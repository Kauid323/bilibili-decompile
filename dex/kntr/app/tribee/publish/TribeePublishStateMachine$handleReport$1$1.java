package kntr.app.tribee.publish;

import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.tribee.publish.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Lkntr/app/tribee/publish/TribeePublishAction;", "<unused var>", "Lkntr/app/tribee/publish/TribeePublishState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishStateMachine$handleReport$1$1", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishStateMachine$handleReport$1$1 extends SuspendLambda implements Function3<TribeePublishAction, TribeePublishState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handleReport$1$1(Continuation<? super TribeePublishStateMachine$handleReport$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeePublishAction tribeePublishAction, TribeePublishState tribeePublishState, Continuation<? super Unit> continuation) {
        TribeePublishStateMachine$handleReport$1$1 tribeePublishStateMachine$handleReport$1$1 = new TribeePublishStateMachine$handleReport$1$1(continuation);
        tribeePublishStateMachine$handleReport$1$1.L$0 = tribeePublishAction;
        return tribeePublishStateMachine$handleReport$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeePublishAction action = (TribeePublishAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action instanceof TribeePublishAction.TrackerAction.PublishButtonClick) {
                    TrackerKt.reportPublishButtonClick(((TribeePublishAction.TrackerAction.PublishButtonClick) action).getType());
                } else if (action instanceof TribeePublishAction.TrackerAction.PublishSuccessClick) {
                    TrackerKt.reportPublishSuccessClick(((TribeePublishAction.TrackerAction.PublishSuccessClick) action).getType());
                } else if (action instanceof TribeePublishAction.TrackerAction.PhotoButtonClick) {
                    TrackerKt.reportPhotoButtonClick(((TribeePublishAction.TrackerAction.PhotoButtonClick) action).getType());
                } else if (action instanceof TribeePublishAction.TrackerAction.PhotoFloatLayerExposure) {
                    TrackerKt.reportPhotoFloatLayerExposure(((TribeePublishAction.TrackerAction.PhotoFloatLayerExposure) action).getType());
                } else if (action instanceof TribeePublishAction.TrackerAction.PhotoFloatLayerClick) {
                    TrackerKt.reportPhotoFloatLayerClick(((TribeePublishAction.TrackerAction.PhotoFloatLayerClick) action).getType(), ((TribeePublishAction.TrackerAction.PhotoFloatLayerClick) action).getActionType());
                } else if (action instanceof TribeePublishAction.TrackerAction.SyncToDynClick) {
                    TrackerKt.reportSyncToDynClick(((TribeePublishAction.TrackerAction.SyncToDynClick) action).getType());
                } else if (action instanceof TribeePublishAction.TrackerAction.CategorySelected) {
                    TrackerKt.reportCategoryClick(((TribeePublishAction.TrackerAction.CategorySelected) action).getTribeeId(), String.valueOf(((TribeePublishAction.TrackerAction.CategorySelected) action).getCategory().getCategoryId()), ((TribeePublishAction.TrackerAction.CategorySelected) action).getCategory().getName());
                } else if (action instanceof TribeePublishAction.TrackerAction.CategoryExposure) {
                    TrackerKt.reportCategoryExposure(((TribeePublishAction.TrackerAction.CategoryExposure) action).getTribeeId(), String.valueOf(((TribeePublishAction.TrackerAction.CategoryExposure) action).getCategory().getCategoryId()), ((TribeePublishAction.TrackerAction.CategoryExposure) action).getCategory().getName());
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}