package im.setting.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.setting.stateMachine.IMSettingItemStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/stateMachine/IMSettingItemStatus;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lim/setting/stateMachine/IMSettingItemStatus$Loading;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingItemChangeStateMachine$1$2$1", f = "SettingItemChangeStateMachine.kt", i = {0}, l = {131}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class SettingItemChangeStateMachine$1$2$1 extends SuspendLambda implements Function2<State<IMSettingItemStatus.Loading>, Continuation<? super ChangedState<? extends IMSettingItemStatus>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingItemChangeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingItemChangeStateMachine$1$2$1(SettingItemChangeStateMachine settingItemChangeStateMachine, Continuation<? super SettingItemChangeStateMachine$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = settingItemChangeStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> settingItemChangeStateMachine$1$2$1 = new SettingItemChangeStateMachine$1$2$1(this.this$0, continuation);
        settingItemChangeStateMachine$1$2$1.L$0 = obj;
        return settingItemChangeStateMachine$1$2$1;
    }

    public final Object invoke(State<IMSettingItemStatus.Loading> state, Continuation<? super ChangedState<? extends IMSettingItemStatus>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object request;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                request = this.this$0.request(state, (Continuation) this);
                if (request == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return request;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}