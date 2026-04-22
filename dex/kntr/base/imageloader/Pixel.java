package kntr.base.imageloader;

import androidx.compose.ui.unit.Density;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BfsProtocol.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, d2 = {"Lkntr/base/imageloader/Pixel;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@JvmInline
public final class Pixel {
    public static final Companion Companion = new Companion(null);
    private static final int UNSET = m1517constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Pixel m1516boximpl(int i) {
        return new Pixel(i);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1518equalsimpl(int i, Object obj) {
        return (obj instanceof Pixel) && i == ((Pixel) obj).m1522unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1519equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1520hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1521toStringimpl(int i) {
        return "Pixel(value=" + i + ")";
    }

    public boolean equals(Object obj) {
        return m1518equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1520hashCodeimpl(this.value);
    }

    public String toString() {
        return m1521toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1522unboximpl() {
        return this.value;
    }

    private /* synthetic */ Pixel(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1517constructorimpl(int value) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException("pixel must be >= 0".toString());
    }

    /* compiled from: BfsProtocol.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkntr/base/imageloader/Pixel$Companion;", "", "<init>", "()V", "UNSET", "Lkntr/base/imageloader/Pixel;", "getUNSET-uhUG8m8", "()I", "I", "toDp", "Landroidx/compose/ui/unit/Dp;", "density", "Landroidx/compose/ui/unit/Density;", "toDp-Q9s-Iyw", "(ILandroidx/compose/ui/unit/Density;)F", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUNSET-uhUG8m8  reason: not valid java name */
        public final int m1523getUNSETuhUG8m8() {
            return Pixel.UNSET;
        }

        /* renamed from: toDp-Q9s-Iyw  reason: not valid java name */
        public final float m1524toDpQ9sIyw(int i, Density density) {
            Intrinsics.checkNotNullParameter(density, "density");
            return density.toDp-u2uoSUM(i);
        }
    }
}