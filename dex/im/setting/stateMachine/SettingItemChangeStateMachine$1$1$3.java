package im.setting.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.setting.stateMachine.IMSettingItemAction;
import im.setting.stateMachine.IMSettingItemChangeTask;
import im.setting.stateMachine.IMSettingItemStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/stateMachine/IMSettingItemStatus;", "<unused var>", "Lim/setting/stateMachine/IMSettingItemAction$Confirm;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lim/setting/stateMachine/IMSettingItemStatus$Pending;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingItemChangeStateMachine$1$1$3", f = "SettingItemChangeStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SettingItemChangeStateMachine$1$1$3 extends SuspendLambda implements Function3<IMSettingItemAction.Confirm, State<IMSettingItemStatus.Pending>, Continuation<? super ChangedState<? extends IMSettingItemStatus>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingItemChangeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingItemChangeStateMachine$1$1$3(SettingItemChangeStateMachine settingItemChangeStateMachine, Continuation<? super SettingItemChangeStateMachine$1$1$3> continuation) {
        super(3, continuation);
        this.this$0 = settingItemChangeStateMachine;
    }

    public final Object invoke(IMSettingItemAction.Confirm confirm, State<IMSettingItemStatus.Pending> state, Continuation<? super ChangedState<? extends IMSettingItemStatus>> continuation) {
        SettingItemChangeStateMachine$1$1$3 settingItemChangeStateMachine$1$1$3 = new SettingItemChangeStateMachine$1$1$3(this.this$0, continuation);
        settingItemChangeStateMachine$1$1$3.L$0 = state;
        return settingItemChangeStateMachine$1$1$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMSettingItemChangeTask iMSettingItemChangeTask;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iMSettingItemChangeTask = this.this$0.task;
                if (iMSettingItemChangeTask instanceof IMSettingItemChangeTask.Switch) {
                    return state.override(new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$1$1$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            IMSettingItemStatus.Loading invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = SettingItemChangeStateMachine$1$1$3.invokeSuspend$lambda$0((IMSettingItemStatus.Pending) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                if (!(iMSettingItemChangeTask instanceof IMSettingItemChangeTask.Select)) {
                    throw new NoWhenBranchMatchedException();
                }
                return state.override(new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$1$1$3$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        IMSettingItemStatus.Loading invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = SettingItemChangeStateMachine$1$1$3.invokeSuspend$lambda$1((IMSettingItemStatus.Pending) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingItemStatus.Loading invokeSuspend$lambda$0(IMSettingItemStatus.Pending $this$override) {
        return new IMSettingItemStatus.Loading($this$override.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingItemStatus.Loading invokeSuspend$lambda$1(IMSettingItemStatus.Pending $this$override) {
        return new IMSettingItemStatus.Loading($this$override.getType());
    }
}