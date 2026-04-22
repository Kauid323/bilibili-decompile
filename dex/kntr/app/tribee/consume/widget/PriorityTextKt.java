package kntr.app.tribee.consume.widget;

import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriorityText.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"PriorityOverflowText", "", "endText", "", "content", "modifier", "Landroidx/compose/ui/Modifier;", "contentStyle", "Landroidx/compose/ui/text/TextStyle;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PriorityTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriorityOverflowText$lambda$1(String str, String str2, Modifier modifier, TextStyle textStyle, int i, int i2, Composer composer, int i3) {
        PriorityOverflowText(str, str2, modifier, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void PriorityOverflowText(final String endText, final String content, Modifier modifier, TextStyle contentStyle, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final TextStyle contentStyle2;
        Modifier modifier3;
        TextStyle contentStyle3;
        Modifier modifier4;
        int i2;
        Intrinsics.checkNotNullParameter(endText, "endText");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1032377688);
        ComposerKt.sourceInformation($composer2, "C(PriorityOverflowText)N(endText,content,modifier,contentStyle)25@901L2211,25@861L2251:PriorityText.kt#vkdvar");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(endText) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(content) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentStyle2 = contentStyle;
                if ($composer2.changed(contentStyle2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                contentStyle2 = contentStyle;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            contentStyle2 = contentStyle;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "23@820L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier4 = modifier2;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    contentStyle2 = new TextStyle(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(18), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1032377688, $dirty, -1, "kntr.app.tribee.consume.widget.PriorityOverflowText (PriorityText.kt:24)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(modifier4, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-916025918, true, new Function3() { // from class: kntr.app.tribee.consume.widget.PriorityTextKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PriorityOverflowText$lambda$0;
                    PriorityOverflowText$lambda$0 = PriorityTextKt.PriorityOverflowText$lambda$0(content, endText, contentStyle2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PriorityOverflowText$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            contentStyle3 = contentStyle2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            contentStyle3 = contentStyle2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final TextStyle textStyle = contentStyle3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.widget.PriorityTextKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriorityOverflowText$lambda$1;
                    PriorityOverflowText$lambda$1 = PriorityTextKt.PriorityOverflowText$lambda$1(endText, content, modifier5, textStyle, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PriorityOverflowText$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriorityOverflowText$lambda$0(String $content, String $endText, TextStyle $contentStyle, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Composer $this$cache$iv;
        AnnotatedString annotatedString;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C26@938L7,27@973L22,30@1113L1896,74@3019L87:PriorityText.kt#vkdvar");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-916025918, $dirty2, -1, "kntr.app.tribee.consume.widget.PriorityOverflowText.<anonymous> (PriorityText.kt:26)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density = (Density) consume;
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer, 0, 1);
            int constrainedMaxWidth = density.roundToPx-0680j_4($this$BoxWithConstraints.getMaxWidth-D9Ej5fM());
            ComposerKt.sourceInformationMarkerStart($composer, 167397162, "CC(remember):PriorityText.kt#9igjgp");
            boolean invalid$iv = $composer.changed($content) | $composer.changed($endText) | $composer.changed(constrainedMaxWidth);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                TextLayoutResult normalLayoutResult = TextMeasurer.measure-wNUYSr0$default(textMeasurer, $content + $endText, $contentStyle, 0, false, 1, Constraints.Companion.fixedWidth-OenEA2s(constrainedMaxWidth), (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 972, (Object) null);
                if (normalLayoutResult.getHasVisualOverflow()) {
                    int endWidth = (int) (TextMeasurer.measure-wNUYSr0$default(textMeasurer, "…" + $endText, $contentStyle, 0, false, 1, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1004, (Object) null).getSize-YbymL2g() >> 32);
                    int remainedSpace = ((int) (normalLayoutResult.getSize-YbymL2g() >> 32)) - endWidth;
                    $this$cache$iv = $composer;
                    TextLayoutResult it = TextMeasurer.measure-wNUYSr0$default(textMeasurer, $content, $contentStyle, 0, false, 1, Constraints.Companion.fixedWidth-OenEA2s(remainedSpace), (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 972, (Object) null);
                    int subOffset = TextLayoutResult.getLineEnd$default(it, it.getLineCount() - 1, false, 2, (Object) null);
                    AnnotatedString.Builder $this$PriorityOverflowText_u24lambda_u240_u241_u241 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                    if (subOffset >= 0 && subOffset < $content.length()) {
                        String substring = $content.substring(0, subOffset);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        $this$PriorityOverflowText_u24lambda_u240_u241_u241.append(substring);
                        $this$PriorityOverflowText_u24lambda_u240_u241_u241.append("…");
                    } else {
                        $this$PriorityOverflowText_u24lambda_u240_u241_u241.append($content);
                    }
                    $this$PriorityOverflowText_u24lambda_u240_u241_u241.append($endText);
                    annotatedString = $this$PriorityOverflowText_u24lambda_u240_u241_u241.toAnnotatedString();
                } else {
                    $this$cache$iv = $composer;
                    AnnotatedString.Builder $this$PriorityOverflowText_u24lambda_u240_u241_u242 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                    $this$PriorityOverflowText_u24lambda_u240_u241_u242.append($content);
                    $this$PriorityOverflowText_u24lambda_u240_u241_u242.append($endText);
                    annotatedString = $this$PriorityOverflowText_u24lambda_u240_u241_u242.toAnnotatedString();
                }
                value$iv = annotatedString;
                $this$cache$iv.updateRememberedValue(value$iv);
            }
            AnnotatedString finalPriorityText = (AnnotatedString) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Z58ophY(finalPriorityText, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, $contentStyle, $composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}