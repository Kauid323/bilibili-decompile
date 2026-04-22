package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/LoginRedirected;", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginRedirected implements ILoginResult {
    public static final int $stable = 0;
    private final LoginWay loginWay;
    private final IAccountRedirect redirect;

    public static /* synthetic */ LoginRedirected copy$default(LoginRedirected loginRedirected, LoginWay loginWay, IAccountRedirect iAccountRedirect, int i, Object obj) {
        if ((i & 1) != 0) {
            loginWay = loginRedirected.loginWay;
        }
        if ((i & 2) != 0) {
            iAccountRedirect = loginRedirected.redirect;
        }
        return loginRedirected.copy(loginWay, iAccountRedirect);
    }

    public final LoginWay component1() {
        return this.loginWay;
    }

    public final IAccountRedirect component2() {
        return this.redirect;
    }

    public final LoginRedirected copy(LoginWay loginWay, IAccountRedirect iAccountRedirect) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(iAccountRedirect, "redirect");
        return new LoginRedirected(loginWay, iAccountRedirect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoginRedirected) {
            LoginRedirected loginRedirected = (LoginRedirected) obj;
            return Intrinsics.areEqual(this.loginWay, loginRedirected.loginWay) && Intrinsics.areEqual(this.redirect, loginRedirected.redirect);
        }
        return false;
    }

    public int hashCode() {
        return (this.loginWay.hashCode() * 31) + this.redirect.hashCode();
    }

    public String toString() {
        LoginWay loginWay = this.loginWay;
        return "LoginRedirected(loginWay=" + loginWay + ", redirect=" + this.redirect + ")";
    }

    public LoginRedirected(LoginWay loginWay, IAccountRedirect redirect) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(redirect, "redirect");
        this.loginWay = loginWay;
        this.redirect = redirect;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final IAccountRedirect getRedirect() {
        return this.redirect;
    }
}