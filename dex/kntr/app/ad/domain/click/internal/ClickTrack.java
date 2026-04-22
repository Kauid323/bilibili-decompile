package kntr.app.ad.domain.click.internal;

import java.util.List;
import kntr.app.ad.domain.click.internal.action.ActionDispatcher;
import kntr.app.ad.domain.click.internal.action.ActionResult;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.action.results.WxOpenFailureReason;
import kntr.app.ad.domain.click.internal.action.results.WxOpenResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickTrack.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J4\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/domain/click/internal/ClickTrack;", "Lkntr/app/ad/domain/click/internal/action/ActionDispatcher;", "<init>", "()V", "onActionResult", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "action", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "handleCallUpResult", "result", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "openWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClickTrack implements ActionDispatcher {
    public static final ClickTrack INSTANCE = new ClickTrack();

    private ClickTrack() {
    }

    @Override // kntr.app.ad.domain.click.internal.action.ActionDispatcher
    public void onActionResult(ClickContext context, ActionResult action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof ActionResult.AppDownload) && !(action instanceof ActionResult.AppStoreOpen) && !(action instanceof ActionResult.AppStoreCallUp) && !(action instanceof ActionResult.BxProgram) && !(action instanceof ActionResult.SchemeDoubleJump)) {
            if (action instanceof ActionResult.Scheme) {
                handleCallUpResult(context, ((ActionResult.Scheme) action).getResult(), ((ActionResult.Scheme) action).getParam().getCallUpUrl(), ((ActionResult.Scheme) action).getParam().getOpenWhiteList());
            } else if (action instanceof ActionResult.ULink) {
                handleCallUpResult(context, ((ActionResult.ULink) action).getResult(), ((ActionResult.ULink) action).getParam().getCallUpUrl(), ((ActionResult.ULink) action).getParam().getOpenWhiteList());
            } else if (!(action instanceof ActionResult.IMax) && !(action instanceof ActionResult.BiliNative) && !(action instanceof ActionResult.BiliLink) && !(action instanceof ActionResult.MWeb) && !(action instanceof ActionResult.AdWeb)) {
                if (action instanceof ActionResult.WxProgram) {
                    WxOpenResult result = ((ActionResult.WxProgram) action).getResult();
                    if (Intrinsics.areEqual(result, WxOpenResult.Success.INSTANCE)) {
                        context.trackWxCallUp(WxProgramCallUpTrackResult.Success, ((ActionResult.WxProgram) action).getParam().getWxInfo());
                    } else if (!(result instanceof WxOpenResult.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        WxOpenFailureReason reason = ((WxOpenResult.Failure) ((ActionResult.WxProgram) action).getResult()).getReason();
                        if (reason instanceof WxOpenFailureReason.InputError) {
                            context.trackWxCallUp(WxProgramCallUpTrackResult.DataIllegal, ((ActionResult.WxProgram) action).getParam().getWxInfo());
                        } else if (Intrinsics.areEqual(reason, WxOpenFailureReason.NotInstalled.INSTANCE)) {
                            context.trackWxCallUp(WxProgramCallUpTrackResult.NotInstall, ((ActionResult.WxProgram) action).getParam().getWxInfo());
                        } else if (!(reason instanceof WxOpenFailureReason.InternalError)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            context.trackWxCallUp(WxProgramCallUpTrackResult.OpenFail, ((ActionResult.WxProgram) action).getParam().getWxInfo());
                        }
                    }
                } else if (!(action instanceof ActionResult.Hook)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    private final void handleCallUpResult(ClickContext context, CallUpResult result, String url, List<String> list) {
        if (Intrinsics.areEqual(result, CallUpResult.Success.INSTANCE)) {
            context.trackAppCallUp(AppCallUpTrackResult.Success, url, list);
        } else if (!(result instanceof CallUpResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            CallUpFailureReason reason = ((CallUpResult.Failure) result).getReason();
            if (Intrinsics.areEqual(reason, CallUpFailureReason.AuthFailed.INSTANCE)) {
                context.trackAppCallUp(AppCallUpTrackResult.AuthFail, url, list);
            } else if (Intrinsics.areEqual(reason, CallUpFailureReason.NotInstalled.INSTANCE)) {
                context.trackAppCallUp(AppCallUpTrackResult.NotInstallFail, url, list);
            } else if (Intrinsics.areEqual(reason, CallUpFailureReason.UserCancelled.INSTANCE)) {
                context.trackAppCallUp(AppCallUpTrackResult.UserCancel, url, list);
            } else if (reason instanceof CallUpFailureReason.InternalError) {
                context.trackAppCallUp(AppCallUpTrackResult.UnKnownFail, url, list);
            }
        }
    }
}