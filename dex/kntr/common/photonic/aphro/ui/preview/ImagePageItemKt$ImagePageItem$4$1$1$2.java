package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePageItem.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$4$1$1$2", f = "ImagePageItem.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImagePageItemKt$ImagePageItem$4$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TweenSpec<Float> $animationSpec;
    final /* synthetic */ long $newOffset;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetX;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePageItemKt$ImagePageItem$4$1$1$2(Animatable<Float, AnimationVector1D> animatable, long j, TweenSpec<Float> tweenSpec, Continuation<? super ImagePageItemKt$ImagePageItem$4$1$1$2> continuation) {
        super(2, continuation);
        this.$offsetX = animatable;
        this.$newOffset = j;
        this.$animationSpec = tweenSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePageItemKt$ImagePageItem$4$1$1$2(this.$offsetX, this.$newOffset, this.$animationSpec, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Animatable<Float, AnimationVector1D> animatable = this.$offsetX;
                int bits$iv$iv$iv = (int) (this.$newOffset >> 32);
                this.label = 1;
                if (Animatable.animateTo$default(animatable, Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv)), this.$animationSpec, (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}