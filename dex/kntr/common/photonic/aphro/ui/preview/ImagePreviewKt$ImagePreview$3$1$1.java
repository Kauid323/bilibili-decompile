package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.datetime.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePreview.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewKt$ImagePreview$3$1$1 implements PointerInputEventHandler {
    final /* synthetic */ Function1<ExitTransitionState, Unit> $onDismissRequest;
    final /* synthetic */ Function0<Unit> $resetGestureState;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ ImagePreviewState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ImagePreviewKt$ImagePreview$3$1$1(ImagePreviewState imagePreviewState, Function1<? super ExitTransitionState, Unit> function1, Function0<Unit> function0, CoroutineScope coroutineScope) {
        this.$state = imagePreviewState;
        this.$onDismissRequest = function1;
        this.$resetGestureState = function0;
        this.$scope = coroutineScope;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final ImagePreviewState imagePreviewState = this.$state;
        Function1 function1 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$ImagePreview$3$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = ImagePreviewKt$ImagePreview$3$1$1.invoke$lambda$0(ImagePreviewState.this, (Offset) obj);
                return invoke$lambda$0;
            }
        };
        final ImagePreviewState imagePreviewState2 = this.$state;
        final Function1<ExitTransitionState, Unit> function12 = this.$onDismissRequest;
        final Function0<Unit> function0 = this.$resetGestureState;
        Function0 function02 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$ImagePreview$3$1$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit invoke$lambda$1;
                invoke$lambda$1 = ImagePreviewKt$ImagePreview$3$1$1.invoke$lambda$1(ImagePreviewState.this, function12, function0);
                return invoke$lambda$1;
            }
        };
        final ImagePreviewState imagePreviewState3 = this.$state;
        final CoroutineScope coroutineScope = this.$scope;
        Object detectDragGestures$default = DragGestureDetectorKt.detectDragGestures$default($this$pointerInput, function1, function02, (Function0) null, new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$ImagePreview$3$1$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit invoke$lambda$2;
                invoke$lambda$2 = ImagePreviewKt$ImagePreview$3$1$1.invoke$lambda$2(ImagePreviewState.this, coroutineScope, (PointerInputChange) obj, (Offset) obj2);
                return invoke$lambda$2;
            }
        }, continuation, 4, (Object) null);
        return detectDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(ImagePreviewState $state, Offset it) {
        $state.getAnimation().isDragging().setValue(true);
        $state.getAnimation().getTotalDragOffset().setValue(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()));
        $state.getAnimation().getLastDragTime().setValue(Long.valueOf(Clock.System.INSTANCE.now().toEpochMilliseconds()));
        $state.getAnimation().getVelocityY().setValue(Float.valueOf(0.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(ImagePreviewState $state, Function1 $onDismissRequest, Function0 $resetGestureState) {
        boolean shouldExit = false;
        $state.getAnimation().isDragging().setValue(false);
        int bits$iv$iv$iv = (int) (4294967295L & ((Offset) $state.getAnimation().getTotalDragOffset().getValue()).unbox-impl());
        float dy = Math.abs(Float.intBitsToFloat(bits$iv$iv$iv));
        int bits$iv$iv$iv2 = (int) (((Offset) $state.getAnimation().getTotalDragOffset().getValue()).unbox-impl() >> 32);
        float dx = Math.abs(Float.intBitsToFloat(bits$iv$iv$iv2));
        float vy = Math.abs(((Number) $state.getAnimation().getVelocityY().getValue()).floatValue());
        if (dy > 150.0f || (vy > 800.0f && dx < dy)) {
            shouldExit = true;
        }
        if (shouldExit) {
            $onDismissRequest.invoke($state.getExitTransitionState$ui_debug());
        } else {
            $resetGestureState.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2(ImagePreviewState $state, CoroutineScope $scope, PointerInputChange pointerInputChange, Offset dragAmount) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        if (!$state.isAnimating$ui_debug() && !$state.isExiting$ui_debug()) {
            long currentTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
            long deltaTime = currentTime - ((Number) $state.getAnimation().getLastDragTime().getValue()).longValue();
            MutableStateFlow<Offset> totalDragOffset = $state.getAnimation().getTotalDragOffset();
            int bits$iv$iv$iv = (int) (((Offset) $state.getAnimation().getTotalDragOffset().getValue()).unbox-impl() >> 32);
            float intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv);
            int bits$iv$iv$iv2 = (int) (dragAmount.unbox-impl() >> 32);
            float x$iv = intBitsToFloat + Float.intBitsToFloat(bits$iv$iv$iv2);
            int bits$iv$iv$iv3 = (int) (((Offset) $state.getAnimation().getTotalDragOffset().getValue()).unbox-impl() & 4294967295L);
            float intBitsToFloat2 = Float.intBitsToFloat(bits$iv$iv$iv3);
            int bits$iv$iv$iv4 = (int) (dragAmount.unbox-impl() & 4294967295L);
            float y$iv = intBitsToFloat2 + Float.intBitsToFloat(bits$iv$iv$iv4);
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            totalDragOffset.setValue(Offset.box-impl(Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L))));
            if (deltaTime > 0) {
                int bits$iv$iv$iv5 = (int) (4294967295L & dragAmount.unbox-impl());
                float instantVelocity = (Float.intBitsToFloat(bits$iv$iv$iv5) / ((float) deltaTime)) * ((float) MediaAttrUtils.TYPE_PAY_SEASON);
                $state.getAnimation().getVelocityY().setValue(Float.valueOf((((Number) $state.getAnimation().getVelocityY().getValue()).floatValue() * 0.8f) + (0.2f * instantVelocity)));
            }
            $state.getAnimation().getLastDragTime().setValue(Long.valueOf(currentTime));
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ImagePreviewKt$ImagePreview$3$1$1$3$1($state, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }
}