package tv.danmaku.bili.splash.ad.core;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.teenagersmode.TeenagersMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashSource;
import tv.danmaku.bili.splash.ad.page.HotSplashActivity;
import tv.danmaku.bili.splash.ad.page.HotSplashActivityKt;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashHotStartComponent.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\b\u0010\u0006\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"lastRequestTime", "", "checkHotSplashInner", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "tryUpdateSplashListWhenHotLaunch", "checkWithoutSplash", "", "TAG", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashHotStartComponentKt {
    private static final String TAG = "[Splash]SplashHotStartComponent";
    private static long lastRequestTime;

    public static final void checkHotSplashInner(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        BLog.i(TAG, "checkHotSplash");
        SplashCustomReporterKt.reportAppLaunch(true);
        if (TeenagersMode.getInstance().isEnable() || RestrictedMode.isEnable(RestrictedType.LESSONS, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH)) {
            BLog.i(TAG, "checkHotSplashInner, failure restrict mode");
            return;
        }
        tryUpdateSplashListWhenHotLaunch();
        if (((activity instanceof IDrawerHost) && ((IDrawerHost) activity).isSplashShowing()) || (activity instanceof HotSplashActivity)) {
            BLog.i(TAG, "checkHotSplashInner, failure splash showing");
        } else if (SplashManagerKt.getSplashState().getSplashShowIntervalBeginTimeMs() == 0) {
            BLog.i(TAG, "checkHotSplashInner, failure cold start not show");
            if (SplashConfigKt.getSplashSchemeColdStockEnable()) {
                SplashManagerKt.getSplashState().setSplashShowIntervalBeginTimeMs(SystemClock.elapsedRealtime() + 1000);
            }
        } else if (checkWithoutSplash(activity)) {
            BLog.i(TAG, "checkHotSplashInner, failure changlian");
        } else {
            long hotShowIntervalMs = SplashManagerKt.getSplashState().getSplashHotShowInterval() * 1000;
            long currentTime = SystemClock.elapsedRealtime();
            long hotIntervalMs = currentTime - SplashManagerKt.getSplashState().getSplashShowIntervalBeginTimeMs();
            if (hotIntervalMs < hotShowIntervalMs) {
                BLog.i(TAG, "checkHotSplashInner, failure interval. hotShowIntervalMs = " + hotShowIntervalMs + ", nowIntervalMs = " + hotIntervalMs);
                return;
            }
            SplashManagerKt.getSplashState().setSplashShowIntervalBeginTimeMs(currentTime);
            SplashOrder splash = SplashManager.getLocalListShowSplash$default(SplashManager.INSTANCE, SplashSource.HOT, false, 2, null);
            if (splash == null) {
                SplashAdHelper.INSTANCE.stockReport(BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT, false);
                BLog.i(TAG, "checkHotSplashInner, failure no order");
                return;
            }
            try {
                long id = splash.getId();
                int cardType = splash.getCardType();
                String imageUrl = splash.getImageUrl();
                BLog.i(TAG, "show hot splash, id = " + id + " cardType = " + cardType + " imageUrl = " + imageUrl + " videoUrl = " + splash.getVideoUrl());
                HotSplashActivityKt.setPendingShowHotSplash(splash);
                HotSplashActivityKt.isHotSplashShowing = true;
                RouteRequest request = new RouteRequest.Builder("bilibili://main/hot-splash2").addFlag(335544320).build();
                BLRouter.routeTo(request, activity);
            } catch (Exception e) {
                BLog.w(e.getMessage(), e);
                HotSplashActivityKt.setPendingShowHotSplash(null);
                HotSplashActivityKt.isHotSplashShowing = false;
            }
        }
    }

    private static final void tryUpdateSplashListWhenHotLaunch() {
        long now = System.currentTimeMillis();
        boolean validInterval = now - lastRequestTime > SplashConfigKt.getHotLaunchRequestListColdTimeMs();
        lastRequestTime = now;
        if (SplashConfigKt.getEnableHotLaunchRequestList() && SplashConfigKt.getEnableHotLaunchBehaviorRequestList() && validInterval) {
            BLog.i(TAG, "checkHotSplash, needUpdateSplash");
            SplashUpdateComponentKt.updateSplash(SplashConfigKt.getHotSplashDelayRefreshListTimeMs(), BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT);
        }
    }

    private static final boolean checkWithoutSplash(Activity activity) {
        Intent intent;
        Uri uri;
        if (activity == null || (intent = activity.getIntent()) == null || (uri = intent.getData()) == null) {
            return false;
        }
        String params = uri.getQueryParameter("h5awaken");
        String str = params;
        if (!(str == null || StringsKt.isBlank(str))) {
            try {
                byte[] bytes = params.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                byte[] decode = Base64.decode(bytes, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
                String h5awakenDec = new String(decode, Charsets.UTF_8);
                String $this$toUri$iv = uri + "&" + h5awakenDec;
                Uri newUri = Uri.parse($this$toUri$iv);
                if (Intrinsics.areEqual("huaweichanglian", newUri.getQueryParameter("open_app_from_type"))) {
                    BLog.i(TAG, "open from huawei changlian, not show hot splash");
                    activity.getIntent().setData(SplashUtilsKt.removeUriParameter(uri, "h5awaken"));
                    return true;
                }
            } catch (Exception e) {
                BLog.e(TAG, "checkWithoutSplash, base64 decode failed");
            }
        }
        return false;
    }
}