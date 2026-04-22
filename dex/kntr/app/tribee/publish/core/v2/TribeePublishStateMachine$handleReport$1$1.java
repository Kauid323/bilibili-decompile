package kntr.app.tribee.publish.core.v2;

import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.tribee.publish.core.v2.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "<unused var>", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handleReport$1$1", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishStateMachine$handleReport$1$1 extends SuspendLambda implements Function3<TribeePublishAction.TrackerAction, TribeePublishState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handleReport$1$1(Continuation<? super TribeePublishStateMachine$handleReport$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeePublishAction.TrackerAction trackerAction, TribeePublishState tribeePublishState, Continuation<? super Unit> continuation) {
        TribeePublishStateMachine$handleReport$1$1 tribeePublishStateMachine$handleReport$1$1 = new TribeePublishStateMachine$handleReport$1$1(continuation);
        tribeePublishStateMachine$handleReport$1$1.L$0 = trackerAction;
        return tribeePublishStateMachine$handleReport$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeePublishAction.TrackerAction action = (TribeePublishAction.TrackerAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action instanceof TribeePublishAction.TrackerAction.PublishButtonClick) {
                    TrackerKt.reportPublishButtonClick();
                } else if (action instanceof TribeePublishAction.TrackerAction.PublishSuccessClick) {
                    TrackerKt.reportPublishSuccessClick();
                } else if (action instanceof TribeePublishAction.TrackerAction.PhotoFloatLayerExposure) {
                    TrackerKt.reportPhotoFloatLayerExposure();
                } else if (action instanceof TribeePublishAction.TrackerAction.PhotoFloatLayerClick) {
                    TrackerKt.reportPhotoFloatLayerClick(((TribeePublishAction.TrackerAction.PhotoFloatLayerClick) action).getActionType());
                } else if (action instanceof TribeePublishAction.TrackerAction.SyncToDynClick) {
                    TrackerKt.reportSyncToDynClick();
                } else if (action instanceof TribeePublishAction.TrackerAction.SettingsClick) {
                    TrackerKt.reportSettingsClick();
                } else if (action instanceof TribeePublishAction.TrackerAction.ToolbarButtonClick) {
                    TrackerKt.reportToolbarButtonClick(((TribeePublishAction.TrackerAction.ToolbarButtonClick) action).getButton());
                } else if (action instanceof TribeePublishAction.TrackerAction.ToolPanelButtonClick) {
                    TrackerKt.reportToolPanelButtonClick(((TribeePublishAction.TrackerAction.ToolPanelButtonClick) action).getButton(), ((TribeePublishAction.TrackerAction.ToolPanelButtonClick) action).isSelected());
                } else if (action instanceof TribeePublishAction.TrackerAction.CategorySelected) {
                    TrackerKt.reportCategoryClick(((TribeePublishAction.TrackerAction.CategorySelected) action).getTribeeId(), String.valueOf(((TribeePublishAction.TrackerAction.CategorySelected) action).getCategory().getCategoryId()), ((TribeePublishAction.TrackerAction.CategorySelected) action).getCategory().getName());
                } else if (!(action instanceof TribeePublishAction.TrackerAction.CategoryExposure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    TrackerKt.reportCategoryExposure(((TribeePublishAction.TrackerAction.CategoryExposure) action).getTribeeId(), String.valueOf(((TribeePublishAction.TrackerAction.CategoryExposure) action).getCategory().getCategoryId()), ((TribeePublishAction.TrackerAction.CategoryExposure) action).getCategory().getName());
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}