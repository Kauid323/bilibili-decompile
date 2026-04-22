package tv.danmaku.videoplayer.coreV2;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;

/* compiled from: IMediaPlayContext.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0003)*+J\b\u0010\u0003\u001a\u00020\u0001H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J'\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u0006H&J\u000e\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH&J\b\u0010\u001d\u001a\u00020\u0017H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001fH&J\b\u0010\"\u001a\u00020\u0015H&J\b\u0010#\u001a\u00020\u0015H&J\b\u0010$\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0015H&J\b\u0010(\u001a\u00020\u0015H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext;", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayControlContext;", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "getMediaPlayControlContext", "getMediaPlayRenderContext", "isPlaying", "", "isPaused", "isPlayCompleted", "isPrepared", "supportOperator", "op", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;", "invokeOp", "T", "params", "", "(Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;Ljava/lang/Object;)Ljava/lang/Object;", "getBufferedPercentage", "", "getPlayerType", "", "setOnExtraInfoListener", "", "listener", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnExtraInfoListener;", "isIjkPlayer", "getCurrentMediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "reset", "fetchPlayAdapter", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;", "recoveryPlayAdapter", "mediaPlayAdapter", "getDefaultAudioIndex", "getCurrentAudioIndex", "getAudioStreamsIndex", "", "setAudioIndex", "index", "getCurrentState", "Companion", "OnExtraInfoListener", "OnMediaStreamChangedListener", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaPlayContext extends IMediaPlayControlContext, IMediaPlayRenderContext {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int EXTRA_MEDIA_ITEM_WILL_RELEASE = 7;
    public static final int EXTRA_MEDIA_PLAYING_ITEM_WILL_CHANGE = 8;
    public static final int EXTRA_PLAYER_PREPARED_FROM_ABSENT_BY_OTHER = 5;
    public static final int EXTRA_PLAYER_RESTORE_FROM_ABSENT_BY_OTHER = 4;
    public static final int EXTRA_PLAYER_WILL_ABSENT_BY_OTHER = 1;
    public static final int EXTRA_PLAYER_WILL_BECOME_ACTIVE_BY_OTHER = 2;
    public static final int EXTRA_PLAYER_WILL_RELEASE = 6;
    public static final int EXTRA_PLAYER_WILL_RESIGN_ACTIVE_BY_OTHER = 3;

    /* compiled from: IMediaPlayContext.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnExtraInfoListener;", "", "onInfo", "", "what", "", "params", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnExtraInfoListener {
        void onInfo(int i, Object obj);
    }

    IMediaPlayAdapter fetchPlayAdapter();

    int[] getAudioStreamsIndex();

    float getBufferedPercentage();

    int getCurrentAudioIndex();

    MediaItem<?> getCurrentMediaItem();

    int getCurrentState();

    int getDefaultAudioIndex();

    IMediaPlayControlContext getMediaPlayControlContext();

    IMediaPlayRenderContext getMediaPlayRenderContext();

    int getPlayerType();

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    <T> T invokeOp(IMediaPlayAdapter.Ops ops, Object obj);

    boolean isIjkPlayer();

    boolean isPaused();

    boolean isPlayCompleted();

    boolean isPlaying();

    boolean isPrepared();

    void recoveryPlayAdapter(IMediaPlayAdapter iMediaPlayAdapter);

    void reset();

    int setAudioIndex(int i);

    void setOnExtraInfoListener(OnExtraInfoListener onExtraInfoListener);

    boolean supportOperator(IMediaPlayAdapter.Ops ops);

    /* compiled from: IMediaPlayContext.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$Companion;", "", "<init>", "()V", "EXTRA_PLAYER_WILL_ABSENT_BY_OTHER", "", "EXTRA_PLAYER_WILL_BECOME_ACTIVE_BY_OTHER", "EXTRA_PLAYER_WILL_RESIGN_ACTIVE_BY_OTHER", "EXTRA_PLAYER_RESTORE_FROM_ABSENT_BY_OTHER", "EXTRA_PLAYER_PREPARED_FROM_ABSENT_BY_OTHER", "EXTRA_PLAYER_WILL_RELEASE", "EXTRA_MEDIA_ITEM_WILL_RELEASE", "EXTRA_MEDIA_PLAYING_ITEM_WILL_CHANGE", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int EXTRA_MEDIA_ITEM_WILL_RELEASE = 7;
        public static final int EXTRA_MEDIA_PLAYING_ITEM_WILL_CHANGE = 8;
        public static final int EXTRA_PLAYER_PREPARED_FROM_ABSENT_BY_OTHER = 5;
        public static final int EXTRA_PLAYER_RESTORE_FROM_ABSENT_BY_OTHER = 4;
        public static final int EXTRA_PLAYER_WILL_ABSENT_BY_OTHER = 1;
        public static final int EXTRA_PLAYER_WILL_BECOME_ACTIVE_BY_OTHER = 2;
        public static final int EXTRA_PLAYER_WILL_RELEASE = 6;
        public static final int EXTRA_PLAYER_WILL_RESIGN_ACTIVE_BY_OTHER = 3;

        private Companion() {
        }
    }

    /* compiled from: IMediaPlayContext.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnMediaStreamChangedListener;", "", "onVideoStreamChanged", "", "isSuccess", "", "oldStream", "", "newStream", "fromAuto", "onAudioStreamChanged", "onRecommendVideoStreamStarted", "stream", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnMediaStreamChangedListener {
        void onAudioStreamChanged(boolean z, int i, int i2, boolean z2);

        void onRecommendVideoStreamStarted(int i);

        void onVideoStreamChanged(boolean z, int i, int i2, boolean z2);

        /* compiled from: IMediaPlayContext.kt */
        /* renamed from: tv.danmaku.videoplayer.coreV2.IMediaPlayContext$OnMediaStreamChangedListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static void $default$onRecommendVideoStreamStarted(OnMediaStreamChangedListener _this, int stream) {
            }
        }
    }
}