package tv.danmaku.bili.ui.main2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import bili.resource.downloads.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.api.base.Config;
import com.bilibili.app.comm.emoticon.core.EmoticonManager;
import com.bilibili.app.comm.list.common.feed.ActivityStateChangeProxy;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.app.preferences.Settings;
import com.bilibili.base.connectivity.Connectivity;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.droid.AppsFlyerWrapper;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.updater.GUpdater;
import com.bilibili.gripper.api.updater.UpdaterActionType;
import com.bilibili.homepage.ActivityStateService;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.cookie.WebkitCookieHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.media.dolby.DolbyVisionConfigManager;
import com.bilibili.lib.ui.BaseNonUIFragment;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.moduleservice.search.SearchModuleService;
import com.bilibili.networkstats.NetworkFlowStatsManager;
import com.bilibili.offline.OfflineABServiceKt;
import com.bilibili.playerbizcommon.utils.PlayUrlFlagsManager;
import com.bilibili.teenagersmode.TeenagersMode;
import com.bilibili.teenagersmode.TeenagersModeManager;
import com.bilibili.videodownloader.client.VideoDownloadClient;
import dagger.hilt.EntryPoints;
import java.util.concurrent.Callable;
import tv.danmaku.android.ConnectivityManagerHelper;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.ShortcutHelper;
import tv.danmaku.bili.proc.ActivityCallBack;
import tv.danmaku.bili.push.BPushHelper;
import tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt;
import tv.danmaku.bili.report.HuaweiMarketReferrerReporter;
import tv.danmaku.bili.report.InfoEyesReporter;
import tv.danmaku.bili.services.videodownload.action.AutoStartAllTaskIfNeedAction;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;
import tv.danmaku.bili.ui.login.LoginInitializer;
import tv.danmaku.bili.ui.main.MineGuideHelper;
import tv.danmaku.bili.ui.main.deeplink.DelayDeepLinkHelper;
import tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper;
import tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper;
import tv.danmaku.bili.ui.main.usergrow.UserGrowManager;
import tv.danmaku.bili.ui.main2.StartupFragmentV2;
import tv.danmaku.bili.ui.main2.main.ActivityStateServiceImpl;
import tv.danmaku.bili.ui.main2.mine.MinePrefHelper;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;
import tv.danmaku.bili.ui.splash.LaunchNavigation;
import tv.danmaku.bili.ui.splash.brand.BrandSplashHelper;
import tv.danmaku.bili.ui.splash.event.EventSplashStorage;
import tv.danmaku.bili.ui.splash.utils.StaggerConfigKt;
import tv.danmaku.bili.update.api.updater.IUpdater;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.utils.DelayInitHelper;
import tv.danmaku.bili.utils.list.InstalledListUploadUtil;
import tv.danmaku.bili.utils.passport.PassportHelper;
import tv.danmaku.bili.utils.vip.VipAlertHelper;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;

