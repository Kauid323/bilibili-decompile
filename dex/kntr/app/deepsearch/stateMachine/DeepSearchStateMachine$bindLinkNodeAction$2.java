package kntr.app.deepsearch.stateMachine;

import com.bapis.bilibili.app.dynamic.v2.KLinkNode;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifier;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.LinkNodeData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "linkNodeData", "Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindLinkNodeAction$2", f = "DeepSearchStateMachine.kt", i = {0, 0, 0, 0}, l = {240}, m = "invokeSuspend", n = {"linkNodeData", "state", "it", "$i$a$-let-DeepSearchStateMachine$bindLinkNodeAction$2$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class DeepSearchStateMachine$bindLinkNodeAction$2 extends SuspendLambda implements Function3<LinkNodeData, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DeepSearchStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchStateMachine$bindLinkNodeAction$2(DeepSearchStateMachine deepSearchStateMachine, Continuation<? super DeepSearchStateMachine$bindLinkNodeAction$2> continuation) {
        super(3, continuation);
        this.this$0 = deepSearchStateMachine;
    }

    public final Object invoke(LinkNodeData linkNodeData, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchStateMachine$bindLinkNodeAction$2 deepSearchStateMachine$bindLinkNodeAction$2 = new DeepSearchStateMachine$bindLinkNodeAction$2(this.this$0, continuation);
        deepSearchStateMachine$bindLinkNodeAction$2.L$0 = linkNodeData;
        deepSearchStateMachine$bindLinkNodeAction$2.L$1 = state;
        return deepSearchStateMachine$bindLinkNodeAction$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        LinkNodeData linkNodeData = (LinkNodeData) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLinkNode it = linkNodeData.getLinkNode();
                if (it != null) {
                    DeepSearchStateMachine deepSearchStateMachine = this.this$0;
                    DeepSearchDataItemIdentifier idModel = linkNodeData.getIdModel();
                    if (idModel == null || (str = idModel.getQueryId()) == null) {
                        str = RoomRecommendViewModel.EMPTY_CURSOR;
                    }
                    DeepSearchAction.TrackerAction.LinkNodeClick linkNodeClick = new DeepSearchAction.TrackerAction.LinkNodeClick(it, str);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(linkNodeData);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it);
                    this.I$0 = 0;
                    this.label = 1;
                    if (deepSearchStateMachine.dispatch(linkNodeClick, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                int i = this.I$0;
                KLinkNode kLinkNode = (KLinkNode) this.L$2;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.noChange();
    }
}