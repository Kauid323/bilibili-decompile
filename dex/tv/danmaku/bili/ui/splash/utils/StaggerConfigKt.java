package tv.danmaku.bili.ui.splash.utils;

import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.lib.stagger.Stagger;
import com.bilibili.lib.stagger.StaggerManager;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: StaggerConfig.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"registerSplashStaggerConfig", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StaggerConfigKt {
    public static final void registerSplashStaggerConfig() {
        if (!SplashConfigKt.getUseStagger()) {
            return;
        }
        Stagger.DownloadOptions options = new Stagger.DownloadOptions.Builder().type("brand_splash").cacheBizType(DownloadBizType.BrandSplash).cleanable(false).encrypted(true).build();
        StaggerManager.INSTANCE.provide(StaggerManager.INSTANCE, options);
    }
}