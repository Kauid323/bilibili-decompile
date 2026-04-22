package kntr.common.bilibubble;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiliBubble.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a]\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0004X\u008a\u008e\u0002²\u0006\u0016\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003X\u008a\u0084\u0002"}, d2 = {"BiliBubble", "", "onCalculateContentWidth", "Lkotlin/Function1;", "", "bubble", "Landroidx/compose/ui/graphics/ImageBitmap;", "bubbleText", "", "leftRatio", "", "rightRatio", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "textBackground", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "BiliBubble-3csKH6Y", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;FFLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "bilibubble_debug", "bubbleWidth", "currentOnContentWidthCalculated"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliBubbleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliBubble_3csKH6Y$lambda$6(Function1 function1, ImageBitmap imageBitmap, String str, float f, float f2, TextStyle textStyle, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m1827BiliBubble3csKH6Y(function1, imageBitmap, str, f, f2, textStyle, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: BiliBubble-3csKH6Y  reason: not valid java name */
    public static final void m1827BiliBubble3csKH6Y(final Function1<? super Integer, Unit> function1, final ImageBitmap bubble, final String bubbleText, final float leftRatio, final float rightRatio, final TextStyle textStyle, final long j, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Object value$iv;
        int $dirty;
        Modifier modifier4;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(function1, "onCalculateContentWidth");
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        Intrinsics.checkNotNullParameter(bubbleText, "bubbleText");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Composer $composer4 = $composer.startRestartGroup(-1671714152);
        ComposerKt.sourceInformation($composer4, "C(BiliBubble)N(onCalculateContentWidth,bubble,bubbleText,leftRatio,rightRatio,textStyle,textBackground:c#ui.graphics.Color,modifier)34@1204L33,35@1281L45,36@1359L105,36@1331L133,42@1489L22,49@1860L1005,47@1817L1048:BiliBubble.kt#4aivx6");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changedInstance(bubble) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(bubbleText) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changed(leftRatio) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changed(rightRatio) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer4.changed(textStyle) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer4.changed(j) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty2 |= 12582912;
            modifier2 = modifier;
        } else if (($changed & 12582912) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 8388608 : 4194304;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1671714152, $dirty2, -1, "kntr.common.bilibubble.BiliBubble (BiliBubble.kt:33)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, -199522727, "CC(remember):BiliBubble.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer4.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            MutableIntState bubbleWidth$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            State currentOnContentWidthCalculated$delegate = SnapshotStateKt.rememberUpdatedState(function1, $composer4, $dirty2 & 14);
            Integer valueOf = Integer.valueOf(BiliBubble_3csKH6Y$lambda$1(bubbleWidth$delegate));
            Modifier modifier5 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer4, -199517695, "CC(remember):BiliBubble.kt#9igjgp");
            boolean invalid$iv = $composer4.changed(currentOnContentWidthCalculated$delegate);
            Object it$iv2 = $composer4.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                value$iv = (Function2) new BiliBubbleKt$BiliBubble$1$1(bubbleWidth$delegate, currentOnContentWidthCalculated$delegate, null);
                $composer4.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(valueOf, (Function2) value$iv, $composer4, 0);
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer4, 0, 1);
            final TextLayoutResult textLayoutResult = TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(bubbleText, (List) null, 2, (DefaultConstructorMarker) null), textStyle, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null);
            final TextLayoutResult textWidth = TextMeasurer.measure-wNUYSr0$default(textMeasurer, bubbleText, textStyle, 0, false, 1, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1004, (Object) null);
            bubbleWidth$delegate.setIntValue((int) ((bubble.getWidth() * leftRatio) + (bubble.getWidth() * rightRatio) + ((int) (textWidth.getSize-YbymL2g() >> 32))));
            ComposerKt.sourceInformationMarkerStart($composer4, -199500763, "CC(remember):BiliBubble.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 7168) == 2048) | $composer4.changedInstance(bubble) | ((3670016 & $dirty2) == 1048576) | $composer4.changedInstance(textWidth) | $composer4.changedInstance(textLayoutResult) | ((57344 & $dirty2) == 16384);
            Object value$iv3 = $composer4.rememberedValue();
            if (invalid$iv2 || value$iv3 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                modifier4 = modifier5;
                $composer3 = $composer4;
                value$iv3 = new Function1() { // from class: kntr.common.bilibubble.BiliBubbleKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit BiliBubble_3csKH6Y$lambda$5$0;
                        BiliBubble_3csKH6Y$lambda$5$0 = BiliBubbleKt.BiliBubble_3csKH6Y$lambda$5$0(leftRatio, bubble, textWidth, j, textLayoutResult, rightRatio, (DrawScope) obj);
                        return BiliBubble_3csKH6Y$lambda$5$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv3);
            } else {
                modifier4 = modifier5;
                $dirty = $dirty2;
                $composer3 = $composer4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            CanvasKt.Canvas(modifier4, (Function1) value$iv3, $composer2, ($dirty >> 21) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.bilibubble.BiliBubbleKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiliBubble_3csKH6Y$lambda$6;
                    BiliBubble_3csKH6Y$lambda$6 = BiliBubbleKt.BiliBubble_3csKH6Y$lambda$6(function1, bubble, bubbleText, leftRatio, rightRatio, textStyle, j, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiliBubble_3csKH6Y$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BiliBubble_3csKH6Y$lambda$1(MutableIntState $bubbleWidth$delegate) {
        IntState $this$getValue$iv = (IntState) $bubbleWidth$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Integer, Unit> BiliBubble_3csKH6Y$lambda$3(State<? extends Function1<? super Integer, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiliBubble_3csKH6Y$lambda$5$0(float $leftRatio, ImageBitmap $bubble, TextLayoutResult $textWidth, long j, TextLayoutResult $textLayoutResult, float $rightRatio, DrawScope $this$Canvas) {
        int top$iv;
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        int left = (int) ($bubble.getWidth() * $leftRatio);
        long j2 = IntOffset.Companion.getZero-nOcc-ac();
        int height$iv = $bubble.getHeight();
        DrawScope.-CC.drawImage-AZ2fEMs$default($this$Canvas, $bubble, 0L, IntSize.constructor-impl((left << 32) | (height$iv & 4294967295L)), j2, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 0, 1010, (Object) null);
        float left$iv = left;
        $this$Canvas.getDrawContext().getTransform().translate(left$iv, 0.0f);
        try {
            float width$iv = (int) ($textWidth.getSize-YbymL2g() >> 32);
            float height$iv2 = $bubble.getHeight();
            long v1$iv$iv = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv = Float.floatToRawIntBits(height$iv2);
            top$iv = 0;
            try {
                DrawScope.-CC.drawRect-n-J9OG0$default($this$Canvas, j, 0L, Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 122, (Object) null);
                float y$iv = ($bubble.getHeight() - ((int) ($textLayoutResult.getSize-YbymL2g() & 4294967295L))) / 2.0f;
                long v1$iv$iv2 = Float.floatToRawIntBits(0.0f);
                long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
                TextPainterKt.drawText-d8-rzKo$default($this$Canvas, $textLayoutResult, 0L, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), 0.0f, (Shadow) null, (TextDecoration) null, (DrawStyle) null, 0, 250, (Object) null);
                $this$Canvas.getDrawContext().getTransform().translate(-left$iv, -0.0f);
                left$iv = left + ((int) ($textWidth.getSize-YbymL2g() >> 32));
                int top$iv2 = 0.0f;
                $this$Canvas.getDrawContext().getTransform().translate(left$iv, top$iv2);
                try {
                    int x$iv = (int) ($bubble.getWidth() - ($bubble.getWidth() * $rightRatio));
                    long j3 = IntOffset.constructor-impl((x$iv << 32) | (0 & 4294967295L));
                    int x$iv2 = $bubble.getWidth();
                    int width$iv2 = (int) (x$iv2 * $rightRatio);
                    int height$iv3 = $bubble.getHeight();
                    DrawScope.-CC.drawImage-AZ2fEMs$default($this$Canvas, $bubble, j3, IntSize.constructor-impl((width$iv2 << 32) | (height$iv3 & 4294967295L)), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 0, 1016, (Object) null);
                    $this$Canvas.getDrawContext().getTransform().translate(-left$iv, -top$iv2);
                    return Unit.INSTANCE;
                } finally {
                    $this$Canvas.getDrawContext().getTransform().translate(-left$iv, -top$iv2);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            top$iv = 0;
        }
    }
}