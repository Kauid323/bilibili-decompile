package tv.danmaku.bili.report;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.biliid.utils.device.HwIdHelper;
import com.bilibili.lib.biliid.utils.device.PhoneIdHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.drmid.DrmIdHelper;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.neuron.model.CustomModel;
import com.bilibili.lib.oaid.MsaHelper;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppInfo;
import tv.danmaku.android.util.CpuInfoKt;
import tv.danmaku.android.util.InstalledAppsUtils;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.report.biz.triple.TripleReportUtil;
import tv.danmaku.bili.report.platform.api.DataflowReporter;
import tv.danmaku.bili.report.platform.infoeyes.TaskIdConst;
import tv.danmaku.bili.report.platform.neuron.NeuronEventId;

public class InfoEyesReporter {
    public static final int GAME_DETAIL_OPT_CLICK = 1;
    public static final int GAME_DETAIL_OPT_PAGE_PV = 2;
    public static final int MY_GAME_OPT_CLICK = 1;
    public static final int MY_GAME_OPT_MORE = 3;
    public static final int MY_GAME_OPT_SHOW = 2;

    public static void reportAppMain(Context context, boolean reportEnable, String lastRunInterval) {
        String androidId = PhoneIdHelper.getAndroidId(context);
        String imei = PhoneIdHelper.getImei(context);
        String mac = HwIdHelper.getWifiMacAddr(context);
        String oaid = MsaHelper.getOaid();
        String drmId = DrmIdHelper.INSTANCE.getDrmId();
        String buvid3 = BuvidHelper.getRemoteBuvid();
        final String[] values = {Uri.encode(booleanToReportValue(reportEnable)), Uri.encode(lastRunInterval), androidId, imei, mac, "", "", "", oaid, "", drmId, buvid3};
        final Map<String, String> map = new HashMap<>();
        map.put("lastruninterval", lastRunInterval);
        map.put("openudid", androidId);
        map.put("idfa", imei);
        map.put("mac", mac);
        map.put("oaid", oaid);
        map.put("session_id", ApplicationTracer.initialize(context).getSessionId());
        map.put("drmid", drmId);
        map.put("buvid3", buvid3);
        map.put("local_buvid", BuvidHelper.getLocalBuvid());
        map.put("abi", CpuInfoKt.getDevicePrefArch().name());
        map.put("referrer_pkg_name", ReferrerUtil.INSTANCE.getReferrer());
        map.put("installer_name", ReferrerUtil.INSTANCE.getInstaller());
        map.put("install_time", ReferrerUtil.INSTANCE.getInstallTime());
        DelayReportForOaid.INSTANCE.delayIfNeed(new Function0() { // from class: tv.danmaku.bili.report.InfoEyesReporter$$ExternalSyntheticLambda0
            public final Object invoke() {
                return InfoEyesReporter.lambda$reportAppMain$0(map, values);
            }
        });
        CustomModel event = new CustomModel(true, 4, NeuronEventId.APP_MAIN, map, 1);
        Map<String, String> forApi = TripleReportUtil.getMsgInfoMap(event);
        DataflowReporter.report(NeuronEventId.APP_MAIN, 4, forApi);
        BLog.i("report start up", map.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$reportAppMain$0(Map map, String[] values) {
        if (((String) map.get("oaid")).isEmpty()) {
            map.put("oaid", MsaHelper.getOaid());
        }
        Neurons.report(true, 4, NeuronEventId.APP_MAIN, map);
        if (values[8].isEmpty()) {
            values[8] = MsaHelper.getOaid();
        }
        InfoEyesManager.getInstance().report2(true, TaskIdConst.TABLE_APP_MAIN, values);
        return null;
    }

    public static void reportDeviceFingerPrint(@Nonnull Context context) {
        String androidId = PhoneIdHelper.getAndroidId(context);
        String SerialNumber = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_hookGetSERIAL();
        String guid = EnvironmentManager.getInstance().getGuid();
        String[] values = {Uri.encode(androidId), Uri.encode(SerialNumber), guid};
        InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_DEVICE_FINGERPRINT, values);
        Map<String, String> extension = new HashMap<>();
        extension.put("android_id", androidId);
        extension.put("serial", SerialNumber);
        extension.put("guid", guid);
        Neurons.report(false, 4, NeuronEventId.DEVICE_FINGERPRINT, extension);
        CustomModel event = new CustomModel(false, 4, NeuronEventId.DEVICE_FINGERPRINT, extension, 1);
        Map<String, String> forApi = TripleReportUtil.getMsgInfoMap(event);
        DataflowReporter.report(NeuronEventId.DEVICE_FINGERPRINT, 4, forApi);
    }

    public static String uriEncodeString(String str) {
        return str == null ? "" : Uri.encode(str);
    }

    public static String booleanToReportValue(boolean b) {
        return b ? "1" : "2";
    }

    private static String intStringToReportValue(String str) {
        if (str == null) {
            return "";
        }
        if ((str.length() <= 1 || str.charAt(0) != '-' || !TextUtils.isDigitsOnly(str.substring(1))) && !TextUtils.isDigitsOnly(str)) {
            return "";
        }
        return str;
    }

    public static void scheduleReportAppCoexist(Context context) {
        if (!EnvironmentManager.getInstance().getPrefHelper().isTodayFirstAppCoexist() || !((Boolean) ConfigManager.ab().get("startup_applist_enable", true)).booleanValue()) {
            return;
        }
        final Context app = context.getApplicationContext();
        HandlerThreads.postDelayed(1, new Runnable() { // from class: tv.danmaku.bili.report.InfoEyesReporter.1
            @Override // java.lang.Runnable
            public void run() {
                InfoEyesReporter.reportAppCoexist(app);
            }
        }, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportAppCoexist(Context apps) {
        JSONArray jsonArray = getInstalledApps(apps.getPackageManager());
        if (jsonArray.length() == 0) {
            BLog.v("Get empty app list but send it anyway");
        }
        try {
            String cryptString = getLimitedSizeString(jsonArray);
            HashMap<String, String> args = new HashMap<>();
            args.put("applist", Uri.encode(cryptString));
            Neurons.report(false, 4, "main.startup.applist.sys", args);
            EnvironmentManager.getInstance().getPrefHelper().setAppCoexistTime(System.currentTimeMillis());
        } catch (Exception ignored) {
            if (BuildConfig.DEBUG) {
                throw new RuntimeException(ignored.getCause());
            }
            BLog.e(ignored.getMessage());
        }
    }

    private static String getLimitedSizeString(JSONArray source) throws Exception {
        String cryptString = InfoEyesCryptor.aesEncrypt(source.toString().getBytes("UTF-8"));
        while (cryptString.length() > 61440) {
            source = removeFirstElement(source);
            cryptString = InfoEyesCryptor.aesEncrypt(source.toString().getBytes("UTF-8"));
        }
        return cryptString;
    }

    private static JSONArray removeFirstElement(JSONArray source) throws JSONException {
        if (source.length() > 0) {
            source.remove(0);
            return source;
        }
        return source;
    }

    private static JSONArray getInstalledApps(PackageManager packageManager) {
        JSONArray jsonArray = new JSONArray();
        List<AppInfo> applicationInfos = null;
        try {
            applicationInfos = InstalledAppsUtils.getInstalledApps();
        } catch (NullPointerException e) {
            BLog.w(e.getMessage(), e);
        }
        if (applicationInfos == null || applicationInfos.isEmpty()) {
            return jsonArray;
        }
        for (AppInfo applicationInfo : applicationInfos) {
            if ((applicationInfo.flags & 1) == 0) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("p", applicationInfo.packageName);
                    jsonArray.put(jsonObject);
                } catch (JSONException e2) {
                }
            }
        }
        return jsonArray;
    }

    public static void reportOfflineVideoDownload(String from, long cid, String content_type, long connect_time, int response_code, int error_code, String retry_info, String additional) {
        InfoEyesManager.getInstance().report2(true, TaskIdConst.TABLE_DOWNLOAD_VIDEO_QUALITY, new String[]{uriEncodeString(from), String.valueOf(cid), uriEncodeString(content_type), String.valueOf(connect_time), String.valueOf(response_code), String.valueOf(error_code), uriEncodeString(retry_info), uriEncodeString(additional)});
    }

    @JvmStatic
    private static String __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_hookGetSERIAL() {
        Object defaultReturnValue$iv = "";
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getAlways();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("build_get_field_serial")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [build_get_field_serial]", (Throwable) null, 4, (Object) null);
                Object obj = Build.SERIAL;
                defaultReturnValue$iv = obj instanceof String ? obj : null;
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("build_get_field_serial")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [build_get_field_serial] defaultReturnValue = [" + ((Object) "") + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("build_get_field_serial")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [build_get_field_serial] defaultReturnValue = [" + ((Object) "") + "]", (Throwable) null, 4, (Object) null);
            } else {
                Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "build_get_field_serial");
                if (it$iv == null) {
                    Object obj2 = Build.SERIAL;
                    if (!(obj2 instanceof String)) {
                        obj2 = null;
                    }
                    Object res$iv = obj2;
                    if (res$iv != null) {
                        PrivacyHelper.INSTANCE.getPrivacyCache().put("build_get_field_serial", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "build_get_field_serial", defaultCacheTime$iv)));
                    }
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: build_get_field_serial", (Throwable) null, 4, (Object) null);
                    defaultReturnValue$iv = res$iv;
                } else {
                    defaultReturnValue$iv = it$iv;
                }
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: build_get_field_serial, message = " + t$iv.getMessage(), t$iv);
            } else {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: build_get_field_serial, message = " + t$iv.getMessage(), (Throwable) null);
            }
        }
        return (String) defaultReturnValue$iv;
    }

    public static void reportOfflineVideoFlow(String from, long avid, long cid, int abort_type, int storage_type, String root_path, String download_locations, String additional) {
        InfoEyesManager.getInstance().report2(true, TaskIdConst.TABLE_DOWNLOAD_VIDEO_FLOW, new String[]{uriEncodeString(from), String.valueOf(avid), String.valueOf(cid), String.valueOf(abort_type), String.valueOf(storage_type), uriEncodeString(root_path), uriEncodeString(download_locations), uriEncodeString(additional)});
    }
}