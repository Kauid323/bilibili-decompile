package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.player.plugin.mod.X86IjkRequest;

/* compiled from: IPlayerCoreService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerErrorObserver;", "", "onPlayerError", "", X86IjkRequest.POOL, "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "what", "", "extra", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface PlayerErrorObserver {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int MEDIA_ERROR_DISCONNECT = 10001;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;

    void onPlayerError(IMediaPlayer iMediaPlayer, int i, int i2);

    /* compiled from: IPlayerCoreService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerErrorObserver$Companion;", "", "<init>", "()V", "MEDIA_ERROR_UNKNOWN", "", "MEDIA_ERROR_SERVER_DIED", "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK", "MEDIA_ERROR_IO", "MEDIA_ERROR_MALFORMED", "MEDIA_ERROR_UNSUPPORTED", "MEDIA_ERROR_TIMED_OUT", "MEDIA_ERROR_DISCONNECT", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int MEDIA_ERROR_DISCONNECT = 10001;
        public static final int MEDIA_ERROR_IO = -1004;
        public static final int MEDIA_ERROR_MALFORMED = -1007;
        public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
        public static final int MEDIA_ERROR_SERVER_DIED = 100;
        public static final int MEDIA_ERROR_TIMED_OUT = -110;
        public static final int MEDIA_ERROR_UNKNOWN = 1;
        public static final int MEDIA_ERROR_UNSUPPORTED = -1010;

        private Companion() {
        }
    }
}