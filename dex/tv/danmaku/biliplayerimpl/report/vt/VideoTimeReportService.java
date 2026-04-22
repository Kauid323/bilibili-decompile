package tv.danmaku.biliplayerimpl.report.vt;

import com.bilibili.app.vtreport.VtReportTransfer;
import com.bilibili.app.vtreport.data.TickInfo;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.BufferingObserver;
import tv.danmaku.biliplayerv2.service.IMediaCenterObserver;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: VideoTimeReportService.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003\t\f\u000f\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006 "}, d2 = {"Ltv/danmaku/biliplayerimpl/report/vt/VideoTimeReportService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mIsBuffering", "", "mBufferingObserver", "tv/danmaku/biliplayerimpl/report/vt/VideoTimeReportService$mBufferingObserver$1", "Ltv/danmaku/biliplayerimpl/report/vt/VideoTimeReportService$mBufferingObserver$1;", "mTimer", "tv/danmaku/biliplayerimpl/report/vt/VideoTimeReportService$mTimer$1", "Ltv/danmaku/biliplayerimpl/report/vt/VideoTimeReportService$mTimer$1;", "mMediaCenterObserver", "tv/danmaku/biliplayerimpl/report/vt/VideoTimeReportService$mMediaCenterObserver$1", "Ltv/danmaku/biliplayerimpl/report/vt/VideoTimeReportService$mMediaCenterObserver$1;", "bindPlayerContainer", "", "playerContainer", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onAttachByShared", "onStart", "onStop", "report", "tickInfo", "Lcom/bilibili/app/vtreport/data/TickInfo;", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoTimeReportService implements IPlayerService {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "VideoTimeService";
    private boolean mIsBuffering;
    private PlayerContainer mPlayerContainer;
    private final VideoTimeReportService$mBufferingObserver$1 mBufferingObserver = new BufferingObserver() { // from class: tv.danmaku.biliplayerimpl.report.vt.VideoTimeReportService$mBufferingObserver$1
        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingStart(int extra) {
            VideoTimeReportService.this.mIsBuffering = true;
        }

        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingEnd() {
            VideoTimeReportService.this.mIsBuffering = false;
        }
    };
    private final VideoTimeReportService$mTimer$1 mTimer = new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.vt.VideoTimeReportService$mTimer$1
        @Override // java.lang.Runnable
        public void run() {
            PlayerContainer playerContainer;
            PlayerContainer playerContainer2;
            int i;
            PlayerContainer playerContainer3;
            PlayerContainer playerContainer4;
            PlayerContainer playerContainer5;
            PlayerContainer playerContainer6;
            PlayerContainer playerContainer7;
            boolean z;
            playerContainer = VideoTimeReportService.this.mPlayerContainer;
            PlayerContainer playerContainer8 = null;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            Video.PlayableParams playableParam = PlayerContainerKt.getPlayDirector((IPlayerContainer) playerContainer).getCurrentPlayableParams();
            playerContainer2 = VideoTimeReportService.this.mPlayerContainer;
            if (playerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer2 = null;
            }
            int currentState = playerContainer2.getPlayerCoreService().getState();
            if (playableParam != null && currentState >= 3) {
                playerContainer3 = VideoTimeReportService.this.mPlayerContainer;
                if (playerContainer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer3 = null;
                }
                float playSpeed = IPlayerCoreService.CC.getPlaySpeed$default(playerContainer3.getPlayerCoreService(), false, 1, null);
                playerContainer4 = VideoTimeReportService.this.mPlayerContainer;
                if (playerContainer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer4 = null;
                }
                long j = (long) IjkMediaCodecInfo.RANK_MAX;
                long progress = playerContainer4.getPlayerCoreService().getRealCurrentPosition() / j;
                playerContainer5 = VideoTimeReportService.this.mPlayerContainer;
                if (playerContainer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer5 = null;
                }
                long duration = playerContainer5.getPlayerCoreService().getRealDuration() / j;
                String spmid = playableParam.getSpmid();
                String refer = spmid == null ? "" : spmid;
                Video.DisplayParams displayParams = playableParam.getDisplayParams();
                playerContainer6 = VideoTimeReportService.this.mPlayerContainer;
                if (playerContainer6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer6 = null;
                }
                String did = playerContainer6.getPlayerSettingService().getString(Player.KEY_HEARTBEAT_CLICK_REPORT_DID, "");
                VideoTimeReportService videoTimeReportService = VideoTimeReportService.this;
                long avid = displayParams.getAvid();
                long cid = displayParams.getCid();
                boolean isVisible = BiliContext.isVisible();
                playerContainer7 = VideoTimeReportService.this.mPlayerContainer;
                if (playerContainer7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainer8 = playerContainer7;
                }
                String session = playerContainer8.getReporterService().getSession();
                z = VideoTimeReportService.this.mIsBuffering;
                i = 0;
                videoTimeReportService.report(new TickInfo(avid, cid, duration, playSpeed, progress, currentState, refer, isVisible, did, session, z));
            } else {
                i = 0;
            }
            HandlerThreads.postDelayed(i, this, VtReportTransfer.INSTANCE.getSAMPLE_RATE());
        }
    };
    private final VideoTimeReportService$mMediaCenterObserver$1 mMediaCenterObserver = new IMediaCenterObserver() { // from class: tv.danmaku.biliplayerimpl.report.vt.VideoTimeReportService$mMediaCenterObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public /* synthetic */ void onPlayerReconnect() {
            IMediaCenterObserver.CC.$default$onPlayerReconnect(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public void onTerminateByMediaCenter() {
            VideoTimeReportService$mTimer$1 videoTimeReportService$mTimer$1;
            BLog.i(VideoTimeReportService.TAG, this + " TerminateByMediaCenter pause tick");
            videoTimeReportService$mTimer$1 = VideoTimeReportService.this.mTimer;
            HandlerThreads.remove(0, videoTimeReportService$mTimer$1);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public void onRestoreFromMediaCenterTerminate() {
            VideoTimeReportService$mTimer$1 videoTimeReportService$mTimer$1;
            VideoTimeReportService$mTimer$1 videoTimeReportService$mTimer$12;
            BLog.i(VideoTimeReportService.TAG, this + " RestoreFromMediaCenterTerminate resume tick");
            videoTimeReportService$mTimer$1 = VideoTimeReportService.this.mTimer;
            HandlerThreads.remove(0, videoTimeReportService$mTimer$1);
            videoTimeReportService$mTimer$12 = VideoTimeReportService.this.mTimer;
            HandlerThreads.post(0, videoTimeReportService$mTimer$12);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public void onPreparedFromMediaCenterTerminate() {
        }
    };

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ PlayerServiceManager.ServiceConfig serviceConfig() {
        return IPlayerService.CC.$default$serviceConfig(this);
    }

    /* compiled from: VideoTimeReportService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/vt/VideoTimeReportService$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        BLog.i(TAG, this + " onCollectSharedParams");
        HandlerThreads.remove(0, this.mTimer);
        this.mIsBuffering = false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        if (bundle != null) {
            BLog.i(TAG, this + " onAttachByShared");
            HandlerThreads.post(0, this.mTimer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        BLog.i(TAG, this + " onStart");
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerCoreService().addMediaCenterObserver(this.mMediaCenterObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        playerContainer2.getPlayerCoreService().registerBufferingState(this.mBufferingObserver);
        HandlerThreads.post(0, this.mTimer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        BLog.i(TAG, this + " onStop");
        HandlerThreads.remove(0, this.mTimer);
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerCoreService().removeMediaCenterObserver(this.mMediaCenterObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        playerContainer2.getPlayerCoreService().unregisterBufferingState(this.mBufferingObserver);
    }

    public final void report(TickInfo tickInfo) {
        Intrinsics.checkNotNullParameter(tickInfo, "tickInfo");
        VtReportTransfer.INSTANCE.tick(tickInfo);
    }
}