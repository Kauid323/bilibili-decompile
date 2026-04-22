package tv.danmaku.bili.splash.ad.page.component;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.bilibili.app.comm.list.common.utils.BLRemoteConfigUtilKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerType;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.splash.ad.utils.UiUtilsKt;
import tv.danmaku.bili.splash.ad.widget.MotionEventListener;
import tv.danmaku.bili.splash.ad.widget.SplashInteractView;

/* compiled from: FullScreenSlideComponent.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u001c\u0010\f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"TAG", "", "initSplashSlideInteractLayer", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "handleInteractEvent", "", "length", "", "angle", "", "handlerOutsideArea", "getOrDefault", "Lcom/google/gson/JsonObject;", "key", "def", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullScreenSlideComponentKt {
    private static final String TAG = "[Splash]InteractLayerComponent";

    public static final void initSplashSlideInteractLayer(final BaseSplash $this$initSplashSlideInteractLayer) {
        Intrinsics.checkNotNullParameter($this$initSplashSlideInteractLayer, "<this>");
        if (!ExtSplashOrderKt.isInteractSupport($this$initSplashSlideInteractLayer.getSplash$adsplash_debug())) {
            $this$initSplashSlideInteractLayer.getBinding$adsplash_debug().splashButtonContainer.setInteractEnable(false);
            $this$initSplashSlideInteractLayer.getBinding$adsplash_debug().splashInteractView.setVisibility(8);
            return;
        }
        SplashInteractView.InteractListener interactListener = new SplashInteractView.InteractListener() { // from class: tv.danmaku.bili.splash.ad.page.component.FullScreenSlideComponentKt$initSplashSlideInteractLayer$interactListener$1
            @Override // tv.danmaku.bili.splash.ad.widget.SplashInteractView.InteractListener
            public void onScroll(float length, int angle) {
                FullScreenSlideComponentKt.handleInteractEvent(BaseSplash.this, length, angle);
            }

            @Override // tv.danmaku.bili.splash.ad.widget.SplashInteractView.InteractListener
            public void onInteractLayerClicked() {
                SplashAdHelper.INSTANCE.adSplashOutsideClick$adsplash_debug(BaseSplash.this.getSplash$adsplash_debug());
                if (!ExtSplashOrderKt.isSplashClickable(BaseSplash.this.getSplash$adsplash_debug())) {
                    return;
                }
                Intent intent = SplashUtilsKt.buildThirdIntent(BaseSplash.this.getSplash$adsplash_debug(), BaseSplash.this.getSplash$adsplash_debug().getAppLink(), BaseSplash.this.getSplash$adsplash_debug().getAppPkg());
                ISplashEvent.CC.onJumpClick$default(BaseSplash.this, intent, BaseSplash.this.getSplash$adsplash_debug().getAppLink(), BaseSplash.this.getSplash$adsplash_debug().getJumpUrl(), true, SplashActionType.UNDEFINE, true, null, null, 192, null);
            }
        };
        handlerOutsideArea($this$initSplashSlideInteractLayer);
        $this$initSplashSlideInteractLayer.getBinding$adsplash_debug().splashInteractView.setVisibility(0);
        $this$initSplashSlideInteractLayer.getBinding$adsplash_debug().splashInteractView.setOnInteractListener(interactListener);
        $this$initSplashSlideInteractLayer.getBinding$adsplash_debug().splashButtonContainer.setInteractEnable(true);
        $this$initSplashSlideInteractLayer.getBinding$adsplash_debug().splashButtonContainer.setEventListener(new MotionEventListener() { // from class: tv.danmaku.bili.splash.ad.page.component.FullScreenSlideComponentKt$initSplashSlideInteractLayer$1
            @Override // tv.danmaku.bili.splash.ad.widget.MotionEventListener
            public void onTouchEvent(MotionEvent ev) {
                Intrinsics.checkNotNullParameter(ev, "ev");
                ViewGroup.LayoutParams layoutParams = BaseSplash.this.getBinding$adsplash_debug().splashInteractView.getLayoutParams();
                ViewGroup.MarginLayoutParams lps = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (lps == null) {
                    return;
                }
                MotionEvent newEv = MotionEvent.obtain(ev);
                newEv.offsetLocation(-lps.leftMargin, -lps.rightMargin);
                BaseSplash.this.getBinding$adsplash_debug().splashInteractView.deliverySlideEvent(newEv);
                newEv.recycle();
            }
        });
    }

    public static final boolean handleInteractEvent(BaseSplash $this$handleInteractEvent, float length, int angle) {
        Intrinsics.checkNotNullParameter($this$handleInteractEvent, "<this>");
        float pxToDp = UiUtilsKt.getPxToDp(length);
        BLog.i(TAG, "handleInteractEvent, length = " + pxToDp + ", angle = " + angle + ", length limit = " + $this$handleInteractEvent.getSplash$adsplash_debug().getInteractDistance() + ", angle limit = " + $this$handleInteractEvent.getSplash$adsplash_debug().getInteractAngle());
        if (!ExtSplashOrderKt.isInteractSupport($this$handleInteractEvent.getSplash$adsplash_debug()) || length <= 0.0f) {
            return false;
        }
        SplashAdHelper.INSTANCE.reportSplashInteract$adsplash_debug($this$handleInteractEvent.getSplash$adsplash_debug(), UiUtilsKt.getPxToDp(length), $this$handleInteractEvent.getSplash$adsplash_debug().getInteractDistance(), angle, $this$handleInteractEvent.getSplash$adsplash_debug().getInteractAngle());
        boolean isValidAngle = $this$handleInteractEvent.getSplash$adsplash_debug().getInteractAngle() <= 0 || angle <= $this$handleInteractEvent.getSplash$adsplash_debug().getInteractAngle();
        if (length >= ListExtentionsKt.toPx($this$handleInteractEvent.getSplash$adsplash_debug().getInteractDistance()) && isValidAngle) {
            if (!$this$handleInteractEvent.getComponentHolder$adsplash_debug().isSecondPageTriggered()) {
                long showTimeBeforeClick = StatisticComponentKt.calculateSplashRealDuration($this$handleInteractEvent);
                SplashAdHelper.INSTANCE.adReportSplashClicked$adsplash_debug($this$handleInteractEvent.getSplash$adsplash_debug(), true, "ad_splash_slide", (r20 & 8) != 0 ? null : null, showTimeBeforeClick, (r20 & 32) != 0, (r20 & 64) != 0 ? null : null);
                SplashCustomReporterKt.reportSplashClick($this$handleInteractEvent.getSplash$adsplash_debug(), $this$handleInteractEvent.getSplash$adsplash_debug().getJumpUrl(), "0", "splash_slide", "", showTimeBeforeClick);
            }
            if (SecondPageComponentKt.canShowSecondPage($this$handleInteractEvent)) {
                SecondPageComponentKt.onTriggerSecondPage($this$handleInteractEvent, SplashActionType.SLIDE);
                return false;
            }
            ISplashEvent.CC.onPageJump$default($this$handleInteractEvent, false, null, LiveReserveTriggerType.SLIDE, 2, null);
            return true;
        }
        SplashAdHelper.INSTANCE.adSplashSlideFail$adsplash_debug($this$handleInteractEvent.getSplash$adsplash_debug(), null);
        return false;
    }

    private static final void handlerOutsideArea(BaseSplash $this$handlerOutsideArea) {
        int i;
        ViewGroup.LayoutParams layoutParams = $this$handlerOutsideArea.getBinding$adsplash_debug().splashInteractView.getLayoutParams();
        ViewGroup.MarginLayoutParams lps = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (lps == null) {
            return;
        }
        int height = $this$handlerOutsideArea.getResources().getDisplayMetrics().heightPixels;
        int width = $this$handlerOutsideArea.getResources().getDisplayMetrics().widthPixels;
        JsonObject config = (JsonObject) BLRemoteConfigUtilKt.getFawkesConfigObjectByGson("splash.interact_outside_area", JsonObject.class, new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.FullScreenSlideComponentKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                JsonObject handlerOutsideArea$lambda$0;
                handlerOutsideArea$lambda$0 = FullScreenSlideComponentKt.handlerOutsideArea$lambda$0();
                return handlerOutsideArea$lambda$0;
            }
        });
        float left = getOrDefault(config, "left", 4.0f);
        float right = getOrDefault(config, "right", 4.0f);
        float top = getOrDefault(config, "top", 8.0f);
        float bottom = getOrDefault(config, "bottom", 8.0f);
        lps.topMargin = (int) (height * 0.01f * top);
        if (ExtSplashOrderKt.isFullScreen($this$handlerOutsideArea.getSplash$adsplash_debug())) {
            i = (int) (height * 0.01f * bottom);
        } else {
            i = ((int) (height * 0.01f * bottom)) + ($this$handlerOutsideArea.getResources().getDisplayMetrics().heightPixels / 8);
        }
        lps.bottomMargin = i;
        lps.leftMargin = (int) (width * 0.01f * left);
        lps.rightMargin = (int) (width * 0.01f * right);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject handlerOutsideArea$lambda$0() {
        return new JsonObject();
    }

    private static final float getOrDefault(JsonObject $this$getOrDefault, String key, float def) {
        try {
            JsonElement jsonElement = $this$getOrDefault.get(key);
            return jsonElement != null ? jsonElement.getAsFloat() : def;
        } catch (Exception e) {
            return def;
        }
    }
}