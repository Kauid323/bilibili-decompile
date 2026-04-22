package tv.danmaku.videoplayer.coreV2.transformer;

import android.app.Application;
import android.os.Build;
import android.view.WindowManager;
import com.bilibili.api.BiliConfig;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.media.resource.DashResource;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.media.resource.VolumeInfo;
import com.bilibili.lib.tf.TfTypeExt;
import com.bilibili.moduleservice.player.HDRUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaConfigParams;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.videoplayer.core.BuildConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.media.ijk.IjkOptionsHelper;
import tv.danmaku.videoplayer.core.media.ijk.IjkPluginLibLoader;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaItem;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaPlayerItemDecorate;

/* compiled from: IjkMediaItemTransformer.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J$\u0010\u001c\u001a\u00020\r2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016¨\u0006 "}, d2 = {"Ltv/danmaku/videoplayer/coreV2/transformer/IjkMediaItemTransformer;", "Ltv/danmaku/videoplayer/coreV2/transformer/IMediaItemTransformer;", "<init>", "()V", "createMediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "params", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams;", "listener", "Ltv/danmaku/videoplayer/coreV2/MediaItem$IStatusListener;", "setVolumeInfo", "", "ijkMediaConfigParams", "Ltv/danmaku/ijk/media/player/IjkMediaConfigParams;", "isValidVolumeInfo", "", "param", "", "initP2PConfig", "context", "Landroid/app/Application;", "getIjkTrackMode", "", "scheme", "mediaType", "", "updateMediaItem", "mediaItem", "oldResource", "newResource", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkMediaItemTransformer implements IMediaItemTransformer {

    /* compiled from: IjkMediaItemTransformer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TfTypeExt.values().length];
            try {
                iArr[TfTypeExt.C_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TfTypeExt.C_PKG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TfTypeExt.U_CARD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TfTypeExt.U_PKG.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[TfTypeExt.T_CARD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[TfTypeExt.T_PKG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.transformer.IMediaItemTransformer
    public MediaItem<?> createMediaItem(MediaResource resource, MediaItemParams params, MediaItem.IStatusListener listener) {
        String str;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!resource.isPlayable()) {
            if (BuildConfig.DEBUG) {
                throw new IllegalArgumentException("mediaResource is illegal @" + resource);
            }
            PlayerLog.e("IMediaItemTransformer", "mediaResource is illegal @" + resource);
            return null;
        }
        IjkMediaAsset asset = resource.translateToIjkMediaAsset(params.getVideoStreamId(), params.getAudioStreamId());
        Application context = BiliContext.application();
        if (asset != null && context != null) {
            int scheme = params.getScheme();
            PlayIndex playIndex = resource.getPlayIndex();
            String mediaType = playIndex != null ? playIndex.mFrom : null;
            if (scheme == 0) {
                scheme = 2;
                if (Intrinsics.areEqual("downloaded", mediaType)) {
                    scheme = 5;
                } else if (Intrinsics.areEqual("live", mediaType)) {
                    scheme = 1;
                }
            }
            int audioId = asset.getDefaultAudioId();
            int videoId = asset.getDefaultVideoId();
            PlayerLog.i("IjkMediaItemTransformer", "createMediaItem, scheme:" + scheme + ", videoId:" + videoId + ", audioId:" + audioId + ", mediaType:" + mediaType);
            IjkMediaPlayerItem ijkMediaPlayerItem = new IjkMediaPlayerItemDecorate(IjkPluginLibLoader.getInstance(context), context, HandlerThreads.getLooper(4), scheme, audioId, videoId);
            IjkMediaConfigParams ijkMediaConfigParams = new IjkMediaConfigParams();
            Boolean isEnableReportWidevineType = IjkOptionsHelper.isEnableReportWidevineType();
            Intrinsics.checkNotNullExpressionValue(isEnableReportWidevineType, "isEnableReportWidevineType(...)");
            ijkMediaConfigParams.mEnableReportWidevineType = isEnableReportWidevineType.booleanValue();
            ijkMediaConfigParams.mEnableHwCodec = params.getEnableHWCodex();
            IjkOptionsHelper.applyLooperFilter(ijkMediaConfigParams, params.getSkipLoopFilter());
            ijkMediaConfigParams.mTcpReadWriteTimeOut = IjkOptionsHelper.getIjkVodTcpReadWriteTimeout();
            ijkMediaConfigParams.mEnableDecodeSwitch = IjkOptionsHelper.getIjkEnableAndroidVariableCodec();
            ijkMediaConfigParams.mForceRenderLastFrame = params.getForceRenderLastFrame();
            ijkMediaConfigParams.mAudioTrackStreamType = params.getIjkAudioStreamType();
            Boolean isDoblyCheckMediacodec = IjkOptionsHelper.isDoblyCheckMediacodec();
            Intrinsics.checkNotNullExpressionValue(isDoblyCheckMediacodec, "isDoblyCheckMediacodec(...)");
            ijkMediaConfigParams.mDoblyCheckMediaCodec = isDoblyCheckMediacodec.booleanValue();
            ijkMediaConfigParams.mEnableRawData = params.getEnableRawData();
            Boolean isEnableStoryP2PDownload = IjkOptionsHelper.isEnableStoryP2PDownload();
            Intrinsics.checkNotNullExpressionValue(isEnableStoryP2PDownload, "isEnableStoryP2PDownload(...)");
            ijkMediaConfigParams.mEnableStoryP2PDownload = isEnableStoryP2PDownload.booleanValue();
            ijkMediaConfigParams.mUnusedLowLatencyCodecList = IjkOptionsHelper.getUnusedLowLatencyCodecList();
            ijkMediaConfigParams.mDisableSurfaceAlign = IjkOptionsHelper.getAlignSurfaceEnable();
            ijkMediaConfigParams.mLiveHeartbeatInterval = IjkOptionsHelper.getLiveHeartbeatInterval();
            ijkMediaConfigParams.mAppVersion = String.valueOf(BiliConfig.getBiliVersionCode());
            if (IjkOptionsHelper.isEnableMaxCacheSize()) {
                long maxCacheTime = IjkOptionsHelper.getMaxCacheSize();
                if (maxCacheTime > 0) {
                    ijkMediaConfigParams.mMaxCacheSize = maxCacheTime;
                }
            }
            if (params.getStartPosition() > 0) {
                if (!params.getForceRenderLastFrame() && !params.isForceStartAccurateSeek()) {
                    ijkMediaConfigParams.mStartOfPostion = (int) params.getStartPosition();
                } else {
                    ((IjkMediaPlayerItemDecorate) ijkMediaPlayerItem).setPlayPosition(params.getStartPosition());
                }
            }
            long cacheTime = params.getCacheTime();
            if (cacheTime > 0) {
                ijkMediaConfigParams.mInitCacheTime = cacheTime;
            }
            ijkMediaConfigParams.mEnableH265Codec = IjkOptionsHelper.isHevcEnable(context);
            Boolean ijkVariableSeekBuffer = IjkOptionsHelper.getIjkVariableSeekBuffer();
            Intrinsics.checkNotNullExpressionValue(ijkVariableSeekBuffer, "getIjkVariableSeekBuffer(...)");
            ijkMediaConfigParams.mEnableVariableSeekBuffer = ijkVariableSeekBuffer.booleanValue();
            ijkMediaConfigParams.mAccurateSeekTimeout = params.getAccurateSeekTimeoutMs() > 0 ? params.getAccurateSeekTimeoutMs() : IjkOptionsHelper.getAccurateSeekTimeout();
            ijkMediaConfigParams.mStartOnPrepared = params.getStartWhenPrepared();
            ijkMediaConfigParams.mHdrVideoType = 0;
            switch (scheme) {
                case 1:
                case 9:
                    ijkMediaConfigParams.mMultiBufferingControl = 1;
                    if (scheme == 9) {
                        ijkMediaConfigParams.mLiveDiscontinueWhenEOF = !IjkOptionsHelper.isDisableLiveStoryDiscontinueWhenEOF();
                        ijkMediaConfigParams.mSoftReconnect = IjkOptionsHelper.isEnableLiveStorySoftReconnect();
                        break;
                    }
                    break;
            }
            if (params.isHdr()) {
                HDRUtil hdrUtil = (HDRUtil) BLRouter.get$default(BLRouter.INSTANCE, HDRUtil.class, (String) null, 2, (Object) null);
                if (params.getHdrType() == 125) {
                    ijkMediaConfigParams.mHdrVideoType = 1;
                    ijkMediaConfigParams.mTryHwHdr = hdrUtil != null && hdrUtil.couldHdrHw();
                    if (IjkMediaItemTransformerKt.access$getHitHdrRenderTypeDD$p()) {
                        ijkMediaConfigParams.mHdrRenderType = ((hdrUtil == null || !hdrUtil.couldUseExternalRender(false)) ? 0 : 1) ^ 1;
                    }
                }
                if (params.getHdrType() == 129) {
                    Object systemService = context.getSystemService("window");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                    WindowManager window = (WindowManager) systemService;
                    if (Build.VERSION.SDK_INT >= 24 && window.getDefaultDisplay().getHdrCapabilities() != null) {
                        long maxLuminance = window.getDefaultDisplay().getHdrCapabilities().getDesiredMaxLuminance();
                        ijkMediaConfigParams.mExpHdrMaxDisplayLum = maxLuminance;
                        str = "IjkMediaItemTransformer";
                        PlayerLog.i(str, "HDR vivid下，成功获取屏幕最高亮度：" + maxLuminance);
                    } else {
                        str = "IjkMediaItemTransformer";
                        PlayerLog.i(str, "HDR vivid下，没有获取到屏幕的最高亮度");
                    }
                    ijkMediaConfigParams.mHdrVideoType = 6;
                    ijkMediaConfigParams.mTryHwHdr = hdrUtil != null && hdrUtil.couldHdrHw();
                    if (IjkMediaItemTransformerKt.access$getHitHdrRenderTypeDD$p()) {
                        if (hdrUtil != null) {
                            i = 1;
                            if (hdrUtil.couldUseExternalRender(true)) {
                                i2 = 1;
                                ijkMediaConfigParams.mHdrRenderType = i2 ^ i;
                            }
                        } else {
                            i = 1;
                        }
                        i2 = 0;
                        ijkMediaConfigParams.mHdrRenderType = i2 ^ i;
                    }
                } else {
                    str = "IjkMediaItemTransformer";
                }
            } else {
                str = "IjkMediaItemTransformer";
            }
            if (params.isDolbyVision()) {
                if (IjkOptionsHelper.isSupportDolbyVisionHw()) {
                    ijkMediaConfigParams.mHdrVideoType = 5;
                    ijkMediaConfigParams.mHdrRenderType = 1;
                    ijkMediaConfigParams.mEnableDolbyVisionCodec = true;
                } else {
                    ijkMediaConfigParams.mHdrVideoType = 3;
                    ijkMediaConfigParams.mHdrRenderType = 0;
                    ijkMediaConfigParams.mDolbyConfigPath = params.getDolbyConfigPath();
                }
            }
            ijkMediaConfigParams.mAVid = String.valueOf(params.getAvid());
            ijkMediaConfigParams.mSuperResolution = IjkOptionsHelper.isSupportSuperResolution();
            ijkMediaConfigParams.mEnableAlphaLayer = params.getEnableAlphaLayer();
            setVolumeInfo(ijkMediaConfigParams, params);
            if (scheme != 1 && scheme != 9) {
                initP2PConfig(ijkMediaConfigParams, context);
            }
            ijkMediaConfigParams.mEnableAmendExternalClock = IjkOptionsHelper.isEnableAmendExternalClock();
            ijkMediaConfigParams.mEnableIgnoreOnlyVideoBufferingReport = IjkOptionsHelper.isEnableIgnoreOnlyVideoBufferingReport();
            ijkMediaConfigParams.mEnableIgnoreDiscardPkt = IjkOptionsHelper.isEnableIgnoreDiscardPkt();
            ijkMediaConfigParams.mIsInLiveRoom = params.getEnableLiveSkipFrame();
            ijkMediaConfigParams.mExpectStartLatency = (int) params.getLiveStartLatency();
            ijkMediaConfigParams.mEnableVariableWh = params.getVariableResolutionRatio();
            Integer startScreenRatio = params.getStartScreenRatio();
            if (startScreenRatio != null) {
                ijkMediaConfigParams.mStartScreenRatio = startScreenRatio.intValue();
            }
            int mode = params.getTrackerMode();
            if (mode == 0) {
                mode = getIjkTrackMode(scheme, mediaType);
            }
            if (scheme == 6) {
                ((IjkMediaPlayerItemDecorate) ijkMediaPlayerItem).setRenderAfterPrepared(false);
            }
            HashMap reportMap = params.getExtraReportParams();
            if (reportMap == null) {
                reportMap = new HashMap();
            }
            reportMap.put(MediaItemParams.IJK_REPORT_KEY_MEDIA_SOURCE, mediaType == null ? "" : mediaType);
            PlayerLog.i(str, "trackMode: " + mode + " from：" + reportMap);
            ((IjkMediaPlayerItemDecorate) ijkMediaPlayerItem).init(asset, ijkMediaConfigParams);
            ((IjkMediaPlayerItemDecorate) ijkMediaPlayerItem).initIjkMediaPlayerTracker(mode, params.getTrackerId(), IjkOptionsHelper.getBuvid(), reportMap);
            P2PParams it = params.getP2pParams();
            if (it != null) {
                ((IjkMediaPlayerItemDecorate) ijkMediaPlayerItem).setP2pManuscriptInfo(IMediaItemTransformer.Companion.transformP2PParams(it));
            }
            Pair it2 = params.getRecommendStartQualityRange();
            if (it2 != null) {
                ((IjkMediaPlayerItemDecorate) ijkMediaPlayerItem).setRecommendedQn(true, ((Number) it2.getFirst()).intValue(), ((Number) it2.getSecond()).intValue());
            }
            ijkMediaConfigParams.mRenderAfterPrepare = params.getRenderAfterPrepare();
            Integer screenState = params.getScreenState();
            if (screenState != null) {
                ((IjkMediaPlayerItemDecorate) ijkMediaPlayerItem).setScreenState(screenState.intValue());
            }
            ArrayList enhanceList = resource.getEnhanceList();
            if (enhanceList != null && (enhanceList.isEmpty() ^ true)) {
                ArrayList enhanceList2 = resource.getEnhanceList();
                Intrinsics.checkNotNull(enhanceList2);
                ((IjkMediaPlayerItemDecorate) ijkMediaPlayerItem).setEnhanceQnList(CollectionsKt.toIntArray(enhanceList2));
            }
            if (resource.getDynamicQuality() != null) {
                IjkMediaItemTransformerKt.access$setDynamicQuality(ijkMediaPlayerItem, resource);
            }
            IjkMediaItem result = new IjkMediaItem(ijkMediaPlayerItem, listener);
            result.setId(params.getId());
            result.setAutoPlayWhenPrepare(ijkMediaConfigParams.mStartOnPrepared);
            return result;
        }
        return null;
    }

    private final void setVolumeInfo(IjkMediaConfigParams ijkMediaConfigParams, MediaItemParams params) {
        VolumeInfo volumeInfo;
        Map multiSceneArgs;
        ijkMediaConfigParams.mLoudnormType = IjkOptionsHelper.getVolumeBalanceType();
        BLog.i("volume Type:" + ijkMediaConfigParams.mLoudnormType);
        VolumeInfo volumeInfo2 = params.getVolumeInfo();
        Double valueOf = volumeInfo2 != null ? Double.valueOf(volumeInfo2.getMeasuredI()) : null;
        VolumeInfo volumeInfo3 = params.getVolumeInfo();
        Double valueOf2 = volumeInfo3 != null ? Double.valueOf(volumeInfo3.getMeasuredThreshold()) : null;
        VolumeInfo volumeInfo4 = params.getVolumeInfo();
        Double valueOf3 = volumeInfo4 != null ? Double.valueOf(volumeInfo4.getMeasuredLra()) : null;
        VolumeInfo volumeInfo5 = params.getVolumeInfo();
        Double valueOf4 = volumeInfo5 != null ? Double.valueOf(volumeInfo5.getMeasuredTp()) : null;
        VolumeInfo volumeInfo6 = params.getVolumeInfo();
        Double valueOf5 = volumeInfo6 != null ? Double.valueOf(volumeInfo6.getTargetI()) : null;
        VolumeInfo volumeInfo7 = params.getVolumeInfo();
        Double valueOf6 = volumeInfo7 != null ? Double.valueOf(volumeInfo7.getTargetOffset()) : null;
        VolumeInfo volumeInfo8 = params.getVolumeInfo();
        BLog.i("loudnorm params: measuredI=" + valueOf + ", measuredThreshold=" + valueOf2 + ",measuredLra=" + valueOf3 + ", measuredTp=" + valueOf4 + ",targetI=" + valueOf5 + ", targetOffset=" + valueOf6 + ",targetTp=" + (volumeInfo8 != null ? Double.valueOf(volumeInfo8.getTargetTp()) : null) + ",multiSceneArgs=" + (params.getVolumeInfo() != null ? volumeInfo.getMultiSceneArgs() : null));
        VolumeInfo $this$setVolumeInfo_u24lambda_u240 = params.getVolumeInfo();
        if ($this$setVolumeInfo_u24lambda_u240 != null) {
            if (isValidVolumeInfo($this$setVolumeInfo_u24lambda_u240.getMeasuredI())) {
                ijkMediaConfigParams.mMeasuredI = $this$setVolumeInfo_u24lambda_u240.getMeasuredI();
            }
            if (isValidVolumeInfo($this$setVolumeInfo_u24lambda_u240.getMeasuredThreshold())) {
                ijkMediaConfigParams.mMeasuredThreshold = $this$setVolumeInfo_u24lambda_u240.getMeasuredThreshold();
            }
            if (isValidVolumeInfo($this$setVolumeInfo_u24lambda_u240.getMeasuredLra())) {
                ijkMediaConfigParams.mMeasuredLRA = $this$setVolumeInfo_u24lambda_u240.getMeasuredLra();
            }
            if (isValidVolumeInfo($this$setVolumeInfo_u24lambda_u240.getMeasuredTp())) {
                ijkMediaConfigParams.mMeasuredTP = $this$setVolumeInfo_u24lambda_u240.getMeasuredTp();
            }
            if (isValidVolumeInfo($this$setVolumeInfo_u24lambda_u240.getTargetI())) {
                ijkMediaConfigParams.mTargetI = $this$setVolumeInfo_u24lambda_u240.getTargetI();
            }
            if (isValidVolumeInfo($this$setVolumeInfo_u24lambda_u240.getTargetOffset())) {
                ijkMediaConfigParams.mTargetOffset = $this$setVolumeInfo_u24lambda_u240.getTargetOffset();
            }
            if (isValidVolumeInfo($this$setVolumeInfo_u24lambda_u240.getTargetTp())) {
                ijkMediaConfigParams.mTargetTP = $this$setVolumeInfo_u24lambda_u240.getTargetTp();
            }
            boolean z = false;
            if ($this$setVolumeInfo_u24lambda_u240.getMultiSceneArgs() != null && (!multiSceneArgs.isEmpty())) {
                z = true;
            }
            if (z) {
                ijkMediaConfigParams.mMultiSceneArgs = $this$setVolumeInfo_u24lambda_u240.getMultiSceneArgs();
            }
        }
    }

    private final boolean isValidVolumeInfo(double param) {
        return Math.abs(param) > 1.0E-4d;
    }

    private final void initP2PConfig(IjkMediaConfigParams ijkMediaConfigParams, Application context) {
        if (IjkOptionsHelper.isInP2PWhiteList() && !IjkOptionsHelper.deviceDowngrade()) {
            ijkMediaConfigParams.mEnableP2PDownload = IjkOptionsHelper.isEnableP2P();
            IjkMediaItemTransformerKt.initP2P(context);
        }
    }

    private final int getIjkTrackMode(int scheme, String mediaType) {
        if (Intrinsics.areEqual(mediaType, "podcast")) {
            return 9;
        }
        if (scheme == 6) {
            if (IjkMediaItemTransformerKt.access$isWifiActive()) {
                return 5;
            }
            TfTypeExt typeExt = FreeDataManager.getInstance().getFreeDataCondition().getTypeExt();
            switch (typeExt != null ? WhenMappings.$EnumSwitchMapping$0[typeExt.ordinal()] : -1) {
                case 1:
                case 2:
                    return IjkMediaItem.BLIJKPlayMode_VOD_STORY_CM_FREE;
                case 3:
                case 4:
                    return IjkMediaItem.BLIJKPlayMode_VOD_STORY_UNICOM_FREE;
                case 5:
                case 6:
                    return IjkMediaItem.BLIJKPlayMode_VOD_STORY_TELCOM_FREE;
                default:
                    return 5;
            }
        } else if (scheme == 9) {
            if (IjkMediaItemTransformerKt.access$isWifiActive()) {
                return 8;
            }
            TfTypeExt typeExt2 = FreeDataManager.getInstance().getFreeDataCondition().getTypeExt();
            switch (typeExt2 != null ? WhenMappings.$EnumSwitchMapping$0[typeExt2.ordinal()] : -1) {
                case 1:
                case 2:
                    return 801;
                case 3:
                case 4:
                    return 802;
                case 5:
                case 6:
                    return IjkMediaItem.BLIJKPlayMode_VOD_LIVE_STORY_TELCOM_FREE;
                default:
                    return 8;
            }
        } else if (scheme == 5) {
            return 3;
        } else {
            if (scheme == 1) {
                return 2;
            }
            if (IjkMediaItemTransformerKt.access$isWifiActive()) {
                return 1;
            }
            TfTypeExt typeExt3 = FreeDataManager.getInstance().getFreeDataCondition().getTypeExt();
            switch (typeExt3 != null ? WhenMappings.$EnumSwitchMapping$0[typeExt3.ordinal()] : -1) {
                case 1:
                case 2:
                    return 101;
                case 3:
                case 4:
                    return 102;
                case 5:
                case 6:
                    return 103;
                default:
                    return 1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x00df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00db A[SYNTHETIC] */
    @Override // tv.danmaku.videoplayer.coreV2.transformer.IMediaItemTransformer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateMediaItem(MediaItem<?> mediaItem, MediaResource oldResource, MediaResource newResource) {
        IjkMediaPlayerItem ijkItem;
        List audioStreams;
        boolean z;
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        Intrinsics.checkNotNullParameter(oldResource, "oldResource");
        Intrinsics.checkNotNullParameter(newResource, "newResource");
        if ((mediaItem instanceof IjkMediaItem) && (ijkItem = ((IjkMediaItem) mediaItem).realMediaItem()) != null) {
            PlayIndex playIndex = oldResource.getPlayIndex();
            Long oldAttr = playIndex != null ? Long.valueOf(playIndex.attribute) : null;
            PlayIndex playIndex2 = newResource.getPlayIndex();
            Long newAttr = playIndex2 != null ? Long.valueOf(playIndex2.attribute) : null;
            PlayIndex playIndex3 = oldResource.getPlayIndex();
            Boolean oldNoRexcode = playIndex3 != null ? Boolean.valueOf(playIndex3.noRexcode) : null;
            PlayIndex playIndex4 = newResource.getPlayIndex();
            Boolean newNoRexcode = playIndex4 != null ? Boolean.valueOf(playIndex4.noRexcode) : null;
            if (!Intrinsics.areEqual(oldAttr, newAttr) || !Intrinsics.areEqual(oldNoRexcode, newNoRexcode)) {
                PlayerLog.e("IjkMediaItemTransformer", "can not update media item -> {" + oldAttr + ", " + oldNoRexcode + "}-{" + newAttr + ", " + newNoRexcode + "}");
                return;
            }
            ArrayList validStreams = new ArrayList();
            List<IjkMediaAsset.MediaAssetStream> videoStreams = newResource.getIjkVideoMediaStreams();
            if (videoStreams != null) {
                for (IjkMediaAsset.MediaAssetStream stream : videoStreams) {
                    DashResource dashResource = oldResource.getDashResource();
                    if (!(dashResource != null && dashResource.isValidVideoId(stream.getQualityId()))) {
                        validStreams.add(stream);
                    }
                }
            }
            List<IjkMediaAsset.MediaAssetStream> audioStreams2 = newResource.getIjkAudioStreams();
            if (audioStreams2 != null) {
                for (IjkMediaAsset.MediaAssetStream stream2 : audioStreams2) {
                    DashResource dashResource2 = oldResource.getDashResource();
                    if (dashResource2 != null) {
                        audioStreams = audioStreams2;
                        if (dashResource2.isValidAudioId(stream2.getQualityId())) {
                            z = true;
                            if (!z) {
                                audioStreams2 = audioStreams;
                            } else {
                                validStreams.add(stream2);
                                audioStreams2 = audioStreams;
                            }
                        }
                    } else {
                        audioStreams = audioStreams2;
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            ArrayList $this$toTypedArray$iv = validStreams;
            ijkItem.addMediaAssetStreamList((IjkMediaAsset.MediaAssetStream[]) $this$toTypedArray$iv.toArray(new IjkMediaAsset.MediaAssetStream[0]));
            ArrayList enhanceList = oldResource.getEnhanceList();
            Integer valueOf = enhanceList != null ? Integer.valueOf(enhanceList.size()) : null;
            ArrayList enhanceList2 = newResource.getEnhanceList();
            if (!Intrinsics.areEqual(valueOf, enhanceList2 != null ? Integer.valueOf(enhanceList2.size()) : null)) {
                ArrayList enhanceList3 = newResource.getEnhanceList();
                if (enhanceList3 != null && (enhanceList3.isEmpty() ^ true)) {
                    ArrayList enhanceList4 = newResource.getEnhanceList();
                    Intrinsics.checkNotNull(enhanceList4);
                    ijkItem.setEnhanceQnList(CollectionsKt.toIntArray(enhanceList4));
                }
            }
            if (newResource.getDynamicQuality() != null && oldResource.getDynamicQuality() == null) {
                IjkMediaItemTransformerKt.access$setDynamicQuality(ijkItem, newResource);
            }
        }
    }
}