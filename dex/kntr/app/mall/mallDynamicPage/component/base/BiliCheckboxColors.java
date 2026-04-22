package kntr.app.mall.mallDynamicPage.component.base;

import androidx.compose.ui.graphics.Color;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CheckBoxComponent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001d\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001f\u0010\fJ\u0010\u0010 \u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b!\u0010\fJ\u0010\u0010\"\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b#\u0010\fJ\u0010\u0010$\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b%\u0010\fJ\u0010\u0010&\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b'\u0010\fJL\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\f¨\u00061"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/base/BiliCheckboxColors;", RoomRecommendViewModel.EMPTY_CURSOR, "activeCheckedBackground", "Landroidx/compose/ui/graphics/Color;", "activeCheckedMarkColor", "activeUncheckedBackground", "inactiveCheckedBackground", "inactiveCheckedMarkColor", "inactiveUncheckedBackground", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveCheckedBackground-0d7_KjU", "()J", "J", "getActiveCheckedMarkColor-0d7_KjU", "getActiveUncheckedBackground-0d7_KjU", "getInactiveCheckedBackground-0d7_KjU", "getInactiveCheckedMarkColor-0d7_KjU", "getInactiveUncheckedBackground-0d7_KjU", "getBackground", "checked", RoomRecommendViewModel.EMPTY_CURSOR, "active", "getBackground-WaAFU9c", "(ZZ)J", "getMarkColor", "getMarkColor-vNxB06k", "(Z)J", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Lkntr/app/mall/mallDynamicPage/component/base/BiliCheckboxColors;", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BiliCheckboxColors {
    public static final int $stable = 0;
    private final long activeCheckedBackground;
    private final long activeCheckedMarkColor;
    private final long activeUncheckedBackground;
    private final long inactiveCheckedBackground;
    private final long inactiveCheckedMarkColor;
    private final long inactiveUncheckedBackground;

    public /* synthetic */ BiliCheckboxColors(long j2, long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, j4, j5, j6, j7);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m2038component10d7_KjU() {
        return this.activeCheckedBackground;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m2039component20d7_KjU() {
        return this.activeCheckedMarkColor;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m2040component30d7_KjU() {
        return this.activeUncheckedBackground;
    }

    /* renamed from: component4-0d7_KjU  reason: not valid java name */
    public final long m2041component40d7_KjU() {
        return this.inactiveCheckedBackground;
    }

    /* renamed from: component5-0d7_KjU  reason: not valid java name */
    public final long m2042component50d7_KjU() {
        return this.inactiveCheckedMarkColor;
    }

    /* renamed from: component6-0d7_KjU  reason: not valid java name */
    public final long m2043component60d7_KjU() {
        return this.inactiveUncheckedBackground;
    }

    /* renamed from: copy-tNS2XkQ  reason: not valid java name */
    public final BiliCheckboxColors m2044copytNS2XkQ(long j2, long j3, long j4, long j5, long j6, long j7) {
        return new BiliCheckboxColors(j2, j3, j4, j5, j6, j7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiliCheckboxColors) {
            BiliCheckboxColors biliCheckboxColors = (BiliCheckboxColors) obj;
            return Color.equals-impl0(this.activeCheckedBackground, biliCheckboxColors.activeCheckedBackground) && Color.equals-impl0(this.activeCheckedMarkColor, biliCheckboxColors.activeCheckedMarkColor) && Color.equals-impl0(this.activeUncheckedBackground, biliCheckboxColors.activeUncheckedBackground) && Color.equals-impl0(this.inactiveCheckedBackground, biliCheckboxColors.inactiveCheckedBackground) && Color.equals-impl0(this.inactiveCheckedMarkColor, biliCheckboxColors.inactiveCheckedMarkColor) && Color.equals-impl0(this.inactiveUncheckedBackground, biliCheckboxColors.inactiveUncheckedBackground);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Color.hashCode-impl(this.activeCheckedBackground) * 31) + Color.hashCode-impl(this.activeCheckedMarkColor)) * 31) + Color.hashCode-impl(this.activeUncheckedBackground)) * 31) + Color.hashCode-impl(this.inactiveCheckedBackground)) * 31) + Color.hashCode-impl(this.inactiveCheckedMarkColor)) * 31) + Color.hashCode-impl(this.inactiveUncheckedBackground);
    }

    public String toString() {
        String str = Color.toString-impl(this.activeCheckedBackground);
        String str2 = Color.toString-impl(this.activeCheckedMarkColor);
        String str3 = Color.toString-impl(this.activeUncheckedBackground);
        String str4 = Color.toString-impl(this.inactiveCheckedBackground);
        String str5 = Color.toString-impl(this.inactiveCheckedMarkColor);
        return "BiliCheckboxColors(activeCheckedBackground=" + str + ", activeCheckedMarkColor=" + str2 + ", activeUncheckedBackground=" + str3 + ", inactiveCheckedBackground=" + str4 + ", inactiveCheckedMarkColor=" + str5 + ", inactiveUncheckedBackground=" + Color.toString-impl(this.inactiveUncheckedBackground) + ")";
    }

    private BiliCheckboxColors(long activeCheckedBackground, long activeCheckedMarkColor, long activeUncheckedBackground, long inactiveCheckedBackground, long inactiveCheckedMarkColor, long inactiveUncheckedBackground) {
        this.activeCheckedBackground = activeCheckedBackground;
        this.activeCheckedMarkColor = activeCheckedMarkColor;
        this.activeUncheckedBackground = activeUncheckedBackground;
        this.inactiveCheckedBackground = inactiveCheckedBackground;
        this.inactiveCheckedMarkColor = inactiveCheckedMarkColor;
        this.inactiveUncheckedBackground = inactiveUncheckedBackground;
    }

    /* renamed from: getActiveCheckedBackground-0d7_KjU  reason: not valid java name */
    public final long m2045getActiveCheckedBackground0d7_KjU() {
        return this.activeCheckedBackground;
    }

    /* renamed from: getActiveCheckedMarkColor-0d7_KjU  reason: not valid java name */
    public final long m2046getActiveCheckedMarkColor0d7_KjU() {
        return this.activeCheckedMarkColor;
    }

    /* renamed from: getActiveUncheckedBackground-0d7_KjU  reason: not valid java name */
    public final long m2047getActiveUncheckedBackground0d7_KjU() {
        return this.activeUncheckedBackground;
    }

    /* renamed from: getInactiveCheckedBackground-0d7_KjU  reason: not valid java name */
    public final long m2049getInactiveCheckedBackground0d7_KjU() {
        return this.inactiveCheckedBackground;
    }

    /* renamed from: getInactiveCheckedMarkColor-0d7_KjU  reason: not valid java name */
    public final long m2050getInactiveCheckedMarkColor0d7_KjU() {
        return this.inactiveCheckedMarkColor;
    }

    /* renamed from: getInactiveUncheckedBackground-0d7_KjU  reason: not valid java name */
    public final long m2051getInactiveUncheckedBackground0d7_KjU() {
        return this.inactiveUncheckedBackground;
    }

    /* renamed from: getBackground-WaAFU9c  reason: not valid java name */
    public final long m2048getBackgroundWaAFU9c(boolean checked, boolean active) {
        return (checked && active) ? this.activeCheckedBackground : (!checked || active) ? (checked || !active) ? this.inactiveUncheckedBackground : this.activeUncheckedBackground : this.inactiveCheckedBackground;
    }

    /* renamed from: getMarkColor-vNxB06k  reason: not valid java name */
    public final long m2052getMarkColorvNxB06k(boolean active) {
        if (active) {
            return this.activeCheckedMarkColor;
        }
        if (active) {
            throw new NoWhenBranchMatchedException();
        }
        return this.inactiveCheckedMarkColor;
    }
}