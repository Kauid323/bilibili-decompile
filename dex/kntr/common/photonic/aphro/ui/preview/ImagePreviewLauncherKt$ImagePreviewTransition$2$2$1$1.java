package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePreviewLauncher.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$ImagePreviewTransition$2$2$1$1", f = "ImagePreviewLauncher.kt", i = {0}, l = {161}, m = "invokeSuspend", n = {"resolution"}, s = {"L$0"}, v = 1)
public final class ImagePreviewLauncherKt$ImagePreviewTransition$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<IntSize> $parentSize$delegate;
    final /* synthetic */ AssetShower<PreviewableAsset> $shower;
    final /* synthetic */ MutableState<ImageSource> $sourceState;
    final /* synthetic */ TransitionState $state;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewLauncherKt$ImagePreviewTransition$2$2$1$1(MutableState<ImageSource> mutableState, AssetShower<PreviewableAsset> assetShower, TransitionState transitionState, MutableState<IntSize> mutableState2, Continuation<? super ImagePreviewLauncherKt$ImagePreviewTransition$2$2$1$1> continuation) {
        super(2, continuation);
        this.$sourceState = mutableState;
        this.$shower = assetShower;
        this.$state = transitionState;
        this.$parentSize$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePreviewLauncherKt$ImagePreviewTransition$2$2$1$1(this.$sourceState, this.$shower, this.$state, this.$parentSize$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long ImagePreviewTransition$lambda$1;
        long ImagePreviewTransition$lambda$12;
        MutableState<ImageSource> mutableState;
        ImageSource imageSource;
        Object imageSource2;
        MutableState<ImageSource> mutableState2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ImagePreviewTransition$lambda$1 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$1(this.$parentSize$delegate);
                ImagePreviewTransition$lambda$12 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$1(this.$parentSize$delegate);
                Resolution resolution = new Resolution((int) (ImagePreviewTransition$lambda$1 >> 32), (int) (4294967295L & ImagePreviewTransition$lambda$12));
                mutableState = this.$sourceState;
                AssetShower<PreviewableAsset> assetShower = this.$shower;
                if (assetShower == null) {
                    imageSource = null;
                    break;
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(resolution);
                    this.L$1 = mutableState;
                    this.label = 1;
                    imageSource2 = assetShower.getImageSource(this.$state.getAsset(), resolution, true, (Continuation) this);
                    if (imageSource2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableState2 = mutableState;
                    imageSource = (ImageSource) imageSource2;
                    mutableState = mutableState2;
                    break;
                }
            case 1:
                mutableState2 = (MutableState) this.L$1;
                Resolution resolution2 = (Resolution) this.L$0;
                ResultKt.throwOnFailure($result);
                imageSource2 = $result;
                imageSource = (ImageSource) imageSource2;
                mutableState = mutableState2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableState.setValue(imageSource);
        return Unit.INSTANCE;
    }
}