package im.setting.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.setting.IMSettingState;
import im.setting.service.SettingRequestService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/IMSettingState;", "it", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingStateMachine$1$1$5$1", f = "SettingStateMachine.kt", i = {0, 1}, l = {92, 91}, m = "invokeSuspend", n = {"it", "it"}, s = {"L$0", "L$0"}, v = 1)
public final class SettingStateMachine$1$1$5$1 extends SuspendLambda implements Function2<State<IMSettingState>, Continuation<? super ChangedState<? extends IMSettingState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SettingStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingStateMachine$1$1$5$1(SettingStateMachine settingStateMachine, Continuation<? super SettingStateMachine$1$1$5$1> continuation) {
        super(2, continuation);
        this.this$0 = settingStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> settingStateMachine$1$1$5$1 = new SettingStateMachine$1$1$5$1(this.this$0, continuation);
        settingStateMachine$1$1$5$1.L$0 = obj;
        return settingStateMachine$1$1$5$1;
    }

    public final Object invoke(State<IMSettingState> state, Continuation<? super ChangedState<IMSettingState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SettingStateMachine settingStateMachine;
        SettingRequestService settingRequestService;
        Object mo3406loadIoAF18A;
        State state;
        Object receive;
        State it = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                settingStateMachine = this.this$0;
                settingRequestService = this.this$0.requestService;
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.L$1 = settingStateMachine;
                this.L$2 = it;
                this.label = 1;
                mo3406loadIoAF18A = settingRequestService.mo3406loadIoAF18A((Continuation) this);
                if (mo3406loadIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                state = it;
                break;
            case 1:
                state = (State) this.L$2;
                settingStateMachine = (SettingStateMachine) this.L$1;
                ResultKt.throwOnFailure($result);
                mo3406loadIoAF18A = ((Result) $result).unbox-impl();
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        receive = settingStateMachine.receive(state, mo3406loadIoAF18A, (Continuation) this);
        if (receive == coroutine_suspended) {
            return coroutine_suspended;
        }
        return receive;
    }
}