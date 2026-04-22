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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/TribeePublishState;", "action", "Lkntr/app/tribee/publish/TribeePublishAction$Publish;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/publish/TribeePublishContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$1$2$1", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishStateMachine$handlePublish$1$2$1 extends SuspendLambda implements Function3<TribeePublishAction.Publish, State<TribeePublishContent>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handlePublish$1$2$1(Continuation<? super TribeePublishStateMachine$handlePublish$1$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeePublishAction.Publish publish, State<TribeePublishContent> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        TribeePublishStateMachine$handlePublish$1$2$1 tribeePublishStateMachine$handlePublish$1$2$1 = new TribeePublishStateMachine$handlePublish$1$2$1(continuation);
        tribeePublishStateMachine$handlePublish$1$2$1.L$0 = publish;
        tribeePublishStateMachine$handlePublish$1$2$1.L$1 = state;
        return tribeePublishStateMachine$handlePublish$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeePublishAction.Publish action = (TribeePublishAction.Publish) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (TribeePublishStateMachineKt.getNeedConfirmPublish(((TribeePublishContent) state.getSnapshot()).getContent()) && !action.getStrongPublish()) {
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$1$2$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeePublishContent copy$default;
                            copy$default = TribeePublishContent.copy$default((TribeePublishContent) obj, null, null, null, null, null, null, false, null, false, false, false, true, null, 6143, null);
                            return copy$default;
                        }
                    });
                }
                return state.override(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$1$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        TribeePublishUploading invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = TribeePublishStateMachine$handlePublish$1$2$1.invokeSuspend$lambda$1((TribeePublishContent) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishUploading invokeSuspend$lambda$1(TribeePublishContent $this$override) {
        TribeePublishContent copy;
        copy = $this$override.copy((r28 & 1) != 0 ? $this$override.title : null, (r28 & 2) != 0 ? $this$override.content : null, (r28 & 4) != 0 ? $this$override.tribeeInfo : null, (r28 & 8) != 0 ? $this$override.limitInfo : null, (r28 & 16) != 0 ? $this$override.categories : null, (r28 & 32) != 0 ? $this$override.selectedCategory : null, (r28 & 64) != 0 ? $this$override.validLimitInfo : false, (r28 & 128) != 0 ? $this$override.settingItems : null, (r28 & 256) != 0 ? $this$override.sendToFollowing : false, (r28 & 512) != 0 ? $this$override.fromDraft : false, (r28 & 1024) != 0 ? $this$override.fromEdit : false, (r28 & 2048) != 0 ? $this$override.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? $this$override.toast : null);
        return new TribeePublishUploading(copy);
    }
}