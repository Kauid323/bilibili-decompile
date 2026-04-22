package tv.danmaku.bili.ui.splash.common.search;

import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.search.SplashSearchService;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashSearchServiceImpl.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001¨\u0006\u0002"}, d2 = {"getSplashSearchServiceImpl", "Ltv/danmaku/bili/ui/splash/common/search/SplashSearchServiceImpl;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashSearchServiceImplKt {
    public static final SplashSearchServiceImpl getSplashSearchServiceImpl() {
        Object obj = BLRouter.INSTANCE.get(SplashSearchService.class, "SPLASH_SEARCH_SERVICE");
        if (obj instanceof SplashSearchServiceImpl) {
            return (SplashSearchServiceImpl) obj;
        }
        return null;
    }
}