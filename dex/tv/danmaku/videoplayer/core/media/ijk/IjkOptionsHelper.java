package tv.danmaku.videoplayer.core.media.ijk;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.WindowManager;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.StringUtils;
import com.bilibili.droid.BuildHelper;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.playerbizcommon.IPlayerRemoteSetting;
import java.util.zip.Adler32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.CpuUtils;
import tv.danmaku.ijk.media.player.IjkCodecHelper;
import tv.danmaku.ijk.media.player.IjkCpuInfo;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaConfigParams;
import tv.danmaku.ijk.media.player.P2P;
import tv.danmaku.videoplayer.core.android.utils.CpuInfo;

public class IjkOptionsHelper {
    private static final String MAIN_SETTINGS_PREFERENCES_NAME = "bili_ijk_settings_preferences";
    public static final String PREF_KEY_IJKPLAYER_ENABLE_HEVC = "pref_key_is_ijkplayer_enable_h265";
    public static final String PREF_KEY_IJKPLAYER_SUPPORT_4K = "pref_key_is_ijkplayer_support_4k";
    public static final String SYSTEM_HTTP_UA;
    private static final String TAG = "IjkOptionsHelper";
    private static int h265Flag = 0;
    public static final String k_start_on_prepared = "start-on-prepared";
    private static String sCpuName = null;
    private static Boolean sIsSupport4K = null;
    private static Boolean sIsSupportDolbyVisionHw = null;
    private static String sPhoneModel = null;
    private static int sRate = 0;
    private static final long v_avdiscard_all = 48;
    private static final long v_avdiscard_bidir = 16;
    private static final long v_avdiscard_default = 0;
    private static final long v_avdiscard_nonkey = 32;
    private static final long v_avdiscard_nonref = 8;

