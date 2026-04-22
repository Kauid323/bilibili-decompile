package kntr.app.game.base.ui.widget;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
/* compiled from: BiliGameCustomBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$2$1", f = "BiliGameCustomBottomSheet.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $dragAmount;
    final /* synthetic */ float $maxOffset;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetY;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$2$1(Animatable<Float, AnimationVector1D> animatable, float f, float f2, Continuation<? super BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$2$1> continuation) {
        super(2, continuation);
        this.$offsetY = animatable;
        this.$dragAmount = f;
        this.$maxOffset = f2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$2$1(this.$offsetY, this.$dragAmount, this.$maxOffset, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$offsetY.snapTo(Boxing.boxFloat(RangesKt.coerceIn(((Number) this.$offsetY.getValue()).floatValue() + this.$dragAmount, 0.0f, this.$maxOffset)), (Continuation) this) == coroutine_suspended) {
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