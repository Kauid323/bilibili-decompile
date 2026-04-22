package tv.danmaku.bili.splash.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: SplashCircleCountdownButton.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a[\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"createCircleCountdownButton", "Landroidx/compose/ui/platform/ComposeView;", "context", "Landroid/content/Context;", "duration", "", "onClose", "Lkotlin/Function0;", "", "onFinish", "CircleCountdownView", "circleWidth", "", "crossLineWidth", "crossLinePercent", "mainColor", "Landroidx/compose/ui/graphics/Color;", "progressColor", "CircleCountdownView-vRFhKjU", "(FFFJJILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "adsplash_debug", "play", "", "angleAnimation"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashCircleCountdownButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircleCountdownView_vRFhKjU$lambda$9(float f, float f2, float f3, long j, long j2, int i, Function0 function0, int i2, int i3, Composer composer, int i4) {
        m1473CircleCountdownViewvRFhKjU(f, f2, f3, j, j2, i, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ ComposeView createCircleCountdownButton$default(Context context, int i, Function0 function0, Function0 function02, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3000;
        }
        if ((i2 & 4) != 0) {
            function0 = new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i2 & 8) != 0) {
            function02 = new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        return createCircleCountdownButton(context, i, function0, function02);
    }

    public static final ComposeView createCircleCountdownButton(Context context, final int duration, final Function0<Unit> function0, final Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        Intrinsics.checkNotNullParameter(function02, "onFinish");
        final ComposeView $this$createCircleCountdownButton_u24lambda_u242 = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        int size = ListExtentionsKt.toPx(30);
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(size, size);
        ((ConstraintLayout.LayoutParams) layoutParams).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).bottomMargin = ListExtentionsKt.toPx((int) BR.countdownTip);
        $this$createCircleCountdownButton_u24lambda_u242.setLayoutParams(layoutParams);
        $this$createCircleCountdownButton_u24lambda_u242.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashCircleCountdownButtonKt.createCircleCountdownButton$lambda$2$1(function0, $this$createCircleCountdownButton_u24lambda_u242, view);
            }
        });
        $this$createCircleCountdownButton_u24lambda_u242.setContent(ComposableLambdaKt.composableLambdaInstance(-889722795, true, new Function2() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Unit createCircleCountdownButton$lambda$2$2;
                createCircleCountdownButton$lambda$2$2 = SplashCircleCountdownButtonKt.createCircleCountdownButton$lambda$2$2(duration, function02, $this$createCircleCountdownButton_u24lambda_u242, (Composer) obj, ((Integer) obj2).intValue());
                return createCircleCountdownButton$lambda$2$2;
            }
        }));
        return $this$createCircleCountdownButton_u24lambda_u242;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCircleCountdownButton$lambda$2$1(Function0 $onClose, ComposeView $this_apply, View it) {
        $onClose.invoke();
        $this_apply.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createCircleCountdownButton$lambda$2$2(int $duration, final Function0 $onFinish, final ComposeView $this_apply, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C44@1871L76,44@1830L117:SplashCircleCountdownButton.kt#l60eyh");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-889722795, $changed, -1, "tv.danmaku.bili.splash.ad.widget.createCircleCountdownButton.<anonymous>.<anonymous> (SplashCircleCountdownButton.kt:44)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -325112383, "CC(remember):SplashCircleCountdownButton.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onFinish) | $composer.changedInstance($this_apply);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit createCircleCountdownButton$lambda$2$2$0$0;
                        createCircleCountdownButton$lambda$2$2$0$0 = SplashCircleCountdownButtonKt.createCircleCountdownButton$lambda$2$2$0$0($onFinish, $this_apply);
                        return createCircleCountdownButton$lambda$2$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            m1473CircleCountdownViewvRFhKjU(0.0f, 0.0f, 0.0f, 0L, 0L, $duration, (Function0) it$iv, $composer, 0, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createCircleCountdownButton$lambda$2$2$0$0(Function0 $onFinish, ComposeView $this_apply) {
        $onFinish.invoke();
        $this_apply.setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x026b, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0330, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L100;
     */
    /* renamed from: CircleCountdownView-vRFhKjU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1473CircleCountdownViewvRFhKjU(float circleWidth, float crossLineWidth, float crossLinePercent, long j, long j2, int duration, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        float crossLineWidth2;
        float crossLinePercent2;
        long j3;
        int i2;
        long j4;
        int duration2;
        final Function0 onFinish;
        float circleWidth2;
        Function0 onFinish2;
        long j5;
        int duration3;
        long j6;
        float crossLineWidth3;
        float crossLinePercent3;
        float circleWidth3;
        float circleWidth4;
        int i3;
        int i4;
        int i5;
        Composer $composer2 = $composer.startRestartGroup(-1028170368);
        ComposerKt.sourceInformation($composer2, "C(CircleCountdownView)N(circleWidth,crossLineWidth,crossLinePercent,mainColor:c#ui.graphics.Color,progressColor:c#ui.graphics.Color,duration,onFinish)62@2310L41,65@2368L46,70@2529L41,69@2442L224,76@2743L1650,74@2671L1723,112@4428L27,112@4400L55:SplashCircleCountdownButton.kt#l60eyh");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            if ((i & 1) == 0 && $composer2.changed(circleWidth)) {
                i5 = 4;
                $dirty |= i5;
            }
            i5 = 2;
            $dirty |= i5;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                crossLineWidth2 = crossLineWidth;
                if ($composer2.changed(crossLineWidth2)) {
                    i4 = 32;
                    $dirty |= i4;
                }
            } else {
                crossLineWidth2 = crossLineWidth;
            }
            i4 = 16;
            $dirty |= i4;
        } else {
            crossLineWidth2 = crossLineWidth;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= BR.negativeBtnVisible;
            crossLinePercent2 = crossLinePercent;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            crossLinePercent2 = crossLinePercent;
            $dirty |= $composer2.changed(crossLinePercent2) ? BR.hallEnterHotText : BR.cover;
        } else {
            crossLinePercent2 = crossLinePercent;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j3 = j;
                if ($composer2.changed(j3)) {
                    i3 = 2048;
                    $dirty |= i3;
                }
            } else {
                j3 = j;
            }
            i3 = MisakaHelper.MAX_REPORT_SIZE;
            $dirty |= i3;
        } else {
            j3 = j;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            i2 = i6;
            j4 = j2;
        } else if (($changed & 24576) == 0) {
            i2 = i6;
            j4 = j2;
            $dirty |= $composer2.changed(j4) ? RingBuffer.CONSUME_SIZE : 8192;
        } else {
            i2 = i6;
            j4 = j2;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= 196608;
            duration2 = duration;
        } else if (($changed & 196608) == 0) {
            duration2 = duration;
            $dirty |= $composer2.changed(duration2) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        } else {
            duration2 = duration;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
            onFinish = function0;
        } else if (($changed & 1572864) == 0) {
            onFinish = function0;
            $dirty |= $composer2.changedInstance(onFinish) ? 1048576 : 524288;
        } else {
            onFinish = function0;
        }
        if ($composer2.shouldExecute(($dirty & 599187) != 599186, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "60@2280L2");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    circleWidth3 = ListExtentionsKt.toPx(2);
                    $dirty &= -15;
                } else {
                    circleWidth3 = circleWidth;
                }
                if ((i & 2) != 0) {
                    $dirty &= -113;
                    crossLineWidth2 = ListExtentionsKt.toPx(1.5d);
                }
                if (i2 != 0) {
                    crossLinePercent2 = 0.15f;
                }
                if ((i & 8) != 0) {
                    j3 = BiliColorsSourceKt.getDayColors().getBg2-0d7_KjU();
                    $dirty &= -7169;
                }
                if (i7 != 0) {
                    j4 = ColorKt.Color(1727461368);
                }
                if (i8 != 0) {
                    duration2 = 3000;
                }
                if (i9 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -229236158, "CC(remember):SplashCircleCountdownButton.kt#9igjgp");
                    float circleWidth5 = circleWidth3;
                    Object it$iv = $composer2.rememberedValue();
                    int $dirty2 = $dirty;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function0 onFinish3 = (Function0) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty = $dirty2;
                    onFinish = onFinish3;
                    circleWidth3 = circleWidth5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty &= -15;
                }
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    circleWidth3 = circleWidth;
                } else {
                    circleWidth3 = circleWidth;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1028170368, $dirty, -1, "tv.danmaku.bili.splash.ad.widget.CircleCountdownView (SplashCircleCountdownButton.kt:61)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -229235159, "CC(remember):SplashCircleCountdownButton.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = Float.valueOf(circleWidth3 / 2.0f);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final float circleRadius = ((Number) it$iv2).floatValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -229233298, "CC(remember):SplashCircleCountdownButton.kt#9igjgp");
            Object value$iv3 = $composer2.rememberedValue();
            final float crossLinePercent4 = crossLinePercent2;
            if (value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
            }
            MutableState play$delegate = (MutableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float f = CircleCountdownView_vRFhKjU$lambda$3(play$delegate) ? 0.0f : -360.0f;
            AnimationSpec tween$default = AnimationSpecKt.tween$default(duration2, 0, EasingKt.getLinearEasing(), 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -229228151, "CC(remember):SplashCircleCountdownButton.kt#9igjgp");
            boolean invalid$iv = (3670016 & $dirty) == 1048576;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit CircleCountdownView_vRFhKjU$lambda$5$0;
                    CircleCountdownView_vRFhKjU$lambda$5$0 = SplashCircleCountdownButtonKt.CircleCountdownView_vRFhKjU$lambda$5$0(onFinish, ((Float) obj).floatValue());
                    return CircleCountdownView_vRFhKjU$lambda$5$0;
                }
            };
            $composer2.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State angleAnimation$delegate = AnimateAsStateKt.animateFloatAsState(f, tween$default, 0.0f, "angle", (Function1) it$iv3, $composer2, 3072, 4);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -229219694, "CC(remember):SplashCircleCountdownButton.kt#9igjgp");
            boolean invalid$iv2 = ((57344 & $dirty) == 16384) | (((($dirty & 14) ^ 6) > 4 && $composer2.changed(circleWidth3)) || ($dirty & 6) == 4) | (((($dirty & 7168) ^ 3072) > 2048 && $composer2.changed(j3)) || ($dirty & 3072) == 2048) | (($dirty & 896) == 256) | (((($dirty & BR.containerVisible) ^ 48) > 32 && $composer2.changed(crossLineWidth2)) || ($dirty & 48) == 32) | $composer2.changed(angleAnimation$delegate);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv2) {
                onFinish2 = onFinish;
            } else {
                onFinish2 = onFinish;
            }
            final long j7 = j4;
            final float f2 = circleWidth3;
            final long j8 = j3;
            final float f3 = crossLineWidth2;
            Object value$iv5 = new Function1() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit CircleCountdownView_vRFhKjU$lambda$7$0;
                    CircleCountdownView_vRFhKjU$lambda$7$0 = SplashCircleCountdownButtonKt.CircleCountdownView_vRFhKjU$lambda$7$0(j7, circleRadius, f2, j8, crossLinePercent4, f3, angleAnimation$delegate, (ContentDrawScope) obj);
                    return CircleCountdownView_vRFhKjU$lambda$7$0;
                }
            };
            $composer2.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BoxKt.Box(DrawModifierKt.drawWithContent(fillMaxSize$default, (Function1) it$iv4), $composer2, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -229167397, "CC(remember):SplashCircleCountdownButton.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                circleWidth4 = circleWidth3;
                Object value$iv6 = (Function2) new SplashCircleCountdownButtonKt$CircleCountdownView$3$1(play$delegate, null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            } else {
                circleWidth4 = circleWidth3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv5, $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            circleWidth2 = circleWidth4;
            j5 = j4;
            duration3 = duration2;
            j6 = j3;
            crossLinePercent3 = crossLinePercent4;
            crossLineWidth3 = crossLineWidth2;
        } else {
            $composer2.skipToGroupEnd();
            circleWidth2 = circleWidth;
            onFinish2 = onFinish;
            j5 = j4;
            duration3 = duration2;
            j6 = j3;
            crossLineWidth3 = crossLineWidth2;
            crossLinePercent3 = crossLinePercent2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final float f4 = circleWidth2;
            final float f5 = crossLineWidth3;
            final float f6 = crossLinePercent3;
            final long j9 = j6;
            final long j10 = j5;
            final int i10 = duration3;
            final Function0 function02 = onFinish2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.splash.ad.widget.SplashCircleCountdownButtonKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit CircleCountdownView_vRFhKjU$lambda$9;
                    CircleCountdownView_vRFhKjU$lambda$9 = SplashCircleCountdownButtonKt.CircleCountdownView_vRFhKjU$lambda$9(f4, f5, f6, j9, j10, i10, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CircleCountdownView_vRFhKjU$lambda$9;
                }
            });
        }
    }

    private static final boolean CircleCountdownView_vRFhKjU$lambda$3(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CircleCountdownView_vRFhKjU$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final float CircleCountdownView_vRFhKjU$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircleCountdownView_vRFhKjU$lambda$5$0(Function0 $onFinish, float it) {
        $onFinish.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircleCountdownView_vRFhKjU$lambda$7$0(long j, float $circleRadius, float $circleWidth, long j2, float $crossLinePercent, float $crossLineWidth, State $angleAnimation$delegate, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        float f = 2;
        DrawScope.-CC.drawCircle-VaOC9Bg$default((DrawScope) $this$drawWithContent, j, (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) / f) - $circleRadius, 0L, 0.0f, new Stroke($circleWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, (int) BR.constraintSetModifier, (Object) null);
        int bits$iv$iv$iv = (int) (androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawWithContent.getSize-NH-jbRc()) >> 32);
        float x$iv = Float.intBitsToFloat(bits$iv$iv$iv) - (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) * $crossLinePercent);
        int bits$iv$iv$iv2 = (int) (androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawWithContent.getSize-NH-jbRc()) & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2) - (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) * $crossLinePercent);
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j3 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv3 = (int) (androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawWithContent.getSize-NH-jbRc()) >> 32);
        float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv3) + (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) * $crossLinePercent);
        int bits$iv$iv$iv4 = (int) (androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawWithContent.getSize-NH-jbRc()) & 4294967295L);
        float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv4) + (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) * $crossLinePercent);
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        DrawScope.-CC.drawLine-NGM6Ib0$default((DrawScope) $this$drawWithContent, j2, j3, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), $crossLineWidth, StrokeCap.Companion.getRound-KaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, (int) BR.reportVo, (Object) null);
        int bits$iv$iv$iv5 = (int) (androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawWithContent.getSize-NH-jbRc()) >> 32);
        float x$iv3 = Float.intBitsToFloat(bits$iv$iv$iv5) + (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) * $crossLinePercent);
        int bits$iv$iv$iv6 = (int) (androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawWithContent.getSize-NH-jbRc()) & 4294967295L);
        float y$iv3 = Float.intBitsToFloat(bits$iv$iv$iv6) - (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) * $crossLinePercent);
        long v1$iv$iv3 = Float.floatToRawIntBits(x$iv3);
        long v2$iv$iv3 = Float.floatToRawIntBits(y$iv3);
        long j4 = Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L));
        int bits$iv$iv$iv7 = (int) (androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawWithContent.getSize-NH-jbRc()) >> 32);
        float x$iv4 = Float.intBitsToFloat(bits$iv$iv$iv7) - (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) * $crossLinePercent);
        int bits$iv$iv$iv8 = (int) (androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawWithContent.getSize-NH-jbRc()) & 4294967295L);
        float y$iv4 = Float.intBitsToFloat(bits$iv$iv$iv8) + (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) * $crossLinePercent);
        long v1$iv$iv4 = Float.floatToRawIntBits(x$iv4);
        long v2$iv$iv4 = Float.floatToRawIntBits(y$iv4);
        DrawScope.-CC.drawLine-NGM6Ib0$default((DrawScope) $this$drawWithContent, j2, j4, Offset.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv4 & 4294967295L)), $crossLineWidth, StrokeCap.Companion.getRound-KaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, (int) BR.reportVo, (Object) null);
        float CircleCountdownView_vRFhKjU$lambda$6 = CircleCountdownView_vRFhKjU$lambda$6($angleAnimation$delegate);
        float width$iv = Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) - $circleWidth;
        float height$iv = Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) - $circleWidth;
        long v1$iv$iv5 = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv5 = Float.floatToRawIntBits(height$iv);
        long j5 = Size.constructor-impl((v1$iv$iv5 << 32) | (v2$iv$iv5 & 4294967295L));
        float x$iv5 = $circleWidth / f;
        int bits$iv$iv$iv9 = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
        float y$iv5 = ((Float.intBitsToFloat(bits$iv$iv$iv9) / f) - (Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) / f)) + $circleRadius;
        long v1$iv$iv6 = Float.floatToRawIntBits(x$iv5);
        long v2$iv$iv6 = Float.floatToRawIntBits(y$iv5);
        DrawScope.-CC.drawArc-yD3GUKo$default((DrawScope) $this$drawWithContent, j2, -90.0f, CircleCountdownView_vRFhKjU$lambda$6, false, Offset.constructor-impl((v1$iv$iv6 << 32) | (v2$iv$iv6 & 4294967295L)), j5, 0.0f, new Stroke($circleWidth, 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 832, (Object) null);
        return Unit.INSTANCE;
    }
}