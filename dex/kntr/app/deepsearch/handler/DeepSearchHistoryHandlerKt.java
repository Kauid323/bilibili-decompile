package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.ArrayList;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.deepsearch.base.model.DSTimeDescription;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModel;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.deepsearch.service.DeepSearchTransformListServiceImpKt;
import kntr.app.deepsearch.stateMachine.DeepSearchStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DeepSearchHistoryHandler.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0002¨\u0006\u0015"}, d2 = {"bindChatHistoryInitAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", ReportBuildInParam.MACHINE, "Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine;", "isEndLoad", RoomRecommendViewModel.EMPTY_CURSOR, "pageData", "handleSessionEndTimeModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "lastHistoryItem", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "timestampTransformTimeFormat", RoomRecommendViewModel.EMPTY_CURSOR, "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "handleResponseItemList", RoomRecommendViewModel.EMPTY_CURSOR, "list", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchHistoryHandlerKt {
    public static final void bindChatHistoryInitAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock, final DeepSearchStateMachine machine) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        Intrinsics.checkNotNullParameter(machine, ReportBuildInParam.MACHINE);
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindChatHistoryInitAction$lambda$0;
                bindChatHistoryInitAction$lambda$0 = DeepSearchHistoryHandlerKt.bindChatHistoryInitAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindChatHistoryInitAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindChatHistoryInitAction$lambda$1;
                bindChatHistoryInitAction$lambda$1 = DeepSearchHistoryHandlerKt.bindChatHistoryInitAction$lambda$1((ConditionBuilderBlock) obj);
                return bindChatHistoryInitAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindChatHistoryInitAction$lambda$2;
                bindChatHistoryInitAction$lambda$2 = DeepSearchHistoryHandlerKt.bindChatHistoryInitAction$lambda$2((DeepSearchPageData) obj);
                return Boolean.valueOf(bindChatHistoryInitAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindChatHistoryInitAction$lambda$3;
                bindChatHistoryInitAction$lambda$3 = DeepSearchHistoryHandlerKt.bindChatHistoryInitAction$lambda$3((ConditionBuilderBlock) obj);
                return bindChatHistoryInitAction$lambda$3;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean bindChatHistoryInitAction$lambda$4;
                bindChatHistoryInitAction$lambda$4 = DeepSearchHistoryHandlerKt.bindChatHistoryInitAction$lambda$4((DeepSearchPageData) obj);
                return Boolean.valueOf(bindChatHistoryInitAction$lambda$4);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit bindChatHistoryInitAction$lambda$5;
                bindChatHistoryInitAction$lambda$5 = DeepSearchHistoryHandlerKt.bindChatHistoryInitAction$lambda$5(DeepSearchStateMachine.this, (ConditionBuilderBlock) obj);
                return bindChatHistoryInitAction$lambda$5;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.ChatHistoryAction.UpdateList.class), executionPolicy$iv, handler$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChatHistoryInitAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getChatHistoryReqState().getStatus() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindChatHistoryInitAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.ChatHistoryAction.Refresh.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChatHistoryInitAction$lambda$2(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getChatHistoryReqState().getStatus() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindChatHistoryInitAction$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.ChatHistoryAction.LoadMore.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChatHistoryInitAction$lambda$4(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getChatHistoryReqState().getStatus() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindChatHistoryInitAction$lambda$5(DeepSearchStateMachine $machine, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterEffect(new DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1($machine, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isEndLoad(DeepSearchPageData pageData) {
        return (pageData.getHistoryCursor().length() == 0) && !pageData.getList().getList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchSessionEndModel handleSessionEndTimeModel(DeepSearchPageData pageData, KChatHistoryItem lastHistoryItem) {
        KDeepSearchResponse it;
        if (lastHistoryItem != null && (it = lastHistoryItem.getContent()) != null) {
            long nowTimestamp = Clock.System.INSTANCE.now().toEpochMilliseconds();
            long interval = pageData.getTextConfigModel().getSessionEndInterval() > 0 ? pageData.getTextConfigModel().getSessionEndInterval() : 600000L;
            if (nowTimestamp - it.getTimestamp() > interval) {
                return new DeepSearchSessionEndModel(it.getSessionId(), lastHistoryItem.getQuery(), it.getQueryId(), it.getTimestamp(), timestampTransformTimeFormat(it.getTimestamp()));
            }
            return null;
        }
        return null;
    }

    private static final String timestampTransformTimeFormat(long timestamp) {
        Instant instant = Instant.Companion.fromEpochMilliseconds(timestamp);
        LocalDateTime dateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        int year = dateTime.getYear();
        int monthNumber = dateTime.getMonthNumber();
        int dayOfMonth = dateTime.getDayOfMonth();
        String padZero = DSTimeDescription.Null.INSTANCE.padZero(dateTime.getHour());
        return year + "年" + monthNumber + "月" + dayOfMonth + "日 " + padZero + ":" + DSTimeDescription.Null.INSTANCE.padZero(dateTime.getMinute());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KChatHistoryItem> handleResponseItemList(DeepSearchPageData pageData, List<KChatHistoryItem> list) {
        List tempList = new ArrayList();
        List<KChatHistoryItem> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            KChatHistoryItem item = (KChatHistoryItem) element$iv;
            KDeepSearchResponse response = item.getContent();
            if (response != null) {
                if (DeepSearchTransformListServiceImpKt.isContentGreet(response)) {
                    tempList.add(item);
                } else {
                    tempList.add(DeepSearchBroadcastHandlerKt.handleThinkForItem(pageData, item.getQuery(), response, item.getLikeType()));
                }
            }
        }
        return tempList;
    }
}