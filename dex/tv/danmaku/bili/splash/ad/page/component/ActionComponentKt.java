package tv.danmaku.bili.splash.ad.page.component;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.homepage.splash.IAdSplashHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.state.actions.SplashSkipClickEvent;

/* compiled from: ActionComponent.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a4\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0004H\u0000\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TAG", "", "openThirdApp", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "schemaUrl", "splashId", "jumpUrl", "clickData", "Ltv/danmaku/bili/splash/ad/button/model/ButtonClickData;", "reportVideoPlay", "", "setJumpAnimation", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ActionComponentKt {
    private static final String TAG = "[Splash]ActionComponent";

    public static final boolean openThirdApp(BaseSplash $this$openThirdApp, String schemaUrl, String splashId, String jumpUrl, ButtonClickData clickData) {
        Intrinsics.checkNotNullParameter($this$openThirdApp, "<this>");
        boolean z = true;
        $this$openThirdApp.getComponentHolder$adsplash_debug().setClickJump(true);
        $this$openThirdApp.getComponentHolder$adsplash_debug().setSplashId(splashId);
        BLog.i(TAG, "openThirdApp, url = " + schemaUrl);
        $this$openThirdApp.getViewModel$adsplash_debug().update(new SplashSkipClickEvent("openThireApp"));
        boolean success = SplashAdHelper.INSTANCE.handleAdJump($this$openThirdApp.getContext(), $this$openThirdApp.getSplash$adsplash_debug(), schemaUrl, jumpUrl, clickData != null ? clickData.getPrioritySchemaUrl() : null, clickData != null ? clickData.getPriorityJumpUrl() : null, clickData != null ? clickData.getWxProgramInfo() : null);
        if (success) {
            IAdSplashHost activity = $this$openThirdApp.getActivity();
            if (activity instanceof IAdSplashHost) {
                if (ExtSplashOrderKt.isVideo($this$openThirdApp.getSplash$adsplash_debug())) {
                    String adCb = $this$openThirdApp.getSplash$adsplash_debug().getAdCb();
                    if (adCb != null && !StringsKt.isBlank(adCb)) {
                        z = false;
                    }
                    if (!z) {
                        SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
                        long calculateSplashRealDuration = StatisticComponentKt.calculateSplashRealDuration($this$openThirdApp);
                        String adCb2 = $this$openThirdApp.getSplash$adsplash_debug().getAdCb();
                        if (adCb2 == null) {
                            adCb2 = "";
                        }
                        splashAdHelper.reportVideoPlay$adsplash_debug(calculateSplashRealDuration, adCb2);
                    }
                }
                activity.closeSplash();
            }
        }
        return success;
    }

    public static final void reportVideoPlay(BaseSplash $this$reportVideoPlay) {
        Intrinsics.checkNotNullParameter($this$reportVideoPlay, "<this>");
        if (ExtSplashOrderKt.isVideo($this$reportVideoPlay.getSplash$adsplash_debug())) {
            String adCb = $this$reportVideoPlay.getSplash$adsplash_debug().getAdCb();
            if (!(adCb == null || StringsKt.isBlank(adCb))) {
                SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
                long calculateSplashRealDuration = StatisticComponentKt.calculateSplashRealDuration($this$reportVideoPlay);
                String adCb2 = $this$reportVideoPlay.getSplash$adsplash_debug().getAdCb();
                if (adCb2 == null) {
                    adCb2 = "";
                }
                splashAdHelper.reportVideoPlay$adsplash_debug(calculateSplashRealDuration, adCb2);
            }
        }
    }

    public static final void setJumpAnimation(BaseSplash $this$setJumpAnimation) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter($this$setJumpAnimation, "<this>");
        if ($this$setJumpAnimation.getComponentHolder$adsplash_debug().isSecondPageTriggered()) {
            SplashSecondPageInfo secondPage = $this$setJumpAnimation.getSplash$adsplash_debug().getSecondPage();
            boolean z = false;
            if (secondPage != null && secondPage.getInteractStyle() == 2) {
                z = true;
            }
            if (!z || (activity = $this$setJumpAnimation.getActivity()) == null) {
                return;
            }
            activity.overridePendingTransition(R.anim.act_bottom_enter, R.anim.act_bottom_exit);
        }
    }
}