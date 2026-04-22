package kntr.app.deepsearch.handler;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchAppStateHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "<unused var>", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction$EnterForeground;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchAppStateHandlerKt$bindAppStateAction$2", f = "DeepSearchAppStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchAppStateHandlerKt$bindAppStateAction$2 extends SuspendLambda implements Function3<DeepSearchAction.AppStateAction.EnterForeground, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchTimeoutService $timeoutService;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchAppStateHandlerKt$bindAppStateAction$2(DeepSearchTimeoutService deepSearchTimeoutService, Continuation<? super DeepSearchAppStateHandlerKt$bindAppStateAction$2> continuation) {
        super(3, continuation);
        this.$timeoutService = deepSearchTimeoutService;
    }

    public final Object invoke(DeepSearchAction.AppStateAction.EnterForeground enterForeground, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchAppStateHandlerKt$bindAppStateAction$2 deepSearchAppStateHandlerKt$bindAppStateAction$2 = new DeepSearchAppStateHandlerKt$bindAppStateAction$2(this.$timeoutService, continuation);
        deepSearchAppStateHandlerKt$bindAppStateAction$2.L$0 = state;
        return deepSearchAppStateHandlerKt$bindAppStateAction$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!(((DeepSearchPageData) state.getSnapshot()).getPageChatState() instanceof DeepSearchPageChatState.None)) {
                    this.$timeoutService.launchTimeout();
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}