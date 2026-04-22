package kntr.app.upcomingEpisode.base.stateMachine;

import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarCardClickArea;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingEpisodeAction.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "UpcomingEpisodeCalendarShow", "UpcomingEpisodeCalendarClick", "UpcomingEpisodeCardShow", "UpcomingEpisodeCardClick", "UpComingEpisodeRecommendReservationCardShow", "UpComingEpisodeRecommendReservationCardClick", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpComingEpisodeRecommendReservationCardClick;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpComingEpisodeRecommendReservationCardShow;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCalendarClick;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCalendarShow;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCardClick;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCardShow;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TrackerAction extends UpcomingEpisodeAction {

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCalendarShow;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction;", "calendarType", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "<init>", "(Lkntr/app/upcomingEpisode/base/handler/CalendarType;)V", "getCalendarType", "()Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpcomingEpisodeCalendarShow implements TrackerAction {
        public static final int $stable = 0;
        private final CalendarType calendarType;

        public static /* synthetic */ UpcomingEpisodeCalendarShow copy$default(UpcomingEpisodeCalendarShow upcomingEpisodeCalendarShow, CalendarType calendarType, int i, Object obj) {
            if ((i & 1) != 0) {
                calendarType = upcomingEpisodeCalendarShow.calendarType;
            }
            return upcomingEpisodeCalendarShow.copy(calendarType);
        }

        public final CalendarType component1() {
            return this.calendarType;
        }

        public final UpcomingEpisodeCalendarShow copy(CalendarType calendarType) {
            Intrinsics.checkNotNullParameter(calendarType, "calendarType");
            return new UpcomingEpisodeCalendarShow(calendarType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpcomingEpisodeCalendarShow) && this.calendarType == ((UpcomingEpisodeCalendarShow) obj).calendarType;
        }

        public int hashCode() {
            return this.calendarType.hashCode();
        }

        public String toString() {
            return "UpcomingEpisodeCalendarShow(calendarType=" + this.calendarType + ")";
        }

        public UpcomingEpisodeCalendarShow(CalendarType calendarType) {
            Intrinsics.checkNotNullParameter(calendarType, "calendarType");
            this.calendarType = calendarType;
        }

        public final CalendarType getCalendarType() {
            return this.calendarType;
        }
    }

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCalendarClick;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction;", "calendarType", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "pointType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "<init>", "(Lkntr/app/upcomingEpisode/base/handler/CalendarType;Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;)V", "getCalendarType", "()Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "getPointType", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpcomingEpisodeCalendarClick implements TrackerAction {
        public static final int $stable = 8;
        private final CalendarType calendarType;
        private final KCalendarPointType pointType;

        public static /* synthetic */ UpcomingEpisodeCalendarClick copy$default(UpcomingEpisodeCalendarClick upcomingEpisodeCalendarClick, CalendarType calendarType, KCalendarPointType kCalendarPointType, int i, Object obj) {
            if ((i & 1) != 0) {
                calendarType = upcomingEpisodeCalendarClick.calendarType;
            }
            if ((i & 2) != 0) {
                kCalendarPointType = upcomingEpisodeCalendarClick.pointType;
            }
            return upcomingEpisodeCalendarClick.copy(calendarType, kCalendarPointType);
        }

        public final CalendarType component1() {
            return this.calendarType;
        }

        public final KCalendarPointType component2() {
            return this.pointType;
        }

        public final UpcomingEpisodeCalendarClick copy(CalendarType calendarType, KCalendarPointType kCalendarPointType) {
            Intrinsics.checkNotNullParameter(calendarType, "calendarType");
            Intrinsics.checkNotNullParameter(kCalendarPointType, "pointType");
            return new UpcomingEpisodeCalendarClick(calendarType, kCalendarPointType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UpcomingEpisodeCalendarClick) {
                UpcomingEpisodeCalendarClick upcomingEpisodeCalendarClick = (UpcomingEpisodeCalendarClick) obj;
                return this.calendarType == upcomingEpisodeCalendarClick.calendarType && Intrinsics.areEqual(this.pointType, upcomingEpisodeCalendarClick.pointType);
            }
            return false;
        }

        public int hashCode() {
            return (this.calendarType.hashCode() * 31) + this.pointType.hashCode();
        }

        public String toString() {
            CalendarType calendarType = this.calendarType;
            return "UpcomingEpisodeCalendarClick(calendarType=" + calendarType + ", pointType=" + this.pointType + ")";
        }

        public UpcomingEpisodeCalendarClick(CalendarType calendarType, KCalendarPointType pointType) {
            Intrinsics.checkNotNullParameter(calendarType, "calendarType");
            Intrinsics.checkNotNullParameter(pointType, "pointType");
            this.calendarType = calendarType;
            this.pointType = pointType;
        }

        public final CalendarType getCalendarType() {
            return this.calendarType;
        }

        public final KCalendarPointType getPointType() {
            return this.pointType;
        }
    }

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCardShow;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction;", "map", "", "", "<init>", "(Ljava/util/Map;)V", "getMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpcomingEpisodeCardShow implements TrackerAction {
        public static final int $stable = 8;
        private final Map<String, String> map;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpcomingEpisodeCardShow copy$default(UpcomingEpisodeCardShow upcomingEpisodeCardShow, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = upcomingEpisodeCardShow.map;
            }
            return upcomingEpisodeCardShow.copy(map);
        }

        public final Map<String, String> component1() {
            return this.map;
        }

        public final UpcomingEpisodeCardShow copy(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return new UpcomingEpisodeCardShow(map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpcomingEpisodeCardShow) && Intrinsics.areEqual(this.map, ((UpcomingEpisodeCardShow) obj).map);
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "UpcomingEpisodeCardShow(map=" + this.map + ")";
        }

        public UpcomingEpisodeCardShow(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
        }

        public final Map<String, String> getMap() {
            return this.map;
        }
    }

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpcomingEpisodeCardClick;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction;", "clickArea", "Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;", "map", "", "", "<init>", "(Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;Ljava/util/Map;)V", "getClickArea", "()Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;", "getMap", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpcomingEpisodeCardClick implements TrackerAction {
        public static final int $stable = 8;
        private final CalendarCardClickArea clickArea;
        private final Map<String, String> map;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpcomingEpisodeCardClick copy$default(UpcomingEpisodeCardClick upcomingEpisodeCardClick, CalendarCardClickArea calendarCardClickArea, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                calendarCardClickArea = upcomingEpisodeCardClick.clickArea;
            }
            if ((i & 2) != 0) {
                map = upcomingEpisodeCardClick.map;
            }
            return upcomingEpisodeCardClick.copy(calendarCardClickArea, map);
        }

        public final CalendarCardClickArea component1() {
            return this.clickArea;
        }

        public final Map<String, String> component2() {
            return this.map;
        }

        public final UpcomingEpisodeCardClick copy(CalendarCardClickArea calendarCardClickArea, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(calendarCardClickArea, "clickArea");
            Intrinsics.checkNotNullParameter(map, "map");
            return new UpcomingEpisodeCardClick(calendarCardClickArea, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UpcomingEpisodeCardClick) {
                UpcomingEpisodeCardClick upcomingEpisodeCardClick = (UpcomingEpisodeCardClick) obj;
                return this.clickArea == upcomingEpisodeCardClick.clickArea && Intrinsics.areEqual(this.map, upcomingEpisodeCardClick.map);
            }
            return false;
        }

        public int hashCode() {
            return (this.clickArea.hashCode() * 31) + this.map.hashCode();
        }

        public String toString() {
            CalendarCardClickArea calendarCardClickArea = this.clickArea;
            return "UpcomingEpisodeCardClick(clickArea=" + calendarCardClickArea + ", map=" + this.map + ")";
        }

        public UpcomingEpisodeCardClick(CalendarCardClickArea clickArea, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(clickArea, "clickArea");
            Intrinsics.checkNotNullParameter(map, "map");
            this.clickArea = clickArea;
            this.map = map;
        }

        public final CalendarCardClickArea getClickArea() {
            return this.clickArea;
        }

        public final Map<String, String> getMap() {
            return this.map;
        }
    }

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpComingEpisodeRecommendReservationCardShow;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction;", "recommendReservation", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;", "<init>", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;)V", "getRecommendReservation", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpComingEpisodeRecommendReservationCardShow implements TrackerAction {
        public static final int $stable = 8;
        private final KReserveRecommend recommendReservation;

        public static /* synthetic */ UpComingEpisodeRecommendReservationCardShow copy$default(UpComingEpisodeRecommendReservationCardShow upComingEpisodeRecommendReservationCardShow, KReserveRecommend kReserveRecommend, int i, Object obj) {
            if ((i & 1) != 0) {
                kReserveRecommend = upComingEpisodeRecommendReservationCardShow.recommendReservation;
            }
            return upComingEpisodeRecommendReservationCardShow.copy(kReserveRecommend);
        }

        public final KReserveRecommend component1() {
            return this.recommendReservation;
        }

        public final UpComingEpisodeRecommendReservationCardShow copy(KReserveRecommend kReserveRecommend) {
            Intrinsics.checkNotNullParameter(kReserveRecommend, "recommendReservation");
            return new UpComingEpisodeRecommendReservationCardShow(kReserveRecommend);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpComingEpisodeRecommendReservationCardShow) && Intrinsics.areEqual(this.recommendReservation, ((UpComingEpisodeRecommendReservationCardShow) obj).recommendReservation);
        }

        public int hashCode() {
            return this.recommendReservation.hashCode();
        }

        public String toString() {
            return "UpComingEpisodeRecommendReservationCardShow(recommendReservation=" + this.recommendReservation + ")";
        }

        public UpComingEpisodeRecommendReservationCardShow(KReserveRecommend recommendReservation) {
            Intrinsics.checkNotNullParameter(recommendReservation, "recommendReservation");
            this.recommendReservation = recommendReservation;
        }

        public final KReserveRecommend getRecommendReservation() {
            return this.recommendReservation;
        }
    }

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction$UpComingEpisodeRecommendReservationCardClick;", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction;", "recommendReservation", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;", "clickArea", "Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;", "<init>", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;)V", "getRecommendReservation", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;", "getClickArea", "()Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpComingEpisodeRecommendReservationCardClick implements TrackerAction {
        public static final int $stable = 8;
        private final CalendarCardClickArea clickArea;
        private final KReserveRecommend recommendReservation;

        public static /* synthetic */ UpComingEpisodeRecommendReservationCardClick copy$default(UpComingEpisodeRecommendReservationCardClick upComingEpisodeRecommendReservationCardClick, KReserveRecommend kReserveRecommend, CalendarCardClickArea calendarCardClickArea, int i, Object obj) {
            if ((i & 1) != 0) {
                kReserveRecommend = upComingEpisodeRecommendReservationCardClick.recommendReservation;
            }
            if ((i & 2) != 0) {
                calendarCardClickArea = upComingEpisodeRecommendReservationCardClick.clickArea;
            }
            return upComingEpisodeRecommendReservationCardClick.copy(kReserveRecommend, calendarCardClickArea);
        }

        public final KReserveRecommend component1() {
            return this.recommendReservation;
        }

        public final CalendarCardClickArea component2() {
            return this.clickArea;
        }

        public final UpComingEpisodeRecommendReservationCardClick copy(KReserveRecommend kReserveRecommend, CalendarCardClickArea calendarCardClickArea) {
            Intrinsics.checkNotNullParameter(kReserveRecommend, "recommendReservation");
            Intrinsics.checkNotNullParameter(calendarCardClickArea, "clickArea");
            return new UpComingEpisodeRecommendReservationCardClick(kReserveRecommend, calendarCardClickArea);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UpComingEpisodeRecommendReservationCardClick) {
                UpComingEpisodeRecommendReservationCardClick upComingEpisodeRecommendReservationCardClick = (UpComingEpisodeRecommendReservationCardClick) obj;
                return Intrinsics.areEqual(this.recommendReservation, upComingEpisodeRecommendReservationCardClick.recommendReservation) && this.clickArea == upComingEpisodeRecommendReservationCardClick.clickArea;
            }
            return false;
        }

        public int hashCode() {
            return (this.recommendReservation.hashCode() * 31) + this.clickArea.hashCode();
        }

        public String toString() {
            KReserveRecommend kReserveRecommend = this.recommendReservation;
            return "UpComingEpisodeRecommendReservationCardClick(recommendReservation=" + kReserveRecommend + ", clickArea=" + this.clickArea + ")";
        }

        public UpComingEpisodeRecommendReservationCardClick(KReserveRecommend recommendReservation, CalendarCardClickArea clickArea) {
            Intrinsics.checkNotNullParameter(recommendReservation, "recommendReservation");
            Intrinsics.checkNotNullParameter(clickArea, "clickArea");
            this.recommendReservation = recommendReservation;
            this.clickArea = clickArea;
        }

        public final KReserveRecommend getRecommendReservation() {
            return this.recommendReservation;
        }

        public final CalendarCardClickArea getClickArea() {
            return this.clickArea;
        }
    }
}