package tv.danmaku.biliplayerv2.utils;

import com.bilibili.lib.media.resource.MediaResource;
import j$.util.Map;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IStartStreamIdSelector;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: MediaItemBuilderExt.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"getMediaItemParamsBuilder", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams$Builder;", "container", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "playerCoreService", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "playerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "service", "applyPlayableParams", "playableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaItemBuilderExtKt {
    public static final MediaItemParams.Builder getMediaItemParamsBuilder(PlayerContainer container, MediaResource resource) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return getMediaItemParamsBuilder(container.getPlayerCoreService(), container.getPlayerParams(), resource);
    }

    public static final MediaItemParams.Builder getMediaItemParamsBuilder(IPlayerCoreService playerCoreService, PlayerParamsV2 playerParams, MediaResource resource) {
        Intrinsics.checkNotNullParameter(playerCoreService, "playerCoreService");
        Intrinsics.checkNotNullParameter(playerParams, "playerParams");
        Intrinsics.checkNotNullParameter(resource, "resource");
        MediaItemParams.Builder $this$getMediaItemParamsBuilder_u24lambda_u240 = new MediaItemParams.Builder();
        $this$getMediaItemParamsBuilder_u24lambda_u240.setEnableHWCodex(true);
        $this$getMediaItemParamsBuilder_u24lambda_u240.setNeuronSession(String.valueOf(playerCoreService.hashCode()));
        IStartStreamIdSelector startStreamIdSelector = playerCoreService.getStartStreamIdSelector();
        $this$getMediaItemParamsBuilder_u24lambda_u240.setVideoStreamId(startStreamIdSelector != null ? startStreamIdSelector.onGetVideoStreamId(resource) : -1);
        IStartStreamIdSelector startStreamIdSelector2 = playerCoreService.getStartStreamIdSelector();
        $this$getMediaItemParamsBuilder_u24lambda_u240.setAudioStreamId(startStreamIdSelector2 != null ? startStreamIdSelector2.onGetAudioStreamId(resource) : -1);
        $this$getMediaItemParamsBuilder_u24lambda_u240.setHdr(resource.isHdr());
        $this$getMediaItemParamsBuilder_u24lambda_u240.setHdrType(resource.getHdrType());
        $this$getMediaItemParamsBuilder_u24lambda_u240.setDolbyVision(resource.isDolbyVision());
        $this$getMediaItemParamsBuilder_u24lambda_u240.setForceStartAccurateSeek(resource.isForceStartAccurateSeek);
        $this$getMediaItemParamsBuilder_u24lambda_u240.setVolumeInfo(resource.getVolumeInfo());
        $this$getMediaItemParamsBuilder_u24lambda_u240.setVariableResolutionRatio(resource.getVariableResolutionRatio());
        $this$getMediaItemParamsBuilder_u24lambda_u240.setIjkAudioStreamType(playerParams.getConfig().getIjkAudioStreamType());
        $this$getMediaItemParamsBuilder_u24lambda_u240.putReportParam(MediaItemParams.IJK_REPORT_KEY_FLASH, resource.sourceFrom() == 1 ? "yes" : "no");
        return $this$getMediaItemParamsBuilder_u24lambda_u240;
    }

    public static final MediaItemParams.Builder getMediaItemParamsBuilder(IPlayerCoreService service, MediaResource resource) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(resource, "resource");
        MediaItemParams.Builder $this$getMediaItemParamsBuilder_u24lambda_u241 = new MediaItemParams.Builder();
        $this$getMediaItemParamsBuilder_u24lambda_u241.setEnableHWCodex(true);
        $this$getMediaItemParamsBuilder_u24lambda_u241.setNeuronSession(String.valueOf(service.hashCode()));
        IStartStreamIdSelector startStreamIdSelector = service.getStartStreamIdSelector();
        $this$getMediaItemParamsBuilder_u24lambda_u241.setVideoStreamId(startStreamIdSelector != null ? startStreamIdSelector.onGetVideoStreamId(resource) : -1);
        IStartStreamIdSelector startStreamIdSelector2 = service.getStartStreamIdSelector();
        $this$getMediaItemParamsBuilder_u24lambda_u241.setAudioStreamId(startStreamIdSelector2 != null ? startStreamIdSelector2.onGetAudioStreamId(resource) : -1);
        $this$getMediaItemParamsBuilder_u24lambda_u241.setHdr(resource.isHdr());
        $this$getMediaItemParamsBuilder_u24lambda_u241.setHdrType(resource.getHdrType());
        $this$getMediaItemParamsBuilder_u24lambda_u241.setDolbyVision(resource.isDolbyVision());
        $this$getMediaItemParamsBuilder_u24lambda_u241.setVolumeInfo(resource.getVolumeInfo());
        $this$getMediaItemParamsBuilder_u24lambda_u241.setVariableResolutionRatio(resource.getVariableResolutionRatio());
        $this$getMediaItemParamsBuilder_u24lambda_u241.setForceStartAccurateSeek(resource.isForceStartAccurateSeek);
        $this$getMediaItemParamsBuilder_u24lambda_u241.putReportParam(MediaItemParams.IJK_REPORT_KEY_FLASH, resource.sourceFrom() == 1 ? "yes" : "no");
        return $this$getMediaItemParamsBuilder_u24lambda_u241;
    }

    public static final MediaItemParams.Builder getMediaItemParamsBuilder(MediaResource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        MediaItemParams.Builder $this$getMediaItemParamsBuilder_u24lambda_u242 = new MediaItemParams.Builder();
        $this$getMediaItemParamsBuilder_u24lambda_u242.setEnableHWCodex(true);
        $this$getMediaItemParamsBuilder_u24lambda_u242.setHdr(resource.isHdr());
        $this$getMediaItemParamsBuilder_u24lambda_u242.setHdrType(resource.getHdrType());
        $this$getMediaItemParamsBuilder_u24lambda_u242.setDolbyVision(resource.isDolbyVision());
        $this$getMediaItemParamsBuilder_u24lambda_u242.setVolumeInfo(resource.getVolumeInfo());
        $this$getMediaItemParamsBuilder_u24lambda_u242.setVariableResolutionRatio(resource.getVariableResolutionRatio());
        $this$getMediaItemParamsBuilder_u24lambda_u242.setForceStartAccurateSeek(resource.isForceStartAccurateSeek);
        $this$getMediaItemParamsBuilder_u24lambda_u242.putReportParam(MediaItemParams.IJK_REPORT_KEY_FLASH, resource.sourceFrom() == 1 ? "yes" : "no");
        return $this$getMediaItemParamsBuilder_u24lambda_u242;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MediaItemParams.Builder applyPlayableParams(MediaItemParams.Builder $this$applyPlayableParams, Video.PlayableParams playableParams) {
        long roomId;
        String spmid;
        String from;
        Map<String, String> legacyExtra;
        Intrinsics.checkNotNullParameter($this$applyPlayableParams, "<this>");
        if (playableParams != null) {
            $this$applyPlayableParams.setId(playableParams.id());
            String from2 = playableParams.getFrom();
            boolean z = true;
            if (!(from2 != null && from2.equals("live"))) {
                Video.ReportCommonParams reportCommonParams = playableParams.getReportCommonParams();
                if (reportCommonParams != null) {
                    roomId = reportCommonParams.getCid();
                    $this$applyPlayableParams.setTrackerId(roomId);
                    Video.ReportCommonParams reportCommonParams2 = playableParams.getReportCommonParams();
                    $this$applyPlayableParams.setAvid(reportCommonParams2 != null ? reportCommonParams2.getAvid() : 0L);
                    $this$applyPlayableParams.setP2pParams(playableParams.getP2PParams());
                    spmid = playableParams.getSpmid();
                    if (spmid == null) {
                        spmid = "";
                    }
                    $this$applyPlayableParams.putReportParam("spmid", spmid);
                    String fromSpmid = playableParams.getFromSpmid();
                    $this$applyPlayableParams.putReportParam("from_spmid", fromSpmid != null ? fromSpmid : "");
                    $this$applyPlayableParams.putReportParam(MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, playableParams.getBizType().getValue());
                    from = playableParams.getFrom();
                    if (from != null || !from.equals("live")) {
                        z = false;
                    }
                    if (z) {
                        Video.ReportCommonParams reportCommonParams3 = playableParams.getReportCommonParams();
                        $this$applyPlayableParams.putReportParam(MediaItemParams.IJK_REPORT_KEY_LIVE_SCENE, String.valueOf((reportCommonParams3 == null || (legacyExtra = reportCommonParams3.getLegacyExtra()) == null) ? null : Map.-EL.getOrDefault(legacyExtra, MediaItemParams.IJK_REPORT_KEY_LIVE_SCENE, 0)));
                    }
                }
                roomId = 0;
                $this$applyPlayableParams.setTrackerId(roomId);
                Video.ReportCommonParams reportCommonParams22 = playableParams.getReportCommonParams();
                $this$applyPlayableParams.setAvid(reportCommonParams22 != null ? reportCommonParams22.getAvid() : 0L);
                $this$applyPlayableParams.setP2pParams(playableParams.getP2PParams());
                spmid = playableParams.getSpmid();
                if (spmid == null) {
                }
                $this$applyPlayableParams.putReportParam("spmid", spmid);
                String fromSpmid2 = playableParams.getFromSpmid();
                $this$applyPlayableParams.putReportParam("from_spmid", fromSpmid2 != null ? fromSpmid2 : "");
                $this$applyPlayableParams.putReportParam(MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, playableParams.getBizType().getValue());
                from = playableParams.getFrom();
                if (from != null) {
                }
                z = false;
                if (z) {
                }
            } else {
                Video.ReportCommonParams reportCommonParams4 = playableParams.getReportCommonParams();
                if (reportCommonParams4 != null) {
                    roomId = reportCommonParams4.getRoomId();
                    $this$applyPlayableParams.setTrackerId(roomId);
                    Video.ReportCommonParams reportCommonParams222 = playableParams.getReportCommonParams();
                    $this$applyPlayableParams.setAvid(reportCommonParams222 != null ? reportCommonParams222.getAvid() : 0L);
                    $this$applyPlayableParams.setP2pParams(playableParams.getP2PParams());
                    spmid = playableParams.getSpmid();
                    if (spmid == null) {
                    }
                    $this$applyPlayableParams.putReportParam("spmid", spmid);
                    String fromSpmid22 = playableParams.getFromSpmid();
                    $this$applyPlayableParams.putReportParam("from_spmid", fromSpmid22 != null ? fromSpmid22 : "");
                    $this$applyPlayableParams.putReportParam(MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, playableParams.getBizType().getValue());
                    from = playableParams.getFrom();
                    if (from != null) {
                    }
                    z = false;
                    if (z) {
                    }
                }
                roomId = 0;
                $this$applyPlayableParams.setTrackerId(roomId);
                Video.ReportCommonParams reportCommonParams2222 = playableParams.getReportCommonParams();
                $this$applyPlayableParams.setAvid(reportCommonParams2222 != null ? reportCommonParams2222.getAvid() : 0L);
                $this$applyPlayableParams.setP2pParams(playableParams.getP2PParams());
                spmid = playableParams.getSpmid();
                if (spmid == null) {
                }
                $this$applyPlayableParams.putReportParam("spmid", spmid);
                String fromSpmid222 = playableParams.getFromSpmid();
                $this$applyPlayableParams.putReportParam("from_spmid", fromSpmid222 != null ? fromSpmid222 : "");
                $this$applyPlayableParams.putReportParam(MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, playableParams.getBizType().getValue());
                from = playableParams.getFrom();
                if (from != null) {
                }
                z = false;
                if (z) {
                }
            }
        }
        return $this$applyPlayableParams;
    }
}