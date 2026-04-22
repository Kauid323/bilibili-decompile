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
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/FullscreenLoginIdlePage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenActionPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "skippable", "", "<init>", "(Z)V", "getSkippable", "()Z", "currentPage", "getCurrentPage", "()Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "loggedIn", "getLoggedIn", "showLoading", "getShowLoading", "redirect", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "getRedirect", "()Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "captchaDisplay", "Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "getCaptchaDisplay", "()Ltv/danmaku/bili/fullscreen/service/LoginCaptchaInfo;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "loginType", "", "getLoginType", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginIdlePage implements IFullscreenLoginPage, IFullscreenActionPage, IFullscreenLoginState {
    public static final int $stable = 0;
    private final boolean skippable;
    private final ToastInfo toastInfo;

    public FullscreenLoginIdlePage() {
        this(false, 1, null);
    }

    public static /* synthetic */ FullscreenLoginIdlePage copy$default(FullscreenLoginIdlePage fullscreenLoginIdlePage, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fullscreenLoginIdlePage.skippable;
        }
        return fullscreenLoginIdlePage.copy(z);
    }

    public final boolean component1() {
        return this.skippable;
    }

    public final FullscreenLoginIdlePage copy(boolean z) {
        return new FullscreenLoginIdlePage(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FullscreenLoginIdlePage) && this.skippable == ((FullscreenLoginIdlePage) obj).skippable;
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
        return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.skippable);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ boolean isRoot() {
        boolean areEqual;
        areEqual = Intrinsics.areEqual(getRoot(), this);
        return areEqual;
    }

    public String toString() {
        return "FullscreenLoginIdlePage(skippable=" + this.skippable + ")";
    }

    public FullscreenLoginIdlePage(boolean skippable) {
        this.skippable = skippable;
        this.toastInfo = new ToastInfo(null, 0L, 3, null);
    }

    public /* synthetic */ FullscreenLoginIdlePage(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getSkippable() {
        return this.skippable;
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
        return this.toastInfo;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginPage
    public String getLoginType() {
        return "error_fullscreen_new";
    }
}