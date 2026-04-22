package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KSessionReply;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.biz.DeepSearchToast;
import kntr.app.deepsearch.base.model.biz.RequestModelLensKt;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.base.model.biz.RequestStateLensKt;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.deepsearch.base.model.input.InputStateLensKt;
import kntr.base.moss.api.KMossException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchSessionHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$4$1", f = "DeepSearchSessionHandler.kt", i = {0}, l = {57}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class DeepSearchSessionHandlerKt$bindSessionAction$4$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchTimeoutService $timeoutService;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchSessionHandlerKt$bindSessionAction$4$1(DeepSearchTimeoutService deepSearchTimeoutService, Continuation<? super DeepSearchSessionHandlerKt$bindSessionAction$4$1> continuation) {
        super(2, continuation);
        this.$timeoutService = deepSearchTimeoutService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchSessionHandlerKt$bindSessionAction$4$1 = new DeepSearchSessionHandlerKt$bindSessionAction$4$1(this.$timeoutService, continuation);
        deepSearchSessionHandlerKt$bindSessionAction$4$1.L$0 = obj;
        return deepSearchSessionHandlerKt$bindSessionAction$4$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object createSession;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = state;
                    this.label = 1;
                    createSession = DeepSearchSessionHandlerKt.createSession(((DeepSearchPageData) state.getSnapshot()).getSessionQuery(), ((DeepSearchPageData) state.getSnapshot()).getSessionTitle(), (Continuation) this);
                    if (createSession == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    createSession = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final KSessionReply response = (KSessionReply) createSession;
            this.$timeoutService.greetLaunchTimeout();
            return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$4$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    DeepSearchPageData invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = DeepSearchSessionHandlerKt$bindSessionAction$4$1.invokeSuspend$lambda$0(response, (DeepSearchPageData) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Exception e) {
            this.$timeoutService.greetLaunchTimeout();
            return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$4$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    DeepSearchPageData invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = DeepSearchSessionHandlerKt$bindSessionAction$4$1.invokeSuspend$lambda$1(e, (DeepSearchPageData) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final KSessionReply $response, DeepSearchPageData $this$mutate) {
        RequestParam param = $this$mutate.getRequestModel().getSessionReqState().getParam();
        RequestParam.SessionReqParam sessionParam = param instanceof RequestParam.SessionReqParam ? (RequestParam.SessionReqParam) param : null;
        final boolean isRefreshSession = sessionParam != null && sessionParam.isRefreshSession();
        if ($response.getSessionId().length() > 0) {
            if (isRefreshSession) {
                return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$4$1$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0$0;
                        invokeSuspend$lambda$0$0 = DeepSearchSessionHandlerKt$bindSessionAction$4$1.invokeSuspend$lambda$0$0($response, (CopyScope) obj);
                        return invokeSuspend$lambda$0$0;
                    }
                });
            }
            return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$4$1$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit invokeSuspend$lambda$0$1;
                    invokeSuspend$lambda$0$1 = DeepSearchSessionHandlerKt$bindSessionAction$4$1.invokeSuspend$lambda$0$1($response, (CopyScope) obj);
                    return invokeSuspend$lambda$0$1;
                }
            });
        }
        final KMossException error = new KMossException("session is empty", (Throwable) null);
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$4$1$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$2;
                invokeSuspend$lambda$0$2 = DeepSearchSessionHandlerKt$bindSessionAction$4$1.invokeSuspend$lambda$0$2(error, isRefreshSession, (CopyScope) obj);
                return invokeSuspend$lambda$0$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(KSessionReply $response, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getSessionId(DeepSearchPageData.Companion), $response.getSessionId());
        $this$copy.set(InputStateLensKt.isRefreshSessionId(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), false);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getSessionReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Success.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$1(KSessionReply $response, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getSessionId(DeepSearchPageData.Companion), $response.getSessionId());
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getSessionReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Success.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$2(KMossException $error, boolean $isRefreshSession, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getSessionReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error((Throwable) $error));
        if ($isRefreshSession) {
            $this$copy.set(InputStateLensKt.isRefreshSessionId(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), false);
            $this$copy.set(DeepSearchPageDataLensKt.getDeepSearchToast(DeepSearchPageData.Companion), DeepSearchToast.Companion.create("发送失败，请重试"));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$1(final Exception $e, DeepSearchPageData $this$mutate) {
        RequestParam param = $this$mutate.getRequestModel().getSessionReqState().getParam();
        RequestParam.SessionReqParam sessionParam = param instanceof RequestParam.SessionReqParam ? (RequestParam.SessionReqParam) param : null;
        final boolean isRefreshSession = sessionParam != null && sessionParam.isRefreshSession();
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = DeepSearchSessionHandlerKt$bindSessionAction$4$1.invokeSuspend$lambda$1$0($e, isRefreshSession, (CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(Exception $e, boolean $isRefreshSession, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getSessionReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error($e));
        if ($isRefreshSession) {
            $this$copy.set(InputStateLensKt.isRefreshSessionId(DeepSearchPageDataLensKt.getInputState(DeepSearchPageData.Companion)), false);
            $this$copy.set(DeepSearchPageDataLensKt.getDeepSearchToast(DeepSearchPageData.Companion), DeepSearchToast.Companion.create("发送失败，请重试"));
        } else {
            $this$copy.set(DeepSearchPageDataLensKt.getDeepSearchToast(DeepSearchPageData.Companion), DeepSearchToast.Companion.create$default(DeepSearchToast.Companion, $e, null, 2, null));
        }
        return Unit.INSTANCE;
    }
}