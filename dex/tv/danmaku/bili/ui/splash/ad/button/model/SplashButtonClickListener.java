package tv.danmaku.bili.ui.splash.ad.button.model;

import kotlin.Metadata;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashButtonClickListener.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonClickListener;", "", "onClick", "", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "splashGuideButton", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "onClickV2", "clickData", "Ltv/danmaku/bili/ui/splash/ad/button/model/ButtonClickData;", "onSlide", "onShake", "onRotate", "onRunning", "triggerFromThreshold", "", "onElementClick", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface SplashButtonClickListener {
    void onClick(Splash splash, SplashGuideButton splashGuideButton);

    void onClickV2(ButtonClickData buttonClickData);

    void onElementClick();

    void onRotate(SplashGuideButton splashGuideButton);

    void onRunning(SplashGuideButton splashGuideButton, boolean z);

    void onShake(SplashGuideButton splashGuideButton);

    void onSlide(SplashGuideButton splashGuideButton);

    /* compiled from: SplashButtonClickListener.kt */
    /* renamed from: tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onElementClick(SplashButtonClickListener _this) {
        }
    }
}