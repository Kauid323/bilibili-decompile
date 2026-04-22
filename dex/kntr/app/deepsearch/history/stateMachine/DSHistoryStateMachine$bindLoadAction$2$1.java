package kntr.app.deepsearch.history.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.deepsearch.base.model.history.DSHistoryPageStatus;
import kntr.app.deepsearch.base.model.history.LoadActionType;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "<unused var>", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction$Refresh;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$bindLoadAction$2$1", f = "DSHistoryStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DSHistoryStateMachine$bindLoadAction$2$1 extends SuspendLambda implements Function3<DSHistoryAction.LoadAction.Refresh, State<DSHistoryData>, Continuation<? super ChangedState<? extends DSHistoryData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DSHistoryStateMachine$bindLoadAction$2$1(Continuation<? super DSHistoryStateMachine$bindLoadAction$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DSHistoryAction.LoadAction.Refresh refresh, State<DSHistoryData> state, Continuation<? super ChangedState<DSHistoryData>> continuation) {
        DSHistoryStateMachine$bindLoadAction$2$1 dSHistoryStateMachine$bindLoadAction$2$1 = new DSHistoryStateMachine$bindLoadAction$2$1(continuation);
        dSHistoryStateMachine$bindLoadAction$2$1.L$0 = state;
        return dSHistoryStateMachine$bindLoadAction$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$bindLoadAction$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DSHistoryData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DSHistoryStateMachine$bindLoadAction$2$1.invokeSuspend$lambda$0((DSHistoryData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DSHistoryData invokeSuspend$lambda$0(DSHistoryData $this$mutate) {
        return DSHistoryData.copy$default($this$mutate, null, DSHistoryPageStatus.Loading.INSTANCE, null, null, null, LoadActionType.Refresh, 29, null);
    }
}