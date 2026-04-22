package tv.danmaku.bili.ui.videospace;

import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.authorspace.IAuthorSpaceHeaderPlayerService;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.OnMeteredNetworkUrlHookListener;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: AuthorSpaceHeaderPlayerFragment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\bf\u0018\u0000 ?2\u00020\u0001:\u0002?@J\b\u0010\u0002\u001a\u00020\u0003H&J8\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\bH&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u001cH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020%H&J\b\u0010&\u001a\u00020\bH&J\u001c\u0010'\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020(2\n\u0010)\u001a\u00020*\"\u00020\bH&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020(H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H&J\u0010\u00101\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H&J\u0010\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000204H&J\u0010\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u000207H&J\u0010\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u000204H&J\b\u0010:\u001a\u00020;H&J\u0010\u0010<\u001a\u00020\u00032\u0006\u00109\u001a\u000204H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006AÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController;", "", "hideLoading", "", "prepare", "playerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "containerId", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "observer", "Ltv/danmaku/biliplayerv2/service/IRenderStartObserver;", "renderObserver", "Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$RenderObserver;", "play", "videoIndex", "itemIndex", "replay", "resume", "pause", "seekTo", "progress", "release", "updateDataSource", "dataSource", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "registerProgressObserver", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterProgressObserver", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setMeteredNetworkUrlHookListener", "meteredNetworkUrlHookListener", "Ltv/danmaku/biliplayerv2/service/OnMeteredNetworkUrlHookListener;", "observePlayerReady", "Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController$OnPlayerReadyObserver;", "getPlayerState", "observePlayerState", "Ltv/danmaku/biliplayerv2/service/PlayerStateObserver;", "states", "", "unObservePlayerState", "registerRenderStartObserver", "unRegisterRenderStartObserver", "addVideoPlayEventListener", "listener", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "removeVideoPlayEventListener", "setMuteState", "mute", "", "setAspectRatio", "aspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "setControllerEnable", "enable", "getVideoRatio", "", "enableScreenGravity", "setViewPortOffset", "offset", "Companion", "OnPlayerReadyObserver", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IAuthorSpaceHeaderPlayerController {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: AuthorSpaceHeaderPlayerFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController$OnPlayerReadyObserver;", "", "onReady", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnPlayerReadyObserver {
        void onReady();
    }

    void addVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener videoPlayEventListener);

    void enableScreenGravity(boolean z);

    int getPlayerState();

    float getVideoRatio();

    void hideLoading();

    void observePlayerReady(OnPlayerReadyObserver onPlayerReadyObserver);

    void observePlayerState(PlayerStateObserver playerStateObserver, int... iArr);

    void onConfigurationChanged(Configuration configuration);

    void pause();

    void play(int i, int i2);

    void prepare(PlayerParamsV2 playerParamsV2, int i, FragmentActivity fragmentActivity, IRenderStartObserver iRenderStartObserver, IAuthorSpaceHeaderPlayerService.RenderObserver renderObserver);

    void registerProgressObserver(PlayerProgressObserver playerProgressObserver);

    void registerRenderStartObserver(IRenderStartObserver iRenderStartObserver);

    void release();

    void removeVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener videoPlayEventListener);

    void replay();

    void resume();

    void seekTo(int i);

    void setAspectRatio(AspectRatio aspectRatio);

    void setControllerEnable(boolean z);

    void setMeteredNetworkUrlHookListener(OnMeteredNetworkUrlHookListener onMeteredNetworkUrlHookListener);

    void setMuteState(boolean z);

    void setViewPortOffset(int i);

    void unObservePlayerState(PlayerStateObserver playerStateObserver);

    void unRegisterRenderStartObserver(IRenderStartObserver iRenderStartObserver);

    void unregisterProgressObserver(PlayerProgressObserver playerProgressObserver);

    void updateDataSource(PlayerDataSource playerDataSource);

    /* compiled from: AuthorSpaceHeaderPlayerFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final IAuthorSpaceHeaderPlayerController create() {
            return new AuthorSpaceHeaderPlayerFragment();
        }
    }
}