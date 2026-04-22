package kntr.app.deepsearch.stateMachine;

import com.bapis.bilibili.broadcast.message.deepsearch.KChatStatus;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
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
import kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContent;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.input.InputStateLensKt;
import kntr.app.deepsearch.handler.DeepSearchBroadcastHandlerKt;
import kntr.app.deepsearch.handler.DeepSearchTrackerHandlerKt;
import kntr.app.deepsearch.service.DeepSearchTransformListServiceImpKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Result;
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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "result", "Lkotlin/Result;", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KDeepSearchResponse;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindBroadcastAction$1", f = "DeepSearchStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchStateMachine$bindBroadcastAction$1 extends SuspendLambda implements Function3<Result<? extends KDeepSearchResponse>, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ DeepSearchStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchStateMachine$bindBroadcastAction$1(DeepSearchStateMachine deepSearchStateMachine, Continuation<? super DeepSearchStateMachine$bindBroadcastAction$1> continuation) {
        super(3, continuation);
        this.this$0 = deepSearchStateMachine;
    }

    public final Object invoke(Object obj, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchStateMachine$bindBroadcastAction$1 deepSearchStateMachine$bindBroadcastAction$1 = new DeepSearchStateMachine$bindBroadcastAction$1(this.this$0, continuation);
        deepSearchStateMachine$bindBroadcastAction$1.L$0 = obj;
        deepSearchStateMachine$bindBroadcastAction$1.L$1 = state;
        return deepSearchStateMachine$bindBroadcastAction$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Result) obj).unbox-impl(), (State) obj2, (Continuation) obj3);
    }

    public final Object invokeSuspend(Object $result) {
        Object result = this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final DeepSearchStateMachine deepSearchStateMachine = this.this$0;
                Throwable error = Result.exceptionOrNull-impl(result);
                if (error == null) {
                    final KDeepSearchResponse notify = (KDeepSearchResponse) result;
                    DeepSearchTrackerHandlerKt.handleBroadcastTechnicalTrack(notify);
                    ILogger kLog = KLog_androidKt.getKLog();
                    String sessionId = notify.getSessionId();
                    String queryId = notify.getQueryId();
                    KChatStatus status = notify.getStatus();
                    kLog.i("deepsearch broadcast success", "会话：" + sessionId + "问题：" + queryId + "状态：" + status + "是否为问候：" + DeepSearchTransformListServiceImpKt.isContentGreet(notify));
                    return state.mutate(new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindBroadcastAction$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$0$0;
                            invokeSuspend$lambda$0$0 = DeepSearchStateMachine$bindBroadcastAction$1.invokeSuspend$lambda$0$0(notify, deepSearchStateMachine, (DeepSearchPageData) obj);
                            return invokeSuspend$lambda$0$0;
                        }
                    });
                }
                KLog_androidKt.getKLog().i("deepsearch broadcast fail", String.valueOf(error.getMessage()));
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0$0(KDeepSearchResponse $notify, DeepSearchStateMachine this$0, DeepSearchPageData $this$mutate) {
        DeepSearchDataProcessService deepSearchDataProcessService;
        DeepSearchDataProcessService deepSearchDataProcessService2;
        DeepSearchTimeoutService deepSearchTimeoutService;
        DeepSearchDataProcessService deepSearchDataProcessService3;
        deepSearchDataProcessService = this$0.dataProcessService;
        boolean isExpired = DeepSearchBroadcastHandlerKt.handleExpiredResponse($notify, $this$mutate, deepSearchDataProcessService);
        boolean isError = DeepSearchBroadcastHandlerKt.handleErrorResponse($notify, $this$mutate);
        deepSearchDataProcessService2 = this$0.dataProcessService;
        boolean isTimeoutError = deepSearchDataProcessService2.isContainAbnormalQueryId($notify.getQueryId());
        if (!isExpired && !isError && !isTimeoutError) {
            deepSearchTimeoutService = this$0.timeoutService;
            deepSearchDataProcessService3 = this$0.dataProcessService;
            final List tempList = DeepSearchBroadcastHandlerKt.handleBroadcastResponse($notify, $this$mutate, deepSearchTimeoutService, deepSearchDataProcessService3);
            if (!DeepSearchTransformListServiceImpKt.isContentGreet($notify)) {
                final DeepSearchThinkPopContent tempThinkPopContent = DeepSearchBroadcastHandlerKt.handleBroadcastThinkPopContent($notify, $this$mutate);
                final DeepSearchPageChatState pageChatState = DeepSearchBroadcastHandlerKt.handlePageChatState($notify, $this$mutate);
                final boolean finishStatus = !DeepSearchBroadcastHandlerKt.handleFinishStatus($notify);
                return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindBroadcastAction$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0$0$0;
                        invokeSuspend$lambda$0$0$0 = DeepSearchStateMachine$bindBroadcastAction$1.invokeSuspend$lambda$0$0$0(DeepSearchPageChatState.this, finishStatus, tempThinkPopContent, tempList, (CopyScope) obj);
                        return invokeSuspend$lambda$0$0$0;
                    }
                });
            }
            return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$bindBroadcastAction$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit invokeSuspend$lambda$0$0$1;
                    invokeSuspend$lambda$0$0$1 = DeepSearchStateMachine$bindBroadcastAction$1.invokeSuspend$lambda$0$0$1(tempList, (CopyScope) obj);
                    return invokeSuspend$lambda$0$0$1;
                }
            });
        }
        return $this$mutate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0$0(DeepSearchPageChatState $pageChatState, boolean $finishStatus, DeepSearchThinkPopContent $tempThinkPopContent, List $tempList, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getPageChatState(DeepSearchPageData.Companion), $pageChatState);
        $this$copy.set(InputStateLensKt.isSending(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), Boolean.valueOf($finishStatus));
        $this$copy.set(DeepSearchPageDataLensKt.getThinkPopContent(DeepSearchPageData.Companion), $tempThinkPopContent);
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $tempList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0$1(List $tempList, CopyScope $this$copy) {
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $tempList);
        return Unit.INSTANCE;
    }
}