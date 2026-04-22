package kntr.common.compose.list;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Overscroll.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreScroll$1", f = "Overscroll.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreScroll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreScroll$1(OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1, Continuation<? super OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreScroll$1> continuation) {
        super(2, continuation);
        this.this$0 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreScroll$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Animatable<Float, AnimationVector1D> lastFlingAnimator = this.this$0.getLastFlingAnimator();
                if (lastFlingAnimator != null) {
                    this.label = 1;
                    if (lastFlingAnimator.stop((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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