package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatReply;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatReq;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.biz.RequestModelLensKt;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.base.model.biz.RequestStateLensKt;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.deepsearch.base.model.input.InputStateLensKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchChatHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1", f = "DeepSearchChatHandler.kt", i = {0, 0, 0, 0}, l = {298}, m = "invokeSuspend", n = {"state", "chatParam", "chatType", "reqQueryId"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class DeepSearchChatHandlerKt$bindChatAction$4$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchDataProcessService $dataProcessService;
    final /* synthetic */ DeepSearchTimeoutService $timeoutService;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchChatHandlerKt$bindChatAction$4$1(DeepSearchDataProcessService deepSearchDataProcessService, DeepSearchTimeoutService deepSearchTimeoutService, Continuation<? super DeepSearchChatHandlerKt$bindChatAction$4$1> continuation) {
        super(2, continuation);
        this.$dataProcessService = deepSearchDataProcessService;
        this.$timeoutService = deepSearchTimeoutService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchChatHandlerKt$bindChatAction$4$1 = new DeepSearchChatHandlerKt$bindChatAction$4$1(this.$dataProcessService, this.$timeoutService, continuation);
        deepSearchChatHandlerKt$bindChatAction$4$1.L$0 = obj;
        return deepSearchChatHandlerKt$bindChatAction$4$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0119: INVOKE  (r4 I:java.lang.String) = 
      (r7 I:kntr.app.deepsearch.base.model.biz.RequestParam$ChatReqParam A[D('chatParam' kntr.app.deepsearch.base.model.biz.RequestParam$ChatReqParam)])
     type: VIRTUAL call: kntr.app.deepsearch.base.model.biz.RequestParam.ChatReqParam.getQueryId():java.lang.String, block:B:39:0x0117 */
    /* JADX WARN: Type inference failed for: r7v0, types: [kntr.app.deepsearch.base.model.biz.RequestParam$ChatReqParam] */
    public final Object invokeSuspend(Object $result) {
        final ?? queryId;
        final RequestParam.ChatReqParam chatParam;
        boolean isLocalQuery;
        Object loadChat;
        final State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    RequestParam param = ((DeepSearchPageData) state.getSnapshot()).getRequestModel().getChatReqState().getParam();
                    chatParam = param instanceof RequestParam.ChatReqParam ? (RequestParam.ChatReqParam) param : null;
                    if (chatParam != null) {
                        isLocalQuery = DeepSearchChatHandlerKt.isLocalQuery(chatParam.getQueryId());
                        KChatReq.KChatType chatType = isLocalQuery ? (KChatReq.KChatType) KChatReq.KChatType.NEW_CHAT.INSTANCE : KChatReq.KChatType.RETRY_CHAT.INSTANCE;
                        String reqQueryId = Intrinsics.areEqual(chatType, KChatReq.KChatType.NEW_CHAT.INSTANCE) ? RoomRecommendViewModel.EMPTY_CURSOR : chatParam.getQueryId();
                        this.L$0 = state;
                        this.L$1 = chatParam;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(chatType);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(reqQueryId);
                        this.label = 1;
                        loadChat = DeepSearchChatHandlerKt.loadChat(chatType, ((DeepSearchPageData) state.getSnapshot()).getSessionId(), chatParam.getQuery(), reqQueryId, (Continuation) this);
                        if (loadChat != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    } else {
                        return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj) {
                                DeepSearchPageData invokeSuspend$lambda$3;
                                invokeSuspend$lambda$3 = DeepSearchChatHandlerKt$bindChatAction$4$1.invokeSuspend$lambda$3((DeepSearchPageData) obj);
                                return invokeSuspend$lambda$3;
                            }
                        });
                    }
                case 1:
                    String str = (String) this.L$3;
                    KChatReq.KChatType kChatType = (KChatReq.KChatType) this.L$2;
                    chatParam = (RequestParam.ChatReqParam) this.L$1;
                    ResultKt.throwOnFailure($result);
                    loadChat = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final KChatReply response = (KChatReply) loadChat;
            if (this.$dataProcessService.isCurrentReqQueryId(chatParam.getQueryId())) {
                if (response.getCode() != 0 || StringsKt.isBlank(response.getQueryId())) {
                    this.$dataProcessService.cacheCurrentReqQueryId(RoomRecommendViewModel.EMPTY_CURSOR);
                    return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = DeepSearchChatHandlerKt$bindChatAction$4$1.invokeSuspend$lambda$1(RequestParam.ChatReqParam.this, (DeepSearchPageData) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
                this.$timeoutService.launchTimeout();
                this.$dataProcessService.cacheCurrentReqQueryId(RoomRecommendViewModel.EMPTY_CURSOR);
                final List dataItemList = DeepSearchChatHandlerKt.handleChatModel$default(false, (DeepSearchPageData) state.getSnapshot(), chatParam.getQuery(), chatParam.getQueryId(), response.getQueryId(), DeepSearchChatHandlerKt.thinkingText$default((DeepSearchPageData) state.getSnapshot(), false, 1, null), 1, null);
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchChatHandlerKt$bindChatAction$4$1.invokeSuspend$lambda$0(state, response, dataItemList, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            }
            return state.noChange();
        } catch (Exception e) {
            if (this.$dataProcessService.isCurrentReqQueryId(queryId.getQueryId())) {
                this.$dataProcessService.cacheCurrentReqQueryId(RoomRecommendViewModel.EMPTY_CURSOR);
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = DeepSearchChatHandlerKt$bindChatAction$4$1.invokeSuspend$lambda$2(RequestParam.ChatReqParam.this, e, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            }
            return state.noChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final State $state, final KChatReply $response, final List $dataItemList, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchChatHandlerKt$bindChatAction$4$1.invokeSuspend$lambda$0$0($state, $response, $dataItemList, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(State $state, KChatReply $response, List $dataItemList, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getPageChatState(DeepSearchPageData.Companion), new DeepSearchPageChatState.Thinking(((DeepSearchPageData) $state.getSnapshot()).getTextConfigModel().getNavigationThinking(), $response.getQueryId()));
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $dataItemList);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Success.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$1(RequestParam.ChatReqParam $chatParam, DeepSearchPageData $this$mutate) {
        final List dataItemList;
        dataItemList = DeepSearchChatHandlerKt.chatReqError($this$mutate, $chatParam.getQuery(), $chatParam.getQueryId());
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = DeepSearchChatHandlerKt$bindChatAction$4$1.invokeSuspend$lambda$1$0(dataItemList, (CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(List $dataItemList, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getPageChatState(DeepSearchPageData.Companion), new DeepSearchPageChatState.None(null, null, 3, null));
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $dataItemList);
        $this$copy.set(InputStateLensKt.isSending(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), false);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error(new Throwable("网络不佳，请重试")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$2(RequestParam.ChatReqParam $chatParam, final Exception $e, DeepSearchPageData $this$mutate) {
        final List dataItemList;
        dataItemList = DeepSearchChatHandlerKt.chatReqError($this$mutate, $chatParam.getQuery(), $chatParam.getQueryId());
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$2$0;
                invokeSuspend$lambda$2$0 = DeepSearchChatHandlerKt$bindChatAction$4$1.invokeSuspend$lambda$2$0(dataItemList, $e, (CopyScope) obj);
                return invokeSuspend$lambda$2$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2$0(List $dataItemList, Exception $e, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getPageChatState(DeepSearchPageData.Companion), new DeepSearchPageChatState.None(null, null, 3, null));
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $dataItemList);
        $this$copy.set(InputStateLensKt.isSending(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), false);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error($e));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$3(DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$4$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$3$0;
                invokeSuspend$lambda$3$0 = DeepSearchChatHandlerKt$bindChatAction$4$1.invokeSuspend$lambda$3$0((CopyScope) obj);
                return invokeSuspend$lambda$3$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3$0(CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Idle.INSTANCE);
        return Unit.INSTANCE;
    }
}