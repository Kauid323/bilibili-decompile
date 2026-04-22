package tv.danmaku.ijk.media.player;

import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

public class IjkMediaCodecInfo {
    public static final int RANK_ACCEPTABLE = 700;
    public static final int RANK_LAST_CHANCE = 600;
    public static final int RANK_MAX = 1000;
    public static final int RANK_NON_STANDARD = 100;
    public static final int RANK_NO_SENSE = 0;
    public static final int RANK_SECURE = 300;
    public static final int RANK_SOFTWARE = 200;
    public static final int RANK_TESTED = 800;
    private static final String TAG = "IjkMediaCodecInfo";
    private static Map<String, Integer> sKnownCodecList;
    public MediaCodecInfo mCodecInfo;
    public String mMimeType;
    public int mRank = 0;

    private static synchronized Map<String, Integer> getKnownCodecList() {
        synchronized (IjkMediaCodecInfo.class) {
            if (sKnownCodecList != null) {
                return sKnownCodecList;
            }
            sKnownCodecList = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            sKnownCodecList.put("OMX.Nvidia.h264.decode", 800);
            sKnownCodecList.put("OMX.Nvidia.h264.decode.secure", 300);
            sKnownCodecList.put("OMX.Intel.hw_vd.h264", 801);
            sKnownCodecList.put("OMX.Intel.VideoDecoder.AVC", 800);
            sKnownCodecList.put("OMX.qcom.video.decoder.avc", 800);
            sKnownCodecList.put("OMX.ittiam.video.decoder.avc", 0);
            sKnownCodecList.put("OMX.SEC.avc.dec", 800);
            sKnownCodecList.put("OMX.SEC.AVC.Decoder", 799);
            sKnownCodecList.put("OMX.SEC.avcdec", 798);
            sKnownCodecList.put("OMX.SEC.avc.sw.dec", 200);
            sKnownCodecList.put("OMX.SEC.hevc.sw.dec", 200);
            sKnownCodecList.put("OMX.Exynos.avc.dec", 800);
            sKnownCodecList.put("OMX.Exynos.AVC.Decoder", 799);
            sKnownCodecList.put("c2.sec.mpeg4.decoder", 800);
            sKnownCodecList.put("c2.exynos.h264.decoder", 800);
            sKnownCodecList.put("c2.exynos.hevc.decoder", 800);
            sKnownCodecList.put("OMX.k3.video.decoder.avc", 800);
            sKnownCodecList.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
            sKnownCodecList.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
            sKnownCodecList.put("OMX.rk.video_decoder.avc", 800);
            sKnownCodecList.put("OMX.amlogic.avc.decoder.awesome", 800);
            sKnownCodecList.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
            sKnownCodecList.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
            sKnownCodecList.remove("OMX.Action.Video.Decoder");
            sKnownCodecList.remove("OMX.allwinner.video.decoder.avc");
            sKnownCodecList.remove("OMX.BRCM.vc4.decoder.avc");
            sKnownCodecList.remove("OMX.brcm.video.h264.hw.decoder");
            sKnownCodecList.remove("OMX.brcm.video.h264.decoder");
            sKnownCodecList.remove("OMX.cosmo.video.decoder.avc");
            sKnownCodecList.remove("OMX.duos.h264.decoder");
            sKnownCodecList.remove("OMX.hantro.81x0.video.decoder");
            sKnownCodecList.remove("OMX.hantro.G1.video.decoder");
            sKnownCodecList.remove("OMX.hisi.video.decoder");
            sKnownCodecList.remove("OMX.LG.decoder.video.avc");
            sKnownCodecList.remove("OMX.MS.AVC.Decoder");
            sKnownCodecList.remove("OMX.RENESAS.VIDEO.DECODER.H264");
            sKnownCodecList.remove("OMX.RTK.video.decoder");
            sKnownCodecList.remove("OMX.sprd.h264.decoder");
            sKnownCodecList.remove("OMX.ST.VFM.H264Dec");
            sKnownCodecList.remove("OMX.vpu.video_decoder.avc");
            sKnownCodecList.remove("OMX.WMT.decoder.avc");
            sKnownCodecList.remove("OMX.bluestacks.hw.decoder");
            sKnownCodecList.put("OMX.google.h264.decoder", 200);
            sKnownCodecList.put("OMX.google.h264.lc.decoder", 200);
            sKnownCodecList.put("OMX.k3.ffmpeg.decoder", 200);
            sKnownCodecList.put("OMX.ffmpeg.video.decoder", 200);
            sKnownCodecList.put("OMX.sprd.soft.h264.decoder", 200);
            sKnownCodecList.put("OMX.qcom.video.decoder.hevcswvdec", 200);
            sKnownCodecList.put("OMX.qcom.video.decoder.hevchybrid", 200);
            return sKnownCodecList;
        }
    }

