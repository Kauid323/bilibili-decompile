package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
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
import video.base.log.LogKt;
import video.biz.offline.list.logic.model.DialogType;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineBaseListStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$ShowLoading;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$10", f = "OfflineBaseListStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineBaseListStateMachine$1$1$10 extends SuspendLambda implements Function3<OfflineListAction.ShowLoading, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineBaseListStateMachine$1$1$10(Continuation<? super OfflineBaseListStateMachine$1$1$10> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OfflineListAction.ShowLoading showLoading, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineBaseListStateMachine$1$1$10 offlineBaseListStateMachine$1$1$10 = new OfflineBaseListStateMachine$1$1$10(continuation);
        offlineBaseListStateMachine$1$1$10.L$0 = state;
        return offlineBaseListStateMachine$1$1$10.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LogKt.getVBLog().debug("转圈----- state ShowLoading start");
                ChangedState mutate = state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$10$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflinePageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineBaseListStateMachine$1$1$10.invokeSuspend$lambda$0((OfflinePageState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
                LogKt.getVBLog().debug("转圈----- state ShowLoading end");
                return mutate;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$0(OfflinePageState $this$mutate) {
        OfflinePageState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : DialogType.Loading.INSTANCE);
        return copy;
    }
}