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
/* compiled from: PhoneOnePassLoginState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;", "<unused var>", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$DismissEulaAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine$1$1$6", f = "PhoneOnePassLoginState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PhoneOnePassStateMachine$1$1$6 extends SuspendLambda implements Function3<IFullscreenLoginAction.DismissEulaAction, State<PhoneOnePassLoginState>, Continuation<? super ChangedState<? extends IPhoneOnePassState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneOnePassStateMachine$1$1$6(Continuation<? super PhoneOnePassStateMachine$1$1$6> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IFullscreenLoginAction.DismissEulaAction dismissEulaAction, State<PhoneOnePassLoginState> state, Continuation<? super ChangedState<? extends IPhoneOnePassState>> continuation) {
        PhoneOnePassStateMachine$1$1$6 phoneOnePassStateMachine$1$1$6 = new PhoneOnePassStateMachine$1$1$6(continuation);
        phoneOnePassStateMachine$1$1$6.L$0 = state;
        return phoneOnePassStateMachine$1$1$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                State state = (State) this.L$0;
                return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine$1$1$6$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        PhoneOnePassLoginState copy$default;
                        copy$default = PhoneOnePassLoginState.copy$default((PhoneOnePassLoginState) obj2, null, false, null, false, null, null, null, 63, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}