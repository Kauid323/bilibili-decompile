package kntr.app.tribee.invite.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeAllResp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.invite.service.TribeeInviteDataService;
import kntr.app.tribee.invite.state.TribeeInviteState;
import kntr.app.tribee.invite.viewmodel.TribeeInviteUIAction;
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
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeInviteStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/invite/state/TribeeInviteState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/invite/state/TribeeInviteState$TribeeInviteInitiateState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.invite.viewmodel.TribeeInviteStateMachine$1$1$1", f = "TribeeInviteStateMachine.kt", i = {0}, l = {29}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class TribeeInviteStateMachine$1$1$1 extends SuspendLambda implements Function2<State<TribeeInviteState.TribeeInviteInitiateState>, Continuation<? super ChangedState<? extends TribeeInviteState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeeInviteStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeInviteStateMachine$1$1$1(TribeeInviteStateMachine tribeeInviteStateMachine, Continuation<? super TribeeInviteStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeInviteStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeInviteStateMachine$1$1$1 = new TribeeInviteStateMachine$1$1$1(this.this$0, continuation);
        tribeeInviteStateMachine$1$1$1.L$0 = obj;
        return tribeeInviteStateMachine$1$1$1;
    }

    public final Object invoke(State<TribeeInviteState.TribeeInviteInitiateState> state, Continuation<? super ChangedState<? extends TribeeInviteState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeInviteDataService tribeeInviteDataService;
        Object initialData;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    tribeeInviteDataService = this.this$0.dataService;
                    this.L$0 = state;
                    this.label = 1;
                    initialData = tribeeInviteDataService.initialData((Continuation) this);
                    if (initialData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    initialData = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final KTribeeInviteCodeAllResp data = (KTribeeInviteCodeAllResp) initialData;
            return state.override(new Function1() { // from class: kntr.app.tribee.invite.viewmodel.TribeeInviteStateMachine$1$1$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    TribeeInviteState.TribeeInviteContentState invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = TribeeInviteStateMachine$1$1$1.invokeSuspend$lambda$0(data, (TribeeInviteState.TribeeInviteInitiateState) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeInviteStateMachine", "initial error! (" + e.getMessage() + ")");
            return state.override(new Function1() { // from class: kntr.app.tribee.invite.viewmodel.TribeeInviteStateMachine$1$1$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    TribeeInviteState.TribeeInviteErrorState invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = TribeeInviteStateMachine$1$1$1.invokeSuspend$lambda$1(e, (TribeeInviteState.TribeeInviteInitiateState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeInviteState.TribeeInviteContentState invokeSuspend$lambda$0(KTribeeInviteCodeAllResp $data, TribeeInviteState.TribeeInviteInitiateState $this$override) {
        return new TribeeInviteState.TribeeInviteContentState($data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeInviteState.TribeeInviteErrorState invokeSuspend$lambda$1(Exception $e, TribeeInviteState.TribeeInviteInitiateState $this$override) {
        return new TribeeInviteState.TribeeInviteErrorState(new TribeeInviteUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
    }
}