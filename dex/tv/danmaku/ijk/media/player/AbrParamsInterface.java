package tv.danmaku.ijk.media.player;

import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.bilibili.lib.dd.DeviceDecision;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;

public class AbrParamsInterface {
    public static final int ABR_DYNAMIC_ENABLE_HIGH_EXP = 1000007;
    public static final int ABR_DYNAMIC_MAX_QN_VALUE = 1000002;
    public static final int ABR_DYNAMIC_MIN_QN_VALUE = 1000001;
    public static final int ABR_DYNAMIC_SCREEN_RATIO = 1000006;
    public static final int ABR_DYNAMIC_USER_PLAY_PREFER = 1000005;
    public static final int ABR_DYNAMIC_USER_QN_VALUE = 1000003;
    private static final String K_ABR_CONFIG = "ijkplayer.abr_param";
    private static final String K_HUAWEI_HDR_VIVID_SYSTEM_RENDER_LIST = "ijkplayer.huawei_disable_hdr_external_render_list";
    private static final String K_LIVE_START_LATENCY_CONFIG = "ijkplayer.live_start_latency";
    private static final String TAG = "AbrParamsInterface";
    private static IAbrParamsInterface client = null;
    private static final Object onlineConfigParamsCacheLock = new Object();
    private static String onlineConfigParamsCache = "";
    private static String onlineConfigLiveStartLatencyCache = "";
    private static String onlineConfigHuaweiHdrVividListCache = "";
    private static boolean isUpdateOnlineConfigParamCache = true;
    private static final Object onlineExpParamsCacheLock = new Object();
    private static boolean isUpdateOnlineExpParamCache = true;
    private static Bundle onlineExpParamsCache = new Bundle();
    private static final Object dynamicParamsCacheLock = new Object();
    private static final Bundle abrDynamicParamsCache = new Bundle();
    private static final Bundle abrDynamicParamsUpdateList = new Bundle();
    private static boolean isEnableAv1SwCodec = false;
    private static boolean isEnableVodUseAv1Soft = false;
    private static int av1SoftMinAndroidApiLevel = 0;
    private static int av1SoftMinCpuCores = 0;
    private static int av1SoftMinCpuFreq = 0;
    private static int av1SoftMinMemory = 0;
    private static int av1SoftMaxQn = 0;
    private static int av1SoftMinDeviceScore = 55;
    private static boolean isEnableH266SwCodec = false;
    private static int h266SoftMinDeviceScore = 55;
    private static int h266SoftMaxBitrate = 3000000;
    private static boolean enablePreloadByPrefer = false;
    private static int[] deviceLevelThresholds = {35, 42, 55, 70, 90, 100};

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface MediaConfigCallback {
        String getConfigForKey(String str);

        boolean hitExperimentalGroupForKey(String str);
    }

    public static void setInstance(IAbrParamsInterface abrParamsInterface) {
        synchronized (AbrParamsInterface.class) {
            if (client == null || client != abrParamsInterface) {
                client = abrParamsInterface;
                isUpdateOnlineConfigParamCache = false;
                isUpdateOnlineExpParamCache = false;
                BLog.i(TAG, "setInstance");
            }
        }
    }

    private static void setDynamicParam(int type, int value, String printInfo) {
        synchronized (dynamicParamsCacheLock) {
            int cacheValue = abrDynamicParamsCache.getInt(String.valueOf(type));
            if (value != cacheValue) {
                abrDynamicParamsCache.putInt(String.valueOf(type), value);
                abrDynamicParamsUpdateList.putInt(String.valueOf(type), value);
                updateParams();
            }
        }
        BLog.i(TAG, printInfo + value);
    }

    public static void setMinQn(int minQn) {
        setDynamicParam(ABR_DYNAMIC_MIN_QN_VALUE, minQn, "SetMinQn=");
    }

    public static void setMaxQn(int maxQn) {
        IjkDeviceScoreInfo deviceScoreInfo = IjkDeviceScoreInfo.getInstance(null);
        int deviceSupportQn = deviceScoreInfo == null ? -1 : deviceScoreInfo.getDeviceSupportQn();
        if (deviceSupportQn != -1) {
            BLog.i(TAG, "Adjust OriginMaxQn=" + maxQn + " ,deviceSupportQn=" + deviceSupportQn);
            maxQn = Math.min(maxQn, deviceSupportQn);
        }
        setDynamicParam(ABR_DYNAMIC_MAX_QN_VALUE, maxQn, "SetMaxQn=");
    }

