package video.biz.offline.list.ui.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.AppInfo_androidKt;

/* compiled from: ColorUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0011\u0010\u0000\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2 = {"headerTintIconColor", "Landroidx/compose/ui/graphics/Color;", "getHeaderTintIconColor", "(Landroidx/compose/runtime/Composer;I)J", "headerTitleColor", "getHeaderTitleColor", "headerTintTextColor", "getHeaderTintTextColor", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ColorUtilsKt {
    public static final long getHeaderTintIconColor(Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, -1072258136, "C(<get-headerTintIconColor>):ColorUtils.kt#5weiuq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1072258136, $changed, -1, "video.biz.offline.list.ui.utils.<get-headerTintIconColor> (ColorUtils.kt:9)");
        }
        if (AppInfo_androidKt.isHDApp()) {
            $composer.startReplaceGroup(-1970307124);
            ComposerKt.sourceInformation($composer, "10@303L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-1970255230);
            ComposerKt.sourceInformation($composer, "12@355L11");
            j = BiliTheme.INSTANCE.getThemeColors($composer, BiliTheme.$stable).getActionIcon-0d7_KjU();
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }

    public static final long getHeaderTitleColor(Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, -707704064, "C(<get-headerTitleColor>):ColorUtils.kt#5weiuq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-707704064, $changed, -1, "video.biz.offline.list.ui.utils.<get-headerTitleColor> (ColorUtils.kt:17)");
        }
        if (AppInfo_androidKt.isHDApp()) {
            $composer.startReplaceGroup(782727540);
            ComposerKt.sourceInformation($composer, "18@486L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(782779403);
            ComposerKt.sourceInformation($composer, "20@538L11");
            j = BiliTheme.INSTANCE.getThemeColors($composer, BiliTheme.$stable).getTextTitle-0d7_KjU();
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }

    public static final long getHeaderTintTextColor(Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, -188080368, "C(<get-headerTintTextColor>):ColorUtils.kt#5weiuq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-188080368, $changed, -1, "video.biz.offline.list.ui.utils.<get-headerTintTextColor> (ColorUtils.kt:25)");
        }
        if (AppInfo_androidKt.isHDApp()) {
            $composer.startReplaceGroup(1830120292);
            ComposerKt.sourceInformation($composer, "26@671L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(1830172155);
            ComposerKt.sourceInformation($composer, "28@723L11");
            j = BiliTheme.INSTANCE.getThemeColors($composer, BiliTheme.$stable).getTextTitle-0d7_KjU();
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }
}