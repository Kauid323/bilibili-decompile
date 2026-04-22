package kntr.app.game.base.ui.widget;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliGameCustomBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$1$1", f = "BiliGameCustomBottomSheet.kt", i = {}, l = {100, 103}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $maxOffset;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetY;
    final /* synthetic */ Function0<Unit> $onDismiss;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$1$1(Animatable<Float, AnimationVector1D> animatable, float f, Function0<Unit> function0, Continuation<? super BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$offsetY = animatable;
        this.$maxOffset = f;
        this.$onDismiss = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1$1$1(this.$offsetY, this.$maxOffset, this.$onDismiss, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (((Number) this.$offsetY.getValue()).floatValue() > this.$maxOffset * 0.3f) {
                    this.label = 1;
                    if (Animatable.animateTo$default(this.$offsetY, Boxing.boxFloat(this.$maxOffset), (AnimationSpec) null, (Object) null, (Function1) null, (Continuation) this, 14, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.$onDismiss.invoke();
                    Unit unit = Unit.INSTANCE;
                    break;
                } else {
                    this.label = 2;
                    if (Animatable.animateTo$default(this.$offsetY, Boxing.boxFloat(0.0f), (AnimationSpec) null, (Object) null, (Function1) null, (Continuation) this, 14, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                this.$onDismiss.invoke();
                Unit unit2 = Unit.INSTANCE;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}