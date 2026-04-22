package tv.danmaku.bili.utils.reporter;

import android.widget.CheckBox;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ILoginQuickReporter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/utils/reporter/CenterStyleLoginQuickReporter;", "Ltv/danmaku/bili/utils/reporter/ILoginQuickReporter;", "promptScene", "", "loginExperimentValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "onRegisterSuccess", "", "onLoginSuccess", "isNew", "", "reportChangeLoginWayClick", "ispReportFlag", "reportRegCheckboxClick", "view", "Landroid/widget/CheckBox;", "reportLoginClick", "isShow", "isChecked", "reportLinkClick", "itemId", "", "reportCloseClick", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CenterStyleLoginQuickReporter extends ILoginQuickReporter {
    public static final int $stable = 0;
    private final String loginExperimentValue;
    private final String promptScene;

    public CenterStyleLoginQuickReporter(String promptScene, String loginExperimentValue) {
        super(promptScene);
        this.promptScene = promptScene;
        this.loginExperimentValue = loginExperimentValue;
    }

    public void onRegisterSuccess() {
        LoginReporterV2.Show.report("app.register.passed.0.show", LoginReporterV2.generateSingleParamMaps("method", ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE));
    }

    public void onLoginSuccess(boolean isNew) {
        String method;
        if (isNew) {
            method = "24";
        } else {
            method = "19";
        }
        HashMap map = LoginReporterV2.generateSingleParamMaps("method", method);
        if (this.loginExperimentValue != null) {
            Intrinsics.checkNotNull(map);
            map.put(LoginSceneProcessor.SCENE_KEY, this.loginExperimentValue);
        }
        LoginReporterV2.Show.report("app.login.succeed.0.show", map);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportChangeLoginWayClick(String ispReportFlag) {
        HashMap $this$reportChangeLoginWayClick_u24lambda_u240 = LoginReporterV2.generateSingleParamMaps("operator", ispReportFlag == null ? "" : ispReportFlag);
        String str = this.promptScene;
        $this$reportChangeLoginWayClick_u24lambda_u240.put("refer_click", str != null ? str : "");
        LoginReporterV2.Click.report("app.onepass-login.onepass.change.click", $this$reportChangeLoginWayClick_u24lambda_u240);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportRegCheckboxClick(CheckBox view2) {
        LoginRegHelper.reportRegCheckboxClick("app.onepass-login.provision.0.click", view2);
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
        LoginReporterV2.Click.report("app.onepass-login.onepass.authorize.click", $this$reportLoginClick_u24lambda_u240);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportLinkClick(int itemId, String ispReportFlag) {
        LoginQuickLinkClickHelperKt.reportWhenLinkClickInCenterStyle(itemId, ispReportFlag);
    }

    @Override // tv.danmaku.bili.utils.reporter.ILoginQuickReporter
    public void reportCloseClick(String ispReportFlag) {
        HashMap $this$reportCloseClick_u24lambda_u240 = LoginReporterV2.generateSingleParamMaps("operator", ispReportFlag == null ? "" : ispReportFlag);
        String str = this.promptScene;
        $this$reportCloseClick_u24lambda_u240.put("refer_click", str != null ? str : "");
        LoginReporterV2.Click.report("app.onepass-login.onepass.close.click", $this$reportCloseClick_u24lambda_u240);
    }
}