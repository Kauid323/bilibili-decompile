package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: LiveInfoFloatingComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$2$1", f = "LiveInfoFloatingComponent.kt", i = {}, l = {115, 121}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animX;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animY;
    final /* synthetic */ float $bottomPadding;
    final /* synthetic */ Density $density;
    final /* synthetic */ Offset $dragAmount;
    final /* synthetic */ float $floatWidth;
    final /* synthetic */ float $scale;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWidth;
    final /* synthetic */ float $topPadding;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$2$1(Animatable<Float, AnimationVector1D> animatable, Offset offset, Density density, Animatable<Float, AnimationVector1D> animatable2, float f, float f2, float f3, float f4, float f5, float f6, Continuation<? super LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$2$1> continuation) {
        super(2, continuation);
        this.$animX = animatable;
        this.$dragAmount = offset;
        this.$density = density;
        this.$animY = animatable2;
        this.$screenWidth = f;
        this.$floatWidth = f2;
        this.$topPadding = f3;
        this.$screenHeight = f4;
        this.$bottomPadding = f5;
        this.$scale = f6;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1$2$1(this.$animX, this.$dragAmount, this.$density, this.$animY, this.$screenWidth, this.$floatWidth, this.$topPadding, this.$screenHeight, this.$bottomPadding, this.$scale, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Animatable<Float, AnimationVector1D> animatable;
        float floatValue;
        int bits$iv$iv$iv;
        float f;
        Density $this$invokeSuspend_u24lambda_u242;
        float f2;
        float f3;
        float f4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Animatable<Float, AnimationVector1D> animatable2 = this.$animX;
                float floatValue2 = ((Number) this.$animX.getValue()).floatValue();
                int bits$iv$iv$iv2 = (int) (this.$dragAmount.unbox-impl() >> 32);
                Density $this$invokeSuspend_u24lambda_u240 = this.$density;
                float f5 = this.$screenWidth;
                float f6 = this.$floatWidth;
                this.label = 1;
                if (animatable2.snapTo(Boxing.boxFloat(RangesKt.coerceIn(floatValue2 + Float.intBitsToFloat(bits$iv$iv$iv2), 0.0f, $this$invokeSuspend_u24lambda_u240.toPx-0680j_4(f5) - $this$invokeSuspend_u24lambda_u240.toPx-0680j_4(f6))), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                animatable = this.$animY;
                floatValue = ((Number) this.$animY.getValue()).floatValue();
                bits$iv$iv$iv = (int) (4294967295L & this.$dragAmount.unbox-impl());
                Density $this$invokeSuspend_u24lambda_u241 = this.$density;
                f = $this$invokeSuspend_u24lambda_u241.toPx-0680j_4(this.$topPadding);
                $this$invokeSuspend_u24lambda_u242 = this.$density;
                f2 = this.$screenHeight;
                f3 = this.$bottomPadding;
                f4 = this.$scale;
                this.label = 2;
                if (animatable.snapTo(Boxing.boxFloat(RangesKt.coerceIn(floatValue + Float.intBitsToFloat(bits$iv$iv$iv), f, ($this$invokeSuspend_u24lambda_u242.toPx-0680j_4(f2) - $this$invokeSuspend_u24lambda_u242.toPx-0680j_4(f3)) - $this$invokeSuspend_u24lambda_u242.toPx-0680j_4(ProvideUiScaleKt.dpScaled(80, f4)))), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                animatable = this.$animY;
                floatValue = ((Number) this.$animY.getValue()).floatValue();
                bits$iv$iv$iv = (int) (4294967295L & this.$dragAmount.unbox-impl());
                Density $this$invokeSuspend_u24lambda_u2412 = this.$density;
                f = $this$invokeSuspend_u24lambda_u2412.toPx-0680j_4(this.$topPadding);
                $this$invokeSuspend_u24lambda_u242 = this.$density;
                f2 = this.$screenHeight;
                f3 = this.$bottomPadding;
                f4 = this.$scale;
                this.label = 2;
                if (animatable.snapTo(Boxing.boxFloat(RangesKt.coerceIn(floatValue + Float.intBitsToFloat(bits$iv$iv$iv), f, ($this$invokeSuspend_u24lambda_u242.toPx-0680j_4(f2) - $this$invokeSuspend_u24lambda_u242.toPx-0680j_4(f3)) - $this$invokeSuspend_u24lambda_u242.toPx-0680j_4(ProvideUiScaleKt.dpScaled(80, f4)))), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}