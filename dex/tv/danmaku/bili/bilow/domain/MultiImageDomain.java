package tv.danmaku.bili.bilow.domain;

import com.bilibili.lib.blconfig.ConfigManager;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.bilow.domain.model.DomainList;
import tv.danmaku.bili.bilow.ignet.util.IgExceptionKt;
import tv.danmaku.bili.utils.ImageUriUtilWrapper;

@Deprecated
public class MultiImageDomain implements Interceptor {
    private static final String DEFAULT_IMG_HOST = "i0.hdslb.com";
    private static MultiImageDomain INSTANCE = new MultiImageDomain();
    private static final String TAG = "MultiImageDomain";
    private final List<String> mImageDomains = parseImageDomains();

    public static MultiImageDomain getInstance() {
        return INSTANCE;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        if (isBfsImageUrl(url) && isMultiImageDomainEnabled()) {
            return proceed(chain, request);
        }
        return chain.proceed(request);
    }

    private Response proceed(Interceptor.Chain chain, Request request) throws IOException {
        List<String> DOMAIN = this.mImageDomains;
        int i = -1;
        do {
            try {
                return chain.proceed(request);
            } catch (IOException e) {
                if (((e instanceof ConnectException) || (e instanceof SocketTimeoutException) || IgExceptionKt.ignetShouldTryDomainDowngrade(e)) && (i = i + 1) < DOMAIN.size()) {
                    String host = DOMAIN.get(i);
                    HttpUrl backupUrl = request.url().newBuilder().host(host).build();
                    request = request.newBuilder().url(backupUrl).build();
                    BLog.w(TAG, "switch host: " + host);
                    if (i >= DOMAIN.size()) {
                        return null;
                    }
                } else {
                    throw e;
                }
            }
        } while (i >= DOMAIN.size());
        return null;
    }

    private boolean isMultiImageDomainEnabled() {
        return MultiDomainConfig.INSTANCE.getImageMultiDomainEnabled().booleanValue();
    }

    private List<String> parseImageDomains() {
        String config = MultiDomainConfig.INSTANCE.getImageMultiDomain();
        if (config == null) {
            config = MultiDomainConfig.IMAGE_MULTI_DOMAIN;
        }
        List<String> result = DomainList.parseDomain(config);
        if (result != null) {
            return result;
        }
        return new ArrayList();
    }

    private boolean isBfsImageUrl(HttpUrl url) {
        if (ConfigManager.ab().get("switch_image_multi_domain_new_rule", true) == Boolean.TRUE) {
            return ImageUriUtilWrapper.isBfsImageUrl(url.toString());
        }
        return DEFAULT_IMG_HOST.equalsIgnoreCase(url.host());
    }
}