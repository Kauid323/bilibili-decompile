package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/LoginFailed;", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "loginError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/lang/Exception;)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getLoginError", "()Ljava/lang/Exception;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginFailed implements ILoginResult {
    public static final int $stable = 8;
    private final Exception loginError;
    private final LoginWay loginWay;

    public static /* synthetic */ LoginFailed copy$default(LoginFailed loginFailed, LoginWay loginWay, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            loginWay = loginFailed.loginWay;
        }
        if ((i & 2) != 0) {
            exc = loginFailed.loginError;
        }
        return loginFailed.copy(loginWay, exc);
    }

    public final LoginWay component1() {
        return this.loginWay;
    }

    public final Exception component2() {
        return this.loginError;
    }

    public final LoginFailed copy(LoginWay loginWay, Exception exc) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        return new LoginFailed(loginWay, exc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoginFailed) {
            LoginFailed loginFailed = (LoginFailed) obj;
            return Intrinsics.areEqual(this.loginWay, loginFailed.loginWay) && Intrinsics.areEqual(this.loginError, loginFailed.loginError);
        }
        return false;
    }

    public int hashCode() {
        return (this.loginWay.hashCode() * 31) + (this.loginError == null ? 0 : this.loginError.hashCode());
    }

    public String toString() {
        LoginWay loginWay = this.loginWay;
        return "LoginFailed(loginWay=" + loginWay + ", loginError=" + this.loginError + ")";
    }

    public LoginFailed(LoginWay loginWay, Exception loginError) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        this.loginWay = loginWay;
        this.loginError = loginError;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final Exception getLoginError() {
        return this.loginError;
    }
}