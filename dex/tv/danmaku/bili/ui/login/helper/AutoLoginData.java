package tv.danmaku.bili.ui.login.helper;

import BottomSheetItemData$;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "", "loginInfo", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "loginWay", "Ltv/danmaku/bili/ui/login/helper/LoginWay;", "phoneInfo", "Lcom/bilibili/lib/accountsui/quick/LoginQuickManager$PhoneInfoBean;", "netTypePair", "Lkotlin/Pair;", "", "", "getPhoneInfoError", "<init>", "(Lcom/bilibili/lib/accounts/model/TInfoLogin;Ltv/danmaku/bili/ui/login/helper/LoginWay;Lcom/bilibili/lib/accountsui/quick/LoginQuickManager$PhoneInfoBean;Lkotlin/Pair;Z)V", "getLoginInfo", "()Lcom/bilibili/lib/accounts/model/TInfoLogin;", "getLoginWay", "()Ltv/danmaku/bili/ui/login/helper/LoginWay;", "getPhoneInfo", "()Lcom/bilibili/lib/accountsui/quick/LoginQuickManager$PhoneInfoBean;", "getNetTypePair", "()Lkotlin/Pair;", "getGetPhoneInfoError", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AutoLoginData {
    public static final int $stable = 8;
    private final boolean getPhoneInfoError;
    private final TInfoLogin loginInfo;
    private final LoginWay loginWay;
    private final Pair<String, Boolean> netTypePair;
    private final LoginQuickManager.PhoneInfoBean phoneInfo;

    public AutoLoginData() {
        this(null, null, null, null, false, 31, null);
    }

    public static /* synthetic */ AutoLoginData copy$default(AutoLoginData autoLoginData, TInfoLogin tInfoLogin, LoginWay loginWay, LoginQuickManager.PhoneInfoBean phoneInfoBean, Pair pair, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            tInfoLogin = autoLoginData.loginInfo;
        }
        if ((i & 2) != 0) {
            loginWay = autoLoginData.loginWay;
        }
        LoginWay loginWay2 = loginWay;
        if ((i & 4) != 0) {
            phoneInfoBean = autoLoginData.phoneInfo;
        }
        LoginQuickManager.PhoneInfoBean phoneInfoBean2 = phoneInfoBean;
        Pair<String, Boolean> pair2 = pair;
        if ((i & 8) != 0) {
            pair2 = autoLoginData.netTypePair;
        }
        Pair pair3 = pair2;
        if ((i & 16) != 0) {
            z = autoLoginData.getPhoneInfoError;
        }
        return autoLoginData.copy(tInfoLogin, loginWay2, phoneInfoBean2, pair3, z);
    }

    public final TInfoLogin component1() {
        return this.loginInfo;
    }

    public final LoginWay component2() {
        return this.loginWay;
    }

    public final LoginQuickManager.PhoneInfoBean component3() {
        return this.phoneInfo;
    }

    public final Pair<String, Boolean> component4() {
        return this.netTypePair;
    }

    public final boolean component5() {
        return this.getPhoneInfoError;
    }

    public final AutoLoginData copy(TInfoLogin tInfoLogin, LoginWay loginWay, LoginQuickManager.PhoneInfoBean phoneInfoBean, Pair<String, Boolean> pair, boolean z) {
        return new AutoLoginData(tInfoLogin, loginWay, phoneInfoBean, pair, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AutoLoginData) {
            AutoLoginData autoLoginData = (AutoLoginData) obj;
            return Intrinsics.areEqual(this.loginInfo, autoLoginData.loginInfo) && Intrinsics.areEqual(this.loginWay, autoLoginData.loginWay) && Intrinsics.areEqual(this.phoneInfo, autoLoginData.phoneInfo) && Intrinsics.areEqual(this.netTypePair, autoLoginData.netTypePair) && this.getPhoneInfoError == autoLoginData.getPhoneInfoError;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.loginInfo == null ? 0 : this.loginInfo.hashCode()) * 31) + (this.loginWay == null ? 0 : this.loginWay.hashCode())) * 31) + (this.phoneInfo == null ? 0 : this.phoneInfo.hashCode())) * 31) + (this.netTypePair != null ? this.netTypePair.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.getPhoneInfoError);
    }

    public String toString() {
        TInfoLogin tInfoLogin = this.loginInfo;
        LoginWay loginWay = this.loginWay;
        LoginQuickManager.PhoneInfoBean phoneInfoBean = this.phoneInfo;
        Pair<String, Boolean> pair = this.netTypePair;
        return "AutoLoginData(loginInfo=" + tInfoLogin + ", loginWay=" + loginWay + ", phoneInfo=" + phoneInfoBean + ", netTypePair=" + pair + ", getPhoneInfoError=" + this.getPhoneInfoError + ")";
    }

    public AutoLoginData(TInfoLogin loginInfo, LoginWay loginWay, LoginQuickManager.PhoneInfoBean phoneInfo, Pair<String, Boolean> pair, boolean getPhoneInfoError) {
        this.loginInfo = loginInfo;
        this.loginWay = loginWay;
        this.phoneInfo = phoneInfo;
        this.netTypePair = pair;
        this.getPhoneInfoError = getPhoneInfoError;
    }

    public /* synthetic */ AutoLoginData(TInfoLogin tInfoLogin, LoginWay loginWay, LoginQuickManager.PhoneInfoBean phoneInfoBean, Pair pair, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tInfoLogin, (i & 2) != 0 ? null : loginWay, (i & 4) != 0 ? null : phoneInfoBean, (i & 8) == 0 ? pair : null, (i & 16) != 0 ? false : z);
    }

    public final TInfoLogin getLoginInfo() {
        return this.loginInfo;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    public final LoginQuickManager.PhoneInfoBean getPhoneInfo() {
        return this.phoneInfo;
    }

    public final Pair<String, Boolean> getNetTypePair() {
        return this.netTypePair;
    }

    public final boolean getGetPhoneInfoError() {
        return this.getPhoneInfoError;
    }
}