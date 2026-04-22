package tv.danmaku.bili.ui.splash;

import android.content.Context;
import com.bilibili.moduleservice.splash.SplashParamsService;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper;
import tv.danmaku.bili.ui.splash.event.EventSplashServiceKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashParamsServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/splash/SplashParamsServiceImpl;", "Lcom/bilibili/moduleservice/splash/SplashParamsService;", "<init>", "()V", "getBrandListParams", "", "", "context", "Landroid/content/Context;", "getSplashEventListParams", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashParamsServiceImpl implements SplashParamsService {
    public static final int $stable = 0;

    public Map<String, String> getBrandListParams(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return EnhancedUnmodifiabilityKt.unmodifiable(BrandSplashServiceHelper.INSTANCE.getBrandListParams(context2));
    }

    public Map<String, String> getSplashEventListParams(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return EnhancedUnmodifiabilityKt.unmodifiable(EventSplashServiceKt.getEventSplashParams(context2));
    }
}