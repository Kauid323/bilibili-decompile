package kntr.common.compose.list;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: Merge.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1", f = "LoadMoreListState.kt", i = {0, 0}, l = {189}, m = "invokeSuspend", n = {"$this$transformLatest", "it"}, s = {"L$0", "L$1"}, v = 1)
public final class LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super Unit>, ReachedEdgeState, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableSharedFlow $scrollToTopState$inlined;
    final /* synthetic */ Function1 $shouldLoadMoreInState$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1(Continuation continuation, Function1 function1, MutableSharedFlow mutableSharedFlow) {
        super(3, continuation);
        this.$shouldLoadMoreInState$inlined = function1;
        this.$scrollToTopState$inlined = mutableSharedFlow;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FlowCollector) obj, (ReachedEdgeState) obj2, (Continuation) obj3);
    }

    public final Object invoke(FlowCollector<? super Unit> flowCollector, ReachedEdgeState reachedEdgeState, Continuation<? super Unit> continuation) {
        LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1 loadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1 = new LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1(continuation, this.$shouldLoadMoreInState$inlined, this.$scrollToTopState$inlined);
        loadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1.L$0 = flowCollector;
        loadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1.L$1 = reachedEdgeState;
        return loadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Flow flowOf;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FlowCollector $this$transformLatest = (FlowCollector) this.L$0;
                Object it = this.L$1;
                Continuation continuation = (Continuation) this;
                ReachedEdgeState state = (ReachedEdgeState) it;
                if (((Boolean) this.$shouldLoadMoreInState$inlined.invoke(state)).booleanValue()) {
                    flowOf = LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1.WhenMappings.$EnumSwitchMapping$0[state.ordinal()] == 1 ? (Flow) this.$scrollToTopState$inlined : FlowKt.flowOf(Unit.INSTANCE);
                } else {
                    flowOf = FlowKt.flowOf(new Unit[0]);
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$transformLatest);
                this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                this.label = 1;
                if (FlowKt.emitAll($this$transformLatest, flowOf, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                Object obj = this.L$1;
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}