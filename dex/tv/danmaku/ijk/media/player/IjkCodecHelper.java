package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.utils.IjkDrmUtils;
import tv.danmaku.ijk.media.player.utils.IjkUtils;

public class IjkCodecHelper {
    private static final int FLAG_DOLBY_HLG = 64;
    private static final int FLAG_DOLBY_PROFILE5 = 32;
    private static final int FLAG_DOLBY_VISION = 2;
    private static final int FLAG_DRM = 4;
    private static final int FLAG_HDR = 1;
    private static final int FLAG_HDR_HLG = 16;
    private static final int FLAG_HDR_VIVID = 8;
    private static final String HARMONY_OS = "harmony";
    private static final int IJKCODEC_DEFAULT_SUPPORT_FRAMERATE = 30;
    public static final int IJKCODEC_H265_BITRATE = 6000000;
    public static final int IJKCODEC_H265_HEIGHT = 1080;
    public static final int IJKCODEC_H265_WIDTH = 1920;
    private static final int IJKCODEC_UHD_HEIGHT = 2160;
    private static final int IJKCODEC_UHD_WIDTH = 3840;
    private static final String TAG = "IjkCodecHelper";
    private static boolean IJKCODEC_MEDIACODEC = false;
    private static String IJKCODEC_NAME = null;
    private static HashMap<String, Pair<String, String>> sCodecMimeToNameMap = new HashMap<>();
    private static HashMap<String, Boolean> sUhdSupportMap = new HashMap<>();
    private static HashMap<String, List<String>> sUnusedLowLatency = new HashMap<>();
    private static boolean sIsHdrChecked = false;
    private static boolean sIsSupportHDR = false;
    private static boolean sIsHlgChecked = false;
    private static boolean sIsSupportHLG = false;
    private static boolean sIsDolbyVisionChecked = false;
    private static boolean sIsSupportDolbyVision = false;
    private static volatile int cachedCapability = -1;
    private static volatile int sHdrVividSupportCache = -1;

    private static String getBestCodecNameInner(String mimeType, int profile, int level) {
        IjkMediaCodecInfo bestCodec = getBestCodec(mimeType, profile, level);
        if (bestCodec == null || bestCodec.mCodecInfo == null) {
            return null;
        }
        if (bestCodec.mRank < 600) {
            Log.w(TAG, String.format(Locale.US, "unaccetable codec: %s", bestCodec.mCodecInfo.getName()));
            return null;
        }
        String bestCodecName = bestCodec.mCodecInfo.getName();
        BLog.i(TAG, "bestCodec for " + mimeType + " : " + bestCodecName);
        return bestCodecName;
    }