public class StartupFragmentV2 extends BaseNonUIFragment implements BottomTabSelectedHelper.OnTabChangeListener {
    public static final long FORCE_UPDATE_CHECK_INTERVAL = 60000;
    private static final String LAST_RUN_TIME = "savedTime";
    public static final String TAG = "[Home]StartupFragmentV2";
    private ActivityCallBack.ActivityStateCallback mActivityCallback;
    private boolean mClickPositiveButton;
    private final Handler mHandler = HandlerThreads.getHandler(0);
    private long mLastForceCheckUpdateTime = 0;
    private boolean mForceUpdateDialogShowing = false;
    private boolean mIsFromLoginChecker = false;
    private final boolean mIsFirstStart = EnvironmentManager.getInstance().isFirstStart();
    private boolean mFirstCheckDialog = true;
    private ConnectivityMonitor.OnNetworkChangedListener mNetworkChangedListener = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof MainActivityV2)) {
            if (Config.isDebuggable()) {
                throw new AssertionError("StartupFragmentV2 is not attached to MainActivityV2");
            }
            return;
        }
        MainDialogManager.isMainVisible = true;
        this.mActivityCallback = new ActivityCallBack.ActivityStateCallback() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2.1
            @Override // tv.danmaku.bili.proc.ActivityCallBack.ActivityStateCallback
            public void onVisibleCountChanged(Activity activity2, int lastVisibleCount, int currentVisibleCount) {
                ActivityStateChangeProxy.onVisibleCountChanged(activity2, lastVisibleCount, currentVisibleCount);
            }

            @Override // tv.danmaku.bili.proc.ActivityCallBack.ActivityStateCallback
            public void onForegroundActivitiesChanged(Activity activity2, int lastForegroundCount, int currentForegroundCount) {
                ActivityStateChangeProxy.onForegroundActivitiesChanged(activity2, lastForegroundCount, currentForegroundCount);
            }
        };
        ActivityCallBack.addActivityStateCallback(this.mActivityCallback);
        ActivityStateService service = (ActivityStateService) BLRouter.INSTANCE.get(ActivityStateService.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
        if (service instanceof ActivityStateServiceImpl) {
            ActivityCallBack.addActivityStateCallback(((ActivityStateServiceImpl) service).getActivityStateCallback());
        }
        if (savedInstanceState == null) {
            MineGuideHelper mineGuideHelper = new MineGuideHelper(activity);
            if (mineGuideHelper.shouldShowGuide()) {
                mineGuideHelper.showGuide();
            }
            dealWithTeenagersOnStartUp(activity);
            HomeLoginExpKt.onAppStart(activity);
            OpBizDialogHelper.addBizBlockDialog(activity);
            VipAlertHelper.vipAccountFrozen();
            PassportHelper.verify(getApplicationContext());
            refreshAccountInfo();
            MainResourceManager.getInstance().addIPCActivityCallback();
            MainDialogManager.markMainVisibleAndShowDialog();
        }
        if (savedInstanceState == null || SystemClock.elapsedRealtime() - BundleUtil.getLong(savedInstanceState, LAST_RUN_TIME, new long[]{0}) >= 1800000) {
            HandlerThreads.post(1, new Runnable() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2.2
                @Override // java.lang.Runnable
                public void run() {
                    InfoEyesReporter.reportAppMain(StartupFragmentV2.this.getApplicationContext(), true, String.valueOf(EnvironmentManager.getInstance().getLastRunTimeDelta()));
                    InfoEyesReporter.reportDeviceFingerPrint(StartupFragmentV2.this.getApplicationContext());
                    EnvironmentManager.getInstance().setLastRunTime();
                    HuaweiMarketReferrerReporter.report();
                    AppsFlyerWrapper.start(StartupFragmentV2.this.getApplicationContext());
                }
            });
            if (!EnvironmentManager.getInstance().isFirstStart()) {
                PushGuidanceManagerKt.showGuidanceFromHomePage(activity);
            }
            if (savedInstanceState == null) {
                checkMainDialog(activity);
            }
            BottomTabSelectedHelper.registerOnTabChangeListener(this);
            if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
                this.mNetworkChangedListener = newNetworkChangeListener();
                ConnectivityMonitor.getInstance().register(this.mNetworkChangedListener);
                return;
            }
            warnIfNetworkMetered(activity);
            EnvironmentManager.getInstance().getFirstInstallVersion();
            if (this.mIsFirstStart) {
                MinePrefHelper.INSTANCE.setIsNewInstall(activity, true);
            } else {
                GUpdater gUpdater = ((GUpdater.Fetcher) EntryPoints.get(getApplicationContext(), GUpdater.Fetcher.class)).getObj();
                int lastVersion = gUpdater.getConfig().getLastRunVersion(activity);
                if (gUpdater.getConfig().getCurrentVersion(activity) > lastVersion) {
                    BLog.d(TAG, "is update install");
                    MinePrefHelper.INSTANCE.setIsNewInstall(activity, false);
                }
            }
            reportLastTrack();
            this.mHandler.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2.3
                @Override // java.lang.Runnable
                public void run() {
                    AppCompatActivity activity2 = StartupFragmentV2.this.getActivity();
                    if (activity2 == null) {
                        return;
                    }
                    StartupFragmentV2.this.addAppShortcutFor25();
                    Settings.Download.adjustDownloadPath(activity2);
                    if (!OfflineABServiceKt.hitsKOffline()) {
                        VideoDownloadClient.startService(activity2);
                        AutoStartAllTaskIfNeedAction.start(activity2.getApplicationContext());
                        OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().resetMigrate();
                    }
                    if (BiliAccounts.get(activity2).isLogin()) {
                        EmoticonManager.Companion.getInstance(activity2).prefetch();
                    }
                    EmoticonManager.Companion.getInstance(activity2).subscribeLogin();
                    DolbyVisionConfigManager.INSTANCE.setConfigDownloadObserver(new DolbyVisionConfigManager.ConfigDownloadObserver() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$3$$ExternalSyntheticLambda0
                        public final void onSuccess() {
                            PlayUrlFlagsManager.resetFnVal();
                        }
                    });
                    DolbyVisionConfigManager.INSTANCE.requestConfig();
                    Intent intent = activity2.getIntent();
                    if (intent == null) {
                        intent = new Intent();
                    }
                    boolean isClearTask = BundleUtil.getBoolean(intent.getExtras(), "special_mode_clear_task", new boolean[]{false});
                    if (!isClearTask) {
                        GarbManager.fetchGarb(activity2);
                    }
                    InstalledListUploadUtil.uploadAppsList();
                    BrandSplashHelper.update();
                    if (activity2 instanceof AppCompatActivity) {
                        EventSplashStorage.INSTANCE.loadEventSplashData(activity2);
                    }
                }
            }, 1500L);
            startLowPriorityTask();
        }
    }

    public void onStart() {
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        MainDialogManager.isMainVisible = true;
        if (UserGrowManager.checkHomePage()) {
            UserGrowManager.checkActivityWindow();
        }
        if (!this.mFirstCheckDialog && MainDialogManager.checkResume()) {
            MainDialogManager.resume(activity);
        }
        this.mFirstCheckDialog = false;
    }

    private void checkMainDialog(final Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null || !(activity instanceof MainActivityV2)) {
            return;
        }
        SplashViewModel viewModel = new ViewModelProvider((MainActivityV2) activity).get(SplashViewModel.class);
        final boolean fromSplash = viewModel.getActivityFromSplash().getValue() != null && ((Boolean) viewModel.getActivityFromSplash().getValue()).booleanValue();
        final boolean isClearTask = BundleUtil.getBoolean(intent.getExtras(), "special_mode_clear_task", new boolean[]{false});
        activity.getWindow().getDecorView().post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                StartupFragmentV2.this.m1941lambda$checkMainDialog$0$tvdanmakubiliuimain2StartupFragmentV2(fromSplash, isClearTask, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkMainDialog$0$tv-danmaku-bili-ui-main2-StartupFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1941lambda$checkMainDialog$0$tvdanmakubiliuimain2StartupFragmentV2(boolean fromSplash, boolean isClearTask, Activity activity) {
        if (!fromSplash || isClearTask) {
            OpBizDialogHelper.removeBizBlockDialog(activity);
            return;
        }
        ImageRecognizeHelper.onStartup(activity);
        if (this.mIsFirstStart) {
            DelayDeepLinkHelper.fetch(activity.getApplicationContext());
        }
        OpBizDialogHelper.fetchOpDialogInfo(activity);
    }

    private void dealWithTeenagersOnStartUp(Activity activity) {
        BLog.i(TAG, "dealWithTeenagersOnStartUp");
        if (activity instanceof MainActivityV2) {
            SplashViewModel viewModel = new ViewModelProvider((MainActivityV2) activity).get(SplashViewModel.class);
            SplashViewModel.SplashExitInfo exitInfo = (SplashViewModel.SplashExitInfo) viewModel.getSplashExit().getValue();
            if (exitInfo != null && exitInfo.exitWithAnim) {
                return;
            }
        }
        Intent intent = activity.getIntent();
        boolean isClearTask = BundleUtil.getBoolean(intent.getExtras(), "special_mode_clear_task", new boolean[]{false});
        if (!isClearTask) {
            TeenagersMode.getInstance().showDialogIfNeed(activity);
            if (TeenagersModeManager.getInstance().isDialogShowing()) {
                GarbManagerDelegate.setOtherDialogShowing(true);
            }
        }
        TeenagersModeManager.getInstance().onAppStartUp(activity);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onResume() {
        if (!LaunchNavigation.INSTANCE.getHasCheckStorage()) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda3
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    return StartupFragmentV2.this.m1946lambda$onResume$1$tvdanmakubiliuimain2StartupFragmentV2();
                }
            });
            LaunchNavigation.INSTANCE.setHasCheckStorage(true);
        }
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        MainDialogManager.isMainVisible = true;
        HomeLoginExpKt.checkShowOnePassLoginGuide(this, true);
        if (!this.mIsFromLoginChecker) {
            UserGrowManager.checkLazyShow(activity);
        }
        this.mIsFromLoginChecker = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onResume$1$tv-danmaku-bili-ui-main2-StartupFragmentV2  reason: not valid java name */
    public /* synthetic */ boolean m1946lambda$onResume$1$tvdanmakubiliuimain2StartupFragmentV2() {
        checkStorageState();
        return false;
    }

    public void onPause() {
        super.onPause();
        MainDialogManager.isMainVisible = false;
    }

    public void onStop() {
        super.onStop();
        OpBizDialogHelper.isFirst = false;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 31415) {
            this.mIsFromLoginChecker = true;
        }
    }

    private void refreshAccountInfo() {
        Context context = getApplicationContext();
        if (context == null) {
            return;
        }
        BiliAccounts account = BiliAccounts.get(context);
        if (account.isLogin()) {
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda7
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return StartupFragmentV2.lambda$refreshAccountInfo$2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$refreshAccountInfo$2() throws Exception {
        BiliAccountInfo.get().requestForMyAccountInfo();
        return null;
    }

    private void reportLastTrack() {
        this.mHandler.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2.4
            @Override // java.lang.Runnable
            public void run() {
                FragmentActivity activity;
                if (StartupFragmentV2.this.activityDie() || (activity = StartupFragmentV2.this.getActivity()) == null || StartupFragmentV2.this.mIsFirstStart) {
                    return;
                }
                ((GUpdater.Fetcher) EntryPoints.get(StartupFragmentV2.this.getApplicationContext(), GUpdater.Fetcher.class)).getObj().reportUpdateStatues(activity);
                ((GUpdater.Fetcher) EntryPoints.get(StartupFragmentV2.this.getApplicationContext(), GUpdater.Fetcher.class)).getObj().checkUpdate(activity, UpdaterActionType.START_UP, (IUpdater) null);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.main2.StartupFragmentV2$5  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            final FragmentActivity activity = StartupFragmentV2.this.getActivity();
            if (activity == null) {
                return;
            }
            try {
                Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$5$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return StartupFragmentV2.AnonymousClass5.lambda$run$1(activity);
                    }
                });
            } catch (Throwable e) {
                BLog.w(StartupFragmentV2.TAG, e);
            }
            LoginInitializer.getInstance().init(StartupFragmentV2.this.getApplicationContext());
            GAdCoreKt.getGAdReport().retryOnStartUp();
            WebkitCookieHelper.setBuvidCookieAsync(activity);
            WebkitCookieHelper.setWebkitAccountCookies(activity);
            BLog.d(StartupFragmentV2.TAG, "setSSOCookie");
            NetworkFlowStatsManager.INSTANCE.reportNetworkFlow();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Void lambda$run$1(Activity activity) throws Exception {
            boolean disablePush = Settings.General.isPushDisabled(activity);
            if (!disablePush) {
                if (DelayInitHelper.needDelayInit()) {
                    DelayInitHelper.registerDelayInitTask(new DelayInitHelper.DelayInitTask() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$5$$ExternalSyntheticLambda1
                        public final void onExecute() {
                            BPushHelper.startPushService();
                        }
                    });
                    return null;
                }
                BPushHelper.startPushService();
                return null;
            }
            return null;
        }
    }

    private void startLowPriorityTask() {
        this.mHandler.postDelayed(new AnonymousClass5(), 3000L);
        HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StartupFragmentV2.lambda$startLowPriorityTask$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$startLowPriorityTask$3() {
        StaggerConfigKt.registerSplashStaggerConfig();
        SearchModuleService service = (SearchModuleService) BLRouter.INSTANCE.get(SearchModuleService.class, "search");
        if (service != null) {
            service.registerStaggerConfig();
            service.updateStaticResConfig();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAppShortcutFor25() {
        if (Build.VERSION.SDK_INT >= 25) {
            ShortcutHelper.publishAllDynamic(getApplicationContext());
        }
    }

    private ConnectivityMonitor.OnNetworkChangedListener newNetworkChangeListener() {
        return new ConnectivityMonitor.OnNetworkChangedListener() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda8
            public final void onChanged(int i) {
                StartupFragmentV2.this.m1945lambda$newNetworkChangeListener$4$tvdanmakubiliuimain2StartupFragmentV2(i);
            }

            public /* synthetic */ void onChanged(int i, int i2, NetworkInfo networkInfo) {
                ConnectivityMonitor.OnNetworkChangedListener.-CC.$default$onChanged(this, i, i2, networkInfo);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$newNetworkChangeListener$4$tv-danmaku-bili-ui-main2-StartupFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1945lambda$newNetworkChangeListener$4$tvdanmakubiliuimain2StartupFragmentV2(int net) {
        switch (net) {
            case 1:
            case 2:
            case 5:
                if (this.mForceUpdateDialogShowing || System.currentTimeMillis() - this.mLastForceCheckUpdateTime < FORCE_UPDATE_CHECK_INTERVAL) {
                    return;
                }
                this.mLastForceCheckUpdateTime = System.currentTimeMillis();
                ((GUpdater.Fetcher) EntryPoints.get(getApplicationContext(), GUpdater.Fetcher.class)).getObj().checkUpdate(getActivity(), UpdaterActionType.FORCE, new IUpdater() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2.6
                    public void onUpdate(BiliUpgradeInfo info, boolean isManual) {
                    }

                    public void onError(String message) {
                        StartupFragmentV2.this.mForceUpdateDialogShowing = true;
                    }
                });
                return;
            case 3:
            case 4:
            default:
                return;
        }
    }

    public void onDestroy() {
        if (this.mNetworkChangedListener != null) {
            ConnectivityMonitor.getInstance().unregister(this.mNetworkChangedListener);
        }
        DolbyVisionConfigManager.INSTANCE.setConfigDownloadObserver((DolbyVisionConfigManager.ConfigDownloadObserver) null);
        super.onDestroy();
        BottomTabSelectedHelper.unregisterOnTabChangeListener(this);
        OpBizDialogHelper.release();
        if (this.mActivityCallback != null) {
            ActivityCallBack.removeActivityStateCallback(this.mActivityCallback);
            this.mActivityCallback = null;
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(LAST_RUN_TIME, SystemClock.elapsedRealtime());
    }

    private void warnIfNetworkMetered(Context context) {
        NetworkInfo info;
        int networkClass;
        if (!OnlineParamsHelper.enableHomepageNetworkToast() || FreeDataManager.getInstance().isTf() || (info = Connectivity.getActiveNetworkInfo(context)) == null || !ConnectivityManagerHelper.isActiveNetworkMetered(context) || (networkClass = ConnectivityManagerHelper.getNetworkClass(info.getSubtype())) == 0) {
            return;
        }
        ToastHelper.showToastShort(context, context.getString(R.string.downloads_global_string_122, ConnectivityManagerHelper.networkClassNames[networkClass]));
    }

    public static boolean isAttached(FragmentManager fm) {
        return fm.findFragmentByTag(TAG) != null;
    }

    public static void attach(FragmentTransaction transaction, StartupFragmentV2 fragment) {
        transaction.add(fragment, TAG);
    }

    private void checkStorageState() {
        if (activityDie()) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return StartupFragmentV2.this.m1942lambda$checkStorageState$5$tvdanmakubiliuimain2StartupFragmentV2();
            }
        }).onSuccess(new Continuation() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda5
            public final Object then(Task task) {
                return StartupFragmentV2.this.m1943lambda$checkStorageState$6$tvdanmakubiliuimain2StartupFragmentV2(task);
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda6
            public final Object then(Task task) {
                return StartupFragmentV2.this.m1944lambda$checkStorageState$7$tvdanmakubiliuimain2StartupFragmentV2(task);
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkStorageState$5$tv-danmaku-bili-ui-main2-StartupFragmentV2  reason: not valid java name */
    public /* synthetic */ Integer m1942lambda$checkStorageState$5$tvdanmakubiliuimain2StartupFragmentV2() throws Exception {
        return Integer.valueOf(LaunchNavigation.INSTANCE.getStorageState(getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkStorageState$6$tv-danmaku-bili-ui-main2-StartupFragmentV2  reason: not valid java name */
    public /* synthetic */ Integer m1943lambda$checkStorageState$6$tvdanmakubiliuimain2StartupFragmentV2(Task task) throws Exception {
        if (((Integer) task.getResult()).intValue() == 3) {
            LaunchNavigation.INSTANCE.clearApiAndImageCache(getApplicationContext());
        }
        return (Integer) task.getResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkStorageState$7$tv-danmaku-bili-ui-main2-StartupFragmentV2  reason: not valid java name */
    public /* synthetic */ Void m1944lambda$checkStorageState$7$tvdanmakubiliuimain2StartupFragmentV2(Task task) throws Exception {
        switch (((Integer) task.getResult()).intValue()) {
            case 2:
                showDialog(getActivity(), "0");
                return null;
            case 3:
                showDialog(getActivity(), "1");
                return null;
            default:
                return null;
        }
    }

    private void showDialog(final Activity activity, String autoClean) {
        if (activityDie() || this.mIsFirstStart) {
            return;
        }
        final Intent intent = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        if (LaunchNavigation.INSTANCE.needDialogPrompt(activity) && intent.resolveActivity(activity.getPackageManager()) != null) {
            final AlertDialog dialog = new AlertDialog.Builder(activity, com.bilibili.app.preferences.R.style.AppTheme_Dialog_Alert).setTitle(bili.resource.homepage.R.string.homepage_global_string_216).setMessage(bili.resource.homepage.R.string.homepage_global_string_346).setPositiveButton(bili.resource.homepage.R.string.homepage_global_string_233, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    StartupFragmentV2.this.m1947lambda$showDialog$8$tvdanmakubiliuimain2StartupFragmentV2(intent, dialogInterface, i);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                }
            }).create();
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialog2) {
                    MainDialogManager.showNextDialog("storage", StartupFragmentV2.this.mClickPositiveButton, activity);
                }
            });
            MainDialogManager.DialogManagerInfo storage = new MainDialogManager.DialogManagerInfo("storage", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main2.StartupFragmentV2.8
                public void onShow() {
                    dialog.show();
                }
            }, 2010);
            MainDialogManager.addDialog(storage, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showDialog$8$tv-danmaku-bili-ui-main2-StartupFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1947lambda$showDialog$8$tvdanmakubiliuimain2StartupFragmentV2(Intent intent, DialogInterface dialogInterface, int i) {
        startActivity(intent);
        this.mClickPositiveButton = true;
        dialogInterface.dismiss();
    }

    public void onChange(String pageUrl) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (UserGrowManager.checkPage(pageUrl)) {
            UserGrowManager.checkLazyShow(activity);
        }
        if (UserGrowManager.checkHomePage()) {
            UserGrowManager.checkActivityWindow();
            if (MainDialogManager.checkResume()) {
                MainDialogManager.resume(activity);
            }
        }
        OpBizDialogHelper.isFirst = false;
        this.mFirstCheckDialog = false;
    }
}