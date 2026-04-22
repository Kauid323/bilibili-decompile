package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
/* compiled from: MiniVideoFloatingComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$2$1", f = "MiniVideoFloatingComponent.kt", i = {0, 1, 1}, l = {173, 181}, m = "invokeSuspend", n = {"targetX", "targetX", "targetY"}, s = {"F$0", "F$0", "F$1"}, v = 1)
public final class MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animX;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animY;
    final /* synthetic */ Density $density;
    final /* synthetic */ Offset $dragAmount;
    final /* synthetic */ State<Dp> $floatingViewHeight$delegate;
    final /* synthetic */ State<Dp> $floatingViewWidth$delegate;
    final /* synthetic */ float $scale;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWidth;
    final /* synthetic */ float $topPadding;
    float F$0;
    float F$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$2$1(Animatable<Float, AnimationVector1D> animatable, Offset offset, Density density, Animatable<Float, AnimationVector1D> animatable2, float f, State<Dp> state, float f2, float f3, float f4, State<Dp> state2, Continuation<? super MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$2$1> continuation) {
        super(2, continuation);
        this.$animX = animatable;
        this.$dragAmount = offset;
        this.$density = density;
        this.$animY = animatable2;
        this.$screenWidth = f;
        this.$floatingViewWidth$delegate = state;
        this.$topPadding = f2;
        this.$screenHeight = f3;
        this.$scale = f4;
        this.$floatingViewHeight$delegate = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1$2$1(this.$animX, this.$dragAmount, this.$density, this.$animY, this.$screenWidth, this.$floatingViewWidth$delegate, this.$topPadding, this.$screenHeight, this.$scale, this.$floatingViewHeight$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        float MiniVideoFloatingComponent_hqqSWsU$lambda$8;
        float targetX;
        float MiniVideoFloatingComponent_hqqSWsU$lambda$10;
        float targetY;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                float floatValue = ((Number) this.$animX.getValue()).floatValue();
                int bits$iv$iv$iv = (int) (this.$dragAmount.unbox-impl() >> 32);
                Density $this$invokeSuspend_u24lambda_u240 = this.$density;
                float f = this.$screenWidth;
                State<Dp> state = this.$floatingViewWidth$delegate;
                float f2 = $this$invokeSuspend_u24lambda_u240.toPx-0680j_4(f);
                MiniVideoFloatingComponent_hqqSWsU$lambda$8 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$8(state);
                targetX = RangesKt.coerceIn(floatValue + Float.intBitsToFloat(bits$iv$iv$iv), 0.0f, f2 - $this$invokeSuspend_u24lambda_u240.toPx-0680j_4(MiniVideoFloatingComponent_hqqSWsU$lambda$8));
                this.F$0 = targetX;
                this.label = 1;
                if (this.$animX.snapTo(Boxing.boxFloat(targetX), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                float floatValue2 = ((Number) this.$animY.getValue()).floatValue();
                int bits$iv$iv$iv2 = (int) (4294967295L & this.$dragAmount.unbox-impl());
                Density $this$invokeSuspend_u24lambda_u241 = this.$density;
                float f3 = $this$invokeSuspend_u24lambda_u241.toPx-0680j_4(this.$topPadding);
                Density $this$invokeSuspend_u24lambda_u242 = this.$density;
                float f4 = this.$screenHeight;
                float f5 = this.$scale;
                MiniVideoFloatingComponent_hqqSWsU$lambda$10 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$10(this.$floatingViewHeight$delegate);
                targetY = RangesKt.coerceIn(floatValue2 + Float.intBitsToFloat(bits$iv$iv$iv2), f3, $this$invokeSuspend_u24lambda_u242.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(f4 - MiniVideoFloatingComponent_hqqSWsU$lambda$10) - ProvideUiScaleKt.dpScaled(25, f5))));
                this.F$0 = targetX;
                this.F$1 = targetY;
                this.label = 2;
                if (this.$animY.snapTo(Boxing.boxFloat(targetY), (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                targetX = this.F$0;
                ResultKt.throwOnFailure($result);
                float floatValue22 = ((Number) this.$animY.getValue()).floatValue();
                int bits$iv$iv$iv22 = (int) (4294967295L & this.$dragAmount.unbox-impl());
                Density $this$invokeSuspend_u24lambda_u2412 = this.$density;
                float f32 = $this$invokeSuspend_u24lambda_u2412.toPx-0680j_4(this.$topPadding);
                Density $this$invokeSuspend_u24lambda_u2422 = this.$density;
                float f42 = this.$screenHeight;
                float f52 = this.$scale;
                MiniVideoFloatingComponent_hqqSWsU$lambda$10 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$10(this.$floatingViewHeight$delegate);
                targetY = RangesKt.coerceIn(floatValue22 + Float.intBitsToFloat(bits$iv$iv$iv22), f32, $this$invokeSuspend_u24lambda_u2422.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(f42 - MiniVideoFloatingComponent_hqqSWsU$lambda$10) - ProvideUiScaleKt.dpScaled(25, f52))));
                this.F$0 = targetX;
                this.F$1 = targetY;
                this.label = 2;
                if (this.$animY.snapTo(Boxing.boxFloat(targetY), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                float f6 = this.F$1;
                float f7 = this.F$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}