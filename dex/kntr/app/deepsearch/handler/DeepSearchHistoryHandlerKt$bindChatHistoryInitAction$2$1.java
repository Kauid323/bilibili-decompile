package kntr.app.deepsearch.handler;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.PageStyle;
import kntr.app.deepsearch.base.model.biz.RequestModelLensKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchHistoryHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "<unused var>", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction$Refresh;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1", f = "DeepSearchHistoryHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1 extends SuspendLambda implements Function3<DeepSearchAction.ChatHistoryAction.Refresh, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1(Continuation<? super DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DeepSearchAction.ChatHistoryAction.Refresh refresh, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1 deepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1 = new DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1(continuation);
        deepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1.L$0 = state;
        return deepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(((DeepSearchPageData) state.getSnapshot()).getPageStyle(), PageStyle.Init.INSTANCE)) {
                    return state.noChange();
                }
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1.invokeSuspend$lambda$0((DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$2$1.invokeSuspend$lambda$0$0((CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getChatHistoryReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Loading.INSTANCE);
        return Unit.INSTANCE;
    }
}