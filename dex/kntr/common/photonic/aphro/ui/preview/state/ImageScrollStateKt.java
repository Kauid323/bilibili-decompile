package kntr.common.photonic.aphro.ui.preview.state;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: ImageScrollState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberImageScrollState", "Lkntr/common/photonic/aphro/ui/preview/state/ImageScrollState;", "(Landroidx/compose/runtime/Composer;I)Lkntr/common/photonic/aphro/ui/preview/state/ImageScrollState;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageScrollStateKt {
    public static final ImageScrollState rememberImageScrollState(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1170518563, "C(rememberImageScrollState)16@634L31:ImageScrollState.kt#za7lpn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1170518563, $changed, -1, "kntr.common.photonic.aphro.ui.preview.state.rememberImageScrollState (ImageScrollState.kt:16)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -413090846, "CC(remember):ImageScrollState.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new ImageScrollState();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ImageScrollState imageScrollState = (ImageScrollState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return imageScrollState;
    }
}