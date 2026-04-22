package kntr.common.ouro.core.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroSelection.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0018"}, d2 = {"Lkntr/common/ouro/core/model/OuroPoint;", "", "index", "", "offset", "<init>", "(II)V", "getIndex", "()I", "getOffset", "compareTo", "other", "isInside", "", "()Z", "component1", "component2", "copy", "equals", "", "hashCode", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroPoint implements Comparable<OuroPoint> {
    public static final Companion Companion = new Companion(null);
    private static final OuroPoint Zero = new OuroPoint(0, 0);
    private final int index;
    private final int offset;

    public static /* synthetic */ OuroPoint copy$default(OuroPoint ouroPoint, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ouroPoint.index;
        }
        if ((i3 & 2) != 0) {
            i2 = ouroPoint.offset;
        }
        return ouroPoint.copy(i, i2);
    }

    public final int component1() {
        return this.index;
    }

    public final int component2() {
        return this.offset;
    }

    public final OuroPoint copy(int i, int i2) {
        return new OuroPoint(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroPoint) {
            OuroPoint ouroPoint = (OuroPoint) obj;
            return this.index == ouroPoint.index && this.offset == ouroPoint.offset;
        }
        return false;
    }

    public int hashCode() {
        return (this.index * 31) + this.offset;
    }

    public String toString() {
        int i = this.index;
        return "OuroPoint(index=" + i + ", offset=" + this.offset + ")";
    }

    public OuroPoint(int index, int offset) {
        this.index = index;
        this.offset = offset;
    }

    public /* synthetic */ OuroPoint(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getOffset() {
        return this.offset;
    }

    /* compiled from: OuroSelection.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/common/ouro/core/model/OuroPoint$Companion;", "", "<init>", "()V", "Zero", "Lkntr/common/ouro/core/model/OuroPoint;", "getZero", "()Lkntr/common/ouro/core/model/OuroPoint;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OuroPoint getZero() {
            return OuroPoint.Zero;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(OuroPoint other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(this, other)) {
            return 0;
        }
        if (this.index > other.index) {
            return 1;
        }
        if (this.index < other.index) {
            return -1;
        }
        return Intrinsics.compare(this.offset, other.offset);
    }

    public final boolean isInside() {
        return this.offset > 0;
    }
}