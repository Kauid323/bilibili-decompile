package tv.danmaku.bili.splash.ad.page;

import android.content.Intent;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerType;
import tv.danmaku.bili.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: ISplashEvent.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001Jb\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\nH&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J(\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/ISplashEvent;", "", "onJumpClick", "", "intent", "Landroid/content/Intent;", "schema", "", "jumpUrl", "withFrom", "", "actionType", "Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "reportClick", "buttonId", "clickData", "Ltv/danmaku/bili/splash/ad/button/model/ButtonClickData;", "onPageJump", "isSecondPage", "secondPageJumpReason", "liveReserveTriggerType", "Ltv/danmaku/bili/splash/ad/business/livereserve/LiveReserveTriggerType;", "onSplashReady", "realReady", "onCountdownEnd", "stopCountdown", "showMainMaterial", "onSkipClick", "exitSplash", "jumped", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ISplashEvent {
    void exitSplash(boolean z, SplashOrder splashOrder, String str);

    void onCountdownEnd();

    void onJumpClick(Intent intent, String str, String str2, boolean z, SplashActionType splashActionType, boolean z2, String str3, ButtonClickData buttonClickData);

    void onPageJump(boolean z, String str, LiveReserveTriggerType liveReserveTriggerType);

    void onSkipClick();

    void onSplashReady(boolean z);

    void showMainMaterial();

    void stopCountdown();

    /* compiled from: ISplashEvent.kt */
    /* renamed from: tv.danmaku.bili.splash.ad.page.ISplashEvent$-CC */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void onJumpClick$default(ISplashEvent iSplashEvent, Intent intent, String str, String str2, boolean z, SplashActionType splashActionType, boolean z2, String str3, ButtonClickData buttonClickData, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onJumpClick");
            }
            if ((i & 1) != 0) {
                intent = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            if ((i & 16) != 0) {
                splashActionType = SplashActionType.UNDEFINE;
            }
            if ((i & 32) != 0) {
                z2 = false;
            }
            if ((i & 64) != 0) {
                str3 = null;
            }
            if ((i & BR.cover) != 0) {
                buttonClickData = null;
            }
            iSplashEvent.onJumpClick(intent, str, str2, z, splashActionType, z2, str3, buttonClickData);
        }

        public static /* synthetic */ void onPageJump$default(ISplashEvent iSplashEvent, boolean z, String str, LiveReserveTriggerType liveReserveTriggerType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageJump");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                liveReserveTriggerType = null;
            }
            iSplashEvent.onPageJump(z, str, liveReserveTriggerType);
        }

        public static /* synthetic */ void onSplashReady$default(ISplashEvent iSplashEvent, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSplashReady");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            iSplashEvent.onSplashReady(z);
        }

        public static /* synthetic */ void exitSplash$default(ISplashEvent iSplashEvent, boolean z, SplashOrder splashOrder, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitSplash");
            }
            if ((i & 2) != 0) {
                splashOrder = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            iSplashEvent.exitSplash(z, splashOrder, str);
        }
    }
}