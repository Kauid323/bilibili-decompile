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
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.model.OfflineCacheCardModelKt;
import video.biz.offline.list.logic.model.OfflinePageConfig;
import video.biz.offline.list.logic.model.OfflinePageState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineHomePageStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$childSpec$2$2", f = "OfflineHomePageStateMachine.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {62, 63, 64}, m = "invokeSuspend", n = {"videos", "state", "videos", "state", "completed", "videos", "state", "completed", "downloading"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class OfflineHomePageStateMachine$childSpec$2$2 extends SuspendLambda implements Function3<List<? extends OfflineVideoEntity>, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ OfflineHomePageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomePageStateMachine$childSpec$2$2(OfflineHomePageStateMachine offlineHomePageStateMachine, Continuation<? super OfflineHomePageStateMachine$childSpec$2$2> continuation) {
        super(3, continuation);
        this.this$0 = offlineHomePageStateMachine;
    }

    public final Object invoke(List<OfflineVideoEntity> list, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineHomePageStateMachine$childSpec$2$2 offlineHomePageStateMachine$childSpec$2$2 = new OfflineHomePageStateMachine$childSpec$2$2(this.this$0, continuation);
        offlineHomePageStateMachine$childSpec$2$2.L$0 = list;
        offlineHomePageStateMachine$childSpec$2$2.L$1 = state;
        return offlineHomePageStateMachine$childSpec$2$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object completedGroups;
        final List completed;
        Object downloadingCards;
        final List downloading;
        List videos = (List) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = videos;
                this.L$1 = state;
                this.label = 1;
                completedGroups = OfflineCacheCardModelKt.completedGroups(videos, this.this$0.getHistoryCache(), (Continuation) this);
                if (completedGroups == coroutine_suspended) {
                    return coroutine_suspended;
                }
                completed = (List) completedGroups;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.L$2 = completed;
                this.label = 2;
                downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos, (Continuation) this);
                if (downloadingCards == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List downloading2 = (List) downloadingCards;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.L$2 = completed;
                this.L$3 = downloading2;
                this.label = 3;
                if (this.this$0.notifyUpdateHistoryProgressIfNeed(((OfflinePageState) state.getSnapshot()).getCompleted(), completed, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                downloading = downloading2;
                final OfflineHomePageStateMachine offlineHomePageStateMachine = this.this$0;
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$childSpec$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflinePageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineHomePageStateMachine$childSpec$2$2.invokeSuspend$lambda$0(downloading, completed, offlineHomePageStateMachine, (OfflinePageState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                completedGroups = $result;
                completed = (List) completedGroups;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.L$2 = completed;
                this.label = 2;
                downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos, (Continuation) this);
                if (downloadingCards == coroutine_suspended) {
                }
                List downloading22 = (List) downloadingCards;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.L$2 = completed;
                this.L$3 = downloading22;
                this.label = 3;
                if (this.this$0.notifyUpdateHistoryProgressIfNeed(((OfflinePageState) state.getSnapshot()).getCompleted(), completed, (Continuation) this) == coroutine_suspended) {
                }
                break;
            case 2:
                completed = (List) this.L$2;
                ResultKt.throwOnFailure($result);
                downloadingCards = $result;
                List downloading222 = (List) downloadingCards;
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.L$2 = completed;
                this.L$3 = downloading222;
                this.label = 3;
                if (this.this$0.notifyUpdateHistoryProgressIfNeed(((OfflinePageState) state.getSnapshot()).getCompleted(), completed, (Continuation) this) == coroutine_suspended) {
                }
                break;
            case 3:
                downloading = (List) this.L$3;
                completed = (List) this.L$2;
                ResultKt.throwOnFailure($result);
                final OfflineHomePageStateMachine offlineHomePageStateMachine2 = this.this$0;
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$childSpec$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflinePageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineHomePageStateMachine$childSpec$2$2.invokeSuspend$lambda$0(downloading, completed, offlineHomePageStateMachine2, (OfflinePageState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$0(List $downloading, List $completed, OfflineHomePageStateMachine this$0, OfflinePageState $this$mutate) {
        OfflinePageConfig updateConfig;
        OfflinePageState copy;
        updateConfig = this$0.updateConfig($this$mutate, $completed.isEmpty());
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : $downloading, (r18 & 2) != 0 ? $this$mutate.completed : $completed, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : updateConfig, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }
}