package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSizeKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePreviewLauncher.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$ImagePreviewTransition$1$1", f = "ImagePreviewLauncher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImagePreviewLauncherKt$ImagePreviewTransition$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<LayoutCoordinates> $boxCoordinates$delegate;
    final /* synthetic */ MutableState<IntRect> $exitSourcePictureFrame$delegate;
    final /* synthetic */ ImagePreviewState $previewState;
    final /* synthetic */ TransitionState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewLauncherKt$ImagePreviewTransition$1$1(TransitionState transitionState, ImagePreviewState imagePreviewState, MutableState<LayoutCoordinates> mutableState, MutableState<IntRect> mutableState2, Continuation<? super ImagePreviewLauncherKt$ImagePreviewTransition$1$1> continuation) {
        super(2, continuation);
        this.$state = transitionState;
        this.$previewState = imagePreviewState;
        this.$boxCoordinates$delegate = mutableState;
        this.$exitSourcePictureFrame$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePreviewLauncherKt$ImagePreviewTransition$1$1(this.$state, this.$previewState, this.$boxCoordinates$delegate, this.$exitSourcePictureFrame$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
        r4 = kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt.ImagePreviewTransition$lambda$10(r22.$boxCoordinates$delegate);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        LayoutCoordinates ImagePreviewTransition$lambda$10;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$state.getAnimationPhase().getValue() == AnimationPhase.Exiting) {
                    MutableState<IntRect> mutableState = this.$exitSourcePictureFrame$delegate;
                    Rect rect = (Rect) this.$previewState.getCurrentPictureRect().getValue();
                    IntRect intRect = null;
                    if (rect != null && ImagePreviewTransition$lambda$10 != null) {
                        float x$iv = rect.getLeft();
                        float y$iv = rect.getTop();
                        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
                        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                        long it = ImagePreviewTransition$lambda$10.windowToLocal-MK-Hz9U(Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)));
                        int bits$iv$iv$iv = (int) (it >> 32);
                        int x$iv2 = (int) Float.intBitsToFloat(bits$iv$iv$iv);
                        int bits$iv$iv$iv2 = (int) (it & 4294967295L);
                        int y$iv2 = (int) Float.intBitsToFloat(bits$iv$iv$iv2);
                        intRect = IntRectKt.IntRect-VbeCjmY(IntOffset.constructor-impl((x$iv2 << 32) | (y$iv2 & 4294967295L)), IntSizeKt.toIntSize-uvyYCjk(rect.getSize-NH-jbRc()));
                    }
                    mutableState.setValue(intRect);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}