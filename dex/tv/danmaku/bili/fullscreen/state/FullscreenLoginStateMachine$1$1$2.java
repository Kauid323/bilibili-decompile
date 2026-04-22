package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
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
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$OnPhoneGetAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPhoneIdlePage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$1$2", f = "IFullscreenLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginStateMachine$1$1$2 extends SuspendLambda implements Function3<IFullscreenLoginAction.OnPhoneGetAction, State<FullscreenLoginPhoneIdlePage>, Continuation<? super ChangedState<? extends IFullscreenLoginState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullscreenLoginStateMachine$1$1$2(Continuation<? super FullscreenLoginStateMachine$1$1$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IFullscreenLoginAction.OnPhoneGetAction onPhoneGetAction, State<FullscreenLoginPhoneIdlePage> state, Continuation<? super ChangedState<? extends IFullscreenLoginState>> continuation) {
        FullscreenLoginStateMachine$1$1$2 fullscreenLoginStateMachine$1$1$2 = new FullscreenLoginStateMachine$1$1$2(continuation);
        fullscreenLoginStateMachine$1$1$2.L$0 = onPhoneGetAction;
        fullscreenLoginStateMachine$1$1$2.L$1 = state;
        return fullscreenLoginStateMachine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final IFullscreenLoginAction.OnPhoneGetAction action = (IFullscreenLoginAction.OnPhoneGetAction) this.L$0;
                State state = (State) this.L$1;
                return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$1$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        FullscreenLoginPhonePage invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = FullscreenLoginStateMachine$1$1$2.invokeSuspend$lambda$0(IFullscreenLoginAction.OnPhoneGetAction.this, (FullscreenLoginPhoneIdlePage) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FullscreenLoginPhonePage invokeSuspend$lambda$0(IFullscreenLoginAction.OnPhoneGetAction $action, FullscreenLoginPhoneIdlePage $this$override) {
        return new FullscreenLoginPhonePage(new PhoneOnePassLoginState($action.getPhone(), false, null, false, null, null, null, BR.countdownTotal, null));
    }
}