    private static void removeNameFromMap(String name) {
        Iterator<Map.Entry<String, Pair<String, String>>> iterator = sCodecMimeToNameMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Pair<String, String>> entry = iterator.next();
            String codec = (String) entry.getValue().second;
            if (!TextUtils.isEmpty(codec) && codec.contains(name)) {
                iterator.remove();
            }
        }
    }

    private static void updateCodecMap() {
        if (isUnusedLowLatency()) {
            removeNameFromMap("low_latency");
        }
    }

    public static String getBestCodecNameEnter(String mimeType) {
        return getBestCodecNameWithProfile(mimeType, 0, 0);
    }

    public static String getBestCodecNameWithProfile(String mimeType, int profile, int level) {
        if (TextUtils.isEmpty(mimeType)) {
            return "";
        }
        synchronized (IjkCodecHelper.class) {
            updateCodecMap();
            if (sCodecMimeToNameMap.containsKey(mimeType)) {
                return (String) sCodecMimeToNameMap.get(mimeType).second;
            }
            String codecName = getBestCodecNameInner(mimeType, profile, level);
            synchronized (IjkCodecHelper.class) {
                BLog.i(TAG, "get best codec name " + mimeType + " : " + codecName);
                sCodecMimeToNameMap.put(mimeType, Pair.create("", codecName));
            }
            return codecName;
        }
    }

    public static IjkMediaCodecInfo getBestCodec(String mimeType, int profile, int level) {
        int numCodecs;
        int numCodecs2;
        MediaCodecInfo codecInfo;
        char c;
        if (TextUtils.isEmpty(mimeType)) {
            return null;
        }
        try {
            int numCodecs3 = MediaCodecList.getCodecCount();
            TreeMap<Integer, IjkMediaCodecInfo> candidateCodecList = new TreeMap<>();
            int i = 0;
            while (i < numCodecs3) {
                MediaCodecInfo codecInfo2 = MediaCodecList.getCodecInfoAt(i);
                int i2 = 1;
                char c2 = 0;
                BLog.d(TAG, String.format(Locale.US, "  found codec: %s", codecInfo2.getName()));
                if (codecInfo2.isEncoder()) {
                    numCodecs = numCodecs3;
                } else {
                    String[] types = codecInfo2.getSupportedTypes();
                    if (types == null) {
                        numCodecs = numCodecs3;
                    } else {
                        int length = types.length;
                        int i3 = 0;
                        while (i3 < length) {
                            String type = types[i3];
                            if (TextUtils.isEmpty(type)) {
                                numCodecs2 = numCodecs3;
                                codecInfo = codecInfo2;
                                c = c2;
                            } else {
                                Locale locale = Locale.US;
                                Object[] objArr = new Object[i2];
                                objArr[c2] = type;
                                BLog.d(TAG, String.format(locale, "    mime: %s", objArr));
                                if (type.equalsIgnoreCase(mimeType)) {
                                    IjkMediaCodecInfo candidate = IjkMediaCodecInfo.setupCandidate(codecInfo2, mimeType, profile, level);
                                    if (candidate == null) {
                                        numCodecs2 = numCodecs3;
                                        codecInfo = codecInfo2;
                                        c = c2;
                                    } else {
                                        candidateCodecList.put(Integer.valueOf(candidate.mRank), candidate);
                                        if (Build.VERSION.SDK_INT >= 29) {
                                            numCodecs2 = numCodecs3;
                                            BLog.i(TAG, String.format(Locale.US, "candidate codec: %s rank=%d, isSoftwareOnly=%b, isHardwareAccelerated=%b, type=%s", codecInfo2.getName(), Integer.valueOf(candidate.mRank), Boolean.valueOf(codecInfo2.isSoftwareOnly()), Boolean.valueOf(codecInfo2.isHardwareAccelerated()), type));
                                            codecInfo = codecInfo2;
                                            i2 = 1;
                                            c = 0;
                                        } else {
                                            numCodecs2 = numCodecs3;
                                            codecInfo = codecInfo2;
                                            c = 0;
                                            i2 = 1;
                                            BLog.i(TAG, String.format(Locale.US, "candidate codec: %s rank=%d, type=%s", codecInfo2.getName(), Integer.valueOf(candidate.mRank), type));
                                        }
                                        candidate.dumpProfileLevels(mimeType);
                                    }
                                } else {
                                    numCodecs2 = numCodecs3;
                                    codecInfo = codecInfo2;
                                    c = c2;
                                }
                            }
                            i3++;
                            c2 = c;
                            codecInfo2 = codecInfo;
                            numCodecs3 = numCodecs2;
                        }
                        numCodecs = numCodecs3;
                    }
                }
                try {
                    i++;
                    numCodecs3 = numCodecs;
                } catch (Exception e) {
                    e = e;
                    BLog.e(TAG, "MediaCodec Error: " + e);
                    return null;
                }
            }
            Map.Entry<Integer, IjkMediaCodecInfo> bestEntry = candidateCodecList.lastEntry();
            if (bestEntry == null) {
                return null;
            }
            return bestEntry.getValue();
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static boolean isCodecSupport(String codecName, String mimeType, int width, int height, int bitrate) {
        MediaCodecInfo.CodecCapabilities caps;
        MediaCodecInfo.VideoCapabilities video_caps;
        if (TextUtils.isEmpty(codecName)) {
            return false;
        }
        try {
            int numCodecs = MediaCodecList.getCodecCount();
            for (int i = 0; i < numCodecs; i++) {
                MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
                if (!codecInfo.isEncoder() && !TextUtils.isEmpty(codecInfo.getName()) && codecInfo.getName().equals(codecName) && (caps = codecInfo.getCapabilitiesForType(mimeType)) != null && (video_caps = caps.getVideoCapabilities()) != null) {
                    BLog.i(TAG, "codecName: " + codecName + " width " + video_caps.getSupportedWidths() + " height " + video_caps.getSupportedHeights() + " bitrate " + video_caps.getBitrateRange() + " framerate " + video_caps.getSupportedFrameRates());
                    if (video_caps.isSizeSupported(width, height)) {
                        if (video_caps.getBitrateRange().contains((Range<Integer>) Integer.valueOf(bitrate))) {
                            return true;
                        }
                    }
                    return false;
                }
            }
        } catch (Exception e) {
            BLog.e(TAG, "MediaCodec Error: " + e);
        }
        return false;
    }

    public static boolean isUhdSupport(String codecName, String mimeType) {
        return isCodecSupport(codecName, mimeType, IJKCODEC_UHD_WIDTH, IJKCODEC_UHD_HEIGHT, IJKCODEC_H265_BITRATE);
    }

    public static boolean isUhdSupport() {
        String hevcCodecName = getBestCodecNameEnter("video/hevc");
        if (TextUtils.isEmpty(hevcCodecName)) {
            return false;
        }
        if (sUhdSupportMap.containsKey(hevcCodecName)) {
            return sUhdSupportMap.get(hevcCodecName) == Boolean.TRUE;
        }
        boolean uhdSupport = isUhdSupport(hevcCodecName, "video/hevc");
        sUhdSupportMap.put(hevcCodecName, Boolean.valueOf(uhdSupport));
        return uhdSupport;
    }

    public static boolean isLiveAv1Support() {
        if (!AbrParamsInterface.IsEnableLiveAv1()) {
            return false;
        }
        String codecName = getBestCodecNameEnter("video/av01");
        BLog.i(TAG, "isLiveAv1Support: " + codecName);
        return !TextUtils.isEmpty(codecName);
    }

    public static boolean isAv1Support() {
        if (!AbrParamsInterface.IsEnableVodAv1()) {
            return false;
        }
        return isAv1SupportInternal();
    }

    public static boolean isAv1SupportInternal() {
        if (Build.VERSION.SDK_INT <= 30) {
            return false;
        }
        String codecName = getBestCodecNameEnter("video/av01");
        BLog.i(TAG, "isAv1SupportInternal: " + codecName);
        return !TextUtils.isEmpty(codecName);
    }

    public static boolean isAv1SupportSoft(Context context) {
        IjkDeviceScoreInfo deviceScoreInfo;
        if (!AbrParamsInterface.IsEnableAv1SwCodec() || isAv1SupportInternal() || (deviceScoreInfo = IjkDeviceScoreInfo.getInstance(context)) == null) {
            return false;
        }
        float mDevicePerformanceScore = deviceScoreInfo.getTotalScore();
        int minDeviceScore = AbrParamsInterface.getAv1SoftMinDeviceScore();
        boolean isSupport = mDevicePerformanceScore > ((float) minDeviceScore);
        BLog.i(TAG, String.format("[softStrategy] isAv1SupportSoft: %b, deviceScore(%d vs. %d)", Boolean.valueOf(isSupport), Integer.valueOf((int) mDevicePerformanceScore), Integer.valueOf(minDeviceScore)));
        return isSupport;
    }

    public static boolean isH266SupportSoft(Context context) {
        IjkDeviceScoreInfo deviceScoreInfo;
        if (AbrParamsInterface.IsEnableH266SwCodec() && (deviceScoreInfo = IjkDeviceScoreInfo.getInstance(context)) != null) {
            float mDevicePerformanceScore = deviceScoreInfo.getTotalScore();
            int minDeviceScore = AbrParamsInterface.getH266SoftMinDeviceScore();
            boolean isSupport = mDevicePerformanceScore > ((float) minDeviceScore);
            BLog.i(TAG, String.format("[softStrategy] isH266SupportSoft: %b, deviceScore(%d vs. %d)", Boolean.valueOf(isSupport), Integer.valueOf((int) mDevicePerformanceScore), Integer.valueOf(minDeviceScore)));
            return isSupport;
        }
        return false;
    }

    public static boolean isHDRSupport(WindowManager windowManager) {
        boolean isCodecSupport;
        int i = 0;
        if (Build.VERSION.SDK_INT >= 24 && windowManager != null) {
            if (sIsHdrChecked) {
                return sIsSupportHDR;
            }
            if (IjkUtils.isContainThisPhone("player.hdr_device_blacklist", false)) {
                sIsHdrChecked = true;
                sIsSupportHDR = false;
                BLog.i(TAG, "in HDR black list:");
                return sIsSupportHDR;
            }
            boolean isDisplaySupport = false;
            boolean isCodecSupport2 = false;
            try {
                int[] result = windowManager.getDefaultDisplay().getHdrCapabilities().getSupportedHdrTypes();
                for (int i2 : result) {
                    if (i2 == 2) {
                        isDisplaySupport = true;
                    }
                }
                isCodecSupport = false;
                int i3 = 0;
                while (i3 < MediaCodecList.getCodecCount()) {
                    try {
                        MediaCodecInfo info = MediaCodecList.getCodecInfoAt(i3);
                        if (!info.isEncoder()) {
                            String[] types = info.getSupportedTypes();
                            boolean isCodecSupport3 = isCodecSupport;
                            int j = 0;
                            while (j < types.length) {
                                try {
                                    if (types[j].equalsIgnoreCase("video/hevc")) {
                                        MediaCodecInfo.CodecCapabilities capabilities = null;
                                        try {
                                            capabilities = info.getCapabilitiesForType("video/hevc");
                                        } catch (Exception e) {
                                        }
                                        if (capabilities != null) {
                                            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilities.profileLevels;
                                            int length = codecProfileLevelArr.length;
                                            for (int i4 = i; i4 < length; i4++) {
                                                MediaCodecInfo.CodecProfileLevel level = codecProfileLevelArr[i4];
                                                if (level.profile == 4096) {
                                                    isCodecSupport3 = true;
                                                }
                                            }
                                        }
                                    }
                                    j++;
                                    i = 0;
                                } catch (Exception e2) {
                                    e = e2;
                                    isCodecSupport2 = isCodecSupport3;
                                    BLog.e(e.getMessage());
                                    isCodecSupport = isCodecSupport2;
                                    sIsHdrChecked = true;
                                    sIsSupportHDR = !isCodecSupport && isDisplaySupport;
                                    BLog.i(TAG, "isHDR10 Support: " + sIsSupportHDR + " isCodecSupport:" + isCodecSupport + " display support:" + isDisplaySupport);
                                    return sIsSupportHDR;
                                }
                            }
                            isCodecSupport = isCodecSupport3;
                        }
                        i3++;
                        i = 0;
                    } catch (Exception e3) {
                        e = e3;
                        isCodecSupport2 = isCodecSupport;
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
            sIsHdrChecked = true;
            sIsSupportHDR = !isCodecSupport && isDisplaySupport;
            BLog.i(TAG, "isHDR10 Support: " + sIsSupportHDR + " isCodecSupport:" + isCodecSupport + " display support:" + isDisplaySupport);
            return sIsSupportHDR;
        }
        return false;
    }

    public static boolean isHLGSupport(WindowManager windowManager) {
        boolean isCodecSupport;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24 && windowManager != null) {
            if (sIsHlgChecked) {
                return sIsSupportHLG;
            }
            boolean isDisplaySupport = false;
            boolean isCodecSupport2 = false;
            try {
                int[] result = windowManager.getDefaultDisplay().getHdrCapabilities().getSupportedHdrTypes();
                for (int i : result) {
                    if (i == 3) {
                        isDisplaySupport = true;
                    }
                }
                isCodecSupport = false;
                for (int i2 = 0; i2 < MediaCodecList.getCodecCount(); i2++) {
                    try {
                        MediaCodecInfo info = MediaCodecList.getCodecInfoAt(i2);
                        if (!info.isEncoder()) {
                            String[] types = info.getSupportedTypes();
                            boolean isCodecSupport3 = isCodecSupport;
                            for (String str : types) {
                                try {
                                    if (str.equalsIgnoreCase("video/hevc")) {
                                        MediaCodecInfo.CodecCapabilities capabilities = null;
                                        try {
                                            capabilities = info.getCapabilitiesForType("video/hevc");
                                        } catch (Exception e) {
                                        }
                                        if (capabilities != null) {
                                            for (MediaCodecInfo.CodecProfileLevel level : capabilities.profileLevels) {
                                                if (level.profile == 2 || level.profile == 4096) {
                                                    isCodecSupport3 = true;
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    isCodecSupport2 = isCodecSupport3;
                                    BLog.e(e.getMessage());
                                    isCodecSupport = isCodecSupport2;
                                    if (isDisplaySupport) {
                                        z = true;
                                    }
                                    boolean support = z;
                                    sIsHlgChecked = true;
                                    sIsSupportHLG = support;
                                    BLog.i(TAG, "isHLGSupport: " + sIsSupportHLG + " isCodecSupport:" + isCodecSupport + " display support:" + isDisplaySupport);
                                    return sIsSupportHLG;
                                }
                            }
                            isCodecSupport = isCodecSupport3;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        isCodecSupport2 = isCodecSupport;
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
            if (isDisplaySupport && isCodecSupport) {
                z = true;
            }
            boolean support2 = z;
            sIsHlgChecked = true;
            sIsSupportHLG = support2;
            BLog.i(TAG, "isHLGSupport: " + sIsSupportHLG + " isCodecSupport:" + isCodecSupport + " display support:" + isDisplaySupport);
            return sIsSupportHLG;
        }
        return false;
    }

    public static boolean isDolbyVisionSupport(WindowManager windowManager) {
        boolean isCodecSupport;
        int i = 0;
        if (Build.VERSION.SDK_INT >= 28 && windowManager != null) {
            if (sIsDolbyVisionChecked) {
                BLog.i(TAG, "isDolbyVisionSupport sIsSupportDolbyVision:" + sIsSupportDolbyVision);
                return sIsSupportDolbyVision;
            }
            boolean isDisplaySupport = false;
            boolean isCodecSupport2 = false;
            try {
                int[] result = windowManager.getDefaultDisplay().getHdrCapabilities().getSupportedHdrTypes();
                for (int i2 : result) {
                    if (i2 == 1) {
                        isDisplaySupport = true;
                    }
                }
                isCodecSupport = false;
                int i3 = 0;
                while (i3 < MediaCodecList.getCodecCount()) {
                    try {
                        MediaCodecInfo info = MediaCodecList.getCodecInfoAt(i3);
                        if (!info.isEncoder()) {
                            String[] types = info.getSupportedTypes();
                            boolean isCodecSupport3 = isCodecSupport;
                            int j = 0;
                            while (j < types.length) {
                                try {
                                    if (types[j].equalsIgnoreCase("video/dolby-vision")) {
                                        MediaCodecInfo.CodecCapabilities capabilities = null;
                                        try {
                                            capabilities = info.getCapabilitiesForType("video/dolby-vision");
                                        } catch (Exception e) {
                                            BLog.e(TAG, "isDolbyVisionSupport getCapabilitiesForType Error: " + e);
                                        }
                                        if (capabilities != null) {
                                            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilities.profileLevels;
                                            int length = codecProfileLevelArr.length;
                                            for (int i4 = i; i4 < length; i4++) {
                                                MediaCodecInfo.CodecProfileLevel level = codecProfileLevelArr[i4];
                                                BLog.i(TAG, " isDolbyVisionSupport level.profile:" + level.profile + " level:" + level.level + " name: " + info.getName());
                                                if (level.profile == 32 || level.profile == 256 || level.profile == 2 || level.profile == 1 || level.profile == 8 || level.profile == 4 || level.profile == 128 || level.profile == 64 || level.profile == 16 || level.profile == 512 || level.profile == 1024) {
                                                    isCodecSupport3 = true;
                                                }
                                            }
                                        }
                                    }
                                    j++;
                                    i = 0;
                                } catch (Exception e2) {
                                    e = e2;
                                    isCodecSupport2 = isCodecSupport3;
                                    BLog.e(e.getMessage());
                                    isCodecSupport = isCodecSupport2;
                                    sIsDolbyVisionChecked = true;
                                    sIsSupportDolbyVision = !isCodecSupport && isDisplaySupport;
                                    BLog.i(TAG, "sIsSupportDolbyVision：" + sIsSupportDolbyVision + " isCodecSupport :" + isCodecSupport + " display support :" + isDisplaySupport);
                                    return sIsSupportDolbyVision;
                                }
                            }
                            isCodecSupport = isCodecSupport3;
                        }
                        i3++;
                        i = 0;
                    } catch (Exception e3) {
                        e = e3;
                        isCodecSupport2 = isCodecSupport;
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
            sIsDolbyVisionChecked = true;
            sIsSupportDolbyVision = !isCodecSupport && isDisplaySupport;
            BLog.i(TAG, "sIsSupportDolbyVision：" + sIsSupportDolbyVision + " isCodecSupport :" + isCodecSupport + " display support :" + isDisplaySupport);
            return sIsSupportDolbyVision;
        }
        return false;
    }

    private static Pair<Boolean, Boolean> getDolbyVisionProfileSupport() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        boolean supportP5 = false;
        boolean supportP8_4 = false;
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo info = MediaCodecList.getCodecInfoAt(i);
            if (!info.isEncoder()) {
                String[] types = info.getSupportedTypes();
                for (String type : types) {
                    if ("video/dolby-vision".equalsIgnoreCase(type)) {
                        MediaCodecInfo.CodecCapabilities caps = null;
                        try {
                            caps = info.getCapabilitiesForType("video/dolby-vision");
                        } catch (Exception e) {
                        }
                        if (caps != null) {
                            for (MediaCodecInfo.CodecProfileLevel pl : caps.profileLevels) {
                                supportP5 = (pl.profile == 32 || pl.profile == 512) ? true : true;
                                if (pl.profile == 256) {
                                    supportP8_4 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return Pair.create(Boolean.valueOf(supportP5), Boolean.valueOf(supportP8_4));
    }

    public static double getSupportFrameRateForSize(String mime, int width, int height) {
        double maxSupport = 0.0d;
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo info = MediaCodecList.getCodecInfoAt(i);
            if (!info.isEncoder()) {
                String[] types = info.getSupportedTypes();
                for (String str : types) {
                    if (str.equalsIgnoreCase(mime)) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilities = info.getCapabilitiesForType(mime);
                            Range<Double> frameRateRange = capabilities.getVideoCapabilities().getAchievableFrameRatesFor(width, height);
                            if (frameRateRange != null) {
                                maxSupport = Math.max(frameRateRange.getUpper().doubleValue(), maxSupport);
                                BLog.i(TAG, "getSupportFrameRate  frameRate : " + maxSupport);
                            }
                        } catch (Exception e) {
                            BLog.i(TAG, "getSupportFrameRate  getAchievableFrameRatesFor error : " + e.getMessage() + " codec:" + info.getName());
                        }
                    }
                }
            }
        }
        return maxSupport;
    }

    public static boolean isEac3Support() {
        if (!IJKCODEC_MEDIACODEC) {
            return true;
        }
        return isEac3MediaCodecSupport();
    }

    public static boolean isEac3MediaCodecSupport() {
        if (IJKCODEC_NAME != null) {
            return true;
        }
        MediaCodecInfo codecInfo = null;
        MediaCodecInfo.CodecCapabilities capabilities = null;
        int i = 0;
        while (true) {
            if (i >= MediaCodecList.getCodecCount()) {
                break;
            }
            codecInfo = MediaCodecList.getCodecInfoAt(i);
            try {
            } catch (Exception e) {
                BLog.i(TAG, "MediaCodecInfo  getCapabilitiesForType error : " + e.getMessage());
            }
            if (codecInfo.isEncoder()) {
                i++;
            } else {
                capabilities = codecInfo.getCapabilitiesForType("audio/eac3");
                break;
            }
        }
        if (capabilities != null) {
            IJKCODEC_NAME = codecInfo.getName();
            BLog.i(TAG, "dobly codec name is " + codecInfo.getName() + " .");
            return true;
        }
        return false;
    }

    public static void addUnusedLowLatencyDevices(String json) {
        try {
            if (TextUtils.isEmpty(json)) {
                return;
            }
            JSONArray jsonArray = new JSONArray(json);
            addUnusedLowLatencyDevices(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
            BLog.e("pares unused low latency json array error !" + e.getMessage());
        }
    }

    public static void addUnusedLowLatencyDevices(JSONArray array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length(); i++) {
            try {
                JSONObject entity = array.getJSONObject(i);
                String model = entity.getString("model");
                String brand = entity.getString("brand");
                if (!TextUtils.isEmpty(model) && !TextUtils.isEmpty(brand)) {
                    String model2 = model.toLowerCase();
                    String brand2 = brand.toLowerCase();
                    if (!sUnusedLowLatency.containsKey(brand2)) {
                        List<String> modeList = new ArrayList<>();
                        modeList.add(model2);
                        sUnusedLowLatency.put(brand2, modeList);
                    } else {
                        List<String> modeList2 = sUnusedLowLatency.get(brand2);
                        if (!modeList2.contains(model2)) {
                            modeList2.add(model2);
                        }
                    }
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                BLog.e("pares unused low latency json array error !" + e.getMessage());
                return;
            }
        }
    }

    public static boolean isUnusedLowLatency() {
        try {
            String brand = Build.BRAND.toLowerCase();
            String model = Build.MODEL.toLowerCase();
            if (sUnusedLowLatency.containsKey(brand)) {
                List<String> modeList = sUnusedLowLatency.get(brand);
                if (modeList.contains("*")) {
                    BLog.i(TAG, " isUnusedLowLatency true model: *  brand :" + brand);
                    return true;
                }
                boolean result = modeList.contains(model);
                if (result) {
                    BLog.i(TAG, " isUnusedLowLatency true model: " + model + " brand :" + brand);
                }
                return result;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            BLog.e("get isUnusedLowLatency  error !" + e.getMessage());
            return false;
        }
    }

    public static boolean isHarmonyOS() {
        try {
            Class clz = Class.forName("com.huawei.system.BuildEx");
            Method method = clz.getMethod("getOsBrand", new Class[0]);
            return HARMONY_OS.equals(method.invoke(clz, new Object[0]));
        } catch (ClassNotFoundException e) {
            BLog.e(TAG, "occured ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException e2) {
            BLog.e(TAG, "occured NoSuchMethodException");
            return false;
        } catch (Exception e3) {
            BLog.e(TAG, "occured other problem");
            return false;
        }
    }

    public static String getHarmonyOS() {
        try {
            Class<?> S = Class.forName("android.os.SystemProperties");
            Method[] M = S.getMethods();
            Method getMethod = null;
            for (Method m : M) {
                String n = m.getName();
                if (n.equals("get")) {
                    getMethod = m;
                }
            }
            if (getMethod != null) {
                String version = (String) getMethod.invoke(null, "hw_sc.build.platform.version", "");
                return version;
            }
            return "0.0.0";
        } catch (Exception e) {
            BLog.e(TAG, "getHarmonyOSVersion error");
            return "0.0.0";
        }
    }

    public static boolean isSupportHarmonyOSHDR() {
        String version;
        if (isHarmonyOS() && (version = getHarmonyOS()) != null && version.length() > 0) {
            String[] versions = version.split("\\.");
            if (versions.length > 0) {
                int major = Integer.parseInt(versions[0]);
                return major >= 3;
            }
        }
        return false;
    }

    public static boolean isHdrVividSupported(WindowManager windowManager) {
        int local = sHdrVividSupportCache;
        if (local != -1) {
            return local == 1;
        }
        boolean supported = false;
        try {
            if (isHuaweiRom()) {
                String json = AbrParamsInterface.getHuaweiHdrVividSystemRenderListJson();
                if (!TextUtils.isEmpty(json)) {
                    JSONArray array = new JSONArray(json);
                    String model = Build.MODEL;
                    String brand = Build.BRAND;
                    if (!TextUtils.isEmpty(model) && !TextUtils.isEmpty(brand)) {
                        String modelLower = model.toLowerCase(Locale.ROOT);
                        String brandLower = brand.toLowerCase(Locale.ROOT);
                        int i = 0;
                        while (true) {
                            if (i >= array.length()) {
                                break;
                            }
                            JSONObject item = array.getJSONObject(i);
                            String m = item.optString("model");
                            String b = item.optString("brand");
                            if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(b) && modelLower.equals(m.toLowerCase(Locale.ROOT)) && brandLower.equals(b.toLowerCase(Locale.ROOT))) {
                                supported = true;
                                break;
                            }
                            i++;
                        }
                    }
                }
            } else {
                boolean supportV2 = true;
                String cpuName = IjkCpuInfo.getCpuName();
                String model2 = Build.MODEL;
                if (!TextUtils.isEmpty(model2) && !TextUtils.isEmpty(cpuName)) {
                    String modelLower2 = model2.toLowerCase(Locale.ROOT);
                    String cpuLower = cpuName.toLowerCase(Locale.ROOT);
                    supportV2 = (modelLower2.contains("huawei p7") || cpuLower.contains("mt6795m") || cpuLower.contains("mt6595")) ? false : true;
                }
                boolean supportV22 = supportV2 && !isX86Abi();
                boolean supportHdr = isHDRSupport(windowManager);
                supported = supportV22 && supportHdr;
            }
        } catch (Throwable th) {
        }
        sHdrVividSupportCache = supported ? 1 : 0;
        return supported;
    }

    private static boolean isX86Abi() {
        String[] strArr;
        try {
            if (Build.SUPPORTED_ABIS != null) {
                for (String abi : Build.SUPPORTED_ABIS) {
                    if ("x86".equalsIgnoreCase(abi) || "x86_64".equalsIgnoreCase(abi)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    private static boolean isHuaweiRom() {
        String manufacturer = Build.MANUFACTURER;
        return !TextUtils.isEmpty(manufacturer) && manufacturer.contains("HUAWEI");
    }

    public static int getDeviceCapability(WindowManager windowManager) {
        int local = cachedCapability;
        if (local != -1) {
            return local;
        }
        boolean supportHdr = isHDRSupport(windowManager);
        boolean supportHlg = isHLGSupport(windowManager);
        boolean supportDolbyVision = isDolbyVisionSupport(windowManager);
        boolean z = false;
        boolean supportDrm = IjkDrmUtils.getSupportWidevineType() == 2;
        boolean supportHdrVivid = isHdrVividSupported(windowManager);
        boolean supportDolbyP5 = false;
        boolean supportDolbyP8_4 = false;
        Pair<Boolean, Boolean> dvProfile = getDolbyVisionProfileSupport();
        if (dvProfile != null) {
            supportDolbyP5 = ((Boolean) dvProfile.first).booleanValue();
            supportDolbyP8_4 = ((Boolean) dvProfile.second).booleanValue();
        }
        int capability = supportHdr ? 0 | 1 : 0;
        if (supportDolbyVision) {
            capability |= 2;
        }
        if (supportDrm) {
            capability |= 4;
        }
        if (supportHdrVivid) {
            capability |= 8;
        }
        if (supportHlg) {
            capability |= 16;
        }
        if (supportDolbyVision && supportDolbyP5) {
            capability |= 32;
        }
        if (supportDolbyVision && supportDolbyP8_4) {
            capability |= 64;
        }
        StringBuilder append = new StringBuilder().append("getDeviceCapability -> HDR=").append(supportHdr).append(", HLG=").append(supportHlg).append(", DolbyVision=").append(supportDolbyVision).append(", DV_P5=").append(supportDolbyVision && supportDolbyP5).append(", DV_HLG_P8.4=");
        if (supportDolbyVision && supportDolbyP8_4) {
            z = true;
        }
        BLog.i(TAG, append.append(z).append(", DRM=").append(supportDrm).append(", HDR_VIVID=").append(supportHdrVivid).append(", mask=").append(capability).toString());
        cachedCapability = capability;
        return capability;
    }
}