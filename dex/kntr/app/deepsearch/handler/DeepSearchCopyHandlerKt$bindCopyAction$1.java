package kntr.app.deepsearch.handler;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchCopyModel;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
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
/* compiled from: DeepSearchCopyHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "action", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$CopyAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchCopyHandlerKt$bindCopyAction$1", f = "DeepSearchCopyHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchCopyHandlerKt$bindCopyAction$1 extends SuspendLambda implements Function3<DeepSearchAction.CopyAction, State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchCopyHandlerKt$bindCopyAction$1(Continuation<? super DeepSearchCopyHandlerKt$bindCopyAction$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DeepSearchAction.CopyAction copyAction, State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        DeepSearchCopyHandlerKt$bindCopyAction$1 deepSearchCopyHandlerKt$bindCopyAction$1 = new DeepSearchCopyHandlerKt$bindCopyAction$1(continuation);
        deepSearchCopyHandlerKt$bindCopyAction$1.L$0 = copyAction;
        deepSearchCopyHandlerKt$bindCopyAction$1.L$1 = state;
        return deepSearchCopyHandlerKt$bindCopyAction$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final String copyContent;
        DeepSearchAction.CopyAction action = (DeepSearchAction.CopyAction) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                copyContent = DeepSearchCopyHandlerKt.copyContent(action.getQueryId(), ((DeepSearchPageData) state.getSnapshot()).getList().getList());
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchCopyHandlerKt$bindCopyAction$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchCopyHandlerKt$bindCopyAction$1.invokeSuspend$lambda$0(copyContent, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final String $copyContent, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchCopyHandlerKt$bindCopyAction$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchCopyHandlerKt$bindCopyAction$1.invokeSuspend$lambda$0$0($copyContent, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(String $copyContent, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getCopyModel(DeepSearchPageData.Companion), DeepSearchCopyModel.Companion.create($copyContent));
        return Unit.INSTANCE;
    }
}