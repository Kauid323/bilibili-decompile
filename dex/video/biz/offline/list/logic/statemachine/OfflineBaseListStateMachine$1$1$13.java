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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.DialogType;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;
import video.biz.offline.list.logic.utils.UtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineBaseListStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$VipPurchase;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$13", f = "OfflineBaseListStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineBaseListStateMachine$1$1$13 extends SuspendLambda implements Function3<OfflineListAction.VipPurchase, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OfflineBaseListStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineBaseListStateMachine$1$1$13(OfflineBaseListStateMachine offlineBaseListStateMachine, Continuation<? super OfflineBaseListStateMachine$1$1$13> continuation) {
        super(3, continuation);
        this.this$0 = offlineBaseListStateMachine;
    }

    public final Object invoke(OfflineListAction.VipPurchase vipPurchase, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineBaseListStateMachine$1$1$13 offlineBaseListStateMachine$1$1$13 = new OfflineBaseListStateMachine$1$1$13(this.this$0, continuation);
        offlineBaseListStateMachine$1$1$13.L$0 = vipPurchase;
        offlineBaseListStateMachine$1$1$13.L$1 = state;
        return offlineBaseListStateMachine$1$1$13.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Router router;
        OfflineListAction.VipPurchase action = (OfflineListAction.VipPurchase) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                router = this.this$0.router;
                router.launch(UtilsKt.resolveVipRoute(action.getType()));
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$13$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflinePageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineBaseListStateMachine$1$1$13.invokeSuspend$lambda$0((OfflinePageState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$0(OfflinePageState $this$mutate) {
        OfflinePageState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : DialogType.None.INSTANCE);
        return copy;
    }
}