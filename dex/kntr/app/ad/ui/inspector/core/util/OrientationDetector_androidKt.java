package kntr.app.ad.ui.inspector.core.util;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: OrientationDetector.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberIsLandscape", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/runtime/Composer;I)Z", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OrientationDetector_androidKt {
    public static final boolean rememberIsLandscape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 557261010, "C(rememberIsLandscape)11@317L7:OrientationDetector.android.kt#5qtqsx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(557261010, $changed, -1, "kntr.app.ad.ui.inspector.core.util.rememberIsLandscape (OrientationDetector.android.kt:10)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Configuration configuration = (Configuration) consume;
        boolean z = configuration.orientation == 2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return z;
    }
}