    public static void setUserPlayPrefer(int userPlayPrefer) {
        setDynamicParam(ABR_DYNAMIC_USER_PLAY_PREFER, userPlayPrefer, "SetUserPlayPrefer=");
    }

    public static void setUserQn(int userQn) {
        setDynamicParam(ABR_DYNAMIC_USER_QN_VALUE, userQn, "SetUserQn=");
    }

    public static void setScreenRatio(int screenRatio) {
        setDynamicParam(ABR_DYNAMIC_SCREEN_RATIO, screenRatio, "SetScreenRatio=");
    }

    public static void setEnableHighExperience() {
        setDynamicParam(ABR_DYNAMIC_ENABLE_HIGH_EXP, GetDdSwitch("ijkplayer.enable_high_experience", false) ? 1 : 0, "setEnableHighExperience=");
    }

    public static int getMinQn() {
        return getDynamicParams(ABR_DYNAMIC_MIN_QN_VALUE);
    }

    public static int getMaxQn() {
        return getDynamicParams(ABR_DYNAMIC_MAX_QN_VALUE);
    }

    public static int getUserPlayPrefer() {
        return getDynamicParams(ABR_DYNAMIC_USER_PLAY_PREFER);
    }

    public static int getUserQn() {
        return getDynamicParams(ABR_DYNAMIC_USER_QN_VALUE);
    }

