package kntr.common.photonic;

import androidx.collection.DoubleList$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ContentSize.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005\u0088\u0001\u0002¨\u0006\""}, d2 = {"Lkntr/common/photonic/ContentSize;", "", "size", "", "constructor-impl", "(D)D", "getSize", "()D", "bytes", "getBytes-impl", "kilobytes", "getKilobytes-impl", "megabytes", "getMegabytes-impl", "plus", "other", "plus-mcnd5EU", "(DD)D", "div", "div-4yfSoQ8", "times", "factor", "times-zLmOkFI", "compareTo", "", "compareTo-4yfSoQ8", "(DD)I", "equals", "", "", "hashCode", "toString", "", "Companion", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@JvmInline
public final class ContentSize implements Comparable<ContentSize> {
    public static final Companion Companion = new Companion(null);
    private static final double UNKNOWN = m2183constructorimpl(-1.0d);
    private final double size;

    /* renamed from: box-impl */
    public static final /* synthetic */ ContentSize m2181boximpl(double d) {
        return new ContentSize(d);
    }

    /* renamed from: constructor-impl */
    public static double m2183constructorimpl(double d) {
        return d;
    }

    /* renamed from: equals-impl */
    public static boolean m2185equalsimpl(double d, Object obj) {
        return (obj instanceof ContentSize) && Double.compare(d, ((ContentSize) obj).m2195unboximpl()) == 0;
    }

    /* renamed from: equals-impl0 */
    public static final boolean m2186equalsimpl0(double d, double d2) {
        return Double.compare(d, d2) == 0;
    }

    /* renamed from: hashCode-impl */
    public static int m2190hashCodeimpl(double d) {
        return DoubleList$.ExternalSyntheticBackport0.m(d);
    }

    /* renamed from: toString-impl */
    public static String m2193toStringimpl(double d) {
        return "ContentSize(size=" + d + ")";
    }

    public boolean equals(Object obj) {
        return m2185equalsimpl(this.size, obj);
    }

    public int hashCode() {
        return m2190hashCodeimpl(this.size);
    }

    public String toString() {
        return m2193toStringimpl(this.size);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ double m2195unboximpl() {
        return this.size;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ContentSize contentSize) {
        return m2194compareTo4yfSoQ8(contentSize.m2195unboximpl());
    }

    private /* synthetic */ ContentSize(double size) {
        this.size = size;
    }

    public final double getSize() {
        return this.size;
    }

    /* compiled from: ContentSize.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkntr/common/photonic/ContentSize$Companion;", "", "<init>", "()V", "UNKNOWN", "Lkntr/common/photonic/ContentSize;", "getUNKNOWN-QJZHGII", "()D", "D", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUNKNOWN-QJZHGII */
        public final double m2196getUNKNOWNQJZHGII() {
            return ContentSize.UNKNOWN;
        }
    }

    /* renamed from: getBytes-impl */
    public static final double m2187getBytesimpl(double d) {
        return d;
    }

    /* renamed from: getKilobytes-impl */
    public static final double m2188getKilobytesimpl(double d) {
        return d / 1024;
    }

    /* renamed from: getMegabytes-impl */
    public static final double m2189getMegabytesimpl(double d) {
        return m2188getKilobytesimpl(d) / 1024;
    }

    /* renamed from: plus-mcnd5EU */
    public static final double m2191plusmcnd5EU(double d, double d2) {
        if (m2186equalsimpl0(d, UNKNOWN) || m2186equalsimpl0(d2, UNKNOWN)) {
            return UNKNOWN;
        }
        return m2183constructorimpl(d + d2);
    }

    /* renamed from: div-4yfSoQ8 */
    public static final double m2184div4yfSoQ8(double d, double d2) {
        if (m2186equalsimpl0(d, UNKNOWN) || m2186equalsimpl0(d2, UNKNOWN)) {
            return -1.0d;
        }
        return d / d2;
    }

    /* renamed from: times-zLmOkFI */
    public static final double m2192timeszLmOkFI(double d, double factor) {
        if (m2186equalsimpl0(d, UNKNOWN)) {
            return UNKNOWN;
        }
        return m2183constructorimpl(d * factor);
    }

    /* renamed from: compareTo-4yfSoQ8 */
    public static int m2182compareTo4yfSoQ8(double d, double d2) {
        return Double.compare(d, d2);
    }

    /* renamed from: compareTo-4yfSoQ8 */
    public int m2194compareTo4yfSoQ8(double other) {
        return m2182compareTo4yfSoQ8(this.size, other);
    }
}