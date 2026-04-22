package kntr.app.deepsearch.history;

import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DSHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.history.DSHistoryViewModel$dispatch$1", f = "DSHistoryViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DSHistoryViewModel$dispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DSHistoryAction $action;
    int label;
    final /* synthetic */ DSHistoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSHistoryViewModel$dispatch$1(DSHistoryViewModel dSHistoryViewModel, DSHistoryAction dSHistoryAction, Continuation<? super DSHistoryViewModel$dispatch$1> continuation) {
        super(2, continuation);
        this.this$0 = dSHistoryViewModel;
        this.$action = dSHistoryAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DSHistoryViewModel$dispatch$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DSHistoryStateMachine dSHistoryStateMachine;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                dSHistoryStateMachine = this.this$0.stateMachine;
                this.label = 1;
                if (dSHistoryStateMachine.dispatch(this.$action, (Continuation) this) == coroutine_suspended) {
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