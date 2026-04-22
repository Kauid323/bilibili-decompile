package kntr.app.game.steam.chart;

import BottomSheetItemData$;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarChart.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0010\u00107\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b8\u0010 J\u0010\u00109\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b:\u0010 J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\u0010\u0010=\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b>\u0010 J\u0010\u0010?\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b@\u0010 J\t\u0010A\u001a\u00020\fHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\t\u0010D\u001a\u00020\fHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\bFJ\u0010\u0010G\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\bH\u0010$JÀ\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\bJ\u0010KJ\u0013\u0010L\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020OHÖ\u0001J\t\u0010P\u001a\u00020QHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\n\u001a\u00020\t¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u000e\u001a\u00020\t¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0016\u001a\u00020\u0015¢\u0006\n\n\u0002\u00101\u001a\u0004\b0\u0010$¨\u0006R"}, d2 = {"Lkntr/app/game/steam/chart/BarChartConfig;", RoomRecommendViewModel.EMPTY_CURSOR, "showGrid", RoomRecommendViewModel.EMPTY_CURSOR, "showHorizontalGrid", "showVerticalGrid", "showAxisLabels", "showValueLabels", "gridColor", "Landroidx/compose/ui/graphics/Color;", "axisColor", "labelTextSize", RoomRecommendViewModel.EMPTY_CURSOR, "valueTextSize", "labelTextColor", "valueTextColor", "barWidth", "maxValue", "minValue", "barCornerRadius", "chartWidth", "Landroidx/compose/ui/unit/Dp;", "chartHeight", "<init>", "(ZZZZZJJFFJJFLjava/lang/Float;Ljava/lang/Float;FLandroidx/compose/ui/unit/Dp;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getShowGrid", "()Z", "getShowHorizontalGrid", "getShowVerticalGrid", "getShowAxisLabels", "getShowValueLabels", "getGridColor-0d7_KjU", "()J", "J", "getAxisColor-0d7_KjU", "getLabelTextSize", "()F", "getValueTextSize", "getLabelTextColor-0d7_KjU", "getValueTextColor-0d7_KjU", "getBarWidth", "getMaxValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMinValue", "getBarCornerRadius", "getChartWidth-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "getChartHeight-D9Ej5fM", "F", "component1", "component2", "component3", "component4", "component5", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "component8", "component9", "component10", "component10-0d7_KjU", "component11", "component11-0d7_KjU", "component12", "component13", "component14", "component15", "component16", "component16-lTKBWiU", "component17", "component17-D9Ej5fM", "copy", "copy-zsaAYUU", "(ZZZZZJJFFJJFLjava/lang/Float;Ljava/lang/Float;FLandroidx/compose/ui/unit/Dp;F)Lkntr/app/game/steam/chart/BarChartConfig;", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BarChartConfig {
    public static final int $stable = 0;
    private final long axisColor;
    private final float barCornerRadius;
    private final float barWidth;
    private final float chartHeight;
    private final Dp chartWidth;
    private final long gridColor;
    private final long labelTextColor;
    private final float labelTextSize;
    private final Float maxValue;
    private final Float minValue;
    private final boolean showAxisLabels;
    private final boolean showGrid;
    private final boolean showHorizontalGrid;
    private final boolean showValueLabels;
    private final boolean showVerticalGrid;
    private final long valueTextColor;
    private final float valueTextSize;

    public /* synthetic */ BarChartConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, long j2, long j3, float f, float f2, long j4, long j5, float f3, Float f4, Float f5, float f6, Dp dp, float f7, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, z3, z4, z5, j2, j3, f, f2, j4, j5, f3, f4, f5, f6, dp, f7);
    }

    public final boolean component1() {
        return this.showGrid;
    }

    /* renamed from: component10-0d7_KjU  reason: not valid java name */
    public final long m1327component100d7_KjU() {
        return this.labelTextColor;
    }

    /* renamed from: component11-0d7_KjU  reason: not valid java name */
    public final long m1328component110d7_KjU() {
        return this.valueTextColor;
    }

    public final float component12() {
        return this.barWidth;
    }

    public final Float component13() {
        return this.maxValue;
    }

    public final Float component14() {
        return this.minValue;
    }

    public final float component15() {
        return this.barCornerRadius;
    }

    /* renamed from: component16-lTKBWiU  reason: not valid java name */
    public final Dp m1329component16lTKBWiU() {
        return this.chartWidth;
    }

    /* renamed from: component17-D9Ej5fM  reason: not valid java name */
    public final float m1330component17D9Ej5fM() {
        return this.chartHeight;
    }

    public final boolean component2() {
        return this.showHorizontalGrid;
    }

    public final boolean component3() {
        return this.showVerticalGrid;
    }

    public final boolean component4() {
        return this.showAxisLabels;
    }

    public final boolean component5() {
        return this.showValueLabels;
    }

    /* renamed from: component6-0d7_KjU  reason: not valid java name */
    public final long m1331component60d7_KjU() {
        return this.gridColor;
    }

    /* renamed from: component7-0d7_KjU  reason: not valid java name */
    public final long m1332component70d7_KjU() {
        return this.axisColor;
    }

    public final float component8() {
        return this.labelTextSize;
    }

    public final float component9() {
        return this.valueTextSize;
    }

    /* renamed from: copy-zsaAYUU  reason: not valid java name */
    public final BarChartConfig m1333copyzsaAYUU(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, long j2, long j3, float f, float f2, long j4, long j5, float f3, Float f4, Float f5, float f6, Dp dp, float f7) {
        return new BarChartConfig(z, z2, z3, z4, z5, j2, j3, f, f2, j4, j5, f3, f4, f5, f6, dp, f7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BarChartConfig) {
            BarChartConfig barChartConfig = (BarChartConfig) obj;
            return this.showGrid == barChartConfig.showGrid && this.showHorizontalGrid == barChartConfig.showHorizontalGrid && this.showVerticalGrid == barChartConfig.showVerticalGrid && this.showAxisLabels == barChartConfig.showAxisLabels && this.showValueLabels == barChartConfig.showValueLabels && Color.equals-impl0(this.gridColor, barChartConfig.gridColor) && Color.equals-impl0(this.axisColor, barChartConfig.axisColor) && Float.compare(this.labelTextSize, barChartConfig.labelTextSize) == 0 && Float.compare(this.valueTextSize, barChartConfig.valueTextSize) == 0 && Color.equals-impl0(this.labelTextColor, barChartConfig.labelTextColor) && Color.equals-impl0(this.valueTextColor, barChartConfig.valueTextColor) && Float.compare(this.barWidth, barChartConfig.barWidth) == 0 && Intrinsics.areEqual(this.maxValue, barChartConfig.maxValue) && Intrinsics.areEqual(this.minValue, barChartConfig.minValue) && Float.compare(this.barCornerRadius, barChartConfig.barCornerRadius) == 0 && Intrinsics.areEqual(this.chartWidth, barChartConfig.chartWidth) && Dp.equals-impl0(this.chartHeight, barChartConfig.chartHeight);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showGrid) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showHorizontalGrid)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showVerticalGrid)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showAxisLabels)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showValueLabels)) * 31) + Color.hashCode-impl(this.gridColor)) * 31) + Color.hashCode-impl(this.axisColor)) * 31) + Float.floatToIntBits(this.labelTextSize)) * 31) + Float.floatToIntBits(this.valueTextSize)) * 31) + Color.hashCode-impl(this.labelTextColor)) * 31) + Color.hashCode-impl(this.valueTextColor)) * 31) + Float.floatToIntBits(this.barWidth)) * 31) + (this.maxValue == null ? 0 : this.maxValue.hashCode())) * 31) + (this.minValue == null ? 0 : this.minValue.hashCode())) * 31) + Float.floatToIntBits(this.barCornerRadius)) * 31) + (this.chartWidth != null ? Dp.hashCode-impl(this.chartWidth.unbox-impl()) : 0)) * 31) + Dp.hashCode-impl(this.chartHeight);
    }

    public String toString() {
        boolean z = this.showGrid;
        boolean z2 = this.showHorizontalGrid;
        boolean z3 = this.showVerticalGrid;
        boolean z4 = this.showAxisLabels;
        boolean z5 = this.showValueLabels;
        String str = Color.toString-impl(this.gridColor);
        String str2 = Color.toString-impl(this.axisColor);
        float f = this.labelTextSize;
        float f2 = this.valueTextSize;
        String str3 = Color.toString-impl(this.labelTextColor);
        String str4 = Color.toString-impl(this.valueTextColor);
        float f3 = this.barWidth;
        Float f4 = this.maxValue;
        Float f5 = this.minValue;
        float f6 = this.barCornerRadius;
        Dp dp = this.chartWidth;
        return "BarChartConfig(showGrid=" + z + ", showHorizontalGrid=" + z2 + ", showVerticalGrid=" + z3 + ", showAxisLabels=" + z4 + ", showValueLabels=" + z5 + ", gridColor=" + str + ", axisColor=" + str2 + ", labelTextSize=" + f + ", valueTextSize=" + f2 + ", labelTextColor=" + str3 + ", valueTextColor=" + str4 + ", barWidth=" + f3 + ", maxValue=" + f4 + ", minValue=" + f5 + ", barCornerRadius=" + f6 + ", chartWidth=" + dp + ", chartHeight=" + Dp.toString-impl(this.chartHeight) + ")";
    }

    private BarChartConfig(boolean showGrid, boolean showHorizontalGrid, boolean showVerticalGrid, boolean showAxisLabels, boolean showValueLabels, long gridColor, long axisColor, float labelTextSize, float valueTextSize, long labelTextColor, long valueTextColor, float barWidth, Float maxValue, Float minValue, float barCornerRadius, Dp chartWidth, float chartHeight) {
        this.showGrid = showGrid;
        this.showHorizontalGrid = showHorizontalGrid;
        this.showVerticalGrid = showVerticalGrid;
        this.showAxisLabels = showAxisLabels;
        this.showValueLabels = showValueLabels;
        this.gridColor = gridColor;
        this.axisColor = axisColor;
        this.labelTextSize = labelTextSize;
        this.valueTextSize = valueTextSize;
        this.labelTextColor = labelTextColor;
        this.valueTextColor = valueTextColor;
        this.barWidth = barWidth;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.barCornerRadius = barCornerRadius;
        this.chartWidth = chartWidth;
        this.chartHeight = chartHeight;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BarChartConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, long j2, long j3, float f, float f2, long j4, long j5, float f3, Float f4, Float f5, float f6, Dp dp, float f7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, r2, r6, r8, r10, r11, r12, r16, r14, r19, r20, r22, r18, r0, null);
        float f8;
        float f9;
        boolean z6 = (i & 1) != 0 ? true : z;
        boolean z7 = (i & 2) != 0 ? true : z2;
        boolean z8 = (i & 4) != 0 ? true : z3;
        boolean z9 = (i & 8) != 0 ? true : z4;
        boolean z10 = (i & 16) == 0 ? z5 : true;
        long j6 = (i & 32) != 0 ? Color.Companion.getLightGray-0d7_KjU() : j2;
        long j7 = (i & 64) != 0 ? Color.Companion.getBlack-0d7_KjU() : j3;
        float f10 = (i & 128) != 0 ? 12.0f : f;
        float f11 = (i & 256) != 0 ? 10.0f : f2;
        long j8 = (i & 512) != 0 ? Color.Companion.getBlack-0d7_KjU() : j4;
        long j9 = (i & 1024) != 0 ? Color.Companion.getBlack-0d7_KjU() : j5;
        float f12 = (i & 2048) != 0 ? 0.7f : f3;
        Float f13 = (i & 4096) != 0 ? null : f4;
        Float f14 = (i & 8192) != 0 ? null : f5;
        float f15 = (i & 16384) != 0 ? 0.0f : f6;
        Dp dp2 = (i & 32768) == 0 ? dp : null;
        if ((i & 65536) != 0) {
            f8 = f15;
            f9 = Dp.constructor-impl(300);
        } else {
            f8 = f15;
            f9 = f7;
        }
    }

    public final boolean getShowGrid() {
        return this.showGrid;
    }

    public final boolean getShowHorizontalGrid() {
        return this.showHorizontalGrid;
    }

    public final boolean getShowVerticalGrid() {
        return this.showVerticalGrid;
    }

    public final boolean getShowAxisLabels() {
        return this.showAxisLabels;
    }

    public final boolean getShowValueLabels() {
        return this.showValueLabels;
    }

    /* renamed from: getGridColor-0d7_KjU  reason: not valid java name */
    public final long m1337getGridColor0d7_KjU() {
        return this.gridColor;
    }

    /* renamed from: getAxisColor-0d7_KjU  reason: not valid java name */
    public final long m1334getAxisColor0d7_KjU() {
        return this.axisColor;
    }

    public final float getLabelTextSize() {
        return this.labelTextSize;
    }

    public final float getValueTextSize() {
        return this.valueTextSize;
    }

    /* renamed from: getLabelTextColor-0d7_KjU  reason: not valid java name */
    public final long m1338getLabelTextColor0d7_KjU() {
        return this.labelTextColor;
    }

    /* renamed from: getValueTextColor-0d7_KjU  reason: not valid java name */
    public final long m1339getValueTextColor0d7_KjU() {
        return this.valueTextColor;
    }

    public final float getBarWidth() {
        return this.barWidth;
    }

    public final Float getMaxValue() {
        return this.maxValue;
    }

    public final Float getMinValue() {
        return this.minValue;
    }

    public final float getBarCornerRadius() {
        return this.barCornerRadius;
    }

    /* renamed from: getChartWidth-lTKBWiU  reason: not valid java name */
    public final Dp m1336getChartWidthlTKBWiU() {
        return this.chartWidth;
    }

    /* renamed from: getChartHeight-D9Ej5fM  reason: not valid java name */
    public final float m1335getChartHeightD9Ej5fM() {
        return this.chartHeight;
    }
}