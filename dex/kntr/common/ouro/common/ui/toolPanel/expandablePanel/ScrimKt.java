package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Scrim.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Scrim", "", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "progress", "", "Scrim-KTwxG1Y", "(JLandroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ScrimKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$1(long j, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m1923ScrimKTwxG1Y(j, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: Scrim-KTwxG1Y  reason: not valid java name */
    public static final void m1923ScrimKTwxG1Y(final long j, Modifier modifier, float progress, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final float progress2;
        float progress3;
        Modifier modifier3;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(1491615352);
        ComposerKt.sourceInformation($composer2, "C(Scrim)N(color:c#ui.graphics.Color,modifier,progress):Scrim.kt#x1p13y");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            progress2 = progress;
        } else if (($changed & 384) == 0) {
            progress2 = progress;
            $dirty |= $composer2.changed(progress2) ? 256 : 128;
        } else {
            progress2 = progress;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            progress3 = progress2;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                progress2 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1491615352, $dirty2, -1, "kntr.common.ouro.common.ui.toolPanel.expandablePanel.Scrim (Scrim.kt:14)");
            }
            if ((j != 16 ? 1 : 0) != 0) {
                $composer2.startReplaceGroup(981433653);
                ComposerKt.sourceInformation($composer2, "16@497L180,16@480L197");
                ComposerKt.sourceInformationMarkerStart($composer2, -1076718676, "CC(remember):Scrim.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 14) == 4) | (($dirty2 & 896) == 256);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ScrimKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit Scrim_KTwxG1Y$lambda$0$0;
                            Scrim_KTwxG1Y$lambda$0$0 = ScrimKt.Scrim_KTwxG1Y$lambda$0$0(j, progress2, (DrawScope) obj);
                            return Scrim_KTwxG1Y$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifier4, (Function1) it$iv, $composer2, ($dirty2 >> 3) & 14);
            } else {
                $composer2.startReplaceGroup(980959818);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            progress3 = progress2;
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final float f = progress3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ScrimKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Scrim_KTwxG1Y$lambda$1;
                    Scrim_KTwxG1Y$lambda$1 = ScrimKt.Scrim_KTwxG1Y$lambda$1(j, modifier5, f, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Scrim_KTwxG1Y$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$0$0(long j, float $progress, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        DrawScope.-CC.drawRect-n-J9OG0$default($this$Canvas, j, 0L, 0L, RangesKt.coerceIn(Constant.INSTANCE.getScrimColorAlpha() * $progress, 0.0f, Constant.INSTANCE.getScrimColorAlpha()), (DrawStyle) null, (ColorFilter) null, 0, (int) ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT, (Object) null);
        return Unit.INSTANCE;
    }
}