package kntr.common.ouro.ui.utils;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnotatedStringUtils.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003JQ\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0007HÖ\u0001J\t\u0010,\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006-"}, d2 = {"Lkntr/common/ouro/ui/utils/AnnotatedStringBuilderContext;", "", "density", "Landroidx/compose/ui/unit/Density;", "theme", "Lcom/bilibili/compose/theme/ThemeDayNight;", "mainAxisLength", "", "placeholderFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "listOrderLayoutCache", "Lkntr/common/ouro/ui/utils/OuroCacheMap;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textMeasure", "Landroidx/compose/ui/text/TextMeasurer;", "<init>", "(Landroidx/compose/ui/unit/Density;Lcom/bilibili/compose/theme/ThemeDayNight;ILandroidx/compose/ui/text/font/FontFamily;Lkntr/common/ouro/ui/utils/OuroCacheMap;Landroidx/compose/ui/text/TextMeasurer;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTheme", "()Lcom/bilibili/compose/theme/ThemeDayNight;", "getMainAxisLength", "()I", "getPlaceholderFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getListOrderLayoutCache", "()Lkntr/common/ouro/ui/utils/OuroCacheMap;", "getTextMeasure", "()Landroidx/compose/ui/text/TextMeasurer;", "isEmptyContainer", "", "isEmptyContainer$ui_debug", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AnnotatedStringBuilderContext {
    public static final int $stable = 8;
    private final Density density;
    private final OuroCacheMap<String, TextLayoutResult> listOrderLayoutCache;
    private final int mainAxisLength;
    private final FontFamily placeholderFontFamily;
    private final TextMeasurer textMeasure;
    private final ThemeDayNight theme;

    public static /* synthetic */ AnnotatedStringBuilderContext copy$default(AnnotatedStringBuilderContext annotatedStringBuilderContext, Density density, ThemeDayNight themeDayNight, int i, FontFamily fontFamily, OuroCacheMap ouroCacheMap, TextMeasurer textMeasurer, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            density = annotatedStringBuilderContext.density;
        }
        if ((i2 & 2) != 0) {
            themeDayNight = annotatedStringBuilderContext.theme;
        }
        ThemeDayNight themeDayNight2 = themeDayNight;
        if ((i2 & 4) != 0) {
            i = annotatedStringBuilderContext.mainAxisLength;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            fontFamily = annotatedStringBuilderContext.placeholderFontFamily;
        }
        FontFamily fontFamily2 = fontFamily;
        OuroCacheMap<String, TextLayoutResult> ouroCacheMap2 = ouroCacheMap;
        if ((i2 & 16) != 0) {
            ouroCacheMap2 = annotatedStringBuilderContext.listOrderLayoutCache;
        }
        OuroCacheMap ouroCacheMap3 = ouroCacheMap2;
        if ((i2 & 32) != 0) {
            textMeasurer = annotatedStringBuilderContext.textMeasure;
        }
        return annotatedStringBuilderContext.copy(density, themeDayNight2, i3, fontFamily2, ouroCacheMap3, textMeasurer);
    }

    public final Density component1() {
        return this.density;
    }

    public final ThemeDayNight component2() {
        return this.theme;
    }

    public final int component3() {
        return this.mainAxisLength;
    }

    public final FontFamily component4() {
        return this.placeholderFontFamily;
    }

    public final OuroCacheMap<String, TextLayoutResult> component5() {
        return this.listOrderLayoutCache;
    }

    public final TextMeasurer component6() {
        return this.textMeasure;
    }

    public final AnnotatedStringBuilderContext copy(Density density, ThemeDayNight themeDayNight, int i, FontFamily fontFamily, OuroCacheMap<String, TextLayoutResult> ouroCacheMap, TextMeasurer textMeasurer) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(themeDayNight, "theme");
        Intrinsics.checkNotNullParameter(fontFamily, "placeholderFontFamily");
        Intrinsics.checkNotNullParameter(ouroCacheMap, "listOrderLayoutCache");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasure");
        return new AnnotatedStringBuilderContext(density, themeDayNight, i, fontFamily, ouroCacheMap, textMeasurer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnnotatedStringBuilderContext) {
            AnnotatedStringBuilderContext annotatedStringBuilderContext = (AnnotatedStringBuilderContext) obj;
            return Intrinsics.areEqual(this.density, annotatedStringBuilderContext.density) && this.theme == annotatedStringBuilderContext.theme && this.mainAxisLength == annotatedStringBuilderContext.mainAxisLength && Intrinsics.areEqual(this.placeholderFontFamily, annotatedStringBuilderContext.placeholderFontFamily) && Intrinsics.areEqual(this.listOrderLayoutCache, annotatedStringBuilderContext.listOrderLayoutCache) && Intrinsics.areEqual(this.textMeasure, annotatedStringBuilderContext.textMeasure);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.density.hashCode() * 31) + this.theme.hashCode()) * 31) + this.mainAxisLength) * 31) + this.placeholderFontFamily.hashCode()) * 31) + this.listOrderLayoutCache.hashCode()) * 31) + this.textMeasure.hashCode();
    }

    public String toString() {
        Density density = this.density;
        ThemeDayNight themeDayNight = this.theme;
        int i = this.mainAxisLength;
        FontFamily fontFamily = this.placeholderFontFamily;
        OuroCacheMap<String, TextLayoutResult> ouroCacheMap = this.listOrderLayoutCache;
        return "AnnotatedStringBuilderContext(density=" + density + ", theme=" + themeDayNight + ", mainAxisLength=" + i + ", placeholderFontFamily=" + fontFamily + ", listOrderLayoutCache=" + ouroCacheMap + ", textMeasure=" + this.textMeasure + ")";
    }

    public AnnotatedStringBuilderContext(Density density, ThemeDayNight theme, int mainAxisLength, FontFamily placeholderFontFamily, OuroCacheMap<String, TextLayoutResult> ouroCacheMap, TextMeasurer textMeasure) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(placeholderFontFamily, "placeholderFontFamily");
        Intrinsics.checkNotNullParameter(ouroCacheMap, "listOrderLayoutCache");
        Intrinsics.checkNotNullParameter(textMeasure, "textMeasure");
        this.density = density;
        this.theme = theme;
        this.mainAxisLength = mainAxisLength;
        this.placeholderFontFamily = placeholderFontFamily;
        this.listOrderLayoutCache = ouroCacheMap;
        this.textMeasure = textMeasure;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final ThemeDayNight getTheme() {
        return this.theme;
    }

    public final int getMainAxisLength() {
        return this.mainAxisLength;
    }

    public final FontFamily getPlaceholderFontFamily() {
        return this.placeholderFontFamily;
    }

    public final OuroCacheMap<String, TextLayoutResult> getListOrderLayoutCache() {
        return this.listOrderLayoutCache;
    }

    public final TextMeasurer getTextMeasure() {
        return this.textMeasure;
    }

    public final boolean isEmptyContainer$ui_debug() {
        return this.mainAxisLength <= 0;
    }
}