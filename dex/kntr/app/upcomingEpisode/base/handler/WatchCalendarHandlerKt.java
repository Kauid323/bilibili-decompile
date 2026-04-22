package kntr.app.upcomingEpisode.base.handler;

import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarDate;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarTimeRange;
import com.bapis.bilibili.community.interfacess.watch.v1.KFeatures;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchCalendarReq;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchCalendarResp;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.datetime.LocalDate;

/* compiled from: WatchCalendarHandler.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0083@¢\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\u00020\n*\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000\u001a\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"TAG", "", "watchCalendar", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchCalendarResp;", "calendarTimeRange", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;", "kFeatures", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KFeatures;", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;Lcom/bapis/bilibili/community/interfacess/watch/v1/KFeatures;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindCalendarAction", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "calculateCalendarType", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "date", "Lkotlinx/datetime/LocalDate;", "calendarList", "", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarDate;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchCalendarHandlerKt {
    private static final String TAG = "WatchCalendarHandler";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object watchCalendar(KCalendarTimeRange calendarTimeRange, KFeatures kFeatures, Continuation<? super KWatchCalendarResp> continuation) {
        KWatchCalendarReq request = new KWatchCalendarReq(calendarTimeRange, kFeatures);
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new WatchCalendarHandlerKt$watchCalendar$2(request, null), continuation);
    }

    public static final void bindCalendarAction(InStateBuilderBlock<UpcomingEpisodeData, UpcomingEpisodeData, UpcomingEpisodeAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindCalendarAction$lambda$0;
                bindCalendarAction$lambda$0 = WatchCalendarHandlerKt.bindCalendarAction$lambda$0((UpcomingEpisodeData) obj);
                return Boolean.valueOf(bindCalendarAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindCalendarAction$lambda$1;
                bindCalendarAction$lambda$1 = WatchCalendarHandlerKt.bindCalendarAction$lambda$1((ConditionBuilderBlock) obj);
                return bindCalendarAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindCalendarAction$lambda$2;
                bindCalendarAction$lambda$2 = WatchCalendarHandlerKt.bindCalendarAction$lambda$2((UpcomingEpisodeData) obj);
                return Boolean.valueOf(bindCalendarAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindCalendarAction$lambda$3;
                bindCalendarAction$lambda$3 = WatchCalendarHandlerKt.bindCalendarAction$lambda$3((ConditionBuilderBlock) obj);
                return bindCalendarAction$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindCalendarAction$lambda$0(UpcomingEpisodeData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getWatchCalendarReqState().getState() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCalendarAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new WatchCalendarHandlerKt$bindCalendarAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(UpcomingEpisodeAction.WatchCalendar.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindCalendarAction$lambda$2(UpcomingEpisodeData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getWatchCalendarReqState().getState() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCalendarAction$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new WatchCalendarHandlerKt$bindCalendarAction$4$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CalendarType calculateCalendarType(LocalDate date, List<KCalendarDate> list) {
        HashSet datesOfWeek = CollectionsKt.toHashSet(BiliCalendarExtensionsKt.datesOfWeek$default(date, null, 1, null));
        KLog_androidKt.getKLog().i(TAG, "date: " + date + ", datesOfWeek: " + datesOfWeek);
        List<KCalendarDate> $this$associate$iv = list;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            KCalendarDate it = (KCalendarDate) element$iv$iv;
            Pair pair = TuplesKt.to(BiliCalendarExtensionsKt.toLocalDate$default(it.getItemDate(), null, 1, null), it.getPointType());
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        for (Map.Entry element$iv : destination$iv$iv.entrySet()) {
            KCalendarPointType pointType = (KCalendarPointType) element$iv.getValue();
            if (!datesOfWeek.contains((LocalDate) element$iv.getKey()) && Intrinsics.areEqual(pointType, KCalendarPointType.CALENDAR_POINT_TYPE_RED.INSTANCE)) {
                return CalendarType.MONTH;
            }
        }
        return CalendarType.WEEK;
    }
}