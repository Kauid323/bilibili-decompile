package tv.danmaku.bili;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.bilibili.app.comm.device.info.DeviceInfoUtils;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.base.util.GlobalNetworkController;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.gripper.GripperExecute;
import com.bilibili.gripper.api.updater.GUpdater;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.homepage.UserProtocolDialogService;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.homepage.INewIntentCompat;
import com.bilibili.lib.homepage.ISearchViewHost;
import com.bilibili.lib.homepage.IWindowFocusChanged;
import com.bilibili.lib.homepage.home.model.StatusBarEvent;
import com.bilibili.lib.homepage.mine.LoginChecker;
import com.bilibili.lib.homepage.splash.BaseMainViewModel;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.LocalShowTopViewIdUpdateAction;
import com.bilibili.lib.homepage.splash.actions.RealBannerRectUpdateAction;
import com.bilibili.lib.homepage.splash.model.SplashState;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.DpUtils;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.performance.BootOpt;
import com.bilibili.lib.performance.DLog;
import com.bilibili.lib.performance.EntryPointKt;
import com.bilibili.lib.projection.ProjectionModuleKt;
import com.bilibili.lib.setup.SetupTrack;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.lib.ui.PermissionsChecker;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.garb.GarbWatcher;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.moduleservice.main.RelationService;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerContainer;
import com.bilibili.pvtracker.PageViewTracker;
import com.bilibili.teenagersmode.TeenagersMode;
import com.bilibili.teenagersmode.TeenagersModeManager;
import com.squareup.otto.Bus;
import dagger.hilt.EntryPoints;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.appwidget.hotlist.HotListAppWidget;
import tv.danmaku.bili.appwidget.hotword.work.BiliWidgetWorkManager;
import tv.danmaku.bili.appwidget.upcard.UpCardAppWidget;
import tv.danmaku.bili.components.HomeStatusBarComponentKt;
import tv.danmaku.bili.core.test.FdDebugActivity;
import tv.danmaku.bili.eventbus.EventBusHost;
import tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt;
import tv.danmaku.bili.report.ReferrerUtil;
import tv.danmaku.bili.report.biz.main.DeviceInfoReporterKt;
import tv.danmaku.bili.report.startup.FragmentTracerKt;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.report.startup.v2.StartShowRecorder;
import tv.danmaku.bili.report.startup.v3.BootTracerV2;
import tv.danmaku.bili.report.umeng.UmengReportUtilKt;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.router.SearchRoutes;
import tv.danmaku.bili.splash.ad.core.model.SplashTaskResultWrapper;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.compatibility.CompatibilityUpdateDialog;
import tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonManager;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;
import tv.danmaku.bili.ui.garb.core.GarbStorageHelper;
import tv.danmaku.bili.ui.intent.IntentHandlerActivity;
import tv.danmaku.bili.ui.main.AppsFlyerManager;
import tv.danmaku.bili.ui.main2.BottomBubbleHelper;
import tv.danmaku.bili.ui.main2.MainFragment;
import tv.danmaku.bili.ui.main2.MainTransaction;
import tv.danmaku.bili.ui.main2.StartupFragmentV2;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialogEntrepot;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolDismissObserver;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolExperiment;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.splash.LaunchInitialization;
import tv.danmaku.bili.ui.splash.LaunchNavigation;
import tv.danmaku.bili.ui.splash.MainSplashHelper;
import tv.danmaku.bili.ui.splash.ad.SplashHelper;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashNotShowReason;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashShowType;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashData;
import tv.danmaku.bili.ui.splash.ad.model.SplashSource;
import tv.danmaku.bili.ui.splash.ad.model.SplashTaskResult;
import tv.danmaku.bili.ui.splash.ad.page.HotSplashActivityKt;
import tv.danmaku.bili.ui.splash.ad.page.ISplash;
import tv.danmaku.bili.ui.splash.brand.BrandSplashHelper;
import tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter;
import tv.danmaku.bili.ui.splash.brand.ui.BrandSplashFragment;
import tv.danmaku.bili.ui.splash.event.EventSplashData;
import tv.danmaku.bili.ui.splash.event.EventSplashFragment;
import tv.danmaku.bili.ui.splash.event.EventSplashManagerKt;
import tv.danmaku.bili.ui.splash.mod.SplashModDownloadFragment;
import tv.danmaku.bili.ui.splash.mod.SplashModHelper;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.ui.theme.ThemeManager;
import tv.danmaku.bili.ui.video.main.H5AwakenTrackingHelper;
import tv.danmaku.bili.ui.video.main.UtilKt;
import tv.danmaku.bili.utils.NetworkController;

