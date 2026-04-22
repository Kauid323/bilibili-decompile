package tv.danmaku.bili;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.homepage.home.model.StatusBarEvent;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.ExpectBannerRectUpdateAction;
import com.bilibili.lib.homepage.splash.actions.LocalShowTopViewIdUpdateAction;
import com.bilibili.lib.homepage.splash.actions.SplashOrderSelectFinishAction;
import com.bilibili.lib.ui.util.StatusBarCompat;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.core.test.FdDebugActivity;
import tv.danmaku.bili.report.startup.v2.BootTagHolder;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.splash.ad.core.SplashManager;
import tv.danmaku.bili.splash.ad.core.model.SplashTaskResultWrapper;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashExtra;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashSource;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashShowType;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.ui.clipboard.BvResult;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.clipboard.RecognizeResult;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.splash.LaunchClipboard;
import tv.danmaku.bili.utils.UriSpmidModuleHelper;

/* compiled from: MainActivitySplashComponentExt.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\b\u001a\u00020\u0006*\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a*\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\n*\u00020\u0004H\u0000\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\n*\u00020\u0004H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\f\u0010\u0013\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a(\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0019\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u0014\u0010\u001a\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H\u0002\u001a\u0016\u0010\u001b\u001a\u00020\u0003*\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002\u001a\f\u0010\u001e\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u001f\u001a\u00020\u0003*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010 \u001a\u00020!*\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"TAG", "", "preSelectBusinessSplashV2", "", "Ltv/danmaku/bili/MainActivityV2;", "hitEventSplash", "", "isDisable", "initSplashFragmentV2", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "reportAdStock", "getAdSplashFragment", "Landroidx/fragment/app/Fragment;", "reportStock", "isDeepLink", "getBusinessSplashV2", "getAdSplash", "refreshRequestedShowSplash", "modifyShowSplash", "exitSplashV2", "splashData", "", "jumpUrl", "jumped", "closeSplashV2", "hideSplash", "launchActivity", "targetUri", "Landroid/net/Uri;", "initExpectBannerRect", "registerSplashObserver", "toPx", "", "", "getToPx", "(I)F", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MainActivitySplashComponentExtKt {
    private static final String TAG = "[Main]MainActivitySplashComponent";

    public static final void preSelectBusinessSplashV2(MainActivityV2 $this$preSelectBusinessSplashV2, boolean hitEventSplash, boolean isDisable) {
        String topViewId;
        Intrinsics.checkNotNullParameter($this$preSelectBusinessSplashV2, "<this>");
        boolean z = false;
        if ($this$preSelectBusinessSplashV2.showSplash && !$this$preSelectBusinessSplashV2.inRestrictedMode()) {
            if (SplashManager.INSTANCE.needRePreloadOnPageCreate()) {
                SplashManager.INSTANCE.releasePreloadData();
                $this$preSelectBusinessSplashV2.mLocalListShowSplashOrder = SplashManager.INSTANCE.getLocalListShowSplash(SplashSource.COLD, true);
            } else {
                $this$preSelectBusinessSplashV2.mLocalListShowSplashOrder = SplashManager.INSTANCE.getLocalListShowSplash(SplashSource.COLD, false);
            }
        } else {
            SplashCustomReporterKt.reportShowType(null, SplashShowType.NOT_SHOW);
            SplashCustomReporterKt.reportStockNotReportReason(!$this$preSelectBusinessSplashV2.mFromLauncher, isDisable, hitEventSplash);
        }
        String str = $this$preSelectBusinessSplashV2.deepLinkSplashScheme;
        if (str == null || StringsKt.isBlank(str)) {
            SplashOrder splashOrder = $this$preSelectBusinessSplashV2.mLocalListShowSplashOrder;
            if (splashOrder != null && ExtSplashOrderKt.isTopView(splashOrder)) {
                z = true;
            }
            if (z) {
                SplashOrder splashOrder2 = $this$preSelectBusinessSplashV2.mLocalListShowSplashOrder;
                topViewId = String.valueOf(splashOrder2 != null ? Long.valueOf(splashOrder2.getId()) : null);
            } else {
                topViewId = "";
            }
            BLog.i(TAG, "preSelectBusinessSplashV2, time to set topview id");
            $this$preSelectBusinessSplashV2.mSplashViewModel.update(new LocalShowTopViewIdUpdateAction(topViewId));
        }
    }

    public static final boolean initSplashFragmentV2(MainActivityV2 $this$initSplashFragmentV2, SplashOrder splash, boolean reportAdStock) {
        Intrinsics.checkNotNullParameter($this$initSplashFragmentV2, "<this>");
        $this$initSplashFragmentV2.mLocalListShowSplashOrder = null;
        $this$initSplashFragmentV2.mRequestedRealtimeShowSplashWrapper = null;
        $this$initSplashFragmentV2.mRealtimeMaterialSplashOrder = null;
        BLog.i(TAG, "show splash id = " + (splash != null ? Long.valueOf(splash.getId()) : null));
        String str = $this$initSplashFragmentV2.deepLinkSplashScheme;
        Fragment adPage = getAdSplashFragment($this$initSplashFragmentV2, splash, reportAdStock, !(str == null || StringsKt.isBlank(str)));
        $this$initSplashFragmentV2.mSplashFragment = adPage;
        if (splash == null || adPage == null) {
            $this$initSplashFragmentV2.exitSplash(null, null, false);
            $this$initSplashFragmentV2.notifySplashExit();
            return false;
        }
        FragmentManager fm = $this$initSplashFragmentV2.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(fm, "getSupportFragmentManager(...)");
        Fragment fragment = fm.findFragmentByTag("ADSplashFragment");
        if (fragment != null) {
            fm.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
        FragmentTransaction transaction = fm.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(transaction, "beginTransaction(...)");
        FrameLayout frameLayout = $this$initSplashFragmentV2.mSplashLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        transaction.add(R.id.splash_layout, adPage, "ADSplashFragment");
        transaction.commitAllowingStateLoss();
        $this$initSplashFragmentV2.viewModel.update(new StatusBarEvent.EnterFullScreen("AdSplash"));
        return true;
    }

    static /* synthetic */ Fragment getAdSplashFragment$default(MainActivityV2 mainActivityV2, SplashOrder splashOrder, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return getAdSplashFragment(mainActivityV2, splashOrder, z, z2);
    }

    private static final Fragment getAdSplashFragment(MainActivityV2 $this$getAdSplashFragment, SplashOrder splash, boolean reportStock, boolean isDeepLink) {
        SplashExtra runtimeExtra;
        SplashExtra runtimeExtra2;
        SplashViewModel vm = new ViewModelProvider((ViewModelStoreOwner) $this$getAdSplashFragment).get(SplashViewModel.class);
        long id = splash != null ? splash.getId() : 0L;
        boolean isTopView = splash != null ? ExtSplashOrderKt.isTopView(splash) : false;
        boolean fromRealShow = (splash == null || (runtimeExtra2 = splash.getRuntimeExtra()) == null) ? false : runtimeExtra2.getFromRealShow();
        int topViewType = splash != null ? splash.getTopViewType() : 0;
        String str = null;
        String adCb = splash != null ? splash.getAdCb() : null;
        if (splash != null && (runtimeExtra = splash.getRuntimeExtra()) != null) {
            str = runtimeExtra.getBindBanner();
        }
        vm.update(new SplashOrderSelectFinishAction(id, isTopView, fromRealShow, topViewType, adCb, str));
        Fragment adPage = SplashManager.INSTANCE.createSplashPage(splash);
        SplashManager.INSTANCE.releasePreloadData();
        if (adPage == null && reportStock) {
            SplashAdHelper.INSTANCE.stockReport(BusinessSplashDefineKt.SPLASH_OPEN_EVENT_COLD, isDeepLink);
        }
        BootTracer.setSession(BootTagHolder.TAG_SP_DURATION, (splash != null ? splash.getDuration() : -1L) * 1000);
        SplashManager.INSTANCE.updateSplashShowIntervalBeginTimeMs();
        return adPage;
    }

    public static final SplashOrder getBusinessSplashV2(MainActivityV2 $this$getBusinessSplashV2) {
        SplashExtra runtimeExtra;
        Intrinsics.checkNotNullParameter($this$getBusinessSplashV2, "<this>");
        String str = $this$getBusinessSplashV2.deepLinkSplashScheme;
        boolean z = true;
        boolean isFromCallUp = !(str == null || StringsKt.isBlank(str));
        SplashOrder splash = getAdSplash($this$getBusinessSplashV2);
        if ((splash != null && splash.getSupportCalledUp()) && isFromCallUp) {
            splash.getRuntimeExtra().setFromCalledUp(true);
        }
        BLog.i(TAG, "getBusinessSplashV2, splashId = " + (splash != null ? Long.valueOf(splash.getId()) : null));
        if (isFromCallUp) {
            if (splash == null || !splash.getSupportCalledUp()) {
                z = false;
            }
            if (!z) {
                SplashOrder callUpSplash = SplashManager.getLocalListShowSplash$default(SplashManager.INSTANCE, SplashSource.CALL_UP, false, 2, null);
                BLog.i(TAG, "getBusinessSplashV2, deeplink splash = " + (callUpSplash != null ? Long.valueOf(callUpSplash.getId()) : null));
                if (callUpSplash != null && (runtimeExtra = callUpSplash.getRuntimeExtra()) != null) {
                    runtimeExtra.setFromRealShow(false);
                }
                return callUpSplash;
            }
        }
        return splash;
    }

    private static final SplashOrder getAdSplash(MainActivityV2 $this$getAdSplash) {
        SplashExtra runtimeExtra;
        SplashExtra runtimeExtra2;
        SplashOrder splashOrder;
        SplashExtra runtimeExtra3;
        refreshRequestedShowSplash($this$getAdSplash);
        boolean z = true;
        if ($this$getAdSplash.mRealtimeMaterialSplashOrder != null) {
            BLog.i(TAG, "getAdSplash, realtimeSplash = " + ($this$getAdSplash.mRealtimeMaterialSplashOrder != null ? Long.valueOf(splashOrder.getId()) : null));
            SplashCustomReporterKt.reportShowType($this$getAdSplash.mRealtimeMaterialSplashOrder, SplashShowType.REAL_TIME_SPLASH);
            SplashOrder splashOrder2 = $this$getAdSplash.mRealtimeMaterialSplashOrder;
            if (splashOrder2 != null && (runtimeExtra3 = splashOrder2.getRuntimeExtra()) != null) {
                runtimeExtra3.setFromRealShow(true);
            }
            return $this$getAdSplash.mRealtimeMaterialSplashOrder;
        }
        SplashTaskResultWrapper splashTaskResultWrapper = $this$getAdSplash.mRequestedRealtimeShowSplashWrapper;
        boolean showRequestSuccess = splashTaskResultWrapper != null ? splashTaskResultWrapper.getRequestShowSuccess() : false;
        if (showRequestSuccess) {
            SplashTaskResultWrapper splashTaskResultWrapper2 = $this$getAdSplash.mRequestedRealtimeShowSplashWrapper;
            SplashOrder realShowSplash = splashTaskResultWrapper2 != null ? splashTaskResultWrapper2.getSplash() : null;
            BLog.i(TAG, "getAdSplash, realShowSplash = " + (realShowSplash != null ? Long.valueOf(realShowSplash.getId()) : null));
            if (realShowSplash != null) {
                SplashCustomReporterKt.reportShowType(realShowSplash, SplashShowType.SHOW_DISPLAY);
            } else {
                SplashCustomReporterKt.reportShowType(null, SplashShowType.NOT_SHOW);
            }
            if (realShowSplash != null && (runtimeExtra2 = realShowSplash.getRuntimeExtra()) != null) {
                runtimeExtra2.setFromRealShow(true);
            }
            return realShowSplash;
        }
        if ($this$getAdSplash.mLocalListShowSplashOrder != null) {
            if ($this$getAdSplash.mLocalListShowSplashOrder == null) {
                SplashCustomReporterKt.reportShowType(null, SplashShowType.NOT_SHOW);
            } else {
                SplashOrder splashOrder3 = $this$getAdSplash.mLocalListShowSplashOrder;
                if (splashOrder3 == null || !ExtSplashOrderKt.isTopView(splashOrder3)) {
                    z = false;
                }
                if (z) {
                    SplashCustomReporterKt.reportShowType($this$getAdSplash.mLocalListShowSplashOrder, SplashShowType.TOP_VIEW);
                } else {
                    SplashCustomReporterKt.reportShowType($this$getAdSplash.mLocalListShowSplashOrder, SplashShowType.LOCAL_SHOW_DISPLAY);
                }
            }
        }
        SplashOrder splashOrder4 = $this$getAdSplash.mLocalListShowSplashOrder;
        if (splashOrder4 != null && (runtimeExtra = splashOrder4.getRuntimeExtra()) != null) {
            runtimeExtra.setFromRealShow(false);
        }
        return $this$getAdSplash.mLocalListShowSplashOrder;
    }

    private static final void refreshRequestedShowSplash(MainActivityV2 $this$refreshRequestedShowSplash) {
        SplashOrder realShowSplash;
        SplashOrder realtimeSplash;
        SplashExtra runtimeExtra;
        boolean z = true;
        if (!SplashConfigKt.getTopViewReadShowEnable()) {
            SplashOrder splashOrder = $this$refreshRequestedShowSplash.mLocalListShowSplashOrder;
            if (splashOrder != null && ExtSplashOrderKt.isTopView(splashOrder)) {
                return;
            }
        }
        if (!$this$refreshRequestedShowSplash.showSplash || $this$refreshRequestedShowSplash.inRestrictedMode()) {
            return;
        }
        $this$refreshRequestedShowSplash.mRequestedRealtimeShowSplashWrapper = SplashManager.INSTANCE.getRealtimeShowSplash();
        SplashManager splashManager = SplashManager.INSTANCE;
        String str = $this$refreshRequestedShowSplash.deepLinkSplashScheme;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        $this$refreshRequestedShowSplash.mRealtimeMaterialSplashOrder = splashManager.getRealtimeMaterialSplash(z ? SplashSource.COLD : SplashSource.CALL_UP);
        modifyShowSplash($this$refreshRequestedShowSplash);
        SplashTaskResultWrapper splashTaskResultWrapper = $this$refreshRequestedShowSplash.mRequestedRealtimeShowSplashWrapper;
        if (splashTaskResultWrapper == null || (realShowSplash = splashTaskResultWrapper.getSplash()) == null || (realtimeSplash = $this$refreshRequestedShowSplash.mRealtimeMaterialSplashOrder) == null) {
            return;
        }
        if (ExtSplashOrderKt.isTopView(realShowSplash) || realShowSplash.getRuntimeExtra().getOriginRealTimeShowIndex() < realtimeSplash.getRuntimeExtra().getOriginRealTimeShowIndex()) {
            SplashOrder splashOrder2 = $this$refreshRequestedShowSplash.mRealtimeMaterialSplashOrder;
            if (splashOrder2 != null && (runtimeExtra = splashOrder2.getRuntimeExtra()) != null) {
                runtimeExtra.setRealTimeSplashBitmap(null);
            }
            $this$refreshRequestedShowSplash.mRealtimeMaterialSplashOrder = null;
        }
    }

    private static final void modifyShowSplash(MainActivityV2 $this$modifyShowSplash) {
        SplashOrder showSplash;
        SplashOrder splashOrder;
        SplashTaskResultWrapper splashTaskResultWrapper = $this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper;
        if (splashTaskResultWrapper == null || (showSplash = splashTaskResultWrapper.getSplash()) == null) {
            return;
        }
        SplashOrder splashOrder2 = $this$modifyShowSplash.mLocalListShowSplashOrder;
        boolean z = true;
        SplashTaskResultWrapper splashTaskResultWrapper2 = null;
        SplashTaskResultWrapper splashTaskResultWrapper3 = null;
        if (((splashOrder2 == null || showSplash.getId() != splashOrder2.getId()) ? null : 1) != null || SplashManager.INSTANCE.trustRealtimeShowTopView()) {
            BLog.i(TAG, "modifyShowSplash, not modify, realtime show id = " + showSplash.getId() + " local show id = " + ($this$modifyShowSplash.mLocalListShowSplashOrder != null ? Long.valueOf(splashOrder.getId()) : null) + ", trust realtime show = " + SplashManager.INSTANCE.trustRealtimeShowTopView());
            return;
        }
        SplashOrder splashOrder3 = $this$modifyShowSplash.mLocalListShowSplashOrder;
        if (splashOrder3 == null || !ExtSplashOrderKt.isTopView(splashOrder3)) {
            z = false;
        }
        if (z) {
            SplashManager splashManager = SplashManager.INSTANCE;
            SplashTaskResultWrapper splashTaskResultWrapper4 = $this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper;
            SplashOrder splashOrder4 = $this$modifyShowSplash.mLocalListShowSplashOrder;
            Intrinsics.checkNotNull(splashOrder4);
            SplashOrder newSplash = splashManager.getRealtimeShowTopViewSplash(splashTaskResultWrapper4, splashOrder4.getId());
            SplashTaskResultWrapper splashTaskResultWrapper5 = $this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper;
            if (splashTaskResultWrapper5 != null) {
                SplashTaskResultWrapper splashTaskResultWrapper6 = $this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper;
                splashTaskResultWrapper2 = SplashTaskResultWrapper.copy$default(splashTaskResultWrapper5, null, newSplash, splashTaskResultWrapper6 != null ? splashTaskResultWrapper6.getRealTimeShowStrategies() : null, null, 8, null);
            }
            $this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper = splashTaskResultWrapper2;
        } else if (ExtSplashOrderKt.isTopView(showSplash)) {
            SplashOrder newSplash2 = SplashManager.INSTANCE.getRealtimeShowTopViewSplash($this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper, -1L);
            SplashTaskResultWrapper splashTaskResultWrapper7 = $this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper;
            if (splashTaskResultWrapper7 != null) {
                SplashTaskResultWrapper splashTaskResultWrapper8 = $this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper;
                splashTaskResultWrapper3 = SplashTaskResultWrapper.copy$default(splashTaskResultWrapper7, null, newSplash2, splashTaskResultWrapper8 != null ? splashTaskResultWrapper8.getRealTimeShowStrategies() : null, null, 8, null);
            }
            $this$modifyShowSplash.mRequestedRealtimeShowSplashWrapper = splashTaskResultWrapper3;
        }
    }

    public static final void exitSplashV2(MainActivityV2 $this$exitSplashV2, Object splashData, String jumpUrl, boolean jumped) {
        Intrinsics.checkNotNullParameter($this$exitSplashV2, "<this>");
        SplashOrder splash = splashData instanceof SplashOrder ? (SplashOrder) splashData : null;
        boolean z = false;
        if (!jumped) {
            String str = $this$exitSplashV2.deepLinkSplashScheme;
            if (!(str == null || StringsKt.isBlank(str))) {
                String str2 = $this$exitSplashV2.deepLinkSplashScheme;
                Intrinsics.checkNotNullExpressionValue(str2, "deepLinkSplashScheme");
                BLRouter.routeTo$default(RouteRequestKt.toRouteRequest(str2), (Context) null, 2, (Object) null);
            }
        }
        $this$exitSplashV2.deepLinkSplashScheme = null;
        if (splash != null) {
            String str3 = jumpUrl;
            if (str3 == null || StringsKt.isBlank(str3)) {
                z = true;
            }
            if (!z) {
                Uri uri = Uri.parse(jumpUrl);
                if (splash.isAdLoc()) {
                    BLog.i(TAG, "splash.isAdLoc :" + uri);
                    SplashAdHelper.INSTANCE.handleAdJump((Context) $this$exitSplashV2, splash, (r18 & 4) != 0 ? "" : jumpUrl, (r18 & 8) != 0 ? "" : null, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
                    hideSplash($this$exitSplashV2, jumped);
                    return;
                }
                launchActivity($this$exitSplashV2, uri);
                return;
            }
        }
        LaunchClipboard launchClipboard = LaunchClipboard.INSTANCE;
        RecognizeResult result = ClipboardChecker.getResult();
        launchClipboard.checkBvData(result instanceof BvResult ? (BvResult) result : null);
        hideSplash($this$exitSplashV2, jumped);
    }

    public static final void closeSplashV2(MainActivityV2 $this$closeSplashV2) {
        Intrinsics.checkNotNullParameter($this$closeSplashV2, "<this>");
        hideSplash($this$closeSplashV2, true);
    }

    private static final void hideSplash(MainActivityV2 $this$hideSplash, boolean jumped) {
        long delayTime = jumped ? RangesKt.coerceAtMost(SplashConfigKt.getDelayHideSplashTime(), (long) FdDebugActivity.UPDATE_DELAY_TIME) : 0L;
        BLog.i(TAG, "hideSplashWithDelay :" + delayTime + " jumped:" + jumped);
        if (delayTime <= 0) {
            $this$hideSplash.hideSplashFragment(false);
        } else {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$hideSplash), (CoroutineContext) null, (CoroutineStart) null, new MainActivitySplashComponentExtKt$hideSplash$1(delayTime, $this$hideSplash, null), 3, (Object) null);
        }
    }

    private static final void launchActivity(MainActivityV2 $this$launchActivity, Uri targetUri) {
        RouteResponse resp = null;
        if (targetUri != null) {
            BLog.i(TAG, "launchActivity:" + targetUri);
            RouteRequest request = new RouteRequest.Builder(UriSpmidModuleHelper.appendFromSpmid(targetUri, BusinessSplashDefineKt.SPLASH_SPMID)).build();
            resp = BLRouter.routeTo(request, (Context) $this$launchActivity);
        }
        boolean z = false;
        if (resp != null && resp.isSuccess()) {
            z = true;
        }
        hideSplash($this$launchActivity, z);
    }

    public static final void initExpectBannerRect(MainActivityV2 $this$initExpectBannerRect) {
        Intrinsics.checkNotNullParameter($this$initExpectBannerRect, "<this>");
        float defaultBannerPadding = getToPx(5);
        float defaultBannerWidth = ScreenUtil.getScreenWidth((Context) $this$initExpectBannerRect) - (2 * defaultBannerPadding);
        float defaultTopMargin = getToPx(96) + StatusBarCompat.getStatusBarHeight((Context) $this$initExpectBannerRect);
        Rect rect = new Rect(MathKt.roundToInt(defaultBannerPadding), MathKt.roundToInt(defaultTopMargin), MathKt.roundToInt(defaultBannerPadding + defaultBannerWidth), MathKt.roundToInt((defaultBannerWidth / 1.78f) + defaultTopMargin));
        $this$initExpectBannerRect.mSplashViewModel.update(new ExpectBannerRectUpdateAction(rect));
    }

    public static final void registerSplashObserver(MainActivityV2 $this$registerSplashObserver) {
        Intrinsics.checkNotNullParameter($this$registerSplashObserver, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$registerSplashObserver), (CoroutineContext) null, (CoroutineStart) null, new MainActivitySplashComponentExtKt$registerSplashObserver$1($this$registerSplashObserver, null), 3, (Object) null);
    }

    private static final float getToPx(int $this$toPx) {
        return Resources.getSystem().getDisplayMetrics().density * $this$toPx;
    }
}