package tv.danmaku.bili.ui.clipboard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: ClipboardService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipBoardInfo;", "", "videoID", "Ltv/danmaku/bili/ui/clipboard/VideoID;", "uniqueK", "", "<init>", "(Ltv/danmaku/bili/ui/clipboard/VideoID;Ljava/lang/String;)V", "getVideoID", "()Ltv/danmaku/bili/ui/clipboard/VideoID;", "getUniqueK", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ClipBoardInfo {
    public static final int $stable = 8;
    private final String uniqueK;
    private final VideoID videoID;

    public static /* synthetic */ ClipBoardInfo copy$default(ClipBoardInfo clipBoardInfo, VideoID videoID, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            videoID = clipBoardInfo.videoID;
        }
        if ((i & 2) != 0) {
            str = clipBoardInfo.uniqueK;
        }
        return clipBoardInfo.copy(videoID, str);
    }

    public final VideoID component1() {
        return this.videoID;
    }

    public final String component2() {
        return this.uniqueK;
    }

    public final ClipBoardInfo copy(VideoID videoID, String str) {
        Intrinsics.checkNotNullParameter(videoID, "videoID");
        Intrinsics.checkNotNullParameter(str, "uniqueK");
        return new ClipBoardInfo(videoID, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClipBoardInfo) {
            ClipBoardInfo clipBoardInfo = (ClipBoardInfo) obj;
            return Intrinsics.areEqual(this.videoID, clipBoardInfo.videoID) && Intrinsics.areEqual(this.uniqueK, clipBoardInfo.uniqueK);
        }
        return false;
    }

    public int hashCode() {
        return (this.videoID.hashCode() * 31) + this.uniqueK.hashCode();
    }

    public String toString() {
        VideoID videoID = this.videoID;
        return "ClipBoardInfo(videoID=" + videoID + ", uniqueK=" + this.uniqueK + ")";
    }

    public ClipBoardInfo(VideoID videoID, String uniqueK) {
        Intrinsics.checkNotNullParameter(videoID, "videoID");
        Intrinsics.checkNotNullParameter(uniqueK, "uniqueK");
        this.videoID = videoID;
        this.uniqueK = uniqueK;
    }

    public final VideoID getVideoID() {
        return this.videoID;
    }

    public final String getUniqueK() {
        return this.uniqueK;
    }
}