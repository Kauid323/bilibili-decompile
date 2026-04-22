package kntr.app.upper.entrance.bubble2.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: BubbleTiredService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lkntr/app/upper/entrance/bubble2/service/TempBubbleShow;", "", "bubbleShowTimes", "", "dayRangeCount", "force", "<init>", "(III)V", "getBubbleShowTimes", "()I", "getDayRangeCount", "setDayRangeCount", "(I)V", "getForce", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TempBubbleShow {
    private final int bubbleShowTimes;
    private int dayRangeCount;
    private final int force;

    public static /* synthetic */ TempBubbleShow copy$default(TempBubbleShow tempBubbleShow, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = tempBubbleShow.bubbleShowTimes;
        }
        if ((i4 & 2) != 0) {
            i2 = tempBubbleShow.dayRangeCount;
        }
        if ((i4 & 4) != 0) {
            i3 = tempBubbleShow.force;
        }
        return tempBubbleShow.copy(i, i2, i3);
    }

    public final int component1() {
        return this.bubbleShowTimes;
    }

    public final int component2() {
        return this.dayRangeCount;
    }

    public final int component3() {
        return this.force;
    }

    public final TempBubbleShow copy(int i, int i2, int i3) {
        return new TempBubbleShow(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TempBubbleShow) {
            TempBubbleShow tempBubbleShow = (TempBubbleShow) obj;
            return this.bubbleShowTimes == tempBubbleShow.bubbleShowTimes && this.dayRangeCount == tempBubbleShow.dayRangeCount && this.force == tempBubbleShow.force;
        }
        return false;
    }

    public int hashCode() {
        return (((this.bubbleShowTimes * 31) + this.dayRangeCount) * 31) + this.force;
    }

    public String toString() {
        int i = this.bubbleShowTimes;
        int i2 = this.dayRangeCount;
        return "TempBubbleShow(bubbleShowTimes=" + i + ", dayRangeCount=" + i2 + ", force=" + this.force + ")";
    }

    public TempBubbleShow(int bubbleShowTimes, int dayRangeCount, int force) {
        this.bubbleShowTimes = bubbleShowTimes;
        this.dayRangeCount = dayRangeCount;
        this.force = force;
    }

    public final int getBubbleShowTimes() {
        return this.bubbleShowTimes;
    }

    public final int getDayRangeCount() {
        return this.dayRangeCount;
    }

    public final void setDayRangeCount(int i) {
        this.dayRangeCount = i;
    }

    public final int getForce() {
        return this.force;
    }
}