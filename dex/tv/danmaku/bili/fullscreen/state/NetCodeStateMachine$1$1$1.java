package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.state.AuthorizeFailed;
import tv.danmaku.bili.fullscreen.state.NetCodeAction;
import tv.danmaku.bili.wauth.WAuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "action", "Ltv/danmaku/bili/fullscreen/state/NetCodeAction$AuthorizeResult;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/Authorizing;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$1$1", f = "NetCodeState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NetCodeStateMachine$1$1$1 extends SuspendLambda implements Function3<NetCodeAction.AuthorizeResult, State<Authorizing>, Continuation<? super ChangedState<? extends NetCodeState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetCodeStateMachine$1$1$1(Continuation<? super NetCodeStateMachine$1$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(NetCodeAction.AuthorizeResult authorizeResult, State<Authorizing> state, Continuation<? super ChangedState<? extends NetCodeState>> continuation) {
        NetCodeStateMachine$1$1$1 netCodeStateMachine$1$1$1 = new NetCodeStateMachine$1$1$1(continuation);
        netCodeStateMachine$1$1$1.L$0 = authorizeResult;
        netCodeStateMachine$1$1$1.L$1 = state;
        return netCodeStateMachine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final NetCodeAction.AuthorizeResult action = (NetCodeAction.AuthorizeResult) this.L$0;
                State state = (State) this.L$1;
                Object m1114getResultd1pmJ48 = action.m1114getResultd1pmJ48();
                if (Result.isFailure-impl(m1114getResultd1pmJ48)) {
                    m1114getResultd1pmJ48 = null;
                }
                final WAuthResult result = (WAuthResult) m1114getResultd1pmJ48;
                return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        NetCodeState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = NetCodeStateMachine$1$1$1.invokeSuspend$lambda$0(NetCodeAction.AuthorizeResult.this, result, (Authorizing) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetCodeState invokeSuspend$lambda$0(NetCodeAction.AuthorizeResult $action, WAuthResult $result, Authorizing $this$override) {
        if (Result.isFailure-impl($action.m1114getResultd1pmJ48())) {
            return new AuthorizeFailed.OtherFailure(null, null, Result.exceptionOrNull-impl($action.m1114getResultd1pmJ48()), null, 11, null);
        }
        boolean z = false;
        if ($result != null && $result.getSuccess()) {
            return new LoginRequesting($result.getBizSeq(), $result.getCertPwdData(), $result.getIdCardAuthData());
        }
        if ($result != null && $result.isUninstall()) {
            return new AuthorizeFailed.AppRequested(null, 1, null);
        }
        if ($result != null && $result.isCancel()) {
            z = true;
        }
        if (z) {
            return new AuthorizeFailed.Cancelled(null, 1, null);
        }
        return new AuthorizeFailed.OtherFailure($result != null ? $result.getErrorCode() : null, $result != null ? $result.getMessage() : null, null, null, 12, null);
    }
}