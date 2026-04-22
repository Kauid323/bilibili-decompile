package kntr.common.trio.p000switch;

import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SimpleSwitch.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Lkntr/common/trio/switch/SimpleSwitchSize;", "", "thumbSize", "Landroidx/compose/ui/unit/Dp;", "padding", "width", "height", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getThumbSize-D9Ej5fM", "()F", "F", "getPadding-D9Ej5fM", "getWidth-D9Ej5fM", "getHeight-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "copy", "copy-a9UjIt4", "(FFFF)Lkntr/common/trio/switch/SimpleSwitchSize;", "equals", "", "other", "hashCode", "", "toString", "", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
/* renamed from: kntr.common.trio.switch.SimpleSwitchSize  reason: invalid package */
public final class SimpleSwitchSize {
    public static final int $stable = 0;
    private final float height;
    private final float padding;
    private final float thumbSize;
    private final float width;

    public /* synthetic */ SimpleSwitchSize(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    /* renamed from: copy-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ SimpleSwitchSize m2443copya9UjIt4$default(SimpleSwitchSize simpleSwitchSize, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = simpleSwitchSize.thumbSize;
        }
        if ((i & 2) != 0) {
            f2 = simpleSwitchSize.padding;
        }
        if ((i & 4) != 0) {
            f3 = simpleSwitchSize.width;
        }
        if ((i & 8) != 0) {
            f4 = simpleSwitchSize.height;
        }
        return simpleSwitchSize.m2448copya9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m2444component1D9Ej5fM() {
        return this.thumbSize;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m2445component2D9Ej5fM() {
        return this.padding;
    }

    /* renamed from: component3-D9Ej5fM  reason: not valid java name */
    public final float m2446component3D9Ej5fM() {
        return this.width;
    }

    /* renamed from: component4-D9Ej5fM  reason: not valid java name */
    public final float m2447component4D9Ej5fM() {
        return this.height;
    }

    /* renamed from: copy-a9UjIt4  reason: not valid java name */
    public final SimpleSwitchSize m2448copya9UjIt4(float f, float f2, float f3, float f4) {
        return new SimpleSwitchSize(f, f2, f3, f4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleSwitchSize) {
            SimpleSwitchSize simpleSwitchSize = (SimpleSwitchSize) obj;
            return Dp.equals-impl0(this.thumbSize, simpleSwitchSize.thumbSize) && Dp.equals-impl0(this.padding, simpleSwitchSize.padding) && Dp.equals-impl0(this.width, simpleSwitchSize.width) && Dp.equals-impl0(this.height, simpleSwitchSize.height);
        }
        return false;
    }

    public int hashCode() {
        return (((((Dp.hashCode-impl(this.thumbSize) * 31) + Dp.hashCode-impl(this.padding)) * 31) + Dp.hashCode-impl(this.width)) * 31) + Dp.hashCode-impl(this.height);
    }

    public String toString() {
        String str = Dp.toString-impl(this.thumbSize);
        String str2 = Dp.toString-impl(this.padding);
        String str3 = Dp.toString-impl(this.width);
        return "SimpleSwitchSize(thumbSize=" + str + ", padding=" + str2 + ", width=" + str3 + ", height=" + Dp.toString-impl(this.height) + ")";
    }

    private SimpleSwitchSize(float thumbSize, float padding, float width, float height) {
        this.thumbSize = thumbSize;
        this.padding = padding;
        this.width = width;
        this.height = height;
    }

    public /* synthetic */ SimpleSwitchSize(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.constructor-impl(14) : f, (i & 2) != 0 ? Dp.constructor-impl(3) : f2, (i & 4) != 0 ? Dp.constructor-impl(32) : f3, (i & 8) != 0 ? Dp.constructor-impl(20) : f4, null);
    }

    /* renamed from: getThumbSize-D9Ej5fM  reason: not valid java name */
    public final float m2451getThumbSizeD9Ej5fM() {
        return this.thumbSize;
    }

    /* renamed from: getPadding-D9Ej5fM  reason: not valid java name */
    public final float m2450getPaddingD9Ej5fM() {
        return this.padding;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m2452getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m2449getHeightD9Ej5fM() {
        return this.height;
    }
}