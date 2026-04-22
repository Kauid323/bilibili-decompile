package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/LoginCaptcha;", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "captchaUrl", "", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/lang/String;)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getCaptchaUrl", "()Ljava/lang/String;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginCaptcha implements ILoginResult {
    public static final int $stable = 8;
    private final String captchaUrl;
    private final LoginWay loginWay;

    public static /* synthetic */ LoginCaptcha copy$default(LoginCaptcha loginCaptcha, LoginWay loginWay, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            loginWay = loginCaptcha.loginWay;
        }
        if ((i & 2) != 0) {
            str = loginCaptcha.captchaUrl;
        }
        return loginCaptcha.copy(loginWay, str);
    }

    public final LoginWay component1() {
        return this.loginWay;
    }

    public final String component2() {
        return this.captchaUrl;
    }

    public final LoginCaptcha copy(LoginWay loginWay, String str) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(str, "captchaUrl");
        return new LoginCaptcha(loginWay, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoginCaptcha) {
            LoginCaptcha loginCaptcha = (LoginCaptcha) obj;
            return Intrinsics.areEqual(this.loginWay, loginCaptcha.loginWay) && Intrinsics.areEqual(this.captchaUrl, loginCaptcha.captchaUrl);
        }
        return false;
    }

    public int hashCode() {
        return (this.loginWay.hashCode() * 31) + this.captchaUrl.hashCode();
    }

    public String toString() {
        LoginWay loginWay = this.loginWay;
        return "LoginCaptcha(loginWay=" + loginWay + ", captchaUrl=" + this.captchaUrl + ")";
    }

    public LoginCaptcha(LoginWay loginWay, String captchaUrl) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(captchaUrl, "captchaUrl");
        this.loginWay = loginWay;
        this.captchaUrl = captchaUrl;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final String getCaptchaUrl() {
        return this.captchaUrl;
    }

    public final LoginCaptchaInfo getCaptchaDisplay() {
        return new LoginCaptchaInfo(this.loginWay, this.captchaUrl, null, 4, null);
    }
}