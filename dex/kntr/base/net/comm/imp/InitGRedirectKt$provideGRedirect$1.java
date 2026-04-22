package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.DelegateResponseCallBack;
import kntr.base.net.GInterceptor;
import kntr.base.net.GnetKt;
import kntr.base.net.MutableRequest;
import kntr.base.net.PHASE;
import kntr.base.net.Request;
import kntr.base.net.Response;
import kntr.base.net.ResponseCallBack;
import kntr.base.net.comm.GRedirect;
import kntr.base.net.comm.GRedirectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGRedirect.kt */
@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J(\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"kntr/base/net/comm/imp/InitGRedirectKt$provideGRedirect$1", "Lkntr/base/net/GInterceptor;", "name", "", "getName", "()Ljava/lang/String;", "phase", "Lkntr/base/net/PHASE;", "getPhase", "()Lkntr/base/net/PHASE;", "intercept", "", "chain", "Lkntr/base/net/GInterceptor$Chain;", "pre", "Lkntr/base/net/ResponseCallBack;", "proceedRedirecResponse", "redirect", "Lkntr/base/net/comm/GRedirect;", "proceed", "rule", "Lkntr/base/net/comm/GRedirect$Redirect;", "redirect_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGRedirectKt$provideGRedirect$1 implements GInterceptor {
    final /* synthetic */ GRedirect $redirect;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InitGRedirectKt$provideGRedirect$1(GRedirect $redirect) {
        this.$redirect = $redirect;
    }

    @Override // kntr.base.net.GInterceptor
    public String getName() {
        return "redirect_url";
    }

    @Override // kntr.base.net.GInterceptor
    public PHASE getPhase() {
        return PHASE.REDIRECT;
    }

    @Override // kntr.base.net.GInterceptor
    public void intercept(GInterceptor.Chain chain, ResponseCallBack pre) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(pre, "pre");
        if (this.$redirect.getEnable()) {
            Request request = chain.getRequest();
            String host = request.getHost();
            String path = request.getPath();
            GRedirect.Redirect rule = this.$redirect.redirect(host, path);
            if (rule != null) {
                proceed(this.$redirect, rule, chain, pre);
                return;
            } else {
                proceedRedirecResponse(this.$redirect, chain, pre);
                return;
            }
        }
        proceedRedirecResponse(this.$redirect, chain, pre);
    }

    private final void proceedRedirecResponse(final GRedirect redirect, final GInterceptor.Chain chain, final ResponseCallBack pre) {
        final MutableRequest request = chain.getRequest().copy();
        if (redirect.getEnable()) {
            request.header(GRedirectKt.KEY_BILI_REDIRECT, "1");
        }
        final String oHost = request.getHost();
        final String oPath = request.getPath();
        chain.proceed(request, new DelegateResponseCallBack(pre, new Function1() { // from class: kntr.base.net.comm.imp.InitGRedirectKt$provideGRedirect$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit proceedRedirecResponse$lambda$0;
                proceedRedirecResponse$lambda$0 = InitGRedirectKt$provideGRedirect$1.proceedRedirecResponse$lambda$0(ResponseCallBack.this, redirect, oHost, oPath, request, chain, (Response) obj);
                return proceedRedirecResponse$lambda$0;
            }
        }, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit proceedRedirecResponse$lambda$0(ResponseCallBack $pre, GRedirect $redirect, String $oHost, String $oPath, MutableRequest $request, GInterceptor.Chain $chain, Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (Intrinsics.areEqual(response.header(GRedirectKt.KEY_BILI_REDIRECT_CODE), GRedirectKt.REDIRECT_CODE)) {
            String it = response.header(GRedirectKt.KEY_BILI_REDIRECT_URL);
            if (it != null) {
                GRedirect.Redirect redirectRule = GRedirect.Redirect.Companion.create(it);
                $redirect.setRedirect($oHost, $oPath, redirectRule);
                MutableRequest newReq = $request.copy();
                newReq.setHost(redirectRule.getHost());
                newReq.setPath(redirectRule.getPath());
                String header = response.header(GRedirectKt.KEY_BILI_METADATA_IDC_REGION);
                if (header == null) {
                    header = "";
                }
                newReq.header(GRedirectKt.KEY_BILI_METADATA_IDC_REGION, header);
                $chain.proceed(newReq, $pre);
            }
        } else {
            $pre.onResponse(response);
        }
        return Unit.INSTANCE;
    }

    private final void proceed(GRedirect redirect, GRedirect.Redirect rule, GInterceptor.Chain chain, ResponseCallBack pre) {
        MutableRequest newReq = chain.getRequest().copy();
        String oHost = newReq.getHost();
        newReq.getPath();
        if (redirect.getEnable()) {
            newReq.header(GRedirectKt.KEY_BILI_REDIRECT, "1");
        }
        newReq.setHost(rule.getHost());
        newReq.setPath(rule.getPath());
        if (!Intrinsics.areEqual(oHost, newReq.getHost())) {
            GnetKt.log(chain.getRequest(), "GRedirect", "host " + oHost + "->" + newReq.getHost());
        }
        chain.proceed(newReq, new DelegateResponseCallBack(pre, null, null, 6, null));
    }
}