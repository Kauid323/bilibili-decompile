package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÀ\u0003¢\u0006\u0002\b\u0010J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPasswordPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenActionPage;", "currentPage", "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginPage;", "rootPage", "<init>", "(Ltv/danmaku/bili/fullscreen/state/IPasswordLoginPage;Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;)V", "getCurrentPage", "()Ltv/danmaku/bili/fullscreen/state/IPasswordLoginPage;", "getRootPage$accountui_apinkDebug", "()Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "root", "getRoot", "component1", "component2", "component2$accountui_apinkDebug", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginPasswordPage implements IFullscreenLoginState, IFullscreenActionPage {
    public static final int $stable = 0;
    private final IPasswordLoginPage currentPage;
    private final IFullscreenLoginState rootPage;

    public static /* synthetic */ FullscreenLoginPasswordPage copy$default(FullscreenLoginPasswordPage fullscreenLoginPasswordPage, IPasswordLoginPage iPasswordLoginPage, IFullscreenLoginState iFullscreenLoginState, int i, Object obj) {
        if ((i & 1) != 0) {
            iPasswordLoginPage = fullscreenLoginPasswordPage.currentPage;
        }
        if ((i & 2) != 0) {
            iFullscreenLoginState = fullscreenLoginPasswordPage.rootPage;
        }
        return fullscreenLoginPasswordPage.copy(iPasswordLoginPage, iFullscreenLoginState);
    }

    public final IPasswordLoginPage component1() {
        return this.currentPage;
    }

    public final IFullscreenLoginState component2$accountui_apinkDebug() {
        return this.rootPage;
    }

    public final FullscreenLoginPasswordPage copy(IPasswordLoginPage iPasswordLoginPage, IFullscreenLoginState iFullscreenLoginState) {
        Intrinsics.checkNotNullParameter(iPasswordLoginPage, "currentPage");
        return new FullscreenLoginPasswordPage(iPasswordLoginPage, iFullscreenLoginState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FullscreenLoginPasswordPage) {
            FullscreenLoginPasswordPage fullscreenLoginPasswordPage = (FullscreenLoginPasswordPage) obj;
            return Intrinsics.areEqual(this.currentPage, fullscreenLoginPasswordPage.currentPage) && Intrinsics.areEqual(this.rootPage, fullscreenLoginPasswordPage.rootPage);
        }
        return false;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ String getLoginType() {
        String loginType;
        loginType = getCurrentPage().getLoginType();
        return loginType;
    }

    public int hashCode() {
        return (this.currentPage.hashCode() * 31) + (this.rootPage == null ? 0 : this.rootPage.hashCode());
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public /* synthetic */ boolean isRoot() {
        boolean areEqual;
        areEqual = Intrinsics.areEqual(getRoot(), this);
        return areEqual;
    }

    public String toString() {
        IPasswordLoginPage iPasswordLoginPage = this.currentPage;
        return "FullscreenLoginPasswordPage(currentPage=" + iPasswordLoginPage + ", rootPage=" + this.rootPage + ")";
    }

    public FullscreenLoginPasswordPage(IPasswordLoginPage currentPage, IFullscreenLoginState rootPage) {
        Intrinsics.checkNotNullParameter(currentPage, "currentPage");
        this.currentPage = currentPage;
        this.rootPage = rootPage;
    }

    public /* synthetic */ FullscreenLoginPasswordPage(IPasswordLoginPage iPasswordLoginPage, IFullscreenLoginState iFullscreenLoginState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPasswordLoginPage, (i & 2) != 0 ? null : iFullscreenLoginState);
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public IPasswordLoginPage getCurrentPage() {
        return this.currentPage;
    }

    public final IFullscreenLoginState getRootPage$accountui_apinkDebug() {
        return this.rootPage;
    }

    @Override // tv.danmaku.bili.fullscreen.state.IFullscreenLoginState
    public IFullscreenLoginState getRoot() {
        IFullscreenLoginState iFullscreenLoginState = this.rootPage;
        return iFullscreenLoginState == null ? IFullscreenLoginState.CC.$default$getRoot(this) : iFullscreenLoginState;
    }
}