    private static boolean isValidAv1Codec(String name) {
        if (name.equals("c2.qti.av1.decoder") || name.equals("c2.mtk.av1.decoder")) {
            return true;
        }
        return false;
    }

    private static int getOtherCodecRank(MediaCodecInfo codecInfo, String name, String mimeType, int profile, int level) {
        int rank;
        MediaCodecInfo.CodecCapabilities cap;
        Integer knownRank = getKnownCodecList().get(name);
        if (knownRank != null) {
            int rank2 = knownRank.intValue();
            return rank2;
        }
        try {
            cap = codecInfo.getCapabilitiesForType(mimeType);
        } catch (Throwable th) {
            rank = RANK_LAST_CHANCE;
        }
        if (cap != null) {
            if (checkSupportProfileLevel(cap, mimeType, profile, level)) {
                rank = 700;
                if (!name.startsWith("c2.") && !mimeType.equalsIgnoreCase("video/dolby-vision")) {
                    return rank - 1;
                }
            }
        }
        rank = RANK_LAST_CHANCE;
        return !name.startsWith("c2.") ? rank : rank;
    }

    private static int getSpecialCodecRank(String name, String mimeType, int profile) {
        if (name.startsWith("omx.pv") || name.startsWith("omx.google.") || name.startsWith("omx.ffmpeg.") || name.startsWith("omx.k3.ffmpeg.") || name.startsWith("omx.avcodec.")) {
            return 200;
        }
        if (name.contains("omx.sec") && name.contains(".sw.")) {
            return 200;
        }
        if (name.startsWith("omx.ittiam.")) {
            return 0;
        }
        if (name.endsWith(".secure")) {
            return 300;
        }
        if (name.contains(".intel.sw_vd.")) {
            return 200;
        }
        if (name.startsWith("omx.mtk.")) {
            return 800;
        }
        if (name.startsWith("c2.android.")) {
            if (mimeType.equalsIgnoreCase("video/dolby-vision")) {
                return isDolbyCodecProfileValid(name, profile) ? 799 : 0;
            }
            return 200;
        } else if (mimeType.equalsIgnoreCase("video/av01") && !isValidAv1Codec(name)) {
            return 100;
        } else {
            if (IjkCodecHelper.isUnusedLowLatency() && name.contains("low_latency")) {
                return RANK_LAST_CHANCE;
            }
            if (!mimeType.equalsIgnoreCase("video/av01") || !name.startsWith("c2.")) {
                return -1;
            }
            return 700;
        }
    }

    private static boolean isDolbyCodecProfileValid(String name, int profile) {
        if (profile > 1 && profile < 9) {
            if (name.endsWith(".avc")) {
                return false;
            }
        } else if (profile != 10 && name.endsWith(".hevc")) {
            return false;
        }
        return true;
    }

    private static boolean isStandardCodec(String name, boolean isDolbyVision) {
        return name.startsWith("omx.") || name.startsWith("c2.");
    }

    public static IjkMediaCodecInfo setupCandidate(MediaCodecInfo codecInfo, String mimeType, int profile, int level) {
        int rank;
        if (codecInfo == null) {
            return null;
        }
        String name = codecInfo.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        boolean isDolbyVision = mimeType.equalsIgnoreCase("video/dolby-vision");
        String name2 = name.toLowerCase(Locale.US);
        if (!isStandardCodec(name2, isDolbyVision)) {
            rank = 100;
        } else {
            int specialRank = getSpecialCodecRank(name2, mimeType, profile);
            if (specialRank != -1) {
                rank = specialRank;
            } else {
                rank = getOtherCodecRank(codecInfo, name2, mimeType, profile, level);
                if (isDolbyVision && !isDolbyCodecProfileValid(name2, profile)) {
                    rank = 0;
                }
            }
        }
        IjkMediaCodecInfo candidate = new IjkMediaCodecInfo();
        candidate.mCodecInfo = codecInfo;
        candidate.mRank = rank;
        candidate.mMimeType = mimeType;
        return candidate;
    }

