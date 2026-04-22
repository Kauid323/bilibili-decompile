package kntr.common.compose.list;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoadMoreListState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1", f = "LoadMoreListState.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $loadMore;
    final /* synthetic */ MutableSharedFlow<Unit> $scrollToTopState;
    final /* synthetic */ State<ReachedEdgeState> $shouldLoadMore;
    final /* synthetic */ Function1<ReachedEdgeState, Boolean> $shouldLoadMoreInState;
    int label;

    /* compiled from: LoadMoreListState.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReachedEdgeState.values().length];
            try {
                iArr[ReachedEdgeState.REACHED_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1(State<? extends ReachedEdgeState> state, Function1<? super ReachedEdgeState, Boolean> function1, MutableSharedFlow<Unit> mutableSharedFlow, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Continuation<? super LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1> continuation) {
        super(2, continuation);
        this.$shouldLoadMore = state;
        this.$shouldLoadMoreInState = function1;
        this.$scrollToTopState = mutableSharedFlow;
        this.$loadMore = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1(this.$shouldLoadMore, this.$shouldLoadMoreInState, this.$scrollToTopState, this.$loadMore, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final State<ReachedEdgeState> state = this.$shouldLoadMore;
                Flow $this$flatMapLatest$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        ReachedEdgeState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1.invokeSuspend$lambda$0(state);
                        return invokeSuspend$lambda$0;
                    }
                });
                Flow $this$flatMapLatest$iv2 = FlowKt.transformLatest($this$flatMapLatest$iv, new LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1$invokeSuspend$$inlined$flatMapLatest$1(null, this.$shouldLoadMoreInState, this.$scrollToTopState));
                final Function1<Continuation<? super Unit>, Object> function1 = this.$loadMore;
                this.label = 1;
                if ($this$flatMapLatest$iv2.collect(new FlowCollector() { // from class: kntr.common.compose.list.LoadMoreListStateKt$applyLoadMoreBackwardEffects$3$1.3
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Unit) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Unit it, Continuation<? super Unit> continuation) {
                        Object invoke = function1.invoke(continuation);
                        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReachedEdgeState invokeSuspend$lambda$0(State $shouldLoadMore) {
        return (ReachedEdgeState) $shouldLoadMore.getValue();
    }
}