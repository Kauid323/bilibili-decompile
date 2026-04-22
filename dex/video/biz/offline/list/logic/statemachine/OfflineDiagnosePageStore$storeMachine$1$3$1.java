package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineDiagnoseState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState;", "event", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$NavToDiagnoseResultBy;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState$Success;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$storeMachine$1$3$1", f = "OfflineDiagnosePageStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineDiagnosePageStore$storeMachine$1$3$1 extends SuspendLambda implements Function3<OfflineDiagnosePageEvent.NavToDiagnoseResultBy, State<OfflineDiagnoseState.Success>, Continuation<? super ChangedState<? extends OfflineDiagnoseState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OfflineDiagnosePageStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDiagnosePageStore$storeMachine$1$3$1(OfflineDiagnosePageStore offlineDiagnosePageStore, Continuation<? super OfflineDiagnosePageStore$storeMachine$1$3$1> continuation) {
        super(3, continuation);
        this.this$0 = offlineDiagnosePageStore;
    }

    public final Object invoke(OfflineDiagnosePageEvent.NavToDiagnoseResultBy navToDiagnoseResultBy, State<OfflineDiagnoseState.Success> state, Continuation<? super ChangedState<? extends OfflineDiagnoseState>> continuation) {
        OfflineDiagnosePageStore$storeMachine$1$3$1 offlineDiagnosePageStore$storeMachine$1$3$1 = new OfflineDiagnosePageStore$storeMachine$1$3$1(this.this$0, continuation);
        offlineDiagnosePageStore$storeMachine$1$3$1.L$0 = navToDiagnoseResultBy;
        offlineDiagnosePageStore$storeMachine$1$3$1.L$1 = state;
        return offlineDiagnosePageStore$storeMachine$1$3$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Router router;
        OfflineDiagnosePageEvent.NavToDiagnoseResultBy event = (OfflineDiagnosePageEvent.NavToDiagnoseResultBy) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                router = this.this$0.router;
                String videoId = event.getVideoId();
                router.launch(UrisKt.toUri("bilibili://offline/cache/diagnose/result?videoId=" + videoId + "&cid=" + event.getCid()));
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}