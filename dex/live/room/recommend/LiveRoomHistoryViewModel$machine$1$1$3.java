package live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMoreLiveMoss;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KRemoveViewHistoryReq;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KRemoveViewHistoryResp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.base.moss.api.KCallOptions;
import kntr.base.moss.api.KMossException;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import live.room.recommend.LiveRoomHistoryEvent;
import live.room.recommend.LiveRoomHistoryState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LiveRoomHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Llive/room/recommend/LiveRoomHistoryState;", "event", "Llive/room/recommend/LiveRoomHistoryEvent$deleteHistory;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$3", f = "LiveRoomHistoryViewModel.kt", i = {0, 0, 0}, l = {157}, m = "invokeSuspend", n = {"event", "state", "req"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class LiveRoomHistoryViewModel$machine$1$1$3 extends SuspendLambda implements Function3<LiveRoomHistoryEvent.deleteHistory, State<LiveRoomHistoryState>, Continuation<? super ChangedState<? extends LiveRoomHistoryState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ LiveRoomHistoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRoomHistoryViewModel$machine$1$1$3(LiveRoomHistoryViewModel liveRoomHistoryViewModel, Continuation<? super LiveRoomHistoryViewModel$machine$1$1$3> continuation) {
        super(3, continuation);
        this.this$0 = liveRoomHistoryViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(LiveRoomHistoryEvent.deleteHistory deletehistory, State<LiveRoomHistoryState> state, Continuation<? super ChangedState<? extends LiveRoomHistoryState>> continuation) {
        LiveRoomHistoryViewModel$machine$1$1$3 liveRoomHistoryViewModel$machine$1$1$3 = new LiveRoomHistoryViewModel$machine$1$1$3(this.this$0, continuation);
        liveRoomHistoryViewModel$machine$1$1$3.L$0 = deletehistory;
        liveRoomHistoryViewModel$machine$1$1$3.L$1 = state;
        return liveRoomHistoryViewModel$machine$1$1$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        List list;
        Object removeViewHistory;
        LiveRoomHistoryEvent.deleteHistory event = (LiveRoomHistoryEvent.deleteHistory) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    list = this.this$0.mDeletedKids;
                    list.addAll(event.getHistoryKids());
                    KRemoveViewHistoryReq req = new KRemoveViewHistoryReq(event.getHistoryKids(), this.this$0.getUid(), event.getBuvid());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(req);
                    this.label = 1;
                    removeViewHistory = new KMoreLiveMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).removeViewHistory(req, this);
                    if (removeViewHistory != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    KRemoveViewHistoryReq kRemoveViewHistoryReq = (KRemoveViewHistoryReq) this.L$2;
                    ResultKt.throwOnFailure($result);
                    removeViewHistory = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            KRemoveViewHistoryResp kRemoveViewHistoryResp = (KRemoveViewHistoryResp) removeViewHistory;
            return state.override(new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LiveRoomHistoryState.Success invokeSuspend$lambda$0$0;
                    invokeSuspend$lambda$0$0 = LiveRoomHistoryViewModel$machine$1$1$3.invokeSuspend$lambda$0$0((LiveRoomHistoryState) obj);
                    return invokeSuspend$lambda$0$0;
                }
            });
        } catch (KMossException e) {
            return state.override(new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LiveRoomHistoryState.Error invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = LiveRoomHistoryViewModel$machine$1$1$3.invokeSuspend$lambda$1(e, (LiveRoomHistoryState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomHistoryState.Success invokeSuspend$lambda$0$0(LiveRoomHistoryState $this$override) {
        return LiveRoomHistoryState.Success.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomHistoryState.Error invokeSuspend$lambda$1(KMossException $e, LiveRoomHistoryState $this$override) {
        String message = $e.getMessage();
        if (message == null) {
            message = "unknown";
        }
        return new LiveRoomHistoryState.Error(message);
    }
}