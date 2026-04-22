package tv.danmaku.bili.bilow.domain;

import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.api.PhoneDeviceId;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.bili.bilow.domain.legacy.RetryStrategy;
import tv.danmaku.bili.bilow.domain.model.DomainList;
import tv.danmaku.bili.report.OnlineParamsHelper;
import tv.danmaku.bili.report.platform.infoeyes.TaskIdConst;

@Deprecated
public class MultiAppDomain implements Interceptor {
    private static final int CDN_ERROR = 3;
    private static final int CDN_SUCCESS = 4;
    private static final int RETRY_ERROR = 5;
    private static final int RETRY_SUCCESS = 6;
    private static final int SESSION = 1;
    private static final int SUCCESS = 2;
    private final ReadWriteLock mLock = new ReentrantReadWriteLock();
    private String mAlternativeHost = null;
    private final List<String> mAppDomains = parseAppDomains();

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        if ("app.bilibili.com".equalsIgnoreCase(url.host()) && isAppMultiDomainEnabled()) {
            return proceed(chain, request, buildUniqueId());
        }
        return chain.proceed(request);
    }

    private Response proceed(Interceptor.Chain chain, Request request, String sessionId) throws IOException {
        boolean isCDNStrategy = OnlineParamsHelper.isCDNStrategy();
        List<String> DOMAIN = getDomainList(isCDNStrategy);
        String alternativeHost = getAlternativeHost();
        if (alternativeHost != null) {
            HttpUrl newUrl = request.url().newBuilder().host(alternativeHost).build();
            request = request.newBuilder().url(newUrl).build();
        }
        report(null, request.url(), sessionId, null, 1);
        String lastHost = null;
        int i = 0;
        do {
            try {
                Response response = chain.proceed(request);
                if (lastHost == null) {
                    report(null, request.url(), sessionId, null, 2);
                } else {
                    report(lastHost, request.url(), sessionId, null, isCDNStrategy ? 4 : 6);
                    setAlternativeHost(request.url().host());
                }
                return response;
            } catch (IOException e) {
                if ((e instanceof ConnectException) || (e instanceof SocketTimeoutException)) {
                    report(lastHost, request.url(), sessionId, getErrorInfo(e), isCDNStrategy ? 3 : 5);
                    lastHost = request.url().host();
                    if (i < DOMAIN.size() - 1) {
                        i++;
                        HttpUrl backupUrl = request.url().newBuilder().host(DOMAIN.get(i)).build();
                        request = request.newBuilder().url(backupUrl).build();
                        if (i >= DOMAIN.size()) {
                            return null;
                        }
                    }
                }
                throw e;
            }
        } while (i >= DOMAIN.size());
        return null;
    }

    private void report(String from, HttpUrl httpUrl, String sessionId, String errorInfo, int resultType) {
        InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_APP_CDN_CHANGE_LOG, new String[]{Uri.encode(httpUrl.toString()), httpUrl.scheme(), httpUrl.host(), Uri.encode(httpUrl.encodedPath()), null, null, null, null, null, null, String.valueOf(resultType), null, null, null, null, null, null, null, null, null, sessionId, errorInfo, from, httpUrl.host()});
    }

    private String buildUniqueId() {
        String timeMill = String.valueOf(System.nanoTime());
        String deviceId = PhoneDeviceId.get();
        String plainText = (TextUtils.isEmpty(deviceId) ? "" : deviceId) + timeMill;
        return DigestUtils.md5(plainText);
    }

    private List<String> getDomainList(boolean isCDNStrategy) {
        if (isCDNStrategy) {
            return this.mAppDomains;
        }
        return new RetryStrategy().domainList();
    }

    private List<String> parseAppDomains() {
        String config = MultiDomainConfig.INSTANCE.getAppMultiDomain();
        if (config == null) {
            config = MultiDomainConfig.APP_MULTI_DOMAIN;
        }
        List<String> result = DomainList.parseDomain(config);
        if (result != null) {
            return result;
        }
        return new ArrayList();
    }

    private String getErrorInfo(IOException e) {
        String errorInfo = e.getClass().getSimpleName() + ":" + e.getMessage();
        return Uri.encode(errorInfo);
    }

    private String getAlternativeHost() {
        this.mLock.readLock().lock();
        try {
            return this.mAlternativeHost;
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    private void setAlternativeHost(String lastHost) {
        if (lastHost.equals(getAlternativeHost())) {
            return;
        }
        this.mLock.writeLock().lock();
        try {
            this.mAlternativeHost = lastHost;
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    private boolean isAppMultiDomainEnabled() {
        return MultiDomainConfig.INSTANCE.getAppMultiDomainEnabled().booleanValue();
    }
}