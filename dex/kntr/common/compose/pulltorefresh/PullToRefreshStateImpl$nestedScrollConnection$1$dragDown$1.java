package kntr.common.compose.pulltorefresh;

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

/* compiled from: PullToRefreshState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1$dragDown$1", f = "PullToRefreshState.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PullToRefreshStateImpl$nestedScrollConnection$1$dragDown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ float $dragMultiplier;
    int label;
    final /* synthetic */ PullToRefreshStateImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshStateImpl$nestedScrollConnection$1$dragDown$1(PullToRefreshStateImpl pullToRefreshStateImpl, long j, float f, Continuation<? super PullToRefreshStateImpl$nestedScrollConnection$1$dragDown$1> continuation) {
        super(2, continuation);
        this.this$0 = pullToRefreshStateImpl;
        this.$available = j;
        this.$dragMultiplier = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullToRefreshStateImpl$nestedScrollConnection$1$dragDown$1(this.this$0, this.$available, this.$dragMultiplier, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object dispatchScrollDelta;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PullToRefreshStateImpl pullToRefreshStateImpl = this.this$0;
                int bits$iv$iv$iv = (int) (4294967295L & this.$available);
                this.label = 1;
                dispatchScrollDelta = pullToRefreshStateImpl.dispatchScrollDelta(Float.intBitsToFloat(bits$iv$iv$iv) * this.$dragMultiplier, (Continuation) this);
                if (dispatchScrollDelta == coroutine_suspended) {
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