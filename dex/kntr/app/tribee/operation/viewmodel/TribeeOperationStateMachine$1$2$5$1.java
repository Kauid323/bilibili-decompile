package kntr.app.tribee.operation.viewmodel;

import com.bapis.bilibili.community.interfacess.cosmoconn.v1.KTribeeManageActionRsp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.operation.common.TribeeToast;
import kntr.app.tribee.operation.viewmodel.TribeeOperationStateAction;
import kntr.app.tribee.operation.viewmodel.TribeeOperationUIAction;
import kntr.app.tribee.operation.viewmodel.service.TribeeOperationDataService;
import kntr.app.tribee.operation.viewmodel.state.TribeeOperationState;
import kntr.app.upcomingEpisode.ConstantsKt;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeOperationStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "action", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$Submit;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$1$2$5$1", f = "TribeeOperationStateMachine.kt", i = {0, 0, 1, 1}, l = {97, ConstantsKt.RESERVATION_CARD_HEIGHT}, m = "invokeSuspend", n = {"state", "selectedTribeeId", "state", "e"}, s = {"L$0", "J$0", "L$0", "L$1"}, v = 1)
public final class TribeeOperationStateMachine$1$2$5$1 extends SuspendLambda implements Function3<TribeeOperationStateAction.Submit, State<TribeeOperationState.TribeeOperationContentState>, Continuation<? super ChangedState<? extends TribeeOperationState>>, Object> {
    long J$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeOperationStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeOperationStateMachine$1$2$5$1(TribeeOperationStateMachine tribeeOperationStateMachine, Continuation<? super TribeeOperationStateMachine$1$2$5$1> continuation) {
        super(3, continuation);
        this.this$0 = tribeeOperationStateMachine;
    }

    public final Object invoke(TribeeOperationStateAction.Submit submit, State<TribeeOperationState.TribeeOperationContentState> state, Continuation<? super ChangedState<? extends TribeeOperationState>> continuation) {
        TribeeOperationStateMachine$1$2$5$1 tribeeOperationStateMachine$1$2$5$1 = new TribeeOperationStateMachine$1$2$5$1(this.this$0, continuation);
        tribeeOperationStateMachine$1$2$5$1.L$0 = state;
        return tribeeOperationStateMachine$1$2$5$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object create$default;
        TribeeOperationDataService tribeeOperationDataService;
        Object submit;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            this.L$0 = state;
            this.L$1 = SpillingKt.nullOutSpilledVariable(e);
            this.label = 2;
            create$default = TribeeToast.Companion.create$default(TribeeToast.Companion, e, null, (Continuation) this, 2, null);
            if (create$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Long selectedTribeeId = ((TribeeOperationState.TribeeOperationContentState) state.getSnapshot()).getSelectedTribeeId();
                if (selectedTribeeId == null) {
                    return state.noChange();
                }
                long selectedTribeeId2 = selectedTribeeId.longValue();
                tribeeOperationDataService = this.this$0.dataService;
                this.L$0 = state;
                this.J$0 = selectedTribeeId2;
                this.label = 1;
                submit = tribeeOperationDataService.submit(selectedTribeeId2, ((TribeeOperationState.TribeeOperationContentState) state.getSnapshot()).getSelectedSendTypeItem().getType().getValue(), ((TribeeOperationState.TribeeOperationContentState) state.getSnapshot()).getSelectedSendCount(), (Continuation) this);
                if (submit == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                long j = this.J$0;
                ResultKt.throwOnFailure($result);
                submit = $result;
                break;
            case 2:
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure($result);
                create$default = $result;
                final TribeeToast errorTips = (TribeeToast) create$default;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$1$2$5$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        TribeeOperationState.TribeeOperationContentState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = TribeeOperationStateMachine$1$2$5$1.invokeSuspend$lambda$1(TribeeToast.this, (TribeeOperationState.TribeeOperationContentState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final String resultTips = ((KTribeeManageActionRsp) submit).getMessage();
        return state.mutate(new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$1$2$5$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                TribeeOperationState.TribeeOperationContentState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = TribeeOperationStateMachine$1$2$5$1.invokeSuspend$lambda$0(resultTips, (TribeeOperationState.TribeeOperationContentState) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeOperationState.TribeeOperationContentState invokeSuspend$lambda$0(String $resultTips, TribeeOperationState.TribeeOperationContentState $this$mutate) {
        return TribeeOperationState.TribeeOperationContentState.copy$default($this$mutate, new TribeeOperationUIAction.Finish($resultTips), null, null, 0L, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeOperationState.TribeeOperationContentState invokeSuspend$lambda$1(TribeeToast $errorTips, TribeeOperationState.TribeeOperationContentState $this$mutate) {
        return TribeeOperationState.TribeeOperationContentState.copy$default($this$mutate, new TribeeOperationUIAction.ToastTips($errorTips), null, null, 0L, null, 30, null);
    }
}