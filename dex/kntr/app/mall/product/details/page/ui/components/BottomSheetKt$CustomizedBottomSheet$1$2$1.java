package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
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
/* compiled from: BottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.BottomSheetKt$CustomizedBottomSheet$1$2$1", f = "BottomSheet.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BottomSheetKt$CustomizedBottomSheet$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetYAnim;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ boolean $show;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetKt$CustomizedBottomSheet$1$2$1(Animatable<Float, AnimationVector1D> animatable, boolean z, float f, Continuation<? super BottomSheetKt$CustomizedBottomSheet$1$2$1> continuation) {
        super(2, continuation);
        this.$offsetYAnim = animatable;
        this.$show = z;
        this.$screenHeight = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BottomSheetKt$CustomizedBottomSheet$1$2$1(this.$offsetYAnim, this.$show, this.$screenHeight, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Animatable<Float, AnimationVector1D> animatable = this.$offsetYAnim;
                float f = this.$show ? 0.0f : this.$screenHeight;
                this.label = 1;
                if (Animatable.animateTo$default(animatable, Boxing.boxFloat(f), AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
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