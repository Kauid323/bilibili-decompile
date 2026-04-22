package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.model.DataState;
import video.biz.offline.list.logic.model.OfflineCacheCardModelKt;
import video.biz.offline.list.logic.model.OfflinePageConfig;
import video.biz.offline.list.logic.model.OfflinePageState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineCompletedPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$2$2", f = "OfflineCompletedPageStateMachine.kt", i = {0, 0, 1, 1, 1}, l = {62, 63}, m = "invokeSuspend", n = {"videos", "state", "videos", "state", "completed"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
public final class OfflineCompletedPageStateMachine$childSpec$2$2 extends SuspendLambda implements Function3<List<? extends OfflineVideoEntity>, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OfflineCompletedPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineCompletedPageStateMachine$childSpec$2$2(OfflineCompletedPageStateMachine offlineCompletedPageStateMachine, Continuation<? super OfflineCompletedPageStateMachine$childSpec$2$2> continuation) {
        super(3, continuation);
        this.this$0 = offlineCompletedPageStateMachine;
    }

    public final Object invoke(List<OfflineVideoEntity> list, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineCompletedPageStateMachine$childSpec$2$2 offlineCompletedPageStateMachine$childSpec$2$2 = new OfflineCompletedPageStateMachine$childSpec$2$2(this.this$0, continuation);
        offlineCompletedPageStateMachine$childSpec$2$2.L$0 = list;
        offlineCompletedPageStateMachine$childSpec$2$2.L$1 = state;
        return offlineCompletedPageStateMachine$childSpec$2$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String str;
        Object completedCards;
        List completed;
        final List completed2;
        List videos = (List) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                str = this.this$0.type;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.label = 1;
                completedCards = OfflineCacheCardModelKt.completedCards(videos, Intrinsics.areEqual(str, "group"), this.this$0.getHistoryCache(), (Continuation) this);
                if (completedCards == coroutine_suspended) {
                    return coroutine_suspended;
                }
                completed = (List) completedCards;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.L$2 = completed;
                this.label = 2;
                if (this.this$0.notifyUpdateHistoryProgressIfNeed(((OfflinePageState) state.getSnapshot()).getCompleted(), completed, (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                completed2 = completed;
                final OfflineCompletedPageStateMachine offlineCompletedPageStateMachine = this.this$0;
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflinePageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineCompletedPageStateMachine$childSpec$2$2.invokeSuspend$lambda$0(completed2, offlineCompletedPageStateMachine, (OfflinePageState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                completedCards = $result;
                completed = (List) completedCards;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.L$2 = completed;
                this.label = 2;
                if (this.this$0.notifyUpdateHistoryProgressIfNeed(((OfflinePageState) state.getSnapshot()).getCompleted(), completed, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                completed2 = (List) this.L$2;
                ResultKt.throwOnFailure($result);
                final OfflineCompletedPageStateMachine offlineCompletedPageStateMachine2 = this.this$0;
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflinePageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineCompletedPageStateMachine$childSpec$2$2.invokeSuspend$lambda$0(completed2, offlineCompletedPageStateMachine2, (OfflinePageState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$0(List $completed, OfflineCompletedPageStateMachine this$0, OfflinePageState $this$mutate) {
        OfflinePageConfig updateConfig;
        OfflinePageState copy;
        DataState dataState = DataState.READY;
        updateConfig = this$0.updateConfig($this$mutate, $completed.isEmpty());
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : $completed, (r18 & 4) != 0 ? $this$mutate.dataState : dataState, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : updateConfig, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }
}