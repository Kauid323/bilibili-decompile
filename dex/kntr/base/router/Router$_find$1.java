package kntr.base.router;

import com.bilibili.lib.brouter.api.BRouteCall;
import com.bilibili.lib.brouter.api.BRouteRequest;
import com.bilibili.lib.brouter.api.BRouteResponse;
import com.bilibili.lib.brouter.api.CallParams;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.di.EntryPointKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Router.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/lib/brouter/api/BRouteResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.router.Router$_find$1", f = "Router.kt", i = {0}, l = {55}, m = "invokeSuspend", n = {"call"}, s = {"L$0"}, v = 1)
public final class Router$_find$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BRouteResponse>, Object> {
    final /* synthetic */ BRouteRequest $request;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Router$_find$1(BRouteRequest bRouteRequest, Continuation<? super Router$_find$1> continuation) {
        super(2, continuation);
        this.$request = bRouteRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Router$_find$1(this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BRouteResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object execute;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BRouteCall call = EntryPointKt.getKRouter().newCall(new CallParams() { // from class: kntr.base.router.Router$_find$1$call$1
                    private final boolean findRouteOnly = true;

                    public /* bridge */ boolean getSkipGlobalInterceptor() {
                        return CallParams.DefaultImpls.getSkipGlobalInterceptor(this);
                    }

                    public boolean getFindRouteOnly() {
                        return this.findRouteOnly;
                    }
                }, this.$request);
                this.L$0 = SpillingKt.nullOutSpilledVariable(call);
                this.label = 1;
                execute = call.execute((Continuation) this);
                if (execute != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                BRouteCall bRouteCall = (BRouteCall) this.L$0;
                ResultKt.throwOnFailure($result);
                execute = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BRouteResponse response = (BRouteResponse) execute;
        return response;
    }
}