package tv.danmaku.biliplayerv2.service;

import android.app.Application;
import android.content.Context;
import bili.resource.common.R;
import com.bilibili.base.BiliContext;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.player.history.IMediaHistoryStorage;
import com.bilibili.player.history.MediaHistoryEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.IPlayDirector;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.service.resolve.ResolvePlayerSDKTask;
import tv.danmaku.biliplayerv2.service.resolve.Task;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IVideoPlayDirectorService.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 L2\u00020\u0001:\u0003LMNJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001c\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u0007H&J\b\u0010\u001e\u001a\u00020\u0007H&J\b\u0010\u001f\u001a\u00020\u000bH&J\b\u0010 \u001a\u00020\u000bH&J\b\u0010!\u001a\u00020\u000bH&J\b\u0010\"\u001a\u00020\u000bH&J\b\u0010#\u001a\u00020\u000bH&J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000bH&J\b\u0010&\u001a\u00020\u000bH&J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000bH&J\b\u0010)\u001a\u00020\u000bH&J\u001e\u0010*\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H&J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u000200H&J\n\u00101\u001a\u0004\u0018\u000100H&J\u0018\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u000205H&J\u0010\u00106\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0005H&J\u0010\u00106\u001a\u00020\u00072\u0006\u00104\u001a\u000205H&J\b\u00107\u001a\u00020\u000bH&J\u0012\u00108\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010:H&J\n\u0010;\u001a\u0004\u0018\u00010:H&J\u0012\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010>H&J\n\u0010?\u001a\u0004\u0018\u00010>H&J\b\u0010@\u001a\u00020\u0005H&J\u0010\u0010A\u001a\u00020\u00072\u0006\u00109\u001a\u00020BH&J\b\u0010C\u001a\u00020BH&J\u0012\u0010D\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010FH&J\u0018\u0010G\u001a\u00020\u00072\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IH&J\b\u0010K\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006OÀ\u0006\u0003"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService;", "Ltv/danmaku/biliplayerv2/service/IPlayDirector;", "getCurrentVideo", "Ltv/danmaku/biliplayerv2/service/Video;", "getCurrentVideoIndex", "", "play", "", "index", "itemIndex", "autoStart", "", "playFromShared", "playNext", "loop", "playNextVideo", "playNextVideoItem", "playPreVideo", "fromBegin", "playPreVideoItem", "playPrevious", "playVideoItem", "item", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "addVideoPlayEventListener", "listener", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "removeVideoPlayEventListener", "replayCurrentVideo", "replayCurrentVideoItem", "reloadCurrentVideoItem", "hasNext", "hasPrevious", "hasPreVideo", "hasNextVideo", "hasNextVideoItem", "setProcessCompleteActionEnable", "enable", "isProcessCompleteActionEnable", "setProcessCompleteActionAvailable", "available", "isProcessCompleteActionAvailable", "updateMediaResource", "outerResolveListener", "Ltv/danmaku/biliplayerv2/service/ResolveListener;", "triggerResolveAndAutoStart", "setPlayerDataSource", "source", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "getPlayerDataSource", "registerVideoPlayHandler", "type", "handler", "Ltv/danmaku/biliplayerv2/service/VideoPlayHandler;", "unregisterVideoPlayHandler", "willAutoPlayNext", "setVideoQualityProvider", "provider", "Ltv/danmaku/biliplayerv2/service/IVideoQualityProvider;", "getVideoQualityProvider", "setMediaItemSettingInterceptor", "interceptor", "Ltv/danmaku/biliplayerv2/service/IMediaItemParamsInterceptor;", "getMediaItemSettingInterceptor", "getCurrentExpectedQuality", "setCommonResolveTaskProvider", "Ltv/danmaku/biliplayerv2/service/resolve/CommonResolveTaskProvider;", "getCommonResolveTaskProvider", "setHistoryProgressReader", "reader", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "setMediaHistoryStorage", "storage", "Lcom/bilibili/player/history/IMediaHistoryStorage;", "Lcom/bilibili/player/history/MediaHistoryEntry;", "resolveDanmaku", "Companion", "VideoPlayEventListener", "IVideoPlayEventDispatcher", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IVideosPlayDirectorService extends IPlayDirector {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String KEY_SHARE_CURRENT_VIDEO_INDEX = "key_share_current_video_index";
    public static final String KEY_SHARE_CURRENT_VIDEO_ITEM = "key_share_current_video_item";
    public static final String KEY_SHARE_PLAYER_DATA_SOURCE = "key_share_player_data_source";
    public static final String KEY_SHARE_PLAYER_PLAYABLE_PARAMS = "key_share_player_playable_params";
    public static final int VIDEO_TYPE_NORMAL = 2;
    public static final int VIDEO_TYPE_UNKNOWN = -1;

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$IVideoPlayEventDispatcher;", "", "dispatchVideoStart", "", "video", "Ltv/danmaku/biliplayerv2/service/Video;", "dispatchVideoItemWillChange", "old", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "new", "dispatchVideoItemStart", "item", "dispatchVideoItemCompleted", "dispatchVideoCompleted", "dispatchResolveFailed", "playableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "errorMsg", "", "dispatchResolveSucceed", "dispatchPlayableParamsChanged", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IVideoPlayEventDispatcher {
        void dispatchPlayableParamsChanged(Video.PlayableParams playableParams);

        void dispatchResolveFailed(Video video2, Video.PlayableParams playableParams, String str);

        void dispatchResolveSucceed();

        void dispatchVideoCompleted(Video video2);

        void dispatchVideoItemCompleted(CurrentVideoPointer currentVideoPointer, Video video2);

        void dispatchVideoItemStart(CurrentVideoPointer currentVideoPointer, Video video2);

        void dispatchVideoItemWillChange(CurrentVideoPointer currentVideoPointer, CurrentVideoPointer currentVideoPointer2, Video video2);

        void dispatchVideoStart(Video video2);
    }

    void addVideoPlayEventListener(VideoPlayEventListener videoPlayEventListener);

    CommonResolveTaskProvider getCommonResolveTaskProvider();

    int getCurrentExpectedQuality();

    Video getCurrentVideo();

    int getCurrentVideoIndex();

    IMediaItemParamsInterceptor getMediaItemSettingInterceptor();

    PlayerDataSource getPlayerDataSource();

    IVideoQualityProvider getVideoQualityProvider();

    boolean hasNext();

    boolean hasNextVideo();

    boolean hasNextVideoItem();

    boolean hasPreVideo();

    boolean hasPrevious();

    boolean isProcessCompleteActionAvailable();

    boolean isProcessCompleteActionEnable();

    void play(int i, int i2);

    void play(int i, int i2, boolean z);

    void playFromShared();

    void playNext(boolean z);

    void playNextVideo();

    void playNextVideoItem(boolean z);

    void playPreVideo(boolean z);

    void playPreVideoItem(boolean z);

    void playPrevious(boolean z);

    void playVideoItem(CurrentVideoPointer currentVideoPointer);

    void registerVideoPlayHandler(int i, VideoPlayHandler videoPlayHandler);

    void reloadCurrentVideoItem();

    void removeVideoPlayEventListener(VideoPlayEventListener videoPlayEventListener);

    void replayCurrentVideo();

    void replayCurrentVideoItem();

    void resolveDanmaku();

    void setCommonResolveTaskProvider(CommonResolveTaskProvider commonResolveTaskProvider);

    void setHistoryProgressReader(AbsMediaResourceResolveTask.IHistoryProgressReader iHistoryProgressReader);

    void setMediaHistoryStorage(IMediaHistoryStorage<MediaHistoryEntry> iMediaHistoryStorage);

    void setMediaItemSettingInterceptor(IMediaItemParamsInterceptor iMediaItemParamsInterceptor);

    void setPlayerDataSource(PlayerDataSource playerDataSource);

    void setProcessCompleteActionAvailable(boolean z);

    void setProcessCompleteActionEnable(boolean z);

    void setVideoQualityProvider(IVideoQualityProvider iVideoQualityProvider);

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    void triggerResolveAndAutoStart(boolean z);

    void unregisterVideoPlayHandler(int i);

    void unregisterVideoPlayHandler(VideoPlayHandler videoPlayHandler);

    void updateMediaResource(boolean z, ResolveListener resolveListener);

    boolean willAutoPlayNext();

    /* compiled from: IVideoPlayDirectorService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = IVideosPlayDirectorService.Companion;
        }

        public static /* synthetic */ void play$default(IVideosPlayDirectorService iVideosPlayDirectorService, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            iVideosPlayDirectorService.play(i, i2);
        }

        public static /* synthetic */ void play$default(IVideosPlayDirectorService iVideosPlayDirectorService, int i, int i2, boolean z, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            iVideosPlayDirectorService.play(i, i2, z);
        }

        public static /* synthetic */ void updateMediaResource$default(IVideosPlayDirectorService iVideosPlayDirectorService, boolean z, ResolveListener resolveListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMediaResource");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                resolveListener = null;
            }
            iVideosPlayDirectorService.updateMediaResource(z, resolveListener);
        }
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean hasPrevious(IVideosPlayDirectorService $this, boolean loop) {
            return IPlayDirector.CC.$default$hasPrevious($this, loop);
        }

        @Deprecated
        public static void triggerResolveAndAutoStart(IVideosPlayDirectorService $this, boolean autoStart) {
            CC.updateMediaResource$default($this, autoStart, null, 2, null);
        }
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$Companion;", "", "<init>", "()V", "VIDEO_TYPE_UNKNOWN", "", "VIDEO_TYPE_NORMAL", "KEY_SHARE_CURRENT_VIDEO_INDEX", "", "KEY_SHARE_PLAYER_PLAYABLE_PARAMS", "KEY_SHARE_PLAYER_DATA_SOURCE", "KEY_SHARE_CURRENT_VIDEO_ITEM", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String KEY_SHARE_CURRENT_VIDEO_INDEX = "key_share_current_video_index";
        public static final String KEY_SHARE_CURRENT_VIDEO_ITEM = "key_share_current_video_item";
        public static final String KEY_SHARE_PLAYER_DATA_SOURCE = "key_share_player_data_source";
        public static final String KEY_SHARE_PLAYER_PLAYABLE_PARAMS = "key_share_player_playable_params";
        public static final int VIDEO_TYPE_NORMAL = 2;
        public static final int VIDEO_TYPE_UNKNOWN = -1;

        private Companion() {
        }
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J.\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "", "onVideoWillChange", "", "old", "Ltv/danmaku/biliplayerv2/service/Video;", "new", "onVideoStart", "video", "onVideoItemWillChange", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "onVideoItemStart", "item", "onVideoItemCompleted", "onVideoCompleted", "onAllVideoCompleted", "onVideoSetWillChange", "onVideoSetChanged", "index", "", "onResolveFailed", "playableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "errorMsg", "", "errorTasks", "", "Ltv/danmaku/biliplayerv2/service/resolve/Task;", "onResolveSucceed", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface VideoPlayEventListener {
        void onAllVideoCompleted();

        void onResolveFailed(Video video2, Video.PlayableParams playableParams, String str);

        void onResolveFailed(Video video2, Video.PlayableParams playableParams, List<? extends Task<?, ?>> list);

        void onResolveSucceed();

        void onVideoCompleted(Video video2);

        void onVideoItemCompleted(CurrentVideoPointer currentVideoPointer, Video video2);

        void onVideoItemStart(CurrentVideoPointer currentVideoPointer, Video video2);

        void onVideoItemWillChange(CurrentVideoPointer currentVideoPointer, CurrentVideoPointer currentVideoPointer2, Video video2);

        void onVideoSetChanged();

        void onVideoSetChanged(int i);

        void onVideoSetWillChange();

        void onVideoStart(Video video2);

        void onVideoWillChange(Video video2, Video video3);

        /* compiled from: IVideoPlayDirectorService.kt */
        /* renamed from: tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService$VideoPlayEventListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static void $default$onVideoWillChange(VideoPlayEventListener _this, Video old, Video video2) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(video2, "new");
            }

            public static void $default$onVideoItemWillChange(VideoPlayEventListener _this, CurrentVideoPointer old, CurrentVideoPointer currentVideoPointer, Video video2) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(currentVideoPointer, "new");
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            public static void $default$onVideoItemStart(VideoPlayEventListener _this, CurrentVideoPointer item, Video video2) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            public static void $default$onVideoItemCompleted(VideoPlayEventListener _this, CurrentVideoPointer item, Video video2) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            public static void $default$onAllVideoCompleted(VideoPlayEventListener _this) {
            }

            public static void $default$onVideoSetWillChange(VideoPlayEventListener _this) {
            }

            public static void $default$onVideoSetChanged(VideoPlayEventListener _this) {
            }

            public static void $default$onVideoSetChanged(VideoPlayEventListener _this, int index) {
            }

            public static void $default$onResolveFailed(VideoPlayEventListener _this, Video video2, Video.PlayableParams playableParams, String errorMsg) {
                Intrinsics.checkNotNullParameter(video2, "video");
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            }

            public static void $default$onResolveFailed(VideoPlayEventListener _this, Video video2, Video.PlayableParams playableParams, List list) {
                Context applicationContext;
                Iterable errorTasks = EnhancedUnmodifiabilityKt.unmodifiable(list);
                Intrinsics.checkNotNullParameter(video2, "video");
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
                Intrinsics.checkNotNullParameter(errorTasks, "errorTasks");
                Application application = BiliContext.application();
                String string = (application == null || (applicationContext = application.getApplicationContext()) == null) ? null : applicationContext.getString(R.string.common_global_string_91);
                Iterable $this$forEach$iv = errorTasks;
                for (Object element$iv : $this$forEach$iv) {
                    Task it = (Task) element$iv;
                    if (it instanceof ResolvePlayerSDKTask) {
                        string = ((ResolvePlayerSDKTask) it).getError();
                    }
                }
                _this.onResolveFailed(video2, playableParams, string == null ? "" : string);
            }

            public static void $default$onResolveSucceed(VideoPlayEventListener _this) {
            }
        }

        /* compiled from: IVideoPlayDirectorService.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static void onVideoWillChange(VideoPlayEventListener $this, Video old, Video video2) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(video2, "new");
                CC.$default$onVideoWillChange($this, old, video2);
            }

            @Deprecated
            public static void onVideoStart(VideoPlayEventListener $this, Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Deprecated
            public static void onVideoItemWillChange(VideoPlayEventListener $this, CurrentVideoPointer old, CurrentVideoPointer currentVideoPointer, Video video2) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(currentVideoPointer, "new");
                Intrinsics.checkNotNullParameter(video2, "video");
                CC.$default$onVideoItemWillChange($this, old, currentVideoPointer, video2);
            }

            @Deprecated
            public static void onVideoItemStart(VideoPlayEventListener $this, CurrentVideoPointer item, Video video2) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(video2, "video");
                CC.$default$onVideoItemStart($this, item, video2);
            }

            @Deprecated
            public static void onVideoItemCompleted(VideoPlayEventListener $this, CurrentVideoPointer item, Video video2) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(video2, "video");
                CC.$default$onVideoItemCompleted($this, item, video2);
            }

            @Deprecated
            public static void onVideoCompleted(VideoPlayEventListener $this, Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Deprecated
            public static void onAllVideoCompleted(VideoPlayEventListener $this) {
                CC.$default$onAllVideoCompleted($this);
            }

            @Deprecated
            public static void onVideoSetWillChange(VideoPlayEventListener $this) {
                CC.$default$onVideoSetWillChange($this);
            }

            @Deprecated
            public static void onVideoSetChanged(VideoPlayEventListener $this) {
                CC.$default$onVideoSetChanged($this);
            }

            @Deprecated
            public static void onVideoSetChanged(VideoPlayEventListener $this, int index) {
                CC.$default$onVideoSetChanged($this, index);
            }

            @Deprecated
            public static void onResolveFailed(VideoPlayEventListener $this, Video video2, Video.PlayableParams playableParams, String errorMsg) {
                Intrinsics.checkNotNullParameter(video2, "video");
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                CC.$default$onResolveFailed($this, video2, playableParams, errorMsg);
            }

            @Deprecated
            public static void onResolveFailed(VideoPlayEventListener $this, Video video2, Video.PlayableParams playableParams, List<? extends Task<?, ?>> list) {
                Intrinsics.checkNotNullParameter(video2, "video");
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
                Intrinsics.checkNotNullParameter(list, "errorTasks");
                CC.$default$onResolveFailed($this, video2, playableParams, list);
            }

            @Deprecated
            public static void onResolveSucceed(VideoPlayEventListener $this) {
                CC.$default$onResolveSucceed($this);
            }
        }
    }
}