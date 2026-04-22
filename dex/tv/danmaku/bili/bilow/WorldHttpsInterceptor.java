package tv.danmaku.bili.bilow;

import java.io.IOException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.report.OnlineParamsHelper;

public class WorldHttpsInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        if (OnlineParamsHelper.isHttpsEnabled() && AppConfig.SCHEME_HTTP.equalsIgnoreCase(url.scheme()) && isInWhiteList(url)) {
            Request httpsRequest = request.newBuilder().url(url.newBuilder().scheme(AppConfig.SCHEME_HTTPS).build()).build();
            try {
                return chainProceed(chain, httpsRequest);
            } catch (IOException e) {
                if (shouldFallback(e)) {
                    return chain.proceed(request);
                }
                throw e;
            }
        }
        return chainProceed(chain, request);
    }

    private Response chainProceed(Interceptor.Chain chain, Request request) throws IOException {
        try {
            return chain.proceed(request);
        } catch (NullPointerException e) {
            if ("ssl_session == null".equalsIgnoreCase(e.getMessage())) {
                throw new IOException(e.getMessage());
            }
            throw e;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean isInWhiteList(HttpUrl url) {
        char c;
        String host = url.host();
        if (host.endsWith(".hdslb.com")) {
            return true;
        }
        String host2 = url.host();
        switch (host2.hashCode()) {
            case -1937917112:
                if (host2.equals("app.bilibili.com")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1737161012:
                if (host2.equals("vip.bilibili.com")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1318282294:
                if (host2.equals("comment.bilibili.com")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1139405724:
                if (host2.equals("elec.bilibili.com")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -899643823:
                if (host2.equals("www.im9.com")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -859113617:
                if (host2.equals("member.bilibili.com")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -542416765:
                if (host2.equals("space.bilibili.com")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -46695646:
                if (host2.equals("message.bilibili.com")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1600993263:
                if (host2.equals("api.bilibili.com")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
                return true;
            default:
                return false;
        }
    }

    private boolean shouldFallback(Throwable e) {
        Throwable thr = getRootCause(e);
        return (thr instanceof CertificateExpiredException) || (thr instanceof CertificateNotYetValidException);
    }

    private Throwable getRootCause(Throwable e) {
        Throwable cause = e.getCause();
        return cause == null ? e : getRootCause(cause);
    }

    private boolean isUnicomFreeData(HttpUrl url) {
        String host = url.host();
        if ("sms.wo186.tv".equals(host) || "dir.v.wo.cn".equals(host) || "dir1.v.wo.cn".equals(host)) {
            return true;
        }
        return false;
    }
}