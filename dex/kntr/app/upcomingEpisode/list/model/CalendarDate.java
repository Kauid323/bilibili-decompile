package kntr.app.upcomingEpisode.list.model;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarCard.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/app/upcomingEpisode/list/model/CalendarDate;", "", "itemDate", "", "pointType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "cardList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "<init>", "(JLcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "getItemDate", "()J", "getPointType", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "getCardList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CalendarDate {
    public static final int $stable = 8;
    private final SnapshotStateList<CalendarCard> cardList;
    private final long itemDate;
    private final KCalendarPointType pointType;

    public CalendarDate() {
        this(0L, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CalendarDate copy$default(CalendarDate calendarDate, long j, KCalendarPointType kCalendarPointType, SnapshotStateList snapshotStateList, int i, Object obj) {
        if ((i & 1) != 0) {
            j = calendarDate.itemDate;
        }
        if ((i & 2) != 0) {
            kCalendarPointType = calendarDate.pointType;
        }
        if ((i & 4) != 0) {
            snapshotStateList = calendarDate.cardList;
        }
        return calendarDate.copy(j, kCalendarPointType, snapshotStateList);
    }

    public final long component1() {
        return this.itemDate;
    }

    public final KCalendarPointType component2() {
        return this.pointType;
    }

    public final SnapshotStateList<CalendarCard> component3() {
        return this.cardList;
    }

    public final CalendarDate copy(long j, KCalendarPointType kCalendarPointType, SnapshotStateList<CalendarCard> snapshotStateList) {
        Intrinsics.checkNotNullParameter(kCalendarPointType, "pointType");
        Intrinsics.checkNotNullParameter(snapshotStateList, "cardList");
        return new CalendarDate(j, kCalendarPointType, snapshotStateList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CalendarDate) {
            CalendarDate calendarDate = (CalendarDate) obj;
            return this.itemDate == calendarDate.itemDate && Intrinsics.areEqual(this.pointType, calendarDate.pointType) && Intrinsics.areEqual(this.cardList, calendarDate.cardList);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.itemDate) * 31) + this.pointType.hashCode()) * 31) + this.cardList.hashCode();
    }

    public String toString() {
        long j = this.itemDate;
        KCalendarPointType kCalendarPointType = this.pointType;
        return "CalendarDate(itemDate=" + j + ", pointType=" + kCalendarPointType + ", cardList=" + this.cardList + ")";
    }

    public CalendarDate(long itemDate, KCalendarPointType pointType, SnapshotStateList<CalendarCard> snapshotStateList) {
        Intrinsics.checkNotNullParameter(pointType, "pointType");
        Intrinsics.checkNotNullParameter(snapshotStateList, "cardList");
        this.itemDate = itemDate;
        this.pointType = pointType;
        this.cardList = snapshotStateList;
    }

    public /* synthetic */ CalendarDate(long j, KCalendarPointType kCalendarPointType, SnapshotStateList snapshotStateList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? (KCalendarPointType) KCalendarPointType.CALENDAR_POINT_TYPE_DEFAULT.INSTANCE : kCalendarPointType, (i & 4) != 0 ? new SnapshotStateList() : snapshotStateList);
    }

    public final long getItemDate() {
        return this.itemDate;
    }

    public final KCalendarPointType getPointType() {
        return this.pointType;
    }

    public final SnapshotStateList<CalendarCard> getCardList() {
        return this.cardList;
    }
}