    public static boolean checkSupportProfileLevel(MediaCodecInfo.CodecCapabilities cap, String mimeType, int profile, int level) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        if (cap == null || profile < 0 || level < 0) {
            return false;
        }
        if (mimeType.equalsIgnoreCase("video/dolby-vision")) {
            int androidProfile = (int) Math.pow(2.0d, profile);
            int androidLevel = (int) Math.pow(2.0d, level - 1);
            boolean supportProfile = false;
            int maxLevel = 0;
            if (cap != null) {
                try {
                    if (cap.profileLevels != null) {
                        for (MediaCodecInfo.CodecProfileLevel profileLevel : cap.profileLevels) {
                            if (profileLevel != null) {
                                if (androidProfile == profileLevel.profile) {
                                    supportProfile = true;
                                }
                                maxLevel = Math.max(maxLevel, profileLevel.level);
                            }
                        }
                    }
                } catch (Throwable th) {
                    Log.i(TAG, "profile-level: exception");
                }
            }
            boolean support = supportProfile && androidLevel <= maxLevel;
            Log.i(TAG, String.format(Locale.US, "checkSupportProfileLevel %s  %s", getProfileLevelName(mimeType, androidProfile, androidLevel), support ? "support" : " not support"));
            return support;
        }
        return true;
    }

    public void dumpProfileLevels(String mimeType) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        try {
            MediaCodecInfo.CodecCapabilities caps = this.mCodecInfo.getCapabilitiesForType(mimeType);
            int maxProfile = 0;
            int maxLevel = 0;
            if (caps != null && caps.profileLevels != null) {
                for (MediaCodecInfo.CodecProfileLevel profileLevel : caps.profileLevels) {
                    if (profileLevel != null) {
                        maxProfile = Math.max(maxProfile, profileLevel.profile);
                        maxLevel = Math.max(maxLevel, profileLevel.level);
                    }
                }
            }
            Log.i(TAG, String.format(Locale.US, "%s", getProfileLevelName(mimeType, maxProfile, maxLevel)));
        } catch (Throwable th) {
            Log.i(TAG, "profile-level: exception");
        }
    }

    public static String getProfileLevelName(String mimeType, int profile, int level) {
        if (mimeType.equalsIgnoreCase("video/dolby-vision")) {
            return String.format(Locale.US, " Dolby Vision %s Profile Level %s (%d,%d)", getDolbyVisionProfileName(profile), getDolbyVisionLevelName(level), Integer.valueOf(profile), Integer.valueOf(level));
        }
        return String.format(Locale.US, " %s Profile Level %s (%d,%d)", getProfileName(profile), getLevelName(level), Integer.valueOf(profile), Integer.valueOf(level));
    }

    public static String getDolbyVisionProfileName(int profile) {
        switch (profile) {
            case 1:
                return "DvavPer";
            case 2:
                return "DvavPen";
            case 4:
                return "DvheDer";
            case 8:
                return "DvheDen";
            case 16:
                return "DvheDtr";
            case 32:
                return "DvheStn";
            case 64:
                return "DvheDth";
            case 128:
                return "DvheDtb";
            case IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN /* 256 */:
                return "DvheSt";
            case 512:
                return "DvavSe";
            case 1024:
                return "Dav110";
            default:
                return "Unknown";
        }
    }

    public static String getDolbyVisionLevelName(int level) {
        switch (level) {
            case 1:
                return "Hd24";
            case 2:
                return "Hd30";
            case 4:
                return "Fhd24";
            case 8:
                return "Fhd30";
            case 16:
                return "Fhd60";
            case 32:
                return "Uhd24";
            case 64:
                return "Uhd30";
            case 128:
                return "Uhd48";
            case IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN /* 256 */:
                return "Uhd60";
            default:
                return "0";
        }
    }

    public static String getProfileName(int profile) {
        switch (profile) {
            case 1:
                return "Baseline";
            case 2:
                return "Main";
            case 4:
                return "Extends";
            case 8:
                return "High";
            case 16:
                return "High10";
            case 32:
                return "High422";
            case 64:
                return "High444";
            default:
                return "Unknown";
        }
    }

    public static String getLevelName(int level) {
        switch (level) {
            case 1:
                return "1";
            case 2:
                return "1b";
            case 4:
                return ConstsKt.ARG_STATE_DIALOG_CLICK_CANCEL;
            case 8:
                return ConstsKt.ARG_STATE_DIALOG_CLICK_UPDATE;
            case 16:
                return ConstsKt.ARG_UPDATE_RESULT;
            case 32:
                return "2";
            case 64:
                return "21";
            case 128:
                return "22";
            case IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN /* 256 */:
                return "3";
            case 512:
                return "31";
            case 1024:
                return "32";
            case IjkMediaMeta.FF_PROFILE_H264_INTRA /* 2048 */:
                return "4";
            case 4096:
                return "41";
            case 8192:
                return "42";
            case IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID /* 16384 */:
                return ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE;
            case 32768:
                return "51";
            case 65536:
                return "52";
            default:
                return "0";
        }
    }
}