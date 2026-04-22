package tv.danmaku.bili.splash.ad.page;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.splash.IAdSplashHost;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.SplashOrderSelectFinishAction;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.module.main.innerpush.IShowPushWhenPageDestroy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.splash.ad.core.SplashManager;
import tv.danmaku.bili.splash.ad.model.SplashExtra;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashSource;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: HotSplashActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0014J$\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0014¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/HotSplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bilibili/lib/homepage/splash/IAdSplashHost;", "Lcom/bilibili/module/main/innerpush/IShowPushWhenPageDestroy;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "closeSplash", "onStop", "exitSplash", "splashData", "", "jumpUrl", "", "jumped", "", "delayFinish", "onDestroy", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotSplashActivity extends AppCompatActivity implements IAdSplashHost, IShowPushWhenPageDestroy {
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ void onADSplashReady() {
        IAdSplashHost.-CC.$default$onADSplashReady(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        SplashExtra runtimeExtra;
        if (savedInstanceState != null) {
            savedInstanceState.remove("android:support:fragments");
        }
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getDecorView().setSystemUiVisibility(1028);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        if (savedInstanceState == null) {
            SplashOrder splash = HotSplashActivityKt.getPendingShowHotSplash();
            if (splash == null) {
                splash = SplashManager.getLocalListShowSplash$default(SplashManager.INSTANCE, SplashSource.HOT, false, 2, null);
            }
            HotSplashActivityKt.setPendingShowHotSplash(null);
            if (splash != null && (runtimeExtra = splash.getRuntimeExtra()) != null) {
                runtimeExtra.setHotSplash(true);
            }
            SplashViewModel vm = new ViewModelProvider((ViewModelStoreOwner) this).get(SplashViewModel.class);
            vm.update(new SplashOrderSelectFinishAction(splash != null ? splash.getId() : 0L, false, false, 0, (String) null, (String) null, 62, (DefaultConstructorMarker) null));
            Fragment splashFragment = SplashManager.INSTANCE.createSplashPage(splash);
            if (splashFragment == null) {
                SplashAdHelper.stockReport$default(SplashAdHelper.INSTANCE, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT, false, 2, null);
                finish();
                return;
            }
            BLog.i("HotSplashActivity", "show hot splash");
            getSupportFragmentManager().beginTransaction().add(16908290, splashFragment, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH).commitAllowingStateLoss();
            return;
        }
        finish();
    }

    public void closeSplash() {
        delayFinish();
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    public void exitSplash(Object splashData, String jumpUrl, boolean jumped) {
        SplashOrder splashOrder = splashData instanceof SplashOrder ? (SplashOrder) splashData : null;
        if (splashOrder != null) {
            String str = jumpUrl;
            if (!(str == null || StringsKt.isBlank(str))) {
                if (splashOrder.isAdLoc()) {
                    SplashAdHelper.INSTANCE.handleAdJump((Context) this, splashOrder, (r18 & 4) != 0 ? "" : jumpUrl, (r18 & 8) != 0 ? "" : null, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
                    delayFinish();
                    return;
                }
                RouteRequest request = new RouteRequest.Builder(Uri.parse(jumpUrl)).build();
                boolean success = BLRouter.routeTo(request, (Context) this).isSuccess();
                if (!success) {
                    BLog.i("HotSplashActivity", "exitSplash, route failed " + jumpUrl);
                    finish();
                    return;
                }
                delayFinish();
                return;
            }
        }
        BLog.i("HotSplashActivity", "exitSplash, splash or jumpUrl is empty");
        finish();
    }

    private final void delayFinish() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new HotSplashActivity$delayFinish$1(this, null), 3, (Object) null);
    }

    protected void onDestroy() {
        super.onDestroy();
        HotSplashActivityKt.onHotSplashDismiss();
    }
}