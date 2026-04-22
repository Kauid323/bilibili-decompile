package tv.danmaku.bili.bilow.domain;

import com.bilibili.lib.okhttp.track.tag.DomainDowngradeTag;
import com.bilibili.lib.rpc.track.model.DomainDowngrade;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestTag;
import okhttp3.Response;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: MultiDomainInterceptor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0003¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/bilow/domain/MultiDomainInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "proceed", "rawHost", "", "rawReq", "Lokhttp3/Request;", "buildRequest", "newHost", "req", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MultiDomainInterceptor implements Interceptor {
    public static final MultiDomainInterceptor INSTANCE = new MultiDomainInterceptor();

    private MultiDomainInterceptor() {
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String host = request.url().host();
        MultiDomain multiDomain = MultiDomain.INSTANCE;
        Intrinsics.checkNotNull(host);
        if (multiDomain.isEnabled(host)) {
            Intrinsics.checkNotNull(request);
            return proceed(chain, host, request);
        }
        Response proceed = chain.proceed(request);
        Intrinsics.checkNotNull(proceed);
        return proceed;
    }

    private final Response proceed(Interceptor.Chain chain, String rawHost, Request rawReq) throws Exception {
        IOException lastException;
        List domains = MultiDomain.INSTANCE.domains(rawHost);
        if (domains == null) {
            domains = CollectionsKt.emptyList();
        }
        Request request = rawReq;
        String it = MultiDomain.INSTANCE.alternative(rawHost);
        if (it != null) {
            request = INSTANCE.buildRequest(it, request);
        }
        String lastHost = null;
        int i = 0;
        do {
            try {
                Response response = chain.proceed(request);
                if (lastHost != null) {
                    MultiDomain multiDomain = MultiDomain.INSTANCE;
                    String host = request.url().host();
                    Intrinsics.checkNotNullExpressionValue(host, "host(...)");
                    multiDomain.setAlternative(rawHost, host);
                }
                Intrinsics.checkNotNull(response);
                if (!RetriableGatewayKt.isRetryableGatewayResponse(response)) {
                    return response;
                }
                throw new RetryableGatewayException();
                break;
            } catch (IOException e) {
                lastException = e;
                if (PolicyKt.isRetryable(e)) {
                    lastHost = request.url().host();
                    if (i < domains.size() - 1) {
                        i++;
                        request = buildRequest(domains.get(i), request);
                        if (i >= domains.size()) {
                            throw lastException;
                        }
                    }
                }
                throw e;
            }
        } while (i >= domains.size());
        throw lastException;
    }

    private final Request buildRequest(String newHost, Request req) {
        DomainDowngradeTag ct = new DomainDowngradeTag(new DomainDowngrade(true));
        HttpUrl newUrl = req.url().newBuilder().host(newHost).build();
        Request newReq = req.newBuilder().url(newUrl).build();
        Object tag = newReq.tag();
        RequestTag it = tag instanceof RequestTag ? (RequestTag) tag : null;
        if (it != null) {
            it.set("domain_downgrade_tag", ct);
        }
        Intrinsics.checkNotNull(newReq);
        return newReq;
    }
}