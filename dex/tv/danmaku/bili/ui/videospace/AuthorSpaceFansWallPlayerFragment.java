package tv.danmaku.bili.ui.videospace;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.app.authorspace.IAuthorSpaceHeaderPlayerService;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.playerbizcommon.features.background.BackgroundPlayService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.PlayerErrorObserver;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: AuthorSpaceFansWallPlayerFragment.kt */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0003\u001d #\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\fJ\u0006\u0010+\u001a\u00020&J\u0006\u0010,\u001a\u00020&J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020&2\u0006\u00101\u001a\u000202J\u000e\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\u001bJ&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u0002072\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020&H\u0016J\b\u0010B\u001a\u00020&H\u0016J\b\u0010C\u001a\u00020&H\u0016J\b\u0010D\u001a\u00020&H\u0016J\b\u0010E\u001a\u00020&H\u0016J\b\u0010F\u001a\u00020&H\u0016J\u000e\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020/J\u000e\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020&2\u0006\u0010J\u001a\u00020KR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006N"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "mObserver", "Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$RenderObserver;", "getMObserver", "()Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$RenderObserver;", "setMObserver", "(Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$RenderObserver;)V", "mCdnUrlList", "", "", "getMCdnUrlList", "()Ljava/util/List;", "setMCdnUrlList", "(Ljava/util/List;)V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "mBackgroundServiceClient", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "Lcom/bilibili/playerbizcommon/features/background/BackgroundPlayService;", "mReadyObservers", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController$OnPlayerReadyObserver;", "Lkotlin/collections/ArrayList;", "isLooping", "", "mPlayerErrorObserver", "tv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment$mPlayerErrorObserver$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment$mPlayerErrorObserver$1;", "mPlayerStartObserver", "tv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment$mPlayerStartObserver$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment$mPlayerStartObserver$1;", "mStateCallback", "tv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment$mStateCallback$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment$mStateCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateDataSource", "url", "pause", "resume", "seekTo", "progress", "", "registerProgressObserver", "observer", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterProgressObserver", "setMuteState", "mute", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "onStart", "onStop", "onDestroyView", "onDestroy", "setViewPortOffset", "offset", "addVideoPlayEventListener", "listener", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "removeVideoPlayEventListener", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorSpaceFansWallPlayerFragment extends BaseFragment {
    public static final String KEY_IS_LOOPING = "is_looping";
    public static final String KEY_URL = "url";
    private static final String TAG = "SpaceFansWallPlayer";
    private List<String> mCdnUrlList;
    private IAuthorSpaceHeaderPlayerService.RenderObserver mObserver;
    private IPlayerContainer mPlayerContainer;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final PlayerServiceManager.Client<BackgroundPlayService> mBackgroundServiceClient = new PlayerServiceManager.Client<>();
    private final ArrayList<IAuthorSpaceHeaderPlayerController.OnPlayerReadyObserver> mReadyObservers = new ArrayList<>(2);
    private boolean isLooping = true;
    private final AuthorSpaceFansWallPlayerFragment$mPlayerErrorObserver$1 mPlayerErrorObserver = new PlayerErrorObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceFansWallPlayerFragment$mPlayerErrorObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerErrorObserver
        public void onPlayerError(IMediaPlayer player, int what, int extra) {
            IPlayerContainer iPlayerContainer;
            IVideosPlayDirectorService videoPlayDirectorService;
            Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
            BLog.i("SpaceFansWallPlayer", "player error" + what + ", reload");
            iPlayerContainer = AuthorSpaceFansWallPlayerFragment.this.mPlayerContainer;
            if (iPlayerContainer != null && (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) != null) {
                IVideosPlayDirectorService.CC.updateMediaResource$default(videoPlayDirectorService, false, null, 3, null);
            }
            IAuthorSpaceHeaderPlayerService.RenderObserver mObserver = AuthorSpaceFansWallPlayerFragment.this.getMObserver();
            if (mObserver != null) {
                mObserver.onPlayerError(what);
            }
        }
    };
    private final AuthorSpaceFansWallPlayerFragment$mPlayerStartObserver$1 mPlayerStartObserver = new IRenderStartObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceFansWallPlayerFragment$mPlayerStartObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public void onVideoRenderStart() {
            IAuthorSpaceHeaderPlayerService.RenderObserver mObserver = AuthorSpaceFansWallPlayerFragment.this.getMObserver();
            if (mObserver != null) {
                mObserver.onVideoRenderStart((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            }
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public void onAudioRenderStart() {
            IAuthorSpaceHeaderPlayerService.RenderObserver mObserver = AuthorSpaceFansWallPlayerFragment.this.getMObserver();
            if (mObserver != null) {
                mObserver.onAudioRenderStart();
            }
        }
    };
    private final AuthorSpaceFansWallPlayerFragment$mStateCallback$1 mStateCallback = new PlayerStateObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceFansWallPlayerFragment$mStateCallback$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            boolean z;
            IPlayerContainer iPlayerContainer;
            IVideosPlayDirectorService videoPlayDirectorService;
            if (state == 6) {
                z = AuthorSpaceFansWallPlayerFragment.this.isLooping;
                if (z) {
                    iPlayerContainer = AuthorSpaceFansWallPlayerFragment.this.mPlayerContainer;
                    if (iPlayerContainer == null || (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) == null) {
                        return;
                    }
                    videoPlayDirectorService.replayCurrentVideoItem();
                } else if (AuthorSpaceFansWallPlayerFragment.this.isAdded()) {
                    IAuthorSpaceHeaderPlayerService.RenderObserver mObserver = AuthorSpaceFansWallPlayerFragment.this.getMObserver();
                    if (mObserver != null) {
                        mObserver.onVideoPlayerRelease();
                    }
                    AuthorSpaceFansWallPlayerFragment.this.getParentFragmentManager().beginTransaction().remove(AuthorSpaceFansWallPlayerFragment.this).commitNowAllowingStateLoss();
                }
            }
        }
    };

    public final IAuthorSpaceHeaderPlayerService.RenderObserver getMObserver() {
        return this.mObserver;
    }

    public final void setMObserver(IAuthorSpaceHeaderPlayerService.RenderObserver renderObserver) {
        this.mObserver = renderObserver;
    }

    public final List<String> getMCdnUrlList() {
        return this.mCdnUrlList;
    }

    public final void setMCdnUrlList(List<String> list) {
        this.mCdnUrlList = list;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.mPlayerContainer == null) {
            PlayerParamsV2 playerParams = new PlayerParamsV2();
            String url = BundleUtil.getString(getArguments(), "url", new String[0]);
            AuthorSpaceHeaderPlayableParams $this$onCreate_u24lambda_u240 = new AuthorSpaceHeaderPlayableParams();
            $this$onCreate_u24lambda_u240.setDirectUrl(true);
            $this$onCreate_u24lambda_u240.setDirectPlayUrl(url);
            Iterable iterable = this.mCdnUrlList;
            if (iterable != null) {
                Iterable $this$forEachIndexed$iv = iterable;
                int index = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv = index + 1;
                    if (index < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String url2 = (String) item$iv;
                    if (index > 0) {
                        $this$onCreate_u24lambda_u240.getBackupUrls().add(url2);
                    }
                    index = index$iv;
                }
            }
            playerParams.setPlayerDataSource(new AuthorSpaceHeaderPlayerDataSource($this$onCreate_u24lambda_u240));
            playerParams.getConfig().setDefaultAspectRatio(AspectRatio.RATIO_CENTER_CROP);
            playerParams.getConfig().setWholeSceneEnable(false);
            playerParams.getConfig().setVideoRenderLayerType(IVideoRenderLayer.Type.TypeTextureViewWithExternalRender);
            ControlContainerConfig verticalFullscreen = new ControlContainerConfig();
            verticalFullscreen.setScreenModeType(ScreenModeType.VERTICAL_FULLSCREEN);
            HashMap controlContainerConfig = new HashMap();
            controlContainerConfig.put(ControlContainerType.VERTICAL_FULLSCREEN, verticalFullscreen);
            this.isLooping = BundleUtil.getBoolean(getArguments(), "is_looping", new boolean[0]);
            IPlayerContainer.Builder builder = new IPlayerContainer.Builder();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.mPlayerContainer = builder.setContext(requireContext).setControlContainerConfig((HashMap<ControlContainerType, ControlContainerConfig>) controlContainerConfig).setPlayerParams(playerParams).build();
        }
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onCreate(savedInstanceState);
        }
    }

    public final void updateDataSource(String url) {
        IVideosPlayDirectorService videoPlayDirectorService;
        IVideosPlayDirectorService videoPlayDirectorService2;
        Intrinsics.checkNotNullParameter(url, "url");
        AuthorSpaceHeaderPlayableParams $this$updateDataSource_u24lambda_u240 = new AuthorSpaceHeaderPlayableParams();
        $this$updateDataSource_u24lambda_u240.setDirectUrl(true);
        $this$updateDataSource_u24lambda_u240.setDirectPlayUrl(url);
        AuthorSpaceHeaderPlayerDataSource dataSource = new AuthorSpaceHeaderPlayerDataSource($this$updateDataSource_u24lambda_u240);
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null && (videoPlayDirectorService2 = iPlayerContainer.getVideoPlayDirectorService()) != null) {
            videoPlayDirectorService2.setPlayerDataSource(dataSource);
        }
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 == null || (videoPlayDirectorService = iPlayerContainer2.getVideoPlayDirectorService()) == null) {
            return;
        }
        videoPlayDirectorService.play(0, 0);
    }

    public final void pause() {
        IPlayerCoreService playerCoreService;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.pause();
    }

    public final void resume() {
        IPlayerCoreService playerCoreService;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.resume();
    }

    public final void seekTo(int progress) {
        IPlayerCoreService playerCoreService;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.seekTo(progress);
    }

    public final void registerProgressObserver(PlayerProgressObserver observer) {
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.registerPlayerProgressObserver(observer);
    }

    public final void unregisterProgressObserver(PlayerProgressObserver observer) {
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.unregisterPlayerProgressObserver(observer);
    }

    public final void setMuteState(boolean mute) {
        IPlayerCoreService playerCoreService;
        IPlayerCoreService playerCoreService2;
        if (mute) {
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer == null || (playerCoreService2 = iPlayerContainer.getPlayerCoreService()) == null) {
                return;
            }
            playerCoreService2.setVolume(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            return;
        }
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 == null || (playerCoreService = iPlayerContainer2.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.setVolume(1.0f, 1.0f);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            return iPlayerContainer.onCreateView(inflater, container, savedInstanceState);
        }
        return null;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        IPlayerContainer player = this.mPlayerContainer;
        if (player != null) {
            player.onViewCreated(view2, savedInstanceState);
            player.getInteractLayerService().setDanmakuEnable(false);
            AbsFunctionWidgetService.CC.disableBufferingView$default(player.getFunctionWidgetService(), false, 1, null);
            player.getPlayerCoreService().registerPlayerErrorObserver(this.mPlayerErrorObserver);
            player.getPlayerCoreService().registerState(this.mStateCallback, 6);
            player.getPlayerCoreService().addRenderStartObserver(this.mPlayerStartObserver);
            player.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(BackgroundPlayService.class), this.mBackgroundServiceClient);
            BackgroundPlayService service = this.mBackgroundServiceClient.getService();
            if (service != null) {
                service.setSettingAvailable(false);
            }
            Iterable $this$forEach$iv = this.mReadyObservers;
            for (Object element$iv : $this$forEach$iv) {
                IAuthorSpaceHeaderPlayerController.OnPlayerReadyObserver it = (IAuthorSpaceHeaderPlayerController.OnPlayerReadyObserver) element$iv;
                it.onReady();
            }
            player.getVideoPlayDirectorService().play(0, 0);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onConfigurationChanged(newConfig);
        }
    }

    public void onPause() {
        super.onPause();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onResume();
        }
    }

    public void onStart() {
        super.onStart();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onStop();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onDestroyView();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onDestroy();
        }
    }

    public final void setViewPortOffset(int offset) {
        IRenderContainerService renderContainerService;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (renderContainerService = iPlayerContainer.getRenderContainerService()) == null) {
            return;
        }
        IRenderContainerService.CC.setViewportOffset$default(renderContainerService, 0, offset, false, 5, null);
    }

    public final void addVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener) {
        IVideosPlayDirectorService videoPlayDirectorService;
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) == null) {
            return;
        }
        videoPlayDirectorService.addVideoPlayEventListener(listener);
    }

    public final void removeVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener) {
        IVideosPlayDirectorService videoPlayDirectorService;
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) == null) {
            return;
        }
        videoPlayDirectorService.removeVideoPlayEventListener(listener);
    }

    /* compiled from: AuthorSpaceFansWallPlayerFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceFansWallPlayerFragment$Companion;", "", "<init>", "()V", "TAG", "", "KEY_URL", "KEY_IS_LOOPING", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}