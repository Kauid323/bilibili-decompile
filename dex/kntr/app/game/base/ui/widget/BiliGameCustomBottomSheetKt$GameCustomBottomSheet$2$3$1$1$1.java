package kntr.app.game.base.ui.widget;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
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
/* compiled from: BiliGameCustomBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1 implements PointerInputEventHandler {
    final /* synthetic */ float $maxOffset;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetY;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1(CoroutineScope coroutineScope, Animatable<Float, AnimationVector1D> animatable, float f, Function0<Unit> function0) {
        this.$scope = coroutineScope;
        this.$offsetY = animatable;
        this.$maxOffset = f;
        this.$onDismiss = function0;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final CoroutineScope coroutineScope = this.$scope;
        final Animatable<Float, AnimationVector1D> animatable = this.$offsetY;
        final float f = this.$maxOffset;
        final Function0<Unit> function0 = this.$onDismiss;
        Function0 function02 = new Function0() { // from class: kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit invoke$lambda$0;
                invoke$lambda$0 = BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1.invoke$lambda$0(coroutineScope, animatable, f, function0);
                return invoke$lambda$0;
            }
        };
        final CoroutineScope coroutineScope2 = this.$scope;
        final Animatable<Float, AnimationVector1D> animatable2 = this.$offsetY;
        final float f2 = this.$maxOffset;
        Object detectVerticalDragGestures$default = DragGestureDetectorKt.detectVerticalDragGestures$default($this$pointerInput, (Function1) null, function02, (Function0) null, new Function2() { // from class: kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit invoke$lambda$1;
                invoke$lambda$1 = BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1.invoke$lambda$1(coroutineScope2, animatable2, f2, (PointerInputChange) obj, ((Float) obj2).floatValue());
                return invoke$lambda$1;
            }
        }, continuation, 5, (Object) null);
        return detectVerticalDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectVerticalDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(CoroutineScope $scope, Animatable $offsetY, float $maxOffset, Function0 $onDismiss) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$1$1($offsetY, $maxOffset, $onDismiss, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(CoroutineScope $scope, Animatable $offsetY, float $maxOffset, PointerInputChange pointerInputChange, float dragAmount) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$2$1($offsetY, dragAmount, $maxOffset, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}