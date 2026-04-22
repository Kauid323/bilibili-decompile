package tv.danmaku.bili.ui.webview;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.biliid.utils.device.HwIdHelper;
import com.bilibili.lib.jsbridge.legacy.WebBehavior;

@Deprecated
public class MWebBehavior extends WebBehavior {
    public MWebBehavior(AppCompatActivity activity) {
        super(activity);
    }

    public void reset() {
        super.reset();
        dismissSnackBar();
    }

    public void setNavigationStyle(final int style, final int colorParsed) {
        if (this.mActivity instanceof MWebActivity) {
            runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MWebBehavior$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MWebBehavior.this.m1856lambda$setNavigationStyle$0$tvdanmakubiliuiwebviewMWebBehavior(style, colorParsed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setNavigationStyle$0$tv-danmaku-bili-ui-webview-MWebBehavior  reason: not valid java name */
    public /* synthetic */ void m1856lambda$setNavigationStyle$0$tvdanmakubiliuiwebviewMWebBehavior(int style, int colorParsed) {
        if (this.mActivity != null) {
            this.mActivity.setNavigationStyle(style, colorParsed);
        }
    }

    public void hideNavigation() {
        if (this.mActivity instanceof MWebActivity) {
            runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MWebBehavior$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    MWebBehavior.this.m1854lambda$hideNavigation$1$tvdanmakubiliuiwebviewMWebBehavior();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$hideNavigation$1$tv-danmaku-bili-ui-webview-MWebBehavior  reason: not valid java name */
    public /* synthetic */ void m1854lambda$hideNavigation$1$tvdanmakubiliuiwebviewMWebBehavior() {
        if (this.mActivity != null) {
            this.mActivity.hideNavigation();
        }
    }

    public void setStatusBarVisibility(final boolean isHidden) {
        if (this.mActivity instanceof MWebActivity) {
            runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MWebBehavior$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MWebBehavior.this.m1858lambda$setStatusBarVisibility$2$tvdanmakubiliuiwebviewMWebBehavior(isHidden);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setStatusBarVisibility$2$tv-danmaku-bili-ui-webview-MWebBehavior  reason: not valid java name */
    public /* synthetic */ void m1858lambda$setStatusBarVisibility$2$tvdanmakubiliuiwebviewMWebBehavior(boolean isHidden) {
        if (this.mActivity != null) {
            this.mActivity.setStatusBarVisibility(isHidden);
        }
    }

    public void showFavoriteMenu(final String topicId) {
        if (this.mActivity instanceof MWebActivity) {
            runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MWebBehavior$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MWebBehavior.this.m1859lambda$showFavoriteMenu$3$tvdanmakubiliuiwebviewMWebBehavior(topicId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showFavoriteMenu$3$tv-danmaku-bili-ui-webview-MWebBehavior  reason: not valid java name */
    public /* synthetic */ void m1859lambda$showFavoriteMenu$3$tvdanmakubiliuiwebviewMWebBehavior(String topicId) {
        if (this.mActivity != null) {
            this.mActivity.showFavoriteMenu(topicId);
        }
    }

    public void immersiveMode() {
        if (this.mActivity instanceof MWebActivity) {
            runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MWebBehavior$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    MWebBehavior.this.m1855lambda$immersiveMode$4$tvdanmakubiliuiwebviewMWebBehavior();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$immersiveMode$4$tv-danmaku-bili-ui-webview-MWebBehavior  reason: not valid java name */
    public /* synthetic */ void m1855lambda$immersiveMode$4$tvdanmakubiliuiwebviewMWebBehavior() {
        if (this.mActivity != null) {
            this.mActivity.immersiveMode();
        }
    }

    public void loadNewUrl(Uri uri, boolean clearHistory) {
        if (this.mActivity instanceof MWebActivity) {
            this.mActivity.loadNewUrl(uri, clearHistory);
        }
    }

    private void dismissSnackBar() {
        if (this.mActivity instanceof MWebActivity) {
            this.mActivity.dismissSnackBar();
        }
    }

    public JSONObject getWebContainerInfo() {
        JSONObject info = super.getWebContainerInfo();
        info.put("build", 1);
        if (this.mActivity instanceof MWebActivity) {
            info.put("deviceId", HwIdHelper.getDid16(this.mActivity));
        }
        return info;
    }

    public void setShareContent(String content) {
        super.setShareContent(content);
        if (this.mActivity instanceof MWebActivity) {
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MWebBehavior$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    MWebBehavior.this.m1857lambda$setShareContent$5$tvdanmakubiliuiwebviewMWebBehavior();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setShareContent$5$tv-danmaku-bili-ui-webview-MWebBehavior  reason: not valid java name */
    public /* synthetic */ void m1857lambda$setShareContent$5$tvdanmakubiliuiwebviewMWebBehavior() {
        if (this.mActivity != null) {
            this.mActivity.invalidateShareMenus();
        }
    }
}