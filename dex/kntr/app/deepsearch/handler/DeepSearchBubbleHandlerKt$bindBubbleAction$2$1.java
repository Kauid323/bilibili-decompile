package kntr.app.deepsearch.handler;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.LinkNodeData;
import kntr.app.deepsearch.service.DeepSearchTextLinkNodeService;
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
/* compiled from: DeepSearchBubbleHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "<unused var>", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$DismissBubble;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchBubbleHandlerKt$bindBubbleAction$2$1", f = "DeepSearchBubbleHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchBubbleHandlerKt$bindBubbleAction$2$1 extends SuspendLambda implements Function3<DeepSearchAction.DismissBubble, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchDataProcessService $dataProcessService;
    final /* synthetic */ DeepSearchTextLinkNodeService $linkNodeService;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchBubbleHandlerKt$bindBubbleAction$2$1(DeepSearchTextLinkNodeService deepSearchTextLinkNodeService, DeepSearchDataProcessService deepSearchDataProcessService, Continuation<? super DeepSearchBubbleHandlerKt$bindBubbleAction$2$1> continuation) {
        super(3, continuation);
        this.$linkNodeService = deepSearchTextLinkNodeService;
        this.$dataProcessService = deepSearchDataProcessService;
    }

    public final Object invoke(DeepSearchAction.DismissBubble dismissBubble, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchBubbleHandlerKt$bindBubbleAction$2$1 deepSearchBubbleHandlerKt$bindBubbleAction$2$1 = new DeepSearchBubbleHandlerKt$bindBubbleAction$2$1(this.$linkNodeService, this.$dataProcessService, continuation);
        deepSearchBubbleHandlerKt$bindBubbleAction$2$1.L$0 = state;
        return deepSearchBubbleHandlerKt$bindBubbleAction$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LinkNodeData bubbleData = ((DeepSearchPageData) state.getSnapshot()).getBubbleData();
                if (bubbleData != null) {
                    this.$linkNodeService.configureShowedBubble$biz_debug(false);
                    DeepSearchBubbleHandlerKt.handleBubbleAction(false, bubbleData, this.$dataProcessService);
                    return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchBubbleHandlerKt$bindBubbleAction$2$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            DeepSearchPageData copy$default;
                            copy$default = DeepSearchPageData.copy$default((DeepSearchPageData) obj, null, null, null, null, null, null, null, null, 0.0d, null, null, null, null, null, null, null, null, 114687, null);
                            return copy$default;
                        }
                    });
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}