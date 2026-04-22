package kntr.app.mall.product.details.page.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.mall.product.details.page.utils.DayNightTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Themes.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\r\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a\b\u0010\u000e\u001a\u00020\fH\u0000\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0010\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0013"}, d2 = {"PAGE_DAY_BG_COLOR", "Landroidx/compose/ui/graphics/Color;", "J", "PAGE_NIGHT_BG_COLOR", "PAGE_DAY_CARD_COLOR", "PAGE_NIGHT_CARD_COLOR", "PAGE_DAY_BOTTOM_OPERATION_COLOR", "PAGE_NIGHT_BOTTOM_OPERATION_COLOR", "currentDayNightTheme", "Lkntr/app/mall/product/details/page/utils/DayNightTheme;", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/mall/product/details/page/utils/DayNightTheme;", "isCurrentThemeLight", "", "(Landroidx/compose/runtime/Composer;I)Z", "isCurrentThemeLightNonComposable", "getPageBgColor", "(Landroidx/compose/runtime/Composer;I)J", "getPageCardColor", "getPageBottomOperationColor", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ThemesKt {
    private static final long PAGE_DAY_BG_COLOR = ColorKt.Color(4294046451L);
    private static final long PAGE_NIGHT_BG_COLOR = ColorKt.Color(4278255873L);
    private static final long PAGE_DAY_CARD_COLOR = ColorKt.Color(4294967295L);
    private static final long PAGE_NIGHT_CARD_COLOR = ColorKt.Color(4279703578L);
    private static final long PAGE_DAY_BOTTOM_OPERATION_COLOR = ColorKt.Color(4294967295L);
    private static final long PAGE_NIGHT_BOTTOM_OPERATION_COLOR = ColorKt.Color(4279703578L);

    /* compiled from: Themes.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeDayNight.values().length];
            try {
                iArr[ThemeDayNight.Day.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ThemeDayNight.Night.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DayNightTheme currentDayNightTheme(Composer $composer, int $changed) {
        DayNightTheme.Light light;
        ComposerKt.sourceInformationMarkerStart($composer, 173479976, "C(currentDayNightTheme)24@792L13:Themes.kt#cdfg83");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(173479976, $changed, -1, "kntr.app.mall.product.details.page.utils.currentDayNightTheme (Themes.kt:23)");
        }
        ThemeDayNight currentBiliTheme = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable);
        switch (WhenMappings.$EnumSwitchMapping$0[currentBiliTheme.ordinal()]) {
            case 1:
                light = DayNightTheme.Light.INSTANCE;
                break;
            case 2:
                light = DayNightTheme.Dark.INSTANCE;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return light;
    }

    public static final boolean isCurrentThemeLight(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1767043113, "C(isCurrentThemeLight)33@1019L22:Themes.kt#cdfg83");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1767043113, $changed, -1, "kntr.app.mall.product.details.page.utils.isCurrentThemeLight (Themes.kt:33)");
        }
        boolean z = false;
        DayNightTheme currentDayNightTheme = currentDayNightTheme($composer, 0);
        if (currentDayNightTheme instanceof DayNightTheme.Light) {
            z = true;
        } else if (!(currentDayNightTheme instanceof DayNightTheme.Dark)) {
            throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return z;
    }

    public static final boolean isCurrentThemeLightNonComposable() {
        switch (WhenMappings.$EnumSwitchMapping$0[((ThemeDayNight) ThemeDayNight.Companion.getCurrentTheme().getValue()).ordinal()]) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final long getPageBgColor(Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, -1162348903, "C(getPageBgColor)47@1428L22:Themes.kt#cdfg83");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1162348903, $changed, -1, "kntr.app.mall.product.details.page.utils.getPageBgColor (Themes.kt:47)");
        }
        DayNightTheme currentDayNightTheme = currentDayNightTheme($composer, 0);
        if (currentDayNightTheme instanceof DayNightTheme.Light) {
            j = PAGE_DAY_BG_COLOR;
        } else if (!(currentDayNightTheme instanceof DayNightTheme.Dark)) {
            throw new NoWhenBranchMatchedException();
        } else {
            j = PAGE_NIGHT_BG_COLOR;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }

    public static final long getPageCardColor(Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, 717940900, "C(getPageCardColor)54@1629L22:Themes.kt#cdfg83");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(717940900, $changed, -1, "kntr.app.mall.product.details.page.utils.getPageCardColor (Themes.kt:54)");
        }
        DayNightTheme currentDayNightTheme = currentDayNightTheme($composer, 0);
        if (currentDayNightTheme instanceof DayNightTheme.Light) {
            j = PAGE_DAY_CARD_COLOR;
        } else if (!(currentDayNightTheme instanceof DayNightTheme.Dark)) {
            throw new NoWhenBranchMatchedException();
        } else {
            j = PAGE_NIGHT_CARD_COLOR;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }

    public static final long getPageBottomOperationColor(Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, 1659163650, "C(getPageBottomOperationColor)61@1845L22:Themes.kt#cdfg83");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1659163650, $changed, -1, "kntr.app.mall.product.details.page.utils.getPageBottomOperationColor (Themes.kt:61)");
        }
        DayNightTheme currentDayNightTheme = currentDayNightTheme($composer, 0);
        if (currentDayNightTheme instanceof DayNightTheme.Light) {
            j = PAGE_DAY_BOTTOM_OPERATION_COLOR;
        } else if (!(currentDayNightTheme instanceof DayNightTheme.Dark)) {
            throw new NoWhenBranchMatchedException();
        } else {
            j = PAGE_NIGHT_BOTTOM_OPERATION_COLOR;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }
}