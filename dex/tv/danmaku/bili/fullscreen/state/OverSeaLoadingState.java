package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.Google;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: OverseaLoginPage.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u000fR\u0012\u0010$\u001a\u00020\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u0004\u0018\u00010(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/OverSeaLoadingState;", "Ltv/danmaku/bili/fullscreen/state/IOverseaLoginState;", "original", "Ltv/danmaku/bili/fullscreen/state/OverseaLoginState;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/OverseaLoginState;Ltv/danmaku/bili/fullscreen/stat/LoginWay;)V", "getOriginal", "()Ltv/danmaku/bili/fullscreen/state/OverseaLoginState;", "getLoginWay", "()Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "showLoading", "", "getShowLoading", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "loggedIn", "getLoggedIn", "loginType", "getLoginType", "()Ljava/lang/String;", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OverSeaLoadingState implements IOverseaLoginState {
    public static final int $stable = 8;
    private final LoginWay loginWay;
    private final OverseaLoginState original;

    public static /* synthetic */ OverSeaLoadingState copy$default(OverSeaLoadingState overSeaLoadingState, OverseaLoginState overseaLoginState, LoginWay loginWay, int i, Object obj) {
        if ((i & 1) != 0) {
            overseaLoginState = overSeaLoadingState.original;
        }
        if ((i & 2) != 0) {
            loginWay = overSeaLoadingState.loginWay;
        }
        return overSeaLoadingState.copy(overseaLoginState, loginWay);
    }

    public final OverseaLoginState component1() {
        return this.original;
    }

    public final LoginWay component2() {
        return this.loginWay;
    }

    public final OverSeaLoadingState copy(OverseaLoginState overseaLoginState, LoginWay loginWay) {
        Intrinsics.checkNotNullParameter(overseaLoginState, "original");
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        return new OverSeaLoadingState(overseaLoginState, loginWay);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OverSeaLoadingState) {
            OverSeaLoadingState overSeaLoadingState = (OverSeaLoadingState) obj;
            return Intrinsics.areEqual(this.original, overSeaLoadingState.original) && Intrinsics.areEqual(this.loginWay, overSeaLoadingState.loginWay);
        }
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return this.original.getCaptchaDisplay();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public EulaDisplayInfo getEulaDisplay() {
        return this.original.getEulaDisplay();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return this.original.getLoggedIn();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return this.original.getLoginType();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public IAccountRedirect getRedirect() {
        return this.original.getRedirect();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public ToastInfo getToastInfo() {
        return this.original.getToastInfo();
    }

    public int hashCode() {
        return (this.original.hashCode() * 31) + this.loginWay.hashCode();
    }

    public String toString() {
        OverseaLoginState overseaLoginState = this.original;
        return "OverSeaLoadingState(original=" + overseaLoginState + ", loginWay=" + this.loginWay + ")";
    }

    public OverSeaLoadingState(OverseaLoginState original, LoginWay loginWay) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(loginWay, "loginWay");
        this.original = original;
        this.loginWay = loginWay;
    }

    public /* synthetic */ OverSeaLoadingState(OverseaLoginState overseaLoginState, Google.GoogleLogin googleLogin, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(overseaLoginState, (i & 2) != 0 ? Google.GoogleLogin.INSTANCE : googleLogin);
    }

    public final OverseaLoginState getOriginal() {
        return this.original;
    }

    public final LoginWay getLoginWay() {
        return this.loginWay;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return true;
    }
}