    static {
        String agent = System.getProperty("http.agent");
        if (agent == null) {
            agent = "Dalvik/1.6.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + " Build/" + Build.ID + ")";
        }
        SYSTEM_HTTP_UA = agent;
        h265Flag = 0;
        sIsSupport4K = null;
        sIsSupportDolbyVisionHw = null;
        sCpuName = null;
        sPhoneModel = null;
        sRate = -1;
    }

    public static int getConfigInt(String key, int def) {
        try {
            return BLRemoteConfig.getInstance().getInt(key, def);
        } catch (Exception e) {
            return def;
        }
    }

    public static String getConfigString(String key, String def) {
        try {
            return BLRemoteConfig.getInstance().getString(key, def);
        } catch (Exception e) {
            return def;
        }
    }

    public static boolean isSupport8K() {
        String model = Build.MODEL;
        if (!TextUtils.isEmpty(model)) {
            return isModeIn8KWhiteList(model.toLowerCase());
        }
        return false;
    }

    public static boolean isSupport4K() {
        Context context = BiliContext.application();
        if (context == null) {
            return false;
        }
        if (sIsSupport4K == null) {
            if (hasSupport4KKV(context)) {
                sIsSupport4K = Boolean.valueOf(getSupport4KKV(context));
            }
            if (sIsSupport4K == null || (isEnableColdStartCheck4K() && !sIsSupport4K.booleanValue())) {
                sIsSupport4K = Boolean.valueOf(initAndSaveSupport4KKV(context));
            }
        }
        return sIsSupport4K.booleanValue();
    }

    public static void ensurePhoneInfo() {
        if (sPhoneModel != null) {
            return;
        }
        try {
            sCpuName = IjkCpuInfo.getCpuName();
            sPhoneModel = Build.MODEL;
            BLog.i(TAG, "device cpuName:" + sCpuName + " model:" + sPhoneModel);
        } catch (Exception e) {
        }
    }

    public static Boolean couldUseDolbyVisionHW() {
        ensurePhoneInfo();
        try {
        } catch (JSONException e) {
            e.printStackTrace();
            BLog.e(TAG, "pares dolbyvision hw black list json array error !" + e.getMessage());
        }
        if (TextUtils.isEmpty(sCpuName)) {
            return true;
        }
        String jsonString = (String) ConfigManager.config().get("ijkplayer.disable_dolbyvision_hw_list", (Object) null);
        if (TextUtils.isEmpty(jsonString)) {
            return true;
        }
        JSONArray array = new JSONArray(jsonString);
        for (int i = 0; i < array.length(); i++) {
            JSONObject device = array.getJSONObject(i);
            String model = device.getString("model");
            String cpuName = device.getString("cpuName");
            if (TextUtils.isEmpty(model)) {
                if (TextUtils.equals(sCpuName.toLowerCase(), cpuName.toLowerCase())) {
                    BLog.i(TAG, "disable dolbyvision hw decoder!");
                    return false;
                }
            } else if (TextUtils.equals(sPhoneModel.toLowerCase(), model.toLowerCase()) && TextUtils.equals(sCpuName.toLowerCase(), cpuName.toLowerCase())) {
                BLog.i(TAG, "disable dolbyvision hw decoder!");
                return false;
            }
        }
        return true;
    }

    public static boolean isSupportDolbyVisionHw() {
        if (sIsSupportDolbyVisionHw == null) {
            Context context = BiliContext.application();
            if (context == null) {
                return false;
            }
            boolean z = true;
            if (!ConfigManager.ab2().getWithDefault("ff_ijkplayer_enable_dolby_hw", true)) {
                sIsSupportDolbyVisionHw = false;
            } else {
                if (!couldUseDolbyVisionHW().booleanValue() || !IjkCodecHelper.isDolbyVisionSupport((WindowManager) context.getSystemService("window"))) {
                    z = false;
                }
                sIsSupportDolbyVisionHw = Boolean.valueOf(z);
            }
        }
        if (sIsSupportDolbyVisionHw.booleanValue()) {
            return sIsSupportDolbyVisionHw.booleanValue();
        }
        return false;
    }

    private static boolean hasSupport4KKV(Context context) {
        return BLKV.getBLSharedPreferences(context, MAIN_SETTINGS_PREFERENCES_NAME, false, 0).contains(PREF_KEY_IJKPLAYER_SUPPORT_4K);
    }

    private static boolean getSupport4KKV(Context context) {
        return BLKV.getBLSharedPreferences(context, MAIN_SETTINGS_PREFERENCES_NAME, false, 0).getBoolean(PREF_KEY_IJKPLAYER_SUPPORT_4K, false);
    }

    private static boolean initAndSaveSupport4KKV(Context context) {
        boolean support = IjkCodecHelper.isUhdSupport();
        BLKV.getBLSharedPreferences(context, MAIN_SETTINGS_PREFERENCES_NAME, false, 0).edit().putBoolean(PREF_KEY_IJKPLAYER_SUPPORT_4K, support).apply();
        return support;
    }

    public static int getIjkVodTcpReadWriteTimeout() {
        return getConfigIntFawkes("ijkplayer.ijk_vod_tcp_read_timeout", 1000000);
    }

    @Deprecated
    public static Boolean enableBufferingImprove() {
        return Boolean.valueOf(ConfigManager.ab().get("ijkplayer.buffering_improve_v1", true) == Boolean.TRUE);
    }

    public static boolean getIjkEnableAndroidVariableCodec() {
        int rate = getConfigInt("android-variable-codec", 0);
        if (isInBlackList()) {
            return false;
        }
        return rate % IjkMediaCodecInfo.RANK_MAX == 0 || myRate() % IjkMediaCodecInfo.RANK_MAX <= rate;
    }

    private static boolean isH265CpuInBlackList() {
        String blacklist = getConfigStringFawkes("ijkplayer.h265-cpu-blacklist", "");
        String cpuName = IjkCpuInfo.getCpuName();
        BLog.i(TAG, "cpuName: " + cpuName + " blacklist: " + blacklist);
        if (!TextUtils.isEmpty(blacklist) && !TextUtils.isEmpty(cpuName) && blacklist.toLowerCase().contains(cpuName.toLowerCase())) {
            return true;
        }
        return false;
    }

    public static boolean isModeIn8KWhiteList(String mode) {
        if (TextUtils.isEmpty(mode)) {
            return false;
        }
        String whiteList = getConfigStringFawkes("ijkplayer.8k_support_white_list", "");
        if (TextUtils.isEmpty(whiteList)) {
            return false;
        }
        String[] whiteArray = whiteList.split(";");
        for (String s : whiteArray) {
            if (s.equals(mode)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean getIjkenableVariableBufferV2() {
        return false;
    }

    @Deprecated
    public static String getIjkVariableBufferString() {
        return getConfigString("android_buffer_config", "");
    }

    private static String getConfigStringFawkes(String key, String def) {
        return (String) ConfigManager.config().get(key, def);
    }

    public static boolean getVolumeBalance() {
        IPlayerRemoteSetting playerSetting = (IPlayerRemoteSetting) BLRouter.INSTANCE.get(IPlayerRemoteSetting.class, "player_remote_setting");
        return playerSetting != null && Boolean.TRUE.equals(ConfigManager.ab().get("player.volume.balance", false)) && playerSetting.enableVolumeBalance();
    }

    public static IjkMediaConfigParams.LoudnormType getVolumeBalanceType() {
        IPlayerRemoteSetting playerSetting = (IPlayerRemoteSetting) BLRouter.INSTANCE.get(IPlayerRemoteSetting.class, "player_remote_setting");
        if (playerSetting == null || !getVolumeBalance()) {
            return IjkMediaConfigParams.LoudnormType.LOUDNORM_NONE;
        }
        long mode = playerSetting.volumeBalanceMode();
        if (mode == 1) {
            return IjkMediaConfigParams.LoudnormType.LOUDNORM_HIGH_DYNAMIC_TYPE;
        }
        return IjkMediaConfigParams.LoudnormType.LOUDNORM_NORMAL_TYPE;
    }

    private static int getConfigIntFawkes(String key, int def) {
        String value = (String) ConfigManager.config().get(key, String.valueOf(def));
        if (value == null) {
            return def;
        }
        try {
            int intValue = Integer.parseInt(value);
            return intValue;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return def;
        }
    }

    private static boolean isInBlackList() {
        String blacklist = getConfigString("android-variable-codec-black-list", "");
        String cpuName = IjkCpuInfo.getCpuName();
        boolean z = true;
        boolean result = false | (Build.MODEL != null && Build.MODEL.toLowerCase().contains("huawei p7"));
        if (TextUtils.isEmpty(cpuName) || TextUtils.isEmpty(blacklist) || !blacklist.toLowerCase().contains(cpuName.toLowerCase())) {
            z = false;
        }
        boolean result2 = result | z;
        if (!TextUtils.isEmpty(blacklist)) {
            blacklist.toLowerCase().contains("android6.0");
        }
        return result2 | false;
    }

    private static int myRate() {
        int rate = sRate;
        if (rate == -1) {
            String buvid = getBuvid();
            if (TextUtils.isEmpty(buvid)) {
                return rate;
            }
            Adler32 sum = new Adler32();
            sum.update(buvid.getBytes());
            int rate2 = Math.abs((int) sum.getValue());
            sRate = rate2;
            return rate2;
        }
        return rate;
    }

    public static String getBuvid() {
        return BuvidHelper.getBuvid();
    }

    public static void setHevcEnable(Context context, boolean enable) {
        BLKV.getBLSharedPreferences(context.getApplicationContext(), MAIN_SETTINGS_PREFERENCES_NAME, false, 0).edit().putBoolean(PREF_KEY_IJKPLAYER_ENABLE_HEVC, enable).apply();
    }

    public static synchronized boolean isHevcEnable(Context context) {
        Boolean enableHevc;
        boolean booleanValue;
        synchronized (IjkOptionsHelper.class) {
            Boolean.valueOf(false);
            if (h265Flag == 0) {
                initHevcEnableState(context);
                enableHevc = Boolean.valueOf(BLKV.getBLSharedPreferences(context.getApplicationContext(), MAIN_SETTINGS_PREFERENCES_NAME, false, 0).getBoolean(PREF_KEY_IJKPLAYER_ENABLE_HEVC, false));
            } else if (h265Flag > 0) {
                enableHevc = true;
            } else {
                enableHevc = false;
            }
            BLog.i(TAG, "isHevcEnable: " + enableHevc);
            booleanValue = enableHevc.booleanValue();
        }
        return booleanValue;
    }

    public static synchronized void initHevcEnableState(Context context) {
        synchronized (IjkOptionsHelper.class) {
            if (h265Flag == 0) {
                isAvcSupport();
                if (isHevcSupport()) {
                    setHevcEnable(context, true);
                    h265Flag = 1;
                } else {
                    setHevcEnable(context, false);
                    h265Flag = -1;
                }
                isAv1Support();
            }
        }
    }

    public static int isSupportSuperResolution() {
        return (((Boolean) ConfigManager.ab().get("ijkplayer.oppo-osie-sr", false)).booleanValue() && "oppo".equalsIgnoreCase(Build.BRAND)) ? 1 : 0;
    }

    public static boolean isInP2PWhiteList() {
        return (((Boolean) ConfigManager.ab().get("grpc_fallback", false)).booleanValue() || ((Boolean) ConfigManager.ab().get(P2P.KEY_EXT_P2P_DISABLE_BLACKLIST, false)).booleanValue()) ? false : true;
    }

    public static boolean deviceDowngrade() {
        CpuUtils.ARCH arch = CpuUtils.getMyCpuArch();
        boolean z = false;
        Boolean x86 = Boolean.valueOf(arch == CpuUtils.ARCH.X86 || arch == CpuUtils.ARCH.X86_64);
        if (x86.booleanValue() && ((Boolean) ConfigManager.ab().get("ijkplayer.p2p_x86_downgrade_enable", true)).booleanValue()) {
            z = true;
        }
        Boolean downgrade = Boolean.valueOf(z);
        if (downgrade.booleanValue()) {
            BLog.i(TAG, "deviceDowngrade: p2p device downgrade");
        }
        return downgrade.booleanValue();
    }

    public static boolean isEnableP2P() {
        return ((Boolean) ConfigManager.ab().get(P2P.KEY_EXT_P2P_DOWNLOAD, false)).booleanValue();
    }

    public static Boolean getIjkVariableSeekBuffer() {
        return Boolean.valueOf(ConfigManager.ab().get("ijkplayer.variable-seek-buffer", false) == Boolean.TRUE);
    }

    public static int getAccurateSeekTimeout() {
        return getConfigIntFawkes("ijkplayer.accurate-seek-timeout", 500);
    }

    public static Boolean isDoblyCheckMediacodec() {
        return Boolean.valueOf(ConfigManager.ab().get("ijkplayer.dobly_check_mediacodec", false) == Boolean.TRUE);
    }

    @Deprecated
    public static Boolean isEnableHighFps() {
        return Boolean.valueOf(ConfigManager.ab().get("ijkplayer.enable-high-fps", false) == Boolean.TRUE);
    }

    public static Boolean isEnableStoryP2PDownload() {
        return Boolean.valueOf(ConfigManager.ab().get("ijkplayer.story_p2p_download", false) == Boolean.TRUE);
    }

    public static String getUnusedLowLatencyCodecList() {
        return getConfigStringFawkes("ijkplayer.android_not_use_low_latency_codec", "");
    }

    public static boolean getAlignSurfaceEnable() {
        return getConfigIntFawkes("ijkplayer.ijk_align_surface_enable", 0) == 0;
    }

    public static int getLiveHeartbeatInterval() {
        return getConfigIntFawkes("ijkplayer.live_heartbeat_interval", 60000);
    }

    public static Boolean isEnableReportWidevineType() {
        return Boolean.valueOf(ConfigManager.ab().get("ijkplayer.enable_report_widevine_type", false) == Boolean.TRUE);
    }

    public static long getMaxCacheSize() {
        return getConfigIntFawkes("ijkplayer.max-cache-size", 0);
    }

    public static boolean isEnableMaxCacheSize() {
        return ConfigManager.ab().get("ijkplayer.enable-max-cache-size", true) == Boolean.TRUE;
    }

    public static boolean isEnableLiveStorySoftReconnect() {
        return ConfigManager.ab().get("ijkplayer.enable-story-live-soft-reconnect", true) == Boolean.TRUE;
    }

    public static boolean isDisableLiveStoryDiscontinueWhenEOF() {
        return ConfigManager.ab().get("ijkplayer.disable-live-story-discontinue-when-eof", true) == Boolean.TRUE;
    }

    public static boolean isEnableAmendExternalClock() {
        return ConfigManager.ab().get("ijkplayer.enable-amend-external-clock", false) == Boolean.TRUE;
    }

    public static boolean isEnableIgnoreOnlyVideoBufferingReport() {
        return ConfigManager.ab().get("ijkplayer.enable-ignore-only-video-buffering-report", false) == Boolean.TRUE;
    }

    public static boolean isEnableIgnoreDiscardPkt() {
        return ConfigManager.ab().get("ijkplayer.enable_ignore_discard_pkt", false) == Boolean.TRUE;
    }

    public static boolean isEnableColdStartCheck4K() {
        return ConfigManager.ab().get("ijkplayer.enable_cold_start_check_4k", false) == Boolean.TRUE;
    }

    public static boolean isHevcSupport() {
        if (isH265CpuInBlackList()) {
            return false;
        }
        String codecName = IjkCodecHelper.getBestCodecNameEnter("video/hevc");
        BLog.i(TAG, "isHevcSupport:  " + codecName);
        boolean WeakH265Disable = getConfigIntFawkes("ijkplayer.disable-weak-h265", 0) != 0;
        BLog.i(TAG, "WeakH265Disable: " + WeakH265Disable);
        if (WeakH265Disable) {
            return IjkCodecHelper.isCodecSupport(codecName, "video/hevc", IjkCodecHelper.IJKCODEC_H265_WIDTH, IjkCodecHelper.IJKCODEC_H265_HEIGHT, IjkCodecHelper.IJKCODEC_H265_BITRATE);
        }
        return !TextUtils.isEmpty(codecName);
    }

    public static boolean isAvcSupport() {
        String codecName = IjkCodecHelper.getBestCodecNameEnter("video/avc");
        BLog.i(TAG, "isAvcSupport:  " + codecName);
        if (!TextUtils.isEmpty(codecName)) {
            return true;
        }
        return false;
    }

    public static boolean isAv1Support() {
        String codecName = IjkCodecHelper.getBestCodecNameEnter("video/av01");
        BLog.i(TAG, "isAv1Support:  " + codecName);
        if (!TextUtils.isEmpty(codecName)) {
            return true;
        }
        return false;
    }

    public static void applyLooperFilter(IjkMediaConfigParams configParams, int loopFilter) {
        boolean isLowProfileHardware = isLowProfileHardware();
        if (isLowProfileHardware) {
            configParams.mSkipLoopFilter = 32L;
            configParams.mSkipFrame = 8L;
            return;
        }
        switch (loopFilter) {
            case -1:
                configParams.mSkipLoopFilter = 0L;
                configParams.mSkipFrame = 0L;
                return;
            case 0:
            default:
                configParams.mSkipLoopFilter = v_avdiscard_all;
                configParams.mSkipFrame = 0L;
                return;
            case 1:
                configParams.mSkipLoopFilter = 8L;
                configParams.mSkipFrame = 8L;
                return;
            case 2:
                configParams.mSkipLoopFilter = 16L;
                configParams.mSkipFrame = 8L;
                return;
            case 3:
                configParams.mSkipLoopFilter = 32L;
                configParams.mSkipFrame = 8L;
                return;
            case 4:
                configParams.mSkipLoopFilter = v_avdiscard_all;
                configParams.mSkipFrame = 8L;
                return;
        }
    }

    private static boolean isLowProfileHardware() {
        String[] abis = BuildHelper.getCpuAbis();
        for (String abi : abis) {
            if (StringUtils.equalsIgnoreCase(abi, "x86") || StringUtils.equalsIgnoreCase(abi, "x86_64") || StringUtils.equalsIgnoreCase(abi, "arm64-v8a")) {
                return false;
            }
            if (StringUtils.equalsIgnoreCase(abi, "armeabi-v7a")) {
                CpuInfo cpuInfo = CpuInfo.parseCpuInfo();
                if (cpuInfo == null) {
                    return false;
                }
                return !cpuInfo.supportNeon() || cpuInfo.isCortexA5() || cpuInfo.isCortexA8() || cpuInfo.isSnapdragon_S1();
            }
        }
        return true;
    }

    public static boolean isSupportHDR(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService("window");
        return IjkCodecHelper.isHDRSupport(wm);
    }

    public static void preloadOptions(Context context, IjkMediaConfigParams ijkMediaConfigParams) {
        BLog.i(TAG, "preloadOptions start");
        long startTime = SystemClock.elapsedRealtime();
        ijkMediaConfigParams.mTcpReadWriteTimeOut = getIjkVodTcpReadWriteTimeout();
        ijkMediaConfigParams.mEnableDecodeSwitch = getIjkEnableAndroidVariableCodec();
        ijkMediaConfigParams.mDoblyCheckMediaCodec = isDoblyCheckMediacodec().booleanValue();
        ijkMediaConfigParams.mEnableStoryP2PDownload = isEnableStoryP2PDownload().booleanValue();
        ijkMediaConfigParams.mUnusedLowLatencyCodecList = getUnusedLowLatencyCodecList();
        ijkMediaConfigParams.mDisableSurfaceAlign = getAlignSurfaceEnable();
        if (isEnableMaxCacheSize()) {
            ijkMediaConfigParams.mMaxCacheSize = getMaxCacheSize();
        }
        isAvcSupport();
        if (isHevcSupport()) {
            setHevcEnable(context, true);
        } else {
            setHevcEnable(context, false);
        }
        isAv1Support();
        isSupport4K();
        isSupportHDR(context);
        ijkMediaConfigParams.mEnableH265Codec = isHevcEnable(context);
        ijkMediaConfigParams.mEnableVariableSeekBuffer = getIjkVariableSeekBuffer().booleanValue();
        ijkMediaConfigParams.mAccurateSeekTimeout = getAccurateSeekTimeout();
        ijkMediaConfigParams.mSuperResolution = isSupportSuperResolution();
        ijkMediaConfigParams.mEnableAmendExternalClock = isEnableAmendExternalClock();
        ijkMediaConfigParams.mEnableIgnoreOnlyVideoBufferingReport = isEnableIgnoreOnlyVideoBufferingReport();
        ijkMediaConfigParams.mEnableIgnoreDiscardPkt = isEnableIgnoreDiscardPkt();
        BLog.i(TAG, "preloadOptions end duration = " + (SystemClock.elapsedRealtime() - startTime));
    }
}