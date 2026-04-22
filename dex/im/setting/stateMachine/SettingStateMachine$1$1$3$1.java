package im.setting.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.setting.IMSettingLoadAction;
import im.setting.IMSettingState;
import im.setting.IMSettingStateTypeLoading;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/IMSettingState;", "<unused var>", "Lim/setting/IMSettingLoadAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingStateMachine$1$1$3$1", f = "SettingStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SettingStateMachine$1$1$3$1 extends SuspendLambda implements Function3<IMSettingLoadAction, State<IMSettingState>, Continuation<? super ChangedState<? extends IMSettingState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingStateMachine$1$1$3$1(Continuation<? super SettingStateMachine$1$1$3$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMSettingLoadAction iMSettingLoadAction, State<IMSettingState> state, Continuation<? super ChangedState<IMSettingState>> continuation) {
        SettingStateMachine$1$1$3$1 settingStateMachine$1$1$3$1 = new SettingStateMachine$1$1$3$1(continuation);
        settingStateMachine$1$1$3$1.L$0 = state;
        return settingStateMachine$1$1$3$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$1$1$3$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMSettingState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SettingStateMachine$1$1$3$1.invokeSuspend$lambda$0(state, (IMSettingState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState invokeSuspend$lambda$0(State $state, IMSettingState $this$override) {
        return new IMSettingState(IMSettingStateTypeLoading.INSTANCE, ((IMSettingState) $state.getSnapshot()).getData(), null, null, null, null, 60, null);
    }
}