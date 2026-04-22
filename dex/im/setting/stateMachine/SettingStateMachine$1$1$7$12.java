package im.setting.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.setting.IMSettingState;
import im.setting.evethub.SettingEventHubFlowData;
import im.setting.model.extension.IMSettingPageDataExtKt;
import kntr.base.log.KLog_androidKt;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/IMSettingState;", "flowData", "Lim/setting/evethub/SettingEventHubFlowData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingStateMachine$1$1$7$12", f = "SettingStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SettingStateMachine$1$1$7$12 extends SuspendLambda implements Function3<SettingEventHubFlowData, State<IMSettingState>, Continuation<? super ChangedState<? extends IMSettingState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingStateMachine$1$1$7$12(Continuation<? super SettingStateMachine$1$1$7$12> continuation) {
        super(3, continuation);
    }

    public final Object invoke(SettingEventHubFlowData settingEventHubFlowData, State<IMSettingState> state, Continuation<? super ChangedState<IMSettingState>> continuation) {
        SettingStateMachine$1$1$7$12 settingStateMachine$1$1$7$12 = new SettingStateMachine$1$1$7$12(continuation);
        settingStateMachine$1$1$7$12.L$0 = settingEventHubFlowData;
        settingStateMachine$1$1$7$12.L$1 = state;
        return settingStateMachine$1$1$7$12.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final SettingEventHubFlowData flowData = (SettingEventHubFlowData) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("IMSetting", "Event hub 接收流数据: " + flowData);
                return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$1$1$7$12$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMSettingState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SettingStateMachine$1$1$7$12.invokeSuspend$lambda$0(SettingEventHubFlowData.this, (IMSettingState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState invokeSuspend$lambda$0(SettingEventHubFlowData $flowData, IMSettingState $this$mutate) {
        return IMSettingState.copy$default($this$mutate, null, IMSettingPageDataExtKt.receiveEvent($this$mutate.getData(), $flowData), null, null, null, null, 61, null);
    }
}