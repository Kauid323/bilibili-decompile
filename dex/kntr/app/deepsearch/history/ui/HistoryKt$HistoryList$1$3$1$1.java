package kntr.app.deepsearch.history.ui;

import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: History.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.history.ui.HistoryKt$HistoryList$1$3$1$1", f = "History.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HistoryKt$HistoryList$1$3$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DSHistoryAction, Unit> $dispatcher;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HistoryKt$HistoryList$1$3$1$1(Function1<? super DSHistoryAction, Unit> function1, Continuation<? super HistoryKt$HistoryList$1$3$1$1> continuation) {
        super(1, continuation);
        this.$dispatcher = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HistoryKt$HistoryList$1$3$1$1(this.$dispatcher, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$dispatcher.invoke(DSHistoryAction.LoadAction.LoadMore.INSTANCE);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}