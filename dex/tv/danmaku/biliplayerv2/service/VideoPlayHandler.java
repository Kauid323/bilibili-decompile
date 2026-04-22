package tv.danmaku.biliplayerv2.service;

import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: IVideoPlayDirectorService.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000bH\u0017J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020%H&J\u0018\u00107\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u000205H&J \u00107\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u000201H&J\u0010\u0010:\u001a\u00020%2\u0006\u00102\u001a\u000203H&J\b\u0010;\u001a\u00020%H&J\u0010\u0010<\u001a\u00020%2\u0006\u00102\u001a\u000203H&J\u001c\u0010=\u001a\u00020%2\u0006\u00109\u001a\u0002012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?H&J)\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020)H&¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020%H&J\u0010\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020!H&J\u0018\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020!2\u0006\u00109\u001a\u000201H&J\b\u0010K\u001a\u00020%H\u0016J\u0012\u0010L\u001a\u00020%2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u000201H&J\b\u0010P\u001a\u000201H&J\u0010\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u000201H&J\u0010\u0010S\u001a\u00020%2\u0006\u0010R\u001a\u000201H&J\n\u0010T\u001a\u0004\u0018\u000103H&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u0004\u0018\u00010!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006U"}, d2 = {"Ltv/danmaku/biliplayerv2/service/VideoPlayHandler;", "", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "getMPlayerContainer", "()Ltv/danmaku/biliplayerv2/PlayerContainer;", "setMPlayerContainer", "(Ltv/danmaku/biliplayerv2/PlayerContainer;)V", "mVideoPlayEventDispatcher", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$IVideoPlayEventDispatcher;", "getMVideoPlayEventDispatcher", "()Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$IVideoPlayEventDispatcher;", "setMVideoPlayEventDispatcher", "(Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$IVideoPlayEventDispatcher;)V", "mPlayerCoreService", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "getMPlayerCoreService", "()Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "mPlayerCoreService$delegate", "Lkotlin/Lazy;", "mDanmakuService", "Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "getMDanmakuService", "()Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "mDanmakuService$delegate", "mFunctionWidgetService", "Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "getMFunctionWidgetService", "()Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "mFunctionWidgetService$delegate", "currentVideoItem", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "getCurrentVideoItem", "()Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "attach", "", "playerContainer", "dispatcher", "expectedQuality", "", "getRecommendStartQualityRange", "", "onCollectSharedParams", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onRestoreFromSharedParams", "startFromShared", "", "video", "Ltv/danmaku/biliplayerv2/service/Video;", "playerDataSource", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "replay", "start", "dataSource", "autoStart", "stop", "release", "update", "updateMediaResource", "outerResolveListener", "Ltv/danmaku/biliplayerv2/service/ResolveListener;", "obtainMediaResourceSync", "Lcom/bilibili/lib/media/resource/MediaResource;", "reason", "codecType", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", IjkMediaMeta.IJKM_KEY_FORMAT, "obtainMediaResourceSync-4pVzu0o", "(III)Lcom/bilibili/lib/media/resource/MediaResource;", "reload", "play", "item", "onCompleted", "setHistoryProgressReader", "reader", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "hasNext", "hasPrevious", "playNext", "loop", "playPrevious", "getCurrentVideo", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class VideoPlayHandler {
    protected PlayerContainer mPlayerContainer;
    protected IVideosPlayDirectorService.IVideoPlayEventDispatcher mVideoPlayEventDispatcher;
    private final Lazy mPlayerCoreService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.VideoPlayHandler$$ExternalSyntheticLambda0
        public final Object invoke() {
            IPlayerCoreService mPlayerCoreService_delegate$lambda$0;
            mPlayerCoreService_delegate$lambda$0 = VideoPlayHandler.mPlayerCoreService_delegate$lambda$0(VideoPlayHandler.this);
            return mPlayerCoreService_delegate$lambda$0;
        }
    });
    private final Lazy mDanmakuService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.VideoPlayHandler$$ExternalSyntheticLambda1
        public final Object invoke() {
            IInteractLayerService mDanmakuService_delegate$lambda$0;
            mDanmakuService_delegate$lambda$0 = VideoPlayHandler.mDanmakuService_delegate$lambda$0(VideoPlayHandler.this);
            return mDanmakuService_delegate$lambda$0;
        }
    });
    private final Lazy mFunctionWidgetService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.VideoPlayHandler$$ExternalSyntheticLambda2
        public final Object invoke() {
            AbsFunctionWidgetService mFunctionWidgetService_delegate$lambda$0;
            mFunctionWidgetService_delegate$lambda$0 = VideoPlayHandler.mFunctionWidgetService_delegate$lambda$0(VideoPlayHandler.this);
            return mFunctionWidgetService_delegate$lambda$0;
        }
    });

    public abstract Video getCurrentVideo();

    public abstract CurrentVideoPointer getCurrentVideoItem();

    public abstract boolean hasNext();

    public abstract boolean hasPrevious();

    /* renamed from: obtainMediaResourceSync-4pVzu0o */
    public abstract MediaResource mo2235obtainMediaResourceSync4pVzu0o(int i, int i2, int i3);

    public abstract void play(CurrentVideoPointer currentVideoPointer);

    public abstract void play(CurrentVideoPointer currentVideoPointer, boolean z);

    public abstract void playNext(boolean z);

    public abstract void playPrevious(boolean z);

    public abstract void release();

    public abstract void reload();

    public abstract void replay();

    public abstract void start(Video video2, PlayerDataSource playerDataSource);

    public abstract void start(Video video2, PlayerDataSource playerDataSource, boolean z);

    public abstract void stop(Video video2);

    public abstract void update(Video video2);

    public abstract void updateMediaResource(boolean z, ResolveListener resolveListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public final PlayerContainer getMPlayerContainer() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null) {
            return playerContainer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        return null;
    }

    protected final void setMPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "<set-?>");
        this.mPlayerContainer = playerContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IVideosPlayDirectorService.IVideoPlayEventDispatcher getMVideoPlayEventDispatcher() {
        IVideosPlayDirectorService.IVideoPlayEventDispatcher iVideoPlayEventDispatcher = this.mVideoPlayEventDispatcher;
        if (iVideoPlayEventDispatcher != null) {
            return iVideoPlayEventDispatcher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayEventDispatcher");
        return null;
    }

    protected final void setMVideoPlayEventDispatcher(IVideosPlayDirectorService.IVideoPlayEventDispatcher iVideoPlayEventDispatcher) {
        Intrinsics.checkNotNullParameter(iVideoPlayEventDispatcher, "<set-?>");
        this.mVideoPlayEventDispatcher = iVideoPlayEventDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlayerCoreService mPlayerCoreService_delegate$lambda$0(VideoPlayHandler this$0) {
        return this$0.getMPlayerContainer().getPlayerCoreService();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IPlayerCoreService getMPlayerCoreService() {
        return (IPlayerCoreService) this.mPlayerCoreService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IInteractLayerService mDanmakuService_delegate$lambda$0(VideoPlayHandler this$0) {
        return this$0.getMPlayerContainer().getInteractLayerService();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IInteractLayerService getMDanmakuService() {
        return (IInteractLayerService) this.mDanmakuService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbsFunctionWidgetService mFunctionWidgetService_delegate$lambda$0(VideoPlayHandler this$0) {
        return this$0.getMPlayerContainer().getFunctionWidgetService();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AbsFunctionWidgetService getMFunctionWidgetService() {
        return (AbsFunctionWidgetService) this.mFunctionWidgetService$delegate.getValue();
    }

    public void attach(PlayerContainer playerContainer, IVideosPlayDirectorService.IVideoPlayEventDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        setMPlayerContainer(playerContainer);
        setMVideoPlayEventDispatcher(dispatcher);
    }

    public final int expectedQuality() {
        int qualityByProvider = getMPlayerContainer().getVideoPlayDirectorService().getCurrentExpectedQuality();
        if (qualityByProvider > 0) {
            return qualityByProvider;
        }
        return getMPlayerContainer().getPlayerSettingService().getInt(Player.KEY_PLAY_QUALITY_USER_EXPECTED, 32);
    }

    public final int[] getRecommendStartQualityRange() {
        IVideoQualityProvider videoQualityProvider = getMPlayerContainer().getVideoPlayDirectorService().getVideoQualityProvider();
        if (videoQualityProvider != null) {
            return videoQualityProvider.getRecommendStartQualityRange();
        }
        return null;
    }

    public void onCollectSharedParams(PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    public void onRestoreFromSharedParams(PlayerSharingBundle bundle) {
    }

    public boolean startFromShared(Video video2, PlayerDataSource playerDataSource) {
        Intrinsics.checkNotNullParameter(video2, "video");
        Intrinsics.checkNotNullParameter(playerDataSource, "playerDataSource");
        return false;
    }

    public static /* synthetic */ void updateMediaResource$default(VideoPlayHandler videoPlayHandler, boolean z, ResolveListener resolveListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMediaResource");
        }
        if ((i & 2) != 0) {
            resolveListener = null;
        }
        videoPlayHandler.updateMediaResource(z, resolveListener);
    }

    public void onCompleted() {
        Video video2;
        CurrentVideoPointer item = getCurrentVideoItem();
        if (item == null || (video2 = getCurrentVideo()) == null) {
            return;
        }
        getMVideoPlayEventDispatcher().dispatchVideoItemCompleted(item, video2);
        if (!hasNext()) {
            getMVideoPlayEventDispatcher().dispatchVideoCompleted(video2);
        }
    }

    public void setHistoryProgressReader(AbsMediaResourceResolveTask.IHistoryProgressReader reader) {
    }
}