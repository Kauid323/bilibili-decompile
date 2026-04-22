package tv.danmaku.bili.ui.splash.service;

import android.app.Activity;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.globalactions.UpdateAppBackgroundAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.bili.proc.ActivityCallBack;
import tv.danmaku.bili.splash.ad.core.SplashManager;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.ui.splash.ad.SplashHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashCoreServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"tv/danmaku/bili/ui/splash/service/SplashCoreServiceImpl$addIPCCallBack$1", "Ltv/danmaku/bili/proc/ActivityCallBack$IPCActivityStateCallback;", "onVisibleCountChanged", "", "activity", "Landroid/app/Activity;", "lastVisibleCount", "", "currentVisibleCount", "onForegroundActivitiesChanged", "lastForegroundCount", "currentForegroundCount", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashCoreServiceImpl$addIPCCallBack$1 implements ActivityCallBack.IPCActivityStateCallback {
    final /* synthetic */ SplashCoreServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SplashCoreServiceImpl$addIPCCallBack$1(SplashCoreServiceImpl $receiver) {
        this.this$0 = $receiver;
    }

    public void onVisibleCountChanged(final Activity activity, int lastVisibleCount, int currentVisibleCount) {
        boolean yieldColdStart;
        Intrinsics.checkNotNullParameter(activity, "activity");
        SplashViewModel.Companion.update(new UpdateAppBackgroundAction(currentVisibleCount == 0));
        yieldColdStart = this.this$0.yieldColdStart(activity);
        if (yieldColdStart || lastVisibleCount != 0) {
            return;
        }
        Function0 checkShowHotSplash = new Function0() { // from class: tv.danmaku.bili.ui.splash.service.SplashCoreServiceImpl$addIPCCallBack$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onVisibleCountChanged$lambda$0;
                onVisibleCountChanged$lambda$0 = SplashCoreServiceImpl$addIPCCallBack$1.onVisibleCountChanged$lambda$0(activity);
                return onVisibleCountChanged$lambda$0;
            }
        };
        if (SplashConfigKt.getDelayShowHotSplashMs() == 0) {
            checkShowHotSplash.invoke();
        } else {
            BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SplashCoreServiceImpl$addIPCCallBack$1$onVisibleCountChanged$1(checkShowHotSplash, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onVisibleCountChanged$lambda$0(Activity $activity) {
        if (SplashConfigKt.getSplashUseNewSplashExp()) {
            SplashManager.INSTANCE.checkHotSplash($activity);
        } else {
            SplashHelper.checkHotSplash($activity);
        }
        return Unit.INSTANCE;
    }

    public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
    }
}