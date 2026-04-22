package kntr.app.tribee.steam.viewmodel;

import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.base.TribeeSteamBindingContainer;
import kntr.app.tribee.base.TribeeSteamBindingState;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.steam.service.TribeeSteamDataService;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "<unused var>", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$UnbindSteamAccount;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$3", f = "TribeeSteamStateMachine.kt", i = {0, 1, 1}, l = {311, 313}, m = "invokeSuspend", n = {"state", "state", "resultTips"}, s = {"L$0", "L$0", "L$1"}, v = 1)
public final class TribeeSteamStateMachine$1$3$3 extends SuspendLambda implements Function3<TribeeSteamStateAction.UnbindSteamAccount, State<TribeeSteamState>, Continuation<? super ChangedState<? extends TribeeSteamState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeSteamStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamStateMachine$1$3$3(TribeeSteamStateMachine tribeeSteamStateMachine, Continuation<? super TribeeSteamStateMachine$1$3$3> continuation) {
        super(3, continuation);
        this.this$0 = tribeeSteamStateMachine;
    }

    public final Object invoke(TribeeSteamStateAction.UnbindSteamAccount unbindSteamAccount, State<TribeeSteamState> state, Continuation<? super ChangedState<? extends TribeeSteamState>> continuation) {
        TribeeSteamStateMachine$1$3$3 tribeeSteamStateMachine$1$3$3 = new TribeeSteamStateMachine$1$3$3(this.this$0, continuation);
        tribeeSteamStateMachine$1$3$3.L$0 = state;
        return tribeeSteamStateMachine$1$3$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object string;
        String resultTips;
        final Exception e;
        TribeeSteamDataService tribeeSteamDataService;
        final String resultTips2;
        final State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.label = 1;
                string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_33(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string == coroutine_suspended) {
                    return coroutine_suspended;
                }
                resultTips = (String) string;
                try {
                    tribeeSteamDataService = this.this$0.dataService;
                    this.L$0 = state;
                    this.L$1 = resultTips;
                    this.label = 2;
                    if (TribeeSteamDataService.unbindSteamEntitlement$default(tribeeSteamDataService, null, (Continuation) this, 1, null) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    resultTips2 = resultTips;
                    TribeeSteamBindingContainer.INSTANCE.putSteamUnbindResult(TribeeSteamBindingState.SUCCESS);
                    return state.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeSteamState.InitialState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeSteamStateMachine$1$3$3.invokeSuspend$lambda$0(resultTips2, (TribeeSteamState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } catch (Exception e2) {
                    e = e2;
                    KLog_androidKt.getKLog().e("TribeeSteamStateMachine", "unbind error", e);
                    TribeeSteamBindingContainer.INSTANCE.putSteamUnbindResult(TribeeSteamBindingState.FAILURE);
                    return state.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$3$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            TribeeSteamState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = TribeeSteamStateMachine$1$3$3.invokeSuspend$lambda$1(state, e, (TribeeSteamState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
            case 1:
                ResultKt.throwOnFailure($result);
                string = $result;
                resultTips = (String) string;
                tribeeSteamDataService = this.this$0.dataService;
                this.L$0 = state;
                this.L$1 = resultTips;
                this.label = 2;
                if (TribeeSteamDataService.unbindSteamEntitlement$default(tribeeSteamDataService, null, (Continuation) this, 1, null) != coroutine_suspended) {
                }
                break;
            case 2:
                resultTips2 = (String) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    TribeeSteamBindingContainer.INSTANCE.putSteamUnbindResult(TribeeSteamBindingState.SUCCESS);
                    return state.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeSteamState.InitialState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeSteamStateMachine$1$3$3.invokeSuspend$lambda$0(resultTips2, (TribeeSteamState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } catch (Exception e3) {
                    e = e3;
                    KLog_androidKt.getKLog().e("TribeeSteamStateMachine", "unbind error", e);
                    TribeeSteamBindingContainer.INSTANCE.putSteamUnbindResult(TribeeSteamBindingState.FAILURE);
                    return state.override(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$3$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            TribeeSteamState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = TribeeSteamStateMachine$1$3$3.invokeSuspend$lambda$1(state, e, (TribeeSteamState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState.InitialState invokeSuspend$lambda$0(String $resultTips, TribeeSteamState $this$override) {
        return new TribeeSteamState.InitialState(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create($resultTips), "unbind"), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState invokeSuspend$lambda$1(State $state, Exception $e, TribeeSteamState $this$override) {
        return ((TribeeSteamState) $state.getSnapshot()).copyBy(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null), null, 2, null), ((TribeeSteamState) $state.getSnapshot()).getRequestingActions());
    }
}