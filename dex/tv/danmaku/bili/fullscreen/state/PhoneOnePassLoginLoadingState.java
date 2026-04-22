package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: PhoneOnePassLoginState.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000bR\u0012\u0010\u001f\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u0004\u0018\u00010#X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginLoadingState;", "Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;", "origin", "Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginState;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginState;)V", "getOrigin", "()Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginState;", "showLoading", "", "getShowLoading", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "loggedIn", "getLoggedIn", "loginType", "getLoginType", "()Ljava/lang/String;", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneOnePassLoginLoadingState implements IPhoneOnePassState {
    public static final int $stable = 0;
    private final PhoneOnePassLoginState origin;

    public static /* synthetic */ PhoneOnePassLoginLoadingState copy$default(PhoneOnePassLoginLoadingState phoneOnePassLoginLoadingState, PhoneOnePassLoginState phoneOnePassLoginState, int i, Object obj) {
        if ((i & 1) != 0) {
            phoneOnePassLoginState = phoneOnePassLoginLoadingState.origin;
        }
        return phoneOnePassLoginLoadingState.copy(phoneOnePassLoginState);
    }

    public final PhoneOnePassLoginState component1() {
        return this.origin;
    }

    public final PhoneOnePassLoginLoadingState copy(PhoneOnePassLoginState phoneOnePassLoginState) {
        Intrinsics.checkNotNullParameter(phoneOnePassLoginState, "origin");
        return new PhoneOnePassLoginLoadingState(phoneOnePassLoginState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PhoneOnePassLoginLoadingState) && Intrinsics.areEqual(this.origin, ((PhoneOnePassLoginLoadingState) obj).origin);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return this.origin.getCaptchaDisplay();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public EulaDisplayInfo getEulaDisplay() {
        return this.origin.getEulaDisplay();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return this.origin.getLoggedIn();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return this.origin.getLoginType();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public IAccountRedirect getRedirect() {
        return this.origin.getRedirect();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public ToastInfo getToastInfo() {
        return this.origin.getToastInfo();
    }

    public int hashCode() {
        return this.origin.hashCode();
    }

    public String toString() {
        return "PhoneOnePassLoginLoadingState(origin=" + this.origin + ")";
    }

    public PhoneOnePassLoginLoadingState(PhoneOnePassLoginState origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.origin = origin;
    }

    public final PhoneOnePassLoginState getOrigin() {
        return this.origin;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return true;
    }
}