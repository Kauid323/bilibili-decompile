package kntr.app.ad.domain.click.internal;

import kntr.app.ad.domain.click.internal.action.ActionDispatcher;
import kntr.app.ad.domain.click.internal.action.ActionResult;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.action.results.DownloadFailureReason;
import kntr.app.ad.domain.click.internal.action.results.DownloadResult;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.ad.domain.click.internal.action.results.FailureReason;
import kntr.app.ad.domain.click.internal.action.results.WxOpenFailureReason;
import kntr.app.ad.domain.click.internal.action.results.WxOpenResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickInspector.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/domain/click/internal/ClickInspector;", "Lkntr/app/ad/domain/click/internal/action/ActionDispatcher;", "<init>", "()V", "onActionResult", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "action", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "handleEasyResult", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "handleCallUpResult", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClickInspector implements ActionDispatcher {
    public static final ClickInspector INSTANCE = new ClickInspector();

    private ClickInspector() {
    }

    @Override // kntr.app.ad.domain.click.internal.action.ActionDispatcher
    public void onActionResult(ClickContext context, ActionResult action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof ActionResult.AppDownload) {
            DownloadResult result = ((ActionResult.AppDownload) action).getResult();
            if (Intrinsics.areEqual(result, DownloadResult.Success.INSTANCE)) {
                context.getStage().info("触发下载成功");
            } else if (!(result instanceof DownloadResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            } else {
                if (Intrinsics.areEqual(((DownloadResult.Failure) ((ActionResult.AppDownload) action).getResult()).getReason(), DownloadFailureReason.AuthFailed.INSTANCE)) {
                    context.getStage().error("下载失败：白名单校验不通过");
                }
            }
        } else if (action instanceof ActionResult.AppStoreOpen) {
            if (KDevice.INSTANCE.getDeviceType() == DeviceType.Android) {
                handleEasyResult(context, ((ActionResult.AppStoreOpen) action).getResult(), "打开商店");
            }
        } else if (action instanceof ActionResult.AppStoreCallUp) {
            handleCallUpResult(context, "AppStore", ((ActionResult.AppStoreCallUp) action).getResult());
        } else if (action instanceof ActionResult.BxProgram) {
            handleEasyResult(context, ((ActionResult.BxProgram) action).getResult(), "打开B小");
        } else if (action instanceof ActionResult.SchemeDoubleJump) {
            handleEasyResult(context, ((ActionResult.SchemeDoubleJump) action).getResult(), "触发双跳");
        } else if (action instanceof ActionResult.Scheme) {
            handleCallUpResult(context, "Scheme", ((ActionResult.Scheme) action).getResult());
        } else if (action instanceof ActionResult.ULink) {
            handleCallUpResult(context, "ULK", ((ActionResult.ULink) action).getResult());
        } else if (action instanceof ActionResult.IMax) {
            handleEasyResult(context, ((ActionResult.IMax) action).getResult(), "打开巨幕");
        } else if (action instanceof ActionResult.BiliNative) {
            handleEasyResult(context, ((ActionResult.BiliNative) action).getResult(), "打开站内页面");
        } else if (action instanceof ActionResult.BiliLink) {
            handleEasyResult(context, ((ActionResult.BiliLink) action).getResult(), "打开站内页面");
        } else if (action instanceof ActionResult.MWeb) {
            handleEasyResult(context, ((ActionResult.MWeb) action).getResult(), "打开主站Web");
        } else if (action instanceof ActionResult.AdWeb) {
            handleEasyResult(context, ((ActionResult.AdWeb) action).getResult(), "打开广告Web");
        } else if (action instanceof ActionResult.WxProgram) {
            WxOpenResult result2 = ((ActionResult.WxProgram) action).getResult();
            if (Intrinsics.areEqual(result2, WxOpenResult.Success.INSTANCE)) {
                context.getStage().info("打开微信成功");
            } else if (!(result2 instanceof WxOpenResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            } else {
                WxOpenFailureReason reason = ((WxOpenResult.Failure) ((ActionResult.WxProgram) action).getResult()).getReason();
                if (!(reason instanceof WxOpenFailureReason.InputError)) {
                    if (!Intrinsics.areEqual(reason, WxOpenFailureReason.NotInstalled.INSTANCE)) {
                        if (!(reason instanceof WxOpenFailureReason.InternalError)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        context.getStage().error("打开微信失败：内部错误");
                        return;
                    }
                    context.getStage().error("打开微信失败：未安装微信");
                    return;
                }
                context.getStage().error("打开微信失败：数据不合法");
            }
        } else if (!(action instanceof ActionResult.Hook)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void handleEasyResult(ClickContext context, EasyResult result, String desc) {
        if (Intrinsics.areEqual(result, EasyResult.Success.INSTANCE)) {
            context.getStage().info(desc + "成功");
        } else if (!(result instanceof EasyResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            FailureReason reason = ((EasyResult.Failure) result).getReason();
            if (!(reason instanceof FailureReason.InputError)) {
                if (!(reason instanceof FailureReason.InternalError)) {
                    throw new NoWhenBranchMatchedException();
                }
                context.getStage().error(desc + "失败");
            }
        }
    }

    private final void handleCallUpResult(ClickContext context, String desc, CallUpResult result) {
        if (Intrinsics.areEqual(result, CallUpResult.Success.INSTANCE)) {
            context.getStage().info(desc + "唤起成功");
        } else if (!(result instanceof CallUpResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            CallUpFailureReason reason = ((CallUpResult.Failure) result).getReason();
            if (Intrinsics.areEqual(reason, CallUpFailureReason.AuthFailed.INSTANCE)) {
                context.getStage().error(desc + "唤起失败：白名单校验不通过");
            } else if (Intrinsics.areEqual(reason, CallUpFailureReason.NotInstalled.INSTANCE)) {
                context.getStage().error(desc + "唤起失败：未安装该应用");
            } else if (Intrinsics.areEqual(reason, CallUpFailureReason.UserCancelled.INSTANCE)) {
                context.getStage().error(desc + "唤起失败：用户取消");
            } else if (reason instanceof CallUpFailureReason.InternalError) {
                context.getStage().error(desc + "唤起失败：内部错误");
            }
        }
    }
}