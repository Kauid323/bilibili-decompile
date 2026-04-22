package kntr.app.deepsearch.handler;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchLikeHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1", f = "DeepSearchLikeHandler.kt", i = {0, 0}, l = {62}, m = "invokeSuspend", n = {"state", "likeParam"}, s = {"L$0", "L$1"}, v = 1)
public final class DeepSearchLikeHandlerKt$bindLikeAction$4$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchLikeHandlerKt$bindLikeAction$4$1(Continuation<? super DeepSearchLikeHandlerKt$bindLikeAction$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchLikeHandlerKt$bindLikeAction$4$1 = new DeepSearchLikeHandlerKt$bindLikeAction$4$1(continuation);
        deepSearchLikeHandlerKt$bindLikeAction$4$1.L$0 = obj;
        return deepSearchLikeHandlerKt$bindLikeAction$4$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final Exception e;
        RequestParam.LikeReqParam likeParam;
        Object reqLikeState;
        final List dataList;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestParam param = ((DeepSearchPageData) state.getSnapshot()).getRequestModel().getLikeReqState().getParam();
                RequestParam.LikeReqParam likeParam2 = param instanceof RequestParam.LikeReqParam ? (RequestParam.LikeReqParam) param : null;
                if (likeParam2 != null) {
                    try {
                        this.L$0 = state;
                        this.L$1 = likeParam2;
                        this.label = 1;
                        reqLikeState = DeepSearchLikeHandlerKt.reqLikeState(((DeepSearchPageData) state.getSnapshot()).getSessionId(), likeParam2.getQueryId(), likeParam2.getLikeType(), (Continuation) this);
                        if (reqLikeState == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        likeParam = likeParam2;
                        dataList = DeepSearchLikeHandlerKt.likeSuccessUpdateList(((DeepSearchPageData) state.getSnapshot()).getList().getList(), likeParam);
                        return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                DeepSearchPageData invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = DeepSearchLikeHandlerKt$bindLikeAction$4$1.invokeSuspend$lambda$0(dataList, (DeepSearchPageData) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    } catch (Exception e2) {
                        RequestParam.LikeReqParam likeReqParam = likeParam2;
                        e = e2;
                        likeParam = likeReqParam;
                        return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                DeepSearchPageData invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = DeepSearchLikeHandlerKt$bindLikeAction$4$1.invokeSuspend$lambda$1(e, (DeepSearchPageData) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    }
                }
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = DeepSearchLikeHandlerKt$bindLikeAction$4$1.invokeSuspend$lambda$2((DeepSearchPageData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            case 1:
                likeParam = (RequestParam.LikeReqParam) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    dataList = DeepSearchLikeHandlerKt.likeSuccessUpdateList(((DeepSearchPageData) state.getSnapshot()).getList().getList(), likeParam);
                    return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = DeepSearchLikeHandlerKt$bindLikeAction$4$1.invokeSuspend$lambda$0(dataList, (DeepSearchPageData) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } catch (Exception e3) {
                    e = e3;
                    return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            DeepSearchPageData invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = DeepSearchLikeHandlerKt$bindLikeAction$4$1.invokeSuspend$lambda$1(e, (DeepSearchPageData) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final List $dataList, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchLikeHandlerKt$bindLikeAction$4$1.invokeSuspend$lambda$0$0($dataList, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(List $dataList, CopyScope $this$copy) {
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $dataList);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getLikeReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Success.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$1(final Exception $e, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = DeepSearchLikeHandlerKt$bindLikeAction$4$1.invokeSuspend$lambda$1$0($e, (CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(Exception $e, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getLikeReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error($e));
        $this$copy.set(DeepSearchPageDataLensKt.getDeepSearchToast(DeepSearchPageData.Companion), DeepSearchToast.Companion.create$default(DeepSearchToast.Companion, $e, null, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$2(DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$bindLikeAction$4$1$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$2$0;
                invokeSuspend$lambda$2$0 = DeepSearchLikeHandlerKt$bindLikeAction$4$1.invokeSuspend$lambda$2$0((CopyScope) obj);
                return invokeSuspend$lambda$2$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2$0(CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getLikeReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Idle.INSTANCE);
        return Unit.INSTANCE;
    }
}