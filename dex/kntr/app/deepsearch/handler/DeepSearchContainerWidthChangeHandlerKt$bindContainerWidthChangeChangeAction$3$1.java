package kntr.app.deepsearch.handler;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchContainerWidthChangeHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1", f = "DeepSearchContainerWidthChangeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchDataProcessService $dataProcessService;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1(DeepSearchDataProcessService deepSearchDataProcessService, Continuation<? super DeepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1> continuation) {
        super(2, continuation);
        this.$dataProcessService = deepSearchDataProcessService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1 = new DeepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1(this.$dataProcessService, continuation);
        deepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1.L$0 = obj;
        return deepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$dataProcessService.cleanLayoutCache();
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}