package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class IjkMediaFormat implements IMediaFormat {
    public static final String CODEC_NAME_H264 = "h264";
    public static final String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
    public static final String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
    public static final String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
    public static final String KEY_IJK_CODEC_NAME_UI = "ijk-codec-name-ui";
    public static final String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
    public static final String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
    public static final String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
    public static final String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
    public static final String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
    private static final Map<String, Formatter> sFormatterMap = new HashMap();
    public final IjkMediaMeta.IjkStreamMeta mMediaFormat;

    public IjkMediaFormat(IjkMediaMeta.IjkStreamMeta streamMeta) {
        sFormatterMap.put(KEY_IJK_CODEC_LONG_NAME_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.1
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            public String doFormat(IjkMediaFormat mediaFormat) {
                return IjkMediaFormat.this.mMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_LONG_NAME);
            }
        });
        sFormatterMap.put(KEY_IJK_CODEC_NAME_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.2
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            public String doFormat(IjkMediaFormat mediaFormat) {
                return IjkMediaFormat.this.mMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_NAME);
            }
        });
        sFormatterMap.put(KEY_IJK_BIT_RATE_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.3
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat mediaFormat) {
                int bitRate = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_BITRATE);
                if (bitRate <= 0) {
                    return null;
                }
                return bitRate < 1000 ? String.format(Locale.US, "%d bit/s", Integer.valueOf(bitRate)) : String.format(Locale.US, "%d kb/s", Integer.valueOf(bitRate / IjkMediaCodecInfo.RANK_MAX));
            }
        });
        sFormatterMap.put(KEY_IJK_CODEC_PROFILE_LEVEL_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.4
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat mediaFormat) {
                String profile;
                int profileIndex = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_CODEC_PROFILE_ID);
                switch (profileIndex) {
                    case 44:
                        profile = "CAVLC 4:4:4";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                        profile = "Baseline";
                        break;
                    case 77:
                        profile = "Main";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                        profile = "Extended";
                        break;
                    case 100:
                        profile = "High";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_10 /* 110 */:
                        profile = "High 10";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_422 /* 122 */:
                        profile = "High 4:2:2";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
                        profile = "High 4:4:4";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                        profile = "High 4:4:4 Predictive";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE /* 578 */:
                        profile = "Constrained Baseline";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_10_INTRA /* 2158 */:
                        profile = "High 10 Intra";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_422_INTRA /* 2170 */:
                        profile = "High 4:2:2 Intra";
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_INTRA /* 2292 */:
                        profile = "High 4:4:4 Intra";
                        break;
                    default:
                        return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(profile);
                String codecName = mediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_NAME);
                if (!TextUtils.isEmpty(codecName) && codecName.equalsIgnoreCase(IjkMediaFormat.CODEC_NAME_H264)) {
                    int level = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_CODEC_LEVEL);
                    if (level < 10) {
                        return sb.toString();
                    }
                    sb.append(" Profile Level ");
                    sb.append((level / 10) % 10);
                    if (level % 10 != 0) {
                        sb.append(".");
                        sb.append(level % 10);
                    }
                }
                return sb.toString();
            }
        });
        sFormatterMap.put(KEY_IJK_CODEC_PIXEL_FORMAT_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.5
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat mediaFormat) {
                return mediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_PIXEL_FORMAT);
            }
        });
        sFormatterMap.put(KEY_IJK_RESOLUTION_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.6
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat mediaFormat) {
                int width = mediaFormat.getInteger("width");
                int height = mediaFormat.getInteger("height");
                int sarNum = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAR_NUM);
                int sarDen = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAR_DEN);
                if (width <= 0 || height <= 0) {
                    return null;
                }
                return (sarNum <= 0 || sarDen <= 0) ? String.format(Locale.US, "%d x %d", Integer.valueOf(width), Integer.valueOf(height)) : String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(sarNum), Integer.valueOf(sarDen));
            }
        });
        sFormatterMap.put(KEY_IJK_FRAME_RATE_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.7
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat mediaFormat) {
                int fpsNum = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_FPS_NUM);
                int fpsDen = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_FPS_DEN);
                if (fpsNum <= 0 || fpsDen <= 0) {
                    return null;
                }
                return String.valueOf(fpsNum / fpsDen);
            }
        });
        sFormatterMap.put(KEY_IJK_SAMPLE_RATE_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.8
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat mediaFormat) {
                int sampleRate = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
                if (sampleRate <= 0) {
                    return null;
                }
                return String.format(Locale.US, "%d Hz", Integer.valueOf(sampleRate));
            }
        });
        sFormatterMap.put(KEY_IJK_CHANNEL_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.9
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat mediaFormat) {
                int channelLayout = mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_CHANNEL_LAYOUT);
                if (channelLayout <= 0) {
                    return null;
                }
                if (channelLayout == 4) {
                    return "mono";
                }
                return ((long) channelLayout) == 3 ? "stereo" : String.format(Locale.US, "%x", Integer.valueOf(channelLayout));
            }
        });
        this.mMediaFormat = streamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public int getInteger(String name) {
        if (this.mMediaFormat == null) {
            return 0;
        }
        return this.mMediaFormat.getInt(name);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public String getString(String name) {
        if (this.mMediaFormat == null) {
            return null;
        }
        if (sFormatterMap.containsKey(name)) {
            Formatter formatter = sFormatterMap.get(name);
            return formatter.format(this);
        }
        return this.mMediaFormat.getString(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Formatter {
        protected abstract String doFormat(IjkMediaFormat ijkMediaFormat);

        private Formatter() {
        }

        public String format(IjkMediaFormat mediaFormat) {
            String value = doFormat(mediaFormat);
            if (TextUtils.isEmpty(value)) {
                return getDefaultString();
            }
            return value;
        }

        protected String getDefaultString() {
            return "N/A";
        }
    }
}