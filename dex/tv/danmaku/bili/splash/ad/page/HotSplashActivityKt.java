package tv.danmaku.bili.splash.ad.page;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.splash.SplashCoreService;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashOrder;

/* compiled from: HotSplashActivity.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000\"/\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"TAG", "", "isHotSplashShowing", "", "<set-?>", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "pendingShowHotSplash", "getPendingShowHotSplash", "()Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "setPendingShowHotSplash", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)V", "pendingShowHotSplash$delegate", "Ltv/danmaku/bili/splash/ad/page/TemporaryReference;", "onHotSplashDismiss", "", "delayHideSplashTime", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotSplashActivityKt {
    private static final String TAG = "HotSplashActivity";
    private static final long delayHideSplashTime;
    public static boolean isHotSplashShowing;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(HotSplashActivityKt.class, "pendingShowHotSplash", "getPendingShowHotSplash()Ltv/danmaku/bili/splash/ad/model/SplashOrder;", 1))};
    private static final TemporaryReference pendingShowHotSplash$delegate = new TemporaryReference(0, 1, null);

    static {
        Long longOrNull;
        long j = 0;
        String str = (String) ConfigManager.Companion.config().get("splash.hot_splash_jump_delay_time", "500");
        if (str != null && (longOrNull = StringsKt.toLongOrNull(str)) != null) {
            j = longOrNull.longValue();
        }
        delayHideSplashTime = j;
    }

    public static final SplashOrder getPendingShowHotSplash() {
        return (SplashOrder) pendingShowHotSplash$delegate.getValue(null, $$delegatedProperties[0]);
    }

    public static final void setPendingShowHotSplash(SplashOrder splashOrder) {
        pendingShowHotSplash$delegate.setValue(null, $$delegatedProperties[0], splashOrder);
    }

    public static final void onHotSplashDismiss() {
        isHotSplashShowing = false;
        SplashCoreService splashCoreService = (SplashCoreService) BLRouter.get$default(BLRouter.INSTANCE, SplashCoreService.class, (String) null, 2, (Object) null);
        if (splashCoreService != null) {
            splashCoreService.onHotSplashDismiss();
        }
    }
}