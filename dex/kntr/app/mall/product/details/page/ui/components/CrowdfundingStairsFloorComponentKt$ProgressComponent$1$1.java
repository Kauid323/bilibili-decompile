package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.MutableFloatState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CrowdfundingStairsFloorComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.CrowdfundingStairsFloorComponentKt$ProgressComponent$1$1", f = "CrowdfundingStairsFloorComponent.kt", i = {0, 0}, l = {287}, m = "invokeSuspend", n = {"pct", "duration"}, s = {"F$0", "I$0"}, v = 1)
public final class CrowdfundingStairsFloorComponentKt$ProgressComponent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $anim;
    final /* synthetic */ MutableFloatState $lastFraction;
    final /* synthetic */ int $progress;
    final /* synthetic */ float $targetFraction;
    float F$0;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrowdfundingStairsFloorComponentKt$ProgressComponent$1$1(Animatable<Float, AnimationVector1D> animatable, float f, int i, MutableFloatState mutableFloatState, Continuation<? super CrowdfundingStairsFloorComponentKt$ProgressComponent$1$1> continuation) {
        super(2, continuation);
        this.$anim = animatable;
        this.$targetFraction = f;
        this.$progress = i;
        this.$lastFraction = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CrowdfundingStairsFloorComponentKt$ProgressComponent$1$1(this.$anim, this.$targetFraction, this.$progress, this.$lastFraction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int duration;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!(((Number) this.$anim.getTargetValue()).floatValue() == this.$targetFraction)) {
                    float pct = this.$progress / 100.0f;
                    if (pct >= 100.0f) {
                        duration = 2000;
                    } else if (pct <= 10.0f) {
                        duration = RangesKt.coerceAtLeast((int) ((pct / 10.0f) * ((float) MediaAttrUtils.TYPE_PAY_SEASON)), 1);
                    } else {
                        duration = RangesKt.coerceAtLeast((int) ((pct / 50.0f) * ((float) MediaAttrUtils.TYPE_PAY_SEASON)), 1);
                    }
                    this.F$0 = pct;
                    this.I$0 = duration;
                    this.label = 1;
                    if (Animatable.animateTo$default(this.$anim, Boxing.boxFloat(this.$targetFraction), AnimationSpecKt.tween$default(duration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.$lastFraction.setValue(((Number) this.$anim.getValue()).floatValue());
                    break;
                }
                break;
            case 1:
                int i = this.I$0;
                float f = this.F$0;
                ResultKt.throwOnFailure($result);
                this.$lastFraction.setValue(((Number) this.$anim.getValue()).floatValue());
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}