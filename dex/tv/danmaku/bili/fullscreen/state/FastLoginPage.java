package tv.danmaku.bili.fullscreen.state;

import BottomSheetItemData$;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: FastLoginPage.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010,\u001a\u00020\u0011HÆ\u0003Ji\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/FastLoginPage;", "Ltv/danmaku/bili/fullscreen/state/IFastLoginPage;", "account", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "agreementChecked", "", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "loggedIn", "showLoading", "loginType", "", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "<init>", "(Lcom/bilibili/lib/accounts/model/SimpleAccountItem;ZLtv/danmaku/bili/fullscreen/service/EulaDisplayInfo;ZZLjava/lang/String;Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;Ltv/danmaku/bili/fullscreen/service/ToastInfo;)V", "getAccount", "()Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "getAgreementChecked", "()Z", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getLoggedIn", "getShowLoading", "getLoginType", "()Ljava/lang/String;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FastLoginPage implements IFastLoginPage {
    public static final int $stable = 8;
    private final SimpleAccountItem account;
    private final boolean agreementChecked;
    private final LoginCaptchaInfo captchaDisplay;
    private final EulaDisplayInfo eulaDisplay;
    private final boolean loggedIn;
    private final String loginType;
    private final IAccountRedirect redirect;
    private final boolean showLoading;
    private final ToastInfo toastInfo;

    public FastLoginPage() {
        this(null, false, null, false, false, null, null, null, null, BR.roleTitle, null);
    }

    public final SimpleAccountItem component1() {
        return this.account;
    }

    public final boolean component2() {
        return this.agreementChecked;
    }

    public final EulaDisplayInfo component3() {
        return this.eulaDisplay;
    }

    public final boolean component4() {
        return this.loggedIn;
    }

    public final boolean component5() {
        return this.showLoading;
    }

    public final String component6() {
        return this.loginType;
    }

    public final IAccountRedirect component7() {
        return this.redirect;
    }

    public final LoginCaptchaInfo component8() {
        return this.captchaDisplay;
    }

    public final ToastInfo component9() {
        return this.toastInfo;
    }

    public final FastLoginPage copy(SimpleAccountItem simpleAccountItem, boolean z, EulaDisplayInfo eulaDisplayInfo, boolean z2, boolean z3, String str, IAccountRedirect iAccountRedirect, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo) {
        Intrinsics.checkNotNullParameter(simpleAccountItem, "account");
        Intrinsics.checkNotNullParameter(str, "loginType");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        return new FastLoginPage(simpleAccountItem, z, eulaDisplayInfo, z2, z3, str, iAccountRedirect, loginCaptchaInfo, toastInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FastLoginPage) {
            FastLoginPage fastLoginPage = (FastLoginPage) obj;
            return Intrinsics.areEqual(this.account, fastLoginPage.account) && this.agreementChecked == fastLoginPage.agreementChecked && Intrinsics.areEqual(this.eulaDisplay, fastLoginPage.eulaDisplay) && this.loggedIn == fastLoginPage.loggedIn && this.showLoading == fastLoginPage.showLoading && Intrinsics.areEqual(this.loginType, fastLoginPage.loginType) && Intrinsics.areEqual(this.redirect, fastLoginPage.redirect) && Intrinsics.areEqual(this.captchaDisplay, fastLoginPage.captchaDisplay) && Intrinsics.areEqual(this.toastInfo, fastLoginPage.toastInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.account.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.agreementChecked)) * 31) + (this.eulaDisplay == null ? 0 : this.eulaDisplay.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loggedIn)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showLoading)) * 31) + this.loginType.hashCode()) * 31) + (this.redirect == null ? 0 : this.redirect.hashCode())) * 31) + (this.captchaDisplay != null ? this.captchaDisplay.hashCode() : 0)) * 31) + this.toastInfo.hashCode();
    }

    public String toString() {
        SimpleAccountItem simpleAccountItem = this.account;
        boolean z = this.agreementChecked;
        EulaDisplayInfo eulaDisplayInfo = this.eulaDisplay;
        boolean z2 = this.loggedIn;
        boolean z3 = this.showLoading;
        String str = this.loginType;
        IAccountRedirect iAccountRedirect = this.redirect;
        LoginCaptchaInfo loginCaptchaInfo = this.captchaDisplay;
        return "FastLoginPage(account=" + simpleAccountItem + ", agreementChecked=" + z + ", eulaDisplay=" + eulaDisplayInfo + ", loggedIn=" + z2 + ", showLoading=" + z3 + ", loginType=" + str + ", redirect=" + iAccountRedirect + ", captchaDisplay=" + loginCaptchaInfo + ", toastInfo=" + this.toastInfo + ")";
    }

    public FastLoginPage(SimpleAccountItem account, boolean agreementChecked, EulaDisplayInfo eulaDisplay, boolean loggedIn, boolean showLoading, String loginType, IAccountRedirect redirect, LoginCaptchaInfo captchaDisplay, ToastInfo toastInfo) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        this.account = account;
        this.agreementChecked = agreementChecked;
        this.eulaDisplay = eulaDisplay;
        this.loggedIn = loggedIn;
        this.showLoading = showLoading;
        this.loginType = loginType;
        this.redirect = redirect;
        this.captchaDisplay = captchaDisplay;
        this.toastInfo = toastInfo;
    }

    public /* synthetic */ FastLoginPage(SimpleAccountItem simpleAccountItem, boolean z, EulaDisplayInfo eulaDisplayInfo, boolean z2, boolean z3, String str, IAccountRedirect iAccountRedirect, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SimpleAccountItem(0L, "", "") : simpleAccountItem, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : eulaDisplayInfo, (i & 8) != 0 ? false : z2, (i & 16) == 0 ? z3 : false, (i & 32) != 0 ? "fast_fullscreen" : str, (i & 64) != 0 ? null : iAccountRedirect, (i & BR.cover) == 0 ? loginCaptchaInfo : null, (i & BR.hallEnterHotText) != 0 ? new ToastInfo(null, 0L, 3, null) : toastInfo);
    }

    public final SimpleAccountItem getAccount() {
        return this.account;
    }

    public final boolean getAgreementChecked() {
        return this.agreementChecked;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public EulaDisplayInfo getEulaDisplay() {
        return this.eulaDisplay;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return this.showLoading;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return this.loginType;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public IAccountRedirect getRedirect() {
        return this.redirect;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return this.captchaDisplay;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public ToastInfo getToastInfo() {
        return this.toastInfo;
    }
}