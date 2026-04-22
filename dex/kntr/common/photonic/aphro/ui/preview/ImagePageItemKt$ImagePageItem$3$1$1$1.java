package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.geometry.Offset;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePageItem.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$3$1$1$1", f = "ImagePageItem.kt", i = {}, l = {133, 134, 135}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImagePageItemKt$ImagePageItem$3$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $newScale;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetX;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetY;
    final /* synthetic */ Pair<Offset, Boolean> $result;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePageItemKt$ImagePageItem$3$1$1$1(Animatable<Float, AnimationVector1D> animatable, float f, Animatable<Float, AnimationVector1D> animatable2, Pair<Offset, Boolean> pair, Animatable<Float, AnimationVector1D> animatable3, Continuation<? super ImagePageItemKt$ImagePageItem$3$1$1$1> continuation) {
        super(2, continuation);
        this.$scale = animatable;
        this.$newScale = f;
        this.$offsetX = animatable2;
        this.$result = pair;
        this.$offsetY = animatable3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePageItemKt$ImagePageItem$3$1$1$1(this.$scale, this.$newScale, this.$offsetX, this.$result, this.$offsetY, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0093 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Animatable<Float, AnimationVector1D> animatable;
        int bits$iv$iv$iv;
        Animatable<Float, AnimationVector1D> animatable2;
        int bits$iv$iv$iv2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$scale.snapTo(Boxing.boxFloat(this.$newScale), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                animatable = this.$offsetX;
                bits$iv$iv$iv = (int) (this.$result.getFirst().unbox-impl() >> 32);
                this.label = 2;
                if (animatable.snapTo(Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                animatable2 = this.$offsetY;
                bits$iv$iv$iv2 = (int) (4294967295L & this.$result.getFirst().unbox-impl());
                this.label = 3;
                if (animatable2.snapTo(Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv2)), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                animatable = this.$offsetX;
                bits$iv$iv$iv = (int) (this.$result.getFirst().unbox-impl() >> 32);
                this.label = 2;
                if (animatable.snapTo(Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv)), (Continuation) this) == coroutine_suspended) {
                }
                animatable2 = this.$offsetY;
                bits$iv$iv$iv2 = (int) (4294967295L & this.$result.getFirst().unbox-impl());
                this.label = 3;
                if (animatable2.snapTo(Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv2)), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                animatable2 = this.$offsetY;
                bits$iv$iv$iv2 = (int) (4294967295L & this.$result.getFirst().unbox-impl());
                this.label = 3;
                if (animatable2.snapTo(Boxing.boxFloat(Float.intBitsToFloat(bits$iv$iv$iv2)), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}