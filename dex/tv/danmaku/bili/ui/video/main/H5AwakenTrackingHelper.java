package tv.danmaku.bili.ui.video.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.base.ipc.IPCAppStateManager;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.biliid.utils.device.PhoneIdHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.oaid.MsaHelper;
import com.bilibili.lib.sharewrapper.report.ShareTrackHelper;
import com.bilibili.lib.sharewrapper.report.ShareTrackParams;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.ApplicationTracer;
import tv.danmaku.bili.report.ReferrerUtil;
import tv.danmaku.bili.ui.intent.IntentHandlerActivity;
import tv.danmaku.bili.ui.main.deeplink.RedirectDeeplinkHelper;

public final class H5AwakenTrackingHelper {
    private static final String ERROR_REPORT_KEY_MESSAGE = "error_message";
    private static final String ERROR_REPORT_KEY_URL = "url";
    private static final String EVENT_ERROR_REPORT = "main.growth.startup.sys";
    private static final String PARAMS_ADDITION = "open_app_addition";
    private static final String PARAMS_ANDROID_ID = "androidid";
    private static final String PARAMS_CODE_START = "open_app_wake";
    private static final String PARAMS_DEEP_LINK_ID = "deeplink_id";
    public static final String PARAMS_EXTRA_MSG = "extra_msg";
    private static final String PARAMS_FROM_TYPE = "open_app_from_type";
    private static final String PARAMS_GROUPID = "open_app_groupid";
    private static final String PARAMS_IMEI = "imei";
    public static final String PARAMS_INSTALLER_NAME = "installer_name";
    public static final String PARAMS_INSTALLER_TIME = "install_time";
    private static final String PARAMS_IVK_FROM = "ivk_from";
    private static final String PARAMS_IVK_FROM_CHANNEL = "growth.ivk_from_channel";
    private static final String PARAMS_OAID = "oaid";
    public static final String PARAMS_PAID_LAHUO = "is_paid_lahuo";
    private static final String PARAMS_PUSH_SESSION_ID = "session_id";
    public static final String PARAMS_PUSH_TASK_ID = "push_task_id";
    public static final String PARAMS_REFERRER_PKG_NAME = "referrer_pkg_name";
    private static final String PARAMS_URL = "open_app_url";
    private static final String PARAMS_UUID = "open_app_uuid";
    private static final String TAG = "H5AwakenTrackingHelper";
    private static String lastRecord = "";
    private static String lastRecord_1 = "";
    private static String lastRecord_2 = "";
    public static Boolean fromPullActiveUser = false;
    private static Application.ActivityLifecycleCallbacks CALLBACK = new Application.ActivityLifecycleCallbacks() { // from class: tv.danmaku.bili.ui.video.main.H5AwakenTrackingHelper.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (UtilKt.checkAllowReport()) {
                handleV2Report(activity, savedInstanceState, 0);
            }
            if (H5AwakenTrackingHelper.checkInterceptActivity77(activity)) {
                if (UtilKt.checkAllowReport1()) {
                    handleV2Report(activity, savedInstanceState, 1);
                }
                if (UtilKt.checkAllowReport2()) {
                    handleV2Report(activity, savedInstanceState, 2);
                }
            }
            if (activity instanceof IntentHandlerActivity) {
                UtilKt.deepLinkTrack("H5AwakenTrackingHelper hook onActivityCreated but curActivity is IntentHandlerActivity");
            } else if (savedInstanceState == null) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    String deeplinkOriginUrl = RedirectDeeplinkHelper.INSTANCE.getOriginUrl();
                    if (H5AwakenTrackingHelper.enableDeeplinkReport() && !deeplinkOriginUrl.equals("")) {
                        UtilKt.deepLinkTrack("H5AwakenTrackingHelper report deeplinkOriginUrl");
                        H5AwakenTrackingHelper.tryReport(deeplinkOriginUrl);
                        RedirectDeeplinkHelper.INSTANCE.setOriginUrl("");
                        return;
                    } else if (data != null) {
                        H5AwakenTrackingHelper.tryReport(data.toString());
                        return;
                    } else {
                        H5AwakenTrackingHelper.tryReport(findRequiredParam(intent.getExtras(), "blrouter.pureurl"));
                        return;
                    }
                }
                UtilKt.deepLinkTrack("H5AwakenTrackingHelper intent is null");
            } else {
                UtilKt.deepLinkTrack("H5AwakenTrackingHelper has savedInstanceState so drop");
            }
        }

        private void handleV2Report(Activity activity, Bundle savedInstanceState, int type) {
            String check;
            if (savedInstanceState == null) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Bundle b = intent.getExtras();
                    if (b != null && (check = b.getString("deeplink_transform_check")) != null && check.equals("1")) {
                        return;
                    }
                    Uri data = intent.getData();
                    String deeplinkOriginUrl = RedirectDeeplinkHelper.INSTANCE.getOriginUrl();
                    if (H5AwakenTrackingHelper.enableDeeplinkReport() && !deeplinkOriginUrl.equals("")) {
                        UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper report deeplinkOriginUrl");
                        H5AwakenTrackingHelper.tryReportV2(deeplinkOriginUrl, type);
                        RedirectDeeplinkHelper.INSTANCE.setOriginUrl("");
                        return;
                    } else if (data != null) {
                        H5AwakenTrackingHelper.tryReportV2(data.toString(), type);
                        return;
                    } else {
                        String temp = findRequiredParamV2(intent.getExtras(), "blrouter.pureurl");
                        UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper findRequiredParam, url = " + temp);
                        H5AwakenTrackingHelper.tryReportV2(temp, type);
                        return;
                    }
                }
                UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper intent is null");
                return;
            }
            String url = savedInstanceState.getString(UtilKt.DEEPLINK_URL_KEY);
            UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper savedInstanceState is null, url = " + url);
            H5AwakenTrackingHelper.tryReportV2(url, type);
            savedInstanceState.remove(UtilKt.DEEPLINK_URL_KEY);
        }

        private String findRequiredParam(Bundle bundle, String target) {
            String param;
            if (bundle == null) {
                return null;
            }
            String s = bundle.getString(target);
            if (s != null) {
                return s;
            }
            for (String key : bundle.keySet()) {
                Object nested = bundle.get(key);
                if ((nested instanceof Bundle) && (param = findRequiredParam((Bundle) nested, target)) != null) {
                    return param;
                }
            }
            return null;
        }

        private String findRequiredParamV2(Bundle bundle, String target) {
            String param;
            if (bundle == null) {
                return null;
            }
            String s = bundle.getString(target);
            if (s != null) {
                return s;
            }
            for (String key : bundle.keySet()) {
                Object nested = bundle.get(key);
                if ((nested instanceof Bundle) && (param = findRequiredParamV2((Bundle) nested, target)) != null) {
                    return param;
                }
            }
            for (String key2 : bundle.keySet()) {
                Object value = bundle.get(key2);
                if ((value instanceof String) && H5AwakenTrackingHelper.checkDeeplinkFormat(value.toString())) {
                    return value.toString();
                }
            }
            return null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            StartUpUtil.INSTANCE.setColdStartForAwaken(false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            UtilKt.deepLinkTrack("H5AwakenTrackingHelper activity is destroy, cur activity is " + activity.getLocalClassName());
        }
    };

    private static boolean checkInterceptActivity(Activity activity) {
        return (activity instanceof IntentHandlerActivity) || activity.getClass().getSimpleName().equals("WXEntryActivity") || activity.getClass().getSimpleName().equals("InstantEventWebActivity") || activity.getClass().getSimpleName().equals("InterceptUserProtocolActivity") || activity.getClass().getSimpleName().equals("AuthLoginActivity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkInterceptActivity77(Activity activity) {
        return (activity instanceof IntentHandlerActivity) || activity.getClass().getSimpleName().equals("WXEntryActivity") || activity.getClass().getSimpleName().equals("InstantEventWebActivity");
    }

    public static void initialize(Context context) {
        Application app = (Application) context.getApplicationContext();
        attach(app);
    }

    public static void attach(Application app) {
        detach(app);
        UtilKt.deepLinkTrack("H5AwakenTrackingHelper attach");
        app.registerActivityLifecycleCallbacks(CALLBACK);
        IPCAppStateManager.getInstance().addIPCActivityStateCallback(new IPCAppStateManager.GlobalVisibilityChangeCallback() { // from class: tv.danmaku.bili.ui.video.main.H5AwakenTrackingHelper.2
            public void onBackground() {
                H5AwakenTrackingHelper.lastRecord = "";
                H5AwakenTrackingHelper.lastRecord_1 = "";
                H5AwakenTrackingHelper.lastRecord_2 = "";
                UtilKt.setAllowReport(true);
                UtilKt.setAllowReport1(true);
                UtilKt.setAllowReport2(true);
                UtilKt.deepLinkTrack("app is onBackground");
            }

            public void onForeground() {
                UtilKt.deepLinkTrack("app is onForeground");
            }
        });
    }

    public static void detach(Application app) {
        UtilKt.deepLinkTrack("H5AwakenTrackingHelper detach");
        app.unregisterActivityLifecycleCallbacks(CALLBACK);
    }

    public static void tryReport(final String targetUrl) {
        UtilKt.deepLinkTrack("H5AwakenTrackingHelper tryReport targetUrl is " + targetUrl);
        if (TextUtils.isEmpty(targetUrl)) {
            UtilKt.deepLinkTrack("targetUrl is null");
        } else if (!checkDeeplinkFormat(targetUrl)) {
            boolean hasH5awaken = targetUrl.contains("h5awaken=");
            boolean hasPushTaskId = targetUrl.contains("push_task_id=");
            boolean hasIvkFrom = checkIvkFromExist(targetUrl);
            UtilKt.deepLinkTrack("H5AwakenTrackingHelper url param filter fail, can't report, reason is hasH5awaken = " + hasH5awaken + " hasPushTaskId = " + hasPushTaskId + " hasIvkFrom = " + hasIvkFrom);
        } else {
            HandlerThreads.getHandler(3).post(new Runnable() { // from class: tv.danmaku.bili.ui.video.main.H5AwakenTrackingHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        H5AwakenTrackingHelper.report(targetUrl);
                    } catch (Exception e) {
                        Map<String, String> params = new HashMap<>();
                        params.put("url", targetUrl);
                        params.put(H5AwakenTrackingHelper.ERROR_REPORT_KEY_MESSAGE, e.getMessage());
                        UtilKt.deepLinkTrack("H5AwakenTrackingHelper deeplink report error", e);
                        Neurons.report(true, 4, H5AwakenTrackingHelper.EVENT_ERROR_REPORT, params);
                    }
                }
            });
        }
    }

    public static boolean checkDeeplinkFormat(String targetUrl) {
        return targetUrl.contains("h5awaken=") || targetUrl.contains("push_task_id=") || checkIvkFromExist(targetUrl);
    }

    public static void tryReportV2(final String targetUrl, final int type) {
        UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper tryReport targetUrl is " + targetUrl);
        if (TextUtils.isEmpty(targetUrl)) {
            UtilKt.deepLinkTrack("V2 targetUrl is null");
            return;
        }
        switch (type) {
            case 1:
                if (UtilKt.checkEqual(lastRecord_1, targetUrl)) {
                    UtilKt.deepLinkTrack("V2 targetUrl is duplicate 1, drop it. url = " + lastRecord);
                    return;
                }
                break;
            case 2:
                if (UtilKt.checkEqual(lastRecord_2, targetUrl)) {
                    UtilKt.deepLinkTrack("V2 targetUrl is duplicate 2, drop it. url = " + lastRecord);
                    return;
                }
                break;
            default:
                if (UtilKt.checkEqual(lastRecord, targetUrl)) {
                    UtilKt.deepLinkTrack("V2 targetUrl is duplicate, drop it. url = " + lastRecord);
                    return;
                }
                break;
        }
        if (!checkDeeplinkFormat(targetUrl) && type != 2) {
            boolean hasH5awaken = targetUrl.contains("h5awaken=");
            boolean hasPushTaskId = targetUrl.contains("push_task_id=");
            boolean hasIvkFrom = checkIvkFromExist(targetUrl);
            UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper url param filter fail, can't report, reason is hasH5awaken = " + hasH5awaken + " hasPushTaskId = " + hasPushTaskId + " hasIvkFrom = " + hasIvkFrom);
            return;
        }
        switch (type) {
            case 1:
                lastRecord_1 = targetUrl;
                UtilKt.setAllowReport1(false);
                break;
            case 2:
                lastRecord_2 = targetUrl;
                UtilKt.setAllowReport2(false);
                break;
            default:
                lastRecord = targetUrl;
                UtilKt.setAllowReport(false);
                break;
        }
        HandlerThreads.getHandler(3).post(new Runnable() { // from class: tv.danmaku.bili.ui.video.main.H5AwakenTrackingHelper.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    H5AwakenTrackingHelper.reportV2(targetUrl, type);
                } catch (Exception e) {
                    UtilKt.setAllowReport(true);
                    UtilKt.setAllowReport1(true);
                    UtilKt.setAllowReport2(true);
                    Map<String, String> params = new HashMap<>();
                    params.put("url", targetUrl);
                    params.put(H5AwakenTrackingHelper.ERROR_REPORT_KEY_MESSAGE, e.getMessage());
                    UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper deeplink report error", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportV2(String targetUrl, int type) {
        Uri uri = Uri.parse(targetUrl);
        String h5awaken = uri.getQueryParameter("h5awaken");
        String fakeUrl = targetUrl;
        if (!TextUtils.isEmpty(h5awaken)) {
            String h5awakenDec = new String(Base64.decode(h5awaken.getBytes(), 0));
            fakeUrl = targetUrl + "&" + h5awakenDec;
        }
        reportAwakeV2(targetUrl, fakeUrl, type);
    }

    private static void reportAwakeV2(String originUrl, String fakeUrl, int type) {
        Map<String, String> map;
        Context context = BiliContext.application();
        UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper reportAwake targetUrl = " + originUrl + "fakeUrl = " + fakeUrl);
        if (context == null) {
            switch (type) {
                case 1:
                    UtilKt.setAllowReport1(true);
                    break;
                case 2:
                    UtilKt.setAllowReport2(true);
                    break;
                default:
                    UtilKt.setAllowReport(true);
                    break;
            }
            UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper context is null");
            return;
        }
        Uri newUri = Uri.parse(fakeUrl);
        String fromType = newUri.getQueryParameter(PARAMS_FROM_TYPE);
        String uuid = newUri.getQueryParameter(PARAMS_UUID);
        String groupid = newUri.getQueryParameter(PARAMS_GROUPID);
        String h5WebUrl = newUri.getQueryParameter(PARAMS_URL);
        String addition = newUri.getQueryParameter(PARAMS_ADDITION);
        String taskId = newUri.getQueryParameter(PARAMS_PUSH_TASK_ID);
        Map<String, String> map2 = new HashMap<>();
        if (!TextUtils.isEmpty(taskId)) {
            map = map2;
            map.put(PARAMS_FROM_TYPE, "push");
        } else {
            map = map2;
            if (TextUtils.isEmpty(fromType)) {
                map.put(PARAMS_FROM_TYPE, "other");
            } else {
                map.put(PARAMS_FROM_TYPE, fromType);
            }
        }
        if (!TextUtils.isEmpty(uuid)) {
            map.put(PARAMS_UUID, uuid);
        }
        if (!TextUtils.isEmpty(groupid)) {
            map.put(PARAMS_GROUPID, groupid);
        }
        if (!TextUtils.isEmpty(h5WebUrl)) {
            map.put(PARAMS_URL, h5WebUrl);
        }
        if (!TextUtils.isEmpty(taskId)) {
            map.put(PARAMS_ADDITION, taskId);
        } else if (!TextUtils.isEmpty(addition)) {
            map.put(PARAMS_ADDITION, addition);
        }
        map.put(PARAMS_CODE_START, String.valueOf(ApplicationTracer.initialize(context).getColdStart()));
        map.put(PARAMS_PUSH_SESSION_ID, ApplicationTracer.initialize(context).getSessionId());
        map.put(PARAMS_IMEI, PhoneIdHelper.getImei(context));
        map.put(PARAMS_OAID, MsaHelper.getOaid());
        map.put(PARAMS_ANDROID_ID, PhoneIdHelper.getAndroidId(context));
        map.put(PARAMS_DEEP_LINK_ID, originUrl);
        map.put(PARAMS_REFERRER_PKG_NAME, ReferrerUtil.INSTANCE.getReferrer());
        map.put(PARAMS_INSTALLER_NAME, ReferrerUtil.INSTANCE.getInstaller());
        map.put(PARAMS_INSTALLER_TIME, ReferrerUtil.INSTANCE.getInstallTime());
        switch (type) {
            case 1:
                Neurons.report(true, 4, "app.active.growth_test2.sys", map);
                break;
            case 2:
                Neurons.report(true, 4, "app.active.growth_test3.sys", map);
                break;
            default:
                Neurons.report(true, 4, "app.active.growth_test.sys", map);
                break;
        }
        UtilKt.deepLinkTrack("V2 H5AwakenTrackingHelper report param is" + map);
    }

    public static boolean enableDeeplinkReport() {
        return ConfigManager.ab().get("ff_deeplink_repetition_remake", true) != Boolean.FALSE;
    }

    private static boolean checkIvkFromExist(String targetUrl) {
        List<String> list;
        boolean disable = UtilKt.disableFFIvkFrom();
        String content = (String) ConfigManager.config().get(PARAMS_IVK_FROM_CHANNEL, "");
        ArrayList<String> channels = new ArrayList<>();
        try {
            Channel channel = (Channel) JSON.parseObject(content, Channel.class);
            if (channel != null && (list = channel.getChannel()) != null) {
                channels.addAll(list);
            }
        } catch (Exception e) {
            BLog.e(TAG, "json parse error", e);
        }
        if (channels.isEmpty()) {
            return targetUrl.contains(PARAMS_IVK_FROM) && !disable;
        }
        boolean checkChannel = false;
        for (int i = 0; i < channels.size(); i++) {
            if (targetUrl.contains("ivk_from=" + channels.get(i))) {
                checkChannel = true;
            }
        }
        return checkChannel && !disable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(String targetUrl) {
        Uri uri = Uri.parse(targetUrl);
        String h5awaken = uri.getQueryParameter("h5awaken");
        String fakeUrl = targetUrl;
        if (!TextUtils.isEmpty(h5awaken)) {
            String h5awakenDec = new String(Base64.decode(h5awaken.getBytes(), 0));
            fakeUrl = targetUrl + "&" + h5awakenDec;
            reportShareBack(fakeUrl);
        }
        reportAwake(targetUrl, fakeUrl);
    }

    private static void reportShareBack(String fakeUrl) {
        ShareTrackParams params = ShareTrackHelper.decodeTrackParamsFrom(fakeUrl);
        if (params == null) {
            return;
        }
        InfoEyesManager.getInstance().report2(false, "000225", new String[]{"app_source", "show", params.media, params.source, params.buvid, params.ts});
    }

    private static void reportAwake(String originUrl, String fakeUrl) {
        Context context = BiliContext.application();
        UtilKt.deepLinkTrack("H5AwakenTrackingHelper reportAwake targetUrl = " + originUrl + "fakeUrl = " + fakeUrl);
        if (context == null) {
            UtilKt.deepLinkTrack("H5AwakenTrackingHelper context is null");
            return;
        }
        Uri newUri = Uri.parse(fakeUrl);
        String fromType = newUri.getQueryParameter(PARAMS_FROM_TYPE);
        String uuid = newUri.getQueryParameter(PARAMS_UUID);
        String groupid = newUri.getQueryParameter(PARAMS_GROUPID);
        String h5WebUrl = newUri.getQueryParameter(PARAMS_URL);
        String addition = newUri.getQueryParameter(PARAMS_ADDITION);
        String taskId = newUri.getQueryParameter(PARAMS_PUSH_TASK_ID);
        Map<String, String> map = new HashMap<>();
        if (!TextUtils.isEmpty(taskId)) {
            map.put(PARAMS_FROM_TYPE, "push");
        } else if (TextUtils.isEmpty(fromType)) {
            map.put(PARAMS_FROM_TYPE, "other");
        } else {
            map.put(PARAMS_FROM_TYPE, fromType);
        }
        if (!TextUtils.isEmpty(uuid)) {
            map.put(PARAMS_UUID, uuid);
        }
        if (!TextUtils.isEmpty(groupid)) {
            map.put(PARAMS_GROUPID, groupid);
        }
        if (!TextUtils.isEmpty(h5WebUrl)) {
            map.put(PARAMS_URL, h5WebUrl);
        }
        if (!TextUtils.isEmpty(taskId)) {
            map.put(PARAMS_ADDITION, taskId);
        } else if (!TextUtils.isEmpty(addition)) {
            map.put(PARAMS_ADDITION, addition);
        }
        map.put(PARAMS_CODE_START, String.valueOf(ApplicationTracer.initialize(context).getColdStart()));
        map.put(PARAMS_PUSH_SESSION_ID, ApplicationTracer.initialize(context).getSessionId());
        map.put(PARAMS_IMEI, PhoneIdHelper.getImei(context));
        map.put(PARAMS_OAID, MsaHelper.getOaid());
        map.put(PARAMS_ANDROID_ID, PhoneIdHelper.getAndroidId(context));
        map.put(PARAMS_DEEP_LINK_ID, originUrl);
        map.put(PARAMS_REFERRER_PKG_NAME, ReferrerUtil.INSTANCE.getReferrer());
        map.put(PARAMS_INSTALLER_NAME, ReferrerUtil.INSTANCE.getInstaller());
        map.put(PARAMS_INSTALLER_TIME, ReferrerUtil.INSTANCE.getInstallTime());
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(PARAMS_PAID_LAHUO, Integer.valueOf(fromPullActiveUser.booleanValue() ? 1 : 0));
        map.put(PARAMS_EXTRA_MSG, jsonObject.toString());
        fromPullActiveUser = false;
        Neurons.report(true, 4, "app.active.growth.sys", map);
        UtilKt.deepLinkTrack("H5AwakenTrackingHelper report param is" + map);
    }
}