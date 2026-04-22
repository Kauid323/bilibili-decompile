package kntr.app.tribee.operation.ui;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Screen.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"getScreenWidth", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/runtime/Composer;I)F", "getScreenHeight", "operation_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Screen_androidKt {
    public static final float getScreenWidth(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2044746047, "C(getScreenWidth)8@281L7:Screen.android.kt#84j3m0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2044746047, $changed, -1, "kntr.app.tribee.operation.ui.getScreenWidth (Screen.android.kt:8)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        int $this$dp$iv = ((Configuration) consume).screenWidthDp;
        float f = Dp.constructor-impl($this$dp$iv);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return f;
    }

    public static final float getScreenHeight(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2140431112, "C(getScreenHeight)11@382L7:Screen.android.kt#84j3m0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2140431112, $changed, -1, "kntr.app.tribee.operation.ui.getScreenHeight (Screen.android.kt:11)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        int $this$dp$iv = ((Configuration) consume).screenHeightDp;
        float f = Dp.constructor-impl($this$dp$iv);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return f;
    }
}