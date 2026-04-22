package tv.danmaku.bili.ui.videospace;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.authorspace.IAuthorSpaceHeaderPlayerService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.playerbizcommon.features.background.BackgroundPlayService;
import com.bilibili.playerbizcommon.features.hardware.HardwareService;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerWindowManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.ControlContainerObserver;
import tv.danmaku.biliplayerv2.service.IControlContainerService;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerServiceManager;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.IVideoQualityProvider;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.OnMeteredNetworkUrlHookListener;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.PlayerErrorObserver;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.ScreenOrientationDelegate;
import tv.danmaku.biliplayerv2.service.SeekService;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: AuthorSpaceHeaderPlayerFragment.kt */
@Metadata(d1 = {"\u0000ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0003'*-\b\u0007\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0001wB\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010/\u001a\u000200H\u0016J6\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00112\b\u00106\u001a\u0004\u0018\u00010\"2\b\u00107\u001a\u0004\u0018\u00010$H\u0016J\u0018\u00108\u001a\u0002002\u0006\u00109\u001a\u0002042\u0006\u0010:\u001a\u000204H\u0016J\b\u0010;\u001a\u000200H\u0016J\b\u0010<\u001a\u000200H\u0016J\b\u0010=\u001a\u000200H\u0016J\u0010\u0010>\u001a\u0002002\u0006\u0010?\u001a\u000204H\u0016J\b\u0010@\u001a\u000200H\u0016J\u0010\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u0002002\u0006\u00106\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u0002002\u0006\u00106\u001a\u00020EH\u0016J\u0012\u0010G\u001a\u0002002\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J&\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u000f2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u001a\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020K2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010Q\u001a\u000200H\u0016J\b\u0010R\u001a\u000200H\u0016J\b\u0010S\u001a\u000200H\u0016J\b\u0010T\u001a\u000200H\u0016J\b\u0010U\u001a\u000200H\u0016J\b\u0010V\u001a\u000200H\u0002J\u0010\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u0002002\u0006\u0010[\u001a\u00020\\H\u0016J\u0010\u0010]\u001a\u0002002\u0006\u00106\u001a\u00020\u001fH\u0016J\b\u0010^\u001a\u000204H\u0016J\u001c\u0010_\u001a\u0002002\u0006\u00106\u001a\u00020`2\n\u0010a\u001a\u00020b\"\u000204H\u0016J\u0010\u0010c\u001a\u0002002\u0006\u00106\u001a\u00020`H\u0016J\u0010\u0010d\u001a\u0002002\u0006\u00106\u001a\u00020\"H\u0016J\u0010\u0010e\u001a\u0002002\u0006\u00106\u001a\u00020\"H\u0016J\u0010\u0010f\u001a\u0002002\u0006\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u0002002\u0006\u0010g\u001a\u00020hH\u0016J\u0010\u0010j\u001a\u0002002\u0006\u0010k\u001a\u00020\u0013H\u0016J\u0010\u0010l\u001a\u0002002\u0006\u0010k\u001a\u00020\u0013H\u0002J\u0010\u0010m\u001a\u0002002\u0006\u0010n\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u0002002\u0006\u0010q\u001a\u00020\u0013H\u0016J\b\u0010r\u001a\u00020sH\u0016J\u0010\u0010t\u001a\u0002002\u0006\u0010q\u001a\u00020\u0013H\u0016J\u0010\u0010u\u001a\u0002002\u0006\u0010v\u001a\u000204H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.¨\u0006x"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "mPlayerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "mControlContainerConfig", "Ljava/util/HashMap;", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "Lkotlin/collections/HashMap;", "mVideoContainer", "Landroid/view/ViewGroup;", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "mIsReady", "", "mHardwareServiceClient", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "Lcom/bilibili/playerbizcommon/features/hardware/HardwareService;", "mSeekServiceClient", "Ltv/danmaku/biliplayerv2/service/SeekService;", "mBackgroundServiceClient", "Lcom/bilibili/playerbizcommon/features/background/BackgroundPlayService;", "mAuthorSpaceHeaderPlayerHistoryServiceClient", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerHistoryService;", "mReadyObservers", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController$OnPlayerReadyObserver;", "Lkotlin/collections/ArrayList;", "mRenderStartObserver", "Ltv/danmaku/biliplayerv2/service/IRenderStartObserver;", "mObserver", "Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$RenderObserver;", "mMuteState", "halfScreenOnBack", "tv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerFragment$halfScreenOnBack$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerFragment$halfScreenOnBack$1;", "mPlayerErrorObserver", "tv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerFragment$mPlayerErrorObserver$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerFragment$mPlayerErrorObserver$1;", "mScreenOrientationDelegate", "tv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerFragment$mScreenOrientationDelegate$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerFragment$mScreenOrientationDelegate$1;", "hideLoading", "", "prepare", "playerParams", "containerId", "", "activity", "observer", "renderObserver", "play", "videoIndex", "itemIndex", "replay", "resume", "pause", "seekTo", "progress", "release", "updateDataSource", "dataSource", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "registerProgressObserver", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterProgressObserver", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "onPause", "onStart", "onResume", "onStop", "onDestroy", "onReady", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setMeteredNetworkUrlHookListener", "meteredNetworkUrlHookListener", "Ltv/danmaku/biliplayerv2/service/OnMeteredNetworkUrlHookListener;", "observePlayerReady", "getPlayerState", "observePlayerState", "Ltv/danmaku/biliplayerv2/service/PlayerStateObserver;", "states", "", "unObservePlayerState", "registerRenderStartObserver", "unRegisterRenderStartObserver", "addVideoPlayEventListener", "listener", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "removeVideoPlayEventListener", "setMuteState", "mute", "setMute", "setAspectRatio", "aspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "setControllerEnable", "enable", "getVideoRatio", "", "enableScreenGravity", "setViewPortOffset", "offset", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorSpaceHeaderPlayerFragment extends BaseFragment implements IAuthorSpaceHeaderPlayerController {
    private static final String FRAGMENT_TAG = "author_space_header_player_fragment";
    private static final String TAG = "AuthorSpaceHeaderPlayerFragment";
    private FragmentActivity mActivity;
    private boolean mIsReady;
    private IAuthorSpaceHeaderPlayerService.RenderObserver mObserver;
    private IPlayerContainer mPlayerContainer;
    private PlayerParamsV2 mPlayerParams;
    private IRenderStartObserver mRenderStartObserver;
    private ViewGroup mVideoContainer;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final HashMap<ControlContainerType, ControlContainerConfig> mControlContainerConfig = new HashMap<>();
    private final PlayerServiceManager.Client<HardwareService> mHardwareServiceClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<SeekService> mSeekServiceClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<BackgroundPlayService> mBackgroundServiceClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<AuthorSpaceHeaderPlayerHistoryService> mAuthorSpaceHeaderPlayerHistoryServiceClient = new PlayerServiceManager.Client<>();
    private final ArrayList<IAuthorSpaceHeaderPlayerController.OnPlayerReadyObserver> mReadyObservers = new ArrayList<>(2);
    private boolean mMuteState = true;
    private final AuthorSpaceHeaderPlayerFragment$halfScreenOnBack$1 halfScreenOnBack = new OnBackPressedCallback() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerFragment$halfScreenOnBack$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        public void handleOnBackPressed() {
            PlayerServiceManager.Client client;
            client = AuthorSpaceHeaderPlayerFragment.this.mHardwareServiceClient;
            HardwareService service = client.getService();
            if (service != null) {
                service.performBackPressed();
            }
        }
    };
    private final AuthorSpaceHeaderPlayerFragment$mPlayerErrorObserver$1 mPlayerErrorObserver = new PlayerErrorObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerFragment$mPlayerErrorObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerErrorObserver
        public void onPlayerError(IMediaPlayer player, int what, int extra) {
            IPlayerContainer iPlayerContainer;
            IAuthorSpaceHeaderPlayerService.RenderObserver renderObserver;
            IVideosPlayDirectorService videoPlayDirectorService;
            Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
            BLog.i("AuthorSpaceHeaderPlayerFragment", "player error" + what + ", reload");
            iPlayerContainer = AuthorSpaceHeaderPlayerFragment.this.mPlayerContainer;
            if (iPlayerContainer != null && (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) != null) {
                IVideosPlayDirectorService.CC.updateMediaResource$default(videoPlayDirectorService, false, null, 3, null);
            }
            renderObserver = AuthorSpaceHeaderPlayerFragment.this.mObserver;
            if (renderObserver != null) {
                renderObserver.onPlayerError(what);
            }
        }
    };
    private final AuthorSpaceHeaderPlayerFragment$mScreenOrientationDelegate$1 mScreenOrientationDelegate = new ScreenOrientationDelegate() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerFragment$mScreenOrientationDelegate$1
        @Override // tv.danmaku.biliplayerv2.service.ScreenOrientationDelegate
        public /* synthetic */ void enterFullScreen() {
            ScreenOrientationDelegate.CC.$default$enterFullScreen(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.ScreenOrientationDelegate
        public void switchOrientation(int orientation) {
            PlayerServiceManager.Client client;
            client = AuthorSpaceHeaderPlayerFragment.this.mHardwareServiceClient;
            HardwareService service = client.getService();
            if (service != null) {
                service.switchScreenOrientation(orientation);
            }
        }
    };

    /* compiled from: AuthorSpaceHeaderPlayerFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerFragment$Companion;", "", "<init>", "()V", "FRAGMENT_TAG", "", "TAG", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void hideLoading() {
        AbsFunctionWidgetService functionWidgetService;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (functionWidgetService = iPlayerContainer.getFunctionWidgetService()) == null) {
            return;
        }
        AbsFunctionWidgetService.CC.disableBufferingView$default(functionWidgetService, false, 1, null);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void prepare(PlayerParamsV2 playerParams, int containerId, FragmentActivity activity, IRenderStartObserver observer, IAuthorSpaceHeaderPlayerService.RenderObserver renderObserver) {
        Intrinsics.checkNotNullParameter(playerParams, "playerParams");
        if (activity == null) {
            return;
        }
        this.mActivity = activity;
        this.mRenderStartObserver = observer;
        this.mObserver = renderObserver;
        ControlContainerConfig landscapeFullscreen = new ControlContainerConfig();
        landscapeFullscreen.setScreenModeType(ScreenModeType.LANDSCAPE_FULLSCREEN);
        landscapeFullscreen.setLayoutRes(R.layout.bili_player_controller_landscape_fullscreen);
        this.mControlContainerConfig.put(ControlContainerType.LANDSCAPE_FULLSCREEN, landscapeFullscreen);
        ControlContainerConfig verticalFullscreen = new ControlContainerConfig();
        verticalFullscreen.setScreenModeType(ScreenModeType.VERTICAL_FULLSCREEN);
        verticalFullscreen.setLayoutRes(R.layout.bili_player_controller_vertical_fullscreen);
        this.mControlContainerConfig.put(ControlContainerType.VERTICAL_FULLSCREEN, verticalFullscreen);
        ControlContainerConfig halfScreen = new ControlContainerConfig();
        halfScreen.setScreenModeType(ScreenModeType.THUMB);
        halfScreen.setLayoutRes(R.layout.bili_player_controller_half_screen);
        this.mControlContainerConfig.put(ControlContainerType.HALF_SCREEN, halfScreen);
        this.mPlayerParams = playerParams;
        if (containerId != 0) {
            this.mVideoContainer = (ViewGroup) activity.findViewById(containerId);
            activity.getSupportFragmentManager().beginTransaction().replace(containerId, (Fragment) this, FRAGMENT_TAG).commitNowAllowingStateLoss();
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void play(int videoIndex, int itemIndex) {
        IPlayerContainer iPlayerContainer;
        IVideosPlayDirectorService videoPlayDirectorService;
        if (this.mIsReady && (iPlayerContainer = this.mPlayerContainer) != null && (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) != null) {
            videoPlayDirectorService.play(videoIndex, itemIndex);
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void replay() {
        IPlayerContainer iPlayerContainer;
        IVideosPlayDirectorService videoPlayDirectorService;
        if (this.mIsReady && (iPlayerContainer = this.mPlayerContainer) != null && (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) != null) {
            videoPlayDirectorService.replayCurrentVideoItem();
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void resume() {
        IPlayerCoreService playerCoreService;
        if (!this.mIsReady) {
            return;
        }
        BLog.d(TAG, "resume, mute state " + this.mMuteState);
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null && (playerCoreService = iPlayerContainer.getPlayerCoreService()) != null) {
            playerCoreService.resume();
        }
        setMute(this.mMuteState);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void pause() {
        IPlayerContainer iPlayerContainer;
        IPlayerCoreService playerCoreService;
        if (this.mIsReady && (iPlayerContainer = this.mPlayerContainer) != null && (playerCoreService = iPlayerContainer.getPlayerCoreService()) != null) {
            playerCoreService.pause();
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void seekTo(int progress) {
        IPlayerContainer iPlayerContainer;
        IPlayerCoreService playerCoreService;
        if (this.mIsReady && (iPlayerContainer = this.mPlayerContainer) != null && (playerCoreService = iPlayerContainer.getPlayerCoreService()) != null) {
            playerCoreService.seekTo(progress);
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void release() {
        IPlayerCoreService playerCoreService;
        IPlayerContainer iPlayerContainer;
        IPlayerCoreService playerCoreService2;
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove((Fragment) this)) != null) {
            remove.commitNowAllowingStateLoss();
        }
        IRenderStartObserver it = this.mRenderStartObserver;
        if (it != null && (iPlayerContainer = this.mPlayerContainer) != null && (playerCoreService2 = iPlayerContainer.getPlayerCoreService()) != null) {
            playerCoreService2.removeRenderStartObserver(it);
        }
        this.mObserver = null;
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 != null && (playerCoreService = iPlayerContainer2.getPlayerCoreService()) != null) {
            playerCoreService.unregisterPlayerErrorObserver(this.mPlayerErrorObserver);
        }
        this.mPlayerContainer = null;
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void updateDataSource(PlayerDataSource dataSource) {
        IVideosPlayDirectorService videoPlayDirectorService;
        IVideosPlayDirectorService videoPlayDirectorService2;
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
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

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void registerProgressObserver(PlayerProgressObserver observer) {
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.registerPlayerProgressObserver(observer);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void unregisterProgressObserver(PlayerProgressObserver observer) {
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.unregisterPlayerProgressObserver(observer);
    }

    public void onCreate(Bundle savedInstanceState) {
        Resources resources;
        Configuration configuration;
        super.onCreate(savedInstanceState);
        if (this.mPlayerContainer == null && this.mPlayerParams != null) {
            PlayerParamsV2 playerParamsV2 = this.mPlayerParams;
            Intrinsics.checkNotNull(playerParamsV2);
            PlayerDataSource playerDataSource = playerParamsV2.getPlayerDataSource();
            Intrinsics.checkNotNull(playerDataSource, "null cannot be cast to non-null type tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerDataSource");
            float displayRotate = ((AuthorSpaceHeaderPlayerDataSource) playerDataSource).getAuthorSpaceHeaderPlayableParams().getDisplayRotate();
            FragmentActivity fragmentActivity = this.mActivity;
            Integer curOrientation = (fragmentActivity == null || (resources = fragmentActivity.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
            if (displayRotate <= 1.0f) {
                PlayerParamsV2 playerParamsV22 = this.mPlayerParams;
                Intrinsics.checkNotNull(playerParamsV22);
                playerParamsV22.getConfig().setInitialControlContainerType(ControlContainerType.VERTICAL_FULLSCREEN);
            } else if (curOrientation != null && curOrientation.intValue() == 2) {
                PlayerParamsV2 playerParamsV23 = this.mPlayerParams;
                Intrinsics.checkNotNull(playerParamsV23);
                playerParamsV23.getConfig().setInitialControlContainerType(ControlContainerType.LANDSCAPE_FULLSCREEN);
            } else {
                PlayerParamsV2 playerParamsV24 = this.mPlayerParams;
                Intrinsics.checkNotNull(playerParamsV24);
                playerParamsV24.getConfig().setInitialControlContainerType(ControlContainerType.HALF_SCREEN);
            }
            IPlayerContainer.Builder builder = new IPlayerContainer.Builder();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            IPlayerContainer.Builder context = builder.setContext(requireContext);
            PlayerParamsV2 playerParamsV25 = this.mPlayerParams;
            Intrinsics.checkNotNull(playerParamsV25);
            this.mPlayerContainer = context.setPlayerParams(playerParamsV25).setControlContainerConfig(this.mControlContainerConfig).build();
        }
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onCreate(savedInstanceState);
        }
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
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onViewCreated(view2, savedInstanceState);
        }
        onReady();
    }

    public void onPause() {
        pause();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onPause();
        }
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            service.stopGravitySensor();
        }
        PlayerLog.i(TAG, "onPause try to stopGravitySensor");
        super.onPause();
    }

    public void onStart() {
        super.onStart();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onStart();
        }
    }

    public void onResume() {
        super.onResume();
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onResume();
        }
        IMiniPlayerWindowManager iMiniPlayerWindowManager = (IMiniPlayerWindowManager) BLRouter.INSTANCE.get(IMiniPlayerWindowManager.class, "default");
        boolean z = false;
        if (iMiniPlayerWindowManager != null && iMiniPlayerWindowManager.isMiniPlayerActive(true)) {
            z = true;
        }
        if (!z) {
            resume();
        }
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            service.startGravitySensor();
        }
    }

    public void onStop() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onStop();
        }
        super.onStop();
    }

    public void onDestroy() {
        IPlayerServiceManager playerServiceManager;
        IPlayerServiceManager playerServiceManager2;
        IPlayerServiceManager playerServiceManager3;
        IPlayerServiceManager playerServiceManager4;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onDestroy();
        }
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 != null && (playerServiceManager4 = iPlayerContainer2.getPlayerServiceManager()) != null) {
            playerServiceManager4.unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(HardwareService.class), this.mHardwareServiceClient);
        }
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 != null && (playerServiceManager3 = iPlayerContainer3.getPlayerServiceManager()) != null) {
            playerServiceManager3.unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(HardwareService.class), this.mSeekServiceClient);
        }
        IPlayerContainer iPlayerContainer4 = this.mPlayerContainer;
        if (iPlayerContainer4 != null && (playerServiceManager2 = iPlayerContainer4.getPlayerServiceManager()) != null) {
            playerServiceManager2.unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(BackgroundPlayService.class), this.mBackgroundServiceClient);
        }
        IPlayerContainer iPlayerContainer5 = this.mPlayerContainer;
        if (iPlayerContainer5 != null && (playerServiceManager = iPlayerContainer5.getPlayerServiceManager()) != null) {
            playerServiceManager.unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(AuthorSpaceHeaderPlayerHistoryService.class), this.mAuthorSpaceHeaderPlayerHistoryServiceClient);
        }
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            service.stopGravitySensor();
        }
        remove();
        super.onDestroy();
    }

    private final void onReady() {
        IControlContainerService controlContainerService;
        IControlContainerService controlContainerService2;
        IPlayerServiceManager playerServiceManager;
        IPlayerServiceManager playerServiceManager2;
        IPlayerServiceManager playerServiceManager3;
        IPlayerCoreService playerCoreService;
        IVideosPlayDirectorService videoPlayDirectorService;
        IPlayerServiceManager playerServiceManager4;
        IPlayerContainer iPlayerContainer;
        IPlayerCoreService playerCoreService2;
        IInteractLayerService interactLayerService;
        this.mIsReady = true;
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 != null && (interactLayerService = iPlayerContainer2.getInteractLayerService()) != null) {
            interactLayerService.setDanmakuEnable(false);
        }
        IRenderStartObserver it = this.mRenderStartObserver;
        if (it != null && (iPlayerContainer = this.mPlayerContainer) != null && (playerCoreService2 = iPlayerContainer.getPlayerCoreService()) != null) {
            playerCoreService2.addRenderStartObserver(it);
        }
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 != null && (playerServiceManager4 = iPlayerContainer3.getPlayerServiceManager()) != null) {
            playerServiceManager4.bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(HardwareService.class), this.mHardwareServiceClient);
        }
        IPlayerContainer iPlayerContainer4 = this.mPlayerContainer;
        if (iPlayerContainer4 != null && (videoPlayDirectorService = iPlayerContainer4.getVideoPlayDirectorService()) != null) {
            videoPlayDirectorService.setVideoQualityProvider(new IVideoQualityProvider() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerFragment$onReady$2
                @Override // tv.danmaku.biliplayerv2.service.IVideoQualityProvider
                public /* synthetic */ int[] getRecommendStartQualityRange() {
                    return IVideoQualityProvider.CC.$default$getRecommendStartQualityRange(this);
                }

                @Override // tv.danmaku.biliplayerv2.service.IVideoQualityProvider
                public int getExpectedQuality(IVideoQualityProvider.ResolveFrom from) {
                    PlayerParamsV2 playerParamsV2;
                    AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams;
                    Intrinsics.checkNotNullParameter(from, "from");
                    playerParamsV2 = AuthorSpaceHeaderPlayerFragment.this.mPlayerParams;
                    PlayerDataSource playerDataSource = playerParamsV2 != null ? playerParamsV2.getPlayerDataSource() : null;
                    AuthorSpaceHeaderPlayerDataSource authorSpaceHeaderPlayerDataSource = playerDataSource instanceof AuthorSpaceHeaderPlayerDataSource ? (AuthorSpaceHeaderPlayerDataSource) playerDataSource : null;
                    if (authorSpaceHeaderPlayerDataSource == null || (authorSpaceHeaderPlayableParams = authorSpaceHeaderPlayerDataSource.getAuthorSpaceHeaderPlayableParams()) == null) {
                        return 32;
                    }
                    return authorSpaceHeaderPlayableParams.getExpectedQuality();
                }
            });
        }
        IPlayerContainer iPlayerContainer5 = this.mPlayerContainer;
        if (iPlayerContainer5 != null && (playerCoreService = iPlayerContainer5.getPlayerCoreService()) != null) {
            playerCoreService.registerPlayerErrorObserver(this.mPlayerErrorObserver);
        }
        IPlayerContainer iPlayerContainer6 = this.mPlayerContainer;
        if (iPlayerContainer6 != null && (playerServiceManager3 = iPlayerContainer6.getPlayerServiceManager()) != null) {
            playerServiceManager3.bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(SeekService.class), this.mSeekServiceClient);
        }
        SeekService service = this.mSeekServiceClient.getService();
        if (service != null) {
            service.setThumbnailEnable(false);
        }
        IPlayerContainer iPlayerContainer7 = this.mPlayerContainer;
        if (iPlayerContainer7 != null && (playerServiceManager2 = iPlayerContainer7.getPlayerServiceManager()) != null) {
            playerServiceManager2.bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(AuthorSpaceHeaderPlayerHistoryService.class), this.mAuthorSpaceHeaderPlayerHistoryServiceClient);
        }
        IPlayerContainer iPlayerContainer8 = this.mPlayerContainer;
        if (iPlayerContainer8 != null && (playerServiceManager = iPlayerContainer8.getPlayerServiceManager()) != null) {
            playerServiceManager.bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(BackgroundPlayService.class), this.mBackgroundServiceClient);
        }
        BackgroundPlayService service2 = this.mBackgroundServiceClient.getService();
        if (service2 != null) {
            service2.setSettingAvailable(false);
        }
        HardwareService service3 = this.mHardwareServiceClient.getService();
        if (service3 != null) {
            FragmentActivity fragmentActivity = this.mActivity;
            Intrinsics.checkNotNull(fragmentActivity);
            Activity activity = this.mActivity;
            Intrinsics.checkNotNull(activity);
            ViewGroup viewGroup = this.mVideoContainer;
            Intrinsics.checkNotNull(viewGroup);
            service3.init(fragmentActivity, new HardwareDelegate(activity, viewGroup));
        }
        HardwareService service4 = this.mHardwareServiceClient.getService();
        if (service4 != null) {
            service4.setGravityEnable(false);
        }
        PlayerLog.i("HardwareService", "player ready, try to startGravitySensor");
        HardwareService service5 = this.mHardwareServiceClient.getService();
        if (service5 != null) {
            service5.startGravitySensor();
        }
        Iterable $this$forEach$iv = this.mReadyObservers;
        for (Object element$iv : $this$forEach$iv) {
            ((IAuthorSpaceHeaderPlayerController.OnPlayerReadyObserver) element$iv).onReady();
        }
        IPlayerContainer iPlayerContainer9 = this.mPlayerContainer;
        if (iPlayerContainer9 != null && (controlContainerService2 = iPlayerContainer9.getControlContainerService()) != null) {
            controlContainerService2.setScreenOrientationDelegate(this.mScreenOrientationDelegate);
        }
        IPlayerContainer iPlayerContainer10 = this.mPlayerContainer;
        if (iPlayerContainer10 != null && (controlContainerService = iPlayerContainer10.getControlContainerService()) != null) {
            controlContainerService.registerState(new ControlContainerObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerFragment$onReady$4
                @Override // tv.danmaku.biliplayerv2.service.ControlContainerObserver
                public void onControlContainerChanged(ControlContainerType state, ScreenModeType screenType) {
                    AuthorSpaceHeaderPlayerFragment$halfScreenOnBack$1 authorSpaceHeaderPlayerFragment$halfScreenOnBack$1;
                    AuthorSpaceHeaderPlayerFragment$halfScreenOnBack$1 authorSpaceHeaderPlayerFragment$halfScreenOnBack$12;
                    Intrinsics.checkNotNullParameter(state, "state");
                    Intrinsics.checkNotNullParameter(screenType, "screenType");
                    if (screenType != ScreenModeType.LANDSCAPE_FULLSCREEN) {
                        authorSpaceHeaderPlayerFragment$halfScreenOnBack$1 = AuthorSpaceHeaderPlayerFragment.this.halfScreenOnBack;
                        authorSpaceHeaderPlayerFragment$halfScreenOnBack$1.remove();
                        return;
                    }
                    OnBackPressedDispatcher onBackPressedDispatcher = AuthorSpaceHeaderPlayerFragment.this.requireActivity().getOnBackPressedDispatcher();
                    authorSpaceHeaderPlayerFragment$halfScreenOnBack$12 = AuthorSpaceHeaderPlayerFragment.this.halfScreenOnBack;
                    onBackPressedDispatcher.addCallback(authorSpaceHeaderPlayerFragment$halfScreenOnBack$12);
                }
            });
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new AuthorSpaceHeaderPlayerFragment$onReady$5(this, null), 3, (Object) null);
        play(0, 0);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            iPlayerContainer.onConfigurationChanged(newConfig);
        }
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            service.onConfigurationChanged(newConfig);
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void setMeteredNetworkUrlHookListener(OnMeteredNetworkUrlHookListener meteredNetworkUrlHookListener) {
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(meteredNetworkUrlHookListener, "meteredNetworkUrlHookListener");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null && (playerCoreService = iPlayerContainer.getPlayerCoreService()) != null) {
            playerCoreService.setMeteredNetworkUrlHookListener(meteredNetworkUrlHookListener);
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void observePlayerReady(IAuthorSpaceHeaderPlayerController.OnPlayerReadyObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mReadyObservers.add(observer);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public int getPlayerState() {
        IPlayerContainer iPlayerContainer;
        IPlayerCoreService playerCoreService;
        if (!this.mIsReady || (iPlayerContainer = this.mPlayerContainer) == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return 0;
        }
        return playerCoreService.getState();
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void observePlayerState(PlayerStateObserver observer, int... states) {
        IPlayerContainer iPlayerContainer;
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(states, "states");
        if (this.mIsReady && (iPlayerContainer = this.mPlayerContainer) != null && (playerCoreService = iPlayerContainer.getPlayerCoreService()) != null) {
            playerCoreService.registerState(observer, Arrays.copyOf(states, states.length));
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void unObservePlayerState(PlayerStateObserver observer) {
        IPlayerContainer iPlayerContainer;
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mIsReady && (iPlayerContainer = this.mPlayerContainer) != null && (playerCoreService = iPlayerContainer.getPlayerCoreService()) != null) {
            playerCoreService.unregisterState(observer);
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void registerRenderStartObserver(IRenderStartObserver observer) {
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.addRenderStartObserver(observer);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void unRegisterRenderStartObserver(IRenderStartObserver observer) {
        IPlayerCoreService playerCoreService;
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (playerCoreService = iPlayerContainer.getPlayerCoreService()) == null) {
            return;
        }
        playerCoreService.removeRenderStartObserver(observer);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void addVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener) {
        IVideosPlayDirectorService videoPlayDirectorService;
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) == null) {
            return;
        }
        videoPlayDirectorService.addVideoPlayEventListener(listener);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void removeVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener) {
        IVideosPlayDirectorService videoPlayDirectorService;
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (videoPlayDirectorService = iPlayerContainer.getVideoPlayDirectorService()) == null) {
            return;
        }
        videoPlayDirectorService.removeVideoPlayEventListener(listener);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void setMuteState(boolean mute) {
        this.mMuteState = mute;
        setMute(mute);
    }

    private final void setMute(boolean mute) {
        IPlayerCoreService playerCoreService;
        IPlayerCoreService playerCoreService2;
        BLog.d(TAG, "setMute " + mute);
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

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void setAspectRatio(AspectRatio aspectRatio) {
        IPlayerContainer iPlayerContainer;
        IRenderContainerService renderContainerService;
        IRenderContainerService renderContainerService2;
        Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (((iPlayerContainer2 == null || (renderContainerService2 = iPlayerContainer2.getRenderContainerService()) == null) ? null : renderContainerService2.getAspectRatio()) == aspectRatio || (iPlayerContainer = this.mPlayerContainer) == null || (renderContainerService = iPlayerContainer.getRenderContainerService()) == null) {
            return;
        }
        renderContainerService.setAspectRatio(aspectRatio);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void setControllerEnable(boolean enable) {
        IControlContainerService controlContainerService;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (controlContainerService = iPlayerContainer.getControlContainerService()) == null) {
            return;
        }
        IControlContainerService.CC.setControllerEnable$default(controlContainerService, enable, null, 2, null);
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public float getVideoRatio() {
        IRenderContainerService renderContainerService;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        return (iPlayerContainer == null || (renderContainerService = iPlayerContainer.getRenderContainerService()) == null) ? DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN : renderContainerService.getVideoRatio();
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void enableScreenGravity(boolean enable) {
        if (enable) {
            HardwareService service = this.mHardwareServiceClient.getService();
            if (service != null) {
                service.startGravitySensor();
                return;
            }
            return;
        }
        HardwareService service2 = this.mHardwareServiceClient.getService();
        if (service2 != null) {
            service2.stopGravitySensor();
        }
    }

    @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController
    public void setViewPortOffset(int offset) {
        IRenderContainerService renderContainerService;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null || (renderContainerService = iPlayerContainer.getRenderContainerService()) == null) {
            return;
        }
        IRenderContainerService.CC.setViewportOffset$default(renderContainerService, 0, offset, false, 5, null);
    }
}