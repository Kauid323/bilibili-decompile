package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/AccountSucceed;", "Ltv/danmaku/bili/fullscreen/service/IAccountResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountSucceed implements IAccountResult {
    public static final int $stable = 8;
    private final LoginWay loginWay;

    public static /* synthetic */ AccountSucceed copy$default(AccountSucceed accountSucceed, LoginWay loginWay, int i, Object obj) {
        if ((i & 1) != 0) {
            loginWay = accountSucceed.loginWay;
        }
        return accountSucceed.copy(loginWay);
    }

    public final LoginWay component1() {
        return this.loginWay;
    }

    public final AccountSucceed copy(LoginWay loginWay) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        return new AccountSucceed(loginWay);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AccountSucceed) && Intrinsics.areEqual(this.loginWay, ((AccountSucceed) obj).loginWay);
    }

    public int hashCode() {
        return this.loginWay.hashCode();
    }

    public String toString() {
        return "AccountSucceed(loginWay=" + this.loginWay + ")";
    }

    public AccountSucceed(LoginWay loginWay) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        this.loginWay = loginWay;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }
}