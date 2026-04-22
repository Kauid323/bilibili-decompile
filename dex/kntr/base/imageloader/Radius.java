package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BfsProtocol.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\t\u001a\u00020\n*\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0013"}, d2 = {"Lkntr/base/imageloader/Radius;", "", "value", "", "constructor-impl", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isOdd", "", "isOdd-impl", "(Ljava/lang/Integer;I)Z", "equals", "other", "hashCode", "toString", "", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@JvmInline
public final class Radius {
    public static final Companion Companion = new Companion(null);
    private static final Integer UNSET = m1550constructorimpl(null);
    private final Integer value;

    /* renamed from: box-impl */
    public static final /* synthetic */ Radius m1549boximpl(Integer num) {
        return new Radius(num);
    }

    /* renamed from: equals-impl */
    public static boolean m1551equalsimpl(Integer num, Object obj) {
        return (obj instanceof Radius) && Intrinsics.areEqual(num, ((Radius) obj).m1556unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m1552equalsimpl0(Integer num, Integer num2) {
        return Intrinsics.areEqual(num, num2);
    }

    /* renamed from: hashCode-impl */
    public static int m1553hashCodeimpl(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m1555toStringimpl(Integer num) {
        return "Radius(value=" + num + ")";
    }

    public boolean equals(Object obj) {
        return m1551equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1553hashCodeimpl(this.value);
    }

    public String toString() {
        return m1555toStringimpl(this.value);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ Integer m1556unboximpl() {
        return this.value;
    }

    private /* synthetic */ Radius(Integer value) {
        this.value = value;
    }

    public final Integer getValue() {
        return this.value;
    }

    /* renamed from: constructor-impl */
    public static Integer m1550constructorimpl(Integer value) {
        boolean z = true;
        if (value != null) {
            int intValue = value.intValue();
            if (!(1 <= intValue && intValue < 51) || !m1554isOddimpl(value, value.intValue())) {
                z = false;
            }
        }
        if (z) {
            return value;
        }
        throw new IllegalArgumentException("radius must be in [1,50] and odd".toString());
    }

    /* compiled from: BfsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkntr/base/imageloader/Radius$Companion;", "", "<init>", "()V", "UNSET", "Lkntr/base/imageloader/Radius;", "getUNSET-tNbwJAw", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUNSET-tNbwJAw */
        public final Integer m1557getUNSETtNbwJAw() {
            return Radius.UNSET;
        }
    }

    /* renamed from: isOdd-impl */
    private static final boolean m1554isOddimpl(Integer num, int $this$isOdd) {
        return $this$isOdd % 2 == 1;
    }
}