package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardDisplay.kt */
@Bson
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplayMark;", "", "img", "", "<init>", "(Ljava/lang/String;)V", "getImg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliDLCCardDisplayMark {
    public static final int $stable = 0;
    @SerializedName("img_url")
    private final String img;

    public static /* synthetic */ BiliDLCCardDisplayMark copy$default(BiliDLCCardDisplayMark biliDLCCardDisplayMark, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = biliDLCCardDisplayMark.img;
        }
        return biliDLCCardDisplayMark.copy(str);
    }

    public final String component1() {
        return this.img;
    }

    public final BiliDLCCardDisplayMark copy(String str) {
        Intrinsics.checkNotNullParameter(str, "img");
        return new BiliDLCCardDisplayMark(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BiliDLCCardDisplayMark) && Intrinsics.areEqual(this.img, ((BiliDLCCardDisplayMark) obj).img);
    }

    public int hashCode() {
        return this.img.hashCode();
    }

    public String toString() {
        return "BiliDLCCardDisplayMark(img=" + this.img + ")";
    }

    public BiliDLCCardDisplayMark(String img) {
        Intrinsics.checkNotNullParameter(img, "img");
        this.img = img;
    }

    public final String getImg() {
        return this.img;
    }
}