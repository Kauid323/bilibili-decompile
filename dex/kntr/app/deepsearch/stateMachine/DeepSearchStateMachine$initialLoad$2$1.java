package kntr.app.deepsearch.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.PageStatus;
import kntr.app.deepsearch.base.model.biz.PageStyle;
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
/* compiled from: DeepSearchStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$initialLoad$2$1", f = "DeepSearchStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DeepSearchStateMachine$initialLoad$2$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchStateMachine$initialLoad$2$1(Continuation<? super DeepSearchStateMachine$initialLoad$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchStateMachine$initialLoad$2$1 = new DeepSearchStateMachine$initialLoad$2$1(continuation);
        deepSearchStateMachine$initialLoad$2$1.L$0 = obj;
        return deepSearchStateMachine$initialLoad$2$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.deepsearch.stateMachine.DeepSearchStateMachine$initialLoad$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DeepSearchPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchStateMachine$initialLoad$2$1.invokeSuspend$lambda$0(state, (DeepSearchPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(State $state, DeepSearchPageData $this$mutate) {
        PageStyle pageStyle;
        DeepSearchPageData copy;
        if (((DeepSearchPageData) $state.getSnapshot()).getSessionId().length() == 0) {
            pageStyle = PageStyle.Init.INSTANCE;
        } else {
            pageStyle = PageStyle.History.INSTANCE;
        }
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.sessionQuery : null, (r36 & 4) != 0 ? $this$mutate.sessionTitle : null, (r36 & 8) != 0 ? $this$mutate.historyCursor : null, (r36 & 16) != 0 ? $this$mutate.pageStatus : PageStatus.InitSuccess.INSTANCE, (r36 & 32) != 0 ? $this$mutate.pageStyle : pageStyle, (r36 & 64) != 0 ? $this$mutate.requestModel : null, (r36 & 128) != 0 ? $this$mutate.textConfigModel : null, (r36 & 256) != 0 ? $this$mutate.containerWidth : 0.0d, (r36 & 512) != 0 ? $this$mutate.pageChatState : null, (r36 & 1024) != 0 ? $this$mutate.thinkPopContent : null, (r36 & 2048) != 0 ? $this$mutate.deepSearchToast : null, (r36 & 4096) != 0 ? $this$mutate.copyModel : null, (r36 & 8192) != 0 ? $this$mutate.treadPopContent : null, (r36 & 16384) != 0 ? $this$mutate.bubbleData : null, (r36 & 32768) != 0 ? $this$mutate.inputState : null, (r36 & 65536) != 0 ? $this$mutate.list : null);
        return copy;
    }
}