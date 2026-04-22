package im.session.track;

import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.tencent.tauth.AuthActivity;
import im.session.IMAction;
import im.session.IMActionAlertShow;
import im.session.IMActionClickQuickLinkItem;
import im.session.IMActionClickSessionCard;
import im.session.IMActionClickThreeDotItem;
import im.session.IMActionDismissBehaviorAlert;
import im.session.IMActionDismissQuickLinkBubble;
import im.session.IMActionExposureQuickLinkBubble;
import im.session.IMActionExposureQuickLinkItem;
import im.session.IMActionExposureSessionCard;
import im.session.IMActionExposureThreeDotItem;
import im.session.IMActionSessionDelete;
import im.session.IMActionSessionPin;
import im.session.IMActionUnBlockSession;
import im.session.IMState;
import im.session.model.IMQuickLink;
import im.session.model.IMSessionAlert;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tracker.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", AuthActivity.ACTION_KEY, "Lim/session/IMAction;", "state", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.track.TrackerKt$bindTracker$1$1", f = "Tracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TrackerKt$bindTracker$1$1 extends SuspendLambda implements Function3<IMAction, IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackerKt$bindTracker$1$1(Continuation<? super TrackerKt$bindTracker$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMAction iMAction, IMState iMState, Continuation<? super Unit> continuation) {
        TrackerKt$bindTracker$1$1 trackerKt$bindTracker$1$1 = new TrackerKt$bindTracker$1$1(continuation);
        trackerKt$bindTracker$1$1.L$0 = iMAction;
        trackerKt$bindTracker$1$1.L$1 = iMState;
        return trackerKt$bindTracker$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMSessionAlert it;
        KQuickLinkBubble it2;
        KQuickLinkBubble it3;
        IMAction action = (IMAction) this.L$0;
        IMState state = (IMState) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action instanceof IMActionExposureThreeDotItem) {
                    TrackerKt.handleThreeDotItemExposure((IMActionExposureThreeDotItem) action);
                } else if (action instanceof IMActionClickThreeDotItem) {
                    TrackerKt.handleThreeDotItemClicked((IMActionClickThreeDotItem) action);
                } else if (action instanceof IMActionExposureQuickLinkItem) {
                    TrackerKt.handleQuickLinkExposure((IMActionExposureQuickLinkItem) action);
                } else if (action instanceof IMActionClickQuickLinkItem) {
                    TrackerKt.handleQuickLinkClicked((IMActionClickQuickLinkItem) action);
                } else if (action instanceof IMActionExposureSessionCard) {
                    TrackerKt.handleSessionExposure((IMActionExposureSessionCard) action, state);
                } else if (action instanceof IMActionClickSessionCard) {
                    TrackerKt.handleSessionClicked(((IMActionClickSessionCard) action).getCard(), "turn", state);
                } else if (action instanceof IMActionSessionDelete) {
                    TrackerKt.handleSessionClicked(((IMActionSessionDelete) action).getCard(), "delete", state);
                } else if (action instanceof IMActionSessionPin) {
                    TrackerKt.handleSessionClicked(((IMActionSessionPin) action).getCard(), ((IMActionSessionPin) action).getCard().isPinned() ? "cancel-top" : "top", state);
                } else if (action instanceof IMActionUnBlockSession) {
                    TrackerKt.handleSessionClicked(((IMActionUnBlockSession) action).getCard(), "intercept", state);
                } else if (action instanceof IMActionDismissQuickLinkBubble) {
                    IMQuickLink quickLinks = state.getData().getQuickLinks();
                    if (quickLinks != null && (it3 = quickLinks.getBubble()) != null) {
                        TrackerKt.handleQuickLinkBubbleClose(it3);
                    }
                } else if (action instanceof IMActionExposureQuickLinkBubble) {
                    IMQuickLink quickLinks2 = state.getData().getQuickLinks();
                    if (quickLinks2 != null && (it2 = quickLinks2.getBubble()) != null) {
                        TrackerKt.handleQuickLinkBubbleExposure(it2);
                    }
                } else if (action instanceof IMActionAlertShow) {
                    TrackerKt.handleAlertShow((IMActionAlertShow) action);
                } else if ((action instanceof IMActionDismissBehaviorAlert) && (it = state.getData().getAlert$session_debug()) != null) {
                    TrackerKt.handleAlertDismissClick(it);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}