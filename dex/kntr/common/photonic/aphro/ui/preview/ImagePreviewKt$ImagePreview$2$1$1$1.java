package kntr.common.photonic.aphro.ui.preview;

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

/* compiled from: ImagePreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePreviewKt$ImagePreview$2$1$1$1", f = "ImagePreview.kt", i = {}, l = {89, 90, 91, 92}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ImagePreviewKt$ImagePreview$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImagePreviewState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewKt$ImagePreview$2$1$1$1(ImagePreviewState imagePreviewState, Continuation<? super ImagePreviewKt$ImagePreview$2$1$1$1> continuation) {
        super(2, continuation);
        this.$state = imagePreviewState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePreviewKt$ImagePreview$2$1$1$1(this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$state.getAnimation().getGestureOffsetX().stop((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                if (this.$state.getAnimation().getGestureOffsetY().stop((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 3;
                if (this.$state.getAnimation().getGestureScale().stop((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 4;
                if (this.$state.getAnimation().getGestureBackgroundAlpha().stop((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (this.$state.getAnimation().getGestureOffsetY().stop((Continuation) this) == coroutine_suspended) {
                }
                this.label = 3;
                if (this.$state.getAnimation().getGestureScale().stop((Continuation) this) == coroutine_suspended) {
                }
                this.label = 4;
                if (this.$state.getAnimation().getGestureBackgroundAlpha().stop((Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                this.label = 3;
                if (this.$state.getAnimation().getGestureScale().stop((Continuation) this) == coroutine_suspended) {
                }
                this.label = 4;
                if (this.$state.getAnimation().getGestureBackgroundAlpha().stop((Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                this.label = 4;
                if (this.$state.getAnimation().getGestureBackgroundAlpha().stop((Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}