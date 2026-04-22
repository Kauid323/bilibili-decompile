package tv.danmaku.bili.ui.splash.brand.ui;

import android.view.ViewTreeObserver;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashFragment.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"tv/danmaku/bili/ui/splash/brand/ui/BrandSplashFragment$doAfterViewCreate$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashFragment$doAfterViewCreate$2 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ BrandShowInfo $brandInfo;
    final /* synthetic */ BrandSplashFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrandSplashFragment$doAfterViewCreate$2(BrandSplashFragment $receiver, BrandShowInfo $brandInfo) {
        this.this$0 = $receiver;
        this.$brandInfo = $brandInfo;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.this$0.getMSplashContainer().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        final BrandSplashFragment brandSplashFragment = this.this$0;
        Runnable runnable = new Runnable() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BrandSplashFragment$doAfterViewCreate$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BrandSplashFragment$doAfterViewCreate$2.onGlobalLayout$lambda$0(BrandSplashFragment.this);
            }
        };
        BrandShowInfo brandShowInfo = this.$brandInfo;
        HandlerThreads.postDelayed(0, runnable, brandShowInfo != null ? brandShowInfo.getDuration() : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGlobalLayout$lambda$0(BrandSplashFragment this$0) {
        this$0.exit();
        BLog.i(BaseBrandSplashFragment.TAG, "brand splash exit");
    }
}