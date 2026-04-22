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
import tv.danmaku.ijk.media.player.IjkCpuInfo;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.model.OfflineCacheCardModelKt;
import video.biz.offline.list.logic.model.OfflinePageConfig;
import video.biz.offline.list.logic.model.OfflinePageState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDownloadingPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$2$2", f = "OfflineDownloadingPageStateMachine.kt", i = {0, 0}, l = {IjkCpuInfo.CPU_PART_SNAPDRAGON_S3}, m = "invokeSuspend", n = {"videos", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class OfflineDownloadingPageStateMachine$childSpec$2$2 extends SuspendLambda implements Function3<List<? extends OfflineVideoEntity>, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OfflineDownloadingPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDownloadingPageStateMachine$childSpec$2$2(OfflineDownloadingPageStateMachine offlineDownloadingPageStateMachine, Continuation<? super OfflineDownloadingPageStateMachine$childSpec$2$2> continuation) {
        super(3, continuation);
        this.this$0 = offlineDownloadingPageStateMachine;
    }

    public final Object invoke(List<OfflineVideoEntity> list, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineDownloadingPageStateMachine$childSpec$2$2 offlineDownloadingPageStateMachine$childSpec$2$2 = new OfflineDownloadingPageStateMachine$childSpec$2$2(this.this$0, continuation);
        offlineDownloadingPageStateMachine$childSpec$2$2.L$0 = list;
        offlineDownloadingPageStateMachine$childSpec$2$2.L$1 = state;
        return offlineDownloadingPageStateMachine$childSpec$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object downloadingCards;
        List videos = (List) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                this.L$1 = state;
                this.label = 1;
                downloadingCards = OfflineCacheCardModelKt.downloadingCards(videos, (Continuation) this);
                if (downloadingCards == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                downloadingCards = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final List downloading = (List) downloadingCards;
        final OfflineDownloadingPageStateMachine offlineDownloadingPageStateMachine = this.this$0;
        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$2$2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OfflinePageState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = OfflineDownloadingPageStateMachine$childSpec$2$2.invokeSuspend$lambda$0(downloading, offlineDownloadingPageStateMachine, (OfflinePageState) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$0(List $downloading, OfflineDownloadingPageStateMachine this$0, OfflinePageState $this$mutate) {
        OfflinePageConfig updateConfig;
        OfflinePageState copy;
        updateConfig = this$0.updateConfig($this$mutate, $downloading.isEmpty());
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : $downloading, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : updateConfig, (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }
}