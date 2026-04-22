package home.sidecenter.recent;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecentPageStateHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.recent.RecentPageStateHolder$handleAction$2", f = "RecentPageStateHolder.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RecentPageStateHolder$handleAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecentActionResult $result;
    int label;
    final /* synthetic */ RecentPageStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentPageStateHolder$handleAction$2(RecentActionResult recentActionResult, RecentPageStateHolder recentPageStateHolder, Continuation<? super RecentPageStateHolder$handleAction$2> continuation) {
        super(2, continuation);
        this.$result = recentActionResult;
        this.this$0 = recentPageStateHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RecentPageStateHolder$handleAction$2(this.$result, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<IRecentAction> sideEffect = this.$result.getSideEffect();
                final RecentPageStateHolder recentPageStateHolder = this.this$0;
                this.label = 1;
                if (sideEffect.collect(new FlowCollector() { // from class: home.sidecenter.recent.RecentPageStateHolder$handleAction$2.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((IRecentAction) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(IRecentAction it, Continuation<? super Unit> continuation) {
                        Object handleAction = RecentPageStateHolder.this.handleAction(it, continuation);
                        return handleAction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? handleAction : Unit.INSTANCE;
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
}