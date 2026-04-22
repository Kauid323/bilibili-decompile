package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/AccountIntercepted;", "Ltv/danmaku/bili/fullscreen/service/IAccountResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "intercepted", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getIntercepted", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountIntercepted implements IAccountResult {
    public static final int $stable = 0;
    private final IAccountRedirect intercepted;
    private final LoginWay loginWay;

    public static /* synthetic */ AccountIntercepted copy$default(AccountIntercepted accountIntercepted, LoginWay loginWay, IAccountRedirect iAccountRedirect, int i, Object obj) {
        if ((i & 1) != 0) {
            loginWay = accountIntercepted.loginWay;
        }
        if ((i & 2) != 0) {
            iAccountRedirect = accountIntercepted.intercepted;
        }
        return accountIntercepted.copy(loginWay, iAccountRedirect);
    }

    public final LoginWay component1() {
        return this.loginWay;
    }

    public final IAccountRedirect component2() {
        return this.intercepted;
    }

    public final AccountIntercepted copy(LoginWay loginWay, IAccountRedirect iAccountRedirect) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(iAccountRedirect, "intercepted");
        return new AccountIntercepted(loginWay, iAccountRedirect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccountIntercepted) {
            AccountIntercepted accountIntercepted = (AccountIntercepted) obj;
            return Intrinsics.areEqual(this.loginWay, accountIntercepted.loginWay) && Intrinsics.areEqual(this.intercepted, accountIntercepted.intercepted);
        }
        return false;
    }

    public int hashCode() {
        return (this.loginWay.hashCode() * 31) + this.intercepted.hashCode();
    }

    public String toString() {
        LoginWay loginWay = this.loginWay;
        return "AccountIntercepted(loginWay=" + loginWay + ", intercepted=" + this.intercepted + ")";
    }

    public AccountIntercepted(LoginWay loginWay, IAccountRedirect intercepted) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(intercepted, "intercepted");
        this.loginWay = loginWay;
        this.intercepted = intercepted;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final IAccountRedirect getIntercepted() {
        return this.intercepted;
    }
}