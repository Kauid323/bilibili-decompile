package kntr.app.tribee.publish;

import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.tribee.publish.draft.TribeeDraftService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "<unused var>", "Lkntr/app/tribee/publish/TribeePublishAction$ClearDraft;", "stateSnapshot", "Lkntr/app/tribee/publish/TribeePublishContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishStateMachine$handleDraft$2", f = "TribeePublishStateMachine.kt", i = {0}, l = {160}, m = "invokeSuspend", n = {"stateSnapshot"}, s = {"L$0"}, v = 1)
public final class TribeePublishStateMachine$handleDraft$2 extends SuspendLambda implements Function3<TribeePublishAction.ClearDraft, TribeePublishContent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeePublishStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishStateMachine$handleDraft$2(TribeePublishStateMachine tribeePublishStateMachine, Continuation<? super TribeePublishStateMachine$handleDraft$2> continuation) {
        super(3, continuation);
        this.this$0 = tribeePublishStateMachine;
    }

    public final Object invoke(TribeePublishAction.ClearDraft clearDraft, TribeePublishContent tribeePublishContent, Continuation<? super Unit> continuation) {
        TribeePublishStateMachine$handleDraft$2 tribeePublishStateMachine$handleDraft$2 = new TribeePublishStateMachine$handleDraft$2(this.this$0, continuation);
        tribeePublishStateMachine$handleDraft$2.L$0 = tribeePublishContent;
        return tribeePublishStateMachine$handleDraft$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeDraftService tribeeDraftService;
        TribeePublishContent stateSnapshot = (TribeePublishContent) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                tribeeDraftService = this.this$0.draftService;
                this.L$0 = SpillingKt.nullOutSpilledVariable(stateSnapshot);
                this.label = 1;
                if (tribeeDraftService.saveDraft(stateSnapshot.getTribeeInfo(), null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}