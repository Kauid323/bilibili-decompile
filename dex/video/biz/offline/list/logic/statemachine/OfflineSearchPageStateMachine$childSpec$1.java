package video.biz.offline.list.logic.statemachine;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* compiled from: OfflineSearchPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Search;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine$childSpec$1", f = "OfflineSearchPageStateMachine.kt", i = {0, 0}, l = {DynModuleType.module_onetime_notice_VALUE}, m = "invokeSuspend", n = {"action", "state"}, s = {"L$0", "L$1"}, v = 1)
final class OfflineSearchPageStateMachine$childSpec$1 extends SuspendLambda implements Function3<OfflineListAction.Search, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OfflineSearchPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineSearchPageStateMachine$childSpec$1(OfflineSearchPageStateMachine offlineSearchPageStateMachine, Continuation<? super OfflineSearchPageStateMachine$childSpec$1> continuation) {
        super(3, continuation);
        this.this$0 = offlineSearchPageStateMachine;
    }

    public final Object invoke(OfflineListAction.Search search, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineSearchPageStateMachine$childSpec$1 offlineSearchPageStateMachine$childSpec$1 = new OfflineSearchPageStateMachine$childSpec$1(this.this$0, continuation);
        offlineSearchPageStateMachine$childSpec$1.L$0 = search;
        offlineSearchPageStateMachine$childSpec$1.L$1 = state;
        return offlineSearchPageStateMachine$childSpec$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OfflineListAction.Search action = (OfflineListAction.Search) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.isBlank(action.getKeyword())) {
                    return state.noChange();
                }
                this.this$0.keyword = action.getKeyword();
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                Object loadData = this.this$0.loadData(state, (Continuation) this);
                if (loadData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return loadData;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}