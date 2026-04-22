package tv.danmaku.bili.utils.reporter;

import android.widget.CheckBox;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ILoginQuickReporter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/utils/reporter/BottomSheetStyleLoginQuickReporter;", "Ltv/danmaku/bili/utils/reporter/ILoginQuickReporter;", "promptScene", "", "<init>", "(Ljava/lang/String;)V", "onRegisterSuccess", "", "onLoginSuccess", "isNew", "", "reportChangeLoginWayClick", "ispReportFlag", "reportRegCheckboxClick", "view", "Landroid/widget/CheckBox;", "reportLoginClick", "isShow", "isChecked", "reportLinkClick", "itemId", "", "reportCloseClick", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BottomSheetStyleLoginQuickReporter extends ILoginQuickReporter {
    public static final int $stable = 0;
    private final String promptScene;

    public BottomSheetStyleLoginQuickReporter(String promptScene) {
        super(promptScene);
        this.promptScene = promptScene;
    }

    public void onRegisterSuccess() {
        LoginReporterV2.Show.report("app.register.passed.0.show", LoginReporterV2.generateSingleParamMaps("method", ConstsKt.ARG_FULL_PKG_DOWNLOAD_FAILURE));
    }

    public void onLoginSuccess(boolean isNew) {
        String method;
        if (isNew) {
            method = "26";
        } else {
            method = "25";
        }
        HashMap map = LoginReporterV2.generateSingleParamMaps("method", method);
        LoginReporterV2.Show.report("app.login.succeed.0.show", map);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportChangeLoginWayClick(String ispReportFlag) {
        HashMap $this$reportChangeLoginWayClick_u24lambda_u240 = LoginReporterV2.generateSingleParamMaps("operator", ispReportFlag == null ? "" : ispReportFlag);
        String str = this.promptScene;
        $this$reportChangeLoginWayClick_u24lambda_u240.put("refer_click", str != null ? str : "");
        LoginReporterV2.Click.report("app.onepass-login2.onepass2.change.click", $this$reportChangeLoginWayClick_u24lambda_u240);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportRegCheckboxClick(CheckBox view2) {
        LoginRegHelper.reportRegCheckboxClick("app.onepass-login2.provision.0.click", view2);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportLoginClick(String ispReportFlag, String isShow, String isChecked) {
        Intrinsics.checkNotNullParameter(isShow, "isShow");
        Intrinsics.checkNotNullParameter(isChecked, "isChecked");
        HashMap $this$reportLoginClick_u24lambda_u240 = LoginReporterV2.generateSingleParamMaps("operator", ispReportFlag == null ? "" : ispReportFlag);
        String str = this.promptScene;
        $this$reportLoginClick_u24lambda_u240.put("refer_click", str != null ? str : "");
        $this$reportLoginClick_u24lambda_u240.put("show_provision", isShow);
        if (Intrinsics.areEqual("1", isShow)) {
            $this$reportLoginClick_u24lambda_u240.put("is_agree", isChecked);
        }
        LoginReporterV2.Click.report("app.onepass-login2.onepass2.authorize.click", $this$reportLoginClick_u24lambda_u240);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportLinkClick(int itemId, String ispReportFlag) {
        LoginQuickLinkClickHelperKt.reportWhenLinkClickInBottomSheetStyle(itemId, ispReportFlag);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportCloseClick(String ispReportFlag) {
        HashMap $this$reportCloseClick_u24lambda_u240 = LoginReporterV2.generateSingleParamMaps("operator", ispReportFlag == null ? "" : ispReportFlag);
        String str = this.promptScene;
        $this$reportCloseClick_u24lambda_u240.put("refer_click", str != null ? str : "");
        LoginReporterV2.Click.report("app.onepass-login2.onepass2.close.click", $this$reportCloseClick_u24lambda_u240);
    }
}