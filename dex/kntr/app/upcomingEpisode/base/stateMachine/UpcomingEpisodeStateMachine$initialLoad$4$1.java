package kntr.app.upcomingEpisode.base.stateMachine;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.TrackerAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpcomingEpisodeStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$initialLoad$4$1", f = "UpcomingEpisodeStateMachine.kt", i = {0}, l = {52}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class UpcomingEpisodeStateMachine$initialLoad$4$1 extends SuspendLambda implements Function2<UpcomingEpisodeData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UpcomingEpisodeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpcomingEpisodeStateMachine$initialLoad$4$1(UpcomingEpisodeStateMachine upcomingEpisodeStateMachine, Continuation<? super UpcomingEpisodeStateMachine$initialLoad$4$1> continuation) {
        super(2, continuation);
        this.this$0 = upcomingEpisodeStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> upcomingEpisodeStateMachine$initialLoad$4$1 = new UpcomingEpisodeStateMachine$initialLoad$4$1(this.this$0, continuation);
        upcomingEpisodeStateMachine$initialLoad$4$1.L$0 = obj;
        return upcomingEpisodeStateMachine$initialLoad$4$1;
    }

    public final Object invoke(UpcomingEpisodeData upcomingEpisodeData, Continuation<? super Unit> continuation) {
        return create(upcomingEpisodeData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        UpcomingEpisodeData it = (UpcomingEpisodeData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.label = 1;
                if (this.this$0.dispatch(new TrackerAction.UpcomingEpisodeCalendarShow(it.getCalendarType()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}