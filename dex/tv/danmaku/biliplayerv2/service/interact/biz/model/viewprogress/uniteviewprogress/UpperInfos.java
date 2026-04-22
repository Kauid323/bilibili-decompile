package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoGuide.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/UpperInfos;", "", "<init>", "()V", "fansCount", "", "getFansCount", "()J", "setFansCount", "(J)V", "arcCountLastHalfYear", "getArcCountLastHalfYear", "setArcCountLastHalfYear", "firstUpDates", "getFirstUpDates", "setFirstUpDates", "totalPlayCount", "getTotalPlayCount", "setTotalPlayCount", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UpperInfos {
    private long fansCount = 1;
    private long arcCountLastHalfYear = 2;
    private long firstUpDates = 3;
    private long totalPlayCount = 4;

    public final long getFansCount() {
        return this.fansCount;
    }

    public final void setFansCount(long j) {
        this.fansCount = j;
    }

    public final long getArcCountLastHalfYear() {
        return this.arcCountLastHalfYear;
    }

    public final void setArcCountLastHalfYear(long j) {
        this.arcCountLastHalfYear = j;
    }

    public final long getFirstUpDates() {
        return this.firstUpDates;
    }

    public final void setFirstUpDates(long j) {
        this.firstUpDates = j;
    }

    public final long getTotalPlayCount() {
        return this.totalPlayCount;
    }

    public final void setTotalPlayCount(long j) {
        this.totalPlayCount = j;
    }
}