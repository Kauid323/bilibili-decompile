package kntr.app.deepsearch.handler;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchSumitTreadHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1", f = "DeepSearchSumitTreadHandler.kt", i = {0, 0}, l = {60}, m = "invokeSuspend", n = {"state", "submitTreadParam"}, s = {"L$0", "L$1"}, v = 1)
public final class DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1(Continuation<? super DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1 = new DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1(continuation);
        deepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.L$0 = obj;
        return deepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final Exception e;
        RequestParam.SubmitTreadParam submitTreadParam;
        Object requestSubmitTread;
        ChangedState mutate;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestParam param = ((DeepSearchPageData) state.getSnapshot()).getRequestModel().getSubmitTreadState().getParam();
                RequestParam.SubmitTreadParam submitTreadParam2 = param instanceof RequestParam.SubmitTreadParam ? (RequestParam.SubmitTreadParam) param : null;
                if (submitTreadParam2 != null) {
                    try {
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(submitTreadParam2);
                        this.label = 1;
                        requestSubmitTread = DeepSearchSumitTreadHandlerKt.requestSubmitTread(((DeepSearchPageData) state.getSnapshot()).getSessionId(), submitTreadParam2, (Continuation) this);
                    } catch (Exception e2) {
                        RequestParam.SubmitTreadParam submitTreadParam3 = submitTreadParam2;
                        e = e2;
                        submitTreadParam = submitTreadParam3;
                        mutate = state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj) {
                                DeepSearchPageData invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.invokeSuspend$lambda$1(e, (DeepSearchPageData) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                        return mutate;
                    }
                    if (requestSubmitTread == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    submitTreadParam = submitTreadParam2;
                    mutate = state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.invokeSuspend$lambda$0((DeepSearchPageData) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                    return mutate;
                }
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.invokeSuspend$lambda$2((DeepSearchPageData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            case 1:
                submitTreadParam = (RequestParam.SubmitTreadParam) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    mutate = state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.invokeSuspend$lambda$0((DeepSearchPageData) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } catch (Exception e3) {
                    e = e3;
                    mutate = state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.invokeSuspend$lambda$1(e, (DeepSearchPageData) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                    return mutate;
                }
                return mutate;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.invokeSuspend$lambda$0$0((CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getSubmitTreadState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Success.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$1(final Exception $e, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.invokeSuspend$lambda$1$0($e, (CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(Exception $e, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getSubmitTreadState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error($e));
        $this$copy.set(DeepSearchPageDataLensKt.getDeepSearchToast(DeepSearchPageData.Companion), DeepSearchToast.Companion.create$default(DeepSearchToast.Companion, $e, null, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$2(DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$2$0;
                invokeSuspend$lambda$2$0 = DeepSearchSumitTreadHandlerKt$bindSubmitTreadAction$4$1.invokeSuspend$lambda$2$0((CopyScope) obj);
                return invokeSuspend$lambda$2$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2$0(CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getSubmitTreadState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Idle.INSTANCE);
        return Unit.INSTANCE;
    }
}