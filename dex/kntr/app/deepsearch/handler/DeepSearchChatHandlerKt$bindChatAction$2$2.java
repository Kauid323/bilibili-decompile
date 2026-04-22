package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
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
import kntr.app.deepsearch.base.model.input.InputState;
import kntr.app.deepsearch.base.model.input.InputStateLensKt;
import kntr.app.deepsearch.base.model.input.SenderStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "<unused var>", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction$SenderClick;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$2", f = "DeepSearchChatHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchChatHandlerKt$bindChatAction$2$2 extends SuspendLambda implements Function3<DeepSearchAction.InputAction.SenderClick, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchDataProcessService $dataProcessService;
    /* synthetic */ Object L$0;
    int label;

    /* compiled from: DeepSearchChatHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SenderStatus.values().length];
            try {
                iArr[SenderStatus.SEND_ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SenderStatus.STOP_ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchChatHandlerKt$bindChatAction$2$2(DeepSearchDataProcessService deepSearchDataProcessService, Continuation<? super DeepSearchChatHandlerKt$bindChatAction$2$2> continuation) {
        super(3, continuation);
        this.$dataProcessService = deepSearchDataProcessService;
    }

    public final Object invoke(DeepSearchAction.InputAction.SenderClick senderClick, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchChatHandlerKt$bindChatAction$2$2 deepSearchChatHandlerKt$bindChatAction$2$2 = new DeepSearchChatHandlerKt$bindChatAction$2$2(this.$dataProcessService, continuation);
        deepSearchChatHandlerKt$bindChatAction$2$2.L$0 = state;
        return deepSearchChatHandlerKt$bindChatAction$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final String thinkingText = DeepSearchChatHandlerKt.thinkingText$default((DeepSearchPageData) state.getSnapshot(), false, 1, null);
                final DeepSearchDataProcessService deepSearchDataProcessService = this.$dataProcessService;
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchChatHandlerKt$bindChatAction$2$2.invokeSuspend$lambda$0(DeepSearchDataProcessService.this, thinkingText, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(DeepSearchDataProcessService $dataProcessService, String $thinkingText, DeepSearchPageData $this$mutate) {
        final String queryId;
        KChatHistoryItem item;
        String str;
        String str2;
        final List dataItemList;
        boolean isLocalQuery;
        final RequestStatus.Loading stopReqStatus;
        KDeepSearchResponse content;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$mutate.getInputState().getSenderStatus().ordinal()]) {
            case 1:
                if (!($this$mutate.getSessionId().length() == 0)) {
                    queryId = DeepSearchChatHandlerKt.generateTimeBasedId($this$mutate.getSessionId(), $dataProcessService);
                    final String navigationThinking = $this$mutate.getTextConfigModel().getNavigationThinking();
                    final InputState updateInput = $this$mutate.getInputState().updateInput(RoomRecommendViewModel.EMPTY_CURSOR, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$2$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            long invokeSuspend$lambda$0$1;
                            invokeSuspend$lambda$0$1 = DeepSearchChatHandlerKt$bindChatAction$2$2.invokeSuspend$lambda$0$1(((Long) obj).longValue());
                            return Long.valueOf(invokeSuspend$lambda$0$1);
                        }
                    });
                    final RequestParam.ChatReqParam chatParam = new RequestParam.ChatReqParam($this$mutate.getInputState().getInput(), queryId);
                    final List dataItemList2 = DeepSearchChatHandlerKt.handleChatModel$default(false, $this$mutate, $this$mutate.getInputState().getInput(), RoomRecommendViewModel.EMPTY_CURSOR, queryId, $thinkingText, 1, null);
                    $dataProcessService.cacheCurrentReqQueryId(queryId);
                    return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$2$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit invokeSuspend$lambda$0$2;
                            invokeSuspend$lambda$0$2 = DeepSearchChatHandlerKt$bindChatAction$2$2.invokeSuspend$lambda$0$2(navigationThinking, queryId, updateInput, dataItemList2, chatParam, (CopyScope) obj);
                            return invokeSuspend$lambda$0$2;
                        }
                    });
                }
                final RequestParam.SessionReqParam sessionParam = new RequestParam.SessionReqParam(true);
                return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$2$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0$0;
                        invokeSuspend$lambda$0$0 = DeepSearchChatHandlerKt$bindChatAction$2$2.invokeSuspend$lambda$0$0(RequestParam.SessionReqParam.this, (CopyScope) obj);
                        return invokeSuspend$lambda$0$0;
                    }
                });
            case 2:
                item = DeepSearchChatHandlerKt.findDoingItem($this$mutate);
                if (item == null || (str = item.getQuery()) == null) {
                    str = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                if (item == null || (content = item.getContent()) == null || (str2 = content.getQueryId()) == null) {
                    str2 = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                final RequestParam.ChatReqParam stopChatParam = new RequestParam.ChatReqParam(str, str2);
                dataItemList = DeepSearchChatHandlerKt.handleStopAnswer($this$mutate, item);
                $dataProcessService.cacheAbnormalQuery(stopChatParam.getQueryId());
                $dataProcessService.cacheCurrentReqQueryId(RoomRecommendViewModel.EMPTY_CURSOR);
                isLocalQuery = DeepSearchChatHandlerKt.isLocalQuery(stopChatParam.getQueryId());
                if (isLocalQuery) {
                    stopReqStatus = RequestStatus.Idle.INSTANCE;
                } else {
                    stopReqStatus = RequestStatus.Loading.INSTANCE;
                }
                return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$2$2$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0$3;
                        invokeSuspend$lambda$0$3 = DeepSearchChatHandlerKt$bindChatAction$2$2.invokeSuspend$lambda$0$3(dataItemList, stopChatParam, stopReqStatus, (CopyScope) obj);
                        return invokeSuspend$lambda$0$3;
                    }
                });
            default:
                return $this$mutate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(RequestParam.SessionReqParam $sessionParam, CopyScope $this$copy) {
        $this$copy.set(InputStateLensKt.isRefreshSessionId(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), true);
        $this$copy.set(RequestStateLensKt.getParam(RequestModelLensKt.getSessionReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), $sessionParam);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getSessionReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Loading.INSTANCE);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getTextConfigReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Loading.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invokeSuspend$lambda$0$1(long it) {
        return 1 + it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$2(String $navigationThinking, String $queryId, InputState $updateInput, List $dataItemList, RequestParam.ChatReqParam $chatParam, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getPageChatState(DeepSearchPageData.Companion), new DeepSearchPageChatState.Thinking($navigationThinking, $queryId));
        $this$copy.set(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion), $updateInput);
        $this$copy.set(InputStateLensKt.isSending(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), true);
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $dataItemList);
        $this$copy.set(RequestStateLensKt.getParam(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), $chatParam);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Loading.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$3(List $dataItemList, RequestParam.ChatReqParam $stopChatParam, RequestStatus $stopReqStatus, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getPageChatState(DeepSearchPageData.Companion), new DeepSearchPageChatState.None(null, null, 3, null));
        $this$copy.set(InputStateLensKt.isSending(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), false);
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $dataItemList);
        $this$copy.set(RequestStateLensKt.getParam(RequestModelLensKt.getStopChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), $stopChatParam);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getStopChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), $stopReqStatus);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Idle.INSTANCE);
        return Unit.INSTANCE;
    }
}