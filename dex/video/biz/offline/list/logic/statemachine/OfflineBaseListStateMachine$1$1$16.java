package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.base.router.Router;
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
import video.biz.offline.list.logic.statemachine.OfflineListAction;
import video.biz.offline.list.logic.utils.UtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineBaseListStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Jump2BandWidth;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$16", f = "OfflineBaseListStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineBaseListStateMachine$1$1$16 extends SuspendLambda implements Function3<OfflineListAction.Jump2BandWidth, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfflineBaseListStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineBaseListStateMachine$1$1$16(OfflineBaseListStateMachine offlineBaseListStateMachine, Continuation<? super OfflineBaseListStateMachine$1$1$16> continuation) {
        super(3, continuation);
        this.this$0 = offlineBaseListStateMachine;
    }

    public final Object invoke(OfflineListAction.Jump2BandWidth jump2BandWidth, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineBaseListStateMachine$1$1$16 offlineBaseListStateMachine$1$1$16 = new OfflineBaseListStateMachine$1$1$16(this.this$0, continuation);
        offlineBaseListStateMachine$1$1$16.L$0 = state;
        return offlineBaseListStateMachine$1$1$16.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Router router;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                router = this.this$0.router;
                router.launch(UtilsKt.resolveBandwidthRoute());
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}