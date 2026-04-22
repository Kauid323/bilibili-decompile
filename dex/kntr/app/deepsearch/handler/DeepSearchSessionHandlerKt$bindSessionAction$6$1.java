package kntr.app.deepsearch.handler;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.RequestModelLensKt;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.base.model.biz.RequestStateLensKt;
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
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$6$1", f = "DeepSearchSessionHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchSessionHandlerKt$bindSessionAction$6$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchSessionHandlerKt$bindSessionAction$6$1(Continuation<? super DeepSearchSessionHandlerKt$bindSessionAction$6$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchSessionHandlerKt$bindSessionAction$6$1 = new DeepSearchSessionHandlerKt$bindSessionAction$6$1(continuation);
        deepSearchSessionHandlerKt$bindSessionAction$6$1.L$0 = obj;
        return deepSearchSessionHandlerKt$bindSessionAction$6$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestParam param = ((DeepSearchPageData) state.getSnapshot()).getRequestModel().getSessionReqState().getParam();
                RequestParam.SessionReqParam sessionParam = param instanceof RequestParam.SessionReqParam ? (RequestParam.SessionReqParam) param : null;
                boolean isRefreshSession = sessionParam != null && sessionParam.isRefreshSession();
                final boolean z = isRefreshSession;
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$6$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchSessionHandlerKt$bindSessionAction$6$1.invokeSuspend$lambda$0(z, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(boolean $isRefreshSession, DeepSearchPageData $this$mutate) {
        final List dataItemList;
        if ($isRefreshSession) {
            if ($this$mutate.getSessionId().length() > 0) {
                dataItemList = DeepSearchSessionHandlerKt.insertDefaultGreet($this$mutate);
                return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchSessionHandlerKt$bindSessionAction$6$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0$0;
                        invokeSuspend$lambda$0$0 = DeepSearchSessionHandlerKt$bindSessionAction$6$1.invokeSuspend$lambda$0$0(dataItemList, (CopyScope) obj);
                        return invokeSuspend$lambda$0$0;
                    }
                });
            }
        }
        return $this$mutate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(List $dataItemList, CopyScope $this$copy) {
        $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), $dataItemList);
        $this$copy.set(RequestStateLensKt.getParam(RequestModelLensKt.getSessionReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), (Object) null);
        return Unit.INSTANCE;
    }
}