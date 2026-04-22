package tv.danmaku.bili.splash.ad.anim;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LandDanmakuView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/splash/ad/anim/DanmakuData;", "", "list", "", "Ltv/danmaku/bili/splash/ad/anim/DanmakuItem;", "maxLine", "", "containerHeightPx", "containerWidthPx", "<init>", "(Ljava/util/List;III)V", "getList", "()Ljava/util/List;", "getMaxLine", "()I", "getContainerHeightPx", "getContainerWidthPx", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "splashwidget_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DanmakuData {
    public static final int $stable = 8;
    private final int containerHeightPx;
    private final int containerWidthPx;
    private final List<DanmakuItem> list;
    private final int maxLine;

    public DanmakuData() {
        this(null, 0, 0, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DanmakuData copy$default(DanmakuData danmakuData, List list, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = danmakuData.list;
        }
        if ((i4 & 2) != 0) {
            i = danmakuData.maxLine;
        }
        if ((i4 & 4) != 0) {
            i2 = danmakuData.containerHeightPx;
        }
        if ((i4 & 8) != 0) {
            i3 = danmakuData.containerWidthPx;
        }
        return danmakuData.copy(list, i, i2, i3);
    }

    public final List<DanmakuItem> component1() {
        return this.list;
    }

    public final int component2() {
        return this.maxLine;
    }

    public final int component3() {
        return this.containerHeightPx;
    }

    public final int component4() {
        return this.containerWidthPx;
    }

    public final DanmakuData copy(List<DanmakuItem> list, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new DanmakuData(list, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DanmakuData) {
            DanmakuData danmakuData = (DanmakuData) obj;
            return Intrinsics.areEqual(this.list, danmakuData.list) && this.maxLine == danmakuData.maxLine && this.containerHeightPx == danmakuData.containerHeightPx && this.containerWidthPx == danmakuData.containerWidthPx;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.list.hashCode() * 31) + this.maxLine) * 31) + this.containerHeightPx) * 31) + this.containerWidthPx;
    }

    public String toString() {
        List<DanmakuItem> list = this.list;
        int i = this.maxLine;
        int i2 = this.containerHeightPx;
        return "DanmakuData(list=" + list + ", maxLine=" + i + ", containerHeightPx=" + i2 + ", containerWidthPx=" + this.containerWidthPx + ")";
    }

    public DanmakuData(List<DanmakuItem> list, int maxLine, int containerHeightPx, int containerWidthPx) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.maxLine = maxLine;
        this.containerHeightPx = containerHeightPx;
        this.containerWidthPx = containerWidthPx;
    }

    public /* synthetic */ DanmakuData(List list, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? CollectionsKt.emptyList() : list, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public final List<DanmakuItem> getList() {
        return this.list;
    }

    public final int getMaxLine() {
        return this.maxLine;
    }

    public final int getContainerHeightPx() {
        return this.containerHeightPx;
    }

    public final int getContainerWidthPx() {
        return this.containerWidthPx;
    }
}