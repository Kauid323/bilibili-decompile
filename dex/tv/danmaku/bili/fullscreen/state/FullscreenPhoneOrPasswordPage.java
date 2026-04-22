package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/FullscreenPhoneOrPasswordPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenActionPage;", "currentPage", "Ltv/danmaku/bili/fullscreen/state/IPhoneOrPasswordLoginPage;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/IPhoneOrPasswordLoginPage;)V", "getCurrentPage", "()Ltv/danmaku/bili/fullscreen/state/IPhoneOrPasswordLoginPage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenPhoneOrPasswordPage implements IFullscreenLoginState, IFullscreenActionPage {
    public static final int $stable = 8;
    private final IPhoneOrPasswordLoginPage currentPage;

    public static /* synthetic */ FullscreenPhoneOrPasswordPage copy$default(FullscreenPhoneOrPasswordPage fullscreenPhoneOrPasswordPage, IPhoneOrPasswordLoginPage iPhoneOrPasswordLoginPage, int i, Object obj) {
        if ((i & 1) != 0) {
            iPhoneOrPasswordLoginPage = fullscreenPhoneOrPasswordPage.currentPage;
        }
        return fullscreenPhoneOrPasswordPage.copy(iPhoneOrPasswordLoginPage);
    }

    public final IPhoneOrPasswordLoginPage component1() {
        return this.currentPage;
    }

    public final FullscreenPhoneOrPasswordPage copy(IPhoneOrPasswordLoginPage iPhoneOrPasswordLoginPage) {
        Intrinsics.checkNotNullParameter(iPhoneOrPasswordLoginPage, "currentPage");
        return new FullscreenPhoneOrPasswordPage(iPhoneOrPasswordLoginPage);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FullscreenPhoneOrPasswordPage) && Intrinsics.areEqual(this.currentPage, ((FullscreenPhoneOrPasswordPage) obj).currentPage);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ String getLoginType() {
        String loginType;
        loginType = getCurrentPage().getLoginType();
        return loginType;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ IFullscreenLoginState getRoot() {
        return IFullscreenLoginState.CC.$default$getRoot(this);
    }

    public int hashCode() {
        return this.currentPage.hashCode();
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ boolean isRoot() {
        boolean areEqual;
        areEqual = Intrinsics.areEqual(getRoot(), this);
        return areEqual;
    }

    public String toString() {
        return "FullscreenPhoneOrPasswordPage(currentPage=" + this.currentPage + ")";
    }

    public FullscreenPhoneOrPasswordPage(IPhoneOrPasswordLoginPage currentPage) {
        Intrinsics.checkNotNullParameter(currentPage, "currentPage");
        this.currentPage = currentPage;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public IPhoneOrPasswordLoginPage getCurrentPage() {
        return this.currentPage;
    }
}