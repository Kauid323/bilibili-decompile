package kntr.app.mall.product.details.page.ui.scale;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProvideUiScale.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\t*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0013\u001a\u0019\u0010\u000f\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\u0012\u001a\u00020\f*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0014\u001a\u0019\u0010\u000f\u001a\u00020\t*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0016\u001a\u0019\u0010\u0012\u001a\u00020\f*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0017\u001a\u0014\u0010\b\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0019"}, d2 = {"ProvideUiScale", "", "scale", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "scaled", "Landroidx/compose/ui/unit/Dp;", "scaled-D5KLDUw", "(FF)F", "Landroidx/compose/ui/unit/TextUnit;", "scaled-eAf_CNQ", "(JF)J", "dpScaled", "", "(IF)F", "spScaled", "(IF)J", "(FF)J", "", "(DF)F", "(DF)J", "Landroidx/compose/ui/text/TextStyle;", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProvideUiScaleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideUiScale$lambda$2(float f, Function2 function2, int i, Composer composer, int i2) {
        ProvideUiScale(f, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProvideUiScale(final float scale, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(1094040277);
        ComposerKt.sourceInformation($composer2, "C(ProvideUiScale)N(scale,content)22@803L7,24@836L235,31@1131L25,31@1076L80:ProvideUiScale.kt#1ugs58");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(scale) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1094040277, $dirty, -1, "kntr.app.mall.product.details.page.ui.scale.ProvideUiScale (ProvideUiScale.kt:20)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density base = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, -894275488, "CC(remember):ProvideUiScale.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(base) | (($dirty & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = DensityKt.Density(base.getDensity() * scale, base.getFontScale() * scale);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Density scaled = (Density) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalDensity().provides(scaled), ComposableLambdaKt.rememberComposableLambda(1941122581, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProvideUiScale$lambda$1;
                    ProvideUiScale$lambda$1 = ProvideUiScaleKt.ProvideUiScale$lambda$1(function2, (Composer) obj, ((Integer) obj2).intValue());
                    return ProvideUiScale$lambda$1;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProvideUiScale$lambda$2;
                    ProvideUiScale$lambda$2 = ProvideUiScaleKt.ProvideUiScale$lambda$2(scale, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ProvideUiScale$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideUiScale$lambda$1(Function2 $content, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C32@1141L9:ProvideUiScale.kt#1ugs58");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1941122581, $changed, -1, "kntr.app.mall.product.details.page.ui.scale.ProvideUiScale.<anonymous> (ProvideUiScale.kt:32)");
            }
            $content.invoke($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: scaled-D5KLDUw  reason: not valid java name */
    public static final float m606scaledD5KLDUw(float f, float scale) {
        float other$iv = Dp.constructor-impl(f * scale);
        return other$iv;
    }

    /* renamed from: scaled-eAf_CNQ  reason: not valid java name */
    public static final long m607scaledeAf_CNQ(long j, float scale) {
        long j2 = TextUnit.getType-UIouoOA(j);
        if (!TextUnitType.equals-impl0(j2, TextUnitType.Companion.getSp-UIouoOA()) && !TextUnitType.equals-impl0(j2, TextUnitType.Companion.getEm-UIouoOA())) {
            return j;
        }
        TextUnitKt.checkArithmetic--R2X_6o(j);
        return TextUnitKt.pack(TextUnit.getRawType-impl(j), TextUnit.getValue-impl(j) * scale);
    }

    public static final float dpScaled(int $this$dpScaled, float scale) {
        return m606scaledD5KLDUw(Dp.constructor-impl($this$dpScaled), scale);
    }

    public static final long spScaled(int $this$spScaled, float scale) {
        return m607scaledeAf_CNQ(TextUnitKt.getSp($this$spScaled), scale);
    }

    public static final float dpScaled(float $this$dpScaled, float scale) {
        float $this$dp$iv = Dp.constructor-impl($this$dpScaled);
        return m606scaledD5KLDUw($this$dp$iv, scale);
    }

    public static final long spScaled(float $this$spScaled, float scale) {
        return m607scaledeAf_CNQ(TextUnitKt.getSp($this$spScaled), scale);
    }

    public static final float dpScaled(double $this$dpScaled, float scale) {
        return m606scaledD5KLDUw(Dp.constructor-impl((float) $this$dpScaled), scale);
    }

    public static final long spScaled(double $this$spScaled, float scale) {
        return m607scaledeAf_CNQ(TextUnitKt.getSp($this$spScaled), scale);
    }

    public static final TextStyle scaled(TextStyle $this$scaled, float scale) {
        Intrinsics.checkNotNullParameter($this$scaled, "<this>");
        return TextStyle.copy-p1EtxEg$default($this$scaled, 0L, m607scaledeAf_CNQ($this$scaled.getFontSize-XSAIIZE(), scale), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, m607scaledeAf_CNQ($this$scaled.getLetterSpacing-XSAIIZE(), scale), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, m607scaledeAf_CNQ($this$scaled.getLineHeight-XSAIIZE(), scale), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646013, (Object) null);
    }
}