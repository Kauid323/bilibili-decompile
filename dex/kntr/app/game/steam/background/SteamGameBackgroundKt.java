package kntr.app.game.steam.background;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: SteamGameBackground.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000b\u001a\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u001a\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0013\"\u0013\u0010\u0014\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016\"\u0013\u0010\u0018\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"parseRgbString", "Landroidx/compose/ui/graphics/Color;", "rgbString", RoomRecommendViewModel.EMPTY_CURSOR, "rgbToHsl", "Lkntr/app/game/steam/background/HSL;", "color", "rgbToHsl-8_81llA", "(J)Lkntr/app/game/steam/background/HSL;", "hslToRgb", "hsl", "(Lkntr/app/game/steam/background/HSL;)J", "calculateSteamGradientColors", "Lkotlin/Pair;", "appIconRgb", "createSteamGameGradient", "Landroidx/compose/ui/graphics/Brush;", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Brush;", "getDefaultSteamGradient", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Brush;", "SteamOverlayWhite", "getSteamOverlayWhite", "()J", "J", "SteamCardBackground", "getSteamCardBackground", "gamebiz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SteamGameBackgroundKt {
    private static final long SteamOverlayWhite = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    private static final long SteamCardBackground = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);

    public static final Color parseRgbString(String rgbString) {
        Intrinsics.checkNotNullParameter(rgbString, "rgbString");
        try {
            long rgb = Long.parseLong(StringsKt.removePrefix(rgbString, "#"), CharsKt.checkRadix(16));
            float r = ((float) ((rgb >> 16) & 255)) / 255.0f;
            float g = ((float) ((rgb >> 8) & 255)) / 255.0f;
            float b = ((float) (255 & rgb)) / 255.0f;
            return Color.box-impl(ColorKt.Color$default(r, g, b, 0.0f, (ColorSpace) null, 24, (Object) null));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: rgbToHsl-8_81llA  reason: not valid java name */
    public static final HSL m1325rgbToHsl8_81llA(long j2) {
        float s;
        float it;
        float r = Color.getRed-impl(j2);
        float g = Color.getGreen-impl(j2);
        float b = Color.getBlue-impl(j2);
        float max = Math.max(Math.max(r, g), b);
        float min = Math.min(Math.min(r, g), b);
        float delta = max - min;
        float l = (max + min) / 2.0f;
        if (delta == 0.0f) {
            s = 0.0f;
        } else {
            s = delta / (1.0f - Math.abs((l * 2.0f) - 1.0f));
        }
        if (delta == 0.0f) {
            it = 0.0f;
        } else {
            if (max == r) {
                it = (((g - b) / delta) % 6.0f) * 60.0f;
            } else {
                it = max == g ? (((b - r) / delta) + 2.0f) * 60.0f : (((r - g) / delta) + 4.0f) * 60.0f;
            }
        }
        if (it < 0.0f) {
            it = 360.0f + it;
        }
        return new HSL(it, s, l);
    }

    public static final long hslToRgb(HSL hsl) {
        Triple triple;
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        float h = hsl.getH();
        float s = hsl.getS();
        float l = hsl.getL();
        float c = (1.0f - Math.abs((l * 2.0f) - 1.0f)) * s;
        float x = (1.0f - Math.abs(((h / 60.0f) % 2.0f) - 1.0f)) * c;
        float m = l - (c / 2.0f);
        int i = (h > 60.0f ? 1 : (h == 60.0f ? 0 : -1));
        Float valueOf = Float.valueOf(0.0f);
        if (i < 0) {
            triple = new Triple(Float.valueOf(c), Float.valueOf(x), valueOf);
        } else if (h < 120.0f) {
            triple = new Triple(Float.valueOf(x), Float.valueOf(c), valueOf);
        } else if (h < 180.0f) {
            triple = new Triple(valueOf, Float.valueOf(c), Float.valueOf(x));
        } else if (h < 240.0f) {
            triple = new Triple(valueOf, Float.valueOf(x), Float.valueOf(c));
        } else {
            triple = h < 300.0f ? new Triple(Float.valueOf(x), valueOf, Float.valueOf(c)) : new Triple(Float.valueOf(c), valueOf, Float.valueOf(x));
        }
        float r1 = ((Number) triple.component1()).floatValue();
        float g1 = ((Number) triple.component2()).floatValue();
        float b1 = ((Number) triple.component3()).floatValue();
        return ColorKt.Color$default(r1 + m, g1 + m, b1 + m, 0.0f, (ColorSpace) null, 24, (Object) null);
    }

    public static final Pair<Color, Color> calculateSteamGradientColors(String appIconRgb) {
        float f;
        Pair pair;
        long defaultColor = ColorKt.Color(4279703578L);
        Color parseRgbString = parseRgbString(appIconRgb == null ? "#17181a" : appIconRgb);
        long baseColor = parseRgbString != null ? parseRgbString.unbox-impl() : defaultColor;
        HSL hsl = m1325rgbToHsl8_81llA(baseColor);
        float l = hsl.getL() * 100.0f;
        float s = hsl.getS() * 100.0f;
        float l1 = l - 10.0f;
        if (l1 > 50.0f) {
            f = 50.0f;
        } else {
            f = l1 < 20.0f ? 20.0f : l1;
        }
        float l12 = f;
        if (l12 > 40.0f && l12 <= 50.0f) {
            pair = new Pair(Float.valueOf(s), Float.valueOf(l12 - 30.0f));
        } else if (l12 > 30.0f && l12 <= 40.0f) {
            pair = new Pair(Float.valueOf(s <= 40.0f ? s : 40.0f), Float.valueOf(l12 - 20.0f));
        } else if (l12 > 20.0f && l12 <= 30.0f) {
            pair = new Pair(Float.valueOf(s), Float.valueOf(l12 - 10.0f));
        } else {
            pair = new Pair(Float.valueOf(s), Float.valueOf(10.0f));
        }
        float s1 = ((Number) pair.component1()).floatValue();
        float endL = ((Number) pair.component2()).floatValue();
        HSL startHsl = new HSL(hsl.getH(), s1 / 100.0f, l12 / 100.0f);
        HSL endHsl = new HSL(hsl.getH(), s1 / 100.0f, endL / 100.0f);
        return new Pair<>(Color.box-impl(hslToRgb(startHsl)), Color.box-impl(hslToRgb(endHsl)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r26.changed(r25) != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Brush createSteamGameGradient(String appIconRgb, Composer $composer, int $changed) {
        boolean invalid$iv;
        Object it$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1405071685, "C(createSteamGameGradient)N(appIconRgb)160@4438L279:SteamGameBackground.kt#mh6umq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1405071685, $changed, -1, "kntr.app.game.steam.background.createSteamGameGradient (SteamGameBackground.kt:160)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1654160604, "CC(remember):SteamGameBackground.kt#9igjgp");
        if ((($changed & 14) ^ 6) <= 4) {
        }
        if (($changed & 6) != 4) {
            invalid$iv = false;
            it$iv = $composer.rememberedValue();
            if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Pair<Color, Color> calculateSteamGradientColors = calculateSteamGradientColors(appIconRgb);
                long startColor = ((Color) calculateSteamGradientColors.component1()).unbox-impl();
                long endColor = ((Color) calculateSteamGradientColors.component2()).unbox-impl();
                Object value$iv = Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(startColor), Color.box-impl(endColor)}), Offset.Companion.getZero-F1C5BW0(), Offset.Companion.getInfinite-F1C5BW0(), 0, 8, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Brush brush = (Brush) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            return brush;
        }
        invalid$iv = true;
        it$iv = $composer.rememberedValue();
        if (!invalid$iv) {
        }
        Pair<Color, Color> calculateSteamGradientColors2 = calculateSteamGradientColors(appIconRgb);
        long startColor2 = ((Color) calculateSteamGradientColors2.component1()).unbox-impl();
        long endColor2 = ((Color) calculateSteamGradientColors2.component2()).unbox-impl();
        Object value$iv2 = Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(startColor2), Color.box-impl(endColor2)}), Offset.Companion.getZero-F1C5BW0(), Offset.Companion.getInfinite-F1C5BW0(), 0, 8, (Object) null);
        $composer.updateRememberedValue(value$iv2);
        it$iv = value$iv2;
        Brush brush2 = (Brush) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return brush2;
    }

    public static final Brush getDefaultSteamGradient(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 66322133, "C(getDefaultSteamGradient)175@4868L261:SteamGameBackground.kt#mh6umq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(66322133, $changed, -1, "kntr.app.game.steam.background.getDefaultSteamGradient (SteamGameBackground.kt:175)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -688937990, "CC(remember):SteamGameBackground.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Pair<Color, Color> calculateSteamGradientColors = calculateSteamGradientColors(null);
            long startColor = ((Color) calculateSteamGradientColors.component1()).unbox-impl();
            long endColor = ((Color) calculateSteamGradientColors.component2()).unbox-impl();
            Object value$iv = Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(startColor), Color.box-impl(endColor)}), Offset.Companion.getZero-F1C5BW0(), Offset.Companion.getInfinite-F1C5BW0(), 0, 8, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        Brush brush = (Brush) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return brush;
    }

    public static final long getSteamOverlayWhite() {
        return SteamOverlayWhite;
    }

    public static final long getSteamCardBackground() {
        return SteamCardBackground;
    }
}