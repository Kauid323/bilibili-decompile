package bvc_sdk.xcode_tools;

public class BvcXcodeProbeMeta {
    private BvcXcodeAudioMeta audio_meta;
    private BvcXcodeCheckResult check_result;
    private BvcXcodeContainerMeta container_meta;
    private int defender_code;
    private String ijkffmpeg_version;
    private int meta_status;
    private int probe_code;
    private String version;
    private BvcXcodeVideoMeta video_meta;

    public BvcXcodeContainerMeta getContainerMeta() {
        return this.container_meta;
    }

    public BvcXcodeAudioMeta getAudioMeta() {
        return this.audio_meta;
    }

    public BvcXcodeVideoMeta getVideoMeta() {
        return this.video_meta;
    }

    public BvcXcodeCheckResult getCheckResult() {
        return this.check_result;
    }

    public String getVersion() {
        return this.version;
    }

    public String getIjkffmpegVersion() {
        return this.ijkffmpeg_version;
    }

    public int getProbeCode() {
        return this.probe_code;
    }

    public int getDefenderCode() {
        return this.defender_code;
    }

    public int getMetaStatus() {
        return this.meta_status;
    }

    public String toString() {
        return "BvcXcodeProbeMeta:\n\tcontainerMeta=" + this.container_meta.toString().replaceAll("\t", "\t\t") + "\n\taudioMeta=" + this.audio_meta.toString().replaceAll("\t", "\t\t") + "\n\tvideoMeta=" + this.video_meta.toString().replaceAll("\t", "\t\t") + "\n\tcheckResult=" + this.check_result.toString().replaceAll("\t", "\t\t") + "\n\tversion='" + this.version.toString().replaceAll("\t", "\t\t") + "'\n\tijkffmpegVersion='" + this.ijkffmpeg_version.toString().replaceAll("\t", "\t\t") + "'\n\tprobeCode=" + this.probe_code + "\n\tdefenderCode=" + this.defender_code + "\n\tmetaStatus=" + this.meta_status;
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeContainerMeta {
        private String av_delta;
        private String content_duration;
        private String duration;
        private String format_name;
        private String size;
        private String start_time;

        public String getFormatName() {
            return this.format_name;
        }

        public String getSize() {
            return this.size;
        }

        public String getDuration() {
            return this.duration;
        }

        public String getContentDuration() {
            return this.content_duration;
        }

        public String getStartDime() {
            return this.start_time;
        }

        public String getAvDelta() {
            return this.av_delta;
        }

        public String toString() {
            return "BvcXcodeContainerMeta:\n\tformat_name='" + this.format_name.toString().replaceAll("\t", "\t\t") + "'\n\tsize='" + this.size.toString().replaceAll("\t", "\t\t") + "'\n\tduration='" + this.duration.toString().replaceAll("\t", "\t\t") + "'\n\tcontent_duration='" + this.content_duration.toString().replaceAll("\t", "\t\t") + "'\n\tstart_time='" + this.start_time.toString().replaceAll("\t", "\t\t") + "'\n\tav_delta='" + this.av_delta.toString().replaceAll("\t", "\t\t") + '\'';
        }
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeAudioMeta {
        private String bit_rate;
        private String channels;
        private String codec_name;
        private String duration;
        private String frame_count;
        private String profile;
        private String r_frame_rate;
        private String sample_rate;
        private String start_time;
        private String stream_size;

        public String getBitRate() {
            return this.bit_rate;
        }

        public String getChannels() {
            return this.channels;
        }

        public String getCodecName() {
            return this.codec_name;
        }

        public String getDuration() {
            return this.duration;
        }

        public String getFrameCount() {
            return this.frame_count;
        }

        public String getProfile() {
            return this.profile;
        }

        public String getRFrameRate() {
            return this.r_frame_rate;
        }

        public String getSampleRate() {
            return this.sample_rate;
        }

        public String getStartTime() {
            return this.start_time;
        }

        public String getStreamSize() {
            return this.stream_size;
        }

        public String toString() {
            return "BvcXcodeAudioMeta:\n\tbit_rate='" + this.bit_rate.toString().replaceAll("\t", "\t\t") + "'\n\tchannels='" + this.channels.toString().replaceAll("\t", "\t\t") + "'\n\tcodec_name='" + this.codec_name.toString().replaceAll("\t", "\t\t") + "'\n\tduration='" + this.duration.toString().replaceAll("\t", "\t\t") + "'\n\tframe_count='" + this.frame_count.toString().replaceAll("\t", "\t\t") + "'\n\tprofile='" + this.profile.toString().replaceAll("\t", "\t\t") + "'\n\tr_frame_rate='" + this.r_frame_rate.toString().replaceAll("\t", "\t\t") + "'\n\tsample_rate='" + this.sample_rate.toString().replaceAll("\t", "\t\t") + "'\n\tstart_time='" + this.start_time.toString().replaceAll("\t", "\t\t") + "'\n\tstream_size='" + this.stream_size.toString().replaceAll("\t", "\t\t") + '\'';
        }
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeSphericalMeta {
        private String spherical_mapping;
        private String stereo_3D;

        public String getSphericalMapping() {
            return this.spherical_mapping;
        }

        public String getStereo3D() {
            return this.stereo_3D;
        }

        public String toString() {
            return "BvcXcodeSphericalMeta:\n\tsphericalMapping='" + this.spherical_mapping.toString().replaceAll("\t", "\t\t") + "'\n\tstereo3D='" + this.stereo_3D.toString().replaceAll("\t", "\t\t") + '\'';
        }
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeVideoMeta {
        private String avg_frame_rate;
        private String avg_frame_rate_den;
        private String avg_frame_rate_num;
        private String bit_rate;
        private String bits_per_raw_sample;
        private String codec_name;
        private String codec_tag_string;
        private String color_primaries;
        private String color_range;
        private String color_space;
        private String color_transfer;
        private String display_aspect_ratio;
        private String display_aspect_ratio_den;
        private String display_aspect_ratio_num;
        private String duration;
        private String field_order;
        private String frame_count;
        private String has_b_frames;
        private String hdr_format;
        private String hdr_format_compatibility;
        private String hdr_format_level;
        private String hdr_format_profile;
        private String hdr_format_settings;
        private String hdr_format_version;
        private String height;
        private String interlaced;
        private String is_dts_cfr;
        private String is_pts_cfr;
        private String is_spherical;
        private String key_count;
        private String lack_intra;
        private String level;
        private String max_dts_gop_size;
        private String max_pts_gop_size;
        private String max_rate;
        private String pass_video_decoding_trial;
        private String pix_fmt;
        private String profile;
        private String pts_disorder;
        private String r_frame_rate;
        private String r_frame_rate_raw;
        private String rotate;
        private String rotation;
        private String scan_order;
        private String scan_type;
        private BvcXcodeSphericalMeta spherical_meta;
        private String start_time;
        private String stream_size;
        private String width;

        public String getAvgFrameRate() {
            return this.avg_frame_rate;
        }

        public String getAvgFrameRateNum() {
            return this.avg_frame_rate_num;
        }

        public String getAvgFrameRateDen() {
            return this.avg_frame_rate_den;
        }

        public String getBitRate() {
            return this.bit_rate;
        }

        public String getBitsPerRawSample() {
            return this.bits_per_raw_sample;
        }

        public String getCodecName() {
            return this.codec_name;
        }

        public String getCodecTagString() {
            return this.codec_tag_string;
        }

        public String getColorPrimaries() {
            return this.color_primaries;
        }

        public String getColorRange() {
            return this.color_range;
        }

        public String getColorSpace() {
            return this.color_space;
        }

        public String getColorTransfer() {
            return this.color_transfer;
        }

        public String getDisplayAspectRatio() {
            return this.display_aspect_ratio;
        }

        public String getDisplayAspectRatioNum() {
            return this.display_aspect_ratio_num;
        }

        public String getDisplayAspectRatioDen() {
            return this.display_aspect_ratio_den;
        }

        public String getDuration() {
            return this.duration;
        }

        public String getFrameCount() {
            return this.frame_count;
        }

        public String getFieldOrder() {
            return this.field_order;
        }

        public String getHasBFrames() {
            return this.has_b_frames;
        }

        public String getHdrFormat() {
            return this.hdr_format;
        }

        public String getHdrFormatCompatibility() {
            return this.hdr_format_compatibility;
        }

        public String getHdrFormatLevel() {
            return this.hdr_format_level;
        }

        public String getHdrFormatProfile() {
            return this.hdr_format_profile;
        }

        public String getHdrFormatSettings() {
            return this.hdr_format_settings;
        }

        public String getHdrFormatVersion() {
            return this.hdr_format_version;
        }

        public String getHeight() {
            return this.height;
        }

        public String getInterlaced() {
            return this.interlaced;
        }

        public String getIsDtsCfr() {
            return this.is_dts_cfr;
        }

        public String getIsPtsCfr() {
            return this.is_pts_cfr;
        }

        public String getIsSpherical() {
            return this.is_spherical;
        }

        public String getKeyCount() {
            return this.key_count;
        }

        public String getLackIntra() {
            return this.lack_intra;
        }

        public String getLevel() {
            return this.level;
        }

        public String getMaxDtsGopSize() {
            return this.max_dts_gop_size;
        }

        public String getMaxPtsGopSize() {
            return this.max_pts_gop_size;
        }

        public String getMaxRate() {
            return this.max_rate;
        }

        public String getPassVideoDecodingTrial() {
            return this.pass_video_decoding_trial;
        }

        public String getPixFmt() {
            return this.pix_fmt;
        }

        public String getProfile() {
            return this.profile;
        }

        public String getPtsDisorder() {
            return this.pts_disorder;
        }

        public String getRFrameRate() {
            return this.r_frame_rate;
        }

        public String getRFrameRateRaw() {
            return this.r_frame_rate_raw;
        }

        public String getRotate() {
            return this.rotate;
        }

        public String getRotation() {
            return this.rotation;
        }

        public String getScanOrder() {
            return this.scan_order;
        }

        public String getScanType() {
            return this.scan_type;
        }

        public String getStartTime() {
            return this.start_time;
        }

        public String getStreamSize() {
            return this.stream_size;
        }

        public String getWidth() {
            return this.width;
        }

        public BvcXcodeSphericalMeta getSphericalMeta() {
            return this.spherical_meta;
        }

        public String toString() {
            return "BvcXcodeVideoMeta:\n\tavg_frame_rate='" + this.avg_frame_rate.toString().replaceAll("\t", "\t\t") + "'\n\t avg_frame_rate_num='" + this.avg_frame_rate_num.toString().replaceAll("\t", "\t\t") + "'\n\t avg_frame_rate_den='" + this.avg_frame_rate_den.toString().replaceAll("\t", "\t\t") + "'\n\t bit_rate='" + this.bit_rate.toString().replaceAll("\t", "\t\t") + "'\n\t bits_per_raw_sample='" + this.bits_per_raw_sample.toString().replaceAll("\t", "\t\t") + "'\n\t codec_name='" + this.codec_name.toString().replaceAll("\t", "\t\t") + "'\n\t codec_tag_string='" + this.codec_tag_string.toString().replaceAll("\t", "\t\t") + "'\n\t color_primaries='" + this.color_primaries.toString().replaceAll("\t", "\t\t") + "'\n\t color_range='" + this.color_range.toString().replaceAll("\t", "\t\t") + "'\n\t color_space='" + this.color_space.toString().replaceAll("\t", "\t\t") + "'\n\t color_transfer='" + this.color_transfer.toString().replaceAll("\t", "\t\t") + "'\n\t display_aspect_ratio='" + this.display_aspect_ratio.toString().replaceAll("\t", "\t\t") + "'\n\t display_aspect_ratio_num='" + this.display_aspect_ratio_num.toString().replaceAll("\t", "\t\t") + "'\n\t display_aspect_ratio_den='" + this.display_aspect_ratio_den.toString().replaceAll("\t", "\t\t") + "'\n\t duration='" + this.duration.toString().replaceAll("\t", "\t\t") + "'\n\t frame_count='" + this.frame_count.toString().replaceAll("\t", "\t\t") + "'\n\t field_order='" + this.field_order.toString().replaceAll("\t", "\t\t") + "'\n\t has_b_frames='" + this.has_b_frames.toString().replaceAll("\t", "\t\t") + "'\n\t hdr_format='" + this.hdr_format.toString().replaceAll("\t", "\t\t") + "'\n\t hdr_format_compatibility='" + this.hdr_format_compatibility.toString().replaceAll("\t", "\t\t") + "'\n\t hdr_format_level='" + this.hdr_format_level.toString().replaceAll("\t", "\t\t") + "'\n\t hdr_format_profile='" + this.hdr_format_profile.toString().replaceAll("\t", "\t\t") + "'\n\t hdr_format_settings='" + this.hdr_format_settings.toString().replaceAll("\t", "\t\t") + "'\n\t hdr_format_version='" + this.hdr_format_version.toString().replaceAll("\t", "\t\t") + "'\n\t height='" + this.height.toString().replaceAll("\t", "\t\t") + "'\n\t interlaced='" + this.interlaced.toString().replaceAll("\t", "\t\t") + "'\n\t is_dts_cfr='" + this.is_dts_cfr.toString().replaceAll("\t", "\t\t") + "'\n\t is_pts_cfr='" + this.is_pts_cfr.toString().replaceAll("\t", "\t\t") + "'\n\t is_spherical='" + this.is_spherical.toString().replaceAll("\t", "\t\t") + "'\n\t key_count='" + this.key_count.toString().replaceAll("\t", "\t\t") + "'\n\t lack_intra='" + this.lack_intra.toString().replaceAll("\t", "\t\t") + "'\n\t level='" + this.level.toString().replaceAll("\t", "\t\t") + "'\n\t max_dts_gop_size='" + this.max_dts_gop_size.toString().replaceAll("\t", "\t\t") + "'\n\t max_pts_gop_size='" + this.max_pts_gop_size.toString().replaceAll("\t", "\t\t") + "'\n\t max_rate='" + this.max_rate.toString().replaceAll("\t", "\t\t") + "'\n\t pass_video_decoding_trial='" + this.pass_video_decoding_trial.toString().replaceAll("\t", "\t\t") + "'\n\t pix_fmt='" + this.pix_fmt.toString().replaceAll("\t", "\t\t") + "'\n\t profile='" + this.profile.toString().replaceAll("\t", "\t\t") + "'\n\t pts_disorder='" + this.pts_disorder.toString().replaceAll("\t", "\t\t") + "'\n\t r_frame_rate='" + this.r_frame_rate.toString().replaceAll("\t", "\t\t") + "'\n\t r_frame_rate_raw='" + this.r_frame_rate_raw.toString().replaceAll("\t", "\t\t") + "'\n\t rotate='" + this.rotate.toString().replaceAll("\t", "\t\t") + "'\n\t rotation='" + this.rotation.toString().replaceAll("\t", "\t\t") + "'\n\t scan_order='" + this.scan_order.toString().replaceAll("\t", "\t\t") + "'\n\t scan_type='" + this.scan_type.toString().replaceAll("\t", "\t\t") + "'\n\t start_time='" + this.start_time.toString().replaceAll("\t", "\t\t") + "'\n\t stream_size='" + this.stream_size.toString().replaceAll("\t", "\t\t") + "'\n\t width='" + this.width.toString().replaceAll("\t", "\t\t") + "'\n\t spherical_meta=" + this.spherical_meta.toString().replaceAll("\t", "\t\t");
        }
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeTimeStampJumpFromTo {
        private String from;
        private String to;

        public String getFrom() {
            return this.from;
        }

        public String getTo() {
            return this.to;
        }

        public String toString() {
            return "BvcXcodeTimeStampJumpFromTo:\n\tfrom='" + this.from + "'\n\tto='" + this.to + '\'';
        }
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeTimeStampJump {
        private BvcXcodeTimeStampJumpFromTo audio;
        private BvcXcodeTimeStampJumpFromTo video;

        public BvcXcodeTimeStampJumpFromTo getAudio() {
            return this.audio;
        }

        public BvcXcodeTimeStampJumpFromTo getVideo() {
            return this.video;
        }

        public String toString() {
            return "BvcXcodeTimeStampJump:\n\taudio=" + this.audio + "\n\tvideo=" + this.video;
        }
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeTimeStampStretch {
        private String audio;
        private String video;

        public String getAudio() {
            return this.audio;
        }

        public String getVideo() {
            return this.video;
        }

        public String toString() {
            return "BvcXcodeTimeStampStretch:\n\taudio='" + this.audio + "'\n\tvideo='" + this.video + '\'';
        }
    }

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class BvcXcodeCheckResult {
        private String is_close_gop;
        private BvcXcodeTimeStampJump timestamp_jump;
        private BvcXcodeTimeStampStretch timestamp_stretch;

        public BvcXcodeTimeStampJump getTimestampJump() {
            return this.timestamp_jump;
        }

        public BvcXcodeTimeStampStretch getTimestampStretch() {
            return this.timestamp_stretch;
        }

        public String getIsCloseGop() {
            return this.is_close_gop;
        }

        public String toString() {
            return "BvcXcodeCheckResult:\n\ttimestamp_jump=" + this.timestamp_jump + "\n\ttimestamp_stretch=" + this.timestamp_stretch + "\n\tis_close_gop='" + this.is_close_gop + '\'';
        }
    }
}