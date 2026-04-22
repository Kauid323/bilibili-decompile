package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatReply;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatReq;
import com.bapis.bilibili.app.search.deepsearch.v1.KDeepSearchMoss;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import com.bapis.bilibili.app.search.deepsearch.v1.KStopChatReply;
import com.bapis.bilibili.app.search.deepsearch.v1.KStopChatReq;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswer;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerText;
import com.bapis.bilibili.broadcast.message.deepsearch.KChatStatus;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchContent;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.Iterator;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.biz.PageStatus;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.deepsearch.service.DeepSearchTransformListServiceImpKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;

/* compiled from: DeepSearchChatHandler.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\f\u001a@\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002\u001a.\u0010\u0017\u001a\u00020\u0018*\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\"\u0010 \u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a&\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0002\u001a\u0016\u0010\u0016\u001a\u00020\u0005*\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\u0011H\u0002\u001a\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¨\u0006'"}, d2 = {"loadChat", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatReply;", "chatType", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatReq$KChatType;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "query", "retryQueryId", "(Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatReq$KChatType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopChat", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KStopChatReply;", "queryId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleChatModel", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "isStop", RoomRecommendViewModel.EMPTY_CURSOR, "pageData", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "originQueryId", "currentQueryId", "thinkingText", "bindChatAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "dataProcessService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "timeoutService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "findDoingItem", "findQueryIdItem", "chatReqError", "handleStopAnswer", "item", "stopped", "isLocalQuery", "generateTimeBasedId", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchChatHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object loadChat(KChatReq.KChatType chatType, String sessionId, String query, String retryQueryId, Continuation<? super KChatReply> continuation) {
        KChatReq req = new KChatReq(chatType, query, sessionId, retryQueryId);
        return new KDeepSearchMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).chat(req, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object stopChat(String sessionId, String queryId, Continuation<? super KStopChatReply> continuation) {
        KStopChatReq req = new KStopChatReq(sessionId, queryId);
        return new KDeepSearchMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).stopChat(req, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List handleChatModel$default(boolean z, DeepSearchPageData deepSearchPageData, String str, String str2, String str3, String str4, int i, Object obj) {
        boolean z2;
        if ((i & 1) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return handleChatModel(z2, deepSearchPageData, str, str2, str3, str4);
    }

    private static final List<KChatHistoryItem> handleChatModel(boolean isStop, DeepSearchPageData pageData, String query, String originQueryId, String currentQueryId, String thinkingText) {
        KThinking.KStatus kStatus;
        KChatStatus kChatStatus;
        List tempList = CollectionsKt.toMutableList(pageData.getList().getList());
        KChatHistoryItem tempItem = null;
        Iterator it = CollectionsKt.reversed(tempList).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            KChatHistoryItem item = (KChatHistoryItem) it.next();
            KDeepSearchResponse content = item.getContent();
            if (Intrinsics.areEqual(originQueryId, content != null ? content.getQueryId() : null) && Intrinsics.areEqual(query, item.getQuery())) {
                tempItem = item;
                break;
            }
        }
        if (isStop && tempItem == null) {
            return tempList;
        }
        if (tempItem != null) {
            tempList.remove(tempItem);
        }
        if (isStop) {
            kStatus = (KThinking.KStatus) KThinking.KStatus.FINISH.INSTANCE;
        } else {
            kStatus = KThinking.KStatus.INVALID.INSTANCE;
        }
        KThinking thinkContent = new KThinking(kStatus, thinkingText, (String) null, (String) null, 12, (DefaultConstructorMarker) null);
        KAnswer answerItem = new KAnswer(thinkContent, (KAnswerText) null, 2, (DefaultConstructorMarker) null);
        KDeepSearchContent deepContent = new KDeepSearchContent(new KDeepSearchContent.KAnswer(answerItem));
        String sessionId = pageData.getSessionId();
        if (isStop) {
            kChatStatus = (KChatStatus) KChatStatus.STOP.INSTANCE;
        } else {
            kChatStatus = KChatStatus.START.INSTANCE;
        }
        KDeepSearchResponse deepSearchResponse = new KDeepSearchResponse(0, sessionId, currentQueryId, kChatStatus, deepContent, (String) null, 0L, 96, (DefaultConstructorMarker) null);
        KChatHistoryItem chatModel = new KChatHistoryItem(query, deepSearchResponse, (KLikeType) null, 4, (DefaultConstructorMarker) null);
        tempList.add(chatModel);
        return tempList;
    }

    public static final void bindChatAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock, final DeepSearchDataProcessService dataProcessService, final DeepSearchTimeoutService timeoutService) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        Intrinsics.checkNotNullParameter(timeoutService, "timeoutService");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindChatAction$lambda$0;
                bindChatAction$lambda$0 = DeepSearchChatHandlerKt.bindChatAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindChatAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindChatAction$lambda$1;
                bindChatAction$lambda$1 = DeepSearchChatHandlerKt.bindChatAction$lambda$1(DeepSearchDataProcessService.this, (ConditionBuilderBlock) obj);
                return bindChatAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindChatAction$lambda$2;
                bindChatAction$lambda$2 = DeepSearchChatHandlerKt.bindChatAction$lambda$2((DeepSearchPageData) obj);
                return Boolean.valueOf(bindChatAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindChatAction$lambda$3;
                bindChatAction$lambda$3 = DeepSearchChatHandlerKt.bindChatAction$lambda$3(DeepSearchDataProcessService.this, timeoutService, (ConditionBuilderBlock) obj);
                return bindChatAction$lambda$3;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean bindChatAction$lambda$4;
                bindChatAction$lambda$4 = DeepSearchChatHandlerKt.bindChatAction$lambda$4((DeepSearchPageData) obj);
                return Boolean.valueOf(bindChatAction$lambda$4);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit bindChatAction$lambda$5;
                bindChatAction$lambda$5 = DeepSearchChatHandlerKt.bindChatAction$lambda$5((ConditionBuilderBlock) obj);
                return bindChatAction$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChatAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getPageStatus(), PageStatus.InitSuccess.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindChatAction$lambda$1(DeepSearchDataProcessService $dataProcessService, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchChatHandlerKt$bindChatAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.InputAction.InputChange.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new DeepSearchChatHandlerKt$bindChatAction$2$2($dataProcessService, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.InputAction.SenderClick.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv3 = new DeepSearchChatHandlerKt$bindChatAction$2$3($dataProcessService, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.RetryChat.class), executionPolicy$iv3, handler$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChatAction$lambda$2(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getChatReqState().getStatus() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindChatAction$lambda$3(DeepSearchDataProcessService $dataProcessService, DeepSearchTimeoutService $timeoutService, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DeepSearchChatHandlerKt$bindChatAction$4$1($dataProcessService, $timeoutService, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChatAction$lambda$4(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getStopChatReqState().getStatus() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindChatAction$lambda$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DeepSearchChatHandlerKt$bindChatAction$6$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KChatHistoryItem findDoingItem(DeepSearchPageData pageData) {
        Iterable $this$forEach$iv = CollectionsKt.reversed(pageData.getList().getList());
        for (Object element$iv : $this$forEach$iv) {
            KChatHistoryItem it = (KChatHistoryItem) element$iv;
            KDeepSearchResponse content = it.getContent();
            if (content != null && (Intrinsics.areEqual(content.getStatus(), KChatStatus.START.INSTANCE) || Intrinsics.areEqual(content.getStatus(), KChatStatus.COMMON.INSTANCE) || Intrinsics.areEqual(content.getStatus(), KChatStatus.PLACEHOLDER.INSTANCE))) {
                return it;
            }
        }
        return null;
    }

    private static final KChatHistoryItem findQueryIdItem(DeepSearchPageData pageData, String query, String queryId) {
        Iterable $this$forEach$iv = CollectionsKt.reversed(pageData.getList().getList());
        for (Object element$iv : $this$forEach$iv) {
            KChatHistoryItem it = (KChatHistoryItem) element$iv;
            KDeepSearchResponse content = it.getContent();
            if (content != null && (Intrinsics.areEqual(content.getQueryId(), queryId) || Intrinsics.areEqual(it.getQuery(), query))) {
                return it;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KChatHistoryItem> chatReqError(DeepSearchPageData pageData, String query, String queryId) {
        KDeepSearchResponse content;
        KChatHistoryItem item = findQueryIdItem(pageData, query, queryId);
        if (Intrinsics.areEqual((item == null || (content = item.getContent()) == null) ? null : content.getStatus(), KChatStatus.FINISH.INSTANCE)) {
            return pageData.getList().getList();
        }
        return DeepSearchChatErrorHandlerKt.handleChatError(pageData, query, queryId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KChatHistoryItem> handleStopAnswer(DeepSearchPageData pageData, KChatHistoryItem item) {
        KDeepSearchResponse response;
        KAnswerText it;
        List tempList = CollectionsKt.toMutableList(pageData.getList().getList());
        TypeIntrinsics.asMutableCollection(tempList).remove(item);
        if (item != null && (response = item.getContent()) != null) {
            String thinkText = "思考已停止";
            KAnswerText kAnswerText = null;
            if (DeepSearchTransformListServiceImpKt.isAnswer(response)) {
                thinkText = pageData.getTextConfigModel().getCompleteText();
                KDeepSearchContent deepContent = response.getDeepContent();
                KDeepSearchContent.KAnswer contentItem = deepContent != null ? deepContent.getContentItem() : null;
                if ((contentItem instanceof KDeepSearchContent.KAnswer) && (it = contentItem.getValue().getAnswerText()) != null) {
                    kAnswerText = it;
                }
            }
            KThinking thinkContent = new KThinking(KThinking.KStatus.FINISH.INSTANCE, thinkText, (String) null, (String) null, 12, (DefaultConstructorMarker) null);
            KAnswer answerItem = new KAnswer(thinkContent, kAnswerText);
            KDeepSearchContent deepContent2 = new KDeepSearchContent(new KDeepSearchContent.KAnswer(answerItem));
            KDeepSearchResponse deepSearchResponse = new KDeepSearchResponse(response.getCode(), response.getSessionId(), response.getQueryId(), KChatStatus.STOP.INSTANCE, deepContent2, response.getChatSummary(), response.getTimestamp());
            KChatHistoryItem customItem = new KChatHistoryItem(item.getQuery(), deepSearchResponse, (KLikeType) null, 4, (DefaultConstructorMarker) null);
            tempList.add(customItem);
        }
        return tempList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String thinkingText$default(DeepSearchPageData deepSearchPageData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return thinkingText(deepSearchPageData, z);
    }

    private static final String thinkingText(DeepSearchPageData $this$thinkingText, boolean stopped) {
        if (stopped) {
            return "思考已停止";
        }
        String startText = $this$thinkingText.getTextConfigModel().getStartText();
        if (startText.length() == 0) {
            startText = "让我翻下站内资料库";
        }
        return startText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isLocalQuery(String queryId) {
        return StringsKt.contains$default(queryId, "custom_chat_", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateTimeBasedId(String sessionId, DeepSearchDataProcessService dataProcessService) {
        long timestamp = Clock.System.INSTANCE.now().toEpochMilliseconds();
        return "custom_chat_" + sessionId + "_" + timestamp + "_" + dataProcessService.getAtomicIndex();
    }
}