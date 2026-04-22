package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryReply;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModel;
import kntr.app.deepsearch.base.model.biz.DeepSearchToast;
import kntr.app.deepsearch.base.model.biz.RequestModelLensKt;
import kntr.app.deepsearch.base.model.biz.RequestStateLensKt;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchHistoryHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "action", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction$UpdateList;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7", f = "DeepSearchHistoryHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7 extends SuspendLambda implements Function3<DeepSearchAction.ChatHistoryAction.UpdateList, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7(Continuation<? super DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DeepSearchAction.ChatHistoryAction.UpdateList updateList, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7 deepSearchHistoryHandlerKt$bindChatHistoryInitAction$7 = new DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7(continuation);
        deepSearchHistoryHandlerKt$bindChatHistoryInitAction$7.L$0 = updateList;
        deepSearchHistoryHandlerKt$bindChatHistoryInitAction$7.L$1 = state;
        return deepSearchHistoryHandlerKt$bindChatHistoryInitAction$7.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final DeepSearchAction.ChatHistoryAction.UpdateList action = (DeepSearchAction.ChatHistoryAction.UpdateList) this.L$0;
        final State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7.invokeSuspend$lambda$0(DeepSearchAction.ChatHistoryAction.UpdateList.this, state, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final DeepSearchAction.ChatHistoryAction.UpdateList $action, final State $state, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$7.invokeSuspend$lambda$0$0(DeepSearchAction.ChatHistoryAction.UpdateList.this, $state, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(DeepSearchAction.ChatHistoryAction.UpdateList $action, State $state, CopyScope $this$copy) {
        List itemList;
        DeepSearchSessionEndModel sessionEndModel;
        if ($action.getResponse() != null) {
            KChatHistoryReply response = $action.getResponse();
            if (response != null) {
                if (((DeepSearchPageData) $state.getSnapshot()).getHistoryCursor().length() == 0) {
                    sessionEndModel = DeepSearchHistoryHandlerKt.handleSessionEndTimeModel((DeepSearchPageData) $state.getSnapshot(), (KChatHistoryItem) CollectionsKt.lastOrNull(response.getItems()));
                    $this$copy.set(DeepSearchContentListLensKt.getSessionEndModel(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), sessionEndModel);
                }
                itemList = DeepSearchHistoryHandlerKt.handleResponseItemList((DeepSearchPageData) $state.getSnapshot(), response.getItems());
                $this$copy.set(DeepSearchContentListLensKt.getList(DeepSearchPageDataLensKt.getList(DeepSearchPageData.Companion)), CollectionsKt.plus(itemList, ((DeepSearchPageData) $state.getSnapshot()).getList().getList()));
                $this$copy.set(DeepSearchPageDataLensKt.getHistoryCursor(DeepSearchPageData.Companion), response.getNextCursor());
                $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatHistoryReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Success.INSTANCE);
            }
        } else {
            Exception e = $action.getError();
            if (e != null) {
                $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatHistoryReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error(e));
                $this$copy.set(DeepSearchPageDataLensKt.getDeepSearchToast(DeepSearchPageData.Companion), DeepSearchToast.Companion.create$default(DeepSearchToast.Companion, e, null, 2, null));
            }
        }
        return Unit.INSTANCE;
    }
}