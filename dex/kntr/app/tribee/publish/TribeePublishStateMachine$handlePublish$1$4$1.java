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
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$1$4$1", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishStateMachine$handlePublish$1$4$1 extends SuspendLambda implements Function3<TribeePublishAction.Publish, State<TribeePublishContent>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handlePublish$1$4$1(Continuation<? super TribeePublishStateMachine$handlePublish$1$4$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeePublishAction.Publish publish, State<TribeePublishContent> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        TribeePublishStateMachine$handlePublish$1$4$1 tribeePublishStateMachine$handlePublish$1$4$1 = new TribeePublishStateMachine$handlePublish$1$4$1(continuation);
        tribeePublishStateMachine$handlePublish$1$4$1.L$0 = publish;
        tribeePublishStateMachine$handlePublish$1$4$1.L$1 = state;
        return tribeePublishStateMachine$handlePublish$1$4$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final TribeePublishAction.Publish action = (TribeePublishAction.Publish) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeePublishContent snapshot = (TribeePublishContent) state.getSnapshot();
                boolean z = false;
                if (snapshot.getContentNotEmpty() && snapshot.getTitle().length() > snapshot.getLimitInfo().getTitleMaxLength()) {
                    String toastOnTitleOverflow = action.getToastOnTitleOverflow();
                    if (!(toastOnTitleOverflow == null || toastOnTitleOverflow.length() == 0)) {
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$1$4$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeePublishContent invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = TribeePublishStateMachine$handlePublish$1$4$1.invokeSuspend$lambda$0(TribeePublishAction.Publish.this, (TribeePublishContent) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    }
                }
                if (snapshot.getContentNotEmpty() && snapshot.getContent().getTextCount() > snapshot.getLimitInfo().getContentMaxLength()) {
                    String toastOnContentOverflow = action.getToastOnContentOverflow();
                    if (toastOnContentOverflow == null || toastOnContentOverflow.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$1$4$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                TribeePublishContent invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = TribeePublishStateMachine$handlePublish$1$4$1.invokeSuspend$lambda$1(TribeePublishAction.Publish.this, (TribeePublishContent) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    }
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$0(TribeePublishAction.Publish $action, TribeePublishContent $this$mutate) {
        TribeePublishContent copy;
        copy = $this$mutate.copy((r28 & 1) != 0 ? $this$mutate.title : null, (r28 & 2) != 0 ? $this$mutate.content : null, (r28 & 4) != 0 ? $this$mutate.tribeeInfo : null, (r28 & 8) != 0 ? $this$mutate.limitInfo : null, (r28 & 16) != 0 ? $this$mutate.categories : null, (r28 & 32) != 0 ? $this$mutate.selectedCategory : null, (r28 & 64) != 0 ? $this$mutate.validLimitInfo : false, (r28 & 128) != 0 ? $this$mutate.settingItems : null, (r28 & 256) != 0 ? $this$mutate.sendToFollowing : false, (r28 & 512) != 0 ? $this$mutate.fromDraft : false, (r28 & 1024) != 0 ? $this$mutate.fromEdit : false, (r28 & 2048) != 0 ? $this$mutate.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? $this$mutate.toast : $action.getToastOnTitleOverflow());
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$1(TribeePublishAction.Publish $action, TribeePublishContent $this$mutate) {
        TribeePublishContent copy;
        copy = $this$mutate.copy((r28 & 1) != 0 ? $this$mutate.title : null, (r28 & 2) != 0 ? $this$mutate.content : null, (r28 & 4) != 0 ? $this$mutate.tribeeInfo : null, (r28 & 8) != 0 ? $this$mutate.limitInfo : null, (r28 & 16) != 0 ? $this$mutate.categories : null, (r28 & 32) != 0 ? $this$mutate.selectedCategory : null, (r28 & 64) != 0 ? $this$mutate.validLimitInfo : false, (r28 & 128) != 0 ? $this$mutate.settingItems : null, (r28 & 256) != 0 ? $this$mutate.sendToFollowing : false, (r28 & 512) != 0 ? $this$mutate.fromDraft : false, (r28 & 1024) != 0 ? $this$mutate.fromEdit : false, (r28 & 2048) != 0 ? $this$mutate.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? $this$mutate.toast : $action.getToastOnContentOverflow());
        return copy;
    }
}