package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.OfflinePageState;

/* compiled from: OfflineHomePageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/ClickSearch;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$childSpec$3", f = "OfflineHomePageStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineHomePageStateMachine$childSpec$3 extends SuspendLambda implements Function3<ClickSearch, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfflineHomePageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomePageStateMachine$childSpec$3(OfflineHomePageStateMachine offlineHomePageStateMachine, Continuation<? super OfflineHomePageStateMachine$childSpec$3> continuation) {
        super(3, continuation);
        this.this$0 = offlineHomePageStateMachine;
    }

    public final Object invoke(ClickSearch clickSearch, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineHomePageStateMachine$childSpec$3 offlineHomePageStateMachine$childSpec$3 = new OfflineHomePageStateMachine$childSpec$3(this.this$0, continuation);
        offlineHomePageStateMachine$childSpec$3.L$0 = state;
        return offlineHomePageStateMachine$childSpec$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Router router;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                router = this.this$0.router;
                router.launch(UrisKt.toUri("bilibili://offline/cache/search"));
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}