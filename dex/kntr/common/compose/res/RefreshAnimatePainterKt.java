package kntr.common.compose.res;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.graphics.painter.Painter;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;
import srcs.common.compose.res.generated.resources.Res;

/* compiled from: RefreshAnimatePainter.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"rememberRefreshAnimatePainter", "Lkntr/common/compose/res/AnimatePainter;", "startNow", "", "(ZLandroidx/compose/runtime/Composer;II)Lkntr/common/compose/res/AnimatePainter;", "compose-res_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RefreshAnimatePainterKt {
    public static final AnimatePainter rememberRefreshAnimatePainter(boolean startNow, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1455852613, "C(rememberRefreshAnimatePainter)N(startNow)34@1334L53,35@1401L53,36@1468L53,37@1535L53,40@1626L70:RefreshAnimatePainter.kt#xmeb0y");
        if ((i & 1) != 0) {
            startNow = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1455852613, $changed, -1, "kntr.common.compose.res.rememberRefreshAnimatePainter (RefreshAnimatePainter.kt:31)");
        }
        List painters = CollectionsKt.listOf(new Painter[]{ImageResourcesKt.painterResource(Drawable0_commonMainKt.getRefresh_animate_frame_1(Res.drawable.INSTANCE), $composer, 0), ImageResourcesKt.painterResource(Drawable0_commonMainKt.getRefresh_animate_frame_2(Res.drawable.INSTANCE), $composer, 0), ImageResourcesKt.painterResource(Drawable0_commonMainKt.getRefresh_animate_frame_3(Res.drawable.INSTANCE), $composer, 0), ImageResourcesKt.painterResource(Drawable0_commonMainKt.getRefresh_animate_frame_4(Res.drawable.INSTANCE), $composer, 0)});
        ComposerKt.sourceInformationMarkerStart($composer, 1084990817, "CC(remember):RefreshAnimatePainter.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Duration.Companion companion = Duration.Companion;
            Object value$iv = new AnimatePainter(painters, DurationKt.toDuration(0.2d, DurationUnit.SECONDS), null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        AnimatePainter painter = (AnimatePainter) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (startNow) {
            $composer.startReplaceGroup(-724933883);
            ComposerKt.sourceInformation($composer, "44@1759L48,44@1725L82");
            Boolean valueOf = Boolean.valueOf(startNow);
            ComposerKt.sourceInformationMarkerStart($composer, 1084995051, "CC(remember):RefreshAnimatePainter.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(painter);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new RefreshAnimatePainterKt$rememberRefreshAnimatePainter$1$1(painter, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(painter, valueOf, (Function2) it$iv2, $composer, ($changed << 3) & 112);
        } else {
            $composer.startReplaceGroup(-726639193);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return painter;
    }
}