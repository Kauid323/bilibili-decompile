package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.SplashOrderSelectFinishAction;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.module.main.innerpush.IShowPushWhenPageDestroy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.SplashHelper;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashSource;
import tv.danmaku.bili.ui.splash.ad.page.ISplash;
import tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerTopixKt;
import tv.danmaku.bili.videopage.common.VideoPageConstants;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: HotSplashActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J$\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u0007H\u0016¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/page/HotSplashActivity;", "Landroidx/fragment/app/FragmentActivity;", "Ltv/danmaku/bili/ui/splash/ad/page/ISplash$SplashHost;", "Lcom/bilibili/module/main/innerpush/IShowPushWhenPageDestroy;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "exitSplash", "splashData", "", "jumpUrl", "", "jumped", "", "exitBrandSplash", "onADSplashReady", "closeSplash", "delayFinish", "onDestroy", "onModLoadSuccess", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HotSplashActivity extends FragmentActivity implements ISplash.SplashHost, IShowPushWhenPageDestroy {
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.remove(VideoPageConstants.FRAGMENTS_TAG);
        }
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getDecorView().setSystemUiVisibility(MJsBridgeCallHandlerTopixKt.REQUEST_TOPIX);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        if (savedInstanceState == null) {
            Splash splash = HotSplashActivityKt.getPendingShowHotSplash();
            if (splash == null) {
                splash = SplashHelper.getSplashForShow(SplashSource.HOT);
            }
            BLog.i("HotSplashActivity", "pendingShowHotSplash = " + HotSplashActivityKt.getPendingShowHotSplash());
            HotSplashActivityKt.setPendingShowHotSplash(null);
            if (splash != null) {
                splash.isHotSplash = true;
            }
            SplashViewModel vm = new ViewModelProvider((ViewModelStoreOwner) this).get(SplashViewModel.class);
            vm.update(new SplashOrderSelectFinishAction(splash != null ? splash.id : 0L, false, false, 0, (String) null, (String) null, 62, (DefaultConstructorMarker) null));
            Fragment splashFragment = SplashPageFactoryKt.createSplashPage(splash);
            if (splashFragment == null) {
                SplashAdHelper.stockReport$default(BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT, false, 2, null);
                finish();
                return;
            }
            BLog.i("HotSplashActivity", "show hot splash");
            getSupportFragmentManager().beginTransaction().add(16908290, splashFragment, "splash").commitAllowingStateLoss();
            return;
        }
        finish();
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    public void exitSplash(Object splashData, String jumpUrl, boolean jumped) {
        Splash splash = splashData instanceof Splash ? (Splash) splashData : null;
        if (splash == null || TextUtils.isEmpty(jumpUrl)) {
            BLog.i("HotSplashActivity", "exitSplash, splash or jumpUrl is empty");
            finish();
        } else if (!splash.isAdLoc) {
            Uri parse = Uri.parse(jumpUrl);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest request = new RouteRequest.Builder(parse).build();
            boolean success = BLRouter.routeTo(request, (Context) this).isSuccess();
            if (!success) {
                BLog.i("HotSplashActivity", "exitSplash, route failed " + jumpUrl);
                finish();
                return;
            }
            delayFinish();
        } else {
            SplashAdHelper.handleAdJump((Context) this, splash, (r13 & 4) != 0 ? "" : jumpUrl, (r13 & 8) != 0 ? "" : null, (r13 & 16) == 0 ? null : "", (r13 & 32) != 0 ? null : null, (r13 & 64) == 0 ? null : null);
            delayFinish();
        }
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.ISplash.SplashHost
    public void exitBrandSplash() {
    }

    public void onADSplashReady() {
    }

    public void closeSplash() {
        delayFinish();
    }

    private final void delayFinish() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new HotSplashActivity$delayFinish$1(this, null), 3, (Object) null);
    }

    protected void onDestroy() {
        super.onDestroy();
        HotSplashActivityKt.onHotSplashDismiss();
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.ISplash.SplashHost
    public void onModLoadSuccess() {
    }
}