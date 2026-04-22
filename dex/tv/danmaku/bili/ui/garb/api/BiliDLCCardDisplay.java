package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardDisplay.kt */
@Bson
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;", "", "cornerMark", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplayMark;", "frame", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplayFrame;", "<init>", "(Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplayMark;Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplayFrame;)V", "getCornerMark", "()Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplayMark;", "getFrame", "()Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplayFrame;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliDLCCardDisplay {
    public static final int $stable = 0;
    @SerializedName("corner_mark")
    private final BiliDLCCardDisplayMark cornerMark;
    @SerializedName("frame")
    private final BiliDLCCardDisplayFrame frame;

    public static /* synthetic */ BiliDLCCardDisplay copy$default(BiliDLCCardDisplay biliDLCCardDisplay, BiliDLCCardDisplayMark biliDLCCardDisplayMark, BiliDLCCardDisplayFrame biliDLCCardDisplayFrame, int i, Object obj) {
        if ((i & 1) != 0) {
            biliDLCCardDisplayMark = biliDLCCardDisplay.cornerMark;
        }
        if ((i & 2) != 0) {
            biliDLCCardDisplayFrame = biliDLCCardDisplay.frame;
        }
        return biliDLCCardDisplay.copy(biliDLCCardDisplayMark, biliDLCCardDisplayFrame);
    }

    public final BiliDLCCardDisplayMark component1() {
        return this.cornerMark;
    }

    public final BiliDLCCardDisplayFrame component2() {
        return this.frame;
    }

    public final BiliDLCCardDisplay copy(BiliDLCCardDisplayMark biliDLCCardDisplayMark, BiliDLCCardDisplayFrame biliDLCCardDisplayFrame) {
        Intrinsics.checkNotNullParameter(biliDLCCardDisplayMark, "cornerMark");
        Intrinsics.checkNotNullParameter(biliDLCCardDisplayFrame, "frame");
        return new BiliDLCCardDisplay(biliDLCCardDisplayMark, biliDLCCardDisplayFrame);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliDLCCardDisplay) {
            BiliDLCCardDisplay biliDLCCardDisplay = (BiliDLCCardDisplay) obj;
            return Intrinsics.areEqual(this.cornerMark, biliDLCCardDisplay.cornerMark) && Intrinsics.areEqual(this.frame, biliDLCCardDisplay.frame);
        }
        return false;
    }

    public int hashCode() {
        return (this.cornerMark.hashCode() * 31) + this.frame.hashCode();
    }

    public String toString() {
        BiliDLCCardDisplayMark biliDLCCardDisplayMark = this.cornerMark;
        return "BiliDLCCardDisplay(cornerMark=" + biliDLCCardDisplayMark + ", frame=" + this.frame + ")";
    }

    public BiliDLCCardDisplay(BiliDLCCardDisplayMark cornerMark, BiliDLCCardDisplayFrame frame) {
        Intrinsics.checkNotNullParameter(cornerMark, "cornerMark");
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.cornerMark = cornerMark;
        this.frame = frame;
    }

    public final BiliDLCCardDisplayMark getCornerMark() {
        return this.cornerMark;
    }

    public final BiliDLCCardDisplayFrame getFrame() {
        return this.frame;
    }
}