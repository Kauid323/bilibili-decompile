package kntr.base.http.params.interceptor;

import com.bilibili.ktor.CommonParamsKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GNetPublicParam;
import kntr.base.net.ResponseCallBack;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CommonParamsPlugin.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.http.params.interceptor.CommonParamsPluginKt$commonParamsPlugin$1$3$list$2$2$intercept$1", f = "CommonParamsPlugin.kt", i = {0, 0}, l = {256}, m = "invokeSuspend", n = {"toHttpRequestBuilder", "enableGPublicParamKey"}, s = {"L$0", "I$0"}, v = 1)
final class CommonParamsPluginKt$commonParamsPlugin$1$3$list$2$2$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Send.Sender $$this$on;
    final /* synthetic */ GInterceptor.Chain $chain;
    final /* synthetic */ boolean $enable;
    final /* synthetic */ ResponseCallBack $pre;
    final /* synthetic */ Function0<Set<GNetPublicParam>> $publicParam;
    final /* synthetic */ HttpRequestBuilder $request;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonParamsPluginKt$commonParamsPlugin$1$3$list$2$2$intercept$1(GInterceptor.Chain chain, HttpRequestBuilder httpRequestBuilder, Function0<? extends Set<? extends GNetPublicParam>> function0, boolean z, ResponseCallBack responseCallBack, Send.Sender sender, Continuation<? super CommonParamsPluginKt$commonParamsPlugin$1$3$list$2$2$intercept$1> continuation) {
        super(2, continuation);
        this.$chain = chain;
        this.$request = httpRequestBuilder;
        this.$publicParam = function0;
        this.$enable = z;
        this.$pre = responseCallBack;
        this.$$this$on = sender;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonParamsPluginKt$commonParamsPlugin$1$3$list$2$2$intercept$1(this.$chain, this.$request, this.$publicParam, this.$enable, this.$pre, this.$$this$on, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final Object invokeSuspend(Object $result) {
        Object proceed;
        ResponseCallBack responseCallBack;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    HttpRequestBuilder toHttpRequestBuilder = CommonParamsPluginKt.toHttpRequestBuilder(this.$chain.getRequest());
                    Boolean bool = (Boolean) this.$request.getAttributes().getOrNull(CommonParamsKt.getGPublicParamKey());
                    ?? booleanValue = bool != null ? bool.booleanValue() : 0;
                    if (booleanValue != 0) {
                        new NetPublicParamProcess().process(toHttpRequestBuilder, (Set) this.$publicParam.invoke());
                    }
                    toHttpRequestBuilder.getAttributes().put(CommonParamsKt.getGInterceptorKey(), Boxing.boxBoolean(this.$enable));
                    ResponseCallBack responseCallBack2 = this.$pre;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(toHttpRequestBuilder);
                    this.L$1 = responseCallBack2;
                    this.I$0 = booleanValue;
                    this.label = 1;
                    proceed = this.$$this$on.proceed(toHttpRequestBuilder, (Continuation) this);
                    if (proceed != coroutine_suspended) {
                        responseCallBack = responseCallBack2;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    responseCallBack = (ResponseCallBack) this.L$1;
                    HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
                    ResultKt.throwOnFailure($result);
                    proceed = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            responseCallBack.onResponse(CommonParamsPluginKt.toResponse((HttpClientCall) proceed, this.$chain.getRequest()));
        } catch (Throwable e) {
            this.$pre.onError(e);
        }
        return Unit.INSTANCE;
    }
}