package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchContent;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContent;
import kntr.app.deepsearch.base.model.biz.PageStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchThinkPopHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0007*\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bH\u0000¨\u0006\n"}, d2 = {"thinkPopContent", "Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "pageData", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "bindThinkPopAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchThinkPopHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchThinkPopContent thinkPopContent(String queryId, DeepSearchPageData pageData) {
        KDeepSearchContent deepContent;
        Iterable $this$forEach$iv = CollectionsKt.reversed(pageData.getList().getList());
        for (Object element$iv : $this$forEach$iv) {
            KChatHistoryItem it = (KChatHistoryItem) element$iv;
            KDeepSearchResponse response = it.getContent();
            if (response != null && Intrinsics.areEqual(response.getQueryId(), queryId)) {
                KDeepSearchResponse content = it.getContent();
                KDeepSearchContent.KAnswer contentItem = (content == null || (deepContent = content.getDeepContent()) == null) ? null : deepContent.getContentItem();
                if (!(contentItem instanceof KDeepSearchContent.KAnswer)) {
                    return null;
                }
                KThinking think = contentItem.getValue().getThinking();
                if (think != null) {
                    return new DeepSearchThinkPopContent(pageData.getSessionId(), queryId, think.getStatus(), think.getWindowText(), think.getThinkingContent(), response.getTimestamp());
                }
            }
        }
        return null;
    }

    public static final void bindThinkPopAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchThinkPopHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindThinkPopAction$lambda$0;
                bindThinkPopAction$lambda$0 = DeepSearchThinkPopHandlerKt.bindThinkPopAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindThinkPopAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchThinkPopHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindThinkPopAction$lambda$1;
                bindThinkPopAction$lambda$1 = DeepSearchThinkPopHandlerKt.bindThinkPopAction$lambda$1((ConditionBuilderBlock) obj);
                return bindThinkPopAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindThinkPopAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPageStatus() instanceof PageStatus.InitSuccess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindThinkPopAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.ThinkPopViewAction.ThinkPopViewShow.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.ThinkPopViewAction.ThinkPopViewHidden.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }
}