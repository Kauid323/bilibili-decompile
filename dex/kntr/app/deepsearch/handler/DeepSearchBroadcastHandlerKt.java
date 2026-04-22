package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswer;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerText;
import com.bapis.bilibili.broadcast.message.deepsearch.KChatStatus;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchContent;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import java.util.ArrayList;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContent;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.service.DeepSearchTransformListServiceImpKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchBroadcastHandler.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a \u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a \u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a*\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0000¨\u0006\u001d"}, d2 = {"handleBroadcastResponse", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "notify", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KDeepSearchResponse;", "pageData", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "timeoutService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "dataProcessService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "handleGreetBroadcastFail", "handleBroadcastFail", "handleFinishStatus", RoomRecommendViewModel.EMPTY_CURSOR, "handlePageChatState", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "handleErrorResponse", "handleExpiredResponse", "handleBroadcastThinkPopContent", "Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent;", "findBroadcastNotifyToItem", "list", "findListToGreetItem", "handleThinkForItem", "query", RoomRecommendViewModel.EMPTY_CURSOR, "likeType", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchBroadcastHandlerKt {
    public static final List<KChatHistoryItem> handleBroadcastResponse(KDeepSearchResponse notify, DeepSearchPageData pageData, DeepSearchTimeoutService timeoutService, DeepSearchDataProcessService dataProcessService) {
        Intrinsics.checkNotNullParameter(notify, "notify");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(timeoutService, "timeoutService");
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        if (DeepSearchTransformListServiceImpKt.isContentGreet(notify)) {
            timeoutService.greetLaunchTimeout();
            if (handleFinishStatus(notify)) {
                timeoutService.greetCancelTimeout();
            }
            if (Intrinsics.areEqual(notify.getStatus(), KChatStatus.FINISH.INSTANCE) || Intrinsics.areEqual(notify.getStatus(), KChatStatus.STOP.INSTANCE)) {
                dataProcessService.cacheEndQuery("Greet" + notify.getSessionId());
            }
            Object tempGreet = findListToGreetItem(notify, pageData.getList().getList());
            List tempList = CollectionsKt.toMutableList(pageData.getList().getList());
            if (tempGreet != null) {
                tempList.remove(tempGreet);
            }
            KChatHistoryItem newItem = new KChatHistoryItem(RoomRecommendViewModel.EMPTY_CURSOR, notify, (KLikeType) null, 4, (DefaultConstructorMarker) null);
            tempList.add(0, newItem);
            return tempList;
        }
        timeoutService.launchTimeout();
        if (handleFinishStatus(notify)) {
            timeoutService.cancelTimeout();
        }
        if (Intrinsics.areEqual(notify.getStatus(), KChatStatus.FINISH.INSTANCE) || Intrinsics.areEqual(notify.getStatus(), KChatStatus.STOP.INSTANCE)) {
            dataProcessService.cacheEndQuery(notify.getQueryId());
        }
        KChatHistoryItem tempItem = findBroadcastNotifyToItem(notify, pageData.getList().getList());
        if (tempItem == null) {
            return pageData.getList().getList();
        }
        List tempList2 = CollectionsKt.toMutableList(pageData.getList().getList());
        tempList2.remove(tempItem);
        KChatHistoryItem newItem2 = handleThinkForItem$default(pageData, tempItem.getQuery(), notify, null, 8, null);
        tempList2.add(newItem2);
        return tempList2;
    }

    public static final List<KChatHistoryItem> handleGreetBroadcastFail(DeepSearchPageData pageData) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        List tempList = new ArrayList();
        boolean isUpdate = false;
        boolean isHasGreet = false;
        if (pageData.getList().getList().isEmpty()) {
            tempList.add(DeepSearchChatErrorHandlerKt.createGreetError());
            isHasGreet = true;
            isUpdate = true;
        } else {
            Iterable $this$forEach$iv = pageData.getList().getList();
            for (Object element$iv : $this$forEach$iv) {
                KChatHistoryItem item = (KChatHistoryItem) element$iv;
                KDeepSearchResponse content = item.getContent();
                if (content != null) {
                    if (Intrinsics.areEqual(content.getStatus(), KChatStatus.START.INSTANCE) || Intrinsics.areEqual(content.getStatus(), KChatStatus.COMMON.INSTANCE) || Intrinsics.areEqual(content.getStatus(), KChatStatus.PLACEHOLDER.INSTANCE)) {
                        if (DeepSearchTransformListServiceImpKt.isContentGreet(content)) {
                            tempList.add(0, DeepSearchChatErrorHandlerKt.createGreetError());
                            isUpdate = true;
                            isHasGreet = true;
                        } else {
                            tempList.add(item);
                        }
                    } else {
                        if (DeepSearchTransformListServiceImpKt.isContentGreet(content)) {
                            isHasGreet = true;
                        }
                        tempList.add(item);
                    }
                }
            }
        }
        if (!isHasGreet) {
            tempList.add(0, DeepSearchChatErrorHandlerKt.createGreetError());
            isUpdate = true;
        }
        if (isUpdate) {
            return tempList;
        }
        return CollectionsKt.emptyList();
    }

    public static final List<KChatHistoryItem> handleBroadcastFail(DeepSearchPageData pageData, DeepSearchDataProcessService dataProcessService) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        List tempList = new ArrayList();
        boolean isUpdate = false;
        Iterable $this$forEach$iv = pageData.getList().getList();
        for (Object element$iv : $this$forEach$iv) {
            KChatHistoryItem item = (KChatHistoryItem) element$iv;
            KDeepSearchResponse content = item.getContent();
            if (content != null) {
                if (Intrinsics.areEqual(content.getStatus(), KChatStatus.START.INSTANCE) || Intrinsics.areEqual(content.getStatus(), KChatStatus.COMMON.INSTANCE) || Intrinsics.areEqual(content.getStatus(), KChatStatus.PLACEHOLDER.INSTANCE)) {
                    if (!DeepSearchTransformListServiceImpKt.isContentGreet(content)) {
                        dataProcessService.cacheAbnormalQuery(content.getQueryId());
                        KChatHistoryItem errorItem = DeepSearchChatErrorHandlerKt.createChatError(content.getSessionId(), item.getQuery(), content.getQueryId());
                        tempList.add(errorItem);
                        isUpdate = true;
                        DeepSearchTrackerHandlerKt.handleBroadcastErrorTrack(content.getSessionId(), content.getQueryId(), DeepSearchBroadcastError.Timeout);
                    } else {
                        tempList.add(item);
                    }
                } else {
                    tempList.add(item);
                }
            }
        }
        if (isUpdate) {
            return tempList;
        }
        return CollectionsKt.emptyList();
    }

    public static final boolean handleFinishStatus(KDeepSearchResponse notify) {
        Intrinsics.checkNotNullParameter(notify, "notify");
        return Intrinsics.areEqual(notify.getStatus(), KChatStatus.FINISH.INSTANCE) || Intrinsics.areEqual(notify.getStatus(), KChatStatus.STOP.INSTANCE);
    }

    public static final DeepSearchPageChatState handlePageChatState(KDeepSearchResponse notify, DeepSearchPageData pageData) {
        KThinking think;
        Intrinsics.checkNotNullParameter(notify, "notify");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        KDeepSearchContent content = notify.getDeepContent();
        if (content != null) {
            KDeepSearchContent.KAnswer contentItem = content.getContentItem();
            if ((contentItem instanceof KDeepSearchContent.KAnswer) && (think = contentItem.getValue().getThinking()) != null) {
                if ((think.getThinkingContent().length() > 0) && !Intrinsics.areEqual(think.getStatus(), KThinking.KStatus.FINISH.INSTANCE)) {
                    return new DeepSearchPageChatState.Thinking(pageData.getTextConfigModel().getNavigationThinking(), notify.getQueryId());
                }
            }
        }
        if (Intrinsics.areEqual(notify.getStatus(), KChatStatus.STOP.INSTANCE) || Intrinsics.areEqual(notify.getStatus(), KChatStatus.FINISH.INSTANCE)) {
            return new DeepSearchPageChatState.None(null, null, 3, null);
        }
        return new DeepSearchPageChatState.Answering(pageData.getTextConfigModel().getNavigationAnswering(), notify.getQueryId());
    }

    public static final boolean handleErrorResponse(KDeepSearchResponse notify, DeepSearchPageData pageData) {
        Intrinsics.checkNotNullParameter(notify, "notify");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        if (notify.getCode() == 0) {
            if (!(pageData.getSessionId().length() == 0) && Intrinsics.areEqual(pageData.getSessionId(), notify.getSessionId())) {
                KDeepSearchContent deepContent = notify.getDeepContent();
                if ((deepContent != null ? deepContent.getContentItem() : null) == null) {
                    return true;
                }
                if (DeepSearchTransformListServiceImpKt.isContentGreet(notify)) {
                    return false;
                }
                Iterable $this$forEach$iv = CollectionsKt.reversed(pageData.getList().getList());
                for (Object element$iv : $this$forEach$iv) {
                    KChatHistoryItem it = (KChatHistoryItem) element$iv;
                    KDeepSearchResponse content = it.getContent();
                    if (content != null && Intrinsics.areEqual(content.getQueryId(), notify.getQueryId()) && Intrinsics.areEqual(content.getSessionId(), notify.getSessionId())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static final boolean handleExpiredResponse(KDeepSearchResponse notify, DeepSearchPageData pageData, DeepSearchDataProcessService dataProcessService) {
        Intrinsics.checkNotNullParameter(notify, "notify");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        if (DeepSearchTransformListServiceImpKt.isContentGreet(notify)) {
            if (dataProcessService.isContainEndQueryId("Greet" + notify.getSessionId())) {
                return true;
            }
            for (KChatHistoryItem item : pageData.getList().getList()) {
                if (DeepSearchTransformListServiceImpKt.isContentGreet(item.getContent())) {
                    KDeepSearchResponse content = item.getContent();
                    if (content != null) {
                        return Intrinsics.areEqual(content.getStatus(), KChatStatus.FINISH.INSTANCE) || notify.getTimestamp() < content.getTimestamp();
                    }
                    return false;
                }
            }
            return false;
        } else if (dataProcessService.isContainEndQueryId(notify.getQueryId())) {
            return true;
        } else {
            Iterable $this$forEach$iv = CollectionsKt.reversed(pageData.getList().getList());
            for (Object element$iv : $this$forEach$iv) {
                KChatHistoryItem it = (KChatHistoryItem) element$iv;
                KDeepSearchResponse content2 = it.getContent();
                if (content2 != null && Intrinsics.areEqual(content2.getQueryId(), notify.getQueryId()) && Intrinsics.areEqual(content2.getSessionId(), notify.getSessionId())) {
                    return Intrinsics.areEqual(content2.getStatus(), KChatStatus.FINISH.INSTANCE) || Intrinsics.areEqual(content2.getStatus(), KChatStatus.STOP.INSTANCE) || notify.getTimestamp() < content2.getTimestamp();
                }
            }
            return false;
        }
    }

    public static final DeepSearchThinkPopContent handleBroadcastThinkPopContent(KDeepSearchResponse notify, DeepSearchPageData pageData) {
        Intrinsics.checkNotNullParameter(notify, "notify");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        DeepSearchThinkPopContent popContent = pageData.getThinkPopContent();
        if (popContent != null && Intrinsics.areEqual(popContent.getSessionId(), notify.getSessionId()) && Intrinsics.areEqual(popContent.getQueryId(), notify.getQueryId())) {
            if (notify.getTimestamp() < popContent.getTimestamp()) {
                return pageData.getThinkPopContent();
            }
            KDeepSearchContent deepContent = notify.getDeepContent();
            KDeepSearchContent.KAnswer contentItem = deepContent != null ? deepContent.getContentItem() : null;
            if (contentItem instanceof KDeepSearchContent.KAnswer) {
                KThinking it = contentItem.getValue().getThinking();
                if (it != null) {
                    return new DeepSearchThinkPopContent(popContent.getSessionId(), popContent.getQueryId(), it.getStatus(), it.getWindowText(), it.getThinkingContent(), notify.getTimestamp());
                }
            } else {
                return pageData.getThinkPopContent();
            }
        }
        return pageData.getThinkPopContent();
    }

    private static final KChatHistoryItem findBroadcastNotifyToItem(KDeepSearchResponse notify, List<KChatHistoryItem> list) {
        Iterable $this$forEach$iv = CollectionsKt.reversed(list);
        for (Object element$iv : $this$forEach$iv) {
            KChatHistoryItem item = (KChatHistoryItem) element$iv;
            KDeepSearchResponse content = item.getContent();
            if (content != null && Intrinsics.areEqual(notify.getQueryId(), content.getQueryId()) && notify.getTimestamp() > content.getTimestamp()) {
                return item;
            }
        }
        return null;
    }

    private static final KChatHistoryItem findListToGreetItem(KDeepSearchResponse notify, List<KChatHistoryItem> list) {
        Iterable $this$forEach$iv = CollectionsKt.reversed(list);
        for (Object element$iv : $this$forEach$iv) {
            KChatHistoryItem item = (KChatHistoryItem) element$iv;
            KDeepSearchResponse content = item.getContent();
            if (content != null && DeepSearchTransformListServiceImpKt.isContentGreet(content)) {
                return item;
            }
        }
        return null;
    }

    public static /* synthetic */ KChatHistoryItem handleThinkForItem$default(DeepSearchPageData deepSearchPageData, String str, KDeepSearchResponse kDeepSearchResponse, KLikeType kLikeType, int i, Object obj) {
        if ((i & 8) != 0) {
            kLikeType = (KLikeType) KLikeType.INVALID.INSTANCE;
        }
        return handleThinkForItem(deepSearchPageData, str, kDeepSearchResponse, kLikeType);
    }

    public static final KChatHistoryItem handleThinkForItem(DeepSearchPageData pageData, String query, KDeepSearchResponse notify, KLikeType likeType) {
        String completeText;
        String str;
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(notify, "notify");
        Intrinsics.checkNotNullParameter(likeType, "likeType");
        String str2 = RoomRecommendViewModel.EMPTY_CURSOR;
        KThinking.KStatus kStatus = KThinking.KStatus.INVALID.INSTANCE;
        KAnswerText kAnswerText = null;
        KDeepSearchContent content = notify.getDeepContent();
        if (content != null) {
            KDeepSearchContent.KAnswer contentItem = content.getContentItem();
            if (contentItem instanceof KDeepSearchContent.KAnswer) {
                KThinking think = contentItem.getValue().getThinking();
                if (think != null) {
                    str2 = think.getThinkingText();
                    kStatus = think.getStatus();
                }
                KAnswerText it = contentItem.getValue().getAnswerText();
                if (it != null) {
                    kAnswerText = it;
                }
            }
        }
        if ((str2.length() == 0) && Intrinsics.areEqual(kStatus, KThinking.KStatus.INVALID.INSTANCE)) {
            if (Intrinsics.areEqual(notify.getStatus(), KChatStatus.STOP.INSTANCE) || Intrinsics.areEqual(notify.getStatus(), KChatStatus.FINISH.INSTANCE)) {
                if (kAnswerText != null) {
                    str = pageData.getTextConfigModel().getCompleteText();
                } else {
                    str = "思考已停止";
                }
            } else {
                str = pageData.getTextConfigModel().getStreamingText();
            }
            str2 = str;
            kStatus = KThinking.KStatus.FINISH.INSTANCE;
        } else if (Intrinsics.areEqual(kStatus, KThinking.KStatus.FINISH.INSTANCE)) {
            if (Intrinsics.areEqual(notify.getStatus(), KChatStatus.STOP.INSTANCE) || Intrinsics.areEqual(notify.getStatus(), KChatStatus.FINISH.INSTANCE)) {
                completeText = pageData.getTextConfigModel().getCompleteText();
            } else {
                completeText = pageData.getTextConfigModel().getStreamingText();
            }
            str2 = completeText;
        }
        KThinking thinkContent = new KThinking(kStatus, str2, (String) null, (String) null, 12, (DefaultConstructorMarker) null);
        KAnswer answerItem = new KAnswer(thinkContent, kAnswerText);
        KDeepSearchContent deepContent = new KDeepSearchContent(new KDeepSearchContent.KAnswer(answerItem));
        KDeepSearchResponse deepSearchResponse = new KDeepSearchResponse(notify.getCode(), notify.getSessionId(), notify.getQueryId(), notify.getStatus(), deepContent, notify.getChatSummary(), notify.getTimestamp());
        return new KChatHistoryItem(query, deepSearchResponse, likeType);
    }
}