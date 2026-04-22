package tv.danmaku.videoplayer.coreV2;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MediaResourceStream.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/MediaResourceStream;", "", "<init>", "()V", "PLAYER_VIDEO_STREAM_UNDEF", "", "PLAYER_VIDEO_STREAM_AUTO", "PLAYER_VIDEO_STREAM_360P", "PLAYER_VIDEO_STREAM_480P", "PLAYER_VIDEO_STREAM_720P", "PLAYER_VIDEO_STREAM_1080P", "PLAYER_VIDEO_STREAM_1080P_PLUS", "PLAYER_VIDEO_STREAM_1080P_60FPS", "PLAYER_VIDEO_STREAM_4K", "PLAYER_AUDIO_STREAM_UNDEF", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaResourceStream {
    public static final MediaResourceStream INSTANCE = new MediaResourceStream();
    public static final int PLAYER_AUDIO_STREAM_UNDEF = -1;
    public static final int PLAYER_VIDEO_STREAM_1080P = 80;
    public static final int PLAYER_VIDEO_STREAM_1080P_60FPS = 116;
    public static final int PLAYER_VIDEO_STREAM_1080P_PLUS = 112;
    public static final int PLAYER_VIDEO_STREAM_360P = 16;
    public static final int PLAYER_VIDEO_STREAM_480P = 32;
    public static final int PLAYER_VIDEO_STREAM_4K = 120;
    public static final int PLAYER_VIDEO_STREAM_720P = 64;
    public static final int PLAYER_VIDEO_STREAM_AUTO = 0;
    public static final int PLAYER_VIDEO_STREAM_UNDEF = -1;

    private MediaResourceStream() {
    }
}