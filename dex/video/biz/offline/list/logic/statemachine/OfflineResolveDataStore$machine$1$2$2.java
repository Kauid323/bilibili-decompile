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
import video.biz.offline.list.logic.statemachine.OfflineResolvePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineResolveState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResloveStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$VideosLoadFailed;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$Loading;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$2$2", f = "OfflineResloveStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineResolveDataStore$machine$1$2$2 extends SuspendLambda implements Function3<OfflineResolvePageEvent.VideosLoadFailed, State<OfflineResolveState.Loading>, Continuation<? super ChangedState<? extends OfflineResolveState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineResolveDataStore$machine$1$2$2(Continuation<? super OfflineResolveDataStore$machine$1$2$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OfflineResolvePageEvent.VideosLoadFailed videosLoadFailed, State<OfflineResolveState.Loading> state, Continuation<? super ChangedState<? extends OfflineResolveState>> continuation) {
        OfflineResolveDataStore$machine$1$2$2 offlineResolveDataStore$machine$1$2$2 = new OfflineResolveDataStore$machine$1$2$2(continuation);
        offlineResolveDataStore$machine$1$2$2.L$0 = state;
        return offlineResolveDataStore$machine$1$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflineResolveState.Error invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineResolveDataStore$machine$1$2$2.invokeSuspend$lambda$0((OfflineResolveState.Loading) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineResolveState.Error invokeSuspend$lambda$0(OfflineResolveState.Loading $this$override) {
        return new OfflineResolveState.Error(null, 1, null);
    }
}