    private static int getDynamicParams(int type) {
        synchronized (dynamicParamsCacheLock) {
            if (abrDynamicParamsUpdateList.isEmpty()) {
                int value = abrDynamicParamsCache.getInt(String.valueOf(type));
                BLog.i(TAG, "getDynamicParams from cache " + type + " " + value);
                return value;
            }
            IAbrParamsInterface localClient = client;
            int ret = 0;
            if (localClient != null) {
                try {
                    ret = localClient.getAbrParamInt(type);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            BLog.i(TAG, "getDynamicParams from native " + type + " " + ret);
            return ret;
        }
    }

    private static String getOnlineConfigParams(String paramKey) {
        synchronized (onlineConfigParamsCacheLock) {
            String[] paramString = onlineConfigParamsCache.split(",");
            for (String param : paramString) {
                if (param.contains(paramKey)) {
                    Pattern matchPatten = Pattern.compile("(\\d+)");
                    Matcher match = matchPatten.matcher(param);
                    if (isEnableAv1SwCodec) {
                        String numStr = "";
                        while (match.find()) {
                            numStr = match.group(0);
                        }
                        if (numStr != null && !numStr.isEmpty()) {
                            BLog.i(TAG, "getOnlineConfigParams key = " + paramKey + ", value = " + numStr);
                            return numStr;
                        }
                    } else if (match.find()) {
                        BLog.i(TAG, "getOnlineConfigParams key = " + paramKey + "value = " + match.group(0));
                        return match.group(0);
                    }
                }
            }
            return "";
        }
    }

    private static void setAv1SoftConfigInfo() {
        if (!isEnableAv1SwCodec) {
            return;
        }
        av1SoftMinAndroidApiLevel = getIntConfigParamsByKey("av1_soft_min_android_api_level", 28);
        av1SoftMinCpuCores = getIntConfigParamsByKey("av1_soft_min_cpu_cores", 8);
        av1SoftMinCpuFreq = getIntConfigParamsByKey("av1_soft_min_cpu_freq", 2000000);
        av1SoftMinMemory = getIntConfigParamsByKey("av1_soft_min_memory", IjkCodecHelper.IJKCODEC_H265_BITRATE);
        av1SoftMaxQn = getIntConfigParamsByKey("av1_soft_max_qn", 80);
        av1SoftMinDeviceScore = getIntConfigParamsByKey("av1_soft_min_device_score", 55);
    }

    private static void setH266SoftConfigInfo() {
        if (!isEnableH266SwCodec) {
            return;
        }
        h266SoftMinDeviceScore = getIntConfigParamsByKey("h266_soft_min_device_score", 55);
        h266SoftMaxBitrate = getIntConfigParamsByKey("h266_soft_max_bitrate", 3000000);
    }

    private static void setDeviceLevelThresholds() {
        JSONObject paramObj;
        synchronized (onlineConfigParamsCacheLock) {
            if (onlineConfigParamsCache == null || onlineConfigParamsCache.trim().isEmpty()) {
                return;
            }
            try {
                paramObj = new JSONObject(onlineConfigParamsCache);
            } catch (JSONException e) {
                BLog.e(TAG, "device_level_threshold load fail", e);
            }
            if (paramObj.has("device_level_threshold")) {
                JSONObject thresholdObj = paramObj.getJSONObject("device_level_threshold");
                String[] levelKeys = {"poor", "bad", "average", "medium", "good", "high"};
                int[] newThresholds = new int[levelKeys.length];
                for (int i = 0; i < levelKeys.length; i++) {
                    String key = levelKeys[i];
                    newThresholds[i] = thresholdObj.optInt(key, deviceLevelThresholds[i]);
                }
                deviceLevelThresholds = newThresholds;
            }
        }
    }

    public static int getIntConfigParamsByKey(String key, int defaultValue) {
        String valueString = getOnlineConfigParams(key);
        if (valueString == "") {
            return defaultValue;
        }
        int value = Integer.parseInt(valueString);
        return value;
    }

    private static boolean GetDdSwitch(String key, boolean defaultValue) {
        try {
            DeviceDecision instance = DeviceDecision.INSTANCE;
            if (instance.getImpl() == null) {
                return defaultValue;
            }
            boolean ret = instance.getBoolean(key, defaultValue);
            return ret;
        } catch (Exception e) {
            BLog.i(TAG, String.format(Locale.US, "GetDdSwitch fail [%s,%b]", key, Boolean.valueOf(defaultValue)));
            return defaultValue;
        }
    }

    public static boolean IsEnableJavaExpOn() {
        return GetDdSwitch("ijkplayer.enable_java_exp", false);
    }

    public static boolean IsEnableJavaExpOn2() {
        return GetDdSwitch("ijkplayer.enable_java_exp2", false);
    }

    public static boolean IsEnableFirstFrameOpt() {
        return GetDdSwitch("ijkplayer.enable_first_frame_opt", false);
    }

    public static boolean IsEnableVodAv1() {
        return GetDdSwitch("ijkplayer.enable_vod_av1", false);
    }

    public static boolean IsEnableLiveAv1() {
        return GetDdSwitch("ijkplayer.enable_live_av1", false);
    }

    public static boolean IsEnableVodEnhance() {
        return GetDdSwitch("ijkplayer.enable_vod_enhance", false);
    }

    public static boolean IsEnableAv1SwCodec() {
        return isEnableAv1SwCodec;
    }

    public static boolean IsEnableVodUseAv1Soft() {
        return isEnableVodUseAv1Soft;
    }

    public static boolean IsEnableH266SwCodec() {
        return isEnableH266SwCodec;
    }

    public static int getAv1SoftMinAndroidApiLevel() {
        return av1SoftMinAndroidApiLevel;
    }

    public static int getAv1SoftMinCpuCores() {
        return av1SoftMinCpuCores;
    }

    public static int getAv1SoftMinCpuFreq() {
        return av1SoftMinCpuFreq;
    }

    public static int getAv1SoftMinMemory() {
        return av1SoftMinMemory;
    }

    public static int getAv1SoftMaxQn() {
        return av1SoftMaxQn;
    }

    public static int getAv1SoftMinDeviceScore() {
        return av1SoftMinDeviceScore;
    }

    public static int getH266SoftMinDeviceScore() {
        return h266SoftMinDeviceScore;
    }

    public static int getH266SoftMaxBitrate() {
        return h266SoftMaxBitrate;
    }

    public static int[] getDeviceLevelThresholds() {
        return deviceLevelThresholds;
    }

    public static void initOnlineParamsCallback(MediaConfigCallback callback) {
        if (callback != null) {
            loadOnlineConfigCache(callback);
            loadExperimentalGroup(callback);
        }
        setAv1SoftConfigInfo();
        setH266SoftConfigInfo();
        setDeviceLevelThresholds();
    }

    private static void loadOnlineConfigCache(MediaConfigCallback callback) {
        synchronized (onlineConfigParamsCacheLock) {
            onlineConfigParamsCache = callback.getConfigForKey(K_ABR_CONFIG);
            onlineConfigLiveStartLatencyCache = callback.getConfigForKey(K_LIVE_START_LATENCY_CONFIG);
            onlineConfigHuaweiHdrVividListCache = callback.getConfigForKey(K_HUAWEI_HDR_VIVID_SYSTEM_RENDER_LIST);
            isUpdateOnlineConfigParamCache = false;
        }
    }

    public static String getHuaweiHdrVividSystemRenderListJson() {
        String str;
        synchronized (onlineConfigParamsCacheLock) {
            str = onlineConfigHuaweiHdrVividListCache;
        }
        return str;
    }

    private static void putExperimentalKey(Bundle updateBundle, MediaConfigCallback callback, String key) {
        updateBundle.putBoolean(key, GetDdSwitch(key, false));
    }

    private static void loadExperimentalGroup(MediaConfigCallback callback) {
        isEnableAv1SwCodec = GetDdSwitch("ijkplayer.enable_av1_sw_codec", false);
        isEnableVodUseAv1Soft = GetDdSwitch("ijkplayer.enable_vod_use_av1_soft", false);
        isEnableH266SwCodec = GetDdSwitch("ijkplayer.enable_h266_sw_codec", false);
        enablePreloadByPrefer = GetDdSwitch("ijkplayer.enable_preload_by_prefer", false);
        Bundle updateBundle = new Bundle();
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_vod_av1");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_live_av1");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_av1_sw_codec");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_vod_use_av1_soft");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_h266_sw_codec");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable-throughput-log");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable-live-experiment");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_new_jitter");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable-short-term-exp");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_live_dataset_index");
        putExperimentalKey(updateBundle, callback, "ijkplayer.choose_prefer_codec");
        putExperimentalKey(updateBundle, callback, "ijkplayer.url_cache_limit");
        putExperimentalKey(updateBundle, callback, "ijkplayer.cdn_cache_limit");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable-dynamic-recv-buffer-size");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_temp_exp");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_hls_opt_exp");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_start_by_prefer");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_preload_by_prefer");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_cache_by_prefer");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_buffering_risk");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_rendering_stuck");
        putExperimentalKey(updateBundle, callback, "ijkplayer.rendering_stuck_no_beginning");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_new_wave_tracker");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_java_exp");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_user_play_prefer");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_audio_opt");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_first_frame_opt");
        putExperimentalKey(updateBundle, callback, "ijkplayer.disable_send_decoded_frame");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_vod_enhance");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_live_bilinet");
        putExperimentalKey(updateBundle, callback, P2P.KEY_EXT_P2P_DOWNLOAD);
        putExperimentalKey(updateBundle, callback, "ijkplayer.bilinet_short_term_exp");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_bilinet_range_request");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable_resp_header_log");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable-dynamic-tcp-read-timeout");
        putExperimentalKey(updateBundle, callback, "ijkplayer.enable-dynamic-tcp-connect-timeout");
        synchronized (onlineExpParamsCacheLock) {
            onlineExpParamsCache = updateBundle;
            isUpdateOnlineExpParamCache = false;
        }
    }

    public static void updateOnlineConfig() {
        IAbrParamsInterface localClient = client;
        if (localClient == null) {
            return;
        }
        Bundle configBundle = new Bundle();
        synchronized (onlineConfigParamsCacheLock) {
            if (isUpdateOnlineConfigParamCache) {
                return;
            }
            String str = onlineConfigParamsCache;
            configBundle.putString(K_ABR_CONFIG, onlineConfigParamsCache);
            configBundle.putString(K_LIVE_START_LATENCY_CONFIG, onlineConfigLiveStartLatencyCache);
            isUpdateOnlineConfigParamCache = true;
            try {
                localClient.updateOnlineConfigBundle(configBundle);
            } catch (RemoteException e) {
                BLog.i(TAG, String.format("updateOnlineConfig fail, reason= %s", e.toString()));
            }
        }
    }

    public static void updateExperimentalGroup() {
        IAbrParamsInterface localClient = client;
        if (localClient == null) {
            return;
        }
        synchronized (onlineExpParamsCacheLock) {
            Bundle expBundle = onlineExpParamsCache;
            if (isUpdateOnlineExpParamCache) {
                return;
            }
            isUpdateOnlineExpParamCache = true;
            try {
                localClient.updateExperimentalGroup(expBundle);
            } catch (RemoteException e) {
                BLog.i(TAG, "updateExperimentalGroup fail, reason=" + e.toString());
            }
        }
    }

    public static void updateDynamicParams() {
        Bundle dynamicParamBundle;
        IAbrParamsInterface localClient = client;
        if (localClient == null) {
            return;
        }
        synchronized (dynamicParamsCacheLock) {
            if (abrDynamicParamsUpdateList.isEmpty()) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                dynamicParamBundle = abrDynamicParamsUpdateList.deepCopy();
            } else {
                dynamicParamBundle = new Bundle(abrDynamicParamsUpdateList);
            }
            try {
                localClient.updateDynamicAbrParams(dynamicParamBundle);
                abrDynamicParamsUpdateList.clear();
            } catch (RemoteException e) {
                BLog.i(TAG, "updateDynamicParams fail, reason=" + e.toString());
            }
        }
    }

    public static void updateParams() {
        updateExperimentalGroup();
        updateOnlineConfig();
        updateDynamicParams();
    }
}