package kntr.common.compose.res;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import srcs.common.compose.res.generated.resources.Res;

/* compiled from: LoadingAnimateImage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"getLoadingAnimateImageUri", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "compose-res_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LoadingAnimateImageKt {
    public static final String getLoadingAnimateImageUri(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1274268943, "C(getLoadingAnimateImageUri):LoadingAnimateImage.kt#xmeb0y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1274268943, $changed, -1, "kntr.common.compose.res.getLoadingAnimateImageUri (LoadingAnimateImage.kt:8)");
        }
        String uri = Res.INSTANCE.getUri("files/ic_loading_tv.webp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return uri;
    }
}