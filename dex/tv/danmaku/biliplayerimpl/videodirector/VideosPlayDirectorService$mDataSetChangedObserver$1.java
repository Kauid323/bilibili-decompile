package tv.danmaku.biliplayerimpl.videodirector;

import androidx.collection.SparseArrayCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoDirectorObserver;
import tv.danmaku.biliplayerv2.service.VideoPlayHandler;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.transformer.P2PParams;

/* compiled from: VideosPlayDirectorService.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"tv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mDataSetChangedObserver$1", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource$DataSetChangedObserver;", "onChanged", "", "reset", "", "notifyVideoSetChanged", "dispatchVideoSetWillChange", "dispatchVideoSetChanged", "videoIndex", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideosPlayDirectorService$mDataSetChangedObserver$1 implements PlayerDataSource.DataSetChangedObserver {
    final /* synthetic */ VideosPlayDirectorService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideosPlayDirectorService$mDataSetChangedObserver$1(VideosPlayDirectorService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource.DataSetChangedObserver
    public void onChanged(boolean reset) {
        notifyVideoSetChanged(reset);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:
        if (r5 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d5, code lost:
        if (r5 >= 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d7, code lost:
        r5 = r11.this$0.mPendingPlayIndex;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dd, code lost:
        if (r5 < 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00df, code lost:
        r5 = r11.this$0.mPendingPlayIndex;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e6, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e7, code lost:
        tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.CC.play$default(r11.this$0, r5, 0, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f0, code lost:
        dispatchVideoSetChanged();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f3, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void notifyVideoSetChanged(boolean reset) {
        PlayerDataSource dataSource;
        int i;
        Video video2;
        Video video3;
        SparseArrayCompat sparseArrayCompat;
        Video video4;
        VideoPlayHandler oldHandler;
        Video it;
        SparseArrayCompat sparseArrayCompat2;
        Video video5;
        Video it2;
        SparseArrayCompat sparseArrayCompat3;
        Video video6;
        if (!reset) {
            dataSource = this.this$0.mPlayerDataSource;
            if (dataSource == null) {
                return;
            }
            dispatchVideoSetWillChange();
            boolean found = false;
            int videoCount = dataSource.getVideoCount();
            for (int i2 = 0; i2 < videoCount; i2++) {
                Video video7 = dataSource.getVideo(i2);
                if (video7 != null) {
                    video3 = this.this$0.mCurrentVideo;
                    if (Intrinsics.areEqual(video7, video3)) {
                        this.this$0.mCurrentVideoIndex = i2;
                        sparseArrayCompat = this.this$0.mVideoPlayHandlers;
                        VideoPlayHandler handler = (VideoPlayHandler) sparseArrayCompat.get(video7.getType());
                        video4 = this.this$0.mCurrentVideo;
                        if (video4 != null) {
                            sparseArrayCompat2 = this.this$0.mVideoPlayHandlers;
                            video5 = this.this$0.mCurrentVideo;
                            Intrinsics.checkNotNull(video5);
                            oldHandler = (VideoPlayHandler) sparseArrayCompat2.get(video5.getType());
                        } else {
                            oldHandler = null;
                        }
                        if (!Intrinsics.areEqual(oldHandler, handler)) {
                            it = this.this$0.mCurrentVideo;
                            if (it != null && oldHandler != null) {
                                oldHandler.stop(it);
                            }
                            if (handler != null) {
                                handler.start(video7, dataSource);
                            }
                        } else if (handler != null) {
                            handler.update(video7);
                        }
                        this.this$0.mCurrentVideo = video7;
                        found = true;
                    }
                }
            }
            if (!found) {
                video2 = this.this$0.mCurrentVideo;
            }
            i = this.this$0.mPendingPlayIndex;
        } else {
            dispatchVideoSetWillChange();
            it2 = this.this$0.mCurrentVideo;
            if (it2 != null) {
                VideosPlayDirectorService videosPlayDirectorService = this.this$0;
                sparseArrayCompat3 = videosPlayDirectorService.mVideoPlayHandlers;
                VideoPlayHandler handler2 = (VideoPlayHandler) sparseArrayCompat3.get(it2.getType());
                if (handler2 != null) {
                    handler2.stop(it2);
                }
                video6 = videosPlayDirectorService.mCurrentVideo;
                videosPlayDirectorService.mPreviousVideo = video6;
                videosPlayDirectorService.mCurrentVideo = null;
                videosPlayDirectorService.mCurrentVideoIndex = 0;
                videosPlayDirectorService.mPendingPlayIndex = -1;
            }
            dispatchVideoSetChanged();
        }
    }

    private final void dispatchVideoSetWillChange() {
        Collections.SafeIteratorList safeIteratorList;
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mDataSetChangedObserver$1$$ExternalSyntheticLambda4
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                VideosPlayDirectorService$mDataSetChangedObserver$1.dispatchVideoSetWillChange$lambda$2((IVideosPlayDirectorService.VideoPlayEventListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchVideoSetWillChange$lambda$2(IVideosPlayDirectorService.VideoPlayEventListener it) {
        try {
            it.onVideoSetWillChange();
        } catch (Throwable th) {
        }
    }

    private final void dispatchVideoSetChanged() {
        Collections.SafeIteratorList safeIteratorList;
        P2PParams it;
        IPlayerCoreService iPlayerCoreService;
        Collections.SafeIteratorList safeIteratorList2;
        final Video.PlayableParams playableParams = this.this$0.getCurrentPlayableParams();
        if (playableParams != null) {
            safeIteratorList2 = this.this$0.mVideoDirectorObservers;
            safeIteratorList2.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mDataSetChangedObserver$1$$ExternalSyntheticLambda0
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((VideoDirectorObserver) obj).onPlayableParamsChanged(Video.PlayableParams.this);
                }
            });
        }
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mDataSetChangedObserver$1$$ExternalSyntheticLambda1
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onVideoSetChanged();
            }
        });
        Video.PlayableParams currentPlayableParams = this.this$0.getCurrentPlayableParams();
        if (currentPlayableParams != null && (it = currentPlayableParams.getP2PParams()) != null) {
            iPlayerCoreService = this.this$0.mPlayerCoreService;
            if (iPlayerCoreService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                iPlayerCoreService = null;
            }
            iPlayerCoreService.updateP2PParams(it);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource.DataSetChangedObserver
    public void onChanged(int videoIndex) {
        PlayerDataSource dataSource;
        Video video2;
        SparseArrayCompat sparseArrayCompat;
        Video video3;
        Video video4;
        SparseArrayCompat sparseArrayCompat2;
        Video video5;
        Video video6;
        dataSource = this.this$0.mPlayerDataSource;
        if (dataSource == null || (video2 = dataSource.getVideo(videoIndex)) == null) {
            return;
        }
        sparseArrayCompat = this.this$0.mVideoPlayHandlers;
        VideoPlayHandler handler = (VideoPlayHandler) sparseArrayCompat.get(video2.getType());
        dispatchVideoSetWillChange();
        video3 = this.this$0.mCurrentVideo;
        if (!(video3 != null && video3.getType() == video2.getType())) {
            video4 = this.this$0.mCurrentVideo;
            if (video4 != null) {
                sparseArrayCompat2 = this.this$0.mVideoPlayHandlers;
                video5 = this.this$0.mCurrentVideo;
                Intrinsics.checkNotNull(video5);
                VideoPlayHandler videoPlayHandler = (VideoPlayHandler) sparseArrayCompat2.get(video5.getType());
                if (videoPlayHandler != null) {
                    video6 = this.this$0.mCurrentVideo;
                    Intrinsics.checkNotNull(video6);
                    videoPlayHandler.stop(video6);
                }
            }
            IVideosPlayDirectorService.CC.play$default(this.this$0, videoIndex, 0, 2, null);
            dispatchVideoSetChanged(videoIndex);
        } else if (handler != null) {
            handler.update(video2);
        }
    }

    private final void dispatchVideoSetChanged(final int videoIndex) {
        Collections.SafeIteratorList safeIteratorList;
        int i;
        Video.PlayableParams currentPlayableParams;
        P2PParams it;
        IPlayerCoreService iPlayerCoreService;
        Collections.SafeIteratorList safeIteratorList2;
        final Video.PlayableParams playableParams = this.this$0.getCurrentPlayableParams();
        if (playableParams != null) {
            safeIteratorList2 = this.this$0.mVideoDirectorObservers;
            safeIteratorList2.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mDataSetChangedObserver$1$$ExternalSyntheticLambda2
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((VideoDirectorObserver) obj).onPlayableParamsChanged(Video.PlayableParams.this);
                }
            });
        }
        safeIteratorList = this.this$0.mVideoPlayEventListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mDataSetChangedObserver$1$$ExternalSyntheticLambda3
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onVideoSetChanged(videoIndex);
            }
        });
        i = this.this$0.mCurrentVideoIndex;
        if (i == videoIndex && (currentPlayableParams = this.this$0.getCurrentPlayableParams()) != null && (it = currentPlayableParams.getP2PParams()) != null) {
            iPlayerCoreService = this.this$0.mPlayerCoreService;
            if (iPlayerCoreService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                iPlayerCoreService = null;
            }
            iPlayerCoreService.updateP2PParams(it);
        }
    }
}