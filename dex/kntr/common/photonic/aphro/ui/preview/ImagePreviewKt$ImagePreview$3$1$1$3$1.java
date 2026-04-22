package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.geometry.Offset;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$ImagePreview$3$1$1$3$1", f = "ImagePreview.kt", i = {2, 2, 2, 3, 3, 3}, l = {145, 146, 157, 158}, m = "invokeSuspend", n = {"progress", "scale", "alpha", "progress", "scale", "alpha"}, s = {"F$0", "F$1", "F$2", "F$0", "F$1", "F$2"}, v = 1)
public final class ImagePreviewKt$ImagePreview$3$1$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImagePreviewState $state;
    float F$0;
    float F$1;
    float F$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewKt$ImagePreview$3$1$1$3$1(ImagePreviewState imagePreviewState, Continuation<? super ImagePreviewKt$ImagePreview$3$1$1$3$1> continuation) {
        super(2, continuation);
        this.$state = imagePreviewState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePreviewKt$ImagePreview$3$1$1$3$1(this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0131 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Animatable<Float, AnimationVector1D> gestureOffsetY;
        int bits$iv$iv$iv;
        float scale;
        float alpha;
        float scale2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Animatable<Float, AnimationVector1D> gestureOffsetX = this.$state.getAnimation().getGestureOffsetX();
                int bits$iv$iv$iv2 = (int) (((Offset) this.$state.getAnimation().getTotalDragOffset().getValue()).unbox-impl() >> 32);
                this.label = 1;
                if (gestureOffsetX.snapTo(Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv2)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                gestureOffsetY = this.$state.getAnimation().getGestureOffsetY();
                bits$iv$iv$iv = (int) (((Offset) this.$state.getAnimation().getTotalDragOffset().getValue()).unbox-impl() & 4294967295L);
                this.label = 2;
                if (gestureOffsetY.snapTo(Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                int bits$iv$iv$iv3 = (int) (4294967295L & ((Offset) this.$state.getAnimation().getTotalDragOffset().getValue()).unbox-impl());
                float progress = RangesKt.coerceIn(Math.abs(Float.intBitsToFloat(bits$iv$iv$iv3)) / 150.0f, 0.0f, 1.0f);
                scale = 1.0f - (0.3f * progress);
                float alpha2 = 1.0f - (0.5f * progress);
                this.F$0 = progress;
                this.F$1 = scale;
                this.F$2 = alpha2;
                this.label = 3;
                if (this.$state.getAnimation().getGestureScale().snapTo(Boxing.boxFloat(scale), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                alpha = progress;
                scale2 = alpha2;
                this.F$0 = alpha;
                this.F$1 = scale;
                this.F$2 = scale2;
                this.label = 4;
                return this.$state.getAnimation().getGestureBackgroundAlpha().snapTo(Boxing.boxFloat(scale2), (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                gestureOffsetY = this.$state.getAnimation().getGestureOffsetY();
                bits$iv$iv$iv = (int) (((Offset) this.$state.getAnimation().getTotalDragOffset().getValue()).unbox-impl() & 4294967295L);
                this.label = 2;
                if (gestureOffsetY.snapTo(Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv)), (Continuation) this) == coroutine_suspended) {
                }
                int bits$iv$iv$iv32 = (int) (4294967295L & ((Offset) this.$state.getAnimation().getTotalDragOffset().getValue()).unbox-impl());
                float progress2 = RangesKt.coerceIn(Math.abs(Float.intBitsToFloat(bits$iv$iv$iv32)) / 150.0f, 0.0f, 1.0f);
                scale = 1.0f - (0.3f * progress2);
                float alpha22 = 1.0f - (0.5f * progress2);
                this.F$0 = progress2;
                this.F$1 = scale;
                this.F$2 = alpha22;
                this.label = 3;
                if (this.$state.getAnimation().getGestureScale().snapTo(Boxing.boxFloat(scale), (Continuation) this) == coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                int bits$iv$iv$iv322 = (int) (4294967295L & ((Offset) this.$state.getAnimation().getTotalDragOffset().getValue()).unbox-impl());
                float progress22 = RangesKt.coerceIn(Math.abs(Float.intBitsToFloat(bits$iv$iv$iv322)) / 150.0f, 0.0f, 1.0f);
                scale = 1.0f - (0.3f * progress22);
                float alpha222 = 1.0f - (0.5f * progress22);
                this.F$0 = progress22;
                this.F$1 = scale;
                this.F$2 = alpha222;
                this.label = 3;
                if (this.$state.getAnimation().getGestureScale().snapTo(Boxing.boxFloat(scale), (Continuation) this) == coroutine_suspended) {
                }
                break;
            case 3:
                scale2 = this.F$2;
                scale = this.F$1;
                alpha = this.F$0;
                ResultKt.throwOnFailure($result);
                this.F$0 = alpha;
                this.F$1 = scale;
                this.F$2 = scale2;
                this.label = 4;
                if (this.$state.getAnimation().getGestureBackgroundAlpha().snapTo(Boxing.boxFloat(scale2), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 4:
                float f = this.F$2;
                float f2 = this.F$1;
                float f3 = this.F$0;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}