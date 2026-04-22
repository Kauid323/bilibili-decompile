package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.EulaDisplayInfo;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;
import tv.danmaku.bili.fullscreen.service.LoginCaptchaInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPhoneIdlePage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "<init>", "()V", "currentPage", "getCurrentPage", "()Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "loggedIn", "", "getLoggedIn", "()Z", "showLoading", "getShowLoading", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "loginType", "", "getLoginType", "()Ljava/lang/String;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginPhoneIdlePage implements IFullscreenLoginPage, IFullscreenLoginState {
    public static final int $stable = 0;
    public static final FullscreenLoginPhoneIdlePage INSTANCE = new FullscreenLoginPhoneIdlePage();
    private static final ToastInfo toastInfo = new ToastInfo(null, 0, 3, null);

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public /* synthetic */ EulaDisplayInfo getEulaDisplay() {
        return IFullscreenLoginPage.CC.$default$getEulaDisplay(this);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ IFullscreenLoginState getRoot() {
        return IFullscreenLoginState.CC.$default$getRoot(this);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ boolean isRoot() {
        boolean areEqual;
        areEqual = Intrinsics.areEqual(getRoot(), this);
        return areEqual;
    }

    private FullscreenLoginPhoneIdlePage() {
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public IFullscreenLoginPage getCurrentPage() {
        return this;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getLoggedIn() {
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public boolean getShowLoading() {
        return true;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public IAccountRedirect getRedirect() {
        return null;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public LoginCaptchaInfo getCaptchaDisplay() {
        return null;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public ToastInfo getToastInfo() {
        return toastInfo;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return "";
    }
}