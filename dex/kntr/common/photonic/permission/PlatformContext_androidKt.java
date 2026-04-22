package kntr.common.photonic.permission;

import android.app.Activity;
import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: PlatformContext.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00060\u0001j\u0002`\u0003H\u0007¢\u0006\u0002\u0010\u0004*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0005"}, d2 = {"PlatformContext", "Landroid/app/Activity;", "getPlatformContext", "Lkntr/common/photonic/permission/PlatformContext;", "(Landroidx/compose/runtime/Composer;I)Landroid/app/Activity;", "permission_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlatformContext_androidKt {
    public static final Activity getPlatformContext(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1648551041, "C(getPlatformContext)9@283L7:PlatformContext.android.kt#2xlo5t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1648551041, $changed, -1, "kntr.common.photonic.permission.getPlatformContext (PlatformContext.android.kt:9)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Activity findActivity = PermissionState_androidKt.findActivity((Context) consume);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return findActivity;
    }
}