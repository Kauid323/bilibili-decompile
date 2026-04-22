package tv.danmaku.bili.splash.ad.page.component;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: GuideButtonLayerComponent.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a0\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\f"}, d2 = {"showGuideButton", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "handleAction", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "splashGuideButton", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "actionType", "Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "clickData", "Ltv/danmaku/bili/splash/ad/button/model/ButtonClickData;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GuideButtonLayerComponentKt {
    public static final void showGuideButton(final BaseSplash $this$showGuideButton) {
        Intrinsics.checkNotNullParameter($this$showGuideButton, "<this>");
        $this$showGuideButton.getComponentHolder$adsplash_debug().getButtonHelper().injectSplashButton($this$showGuideButton.getBinding$adsplash_debug().splashButtonContainer, $this$showGuideButton.getSplash$adsplash_debug(), $this$showGuideButton, new SplashButtonClickListener() { // from class: tv.danmaku.bili.splash.ad.page.component.GuideButtonLayerComponentKt$showGuideButton$1
            @Override // tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener
            public void onClick(SplashGuideButton splashGuideButton) {
                Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
                GuideButtonLayerComponentKt.handleAction$default(BaseSplash.this, BaseSplash.this.getSplash$adsplash_debug(), splashGuideButton, SplashActionType.BUTTON, null, 8, null);
                SplashAdHelper.INSTANCE.adSplashButtonUIClick$adsplash_debug(BaseSplash.this.getSplash$adsplash_debug(), splashGuideButton);
            }

            @Override // tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener
            public void onClickV2(ButtonClickData clickData) {
                Intrinsics.checkNotNullParameter(clickData, "clickData");
                GuideButtonLayerComponentKt.handleAction(BaseSplash.this, BaseSplash.this.getSplash$adsplash_debug(), clickData.getSplashButton(), clickData.getActionType(), clickData);
                SplashAdHelper.INSTANCE.adSplashButtonUIClick$adsplash_debug(BaseSplash.this.getSplash$adsplash_debug(), clickData.getSplashButton());
            }

            @Override // tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener
            public void onSlide(SplashGuideButton splashGuideButton) {
                Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
                GuideButtonLayerComponentKt.handleAction$default(BaseSplash.this, BaseSplash.this.getSplash$adsplash_debug(), splashGuideButton, SplashActionType.SLIDE, null, 8, null);
            }

            @Override // tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener
            public void onShake(SplashGuideButton splashGuideButton) {
                Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
                GuideButtonLayerComponentKt.handleAction$default(BaseSplash.this, BaseSplash.this.getSplash$adsplash_debug(), splashGuideButton, SplashActionType.SHAKE, null, 8, null);
            }

            @Override // tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener
            public void onRotate(SplashGuideButton splashGuideButton) {
                Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
                GuideButtonLayerComponentKt.handleAction$default(BaseSplash.this, BaseSplash.this.getSplash$adsplash_debug(), splashGuideButton, SplashActionType.ROTATE, null, 8, null);
            }

            @Override // tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener
            public void onRunning(SplashGuideButton splashGuideButton, boolean triggerFromThreshold) {
                Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
                GuideButtonLayerComponentKt.handleAction$default(BaseSplash.this, BaseSplash.this.getSplash$adsplash_debug(), splashGuideButton, triggerFromThreshold ? SplashActionType.ROTATE_BALL_THRESHOLD : SplashActionType.ROTATE_BALL, null, 8, null);
            }

            @Override // tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener
            public void onElementClick() {
                SplashAdHelper.INSTANCE.reportSplashClickableEggClick$adsplash_debug(BaseSplash.this.getSplash$adsplash_debug(), StatisticComponentKt.calculateSplashRealDuration(BaseSplash.this));
                Intent intent = SplashUtilsKt.buildThirdIntent(BaseSplash.this.getSplash$adsplash_debug(), BaseSplash.this.getSplash$adsplash_debug().getAppLink(), BaseSplash.this.getSplash$adsplash_debug().getAppPkg());
                ISplashEvent.CC.onJumpClick$default(BaseSplash.this, intent, BaseSplash.this.getSplash$adsplash_debug().getAppLink(), BaseSplash.this.getSplash$adsplash_debug().getJumpUrl(), true, SplashActionType.CLICKABLE_EGG, true, null, null, 192, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void handleAction$default(BaseSplash baseSplash, SplashOrder splashOrder, SplashGuideButton splashGuideButton, SplashActionType splashActionType, ButtonClickData buttonClickData, int i, Object obj) {
        if ((i & 8) != 0) {
            buttonClickData = null;
        }
        handleAction(baseSplash, splashOrder, splashGuideButton, splashActionType, buttonClickData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAction(BaseSplash $this$handleAction, SplashOrder splash, SplashGuideButton splashGuideButton, SplashActionType actionType, ButtonClickData clickData) {
        Intent intent = SplashUtilsKt.buildThirdIntent(splash, splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName());
        String schema = splashGuideButton.getSchema();
        if (schema == null) {
            schema = splash.getAppLink();
        }
        String str = schema;
        String jumpUrl = splashGuideButton.getJumpUrl();
        if (jumpUrl == null) {
            jumpUrl = splash.getJumpUrl();
        }
        $this$handleAction.onJumpClick(intent, str, jumpUrl, true, actionType, true, String.valueOf(splashGuideButton.getId()), clickData);
    }
}