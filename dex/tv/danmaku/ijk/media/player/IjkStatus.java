package tv.danmaku.ijk.media.player;

import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class IjkStatus {
    public PlaybackStrategy playbackStrategy = new PlaybackStrategy();
    public FirstPlayInfo firstPlayInfo = new FirstPlayInfo();
    public StreamInfo streamInfo = new StreamInfo();
    public PlaybackInfo playbackInfo = new PlaybackInfo();

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class FirstPlayInfo {
        public long renderFirstVideoTime = 0;
        public long networkFirstFrameTime = 0;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class PlaybackInfo {
        public long videoCache = 0;
        public long audioCache = 0;
        public long liveDelayTime = 0;
        public long curBitrate = 0;
        public long curNetSpeed = 0;
        public long curStableSpeed = 0;
        public long stableSpeedTimestamp = 0;
        public float videoDropRate = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        public float avDiff = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        public float minuteBufferCount = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        public long lastestPlayerError = 0;
        public long lastestItemError = 0;
        public long lastestNetError = 0;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class PlaybackStrategy {
        public boolean enableJitterBuffer = true;
        public float jitterBufferRatio = 1.0f;
        public boolean enableSkipFrame = true;
        public int skipFrameCount = 0;
        public boolean enableAbr = false;
        public String abrType = "";
        public int abrSwitchHighCount = 0;
        public int abrSwitchLowCount = 0;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class StreamInfo {
        public long channelLayout;
        public String muxer = "";
        public String streamType = "";
        public float videoFps = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        public int[] videoResolution = {0, 0, 1, 1};
        public String videoCodec = "";
        public String videoDecoder = "";
        public String videoEncoder = "";
        public String videoUrl = "";
        public int sampleRate = 0;
        public String audioCodec = "";
        public String audioUrl = "";
    }
}