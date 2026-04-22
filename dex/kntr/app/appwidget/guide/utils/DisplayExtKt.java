package kntr.app.appwidget.guide.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* compiled from: DisplayExt.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"displayWidth", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/runtime/Composer;I)I", "guide_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DisplayExtKt {
    public static final int displayWidth(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1548515142, "C(displayWidth)13@380L7,15@421L65,18@516L7:DisplayExt.kt#yji61w");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1548515142, $changed, -1, "kntr.app.appwidget.guide.utils.displayWidth (DisplayExt.kt:12)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 2064370247, "CC(remember):DisplayExt.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = context.getResources().getDisplayMetrics();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        DisplayMetrics displayMetrics = (DisplayMetrics) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(this_$iv2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$displayWidth_u24lambda_u241 = (Density) consume2;
        int roundToInt = MathKt.roundToInt($this$displayWidth_u24lambda_u241.toDp-u2uoSUM(displayMetrics.widthPixels));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return roundToInt;
    }
}