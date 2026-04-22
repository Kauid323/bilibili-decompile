package kntr.app.upcomingEpisode.base.handler;

import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.TrackerAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: UpcomingEpisodeTrackerHandler.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\b\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0000\u001a\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0013H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0015H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0017H\u0002\u001a\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0019H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001bH\u0002\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001cH\u0002\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"EXIT_UPCOMING_EP_PAGE_EVENT_ID", "", "UPCOMING_EP_CALENDAR_SHOW_EVENT_ID", "UPCOMING_EP_CALENDAR_CLICK_EVENT_ID", "UPCOMING_EP_CARD_SHOW_EVENT_ID", "UPCOMING_EP_CARD_CLICK_EVENT_ID", "UPCOMING_EP_RECOMMEND_RESERVATION_SHOW_EVENT_ID", "UPCOMING_EP_RECOMMEND_RESERVATION_CLICK_EVENT_ID", "bindTrackerAction", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "handleRecommendReservationShow", "action", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpComingEpisodeRecommendReservationCardShow;", "handleRecommendReservationClick", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpComingEpisodeRecommendReservationCardClick;", "handleCalendarClick", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCalendarClick;", "handleCalendarShow", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCalendarShow;", "handleCardClick", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCardClick;", "handleCardShow", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCardShow;", "toReportString", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeTrackerHandlerKt {
    public static final String EXIT_UPCOMING_EP_PAGE_EVENT_ID = "main.reserve-calendar.0.0.pv";
    private static final String UPCOMING_EP_CALENDAR_CLICK_EVENT_ID = "main.reserve-calendar.calendar.0.click";
    private static final String UPCOMING_EP_CALENDAR_SHOW_EVENT_ID = "main.reserve-calendar.calendar.0.show";
    private static final String UPCOMING_EP_CARD_CLICK_EVENT_ID = "main.reserve-calendar.reserve-list.0.click";
    private static final String UPCOMING_EP_CARD_SHOW_EVENT_ID = "main.reserve-calendar.reserve-card.0.show";
    private static final String UPCOMING_EP_RECOMMEND_RESERVATION_CLICK_EVENT_ID = "main.reserve-calendar.reserve-recommend.reserve-bar.click";
    private static final String UPCOMING_EP_RECOMMEND_RESERVATION_SHOW_EVENT_ID = "main.reserve-calendar.reserve-recommend.reserve-bar.show";

    /* compiled from: UpcomingEpisodeTrackerHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CalendarType.values().length];
            try {
                iArr[CalendarType.WEEK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CalendarType.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CalendarCardClickArea.values().length];
            try {
                iArr2[CalendarCardClickArea.UP_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[CalendarCardClickArea.CARD.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[CalendarCardClickArea.MORE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[CalendarCardClickArea.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[CalendarCardClickArea.RESERVE.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[CalendarCardClickArea.BUTTON.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void bindTrackerAction(FlowReduxStoreBuilder<UpcomingEpisodeData, UpcomingEpisodeAction> flowReduxStoreBuilder) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Function1 block$iv = new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.UpcomingEpisodeTrackerHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit bindTrackerAction$lambda$0;
                bindTrackerAction$lambda$0 = UpcomingEpisodeTrackerHandlerKt.bindTrackerAction$lambda$0((InStateBuilderBlock) obj);
                return bindTrackerAction$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(UpcomingEpisodeData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindTrackerAction$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new UpcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(UpcomingEpisodeAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRecommendReservationShow(TrackerAction.UpComingEpisodeRecommendReservationCardShow action) {
        KNeuron.INSTANCE.reportExposure(false, UPCOMING_EP_RECOMMEND_RESERVATION_SHOW_EVENT_ID, MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("reserve_id", String.valueOf(action.getRecommendReservation().getReserveId())), TuplesKt.to("card_type", String.valueOf(action.getRecommendReservation().getReserveType()))}), action.getRecommendReservation().getReport()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRecommendReservationClick(TrackerAction.UpComingEpisodeRecommendReservationCardClick action) {
        Map emptyMap;
        KNeuron kNeuron = KNeuron.INSTANCE;
        Map plus = MapsKt.plus(action.getRecommendReservation().getReport(), MapsKt.mapOf(new Pair[]{TuplesKt.to("reserve_id", String.valueOf(action.getRecommendReservation().getReserveId())), TuplesKt.to("positon", toReportString(action.getClickArea())), TuplesKt.to("button_type", String.valueOf(action.getRecommendReservation().getReserveState())), TuplesKt.to("card_type", String.valueOf(action.getRecommendReservation().getReserveType()))}));
        if (action.getClickArea() == CalendarCardClickArea.UP_INFO) {
            emptyMap = MapsKt.mapOf(TuplesKt.to("from_spmid", "main.reserve-calendar.0.0"));
        } else {
            emptyMap = MapsKt.emptyMap();
        }
        kNeuron.reportClick(false, UPCOMING_EP_RECOMMEND_RESERVATION_CLICK_EVENT_ID, MapsKt.plus(plus, emptyMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCalendarClick(TrackerAction.UpcomingEpisodeCalendarClick action) {
        KNeuron.INSTANCE.reportClick(false, UPCOMING_EP_CALENDAR_CLICK_EVENT_ID, MapsKt.mapOf(new Pair[]{TuplesKt.to("calendar_type", toReportString(action.getCalendarType())), TuplesKt.to("point_type", toReportString(action.getPointType()))}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCalendarShow(TrackerAction.UpcomingEpisodeCalendarShow action) {
        KNeuron.INSTANCE.reportExposure(false, UPCOMING_EP_CALENDAR_SHOW_EVENT_ID, MapsKt.mapOf(TuplesKt.to("calendar_type", toReportString(action.getCalendarType()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCardClick(TrackerAction.UpcomingEpisodeCardClick action) {
        KNeuron.INSTANCE.reportClick(false, UPCOMING_EP_CARD_CLICK_EVENT_ID, MapsKt.plus(action.getMap(), MapsKt.mapOf(TuplesKt.to("position", toReportString(action.getClickArea())))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCardShow(TrackerAction.UpcomingEpisodeCardShow action) {
        KNeuron.INSTANCE.reportExposure(false, UPCOMING_EP_CARD_SHOW_EVENT_ID, action.getMap());
    }

    private static final String toReportString(CalendarType $this$toReportString) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toReportString.ordinal()]) {
            case 1:
                return "week";
            case 2:
                return "month";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final String toReportString(KCalendarPointType $this$toReportString) {
        return Intrinsics.areEqual($this$toReportString, KCalendarPointType.CALENDAR_POINT_TYPE_RED.INSTANCE) ? "red" : Intrinsics.areEqual($this$toReportString, KCalendarPointType.CALENDAR_POINT_TYPE_GRAY.INSTANCE) ? "gray" : "empty";
    }

    private static final String toReportString(CalendarCardClickArea $this$toReportString) {
        switch (WhenMappings.$EnumSwitchMapping$1[$this$toReportString.ordinal()]) {
            case 1:
                return "up_info";
            case 2:
                return "card";
            case 3:
                return "more";
            case 4:
                return "remove";
            case 5:
                return "reserve";
            case 6:
                return "button";
            default:
                return "cancel_reserve";
        }
    }
}