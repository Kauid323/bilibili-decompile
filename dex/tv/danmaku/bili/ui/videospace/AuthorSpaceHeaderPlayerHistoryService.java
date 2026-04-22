package tv.danmaku.bili.ui.videospace;

import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.CurrentVideoPointer;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.LifecycleObserver;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: AuthorSpaceHeaderPlayerHistoryService.kt */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0012\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0002J(\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerHistoryService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "Ltv/danmaku/biliplayerv2/service/LifecycleObserver;", "Ltv/danmaku/biliplayerv2/service/PlayerStateObserver;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mSavedPlayableParam", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayableParams;", "mSavedDuration", "", "mSavedPosition", "mStartPlayTimeStamp", "", "mNeedUpdateData", "", "mVideoPlayEventListener", "tv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerHistoryService$mVideoPlayEventListener$1", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerHistoryService$mVideoPlayEventListener$1;", "onStart", "", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "bindPlayerContainer", "playerContainer", "serviceConfig", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceConfig;", "savePlayHistory", "reportVideoProgress", "cid", "aid", "progress", "duration", "onLifecycleChanged", "state", "Ltv/danmaku/biliplayerv2/service/LifecycleState;", "onPlayerStateChanged", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorSpaceHeaderPlayerHistoryService implements IPlayerService, LifecycleObserver, PlayerStateObserver {
    private static final int END_THRESHOLD = 5000;
    private static final String TAG = "AuthorSpaceHeaderPlayerHistoryService";
    private boolean mNeedUpdateData;
    private PlayerContainer mPlayerContainer;
    private int mSavedDuration;
    private AuthorSpaceHeaderPlayableParams mSavedPlayableParam;
    private int mSavedPosition;
    private long mStartPlayTimeStamp;
    private final AuthorSpaceHeaderPlayerHistoryService$mVideoPlayEventListener$1 mVideoPlayEventListener = new IVideosPlayDirectorService.VideoPlayEventListener() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerHistoryService$mVideoPlayEventListener$1
        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onAllVideoCompleted() {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onAllVideoCompleted(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, String str) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, str);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, List list) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, list);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onResolveSucceed() {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveSucceed(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoCompleted(Video video2) {
            Intrinsics.checkNotNullParameter(video2, "video");
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoItemCompleted(CurrentVideoPointer currentVideoPointer, Video video2) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemCompleted(this, currentVideoPointer, video2);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoItemStart(CurrentVideoPointer currentVideoPointer, Video video2) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemStart(this, currentVideoPointer, video2);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoSetChanged(int i) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this, i);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoSetWillChange() {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetWillChange(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoWillChange(Video video2, Video video3) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoWillChange(this, video2, video3);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public void onVideoItemWillChange(CurrentVideoPointer old, CurrentVideoPointer currentVideoPointer, Video video2) {
            PlayerContainer playerContainer;
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(currentVideoPointer, "new");
            Intrinsics.checkNotNullParameter(video2, "video");
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemWillChange(this, old, currentVideoPointer, video2);
            AuthorSpaceHeaderPlayerHistoryService authorSpaceHeaderPlayerHistoryService = AuthorSpaceHeaderPlayerHistoryService.this;
            playerContainer = AuthorSpaceHeaderPlayerHistoryService.this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            authorSpaceHeaderPlayerHistoryService.mSavedPosition = playerContainer.getPlayerCoreService().getCurrentPosition();
            AuthorSpaceHeaderPlayerHistoryService.this.savePlayHistory();
            AuthorSpaceHeaderPlayerHistoryService.this.mNeedUpdateData = false;
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public void onVideoSetChanged() {
            boolean z;
            PlayerContainer playerContainer;
            PlayerContainer playerContainer2;
            z = AuthorSpaceHeaderPlayerHistoryService.this.mNeedUpdateData;
            if (z) {
                playerContainer = AuthorSpaceHeaderPlayerHistoryService.this.mPlayerContainer;
                AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams = null;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                PlayerDataSource dataSource = playerContainer.getVideoPlayDirectorService().getPlayerDataSource();
                playerContainer2 = AuthorSpaceHeaderPlayerHistoryService.this.mPlayerContainer;
                if (playerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer2 = null;
                }
                Video currentVideo = playerContainer2.getVideoPlayDirectorService().getCurrentVideo();
                AuthorSpaceHeaderPlayerHistoryService authorSpaceHeaderPlayerHistoryService = AuthorSpaceHeaderPlayerHistoryService.this;
                if (dataSource != null && currentVideo != null) {
                    Video.PlayableParams videoItem = dataSource.getVideoItem(currentVideo, currentVideo.getCurrentIndex());
                    if (videoItem instanceof AuthorSpaceHeaderPlayableParams) {
                        authorSpaceHeaderPlayableParams = (AuthorSpaceHeaderPlayableParams) videoItem;
                    }
                }
                authorSpaceHeaderPlayerHistoryService.mSavedPlayableParam = authorSpaceHeaderPlayableParams;
                AuthorSpaceHeaderPlayerHistoryService.this.mNeedUpdateData = false;
            }
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public void onVideoStart(Video video2) {
            Intrinsics.checkNotNullParameter(video2, "video");
        }
    };
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AuthorSpaceHeaderPlayerHistoryService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LifecycleState.values().length];
            try {
                iArr[LifecycleState.ACTIVITY_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LifecycleState.ACTIVITY_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onAttachByShared(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        IPlayerService.CC.$default$onAttachByShared(this, playerSharingType, playerSharingBundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onCollectSharedParams(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        IPlayerService.CC.$default$onCollectSharedParams(this, playerSharingType, playerSharingBundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    /* compiled from: AuthorSpaceHeaderPlayerHistoryService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerHistoryService$Companion;", "", "<init>", "()V", "TAG", "", "END_THRESHOLD", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerCoreService().registerState(this, 3);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getActivityStateService().registerLifecycle(this, LifecycleState.ACTIVITY_STOP, LifecycleState.ACTIVITY_PAUSE);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        playerContainer2.getVideoPlayDirectorService().addVideoPlayEventListener(this.mVideoPlayEventListener);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerCoreService().unregisterState(this);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getActivityStateService().unregisterLifecycle(this);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        playerContainer2.getVideoPlayDirectorService().removeVideoPlayEventListener(this.mVideoPlayEventListener);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public PlayerServiceManager.ServiceConfig serviceConfig() {
        return PlayerServiceManager.ServiceConfig.Companion.obtain(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void savePlayHistory() {
        AuthorSpaceHeaderPlayableParams playableParams = this.mSavedPlayableParam;
        if (playableParams == null || playableParams.getAvid() < 0 || playableParams.getCid() < 0 || this.mSavedDuration < 0) {
            return;
        }
        if (this.mSavedPosition + END_THRESHOLD >= this.mSavedDuration && this.mSavedDuration > 0) {
            reportVideoProgress(playableParams.getCid(), playableParams.getAvid(), -1L, this.mSavedDuration / 1000);
        } else {
            reportVideoProgress(playableParams.getCid(), playableParams.getAvid(), this.mSavedPosition / 1000, this.mSavedDuration / 1000);
        }
    }

    private final void reportVideoProgress(final long cid, final long aid, final long progress, final long duration) {
        if (cid < 0 || aid < 0) {
            return;
        }
        String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
        long unreliableNow = ServerClock.unreliableNow();
        long j = (long) IjkMediaCodecInfo.RANK_MAX;
        ((BiliSpaceHeaderPlayerHistoryApiService) ServiceGenerator.createService(BiliSpaceHeaderPlayerHistoryApiService.class)).reportProgress(accessKey, cid, aid, 0L, 0L, "space", duration, progress, 3, 0, 0L, unreliableNow / j, this.mStartPlayTimeStamp / j).enqueue(new BiliApiCallback<GeneralResponse<Object>>() { // from class: tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayerHistoryService$reportVideoProgress$1
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                BLog.i("AuthorSpaceHeaderPlayerHistoryService", "report play position failed: " + t.getMessage());
            }

            public void onSuccess(GeneralResponse<Object> generalResponse) {
                long j2 = cid;
                long j3 = aid;
                long j4 = progress;
                String str = $source;
                BLog.i("AuthorSpaceHeaderPlayerHistoryService", "report play position: " + j2 + ", " + j3 + ", " + j4 + ", " + str + ", " + duration);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.LifecycleObserver
    public void onLifecycleChanged(LifecycleState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                savePlayHistory();
                this.mSavedDuration = 0;
                return;
            case 2:
                PlayerContainer playerContainer = this.mPlayerContainer;
                PlayerContainer playerContainer2 = null;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                this.mSavedPosition = playerContainer.getPlayerCoreService().getCurrentPosition();
                PlayerContainer playerContainer3 = this.mPlayerContainer;
                if (playerContainer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainer2 = playerContainer3;
                }
                this.mSavedDuration = playerContainer2.getPlayerCoreService().getDuration();
                return;
            default:
                return;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
    public void onPlayerStateChanged(int state) {
        if (state == 3) {
            this.mStartPlayTimeStamp = ServerClock.unreliableNow();
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            this.mSavedDuration = playerContainer.getPlayerCoreService().getDuration();
            PlayerContainer playerContainer2 = this.mPlayerContainer;
            if (playerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer2 = null;
            }
            Video.PlayableParams currentPlayableParams = playerContainer2.getVideoPlayDirectorService().getCurrentPlayableParams();
            this.mSavedPlayableParam = currentPlayableParams instanceof AuthorSpaceHeaderPlayableParams ? (AuthorSpaceHeaderPlayableParams) currentPlayableParams : null;
        }
    }
}