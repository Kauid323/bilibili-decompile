package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiniVideoFloatingComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1 implements PointerInputEventHandler {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animX;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animY;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Density $density;
    final /* synthetic */ float $floatingPadding;
    final /* synthetic */ State<Dp> $floatingViewHeight$delegate;
    final /* synthetic */ State<Dp> $floatingViewWidth$delegate;
    final /* synthetic */ float $scale;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWidth;
    final /* synthetic */ float $topPadding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1(CoroutineScope coroutineScope, Density density, Animatable<Float, AnimationVector1D> animatable, float f, float f2, State<Dp> state, Animatable<Float, AnimationVector1D> animatable2, float f3, float f4, float f5, State<Dp> state2) {
        this.$coroutineScope = coroutineScope;
        this.$density = density;
        this.$animX = animatable;
        this.$floatingPadding = f;
        this.$screenWidth = f2;
        this.$floatingViewWidth$delegate = state;
        this.$animY = animatable2;
        this.$topPadding = f3;
        this.$screenHeight = f4;
        this.$scale = f5;
        this.$floatingViewHeight$delegate = state2;
    }

    public final Object invoke(final PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final CoroutineScope coroutineScope = this.$coroutineScope;
        final Density density = this.$density;
        final Animatable<Float, AnimationVector1D> animatable = this.$animX;
        final float f = this.$floatingPadding;
        final float f2 = this.$screenWidth;
        final State<Dp> state = this.$floatingViewWidth$delegate;
        Function0 function0 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit invoke$lambda$0;
                invoke$lambda$0 = MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1.invoke$lambda$0(coroutineScope, density, animatable, $this$pointerInput, f, f2, state);
                return invoke$lambda$0;
            }
        };
        final CoroutineScope coroutineScope2 = this.$coroutineScope;
        final Animatable<Float, AnimationVector1D> animatable2 = this.$animX;
        final Density density2 = this.$density;
        final Animatable<Float, AnimationVector1D> animatable3 = this.$animY;
        final float f3 = this.$screenWidth;
        final State<Dp> state2 = this.$floatingViewWidth$delegate;
        final float f4 = this.$topPadding;
        final float f5 = this.$screenHeight;
        final float f6 = this.$scale;
        final State<Dp> state3 = this.$floatingViewHeight$delegate;
        Object detectDragGestures$default = DragGestureDetectorKt.detectDragGestures$default($this$pointerInput, (Function1) null, function0, (Function0) null, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit invoke$lambda$1;
                invoke$lambda$1 = MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1.invoke$lambda$1(coroutineScope2, animatable2, density2, animatable3, f3, state2, f4, f5, f6, state3, (PointerInputChange) obj, (Offset) obj2);
                return invoke$lambda$1;
            }
        }, continuation, 5, (Object) null);
        return detectDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(CoroutineScope $coroutineScope, Density $density, Animatable $animX, PointerInputScope $this_pointerInput, float $floatingPadding, float $screenWidth, State $floatingViewWidth$delegate) {
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$1$1($density, $animX, $this_pointerInput, $floatingPadding, $screenWidth, $floatingViewWidth$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(CoroutineScope $coroutineScope, Animatable $animX, Density $density, Animatable $animY, float $screenWidth, State $floatingViewWidth$delegate, float $topPadding, float $screenHeight, float $scale, State $floatingViewHeight$delegate, PointerInputChange change, Offset dragAmount) {
        Intrinsics.checkNotNullParameter(change, "change");
        change.consume();
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$2$1($animX, dragAmount, $density, $animY, $screenWidth, $floatingViewWidth$delegate, $topPadding, $screenHeight, $scale, $floatingViewHeight$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}