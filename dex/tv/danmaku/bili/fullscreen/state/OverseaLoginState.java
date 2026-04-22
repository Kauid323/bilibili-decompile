package tv.danmaku.bili.fullscreen.state;

import BottomSheetItemData$;
import com.bilibili.lib.accounts.model.TInfoLogin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: OverseaLoginPage.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003Ja\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u000e\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00065"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/OverseaLoginState;", "Ltv/danmaku/bili/fullscreen/state/IOverseaLoginState;", "smsLoginState", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "info", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "loggedIn", "", "showLoading", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;Lcom/bilibili/lib/accounts/model/TInfoLogin;Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;ZZLtv/danmaku/bili/fullscreen/service/ToastInfo;)V", "getSmsLoginState", "()Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "getInfo", "()Lcom/bilibili/lib/accounts/model/TInfoLogin;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getLoggedIn", "()Z", "getShowLoading", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "loginType", "", "getLoginType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OverseaLoginState implements IOverseaLoginState {
    public static final int $stable = 8;
    private final LoginCaptchaInfo captchaDisplay;
    private final EulaDisplayInfo eulaDisplay;
    private final TInfoLogin info;
    private final boolean loggedIn;
    private final IAccountRedirect redirect;
    private final boolean showLoading;
    private final ISmsLoginPageState smsLoginState;
    private final ToastInfo toastInfo;

    public static /* synthetic */ OverseaLoginState copy$default(OverseaLoginState overseaLoginState, ISmsLoginPageState iSmsLoginPageState, TInfoLogin tInfoLogin, EulaDisplayInfo eulaDisplayInfo, LoginCaptchaInfo loginCaptchaInfo, IAccountRedirect iAccountRedirect, boolean z, boolean z2, ToastInfo toastInfo, int i, Object obj) {
        return overseaLoginState.copy((i & 1) != 0 ? overseaLoginState.smsLoginState : iSmsLoginPageState, (i & 2) != 0 ? overseaLoginState.info : tInfoLogin, (i & 4) != 0 ? overseaLoginState.eulaDisplay : eulaDisplayInfo, (i & 8) != 0 ? overseaLoginState.captchaDisplay : loginCaptchaInfo, (i & 16) != 0 ? overseaLoginState.redirect : iAccountRedirect, (i & 32) != 0 ? overseaLoginState.loggedIn : z, (i & 64) != 0 ? overseaLoginState.showLoading : z2, (i & BR.cover) != 0 ? overseaLoginState.toastInfo : toastInfo);
    }

    public final ISmsLoginPageState component1() {
        return this.smsLoginState;
    }

    public final TInfoLogin component2() {
        return this.info;
    }

    public final EulaDisplayInfo component3() {
        return this.eulaDisplay;
    }

    public final LoginCaptchaInfo component4() {
        return this.captchaDisplay;
    }

    public final IAccountRedirect component5() {
        return this.redirect;
    }

    public final boolean component6() {
        return this.loggedIn;
    }

    public final boolean component7() {
        return this.showLoading;
    }

    public final ToastInfo component8() {
        return this.toastInfo;
    }

    public final OverseaLoginState copy(ISmsLoginPageState iSmsLoginPageState, TInfoLogin tInfoLogin, EulaDisplayInfo eulaDisplayInfo, LoginCaptchaInfo loginCaptchaInfo, IAccountRedirect iAccountRedirect, boolean z, boolean z2, ToastInfo toastInfo) {
        Intrinsics.checkNotNullParameter(iSmsLoginPageState, "smsLoginState");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        return new OverseaLoginState(iSmsLoginPageState, tInfoLogin, eulaDisplayInfo, loginCaptchaInfo, iAccountRedirect, z, z2, toastInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OverseaLoginState) {
            OverseaLoginState overseaLoginState = (OverseaLoginState) obj;
            return Intrinsics.areEqual(this.smsLoginState, overseaLoginState.smsLoginState) && Intrinsics.areEqual(this.info, overseaLoginState.info) && Intrinsics.areEqual(this.eulaDisplay, overseaLoginState.eulaDisplay) && Intrinsics.areEqual(this.captchaDisplay, overseaLoginState.captchaDisplay) && Intrinsics.areEqual(this.redirect, overseaLoginState.redirect) && this.loggedIn == overseaLoginState.loggedIn && this.showLoading == overseaLoginState.showLoading && Intrinsics.areEqual(this.toastInfo, overseaLoginState.toastInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.smsLoginState.hashCode() * 31) + (this.info == null ? 0 : this.info.hashCode())) * 31) + (this.eulaDisplay == null ? 0 : this.eulaDisplay.hashCode())) * 31) + (this.captchaDisplay == null ? 0 : this.captchaDisplay.hashCode())) * 31) + (this.redirect != null ? this.redirect.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loggedIn)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showLoading)) * 31) + this.toastInfo.hashCode();
    }

    public String toString() {
        ISmsLoginPageState iSmsLoginPageState = this.smsLoginState;
        TInfoLogin tInfoLogin = this.info;
        EulaDisplayInfo eulaDisplayInfo = this.eulaDisplay;
        LoginCaptchaInfo loginCaptchaInfo = this.captchaDisplay;
        IAccountRedirect iAccountRedirect = this.redirect;
        boolean z = this.loggedIn;
        boolean z2 = this.showLoading;
        return "OverseaLoginState(smsLoginState=" + iSmsLoginPageState + ", info=" + tInfoLogin + ", eulaDisplay=" + eulaDisplayInfo + ", captchaDisplay=" + loginCaptchaInfo + ", redirect=" + iAccountRedirect + ", loggedIn=" + z + ", showLoading=" + z2 + ", toastInfo=" + this.toastInfo + ")";
    }

    public OverseaLoginState(ISmsLoginPageState smsLoginState, TInfoLogin info, EulaDisplayInfo eulaDisplay, LoginCaptchaInfo captchaDisplay, IAccountRedirect redirect, boolean loggedIn, boolean showLoading, ToastInfo toastInfo) {
        Intrinsics.checkNotNullParameter(smsLoginState, "smsLoginState");
        Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
        this.smsLoginState = smsLoginState;
        this.info = info;
        this.eulaDisplay = eulaDisplay;
        this.captchaDisplay = captchaDisplay;
        this.redirect = redirect;
        this.loggedIn = loggedIn;
        this.showLoading = showLoading;
        this.toastInfo = toastInfo;
    }

    public /* synthetic */ OverseaLoginState(ISmsLoginPageState iSmsLoginPageState, TInfoLogin tInfoLogin, EulaDisplayInfo eulaDisplayInfo, LoginCaptchaInfo loginCaptchaInfo, IAccountRedirect iAccountRedirect, boolean z, boolean z2, ToastInfo toastInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSmsLoginPageState, (i & 2) != 0 ? null : tInfoLogin, (i & 4) != 0 ? null : eulaDisplayInfo, (i & 8) != 0 ? null : loginCaptchaInfo, (i & 16) == 0 ? iAccountRedirect : null, (i & 32) != 0 ? false : z, (i & 64) == 0 ? z2 : false, (i & BR.cover) != 0 ? new ToastInfo(null, 0L, 3, null) : toastInfo);
    }

    public final ISmsLoginPageState getSmsLoginState() {
        return this.smsLoginState;
    }

    public final TInfoLogin getInfo() {
        return this.info;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public EulaDisplayInfo getEulaDisplay() {
        return this.eulaDisplay;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return this.captchaDisplay;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public IAccountRedirect getRedirect() {
        return this.redirect;
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
    public ToastInfo getToastInfo() {
        return this.toastInfo;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return "sms_fullscreen_new";
    }
}