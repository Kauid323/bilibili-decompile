package tv.danmaku.ijk.media.player;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tv.danmaku.ijk.media.player.utils.IjkDrmUtils;

public class IjkMediaAsset {
    int defaultAudioId;
    int defaultVideoId;
    public List<MediaAssetStream> streamList = null;
    public static int STREAM_USAGE_SCENARIO_LOW_RATIO = 1;
    public static int STREAM_USAGE_SCENARIO_HIGH_RATIO = 2;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum AudioCodecType {
        UNKNOWN,
        AAC,
        MP3,
        EAC3
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum AudioQualityType {
        NORMAL,
        DOLBY,
        HIRES
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum StreamType {
        NORMAL,
        DASH_VIDEO,
        DASH_AUDIO
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum VideoCodecType {
        UNKNOWN,
        H264,
        H265,
        AV1,
        H266
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Builder {
        private IjkMediaAsset target;

        public Builder(List<MediaAssetStream> streams, int defaultVideoId, int defaultAudioId) {
            this.target = new IjkMediaAsset();
            this.target.streamList = streams;
            this.target.defaultVideoId = defaultVideoId;
            this.target.defaultAudioId = defaultAudioId;
        }

        public Builder(String url, VideoCodecType type, int defaultVideoId, int defaultAudioId) {
            MediaAssertSegment.Builder segmentBuilder = new MediaAssertSegment.Builder(url, 0);
            List<MediaAssertSegment> segmentList = new ArrayList<>();
            segmentList.add(segmentBuilder.build());
            MediaAssetStream.Builder streamBuilder = new MediaAssetStream.Builder(StreamType.NORMAL, type, defaultVideoId);
            streamBuilder.setMediaAssertSegments(segmentList);
            List<MediaAssetStream> streamList = new ArrayList<>();
            streamList.add(streamBuilder.build());
            this.target = new IjkMediaAsset();
            this.target.streamList = streamList;
            this.target.defaultVideoId = defaultVideoId;
            this.target.defaultAudioId = defaultAudioId;
        }

        public IjkMediaAsset build() {
            IjkMediaAsset result = this.target;
            this.target = null;
            return result;
        }
    }

    public List<MediaAssetStream> getStreamList() {
        return this.streamList;
    }

    public int getDefaultAudioId() {
        return this.defaultAudioId;
    }

    public int getDefaultVideoId() {
        return this.defaultVideoId;
    }

    public int getDrmType() {
        if (this.streamList == null) {
            return IjkDrmUtils.DrmType.DRM_DEFAULT.getValue();
        }
        for (MediaAssetStream stream : this.streamList) {
            if (stream != null && stream.drmType != IjkDrmUtils.DrmType.DRM_DEFAULT.getValue()) {
                return stream.drmType;
            }
        }
        return IjkDrmUtils.DrmType.DRM_DEFAULT.getValue();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class MediaAssetStream {
        private AudioCodecType audioCodecType;
        private AudioQualityType audioQualityType;
        private int bandWidth;
        private String drmKid;
        private int drmType;
        private int groupId;
        private int qualityId;
        private int relatedAudioId;
        private List<MediaAssertSegment> segments;
        private String solutionType;
        private StreamType streamType;
        private int targetQn;
        private int usageScenario;
        private VideoCodecType videoCodecType;

        private MediaAssetStream() {
            this.segments = null;
            this.audioQualityType = AudioQualityType.NORMAL;
            this.targetQn = 0;
            this.solutionType = "";
            this.usageScenario = 0;
        }

        public List<MediaAssertSegment> getMediaAssertSegments() {
            return this.segments;
        }

        public StreamType getStreamType() {
            return this.streamType;
        }

        public VideoCodecType getVideoCodecType() {
            return this.videoCodecType;
        }

        public AudioCodecType getAudioCodecType() {
            return this.audioCodecType;
        }

        public int getQualityId() {
            return this.qualityId;
        }

        public int getBandWidth() {
            return this.bandWidth;
        }

        public int getGroupId() {
            return this.groupId;
        }

        public int getDrmType() {
            return this.drmType;
        }

        public String getDrmKid() {
            if (!TextUtils.isEmpty(this.drmKid) && this.drmKid.contains("uri:bili://")) {
                return this.drmKid.substring("uri:bili://".length());
            }
            return this.drmKid;
        }

        public int getRelatedAudioId() {
            return this.relatedAudioId;
        }

        public AudioQualityType getAudioQualityType() {
            return this.audioQualityType;
        }

        public void setTargetQn(int targetQn) {
            this.targetQn = targetQn;
        }

        public int getTargetQn() {
            return this.targetQn;
        }

        public void setSolutionType(String solutionType) {
            this.solutionType = solutionType;
        }

        public String getSolutionType() {
            return this.solutionType;
        }

        public void addUsageScenario(int usageScenario) {
            this.usageScenario |= usageScenario;
        }

        public int getUsageScenario() {
            return this.usageScenario;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static class Builder {
            private MediaAssetStream target = new MediaAssetStream();

            public Builder(StreamType streamType, VideoCodecType codecType, int qualityInt, int drmType, String drmKid) {
                this.target.streamType = streamType;
                this.target.videoCodecType = codecType;
                this.target.qualityId = qualityInt;
                this.target.segments = new ArrayList();
                this.target.drmType = drmType;
                this.target.drmKid = drmKid;
            }

            public Builder(StreamType streamType, VideoCodecType codecType, int qualityInt) {
                this.target.streamType = streamType;
                this.target.videoCodecType = codecType;
                this.target.qualityId = qualityInt;
                this.target.segments = new ArrayList();
            }

            public Builder(StreamType streamType, AudioCodecType codecType, int qualityInt, int drmType, String drmKid) {
                this.target.streamType = streamType;
                this.target.audioCodecType = codecType;
                this.target.qualityId = qualityInt;
                this.target.segments = new ArrayList();
                this.target.drmType = drmType;
                this.target.drmKid = drmKid;
            }

            public Builder(StreamType streamType, AudioCodecType codecType, int qualityInt) {
                this.target.streamType = streamType;
                this.target.audioCodecType = codecType;
                this.target.qualityId = qualityInt;
                this.target.segments = new ArrayList();
            }

            public Builder setMediaAssertSegments(Collection<MediaAssertSegment> segments) {
                if (segments != null) {
                    this.target.segments.addAll(segments);
                } else {
                    this.target.segments.clear();
                }
                return this;
            }

            public Builder setBandWith(int bandWith) {
                this.target.bandWidth = bandWith;
                return this;
            }

            public Builder setRelatedAudioId(int relatedAudioId) {
                this.target.relatedAudioId = relatedAudioId;
                return this;
            }

            public Builder setAudioQualityType(AudioQualityType audioQualityType) {
                this.target.audioQualityType = audioQualityType;
                return this;
            }

            public MediaAssetStream build() {
                MediaAssetStream tmp = this.target;
                this.target = null;
                return tmp;
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class MediaAssertSegment {
        private List<String> backupUrls;
        private int duration;
        private long size;
        private String url;

        private MediaAssertSegment() {
        }

        public String getUrl() {
            return this.url;
        }

        public List<String> getBackupUrls() {
            return this.backupUrls;
        }

        public int getDuration() {
            return this.duration;
        }

        public long getSize() {
            return this.size;
        }

        public String changeUrl() {
            if (this.backupUrls.size() <= 0) {
                return "";
            }
            this.url = this.backupUrls.get(0);
            this.backupUrls.remove(0);
            return this.url;
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static class Builder {
            private MediaAssertSegment target = new MediaAssertSegment();

            public Builder(String url, int duration) {
                this.target.url = url;
                this.target.duration = duration;
                this.target.backupUrls = new ArrayList();
            }

            public Builder setSize(long size) {
                this.target.size = size;
                return this;
            }

            public Builder setBackupUrls(Collection<String> backupUrls) {
                if (backupUrls != null) {
                    this.target.backupUrls.addAll(backupUrls);
                } else {
                    this.target.backupUrls.clear();
                }
                return this;
            }

            public MediaAssertSegment build() {
                MediaAssertSegment result = this.target;
                this.target = null;
                return result;
            }
        }
    }
}