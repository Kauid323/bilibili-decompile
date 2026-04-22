package kntr.app.ad.ui.uikit.components;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdTagText.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\fJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\fJ8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\f¨\u0006#"}, d2 = {"Lkntr/app/ad/ui/uikit/components/AdTagTextStyle;", RoomRecommendViewModel.EMPTY_CURSOR, "titleFontSize", "Landroidx/compose/ui/unit/TextUnit;", "titleLineHeight", "titleFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "titleTextColor", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JJLandroidx/compose/ui/text/font/FontWeight;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTitleFontSize-XSAIIZE", "()J", "J", "getTitleLineHeight-XSAIIZE", "getTitleFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getTitleTextColor-0d7_KjU", "component1", "component1-XSAIIZE", "component2", "component2-XSAIIZE", "component3", "component4", "component4-0d7_KjU", "copy", "copy-qyWbWHw", "(JJLandroidx/compose/ui/text/font/FontWeight;J)Lkntr/app/ad/ui/uikit/components/AdTagTextStyle;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdTagTextStyle {
    public static final int $stable = 0;
    private final long titleFontSize;
    private final FontWeight titleFontWeight;
    private final long titleLineHeight;
    private final long titleTextColor;

    public /* synthetic */ AdTagTextStyle(long j2, long j3, FontWeight fontWeight, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, fontWeight, j4);
    }

    /* renamed from: component1-XSAIIZE  reason: not valid java name */
    public final long m489component1XSAIIZE() {
        return this.titleFontSize;
    }

    /* renamed from: component2-XSAIIZE  reason: not valid java name */
    public final long m490component2XSAIIZE() {
        return this.titleLineHeight;
    }

    public final FontWeight component3() {
        return this.titleFontWeight;
    }

    /* renamed from: component4-0d7_KjU  reason: not valid java name */
    public final long m491component40d7_KjU() {
        return this.titleTextColor;
    }

    /* renamed from: copy-qyWbWHw  reason: not valid java name */
    public final AdTagTextStyle m492copyqyWbWHw(long j2, long j3, FontWeight fontWeight, long j4) {
        Intrinsics.checkNotNullParameter(fontWeight, "titleFontWeight");
        return new AdTagTextStyle(j2, j3, fontWeight, j4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTagTextStyle) {
            AdTagTextStyle adTagTextStyle = (AdTagTextStyle) obj;
            return TextUnit.equals-impl0(this.titleFontSize, adTagTextStyle.titleFontSize) && TextUnit.equals-impl0(this.titleLineHeight, adTagTextStyle.titleLineHeight) && Intrinsics.areEqual(this.titleFontWeight, adTagTextStyle.titleFontWeight) && Color.equals-impl0(this.titleTextColor, adTagTextStyle.titleTextColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((TextUnit.hashCode-impl(this.titleFontSize) * 31) + TextUnit.hashCode-impl(this.titleLineHeight)) * 31) + this.titleFontWeight.hashCode()) * 31) + Color.hashCode-impl(this.titleTextColor);
    }

    public String toString() {
        String str = TextUnit.toString-impl(this.titleFontSize);
        String str2 = TextUnit.toString-impl(this.titleLineHeight);
        FontWeight fontWeight = this.titleFontWeight;
        return "AdTagTextStyle(titleFontSize=" + str + ", titleLineHeight=" + str2 + ", titleFontWeight=" + fontWeight + ", titleTextColor=" + Color.toString-impl(this.titleTextColor) + ")";
    }

    private AdTagTextStyle(long titleFontSize, long titleLineHeight, FontWeight titleFontWeight, long titleTextColor) {
        Intrinsics.checkNotNullParameter(titleFontWeight, "titleFontWeight");
        this.titleFontSize = titleFontSize;
        this.titleLineHeight = titleLineHeight;
        this.titleFontWeight = titleFontWeight;
        this.titleTextColor = titleTextColor;
    }

    public /* synthetic */ AdTagTextStyle(long j2, long j3, FontWeight fontWeight, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TextUnitKt.getSp(16) : j2, (i & 2) != 0 ? TextUnitKt.getSp(20) : j3, (i & 4) != 0 ? FontWeight.Companion.getW500() : fontWeight, (i & 8) != 0 ? ColorKt.Color(4279769372L) : j4, null);
    }

    /* renamed from: getTitleFontSize-XSAIIZE  reason: not valid java name */
    public final long m493getTitleFontSizeXSAIIZE() {
        return this.titleFontSize;
    }

    /* renamed from: getTitleLineHeight-XSAIIZE  reason: not valid java name */
    public final long m494getTitleLineHeightXSAIIZE() {
        return this.titleLineHeight;
    }

    public final FontWeight getTitleFontWeight() {
        return this.titleFontWeight;
    }

    /* renamed from: getTitleTextColor-0d7_KjU  reason: not valid java name */
    public final long m495getTitleTextColor0d7_KjU() {
        return this.titleTextColor;
    }
}