package tv.danmaku.bili.sms;

import com.bilibili.lib.accountsui.CountryCode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: ISmsController.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\"\u0010\t\u001a\u00020\u00032\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH&J*\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH&J\b\u0010\u0011\u001a\u00020\u0003H&J\"\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/sms/ISmsController;", "", "showCountryChoiceDialog", "", "hideCountryChoiceDialog", "startTimer", "stopTimer", "getDefaultCountryCode", "Lcom/bilibili/lib/accountsui/CountryCode;", "sendSmsWithGeeCaptcha", "innerMap", "", "", "sendSmsWithImageCaptcha", "callbackId", "", "param", "tryNotifyImageCaptchaSuccess", "showCaptchaDialog", "url", "onShowCallback", "Lkotlin/Function0;", "hideCaptchaDialog", "callbackCaptchaDialog", LoginReporterV2.Show.SIGNUP_KEY_CODE, "message", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ISmsController {
    void callbackCaptchaDialog(int i, String str);

    CountryCode getDefaultCountryCode();

    void hideCaptchaDialog();

    void hideCountryChoiceDialog();

    void sendSmsWithGeeCaptcha(Map<String, String> map);

    void sendSmsWithImageCaptcha(int i, Map<String, String> map);

    void showCaptchaDialog(String str, Function0<Unit> function0);

    void showCountryChoiceDialog();

    void startTimer();

    void stopTimer();

    void tryNotifyImageCaptchaSuccess();
}