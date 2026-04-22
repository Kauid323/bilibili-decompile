package tv.danmaku.video.bilicardplayer.player;

import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.service.CurrentVideoPointer;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.ResolveListener;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoPlayHandler;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: CardVideoPlayHandler.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J)\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0018\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0015H\u0016J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\b\u00101\u001a\u00020\u0017H\u0016J\u0010\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u0017H\u0016J\u0010\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u0017H\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\n\u00106\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u000109H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006;"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/CardVideoPlayHandler;", "Ltv/danmaku/biliplayerv2/service/VideoPlayHandler;", "<init>", "()V", "mRealVideoPlayHandler", "Ltv/danmaku/biliplayerv2/service/NormalVideoPlayHandler;", "currentVideoItem", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "getCurrentVideoItem", "()Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "attach", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "dispatcher", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$IVideoPlayEventDispatcher;", "replay", "start", "video", "Ltv/danmaku/biliplayerv2/service/Video;", "dataSource", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "autoStart", "", "stop", "release", "update", "updateMediaResource", "outerResolveListener", "Ltv/danmaku/biliplayerv2/service/ResolveListener;", "obtainMediaResourceSync", "Lcom/bilibili/lib/media/resource/MediaResource;", "reason", "", "codecType", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", IjkMediaMeta.IJKM_KEY_FORMAT, "obtainMediaResourceSync-4pVzu0o", "(III)Lcom/bilibili/lib/media/resource/MediaResource;", "reload", "play", "item", "startFromShared", "playerDataSource", "onCollectSharedParams", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onRestoreFromSharedParams", "hasNext", "hasPrevious", "playNext", "loop", "playPrevious", "onCompleted", "getCurrentVideo", "setHistoryProgressReader", "reader", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "Companion", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CardVideoPlayHandler extends VideoPlayHandler {
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_VIDEO_CARD = 104;
    private final NormalVideoPlayHandler mRealVideoPlayHandler = new NormalVideoPlayHandler();

    /* compiled from: CardVideoPlayHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/CardVideoPlayHandler$Companion;", "", "<init>", "()V", "TYPE_VIDEO_CARD", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public CurrentVideoPointer getCurrentVideoItem() {
        return this.mRealVideoPlayHandler.getCurrentVideoItem();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void attach(PlayerContainer playerContainer, IVideosPlayDirectorService.IVideoPlayEventDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        super.attach(playerContainer, dispatcher);
        this.mRealVideoPlayHandler.attach(playerContainer, dispatcher);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void replay() {
        this.mRealVideoPlayHandler.replay();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void start(Video video2, PlayerDataSource dataSource) {
        Intrinsics.checkNotNullParameter(video2, "video");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        start(video2, dataSource, true);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void start(Video video2, PlayerDataSource dataSource, boolean autoStart) {
        Intrinsics.checkNotNullParameter(video2, "video");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.mRealVideoPlayHandler.start(video2, dataSource, autoStart);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void stop(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        this.mRealVideoPlayHandler.stop(video2);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void release() {
        this.mRealVideoPlayHandler.release();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void update(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        this.mRealVideoPlayHandler.update(video2);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void updateMediaResource(boolean autoStart, ResolveListener outerResolveListener) {
        VideoPlayHandler.updateMediaResource$default(this.mRealVideoPlayHandler, autoStart, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    /* renamed from: obtainMediaResourceSync-4pVzu0o */
    public MediaResource mo2235obtainMediaResourceSync4pVzu0o(int reason, int i, int format) {
        return this.mRealVideoPlayHandler.mo2235obtainMediaResourceSync4pVzu0o(reason, i, format);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void reload() {
        this.mRealVideoPlayHandler.reload();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void play(CurrentVideoPointer item) {
        Intrinsics.checkNotNullParameter(item, "item");
        play(item, true);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void play(CurrentVideoPointer item, boolean autoStart) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.mRealVideoPlayHandler.play(item);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public boolean startFromShared(Video video2, PlayerDataSource playerDataSource) {
        Intrinsics.checkNotNullParameter(video2, "video");
        Intrinsics.checkNotNullParameter(playerDataSource, "playerDataSource");
        return this.mRealVideoPlayHandler.startFromShared(video2, playerDataSource);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void onCollectSharedParams(PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.mRealVideoPlayHandler.onCollectSharedParams(bundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void onRestoreFromSharedParams(PlayerSharingBundle bundle) {
        this.mRealVideoPlayHandler.onRestoreFromSharedParams(bundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public boolean hasNext() {
        return this.mRealVideoPlayHandler.hasNext();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public boolean hasPrevious() {
        return this.mRealVideoPlayHandler.hasPrevious();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void playNext(boolean loop) {
        this.mRealVideoPlayHandler.playNext(loop);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void playPrevious(boolean loop) {
        this.mRealVideoPlayHandler.playPrevious(loop);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void onCompleted() {
        this.mRealVideoPlayHandler.onCompleted();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public Video getCurrentVideo() {
        return this.mRealVideoPlayHandler.getCurrentVideo();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void setHistoryProgressReader(AbsMediaResourceResolveTask.IHistoryProgressReader reader) {
        this.mRealVideoPlayHandler.setHistoryProgressReader(reader);
    }
}