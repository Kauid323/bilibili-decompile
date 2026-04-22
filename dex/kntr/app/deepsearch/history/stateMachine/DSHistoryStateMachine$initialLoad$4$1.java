package kntr.app.deepsearch.history.stateMachine;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryListReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.deepsearch.base.model.history.LoadActionType;
import kntr.app.deepsearch.history.log.LogTagKt;
import kntr.app.deepsearch.history.service.DSHistoryLoadService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
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
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DSHistoryStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$initialLoad$4$1", f = "DSHistoryStateMachine.kt", i = {0, 0}, l = {66}, m = "invokeSuspend", n = {"state", "cursor"}, s = {"L$0", "L$1"}, v = 1)
public final class DSHistoryStateMachine$initialLoad$4$1 extends SuspendLambda implements Function2<State<DSHistoryData>, Continuation<? super ChangedState<? extends DSHistoryData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DSHistoryStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSHistoryStateMachine$initialLoad$4$1(DSHistoryStateMachine dSHistoryStateMachine, Continuation<? super DSHistoryStateMachine$initialLoad$4$1> continuation) {
        super(2, continuation);
        this.this$0 = dSHistoryStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> dSHistoryStateMachine$initialLoad$4$1 = new DSHistoryStateMachine$initialLoad$4$1(this.this$0, continuation);
        dSHistoryStateMachine$initialLoad$4$1.L$0 = obj;
        return dSHistoryStateMachine$initialLoad$4$1;
    }

    public final Object invoke(State<DSHistoryData> state, Continuation<? super ChangedState<DSHistoryData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        DSHistoryLoadService dSHistoryLoadService;
        final Object result;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DSHistoryData it = (DSHistoryData) state.getSnapshot();
                if (it.getLoadActionType() == LoadActionType.More) {
                    str = it.getCursor();
                } else {
                    str = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                String cursor = str;
                dSHistoryLoadService = this.this$0.loadService;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(cursor);
                this.label = 1;
                Object m641loadgIAlus$history_debug = dSHistoryLoadService.m641loadgIAlus$history_debug(cursor, (Continuation) this);
                if (m641loadgIAlus$history_debug != coroutine_suspended) {
                    result = m641loadgIAlus$history_debug;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                String str2 = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                result = ((Result) $result).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object result2 = result;
        if (Result.isSuccess-impl(result2)) {
            KChatHistoryListReply reply = (KChatHistoryListReply) result2;
            KLog_androidKt.getKLog().i(LogTagKt.DS_HISTORY_LOG_TAG, "请求列表成功，列表长度 " + reply.getItems().size());
        }
        Throwable throwable = Result.exceptionOrNull-impl(result2);
        if (throwable != null) {
            KLog_androidKt.getKLog().e(LogTagKt.DS_HISTORY_LOG_TAG, "列表请求失败", throwable);
        }
        return state.mutate(new Function1() { // from class: kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine$initialLoad$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                DSHistoryData invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = DSHistoryStateMachine$initialLoad$4$1.invokeSuspend$lambda$2(result, (DSHistoryData) obj);
                return invokeSuspend$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DSHistoryData invokeSuspend$lambda$2(Object $result, DSHistoryData $this$mutate) {
        return $this$mutate.receive($result);
    }
}