public class MainActivityV2 extends Hilt_MainActivityV2 implements IDrawerHost, EventBusHost, ISearchViewHost, ThemeManager.ThemeListener, GarbWatcher.Observer, ISplash.SplashHost, PageViewTracker.OnReceiveCurrentEventIdListener, UserProtocolDismissObserver, DelayTaskController.IInterceptDialogHost, IMiniPlayerContainer {
    protected static final String AD_SPLASH_TAG = "ADSplashFragment";
    private static final String BRAND_SPLASH_TAG = "BrandSplashFragment";
    private static final String MAIN_BACK_CLICK = "main.public-community.back.0.click";
    private static final String MAIN_BACK_PV_END = ".pv";
    public static final String ROUTE_NAME = "MainPage";
    private static final String SAVE_KEY_IN_FAKE_PEGASUS = "key_is_protocol_processing";
    private static final String SAVE_KEY_SHOW_PROTOCOL = "key_show_protocol";
    private static final int SCREENLAYOUT_COMPAT_NEEDED = 268435456;
    private static final String TAG = "[Main]MainActivityV2";
    private static final String USER_SPLASH_TAG = "UserSplashFragment";
    public String deepLinkSplashScheme;
    private boolean isInFakePegasus;
    private Fragment mBrandSplashFragment;
    private String mCurrentPvId;
    private boolean mFirstBoot;
    protected boolean mFromLauncher;
    private long mLastBackTime;
    protected SplashOrder mLocalListShowSplashOrder;
    private LoginChecker mLoginChecker;
    private Fragment mMainFragment;
    private MainSplashHelper mMainSplashHelper;
    protected SplashOrder mRealtimeMaterialSplashOrder;
    private Splash mRealtimeSplash;
    protected SplashTaskResultWrapper mRequestedRealtimeShowSplashWrapper;
    private SplashTaskResult mRequestedShowSplash;
    private Splash mSplash;
    protected Fragment mSplashFragment;
    protected FrameLayout mSplashLayout;
    public SplashViewModel mSplashViewModel;
    protected boolean showSplash;
    private boolean splashFinish;
    public BaseMainViewModel viewModel;
    private boolean isBrandSplashCanExit = false;
    private boolean mIsBlock = false;
    private long pageCreateTime = 0;
    private final Bus mBus = new Bus("MainActivity");
    private final ThemeWatcher.MainObserver mThemeObserver = new ThemeWatcher.MainObserver() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda5
        public final void onThemeChanged() {
            MainActivityV2.this.m638lambda$new$0$tvdanmakubiliMainActivityV2();
        }
    };
    private Configuration mConfiguration = null;
    private final PassportObserver passportObserver = new PassportObserver() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda6
        public final void onChange(Topic topic) {
            MainActivityV2.this.m639lambda$new$1$tvdanmakubiliMainActivityV2(topic);
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(com.bilibili.lib.tribe.core.internal.Hooks.hookAttachContext(this, context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$new$0$tv-danmaku-bili-MainActivityV2  reason: not valid java name */
    public /* synthetic */ void m638lambda$new$0$tvdanmakubiliMainActivityV2() {
        getDelegate().setLocalNightMode(MultipleThemeUtils.getCurrentNightMode(this));
        MainFragment fragment = getMainFragment();
        if (fragment == null || !fragment.isToolbarColorUpdated()) {
            tintStatusBarPureForDrawer();
        }
        BiliTheme.tintTaskDescription(this);
        ThemeUtils.refreshUI(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$new$1$tv-danmaku-bili-MainActivityV2  reason: not valid java name */
    public /* synthetic */ void m639lambda$new$1$tvdanmakubiliMainActivityV2(Topic topic) {
        if (topic == Topic.SIGN_IN || topic == Topic.SIGN_OUT) {
            BiliWidgetWorkManager.Companion.update(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.Hilt_MainActivityV2
    protected void onCreate(Bundle savedInstanceState) {
        DLog.d(TAG, "onCreate");
        if (savedInstanceState != null) {
            GripperExecute.Companion.of().awaitSetupJob();
        }
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.ENTRY_ACTIVITY_CREATE_START);
        this.pageCreateTime = SystemClock.elapsedRealtime();
        StartChecker.mainActivityRan();
        this.mFromLauncher = isFromLauncher(savedInstanceState);
        BootTracer.setFromLauncher(this.mFromLauncher);
        this.mConfiguration = getResources().getConfiguration();
        this.viewModel = new ViewModelProvider(this).get(BaseMainViewModel.class);
        this.mSplashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        HomeStatusBarComponentKt.observerStatusBarStatus(this);
        SystemPushDialogHelperKt.recordMainActivityCreateOnBlock(this);
        super.onCreate(savedInstanceState);
        if (DelayTaskController.shouldBlock()) {
            this.mIsBlock = true;
            if (DelayTaskController.INSTANCE.getBlockReason() == DelayTaskController.BlockReason.ABI_INCOMPATIBLE) {
                new CompatibilityUpdateDialog(this).show();
            } else {
                UserProtocolBlockDialogEntrepot.INSTANCE.reset();
                UserProtocolHelper.UserDialogDismissWatcher.subscribe(this);
                UserProtocolHelper.showBlockDialog(this, new UserProtocolDialogListener() { // from class: tv.danmaku.bili.MainActivityV2.1
                    public void onAgree() {
                        MainActivityV2.this.agreePrivacyProtocol();
                    }

                    public void onCancel(boolean isFirstStep) {
                        BLog.d(MainActivityV2.TAG, "onUserProtocolCancelClick isFirstStep = " + isFirstStep);
                        UserProtocolDialogService service = (UserProtocolDialogService) BLRouter.INSTANCE.get(UserProtocolDialogService.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
                        if (service != null && isFirstStep && service.hitVisitMode()) {
                            BLRouter.routeTo(new RouteRequest.Builder("bilibili://main/fake-main-page").overridePendingTransition(0, 0).build(), MainActivityV2.this);
                            MainActivityV2.this.isInFakePegasus = true;
                        }
                    }
                }, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
            }
            BootTracer.setFirstLaunch();
            BootTracer.setHasPrivacy();
        } else if (UserProtocolHelper.shouldShowDialog(this) && canShowProtocol(savedInstanceState)) {
            this.mIsBlock = true;
            UserProtocolHelper.UserDialogDismissWatcher.subscribe(this);
            UserProtocolHelper.showDialog(this, new UserProtocolDialogListener() { // from class: tv.danmaku.bili.MainActivityV2.2
                public void onAgree() {
                    MainActivityV2.this.mIsBlock = false;
                    MainActivityV2.this.mFromLauncher = true;
                    if (!GlobalNetworkController.isNetworkAllowed()) {
                        NetworkController.setNetworkAllow(true);
                    }
                    MainActivityV2.this.doOnCreate(true, null);
                }

                public void onCancel(boolean isFirstStep) {
                }
            }, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
            BootTracer.setHasPrivacy();
        } else {
            boolean fromFakePegasus = savedInstanceState != null && savedInstanceState.getBoolean(SAVE_KEY_IN_FAKE_PEGASUS, false);
            if (fromFakePegasus) {
                this.isInFakePegasus = false;
                doOnCreate(false, null);
            } else {
                doOnCreate(false, savedInstanceState);
            }
        }
        BiliAccounts.get(BiliContext.application()).subscribe(this.passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.ENTRY_ACTIVITY_CREATE_END);
        HotListAppWidget.Companion.registerActivityCallBack();
        HotListAppWidget.Companion.registerPackageChanged();
        UpCardAppWidget.Companion.registerActivityCallBack();
        UpCardAppWidget.Companion.registerPackageChanged();
        MainRecreateUtilKt.reportPageState(savedInstanceState != null);
        DeviceInfoUtils.INSTANCE.registerFoldableDeviceTracker(this);
        DLog.d(TAG, "onCreate end");
    }

    public void setTaskDescription() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agreePrivacyProtocol() {
        this.mIsBlock = false;
        this.mFromLauncher = true;
        doOnCreate(true, null);
    }

    private boolean canShowProtocol(Bundle savedInstanceState) {
        return savedInstanceState == null || savedInstanceState.getBoolean(SAVE_KEY_SHOW_PROTOCOL, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.ENTRY_ACTIVITY_START_START);
        super.onStart();
        if (this.mIsBlock) {
            return;
        }
        getDelegate().setLocalNightMode(MultipleThemeUtils.getCurrentNightMode(this));
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.ENTRY_ACTIVITY_START_END);
    }

    protected void onResume() {
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.ENTRY_ACTIVITY_RESUME_START);
        BootOpt.INSTANCE.resetAwakeCanReportTag();
        super.onResume();
        if (this.mIsBlock) {
            return;
        }
        doOnResume();
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.ENTRY_ACTIVITY_RESUME_END);
    }

    protected void onPause() {
        super.onPause();
        if (this.mIsBlock) {
            return;
        }
        ProjectionModuleKt.getProjectionService().hideFloatView();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVE_KEY_SHOW_PROTOCOL, this.mIsBlock);
        outState.putBoolean(SAVE_KEY_IN_FAKE_PEGASUS, this.isInFakePegasus);
    }

    public boolean isFromLauncher(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        return (savedInstanceState == null && TextUtils.equals(intent.getAction(), "android.intent.action.MAIN") && intent.hasCategory("android.intent.category.LAUNCHER")) || EntryPointKt.getBootOptBuild();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void doOnCreate(boolean isDialogIntercept, Bundle saveInstanceState) {
        GripperExecute.Companion.of().direTrigger("boot_opt_main");
        StartChecker.postMainActivityRan(getWindow().getDecorView());
        ReferrerUtil.INSTANCE.initReferrer(this);
        if (saveInstanceState == null) {
            if (SplashConfigKt.getSplashUseNewSplashExp()) {
                SplashCustomReporterKt.reportMainActivityLaunch();
            } else {
                tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportMainActivityLaunch();
            }
        }
        if (LaunchNavigation.INSTANCE.needJudgeTaskRoot(this) && !isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && TextUtils.equals(action, "android.intent.action.MAIN")) {
                LaunchNavigation.INSTANCE.increaseFinishTimes(this);
                finish();
                return;
            }
        }
        this.mFirstBoot = LaunchInitialization.INSTANCE.firstBoot();
        if (saveInstanceState == null && SplashModHelper.checkX86So(this) && !SplashModHelper.isModLoaded()) {
            initModDownloadFragment();
            return;
        }
        setContentView(R.layout.bili_app_activity_main_v2);
        if (this.mFirstBoot && (!isDialogIntercept || !AppsFlyerManager.INSTANCE.getJumpPerformed())) {
            AppsFlyerManager.INSTANCE.setJumpPerformed(true);
        }
        if (!GarbStorageHelper.INSTANCE.isGarbInitialized(this)) {
            BLog.i(TAG, "garb initialized false");
            BiliTheme.setCurrentTheme(this, 8);
            GarbStorageHelper.INSTANCE.saveGarbInitialized(this, true);
        }
        if (saveInstanceState == null) {
            SystemPushDialogHelperKt.showSystemPushDialogOnFirstStart(this);
        }
        doMainInit(saveInstanceState);
    }

    private void showSplash(Bundle savedInstanceState) {
        DLog.d(TAG, "showSplash");
        final boolean showBrand = (this.isInFakePegasus || UserProtocolExperiment.hitSpecificBg() || !checkBrandSplash(this.mFromLauncher, TextUtils.isEmpty(this.deepLinkSplashScheme) ^ true)) ? false : true;
        boolean hitEventSplash = this.mBrandSplashFragment instanceof EventSplashFragment;
        boolean isHotSplashShowing = HotSplashActivityKt.isHotSplashShowing || tv.danmaku.bili.splash.ad.page.HotSplashActivityKt.isHotSplashShowing;
        this.showSplash = ((!this.mFromLauncher && TextUtils.isEmpty(this.deepLinkSplashScheme)) || hitEventSplash || isHotSplashShowing) ? false : true;
        if (SplashConfigKt.getSplashUseNewSplashExp()) {
            MainActivitySplashComponentExtKt.preSelectBusinessSplashV2(this, hitEventSplash, false);
        } else {
            if (this.showSplash && !inRestrictedMode()) {
                if (SplashHelper.isNeedRePreloadOnPageCreate()) {
                    SplashHelper.releasePreload();
                    this.mSplash = SplashHelper.getSplashForShow(SplashSource.COLD, true);
                } else {
                    this.mSplash = SplashHelper.getSplashForShow(SplashSource.COLD);
                }
            } else {
                SplashHelper.notShowReason = SplashNotShowReason.DISABLE_SPLASH;
                tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportShowType((Splash) null, SplashShowType.NOT_SHOW);
                tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportStockNotReportReason(!this.mFromLauncher, false, hitEventSplash);
            }
            if (TextUtils.isEmpty(this.deepLinkSplashScheme)) {
                BLog.i(TAG, "doMainInit, time to set topview id");
                this.mSplashViewModel.update(new LocalShowTopViewIdUpdateAction((this.mSplash == null || !this.mSplash.isTopView()) ? "" : String.valueOf(this.mSplash.id)));
            }
        }
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.SPLASH_END);
        if (MainDialogManager.isFirst()) {
            MainDialogManager.block();
        }
        GripperExecute.Companion.of().awaitMain(new Function0() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda7
            public final Object invoke() {
                return MainActivityV2.lambda$showSplash$2();
            }
        }, new Function0() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda8
            public final Object invoke() {
                return MainActivityV2.this.m640lambda$showSplash$3$tvdanmakubiliMainActivityV2(showBrand);
            }
        });
        if (this.showSplash && !showBrand) {
            if (SplashConfigKt.getSplashUseNewSplashExp()) {
                MainActivitySplashComponentExtKt.initSplashFragmentV2(this, MainActivitySplashComponentExtKt.getBusinessSplashV2(this), true);
            } else {
                initSplashFragment(getBusinessSplash(), true);
            }
        }
        DLog.d(TAG, "showSplash end");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$showSplash$2() {
        GripperExecute.Companion.of().await("infra.initRouter");
        GripperExecute.Companion.of().await("infra.initImage");
        GripperExecute.Companion.of().await("app.initGarb");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showSplash$3$tv-danmaku-bili-MainActivityV2  reason: not valid java name */
    public /* synthetic */ Unit m640lambda$showSplash$3$tvdanmakubiliMainActivityV2(boolean showBrand) {
        initMainFragment();
        if (!this.showSplash && !showBrand) {
            doAfterSplash();
            notifySplashExit();
            return null;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void doMainInit(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            FragmentTracerKt.trackFragmentCreateTime(this);
            UmengReportUtilKt.reportUmengDeviceInfo();
        }
        this.mLoginChecker = new LoginChecker(this);
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.SPLASH_START);
        this.mSplashLayout = (FrameLayout) findViewById(R.id.splash_layout);
        this.mSplashViewModel.getActivityFromSplash().setValue(Boolean.valueOf(this.mFromLauncher));
        MainActivitySplashComponentExtKt.registerSplashObserver(this);
        MainActivitySplashComponentExtKt.initExpectBannerRect(this);
        this.deepLinkSplashScheme = null;
        this.deepLinkSplashScheme = getIntent().getStringExtra("deeplink_splash_scheme");
        getIntent().removeExtra("deeplink_splash_scheme");
        BLog.i(TAG, "doMainInit, deeplink_splash_scheme = " + this.deepLinkSplashScheme);
        showSplash(savedInstanceState);
        GripperExecute.Companion.of().asyncSetupJon(new AnonymousClass3(savedInstanceState));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.MainActivityV2$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass3 implements Function0<Unit> {
        final /* synthetic */ Bundle val$savedInstanceState;

        AnonymousClass3(Bundle bundle) {
            this.val$savedInstanceState = bundle;
        }

        public Unit invoke() {
            SetupTrack.sendEvent(MainActivityV2.this);
            DeviceInfoReporterKt.reportInfo();
            DelayTaskController.reportErrorIfExist();
            BrandSplashHelper.INSTANCE.release();
            ThemeWatcher.getInstance().subscribeMain(MainActivityV2.this.mThemeObserver);
            GarbWatcher.INSTANCE.subscribe(MainActivityV2.this);
            if (this.val$savedInstanceState != null) {
                Garb garb = GarbManager.getGarbWithNightMode(MainActivityV2.this);
                if (garb.isPure()) {
                    MainActivityV2.this.tintStatusBarPureForDrawer();
                } else {
                    MainActivityV2.this.tintSystemBar(garb.getSecondaryPageColor(), garb.isDarkMode() ? 1 : 2);
                }
            }
            PageViewTracker.getInstance().registerReceiveCurrentEventIdListener(MainActivityV2.this);
            ThemeManager.getInstance(MainActivityV2.this).setThemeListener(MainActivityV2.this);
            ThemeManager.getInstance(MainActivityV2.this).update();
            MainActivityV2.this.initThemeTips(MainActivityV2.this);
            CrashReporter.INSTANCE.setUserSceneTag(MainActivityV2.this.getApplicationContext(), -1);
            if (LaunchNavigation.isFirst) {
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: tv.danmaku.bili.MainActivityV2$3$$ExternalSyntheticLambda0
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        return MainActivityV2.AnonymousClass3.this.m641lambda$invoke$0$tvdanmakubiliMainActivityV2$3();
                    }
                });
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$invoke$0$tv-danmaku-bili-MainActivityV2$3  reason: not valid java name */
        public /* synthetic */ boolean m641lambda$invoke$0$tvdanmakubiliMainActivityV2$3() {
            LaunchInitialization.INSTANCE.init(MainActivityV2.this.getApplicationContext());
            LaunchNavigation.isFirst = false;
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean checkBrandSplash(boolean fromLauncher, boolean externalPullupSplash) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment userFragment = fragmentManager.findFragmentByTag(USER_SPLASH_TAG);
        if (userFragment != null) {
            fragmentManager.beginTransaction().remove(userFragment).commitAllowingStateLoss();
        }
        Fragment brandFragment = fragmentManager.findFragmentByTag(BRAND_SPLASH_TAG);
        if (brandFragment != null) {
            fragmentManager.beginTransaction().remove(brandFragment).commitAllowingStateLoss();
        }
        if (!fromLauncher && !externalPullupSplash) {
            return false;
        }
        EventSplashData eventSplash = null;
        if (!externalPullupSplash) {
            eventSplash = EventSplashManagerKt.findEventSplashWithPreload();
        }
        if (eventSplash != null) {
            StartShowRecorder.onBrandSplashStart();
            this.mBrandSplashFragment = new EventSplashFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key:event:splash:data", JSON.toJSONString(eventSplash));
            this.mBrandSplashFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(16908290, this.mBrandSplashFragment, USER_SPLASH_TAG).commitAllowingStateLoss();
            this.viewModel.update(new StatusBarEvent.EnterFullScreen("EventSplash"));
            BLog.i(TAG, "show event splash");
            return true;
        }
        Parcelable brandSplashForShow = BrandSplashHelper.INSTANCE.getBrandSplashForShow(this);
        if (brandSplashForShow != null) {
            StartShowRecorder.onBrandSplashStart();
            this.mBrandSplashFragment = new BrandSplashFragment();
            this.mBrandSplashFragment.setBitmapResource(brandSplashForShow.getLocalBitmap());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("arg_brand_info", brandSplashForShow);
            this.mBrandSplashFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().add(16908290, this.mBrandSplashFragment, BRAND_SPLASH_TAG).commitAllowingStateLoss();
            this.viewModel.update(new StatusBarEvent.EnterFullScreen("BrandSplash"));
            BrandSplashReporter.reportBrandSplashShow(brandSplashForShow);
            BLog.i(TAG, "show brand splash: " + brandSplashForShow.getId());
            return true;
        }
        BrandSplashReporter.reportNonBrandSplashShow();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initStubFragments() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(0, 0, 0, 0);
        if (!StartupFragmentV2.isAttached(fm)) {
            StartupFragmentV2.attach(transaction, new StartupFragmentV2());
        }
        if (!transaction.isEmpty()) {
            transaction.commitAllowingStateLoss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initMainFragment() {
        String fragmentTag = getFragmentTag(MainFragment.class);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(0, 0, 0, 0);
        this.mMainFragment = fm.findFragmentByTag(fragmentTag);
        if (this.mMainFragment == null) {
            this.mMainFragment = Fragment.instantiate(this, MainFragment.class.getName());
            transaction.replace(R.id.content_layout, this.mMainFragment, fragmentTag);
            transaction.commitAllowingStateLoss();
        }
    }

    private boolean initSplashFragment(Splash splash, boolean reportAdStock) {
        this.mSplash = null;
        this.mRequestedShowSplash = null;
        this.mRealtimeSplash = null;
        BLog.i(TAG, "show splash " + splash);
        this.mMainSplashHelper = new MainSplashHelper(this);
        this.mSplashFragment = this.mMainSplashHelper.getSplashFragment(splash, reportAdStock, !TextUtils.isEmpty(this.deepLinkSplashScheme));
        if (splash == null || this.mSplashFragment == null) {
            exitSplash(null, null, false);
            notifySplashExit();
            return false;
        }
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(AD_SPLASH_TAG);
        if (fragment != null) {
            fm.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
        FragmentTransaction transaction = fm.beginTransaction();
        this.mSplashLayout.setVisibility(0);
        transaction.add(R.id.splash_layout, this.mSplashFragment, AD_SPLASH_TAG);
        transaction.commitAllowingStateLoss();
        this.viewModel.update(new StatusBarEvent.EnterFullScreen("AdSplash"));
        return true;
    }

    private void initModDownloadFragment() {
        getSupportFragmentManager().beginTransaction().add(16908290, new SplashModDownloadFragment(), "SplashModDownloadFragment").commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void doOnResume() {
        GripperExecute.Companion.of().asyncSetupJon(new Function0<Unit>() { // from class: tv.danmaku.bili.MainActivityV2.4
            public Unit invoke() {
                ((GUpdater.Fetcher) EntryPoints.get(MainActivityV2.this.getApplicationContext(), GUpdater.Fetcher.class)).getObj().checkInstall(MainActivityV2.this);
                return null;
            }
        });
        if (GarbStorageHelper.INSTANCE.isGarbChanged(this)) {
            final Garb garb = GarbStorageHelper.INSTANCE.readGarbWrapper(this, true);
            if (MultipleThemeUtils.isNightFollowSystem(this) && MultipleThemeUtils.isNightModeForDevice(getApplication()) && garb.isPure() && !garb.isNight()) {
                MultipleThemeUtils.setNightFollowSystem(this, false);
                ToastHelper.showToastShort(this, bili.resource.settings.R.string.settings_global_string_217);
            }
            GarbStorageHelper.INSTANCE.clearOpGarb(this, false);
            Garb currentGarb = GarbManager.getCurGarb();
            if (currentGarb.isPure()) {
                GarbStorageHelper.INSTANCE.saveLastGarb(currentGarb);
                GarbManagerDelegate.INSTANCE.notifyGarbChange(garb, false, false, true);
                GarbStorageHelper.INSTANCE.saveGarbChanged(this, null);
            } else {
                GarbStorageHelper.INSTANCE.clearLastGarb(this, new GarbStorageHelper.IClearLastGarbListener() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda4
                    @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.IClearLastGarbListener
                    public final void onClear() {
                        MainActivityV2.this.m636lambda$doOnResume$4$tvdanmakubiliMainActivityV2(garb);
                    }
                });
            }
        }
        ViewGroup container = (ViewGroup) getWindow().getDecorView();
        ProjectionModuleKt.getProjectionService().showFloatView(container);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$doOnResume$4$tv-danmaku-bili-MainActivityV2  reason: not valid java name */
    public /* synthetic */ void m636lambda$doOnResume$4$tvdanmakubiliMainActivityV2(Garb garb) {
        GarbManagerDelegate.INSTANCE.notifyGarbChange(garb, false, false, true);
        GarbStorageHelper.INSTANCE.saveGarbChanged(this, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        super.onStop();
        if (!this.mIsBlock && UserProtocolHelper.hasDelayReport() && !GlobalNetworkController.isNetworkAllowed()) {
            UserProtocolHelper.syncReportDataToDisk(this);
        }
    }

    public void onSkinChange(Garb skin) {
        if (skin.isPure()) {
            return;
        }
        MainFragment fragment = getMainFragment();
        if (fragment == null || !fragment.isToolbarColorUpdated()) {
            tintSystemBar(skin.getSecondaryPageColor(), skin.isDarkMode() ? 1 : 2);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsChecker.onPermissionResult(requestCode, permissions, grantResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initThemeTips(Activity activity) {
        Intent intent = activity.getIntent();
        boolean isClearTask = BundleUtil.getBoolean(intent.getExtras(), "special_mode_clear_task", new boolean[]{false});
        boolean isFirstStart = EnvironmentManager.getInstance().isFirstStart();
        if (!isFirstStart || isClearTask || BiliTheme.getCurrentTheme(activity) == 8) {
            return;
        }
        BiliTheme.setCurrentTheme(activity, 8);
        ThemeWatcher.getInstance().onChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.mIsBlock || intent == null) {
            return;
        }
        String bottomTab = intent.getStringExtra(MainTransaction.ARGS_BOTTOM_ANCHOR_TAB);
        String secTab = intent.getStringExtra("tab_name");
        String bottomTabId = intent.getStringExtra(MainTransaction.ARGS_BOTTOM_ANCHOR_TAB_ID);
        String secTabId = intent.getStringExtra(MainTransaction.ARGS_ANCHOR_TAB_ID);
        if (!TextUtils.isEmpty(bottomTab) || !TextUtils.isEmpty(secTab) || !TextUtils.isEmpty(bottomTabId) || !TextUtils.isEmpty(secTabId)) {
            onNewIntentCompat(intent);
        }
        TeenagersModeManager.getInstance().onAppStartUp(this);
        if (intent.getData() != null) {
            String targetUrl = intent.getData().toString();
            UtilKt.deepLinkTrack("MainActivityV2 tryReport targetUrl is " + targetUrl);
            H5AwakenTrackingHelper.tryReport(targetUrl);
            H5AwakenTrackingHelper.tryReportV2(targetUrl, 0);
            H5AwakenTrackingHelper.tryReportV2(targetUrl, 1);
            H5AwakenTrackingHelper.tryReportV2(targetUrl, 2);
            DeepLinkButtonManager.INSTANCE.analyzingData(targetUrl, this);
        }
        String deepLink = intent.getStringExtra("deeplink_splash_scheme");
        if (!TextUtils.isEmpty(deepLink)) {
            intent.removeExtra("deeplink_splash_scheme");
            BLRouter.routeTo(new RouteRequest.Builder(Uri.parse(deepLink)).build(), this);
            if (SplashConfigKt.getSplashUseNewSplashExp()) {
                SplashCustomReporterKt.reportDeepLinkByNewIntent(deepLink);
            } else {
                tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportDeepLinkByNewIntent(deepLink);
            }
        }
    }

    private void onNewIntentCompat(Intent intent) {
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> fs = fm.getFragments();
        if (fs.isEmpty()) {
            return;
        }
        for (Fragment fragment : fs) {
            if (fragment instanceof INewIntentCompat) {
                ((INewIntentCompat) fragment).onNewIntent(intent);
            }
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> fs = fm.getFragments();
        if (fs.isEmpty()) {
            return;
        }
        for (Fragment fragment : fs) {
            if (fragment instanceof IWindowFocusChanged) {
                ((IWindowFocusChanged) fragment).onWindowFocusChanged(hasFocus);
            }
        }
    }

    @Override // tv.danmaku.bili.eventbus.EventBusHost
    public Bus getEventBus() {
        return this.mBus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onThemeInvalid() {
        BiliTheme.switchDefaultTheme(this);
    }

    public void onThemeFaked() {
        ToastHelper.showToastLong(getApplicationContext(), bili.resource.homepage.R.string.homepage_global_string_322);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onThemeExpired() {
        if (isDestroyCalled() || isFinishing() || EnvironmentManager.getInstance().isFirstStart()) {
            return;
        }
        BiliTheme.switchDefaultTheme(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.mIsBlock) {
            return;
        }
        if (this.mLoginChecker != null) {
            this.mLoginChecker.onActivityResult(requestCode, resultCode, data);
        }
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(StartupFragmentV2.TAG);
        if (fragment instanceof StartupFragmentV2) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
        int limitCode = 0;
        RelationService service = (RelationService) BLRouter.INSTANCE.getServices(RelationService.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
        if (service != null) {
            limitCode = service.getLimitRequestCode();
        }
        if (requestCode == limitCode) {
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return MainActivityV2.lambda$onActivityResult$5();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$onActivityResult$5() throws Exception {
        BiliAccountInfo.get().requestForMyAccountInfo();
        return null;
    }

    public MainFragment getMainFragment() {
        String fragmentTag = getFragmentTag(MainFragment.class);
        MainFragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        if (findFragmentByTag instanceof MainFragment) {
            return findFragmentByTag;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showSearchView() {
        SearchRoutes.enterSearch(this);
    }

    public LoginChecker getLoginChecker() {
        return this.mLoginChecker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (this.mIsBlock) {
            super.onBackPressed();
            return;
        }
        MainFragment mainFragment = getMainFragment();
        if (mainFragment != null && mainFragment.isHomeFloatViewShowing()) {
            mainFragment.dismissHomeFloatView();
        } else if ("1".equals(BundleUtil.getString(getIntent().getExtras(), IntentHandlerActivity.PARAMETER_DIRECT_BACK, new String[]{"0"})) || System.currentTimeMillis() - this.mLastBackTime < FdDebugActivity.UPDATE_DELAY_TIME || isSplashShowing()) {
            reportBackClick(this.mCurrentPvId, 3, this.mLastBackTime, 0);
            doExitMain();
        } else {
            this.mLastBackTime = System.currentTimeMillis();
            Pair<Integer, Integer> backType = backToRefresh();
            reportBackClick(this.mCurrentPvId, ((Integer) backType.first).intValue(), this.mLastBackTime, ((Integer) backType.second).intValue());
            String backToast = getMainBackToast(this);
            if (!backToast.isEmpty()) {
                ToastHelper.showToast(this, backToast, 0, 17);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void doExitMain() {
        char c;
        String mainExitType = DeviceDecision.INSTANCE.dd("dd_main_activity_exit_type", "kill");
        if (mainExitType == null) {
            mainExitType = "kill";
        }
        BLog.i(TAG, "doExitMain main exit type: " + mainExitType);
        switch (mainExitType.hashCode()) {
            case -1274442605:
                if (mainExitType.equals("finish")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3208415:
                if (mainExitType.equals("home")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3291998:
                if (mainExitType.equals("kill")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                super.onBackPressed();
                finish();
                return;
            case 1:
                moveTaskToBack(true);
                return;
            default:
                super.onBackPressed();
                try {
                    HandlerThreads.getHandler(0).postDelayed(new Runnable() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainActivityV2.this.m635lambda$doExitMain$6$tvdanmakubiliMainActivityV2();
                        }
                    }, 1000L);
                    finish();
                    return;
                } catch (Exception e) {
                    return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$doExitMain$6$tv-danmaku-bili-MainActivityV2  reason: not valid java name */
    public /* synthetic */ void m635lambda$doExitMain$6$tvdanmakubiliMainActivityV2() {
        if (!BiliContext.isForeground()) {
            ProcessUtils.killOtherProcess(this);
            ProcessUtils.suicide();
        }
    }

    private String getMainBackToast(Context context) {
        return BLRemoteConfig.getInstance().getString("android_back_toast", context.getString(bili.resource.common.R.string.common_global_string_402));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Pair<Integer, Integer> backToRefresh() {
        int clickType = 0;
        if (!BottomTabSelectedHelper.INSTANCE.currentIsMainPage() || !BottomTabSelectedHelper.isRecommendPage) {
            clickType = 1;
            RouteRequest request = new RouteRequest.Builder(MainRouteUris.URI_BILIBILI_HOME).extras(new Function1() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return MainActivityV2.lambda$backToRefresh$7((MutableBundleLike) obj);
                }
            }).build();
            BLRouter.routeTo(request, this);
        }
        if (BottomTabSelectedHelper.INSTANCE.currentIsMainPage() && BottomTabSelectedHelper.isRecommendPage) {
            clickType = 2;
        }
        return new Pair<>(Integer.valueOf(clickType), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$backToRefresh$7(MutableBundleLike mutableBundleLike) {
        mutableBundleLike.put(MainTransaction.ARGS_BOTTOM_ANCHOR_TAB, Uri.encode("首页"));
        mutableBundleLike.put("tab_name", Uri.encode("推荐"));
        return null;
    }

    private void reportBackClick(String id, int clickType, long sessionId, int isRefresh) {
        try {
            Map<String, String> params = new HashMap<>();
            if (!TextUtils.isEmpty(id)) {
                if (id.endsWith(MAIN_BACK_PV_END)) {
                    id = id.substring(0, id.length() - MAIN_BACK_PV_END.length());
                }
                params.put(FavoritesConstsKt.SPMID, id);
            }
            params.put("click_type", String.valueOf(clickType));
            params.put("click_session_id", String.valueOf(sessionId));
            params.put("is_refresh", String.valueOf(isRefresh));
            Neurons.reportClick(false, MAIN_BACK_CLICK, params);
            BLog.i(TAG, "report back params is" + params);
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.Hilt_MainActivityV2
    protected void onDestroy() {
        super.onDestroy();
        UserProtocolHelper.UserDialogDismissWatcher.unSubscribe(this);
        SystemPushDialogHelperKt.recordMainActivityDestroyDnBlock(this);
        if (this.mIsBlock) {
            return;
        }
        UserProtocolExperiment.reset();
        ThemeManager.getInstance(this).setThemeListener((ThemeManager.ThemeListener) null);
        ThemeWatcher.getInstance().unSubscribeMain(this.mThemeObserver);
        GarbWatcher.INSTANCE.unSubscribe(this);
        BottomBubbleHelper.dismissWindow(false);
        PageViewTracker.getInstance().unregisterReceiveCurrentEventIdListener(this);
        BiliAccounts.get(this).unsubscribe(this.passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void tintStatusBarPureForDrawer() {
        tintSystemBar(ThemeUtils.getThemeAttrColor(this, androidx.appcompat.R.attr.colorPrimary), 0);
    }

    public boolean isSplashShowing() {
        return (this.mSplashFragment != null && this.mSplashLayout.getVisibility() == 0) || (this.mBrandSplashFragment != null && this.mBrandSplashFragment.isVisible());
    }

    public boolean isSplashFinish() {
        return this.splashFinish;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.MainActivityV2$5  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass5 implements Function0<Unit> {
        final /* synthetic */ boolean val$jumped;

        AnonymousClass5(boolean z) {
            this.val$jumped = z;
        }

        public Unit invoke() {
            if (MainActivityV2.this.mSplashFragment != null && MainActivityV2.this.mMainFragment != null && MainActivityV2.this.mSplashLayout != null) {
                boolean quickHide = false;
                if (MainActivityV2.this.mSplashViewModel != null) {
                    quickHide = ((SplashState) MainActivityV2.this.mSplashViewModel.getState().getValue()).getTopViewSpecialDanmakuShow();
                }
                FragmentManager fm = MainActivityV2.this.getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                if (!this.val$jumped && MainActivityV2.this.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                    transaction.setCustomAnimations(0, quickHide ? 0 : com.bilibili.app.comm.baseres.R.anim.br_fade_out);
                }
                transaction.remove(MainActivityV2.this.mSplashFragment);
                if (MainActivityV2.this.mMainFragment.isHidden()) {
                    transaction.show(MainActivityV2.this.mMainFragment);
                }
                transaction.commitAllowingStateLoss();
                MainActivityV2.this.mSplashFragment = null;
                MainActivityV2.this.mSplashLayout.setClickable(false);
                MainActivityV2.this.mSplashLayout.setFocusable(false);
                BLog.i(MainActivityV2.TAG, "hideSplashFragment, quickHide = " + quickHide);
                HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.MainActivityV2$5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivityV2.AnonymousClass5.this.m644lambda$invoke$0$tvdanmakubiliMainActivityV2$5();
                    }
                }, quickHide ? 0L : 500L);
            }
            MainActivityV2.this.doAfterSplash();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$invoke$0$tv-danmaku-bili-MainActivityV2$5  reason: not valid java name */
        public /* synthetic */ void m644lambda$invoke$0$tvdanmakubiliMainActivityV2$5() {
            MainActivityV2.this.mSplashLayout.setVisibility(8);
        }
    }

    public void hideSplashFragment(boolean jumped) {
        GripperExecute.Companion.of().asyncSetupJon(new AnonymousClass5(jumped));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void tintSystemBar(int color, int mode) {
        StatusBarCompat.tintStatusBarForDrawer(this, color, mode);
    }

    public boolean isDestroyCalled() {
        return super.isDestroyCalled();
    }

    public static String getFragmentTag(Class c) {
        return "pager:main:" + c.getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifySplashExit() {
        if (this.mSplashViewModel != null) {
            BLog.i(TAG, "notify splash exit info");
            this.mSplashViewModel.getSplashExit().setValue(new SplashViewModel.SplashExitInfo());
            this.mSplashViewModel.update(new RealBannerRectUpdateAction((Rect) null));
        }
    }

    public void exitBrandSplash() {
        GripperExecute.Companion.of().asyncSetupJon(new Function0() { // from class: tv.danmaku.bili.MainActivityV2$$ExternalSyntheticLambda3
            public final Object invoke() {
                return MainActivityV2.this.m637lambda$exitBrandSplash$8$tvdanmakubiliMainActivityV2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$exitBrandSplash$8$tv-danmaku-bili-MainActivityV2  reason: not valid java name */
    public /* synthetic */ Unit m637lambda$exitBrandSplash$8$tvdanmakubiliMainActivityV2() {
        this.isBrandSplashCanExit = true;
        if (SplashConfigKt.getSplashUseNewSplashExp()) {
            exitBrandSplashV2();
            return null;
        }
        boolean hasShowEventSplash = this.mBrandSplashFragment instanceof EventSplashFragment;
        Splash splash = getBusinessSplash();
        boolean showADSplashSuccess = initSplashFragment(splash, !hasShowEventSplash);
        if (hasShowEventSplash || splash == null || !splash.needPrepare() || !showADSplashSuccess) {
            exitBrashSplashFragment(false, "not need splash");
        } else {
            tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.onStartPrepareADSplash();
            BLog.i(TAG, "not exit brand splash fragment, hasShowEventSplash " + hasShowEventSplash + ", splash " + splash);
        }
        return null;
    }

    public void exitBrandSplashV2() {
        GripperExecute.Companion.of().asyncSetupJon(new Function0<Unit>() { // from class: tv.danmaku.bili.MainActivityV2.6
            public Unit invoke() {
                boolean hasShowEventSplash = MainActivityV2.this.mBrandSplashFragment instanceof EventSplashFragment;
                SplashOrder splash = MainActivitySplashComponentExtKt.getBusinessSplashV2(MainActivityV2.this);
                boolean showADSplashSuccess = MainActivitySplashComponentExtKt.initSplashFragmentV2(MainActivityV2.this, splash, !hasShowEventSplash);
                if (hasShowEventSplash || splash == null || !ExtSplashOrderKt.getNeedPrepare(splash) || !showADSplashSuccess) {
                    MainActivityV2.this.exitBrashSplashFragment(false, "splash ready");
                    return null;
                }
                SplashCustomReporterKt.onStartPrepareADSplash();
                BLog.i(MainActivityV2.TAG, "not exit brand splash fragment splash.id = " + splash.getId());
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitBrashSplashFragment(boolean commitNow, String from) {
        if (this.mBrandSplashFragment != null) {
            BLog.i(TAG, "exitBrashSplashFragment, from = " + from);
            if (SplashConfigKt.getSplashUseNewSplashExp()) {
                SplashCustomReporterKt.onADSplashReady();
            } else {
                tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.onADSplashReady();
            }
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().remove(this.mBrandSplashFragment);
            if (commitNow) {
                ft.commitNowAllowingStateLoss();
            } else {
                ft.commitAllowingStateLoss();
            }
            this.mBrandSplashFragment = null;
            StartShowRecorder.onBrandSplashEnd();
        }
    }

    public void onADSplashReady() {
        exitBrashSplashFragment(true, "splash ready");
    }

    private void refreshRequestedShowSplash() {
        Splash listSplash;
        if ((SplashConfigKt.getTopViewReadShowEnable() || this.mSplash == null || !this.mSplash.isTopView()) && this.showSplash && !inRestrictedMode()) {
            this.mRequestedShowSplash = SplashHelper.getRequestedShowSplash();
            SplashSource source = TextUtils.isEmpty(this.deepLinkSplashScheme) ? SplashSource.COLD : SplashSource.CALL_UP;
            this.mRealtimeSplash = SplashHelper.getRealtimeSplash(source);
            modifyShowSplash();
            if (this.mRequestedShowSplash == null || this.mRealtimeSplash == null || (listSplash = this.mRequestedShowSplash.getSplash()) == null) {
                return;
            }
            if (listSplash.isTopView() || listSplash.originRealTimeShowIndex < this.mRealtimeSplash.originRealTimeShowIndex) {
                this.mRealtimeSplash.realTimeSplashBitmap = null;
                this.mRealtimeSplash = null;
            }
        }
    }

    private void modifyShowSplash() {
        Splash showSplash = this.mRequestedShowSplash == null ? null : this.mRequestedShowSplash.getSplash();
        if (showSplash == null) {
            return;
        }
        if ((this.mSplash != null && showSplash.id == this.mSplash.id) || SplashHelper.trustRealtimeShowTopView()) {
            long localShowId = 0;
            if (this.mSplash != null) {
                localShowId = this.mSplash.id;
            }
            BLog.i(TAG, "modifyShowSplash, showSplashId = " + showSplash.id + ", localSplashId = " + localShowId + ", trust = " + SplashHelper.trustRealtimeShowTopView());
        } else if (this.mSplash != null && this.mSplash.isTopView()) {
            Splash newSplash = SplashHelper.getShowSplashByTopView(this.mRequestedShowSplash, Long.valueOf(this.mSplash.id));
            this.mRequestedShowSplash = this.mRequestedShowSplash.copy((SplashData) null, newSplash, this.mRequestedShowSplash.getRealTimeShowStrategies(), this.mRequestedShowSplash.getRequestId());
        } else if (showSplash.isTopView()) {
            Splash newSplash2 = SplashHelper.getShowSplashByTopView(this.mRequestedShowSplash, -1L);
            this.mRequestedShowSplash = this.mRequestedShowSplash.copy((SplashData) null, newSplash2, this.mRequestedShowSplash.getRealTimeShowStrategies(), this.mRequestedShowSplash.getRequestId());
        }
    }

    private Splash getBusinessSplash() {
        boolean isFromCalledUp = !TextUtils.isEmpty(this.deepLinkSplashScheme);
        Splash splash = getADSplash();
        if (splash != null && splash.supportCalledUp && isFromCalledUp) {
            splash.isFromCalledUp = true;
        }
        BLog.i(TAG, "doMainInit, preload splash = " + (splash == null ? "null" : Long.valueOf(splash.id)));
        if (isFromCalledUp && (splash == null || !splash.supportCalledUp)) {
            splash = SplashHelper.getSplashForShow(SplashSource.CALL_UP);
            if (splash != null) {
                splash.fromRealShow = false;
            }
            BLog.i(TAG, "doMainInit, deeplink splash = " + (splash != null ? Long.valueOf(splash.id) : "null"));
        }
        return splash;
    }

    private Splash getADSplash() {
        refreshRequestedShowSplash();
        if (this.mRealtimeSplash != null) {
            BLog.i("[Splash]SplashHelper", "getShowSplash realtime splash :" + this.mRealtimeSplash.id);
            tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportShowType(this.mRealtimeSplash, SplashShowType.REAL_TIME_SPLASH);
            if (this.mRealtimeSplash != null) {
                this.mRealtimeSplash.fromRealShow = true;
            }
            return this.mRealtimeSplash;
        }
        boolean showRequestSuccess = this.mRequestedShowSplash != null && this.mRequestedShowSplash.getRequestShowSuccess();
        if (showRequestSuccess) {
            BLog.i("[Splash]SplashHelper", "getShowSplash show splash");
            Splash showSplash = this.mRequestedShowSplash.getSplash();
            if (showSplash == null) {
                tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportShowType((Splash) null, SplashShowType.NOT_SHOW);
            } else {
                tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportShowType(showSplash, SplashShowType.SHOW_DISPLAY);
            }
            if (showSplash != null) {
                showSplash.fromRealShow = true;
            }
            return showSplash;
        }
        if (this.mSplash == null) {
            tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportShowType((Splash) null, SplashShowType.NOT_SHOW);
        } else if (this.mSplash.isTopView()) {
            tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportShowType(this.mSplash, SplashShowType.TOP_VIEW);
        } else {
            tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt.reportShowType(this.mSplash, SplashShowType.LOCAL_SHOW_DISPLAY);
        }
        BLog.i("[Splash]SplashHelper", "getShowSplash local splash");
        if (this.mSplash != null) {
            this.mSplash.fromRealShow = false;
        }
        return this.mSplash;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean inRestrictedMode() {
        return TeenagersMode.getInstance().isEnable() || RestrictedMode.isEnable(RestrictedType.LESSONS, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
    }

    public long getTimeSincePageCreateMs() {
        return SystemClock.elapsedRealtime() - this.pageCreateTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.MainActivityV2$7  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass7 implements Function0<Unit> {
        AnonymousClass7() {
        }

        public Unit invoke() {
            MainActivityV2.this.viewModel.update(new StatusBarEvent.ExitFullScreen("doAfterSplash"));
            MainActivityV2.this.initStubFragments();
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.MainActivityV2$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivityV2.AnonymousClass7.this.m647lambda$invoke$0$tvdanmakubiliMainActivityV2$7();
                }
            });
            if (MainActivityV2.this.mFromLauncher) {
                MainActivityV2.this.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.MainActivityV2.7.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        BLog.i(MainActivityV2.TAG, "start check clipboard from launcher");
                        ClipboardChecker.check(new ClipboardChecker.Environment(MainActivityV2.this.getApplicationContext(), MainActivityV2.this.mFirstBoot, true));
                        ClipboardChecker.observer(true);
                        MainActivityV2.this.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
            MainActivityV2.this.splashFinish = true;
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$invoke$0$tv-danmaku-bili-MainActivityV2$7  reason: not valid java name */
        public /* synthetic */ void m647lambda$invoke$0$tvdanmakubiliMainActivityV2$7() {
            Window window = MainActivityV2.this.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterSplash() {
        GripperExecute.Companion.of().asyncSetupJon(new AnonymousClass7());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void exitSplash(Object splashData, String jumpUrl, boolean jumped) {
        if (this.isBrandSplashCanExit) {
            exitBrashSplashFragment(false, "exit splash");
        }
        if (SplashConfigKt.getSplashUseNewSplashExp()) {
            MainActivitySplashComponentExtKt.exitSplashV2(this, splashData, jumpUrl, jumped);
            return;
        }
        if (!jumped && !TextUtils.isEmpty(this.deepLinkSplashScheme)) {
            BLRouter.routeTo(new RouteRequest.Builder(Uri.parse(this.deepLinkSplashScheme)).build(), this);
        }
        this.deepLinkSplashScheme = null;
        if (this.mMainSplashHelper != null) {
            if (!(splashData instanceof Splash)) {
                this.mMainSplashHelper.exitSplash((Splash) null, jumpUrl, jumped);
            } else {
                this.mMainSplashHelper.exitSplash((Splash) splashData, jumpUrl, jumped);
            }
        }
    }

    public void closeSplash() {
        if (SplashConfigKt.getSplashUseNewSplashExp()) {
            MainActivitySplashComponentExtKt.closeSplashV2(this);
        } else if (this.mMainSplashHelper != null) {
            this.mMainSplashHelper.closeSplash();
        }
    }

    public void onGetCurrentId(String currentEventId) {
        this.mCurrentPvId = currentEventId;
        BLog.i(TAG, "current pv id is " + this.mCurrentPvId);
    }

    @Override // tv.danmaku.bili.ui.main2.userprotocol.UserProtocolDismissObserver
    public void onUserProtocolDismiss(String from) {
        BLog.i(TAG, "user protocol dismiss from: " + from);
        if (TextUtils.equals(from, UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT)) {
            finish();
        }
    }

    public void onModLoadSuccess() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("SplashModDownloadFragment");
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
        doOnCreate(false, null);
    }

    public String getMiniPlayerContainerKey() {
        return "main_page";
    }

    public Rect getContainerUnavailableRect() {
        int left = DpUtils.INSTANCE.dp2Px(7);
        int right = DpUtils.INSTANCE.dp2Px(7);
        int bottom = DpUtils.INSTANCE.dp2Px(52);
        return new Rect(left, 0, right, bottom);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Configuration oldConfig = this.mConfiguration;
        this.mConfiguration = newConfig;
        if (oldConfig == null) {
            return;
        }
        int oldScreenLayout = oldConfig.screenLayout;
        int newScreenLayout = newConfig.screenLayout;
        if (DeviceDecision.INSTANCE.getBoolean("main_actvity_screen_layout_compat", true)) {
            int oldSize = oldScreenLayout & (-268435457);
            int newSize = (-268435457) & newScreenLayout;
            if (oldSize != newSize) {
                getWindow().getDecorView().requestLayout();
            }
        } else if (oldScreenLayout != newScreenLayout) {
            recreate();
        }
    }

    public void recreate() {
        super.recreate();
    }

    public void finish() {
        super.finish();
        if (BuildConfig.DEBUG) {
            BLog.i(TAG, "main activity finished", new Throwable());
        }
    }
}