package kntr.app.digital.preview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardNumberColorUtil.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"getDigitalNumberTextStyle", "Landroidx/compose/ui/text/TextStyle;", "gradientColor", "Lkntr/app/digital/preview/CardNumberGradientColor;", "(Lkntr/app/digital/preview/CardNumberGradientColor;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CardNumberColorUtilKt {
    public static final TextStyle getDigitalNumberTextStyle(CardNumberGradientColor gradientColor, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(gradientColor, "gradientColor");
        $composer.startReplaceGroup(1137588317);
        ComposerKt.sourceInformation($composer, "C(getDigitalNumberTextStyle)N(gradientColor):CardNumberColorUtil.kt#cowxjs");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1137588317, $changed, -1, "kntr.app.digital.preview.getDigitalNumberTextStyle (CardNumberColorUtil.kt:98)");
        }
        TextStyle defaultTextStyle = new TextStyle(Color.Companion.getWhite-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null);
        if (gradientColor.getRgbaColors() == null || gradientColor.getPositions() == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return defaultTextStyle;
        } else if (gradientColor.getRgbaColors().size() != gradientColor.getPositions().size()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return defaultTextStyle;
        } else if (gradientColor.getRgbaColors().size() < 2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return defaultTextStyle;
        } else {
            Brush.Companion companion = Brush.Companion;
            Iterable $this$mapIndexed$iv = gradientColor.getRgbaColors();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                long color = ((Color) item$iv$iv).unbox-impl();
                destination$iv$iv.add(TuplesKt.to(Float.valueOf(gradientColor.getPositions().get(index$iv$iv).floatValue() / 100.0f), Color.box-impl(color)));
                index$iv$iv = index$iv$iv2;
            }
            Collection $this$toTypedArray$iv = (List) destination$iv$iv;
            Pair[] pairArr = (Pair[]) $this$toTypedArray$iv.toArray(new Pair[0]);
            TextStyle textStyle = new TextStyle(Brush.Companion.linearGradient-mHitzGk$default(companion, (Pair[]) Arrays.copyOf(pairArr, pairArr.length), 0L, 0L, 0, 14, (Object) null), 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (DefaultConstructorMarker) null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return textStyle;
        }
    }
}