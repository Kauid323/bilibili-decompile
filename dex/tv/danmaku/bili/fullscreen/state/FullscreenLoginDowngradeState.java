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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010!\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/FullscreenLoginDowngradeState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenActionPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "fromPage", "<init>", "(Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;)V", "getFromPage", "()Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "currentPage", "getCurrentPage", "loggedIn", "", "getLoggedIn", "()Z", "showLoading", "getShowLoading", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "loginType", "", "getLoginType", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginDowngradeState implements IFullscreenLoginPage, IFullscreenActionPage, IFullscreenLoginState {
    public static final int $stable = 8;
    private final IFullscreenLoginPage fromPage;

    public static /* synthetic */ FullscreenLoginDowngradeState copy$default(FullscreenLoginDowngradeState fullscreenLoginDowngradeState, IFullscreenLoginPage iFullscreenLoginPage, int i, Object obj) {
        if ((i & 1) != 0) {
            iFullscreenLoginPage = fullscreenLoginDowngradeState.fromPage;
        }
        return fullscreenLoginDowngradeState.copy(iFullscreenLoginPage);
    }

    public final IFullscreenLoginPage component1() {
        return this.fromPage;
    }

    public final FullscreenLoginDowngradeState copy(IFullscreenLoginPage iFullscreenLoginPage) {
        Intrinsics.checkNotNullParameter(iFullscreenLoginPage, "fromPage");
        return new FullscreenLoginDowngradeState(iFullscreenLoginPage);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FullscreenLoginDowngradeState) && Intrinsics.areEqual(this.fromPage, ((FullscreenLoginDowngradeState) obj).fromPage);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public /* synthetic */ EulaDisplayInfo getEulaDisplay() {
        return IFullscreenLoginPage.CC.$default$getEulaDisplay(this);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ IFullscreenLoginState getRoot() {
        return IFullscreenLoginState.CC.$default$getRoot(this);
    }

    public int hashCode() {
        return this.fromPage.hashCode();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ boolean isRoot() {
        boolean areEqual;
        areEqual = Intrinsics.areEqual(getRoot(), this);
        return areEqual;
    }

    public String toString() {
        return "FullscreenLoginDowngradeState(fromPage=" + this.fromPage + ")";
    }

    public FullscreenLoginDowngradeState(IFullscreenLoginPage fromPage) {
        Intrinsics.checkNotNullParameter(fromPage, "fromPage");
        this.fromPage = fromPage;
    }

    public final IFullscreenLoginPage getFromPage() {
        return this.fromPage;
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
        return false;
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
        return new ToastInfo(null, 0L, 3, null);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return "";
    }
}