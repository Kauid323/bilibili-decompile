package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.utils.IntSizeExtKt;
import kntr.common.photonic.aphro.ui.preview.utils.ResolutionExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePreviewLauncher.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncherKt$ImagePreviewTransition$2$2$2$1", f = "ImagePreviewLauncher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImagePreviewLauncherKt$ImagePreviewTransition$2$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<IntSize> $parentSize$delegate;
    final /* synthetic */ MutableState<IntOffset> $pictureOffset$delegate;
    final /* synthetic */ MutableState<IntSize> $pictureSize$delegate;
    final /* synthetic */ TransitionState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewLauncherKt$ImagePreviewTransition$2$2$2$1(TransitionState transitionState, MutableState<IntSize> mutableState, MutableState<IntSize> mutableState2, MutableState<IntOffset> mutableState3, Continuation<? super ImagePreviewLauncherKt$ImagePreviewTransition$2$2$2$1> continuation) {
        super(2, continuation);
        this.$state = transitionState;
        this.$parentSize$delegate = mutableState;
        this.$pictureSize$delegate = mutableState2;
        this.$pictureOffset$delegate = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePreviewLauncherKt$ImagePreviewTransition$2$2$2$1(this.$state, this.$parentSize$delegate, this.$pictureSize$delegate, this.$pictureOffset$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long ImagePreviewTransition$lambda$1;
        long ImagePreviewTransition$lambda$12;
        long ImagePreviewTransition$lambda$4;
        long ImagePreviewTransition$lambda$13;
        long ImagePreviewTransition$lambda$42;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableState<IntSize> mutableState = this.$pictureSize$delegate;
                long intSize = ResolutionExtKt.toIntSize(this.$state.getAsset().getResolution());
                ImagePreviewTransition$lambda$1 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$1(this.$parentSize$delegate);
                ImagePreviewLauncherKt.ImagePreviewTransition$lambda$5(mutableState, IntSizeExtKt.m2327scaleInTemP2vQ(intSize, ImagePreviewTransition$lambda$1));
                MutableState<IntOffset> mutableState2 = this.$pictureOffset$delegate;
                ImagePreviewTransition$lambda$12 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$1(this.$parentSize$delegate);
                ImagePreviewTransition$lambda$4 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$4(this.$pictureSize$delegate);
                int x$iv = (int) ((((int) (ImagePreviewTransition$lambda$12 >> 32)) - ((int) (ImagePreviewTransition$lambda$4 >> 32))) / 2.0f);
                ImagePreviewTransition$lambda$13 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$1(this.$parentSize$delegate);
                int $i$f$unpackInt2 = (int) (ImagePreviewTransition$lambda$13 & 4294967295L);
                ImagePreviewTransition$lambda$42 = ImagePreviewLauncherKt.ImagePreviewTransition$lambda$4(this.$pictureSize$delegate);
                int y$iv = (int) RangesKt.coerceAtLeast(($i$f$unpackInt2 - ((int) (ImagePreviewTransition$lambda$42 & 4294967295L))) / 2.0f, 0.0f);
                ImagePreviewLauncherKt.ImagePreviewTransition$lambda$8(mutableState2, IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L)));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}