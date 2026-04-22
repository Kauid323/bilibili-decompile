package kntr.app.upcomingEpisode.base.handler;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestParam;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchCalendarHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "action", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction$WatchCalendar;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$2$1", f = "WatchCalendarHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchCalendarHandlerKt$bindCalendarAction$2$1 extends SuspendLambda implements Function3<UpcomingEpisodeAction.WatchCalendar, State<UpcomingEpisodeData>, Continuation<? super ChangedState<? extends UpcomingEpisodeData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchCalendarHandlerKt$bindCalendarAction$2$1(Continuation<? super WatchCalendarHandlerKt$bindCalendarAction$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(UpcomingEpisodeAction.WatchCalendar watchCalendar, State<UpcomingEpisodeData> state, Continuation<? super ChangedState<UpcomingEpisodeData>> continuation) {
        WatchCalendarHandlerKt$bindCalendarAction$2$1 watchCalendarHandlerKt$bindCalendarAction$2$1 = new WatchCalendarHandlerKt$bindCalendarAction$2$1(continuation);
        watchCalendarHandlerKt$bindCalendarAction$2$1.L$0 = watchCalendar;
        watchCalendarHandlerKt$bindCalendarAction$2$1.L$1 = state;
        return watchCalendarHandlerKt$bindCalendarAction$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final UpcomingEpisodeAction.WatchCalendar action = (UpcomingEpisodeAction.WatchCalendar) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final RequestParam.WatchCalendarReqParam watchCalendarReqParam = new RequestParam.WatchCalendarReqParam(action.getCalendarTimeRange());
                return state.mutate(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        UpcomingEpisodeData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = WatchCalendarHandlerKt$bindCalendarAction$2$1.invokeSuspend$lambda$0(UpcomingEpisodeAction.WatchCalendar.this, watchCalendarReqParam, (UpcomingEpisodeData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpcomingEpisodeData invokeSuspend$lambda$0(final UpcomingEpisodeAction.WatchCalendar $action, final RequestParam.WatchCalendarReqParam $watchCalendarReqParam, UpcomingEpisodeData $this$mutate) {
        return (UpcomingEpisodeData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt$bindCalendarAction$2$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = WatchCalendarHandlerKt$bindCalendarAction$2$1.invokeSuspend$lambda$0$0(UpcomingEpisodeAction.WatchCalendar.this, $watchCalendarReqParam, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(UpcomingEpisodeAction.WatchCalendar $action, RequestParam.WatchCalendarReqParam $watchCalendarReqParam, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getState(RequestModelLensKt.getWatchCalendarReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), RequestStatus.Loading.INSTANCE);
        $this$copy.set(RequestStateLensKt.getFrom(RequestModelLensKt.getWatchCalendarReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), $action.getRequestFrom());
        $this$copy.set(RequestStateLensKt.getParam(RequestModelLensKt.getWatchCalendarReqState(UpcomingEpisodeDataLensKt.getRequestModel(UpcomingEpisodeData.Companion))), $watchCalendarReqParam);
        return Unit.INSTANCE;
    }
}