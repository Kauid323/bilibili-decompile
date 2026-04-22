package kntr.app.deepsearch.stateMachine;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeout;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.handler.DeepSearchBroadcastHandlerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "<unused var>", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeout;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindTimeoutAction$2", f = "DeepSearchStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchStateMachine$bindTimeoutAction$2 extends SuspendLambda implements Function3<DeepSearchTimeout, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeepSearchStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchStateMachine$bindTimeoutAction$2(DeepSearchStateMachine deepSearchStateMachine, Continuation<? super DeepSearchStateMachine$bindTimeoutAction$2> continuation) {
        super(3, continuation);
        this.this$0 = deepSearchStateMachine;
    }

    public final Object invoke(DeepSearchTimeout deepSearchTimeout, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchStateMachine$bindTimeoutAction$2 deepSearchStateMachine$bindTimeoutAction$2 = new DeepSearchStateMachine$bindTimeoutAction$2(this.this$0, continuation);
        deepSearchStateMachine$bindTimeoutAction$2.L$0 = state;
        return deepSearchStateMachine$bindTimeoutAction$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DeepSearchTimeoutService deepSearchTimeoutService;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                deepSearchTimeoutService = this.this$0.timeoutService;
                deepSearchTimeoutService.greetCancelTimeout();
                final DeepSearchStateMachine deepSearchStateMachine = this.this$0;
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindTimeoutAction$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchStateMachine$bindTimeoutAction$2.invokeSuspend$lambda$0(DeepSearchStateMachine.this, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(DeepSearchStateMachine this$0, DeepSearchPageData $this$mutate) {
        DeepSearchDataProcessService deepSearchDataProcessService;
        final List tempList = DeepSearchBroadcastHandlerKt.handleGreetBroadcastFail($this$mutate);
        if (!tempList.isEmpty()) {
            deepSearchDataProcessService = this$0.dataProcessService;
            deepSearchDataProcessService.cacheEndQuery("Greet" + $this$mutate.getSessionId());
            return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindTimeoutAction$2$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit invokeSuspend$lambda$0$0;
                    invokeSuspend$lambda$0$0 = DeepSearchStateMachine$bindTimeoutAction$2.invokeSuspend$lambda$0$0(tempList, (CopyScope) obj);
                    return invokeSuspend$lambda$0$0;
                }
            });
        }
        return $this$mutate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(List $tempList, CopyScope $this$copy) {
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $tempList);
        return Unit.INSTANCE;
    }
}