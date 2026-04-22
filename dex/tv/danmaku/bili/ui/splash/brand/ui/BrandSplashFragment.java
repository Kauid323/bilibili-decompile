package tv.danmaku.bili.ui.splash.brand.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.page.ISplash;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfo;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfoKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashFragment.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/ui/BrandSplashFragment;", "Ltv/danmaku/bili/ui/splash/brand/ui/BaseBrandSplashFragment;", "<init>", "()V", "doAfterViewCreate", "", "brandInfo", "Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "exit", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashFragment extends BaseBrandSplashFragment {
    public static final int $stable = 8;

    @Override // tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment
    public void doAfterViewCreate(BrandShowInfo brandInfo) {
        if (getContext() == null) {
            return;
        }
        BLog.i(BaseBrandSplashFragment.TAG, "doAfterViewCreate");
        if (brandInfo != null) {
            BrandSplashStorage brandSplashStorage = BrandSplashStorage.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            brandSplashStorage.setLastShowId(requireContext, BrandShowInfoKt.getUniqueId(brandInfo));
        }
        if (!isSplashContainerInitialized()) {
            exit();
            return;
        }
        getMSplashContainer().getViewTreeObserver().addOnGlobalLayoutListener(new BrandSplashFragment$doAfterViewCreate$2(this, brandInfo));
        boolean z = false;
        if (brandInfo != null && brandInfo.getReportFlag() == 4) {
            z = true;
        }
        if (z && brandInfo.getForceShowTimes() > 0) {
            BrandSplashStorage.INSTANCE.increaseBrandSplashShowCount(brandInfo);
        }
    }

    @Override // tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment
    public void exit() {
        ISplash.SplashHost activity = getActivity();
        ISplash.SplashHost splashHost = activity instanceof ISplash.SplashHost ? activity : null;
        if (splashHost != null) {
            splashHost.exitBrandSplash();
        }
    }
}