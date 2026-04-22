package tv.danmaku.bili.router;

import android.content.Context;
import android.content.SharedPreferences;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.app.preferences.PermissionReportHelper;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.Bootstrap;
import com.bilibili.base.ipc.IPCAppStateManager;
import com.bilibili.bililive.playercore.media.ijk.IjkMediaPlayerTrackerHelp;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.biliid.utils.device.HwIdHelper;
import com.bilibili.lib.biliid.utils.device.PhoneIdHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.drmid.DrmIdHelper;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.oaid.MsaHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.category.CategoryManagerV2;
import tv.danmaku.bili.mod.ModManagerHelper;
import tv.danmaku.bili.push.BPushHelper;
import tv.danmaku.bili.report.ApplicationTracer;
import tv.danmaku.bili.report.DelayReportForOaid;
import tv.danmaku.bili.report.InfoEyesReporter;
import tv.danmaku.bili.report.biz.api.consume.OkHttpReporter;
import tv.danmaku.bili.report.platform.neuron.AppSysReport;
import tv.danmaku.bili.report.platform.neuron.NeuronEventId;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;
import tv.danmaku.bili.ui.pandora.PandoraProcessor;
import tv.danmaku.bili.utils.StorageStatisticsHelper;
import tv.danmaku.videoplayer.core.media.ijk.IjkOptionsHelper;

public class MainBootstrap extends Bootstrap.Launch {
    private static final String PRE_KEY_IS_FIRST_OPEN = "pre_key_is_first_open";

    public void bootInProcess(Context context, String processName) {
        boolean isMainProcess = processName == null || processName.indexOf(58) == -1;
        if (isMainProcess) {
            registerIPCCallback();
            ModManagerHelper.registerIPCCallback(context);
            PandoraProcessor.init(context);
            PermissionReportHelper.Companion.reportUserPermission(context);
        }
    }

    public void launchWithUI(Context context, String processName) {
        boolean isMainProcess = processName == null || processName.indexOf(58) == -1;
        if (isMainProcess) {
            EnvironmentManager.getInstance().getFirstRunTime();
            initCategoryAsync(context);
            reportPlayerTimeRecordLog(context);
            InfoEyesReporter.scheduleReportAppCoexist(context);
        }
    }

    private void initCategoryAsync(Context context) {
        CategoryManagerV2.init(context.getApplicationContext());
    }

    public void launchWithWorker(Context context, String processName) {
        boolean isMainProcess = processName == null || processName.indexOf(58) == -1;
        if (!isMainProcess) {
        }
    }

    private void reportPlayerTimeRecordLog(final Context context) {
        Task.delay(500L).continueWith(new Continuation() { // from class: tv.danmaku.bili.router.MainBootstrap$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                return MainBootstrap.lambda$reportPlayerTimeRecordLog$0(context, task);
            }
        }, Task.BACKGROUND_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$reportPlayerTimeRecordLog$0(Context context, Task task) throws Exception {
        try {
            IjkOptionsHelper.initHevcEnableState(context);
            IjkMediaPlayerTrackerHelp.getInstance().setHttpReporter(new OkHttpReporter());
            tv.danmaku.videoplayer.core.media.ijk.IjkMediaPlayerTrackerHelp.getInstance().setHttpReporter(new OkHttpReporter());
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static void registerIPCCallback() {
        IPCAppStateManager.getInstance().addIPCActivityStateCallback(new IPCAppStateManager.GlobalVisibilityChangeCallback() { // from class: tv.danmaku.bili.router.MainBootstrap.1
            public void onBackground() {
                StorageStatisticsHelper.reportStorageStatisticsInfo();
                BLog.i("StorageStatisticsHelper", "report storage statistics info");
                MainDialogManager.resetShowTime();
            }

            public void onForeground() {
                if (ServerClock.now() == -1) {
                    ServerClock.fetchCurrentTimeMillis();
                }
            }
        });
        IPCAppStateManager.getInstance().addIPCActivityStateCallback(new MainBootstrapIPCActivityStateCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class MainBootstrapIPCActivityStateCallback implements IPCAppStateManager.IPCActivityStateCallback {
        private boolean mIsBackground;

        private MainBootstrapIPCActivityStateCallback() {
            this.mIsBackground = true;
        }

        public void onVisibleCountChanged(int lastVisibleCount, int currentVisibleCount) {
            if (currentVisibleCount == 0) {
                this.mIsBackground = true;
                return;
            }
            if (lastVisibleCount == 0 && currentVisibleCount > 0 && this.mIsBackground) {
                HandlerThreads.post(3, new Runnable() { // from class: tv.danmaku.bili.router.MainBootstrap.MainBootstrapIPCActivityStateCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MainBootstrap.reportForeground(BiliContext.application());
                        MainBootstrap.reportIsFirstOpen(BiliContext.application());
                        BPushHelper.reportForeground();
                    }
                });
            }
            this.mIsBackground = false;
        }

        public void onForegroundActivitiesChanged(int lastForegroundCount, int currentForegroundCount) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportIsFirstOpen(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences preference = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        if (EnvironmentManager.getInstance().isFirstStart() && preference.getBoolean(PRE_KEY_IS_FIRST_OPEN, true)) {
            AppSysReport.reportAppFirstOpen();
            preference.edit().putBoolean(PRE_KEY_IS_FIRST_OPEN, false).apply();
        }
    }

    public static void reportForeground(Context context) {
        if (context == null) {
            return;
        }
        String androidId = PhoneIdHelper.getAndroidId(context);
        String imei = PhoneIdHelper.getImei(context);
        String mac = HwIdHelper.getWifiMacAddr(context);
        String oaid = MsaHelper.getOaid();
        String sessionId = ApplicationTracer.initialize(context).getSessionId();
        final Map<String, String> map = new HashMap<>();
        map.put("openudid", androidId);
        map.put("idfa", imei);
        map.put("mac", mac);
        map.put("oaid", oaid);
        map.put("session_id", sessionId);
        map.put("drmid", DrmIdHelper.INSTANCE.getDrmId());
        map.put("local_buvid", BuvidHelper.getLocalBuvid());
        final String[] v2 = {NeuronEventId.APP_COPY, ReportEvent.EVENT_TYPE_SHOW, androidId, imei, sessionId, oaid};
        DelayReportForOaid.INSTANCE.delayIfNeed(new Function0() { // from class: tv.danmaku.bili.router.MainBootstrap$$ExternalSyntheticLambda0
            public final Object invoke() {
                return MainBootstrap.lambda$reportForeground$1(map, v2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$reportForeground$1(Map map, String[] v2) {
        if (((String) map.get("oaid")).isEmpty()) {
            map.put("oaid", MsaHelper.getOaid());
        }
        Neurons.report(true, 4, ((Boolean) ConfigManager.ab().get("dausdk.exchange.enable", true)).booleanValue() ? "app.active.startup-infra.sys" : NeuronEventId.APP_COPY, map);
        if (v2[5].isEmpty()) {
            v2[5] = MsaHelper.getOaid();
        }
        InfoEyesManager.getInstance().report2(true, "000225", v2);
        BLog.i("reportForeground", map.toString());
        return null;
    }
}