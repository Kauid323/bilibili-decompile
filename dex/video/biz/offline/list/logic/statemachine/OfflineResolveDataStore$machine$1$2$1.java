package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
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
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.statemachine.OfflineResolvePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineResolveState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResloveStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "event", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$VideosLoaded;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Loading;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$2$1", f = "OfflineResloveStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineResolveDataStore$machine$1$2$1 extends SuspendLambda implements Function3<OfflineResolvePageEvent.VideosLoaded, State<OfflineResolveState.Loading>, Continuation<? super ChangedState<? extends OfflineResolveState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OfflineResolveDataStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineResolveDataStore$machine$1$2$1(OfflineResolveDataStore offlineResolveDataStore, Continuation<? super OfflineResolveDataStore$machine$1$2$1> continuation) {
        super(3, continuation);
        this.this$0 = offlineResolveDataStore;
    }

    public final Object invoke(OfflineResolvePageEvent.VideosLoaded videosLoaded, State<OfflineResolveState.Loading> state, Continuation<? super ChangedState<? extends OfflineResolveState>> continuation) {
        OfflineResolveDataStore$machine$1$2$1 offlineResolveDataStore$machine$1$2$1 = new OfflineResolveDataStore$machine$1$2$1(this.this$0, continuation);
        offlineResolveDataStore$machine$1$2$1.L$0 = videosLoaded;
        offlineResolveDataStore$machine$1$2$1.L$1 = state;
        return offlineResolveDataStore$machine$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        String str;
        boolean z;
        OfflineResolvePageEvent.VideosLoaded event = (OfflineResolvePageEvent.VideosLoaded) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OfflineResolveDataStore offlineResolveDataStore = this.this$0;
                Iterator<T> it = event.getVideos().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        OfflineVideoEntity it2 = (OfflineVideoEntity) obj;
                        long cid = it2.getCid();
                        str = offlineResolveDataStore.cid;
                        if (cid == Long.parseLong(str)) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                        }
                    } else {
                        obj = null;
                    }
                }
                final OfflineVideoEntity video2 = (OfflineVideoEntity) obj;
                final OfflineResolveDataStore offlineResolveDataStore2 = this.this$0;
                return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        OfflineResolveState.OfflineResolvePageUiState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = OfflineResolveDataStore$machine$1$2$1.invokeSuspend$lambda$1(OfflineResolveDataStore.this, video2, (OfflineResolveState.Loading) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineResolveState.OfflineResolvePageUiState invokeSuspend$lambda$1(OfflineResolveDataStore this$0, OfflineVideoEntity $video, OfflineResolveState.Loading $this$override) {
        String str;
        String str2;
        OfflineResolveState.OfflineResolvePageUiState offlineResolvePageUiState = new OfflineResolveState.OfflineResolvePageUiState(null, null, null, false, false, false, 63, null);
        str = this$0.videoId;
        str2 = this$0.cid;
        return OfflineResolveState.OfflineResolvePageUiState.copy$default(offlineResolvePageUiState, str, str2, $video, false, false, false, 56, null);
    }
}