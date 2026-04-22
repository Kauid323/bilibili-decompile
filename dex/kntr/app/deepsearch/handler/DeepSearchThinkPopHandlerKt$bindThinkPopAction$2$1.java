package kntr.app.deepsearch.handler;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContent;
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
/* compiled from: DeepSearchThinkPopHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "action", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction$ThinkPopViewShow;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1", f = "DeepSearchThinkPopHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1 extends SuspendLambda implements Function3<DeepSearchAction.ThinkPopViewAction.ThinkPopViewShow, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1(Continuation<? super DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DeepSearchAction.ThinkPopViewAction.ThinkPopViewShow thinkPopViewShow, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1 deepSearchThinkPopHandlerKt$bindThinkPopAction$2$1 = new DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1(continuation);
        deepSearchThinkPopHandlerKt$bindThinkPopAction$2$1.L$0 = thinkPopViewShow;
        deepSearchThinkPopHandlerKt$bindThinkPopAction$2$1.L$1 = state;
        return deepSearchThinkPopHandlerKt$bindThinkPopAction$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final DeepSearchThinkPopContent content;
        DeepSearchAction.ThinkPopViewAction.ThinkPopViewShow action = (DeepSearchAction.ThinkPopViewAction.ThinkPopViewShow) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                content = DeepSearchThinkPopHandlerKt.thinkPopContent(action.getQueryId(), (DeepSearchPageData) state.getSnapshot());
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1.invokeSuspend$lambda$0(DeepSearchThinkPopContent.this, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final DeepSearchThinkPopContent $content, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchThinkPopHandlerKt$bindThinkPopAction$2$1.invokeSuspend$lambda$0$0(DeepSearchThinkPopContent.this, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(DeepSearchThinkPopContent $content, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getThinkPopContent(DeepSearchPageData.Companion), $content);
        return Unit.INSTANCE;
    }
}