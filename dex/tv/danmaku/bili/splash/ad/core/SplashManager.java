package tv.danmaku.bili.splash.ad.core;

import android.app.Activity;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.core.model.SplashTaskResultWrapper;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashSource;
import tv.danmaku.bili.splash.ad.page.SplashPageFactoryKt;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashManager.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0005J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/splash/ad/core/SplashManager;", "", "<init>", "()V", "preloadSplashData", "", "releasePreloadData", "trustRealtimeShowTopView", "", "scheduleSplashUpdate", "Lkotlinx/coroutines/Job;", "needRePreloadOnPageCreate", "updateSplashShowIntervalBeginTimeMs", "getLocalListShowSplash", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "source", "Ltv/danmaku/bili/splash/ad/model/SplashSource;", "rePreload", "getRealtimeMaterialSplash", "getRealtimeShowSplash", "Ltv/danmaku/bili/splash/ad/core/model/SplashTaskResultWrapper;", "getRealtimeShowTopViewSplash", "taskResult", "expectTopViewId", "", "checkHotSplash", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "createSplashPage", "Landroidx/fragment/app/Fragment;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashManager {
    public static final int $stable = 0;
    public static final SplashManager INSTANCE = new SplashManager();

    private SplashManager() {
    }

    public final void preloadSplashData() {
        SplashCustomReporterKt.reportAppLaunch(false);
        BusinessSplashResHelper.registerPeakDownloadListener();
        SplashManagerKt.getSplashState().setPreloadStartTime(System.currentTimeMillis());
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new SplashManager$preloadSplashData$1(null), 2, (Object) null);
    }

    public final void releasePreloadData() {
        SplashManagerKt.getSplashState().clean();
    }

    public final boolean trustRealtimeShowTopView() {
        return SplashManagerKt.getSplashState().getData().getTrustRealtimeShowTopView();
    }

    public final Job scheduleSplashUpdate() {
        return BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SplashManager$scheduleSplashUpdate$1(null), 3, (Object) null);
    }

    public final boolean needRePreloadOnPageCreate() {
        return SplashUpdateComponentKt.needRePreloadOnPageCreateInner();
    }

    public final void updateSplashShowIntervalBeginTimeMs() {
        SplashManagerKt.getSplashState().setSplashShowIntervalBeginTimeMs(SystemClock.elapsedRealtime());
    }

    public static /* synthetic */ SplashOrder getLocalListShowSplash$default(SplashManager splashManager, SplashSource splashSource, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return splashManager.getLocalListShowSplash(splashSource, z);
    }

    public final SplashOrder getLocalListShowSplash(SplashSource source, boolean rePreload) {
        Intrinsics.checkNotNullParameter(source, "source");
        return SplashOrderSelectComponentKt.getLocalListShowSplashInner(source, rePreload);
    }

    public final SplashOrder getRealtimeMaterialSplash(SplashSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return SplashOrderSelectComponentKt.getRealtimeMaterialSplashInner(source);
    }

    public final SplashTaskResultWrapper getRealtimeShowSplash() {
        return SplashOrderSelectComponentKt.getRealtimeShowSplashInner();
    }

    public final SplashOrder getRealtimeShowTopViewSplash(SplashTaskResultWrapper taskResult, long expectTopViewId) {
        return SplashOrderSelectComponentKt.getRealtimeShowTopViewSplashInner(taskResult, expectTopViewId);
    }

    public final void checkHotSplash(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        SplashHotStartComponentKt.checkHotSplashInner(activity);
    }

    public final Fragment createSplashPage(SplashOrder splash) {
        return SplashPageFactoryKt.createSplashPageInner(splash);
    }
}