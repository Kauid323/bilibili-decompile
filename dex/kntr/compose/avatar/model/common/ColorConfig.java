package kntr.compose.avatar.model.common;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeDrawSpec.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\b\u0012J0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\b\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lkntr/compose/avatar/model/common/ColorConfig;", "", "dayNight", "", "dayColor", "Lkntr/compose/avatar/model/common/ARGBColor;", "nightColor", "<init>", "(ZLkntr/compose/avatar/model/common/ARGBColor;Lkntr/compose/avatar/model/common/ARGBColor;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDayNight", "()Z", "getDayColor-L6X1Uyc", "()Lkntr/compose/avatar/model/common/ARGBColor;", "getNightColor-L6X1Uyc", "component1", "component2", "component2-L6X1Uyc", "component3", "component3-L6X1Uyc", "copy", "copy-MW03NZA", "equals", "other", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ColorConfig {
    private final ARGBColor dayColor;
    private final boolean dayNight;
    private final ARGBColor nightColor;

    public /* synthetic */ ColorConfig(boolean z, ARGBColor aRGBColor, ARGBColor aRGBColor2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, aRGBColor, aRGBColor2);
    }

    /* renamed from: copy-MW03NZA$default  reason: not valid java name */
    public static /* synthetic */ ColorConfig m2533copyMW03NZA$default(ColorConfig colorConfig, boolean z, ARGBColor aRGBColor, ARGBColor aRGBColor2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = colorConfig.dayNight;
        }
        if ((i & 2) != 0) {
            aRGBColor = colorConfig.dayColor;
        }
        if ((i & 4) != 0) {
            aRGBColor2 = colorConfig.nightColor;
        }
        return colorConfig.m2536copyMW03NZA(z, aRGBColor, aRGBColor2);
    }

    public final boolean component1() {
        return this.dayNight;
    }

    /* renamed from: component2-L6X1Uyc  reason: not valid java name */
    public final ARGBColor m2534component2L6X1Uyc() {
        return this.dayColor;
    }

    /* renamed from: component3-L6X1Uyc  reason: not valid java name */
    public final ARGBColor m2535component3L6X1Uyc() {
        return this.nightColor;
    }

    /* renamed from: copy-MW03NZA  reason: not valid java name */
    public final ColorConfig m2536copyMW03NZA(boolean z, ARGBColor aRGBColor, ARGBColor aRGBColor2) {
        return new ColorConfig(z, aRGBColor, aRGBColor2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ColorConfig) {
            ColorConfig colorConfig = (ColorConfig) obj;
            return this.dayNight == colorConfig.dayNight && Intrinsics.areEqual(this.dayColor, colorConfig.dayColor) && Intrinsics.areEqual(this.nightColor, colorConfig.nightColor);
        }
        return false;
    }

    public int hashCode() {
        return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.dayNight) * 31) + (this.dayColor == null ? 0 : ARGBColor.m2529hashCodeimpl(this.dayColor.m2531unboximpl()))) * 31) + (this.nightColor != null ? ARGBColor.m2529hashCodeimpl(this.nightColor.m2531unboximpl()) : 0);
    }

    public String toString() {
        boolean z = this.dayNight;
        ARGBColor aRGBColor = this.dayColor;
        return "ColorConfig(dayNight=" + z + ", dayColor=" + aRGBColor + ", nightColor=" + this.nightColor + ")";
    }

    private ColorConfig(boolean dayNight, ARGBColor dayColor, ARGBColor nightColor) {
        this.dayNight = dayNight;
        this.dayColor = dayColor;
        this.nightColor = nightColor;
    }

    public /* synthetic */ ColorConfig(boolean z, ARGBColor aRGBColor, ARGBColor aRGBColor2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : aRGBColor, (i & 4) != 0 ? null : aRGBColor2, null);
    }

    public final boolean getDayNight() {
        return this.dayNight;
    }

    /* renamed from: getDayColor-L6X1Uyc  reason: not valid java name */
    public final ARGBColor m2537getDayColorL6X1Uyc() {
        return this.dayColor;
    }

    /* renamed from: getNightColor-L6X1Uyc  reason: not valid java name */
    public final ARGBColor m2538getNightColorL6X1Uyc() {
        return this.nightColor;
    }
}