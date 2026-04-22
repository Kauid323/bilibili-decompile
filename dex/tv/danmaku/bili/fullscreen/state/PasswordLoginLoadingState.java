package tv.danmaku.bili.fullscreen.state;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: PasswordLoginPageState.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u0010R\u0012\u0010$\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u0004\u0018\u00010(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/PasswordLoginLoadingState;", "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginPage;", "original", "Ltv/danmaku/bili/fullscreen/state/PasswordLoginPageState;", "captchaInput", "", "", "<init>", "(Ltv/danmaku/bili/fullscreen/state/PasswordLoginPageState;Ljava/util/Map;)V", "getOriginal", "()Ltv/danmaku/bili/fullscreen/state/PasswordLoginPageState;", "getCaptchaInput", "()Ljava/util/Map;", "showLoading", "", "getShowLoading", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "eulaDisplay", "Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "getEulaDisplay", "()Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "loggedIn", "getLoggedIn", "loginType", "getLoginType", "()Ljava/lang/String;", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PasswordLoginLoadingState implements IPasswordLoginPage {
    public static final int $stable = 8;
    private final Map<String, String> captchaInput;
    private final PasswordLoginPageState original;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PasswordLoginLoadingState copy$default(PasswordLoginLoadingState passwordLoginLoadingState, PasswordLoginPageState passwordLoginPageState, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            passwordLoginPageState = passwordLoginLoadingState.original;
        }
        if ((i & 2) != 0) {
            map = passwordLoginLoadingState.captchaInput;
        }
        return passwordLoginLoadingState.copy(passwordLoginPageState, map);
    }

    public final PasswordLoginPageState component1() {
        return this.original;
    }

    public final Map<String, String> component2() {
        return this.captchaInput;
    }

    public final PasswordLoginLoadingState copy(PasswordLoginPageState passwordLoginPageState, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(passwordLoginPageState, "original");
        Intrinsics.checkNotNullParameter(map, "captchaInput");
        return new PasswordLoginLoadingState(passwordLoginPageState, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PasswordLoginLoadingState) {
            PasswordLoginLoadingState passwordLoginLoadingState = (PasswordLoginLoadingState) obj;
            return Intrinsics.areEqual(this.original, passwordLoginLoadingState.original) && Intrinsics.areEqual(this.captchaInput, passwordLoginLoadingState.captchaInput);
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
        return (this.original.hashCode() * 31) + this.captchaInput.hashCode();
    }

    public String toString() {
        PasswordLoginPageState passwordLoginPageState = this.original;
        return "PasswordLoginLoadingState(original=" + passwordLoginPageState + ", captchaInput=" + this.captchaInput + ")";
    }

    public PasswordLoginLoadingState(PasswordLoginPageState original, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(map, "captchaInput");
        this.original = original;
        this.captchaInput = map;
    }

    public /* synthetic */ PasswordLoginLoadingState(PasswordLoginPageState passwordLoginPageState, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(passwordLoginPageState, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final PasswordLoginPageState getOriginal() {
        return this.original;
    }

    public final Map<String, String> getCaptchaInput() {
        return this.captchaInput;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return true;
    }
}