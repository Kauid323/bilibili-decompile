package tv.danmaku.bili.ui.splash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.SplashOrderSelectFinishAction;
import com.bilibili.lib.ui.IDrawerHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.ui.clipboard.BvResult;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.clipboard.RecognizeResult;
import tv.danmaku.bili.ui.splash.ad.SplashHelper;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.splash.ad.config.SplashConstantKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.page.BaseSplash;
import tv.danmaku.bili.ui.splash.ad.page.SplashPageFactoryKt;
import tv.danmaku.bili.utils.UriSpmidModuleHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MainSplashHelper.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J\"\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0019J\b\u0010 \u001a\u00020\u001cH\u0002J\u0006\u0010!\u001a\u00020\u001cJ\u0012\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/splash/MainSplashHelper;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "mSplashFragment", "Landroidx/fragment/app/Fragment;", "delayHideSplashTime", "", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "mDelayJumpRunnable", "Ljava/lang/Runnable;", "getSplashFragment", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "reportStock", "", "isDeepLink", "exitSplash", "", "jumpUrl", "", "jumped", "dealWithClipData", "closeSplash", "launchActivity", "targetUri", "Landroid/net/Uri;", "hideSplash", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MainSplashHelper {
    public static final int $stable = 8;
    private FragmentActivity activity;
    private final long delayHideSplashTime;
    private final Runnable mDelayJumpRunnable;
    private final Lazy mHandler$delegate;
    private Fragment mSplashFragment;

    public final Fragment getSplashFragment(Splash splash, boolean z) {
        return getSplashFragment$default(this, splash, false, z, 2, null);
    }

    public MainSplashHelper(FragmentActivity activity) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        String str = (String) ConfigManager.Companion.config().get("splash.splash_jump_delay_time", "500");
        this.delayHideSplashTime = (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
        this.mHandler$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.MainSplashHelper$$ExternalSyntheticLambda0
            public final Object invoke() {
                Handler mHandler_delegate$lambda$0;
                mHandler_delegate$lambda$0 = MainSplashHelper.mHandler_delegate$lambda$0();
                return mHandler_delegate$lambda$0;
            }
        });
        this.mDelayJumpRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.splash.MainSplashHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MainSplashHelper.mDelayJumpRunnable$lambda$0(MainSplashHelper.this);
            }
        };
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final void setActivity(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<set-?>");
        this.activity = fragmentActivity;
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mHandler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDelayJumpRunnable$lambda$0(MainSplashHelper this$0) {
        if (this$0.activity.isFinishing()) {
            BLog.i("MainSplashHelper", "activity finished");
            return;
        }
        BLog.i("MainSplashHelper", "mDelayJumpRunnable hideSplashFragment");
        IDrawerHost iDrawerHost = this$0.activity;
        IDrawerHost iDrawerHost2 = iDrawerHost instanceof IDrawerHost ? iDrawerHost : null;
        if (iDrawerHost2 != null) {
            iDrawerHost2.hideSplashFragment(true);
        }
    }

    public static /* synthetic */ Fragment getSplashFragment$default(MainSplashHelper mainSplashHelper, Splash splash, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return mainSplashHelper.getSplashFragment(splash, z, z2);
    }

    public final Fragment getSplashFragment(Splash splash, boolean reportStock, boolean isDeepLink) {
        Lifecycle lifecycle;
        SplashViewModel vm = new ViewModelProvider(this.activity).get(SplashViewModel.class);
        vm.update(new SplashOrderSelectFinishAction(splash != null ? splash.id : 0L, splash != null ? splash.isTopView() : false, splash != null ? splash.fromRealShow : false, splash != null ? splash.topViewType : 0, splash != null ? splash.adCb : null, splash != null ? splash.bindBanner : null));
        this.mSplashFragment = SplashPageFactoryKt.createSplashPage(splash);
        SplashHelper.releasePreload();
        if (this.mSplashFragment == null && reportStock) {
            SplashAdHelper.stockReport(BusinessSplashDefineKt.SPLASH_OPEN_EVENT_COLD, isDeepLink);
        }
        if (this.mSplashFragment instanceof BaseSplash) {
            BaseSplash baseSplash = this.mSplashFragment;
            Intrinsics.checkNotNull(baseSplash, "null cannot be cast to non-null type tv.danmaku.bili.ui.splash.ad.page.BaseSplash");
            Splash splash2 = baseSplash.getSplash();
            BootTracer.setSession("SplashDuration", splash2 != null ? splash2.duration : -1000L);
        }
        SplashHelper.onSplashColdStart(this.activity.getApplicationContext());
        Fragment fragment = this.mSplashFragment;
        if (fragment != null && (lifecycle = fragment.getLifecycle()) != null) {
            lifecycle.addObserver(new LifecycleObserver() { // from class: tv.danmaku.bili.ui.splash.MainSplashHelper$getSplashFragment$1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public final void onDestroy() {
                    MainSplashHelper.this.mSplashFragment = null;
                }
            });
        }
        return this.mSplashFragment;
    }

    public final void exitSplash(Splash splash, String jumpUrl, boolean jumped) {
        if (splash == null || TextUtils.isEmpty(jumpUrl)) {
            dealWithClipData();
            hideSplash(jumped);
            return;
        }
        Uri uri = Uri.parse(jumpUrl);
        if (splash.isAdLoc) {
            BLog.i("MainSplashHelper", "splash.isAdLoc :" + uri);
            SplashAdHelper.handleAdJump(this.activity, splash, (r13 & 4) != 0 ? "" : jumpUrl, (r13 & 8) != 0 ? "" : null, (r13 & 16) == 0 ? null : "", (r13 & 32) != 0 ? null : null, (r13 & 64) == 0 ? null : null);
            hideSplash(jumped);
            return;
        }
        launchActivity(uri);
    }

    private final void dealWithClipData() {
        LaunchClipboard launchClipboard = LaunchClipboard.INSTANCE;
        RecognizeResult result = ClipboardChecker.getResult();
        launchClipboard.checkBvData(result instanceof BvResult ? (BvResult) result : null);
    }

    public final void closeSplash() {
        if (this.activity instanceof IDrawerHost) {
            hideSplash(true);
        } else {
            this.mSplashFragment = null;
        }
    }

    private final void launchActivity(Uri targetUri) {
        RouteResponse resp = null;
        if (targetUri != null) {
            BLog.i("MainSplashHelper", "launchActivity:" + targetUri);
            RouteRequest request = new RouteRequest.Builder(UriSpmidModuleHelper.appendFromSpmid(targetUri, SplashConstantKt.SPLASH_SPMID)).build();
            resp = BLRouter.routeTo(request, this.activity);
        }
        boolean z = false;
        if (resp != null && resp.isSuccess()) {
            z = true;
        }
        hideSplash(z);
    }

    private final void hideSplash(boolean jumped) {
        IDrawerHost iDrawerHost = this.activity;
        IDrawerHost act = iDrawerHost instanceof IDrawerHost ? iDrawerHost : null;
        if (act == null) {
            return;
        }
        long delayTime = jumped ? RangesKt.coerceAtMost(this.delayHideSplashTime, (long) PlayerToastConfig.DURATION_2) : 0L;
        BLog.i("MainSplashHelper", "hideSplashWithDelay :" + delayTime + " jumped:" + jumped);
        if (delayTime <= 0) {
            act.hideSplashFragment(false);
        } else {
            getMHandler().postDelayed(this.mDelayJumpRunnable, this.delayHideSplashTime);
        }
    }
}