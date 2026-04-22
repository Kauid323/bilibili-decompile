package kntr.app.deepsearch.handler;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.RequestModelLensKt;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.base.model.biz.RequestStateLensKt;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.deepsearch.base.model.input.InputStateLensKt;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "action", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$RetryChat;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$3", f = "DeepSearchChatHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchChatHandlerKt$bindChatAction$2$3 extends SuspendLambda implements Function3<DeepSearchAction.RetryChat, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchDataProcessService $dataProcessService;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchChatHandlerKt$bindChatAction$2$3(DeepSearchDataProcessService deepSearchDataProcessService, Continuation<? super DeepSearchChatHandlerKt$bindChatAction$2$3> continuation) {
        super(3, continuation);
        this.$dataProcessService = deepSearchDataProcessService;
    }

    public final Object invoke(DeepSearchAction.RetryChat retryChat, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchChatHandlerKt$bindChatAction$2$3 deepSearchChatHandlerKt$bindChatAction$2$3 = new DeepSearchChatHandlerKt$bindChatAction$2$3(this.$dataProcessService, continuation);
        deepSearchChatHandlerKt$bindChatAction$2$3.L$0 = retryChat;
        deepSearchChatHandlerKt$bindChatAction$2$3.L$1 = state;
        return deepSearchChatHandlerKt$bindChatAction$2$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final DeepSearchAction.RetryChat action = (DeepSearchAction.RetryChat) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final DeepSearchDataProcessService deepSearchDataProcessService = this.$dataProcessService;
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchChatHandlerKt$bindChatAction$2$3.invokeSuspend$lambda$0(DeepSearchAction.RetryChat.this, deepSearchDataProcessService, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final DeepSearchAction.RetryChat $action, DeepSearchDataProcessService $dataProcessService, DeepSearchPageData $this$mutate) {
        final RequestParam.ChatReqParam chatParam = new RequestParam.ChatReqParam($action.getRetryChatModel().getQuery(), $action.getRetryChatModel().getQueryId());
        final List dataItemList = DeepSearchChatHandlerKt.handleChatModel$default(false, $this$mutate, $action.getRetryChatModel().getQuery(), $action.getRetryChatModel().getQueryId(), $action.getRetryChatModel().getQueryId(), DeepSearchChatHandlerKt.thinkingText$default($this$mutate, false, 1, null), 1, null);
        $dataProcessService.cacheCurrentReqQueryId($action.getRetryChatModel().getQueryId());
        final String navigationThinking = $this$mutate.getTextConfigModel().getNavigationThinking();
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$3$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchChatHandlerKt$bindChatAction$2$3.invokeSuspend$lambda$0$0(navigationThinking, $action, dataItemList, chatParam, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(String $navigationThinking, DeepSearchAction.RetryChat $action, List $dataItemList, RequestParam.ChatReqParam $chatParam, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getPageChatState(DeepSearchPageData.Companion), new DeepSearchPageChatState.Thinking($navigationThinking, $action.getRetryChatModel().getQueryId()));
        $this$copy.set(InputStateLensKt.isSending(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), true);
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $dataItemList);
        $this$copy.set(RequestStateLensKt.getParam(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), $chatParam);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Loading.INSTANCE);
        return Unit.INSTANCE;
    }
}