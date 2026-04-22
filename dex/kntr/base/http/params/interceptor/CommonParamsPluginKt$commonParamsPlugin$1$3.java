package kntr.base.http.params.interceptor;

import com.bilibili.ktor.CommonParamsKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GInterceptorEnableInterceptor;
import kntr.base.net.GNetPublicParam;
import kntr.base.net.PHASE;
import kntr.base.net.RealInterceptorChain;
import kntr.base.net.Request;
import kntr.base.net.RequestHook;
import kntr.base.net.Response;
import kntr.base.net.ResponseCallBack;
import kntr.base.net.tags.GInterceptorEnable;
import kntr.base.net.tags.RequestTime;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.datetime.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonParamsPlugin.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.http.params.interceptor.CommonParamsPluginKt$commonParamsPlugin$1$3", f = "CommonParamsPlugin.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {493}, m = "invokeSuspend", n = {"$this$on", "request", "req", "list", "chain", "enable", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
public final class CommonParamsPluginKt$commonParamsPlugin$1$3 extends SuspendLambda implements Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ List<GInterceptor> $interceptor;
    final /* synthetic */ Function0<Set<GNetPublicParam>> $publicParam;
    final /* synthetic */ ClientPluginBuilder<Unit> $this_createClientPlugin;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonParamsPluginKt$commonParamsPlugin$1$3(List<? extends GInterceptor> list, ClientPluginBuilder<Unit> clientPluginBuilder, Function0<? extends Set<? extends GNetPublicParam>> function0, Continuation<? super CommonParamsPluginKt$commonParamsPlugin$1$3> continuation) {
        super(3, continuation);
        this.$interceptor = list;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$publicParam = function0;
    }

    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        CommonParamsPluginKt$commonParamsPlugin$1$3 commonParamsPluginKt$commonParamsPlugin$1$3 = new CommonParamsPluginKt$commonParamsPlugin$1$3(this.$interceptor, this.$this_createClientPlugin, this.$publicParam, continuation);
        commonParamsPluginKt$commonParamsPlugin$1$3.L$0 = sender;
        commonParamsPluginKt$commonParamsPlugin$1$3.L$1 = httpRequestBuilder;
        return commonParamsPluginKt$commonParamsPlugin$1$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final Object invokeSuspend(Object $result) {
        Object result;
        final Send.Sender $this$on = (Send.Sender) this.L$0;
        final HttpRequestBuilder request = (HttpRequestBuilder) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Request req = CommonParamsPluginKt.toRequest$default(request, null, 1, null);
                Boolean bool = (Boolean) request.getAttributes().getOrNull(CommonParamsKt.getGInterceptorKey());
                ?? booleanValue = bool != null ? bool.booleanValue() : 0;
                Iterable $this$map$iv = this.$interceptor;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    GInterceptor it = (GInterceptor) item$iv$iv;
                    destination$iv$iv.add(new GInterceptorEnableInterceptor(it));
                }
                List list = CollectionsKt.toMutableList((List) destination$iv$iv);
                final Function0<Set<GNetPublicParam>> function0 = this.$publicParam;
                PHASE phase = PHASE.INIT;
                final boolean z = booleanValue != 0;
                list.add(0, new RequestHook("init_interceptor", phase, new Function1() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$commonParamsPlugin$1$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Request invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = CommonParamsPluginKt$commonParamsPlugin$1$3.invokeSuspend$lambda$1$0(z, (Request) obj);
                        return invokeSuspend$lambda$1$0;
                    }
                }));
                final boolean z2 = booleanValue != 0;
                list.add(new GInterceptor() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$commonParamsPlugin$1$3$list$2$2
                    @Override // kntr.base.net.GInterceptor
                    public String getName() {
                        return "real_send";
                    }

                    @Override // kntr.base.net.GInterceptor
                    public PHASE getPhase() {
                        return PHASE.SEND;
                    }

                    @Override // kntr.base.net.GInterceptor
                    public void intercept(GInterceptor.Chain chain, ResponseCallBack pre) {
                        Intrinsics.checkNotNullParameter(chain, "chain");
                        Intrinsics.checkNotNullParameter(pre, "pre");
                        chain.getRequest().tag(Reflection.getOrCreateKotlinClass(RequestTime.class), new RequestTime(Clock.System.INSTANCE.now().toEpochMilliseconds()));
                        BuildersKt.launch$default($this$on, (CoroutineContext) null, (CoroutineStart) null, new CommonParamsPluginKt$commonParamsPlugin$1$3$list$2$2$intercept$1(chain, request, function0, z2, pre, $this$on, null), 3, (Object) null);
                    }
                });
                RealInterceptorChain chain = new RealInterceptorChain(list, 0, req);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$on);
                this.L$1 = request;
                this.L$2 = req;
                this.L$3 = SpillingKt.nullOutSpilledVariable(list);
                this.L$4 = chain;
                this.I$0 = booleanValue;
                this.I$1 = 0;
                this.label = 1;
                Continuation uCont$iv = (Continuation) this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuation it2 = cancellableContinuationImpl;
                chain.proceed(req, new ResponseCallBack() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$commonParamsPlugin$1$3$1$1
                    @Override // kntr.base.net.ResponseCallBack
                    public void onResponse(Response response) {
                        Intrinsics.checkNotNullParameter(response, "response");
                        Result.Companion companion = Result.Companion;
                        it2.resumeWith(Result.m2636constructorimpl(response));
                    }

                    @Override // kntr.base.net.ResponseCallBack
                    public void onError(Throwable e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        Result.Companion companion = Result.Companion;
                        it2.resumeWith(Result.m2636constructorimpl(ResultKt.createFailure(e)));
                    }
                });
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                }
                if (result != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                int i = this.I$1;
                int i2 = this.I$0;
                RealInterceptorChain realInterceptorChain = (RealInterceptorChain) this.L$4;
                List list2 = (List) this.L$3;
                Request request2 = (Request) this.L$2;
                ResultKt.throwOnFailure($result);
                result = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return CommonParamsPluginKt.toHttpClientCall((Response) result, this.$this_createClientPlugin.getClient(), request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request invokeSuspend$lambda$1$0(boolean $enable, Request it) {
        it.tag(Reflection.getOrCreateKotlinClass(GInterceptorEnable.class), new GInterceptorEnable($enable));
        return it;
    }
}