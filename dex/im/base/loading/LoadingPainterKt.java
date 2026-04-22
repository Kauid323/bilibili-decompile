package im.base.loading;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import faceverify.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: LoadingPainter.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\n\u001a.\u0010\u0007\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000eH\u0082\b\"\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015²\u0006\n\u0010\u0007\u001a\u00020\bX\u008a\u008e\u0002"}, d2 = {"TinyLoadingAnimation", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "colorOnFrame", "Landroidx/compose/ui/graphics/Color;", "frame", "", "colorOnFrame-DxMtmZc", "(JI)J", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", q.KEY_RES_9_CONTENT, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "LOADING_SLOT", "LOADING_FRAME_TICK", "Lkotlin/time/Duration;", "J", "BASE_ALPHA", "", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LoadingPainterKt {
    private static final float BASE_ALPHA = 0.6f;
    private static final long LOADING_FRAME_TICK;
    private static final int LOADING_SLOT = 12;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TinyLoadingAnimation$lambda$5(Modifier modifier, int i2, int i3, Composer composer, int i4) {
        TinyLoadingAnimation(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void TinyLoadingAnimation(Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1533090953);
        ComposerKt.sourceInformation($composer2, "C(TinyLoadingAnimation)N(modifier)23@920L33,24@984L6,26@1023L412,26@1002L433,40@1458L512,40@1441L529:LoadingPainter.kt#fuuht5");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1533090953, $dirty, -1, "im.base.loading.TinyLoadingAnimation (LoadingPainter.kt:22)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 126625738, "CC(remember):LoadingPainter.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableIntState frame$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final long baseColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 126629413, "CC(remember):LoadingPainter.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new LoadingPainterKt$TinyLoadingAnimation$1$1(frame$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 126643433, "CC(remember):LoadingPainter.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(baseColor);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: im.base.loading.LoadingPainterKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit TinyLoadingAnimation$lambda$4$0;
                        TinyLoadingAnimation$lambda$4$0 = LoadingPainterKt.TinyLoadingAnimation$lambda$4$0(frame$delegate, baseColor, (DrawScope) obj);
                        return TinyLoadingAnimation$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier3, (Function1) it$iv3, $composer2, $dirty & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.loading.LoadingPainterKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TinyLoadingAnimation$lambda$5;
                    TinyLoadingAnimation$lambda$5 = LoadingPainterKt.TinyLoadingAnimation$lambda$5(modifier3, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return TinyLoadingAnimation$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TinyLoadingAnimation$lambda$1(MutableIntState $frame$delegate) {
        IntState $this$getValue$iv = (IntState) $frame$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TinyLoadingAnimation$lambda$4$0(MutableIntState $frame$delegate, long $baseColor, DrawScope $this$Canvas) {
        long previousSize$iv$iv$iv;
        DrawContext $this$withTransform_u24lambda_u240$iv$iv$iv;
        long v1$iv$iv;
        float x$iv;
        float width;
        long v1$iv$iv2;
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float height = Float.intBitsToFloat(bits$iv$iv$iv) / 4.0f;
        float width2 = height / 2.5f;
        int frame$iv = TinyLoadingAnimation$lambda$1($frame$delegate);
        boolean z = false;
        int angle$iv = (frame$iv * 360) / 12;
        float degrees$iv$iv = angle$iv;
        DrawScope $this$rotate_u2dRg1IO4c_u24default$iv$iv = $this$Canvas;
        long j = $this$rotate_u2dRg1IO4c_u24default$iv$iv.getCenter-F1C5BW0();
        DrawContext $this$withTransform_u24lambda_u240$iv$iv$iv2 = $this$rotate_u2dRg1IO4c_u24default$iv$iv.getDrawContext();
        boolean z2 = false;
        long previousSize$iv$iv$iv2 = $this$withTransform_u24lambda_u240$iv$iv$iv2.getSize-NH-jbRc();
        $this$withTransform_u24lambda_u240$iv$iv$iv2.getCanvas().save();
        try {
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv2.getTransform();
            $this$rotate_Rg1IO4c_u24lambda_u240$iv$iv.rotate-Uv8p0NA(degrees$iv$iv, j);
            int i2 = 0;
            for (int i3 = 12; i2 < i3; i3 = 12) {
                int it = i2;
                boolean z3 = z;
                int $i$f$frame = it * 360;
                try {
                    float degrees$iv$iv2 = $i$f$frame / i3;
                    long j2 = $this$rotate_u2dRg1IO4c_u24default$iv$iv.getCenter-F1C5BW0();
                    DrawContext $this$withTransform_u24lambda_u240$iv$iv$iv3 = $this$rotate_u2dRg1IO4c_u24default$iv$iv.getDrawContext();
                    long previousSize$iv$iv$iv3 = $this$withTransform_u24lambda_u240$iv$iv$iv3.getSize-NH-jbRc();
                    $this$withTransform_u24lambda_u240$iv$iv$iv3.getCanvas().save();
                    try {
                        DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv$iv2 = $this$withTransform_u24lambda_u240$iv$iv$iv3.getTransform();
                        int angle$iv2 = angle$iv;
                        float degrees$iv$iv3 = degrees$iv$iv;
                        try {
                            $this$rotate_Rg1IO4c_u24lambda_u240$iv$iv2.rotate-Uv8p0NA(degrees$iv$iv2, j2);
                            try {
                                long m3114colorOnFrameDxMtmZc = m3114colorOnFrameDxMtmZc($baseColor, it);
                                int bits$iv$iv$iv2 = (int) ($this$rotate_u2dRg1IO4c_u24default$iv$iv.getSize-NH-jbRc() >> 32);
                                float f2 = 2;
                                try {
                                    long floatToRawIntBits = Float.floatToRawIntBits((Float.intBitsToFloat(bits$iv$iv$iv2) - width2) / f2);
                                    try {
                                        DrawScope $this$rotate_u2dRg1IO4c_u24default$iv$iv2 = $this$rotate_u2dRg1IO4c_u24default$iv$iv;
                                        long j3 = j;
                                        long v2$iv$iv = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                        long v1$iv$iv3 = (floatToRawIntBits << 32) | (v2$iv$iv & 4294967295L);
                                        try {
                                            long v1$iv$iv4 = Offset.constructor-impl(v1$iv$iv3);
                                            float height$iv = height;
                                            float width$iv = width2;
                                            boolean z4 = z2;
                                            float height2 = height;
                                            long v1$iv$iv5 = Float.floatToRawIntBits(width$iv);
                                            try {
                                                long v2$iv$iv2 = Float.floatToRawIntBits(height$iv);
                                                v1$iv$iv = Size.constructor-impl((v1$iv$iv5 << 32) | (v2$iv$iv2 & 4294967295L));
                                                x$iv = width2 / f2;
                                                width = width2;
                                                v1$iv$iv2 = Float.floatToRawIntBits(x$iv);
                                            } catch (Throwable th) {
                                                th = th;
                                                $this$withTransform_u24lambda_u240$iv$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv3;
                                                previousSize$iv$iv$iv = previousSize$iv$iv$iv3;
                                            }
                                            try {
                                                long v2$iv$iv3 = Float.floatToRawIntBits(x$iv);
                                                DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$rotate_u2dRg1IO4c_u24default$iv$iv, m3114colorOnFrameDxMtmZc, v1$iv$iv4, v1$iv$iv, CornerRadius.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv3 & 4294967295L)), (DrawStyle) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, 0, (int) TbsListener.ErrorCode.TPATCH_VERSION_FAILED, (Object) null);
                                                try {
                                                    $this$withTransform_u24lambda_u240$iv$iv$iv3.getCanvas().restore();
                                                    $this$withTransform_u24lambda_u240$iv$iv$iv3.setSize-uvyYCjk(previousSize$iv$iv$iv3);
                                                    i2++;
                                                    z = z3;
                                                    angle$iv = angle$iv2;
                                                    degrees$iv$iv = degrees$iv$iv3;
                                                    $this$rotate_u2dRg1IO4c_u24default$iv$iv = $this$rotate_u2dRg1IO4c_u24default$iv$iv2;
                                                    j = j3;
                                                    height = height2;
                                                    z2 = z4;
                                                    width2 = width;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    $this$withTransform_u24lambda_u240$iv$iv$iv2.getCanvas().restore();
                                                    $this$withTransform_u24lambda_u240$iv$iv$iv2.setSize-uvyYCjk(previousSize$iv$iv$iv2);
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                $this$withTransform_u24lambda_u240$iv$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv3;
                                                previousSize$iv$iv$iv = previousSize$iv$iv$iv3;
                                                $this$withTransform_u24lambda_u240$iv$iv$iv.getCanvas().restore();
                                                $this$withTransform_u24lambda_u240$iv$iv$iv.setSize-uvyYCjk(previousSize$iv$iv$iv);
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            $this$withTransform_u24lambda_u240$iv$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv3;
                                            previousSize$iv$iv$iv = previousSize$iv$iv$iv3;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        $this$withTransform_u24lambda_u240$iv$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv3;
                                        previousSize$iv$iv$iv = previousSize$iv$iv$iv3;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    $this$withTransform_u24lambda_u240$iv$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv3;
                                    previousSize$iv$iv$iv = previousSize$iv$iv$iv3;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                $this$withTransform_u24lambda_u240$iv$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv3;
                                previousSize$iv$iv$iv = previousSize$iv$iv$iv3;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            $this$withTransform_u24lambda_u240$iv$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv3;
                            previousSize$iv$iv$iv = previousSize$iv$iv$iv3;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        previousSize$iv$iv$iv = previousSize$iv$iv$iv3;
                        $this$withTransform_u24lambda_u240$iv$iv$iv = $this$withTransform_u24lambda_u240$iv$iv$iv3;
                    }
                } catch (Throwable th10) {
                    th = th10;
                }
            }
            $this$withTransform_u24lambda_u240$iv$iv$iv2.getCanvas().restore();
            $this$withTransform_u24lambda_u240$iv$iv$iv2.setSize-uvyYCjk(previousSize$iv$iv$iv2);
            return Unit.INSTANCE;
        } catch (Throwable th11) {
            th = th11;
        }
    }

    /* renamed from: colorOnFrame-DxMtmZc  reason: not valid java name */
    private static final long m3114colorOnFrameDxMtmZc(long j, int frame) {
        return Color.copy-wmQWz5c$default(j, BASE_ALPHA - ((frame * BASE_ALPHA) / 12), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 14, (Object) null);
    }

    private static final void frame(DrawScope $this$frame, int frame, Function1<? super DrawScope, Unit> function1) {
        int angle = (frame * 360) / 12;
        float degrees$iv = angle;
        long j = $this$frame.getCenter-F1C5BW0();
        DrawContext $this$withTransform_u24lambda_u240$iv$iv = $this$frame.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u240$iv$iv.getSize-NH-jbRc();
        $this$withTransform_u24lambda_u240$iv$iv.getCanvas().save();
        try {
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u240$iv$iv.getTransform();
            $this$rotate_Rg1IO4c_u24lambda_u240$iv.rotate-Uv8p0NA(degrees$iv, j);
            try {
                function1.invoke($this$frame);
                InlineMarker.finallyStart(1);
                $this$withTransform_u24lambda_u240$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u240$iv$iv.setSize-uvyYCjk(previousSize$iv$iv);
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                th = th;
                InlineMarker.finallyStart(1);
                $this$withTransform_u24lambda_u240$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u240$iv$iv.setSize-uvyYCjk(previousSize$iv$iv);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static {
        Duration.Companion companion = Duration.Companion;
        LOADING_FRAME_TICK = DurationKt.toDuration(200, DurationUnit.MILLISECONDS);
    }
}