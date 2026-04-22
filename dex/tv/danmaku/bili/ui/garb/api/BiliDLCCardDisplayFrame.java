package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardDisplay.kt */
@Bson
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplayFrame;", "", "img", "", "imgSmall", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getImg", "()Ljava/lang/String;", "getImgSmall", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliDLCCardDisplayFrame {
    public static final int $stable = 0;
    @SerializedName("img_url")
    private final String img;
    @SerializedName("small_img_url")
    private final String imgSmall;

    public static /* synthetic */ BiliDLCCardDisplayFrame copy$default(BiliDLCCardDisplayFrame biliDLCCardDisplayFrame, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = biliDLCCardDisplayFrame.img;
        }
        if ((i & 2) != 0) {
            str2 = biliDLCCardDisplayFrame.imgSmall;
        }
        return biliDLCCardDisplayFrame.copy(str, str2);
    }

    public final String component1() {
        return this.img;
    }

    public final String component2() {
        return this.imgSmall;
    }

    public final BiliDLCCardDisplayFrame copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "img");
        Intrinsics.checkNotNullParameter(str2, "imgSmall");
        return new BiliDLCCardDisplayFrame(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliDLCCardDisplayFrame) {
            BiliDLCCardDisplayFrame biliDLCCardDisplayFrame = (BiliDLCCardDisplayFrame) obj;
            return Intrinsics.areEqual(this.img, biliDLCCardDisplayFrame.img) && Intrinsics.areEqual(this.imgSmall, biliDLCCardDisplayFrame.imgSmall);
        }
        return false;
    }

    public int hashCode() {
        return (this.img.hashCode() * 31) + this.imgSmall.hashCode();
    }

    public String toString() {
        String str = this.img;
        return "BiliDLCCardDisplayFrame(img=" + str + ", imgSmall=" + this.imgSmall + ")";
    }

    public BiliDLCCardDisplayFrame(String img, String imgSmall) {
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(imgSmall, "imgSmall");
        this.img = img;
        this.imgSmall = imgSmall;
    }

    public final String getImg() {
        return this.img;
    }

    public final String getImgSmall() {
        return this.imgSmall;
    }
}