package tv.danmaku.bili.utils.reporter;

import kotlin.Metadata;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LoginQuickLinkClickHelper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0007"}, d2 = {"reportWhenLinkClickInBottomSheetStyle", "", "itemId", "", "ispReportFlag", "", "reportWhenLinkClickInCenterStyle", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LoginQuickLinkClickHelperKt {
    public static final void reportWhenLinkClickInBottomSheetStyle(int itemId, String ispReportFlag) {
        switch (itemId) {
            case 2:
                LoginReporterV2.Click.report("app.onepass-login2.onepass2.agreement.click", LoginReporterV2.generateSingleParamMaps("operator", ispReportFlag != null ? ispReportFlag : ""));
                LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", "4"));
                return;
            case 3:
                LoginReporterV2.Click.report("app.onepass-login2.onepass2.privacy.click", LoginReporterV2.generateSingleParamMaps("operator", ispReportFlag != null ? ispReportFlag : ""));
                LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE));
                return;
            case 4:
                LoginReporterV2.Click.report("app.onepass-login2.onepass2.operator.click", LoginReporterV2.generateSingleParamMaps("operator", ispReportFlag != null ? ispReportFlag : ""));
                LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", ConstsKt.ARG_MERGE_INCREMENT_FAILURE));
                return;
            default:
                return;
        }
    }

    public static final void reportWhenLinkClickInCenterStyle(int itemId, String ispReportFlag) {
        String str = "";
        switch (itemId) {
            case 2:
                if (ispReportFlag != null) {
                    str = ispReportFlag;
                }
                LoginReporterV2.Click.report("app.onepass-login.onepass.agreement.click", LoginReporterV2.generateSingleParamMaps("operator", str));
                LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", "4"));
                return;
            case 3:
                if (ispReportFlag != null) {
                    str = ispReportFlag;
                }
                LoginReporterV2.Click.report("app.onepass-login.onepass.privacy.click", LoginReporterV2.generateSingleParamMaps("operator", str));
                LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE));
                return;
            case 4:
                if (ispReportFlag != null) {
                    str = ispReportFlag;
                }
                LoginReporterV2.Click.report("app.onepass-login.onepass.operator.click", LoginReporterV2.generateSingleParamMaps("operator", str));
                LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", ConstsKt.ARG_MERGE_INCREMENT_FAILURE));
                return;
            default:
                return;
        }
    }
}