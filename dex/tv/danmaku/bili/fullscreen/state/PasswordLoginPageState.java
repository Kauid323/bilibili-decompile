package tv.danmaku.bili.fullscreen.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Password;

/* compiled from: PasswordLoginPageState.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003Ji\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u00102\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0018R\u0014\u0010&\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0015¨\u00068"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/PasswordLoginPageState;", "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginPage;", "account", "", "password", "agreementChecked", "", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "loggedIn", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLtv/danmaku/bili/fullscreen/stat/LoginWay;ZLtv/danmaku/bili/fullscreen/service/IAccountRedirect;Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;Ltv/danmaku/bili/fullscreen/service/ToastInfo;Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;)V", "getAccount", "()Ljava/lang/String;", "getPassword", "getAgreementChecked", "()Z", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getLoggedIn", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "showLoading", "getShowLoading", "loginType", "getLoginType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PasswordLoginPageState implements IPasswordLoginPage {
    public static final int $stable = 0;
    private final String account;
    private final boolean agreementChecked;
    private final LoginCaptchaInfo captchaDisplay;
    private final EulaDisplayInfo eulaDisplay;
    private final boolean loggedIn;
    private final LoginWay loginWay;
    private final String password;
    private final IAccountRedirect redirect;
    private final ToastInfo toastInfo;

    public PasswordLoginPageState() {
        this(null, null, false, null, false, null, null, null, null, BR.roleTitle, null);
    }

    public static /* synthetic */ PasswordLoginPageState copy$default(PasswordLoginPageState passwordLoginPageState, String str, String str2, boolean z, LoginWay loginWay, boolean z2, IAccountRedirect iAccountRedirect, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, int i, Object obj) {
        return passwordLoginPageState.copy((i & 1) != 0 ? passwordLoginPageState.account : str, (i & 2) != 0 ? passwordLoginPageState.password : str2, (i & 4) != 0 ? passwordLoginPageState.agreementChecked : z, (i & 8) != 0 ? passwordLoginPageState.loginWay : loginWay, (i & 16) != 0 ? passwordLoginPageState.loggedIn : z2, (i & 32) != 0 ? passwordLoginPageState.redirect : iAccountRedirect, (i & 64) != 0 ? passwordLoginPageState.captchaDisplay : loginCaptchaInfo, (i & BR.cover) != 0 ? passwordLoginPageState.toastInfo : toastInfo, (i & BR.hallEnterHotText) != 0 ? passwordLoginPageState.eulaDisplay : eulaDisplayInfo);
    }

    public final String component1() {
        return this.account;
    }

    public final String component2() {
        return this.password;
    }

    public final boolean component3() {
        return this.agreementChecked;
    }

    public final LoginWay component4() {
        return this.loginWay;
    }

    public final boolean component5() {
        return this.loggedIn;
    }

    public final IAccountRedirect component6() {
        return this.redirect;
    }

    public final LoginCaptchaInfo component7() {
        return this.captchaDisplay;
    }

    public final ToastInfo component8() {
        return this.toastInfo;
    }

    public final EulaDisplayInfo component9() {
        return this.eulaDisplay;
    }

    public final PasswordLoginPageState copy(String str, String str2, boolean z, LoginWay loginWay, boolean z2, IAccountRedirect iAccountRedirect, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo) {
        Intrinsics.checkNotNullParameter(str, "account");
        Intrinsics.checkNotNullParameter(str2, "password");
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        return new PasswordLoginPageState(str, str2, z, loginWay, z2, iAccountRedirect, loginCaptchaInfo, toastInfo, eulaDisplayInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PasswordLoginPageState) {
            PasswordLoginPageState passwordLoginPageState = (PasswordLoginPageState) obj;
            return Intrinsics.areEqual(this.account, passwordLoginPageState.account) && Intrinsics.areEqual(this.password, passwordLoginPageState.password) && this.agreementChecked == passwordLoginPageState.agreementChecked && Intrinsics.areEqual(this.loginWay, passwordLoginPageState.loginWay) && this.loggedIn == passwordLoginPageState.loggedIn && Intrinsics.areEqual(this.redirect, passwordLoginPageState.redirect) && Intrinsics.areEqual(this.captchaDisplay, passwordLoginPageState.captchaDisplay) && Intrinsics.areEqual(this.toastInfo, passwordLoginPageState.toastInfo) && Intrinsics.areEqual(this.eulaDisplay, passwordLoginPageState.eulaDisplay);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.account.hashCode() * 31) + this.password.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.agreementChecked)) * 31) + this.loginWay.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loggedIn)) * 31) + (this.redirect == null ? 0 : this.redirect.hashCode())) * 31) + (this.captchaDisplay == null ? 0 : this.captchaDisplay.hashCode())) * 31) + this.toastInfo.hashCode()) * 31) + (this.eulaDisplay != null ? this.eulaDisplay.hashCode() : 0);
    }

    public String toString() {
        String str = this.account;
        String str2 = this.password;
        boolean z = this.agreementChecked;
        LoginWay loginWay = this.loginWay;
        boolean z2 = this.loggedIn;
        IAccountRedirect iAccountRedirect = this.redirect;
        LoginCaptchaInfo loginCaptchaInfo = this.captchaDisplay;
        ToastInfo toastInfo = this.toastInfo;
        return "PasswordLoginPageState(account=" + str + ", password=" + str2 + ", agreementChecked=" + z + ", loginWay=" + loginWay + ", loggedIn=" + z2 + ", redirect=" + iAccountRedirect + ", captchaDisplay=" + loginCaptchaInfo + ", toastInfo=" + toastInfo + ", eulaDisplay=" + this.eulaDisplay + ")";
    }

    public PasswordLoginPageState(String account, String password, boolean agreementChecked, LoginWay loginWay, boolean loggedIn, IAccountRedirect redirect, LoginCaptchaInfo captchaDisplay, ToastInfo toastInfo, EulaDisplayInfo eulaDisplay) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        this.account = account;
        this.password = password;
        this.agreementChecked = agreementChecked;
        this.loginWay = loginWay;
        this.loggedIn = loggedIn;
        this.redirect = redirect;
        this.captchaDisplay = captchaDisplay;
        this.toastInfo = toastInfo;
        this.eulaDisplay = eulaDisplay;
    }

    public /* synthetic */ PasswordLoginPageState(String str, String str2, boolean z, LoginWay loginWay, boolean z2, IAccountRedirect iAccountRedirect, LoginCaptchaInfo loginCaptchaInfo, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? false : z, (i & 8) != 0 ? Password.PasswordLogin.INSTANCE : loginWay, (i & 16) == 0 ? z2 : false, (i & 32) != 0 ? null : iAccountRedirect, (i & 64) != 0 ? null : loginCaptchaInfo, (i & BR.cover) != 0 ? new ToastInfo(null, 0L, 3, null) : toastInfo, (i & BR.hallEnterHotText) == 0 ? eulaDisplayInfo : null);
    }

    public final String getAccount() {
        return this.account;
    }

    public final String getPassword() {
        return this.password;
    }

    public final boolean getAgreementChecked() {
        return this.agreementChecked;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return this.loggedIn;
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

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public EulaDisplayInfo getEulaDisplay() {
        return this.eulaDisplay;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return "pwd_fullscreen_new";
    }
}