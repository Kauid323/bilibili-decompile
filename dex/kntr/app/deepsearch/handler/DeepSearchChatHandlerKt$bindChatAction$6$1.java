package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KStopChatReply;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchToast;
import kntr.app.deepsearch.base.model.biz.RequestModelLensKt;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.base.model.biz.RequestStateLensKt;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.base.log.KLogKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchChatHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1", f = "DeepSearchChatHandler.kt", i = {0, 0}, l = {393}, m = "invokeSuspend", n = {"state", "stopChatParam"}, s = {"L$0", "L$1"}, v = 1)
public final class DeepSearchChatHandlerKt$bindChatAction$6$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchChatHandlerKt$bindChatAction$6$1(Continuation<? super DeepSearchChatHandlerKt$bindChatAction$6$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchChatHandlerKt$bindChatAction$6$1 = new DeepSearchChatHandlerKt$bindChatAction$6$1(continuation);
        deepSearchChatHandlerKt$bindChatAction$6$1.L$0 = obj;
        return deepSearchChatHandlerKt$bindChatAction$6$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final Exception e;
        RequestParam.ChatReqParam stopChatParam;
        Object stopChat;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestParam param = ((DeepSearchPageData) state.getSnapshot()).getRequestModel().getStopChatReqState().getParam();
                RequestParam.ChatReqParam stopChatParam2 = param instanceof RequestParam.ChatReqParam ? (RequestParam.ChatReqParam) param : null;
                if (stopChatParam2 != null) {
                    try {
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(stopChatParam2);
                        this.label = 1;
                        stopChat = DeepSearchChatHandlerKt.stopChat(((DeepSearchPageData) state.getSnapshot()).getSessionId(), stopChatParam2.getQueryId(), (Continuation) this);
                        if (stopChat == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        stopChatParam = stopChatParam2;
                        final KStopChatReply response = (KStopChatReply) stopChat;
                        KLogKt.d(KLog_androidKt.getKLog(), "StopChat", new Function0() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                String kStopChatReply;
                                kStopChatReply = response.toString();
                                return kStopChatReply;
                            }
                        });
                        return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                DeepSearchPageData invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = DeepSearchChatHandlerKt$bindChatAction$6$1.invokeSuspend$lambda$1((DeepSearchPageData) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    } catch (Exception e2) {
                        RequestParam.ChatReqParam chatReqParam = stopChatParam2;
                        e = e2;
                        stopChatParam = chatReqParam;
                        return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                DeepSearchPageData invokeSuspend$lambda$2;
                                invokeSuspend$lambda$2 = DeepSearchChatHandlerKt$bindChatAction$6$1.invokeSuspend$lambda$2(e, (DeepSearchPageData) obj);
                                return invokeSuspend$lambda$2;
                            }
                        });
                    }
                }
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$3;
                        invokeSuspend$lambda$3 = DeepSearchChatHandlerKt$bindChatAction$6$1.invokeSuspend$lambda$3((DeepSearchPageData) obj);
                        return invokeSuspend$lambda$3;
                    }
                });
            case 1:
                stopChatParam = (RequestParam.ChatReqParam) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    stopChat = $result;
                    final KStopChatReply response2 = (KStopChatReply) stopChat;
                    KLogKt.d(KLog_androidKt.getKLog(), "StopChat", new Function0() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            String kStopChatReply;
                            kStopChatReply = response2.toString();
                            return kStopChatReply;
                        }
                    });
                    return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = DeepSearchChatHandlerKt$bindChatAction$6$1.invokeSuspend$lambda$1((DeepSearchPageData) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                } catch (Exception e3) {
                    e = e3;
                    return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = DeepSearchChatHandlerKt$bindChatAction$6$1.invokeSuspend$lambda$2(e, (DeepSearchPageData) obj);
                            return invokeSuspend$lambda$2;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$1(DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = DeepSearchChatHandlerKt$bindChatAction$6$1.invokeSuspend$lambda$1$0((CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getStopChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Success.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$2(final Exception $e, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$2$0;
                invokeSuspend$lambda$2$0 = DeepSearchChatHandlerKt$bindChatAction$6$1.invokeSuspend$lambda$2$0($e, (CopyScope) obj);
                return invokeSuspend$lambda$2$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2$0(Exception $e, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getStopChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error($e));
        $this$copy.set(DeepSearchPageDataLensKt.getDeepSearchToast(DeepSearchPageData.Companion), DeepSearchToast.Companion.create$default(DeepSearchToast.Companion, $e, null, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$3(DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchChatHandlerKt$bindChatAction$6$1$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$3$0;
                invokeSuspend$lambda$3$0 = DeepSearchChatHandlerKt$bindChatAction$6$1.invokeSuspend$lambda$3$0((CopyScope) obj);
                return invokeSuspend$lambda$3$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3$0(CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getStopChatReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Idle.INSTANCE);
        return Unit.INSTANCE;
    }
}