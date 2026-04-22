package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.utils.DetectTransformGesturesKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function5;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePageItem.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePageItemKt$ImagePageItem$3$1 implements PointerInputEventHandler {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetX;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetY;
    final /* synthetic */ MutableState<IntSize> $parentSize$delegate;
    final /* synthetic */ MutableState<IntSize> $pictureSize$delegate;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImagePageItemKt$ImagePageItem$3$1(Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, Animatable<Float, AnimationVector1D> animatable3, CoroutineScope coroutineScope, MutableState<IntSize> mutableState, MutableState<IntSize> mutableState2) {
        this.$scale = animatable;
        this.$offsetX = animatable2;
        this.$offsetY = animatable3;
        this.$scope = coroutineScope;
        this.$parentSize$delegate = mutableState;
        this.$pictureSize$delegate = mutableState2;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final Animatable<Float, AnimationVector1D> animatable = this.$scale;
        final Animatable<Float, AnimationVector1D> animatable2 = this.$offsetX;
        final Animatable<Float, AnimationVector1D> animatable3 = this.$offsetY;
        final CoroutineScope coroutineScope = this.$scope;
        final MutableState<IntSize> mutableState = this.$parentSize$delegate;
        final MutableState<IntSize> mutableState2 = this.$pictureSize$delegate;
        Object detectTransformGestures$default = DetectTransformGesturesKt.detectTransformGestures$default($this$pointerInput, false, new Function5() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$3$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                boolean invoke$lambda$0;
                invoke$lambda$0 = ImagePageItemKt$ImagePageItem$3$1.invoke$lambda$0(animatable, animatable2, animatable3, coroutineScope, mutableState, mutableState2, ((Integer) obj).intValue(), (Offset) obj2, (Offset) obj3, ((Float) obj4).floatValue(), ((Float) obj5).floatValue());
                return Boolean.valueOf(invoke$lambda$0);
            }
        }, continuation, 1, null);
        return detectTransformGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTransformGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(Animatable $scale, Animatable $offsetX, Animatable $offsetY, CoroutineScope $scope, MutableState $parentSize$delegate, MutableState $pictureSize$delegate, int count, Offset offset, Offset pan, float zoom, float f) {
        long ImagePageItem$lambda$1;
        long ImagePageItem$lambda$4;
        long ImagePageItem$lambda$12;
        long ImagePageItem$lambda$42;
        if (count >= 2) {
            float newScale = RangesKt.coerceIn(((Number) $scale.getValue()).floatValue() * zoom, 1.0f, 5.0f);
            ImagePageItem$lambda$12 = ImagePageItemKt.ImagePageItem$lambda$1($parentSize$delegate);
            long j = IntSizeKt.toSize-ozmzZPI(ImagePageItem$lambda$12);
            ImagePageItem$lambda$42 = ImagePageItemKt.ImagePageItem$lambda$4($pictureSize$delegate);
            long j2 = IntSizeKt.toSize-ozmzZPI(ImagePageItem$lambda$42);
            float x$iv = ((Number) $offsetX.getValue()).floatValue();
            float y$iv = ((Number) $offsetY.getValue()).floatValue();
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePageItemKt$ImagePageItem$3$1$1$1($scale, newScale, $offsetX, DetectTransformGesturesKt.m2324calculateOffsete7dZX2I(j, j2, newScale, Offset.plus-MK-Hz9U(Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), Offset.times-tuRUvjQ(pan.unbox-impl(), ((Number) $scale.getValue()).floatValue()))), $offsetY, null), 3, (Object) null);
            return true;
        }
        if (zoom == 1.0f) {
            if (((Number) $offsetX.getValue()).floatValue() == 0.0f) {
                if (((Number) $offsetY.getValue()).floatValue() == 0.0f) {
                    if (((Number) $scale.getValue()).floatValue() == 1.0f) {
                        return false;
                    }
                }
            }
        }
        float newScale2 = RangesKt.coerceIn(((Number) $scale.getValue()).floatValue() * zoom, 1.0f, 5.0f);
        ImagePageItem$lambda$1 = ImagePageItemKt.ImagePageItem$lambda$1($parentSize$delegate);
        long j3 = IntSizeKt.toSize-ozmzZPI(ImagePageItem$lambda$1);
        ImagePageItem$lambda$4 = ImagePageItemKt.ImagePageItem$lambda$4($pictureSize$delegate);
        long j4 = IntSizeKt.toSize-ozmzZPI(ImagePageItem$lambda$4);
        float x$iv2 = ((Number) $offsetX.getValue()).floatValue();
        float y$iv2 = ((Number) $offsetY.getValue()).floatValue();
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        Pair result = DetectTransformGesturesKt.m2324calculateOffsete7dZX2I(j3, j4, newScale2, Offset.plus-MK-Hz9U(Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), Offset.times-tuRUvjQ(pan.unbox-impl(), ((Number) $scale.getValue()).floatValue())));
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePageItemKt$ImagePageItem$3$1$1$2($scale, newScale2, $offsetX, result, $offsetY, null), 3, (Object) null);
        return result.getSecond().booleanValue();
    }
}