package tv.danmaku.bili.ui.splash.ad.secondpage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.widget.SplashInteractView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SecondPageViewHelper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H&J\b\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/secondpage/SecondPageInteractListener;", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonClickListener;", "Ltv/danmaku/bili/ui/splash/widget/SplashInteractView$InteractListener;", "<init>", "()V", "onRotate", "", "splashGuideButton", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "onClickV2", "clickData", "Ltv/danmaku/bili/ui/splash/ad/button/model/ButtonClickData;", "onShake", "onRunning", "triggerFromThreshold", "", "onSlide", "onCloseClicked", "onSoundClicked", "onSecondPageEggVideoComplete", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class SecondPageInteractListener implements SplashButtonClickListener, SplashInteractView.InteractListener {
    public static final int $stable = 0;

    public abstract void onCloseClicked();

    @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
    public /* synthetic */ void onElementClick() {
        SplashButtonClickListener.CC.$default$onElementClick(this);
    }

    public abstract void onSecondPageEggVideoComplete();

    public abstract void onSoundClicked();

    @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
    public void onRotate(SplashGuideButton splashGuideButton) {
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
    }

    @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
    public void onClickV2(ButtonClickData clickData) {
        Intrinsics.checkNotNullParameter(clickData, "clickData");
    }

    @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
    public void onShake(SplashGuideButton splashGuideButton) {
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
    }

    @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
    public void onRunning(SplashGuideButton splashGuideButton, boolean triggerFromThreshold) {
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
    }

    @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
    public void onSlide(SplashGuideButton splashGuideButton) {
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
    }
}