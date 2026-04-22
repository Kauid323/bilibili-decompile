package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataNotifier;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPageContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$PreviewPageContent$1$2$1", f = "PreviewPageContent.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PreviewPageContentKt$PreviewPageContent$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<AnimationPhase> $animationPhase$delegate;
    final /* synthetic */ State<Function0<Unit>> $close;
    final /* synthetic */ ImagePreviewDataSource $imagePreviewData;
    final /* synthetic */ TransitionState $transitionState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PreviewPageContentKt$PreviewPageContent$1$2$1(TransitionState transitionState, State<? extends Function0<Unit>> state, ImagePreviewDataSource imagePreviewDataSource, State<? extends AnimationPhase> state2, Continuation<? super PreviewPageContentKt$PreviewPageContent$1$2$1> continuation) {
        super(2, continuation);
        this.$transitionState = transitionState;
        this.$close = state;
        this.$imagePreviewData = imagePreviewDataSource;
        this.$animationPhase$delegate = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreviewPageContentKt$PreviewPageContent$1$2$1(this.$transitionState, this.$close, this.$imagePreviewData, this.$animationPhase$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        AnimationPhase PreviewPageContent$lambda$4$1;
        ImagePreviewType.Gallery gallery;
        String it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PreviewPageContent$lambda$4$1 = PreviewPageContentKt.PreviewPageContent$lambda$4$1(this.$animationPhase$delegate);
                if (PreviewPageContent$lambda$4$1 == AnimationPhase.Exiting) {
                    this.label = 1;
                    if (Animatable.animateTo$default(this.$transitionState.getAnimationProgress(), Boxing.boxFloat(0.0f), AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.$transitionState.getAnimationPhase().setValue(AnimationPhase.Exited);
                    ((Function0) this.$close.getValue()).invoke();
                    ImagePreviewType imagePreviewType = this.$imagePreviewData.getImagePreviewType();
                    gallery = !(imagePreviewType instanceof ImagePreviewType.Gallery) ? (ImagePreviewType.Gallery) imagePreviewType : null;
                    if (gallery != null && (it = gallery.getSelectMatchKey()) != null) {
                        SendChannel.DefaultImpls.close$default(ImagePreviewDataNotifier.INSTANCE.getPreviewSelectResultChannel(((ImagePreviewType.Gallery) this.$imagePreviewData.getImagePreviewType()).getSelectMatchKey()), (Throwable) null, 1, (Object) null);
                        ImagePreviewDataNotifier.INSTANCE.clearPreviewSelectResultChannel(it);
                        break;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                this.$transitionState.getAnimationPhase().setValue(AnimationPhase.Exited);
                ((Function0) this.$close.getValue()).invoke();
                ImagePreviewType imagePreviewType2 = this.$imagePreviewData.getImagePreviewType();
                if (!(imagePreviewType2 instanceof ImagePreviewType.Gallery)) {
                }
                if (gallery != null) {
                    SendChannel.DefaultImpls.close$default(ImagePreviewDataNotifier.INSTANCE.getPreviewSelectResultChannel(((ImagePreviewType.Gallery) this.$imagePreviewData.getImagePreviewType()).getSelectMatchKey()), (Throwable) null, 1, (Object) null);
                    ImagePreviewDataNotifier.INSTANCE.clearPreviewSelectResultChannel(it);
                    break;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}