package kntr.app.deepsearch.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.PageStyle;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "<unused var>", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$RetryIfPossible;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindChatHistoryResetAction$2$1", f = "DeepSearchStateMachine.kt", i = {0, 1, 2}, l = {254, 258, 259}, m = "invokeSuspend", n = {"state", "state", "state"}, s = {"L$0", "L$0", "L$0"}, v = 1)
public final class DeepSearchStateMachine$bindChatHistoryResetAction$2$1 extends SuspendLambda implements Function3<DeepSearchAction.RetryIfPossible, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeepSearchStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchStateMachine$bindChatHistoryResetAction$2$1(DeepSearchStateMachine deepSearchStateMachine, Continuation<? super DeepSearchStateMachine$bindChatHistoryResetAction$2$1> continuation) {
        super(3, continuation);
        this.this$0 = deepSearchStateMachine;
    }

    public final Object invoke(DeepSearchAction.RetryIfPossible retryIfPossible, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchStateMachine$bindChatHistoryResetAction$2$1 deepSearchStateMachine$bindChatHistoryResetAction$2$1 = new DeepSearchStateMachine$bindChatHistoryResetAction$2$1(this.this$0, continuation);
        deepSearchStateMachine$bindChatHistoryResetAction$2$1.L$0 = state;
        return deepSearchStateMachine$bindChatHistoryResetAction$2$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(((DeepSearchPageData) state.getSnapshot()).getPageStyle(), PageStyle.History.INSTANCE) && (((DeepSearchPageData) state.getSnapshot()).getRequestModel().getTextConfigReqState().getStatus() instanceof RequestStatus.Error) && ((DeepSearchPageData) state.getSnapshot()).getList().getList().isEmpty()) {
                    this.L$0 = state;
                    this.label = 1;
                    if (this.this$0.dispatch(DeepSearchAction.TextConfig.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (Intrinsics.areEqual(((DeepSearchPageData) state.getSnapshot()).getPageStyle(), PageStyle.Init.INSTANCE) && (((DeepSearchPageData) state.getSnapshot()).getRequestModel().getSessionReqState().getStatus() instanceof RequestStatus.Error)) {
                    this.L$0 = state;
                    this.label = 2;
                    if (this.this$0.dispatch(DeepSearchAction.TextConfig.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = state;
                    this.label = 3;
                    if (this.this$0.dispatch(DeepSearchAction.CreateSession.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return state.noChange();
            case 1:
                ResultKt.throwOnFailure($result);
                return state.noChange();
            case 2:
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.label = 3;
                if (this.this$0.dispatch(DeepSearchAction.CreateSession.INSTANCE, (Continuation) this) == coroutine_suspended) {
                }
                return state.noChange();
            case 3:
                ResultKt.throwOnFailure($result);
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}