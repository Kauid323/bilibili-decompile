package kntr.app.upcomingEpisode.base.handler;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.TrackerAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpcomingEpisodeTrackerHandler.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "<unused var>", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.base.handler.UpcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1", f = "UpcomingEpisodeTrackerHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UpcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1 extends SuspendLambda implements Function3<UpcomingEpisodeAction, UpcomingEpisodeData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1(Continuation<? super UpcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(UpcomingEpisodeAction upcomingEpisodeAction, UpcomingEpisodeData upcomingEpisodeData, Continuation<? super Unit> continuation) {
        UpcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1 upcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1 = new UpcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1(continuation);
        upcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1.L$0 = upcomingEpisodeAction;
        return upcomingEpisodeTrackerHandlerKt$bindTrackerAction$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        UpcomingEpisodeAction action = (UpcomingEpisodeAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action instanceof TrackerAction.UpcomingEpisodeCalendarClick) {
                    UpcomingEpisodeTrackerHandlerKt.handleCalendarClick((TrackerAction.UpcomingEpisodeCalendarClick) action);
                } else if (action instanceof TrackerAction.UpcomingEpisodeCalendarShow) {
                    UpcomingEpisodeTrackerHandlerKt.handleCalendarShow((TrackerAction.UpcomingEpisodeCalendarShow) action);
                } else if (action instanceof TrackerAction.UpcomingEpisodeCardClick) {
                    UpcomingEpisodeTrackerHandlerKt.handleCardClick((TrackerAction.UpcomingEpisodeCardClick) action);
                } else if (action instanceof TrackerAction.UpcomingEpisodeCardShow) {
                    UpcomingEpisodeTrackerHandlerKt.handleCardShow((TrackerAction.UpcomingEpisodeCardShow) action);
                } else if (action instanceof TrackerAction.UpComingEpisodeRecommendReservationCardShow) {
                    UpcomingEpisodeTrackerHandlerKt.handleRecommendReservationShow((TrackerAction.UpComingEpisodeRecommendReservationCardShow) action);
                } else if (action instanceof TrackerAction.UpComingEpisodeRecommendReservationCardClick) {
                    UpcomingEpisodeTrackerHandlerKt.handleRecommendReservationClick((TrackerAction.UpComingEpisodeRecommendReservationCardClick) action);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}