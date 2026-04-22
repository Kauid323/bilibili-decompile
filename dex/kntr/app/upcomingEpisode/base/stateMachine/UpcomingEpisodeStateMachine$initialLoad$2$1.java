package kntr.app.upcomingEpisode.base.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.PageStatus;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpcomingEpisodeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$initialLoad$2$1", f = "UpcomingEpisodeStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UpcomingEpisodeStateMachine$initialLoad$2$1 extends SuspendLambda implements Function2<State<UpcomingEpisodeData>, Continuation<? super ChangedState<? extends UpcomingEpisodeData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpcomingEpisodeStateMachine$initialLoad$2$1(Continuation<? super UpcomingEpisodeStateMachine$initialLoad$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> upcomingEpisodeStateMachine$initialLoad$2$1 = new UpcomingEpisodeStateMachine$initialLoad$2$1(continuation);
        upcomingEpisodeStateMachine$initialLoad$2$1.L$0 = obj;
        return upcomingEpisodeStateMachine$initialLoad$2$1;
    }

    public final Object invoke(State<UpcomingEpisodeData> state, Continuation<? super ChangedState<UpcomingEpisodeData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$initialLoad$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        UpcomingEpisodeData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = UpcomingEpisodeStateMachine$initialLoad$2$1.invokeSuspend$lambda$0((UpcomingEpisodeData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpcomingEpisodeData invokeSuspend$lambda$0(UpcomingEpisodeData $this$mutate) {
        UpcomingEpisodeData copy;
        KLog_androidKt.getKLog().i("UpcomingEpisodeStateMachine", "pageStatus change to PageStatus.InitSuccess");
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.hasRequestCalendarApi : false, (r20 & 2) != 0 ? $this$mutate.calendarType : null, (r20 & 4) != 0 ? $this$mutate.cardListMap : null, (r20 & 8) != 0 ? $this$mutate.pointTypeMap : null, (r20 & 16) != 0 ? $this$mutate.pageSet : null, (r20 & 32) != 0 ? $this$mutate.requestModel : null, (r20 & 64) != 0 ? $this$mutate.pageStatus : PageStatus.InitSuccess.INSTANCE, (r20 & 128) != 0 ? $this$mutate.recommendData : null, (r20 & 256) != 0 ? $this$mutate.feature : false);
        return copy;
    }
}