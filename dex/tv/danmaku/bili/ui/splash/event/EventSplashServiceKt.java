package tv.danmaku.bili.ui.splash.event;

import android.content.Context;
import com.bilibili.base.connectivity.Connectivity;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashService.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\n\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000f"}, d2 = {"mApi", "Ltv/danmaku/bili/ui/splash/event/EventSplashService;", "getMApi", "()Ltv/danmaku/bili/ui/splash/event/EventSplashService;", "mApi$delegate", "Lkotlin/Lazy;", "getEventSplashList", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/splash/event/EventSplashDataList;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventSplashParams", "", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EventSplashServiceKt {
    private static final Lazy mApi$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashServiceKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            EventSplashService mApi_delegate$lambda$0;
            mApi_delegate$lambda$0 = EventSplashServiceKt.mApi_delegate$lambda$0();
            return mApi_delegate$lambda$0;
        }
    });

    private static final EventSplashService getMApi() {
        return (EventSplashService) mApi$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventSplashService mApi_delegate$lambda$0() {
        return (EventSplashService) ServiceGenerator.createService(EventSplashService.class);
    }

    public static final Object getEventSplashList(Context context, Continuation<? super com.bilibili.lib.arch.lifecycle.Resource<EventSplashDataList>> continuation) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Map map = getEventSplashParams(context2);
        EventSplashService mApi = getMApi();
        String str = map.get(PerformanceConstants.EXTRA_KEY_NETWORK);
        String str2 = map.get("screen_width");
        int parseInt = str2 != null ? Integer.parseInt(str2) : 0;
        String str3 = map.get("screen_height");
        BiliCall<GeneralResponse<EventSplashDataList>> splashList = mApi.getSplashList("phone", str, parseInt, str3 != null ? Integer.parseInt(str3) : 0);
        if (splashList != null) {
            Object result = BiliCallExtKt.getResult(splashList, continuation);
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : (com.bilibili.lib.arch.lifecycle.Resource) result;
        }
        return null;
    }

    public static final Map<String, String> getEventSplashParams(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Map map = new LinkedHashMap();
        map.put("device", "phone");
        boolean isWifi = Connectivity.isConnected(Connectivity.getWifiNetworkInfo(context2));
        map.put(PerformanceConstants.EXTRA_KEY_NETWORK, isWifi ? Splash.NETWORK_WIFI : Splash.NETWORK_MOBILE);
        int width = ScreenUtil.getScreenWidth(context2);
        int height = ScreenUtil.getScreenHeight(context2);
        map.put("screen_width", String.valueOf(width));
        map.put("screen_height", String.valueOf(height));
        return EnhancedUnmodifiabilityKt.unmodifiable(map);
    }
}