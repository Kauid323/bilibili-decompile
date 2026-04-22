package kntr.app.deepsearch.handler;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifier;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData_androidKt;
import kntr.app.deepsearch.base.model.biz.LinkNodeData;
import kntr.app.deepsearch.base.model.biz.TextLayout;
import kntr.app.deepsearch.service.DeepSearchTextLinkNodeService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DeepSearchBubbleHandler.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a.\u0010\b\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0000¨\u0006\u000e"}, d2 = {"handleBubbleAction", RoomRecommendViewModel.EMPTY_CURSOR, "isShow", RoomRecommendViewModel.EMPTY_CURSOR, "bubbleData", "Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", "dataProcessService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "bindBubbleAction", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "linkNodeService", "Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchBubbleHandlerKt {
    public static final void handleBubbleAction(boolean isShow, LinkNodeData bubbleData, DeepSearchDataProcessService dataProcessService) {
        DeepSearchDataItemIdentifier it;
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        if (bubbleData != null && (it = bubbleData.getIdModel()) != null) {
            TextLayout textLayout = dataProcessService.getCacheLayout(it);
            TextLayout changeColorLayout = DeepSearchPageData_androidKt.bubbleActionForUnderlineChangeColor(isShow, bubbleData, textLayout);
            if (changeColorLayout != null) {
                dataProcessService.updateLayout(it, changeColorLayout);
            }
        }
    }

    public static final void bindBubbleAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock, final DeepSearchDataProcessService dataProcessService, final DeepSearchTextLinkNodeService linkNodeService) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        Intrinsics.checkNotNullParameter(linkNodeService, "linkNodeService");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchBubbleHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindBubbleAction$lambda$0;
                bindBubbleAction$lambda$0 = DeepSearchBubbleHandlerKt.bindBubbleAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindBubbleAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchBubbleHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindBubbleAction$lambda$1;
                bindBubbleAction$lambda$1 = DeepSearchBubbleHandlerKt.bindBubbleAction$lambda$1(DeepSearchTextLinkNodeService.this, dataProcessService, (ConditionBuilderBlock) obj);
                return bindBubbleAction$lambda$1;
            }
        });
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchBubbleHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Flow bindBubbleAction$lambda$2;
                bindBubbleAction$lambda$2 = DeepSearchBubbleHandlerKt.bindBubbleAction$lambda$2(DeepSearchTextLinkNodeService.this, (DeepSearchPageData) obj);
                return bindBubbleAction$lambda$2;
            }
        }, (ExecutionPolicy) null, new DeepSearchBubbleHandlerKt$bindBubbleAction$4(linkNodeService, dataProcessService, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindBubbleAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getBubbleData() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindBubbleAction$lambda$1(DeepSearchTextLinkNodeService $linkNodeService, DeepSearchDataProcessService $dataProcessService, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchBubbleHandlerKt$bindBubbleAction$2$1($linkNodeService, $dataProcessService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.DismissBubble.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow bindBubbleAction$lambda$2(DeepSearchTextLinkNodeService $linkNodeService, DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $linkNodeService.getTapBubbleFlow$biz_debug();
    }
}