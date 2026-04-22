package kntr.app.deepsearch.service;

import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswer;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerParagraph;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerText;
import com.bapis.bilibili.broadcast.message.deepsearch.KAuthorCard;
import com.bapis.bilibili.broadcast.message.deepsearch.KCardItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KChatStatus;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchContent;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCard;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCardItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCardPreview;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.CardType;
import kntr.app.deepsearch.base.model.biz.DeepSearchContent;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentListKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataItem;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifier;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData_androidKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchRetryChatModel;
import kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModel;
import kntr.app.deepsearch.base.model.biz.DeepSearchThinkStatus;
import kntr.app.deepsearch.base.model.biz.LinkNodeData;
import kntr.app.deepsearch.base.model.biz.TextLayout;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTransformListServiceImp.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001aV\u0010\u000f\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018j\u0004\u0018\u0001`\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001ah\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00012\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018j\u0004\u0018\u0001`\u001a2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001aL\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018j\u0004\u0018\u0001`\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001aL\u0010)\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\u0006\u0010'\u001a\u00020(2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018j\u0004\u0018\u0001`\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001aL\u0010-\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010/\u001a\u0002002\u0006\u0010'\u001a\u00020(2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018j\u0004\u0018\u0001`\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001aP\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010'\u001a\u00020(2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018j\u0004\u0018\u0001`\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u00103\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0000\u001a\u0012\u0010:\u001a\u00020\u001d2\b\u00108\u001a\u0004\u0018\u000109H\u0000\u001a*\u0010;\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00108\u001a\u0002092\u0006\u0010<\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002\u001a\"\u0010?\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002¨\u0006@"}, d2 = {"handleContentList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem;", "pageData", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "dataProcessService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "linkNodeService", "Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;", "historyItem", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "analysisHistoryItem", "item", "analysisAnswer", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "query", "answerItem", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KAnswer;", "linkNodeCallback", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", "Lkntr/app/deepsearch/base/model/biz/LinkNodeCallback;", "analysisCardItems", "embed", RoomRecommendViewModel.EMPTY_CURSOR, "cardItems", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem;", "startIndex", "createContentAuthor", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Author;", "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "authorCard", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KAuthorCard;", "contentWidth", RoomRecommendViewModel.EMPTY_CURSOR, "createContentText", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Text;", "moduleParagraph", "Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;", "createContentPicture", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Picture;", "pictureCard", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;", "createTextLayout", "Lkntr/app/deepsearch/base/model/biz/TextLayout;", "createThinkNavigation", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$ThinkNavigation;", "thinking", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking;", "isAnswer", "response", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KDeepSearchResponse;", "isContentGreet", "isShowRetry", "responseIndex", "endModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "isHistoryItem", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTransformListServiceImpKt {
    public static final /* synthetic */ List access$handleContentList(DeepSearchPageData pageData, DeepSearchDataProcessService dataProcessService, DeepSearchTextLinkNodeService linkNodeService, KChatHistoryItem historyItem, int index) {
        return handleContentList(pageData, dataProcessService, linkNodeService, historyItem, index);
    }

    public static final List<DeepSearchDataItem> handleContentList(DeepSearchPageData pageData, DeepSearchDataProcessService dataProcessService, DeepSearchTextLinkNodeService linkNodeService, KChatHistoryItem historyItem, int index) {
        String queryId;
        KDeepSearchResponse response;
        DeepSearchSessionEndModel endModel;
        KDeepSearchResponse content = historyItem.getContent();
        if (content == null || (queryId = content.getQueryId()) == null) {
            queryId = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        List dataItemList = new ArrayList();
        dataItemList.addAll(analysisHistoryItem(pageData, historyItem, linkNodeService, dataProcessService));
        KDeepSearchResponse response2 = historyItem.getContent();
        if (response2 == null) {
            return dataItemList;
        }
        if (Intrinsics.areEqual(response2.getStatus(), KChatStatus.PLACEHOLDER.INSTANCE)) {
            dataItemList.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, historyItem.getQuery(), CardType.Placeholder, false, dataItemList.size(), 0, 0, 192, null), false, false, false, CardType.Placeholder, pageData.getContainerWidth(), pageData.getSessionId(), queryId, DeepSearchContent.Placeholder.INSTANCE, 0.0d, 524, null));
            return dataItemList;
        }
        if (Intrinsics.areEqual(response2.getStatus(), KChatStatus.STOP.INSTANCE) && isAnswer(response2)) {
            dataItemList = dataItemList;
            dataItemList.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, historyItem.getQuery(), CardType.AnswerStop, false, dataItemList.size(), 0, 0, 192, null), false, false, false, CardType.AnswerStop, pageData.getContainerWidth(), pageData.getSessionId(), queryId, new DeepSearchContent.AnswerStop(pageData.getSessionId(), queryId), 0.0d, 524, null));
        }
        DeepSearchSessionEndModel endModel2 = pageData.getList().getSessionEndModel();
        boolean z = false;
        boolean isShowEndModel = endModel2 != null && DeepSearchContentListKt.isShowSessionEndTimeLine(endModel2, historyItem);
        if (isShowEndModel) {
            response = response2;
        } else if (index != pageData.getList().getList().size() - 1) {
            response = response2;
        } else {
            response = response2;
            if (isShowRetry(pageData, response, index, pageData.getList().getSessionEndModel())) {
                z = true;
            }
        }
        boolean isShowRetryBtn = z;
        if (isContentGreet(historyItem.getContent())) {
            endModel = endModel2;
        } else if (Intrinsics.areEqual(response.getStatus(), KChatStatus.STOP.INSTANCE) || Intrinsics.areEqual(response.getStatus(), KChatStatus.FINISH.INSTANCE)) {
            endModel = endModel2;
            dataItemList = dataItemList;
            dataItemList.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, historyItem.getQuery(), CardType.Retry, false, dataItemList.size(), 0, 0, 192, null), false, false, false, CardType.Retry, pageData.getContainerWidth(), pageData.getSessionId(), queryId, new DeepSearchContent.Retry(new DeepSearchRetryChatModel(historyItem.getQuery(), queryId, isShowRetryBtn, historyItem.getLikeType())), 0.0d, 526, null));
        } else {
            endModel = endModel2;
        }
        if (!isShowEndModel) {
            return dataItemList;
        }
        if (endModel == null) {
            return dataItemList;
        }
        DeepSearchSessionEndModel it = endModel;
        List dataItemList2 = dataItemList;
        dataItemList2.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, historyItem.getQuery(), CardType.SessionEndTimeLine, false, dataItemList.size(), 0, 0, 192, null), false, false, false, CardType.SessionEndTimeLine, pageData.getContainerWidth(), pageData.getSessionId(), queryId, new DeepSearchContent.SessionEndTimeLine(it), 0.0d, 524, null));
        return dataItemList2;
    }

    private static final List<DeepSearchDataItem> analysisHistoryItem(DeepSearchPageData pageData, KChatHistoryItem item, final DeepSearchTextLinkNodeService linkNodeService, DeepSearchDataProcessService dataProcessService) {
        String str;
        KDeepSearchContent deepContent;
        List $this$analysisHistoryItem_u24lambda_u240 = CollectionsKt.createListBuilder();
        String sessionId = pageData.getSessionId();
        KDeepSearchResponse content = item.getContent();
        if (content == null || (str = content.getQueryId()) == null) {
            str = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        String queryId = str;
        if (item.getQuery().length() > 0) {
            $this$analysisHistoryItem_u24lambda_u240.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, item.getQuery(), CardType.Query, false, $this$analysisHistoryItem_u24lambda_u240.size(), 0, 0, 192, null), false, false, false, CardType.Query, pageData.getContainerWidth(), sessionId, queryId, new DeepSearchContent.Query(item.getQuery()), 0.0d, 526, null));
        }
        KDeepSearchResponse content2 = item.getContent();
        KDeepSearchContent.IContentItem contentItem = (content2 == null || (deepContent = content2.getDeepContent()) == null) ? null : deepContent.getContentItem();
        if (contentItem instanceof KDeepSearchContent.KGreetings) {
            $this$analysisHistoryItem_u24lambda_u240.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, item.getQuery(), CardType.Greet, false, $this$analysisHistoryItem_u24lambda_u240.size(), 0, 0, 192, null), false, false, false, CardType.Greet, pageData.getContainerWidth(), sessionId, queryId, new DeepSearchContent.Greet(((KDeepSearchContent.KGreetings) contentItem).getValue(), pageData.getTextConfigModel().getChatBotIcon()), 0.0d, 526, null));
            Iterable $this$forEach$iv = ((KDeepSearchContent.KGreetings) contentItem).getValue().getParagraphs();
            for (Object element$iv : $this$forEach$iv) {
                KModuleParagraph moduleParagraph = (KModuleParagraph) element$iv;
                DeepSearchDataItemIdentifier idModel = new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, item.getQuery(), CardType.Text, false, $this$analysisHistoryItem_u24lambda_u240.size(), 0, 0, 192, null);
                double d = 32;
                $this$analysisHistoryItem_u24lambda_u240.add(new DeepSearchDataItem(idModel, false, false, false, CardType.Text, pageData.getContainerWidth() - d, sessionId, queryId, createContentText(pageData, idModel, moduleParagraph, pageData.getContainerWidth() - d, new Function1() { // from class: kntr.app.deepsearch.service.DeepSearchTransformListServiceImpKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit analysisHistoryItem$lambda$0$0$0;
                        analysisHistoryItem$lambda$0$0$0 = DeepSearchTransformListServiceImpKt.analysisHistoryItem$lambda$0$0$0(DeepSearchTextLinkNodeService.this, (LinkNodeData) obj);
                        return analysisHistoryItem$lambda$0$0$0;
                    }
                }, dataProcessService), 0.0d, 526, null));
            }
        } else if ((contentItem instanceof KDeepSearchContent.KAnswer) && item.getContent() != null) {
            analysisAnswer($this$analysisHistoryItem_u24lambda_u240, pageData, queryId, item.getQuery(), ((KDeepSearchContent.KAnswer) contentItem).getValue(), new Function1() { // from class: kntr.app.deepsearch.service.DeepSearchTransformListServiceImpKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit analysisHistoryItem$lambda$0$1$0;
                    analysisHistoryItem$lambda$0$1$0 = DeepSearchTransformListServiceImpKt.analysisHistoryItem$lambda$0$1$0(DeepSearchTextLinkNodeService.this, (LinkNodeData) obj);
                    return analysisHistoryItem$lambda$0$1$0;
                }
            }, dataProcessService);
        }
        return CollectionsKt.build($this$analysisHistoryItem_u24lambda_u240);
    }

    public static final Unit analysisHistoryItem$lambda$0$0$0(DeepSearchTextLinkNodeService $linkNodeService, LinkNodeData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        $linkNodeService.emit$biz_debug(data);
        return Unit.INSTANCE;
    }

    public static final Unit analysisHistoryItem$lambda$0$1$0(DeepSearchTextLinkNodeService $linkNodeService, LinkNodeData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        $linkNodeService.emit$biz_debug(data);
        return Unit.INSTANCE;
    }

    private static final void analysisAnswer(List<DeepSearchDataItem> list, DeepSearchPageData pageData, String queryId, String query, KAnswer answerItem, Function1<? super LinkNodeData, Unit> function1, DeepSearchDataProcessService dataProcessService) {
        List paragraphList;
        KThinking thinking = answerItem.getThinking();
        if (thinking != null) {
            list.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, query, CardType.ThinkNavigation, false, list.size(), 0, 0, 192, null), false, false, false, CardType.ThinkNavigation, pageData.getContainerWidth(), pageData.getSessionId(), queryId, createThinkNavigation(pageData, thinking, queryId), 0.0d, 526, null));
        }
        KAnswerText answerText = answerItem.getAnswerText();
        if (answerText != null && (paragraphList = answerText.getParagraphs()) != null) {
            if (paragraphList.isEmpty()) {
                KThinking thinking2 = answerItem.getThinking();
                if (thinking2 != null) {
                    if (thinking2.getThinkingContent().length() > 0) {
                        list.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, query, CardType.ThinkContent, false, list.size(), 0, 0, 192, null), false, false, false, CardType.ThinkContent, pageData.getContainerWidth(), pageData.getSessionId(), queryId, new DeepSearchContent.ThinkContent(thinking2.getThinkingContent()), 0.0d, 526, null));
                        return;
                    }
                    return;
                }
                return;
            }
            List $this$forEach$iv = paragraphList;
            for (Object element$iv : $this$forEach$iv) {
                KAnswerParagraph answerParagraph = (KAnswerParagraph) element$iv;
                if (answerParagraph.getEmbed() && !answerParagraph.getItems().isEmpty()) {
                    List dataItems = analysisCardItems(answerParagraph.getEmbed(), pageData, queryId, query, answerParagraph.getItems(), function1, list.size(), dataProcessService);
                    DeepSearchDataItem dataItem = new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, query, CardType.Embed, true, list.size(), 0, 0, 192, null), false, false, false, CardType.Embed, pageData.getContainerWidth(), pageData.getSessionId(), queryId, new DeepSearchContent.EmbedModule(dataItems), 0.0d, 526, null);
                    list.add(dataItem);
                } else if (!answerParagraph.getItems().isEmpty()) {
                    list.addAll(analysisCardItems(answerParagraph.getEmbed(), pageData, queryId, query, answerParagraph.getItems(), function1, list.size(), dataProcessService));
                }
            }
        }
    }

    private static final List<DeepSearchDataItem> analysisCardItems(boolean embed, DeepSearchPageData pageData, String queryId, String query, List<KCardItem> list, Function1<? super LinkNodeData, Unit> function1, int startIndex, DeepSearchDataProcessService dataProcessService) {
        int dataItemListIndex;
        int embedIndex;
        List $this$analysisCardItems_u24lambda_u240;
        double showWidth;
        double showWidth2;
        List createListBuilder = CollectionsKt.createListBuilder();
        List $this$analysisCardItems_u24lambda_u2402 = createListBuilder;
        List<KCardItem> $this$forEachIndexed$iv = list;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KCardItem cardItem = (KCardItem) item$iv;
            int index = index$iv;
            boolean isFirst = index == 0;
            boolean isLast = index == list.size() - 1;
            if (embed) {
                dataItemListIndex = startIndex;
            } else {
                dataItemListIndex = startIndex + index;
            }
            if (embed) {
                embedIndex = index;
            } else {
                embedIndex = -1;
            }
            KCardItem.KAuthor cardItem2 = cardItem.getCardItem();
            if (cardItem2 instanceof KCardItem.KAuthor) {
                if (embed) {
                    double d = 32;
                    showWidth2 = ((pageData.getContainerWidth() - d) - 24) - d;
                } else {
                    showWidth2 = pageData.getContainerWidth() - 32;
                }
                DeepSearchDataItemIdentifier idModel = new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, query, CardType.Author, embed, dataItemListIndex, embedIndex, 0, 128, null);
                $this$analysisCardItems_u24lambda_u240 = $this$analysisCardItems_u24lambda_u2402;
                $this$analysisCardItems_u24lambda_u240.add(new DeepSearchDataItem(idModel, embed, isFirst, isLast, CardType.Author, pageData.getContainerWidth(), pageData.getSessionId(), queryId, createContentAuthor(pageData, idModel, cardItem2.getValue(), showWidth2, function1, dataProcessService), 0.0d, 512, null));
            } else {
                $this$analysisCardItems_u24lambda_u240 = $this$analysisCardItems_u24lambda_u2402;
                if (cardItem2 instanceof KCardItem.KText) {
                    KModuleParagraph moduleParagraph = ((KCardItem.KText) cardItem2).getValue().getParagraph();
                    if (moduleParagraph != null) {
                        if (embed) {
                            showWidth = (pageData.getContainerWidth() - 32) - 24;
                        } else {
                            showWidth = pageData.getContainerWidth() - 32;
                        }
                        DeepSearchDataItemIdentifier idModel2 = new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, query, CardType.Text, embed, dataItemListIndex, embedIndex, 0, 128, null);
                        $this$analysisCardItems_u24lambda_u240.add(new DeepSearchDataItem(idModel2, embed, isFirst, isLast, CardType.Text, pageData.getContainerWidth(), pageData.getSessionId(), queryId, createContentText(pageData, idModel2, moduleParagraph, showWidth, function1, dataProcessService), 0.0d, 512, null));
                    }
                } else if (cardItem2 instanceof KCardItem.KPictures) {
                    DeepSearchDataItemIdentifier idModel3 = new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, query, CardType.Picture, embed, dataItemListIndex, embedIndex, 0, 128, null);
                    $this$analysisCardItems_u24lambda_u240.add(new DeepSearchDataItem(idModel3, embed, isFirst, isLast, CardType.Picture, pageData.getContainerWidth(), pageData.getSessionId(), queryId, createContentPicture(pageData, idModel3, ((KCardItem.KPictures) cardItem2).getValue(), pageData.getContainerWidth(), function1, dataProcessService), 0.0d, 512, null));
                } else if (cardItem2 instanceof KCardItem.KVideo) {
                    $this$analysisCardItems_u24lambda_u240.add(new DeepSearchDataItem(new DeepSearchDataItemIdentifier(pageData.getSessionId(), queryId, query, CardType.Video, embed, dataItemListIndex, embedIndex, 0, 128, null), embed, isFirst, isLast, CardType.Video, pageData.getContainerWidth(), pageData.getSessionId(), queryId, new DeepSearchContent.Video(((KCardItem.KVideo) cardItem2).getValue()), 0.0d, 512, null));
                }
            }
            $this$analysisCardItems_u24lambda_u2402 = $this$analysisCardItems_u24lambda_u240;
            index$iv = index$iv2;
        }
        return CollectionsKt.build(createListBuilder);
    }

    private static final DeepSearchContent.Author createContentAuthor(DeepSearchPageData pageData, DeepSearchDataItemIdentifier idModel, KAuthorCard authorCard, double contentWidth, Function1<? super LinkNodeData, Unit> function1, DeepSearchDataProcessService dataProcessService) {
        return new DeepSearchContent.Author(authorCard, createTextLayout(pageData, idModel, authorCard.getParagraph(), contentWidth, function1, dataProcessService));
    }

    private static final DeepSearchContent.Text createContentText(DeepSearchPageData pageData, DeepSearchDataItemIdentifier idModel, KModuleParagraph moduleParagraph, double contentWidth, Function1<? super LinkNodeData, Unit> function1, DeepSearchDataProcessService dataProcessService) {
        return new DeepSearchContent.Text(moduleParagraph, createTextLayout(pageData, idModel, moduleParagraph, contentWidth, function1, dataProcessService));
    }

    private static final DeepSearchContent.Picture createContentPicture(DeepSearchPageData pageData, DeepSearchDataItemIdentifier idModel, KPictureCard pictureCard, double contentWidth, Function1<? super LinkNodeData, Unit> function1, DeepSearchDataProcessService dataProcessService) {
        DeepSearchContent.Author author;
        KCardItem card;
        List items = new ArrayList();
        Iterable $this$forEachIndexed$iv = pictureCard.getItems();
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KPictureCardItem cardItem = (KPictureCardItem) item$iv;
            DeepSearchDataItemIdentifier pictureIdModel = new DeepSearchDataItemIdentifier(idModel.getSessionId(), idModel.getQueryId(), idModel.getQuery(), idModel.getCardType(), idModel.getEmbed(), idModel.getDataItemListIndex(), idModel.getEmbedIndex(), index);
            KPictureCardPreview preview = cardItem.getPreview();
            KCardItem.ICardItem tempItem = (preview == null || (card = preview.getCard()) == null) ? null : card.getCardItem();
            if (tempItem instanceof KCardItem.KAuthor) {
                author = createContentAuthor(pageData, pictureIdModel, ((KCardItem.KAuthor) tempItem).getValue(), contentWidth, function1, dataProcessService);
            } else if (tempItem instanceof KCardItem.KText) {
                KAuthorCard tempAuthorCard = new KAuthorCard(0L, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, ((KCardItem.KText) tempItem).getValue().getParagraph(), RoomRecommendViewModel.EMPTY_CURSOR);
                author = createContentAuthor(pageData, pictureIdModel, tempAuthorCard, contentWidth, function1, dataProcessService);
            } else {
                author = null;
            }
            items.add(new DeepSearchContent.PictureCardItem(cardItem, new DeepSearchContent.PictureCardPreview(cardItem.getPreview(), author)));
            index = index$iv;
        }
        return new DeepSearchContent.Picture(pictureCard, items);
    }

    private static final TextLayout createTextLayout(DeepSearchPageData pageData, DeepSearchDataItemIdentifier idModel, KModuleParagraph moduleParagraph, double contentWidth, Function1<? super LinkNodeData, Unit> function1, DeepSearchDataProcessService dataProcessService) {
        if (moduleParagraph != null) {
            if (dataProcessService.isSameParagraph(idModel, moduleParagraph)) {
                return dataProcessService.getCacheLayout(idModel);
            }
            TextLayout textLayout = DeepSearchPageData_androidKt.textLayout(idModel, moduleParagraph, contentWidth, function1);
            LinkNodeData it = pageData.getBubbleData();
            if (it != null) {
                DeepSearchDataItemIdentifier idModel2 = it.getIdModel();
                if ((idModel2 != null ? idModel2.hashCode() : 0) == idModel.hashCode()) {
                    return DeepSearchPageData_androidKt.bubbleActionForUnderlineChangeColor(true, it, textLayout);
                }
            }
            if (textLayout != null) {
                dataProcessService.saveLayout(idModel, moduleParagraph, textLayout);
            }
            return textLayout;
        }
        return null;
    }

    private static final DeepSearchContent.ThinkNavigation createThinkNavigation(DeepSearchPageData pageData, KThinking thinking, String queryId) {
        if ((thinking.getThinkingText().length() == 0) && Intrinsics.areEqual(thinking.getStatus(), KThinking.KStatus.INVALID.INSTANCE)) {
            return new DeepSearchContent.ThinkNavigation(thinking.getThinkingText(), thinking.getThinkingContent(), false, DeepSearchThinkStatus.NONE);
        }
        return new DeepSearchContent.ThinkNavigation(thinking.getThinkingText(), thinking.getThinkingContent(), pageData.getPageChatState().avatarAnimated(queryId), thinking.getStatus());
    }

    public static final boolean isAnswer(KDeepSearchResponse response) {
        KAnswerText answerText;
        List paragraphList;
        Intrinsics.checkNotNullParameter(response, "response");
        KDeepSearchContent it = response.getDeepContent();
        if (it != null) {
            KDeepSearchContent.KAnswer contentItem = it.getContentItem();
            if ((contentItem instanceof KDeepSearchContent.KAnswer) && (answerText = contentItem.getValue().getAnswerText()) != null && (paragraphList = answerText.getParagraphs()) != null && !paragraphList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isContentGreet(KDeepSearchResponse response) {
        KDeepSearchContent it;
        if (response == null || (it = response.getDeepContent()) == null || !(it.getContentItem() instanceof KDeepSearchContent.KGreetings)) {
            return false;
        }
        return true;
    }

    private static final boolean isShowRetry(DeepSearchPageData pageData, KDeepSearchResponse response, int responseIndex, DeepSearchSessionEndModel endModel) {
        return !isContentGreet(response) && isHistoryItem(pageData, responseIndex, endModel) && (Intrinsics.areEqual(response.getStatus(), KChatStatus.STOP.INSTANCE) || Intrinsics.areEqual(response.getStatus(), KChatStatus.FINISH.INSTANCE));
    }

    private static final boolean isHistoryItem(DeepSearchPageData pageData, int responseIndex, DeepSearchSessionEndModel endModel) {
        if (endModel == null) {
            return true;
        }
        int endModelIndex = -1;
        Iterator<T> it = pageData.getList().getList().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int index = i;
            i++;
            KChatHistoryItem item = (KChatHistoryItem) it.next();
            KDeepSearchResponse content = item.getContent();
            if (Intrinsics.areEqual(content != null ? content.getQueryId() : null, endModel.getQueryId())) {
                endModelIndex = index;
                break;
            }
        }
        return 1 <= endModelIndex && endModelIndex < responseIndex;
    }
}