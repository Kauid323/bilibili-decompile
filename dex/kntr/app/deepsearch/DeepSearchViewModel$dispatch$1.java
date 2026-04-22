package kntr.app.deepsearch;

import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.stateMachine.DeepSearchStateMachine;
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
/* compiled from: DeepSearchViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.DeepSearchViewModel$dispatch$1", f = "DeepSearchViewModel.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchViewModel$dispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeepSearchAction $action;
    int label;
    final /* synthetic */ DeepSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchViewModel$dispatch$1(DeepSearchViewModel deepSearchViewModel, DeepSearchAction deepSearchAction, Continuation<? super DeepSearchViewModel$dispatch$1> continuation) {
        super(2, continuation);
        this.this$0 = deepSearchViewModel;
        this.$action = deepSearchAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepSearchViewModel$dispatch$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DeepSearchStateMachine deepSearchStateMachine;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                deepSearchStateMachine = this.this$0.stateMachine;
                this.label = 1;
                if (deepSearchStateMachine.dispatch(this.$action, (Continuation) this) == coroutine_suspended) {
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