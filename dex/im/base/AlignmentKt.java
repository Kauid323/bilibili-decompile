package im.base;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: Alignment.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberIMStatusAlignment", "Landroidx/compose/ui/Alignment;", "minCenterOffset", "Landroidx/compose/ui/unit/Dp;", "rememberIMStatusAlignment-kHDZbjc", "(FLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Alignment;", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AlignmentKt {
    /* renamed from: rememberIMStatusAlignment-kHDZbjc  reason: not valid java name */
    public static final Alignment m3060rememberIMStatusAlignmentkHDZbjc(float f2, Composer $composer, int $changed, int i2) {
        ComposerKt.sourceInformationMarkerStart($composer, 251968285, "C(rememberIMStatusAlignment)N(minCenterOffset:c#ui.unit.Dp)21@619L7:Alignment.kt#uu6lp7");
        boolean invalid$iv = true;
        if ((i2 & 1) != 0) {
            f2 = Dp.constructor-impl(144);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(251968285, $changed, -1, "im.base.rememberIMStatusAlignment (Alignment.kt:21)");
        }
        $composer.startReplaceGroup(1623355907);
        ComposerKt.sourceInformation($composer, "*22@638L91");
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$rememberIMStatusAlignment_kHDZbjc_u24lambda_u240 = (Density) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 1712078513, "CC(remember):Alignment.kt#9igjgp");
        if (((($changed & 14) ^ 6) <= 4 || !$composer.changed(f2)) && ($changed & 6) != 4) {
            invalid$iv = false;
        }
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new IMStatusAlignment($this$rememberIMStatusAlignment_kHDZbjc_u24lambda_u240.toPx-0680j_4(f2));
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        IMStatusAlignment iMStatusAlignment = (IMStatusAlignment) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iMStatusAlignment;
    }
}