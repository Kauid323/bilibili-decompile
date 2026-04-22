package kntr.base.net.comm.imp;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.DelegateResponseCallBack;
import kntr.base.net.GInterceptor;
import kntr.base.net.GnetKt;
import kntr.base.net.MutableRequest;
import kntr.base.net.PHASE;
import kntr.base.net.Request;
import kntr.base.net.Response;
import kntr.base.net.ResponseCallBack;
import kntr.base.net.comm.GMultiDomain;
import kntr.base.net.comm.RetryableGatewayException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGMultiDomain.kt */
@Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J8\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"kntr/base/net/comm/imp/InitGMultiDomainKt$provideGMultiDomain$1", "Lkntr/base/net/GInterceptor;", "name", "", "getName", "()Ljava/lang/String;", "phase", "Lkntr/base/net/PHASE;", "getPhase", "()Lkntr/base/net/PHASE;", "intercept", "", "chain", "Lkntr/base/net/GInterceptor$Chain;", "pre", "Lkntr/base/net/ResponseCallBack;", "proceed", "multiDomain", "Lkntr/base/net/comm/GMultiDomain;", "rawHost", "rawReq", "Lkntr/base/net/Request;", "index", "", "multi_domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGMultiDomainKt$provideGMultiDomain$1 implements GInterceptor {
    final /* synthetic */ GMultiDomain $multiDomain;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InitGMultiDomainKt$provideGMultiDomain$1(GMultiDomain $multiDomain) {
        this.$multiDomain = $multiDomain;
    }

    @Override // kntr.base.net.GInterceptor
    public String getName() {
        return "multi_domain";
    }

    @Override // kntr.base.net.GInterceptor
    public PHASE getPhase() {
        return PHASE.MULTI_DOMAIN;
    }

    @Override // kntr.base.net.GInterceptor
    public void intercept(GInterceptor.Chain chain, ResponseCallBack pre) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(pre, "pre");
        Request request = chain.getRequest();
        String host = request.getHost();
        GnetKt.log(chain.getRequest(), "multiDomain", "host " + host);
        if (this.$multiDomain.enabled(host)) {
            proceed(this.$multiDomain, chain, host, request, 0, pre);
        } else {
            chain.proceed(request, new DelegateResponseCallBack(pre, null, null, 6, null));
        }
    }

    private final void proceed(final GMultiDomain multiDomain, final GInterceptor.Chain chain, final String rawHost, Request rawReq, final int index, final ResponseCallBack pre) {
        List domains = multiDomain.domains(rawHost);
        if (domains == null) {
            domains = CollectionsKt.emptyList();
        }
        final List domains2 = domains;
        final MutableRequest newReq = rawReq.copy();
        String it = multiDomain.alternative(rawHost);
        if (it != null) {
            newReq.setHost(it);
        }
        if (!Intrinsics.areEqual(rawHost, newReq.getHost())) {
            GnetKt.log(chain.getRequest(), "multiDomain", "host " + rawHost + "->" + newReq.getHost());
        }
        chain.proceed(newReq, new DelegateResponseCallBack(pre, new Function1() { // from class: kntr.base.net.comm.imp.InitGMultiDomainKt$provideGMultiDomain$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit proceed$lambda$1;
                proceed$lambda$1 = InitGMultiDomainKt$provideGMultiDomain$1.proceed$lambda$1(index, multiDomain, rawHost, newReq, chain, pre, (Response) obj);
                return proceed$lambda$1;
            }
        }, new Function1() { // from class: kntr.base.net.comm.imp.InitGMultiDomainKt$provideGMultiDomain$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit proceed$lambda$2;
                proceed$lambda$2 = InitGMultiDomainKt$provideGMultiDomain$1.proceed$lambda$2(GInterceptor.Chain.this, multiDomain, index, domains2, newReq, this, rawHost, pre, (Throwable) obj);
                return proceed$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit proceed$lambda$1(int $index, GMultiDomain $multiDomain, String $rawHost, MutableRequest $newReq, GInterceptor.Chain $chain, ResponseCallBack $pre, Response it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ($index > 0) {
            $multiDomain.setAlternative($rawHost, $newReq.getHost());
        }
        if ($multiDomain.retriableResponse(it.getHost(), it.getHttpStatus().getValue())) {
            GnetKt.log($chain.getRequest(), "multiDomain", "RetryableGatewayException");
            throw new RetryableGatewayException();
        }
        $pre.onResponse(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit proceed$lambda$2(GInterceptor.Chain $chain, GMultiDomain $multiDomain, int $index, List $domains, MutableRequest $newReq, InitGMultiDomainKt$provideGMultiDomain$1 this$0, String $rawHost, ResponseCallBack $pre, Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Request request = $chain.getRequest();
        String message = it.getMessage();
        if (message == null) {
            message = "";
        }
        GnetKt.log(request, "multiDomain", message);
        if (!$multiDomain.retriable(it)) {
            $pre.onError(it);
        } else if ($index < $domains.size() - 1) {
            $newReq.setHost((String) $domains.get($index + 1));
            this$0.proceed($multiDomain, $chain, $rawHost, $newReq, $index + 1, $pre);
        } else {
            $pre.onError(it);
        }
        return Unit.INSTANCE;
    }
}