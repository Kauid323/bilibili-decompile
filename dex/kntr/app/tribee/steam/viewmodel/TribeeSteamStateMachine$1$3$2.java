package kntr.app.tribee.steam.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import java.util.ListIterator;
import kntr.app.tribee.steam.service.TribeeSteamDataService;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "action", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$LaunchPolling;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$2", f = "TribeeSteamStateMachine.kt", i = {0, 0, 1, 1, 2, 2, 2, 2}, l = {290, 294, 302}, m = "invokeSuspend", n = {"action", "state", "action", "state", "action", "state", "newState", "nextPollingAction"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class TribeeSteamStateMachine$1$3$2 extends SuspendLambda implements Function3<TribeeSteamStateAction.LaunchPolling, State<TribeeSteamState>, Continuation<? super ChangedState<? extends TribeeSteamState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TribeeSteamStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamStateMachine$1$3$2(TribeeSteamStateMachine tribeeSteamStateMachine, Continuation<? super TribeeSteamStateMachine$1$3$2> continuation) {
        super(3, continuation);
        this.this$0 = tribeeSteamStateMachine;
    }

    public final Object invoke(TribeeSteamStateAction.LaunchPolling launchPolling, State<TribeeSteamState> state, Continuation<? super ChangedState<? extends TribeeSteamState>> continuation) {
        TribeeSteamStateMachine$1$3$2 tribeeSteamStateMachine$1$3$2 = new TribeeSteamStateMachine$1$3$2(this.this$0, continuation);
        tribeeSteamStateMachine$1$3$2.L$0 = launchPolling;
        tribeeSteamStateMachine$1$3$2.L$1 = state;
        return tribeeSteamStateMachine$1$3$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        TribeeSteamDataService tribeeSteamDataService;
        Object pollingState;
        final TribeeSteamState newState;
        List<TribeeSteamStateAction> requestingActions;
        TribeeSteamStateAction nextPollingAction;
        TribeeSteamStateAction nextPollingAction2;
        TribeeSteamStateAction.LaunchPolling action = (TribeeSteamStateAction.LaunchPolling) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action.getCount() > 1) {
                    this.L$0 = action;
                    this.L$1 = state;
                    this.label = 1;
                    if (DelayKt.delay(5000L, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "polling page , count = " + action.getCount() + ", from state = " + state.getSnapshot());
                tribeeSteamDataService = this.this$0.dataService;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.label = 2;
                pollingState = tribeeSteamDataService.pollingState((TribeeSteamState) state.getSnapshot(), action.getCount(), (Continuation) this);
                if (pollingState == coroutine_suspended) {
                    return coroutine_suspended;
                }
                newState = (TribeeSteamState) pollingState;
                requestingActions = newState.getRequestingActions();
                if (requestingActions != null) {
                    ListIterator<TribeeSteamStateAction> listIterator = requestingActions.listIterator(requestingActions.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            TribeeSteamStateAction previous = listIterator.previous();
                            TribeeSteamStateAction it = previous;
                            r6 = it instanceof TribeeSteamStateAction.LaunchPolling ? previous : null;
                        }
                    }
                    r6 = r6;
                }
                nextPollingAction = r6;
                if (nextPollingAction == null) {
                    KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "polling page , new state = " + newState + ", stop polling");
                    return state.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeSteamState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = TribeeSteamStateMachine$1$3$2.invokeSuspend$lambda$1(TribeeSteamState.this, (TribeeSteamState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
                KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "polling page , new state = " + newState + ", still polling");
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = newState;
                this.L$3 = SpillingKt.nullOutSpilledVariable(nextPollingAction);
                this.label = 3;
                if (this.this$0.dispatch(nextPollingAction, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nextPollingAction2 = nextPollingAction;
                return state.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeSteamState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = TribeeSteamStateMachine$1$3$2.invokeSuspend$lambda$1(TribeeSteamState.this, (TribeeSteamState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d("TribeeSteamStateMachine", "polling page , count = " + action.getCount() + ", from state = " + state.getSnapshot());
                tribeeSteamDataService = this.this$0.dataService;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.label = 2;
                pollingState = tribeeSteamDataService.pollingState((TribeeSteamState) state.getSnapshot(), action.getCount(), (Continuation) this);
                if (pollingState == coroutine_suspended) {
                }
                newState = (TribeeSteamState) pollingState;
                requestingActions = newState.getRequestingActions();
                if (requestingActions != null) {
                }
                nextPollingAction = r6;
                if (nextPollingAction == null) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                pollingState = $result;
                newState = (TribeeSteamState) pollingState;
                requestingActions = newState.getRequestingActions();
                if (requestingActions != null) {
                }
                nextPollingAction = r6;
                if (nextPollingAction == null) {
                }
                break;
            case 3:
                nextPollingAction2 = (TribeeSteamStateAction) this.L$3;
                newState = (TribeeSteamState) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeSteamState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = TribeeSteamStateMachine$1$3$2.invokeSuspend$lambda$1(TribeeSteamState.this, (TribeeSteamState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState invokeSuspend$lambda$1(TribeeSteamState $newState, TribeeSteamState $this$override) {
        return $newState;
    }
}