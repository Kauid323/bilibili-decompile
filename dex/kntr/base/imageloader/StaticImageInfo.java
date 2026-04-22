package kntr.base.imageloader;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Image.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0019"}, d2 = {"Lkntr/base/imageloader/StaticImageInfo;", "", "size", "Landroidx/compose/ui/geometry/Size;", "byteSize", "", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-NH-jbRc", "()J", "J", "getByteSize", "component1", "component1-NH-jbRc", "component2", "copy", "copy-TmRCtEA", "(JJ)Lkntr/base/imageloader/StaticImageInfo;", "equals", "", "other", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class StaticImageInfo {
    public static final int $stable = 0;
    private final long byteSize;
    private final long size;

    public /* synthetic */ StaticImageInfo(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* renamed from: copy-TmRCtEA$default  reason: not valid java name */
    public static /* synthetic */ StaticImageInfo m1579copyTmRCtEA$default(StaticImageInfo staticImageInfo, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = staticImageInfo.size;
        }
        if ((i & 2) != 0) {
            j2 = staticImageInfo.byteSize;
        }
        return staticImageInfo.m1581copyTmRCtEA(j, j2);
    }

    /* renamed from: component1-NH-jbRc  reason: not valid java name */
    public final long m1580component1NHjbRc() {
        return this.size;
    }

    public final long component2() {
        return this.byteSize;
    }

    /* renamed from: copy-TmRCtEA  reason: not valid java name */
    public final StaticImageInfo m1581copyTmRCtEA(long j, long j2) {
        return new StaticImageInfo(j, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StaticImageInfo) {
            StaticImageInfo staticImageInfo = (StaticImageInfo) obj;
            return androidx.compose.ui.geometry.Size.equals-impl0(this.size, staticImageInfo.size) && this.byteSize == staticImageInfo.byteSize;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.compose.ui.geometry.Size.hashCode-impl(this.size) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.byteSize);
    }

    public String toString() {
        String str = androidx.compose.ui.geometry.Size.toString-impl(this.size);
        return "StaticImageInfo(size=" + str + ", byteSize=" + this.byteSize + ")";
    }

    private StaticImageInfo(long size, long byteSize) {
        this.size = size;
        this.byteSize = byteSize;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StaticImageInfo(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, null);
        long j3;
        long j4;
        if ((i & 1) == 0) {
            j3 = j;
        } else {
            j3 = androidx.compose.ui.geometry.Size.Companion.getUnspecified-NH-jbRc();
        }
        if ((i & 2) == 0) {
            j4 = j2;
        } else {
            j4 = 0;
        }
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public final long m1582getSizeNHjbRc() {
        return this.size;
    }

    public final long getByteSize() {
        return this.byteSize;
    }
}