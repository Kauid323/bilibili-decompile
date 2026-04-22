package kntr.watch.later.watchlater.viewmodel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.api.WatchLaterApiKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$2", f = "WatchLaterViewModel.kt", i = {0, 1}, l = {839, 839}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
public final class WatchLaterViewModel$cleanVideo$2 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $cleanType;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$cleanVideo$2(int i, Continuation<? super WatchLaterViewModel$cleanVideo$2> continuation) {
        super(2, continuation);
        this.$cleanType = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> watchLaterViewModel$cleanVideo$2 = new WatchLaterViewModel$cleanVideo$2(this.$cleanType, continuation);
        watchLaterViewModel$cleanVideo$2.L$0 = obj;
        return watchLaterViewModel$cleanVideo$2;
    }

    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object obj;
        FlowCollector flowCollector;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = $this$flow;
                this.label = 1;
                Object cleanWatchLater = WatchLaterApiKt.cleanWatchLater(this.$cleanType, (Continuation) this);
                if (cleanWatchLater == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = cleanWatchLater;
                flowCollector = $this$flow;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = null;
                this.label = 2;
                if (flowCollector.emit(obj, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                flowCollector = (FlowCollector) this.L$1;
                ResultKt.throwOnFailure($result);
                obj = $result;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = null;
                this.label = 2;
                if (flowCollector.emit(obj, (Continuation) this) == coroutine_suspended) {
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