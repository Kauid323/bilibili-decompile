package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.dynamic.v2.KBgStyle;
import com.bapis.bilibili.app.dynamic.v2.KColors;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.dynamic.v2.KTextParagraph;
import com.bapis.bilibili.app.dynamic.v2.KWordNode;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswer;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerParagraph;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerText;
import com.bapis.bilibili.broadcast.message.deepsearch.KCardItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KChatStatus;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchContent;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bapis.bilibili.broadcast.message.deepsearch.KGreetings;
import com.bapis.bilibili.broadcast.message.deepsearch.KTextCard;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: DeepSearchChatErrorHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a \u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\b\u0010\n\u001a\u00020\u0002H\u0000¨\u0006\u000b"}, d2 = {"handleChatError", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "pageData", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "query", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "createChatError", "sessionId", "createGreetError", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchChatErrorHandlerKt {
    public static final List<KChatHistoryItem> handleChatError(DeepSearchPageData pageData, String query, String queryId) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        List tempList = CollectionsKt.toMutableList(pageData.getList().getList());
        KChatHistoryItem tempItem = null;
        for (KChatHistoryItem item : CollectionsKt.reversed(tempList)) {
            if (!Intrinsics.areEqual(query, item.getQuery())) {
                KDeepSearchResponse content = item.getContent();
                if (Intrinsics.areEqual(queryId, content != null ? content.getQueryId() : null)) {
                }
            }
            tempItem = item;
        }
        if (tempItem != null) {
            tempList.remove(tempItem);
        }
        KChatHistoryItem chatModel = createChatError(pageData.getSessionId(), query, queryId);
        tempList.add(chatModel);
        return tempList;
    }

    public static final KChatHistoryItem createChatError(String sessionId, String query, String queryId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        KColors colors = new KColors("#18191C", "#E7E9EB");
        KWordNode wordNode = new KWordNode("遇到问题了，请重试。", 16.0d, colors, (KWordNode.KWordNodeStyle) null, (KWordNode.KUnderlineStyle) null, "regular", 0, (KBgStyle) null, 216, (DefaultConstructorMarker) null);
        KTextNode nodeText = new KTextNode(KTextNode.KTextNodeType.WORDS.INSTANCE, "遇到问题了，请重试。", new KTextNode.KWord(wordNode));
        KParagraph paragraph = new KParagraph(KParagraph.KParagraphType.TEXT.INSTANCE, (KParagraph.KParagraphFormat) null, new KParagraph.KText(new KTextParagraph(CollectionsKt.listOf(nodeText))), 2, (DefaultConstructorMarker) null);
        KParaSpacing paraSpace = new KParaSpacing(12.0d, 0.0d, 0.0d, 6, (DefaultConstructorMarker) null);
        KCardItem cardItem = new KCardItem(KCardItem.KCardType.TEXT.INSTANCE, new KCardItem.KText(new KTextCard(new KModuleParagraph(paragraph, false, paraSpace, 2, (DefaultConstructorMarker) null))));
        KAnswerText answerText = new KAnswerText(CollectionsKt.listOf(new KAnswerParagraph(false, CollectionsKt.listOf(cardItem), 1, (DefaultConstructorMarker) null)));
        KThinking thinkContent = new KThinking(KThinking.KStatus.INVALID.INSTANCE, (String) null, (String) null, (String) null, 14, (DefaultConstructorMarker) null);
        KAnswer answerItem = new KAnswer(thinkContent, answerText);
        KDeepSearchContent deepContent = new KDeepSearchContent(new KDeepSearchContent.KAnswer(answerItem));
        KDeepSearchResponse deepSearchResponse = new KDeepSearchResponse(0, sessionId, queryId, KChatStatus.FINISH.INSTANCE, deepContent, (String) null, 0L, 96, (DefaultConstructorMarker) null);
        KChatHistoryItem chatModel = new KChatHistoryItem(query, deepSearchResponse, (KLikeType) null, 4, (DefaultConstructorMarker) null);
        return chatModel;
    }

    public static final KChatHistoryItem createGreetError() {
        String onlineContent = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "ff_community_deepsearch_greet_default", (String) null, 2, (Object) null);
        if (onlineContent == null) {
            onlineContent = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        if (onlineContent.length() == 0) {
            onlineContent = "你好！我们整理了站内大量的测评视频和真实用户的反馈，可以帮你找到最适合的手机。能告诉我你最关心的手机的哪些方面吗？";
        }
        KColors colors = new KColors("#18191C", "#E7E9EB");
        KWordNode wordNode = new KWordNode(onlineContent, 16.0d, colors, (KWordNode.KWordNodeStyle) null, (KWordNode.KUnderlineStyle) null, "regular", 0, (KBgStyle) null, 216, (DefaultConstructorMarker) null);
        KTextNode nodeText = new KTextNode(KTextNode.KTextNodeType.WORDS.INSTANCE, onlineContent, new KTextNode.KWord(wordNode));
        KParagraph paragraph = new KParagraph(KParagraph.KParagraphType.TEXT.INSTANCE, (KParagraph.KParagraphFormat) null, new KParagraph.KText(new KTextParagraph(CollectionsKt.listOf(nodeText))), 2, (DefaultConstructorMarker) null);
        KParaSpacing paraSpacing = new KParaSpacing(12.0d, 0.0d, 0.0d, 6, (DefaultConstructorMarker) null);
        KGreetings greets = new KGreetings(CollectionsKt.listOf(new KModuleParagraph(paragraph, false, paraSpacing, 2, (DefaultConstructorMarker) null)));
        KDeepSearchContent deepContent = new KDeepSearchContent(new KDeepSearchContent.KGreetings(greets));
        KDeepSearchResponse deepSearchResponse = new KDeepSearchResponse(0, Clock.System.INSTANCE.now().toEpochMilliseconds() + "_session", Clock.System.INSTANCE.now().toEpochMilliseconds() + "_query", KChatStatus.FINISH.INSTANCE, deepContent, (String) null, Clock.System.INSTANCE.now().toEpochMilliseconds(), 32, (DefaultConstructorMarker) null);
        KChatHistoryItem chatModel = new KChatHistoryItem(RoomRecommendViewModel.EMPTY_CURSOR, deepSearchResponse, (KLikeType) null, 4, (DefaultConstructorMarker) null);
        return chatModel;
    }
}