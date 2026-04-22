package kntr.common.screen.adjust;

import androidx.window.core.layout.WindowSizeClass;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KScreenAdjustUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\u000b\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\f\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\r\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"MEDIUM_MIN_WIDTH", "", "MEDIUM_MIN_HEIGHT", "LARGE_MIN_WIDTH", "LARGE_MIN_HEIGHT", "isLargeLandscape", "", "Landroidx/window/core/layout/WindowSizeClass;", "isLargePortrait", "isLarge", "isMedium", "isNormal", "widthBreakPointNormal", "widthBreakPointMedium", "widthBreakPointLarge", "CONTAINER_FUNCTION_MAX_WIDTH", "CONTAINER_WEBVIEW_MAX_WIDTH", "CONTAINER_CONTENT_MAX_WIDTH", "contentPanelMaxWith", "functionPanelMaxWith", "contentWebViewMaxWith", "screen-adjust_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KScreenAdjustUtilsKt {
    public static final int CONTAINER_CONTENT_MAX_WIDTH = 720;
    public static final int CONTAINER_FUNCTION_MAX_WIDTH = 480;
    public static final int CONTAINER_WEBVIEW_MAX_WIDTH = 600;
    public static final int LARGE_MIN_HEIGHT = 600;
    public static final int LARGE_MIN_WIDTH = 840;
    public static final int MEDIUM_MIN_HEIGHT = 600;
    public static final int MEDIUM_MIN_WIDTH = 600;

    public static final boolean isLargeLandscape(WindowSizeClass $this$isLargeLandscape) {
        Intrinsics.checkNotNullParameter($this$isLargeLandscape, "<this>");
        if (KScreenAdjustConfigKt.getHitScreenAdjustForceLargeLandscape()) {
            return true;
        }
        return KScreenAdjustConfigKt.getHitScreenAdjustLarge() && $this$isLargeLandscape.getMinWidthDp() >= 840 && $this$isLargeLandscape.getMinHeightDp() >= 600;
    }

    public static final boolean isLargePortrait(WindowSizeClass $this$isLargePortrait) {
        Intrinsics.checkNotNullParameter($this$isLargePortrait, "<this>");
        if (!KScreenAdjustConfigKt.getHitScreenAdjustForceLargeLandscape() && KScreenAdjustConfigKt.getHitScreenAdjustLarge()) {
            int minWidthDp = $this$isLargePortrait.getMinWidthDp();
            return (600 <= minWidthDp && minWidthDp < 840) && $this$isLargePortrait.getMinHeightDp() >= 840;
        }
        return false;
    }

    public static final boolean isLarge(WindowSizeClass $this$isLarge) {
        Intrinsics.checkNotNullParameter($this$isLarge, "<this>");
        return isLargePortrait($this$isLarge) || isLargeLandscape($this$isLarge);
    }

    public static final boolean isMedium(WindowSizeClass $this$isMedium) {
        Intrinsics.checkNotNullParameter($this$isMedium, "<this>");
        if (KScreenAdjustConfigKt.getHitScreenAdjustForceLargeLandscape()) {
            return false;
        }
        if (KScreenAdjustConfigKt.getHitScreenAdjustMedium() || KScreenAdjustConfigKt.getHitScreenAdjustLarge()) {
            int minWidthDp = $this$isMedium.getMinWidthDp();
            boolean validWidth = 600 <= minWidthDp && minWidthDp < 840;
            int minHeightDp = $this$isMedium.getMinHeightDp();
            boolean validHeight = 600 <= minHeightDp && minHeightDp < 840;
            return validWidth && validHeight;
        }
        return false;
    }

    public static final boolean isNormal(WindowSizeClass $this$isNormal) {
        Intrinsics.checkNotNullParameter($this$isNormal, "<this>");
        return (isLarge($this$isNormal) || isMedium($this$isNormal)) ? false : true;
    }

    public static final boolean widthBreakPointNormal(WindowSizeClass $this$widthBreakPointNormal) {
        Intrinsics.checkNotNullParameter($this$widthBreakPointNormal, "<this>");
        return isNormal($this$widthBreakPointNormal);
    }

    public static final boolean widthBreakPointMedium(WindowSizeClass $this$widthBreakPointMedium) {
        Intrinsics.checkNotNullParameter($this$widthBreakPointMedium, "<this>");
        return isLargePortrait($this$widthBreakPointMedium) || isMedium($this$widthBreakPointMedium);
    }

    public static final boolean widthBreakPointLarge(WindowSizeClass $this$widthBreakPointLarge) {
        Intrinsics.checkNotNullParameter($this$widthBreakPointLarge, "<this>");
        return isLargeLandscape($this$widthBreakPointLarge);
    }

    public static final int contentPanelMaxWith(WindowSizeClass $this$contentPanelMaxWith) {
        Intrinsics.checkNotNullParameter($this$contentPanelMaxWith, "<this>");
        if (KScreenAdjustConfigKt.getHitScreenAdjustLarge() && isLargeLandscape($this$contentPanelMaxWith)) {
            return CONTAINER_CONTENT_MAX_WIDTH;
        }
        return 0;
    }

    public static final int functionPanelMaxWith(WindowSizeClass $this$functionPanelMaxWith) {
        Intrinsics.checkNotNullParameter($this$functionPanelMaxWith, "<this>");
        if ((KScreenAdjustConfigKt.getHitScreenAdjustLarge() && !isNormal($this$functionPanelMaxWith)) || (KScreenAdjustConfigKt.getHitScreenAdjustMedium() && isMedium($this$functionPanelMaxWith))) {
            return CONTAINER_FUNCTION_MAX_WIDTH;
        }
        return 0;
    }

    public static final int contentWebViewMaxWith(WindowSizeClass $this$contentWebViewMaxWith) {
        Intrinsics.checkNotNullParameter($this$contentWebViewMaxWith, "<this>");
        if ((KScreenAdjustConfigKt.getHitScreenAdjustLarge() && !isNormal($this$contentWebViewMaxWith)) || (KScreenAdjustConfigKt.getHitScreenAdjustMedium() && isMedium($this$contentWebViewMaxWith))) {
            return 600;
        }
        return 0;
    }
}