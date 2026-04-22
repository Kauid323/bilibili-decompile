package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BfsProtocol.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, d2 = {"Lkntr/base/imageloader/Quality;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@JvmInline
public final class Quality {
    public static final Companion Companion = new Companion(null);
    private static final int Default = m1542constructorimpl(85);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Quality m1541boximpl(int i) {
        return new Quality(i);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1543equalsimpl(int i, Object obj) {
        return (obj instanceof Quality) && i == ((Quality) obj).m1547unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1544equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1545hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1546toStringimpl(int i) {
        return "Quality(value=" + i + ")";
    }

    public boolean equals(Object obj) {
        return m1543equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1545hashCodeimpl(this.value);
    }

    public String toString() {
        return m1546toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1547unboximpl() {
        return this.value;
    }

    private /* synthetic */ Quality(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1542constructorimpl(int value) {
        boolean z = false;
        if (value >= 0 && value < 101) {
            z = true;
        }
        if (z) {
            return value;
        }
        throw new IllegalArgumentException("quality must be in [0,100]".toString());
    }

    /* compiled from: BfsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkntr/base/imageloader/Quality$Companion;", "", "<init>", "()V", "Default", "Lkntr/base/imageloader/Quality;", "getDefault-Z1J5CoE", "()I", "I", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getDefault-Z1J5CoE  reason: not valid java name */
        public final int m1548getDefaultZ1J5CoE() {
            return Quality.Default;
        }
    }
}