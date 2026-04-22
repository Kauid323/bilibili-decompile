package tv.danmaku.biliplayerv2.service;

import android.text.TextUtils;
import bili.resource.playerbaseres.R;
import com.bilibili.lib.media.resolver2.BiliCodec;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.util.ExtraInfoExtensionKt;
import com.bilibili.lib.media.util.PreviewInfo;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayer.preload.repository.PreloadPool;
import tv.danmaku.biliplayer.preload.repository.PreloadPoolKt;
import tv.danmaku.biliplayer.preload.repository.VideoCacheScope;
import tv.danmaku.biliplayerv2.BuildConfig;
import tv.danmaku.biliplayerv2.PlayerContainerCoroutineKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.profiler.PlayerProfiler;
import tv.danmaku.biliplayerv2.profiler.ProfilerTags;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.utils.MediaItemBuilderExtKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: NormalVideoPlayHandler.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u001a\u0010$\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J)\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\u0019H\u0016J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0005H\u0016J\u0018\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\rH\u0016J7\u00103\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00052$\u00104\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001905H\u0082\bJ0\u00108\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00052\u0006\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u0002072\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010<\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0005H\u0002J\"\u0010=\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00052\u0006\u0010>\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010?\u001a\u00020\u0019H\u0002J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020(H\u0002J\b\u0010B\u001a\u00020\u0019H\u0016J\b\u0010C\u001a\u00020\u0019H\u0016J\b\u0010D\u001a\u00020\rH\u0016J\u0012\u0010E\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010G\u001a\u00020\rH\u0016J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\rH\u0016J\u0010\u0010J\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\rH\u0016J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\n\u0010L\u001a\u0004\u0018\u00010\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006N"}, d2 = {"Ltv/danmaku/biliplayerv2/service/NormalVideoPlayHandler;", "Ltv/danmaku/biliplayerv2/service/VideoPlayHandler;", "<init>", "()V", "mVideoItem", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "mVideo", "Ltv/danmaku/biliplayerv2/service/Video;", "mCurrentPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "mDataSource", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "mIsResolvingMainEntry", "", "mPendingUpdateMediaResource", "mLoadingPlayerSdkToast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "mHistoryProgressReader", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "mResolverJob", "Lkotlinx/coroutines/Job;", "currentVideoItem", "getCurrentVideoItem", "()Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "start", "", "video", "dataSource", "autoStart", "onCollectSharedParams", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onRestoreFromSharedParams", "startFromShared", "playerDataSource", "stop", "updateMediaResource", "outerResolveListener", "Ltv/danmaku/biliplayerv2/service/ResolveListener;", "obtainMediaResourceSync", "Lcom/bilibili/lib/media/resource/MediaResource;", "reason", "", "codecType", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", IjkMediaMeta.IJKM_KEY_FORMAT, "obtainMediaResourceSync-4pVzu0o", "(III)Lcom/bilibili/lib/media/resource/MediaResource;", "reload", "play", "item", "checkPreloadEnableRun", "action", "Lkotlin/Function4;", "Ltv/danmaku/biliplayer/preload/repository/PreloadPool;", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "playPreloadRes", "pool", "playableParams", "resolveParams", "videoItemChange", "resolve", "startPosition", "cancelResolverTask", "setFakeDurationIfNeeded", "mediaResource", "replay", "release", "hasNext", "setHistoryProgressReader", "reader", "hasPrevious", "playNext", "loop", "playPrevious", "update", "getCurrentVideo", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NormalVideoPlayHandler extends VideoPlayHandler {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "NormalVideoPlayHandler";
    private Video.PlayableParams mCurrentPlayableParams;
    private PlayerDataSource mDataSource;
    private AbsMediaResourceResolveTask.IHistoryProgressReader mHistoryProgressReader;
    private boolean mIsResolvingMainEntry;
    private PlayerToast mLoadingPlayerSdkToast;
    private boolean mPendingUpdateMediaResource;
    private Job mResolverJob;
    private Video mVideo;
    private CurrentVideoPointer mVideoItem;

    /* compiled from: NormalVideoPlayHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/NormalVideoPlayHandler$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
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
        return this.mVideoItem;
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
        PlayerLog.i(TAG, "start video: " + video2.getDescription());
        if (video2.getForceReplay()) {
            video2.setCurrentIndex(0);
            PlayerLog.i(TAG, "force start video from 0 index");
        }
        this.mDataSource = dataSource;
        getMVideoPlayEventDispatcher().dispatchVideoStart(video2);
        this.mVideo = video2;
        this.mVideoItem = new CurrentVideoPointer();
        CurrentVideoPointer currentVideoPointer = this.mVideoItem;
        if (currentVideoPointer != null) {
            currentVideoPointer.setType(2);
        }
        CurrentVideoPointer currentVideoPointer2 = this.mVideoItem;
        if (currentVideoPointer2 != null) {
            Video video3 = this.mVideo;
            currentVideoPointer2.setIndex(video3 != null ? video3.getCurrentIndex() : 0);
        }
        CurrentVideoPointer currentVideoPointer3 = this.mVideoItem;
        if (currentVideoPointer3 != null) {
            CurrentVideoPointer currentVideoPointer4 = this.mVideoItem;
            currentVideoPointer3.setDescription("index:" + (currentVideoPointer4 != null ? Integer.valueOf(currentVideoPointer4.getIndex()) : null));
        }
        CurrentVideoPointer currentVideoPointer5 = this.mVideoItem;
        Intrinsics.checkNotNull(currentVideoPointer5);
        play(currentVideoPointer5, autoStart);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void onCollectSharedParams(PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        CurrentVideoPointer videoItem = getCurrentVideoItem();
        if (videoItem == null) {
            return;
        }
        bundle.putSharableObject("key_share_current_video_item", videoItem);
        videoItem.detachByShared();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void onRestoreFromSharedParams(PlayerSharingBundle bundle) {
        if (bundle != null) {
            this.mVideoItem = (CurrentVideoPointer) PlayerSharingBundle.getSharableObject$default(bundle, "key_share_current_video_item", false, 2, null);
            CurrentVideoPointer currentVideoPointer = this.mVideoItem;
            if (currentVideoPointer != null) {
                currentVideoPointer.attachByShared();
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public boolean startFromShared(final Video video2, final PlayerDataSource playerDataSource) {
        Intrinsics.checkNotNullParameter(video2, "video");
        Intrinsics.checkNotNullParameter(playerDataSource, "playerDataSource");
        PlayerLog.i(TAG, "start from shared, videoItem: " + this.mVideoItem);
        final CurrentVideoPointer videoItem = this.mVideoItem;
        if (videoItem == null) {
            return false;
        }
        int videoItemCount = playerDataSource.getVideoItemCount(video2);
        if (videoItem.getIndex() >= videoItemCount) {
            videoItem.setIndex(0);
            PlayerLog.e(TAG, "startFromShared videoitem index error, item count is " + videoItemCount + " item index is " + videoItem.getIndex());
            if (BuildConfig.DEBUG) {
                throw new IllegalArgumentException("startFromShared videoitem index error, item count is " + videoItemCount + " item index is " + videoItem.getIndex());
            }
        }
        this.mCurrentPlayableParams = playerDataSource.getVideoItem(video2, videoItem.getIndex());
        this.mDataSource = playerDataSource;
        return getMPlayerCoreService().playFromShared(new Function0() { // from class: tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit startFromShared$lambda$0;
                startFromShared$lambda$0 = NormalVideoPlayHandler.startFromShared$lambda$0(NormalVideoPlayHandler.this, video2, videoItem);
                return startFromShared$lambda$0;
            }
        }, new Function0() { // from class: tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit startFromShared$lambda$1;
                startFromShared$lambda$1 = NormalVideoPlayHandler.startFromShared$lambda$1(PlayerDataSource.this, video2, videoItem, this);
                return startFromShared$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startFromShared$lambda$0(NormalVideoPlayHandler this$0, Video $video, CurrentVideoPointer $videoItem) {
        this$0.mVideo = $video;
        this$0.getMVideoPlayEventDispatcher().dispatchVideoStart($video);
        this$0.getMVideoPlayEventDispatcher().dispatchVideoItemWillChange($videoItem, $videoItem, $video);
        this$0.getMVideoPlayEventDispatcher().dispatchVideoItemStart($videoItem, $video);
        this$0.getMVideoPlayEventDispatcher().dispatchResolveSucceed();
        MediaResource it = this$0.getMPlayerCoreService().getMediaResource();
        if (it != null) {
            this$0.setFakeDurationIfNeeded(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startFromShared$lambda$1(PlayerDataSource $playerDataSource, Video $video, CurrentVideoPointer $videoItem, NormalVideoPlayHandler this$0) {
        Video.PlayableParams playableParams = $playerDataSource.getVideoItem($video, $videoItem.getIndex());
        if (playableParams == null) {
            return Unit.INSTANCE;
        }
        boolean sharedDanmaku = this$0.getMDanmakuService().startFromShared(playableParams.getDanmakuResolveParams());
        if (sharedDanmaku) {
            return Unit.INSTANCE;
        }
        this$0.getMPlayerContainer().getVideoPlayDirectorService().resolveDanmaku();
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void stop(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        PlayerLog.i(TAG, "stop video: " + video2.getDescription());
        String id = video2.getId();
        Video video3 = this.mVideo;
        if (TextUtils.equals(id, video3 != null ? video3.getId() : null)) {
            getMPlayerCoreService().pause();
            this.mVideo = null;
            this.mVideoItem = null;
        }
        cancelResolverTask();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void updateMediaResource(boolean autoStart, ResolveListener outerResolveListener) {
        Video video2;
        CurrentVideoPointer item;
        Video.PlayableParams playableParams;
        PlayerLog.i(TAG, "updateMediaResource, autoStart:" + autoStart);
        if (this.mIsResolvingMainEntry) {
            PlayerLog.i(TAG, "main entry is resolving, update media resource latter");
            this.mPendingUpdateMediaResource = true;
            return;
        }
        PlayerDataSource dataSource = this.mDataSource;
        if (dataSource == null || (video2 = this.mVideo) == null || (item = this.mVideoItem) == null || (playableParams = dataSource.getVideoItem(video2, item.getIndex())) == null) {
            return;
        }
        int quality = expectedQuality();
        PlayerLog.i(TAG, "update media resource resolving, quality:" + quality);
        if (quality > 0) {
            playableParams.setExpectedQuality(quality);
        }
        int currentPosition = getMPlayerContainer().getPlayerCoreService().getCurrentPosition();
        IResolveParams resolveParams = playableParams.getResolveParams();
        int format = resolveParams != null ? resolveParams.getFormat() : 0;
        IResolveParams resolveParams2 = playableParams.getResolveParams();
        int codec = resolveParams2 != null ? resolveParams2.getCodecType-eY-7Wcs() : BiliCodec.Companion.getDEFAULT-eY-7Wcs();
        AbsMediaResourceResolveTask mediaResourceResolveTask = CommonResolveTaskProvider.CC.m2285provideMediaSourceResolveTask9jpZhns$default(getMPlayerContainer().getVideoPlayDirectorService().getCommonResolveTaskProvider(), getMPlayerContainer().getContext(), true, false, playableParams, format, codec, null, 0, 128, null);
        int state = getMPlayerCoreService().getState();
        if (state != 4 && state != 5 && state != 6) {
            AbsMediaResourceResolveTask.HistoryProgressReader historyProgressReader = this.mHistoryProgressReader;
            if (historyProgressReader == null) {
                historyProgressReader = new AbsMediaResourceResolveTask.HistoryProgressReader(playableParams, null, 2, null);
            }
            mediaResourceResolveTask.setHistoryProgressReader(historyProgressReader);
        }
        cancelResolverTask();
        this.mResolverJob = BuildersKt.launch$default(VideoCacheScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new NormalVideoPlayHandler$updateMediaResource$1(mediaResourceResolveTask, outerResolveListener, playableParams, this, autoStart, currentPosition, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMediaResource$finishResolver(NormalVideoPlayHandler this$0, boolean $autoStart, Video.PlayableParams playableParams, int currentPosition, MediaResource mediaResource) {
        PlayerLog.i(TAG, "update media resource resolve succeed");
        boolean shouldStart = this$0.getMPlayerCoreService().getState() == 4 || $autoStart;
        MediaItemParams.Builder $this$updateMediaResource_u24finishResolver_u24lambda_u240 = MediaItemBuilderExtKt.applyPlayableParams(MediaItemBuilderExtKt.getMediaItemParamsBuilder(this$0.getMPlayerContainer(), mediaResource), playableParams);
        $this$updateMediaResource_u24finishResolver_u24lambda_u240.setStartPosition(this$0.getMPlayerCoreService().interceptSeekTarget(currentPosition));
        IMediaItemParamsInterceptor mediaItemSettingInterceptor = this$0.getMPlayerContainer().getVideoPlayDirectorService().getMediaItemSettingInterceptor();
        if (mediaItemSettingInterceptor != null) {
            mediaItemSettingInterceptor.interceptMediaItemParams(playableParams, $this$updateMediaResource_u24finishResolver_u24lambda_u240, true);
        }
        MediaItemParams itemParams = $this$updateMediaResource_u24finishResolver_u24lambda_u240.build();
        this$0.setFakeDurationIfNeeded(mediaResource);
        this$0.getMPlayerCoreService().setMediaResource(mediaResource, shouldStart, itemParams);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    /* renamed from: obtainMediaResourceSync-4pVzu0o  reason: not valid java name */
    public MediaResource mo2235obtainMediaResourceSync4pVzu0o(int reason, int i, int format) {
        if (this.mDataSource == null || this.mVideo == null || this.mVideoItem == null) {
            return null;
        }
        PlayerDataSource playerDataSource = this.mDataSource;
        Intrinsics.checkNotNull(playerDataSource);
        Video video2 = this.mVideo;
        Intrinsics.checkNotNull(video2);
        CurrentVideoPointer currentVideoPointer = this.mVideoItem;
        Intrinsics.checkNotNull(currentVideoPointer);
        Video.PlayableParams videoItem = playerDataSource.getVideoItem(video2, currentVideoPointer.getIndex());
        if (videoItem == null) {
            return null;
        }
        int quality = expectedQuality();
        PlayerLog.i(TAG, "obtain media resource sync resolving, quality:" + quality);
        if (quality > 0) {
            videoItem.setExpectedQuality(quality);
        }
        if (reason == 4) {
            videoItem.setEnableSafeConnection(true);
        }
        MediaResource mediaResource = getMPlayerCoreService().getMediaResource();
        String language = mediaResource != null ? mediaResource.getCurrentLanguage() : null;
        MediaResource mediaResource2 = getMPlayerCoreService().getMediaResource();
        int productionType = mediaResource2 != null ? mediaResource2.getCurProductionType() : 0;
        AbsMediaResourceResolveTask mediaResourceResolveTask = getMPlayerContainer().getVideoPlayDirectorService().getCommonResolveTaskProvider().mo2282provideMediaSourceResolveTask9jpZhns(getMPlayerContainer().getContext(), true, false, videoItem, format, i, language, productionType);
        mediaResourceResolveTask.run();
        return mediaResourceResolveTask.getResult();
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void reload() {
        PlayerLog.i(TAG, "call reload current video item");
        CurrentVideoPointer item = this.mVideoItem;
        if (item == null) {
            return;
        }
        int curPosition = getMPlayerCoreService().getCurrentPosition();
        resolve$default(this, item, curPosition, false, 4, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void play(CurrentVideoPointer item) {
        Intrinsics.checkNotNullParameter(item, "item");
        play(item, true);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void play(CurrentVideoPointer item, boolean autoStart) {
        boolean z;
        Intrinsics.checkNotNullParameter(item, "item");
        PlayerLog.i(TAG, "start play videoItem:" + item.getDescription());
        if (getMPlayerCoreService().getState() == 4) {
            getMPlayerCoreService().pause();
        }
        getMFunctionWidgetService().showBufferingWidget();
        Video video$iv = this.mVideo;
        if (video$iv == null) {
            z = false;
        } else if (video$iv.getEnablePreload()) {
            PreloadPool cachePool$iv = PreloadPoolKt.getPlayerCachePool();
            PlayerDataSource dataSource$iv = this.mDataSource;
            if (dataSource$iv == null) {
                z = false;
            } else {
                Video.PlayableParams playableParams$iv = dataSource$iv.getVideoItem(video$iv, item.getIndex());
                if (playableParams$iv == null) {
                    z = false;
                } else {
                    IResolveParams resolveParams$iv = playableParams$iv.getResolveParams();
                    if (resolveParams$iv == null) {
                        z = false;
                    } else {
                        playPreloadRes(item, cachePool$iv, playableParams$iv, resolveParams$iv, autoStart);
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        boolean enablePlayPreload = z;
        if (!enablePlayPreload && !resolve(item, 0, autoStart)) {
            PlayerLog.e(TAG, "resolve videoItem error!!!");
        }
    }

    private final boolean checkPreloadEnableRun(CurrentVideoPointer item, Function4<? super CurrentVideoPointer, ? super PreloadPool, ? super Video.PlayableParams, ? super IResolveParams, Unit> function4) {
        Video.PlayableParams playableParams;
        IResolveParams resolveParams;
        Video video2 = this.mVideo;
        if (video2 != null && video2.getEnablePreload()) {
            PreloadPool cachePool = PreloadPoolKt.getPlayerCachePool();
            PlayerDataSource dataSource = this.mDataSource;
            if (dataSource == null || (playableParams = dataSource.getVideoItem(video2, item.getIndex())) == null || (resolveParams = playableParams.getResolveParams()) == null) {
                return false;
            }
            function4.invoke(item, cachePool, playableParams, resolveParams);
            return true;
        }
        return false;
    }

    private final void playPreloadRes(CurrentVideoPointer item, PreloadPool pool, Video.PlayableParams playableParams, IResolveParams resolveParams, boolean autoStart) {
        BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(getMPlayerContainer()), (CoroutineContext) null, (CoroutineStart) null, new NormalVideoPlayHandler$playPreloadRes$1(pool, resolveParams, this, item, playableParams, autoStart, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void videoItemChange(CurrentVideoPointer item) {
        CurrentVideoPointer it = this.mVideoItem;
        if (it != null) {
            IVideosPlayDirectorService.IVideoPlayEventDispatcher mVideoPlayEventDispatcher = getMVideoPlayEventDispatcher();
            Video video2 = this.mVideo;
            Intrinsics.checkNotNull(video2);
            mVideoPlayEventDispatcher.dispatchVideoItemWillChange(it, item, video2);
        }
        getMPlayerCoreService().removeCurrentSource();
        this.mVideoItem = item;
        IVideosPlayDirectorService.IVideoPlayEventDispatcher mVideoPlayEventDispatcher2 = getMVideoPlayEventDispatcher();
        CurrentVideoPointer currentVideoPointer = this.mVideoItem;
        Intrinsics.checkNotNull(currentVideoPointer);
        Video video3 = this.mVideo;
        Intrinsics.checkNotNull(video3);
        mVideoPlayEventDispatcher2.dispatchVideoItemStart(currentVideoPointer, video3);
    }

    static /* synthetic */ boolean resolve$default(NormalVideoPlayHandler normalVideoPlayHandler, CurrentVideoPointer currentVideoPointer, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return normalVideoPlayHandler.resolve(currentVideoPointer, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resolve(CurrentVideoPointer item, int startPosition, boolean autoStart) {
        Video video2;
        Video.PlayableParams playableParams;
        PlayerLog.i(TAG, "resolve before actual play");
        PlayerDataSource dataSource = this.mDataSource;
        if (dataSource == null || (video2 = this.mVideo) == null || item.getIndex() >= dataSource.getVideoItemCount(video2) || (playableParams = dataSource.getVideoItem(video2, item.getIndex())) == null) {
            return false;
        }
        int quality = expectedQuality();
        PlayerLog.i(TAG, "resolve resolving, quality:" + quality);
        if (quality > 0) {
            playableParams.setExpectedQuality(quality);
        }
        this.mCurrentPlayableParams = playableParams;
        Video video3 = this.mVideo;
        if (video3 != null) {
            video3.setCurrentIndex(item.getIndex());
        }
        this.mIsResolvingMainEntry = true;
        videoItemChange(item);
        cancelResolverTask();
        this.mResolverJob = BuildersKt.launch$default(VideoCacheScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new NormalVideoPlayHandler$resolve$1(this, playableParams, video2, startPosition, autoStart, null), 3, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolve$resolveMediaResourceSucceed(Video.PlayableParams playableParams, NormalVideoPlayHandler this$0, int $startPosition, boolean $autoStart, MediaResource resource) {
        int actualPosition;
        String str;
        String id = playableParams.id();
        Video.PlayableParams playableParams2 = this$0.mCurrentPlayableParams;
        if (!TextUtils.equals(id, playableParams2 != null ? playableParams2.id() : null)) {
            String id2 = playableParams.id();
            Video.PlayableParams playableParams3 = this$0.mCurrentPlayableParams;
            PlayerLog.i(TAG, "resolve succeed, but video has changed: " + id2 + " " + (playableParams3 != null ? playableParams3.id() : null));
            return;
        }
        PlayerProfiler playerProfiler = this$0.getMPlayerContainer().getPlayerProfiler();
        if (playerProfiler != null) {
            playerProfiler.doProfile(ProfilerTags.RESOLVE_PLAY_URL_FIRE, null);
        }
        PlayerLog.i(TAG, "resolve succeed");
        if ($startPosition > 0) {
            actualPosition = $startPosition;
        } else {
            actualPosition = resource.startPosition;
        }
        MediaItemParams.Builder $this$resolve_u24resolveMediaResourceSucceed_u24lambda_u240 = MediaItemBuilderExtKt.applyPlayableParams(MediaItemBuilderExtKt.getMediaItemParamsBuilder(this$0.getMPlayerContainer(), resource), playableParams);
        $this$resolve_u24resolveMediaResourceSucceed_u24lambda_u240.setStartPosition(this$0.getMPlayerCoreService().interceptSeekTarget(actualPosition));
        int[] range = this$0.getRecommendStartQualityRange();
        if (range != null && range.length == 2) {
            $this$resolve_u24resolveMediaResourceSucceed_u24lambda_u240.setRecommendStartQualityRange(range);
        }
        if (Intrinsics.areEqual(playableParams.getFrom(), "live")) {
            $this$resolve_u24resolveMediaResourceSucceed_u24lambda_u240.setEnableLiveSkipFrame(true);
        }
        IMediaItemParamsInterceptor mediaItemSettingInterceptor = this$0.getMPlayerContainer().getVideoPlayDirectorService().getMediaItemSettingInterceptor();
        if (mediaItemSettingInterceptor != null) {
            mediaItemSettingInterceptor.interceptMediaItemParams(playableParams, $this$resolve_u24resolveMediaResourceSucceed_u24lambda_u240, false);
        }
        MediaItemParams itemParams = $this$resolve_u24resolveMediaResourceSucceed_u24lambda_u240.build();
        this$0.setFakeDurationIfNeeded(resource);
        this$0.getMPlayerCoreService().setMediaResource(resource, $autoStart, itemParams);
        HashMap profilerParams = new HashMap();
        profilerParams.put(ProfilerTags.KEY_EXTRAS_QN, String.valueOf(this$0.getMPlayerCoreService().getCurrentQuality()));
        HashMap hashMap = profilerParams;
        switch (resource.sourceFrom()) {
            case 1:
                str = "1";
                break;
            case 2:
            default:
                str = "0";
                break;
            case 3:
                str = "2";
                break;
        }
        hashMap.put(ProfilerTags.KEY_EXTRAS_RESOLVE_TYPE, str);
        profilerParams.put(ProfilerTags.KEY_EXTRAS_START_POSITION, String.valueOf(actualPosition));
        PlayerProfiler playerProfiler2 = this$0.getMPlayerContainer().getPlayerProfiler();
        if (playerProfiler2 != null) {
            playerProfiler2.doProfile(ProfilerTags.SET_MEDIA_ITEM, profilerParams);
        }
        playableParams.setFlashJsonStr(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolve$startLoadSdk(NormalVideoPlayHandler this$0) {
        PlayerToast.Builder location = new PlayerToast.Builder().toastItemType(17).location(32);
        String string = this$0.getMPlayerContainer().getContext().getString(R.string.playerbaseres_global_string_1258);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this$0.mLoadingPlayerSdkToast = location.setExtraString(PlayerToastConfig.EXTRA_TITLE, string).duration(PlayerToastConfig.DURATION_3).build();
        IToastService toastService = this$0.getMPlayerContainer().getToastService();
        PlayerToast playerToast = this$0.mLoadingPlayerSdkToast;
        Intrinsics.checkNotNull(playerToast);
        toastService.showToast(playerToast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolve$finishLoadSdk(NormalVideoPlayHandler this$0) {
        PlayerToast it = this$0.mLoadingPlayerSdkToast;
        if (it != null) {
            this$0.getMPlayerContainer().getToastService().dismissToast(it);
        }
    }

    private final void cancelResolverTask() {
        Job job;
        Job job2 = this.mResolverJob;
        boolean z = false;
        if (job2 != null && job2.isActive()) {
            z = true;
        }
        if (z && (job = this.mResolverJob) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mResolverJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFakeDurationIfNeeded(MediaResource mediaResource) {
        final PreviewInfo previewInfo;
        ExtraInfo extraInfo = mediaResource.getExtraInfo();
        if (extraInfo == null || (previewInfo = ExtraInfoExtensionKt.getPreviewInfo(extraInfo)) == null) {
            return;
        }
        IPlayerCoreService service = getMPlayerCoreService();
        if (previewInfo.isPreview() && previewInfo.getCustomFakeDuration() != 0) {
            service.setDurationInterceptor(new IDurationInterceptor() { // from class: tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$setFakeDurationIfNeeded$1
                @Override // tv.danmaku.biliplayerv2.service.IDurationInterceptor
                public int intercept(int duration) {
                    return (int) previewInfo.getCustomFakeDurationMs();
                }
            });
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void replay() {
        PlayerLog.i(TAG, "call replay");
        if (this.mVideoItem != null && this.mVideo != null) {
            if (getMPlayerCoreService().getCurrentPosition() < getMPlayerCoreService().getDuration()) {
                getMPlayerCoreService().seekTo(0);
            }
            if (getMPlayerCoreService().getState() == 6) {
                getMPlayerCoreService().resume();
            } else {
                getMPlayerCoreService().play();
            }
            IVideosPlayDirectorService.IVideoPlayEventDispatcher mVideoPlayEventDispatcher = getMVideoPlayEventDispatcher();
            CurrentVideoPointer currentVideoPointer = this.mVideoItem;
            Intrinsics.checkNotNull(currentVideoPointer);
            Video video2 = this.mVideo;
            Intrinsics.checkNotNull(video2);
            mVideoPlayEventDispatcher.dispatchVideoItemStart(currentVideoPointer, video2);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void release() {
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public boolean hasNext() {
        int count;
        if (this.mVideo == null) {
            return false;
        }
        PlayerDataSource playerDataSource = this.mDataSource;
        if (playerDataSource != null) {
            Video video2 = this.mVideo;
            Intrinsics.checkNotNull(video2);
            count = playerDataSource.getVideoItemCount(video2);
        } else {
            count = 0;
        }
        Video video3 = this.mVideo;
        Intrinsics.checkNotNull(video3);
        return video3.getCurrentIndex() < count + (-1);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void setHistoryProgressReader(AbsMediaResourceResolveTask.IHistoryProgressReader reader) {
        this.mHistoryProgressReader = reader;
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public boolean hasPrevious() {
        if (this.mVideo == null) {
            return false;
        }
        Video video2 = this.mVideo;
        Intrinsics.checkNotNull(video2);
        return video2.getCurrentIndex() > 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void playNext(boolean loop) {
        PlayerDataSource playerDataSource;
        Video video2 = this.mVideo;
        if (video2 == null || (playerDataSource = this.mDataSource) == null) {
            return;
        }
        int count = playerDataSource.getVideoItemCount(video2);
        CurrentVideoPointer item = new CurrentVideoPointer();
        item.setIndex(video2.getCurrentIndex() + 1);
        if (item.getIndex() >= count) {
            if (loop) {
                item.setIndex(0);
                video2.setCurrentIndex(0);
            } else {
                PlayerLog.i(TAG, "do not has a next item");
                return;
            }
        }
        PlayerLog.i(TAG, "call play next");
        play(item);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void playPrevious(boolean loop) {
        PlayerDataSource playerDataSource;
        Video video2 = this.mVideo;
        if (video2 == null || (playerDataSource = this.mDataSource) == null) {
            return;
        }
        int count = playerDataSource.getVideoItemCount(video2);
        CurrentVideoPointer item = new CurrentVideoPointer();
        item.setIndex(video2.getCurrentIndex() - 1);
        if (item.getIndex() < 0) {
            if (loop) {
                item.setIndex(count - 1);
                video2.setCurrentIndex(count - 1);
            } else {
                PlayerLog.i(TAG, "do not has a previous item");
                return;
            }
        }
        PlayerLog.i(TAG, "call play previous");
        play(item);
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public void update(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        PlayerLog.i(TAG, "call update video");
        PlayerDataSource dataSource = this.mDataSource;
        if (dataSource == null) {
            return;
        }
        Video.PlayableParams playableParams = this.mCurrentPlayableParams;
        if (playableParams == null) {
            this.mVideo = video2;
            return;
        }
        boolean found = false;
        int itemCount = dataSource.getVideoItemCount(video2);
        for (int i = 0; i < itemCount; i++) {
            Video.PlayableParams p = dataSource.getVideoItem(video2, i);
            if (p != null && TextUtils.equals(p.id(), playableParams.id())) {
                video2.setCurrentIndex(i);
                CurrentVideoPointer currentVideoPointer = this.mVideoItem;
                if (currentVideoPointer != null) {
                    currentVideoPointer.setIndex(i);
                }
                found = true;
            }
        }
        this.mVideo = video2;
        if (!found) {
            PlayerLog.i(TAG, "update video not found same item, play first");
            CurrentVideoPointer p2 = new CurrentVideoPointer();
            p2.setIndex(0);
            play(p2);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.VideoPlayHandler
    public Video getCurrentVideo() {
        return this.mVideo;
    }
}