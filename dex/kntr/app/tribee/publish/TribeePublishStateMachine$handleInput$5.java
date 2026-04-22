package kntr.app.tribee.publish;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.publish.TribeePublishAction;
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

/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/TribeePublishState;", "action", "Lkntr/app/tribee/publish/TribeePublishAction$SwitchSendToFollowing;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/publish/TribeePublishContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishStateMachine$handleInput$5", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeePublishStateMachine$handleInput$5 extends SuspendLambda implements Function3<TribeePublishAction.SwitchSendToFollowing, State<TribeePublishContent>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handleInput$5(Continuation<? super TribeePublishStateMachine$handleInput$5> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeePublishAction.SwitchSendToFollowing switchSendToFollowing, State<TribeePublishContent> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        TribeePublishStateMachine$handleInput$5 tribeePublishStateMachine$handleInput$5 = new TribeePublishStateMachine$handleInput$5(continuation);
        tribeePublishStateMachine$handleInput$5.L$0 = switchSendToFollowing;
        tribeePublishStateMachine$handleInput$5.L$1 = state;
        return tribeePublishStateMachine$handleInput$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final TribeePublishAction.SwitchSendToFollowing action = (TribeePublishAction.SwitchSendToFollowing) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$handleInput$5$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeePublishContent invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeePublishStateMachine$handleInput$5.invokeSuspend$lambda$0(TribeePublishAction.SwitchSendToFollowing.this, (TribeePublishContent) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$0(TribeePublishAction.SwitchSendToFollowing $action, TribeePublishContent $this$mutate) {
        TribeePublishContent copy;
        copy = $this$mutate.copy((r28 & 1) != 0 ? $this$mutate.title : null, (r28 & 2) != 0 ? $this$mutate.content : null, (r28 & 4) != 0 ? $this$mutate.tribeeInfo : null, (r28 & 8) != 0 ? $this$mutate.limitInfo : null, (r28 & 16) != 0 ? $this$mutate.categories : null, (r28 & 32) != 0 ? $this$mutate.selectedCategory : null, (r28 & 64) != 0 ? $this$mutate.validLimitInfo : false, (r28 & 128) != 0 ? $this$mutate.settingItems : null, (r28 & 256) != 0 ? $this$mutate.sendToFollowing : $action.getEnabled(), (r28 & 512) != 0 ? $this$mutate.fromDraft : false, (r28 & 1024) != 0 ? $this$mutate.fromEdit : false, (r28 & 2048) != 0 ? $this$mutate.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? $this$mutate.toast : null);
        return copy;
    }
}