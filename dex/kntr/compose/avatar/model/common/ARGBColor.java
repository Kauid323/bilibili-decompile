package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NativeDrawSpec.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, d2 = {"Lkntr/compose/avatar/model/common/ARGBColor;", "", "colorInt", "", "constructor-impl", "(I)I", "getColorInt", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@JvmInline
public final class ARGBColor {
    public static final Companion Companion = new Companion(null);
    private static final int Transparent = m2526constructorimpl(0);
    private final int colorInt;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ARGBColor m2525boximpl(int i) {
        return new ARGBColor(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2526constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2527equalsimpl(int i, Object obj) {
        return (obj instanceof ARGBColor) && i == ((ARGBColor) obj).m2531unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2528equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2529hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2530toStringimpl(int i) {
        return "ARGBColor(colorInt=" + i + ")";
    }

    public boolean equals(Object obj) {
        return m2527equalsimpl(this.colorInt, obj);
    }

    public int hashCode() {
        return m2529hashCodeimpl(this.colorInt);
    }

    public String toString() {
        return m2530toStringimpl(this.colorInt);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2531unboximpl() {
        return this.colorInt;
    }

    private /* synthetic */ ARGBColor(int colorInt) {
        this.colorInt = colorInt;
    }

    public final int getColorInt() {
        return this.colorInt;
    }

    /* compiled from: NativeDrawSpec.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkntr/compose/avatar/model/common/ARGBColor$Companion;", "", "<init>", "()V", "Transparent", "Lkntr/compose/avatar/model/common/ARGBColor;", "getTransparent-LQWBnzc", "()I", "I", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getTransparent-LQWBnzc  reason: not valid java name */
        public final int m2532getTransparentLQWBnzc() {
            return ARGBColor.Transparent;
        }
    }
}