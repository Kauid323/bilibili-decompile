package tv.danmaku.bili.ui.favorites.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/CntInfo;", "", "thumbNum", "", "<init>", "(I)V", "getThumbNum", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CntInfo {
    public static final int $stable = 0;
    @SerializedName("thumb_up")
    private final int thumbNum;

    public CntInfo() {
        this(0, 1, null);
    }

    public static /* synthetic */ CntInfo copy$default(CntInfo cntInfo, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cntInfo.thumbNum;
        }
        return cntInfo.copy(i);
    }

    public final int component1() {
        return this.thumbNum;
    }

    public final CntInfo copy(int i) {
        return new CntInfo(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CntInfo) && this.thumbNum == ((CntInfo) obj).thumbNum;
    }

    public int hashCode() {
        return this.thumbNum;
    }

    public String toString() {
        return "CntInfo(thumbNum=" + this.thumbNum + ")";
    }

    public CntInfo(int thumbNum) {
        this.thumbNum = thumbNum;
    }

    public /* synthetic */ CntInfo(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getThumbNum() {
        return this.thumbNum;
    }
}