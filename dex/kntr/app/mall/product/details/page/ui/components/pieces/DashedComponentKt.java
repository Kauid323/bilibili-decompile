package kntr.app.mall.product.details.page.ui.components.pieces;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashedComponent.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b\r\u0010\u000b\u001aC\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"DashedDivider", "", "thickness", "Landroidx/compose/ui/unit/Dp;", "on", "off", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "DashedDivider-GCwHvm0", "(FFFLandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DashedVerticalLine", "DashedVerticalLine-GCwHvm0", "DashedBorderBox", "cornerRadius", "strokeWidth", "DashedBorderBox-fQ-5IY4", "(FFFFLandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DashedComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DashedBorderBox_fQ_5IY4$lambda$2(float f, float f2, float f3, float f4, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m545DashedBorderBoxfQ5IY4(f, f2, f3, f4, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DashedDivider_GCwHvm0$lambda$2(float f, float f2, float f3, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m546DashedDividerGCwHvm0(f, f2, f3, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DashedVerticalLine_GCwHvm0$lambda$2(float f, float f2, float f3, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m547DashedVerticalLineGCwHvm0(f, f2, f3, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b0, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e0  */
    /* renamed from: DashedDivider-GCwHvm0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m546DashedDividerGCwHvm0(final float f, final float f2, final float f3, Modifier modifier, long j, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j2;
        long j3;
        Modifier modifier3;
        Modifier modifier4;
        boolean invalid$iv;
        Modifier modifier5;
        Composer $composer2 = $composer.startRestartGroup(-678715775);
        ComposerKt.sourceInformation($composer2, "C(DashedDivider)N(thickness:c#ui.unit.Dp,on:c#ui.unit.Dp,off:c#ui.unit.Dp,modifier,color:c#ui.graphics.Color)27@990L7,29@1043L155,40@1344L464,35@1204L611:DashedComponent.kt#v057zd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(f) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(f2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(f3) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            j2 = j;
        } else if (($changed & 24576) == 0) {
            j2 = j;
            $dirty |= $composer2.changed(j2) ? 16384 : 8192;
        } else {
            j2 = j;
        }
        if ($composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                j2 = ColorKt.Color(4292730333L);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-678715775, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.pieces.DashedDivider (DashedComponent.kt:26)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 589176540, "CC(remember):DashedComponent.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 14) == 4) | (($dirty & 112) == 32) | (($dirty & 896) == 256) | $composer2.changed(density);
            Object it$iv = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                Triple triple = (Triple) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final float thicknessPx = ((Number) triple.component1()).floatValue();
                final float onPx = ((Number) triple.component2()).floatValue();
                final float offPx = ((Number) triple.component3()).floatValue();
                Modifier modifier6 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), f);
                ComposerKt.sourceInformationMarkerStart($composer2, 589186481, "CC(remember):DashedComponent.kt#9igjgp");
                invalid$iv = $composer2.changed(onPx) | $composer2.changed(offPx) | ((57344 & $dirty) != 16384) | $composer2.changed(thicknessPx);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                    modifier5 = modifier4;
                } else {
                    modifier5 = modifier4;
                }
                final long j4 = j2;
                Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit DashedDivider_GCwHvm0$lambda$1$0;
                        DashedDivider_GCwHvm0$lambda$1$0 = DashedComponentKt.DashedDivider_GCwHvm0$lambda$1$0(onPx, offPx, j4, thicknessPx, (DrawScope) obj);
                        return DashedDivider_GCwHvm0$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BoxKt.Box(DrawModifierKt.drawBehind(modifier6, (Function1) it$iv2), $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j2;
                modifier3 = modifier5;
            }
            Object value$iv2 = new Triple(Float.valueOf(density.toPx-0680j_4(f)), Float.valueOf(density.toPx-0680j_4(f2)), Float.valueOf(density.toPx-0680j_4(f3)));
            $composer2.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            Triple triple2 = (Triple) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final float thicknessPx2 = ((Number) triple2.component1()).floatValue();
            final float onPx2 = ((Number) triple2.component2()).floatValue();
            final float offPx2 = ((Number) triple2.component3()).floatValue();
            Modifier modifier62 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), f);
            ComposerKt.sourceInformationMarkerStart($composer2, 589186481, "CC(remember):DashedComponent.kt#9igjgp");
            invalid$iv = $composer2.changed(onPx2) | $composer2.changed(offPx2) | ((57344 & $dirty) != 16384) | $composer2.changed(thicknessPx2);
            Object it$iv22 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final long j42 = j2;
            Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit DashedDivider_GCwHvm0$lambda$1$0;
                    DashedDivider_GCwHvm0$lambda$1$0 = DashedComponentKt.DashedDivider_GCwHvm0$lambda$1$0(onPx2, offPx2, j42, thicknessPx2, (DrawScope) obj);
                    return DashedDivider_GCwHvm0$lambda$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv22 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BoxKt.Box(DrawModifierKt.drawBehind(modifier62, (Function1) it$iv22), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j3 = j2;
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            j3 = j2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final long j5 = j3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit DashedDivider_GCwHvm0$lambda$2;
                    DashedDivider_GCwHvm0$lambda$2 = DashedComponentKt.DashedDivider_GCwHvm0$lambda$2(f, f2, f3, modifier7, j5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DashedDivider_GCwHvm0$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DashedDivider_GCwHvm0$lambda$1$0(float $onPx, float $offPx, long j, float $thicknessPx, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
        float y = Float.intBitsToFloat(bits$iv$iv$iv) / 2;
        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
        long v2$iv$iv = Float.floatToRawIntBits(y);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$drawBehind.getSize-NH-jbRc() >> 32);
        float x$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv2 = Float.floatToRawIntBits(y);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawBehind, j, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), $thicknessPx, StrokeCap.Companion.getButt-KaPHkGw(), PathEffect.Companion.dashPathEffect(new float[]{$onPx, $offPx}, 0.0f), 0.0f, (ColorFilter) null, 0, 448, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x01aa, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01da  */
    /* renamed from: DashedVerticalLine-GCwHvm0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m547DashedVerticalLineGCwHvm0(final float f, final float f2, final float f3, Modifier modifier, long j, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        boolean invalid$iv;
        Composer $composer2 = $composer.startRestartGroup(668448402);
        ComposerKt.sourceInformation($composer2, "C(DashedVerticalLine)N(thickness:c#ui.unit.Dp,on:c#ui.unit.Dp,off:c#ui.unit.Dp,modifier,color:c#ui.graphics.Color)62@2016L7,64@2069L127,72@2307L407,68@2202L519:DashedComponent.kt#v057zd");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(f) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(f2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(f3) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            j2 = j;
        } else if (($changed & 24576) == 0) {
            j2 = j;
            $dirty2 |= $composer2.changed(j2) ? 16384 : 8192;
        } else {
            j2 = j;
        }
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                j2 = ColorKt.Color(4292730333L);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(668448402, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.pieces.DashedVerticalLine (DashedComponent.kt:61)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, -1866172623, "CC(remember):DashedComponent.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32) | (($dirty2 & 896) == 256) | $composer2.changed(density);
            Object it$iv = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                Triple triple = (Triple) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final float thicknessPx = ((Number) triple.component1()).floatValue();
                final float onPx = ((Number) triple.component2()).floatValue();
                final float offPx = ((Number) triple.component3()).floatValue();
                modifier3 = modifier4;
                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(modifier4, f), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, -1866164727, "CC(remember):DashedComponent.kt#9igjgp");
                invalid$iv = ((57344 & $dirty2) == 16384) | $composer2.changed(onPx) | $composer2.changed(offPx) | $composer2.changed(thicknessPx);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                    $dirty = $dirty2;
                } else {
                    $dirty = $dirty2;
                }
                final long j3 = j2;
                Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit DashedVerticalLine_GCwHvm0$lambda$1$0;
                        DashedVerticalLine_GCwHvm0$lambda$1$0 = DashedComponentKt.DashedVerticalLine_GCwHvm0$lambda$1$0(onPx, offPx, j3, thicknessPx, (DrawScope) obj);
                        return DashedVerticalLine_GCwHvm0$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BoxKt.Box(DrawModifierKt.drawBehind(fillMaxHeight$default, (Function1) it$iv2), $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv2 = new Triple(Float.valueOf(density.toPx-0680j_4(f)), Float.valueOf(density.toPx-0680j_4(f2)), Float.valueOf(density.toPx-0680j_4(f3)));
            $composer2.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            Triple triple2 = (Triple) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final float thicknessPx2 = ((Number) triple2.component1()).floatValue();
            final float onPx2 = ((Number) triple2.component2()).floatValue();
            final float offPx2 = ((Number) triple2.component3()).floatValue();
            modifier3 = modifier4;
            Modifier fillMaxHeight$default2 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(modifier4, f), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1866164727, "CC(remember):DashedComponent.kt#9igjgp");
            invalid$iv = ((57344 & $dirty2) == 16384) | $composer2.changed(onPx2) | $composer2.changed(offPx2) | $composer2.changed(thicknessPx2);
            Object it$iv22 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final long j32 = j2;
            Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit DashedVerticalLine_GCwHvm0$lambda$1$0;
                    DashedVerticalLine_GCwHvm0$lambda$1$0 = DashedComponentKt.DashedVerticalLine_GCwHvm0$lambda$1$0(onPx2, offPx2, j32, thicknessPx2, (DrawScope) obj);
                    return DashedVerticalLine_GCwHvm0$lambda$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv22 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BoxKt.Box(DrawModifierKt.drawBehind(fillMaxHeight$default2, (Function1) it$iv22), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j4 = j2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit DashedVerticalLine_GCwHvm0$lambda$2;
                    DashedVerticalLine_GCwHvm0$lambda$2 = DashedComponentKt.DashedVerticalLine_GCwHvm0$lambda$2(f, f2, f3, modifier5, j4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DashedVerticalLine_GCwHvm0$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DashedVerticalLine_GCwHvm0$lambda$1$0(float $onPx, float $offPx, long j, float $thicknessPx, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() >> 32);
        float x = Float.intBitsToFloat(bits$iv$iv$iv) / 2.0f;
        long v1$iv$iv = Float.floatToRawIntBits(x);
        long v2$iv$iv = Float.floatToRawIntBits(0.0f);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
        long v1$iv$iv2 = Float.floatToRawIntBits(x);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawBehind, j, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), $thicknessPx, StrokeCap.Companion.getButt-KaPHkGw(), PathEffect.Companion.dashPathEffect(new float[]{$onPx, $offPx}, 0.0f), 0.0f, (ColorFilter) null, 0, 448, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e0, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d8  */
    /* renamed from: DashedBorderBox-fQ-5IY4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m545DashedBorderBoxfQ5IY4(final float f, final float f2, final float f3, final float f4, Modifier modifier, long j, Composer $composer, final int $changed, final int i) {
        long j2;
        int $dirty;
        Modifier modifier2;
        long j3;
        Modifier modifier3;
        long j4;
        boolean invalid$iv;
        Composer $composer2 = $composer.startRestartGroup(875773451);
        ComposerKt.sourceInformation($composer2, "C(DashedBorderBox)N(cornerRadius:c#ui.unit.Dp,strokeWidth:c#ui.unit.Dp,on:c#ui.unit.Dp,off:c#ui.unit.Dp,modifier,color:c#ui.graphics.Color)96@2960L7,98@3010L167,103@3216L419,102@3183L459:DashedComponent.kt#v057zd");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(f) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(f2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(f3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(f4) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 16384 : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= 196608;
            j2 = j;
        } else if (($changed & 196608) == 0) {
            j2 = j;
            $dirty2 |= $composer2.changed(j2) ? 131072 : 65536;
        } else {
            j2 = j;
        }
        if (!$composer2.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            j3 = j2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 == 0) {
                j4 = j2;
            } else {
                j4 = ColorKt.Color(4289374890L);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(875773451, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.pieces.DashedBorderBox (DashedComponent.kt:95)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, -195295534, "CC(remember):DashedComponent.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32) | (($dirty2 & 896) == 256) | (($dirty2 & 7168) == 2048) | $composer2.changed(density);
            Object it$iv = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                Float[] fArr = (Float[]) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final float rPx = fArr[0].floatValue();
                final float wPx = fArr[1].floatValue();
                final float onPx = fArr[2].floatValue();
                final float offPx = fArr[3].floatValue();
                ComposerKt.sourceInformationMarkerStart($composer2, -195288690, "CC(remember):DashedComponent.kt#9igjgp");
                $dirty = $dirty2;
                invalid$iv = $composer2.changed(wPx) | $composer2.changed(onPx) | $composer2.changed(offPx) | $composer2.changed(rPx) | ((458752 & $dirty2) == 131072);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                final long j5 = j4;
                Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit DashedBorderBox_fQ_5IY4$lambda$1$0;
                        DashedBorderBox_fQ_5IY4$lambda$1$0 = DashedComponentKt.DashedBorderBox_fQ_5IY4$lambda$1$0(wPx, onPx, offPx, rPx, j5, (DrawScope) obj);
                        return DashedBorderBox_fQ_5IY4$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BoxKt.Box(DrawModifierKt.drawBehind(modifier3, (Function1) it$iv2), $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = j4;
            }
            Float[] fArr2 = {Float.valueOf(density.toPx-0680j_4(f)), Float.valueOf(density.toPx-0680j_4(f2)), Float.valueOf(density.toPx-0680j_4(f3)), Float.valueOf(density.toPx-0680j_4(f4))};
            $composer2.updateRememberedValue(fArr2);
            it$iv = fArr2;
            Float[] fArr3 = (Float[]) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final float rPx2 = fArr3[0].floatValue();
            final float wPx2 = fArr3[1].floatValue();
            final float onPx2 = fArr3[2].floatValue();
            final float offPx2 = fArr3[3].floatValue();
            ComposerKt.sourceInformationMarkerStart($composer2, -195288690, "CC(remember):DashedComponent.kt#9igjgp");
            $dirty = $dirty2;
            invalid$iv = $composer2.changed(wPx2) | $composer2.changed(onPx2) | $composer2.changed(offPx2) | $composer2.changed(rPx2) | ((458752 & $dirty2) == 131072);
            Object it$iv22 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final long j52 = j4;
            Object value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit DashedBorderBox_fQ_5IY4$lambda$1$0;
                    DashedBorderBox_fQ_5IY4$lambda$1$0 = DashedComponentKt.DashedBorderBox_fQ_5IY4$lambda$1$0(wPx2, onPx2, offPx2, rPx2, j52, (DrawScope) obj);
                    return DashedBorderBox_fQ_5IY4$lambda$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv22 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BoxKt.Box(DrawModifierKt.drawBehind(modifier3, (Function1) it$iv22), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            j3 = j4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final long j6 = j3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.DashedComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit DashedBorderBox_fQ_5IY4$lambda$2;
                    DashedBorderBox_fQ_5IY4$lambda$2 = DashedComponentKt.DashedBorderBox_fQ_5IY4$lambda$2(f, f2, f3, f4, modifier4, j6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DashedBorderBox_fQ_5IY4$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DashedBorderBox_fQ_5IY4$lambda$1$0(float $wPx, float $onPx, float $offPx, float $rPx, long j, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        DrawStyle stroke = new Stroke($wPx, 0.0f, 0, 0, PathEffect.Companion.dashPathEffect(new float[]{$onPx, $offPx}, 0.0f), 14, (DefaultConstructorMarker) null);
        long v1$iv$iv = Float.floatToRawIntBits($rPx);
        long v2$iv$iv = Float.floatToRawIntBits($rPx);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$drawBehind, j, 0L, 0L, CornerRadius.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)), stroke, 0.0f, (ColorFilter) null, 0, 230, (Object) null);
        return Unit.INSTANCE;
    }
}