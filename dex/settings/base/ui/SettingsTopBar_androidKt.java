package settings.base.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: SettingsTopBar.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "getTitleTextStyle", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SettingsTopBar_androidKt {
    public static final TextStyle getTitleTextStyle(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1414934053, "C(<get-titleTextStyle>)8@240L9:SettingsTopBar.android.kt#d1bdve");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1414934053, $changed, -1, "settings.base.ui.<get-titleTextStyle> (SettingsTopBar.android.kt:8)");
        }
        TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return t16;
    }
}