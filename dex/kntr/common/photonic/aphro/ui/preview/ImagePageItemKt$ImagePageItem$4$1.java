package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kntr.common.photonic.aphro.ui.preview.utils.DetectTransformGesturesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePageItem.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePageItemKt$ImagePageItem$4$1 implements PointerInputEventHandler {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetX;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetY;
    final /* synthetic */ Function1<ExitTransitionState, Unit> $onDismissRequest;
    final /* synthetic */ MutableState<IntSize> $parentSize$delegate;
    final /* synthetic */ MutableState<IntSize> $pictureSize$delegate;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ ImagePreviewState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ImagePageItemKt$ImagePageItem$4$1(Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, Animatable<Float, AnimationVector1D> animatable3, CoroutineScope coroutineScope, MutableState<IntSize> mutableState, MutableState<IntSize> mutableState2, ImagePreviewState imagePreviewState, Function1<? super ExitTransitionState, Unit> function1) {
        this.$offsetX = animatable;
        this.$offsetY = animatable2;
        this.$scale = animatable3;
        this.$scope = coroutineScope;
        this.$parentSize$delegate = mutableState;
        this.$pictureSize$delegate = mutableState2;
        this.$state = imagePreviewState;
        this.$onDismissRequest = function1;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final Animatable<Float, AnimationVector1D> animatable = this.$offsetX;
        final Animatable<Float, AnimationVector1D> animatable2 = this.$offsetY;
        final Animatable<Float, AnimationVector1D> animatable3 = this.$scale;
        final CoroutineScope coroutineScope = this.$scope;
        final MutableState<IntSize> mutableState = this.$parentSize$delegate;
        final MutableState<IntSize> mutableState2 = this.$pictureSize$delegate;
        Function1 function1 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = ImagePageItemKt$ImagePageItem$4$1.invoke$lambda$0(animatable, animatable2, animatable3, coroutineScope, mutableState, mutableState2, (Offset) obj);
                return invoke$lambda$0;
            }
        };
        final ImagePreviewState imagePreviewState = this.$state;
        final Function1<ExitTransitionState, Unit> function12 = this.$onDismissRequest;
        Object detectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, function1, (Function1) null, (Function3) null, new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$4$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invoke$lambda$1;
                invoke$lambda$1 = ImagePageItemKt$ImagePageItem$4$1.invoke$lambda$1(ImagePreviewState.this, function12, (Offset) obj);
                return invoke$lambda$1;
            }
        }, continuation, 6, (Object) null);
        return detectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Animatable $offsetX, Animatable $offsetY, Animatable $scale, CoroutineScope $scope, MutableState $parentSize$delegate, MutableState $pictureSize$delegate, Offset point) {
        long ImagePageItem$lambda$1;
        long ImagePageItem$lambda$12;
        long ImagePageItem$lambda$13;
        long ImagePageItem$lambda$4;
        long newOffset;
        ImagePageItem$lambda$1 = ImagePageItemKt.ImagePageItem$lambda$1($parentSize$delegate);
        float f = 2;
        float x$iv = ((int) (ImagePageItem$lambda$1 >> 32)) / f;
        ImagePageItem$lambda$12 = ImagePageItemKt.ImagePageItem$lambda$1($parentSize$delegate);
        int $i$f$unpackInt2 = (int) (ImagePageItem$lambda$12 & 4294967295L);
        float y$iv = $i$f$unpackInt2 / f;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long center = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        float x$iv2 = ((Number) $offsetX.getValue()).floatValue();
        float y$iv2 = ((Number) $offsetY.getValue()).floatValue();
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        long realPoint = Offset.minus-MK-Hz9U(Offset.plus-MK-Hz9U(Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), center), point.unbox-impl());
        float newScale = ((Number) $scale.getValue()).floatValue() <= 1.0f ? 2.0f : 1.0f;
        if (newScale > 1.0f) {
            ImagePageItem$lambda$13 = ImagePageItemKt.ImagePageItem$lambda$1($parentSize$delegate);
            long j = IntSizeKt.toSize-ozmzZPI(ImagePageItem$lambda$13);
            ImagePageItem$lambda$4 = ImagePageItemKt.ImagePageItem$lambda$4($pictureSize$delegate);
            newOffset = DetectTransformGesturesKt.m2324calculateOffsete7dZX2I(j, IntSizeKt.toSize-ozmzZPI(ImagePageItem$lambda$4), newScale, Offset.times-tuRUvjQ(realPoint, newScale)).getFirst().unbox-impl();
        } else {
            newOffset = Offset.Companion.getZero-F1C5BW0();
        }
        TweenSpec animationSpec = AnimationSpecKt.tween$default(200, 0, (Easing) null, 6, (Object) null);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePageItemKt$ImagePageItem$4$1$1$1($scale, newScale, animationSpec, null), 3, (Object) null);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePageItemKt$ImagePageItem$4$1$1$2($offsetX, newOffset, animationSpec, null), 3, (Object) null);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePageItemKt$ImagePageItem$4$1$1$3($offsetY, newOffset, animationSpec, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(ImagePreviewState $state, Function1 $onDismissRequest, Offset it) {
        if (!$state.isAnimating$ui_debug() && !$state.isExiting$ui_debug()) {
            $onDismissRequest.invoke($state.getExitTransitionState$ui_debug());
        }
        return Unit.INSTANCE;
    }
}