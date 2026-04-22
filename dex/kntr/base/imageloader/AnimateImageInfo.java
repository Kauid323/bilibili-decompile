package kntr.base.imageloader;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Image.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lkntr/base/imageloader/AnimateImageInfo;", "", "size", "Landroidx/compose/ui/geometry/Size;", "frameCount", "", "byteSize", "", "<init>", "(JIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-NH-jbRc", "()J", "J", "getFrameCount", "()I", "getByteSize", "component1", "component1-NH-jbRc", "component2", "component3", "copy", "copy-Pq9zytI", "(JIJ)Lkntr/base/imageloader/AnimateImageInfo;", "equals", "", "other", "hashCode", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AnimateImageInfo {
    public static final int $stable = 0;
    private final long byteSize;
    private final int frameCount;
    private final long size;

    public /* synthetic */ AnimateImageInfo(long j, int i, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, j2);
    }

    /* renamed from: copy-Pq9zytI$default  reason: not valid java name */
    public static /* synthetic */ AnimateImageInfo m1410copyPq9zytI$default(AnimateImageInfo animateImageInfo, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = animateImageInfo.size;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            i = animateImageInfo.frameCount;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j2 = animateImageInfo.byteSize;
        }
        return animateImageInfo.m1412copyPq9zytI(j3, i3, j2);
    }

    /* renamed from: component1-NH-jbRc  reason: not valid java name */
    public final long m1411component1NHjbRc() {
        return this.size;
    }

    public final int component2() {
        return this.frameCount;
    }

    public final long component3() {
        return this.byteSize;
    }

    /* renamed from: copy-Pq9zytI  reason: not valid java name */
    public final AnimateImageInfo m1412copyPq9zytI(long j, int i, long j2) {
        return new AnimateImageInfo(j, i, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnimateImageInfo) {
            AnimateImageInfo animateImageInfo = (AnimateImageInfo) obj;
            return androidx.compose.ui.geometry.Size.equals-impl0(this.size, animateImageInfo.size) && this.frameCount == animateImageInfo.frameCount && this.byteSize == animateImageInfo.byteSize;
        }
        return false;
    }

    public int hashCode() {
        return (((androidx.compose.ui.geometry.Size.hashCode-impl(this.size) * 31) + this.frameCount) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.byteSize);
    }

    public String toString() {
        String str = androidx.compose.ui.geometry.Size.toString-impl(this.size);
        int i = this.frameCount;
        return "AnimateImageInfo(size=" + str + ", frameCount=" + i + ", byteSize=" + this.byteSize + ")";
    }

    private AnimateImageInfo(long size, int frameCount, long byteSize) {
        this.size = size;
        this.frameCount = frameCount;
        this.byteSize = byteSize;
    }

    public /* synthetic */ AnimateImageInfo(long j, int i, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? androidx.compose.ui.geometry.Size.Companion.getUnspecified-NH-jbRc() : j, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0L : j2, null);
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public final long m1413getSizeNHjbRc() {
        return this.size;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final long getByteSize() {
        return this.byteSize;
    }
}