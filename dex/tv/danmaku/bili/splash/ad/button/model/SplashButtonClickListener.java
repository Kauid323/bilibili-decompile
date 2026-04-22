package tv.danmaku.bili.splash.ad.button.model;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;

/* compiled from: SplashButtonClickListener.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/splash/ad/button/model/SplashButtonClickListener;", "", "onClick", "", "splashGuideButton", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "onClickV2", "clickData", "Ltv/danmaku/bili/splash/ad/button/model/ButtonClickData;", "onSlide", "onShake", "onRotate", "onRunning", "triggerFromThreshold", "", "onElementClick", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface SplashButtonClickListener {
    void onClick(SplashGuideButton splashGuideButton);

    void onClickV2(ButtonClickData buttonClickData);

    void onElementClick();

    void onRotate(SplashGuideButton splashGuideButton);

    void onRunning(SplashGuideButton splashGuideButton, boolean z);

    void onShake(SplashGuideButton splashGuideButton);

    void onSlide(SplashGuideButton splashGuideButton);

    /* compiled from: SplashButtonClickListener.kt */
    /* renamed from: tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static void $default$onElementClick(SplashButtonClickListener _this) {
        }
    }
}