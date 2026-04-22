package kntr.app.tribee.operation.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeSendInviteCodeOptionsResp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
import kntr.app.tribee.operation.common.TribeeToast;
import kntr.app.tribee.operation.viewmodel.TribeeOperationUIAction;
import kntr.app.tribee.operation.viewmodel.service.TribeeOperationDataService;
import kntr.app.tribee.operation.viewmodel.state.TribeeOperationState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeOperationStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationInitiateState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$1$1$1", f = "TribeeOperationStateMachine.kt", i = {0, 0, 1, 1}, l = {29, 44}, m = "invokeSuspend", n = {"state", "tribeeId", "state", "e"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class TribeeOperationStateMachine$1$1$1 extends SuspendLambda implements Function2<State<TribeeOperationState.TribeeOperationInitiateState>, Continuation<? super ChangedState<? extends TribeeOperationState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeOperationStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeOperationStateMachine$1$1$1(TribeeOperationStateMachine tribeeOperationStateMachine, Continuation<? super TribeeOperationStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeOperationStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeOperationStateMachine$1$1$1 = new TribeeOperationStateMachine$1$1$1(this.this$0, continuation);
        tribeeOperationStateMachine$1$1$1.L$0 = obj;
        return tribeeOperationStateMachine$1$1$1;
    }

    public final Object invoke(State<TribeeOperationState.TribeeOperationInitiateState> state, Continuation<? super ChangedState<? extends TribeeOperationState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object create$default;
        TribeeOperationDataService tribeeOperationDataService;
        Object initialPage;
        final State state = (State) this.L$0;
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
                Long tribeeId = ((TribeeOperationState.TribeeOperationInitiateState) state.getSnapshot()).getSelectedTribeeId();
                if (!(tribeeId != null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                tribeeOperationDataService = this.this$0.dataService;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(tribeeId);
                this.label = 1;
                initialPage = tribeeOperationDataService.initialPage(tribeeId.longValue(), (Continuation) this);
                if (initialPage == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                Long l = (Long) this.L$1;
                ResultKt.throwOnFailure($result);
                initialPage = $result;
                break;
            case 2:
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure($result);
                create$default = $result;
                final TribeeToast tips = (TribeeToast) create$default;
                return state.override(new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$1$1$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        TribeeOperationState.TribeeOperationErrorState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = TribeeOperationStateMachine$1$1$1.invokeSuspend$lambda$1(state, tips, (TribeeOperationState.TribeeOperationInitiateState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final KTribeeSendInviteCodeOptionsResp data = (KTribeeSendInviteCodeOptionsResp) initialPage;
        final KTribeeSendInviteCodeOptionsResp.KInviteTypeItem defaultInviteItem = (KTribeeSendInviteCodeOptionsResp.KInviteTypeItem) CollectionsKt.first(data.getInviteTypeItems());
        return state.override(new Function1() { // from class: kntr.app.tribee.operation.viewmodel.TribeeOperationStateMachine$1$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                TribeeOperationState.TribeeOperationContentState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = TribeeOperationStateMachine$1$1$1.invokeSuspend$lambda$0(data, defaultInviteItem, state, (TribeeOperationState.TribeeOperationInitiateState) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeOperationState.TribeeOperationContentState invokeSuspend$lambda$0(KTribeeSendInviteCodeOptionsResp $data, KTribeeSendInviteCodeOptionsResp.KInviteTypeItem $defaultInviteItem, State $state, TribeeOperationState.TribeeOperationInitiateState $this$override) {
        Object obj;
        boolean z;
        Iterator it = $data.getTribeeList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem it2 = (KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem) obj;
            long id = it2.getId();
            Long selectedTribeeId = ((TribeeOperationState.TribeeOperationInitiateState) $state.getSnapshot()).getSelectedTribeeId();
            if (selectedTribeeId != null && id == selectedTribeeId.longValue()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem = (KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem) obj;
        Long l = (Long) CollectionsKt.firstOrNull($defaultInviteItem.getSendCountOptions());
        return new TribeeOperationState.TribeeOperationContentState(null, $data, $defaultInviteItem, l != null ? l.longValue() : 0L, kTribeeSelectItem, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeOperationState.TribeeOperationErrorState invokeSuspend$lambda$1(State $state, TribeeToast $tips, TribeeOperationState.TribeeOperationInitiateState $this$override) {
        return new TribeeOperationState.TribeeOperationErrorState(((TribeeOperationState.TribeeOperationInitiateState) $state.getSnapshot()).getSelectedTribeeId(), new TribeeOperationUIAction.ToastTips($tips));
    }
}