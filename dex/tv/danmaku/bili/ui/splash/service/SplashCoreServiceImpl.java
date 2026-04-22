package tv.danmaku.bili.ui.splash.service;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.bilibili.moduleservice.splash.SplashCoreService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.proc.ActivityCallBack;
import tv.danmaku.bili.proc.TeenagersModeActivityCallback;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.main.usergrow.UserGrowManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashCoreServiceImpl.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/splash/service/SplashCoreServiceImpl;", "Lcom/bilibili/moduleservice/splash/SplashCoreService;", "<init>", "()V", "progressStartTimeMs", "", "setSplashDurationSession", "", "duration", "dropCurrentTrace", "onHotSplashDismiss", "addIPCCallBack", "context", "Landroid/content/Context;", "yieldColdStart", "", "activity", "Landroid/app/Activity;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashCoreServiceImpl implements SplashCoreService {
    public static final int $stable = 8;
    private long progressStartTimeMs;

    public void setSplashDurationSession(long duration) {
        BootTracer.setSession("SplashRealDuration", duration);
    }

    public void dropCurrentTrace() {
        BootTracer.dropCurrentTrace();
    }

    public void onHotSplashDismiss() {
        TeenagersModeActivityCallback.getInstance().onHotSplashDismiss();
        UserGrowManager.INSTANCE.notifyHotSplashDismiss();
        ClipboardChecker.notifyCheck();
    }

    public void addIPCCallBack(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.progressStartTimeMs = SystemClock.elapsedRealtime();
        ActivityCallBack.addIPCActivityStateCallback(new SplashCoreServiceImpl$addIPCCallBack$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean yieldColdStart(Activity activity) {
        boolean yieldNormalColdStart = (activity instanceof MainActivityV2) && (((MainActivityV2) activity).isSplashShowing() || ((MainActivityV2) activity).getTimeSincePageCreateMs() < SplashConfigKt.getHotsSplashYieldColdStartTimeMs());
        boolean yieldSchemeColdStart = SystemClock.elapsedRealtime() - this.progressStartTimeMs < SplashConfigKt.getHotsSplashYieldColdStartTimeMs();
        BLog.i("[Splash]SplashCoreServiceImpl", "yieldColdStart:" + yieldNormalColdStart + ", yieldNormalColdStart:" + yieldSchemeColdStart + ", activity = " + activity.getClass().getSimpleName());
        return yieldNormalColdStart || yieldSchemeColdStart;
    }
}