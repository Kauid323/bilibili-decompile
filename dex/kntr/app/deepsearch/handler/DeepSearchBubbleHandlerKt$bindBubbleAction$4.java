package kntr.app.deepsearch.handler;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "bubbleData", "Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchBubbleHandlerKt$bindBubbleAction$4", f = "DeepSearchBubbleHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchBubbleHandlerKt$bindBubbleAction$4 extends SuspendLambda implements Function3<LinkNodeData, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchDataProcessService $dataProcessService;
    final /* synthetic */ DeepSearchTextLinkNodeService $linkNodeService;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchBubbleHandlerKt$bindBubbleAction$4(DeepSearchTextLinkNodeService deepSearchTextLinkNodeService, DeepSearchDataProcessService deepSearchDataProcessService, Continuation<? super DeepSearchBubbleHandlerKt$bindBubbleAction$4> continuation) {
        super(3, continuation);
        this.$linkNodeService = deepSearchTextLinkNodeService;
        this.$dataProcessService = deepSearchDataProcessService;
    }

    public final Object invoke(LinkNodeData linkNodeData, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchBubbleHandlerKt$bindBubbleAction$4 deepSearchBubbleHandlerKt$bindBubbleAction$4 = new DeepSearchBubbleHandlerKt$bindBubbleAction$4(this.$linkNodeService, this.$dataProcessService, continuation);
        deepSearchBubbleHandlerKt$bindBubbleAction$4.L$0 = linkNodeData;
        deepSearchBubbleHandlerKt$bindBubbleAction$4.L$1 = state;
        return deepSearchBubbleHandlerKt$bindBubbleAction$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final LinkNodeData bubbleData = (LinkNodeData) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$linkNodeService.configureShowedBubble$biz_debug(true);
                DeepSearchBubbleHandlerKt.handleBubbleAction(true, bubbleData, this.$dataProcessService);
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchBubbleHandlerKt$bindBubbleAction$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchBubbleHandlerKt$bindBubbleAction$4.invokeSuspend$lambda$0(LinkNodeData.this, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(LinkNodeData $bubbleData, DeepSearchPageData $this$mutate) {
        DeepSearchPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.sessionQuery : null, (r36 & 4) != 0 ? $this$mutate.sessionTitle : null, (r36 & 8) != 0 ? $this$mutate.historyCursor : null, (r36 & 16) != 0 ? $this$mutate.pageStatus : null, (r36 & 32) != 0 ? $this$mutate.pageStyle : null, (r36 & 64) != 0 ? $this$mutate.requestModel : null, (r36 & 128) != 0 ? $this$mutate.textConfigModel : null, (r36 & 256) != 0 ? $this$mutate.containerWidth : 0.0d, (r36 & 512) != 0 ? $this$mutate.pageChatState : null, (r36 & 1024) != 0 ? $this$mutate.thinkPopContent : null, (r36 & 2048) != 0 ? $this$mutate.deepSearchToast : null, (r36 & 4096) != 0 ? $this$mutate.copyModel : null, (r36 & 8192) != 0 ? $this$mutate.treadPopContent : null, (r36 & 16384) != 0 ? $this$mutate.bubbleData : $bubbleData, (r36 & 32768) != 0 ? $this$mutate.inputState : null, (r36 & 65536) != 0 ? $this$mutate.list : null);
        return copy;
    }
}