package tv.danmaku.bili.ui.login;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: SmsLoginTracker.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/login/SmsLoginFragmentTracker;", "Ltv/danmaku/bili/ui/login/SmsLoginTracker;", "<init>", "()V", "trackGetSmsCodeStatus", "", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", AuthResultCbHelper.ARGS_MSG, "dataStatus", "dataUrl", "dataMsg", "trackSetCountryCode", "countryId", "trackRegisterSuccess", "trackLoginSuccess", "trackLoginSuccessAfterRegister", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginFragmentTracker implements SmsLoginTracker {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackGetSmsCodeStatus(String code, String msg, String dataStatus, String dataUrl, String dataMsg) {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_SMS_LOGIN_GETSTATUS_0_SHOW, code, msg, dataStatus, dataUrl, dataMsg);
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackSetCountryCode(String countryId) {
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_COUNTY_CODE_CLICK, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.Click.SIGNUP_KEY_COUNTRY, countryId));
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackRegisterSuccess() {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_REGISTER_PASSED_0_SHOW, LoginReporterV2.generateSingleParamMaps("method", "3"));
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackLoginSuccess() {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, LoginReporterV2.generateSingleParamMaps("method", "10"));
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackLoginSuccessAfterRegister() {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, LoginReporterV2.generateSingleParamMaps("method", LoginReporterV2.Show.LOGIN_SUCCEED_NO_ACCOUNT));
    }
}