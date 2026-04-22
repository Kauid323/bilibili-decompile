package kntr.app.tribee.publish;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.tribee.publish.draft.TribeeDraftService;
import kntr.app.tribee.publish.service.PublishResult;
import kntr.app.tribee.publish.service.TribeePublishService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/TribeePublishState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/publish/TribeePublishUploading;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$2$1", f = "TribeePublishStateMachine.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {208, 210, 211}, m = "invokeSuspend", n = {"state", "snapshot", "state", "snapshot", "result", "$i$a$-fold-TribeePublishStateMachine$handlePublish$2$1$1", "state", "snapshot", "result", "$i$a$-fold-TribeePublishStateMachine$handlePublish$2$1$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class TribeePublishStateMachine$handlePublish$2$1 extends SuspendLambda implements Function2<State<TribeePublishUploading>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TribeePublishStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishStateMachine$handlePublish$2$1(TribeePublishStateMachine tribeePublishStateMachine, Continuation<? super TribeePublishStateMachine$handlePublish$2$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeePublishStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeePublishStateMachine$handlePublish$2$1 = new TribeePublishStateMachine$handlePublish$2$1(this.this$0, continuation);
        tribeePublishStateMachine$handlePublish$2$1.L$0 = obj;
        return tribeePublishStateMachine$handlePublish$2$1;
    }

    public final Object invoke(State<TribeePublishUploading> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        TribeePublishContent snapshot;
        TribeePublishService tribeePublishService;
        Object mo927publishgIAlus;
        TribeePublishStateMachine tribeePublishStateMachine;
        final Throwable it;
        PublishResult result;
        TribeePublishContent snapshot2;
        int i;
        TribeeDraftService tribeeDraftService;
        TribeeInfo tribeeInfo;
        final PublishResult result2;
        TribeePublishContent snapshot3;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                snapshot = ((TribeePublishUploading) state.getSnapshot()).getContent();
                tribeePublishService = this.this$0.publishService;
                this.L$0 = state;
                this.L$1 = snapshot;
                this.label = 1;
                mo927publishgIAlus = tribeePublishService.mo927publishgIAlus(snapshot, (Continuation) this);
                if (mo927publishgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                tribeePublishStateMachine = this.this$0;
                it = Result.m2639exceptionOrNullimpl(mo927publishgIAlus);
                if (it != null) {
                    result = (PublishResult) mo927publishgIAlus;
                    TribeePublishAction.TrackerAction.PublishSuccessClick publishSuccessClick = new TribeePublishAction.TrackerAction.PublishSuccessClick("tribee");
                    this.L$0 = state;
                    this.L$1 = snapshot;
                    this.L$2 = tribeePublishStateMachine;
                    this.L$3 = result;
                    this.I$0 = 0;
                    this.label = 2;
                    if (tribeePublishStateMachine.dispatch(publishSuccessClick, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    snapshot2 = snapshot;
                    i = 0;
                    tribeeDraftService = tribeePublishStateMachine.draftService;
                    tribeeInfo = snapshot2.getTribeeInfo();
                    this.L$0 = state;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot2);
                    this.L$2 = result;
                    this.L$3 = null;
                    this.I$0 = i;
                    this.label = 3;
                    if (tribeeDraftService.saveDraft(tribeeInfo, null, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    result2 = result;
                    snapshot3 = snapshot2;
                    return state.override(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$2$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeePublishSucceed invokeSuspend$lambda$0$0;
                            invokeSuspend$lambda$0$0 = TribeePublishStateMachine$handlePublish$2$1.invokeSuspend$lambda$0$0(PublishResult.this, (TribeePublishUploading) obj);
                            return invokeSuspend$lambda$0$0;
                        }
                    });
                }
                return state.override(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        TribeePublishFailed invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = TribeePublishStateMachine$handlePublish$2$1.invokeSuspend$lambda$1$0(it, (TribeePublishUploading) obj);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            case 1:
                snapshot = (TribeePublishContent) this.L$1;
                ResultKt.throwOnFailure($result);
                mo927publishgIAlus = ((Result) $result).m2645unboximpl();
                tribeePublishStateMachine = this.this$0;
                it = Result.m2639exceptionOrNullimpl(mo927publishgIAlus);
                if (it != null) {
                }
                break;
            case 2:
                i = this.I$0;
                result = (PublishResult) this.L$3;
                tribeePublishStateMachine = (TribeePublishStateMachine) this.L$2;
                snapshot2 = (TribeePublishContent) this.L$1;
                ResultKt.throwOnFailure($result);
                tribeeDraftService = tribeePublishStateMachine.draftService;
                tribeeInfo = snapshot2.getTribeeInfo();
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot2);
                this.L$2 = result;
                this.L$3 = null;
                this.I$0 = i;
                this.label = 3;
                if (tribeeDraftService.saveDraft(tribeeInfo, null, this) != coroutine_suspended) {
                }
                break;
            case 3:
                int i2 = this.I$0;
                result2 = (PublishResult) this.L$2;
                snapshot3 = (TribeePublishContent) this.L$1;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.tribee.publish.TribeePublishStateMachine$handlePublish$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeePublishSucceed invokeSuspend$lambda$0$0;
                        invokeSuspend$lambda$0$0 = TribeePublishStateMachine$handlePublish$2$1.invokeSuspend$lambda$0$0(PublishResult.this, (TribeePublishUploading) obj);
                        return invokeSuspend$lambda$0$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishSucceed invokeSuspend$lambda$0$0(PublishResult $result, TribeePublishUploading $this$override) {
        TribeePublishContent copy;
        copy = r1.copy((r28 & 1) != 0 ? r1.title : null, (r28 & 2) != 0 ? r1.content : null, (r28 & 4) != 0 ? r1.tribeeInfo : null, (r28 & 8) != 0 ? r1.limitInfo : null, (r28 & 16) != 0 ? r1.categories : null, (r28 & 32) != 0 ? r1.selectedCategory : null, (r28 & 64) != 0 ? r1.validLimitInfo : false, (r28 & 128) != 0 ? r1.settingItems : null, (r28 & 256) != 0 ? r1.sendToFollowing : false, (r28 & 512) != 0 ? r1.fromDraft : false, (r28 & 1024) != 0 ? r1.fromEdit : false, (r28 & 2048) != 0 ? r1.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? $this$override.getContent().toast : $result.getToast());
        return new TribeePublishSucceed(copy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishFailed invokeSuspend$lambda$1$0(Throwable $it, TribeePublishUploading $this$override) {
        TribeePublishContent copy;
        copy = r1.copy((r28 & 1) != 0 ? r1.title : null, (r28 & 2) != 0 ? r1.content : null, (r28 & 4) != 0 ? r1.tribeeInfo : null, (r28 & 8) != 0 ? r1.limitInfo : null, (r28 & 16) != 0 ? r1.categories : null, (r28 & 32) != 0 ? r1.selectedCategory : null, (r28 & 64) != 0 ? r1.validLimitInfo : false, (r28 & 128) != 0 ? r1.settingItems : null, (r28 & 256) != 0 ? r1.sendToFollowing : false, (r28 & 512) != 0 ? r1.fromDraft : false, (r28 & 1024) != 0 ? r1.fromEdit : false, (r28 & 2048) != 0 ? r1.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? $this$override.getContent().toast : $it.getMessage());
        return new TribeePublishFailed(copy, $it);
    }
}