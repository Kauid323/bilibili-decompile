package tv.danmaku.biliplayerimpl.videodirector;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.CurrentVideoPointer;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: VideosPlayDirectorService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerimpl/videodirector/MockVideoPlayEventListener;", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "<init>", "()V", "onVideoStart", "", "video", "Ltv/danmaku/biliplayerv2/service/Video;", "onVideoItemStart", "item", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "onVideoItemWillChange", "old", "new", "onVideoItemCompleted", "onVideoWillChange", "onVideoCompleted", "onAllVideoCompleted", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
final class MockVideoPlayEventListener implements IVideosPlayDirectorService.VideoPlayEventListener {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "VideoPlayEventListener";

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
    public /* synthetic */ void onVideoSetChanged() {
        IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public /* synthetic */ void onVideoSetChanged(int i) {
        IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this, i);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public /* synthetic */ void onVideoSetWillChange() {
        IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetWillChange(this);
    }

    /* compiled from: VideosPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/videodirector/MockVideoPlayEventListener$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public void onVideoStart(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        PlayerLog.d(TAG, "video start, video = " + video2.getDescription());
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public void onVideoItemStart(CurrentVideoPointer item, Video video2) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(video2, "video");
        PlayerLog.d(TAG, "videoItem start, item = " + item.getDescription());
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public void onVideoItemWillChange(CurrentVideoPointer old, CurrentVideoPointer currentVideoPointer, Video video2) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(currentVideoPointer, "new");
        Intrinsics.checkNotNullParameter(video2, "video");
        String description = old.getDescription();
        PlayerLog.d(TAG, "videoItem will change, oldItem = " + description + "; newItem = " + currentVideoPointer.getDescription() + "}");
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public void onVideoItemCompleted(CurrentVideoPointer item, Video video2) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(video2, "video");
        PlayerLog.d(TAG, "videoItem completed, item = " + item.getDescription());
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public void onVideoWillChange(Video old, Video video2) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(video2, "new");
        String description = old.getDescription();
        PlayerLog.d(TAG, "video will change, oldVideo = " + description + "; newVideo = " + video2.getDescription());
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public void onVideoCompleted(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        PlayerLog.d(TAG, "video completed, video = " + video2.getDescription());
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
    public void onAllVideoCompleted() {
        PlayerLog.d(TAG, "all videos play completed...");
    }
}