package tv.danmaku.bili.fullscreen.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.stat.Phone;

/* compiled from: PhoneOnePassLoginState.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000eHÆ\u0003JS\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u00100\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010 \u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00066"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginState;", "Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;", "phone", "Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "agreementChecked", "", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "loggedIn", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "<init>", "(Ltv/danmaku/bili/fullscreen/service/PhoneInfo;ZLtv/danmaku/bili/fullscreen/stat/LoginWay;ZLtv/danmaku/bili/fullscreen/service/IAccountRedirect;Ltv/danmaku/bili/fullscreen/service/ToastInfo;Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;)V", "getPhone", "()Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "getAgreementChecked", "()Z", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "getLoggedIn", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "showLoading", "getShowLoading", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "loginType", "", "getLoginType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneOnePassLoginState implements IPhoneOnePassState {
    public static final int $stable = 0;
    private final boolean agreementChecked;
    private final EulaDisplayInfo eulaDisplay;
    private final boolean loggedIn;
    private final LoginWay loginWay;
    private final PhoneInfo phone;
    private final IAccountRedirect redirect;
    private final ToastInfo toastInfo;

    public static /* synthetic */ PhoneOnePassLoginState copy$default(PhoneOnePassLoginState phoneOnePassLoginState, PhoneInfo phoneInfo, boolean z, LoginWay loginWay, boolean z2, IAccountRedirect iAccountRedirect, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            phoneInfo = phoneOnePassLoginState.phone;
        }
        if ((i & 2) != 0) {
            z = phoneOnePassLoginState.agreementChecked;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            loginWay = phoneOnePassLoginState.loginWay;
        }
        LoginWay loginWay2 = loginWay;
        if ((i & 8) != 0) {
            z2 = phoneOnePassLoginState.loggedIn;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            iAccountRedirect = phoneOnePassLoginState.redirect;
        }
        IAccountRedirect iAccountRedirect2 = iAccountRedirect;
        if ((i & 32) != 0) {
            toastInfo = phoneOnePassLoginState.toastInfo;
        }
        ToastInfo toastInfo2 = toastInfo;
        if ((i & 64) != 0) {
            eulaDisplayInfo = phoneOnePassLoginState.eulaDisplay;
        }
        return phoneOnePassLoginState.copy(phoneInfo, z3, loginWay2, z4, iAccountRedirect2, toastInfo2, eulaDisplayInfo);
    }

    public final PhoneInfo component1() {
        return this.phone;
    }

    public final boolean component2() {
        return this.agreementChecked;
    }

    public final LoginWay component3() {
        return this.loginWay;
    }

    public final boolean component4() {
        return this.loggedIn;
    }

    public final IAccountRedirect component5() {
        return this.redirect;
    }

    public final ToastInfo component6() {
        return this.toastInfo;
    }

    public final EulaDisplayInfo component7() {
        return this.eulaDisplay;
    }

    public final PhoneOnePassLoginState copy(PhoneInfo phoneInfo, boolean z, LoginWay loginWay, boolean z2, IAccountRedirect iAccountRedirect, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo) {
        Intrinsics.checkNotNullParameter(phoneInfo, "phone");
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        return new PhoneOnePassLoginState(phoneInfo, z, loginWay, z2, iAccountRedirect, toastInfo, eulaDisplayInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PhoneOnePassLoginState) {
            PhoneOnePassLoginState phoneOnePassLoginState = (PhoneOnePassLoginState) obj;
            return Intrinsics.areEqual(this.phone, phoneOnePassLoginState.phone) && this.agreementChecked == phoneOnePassLoginState.agreementChecked && Intrinsics.areEqual(this.loginWay, phoneOnePassLoginState.loginWay) && this.loggedIn == phoneOnePassLoginState.loggedIn && Intrinsics.areEqual(this.redirect, phoneOnePassLoginState.redirect) && Intrinsics.areEqual(this.toastInfo, phoneOnePassLoginState.toastInfo) && Intrinsics.areEqual(this.eulaDisplay, phoneOnePassLoginState.eulaDisplay);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.phone.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.agreementChecked)) * 31) + this.loginWay.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loggedIn)) * 31) + (this.redirect == null ? 0 : this.redirect.hashCode())) * 31) + this.toastInfo.hashCode()) * 31) + (this.eulaDisplay != null ? this.eulaDisplay.hashCode() : 0);
    }

    public String toString() {
        PhoneInfo phoneInfo = this.phone;
        boolean z = this.agreementChecked;
        LoginWay loginWay = this.loginWay;
        boolean z2 = this.loggedIn;
        IAccountRedirect iAccountRedirect = this.redirect;
        ToastInfo toastInfo = this.toastInfo;
        return "PhoneOnePassLoginState(phone=" + phoneInfo + ", agreementChecked=" + z + ", loginWay=" + loginWay + ", loggedIn=" + z2 + ", redirect=" + iAccountRedirect + ", toastInfo=" + toastInfo + ", eulaDisplay=" + this.eulaDisplay + ")";
    }

    public PhoneOnePassLoginState(PhoneInfo phone, boolean agreementChecked, LoginWay loginWay, boolean loggedIn, IAccountRedirect redirect, ToastInfo toastInfo, EulaDisplayInfo eulaDisplay) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        this.phone = phone;
        this.agreementChecked = agreementChecked;
        this.loginWay = loginWay;
        this.loggedIn = loggedIn;
        this.redirect = redirect;
        this.toastInfo = toastInfo;
        this.eulaDisplay = eulaDisplay;
    }

    public /* synthetic */ PhoneOnePassLoginState(PhoneInfo phoneInfo, boolean z, LoginWay loginWay, boolean z2, IAccountRedirect iAccountRedirect, ToastInfo toastInfo, EulaDisplayInfo eulaDisplayInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(phoneInfo, (i & 2) != 0 ? false : z, (i & 4) != 0 ? Phone.PhoneLogin.INSTANCE : loginWay, (i & 8) == 0 ? z2 : false, (i & 16) != 0 ? null : iAccountRedirect, (i & 32) != 0 ? new ToastInfo(null, 0L, 3, null) : toastInfo, (i & 64) == 0 ? eulaDisplayInfo : null);
    }

    public final PhoneInfo getPhone() {
        return this.phone;
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
    public LoginCaptchaInfo getCaptchaDisplay() {
        return null;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return "onepass_fullscreen_new";
    }
}