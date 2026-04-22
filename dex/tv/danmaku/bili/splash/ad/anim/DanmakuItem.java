package tv.danmaku.bili.splash.ad.anim;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LandDanmakuView.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000e¨\u0006!"}, d2 = {"Ltv/danmaku/bili/splash/ad/anim/DanmakuItem;", "", "text", "", "textSize", "", "textColor", "index", "duration", "<init>", "(Ljava/lang/String;IIII)V", "getText", "()Ljava/lang/String;", "getTextSize", "()I", "getTextColor", "getIndex", "getDuration", "lineLocation", "getLineLocation", "appearTime", "getAppearTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "splashwidget_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DanmakuItem {
    public static final int $stable = 0;
    private final int duration;
    private final int index;
    private final String text;
    private final int textColor;
    private final int textSize;

    public DanmakuItem() {
        this(null, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ DanmakuItem copy$default(DanmakuItem danmakuItem, String str, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = danmakuItem.text;
        }
        if ((i5 & 2) != 0) {
            i = danmakuItem.textSize;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = danmakuItem.textColor;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = danmakuItem.index;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = danmakuItem.duration;
        }
        return danmakuItem.copy(str, i6, i7, i8, i4);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.textSize;
    }

    public final int component3() {
        return this.textColor;
    }

    public final int component4() {
        return this.index;
    }

    public final int component5() {
        return this.duration;
    }

    public final DanmakuItem copy(String str, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new DanmakuItem(str, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DanmakuItem) {
            DanmakuItem danmakuItem = (DanmakuItem) obj;
            return Intrinsics.areEqual(this.text, danmakuItem.text) && this.textSize == danmakuItem.textSize && this.textColor == danmakuItem.textColor && this.index == danmakuItem.index && this.duration == danmakuItem.duration;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.text.hashCode() * 31) + this.textSize) * 31) + this.textColor) * 31) + this.index) * 31) + this.duration;
    }

    public String toString() {
        String str = this.text;
        int i = this.textSize;
        int i2 = this.textColor;
        int i3 = this.index;
        return "DanmakuItem(text=" + str + ", textSize=" + i + ", textColor=" + i2 + ", index=" + i3 + ", duration=" + this.duration + ")";
    }

    public DanmakuItem(String text, int textSize, int textColor, int index, int duration) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.textSize = textSize;
        this.textColor = textColor;
        this.index = index;
        this.duration = duration;
    }

    public /* synthetic */ DanmakuItem(String str, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? 16 : i, (i5 & 4) != 0 ? -1 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4);
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getLineLocation() {
        int i = this.index % 6;
        switch (i + ((((i ^ 6) & ((-i) | i)) >> 31) & 6)) {
            case 0:
                return 1;
            case 1:
                return 4;
            case 2:
                return 5;
            case 3:
                return 3;
            case 4:
                return 6;
            default:
                return 2;
        }
    }

    public final int getAppearTime() {
        int offsetDelay;
        int round = this.index / 6;
        int roundDelay = round * 300 * 6;
        switch (getLineLocation()) {
            case 1:
                offsetDelay = 0;
                break;
            case 2:
            default:
                offsetDelay = 1500;
                break;
            case 3:
                offsetDelay = 900;
                break;
            case 4:
                offsetDelay = 300;
                break;
            case 5:
                offsetDelay = BR.subTitle;
                break;
            case 6:
                offsetDelay = 1200;
                break;
        }
        return roundDelay + offsetDelay;
    }
}