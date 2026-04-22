package tv.danmaku.bili.ui.videospace;

import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import bili.resource.share.R;
import com.bilibili.app.authorspace.IAuthorSpaceHeaderPlayerService;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.base.BiliContext;
import com.bilibili.bus.Violet;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.live.LivePlayerOutService;
import com.bilibili.mini.player.common.manager.MiniPlayerManager;
import com.bilibili.mini.player.common.manager.MiniPlayerStateEvent;
import com.bilibili.mini.player.common.manager.MiniScreenPlayerCloseEvent;
import com.bilibili.mini.player.common.manager.MiniScreenPlayerOpenEvent;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerWindowManager;
import com.bilibili.playerbizcommon.utils.PlayUrlFlagsManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController;
import tv.danmaku.biliplayerv2.HookErrorType;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.OnMeteredNetworkUrlHookListener;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.network.PlayerFreeDataHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: AuthorSpaceHeaderPlayer.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0017\u001a\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\b\u0010%\u001a\u00020\u0007H\u0002J(\u0010&\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00102\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0002J\u0006\u0010'\u001a\u00020\u001dJ\u0006\u0010(\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001dJ\u0006\u0010,\u001a\u00020\u001dJ\u0006\u0010-\u001a\u00020\u001dJ\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020 J\u0006\u00103\u001a\u000200J\u0012\u00104\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u00105\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0007J\u000e\u00108\u001a\u00020\u001d2\u0006\u0010#\u001a\u000209J\u000e\u0010:\u001a\u00020\u001d2\u0006\u0010#\u001a\u000209J\u000e\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u0007J\u0006\u0010@\u001a\u00020*J\u000e\u0010A\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u0007J\u000e\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u000200J\u000e\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020FJ\u000e\u0010H\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u0015J\u0006\u0010I\u001a\u00020\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006K"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayer;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isHideLoading", "", "isLooping", "mPlayerController", "Ltv/danmaku/bili/ui/videospace/IAuthorSpaceHeaderPlayerController;", "mContext", "mHasShowMobileToast", "mAuthorSpaceHeaderPlayableParams", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayableParams;", "mRenderObserver", "Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$RenderObserver;", "mPrepared", "mMiniPlayerRouteService", "Lcom/bilibili/playerbizcommon/miniplayer/IMiniPlayerWindowManager;", "mPlayerStateListener", "Lcom/bilibili/app/authorspace/IAuthorSpaceHeaderPlayerService$IPlayerStateListener;", "mMeteredNetworkUrlHookListener", "tv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1;", "mPlayerStateObserver", "tv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayer$mPlayerStateObserver$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayer$mPlayerStateObserver$1;", "createAndPrepareNormalPlayer", "", "urlList", "", "", "videoContainer", "Landroid/view/ViewGroup;", "observer", "exitMiniWindow", "isMiniPlayerPlaying", "initPlayer", "exitAllMiniFloatWindow", "isMiniWindowShowing", "getVideoAspect", "", "releaseNormalPlayer", "onPause", "onResume", "seekTo", "progress", "", "playNext", "url", "getPlayerState", "closeLiveWindow", "isLiveWindowShowing", "setMuteState", "mute", "registerProgressObserver", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterProgressObserver", "setAspectRatio", "aspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "setControllerEnable", "enable", "getVideoRatio", "enableScreenGravity", "setViewPortOffset", "offset", "addVideoPlayEventListener", "listener", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "removeVideoPlayEventListener", "setPlayerStateListener", "resetPlayerStateListener", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorSpaceHeaderPlayer {
    public static final String DEFAULT = "default";
    public static final float DEFAULT_VIDEO_ASPECT = 0.5625f;
    public static final String TAG = "AuthorSpaceHeaderPlayer";
    private boolean isHideLoading;
    private Context mContext;
    private boolean mHasShowMobileToast;
    private IAuthorSpaceHeaderPlayerController mPlayerController;
    private IAuthorSpaceHeaderPlayerService.IPlayerStateListener mPlayerStateListener;
    private boolean mPrepared;
    private IAuthorSpaceHeaderPlayerService.RenderObserver mRenderObserver;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private boolean isLooping = true;
    private AuthorSpaceHeaderPlayableParams mAuthorSpaceHeaderPlayableParams = new AuthorSpaceHeaderPlayableParams();
    private final IMiniPlayerWindowManager mMiniPlayerRouteService = (IMiniPlayerWindowManager) BLRouter.INSTANCE.get(IMiniPlayerWindowManager.class, "default");
    private final AuthorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1 mMeteredNetworkUrlHookListener = new OnMeteredNetworkUrlHookListener() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1
        @Override // tv.danmaku.biliplayerv2.service.OnMeteredNetworkUrlHookListener
        public String onMeteredNetworkUrlHook(String url, IjkNetworkUtils.NetWorkType type, HookErrorType networkErrorType) {
            boolean z;
            Context context;
            Context context2;
            Intrinsics.checkNotNullParameter(type, "type");
            if (type == IjkNetworkUtils.NetWorkType.MOBILE) {
                z = AuthorSpaceHeaderPlayer.this.mHasShowMobileToast;
                if (z) {
                    return url;
                }
                if (PlayerFreeDataHelper.INSTANCE.shouldProcessUrl() && (PlayerFreeDataHelper.INSTANCE.isFreeCardUser() || PlayerFreeDataHelper.INSTANCE.isFreePackageUser())) {
                    if (!PlayerFreeDataHelper.INSTANCE.checkMediaUrlProcessed(url)) {
                        Application application = BiliContext.application();
                        context2 = AuthorSpaceHeaderPlayer.this.mContext;
                        ToastHelper.showToast(application, context2 != null ? context2.getString(R.string.share_global_string_21) : null, 0, 17);
                    }
                } else {
                    Application application2 = BiliContext.application();
                    context = AuthorSpaceHeaderPlayer.this.mContext;
                    ToastHelper.showToast(application2, context != null ? context.getString(R.string.share_global_string_21) : null, 0, 17);
                }
                AuthorSpaceHeaderPlayer.this.mHasShowMobileToast = true;
            } else {
                AuthorSpaceHeaderPlayer.this.mHasShowMobileToast = false;
            }
            return url;
        }
    };
    private final AuthorSpaceHeaderPlayer$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            IAuthorSpaceHeaderPlayerService.IPlayerStateListener iPlayerStateListener;
            boolean z;
            IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController;
            switch (state) {
                case 5:
                    iPlayerStateListener = AuthorSpaceHeaderPlayer.this.mPlayerStateListener;
                    if (iPlayerStateListener != null) {
                        iPlayerStateListener.didPaused();
                        return;
                    }
                    return;
                case 6:
                    z = AuthorSpaceHeaderPlayer.this.isLooping;
                    if (z) {
                        iAuthorSpaceHeaderPlayerController = AuthorSpaceHeaderPlayer.this.mPlayerController;
                        if (iAuthorSpaceHeaderPlayerController != null) {
                            iAuthorSpaceHeaderPlayerController.replay();
                            return;
                        }
                        return;
                    }
                    AuthorSpaceHeaderPlayer.this.releaseNormalPlayer();
                    return;
                default:
                    return;
            }
        }
    };

    /* compiled from: AuthorSpaceHeaderPlayer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayer$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_VIDEO_ASPECT", "", "DEFAULT", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$mPlayerStateObserver$1] */
    public AuthorSpaceHeaderPlayer(Context context) {
        this.mContext = context;
    }

    public static /* synthetic */ void createAndPrepareNormalPlayer$default(AuthorSpaceHeaderPlayer authorSpaceHeaderPlayer, List list, ViewGroup viewGroup, IAuthorSpaceHeaderPlayerService.RenderObserver renderObserver, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        if ((i & 16) == 0) {
            z4 = z2;
        } else {
            z4 = true;
        }
        if ((i & 32) == 0) {
            z5 = z3;
        } else {
            z5 = false;
        }
        authorSpaceHeaderPlayer.createAndPrepareNormalPlayer(list, viewGroup, renderObserver, z, z4, z5);
    }

    public final void createAndPrepareNormalPlayer(final List<String> list, final ViewGroup videoContainer, final IAuthorSpaceHeaderPlayerService.RenderObserver observer, boolean exitMiniWindow, boolean isLooping, boolean isHideLoading) {
        Intrinsics.checkNotNullParameter(videoContainer, "videoContainer");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        this.isHideLoading = isHideLoading;
        this.isLooping = isLooping;
        if (exitMiniWindow) {
            exitAllMiniFloatWindow();
            initPlayer(videoContainer, observer, list);
        } else if (isLiveWindowShowing(context)) {
        } else {
            Violet.INSTANCE.ofChannel(MiniScreenPlayerOpenEvent.class).observeUnSticky(UtilKt.requireFragmentActivity(context), new Observer() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$$ExternalSyntheticLambda0
                public final void onChanged(Object obj) {
                    AuthorSpaceHeaderPlayer.createAndPrepareNormalPlayer$lambda$0(AuthorSpaceHeaderPlayer.this, (MiniScreenPlayerOpenEvent) obj);
                }
            });
            Violet.INSTANCE.ofChannel(MiniScreenPlayerCloseEvent.class).observeUnSticky(UtilKt.requireFragmentActivity(context), new Observer() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$$ExternalSyntheticLambda1
                public final void onChanged(Object obj) {
                    AuthorSpaceHeaderPlayer.createAndPrepareNormalPlayer$lambda$1(AuthorSpaceHeaderPlayer.this, videoContainer, observer, list, (MiniScreenPlayerCloseEvent) obj);
                }
            });
            Violet.INSTANCE.ofChannel(MiniPlayerStateEvent.class).observeUnSticky(UtilKt.requireFragmentActivity(context), new Observer() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$$ExternalSyntheticLambda2
                public final void onChanged(Object obj) {
                    AuthorSpaceHeaderPlayer.createAndPrepareNormalPlayer$lambda$2(AuthorSpaceHeaderPlayer.this, videoContainer, observer, list, (MiniPlayerStateEvent) obj);
                }
            });
            IMiniPlayerWindowManager iMiniPlayerWindowManager = this.mMiniPlayerRouteService;
            boolean z = false;
            if (iMiniPlayerWindowManager != null && iMiniPlayerWindowManager.isMiniPlayerActive(false)) {
                z = true;
            }
            if (!z || !isMiniPlayerPlaying()) {
                if (this.mPrepared) {
                    IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
                    if (iAuthorSpaceHeaderPlayerController != null) {
                        iAuthorSpaceHeaderPlayerController.resume();
                        return;
                    }
                    return;
                }
                initPlayer(videoContainer, observer, list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAndPrepareNormalPlayer$lambda$0(AuthorSpaceHeaderPlayer this$0, MiniScreenPlayerOpenEvent it) {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.mPrepared || (iAuthorSpaceHeaderPlayerController = this$0.mPlayerController) == null) {
            return;
        }
        iAuthorSpaceHeaderPlayerController.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAndPrepareNormalPlayer$lambda$1(AuthorSpaceHeaderPlayer this$0, ViewGroup $videoContainer, IAuthorSpaceHeaderPlayerService.RenderObserver $observer, List $urlList, MiniScreenPlayerCloseEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.mPrepared) {
            IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this$0.mPlayerController;
            if (iAuthorSpaceHeaderPlayerController != null) {
                iAuthorSpaceHeaderPlayerController.resume();
                return;
            }
            return;
        }
        this$0.initPlayer($videoContainer, $observer, $urlList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAndPrepareNormalPlayer$lambda$2(AuthorSpaceHeaderPlayer this$0, ViewGroup $videoContainer, IAuthorSpaceHeaderPlayerService.RenderObserver $observer, List $urlList, MiniPlayerStateEvent t) {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController;
        Intrinsics.checkNotNullParameter(t, "t");
        int playerState = t.getPlayerState();
        if (playerState == 5 || playerState == 6 || playerState == 7) {
            if (this$0.mPrepared) {
                IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController2 = this$0.mPlayerController;
                if (iAuthorSpaceHeaderPlayerController2 != null) {
                    iAuthorSpaceHeaderPlayerController2.resume();
                    return;
                }
                return;
            }
            this$0.initPlayer($videoContainer, $observer, $urlList);
        } else if (playerState != 4 || (iAuthorSpaceHeaderPlayerController = this$0.mPlayerController) == null) {
        } else {
            iAuthorSpaceHeaderPlayerController.pause();
        }
    }

    private final boolean isMiniPlayerPlaying() {
        if (MiniPlayerManager.INSTANCE.isMiniPlayerActive()) {
            return MiniPlayerManager.INSTANCE.isMiniPlayerPlaying();
        }
        return false;
    }

    private final void initPlayer(ViewGroup videoContainer, IAuthorSpaceHeaderPlayerService.RenderObserver observer, List<String> list) {
        AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
        String directPlayUrl = authorSpaceHeaderVideoModel != null ? authorSpaceHeaderVideoModel.getDirectPlayUrl() : null;
        if (!(directPlayUrl == null || directPlayUrl.length() == 0)) {
            this.mAuthorSpaceHeaderPlayableParams.setDirectUrl(true);
            AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams = this.mAuthorSpaceHeaderPlayableParams;
            AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel2 = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
            authorSpaceHeaderPlayableParams.setDirectPlayUrl(authorSpaceHeaderVideoModel2 != null ? authorSpaceHeaderVideoModel2.getDirectPlayUrl() : null);
            if (list != null) {
                List<String> $this$forEachIndexed$iv = list;
                int index = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv = index + 1;
                    if (index < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String url = (String) item$iv;
                    if (index > 0) {
                        this.mAuthorSpaceHeaderPlayableParams.getBackupUrls().add(url);
                    }
                    index = index$iv;
                }
            }
        } else {
            this.mAuthorSpaceHeaderPlayableParams.setExpectedQuality(64);
            this.mAuthorSpaceHeaderPlayableParams.setDisplayRotate(getVideoAspect());
            AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams2 = this.mAuthorSpaceHeaderPlayableParams;
            AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel3 = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
            authorSpaceHeaderPlayableParams2.setAvid(authorSpaceHeaderVideoModel3 != null ? authorSpaceHeaderVideoModel3.getAvid() : -1L);
            AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams3 = this.mAuthorSpaceHeaderPlayableParams;
            AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel4 = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
            authorSpaceHeaderPlayableParams3.setCid(authorSpaceHeaderVideoModel4 != null ? authorSpaceHeaderVideoModel4.getCid() : -1L);
            AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams4 = this.mAuthorSpaceHeaderPlayableParams;
            AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel5 = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
            authorSpaceHeaderPlayableParams4.setFlashJsonStr(authorSpaceHeaderVideoModel5 != null ? authorSpaceHeaderVideoModel5.getFastPlayInfo() : null);
            AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams5 = this.mAuthorSpaceHeaderPlayableParams;
            AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel6 = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
            authorSpaceHeaderPlayableParams5.setFromSpmid(authorSpaceHeaderVideoModel6 != null ? authorSpaceHeaderVideoModel6.getFromSpmid() : null);
            AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams6 = this.mAuthorSpaceHeaderPlayableParams;
            AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel7 = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
            authorSpaceHeaderPlayableParams6.setSpmid(authorSpaceHeaderVideoModel7 != null ? authorSpaceHeaderVideoModel7.getSpmid() : null);
            this.mAuthorSpaceHeaderPlayableParams.setJumpFrom("");
            this.mAuthorSpaceHeaderPlayableParams.setFnVer(PlayUrlFlagsManager.getFnVer());
            this.mAuthorSpaceHeaderPlayableParams.setFnVal(PlayUrlFlagsManager.getFnVal());
            this.mAuthorSpaceHeaderPlayableParams.setFromAutoPlay(99);
        }
        PlayerParamsV2 playerParamsV2 = new PlayerParamsV2();
        playerParamsV2.setPlayerDataSource(new AuthorSpaceHeaderPlayerDataSource(this.mAuthorSpaceHeaderPlayableParams));
        playerParamsV2.getConfig().setWholeSceneEnable(false);
        playerParamsV2.getConfig().setVideoRenderLayerType(IVideoRenderLayer.Type.TypeTextureViewWithExternalRender);
        this.mPlayerController = IAuthorSpaceHeaderPlayerController.Companion.create();
        this.mRenderObserver = observer;
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.observePlayerReady(new IAuthorSpaceHeaderPlayerController.OnPlayerReadyObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$initPlayer$2
                /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
                    r0 = r4.this$0.mPlayerController;
                 */
                @Override // tv.danmaku.bili.ui.videospace.IAuthorSpaceHeaderPlayerController.OnPlayerReadyObserver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onReady() {
                    IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController2;
                    IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController3;
                    boolean z;
                    IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController4;
                    AuthorSpaceHeaderPlayer$mPlayerStateObserver$1 authorSpaceHeaderPlayer$mPlayerStateObserver$1;
                    AuthorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1 authorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1;
                    iAuthorSpaceHeaderPlayerController2 = AuthorSpaceHeaderPlayer.this.mPlayerController;
                    if (iAuthorSpaceHeaderPlayerController2 != null) {
                        authorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1 = AuthorSpaceHeaderPlayer.this.mMeteredNetworkUrlHookListener;
                        iAuthorSpaceHeaderPlayerController2.setMeteredNetworkUrlHookListener(authorSpaceHeaderPlayer$mMeteredNetworkUrlHookListener$1);
                    }
                    iAuthorSpaceHeaderPlayerController3 = AuthorSpaceHeaderPlayer.this.mPlayerController;
                    if (iAuthorSpaceHeaderPlayerController3 != null) {
                        authorSpaceHeaderPlayer$mPlayerStateObserver$1 = AuthorSpaceHeaderPlayer.this.mPlayerStateObserver;
                        iAuthorSpaceHeaderPlayerController3.observePlayerState(authorSpaceHeaderPlayer$mPlayerStateObserver$1, 6, 5);
                    }
                    z = AuthorSpaceHeaderPlayer.this.isHideLoading;
                    if (!z || iAuthorSpaceHeaderPlayerController4 == null) {
                        return;
                    }
                    iAuthorSpaceHeaderPlayerController4.hideLoading();
                }
            });
        }
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController2 = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController2 != null) {
            iAuthorSpaceHeaderPlayerController2.prepare(playerParamsV2, videoContainer.getId(), UtilKt.findFragmentActivityOrNull(this.mContext), new IRenderStartObserver() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayer$initPlayer$3
                @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
                public void onVideoRenderStart() {
                    IAuthorSpaceHeaderPlayerService.RenderObserver renderObserver;
                    renderObserver = AuthorSpaceHeaderPlayer.this.mRenderObserver;
                    if (renderObserver != null) {
                        renderObserver.onVideoRenderStart(AuthorSpaceHeaderPlayer.this.getVideoRatio());
                    }
                }

                @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
                public void onAudioRenderStart() {
                    IAuthorSpaceHeaderPlayerService.RenderObserver renderObserver;
                    renderObserver = AuthorSpaceHeaderPlayer.this.mRenderObserver;
                    if (renderObserver != null) {
                        renderObserver.onAudioRenderStart();
                    }
                }
            }, this.mRenderObserver);
        }
        this.mPrepared = true;
    }

    public final void exitAllMiniFloatWindow() {
        IMiniPlayerWindowManager iMiniPlayerWindowManager = this.mMiniPlayerRouteService;
        if (iMiniPlayerWindowManager != null) {
            iMiniPlayerWindowManager.finishMiniPlayer(true);
        }
    }

    public final boolean isMiniWindowShowing() {
        IMiniPlayerWindowManager iMiniPlayerWindowManager = this.mMiniPlayerRouteService;
        if (iMiniPlayerWindowManager != null) {
            return iMiniPlayerWindowManager.isMiniPlayerActive(true);
        }
        return false;
    }

    public final float getVideoAspect() {
        Integer playerRotate;
        Integer playerHeight;
        Integer playerWidth;
        AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
        boolean z = false;
        int width = (authorSpaceHeaderVideoModel == null || (playerWidth = authorSpaceHeaderVideoModel.getPlayerWidth()) == null) ? 0 : playerWidth.intValue();
        AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel2 = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
        int height = (authorSpaceHeaderVideoModel2 == null || (playerHeight = authorSpaceHeaderVideoModel2.getPlayerHeight()) == null) ? 0 : playerHeight.intValue();
        if (width > 0 && height > 0) {
            AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel3 = AuthorSpaceHeaderVideoModel.Companion.get(this.mContext);
            if (authorSpaceHeaderVideoModel3 != null && (playerRotate = authorSpaceHeaderVideoModel3.getPlayerRotate()) != null && playerRotate.intValue() == 0) {
                z = true;
            }
            if (z) {
                return (width * 1.0f) / height;
            }
            return (height * 1.0f) / width;
        }
        return 0.5625f;
    }

    public final void releaseNormalPlayer() {
        IAuthorSpaceHeaderPlayerService.RenderObserver renderObserver = this.mRenderObserver;
        if (renderObserver != null) {
            renderObserver.onVideoPlayerRelease();
        }
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.unObservePlayerState(this.mPlayerStateObserver);
        }
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController2 = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController2 != null) {
            iAuthorSpaceHeaderPlayerController2.release();
        }
        this.mPrepared = false;
    }

    public final void onPause() {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.pause();
        }
    }

    public final void onResume() {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.resume();
        }
    }

    public final void seekTo(int progress) {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.seekTo(progress);
        }
    }

    public final void playNext(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            AuthorSpaceHeaderPlayableParams $this$playNext_u24lambda_u240 = new AuthorSpaceHeaderPlayableParams();
            $this$playNext_u24lambda_u240.setDirectUrl(true);
            $this$playNext_u24lambda_u240.setDirectPlayUrl(url);
            iAuthorSpaceHeaderPlayerController.updateDataSource(new AuthorSpaceHeaderPlayerDataSource($this$playNext_u24lambda_u240));
        }
    }

    public final int getPlayerState() {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            return iAuthorSpaceHeaderPlayerController.getPlayerState();
        }
        return 0;
    }

    private final void closeLiveWindow(Context context) {
        LivePlayerOutService service = (LivePlayerOutService) BLRouter.INSTANCE.getServices(LivePlayerOutService.class).get("default");
        if (service != null) {
            service.stopFloatLiveWindow();
        }
    }

    private final boolean isLiveWindowShowing(Context context) {
        LivePlayerOutService service = (LivePlayerOutService) BLRouter.INSTANCE.getServices(LivePlayerOutService.class).get("default");
        return service != null && service.floatWindowIsShown();
    }

    public final void setMuteState(boolean mute) {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.setMuteState(mute);
        }
    }

    public final void registerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.registerProgressObserver(observer);
        }
    }

    public final void unregisterProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.unregisterProgressObserver(observer);
        }
    }

    public final void setAspectRatio(AspectRatio aspectRatio) {
        Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.setAspectRatio(aspectRatio);
        }
    }

    public final void setControllerEnable(boolean enable) {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.setControllerEnable(enable);
        }
    }

    public final float getVideoRatio() {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        return iAuthorSpaceHeaderPlayerController != null ? iAuthorSpaceHeaderPlayerController.getVideoRatio() : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    }

    public final void enableScreenGravity(boolean enable) {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.enableScreenGravity(enable);
        }
    }

    public final void setViewPortOffset(int offset) {
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.setViewPortOffset(offset);
        }
    }

    public final void addVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.addVideoPlayEventListener(listener);
        }
    }

    public final void removeVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IAuthorSpaceHeaderPlayerController iAuthorSpaceHeaderPlayerController = this.mPlayerController;
        if (iAuthorSpaceHeaderPlayerController != null) {
            iAuthorSpaceHeaderPlayerController.removeVideoPlayEventListener(listener);
        }
    }

    public final void setPlayerStateListener(IAuthorSpaceHeaderPlayerService.IPlayerStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPlayerStateListener = listener;
    }

    public final void resetPlayerStateListener() {
        this.mPlayerStateListener = null;
    }
}