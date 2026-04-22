package tv.danmaku.bili.ui.login;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: SmsLoginTracker.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/login/SmsLoginDialogTracker;", "Ltv/danmaku/bili/ui/login/SmsLoginTracker;", "spmId", "", "<init>", "(Ljava/lang/String;)V", "getSpmId", "()Ljava/lang/String;", "trackGetSmsCodeStatus", "", LoginReporterV2.Show.SIGNUP_KEY_CODE, AuthResultCbHelper.ARGS_MSG, "dataStatus", "dataUrl", "dataMsg", "trackSetCountryCode", "countryId", "trackRegisterSuccess", "trackLoginSuccess", "trackLoginSuccessAfterRegister", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginDialogTracker implements SmsLoginTracker {
    public static final int $stable = 0;
    private final String spmId;

    public SmsLoginDialogTracker(String spmId) {
        this.spmId = spmId;
    }

    public final String getSpmId() {
        return this.spmId;
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackGetSmsCodeStatus(String code, String msg, String dataStatus, String dataUrl, String dataMsg) {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_SMS_LOGIN_GETSTATUS_2_SHOW, code, msg, dataStatus, dataUrl, dataMsg);
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackSetCountryCode(String countryId) {
        LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_SET_COUNTRY_CODE, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.Click.SIGNUP_KEY_COUNTRY, countryId));
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackRegisterSuccess() {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_REGISTER_PASSED_0_SHOW, LoginReporterV2.generateSingleParamMaps("method", "9"));
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackLoginSuccess() {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, LoginReporterV2.generateSingleParamMaps("method", LoginReporterV2.Show.LOGIN_SUCCEED_SMS_NO_IDENTITY_FROM_SMS_LOGIN_DIALOG));
    }

    @Override // tv.danmaku.bili.ui.login.SmsLoginTracker
    public void trackLoginSuccessAfterRegister() {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, LoginReporterV2.generateSingleParamMaps("method", LoginReporterV2.Show.LOGIN_SUCCEED_NO_ACCOUNT_FROM_SMS_LOGIN_DIALOG));
    }
}