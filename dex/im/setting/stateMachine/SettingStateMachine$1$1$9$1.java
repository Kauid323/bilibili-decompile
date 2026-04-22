package im.setting.stateMachine;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.setting.IMSettingDialogConfirmAction;
import im.setting.IMSettingState;
import im.setting.IMSettingStateLensKt;
import im.setting.service.SettingNetworkService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/IMSettingState;", AuthActivity.ACTION_KEY, "Lim/setting/IMSettingDialogConfirmAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingStateMachine$1$1$9$1", f = "SettingStateMachine.kt", i = {0, 0}, l = {185}, m = "invokeSuspend", n = {AuthActivity.ACTION_KEY, "state"}, s = {"L$0", "L$1"}, v = 1)
public final class SettingStateMachine$1$1$9$1 extends SuspendLambda implements Function3<IMSettingDialogConfirmAction, State<IMSettingState>, Continuation<? super ChangedState<? extends IMSettingState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingStateMachine$1$1$9$1(Continuation<? super SettingStateMachine$1$1$9$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMSettingDialogConfirmAction iMSettingDialogConfirmAction, State<IMSettingState> state, Continuation<? super ChangedState<IMSettingState>> continuation) {
        SettingStateMachine$1$1$9$1 settingStateMachine$1$1$9$1 = new SettingStateMachine$1$1$9$1(continuation);
        settingStateMachine$1$1$9$1.L$0 = iMSettingDialogConfirmAction;
        settingStateMachine$1$1$9$1.L$1 = state;
        return settingStateMachine$1$1$9$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        IMSettingDialogConfirmAction action = (IMSettingDialogConfirmAction) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(action.getItem().getType(), KIMSettingType.SETTING_TYPE_CLOSE_FANS_GROUP.INSTANCE)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.label = 1;
                    Object m3411stopGroupIoAF18A$logic_debug = new SettingNetworkService().m3411stopGroupIoAF18A$logic_debug((Continuation) this);
                    if (m3411stopGroupIoAF18A$logic_debug == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = m3411stopGroupIoAF18A$logic_debug;
                    Result.box-impl(obj);
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = ((Result) $result).unbox-impl();
                Result.box-impl(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.mutate(new Function1() { // from class: im.setting.stateMachine.SettingStateMachine$1$1$9$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                IMSettingState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = SettingStateMachine$1$1$9$1.invokeSuspend$lambda$0((IMSettingState) obj2);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingState invokeSuspend$lambda$0(IMSettingState $this$mutate) {
        return (IMSettingState) IMSettingStateLensKt.getDialog(IMSettingState.Companion).set($this$mutate, (Object) null);
    }
}