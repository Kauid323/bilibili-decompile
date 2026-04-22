package im.setting.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.setting.IMSettingCloseSelectWindowAction;
import im.setting.IMSettingState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/IMSettingState;", "<unused var>", "Lim/setting/IMSettingCloseSelectWindowAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingStateMachine$1$1$7$10", f = "SettingStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SettingStateMachine$1$1$7$10 extends SuspendLambda implements Function3<IMSettingCloseSelectWindowAction, State<IMSettingState>, Continuation<? super ChangedState<? extends IMSettingState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingStateMachine$1$1$7$10(SettingStateMachine settingStateMachine, Continuation<? super SettingStateMachine$1$1$7$10> continuation) {
        super(3, continuation);
        this.this$0 = settingStateMachine;
    }

    public final Object invoke(IMSettingCloseSelectWindowAction iMSettingCloseSelectWindowAction, State<IMSettingState> state, Continuation<? super ChangedState<IMSettingState>> continuation) {
        SettingStateMachine$1$1$7$10 settingStateMachine$1$1$7$10 = new SettingStateMachine$1$1$7$10(this.this$0, continuation);
        settingStateMachine$1$1$7$10.L$0 = state;
        return settingStateMachine$1$1$7$10.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ChangedState onCloseSelectWindowAction;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                onCloseSelectWindowAction = this.this$0.onCloseSelectWindowAction(state);
                return onCloseSelectWindowAction;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}