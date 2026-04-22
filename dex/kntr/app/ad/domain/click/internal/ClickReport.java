package kntr.app.ad.domain.click.internal;

import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.ad.domain.click.internal.action.ActionDispatcher;
import kntr.app.ad.domain.click.internal.action.ActionResult;
import kntr.app.ad.domain.click.internal.action.results.DownloadFailureReason;
import kntr.app.ad.domain.click.internal.action.results.DownloadResult;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.ad.domain.click.internal.action.results.FailureReason;
import kntr.app.ad.domain.click.internal.action.results.WxOpenFailureReason;
import kntr.app.ad.domain.click.internal.action.results.WxOpenResult;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickReport.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lkntr/app/ad/domain/click/internal/ClickReport;", "Lkntr/app/ad/domain/click/internal/action/ActionDispatcher;", "<init>", "()V", "onActionResult", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "action", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClickReport implements ActionDispatcher {
    public static final ClickReport INSTANCE = new ClickReport();

    private ClickReport() {
    }

    @Override // kntr.app.ad.domain.click.internal.action.ActionDispatcher
    public void onActionResult(ClickContext context, final ActionResult action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        Logger_androidKt.getAdLog().d("KAdClick", action.toString());
        if (action instanceof ActionResult.AppDownload) {
            DownloadResult result = ((ActionResult.AppDownload) action).getResult();
            if (!Intrinsics.areEqual(result, DownloadResult.Success.INSTANCE)) {
                if (!(result instanceof DownloadResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (Intrinsics.areEqual(((DownloadResult.Failure) ((ActionResult.AppDownload) action).getResult()).getReason(), DownloadFailureReason.AuthFailed.INSTANCE)) {
                    context.reportUi(ActionUiEvent.AUTH_FAIL, new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickReport$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit onActionResult$lambda$0;
                            onActionResult$lambda$0 = ClickReport.onActionResult$lambda$0(ActionResult.this, (IReportExtraHandler) obj);
                            return onActionResult$lambda$0;
                        }
                    });
                }
            }
        } else if (action instanceof ActionResult.AppStoreOpen) {
            if (KDevice.INSTANCE.getDeviceType() == DeviceType.Android) {
                EasyResult result2 = ((ActionResult.AppStoreOpen) action).getResult();
                if (Intrinsics.areEqual(result2, EasyResult.Success.INSTANCE)) {
                    context.reportUi(ActionUiEvent.OPEN_STORE_DIRECT, new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickReport$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit onActionResult$lambda$1;
                            onActionResult$lambda$1 = ClickReport.onActionResult$lambda$1(ActionResult.this, (IReportExtraHandler) obj);
                            return onActionResult$lambda$1;
                        }
                    });
                } else if (!(result2 instanceof EasyResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    FailureReason reason = ((EasyResult.Failure) ((ActionResult.AppStoreOpen) action).getResult()).getReason();
                    if (!(reason instanceof FailureReason.InputError)) {
                        if (!(reason instanceof FailureReason.InternalError)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        context.reportUi(ActionUiEvent.OPEN_STORE_DIRECT_FAIL, new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickReport$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                Unit onActionResult$lambda$2;
                                onActionResult$lambda$2 = ClickReport.onActionResult$lambda$2(ActionResult.this, (IReportExtraHandler) obj);
                                return onActionResult$lambda$2;
                            }
                        });
                    }
                }
            }
        } else if (!(action instanceof ActionResult.AppStoreCallUp)) {
            if (!(action instanceof ActionResult.BxProgram) && !(action instanceof ActionResult.SchemeDoubleJump)) {
                if (!(action instanceof ActionResult.Scheme)) {
                    if (!(action instanceof ActionResult.ULink)) {
                        if (!(action instanceof ActionResult.IMax) && !(action instanceof ActionResult.BiliNative) && !(action instanceof ActionResult.BiliLink) && !(action instanceof ActionResult.MWeb) && !(action instanceof ActionResult.AdWeb)) {
                            if (action instanceof ActionResult.WxProgram) {
                                WxOpenResult result3 = ((ActionResult.WxProgram) action).getResult();
                                if (Intrinsics.areEqual(result3, WxOpenResult.Success.INSTANCE)) {
                                    context.reportUi(ActionUiEvent.WX_MINI_CALLUP_SUC, new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickReport$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj) {
                                            Unit onActionResult$lambda$3;
                                            onActionResult$lambda$3 = ClickReport.onActionResult$lambda$3(ActionResult.this, (IReportExtraHandler) obj);
                                            return onActionResult$lambda$3;
                                        }
                                    });
                                    return;
                                } else if (!(result3 instanceof WxOpenResult.Failure)) {
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    context.reportUi(ActionUiEvent.WX_MINI_CALLUP_FAILED, new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickReport$$ExternalSyntheticLambda4
                                        public final Object invoke(Object obj) {
                                            Unit onActionResult$lambda$4;
                                            onActionResult$lambda$4 = ClickReport.onActionResult$lambda$4(ActionResult.this, (IReportExtraHandler) obj);
                                            return onActionResult$lambda$4;
                                        }
                                    });
                                    return;
                                }
                            } else if (!(action instanceof ActionResult.Hook)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    ClickReportKt.reportCallUp(context, ((ActionResult.ULink) action).getResult(), ((ActionResult.ULink) action).getParam().getCallUpUrl());
                    return;
                }
                ClickReportKt.reportCallUp(context, ((ActionResult.Scheme) action).getResult(), ((ActionResult.Scheme) action).getParam().getCallUpUrl());
            }
        } else {
            ClickReportKt.reportCallUp(context, ((ActionResult.AppStoreCallUp) action).getResult(), ((ActionResult.AppStoreCallUp) action).getParam().getUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActionResult$lambda$0(ActionResult $action, IReportExtraHandler $this$reportUi) {
        Intrinsics.checkNotNullParameter($this$reportUi, "$this$reportUi");
        $this$reportUi.put(ActionUiExtra.URL.getValue(), ((ActionResult.AppDownload) $action).getParams().getUrl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActionResult$lambda$1(ActionResult $action, IReportExtraHandler $this$reportUi) {
        Intrinsics.checkNotNullParameter($this$reportUi, "$this$reportUi");
        $this$reportUi.put(ActionUiExtra.URL.getValue(), ((ActionResult.AppStoreOpen) $action).getIntermediates().get(ActionUiExtra.URL.getValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActionResult$lambda$2(ActionResult $action, IReportExtraHandler $this$reportUi) {
        Intrinsics.checkNotNullParameter($this$reportUi, "$this$reportUi");
        $this$reportUi.put(ActionUiExtra.URL.getValue(), ((ActionResult.AppStoreOpen) $action).getIntermediates().get(ActionUiExtra.URL.getValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActionResult$lambda$3(ActionResult $action, IReportExtraHandler $this$reportUi) {
        Intrinsics.checkNotNullParameter($this$reportUi, "$this$reportUi");
        String value = ActionUiExtra.WECHAT_URL.getValue();
        AdWxProgramInfo wxInfo = ((ActionResult.WxProgram) $action).getParam().getWxInfo();
        $this$reportUi.put(value, wxInfo != null ? wxInfo.getPath() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActionResult$lambda$4(ActionResult $action, IReportExtraHandler $this$reportUi) {
        String reason;
        Intrinsics.checkNotNullParameter($this$reportUi, "$this$reportUi");
        String value = ActionUiExtra.WECHAT_URL.getValue();
        AdWxProgramInfo wxInfo = ((ActionResult.WxProgram) $action).getParam().getWxInfo();
        $this$reportUi.put(value, wxInfo != null ? wxInfo.getPath() : null);
        WxOpenFailureReason reason2 = ((WxOpenResult.Failure) ((ActionResult.WxProgram) $action).getResult()).getReason();
        if (reason2 instanceof WxOpenFailureReason.InputError) {
            reason = "wx_mini_data_illegal";
        } else if (Intrinsics.areEqual(reason2, WxOpenFailureReason.NotInstalled.INSTANCE)) {
            reason = "wx_not_install";
        } else if (!(reason2 instanceof WxOpenFailureReason.InternalError)) {
            throw new NoWhenBranchMatchedException();
        } else {
            reason = "wx_mini_open_failed";
        }
        $this$reportUi.put(ActionUiExtra.FAIL_REASON.getValue(), reason);
        return Unit.INSTANCE;
    }
}