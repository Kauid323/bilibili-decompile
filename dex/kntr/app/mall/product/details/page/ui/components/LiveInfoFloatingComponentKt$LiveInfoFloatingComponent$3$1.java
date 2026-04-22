package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.Density;
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
/* compiled from: LiveInfoFloatingComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1 implements PointerInputEventHandler {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animX;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animY;
    final /* synthetic */ float $bottomPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Density $density;
    final /* synthetic */ float $floatRightPadding;
    final /* synthetic */ float $floatWidth;
    final /* synthetic */ float $scale;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWidth;
    final /* synthetic */ float $topPadding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1(CoroutineScope coroutineScope, Density density, Animatable<Float, AnimationVector1D> animatable, float f, float f2, float f3, Animatable<Float, AnimationVector1D> animatable2, float f4, float f5, float f6, float f7) {
        this.$coroutineScope = coroutineScope;
        this.$density = density;
        this.$animX = animatable;
        this.$floatRightPadding = f;
        this.$floatWidth = f2;
        this.$screenWidth = f3;
        this.$animY = animatable2;
        this.$topPadding = f4;
        this.$screenHeight = f5;
        this.$bottomPadding = f6;
        this.$scale = f7;
    }

    public final Object invoke(final PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final CoroutineScope coroutineScope = this.$coroutineScope;
        final Density density = this.$density;
        final Animatable<Float, AnimationVector1D> animatable = this.$animX;
        final float f = this.$floatRightPadding;
        final float f2 = this.$floatWidth;
        final float f3 = this.$screenWidth;
        Function0 function0 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit invoke$lambda$0;
                invoke$lambda$0 = LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1.invoke$lambda$0(coroutineScope, density, animatable, $this$pointerInput, f, f2, f3);
                return invoke$lambda$0;
            }
        };
        final CoroutineScope coroutineScope2 = this.$coroutineScope;
        final Animatable<Float, AnimationVector1D> animatable2 = this.$animX;
        final Density density2 = this.$density;
        final Animatable<Float, AnimationVector1D> animatable3 = this.$animY;
        final float f4 = this.$screenWidth;
        final float f5 = this.$floatWidth;
        final float f6 = this.$topPadding;
        final float f7 = this.$screenHeight;
        final float f8 = this.$bottomPadding;
        final float f9 = this.$scale;
        Object detectDragGestures$default = DragGestureDetectorKt.detectDragGestures$default($this$pointerInput, (Function1) null, function0, (Function0) null, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit invoke$lambda$1;
                invoke$lambda$1 = LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1.invoke$lambda$1(coroutineScope2, animatable2, density2, animatable3, f4, f5, f6, f7, f8, f9, (PointerInputChange) obj, (Offset) obj2);
                return invoke$lambda$1;
            }
        }, continuation, 5, (Object) null);
        return detectDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(CoroutineScope $coroutineScope, Density $density, Animatable $animX, PointerInputScope $this_pointerInput, float $floatRightPadding, float $floatWidth, float $screenWidth) {
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$1$1($density, $animX, $this_pointerInput, $floatRightPadding, $floatWidth, $screenWidth, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(CoroutineScope $coroutineScope, Animatable $animX, Density $density, Animatable $animY, float $screenWidth, float $floatWidth, float $topPadding, float $screenHeight, float $bottomPadding, float $scale, PointerInputChange change, Offset dragAmount) {
        Intrinsics.checkNotNullParameter(change, "change");
        change.consume();
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$2$1($animX, dragAmount, $density, $animY, $screenWidth, $floatWidth, $topPadding, $screenHeight, $bottomPadding, $scale, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}