package kntr.watch.later.watchlater.compose;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterWidget.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$OnBottomReached$2$1", f = "WatchLaterWidget.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterWidgetKt$OnBottomReached$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $loadMore;
    final /* synthetic */ State<Boolean> $shouldLoadMore;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterWidgetKt$OnBottomReached$2$1(State<Boolean> state, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super WatchLaterWidgetKt$OnBottomReached$2$1> continuation) {
        super(2, continuation);
        this.$shouldLoadMore = state;
        this.$loadMore = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterWidgetKt$OnBottomReached$2$1(this.$shouldLoadMore, this.$loadMore, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final State<Boolean> state = this.$shouldLoadMore;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$OnBottomReached$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = WatchLaterWidgetKt$OnBottomReached$2$1.invokeSuspend$lambda$0(state);
                        return Boolean.valueOf(invokeSuspend$lambda$0);
                    }
                });
                final Function1<Continuation<? super Unit>, Object> function1 = this.$loadMore;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$OnBottomReached$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Boolean) value).booleanValue(), $completion);
                    }

                    public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                        Object invoke;
                        return (it && (invoke = function1.invoke(continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? invoke : Unit.INSTANCE;
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
    public static final boolean invokeSuspend$lambda$0(State $shouldLoadMore) {
        return ((Boolean) $shouldLoadMore.getValue()).booleanValue();
    }
}