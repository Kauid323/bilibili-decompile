package tv.danmaku.bili.fullscreen.service;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/LoginSucceed;", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "accessKey", "", "newUser", "", "verifyUrl", "verifyStatus", "", "<init>", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ljava/lang/String;ZLjava/lang/String;I)V", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getAccessKey", "()Ljava/lang/String;", "getNewUser", "()Z", "getVerifyUrl", "getVerifyStatus", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginSucceed implements ILoginResult {
    public static final int $stable = 8;
    private final String accessKey;
    private final LoginWay loginWay;
    private final boolean newUser;
    private final int verifyStatus;
    private final String verifyUrl;

    public static /* synthetic */ LoginSucceed copy$default(LoginSucceed loginSucceed, LoginWay loginWay, String str, boolean z, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            loginWay = loginSucceed.loginWay;
        }
        if ((i2 & 2) != 0) {
            str = loginSucceed.accessKey;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            z = loginSucceed.newUser;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str2 = loginSucceed.verifyUrl;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            i = loginSucceed.verifyStatus;
        }
        return loginSucceed.copy(loginWay, str3, z2, str4, i);
    }

    public final LoginWay component1() {
        return this.loginWay;
    }

    public final String component2() {
        return this.accessKey;
    }

    public final boolean component3() {
        return this.newUser;
    }

    public final String component4() {
        return this.verifyUrl;
    }

    public final int component5() {
        return this.verifyStatus;
    }

    public final LoginSucceed copy(LoginWay loginWay, String str, boolean z, String str2, int i) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(str, "accessKey");
        Intrinsics.checkNotNullParameter(str2, "verifyUrl");
        return new LoginSucceed(loginWay, str, z, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoginSucceed) {
            LoginSucceed loginSucceed = (LoginSucceed) obj;
            return Intrinsics.areEqual(this.loginWay, loginSucceed.loginWay) && Intrinsics.areEqual(this.accessKey, loginSucceed.accessKey) && this.newUser == loginSucceed.newUser && Intrinsics.areEqual(this.verifyUrl, loginSucceed.verifyUrl) && this.verifyStatus == loginSucceed.verifyStatus;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.loginWay.hashCode() * 31) + this.accessKey.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.newUser)) * 31) + this.verifyUrl.hashCode()) * 31) + this.verifyStatus;
    }

    public String toString() {
        LoginWay loginWay = this.loginWay;
        String str = this.accessKey;
        boolean z = this.newUser;
        String str2 = this.verifyUrl;
        return "LoginSucceed(loginWay=" + loginWay + ", accessKey=" + str + ", newUser=" + z + ", verifyUrl=" + str2 + ", verifyStatus=" + this.verifyStatus + ")";
    }

    public LoginSucceed(LoginWay loginWay, String accessKey, boolean newUser, String verifyUrl, int verifyStatus) {
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(verifyUrl, "verifyUrl");
        this.loginWay = loginWay;
        this.accessKey = accessKey;
        this.newUser = newUser;
        this.verifyUrl = verifyUrl;
        this.verifyStatus = verifyStatus;
    }

    public /* synthetic */ LoginSucceed(LoginWay loginWay, String str, boolean z, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(loginWay, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? 0 : i);
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final boolean getNewUser() {
        return this.newUser;
    }

    public final String getVerifyUrl() {
        return this.verifyUrl;
    }

    public final int getVerifyStatus() {
        return this.verifyStatus;
    }
}