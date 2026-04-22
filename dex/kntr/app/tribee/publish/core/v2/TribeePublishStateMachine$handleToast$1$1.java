package kntr.app.tribee.publish.core.v2;

import com.bilibili.blens.BSimpleLens;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "<unused var>", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$ConsumeToast;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handleToast$1$1", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishStateMachine$handleToast$1$1 extends SuspendLambda implements Function3<TribeePublishAction.ConsumeToast, State<TribeePublishState>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handleToast$1$1(Continuation<? super TribeePublishStateMachine$handleToast$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeePublishAction.ConsumeToast consumeToast, State<TribeePublishState> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        TribeePublishStateMachine$handleToast$1$1 tribeePublishStateMachine$handleToast$1$1 = new TribeePublishStateMachine$handleToast$1$1(continuation);
        tribeePublishStateMachine$handleToast$1$1.L$0 = state;
        return tribeePublishStateMachine$handleToast$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handleToast$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeePublishState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeePublishStateMachine$handleToast$1$1.invokeSuspend$lambda$0((TribeePublishState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishState invokeSuspend$lambda$0(TribeePublishState $this$override) {
        TribeePublishState tribeePublishState;
        BSimpleLens<TribeePublishState, String> editToast = $this$override.getEditToast();
        return (editToast == null || (tribeePublishState = (TribeePublishState) editToast.set($this$override, (Object) null)) == null) ? $this$override : tribeePublishState;
    }
}