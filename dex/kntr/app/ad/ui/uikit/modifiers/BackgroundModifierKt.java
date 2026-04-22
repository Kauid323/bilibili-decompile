package kntr.app.ad.ui.uikit.modifiers;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import kntr.app.ad.ui.uikit.modifiers.Background;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackgroundModifier.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0004\u001a\u00020\u0005*\u00020\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"background", "Landroidx/compose/ui/Modifier;", "Lkntr/app/ad/ui/uikit/modifiers/Background;", "(Landroidx/compose/ui/Modifier;Lkntr/app/ad/ui/uikit/modifiers/Background;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "getStrokeWidth", "Landroidx/compose/ui/unit/Dp;", "(Lkntr/app/ad/ui/uikit/modifiers/Background;)F", "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BackgroundModifierKt {
    public static final Modifier background(Modifier $this$background, Background background, Composer $composer, int $changed) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$background, "<this>");
        Intrinsics.checkNotNullParameter(background, "background");
        ComposerKt.sourceInformationMarkerStart($composer, 467730682, "C(background)N(background):BackgroundModifier.kt#8jrz0n");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(467730682, $changed, -1, "kntr.app.ad.ui.uikit.modifiers.background (BackgroundModifier.kt:57)");
        }
        if (background instanceof Background.Fill) {
            modifier = BackgroundKt.background-bw27NRU(ClipKt.clip($this$background, ((Background.Fill) background).getShape()), ((Background.Fill) background).m517getColor0d7_KjU(), ((Background.Fill) background).getShape());
        } else if (background instanceof Background.Stroke) {
            modifier = BorderKt.border(ClipKt.clip($this$background, ((Background.Stroke) background).getShape()), BorderStrokeKt.BorderStroke-cXLIe8U(((Background.Stroke) background).m531getWidthD9Ej5fM(), ((Background.Stroke) background).m530getColor0d7_KjU()), ((Background.Stroke) background).getShape());
        } else if (background instanceof Background.FillAndStroke) {
            modifier = BorderKt.border(BackgroundKt.background-bw27NRU(ClipKt.clip($this$background, ((Background.FillAndStroke) background).getShape()), ((Background.FillAndStroke) background).m523getFillColor0d7_KjU(), ((Background.FillAndStroke) background).getShape()), BorderStrokeKt.BorderStroke-cXLIe8U(((Background.FillAndStroke) background).m525getStrokeWidthD9Ej5fM(), ((Background.FillAndStroke) background).m524getStrokeColor0d7_KjU()), ((Background.FillAndStroke) background).getShape());
        } else if (!(background instanceof Background.NoBackground)) {
            throw new NoWhenBranchMatchedException();
        } else {
            modifier = $this$background;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modifier;
    }

    public static final float getStrokeWidth(Background $this$getStrokeWidth) {
        Intrinsics.checkNotNullParameter($this$getStrokeWidth, "<this>");
        if ($this$getStrokeWidth instanceof Background.Stroke) {
            return ((Background.Stroke) $this$getStrokeWidth).m531getWidthD9Ej5fM();
        }
        if ($this$getStrokeWidth instanceof Background.FillAndStroke) {
            return ((Background.FillAndStroke) $this$getStrokeWidth).m525getStrokeWidthD9Ej5fM();
        }
        if (!($this$getStrokeWidth instanceof Background.Fill) && !($this$getStrokeWidth instanceof Background.NoBackground)) {
            throw new NoWhenBranchMatchedException();
        }
        return Dp.constructor-impl(0);
    }
}