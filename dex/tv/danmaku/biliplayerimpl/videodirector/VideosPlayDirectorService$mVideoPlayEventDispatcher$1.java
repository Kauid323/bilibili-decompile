package tv.danmaku.biliplayerimpl.videodirector;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerv2.DisplayOrientation;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.CurrentVideoPointer;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoDirectorObserver;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.report.PlayerReportCommonField;
import tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner;
import tv.danmaku.biliplayerv2.service.report.heartbeat.ReportStrategy;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.service.setting.Scope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: VideosPlayDirectorService.kt */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0015"}, d2 = {"tv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mVideoPlayEventDispatcher$1", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$IVideoPlayEventDispatcher;", "dispatchVideoStart", "", "video", "Ltv/danmaku/biliplayerv2/service/Video;", "dispatchVideoItemWillChange", "old", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "new", "dispatchVideoItemStart", "item", "dispatchVideoItemCompleted", "dispatchVideoCompleted", "dispatchResolveFailed", "playableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "errorMsg", "", "dispatchResolveSucceed", "dispatchPlayableParamsChanged", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideosPlayDirectorService$mVideoPlayEventDispatcher$1 implements IVideosPlayDirectorService.IVideoPlayEventDispatcher {
    final /* synthetic */ VideosPlayDirectorService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideosPlayDirectorService$mVideoPlayEventDispatcher$1(VideosPlayDirectorService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.IVideoPlayEventDispatcher
    public void dispatchVideoStart(final Video video2) {
        Collections.SafeIteratorList safeIteratorList;
        Intrinsics.checkNotNullParameter(video2, "video");
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda4
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onVideoStart(Video.this);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
        r1 = r7.this$0.mPlayerDataSource;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f1, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((r0 == null || (r3 = r0.getDisplayParams()) == null) ? null : java.lang.Long.valueOf(r3.getCid()), (r0 == null || (r5 = r0.getDisplayParams()) == null) ? null : java.lang.Long.valueOf(r5.getCid())) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fb, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1.getFrom(), "live") != false) goto L53;
     */
    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.IVideoPlayEventDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchVideoItemWillChange(final CurrentVideoPointer old, final CurrentVideoPointer currentVideoPointer, final Video video2) {
        PlayerContainerImpl playerContainerImpl;
        IPlayerCoreService iPlayerCoreService;
        IPlayerCoreService iPlayerCoreService2;
        PlayerContainerImpl playerContainerImpl2;
        PlayerContainerImpl playerContainerImpl3;
        PlayerDataSource playerDataSource;
        Collections.SafeIteratorList safeIteratorList;
        IToastService iToastService;
        IPlayerSettingService iPlayerSettingService;
        Collections.SafeIteratorList safeIteratorList2;
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(currentVideoPointer, "new");
        Intrinsics.checkNotNullParameter(video2, "video");
        playerContainerImpl = this.this$0.mPlayerContainer;
        IToastService iToastService2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IHeartbeatServiceInner heartbeatService = playerContainerImpl.getHeartbeatService();
        iPlayerCoreService = this.this$0.mPlayerCoreService;
        if (iPlayerCoreService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            iPlayerCoreService = null;
        }
        int currentQuality = iPlayerCoreService.getCurrentQuality();
        iPlayerCoreService2 = this.this$0.mPlayerCoreService;
        if (iPlayerCoreService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            iPlayerCoreService2 = null;
        }
        heartbeatService.notifyVideoEnd(currentQuality, iPlayerCoreService2.getRealCurrentPosition());
        playerContainerImpl2 = this.this$0.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        playerContainerImpl2.getReporterService().report(new NeuronsEvents.End(NeuronsEvents.End.Type.NORMAL));
        playerContainerImpl3 = this.this$0.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        playerContainerImpl3.getRenderContainerService().notifyVideoChanged();
        final Video.PlayableParams currentPlayableParams = this.this$0.getCurrentPlayableParams();
        final Video.PlayableParams oldPlayableParams = ((old.getIndex() == currentVideoPointer.getIndex() && old.getType() == currentVideoPointer.getType()) || playerDataSource == null) ? null : playerDataSource.getVideoItem(video2, old.getIndex());
        if (currentPlayableParams != null) {
            safeIteratorList2 = this.this$0.mVideoDirectorObservers;
            safeIteratorList2.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda10
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((VideoDirectorObserver) obj).onItemWillChange(Video.PlayableParams.this, oldPlayableParams);
                }
            });
        }
        if (oldPlayableParams != null) {
            if (!Intrinsics.areEqual(oldPlayableParams.getFrom(), "live")) {
            }
        }
        this.this$0.cancelDanmakuTask();
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda11
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onVideoItemWillChange(CurrentVideoPointer.this, currentVideoPointer, video2);
            }
        });
        if (!Intrinsics.areEqual(old, currentVideoPointer)) {
            iPlayerSettingService = this.this$0.mPlayerSettingService;
            if (iPlayerSettingService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerSettingService");
                iPlayerSettingService = null;
            }
            iPlayerSettingService.removeAll(Scope.VideoItem);
        }
        iToastService = this.this$0.mToastService;
        if (iToastService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToastService");
        } else {
            iToastService2 = iToastService;
        }
        iToastService2.removeAllToast();
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.IVideoPlayEventDispatcher
    public void dispatchVideoItemStart(final CurrentVideoPointer item, final Video video2) {
        PlayerContainerImpl playerContainerImpl;
        PlayerContainerImpl playerContainerImpl2;
        PlayerReportCommonField playerReportCommonField;
        PlayerContainerImpl playerContainerImpl3;
        Collections.SafeIteratorList safeIteratorList;
        PlayerContainerImpl playerContainerImpl4;
        Collections.SafeIteratorList safeIteratorList2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(video2, "video");
        playerContainerImpl = this.this$0.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl5 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getReporterService().resetSession();
        final Video.PlayableParams currentPlayableParams = this.this$0.getCurrentPlayableParams();
        if (currentPlayableParams != null) {
            safeIteratorList2 = this.this$0.mVideoDirectorObservers;
            safeIteratorList2.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda6
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((VideoDirectorObserver) obj).onItemStart(Video.PlayableParams.this);
                }
            });
        }
        Video.ReportCommonParams reportCommonParams = currentPlayableParams != null ? currentPlayableParams.getReportCommonParams() : null;
        if (reportCommonParams != null) {
            reportCommonParams.setReportStrategy(!Intrinsics.areEqual(currentPlayableParams != null ? currentPlayableParams.getFrom() : null, "live") ? ReportStrategy.NORMAL.INSTANCE : ReportStrategy.LIVE.INSTANCE);
        }
        playerContainerImpl2 = this.this$0.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        playerContainerImpl2.getHeartbeatService().notifyMetaInfoChanged(reportCommonParams);
        if (reportCommonParams != null) {
            playerReportCommonField = new PlayerReportCommonField(reportCommonParams.getAvid(), !Intrinsics.areEqual(currentPlayableParams.getFrom(), "live") ? reportCommonParams.getCid() : reportCommonParams.getRoomId(), reportCommonParams.getSeasonId(), reportCommonParams.getEpId(), reportCommonParams.getFromSpmid(), reportCommonParams.getSpmid(), reportCommonParams.getType(), reportCommonParams.getSubType(), reportCommonParams.getTrackId(), currentPlayableParams.getDisplayParams().getDisplayOrientation() == DisplayOrientation.VERTICAL, null, null, null, null, 15360, null);
        } else {
            playerReportCommonField = null;
        }
        PlayerReportCommonField reportCommonField = playerReportCommonField;
        playerContainerImpl3 = this.this$0.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        playerContainerImpl3.getReporterService().notifyVideoChanged(reportCommonField);
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda7
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onVideoItemStart(CurrentVideoPointer.this, video2);
            }
        });
        playerContainerImpl4 = this.this$0.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl5 = playerContainerImpl4;
        }
        playerContainerImpl5.getFunctionWidgetService().notifyVideoChanged();
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.IVideoPlayEventDispatcher
    public void dispatchVideoItemCompleted(final CurrentVideoPointer item, final Video video2) {
        PlayerContainerImpl playerContainerImpl;
        Collections.SafeIteratorList safeIteratorList;
        boolean z;
        IPlayerSettingService iPlayerSettingService;
        Collections.SafeIteratorList safeIteratorList2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(video2, "video");
        playerContainerImpl = this.this$0.mPlayerContainer;
        IPlayerSettingService iPlayerSettingService2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getReporterService().report(new NeuronsEvents.End(NeuronsEvents.End.Type.NORMAL));
        final Video.PlayableParams currentPlayableParams = this.this$0.getCurrentPlayableParams();
        if (currentPlayableParams != null) {
            safeIteratorList2 = this.this$0.mVideoDirectorObservers;
            safeIteratorList2.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda2
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((VideoDirectorObserver) obj).onItemCompleted(Video.PlayableParams.this);
                }
            });
        }
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda3
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onVideoItemCompleted(CurrentVideoPointer.this, video2);
            }
        });
        z = this.this$0.mProcessCompleteActionEnable;
        if (z) {
            iPlayerSettingService = this.this$0.mPlayerSettingService;
            if (iPlayerSettingService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerSettingService");
            } else {
                iPlayerSettingService2 = iPlayerSettingService;
            }
            int action = iPlayerSettingService2.getInt(Player.KEY_PLAY_COMPLETED_ACTION, 0);
            if (action == 1) {
                return;
            }
            if (action == 4) {
                this.this$0.playNext(true);
                return;
            } else if (action == 2) {
                this.this$0.replayCurrentVideoItem();
                return;
            } else if (action == 0) {
                this.this$0.playNext(false);
                return;
            } else {
                return;
            }
        }
        PlayerLog.i("VideosPlayDirectorService", "do not process complete action");
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.IVideoPlayEventDispatcher
    public void dispatchVideoCompleted(final Video video2) {
        Collections.SafeIteratorList safeIteratorList;
        PlayerDataSource playerDataSource;
        int i;
        Intrinsics.checkNotNullParameter(video2, "video");
        video2.setPlayCompleted(true);
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda5
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onVideoCompleted(Video.this);
            }
        });
        playerDataSource = this.this$0.mPlayerDataSource;
        int count = playerDataSource != null ? playerDataSource.getVideoCount() : 0;
        i = this.this$0.mCurrentVideoIndex;
        if (i + 1 >= count) {
            this.this$0.dispatchAllVideoCompleted();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.IVideoPlayEventDispatcher
    public void dispatchResolveFailed(final Video video2, final Video.PlayableParams playableParams, final String errorMsg) {
        Collections.SafeIteratorList safeIteratorList;
        Collections.SafeIteratorList safeIteratorList2;
        Intrinsics.checkNotNullParameter(video2, "video");
        Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        safeIteratorList = this.this$0.mVideoDirectorObservers;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda12
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((VideoDirectorObserver) obj).onResolveFailed(Video.PlayableParams.this, errorMsg);
            }
        });
        safeIteratorList2 = this.this$0.mVideoPlayEventListeners;
        safeIteratorList2.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda1
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onResolveFailed(Video.this, playableParams, errorMsg);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.IVideoPlayEventDispatcher
    public void dispatchResolveSucceed() {
        Collections.SafeIteratorList safeIteratorList;
        Collections.SafeIteratorList safeIteratorList2;
        final Video.PlayableParams currentPlayableParams = this.this$0.getCurrentPlayableParams();
        if (currentPlayableParams != null) {
            safeIteratorList2 = this.this$0.mVideoDirectorObservers;
            safeIteratorList2.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda8
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((VideoDirectorObserver) obj).onResolveSucceed(Video.PlayableParams.this);
                }
            });
        }
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda9
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onResolveSucceed();
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.IVideoPlayEventDispatcher
    public void dispatchPlayableParamsChanged(final Video.PlayableParams playableParams) {
        Collections.SafeIteratorList safeIteratorList;
        Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        safeIteratorList = this.this$0.mVideoDirectorObservers;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mVideoPlayEventDispatcher$1$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((VideoDirectorObserver) obj).onPlayableParamsChanged(Video.PlayableParams.this);
            }
        });
    }
}