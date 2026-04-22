package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u000b\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "", "root", "getRoot", "()Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "currentPage", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "getCurrentPage", "()Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginPage;", "isRoot", "", "()Z", "loginType", "", "getLoginType", "()Ljava/lang/String;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginDowngradeState;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginFastPage;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginIdlePage;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginInvalidPage;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPasswordPage;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPhoneIdlePage;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPhonePage;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginSmsPage;", "Ltv/danmaku/bili/fullscreen/state/FullscreenOverseaPage;", "Ltv/danmaku/bili/fullscreen/state/FullscreenPhoneOrPasswordPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenActionPage;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IFullscreenLoginState {
    IFullscreenLoginPage getCurrentPage();

    String getLoginType();

    IFullscreenLoginState getRoot();

    boolean isRoot();

    /* compiled from: IFullscreenLoginPage.kt */
    /* renamed from: tv.danmaku.bili.fullscreen.state.IFullscreenLoginState$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static IFullscreenLoginState $default$getRoot(IFullscreenLoginState _this) {
            return _this;
        }
    }
}