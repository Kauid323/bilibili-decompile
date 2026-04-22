package kntr.app.deepsearch.handler;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
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
/* compiled from: DeepSearchChatHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "action", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction$InputChange;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$1", f = "DeepSearchChatHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchChatHandlerKt$bindChatAction$2$1 extends SuspendLambda implements Function3<DeepSearchAction.InputAction.InputChange, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchChatHandlerKt$bindChatAction$2$1(Continuation<? super DeepSearchChatHandlerKt$bindChatAction$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DeepSearchAction.InputAction.InputChange inputChange, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchChatHandlerKt$bindChatAction$2$1 deepSearchChatHandlerKt$bindChatAction$2$1 = new DeepSearchChatHandlerKt$bindChatAction$2$1(continuation);
        deepSearchChatHandlerKt$bindChatAction$2$1.L$0 = inputChange;
        deepSearchChatHandlerKt$bindChatAction$2$1.L$1 = state;
        return deepSearchChatHandlerKt$bindChatAction$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final DeepSearchAction.InputAction.InputChange action = (DeepSearchAction.InputAction.InputChange) this.L$0;
        final State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchChatHandlerKt$bindChatAction$2$1.invokeSuspend$lambda$0(state, action, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final State $state, final DeepSearchAction.InputAction.InputChange $action, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchChatHandlerKt$bindChatAction$2$1.invokeSuspend$lambda$0$0($state, $action, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(State $state, final DeepSearchAction.InputAction.InputChange $action, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion), ((DeepSearchPageData) $state.getSnapshot()).getInputState().updateInput($action.getValue(), new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                long version;
                DeepSearchAction.InputAction.InputChange inputChange = DeepSearchAction.InputAction.InputChange.this;
                ((Long) obj).longValue();
                version = inputChange.getVersion();
                return Long.valueOf(version);
            }
        }));
        return Unit.INSTANCE;
    }
}