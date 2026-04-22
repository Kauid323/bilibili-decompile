package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.Density;
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
/* compiled from: LiveInfoFloatingComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$1$1", f = "LiveInfoFloatingComponent.kt", i = {0, 0}, l = {109}, m = "invokeSuspend", n = {"screenWidthPx", "finalX"}, s = {"F$0", "F$1"}, v = 1)
public final class LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animX;
    final /* synthetic */ Density $density;
    final /* synthetic */ float $floatRightPadding;
    final /* synthetic */ float $floatWidth;
    final /* synthetic */ float $screenWidth;
    final /* synthetic */ PointerInputScope $this_pointerInput;
    float F$0;
    float F$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$1$1(Density density, Animatable<Float, AnimationVector1D> animatable, PointerInputScope pointerInputScope, float f, float f2, float f3, Continuation<? super LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$1$1> continuation) {
        super(2, continuation);
        this.$density = density;
        this.$animX = animatable;
        this.$this_pointerInput = pointerInputScope;
        this.$floatRightPadding = f;
        this.$floatWidth = f2;
        this.$screenWidth = f3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$1$1(this.$density, this.$animX, this.$this_pointerInput, this.$floatRightPadding, this.$floatWidth, this.$screenWidth, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        float finalX;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Density $this$invokeSuspend_u24lambda_u240 = this.$density;
                float screenWidthPx = $this$invokeSuspend_u24lambda_u240.toPx-0680j_4(this.$screenWidth);
                if (((Number) this.$animX.getValue()).floatValue() < screenWidthPx / 2) {
                    finalX = this.$this_pointerInput.toPx-0680j_4(this.$floatRightPadding);
                } else {
                    finalX = (screenWidthPx - this.$this_pointerInput.toPx-0680j_4(this.$floatWidth)) - this.$this_pointerInput.toPx-0680j_4(this.$floatRightPadding);
                }
                this.F$0 = screenWidthPx;
                this.F$1 = finalX;
                this.label = 1;
                if (Animatable.animateTo$default(this.$animX, Boxing.boxFloat(finalX), (AnimationSpec) null, (Object) null, (Function1) null, (Continuation) this, 14, (Object) null) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                float f = this.F$1;
                float f2 = this.F$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}