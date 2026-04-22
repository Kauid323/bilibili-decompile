package kntr.common.compose.list;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: Overscroll.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0001\u001az\u0010\f\u001a\u00020\r*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2:\b\u0002\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u001az\u0010\u0016\u001a\u00020\r*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2:\b\u0002\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u001a\u0082\u0001\u0010\u0017\u001a\u00020\r*\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0000\u001a\u001a\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u001d\"D\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u00078AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006:\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"parabolaScrollEasing", "", "currentOffset", "newOffset", "p", "density", "DefaultParabolaScrollEasing", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getDefaultParabolaScrollEasing", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "overScrollVertical", "Landroidx/compose/ui/Modifier;", "nestedScrollToParent", "", "scrollEasing", "springStiff", "springDamp", "remainingFactor", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "overScrollHorizontal", "overScrollOutOfBound", "isVertical", "listState", "forceScrollBy", "Landroidx/compose/foundation/gestures/ScrollableState;", "offset", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-list_debug", "factor", "onScrollEasingSlowDownRate", "remainingPostFlingVelocity", "remainingPostFlingOffset", "remainingPostFlingHasReachedPeak"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OverscrollKt {
    public static /* synthetic */ float parabolaScrollEasing$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 4) != 0) {
            f3 = 50.0f;
        }
        if ((i & 8) != 0) {
            f4 = 4.0f;
        }
        return parabolaScrollEasing(f, f2, f3, f4);
    }

    public static final float parabolaScrollEasing(float currentOffset, float newOffset, float p, float density) {
        float realP = p * density;
        float ratio = RangesKt.coerceIn(realP / ((float) Math.sqrt(RangesKt.coerceAtLeast(Math.abs((newOffset / 2) + currentOffset), Float.MIN_VALUE) * realP)), Float.MIN_VALUE, 1.0f);
        if (Math.signum(currentOffset) == Math.signum(newOffset)) {
            return (newOffset * ratio) + currentOffset;
        }
        return currentOffset + newOffset;
    }

    public static final Function2<Float, Float, Float> getDefaultParabolaScrollEasing(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1695013858, "C(<get-DefaultParabolaScrollEasing>)79@3156L7,80@3187L117:Overscroll.kt#n69ky8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1695013858, $changed, -1, "kntr.common.compose.list.<get-DefaultParabolaScrollEasing> (Overscroll.kt:78)");
        }
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final float density = ((Density) consume).getDensity();
        ComposerKt.sourceInformationMarkerStart($composer, -1115709357, "CC(remember):Overscroll.kt#9igjgp");
        boolean invalid$iv = $composer.changed(density);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function2() { // from class: kntr.common.compose.list.OverscrollKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    float _get_DefaultParabolaScrollEasing_$lambda$0$0;
                    _get_DefaultParabolaScrollEasing_$lambda$0$0 = OverscrollKt._get_DefaultParabolaScrollEasing_$lambda$0$0(density, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                    return Float.valueOf(_get_DefaultParabolaScrollEasing_$lambda$0$0);
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        Function2<Float, Float, Float> function2 = (Function2) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return function2;
    }

    public static final float _get_DefaultParabolaScrollEasing_$lambda$0$0(float $density, float currentOffset, float newOffset) {
        return parabolaScrollEasing$default(currentOffset, newOffset, 0.0f, $density, 4, null);
    }

    public static /* synthetic */ Modifier overScrollVertical$default(Modifier modifier, boolean z, Function2 function2, float f, float f2, float f3, LazyListState lazyListState, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return overScrollVertical(modifier, z, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? 150.0f : f, (i & 8) != 0 ? 1.02f : f2, (i & 16) != 0 ? 0.1986f : f3, (i & 32) == 0 ? lazyListState : null);
    }

    public static final Modifier overScrollVertical(Modifier $this$overScrollVertical, boolean nestedScrollToParent, Function2<? super Float, ? super Float, Float> function2, float springStiff, float springDamp, float remainingFactor, LazyListState state) {
        Intrinsics.checkNotNullParameter($this$overScrollVertical, "<this>");
        return overScrollOutOfBound($this$overScrollVertical, true, nestedScrollToParent, function2, springStiff, springDamp, remainingFactor, state);
    }

    public static /* synthetic */ Modifier overScrollHorizontal$default(Modifier modifier, boolean z, Function2 function2, float f, float f2, float f3, LazyListState lazyListState, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return overScrollHorizontal(modifier, z, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? 150.0f : f, (i & 8) != 0 ? 1.02f : f2, (i & 16) != 0 ? 0.1986f : f3, (i & 32) == 0 ? lazyListState : null);
    }

    public static final Modifier overScrollHorizontal(Modifier $this$overScrollHorizontal, boolean nestedScrollToParent, Function2<? super Float, ? super Float, Float> function2, float springStiff, float springDamp, float remainingFactor, LazyListState state) {
        Intrinsics.checkNotNullParameter($this$overScrollHorizontal, "<this>");
        return overScrollOutOfBound($this$overScrollHorizontal, false, nestedScrollToParent, function2, springStiff, springDamp, remainingFactor, state);
    }

    public static final Modifier overScrollOutOfBound(Modifier $this$overScrollOutOfBound, final boolean isVertical, final boolean nestedScrollToParent, final Function2<? super Float, ? super Float, Float> function2, final float springStiff, final float springDamp, final float remainingFactor, final LazyListState listState) {
        Intrinsics.checkNotNullParameter($this$overScrollOutOfBound, "<this>");
        return ComposedModifierKt.composed$default($this$overScrollOutOfBound, (Function1) null, new Function3() { // from class: kntr.common.compose.list.OverscrollKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier overScrollOutOfBound$lambda$0;
                overScrollOutOfBound$lambda$0 = OverscrollKt.overScrollOutOfBound$lambda$0(nestedScrollToParent, function2, springStiff, springDamp, isVertical, remainingFactor, listState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return overScrollOutOfBound$lambda$0;
            }
        }, 1, (Object) null);
    }

    public static final Modifier overScrollOutOfBound$lambda$0(boolean $nestedScrollToParent, Function2 $scrollEasing, float $springStiff, float $springDamp, boolean $isVertical, float $remainingFactor, LazyListState $listState, Modifier $this$composed, Composer $composer, int $changed) {
        Function2 function2;
        MutableSharedFlow listCountFlow;
        OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 nestedConnection;
        NestedScrollDispatcher dispatcher;
        String str;
        State isVertical$delegate;
        final MutableFloatState offset$delegate;
        int i;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceGroup(1559621388);
        ComposerKt.sourceInformation($composer, "C163@6550L42,164@6621L65,165@6714L33,166@6774L32,167@6833L32,168@6888L37,169@6951L37,170@7031L38,171@7092L36,173@7172L31,174@7244L31,175@7324L34,178@7403L10090,380@17535L226,397@18202L3041,397@18172L3071,457@21369L96:Overscroll.kt#n69ky8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1559621388, $changed, -1, "kntr.common.compose.list.overScrollOutOfBound.<anonymous> (Overscroll.kt:163)");
        }
        State nestedScrollToParent$delegate = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf($nestedScrollToParent), $composer, 0);
        if ($scrollEasing == null) {
            $composer.startReplaceGroup(-147427737);
            ComposerKt.sourceInformation($composer, "164@6658L27");
            function2 = getDefaultParabolaScrollEasing($composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-147428233);
            $composer.endReplaceGroup();
            function2 = $scrollEasing;
        }
        State scrollEasing$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer, 0);
        State springStiff$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf($springStiff), $composer, 0);
        State springDamp$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf($springDamp), $composer, 0);
        State isVertical$delegate2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf($isVertical), $composer, 0);
        State factor$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf($remainingFactor), $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, -147418351, "CC(remember):Overscroll.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new NestedScrollDispatcher();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        NestedScrollDispatcher dispatcher2 = (NestedScrollDispatcher) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -147415790, "CC(remember):Overscroll.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        MutableFloatState onScrollEasingSlowDownRate$delegate = (MutableFloatState) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -147413840, "CC(remember):Overscroll.kt#9igjgp");
        Object it$iv3 = $composer.rememberedValue();
        if (it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        MutableFloatState offset$delegate2 = (MutableFloatState) it$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -147411285, "CC(remember):Overscroll.kt#9igjgp");
        Object it$iv4 = $composer.rememberedValue();
        if (it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv4 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
        }
        MutableState remainingPostFlingVelocity$delegate = (MutableState) it$iv4;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -147408981, "CC(remember):Overscroll.kt#9igjgp");
        Object it$iv5 = $composer.rememberedValue();
        if (it$iv5 == Composer.Companion.getEmpty()) {
            Object value$iv5 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
        }
        MutableState remainingPostFlingOffset$delegate = (MutableState) it$iv5;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -147406418, "CC(remember):Overscroll.kt#9igjgp");
        Object it$iv6 = $composer.rememberedValue();
        if (it$iv6 == Composer.Companion.getEmpty()) {
            Object value$iv6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
        }
        MutableState remainingPostFlingHasReachedPeak$delegate = (MutableState) it$iv6;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -147393834, "CC(remember):Overscroll.kt#9igjgp");
        Object it$iv7 = $composer.rememberedValue();
        if (it$iv7 == Composer.Companion.getEmpty()) {
            Object value$iv7 = new OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1(dispatcher2, nestedScrollToParent$delegate, isVertical$delegate2, offset$delegate2, scrollEasing$delegate, onScrollEasingSlowDownRate$delegate, remainingPostFlingVelocity$delegate, remainingPostFlingOffset$delegate, remainingPostFlingHasReachedPeak$delegate, springDamp$delegate, springStiff$delegate);
            $composer.updateRememberedValue(value$iv7);
            it$iv7 = value$iv7;
        }
        OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 nestedConnection2 = (OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1) it$iv7;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -147079474, "CC(remember):Overscroll.kt#9igjgp");
        Object it$iv8 = $composer.rememberedValue();
        if (it$iv8 == Composer.Companion.getEmpty()) {
            Object value$iv8 = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
            $composer.updateRememberedValue(value$iv8);
            it$iv8 = value$iv8;
        }
        MutableSharedFlow listCountFlow2 = (MutableSharedFlow) it$iv8;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if ($listState == null) {
            $composer.startReplaceGroup(-264246568);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-264246567);
            ComposerKt.sourceInformation($composer, "*389@17826L327,389@17800L353");
            ComposerKt.sourceInformationMarkerStart($composer, 2109983853, "CC(remember):Overscroll.kt#9igjgp");
            boolean invalid$iv = $composer.changed($listState) | $composer.changedInstance(listCountFlow2);
            OverscrollKt$overScrollOutOfBound$1$1$1$1 value$iv9 = $composer.rememberedValue();
            if (!invalid$iv && value$iv9 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect($listState, (Function2) value$iv9, $composer, 0);
                $composer.endReplaceGroup();
            }
            value$iv9 = new OverscrollKt$overScrollOutOfBound$1$1$1$1($listState, listCountFlow2, null);
            $composer.updateRememberedValue(value$iv9);
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect($listState, (Function2) value$iv9, $composer, 0);
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart($composer, -147055315, "CC(remember):Overscroll.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(listCountFlow2) | $composer.changedInstance(nestedConnection2) | $composer.changedInstance(dispatcher2) | $composer.changed($listState) | $composer.changed(factor$delegate) | $composer.changed(springDamp$delegate) | $composer.changed(springStiff$delegate);
        Object value$iv10 = $composer.rememberedValue();
        if (invalid$iv2 || value$iv10 == Composer.Companion.getEmpty()) {
            listCountFlow = listCountFlow2;
            nestedConnection = nestedConnection2;
            dispatcher = dispatcher2;
            str = "CC(remember):Overscroll.kt#9igjgp";
            isVertical$delegate = isVertical$delegate2;
            offset$delegate = offset$delegate2;
            i = 0;
            value$iv10 = new OverscrollKt$overScrollOutOfBound$1$2$1(listCountFlow2, nestedConnection2, dispatcher2, $listState, remainingPostFlingVelocity$delegate, offset$delegate2, remainingPostFlingHasReachedPeak$delegate, remainingPostFlingOffset$delegate, factor$delegate, springDamp$delegate, springStiff$delegate, null);
            $composer.updateRememberedValue(value$iv10);
        } else {
            listCountFlow = listCountFlow2;
            nestedConnection = nestedConnection2;
            dispatcher = dispatcher2;
            str = "CC(remember):Overscroll.kt#9igjgp";
            isVertical$delegate = isVertical$delegate2;
            offset$delegate = offset$delegate2;
            i = 0;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(listCountFlow, (Function2) value$iv10, $composer, i);
        Modifier nestedScroll = NestedScrollModifierKt.nestedScroll(ClipKt.clipToBounds($this$composed), nestedConnection, dispatcher);
        ComposerKt.sourceInformationMarkerStart($composer, -146956916, str);
        final State isVertical$delegate3 = isVertical$delegate;
        boolean invalid$iv3 = $composer.changed(isVertical$delegate3);
        Object it$iv9 = $composer.rememberedValue();
        if (invalid$iv3 || it$iv9 == Composer.Companion.getEmpty()) {
            Object value$iv11 = new Function1() { // from class: kntr.common.compose.list.OverscrollKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit overScrollOutOfBound$lambda$0$26$0;
                    overScrollOutOfBound$lambda$0$26$0 = OverscrollKt.overScrollOutOfBound$lambda$0$26$0(isVertical$delegate3, offset$delegate, (GraphicsLayerScope) obj);
                    return overScrollOutOfBound$lambda$0$26$0;
                }
            };
            $composer.updateRememberedValue(value$iv11);
            it$iv9 = value$iv11;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(nestedScroll, (Function1) it$iv9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return graphicsLayer;
    }

    public static final boolean overScrollOutOfBound$lambda$0$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public static final Function2<Float, Float, Float> overScrollOutOfBound$lambda$0$1(State<? extends Function2<? super Float, ? super Float, Float>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    public static final float overScrollOutOfBound$lambda$0$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    public static final float overScrollOutOfBound$lambda$0$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    public static final boolean overScrollOutOfBound$lambda$0$4(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public static final float overScrollOutOfBound$lambda$0$5(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    public static final float overScrollOutOfBound$lambda$0$8(MutableFloatState $onScrollEasingSlowDownRate$delegate) {
        FloatState $this$getValue$iv = (FloatState) $onScrollEasingSlowDownRate$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    public static final float overScrollOutOfBound$lambda$0$11(MutableFloatState $offset$delegate) {
        FloatState $this$getValue$iv = (FloatState) $offset$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    public static final float overScrollOutOfBound$lambda$0$14(MutableState<Float> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    public static final void overScrollOutOfBound$lambda$0$15(MutableState<Float> mutableState, float f) {
        Object value$iv = Float.valueOf(f);
        mutableState.setValue(value$iv);
    }

    public static final float overScrollOutOfBound$lambda$0$17(MutableState<Float> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    public static final void overScrollOutOfBound$lambda$0$18(MutableState<Float> mutableState, float f) {
        Object value$iv = Float.valueOf(f);
        mutableState.setValue(value$iv);
    }

    public static final boolean overScrollOutOfBound$lambda$0$20(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public static final void overScrollOutOfBound$lambda$0$21(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    public static final Unit overScrollOutOfBound$lambda$0$26$0(State $isVertical$delegate, MutableFloatState $offset$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        if (overScrollOutOfBound$lambda$0$4($isVertical$delegate)) {
            $this$graphicsLayer.setTranslationY(overScrollOutOfBound$lambda$0$11($offset$delegate));
        } else {
            $this$graphicsLayer.setTranslationX(overScrollOutOfBound$lambda$0$11($offset$delegate));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forceScrollBy(ScrollableState $this$forceScrollBy, float offset, Continuation<? super Float> continuation) {
        OverscrollKt$forceScrollBy$1 overscrollKt$forceScrollBy$1;
        Ref.FloatRef consumed;
        if (continuation instanceof OverscrollKt$forceScrollBy$1) {
            overscrollKt$forceScrollBy$1 = (OverscrollKt$forceScrollBy$1) continuation;
            if ((overscrollKt$forceScrollBy$1.label & Integer.MIN_VALUE) != 0) {
                overscrollKt$forceScrollBy$1.label -= Integer.MIN_VALUE;
                Object $result = overscrollKt$forceScrollBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (overscrollKt$forceScrollBy$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Ref.FloatRef consumed2 = new Ref.FloatRef();
                        overscrollKt$forceScrollBy$1.L$0 = SpillingKt.nullOutSpilledVariable($this$forceScrollBy);
                        overscrollKt$forceScrollBy$1.L$1 = consumed2;
                        overscrollKt$forceScrollBy$1.F$0 = offset;
                        overscrollKt$forceScrollBy$1.label = 1;
                        if ($this$forceScrollBy.scroll(MutatePriority.PreventUserInput, new OverscrollKt$forceScrollBy$2(consumed2, offset, null), overscrollKt$forceScrollBy$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        consumed = consumed2;
                        break;
                    case 1:
                        float offset2 = overscrollKt$forceScrollBy$1.F$0;
                        consumed = (Ref.FloatRef) overscrollKt$forceScrollBy$1.L$1;
                        ScrollableState scrollableState = (ScrollableState) overscrollKt$forceScrollBy$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxFloat(consumed.element);
            }
        }
        overscrollKt$forceScrollBy$1 = new OverscrollKt$forceScrollBy$1(continuation);
        Object $result2 = overscrollKt$forceScrollBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (overscrollKt$forceScrollBy$1.label) {
        }
        return Boxing.boxFloat(consumed.element);
    }
}