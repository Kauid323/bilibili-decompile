package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BiliImageOptions.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2 = {"Lkntr/base/imageloader/Alpha;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@JvmInline
public final class Alpha {
    public static final Companion Companion = new Companion(null);
    private static final float UNSET = m1401constructorimpl(1.0f);
    private final float value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Alpha m1400boximpl(float f) {
        return new Alpha(f);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1402equalsimpl(float f, Object obj) {
        return (obj instanceof Alpha) && Float.compare(f, ((Alpha) obj).m1406unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1403equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1404hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1405toStringimpl(float f) {
        return "Alpha(value=" + f + ")";
    }

    public boolean equals(Object obj) {
        return m1402equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1404hashCodeimpl(this.value);
    }

    public String toString() {
        return m1405toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float m1406unboximpl() {
        return this.value;
    }

    private /* synthetic */ Alpha(float value) {
        this.value = value;
    }

    public final float getValue() {
        return this.value;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float m1401constructorimpl(float value) {
        boolean z = false;
        if (0.0f <= value && value <= 1.0f) {
            z = true;
        }
        if (z) {
            return value;
        }
        throw new IllegalArgumentException("alpha must be in [0,1]".toString());
    }

    /* compiled from: BiliImageOptions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkntr/base/imageloader/Alpha$Companion;", "", "<init>", "()V", "UNSET", "Lkntr/base/imageloader/Alpha;", "getUNSET-_AzBSks", "()F", "F", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUNSET-_AzBSks  reason: not valid java name */
        public final float m1407getUNSET_AzBSks() {
            return Alpha.UNSET;
        }
    }
}