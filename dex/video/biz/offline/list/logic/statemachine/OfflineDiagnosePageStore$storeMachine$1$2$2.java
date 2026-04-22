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
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineDiagnoseState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState;", "event", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$VideosLoaded;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState$Loading;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$storeMachine$1$2$2", f = "OfflineDiagnosePageStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineDiagnosePageStore$storeMachine$1$2$2 extends SuspendLambda implements Function3<OfflineDiagnosePageEvent.VideosLoaded, State<OfflineDiagnoseState.Loading>, Continuation<? super ChangedState<? extends OfflineDiagnoseState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineDiagnosePageStore$storeMachine$1$2$2(Continuation<? super OfflineDiagnosePageStore$storeMachine$1$2$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OfflineDiagnosePageEvent.VideosLoaded videosLoaded, State<OfflineDiagnoseState.Loading> state, Continuation<? super ChangedState<? extends OfflineDiagnoseState>> continuation) {
        OfflineDiagnosePageStore$storeMachine$1$2$2 offlineDiagnosePageStore$storeMachine$1$2$2 = new OfflineDiagnosePageStore$storeMachine$1$2$2(continuation);
        offlineDiagnosePageStore$storeMachine$1$2$2.L$0 = videosLoaded;
        offlineDiagnosePageStore$storeMachine$1$2$2.L$1 = state;
        return offlineDiagnosePageStore$storeMachine$1$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final OfflineDiagnosePageEvent.VideosLoaded event = (OfflineDiagnosePageEvent.VideosLoaded) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (event.getVideos().isEmpty()) {
                    return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$storeMachine$1$2$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            OfflineDiagnoseState.Empty invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = OfflineDiagnosePageStore$storeMachine$1$2$2.invokeSuspend$lambda$0((OfflineDiagnoseState.Loading) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$storeMachine$1$2$2$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        OfflineDiagnoseState.Success invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = OfflineDiagnosePageStore$storeMachine$1$2$2.invokeSuspend$lambda$1(OfflineDiagnosePageEvent.VideosLoaded.this, (OfflineDiagnoseState.Loading) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineDiagnoseState.Empty invokeSuspend$lambda$0(OfflineDiagnoseState.Loading $this$override) {
        return OfflineDiagnoseState.Empty.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineDiagnoseState.Success invokeSuspend$lambda$1(OfflineDiagnosePageEvent.VideosLoaded $event, OfflineDiagnoseState.Loading $this$override) {
        return new OfflineDiagnoseState.Success($event.getVideos());
    }
}