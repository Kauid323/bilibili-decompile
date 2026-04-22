package kntr.app.ad.ui.uikit.components;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdVerticalDivider.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"AdVerticalDivider", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "AdVerticalDivider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdVerticalDividerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdVerticalDivider_9IZ8Weo$lambda$1(Modifier modifier, float f, long j2, int i, int i2, Composer composer, int i3) {
        m497AdVerticalDivider9IZ8Weo(modifier, f, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: AdVerticalDivider-9IZ8Weo  reason: not valid java name */
    public static final void m497AdVerticalDivider9IZ8Weo(Modifier modifier, float f, long j2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        final long j3;
        Modifier modifier3;
        float f3;
        Modifier modifier4;
        final float f4;
        Composer $composer2 = $composer.startRestartGroup(1959825023);
        ComposerKt.sourceInformation($composer2, "C(AdVerticalDivider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)24@653L193,20@578L268:AdVerticalDivider.kt#oqm2gb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f2 = f;
        } else if (($changed & 48) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 32 : 16;
        } else {
            f2 = f;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            j3 = j2;
        } else if (($changed & 384) == 0) {
            j3 = j2;
            $dirty |= $composer2.changed(j3) ? 256 : 128;
        } else {
            j3 = j2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(1);
            }
            if (i4 != 0) {
                j3 = Color.Companion.getGray-0d7_KjU();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1959825023, $dirty2, -1, "kntr.app.ad.ui.uikit.components.AdVerticalDivider (AdVerticalDivider.kt:20)");
            }
            Modifier modifier5 = SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(modifier4, 0.0f, 1, (Object) null), f4);
            ComposerKt.sourceInformationMarkerStart($composer2, -2098789440, "CC(remember):AdVerticalDivider.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | (($dirty2 & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.ad.ui.uikit.components.AdVerticalDividerKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit AdVerticalDivider_9IZ8Weo$lambda$0$0;
                        AdVerticalDivider_9IZ8Weo$lambda$0$0 = AdVerticalDividerKt.AdVerticalDivider_9IZ8Weo$lambda$0$0(f4, j3, (DrawScope) obj);
                        return AdVerticalDivider_9IZ8Weo$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier5, (Function1) it$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            f3 = f4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final float f5 = f3;
            final long j4 = j3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdVerticalDividerKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdVerticalDivider_9IZ8Weo$lambda$1;
                    AdVerticalDivider_9IZ8Weo$lambda$1 = AdVerticalDividerKt.AdVerticalDivider_9IZ8Weo$lambda$1(modifier6, f5, j4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdVerticalDivider_9IZ8Weo$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdVerticalDivider_9IZ8Weo$lambda$0$0(float f, long j2, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float f2 = $this$Canvas.toPx-0680j_4(f);
        float f3 = 2;
        float x$iv = $this$Canvas.toPx-0680j_4(f) / f3;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(0.0f);
        long j3 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        float x$iv2 = $this$Canvas.toPx-0680j_4(f) / f3;
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv);
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$Canvas, j2, j3, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), f2, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        return Unit.INSTANCE;
    }
}