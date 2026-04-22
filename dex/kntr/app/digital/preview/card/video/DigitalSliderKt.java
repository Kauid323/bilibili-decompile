package kntr.app.digital.preview.card.video;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: DigitalSlider.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a/\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a/\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0013\u001a0\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0002\u001a \u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002\u001aS\u0010'\u001a\u00020\u00012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030+2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010,\u001aR\u0010-\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002\u001aj\u00100\u001a\u00020\b*\u00020\b2\u0006\u00101\u001a\u0002022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020/2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0003062\u0018\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030+2\u0006\u0010.\u001a\u00020/H\u0002\"\u0016\u00109\u001a\u00020\u0017X\u0080\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;\"\u0016\u0010=\u001a\u00020\u0017X\u0080\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b>\u0010;\"\u0010\u0010?\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<\"\u0010\u0010@\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<\"\u000e\u0010A\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"DigitalSlider", RoomRecommendViewModel.EMPTY_CURSOR, "value", RoomRecommendViewModel.EMPTY_CURSOR, "onValueChange", "Lkotlin/Function1;", "present", "modifier", "Landroidx/compose/ui/Modifier;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "onValueChangeFinished", "Lkotlin/Function0;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(FLkotlin/jvm/functions/Function1;FLandroidx/compose/ui/Modifier;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "width", "(FFFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "Landroidx/compose/ui/unit/Dp;", "SliderThumb-ziNgDLE", "(Landroidx/compose/foundation/layout/BoxScope;FLandroidx/compose/runtime/Composer;I)V", "Track", "positionFractionStart", "positionFractionEnd", "scale", "a1", "b1", "x1", "a2", "b2", "calcFraction", "a", "b", "pos", "CorrectValueSideEffect", "scaleToOffset", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "sliderSemantics", "enabled", RoomRecommendViewModel.EMPTY_CURSOR, "sliderTapModifier", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "maxPx", "isRtl", "rawOffset", "Landroidx/compose/runtime/State;", "gestureEndAction", "pressOffset", "ThumbRadius", "getThumbRadius", "()F", "F", "TrackHeight", "getTrackHeight", "SliderHeight", "SliderMinWidth", "DefaultSliderConstraints", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DigitalSliderKt {
    private static final float ThumbRadius = Dp.constructor-impl(9);
    private static final float TrackHeight = Dp.constructor-impl(4);
    private static final float SliderHeight = Dp.constructor-impl(48);
    private static final float SliderMinWidth = Dp.constructor-impl(144);
    private static final Modifier DefaultSliderConstraints = SizeKt.heightIn-VpY3zN4$default(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, SliderMinWidth, 0.0f, 2, (Object) null), 0.0f, SliderHeight, 1, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CorrectValueSideEffect$lambda$1(Function1 function1, ClosedFloatingPointRange closedFloatingPointRange, ClosedFloatingPointRange closedFloatingPointRange2, MutableState mutableState, float f, int i, Composer composer, int i2) {
        CorrectValueSideEffect(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalSlider$lambda$2(float f, Function1 function1, float f2, Modifier modifier, ClosedFloatingPointRange closedFloatingPointRange, Function0 function0, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        DigitalSlider(f, function1, f2, modifier, closedFloatingPointRange, function0, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SliderImpl$lambda$1(float f, float f2, float f3, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SliderImpl(f, f2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SliderThumb_ziNgDLE$lambda$1(BoxScope boxScope, float f, int i, Composer composer, int i2) {
        m940SliderThumbziNgDLE(boxScope, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$1(float f, float f2, float f3, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Track(f, f2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15 */
    public static final void DigitalSlider(final float value, final Function1<? super Float, Unit> function1, final float present, Modifier modifier, ClosedFloatingPointRange<Float> closedFloatingPointRange, Function0<Unit> function0, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ClosedFloatingPointRange closedFloatingPointRange2;
        Function0 onValueChangeFinished;
        MutableInteractionSource mutableInteractionSource;
        Modifier modifier3;
        ClosedFloatingPointRange valueRange;
        Function0 onValueChangeFinished2;
        MutableInteractionSource interactionSource2;
        Modifier modifier4;
        ClosedFloatingPointRange valueRange2;
        MutableInteractionSource interactionSource3;
        int $dirty;
        int i2;
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer2 = $composer.startRestartGroup(-2067104691);
        ComposerKt.sourceInformation($composer2, "C(DigitalSlider)N(value,onValueChange,present,modifier,valueRange,onValueChangeFinished,interactionSource)74@3344L35,86@3782L2555,75@3384L2953:DigitalSlider.kt#9zxnub");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(value) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(present) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRange2 = closedFloatingPointRange;
                if ($composer2.changed(closedFloatingPointRange2)) {
                    i2 = 16384;
                    $dirty2 |= i2;
                }
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            i2 = 8192;
            $dirty2 |= i2;
        } else {
            closedFloatingPointRange2 = closedFloatingPointRange;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= 196608;
            onValueChangeFinished = function0;
        } else if ((196608 & $changed) == 0) {
            onValueChangeFinished = function0;
            $dirty2 |= $composer2.changedInstance(onValueChangeFinished) ? 131072 : 65536;
        } else {
            onValueChangeFinished = function0;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty2 |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if ((1572864 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ($composer2.shouldExecute((599187 & $dirty2) != 599186, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "72@3270L39");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                modifier3 = modifier2;
                valueRange = closedFloatingPointRange2;
                onValueChangeFinished2 = onValueChangeFinished;
                interactionSource3 = mutableInteractionSource;
                $dirty = $dirty2;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 16) == 0) {
                    valueRange2 = closedFloatingPointRange2;
                } else {
                    valueRange2 = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                }
                if (i4 != 0) {
                    onValueChangeFinished = null;
                }
                if (i5 == 0) {
                    modifier3 = modifier4;
                    valueRange = valueRange2;
                    onValueChangeFinished2 = onValueChangeFinished;
                    interactionSource3 = mutableInteractionSource;
                    $dirty = $dirty2;
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2082259156, "CC(remember):DigitalSlider.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    interactionSource3 = it$iv;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    valueRange = valueRange2;
                    onValueChangeFinished2 = onValueChangeFinished;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2067104691, $dirty, -1, "kntr.app.digital.preview.card.video.DigitalSlider (DigitalSlider.kt:73)");
            }
            final State onValueChangeState = SnapshotStateKt.rememberUpdatedState(function1, $composer2, ($dirty >> 3) & 14);
            final ClosedFloatingPointRange closedFloatingPointRange3 = valueRange;
            final Function0 function02 = onValueChangeFinished2;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            interactionSource2 = interactionSource3;
            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.requiredSizeIn-qDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), Dp.constructor-impl(2 * ThumbRadius), Dp.constructor-impl(2 * ThumbRadius), 0.0f, 0.0f, 12, (Object) null), value, true, function1, onValueChangeFinished2, valueRange), true, interactionSource3), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(307713827, true, new Function3() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DigitalSlider$lambda$1;
                    DigitalSlider$lambda$1 = DigitalSliderKt.DigitalSlider$lambda$1(closedFloatingPointRange3, value, function02, mutableInteractionSource2, present, onValueChangeState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DigitalSlider$lambda$1;
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            valueRange = closedFloatingPointRange2;
            onValueChangeFinished2 = onValueChangeFinished;
            interactionSource2 = mutableInteractionSource;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ClosedFloatingPointRange closedFloatingPointRange4 = valueRange;
            final Function0 function03 = onValueChangeFinished2;
            final MutableInteractionSource mutableInteractionSource3 = interactionSource2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit DigitalSlider$lambda$2;
                    DigitalSlider$lambda$2 = DigitalSliderKt.DigitalSlider$lambda$2(value, function1, present, modifier5, closedFloatingPointRange4, function03, mutableInteractionSource3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DigitalSlider$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalSlider$lambda$1(final ClosedFloatingPointRange $valueRange, float $value, final Function0 $onValueChangeFinished, MutableInteractionSource $interactionSource, float $present, final State $onValueChangeState, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Ref.FloatRef minPx;
        float widthPx;
        String str;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C87@3825L7,92@3986L7,101@4380L54,102@4461L36,105@4540L420,114@4993L15,114@4970L83,117@5119L147,117@5098L168,140@5835L55,147@6189L142:DigitalSlider.kt#9zxnub");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(307713827, $dirty2, -1, "kntr.app.digital.preview.card.video.DigitalSlider.<anonymous> (DigitalSlider.kt:87)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            boolean isRtl = consume == LayoutDirection.Rtl;
            float widthPx2 = Constraints.getMaxWidth-impl($this$BoxWithConstraints.getConstraints-msEJaDk());
            final Ref.FloatRef maxPx = new Ref.FloatRef();
            final Ref.FloatRef minPx2 = new Ref.FloatRef();
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$DigitalSlider_u24lambda_u241_u240 = (Density) consume2;
            maxPx.element = Math.max(widthPx2 - $this$DigitalSlider_u24lambda_u241_u240.toPx-0680j_4(ThumbRadius), 0.0f);
            minPx2.element = Math.min($this$DigitalSlider_u24lambda_u241_u240.toPx-0680j_4(ThumbRadius), maxPx.element);
            ComposerKt.sourceInformationMarkerStart($composer, -639736487, "CC(remember):DigitalSlider.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(DigitalSlider$lambda$1$scaleToOffset($valueRange, minPx2, maxPx, $value));
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final State state = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -639733913, "CC(remember):DigitalSlider.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState mutableState = (MutableFloatState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -639731001, "CC(remember):DigitalSlider.kt#9igjgp");
            boolean invalid$iv = $composer.changed(minPx2.element) | $composer.changed(maxPx.element) | $composer.changed($valueRange);
            Object value$iv3 = $composer.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                minPx = minPx2;
                widthPx = widthPx2;
                str = "CC(remember):DigitalSlider.kt#9igjgp";
                value$iv3 = new SliderDraggableState(new Function1() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit DigitalSlider$lambda$1$3$0;
                        DigitalSlider$lambda$1$3$0 = DigitalSliderKt.DigitalSlider$lambda$1$3$0(state, mutableState, minPx2, maxPx, $onValueChangeState, $valueRange, ((Float) obj).floatValue());
                        return DigitalSlider$lambda$1$3$0;
                    }
                });
                $composer.updateRememberedValue(value$iv3);
            } else {
                minPx = minPx2;
                str = "CC(remember):DigitalSlider.kt#9igjgp";
                widthPx = widthPx2;
            }
            final SliderDraggableState draggableState = (SliderDraggableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -639716910, str);
            boolean invalid$iv2 = $composer.changed($valueRange) | $composer.changed(minPx.element) | $composer.changed(maxPx.element);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (KFunction) new DigitalSliderKt$DigitalSlider$2$2$1($valueRange, minPx, maxPx);
                $composer.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            CorrectValueSideEffect((KFunction) it$iv3, $valueRange, RangesKt.rangeTo(minPx.element, maxPx.element), (MutableState) state, $value, $composer, 3072);
            ComposerKt.sourceInformationMarkerStart($composer, -639712746, str);
            String str2 = str;
            boolean invalid$iv3 = $composer.changedInstance(draggableState) | $composer.changed($onValueChangeFinished);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function1() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit DigitalSlider$lambda$1$5$0;
                        DigitalSlider$lambda$1$5$0 = DigitalSliderKt.DigitalSlider$lambda$1$5$0(SliderDraggableState.this, $onValueChangeFinished, ((Float) obj).floatValue());
                        return DigitalSlider$lambda$1$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            State gestureEndAction = SnapshotStateKt.rememberUpdatedState((Function1) it$iv4, $composer, 0);
            Modifier press = sliderTapModifier(Modifier.Companion, draggableState, $interactionSource, widthPx, isRtl, state, gestureEndAction, mutableState, true);
            Modifier modifier = Modifier.Companion;
            Orientation orientation = Orientation.Horizontal;
            boolean isDragging = draggableState.isDragging();
            Modifier modifier2 = modifier;
            SliderDraggableState sliderDraggableState = draggableState;
            ComposerKt.sourceInformationMarkerStart($composer, -639689926, str2);
            boolean invalid$iv4 = $composer.changed(gestureEndAction);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = (Function3) new DigitalSliderKt$DigitalSlider$2$drag$1$1(gestureEndAction, null);
                $composer.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier drag = DraggableKt.draggable$default(modifier2, sliderDraggableState, orientation, true, $interactionSource, isDragging, (Function3) null, (Function3) it$iv5, isRtl, 32, (Object) null);
            float coerced = RangesKt.coerceIn($value, ((Number) $valueRange.getStart()).floatValue(), ((Number) $valueRange.getEndInclusive()).floatValue());
            float fraction = calcFraction(((Number) $valueRange.getStart()).floatValue(), ((Number) $valueRange.getEndInclusive()).floatValue(), coerced);
            SliderImpl(fraction, $present, maxPx.element - minPx.element, press.then(drag), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final float DigitalSlider$lambda$1$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, float offset) {
        return scale(minPx.element, maxPx.element, offset, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DigitalSlider$lambda$1$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
        return scale(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), userValue, minPx.element, maxPx.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalSlider$lambda$1$3$0(MutableFloatState $rawOffset, MutableFloatState $pressOffset, Ref.FloatRef $minPx, Ref.FloatRef $maxPx, State $onValueChangeState, ClosedFloatingPointRange $valueRange, float it) {
        $rawOffset.setFloatValue($rawOffset.getFloatValue() + it + $pressOffset.getFloatValue());
        $pressOffset.setFloatValue(0.0f);
        float offsetInTrack = RangesKt.coerceIn($rawOffset.getFloatValue(), $minPx.element, $maxPx.element);
        ((Function1) $onValueChangeState.getValue()).invoke(Float.valueOf(DigitalSlider$lambda$1$scaleToUserValue($minPx, $maxPx, $valueRange, offsetInTrack)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalSlider$lambda$1$5$0(SliderDraggableState $draggableState, Function0 $onValueChangeFinished, float f) {
        if (!$draggableState.isDragging() && $onValueChangeFinished != null) {
            $onValueChangeFinished.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final void SliderImpl(final float positionFraction, final float present, final float width, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1048654160);
        ComposerKt.sourceInformation($composer2, "C(SliderImpl)N(positionFraction,present,width,modifier)163@6487L364:DigitalSlider.kt#9zxnub");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(positionFraction) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(present) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(width) ? 256 : 128;
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
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1048654160, $dirty2, -1, "kntr.app.digital.preview.card.video.SliderImpl (DigitalSlider.kt:162)");
            }
            Modifier modifier$iv = modifier4.then(DefaultSliderConstraints);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope $this$SliderImpl_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1227238570, "C165@6584L7,171@6698L119,177@6826L19:DigitalSlider.kt#9zxnub");
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$SliderImpl_u24lambda_u240_u240 = (Density) consume;
            float widthDp = $this$SliderImpl_u24lambda_u240_u240.toDp-u2uoSUM(width);
            float other$iv = Dp.constructor-impl(widthDp * positionFraction);
            Track(present, 0.0f, positionFraction, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, (($dirty2 >> 3) & 14) | 3120 | (($dirty2 << 6) & 896), 0);
            m940SliderThumbziNgDLE($this$SliderImpl_u24lambda_u240, other$iv, $composer2, (((0 >> 6) & 112) | 6) & 14);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit SliderImpl$lambda$1;
                    SliderImpl$lambda$1 = DigitalSliderKt.SliderImpl$lambda$1(positionFraction, present, width, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SliderImpl$lambda$1;
                }
            });
        }
    }

    /* renamed from: SliderThumb-ziNgDLE  reason: not valid java name */
    private static final void m940SliderThumbziNgDLE(final BoxScope $this$SliderThumb_u2dziNgDLE, final float f, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1840349594);
        ComposerKt.sourceInformation($composer2, "C(SliderThumb)N(offset:c#ui.unit.Dp)183@6918L368:DigitalSlider.kt#9zxnub");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$SliderThumb_u2dziNgDLE) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(f) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1840349594, $dirty2, -1, "kntr.app.digital.preview.card.video.SliderThumb (DigitalSlider.kt:182)");
            }
            Modifier modifier$iv = $this$SliderThumb_u2dziNgDLE.align(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Alignment.Companion.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1681572997, "C192@7157L58,188@7036L244:DigitalSlider.kt#9zxnub");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_digital_player_seek_thumb(Res.drawable.INSTANCE), $composer2, 0), "subtitle question", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2 * ThumbRadius)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 432, 120);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit SliderThumb_ziNgDLE$lambda$1;
                    SliderThumb_ziNgDLE$lambda$1 = DigitalSliderKt.SliderThumb_ziNgDLE$lambda$1($this$SliderThumb_u2dziNgDLE, f, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SliderThumb_ziNgDLE$lambda$1;
                }
            });
        }
    }

    private static final void Track(final float present, final float positionFractionStart, final float positionFractionEnd, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-1244053410);
        ComposerKt.sourceInformation($composer2, "C(Track)N(present,positionFractionStart,positionFractionEnd,modifier)207@7558L1328,207@7541L1345:DigitalSlider.kt#9zxnub");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(present) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(positionFractionStart) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(positionFractionEnd) ? 256 : 128;
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
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1244053410, $dirty, -1, "kntr.app.digital.preview.card.video.Track (DigitalSlider.kt:204)");
            }
            final long inactiveTrackColor = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            final long activeTrackColor = Color.Companion.getWhite-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer2, -1534409458, "CC(remember):DigitalSlider.kt#9igjgp");
            boolean invalid$iv = (($dirty & 896) == 256) | (($dirty & 112) == 32) | (($dirty & 14) == 4);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                modifier4 = modifier3;
                value$iv = new Function1() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit Track$lambda$0$0;
                        Track$lambda$0$0 = DigitalSliderKt.Track$lambda$0$0(inactiveTrackColor, positionFractionEnd, positionFractionStart, activeTrackColor, present, (DrawScope) obj);
                        return Track$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                modifier4 = modifier3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier4, (Function1) value$iv, $composer2, ($dirty >> 9) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit Track$lambda$1;
                    Track$lambda$1 = DigitalSliderKt.Track$lambda$1(present, positionFractionStart, positionFractionEnd, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Track$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$0$0(long $inactiveTrackColor, float $positionFractionEnd, float $positionFractionStart, long $activeTrackColor, float $present, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        boolean isRtl = $this$Canvas.getLayoutDirection() == LayoutDirection.Rtl;
        float x$iv = $this$Canvas.toPx-0680j_4(ThumbRadius);
        int bits$iv$iv$iv = (int) ($this$Canvas.getCenter-F1C5BW0() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv);
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv2) - $this$Canvas.toPx-0680j_4(ThumbRadius);
        int bits$iv$iv$iv3 = (int) ($this$Canvas.getCenter-F1C5BW0() & 4294967295L);
        float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv3);
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        long j3 = Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
        long sliderStart = isRtl ? j3 : j2;
        long sliderEnd = isRtl ? j2 : j3;
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$Canvas, $inactiveTrackColor, sliderStart, sliderEnd, $this$Canvas.toPx-0680j_4(Dp.constructor-impl(2)), StrokeCap.Companion.getRound-KaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        int bits$iv$iv$iv4 = (int) (sliderStart >> 32);
        int bits$iv$iv$iv5 = (int) (sliderEnd >> 32);
        int bits$iv$iv$iv6 = (int) (sliderStart >> 32);
        float x$iv3 = Float.intBitsToFloat(bits$iv$iv$iv4) + ((Float.intBitsToFloat(bits$iv$iv$iv5) - Float.intBitsToFloat(bits$iv$iv$iv6)) * $positionFractionEnd);
        int bits$iv$iv$iv7 = (int) ($this$Canvas.getCenter-F1C5BW0() & 4294967295L);
        float y$iv3 = Float.intBitsToFloat(bits$iv$iv$iv7);
        long v1$iv$iv3 = Float.floatToRawIntBits(x$iv3);
        long v2$iv$iv3 = Float.floatToRawIntBits(y$iv3);
        long sliderValueEnd = Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L));
        int bits$iv$iv$iv8 = (int) (sliderStart >> 32);
        int bits$iv$iv$iv9 = (int) (sliderEnd >> 32);
        int bits$iv$iv$iv10 = (int) (sliderStart >> 32);
        float x$iv4 = Float.intBitsToFloat(bits$iv$iv$iv8) + ((Float.intBitsToFloat(bits$iv$iv$iv9) - Float.intBitsToFloat(bits$iv$iv$iv10)) * $positionFractionStart);
        int bits$iv$iv$iv11 = (int) ($this$Canvas.getCenter-F1C5BW0() & 4294967295L);
        float y$iv4 = Float.intBitsToFloat(bits$iv$iv$iv11);
        long v1$iv$iv4 = Float.floatToRawIntBits(x$iv4);
        long v2$iv$iv4 = Float.floatToRawIntBits(y$iv4);
        long sliderValueStart = Offset.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv4 & 4294967295L));
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$Canvas, $activeTrackColor, sliderValueStart, sliderValueEnd, $this$Canvas.toPx-0680j_4(Dp.constructor-impl(2)), StrokeCap.Companion.getRound-KaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        if ($present > 0.0f) {
            long j4 = Color.Companion.getWhite-0d7_KjU();
            int bits$iv$iv$iv12 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
            float x$iv5 = Float.intBitsToFloat(bits$iv$iv$iv12) * $present;
            float y$iv5 = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(6));
            long v1$iv$iv5 = Float.floatToRawIntBits(x$iv5);
            long v2$iv$iv5 = Float.floatToRawIntBits(y$iv5);
            long j5 = Offset.constructor-impl((v1$iv$iv5 << 32) | (v2$iv$iv5 & 4294967295L));
            float width$iv = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(3));
            float height$iv = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(6));
            long v1$iv$iv6 = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv6 = Float.floatToRawIntBits(height$iv);
            long j6 = Size.constructor-impl((v1$iv$iv6 << 32) | (v2$iv$iv6 & 4294967295L));
            float x$iv6 = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(3));
            float y$iv6 = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(3));
            long v1$iv$iv7 = Float.floatToRawIntBits(x$iv6);
            long v2$iv$iv7 = Float.floatToRawIntBits(y$iv6);
            DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$Canvas, j4, j5, j6, CornerRadius.constructor-impl((v1$iv$iv7 << 32) | (v2$iv$iv7 & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    private static final float calcFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a), 0.0f, 1.0f);
    }

    private static final void CorrectValueSideEffect(final Function1<? super Float, Float> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final ClosedFloatingPointRange<Float> closedFloatingPointRange2, final MutableState<Float> mutableState, final float value, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1504680247);
        ComposerKt.sourceInformation($composer2, "C(CorrectValueSideEffect)N(scaleToOffset,valueRange,trackRange,valueState,value)275@9603L300,275@9592L311:DigitalSlider.kt#9zxnub");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(closedFloatingPointRange) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(closedFloatingPointRange2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(mutableState) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(value) ? 16384 : 8192;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1504680247, $dirty, -1, "kntr.app.digital.preview.card.video.CorrectValueSideEffect (DigitalSlider.kt:274)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1406253501, "CC(remember):DigitalSlider.kt#9igjgp");
            boolean invalid$iv = (($dirty & 112) == 32) | (($dirty & 14) == 4) | ((57344 & $dirty) == 16384) | (($dirty & 7168) == 2048) | (($dirty & 896) == 256);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function0() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit CorrectValueSideEffect$lambda$0$0;
                        CorrectValueSideEffect$lambda$0$0 = DigitalSliderKt.CorrectValueSideEffect$lambda$0$0(closedFloatingPointRange, function1, value, mutableState, closedFloatingPointRange2);
                        return CorrectValueSideEffect$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit CorrectValueSideEffect$lambda$1;
                    CorrectValueSideEffect$lambda$1 = DigitalSliderKt.CorrectValueSideEffect$lambda$1(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, value, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CorrectValueSideEffect$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CorrectValueSideEffect$lambda$0$0(ClosedFloatingPointRange $valueRange, Function1 $scaleToOffset, float $value, MutableState $valueState, ClosedFloatingPointRange $trackRange) {
        float error = (((Number) $valueRange.getEndInclusive()).floatValue() - ((Number) $valueRange.getStart()).floatValue()) / 1000;
        float newOffset = ((Number) $scaleToOffset.invoke(Float.valueOf($value))).floatValue();
        if (Math.abs(newOffset - ((Number) $valueState.getValue()).floatValue()) > error && $trackRange.contains((Comparable) $valueState.getValue())) {
            $valueState.setValue(Float.valueOf(newOffset));
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, boolean z, Function1 function1, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange, int i, Object obj) {
        Function0 function02;
        ClosedFloatingPointRange closedFloatingPointRange2;
        if ((i & 8) == 0) {
            function02 = function0;
        } else {
            function02 = null;
        }
        if ((i & 16) == 0) {
            closedFloatingPointRange2 = closedFloatingPointRange;
        } else {
            closedFloatingPointRange2 = RangesKt.rangeTo(0.0f, 1.0f);
        }
        return sliderSemantics(modifier, f, z, function1, function02, closedFloatingPointRange2);
    }

    private static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, final boolean enabled, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        final float coerced = RangesKt.coerceIn(value, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new Function1() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit sliderSemantics$lambda$0;
                sliderSemantics$lambda$0 = DigitalSliderKt.sliderSemantics$lambda$0(enabled, closedFloatingPointRange, coerced, function1, function0, (SemanticsPropertyReceiver) obj);
                return sliderSemantics$lambda$0;
            }
        }, 1, (Object) null), value, closedFloatingPointRange, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sliderSemantics$lambda$0(boolean $enabled, final ClosedFloatingPointRange $valueRange, final float $coerced, final Function1 $onValueChange, final Function0 $onValueChangeFinished, SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        if (!$enabled) {
            SemanticsPropertiesKt.disabled($this$semantics);
        }
        SemanticsPropertiesKt.setProgress$default($this$semantics, (String) null, new Function1() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean sliderSemantics$lambda$0$0;
                sliderSemantics$lambda$0$0 = DigitalSliderKt.sliderSemantics$lambda$0$0($valueRange, $coerced, $onValueChange, $onValueChangeFinished, ((Float) obj).floatValue());
                return Boolean.valueOf(sliderSemantics$lambda$0$0);
            }
        }, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sliderSemantics$lambda$0$0(ClosedFloatingPointRange $valueRange, float $coerced, Function1 $onValueChange, Function0 $onValueChangeFinished, float targetValue) {
        float resolvedValue = RangesKt.coerceIn(targetValue, ((Number) $valueRange.getStart()).floatValue(), ((Number) $valueRange.getEndInclusive()).floatValue());
        if (resolvedValue == $coerced) {
            return false;
        }
        $onValueChange.invoke(Float.valueOf(resolvedValue));
        if ($onValueChangeFinished != null) {
            $onValueChangeFinished.invoke();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderTapModifier$lambda$1(boolean $enabled, DraggableState $draggableState, MutableInteractionSource $interactionSource, float $maxPx, boolean $isRtl, MutableState $pressOffset, State $rawOffset, State $gestureEndAction, Modifier $this$composed, Composer $composer, int $changed) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceGroup(-1974995739);
        ComposerKt.sourceInformation($composer, "C:DigitalSlider.kt#9zxnub");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1974995739, $changed, -1, "kntr.app.digital.preview.card.video.sliderTapModifier.<anonymous> (DigitalSlider.kt:325)");
        }
        if ($enabled) {
            $composer.startReplaceGroup(-341017773);
            ComposerKt.sourceInformation($composer, "326@11307L24,327@11406L899");
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Object[] objArr = {$draggableState, $interactionSource, Float.valueOf($maxPx), Boolean.valueOf($isRtl)};
            ComposerKt.sourceInformationMarkerStart($composer, 404645288, "CC(remember):DigitalSlider.kt#9igjgp");
            boolean invalid$iv = $composer.changed($isRtl) | $composer.changed($maxPx) | $composer.changed($pressOffset) | $composer.changed($rawOffset) | $composer.changedInstance(scope) | $composer.changedInstance($draggableState) | $composer.changed($gestureEndAction);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new DigitalSliderKt$sliderTapModifier$2$1$1($isRtl, $maxPx, $pressOffset, $rawOffset, scope, $draggableState, $gestureEndAction);
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            modifier = SuspendingPointerInputFilterKt.pointerInput($this$composed, objArr, (PointerInputEventHandler) value$iv);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-340017279);
            $composer.endReplaceGroup();
            modifier = $this$composed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return modifier;
    }

    private static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, final DraggableState draggableState, final MutableInteractionSource interactionSource, final float maxPx, final boolean isRtl, final State<Float> state, final State<? extends Function1<? super Float, Unit>> state2, final MutableState<Float> mutableState, final boolean enabled) {
        return ComposedModifierKt.composed($this$sliderTapModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((InspectorInfo) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("sliderTapModifier");
                inspectorInfo.getProperties().set("draggableState", draggableState);
                inspectorInfo.getProperties().set("interactionSource", interactionSource);
                inspectorInfo.getProperties().set("maxPx", Float.valueOf(maxPx));
                inspectorInfo.getProperties().set("isRtl", Boolean.valueOf(isRtl));
                inspectorInfo.getProperties().set("rawOffset", state);
                inspectorInfo.getProperties().set("gestureEndAction", state2);
                inspectorInfo.getProperties().set("pressOffset", mutableState);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(enabled));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: kntr.app.digital.preview.card.video.DigitalSliderKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier sliderTapModifier$lambda$1;
                sliderTapModifier$lambda$1 = DigitalSliderKt.sliderTapModifier$lambda$1(enabled, draggableState, interactionSource, maxPx, isRtl, mutableState, state, state2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return sliderTapModifier$lambda$1;
            }
        });
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }
}