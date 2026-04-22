package kntr.app.deepsearch.history.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
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
/* compiled from: DSHistoryStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "action", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$SelectItem;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$selectAction$2$1", f = "DSHistoryStateMachine.kt", i = {0, 0}, l = {123}, m = "invokeSuspend", n = {"action", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class DSHistoryStateMachine$selectAction$2$1 extends SuspendLambda implements Function3<DSHistoryAction.SelectItem, State<DSHistoryData>, Continuation<? super ChangedState<? extends DSHistoryData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ DSHistoryStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSHistoryStateMachine$selectAction$2$1(DSHistoryStateMachine dSHistoryStateMachine, Continuation<? super DSHistoryStateMachine$selectAction$2$1> continuation) {
        super(3, continuation);
        this.this$0 = dSHistoryStateMachine;
    }

    public final Object invoke(DSHistoryAction.SelectItem selectItem, State<DSHistoryData> state, Continuation<? super ChangedState<DSHistoryData>> continuation) {
        DSHistoryStateMachine$selectAction$2$1 dSHistoryStateMachine$selectAction$2$1 = new DSHistoryStateMachine$selectAction$2$1(this.this$0, continuation);
        dSHistoryStateMachine$selectAction$2$1.L$0 = selectItem;
        dSHistoryStateMachine$selectAction$2$1.L$1 = state;
        return dSHistoryStateMachine$selectAction$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final DSHistoryAction.SelectItem action = (DSHistoryAction.SelectItem) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = action;
                this.L$1 = state;
                this.label = 1;
                if (this.this$0.dispatch(new DSHistoryAction.HistoryTrackerAction.ItemClick(action.getConversationItem().getTitle()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.mutate(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$selectAction$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                DSHistoryData invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = DSHistoryStateMachine$selectAction$2$1.invokeSuspend$lambda$0(DSHistoryAction.SelectItem.this, (DSHistoryData) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DSHistoryData invokeSuspend$lambda$0(DSHistoryAction.SelectItem $action, DSHistoryData $this$mutate) {
        return (DSHistoryData) $this$mutate.getSelect().invoke($action.getConversationItem());
    }
}