package tv.danmaku.bili.ui.login;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: SmsLoginTracker.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/login/SmsLoginTracker;", "", "trackGetSmsCodeStatus", "", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", AuthResultCbHelper.ARGS_MSG, "dataStatus", "dataUrl", "dataMsg", "trackSetCountryCode", "countryId", "trackRegisterSuccess", "trackLoginSuccess", "trackLoginSuccessAfterRegister", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface SmsLoginTracker {
    void trackGetSmsCodeStatus(String str, String str2, String str3, String str4, String str5);

    void trackLoginSuccess();

    void trackLoginSuccessAfterRegister();

    void trackRegisterSuccess();

    void trackSetCountryCode(String str);
}