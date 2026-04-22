package kntr.app.ad.domain.click.internal;

import kntr.app.ad.domain.click.ClickFrom;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickReport.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¨\u0006\b"}, d2 = {"reportCallUp", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "result", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClickReportKt {
    private static final void reportCallUp$reportUiWithUrl(ClickContext $context, final String $url, ActionUiEvent event) {
        $context.reportUi(event, new Function1() { // from class: kntr.app.ad.domain.click.internal.ClickReportKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit reportCallUp$reportUiWithUrl$lambda$0;
                reportCallUp$reportUiWithUrl$lambda$0 = ClickReportKt.reportCallUp$reportUiWithUrl$lambda$0($url, (IReportExtraHandler) obj);
                return reportCallUp$reportUiWithUrl$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportCallUp$reportUiWithUrl$lambda$0(String $url, IReportExtraHandler $this$reportUi) {
        Intrinsics.checkNotNullParameter($this$reportUi, "$this$reportUi");
        $this$reportUi.put(ActionUiExtra.URL.getValue(), $url);
        return Unit.INSTANCE;
    }

    public static final void reportCallUp(ClickContext context, CallUpResult result, String url) {
        ActionUiEvent actionUiEvent;
        ActionUiEvent actionUiEvent2;
        ActionUiEvent actionUiEvent3;
        ActionUiEvent actionUiEvent4;
        ActionUiEvent actionUiEvent5;
        ActionUiEvent actionUiEvent6;
        ActionUiEvent actionUiEvent7;
        ActionUiEvent actionUiEvent8;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        boolean isNativePage = context.getService().getFrom() == ClickFrom.Native;
        if (Intrinsics.areEqual(result, CallUpResult.Success.INSTANCE)) {
            if (context.isDlSucCallUping()) {
                reportCallUp$reportUiWithUrl(context, url, ActionUiEvent.OPEN_APP_URL);
            }
            if (isNativePage) {
                actionUiEvent8 = ActionUiEvent.NA_CALLUP_SUC;
            } else {
                actionUiEvent8 = ActionUiEvent.H5_CALLUP_SUC;
            }
            reportCallUp$reportUiWithUrl(context, url, actionUiEvent8);
        } else if (!(result instanceof CallUpResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (context.isDlSucCallUping()) {
                reportCallUp$reportUiWithUrl(context, url, ActionUiEvent.OPEN_APP_URL);
            }
            CallUpFailureReason reason = ((CallUpResult.Failure) result).getReason();
            if (Intrinsics.areEqual(reason, CallUpFailureReason.AuthFailed.INSTANCE)) {
                if (isNativePage) {
                    actionUiEvent6 = ActionUiEvent.CALLUP_FAIL_NA_AUTH_FAIL;
                } else {
                    actionUiEvent6 = ActionUiEvent.CALLUP_FAIL_H5_AUTH_FAIL;
                }
                reportCallUp$reportUiWithUrl(context, url, actionUiEvent6);
                if (isNativePage) {
                    actionUiEvent7 = ActionUiEvent.NA_CALLUP_FAIL;
                } else {
                    actionUiEvent7 = ActionUiEvent.H5_CALLUP_FAIL;
                }
                reportCallUp$reportUiWithUrl(context, url, actionUiEvent7);
            } else if (Intrinsics.areEqual(reason, CallUpFailureReason.NotInstalled.INSTANCE)) {
                if (isNativePage) {
                    actionUiEvent4 = ActionUiEvent.CALLUP_FAIL_NA_NOT_INSTALL;
                } else {
                    actionUiEvent4 = ActionUiEvent.CALLUP_FAIL_H5_NOT_INSTALL;
                }
                reportCallUp$reportUiWithUrl(context, url, actionUiEvent4);
                if (isNativePage) {
                    actionUiEvent5 = ActionUiEvent.NA_CALLUP_FAIL;
                } else {
                    actionUiEvent5 = ActionUiEvent.H5_CALLUP_FAIL;
                }
                reportCallUp$reportUiWithUrl(context, url, actionUiEvent5);
            } else if (Intrinsics.areEqual(reason, CallUpFailureReason.UserCancelled.INSTANCE)) {
                if (isNativePage) {
                    actionUiEvent2 = ActionUiEvent.CALLUP_FAIL_NA_USER_CANCEL;
                } else {
                    actionUiEvent2 = ActionUiEvent.CALLUP_FAIL_H5_USER_CANCEL;
                }
                reportCallUp$reportUiWithUrl(context, url, actionUiEvent2);
                if (isNativePage) {
                    actionUiEvent3 = ActionUiEvent.NA_CALLUP_FAIL;
                } else {
                    actionUiEvent3 = ActionUiEvent.H5_CALLUP_FAIL;
                }
                reportCallUp$reportUiWithUrl(context, url, actionUiEvent3);
            } else if (reason instanceof CallUpFailureReason.InternalError) {
                if (isNativePage) {
                    actionUiEvent = ActionUiEvent.NA_CALLUP_FAIL;
                } else {
                    actionUiEvent = ActionUiEvent.H5_CALLUP_FAIL;
                }
                reportCallUp$reportUiWithUrl(context, url, actionUiEvent);
            }
        }
    }
}