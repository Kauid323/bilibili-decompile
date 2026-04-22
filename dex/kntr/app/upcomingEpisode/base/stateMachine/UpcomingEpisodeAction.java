package kntr.app.upcomingEpisode.base.stateMachine;

import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarTimeRange;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingEpisodeAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0005\u0006\u0007\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "", "WatchCalendar", "DeleteCalendarCard", "ReserveCard", "CancelReserveCard", "Lkntr/app/upcomingEpisode/base/stateMachine/TrackerAction;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$CancelReserveCard;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$DeleteCalendarCard;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$ReserveCard;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$WatchCalendar;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface UpcomingEpisodeAction {

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$WatchCalendar;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "calendarTimeRange", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;", "requestFrom", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "<init>", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;)V", "getCalendarTimeRange", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;", "getRequestFrom", "()Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WatchCalendar implements UpcomingEpisodeAction {
        public static final int $stable = 8;
        private final KCalendarTimeRange calendarTimeRange;
        private final RequestFrom requestFrom;

        public static /* synthetic */ WatchCalendar copy$default(WatchCalendar watchCalendar, KCalendarTimeRange kCalendarTimeRange, RequestFrom requestFrom, int i, Object obj) {
            if ((i & 1) != 0) {
                kCalendarTimeRange = watchCalendar.calendarTimeRange;
            }
            if ((i & 2) != 0) {
                requestFrom = watchCalendar.requestFrom;
            }
            return watchCalendar.copy(kCalendarTimeRange, requestFrom);
        }

        public final KCalendarTimeRange component1() {
            return this.calendarTimeRange;
        }

        public final RequestFrom component2() {
            return this.requestFrom;
        }

        public final WatchCalendar copy(KCalendarTimeRange kCalendarTimeRange, RequestFrom requestFrom) {
            Intrinsics.checkNotNullParameter(kCalendarTimeRange, "calendarTimeRange");
            Intrinsics.checkNotNullParameter(requestFrom, "requestFrom");
            return new WatchCalendar(kCalendarTimeRange, requestFrom);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WatchCalendar) {
                WatchCalendar watchCalendar = (WatchCalendar) obj;
                return Intrinsics.areEqual(this.calendarTimeRange, watchCalendar.calendarTimeRange) && Intrinsics.areEqual(this.requestFrom, watchCalendar.requestFrom);
            }
            return false;
        }

        public int hashCode() {
            return (this.calendarTimeRange.hashCode() * 31) + this.requestFrom.hashCode();
        }

        public String toString() {
            KCalendarTimeRange kCalendarTimeRange = this.calendarTimeRange;
            return "WatchCalendar(calendarTimeRange=" + kCalendarTimeRange + ", requestFrom=" + this.requestFrom + ")";
        }

        public WatchCalendar(KCalendarTimeRange calendarTimeRange, RequestFrom requestFrom) {
            Intrinsics.checkNotNullParameter(calendarTimeRange, "calendarTimeRange");
            Intrinsics.checkNotNullParameter(requestFrom, "requestFrom");
            this.calendarTimeRange = calendarTimeRange;
            this.requestFrom = requestFrom;
        }

        public final KCalendarTimeRange getCalendarTimeRange() {
            return this.calendarTimeRange;
        }

        public final RequestFrom getRequestFrom() {
            return this.requestFrom;
        }
    }

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$DeleteCalendarCard;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "bizType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "bizId", "", "onDeleteSuccess", "Lkotlin/Function0;", "", "<init>", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getBizType", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "getBizId", "()Ljava/lang/String;", "getOnDeleteSuccess", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DeleteCalendarCard implements UpcomingEpisodeAction {
        public static final int $stable = 8;
        private final String bizId;
        private final KWatchBizType bizType;
        private final Function0<Unit> onDeleteSuccess;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeleteCalendarCard copy$default(DeleteCalendarCard deleteCalendarCard, KWatchBizType kWatchBizType, String str, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                kWatchBizType = deleteCalendarCard.bizType;
            }
            if ((i & 2) != 0) {
                str = deleteCalendarCard.bizId;
            }
            if ((i & 4) != 0) {
                function0 = deleteCalendarCard.onDeleteSuccess;
            }
            return deleteCalendarCard.copy(kWatchBizType, str, function0);
        }

        public final KWatchBizType component1() {
            return this.bizType;
        }

        public final String component2() {
            return this.bizId;
        }

        public final Function0<Unit> component3() {
            return this.onDeleteSuccess;
        }

        public final DeleteCalendarCard copy(KWatchBizType kWatchBizType, String str, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(kWatchBizType, "bizType");
            Intrinsics.checkNotNullParameter(str, "bizId");
            Intrinsics.checkNotNullParameter(function0, "onDeleteSuccess");
            return new DeleteCalendarCard(kWatchBizType, str, function0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteCalendarCard) {
                DeleteCalendarCard deleteCalendarCard = (DeleteCalendarCard) obj;
                return Intrinsics.areEqual(this.bizType, deleteCalendarCard.bizType) && Intrinsics.areEqual(this.bizId, deleteCalendarCard.bizId) && Intrinsics.areEqual(this.onDeleteSuccess, deleteCalendarCard.onDeleteSuccess);
            }
            return false;
        }

        public int hashCode() {
            return (((this.bizType.hashCode() * 31) + this.bizId.hashCode()) * 31) + this.onDeleteSuccess.hashCode();
        }

        public String toString() {
            KWatchBizType kWatchBizType = this.bizType;
            String str = this.bizId;
            return "DeleteCalendarCard(bizType=" + kWatchBizType + ", bizId=" + str + ", onDeleteSuccess=" + this.onDeleteSuccess + ")";
        }

        public DeleteCalendarCard(KWatchBizType bizType, String bizId, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(bizType, "bizType");
            Intrinsics.checkNotNullParameter(bizId, "bizId");
            Intrinsics.checkNotNullParameter(function0, "onDeleteSuccess");
            this.bizType = bizType;
            this.bizId = bizId;
            this.onDeleteSuccess = function0;
        }

        public final KWatchBizType getBizType() {
            return this.bizType;
        }

        public final String getBizId() {
            return this.bizId;
        }

        public final Function0<Unit> getOnDeleteSuccess() {
            return this.onDeleteSuccess;
        }
    }

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$ReserveCard;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "sid", "", "onReserveSuccess", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getSid", "()Ljava/lang/String;", "getOnReserveSuccess", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReserveCard implements UpcomingEpisodeAction {
        public static final int $stable = 0;
        private final Function0<Unit> onReserveSuccess;
        private final String sid;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReserveCard copy$default(ReserveCard reserveCard, String str, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reserveCard.sid;
            }
            if ((i & 2) != 0) {
                function0 = reserveCard.onReserveSuccess;
            }
            return reserveCard.copy(str, function0);
        }

        public final String component1() {
            return this.sid;
        }

        public final Function0<Unit> component2() {
            return this.onReserveSuccess;
        }

        public final ReserveCard copy(String str, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "sid");
            Intrinsics.checkNotNullParameter(function0, "onReserveSuccess");
            return new ReserveCard(str, function0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReserveCard) {
                ReserveCard reserveCard = (ReserveCard) obj;
                return Intrinsics.areEqual(this.sid, reserveCard.sid) && Intrinsics.areEqual(this.onReserveSuccess, reserveCard.onReserveSuccess);
            }
            return false;
        }

        public int hashCode() {
            return (this.sid.hashCode() * 31) + this.onReserveSuccess.hashCode();
        }

        public String toString() {
            String str = this.sid;
            return "ReserveCard(sid=" + str + ", onReserveSuccess=" + this.onReserveSuccess + ")";
        }

        public ReserveCard(String sid, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(sid, "sid");
            Intrinsics.checkNotNullParameter(function0, "onReserveSuccess");
            this.sid = sid;
            this.onReserveSuccess = function0;
        }

        public final String getSid() {
            return this.sid;
        }

        public final Function0<Unit> getOnReserveSuccess() {
            return this.onReserveSuccess;
        }
    }

    /* compiled from: UpcomingEpisodeAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$CancelReserveCard;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "sid", "", "onCancelReserveSuccess", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getSid", "()Ljava/lang/String;", "getOnCancelReserveSuccess", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CancelReserveCard implements UpcomingEpisodeAction {
        public static final int $stable = 0;
        private final Function0<Unit> onCancelReserveSuccess;
        private final String sid;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CancelReserveCard copy$default(CancelReserveCard cancelReserveCard, String str, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cancelReserveCard.sid;
            }
            if ((i & 2) != 0) {
                function0 = cancelReserveCard.onCancelReserveSuccess;
            }
            return cancelReserveCard.copy(str, function0);
        }

        public final String component1() {
            return this.sid;
        }

        public final Function0<Unit> component2() {
            return this.onCancelReserveSuccess;
        }

        public final CancelReserveCard copy(String str, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "sid");
            Intrinsics.checkNotNullParameter(function0, "onCancelReserveSuccess");
            return new CancelReserveCard(str, function0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CancelReserveCard) {
                CancelReserveCard cancelReserveCard = (CancelReserveCard) obj;
                return Intrinsics.areEqual(this.sid, cancelReserveCard.sid) && Intrinsics.areEqual(this.onCancelReserveSuccess, cancelReserveCard.onCancelReserveSuccess);
            }
            return false;
        }

        public int hashCode() {
            return (this.sid.hashCode() * 31) + this.onCancelReserveSuccess.hashCode();
        }

        public String toString() {
            String str = this.sid;
            return "CancelReserveCard(sid=" + str + ", onCancelReserveSuccess=" + this.onCancelReserveSuccess + ")";
        }

        public CancelReserveCard(String sid, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(sid, "sid");
            Intrinsics.checkNotNullParameter(function0, "onCancelReserveSuccess");
            this.sid = sid;
            this.onCancelReserveSuccess = function0;
        }

        public final String getSid() {
            return this.sid;
        }

        public final Function0<Unit> getOnCancelReserveSuccess() {
            return this.onCancelReserveSuccess;
        }
    }
}