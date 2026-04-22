package kntr.app.tribee.repost.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KRepostOpus2TribeeOptionsResp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.consume.TribeePreference;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.repost.action.TribeeRepostUIAction;
import kntr.app.tribee.repost.service.TribeeRepostDataService;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeRepostStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostLoadingState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$1$1", f = "TribeeRepostStateMachine.kt", i = {0}, l = {65}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class TribeeRepostStateMachine$1$1$1 extends SuspendLambda implements Function2<State<TribeeRepostState.TribeeRepostLoadingState>, Continuation<? super ChangedState<? extends TribeeRepostState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeeRepostStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeRepostStateMachine$1$1$1(TribeeRepostStateMachine tribeeRepostStateMachine, Continuation<? super TribeeRepostStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeRepostStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeRepostStateMachine$1$1$1 = new TribeeRepostStateMachine$1$1$1(this.this$0, continuation);
        tribeeRepostStateMachine$1$1$1.L$0 = obj;
        return tribeeRepostStateMachine$1$1$1;
    }

    public final Object invoke(State<TribeeRepostState.TribeeRepostLoadingState> state, Continuation<? super ChangedState<? extends TribeeRepostState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeRepostDataService tribeeRepostDataService;
        Object initialData;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    tribeeRepostDataService = this.this$0.dataService;
                    this.L$0 = state;
                    this.label = 1;
                    initialData = tribeeRepostDataService.initialData(TribeePreference.INSTANCE.getDefaultRepostTribeeId(), (Continuation) this);
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
            final KRepostOpus2TribeeOptionsResp data = (KRepostOpus2TribeeOptionsResp) initialData;
            return state.override(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$1$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = TribeeRepostStateMachine$1$1$1.invokeSuspend$lambda$0(data, (TribeeRepostState.TribeeRepostLoadingState) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeRepostStateMachine", "initial error! (" + e.getMessage() + ")");
            return state.override(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$1$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    TribeeRepostState.TribeeRepostErrorState invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = TribeeRepostStateMachine$1$1$1.invokeSuspend$lambda$1(e, (TribeeRepostState.TribeeRepostLoadingState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$0(KRepostOpus2TribeeOptionsResp $data, TribeeRepostState.TribeeRepostLoadingState $this$override) {
        KRepostOpus2TribeeOptionsResp.KRenderParams params = $data.getParams();
        Long valueOf = params != null ? Long.valueOf(params.getDefaultTribeeId()) : null;
        KRepostOpus2TribeeOptionsResp.KRenderParams params2 = $data.getParams();
        return new TribeeRepostState.TribeeRepostContentState(null, $data, null, false, null, null, TribeePreference.INSTANCE.getEnableRepostToFollowing(), TribeePreference.INSTANCE.getEnableRepostWithSource(), null, null, TuplesKt.to(valueOf, params2 != null ? params2.getDefaultTribeeName() : null), null, true, false, 11069, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeRepostState.TribeeRepostErrorState invokeSuspend$lambda$1(Exception $e, TribeeRepostState.TribeeRepostLoadingState $this$override) {
        return new TribeeRepostState.TribeeRepostErrorState(new TribeeRepostUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
    }
}