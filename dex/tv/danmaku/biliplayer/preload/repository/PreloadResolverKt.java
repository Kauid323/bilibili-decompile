package tv.danmaku.biliplayer.preload.repository;

import android.app.Application;
import android.net.Uri;
import com.bilibili.base.BiliContext;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.media.resolver.exception.ResolveException;
import com.bilibili.lib.media.resolver.exception.ResolveHttpException;
import com.bilibili.lib.media.resolver.exception.ResolveJsonException;
import com.bilibili.lib.media.resolver.exception.ResolveMediaSourceException;
import com.bilibili.lib.media.resolver2.IInternationalizedParams;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resolver2.MediaResolveProviderV2;
import com.bilibili.lib.media.resolver2.interceptor.DefaultFlashMediaResourceResolveInterceptorV2;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.tf.TfTransformResp;
import com.bilibili.lib.tf.freedata.util.TfTransformKt;
import com.bilibili.playerbizcommon.IPlayerMultiLangStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.VideoBizType;
import tv.danmaku.videoplayer.coreV2.transformer.IjkMediaItemTransformer;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: PreloadResolver.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b\u001ad\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2&\b\u0002\u0010\u0012\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\u001e\b\u0002\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017H\u0000\u001a/\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 \u001a(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'\u001a0\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010)2\u0006\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0000\u001a\u0013\u0010*\u001a\u00020+*\u00020,H\u0000¢\u0006\u0004\b-\u0010.\u001a\u0006\u0010/\u001a\u00020\u001a\u001a\u0010\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u000102\u001a\u001a\u00103\u001a\u0004\u0018\u00010\t2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\t\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010¨\u00067"}, d2 = {"transformer", "Ltv/danmaku/videoplayer/coreV2/transformer/IjkMediaItemTransformer;", "getTransformer", "()Ltv/danmaku/videoplayer/coreV2/transformer/IjkMediaItemTransformer;", "transformer$delegate", "Lkotlin/Lazy;", "resolveMediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "flashJson", "", "resolverParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "resolveMediaResourceByPlayView", "playerMultiLangStore", "Lcom/bilibili/playerbizcommon/IPlayerMultiLangStore;", "getPlayerMultiLangStore", "()Lcom/bilibili/playerbizcommon/IPlayerMultiLangStore;", "playerMultiLangStore$delegate", "flashMediaResourceCreator", "Lkotlin/Function2;", "Ltv/danmaku/biliplayer/preload/repository/PreloadFlashResolver;", "paramsMediaResourceCreator", "Lkotlin/Function1;", "Ltv/danmaku/biliplayer/preload/repository/PreloadResolver;", "params", "isUseHttps", "", "codecType", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", IjkMediaMeta.IJKM_KEY_FORMAT, "", "resolveMediaResource-_OmDtSA", "(Lcom/bilibili/lib/media/resolver2/IResolveParams;ZII)Lcom/bilibili/lib/media/resource/MediaResource;", "preloadMediaItemParams", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams$Builder;", "resource", "reportData", "Ltv/danmaku/biliplayer/preload/repository/PreloadReportData;", "cacheTimeMs", "", "createMediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "toIjkPriority", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem$PlayerItemPriority;", "Ltv/danmaku/biliplayer/preload/repository/PreloadPriority;", "toIjkPriority-E-Jy1Qw", "(I)Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem$PlayerItemPriority;", "shouldProcessUrl", "supportDrmFreeData", "drmType", "Lcom/bilibili/lib/media/resource/PlayIndex$DrmType;", "processUrl", "resType", "Lcom/bilibili/fd_service/FreeDataManager$ResType;", "originUrl", "player-preload_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadResolverKt {
    private static final Lazy transformer$delegate = LazyKt.lazy(PreloadResolverKt$transformer$2.INSTANCE);
    private static final Lazy playerMultiLangStore$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayer.preload.repository.PreloadResolverKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IPlayerMultiLangStore playerMultiLangStore_delegate$lambda$0;
            playerMultiLangStore_delegate$lambda$0 = PreloadResolverKt.playerMultiLangStore_delegate$lambda$0();
            return playerMultiLangStore_delegate$lambda$0;
        }
    });

    /* compiled from: PreloadResolver.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<IjkMediaPlayerItem.PlayerItemPriority> entries$0 = EnumEntriesKt.enumEntries(IjkMediaPlayerItem.PlayerItemPriority.values());
    }

    public static final IjkMediaItemTransformer getTransformer() {
        return (IjkMediaItemTransformer) transformer$delegate.getValue();
    }

    public static final MediaResource resolveMediaResource(String flashJson, IResolveParams resolverParams) throws ResolveException, ResolveHttpException, ResolveMediaSourceException.ResolveInvalidCodeException, ResolveJsonException {
        MediaResource resource;
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        if (flashJson != null) {
            resource = DefaultFlashMediaResourceResolveInterceptorV2.Companion.resolve(flashJson, resolverParams.getFrom());
        } else {
            resource = null;
        }
        return resource == null ? resolveMediaResourceByPlayView(resolverParams) : resource;
    }

    public static final MediaResource resolveMediaResourceByPlayView(IResolveParams resolverParams) throws ResolveException, ResolveHttpException, ResolveMediaSourceException.ResolveInvalidCodeException {
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        return MediaResolveProviderV2.Companion.createResolverAndResolve(BiliContext.application(), resolverParams, true);
    }

    private static final IPlayerMultiLangStore getPlayerMultiLangStore() {
        return (IPlayerMultiLangStore) playerMultiLangStore$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlayerMultiLangStore playerMultiLangStore_delegate$lambda$0() {
        return (IPlayerMultiLangStore) BLRouter.INSTANCE.get(IPlayerMultiLangStore.class, "player_ai_translation_store");
    }

    public static /* synthetic */ MediaResource resolveMediaResource$default(String str, IResolveParams iResolveParams, Function2 function2, Function1 function1, int i, Object obj) throws ResolveException, ResolveHttpException, ResolveMediaSourceException.ResolveInvalidCodeException, ResolveJsonException {
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        return resolveMediaResource(str, iResolveParams, function2, function1);
    }

    public static final MediaResource resolveMediaResource(String flashJson, IResolveParams resolverParams, Function2<? super IResolveParams, ? super String, MediaResource> function2, Function1<? super IResolveParams, MediaResource> function1) throws ResolveException, ResolveHttpException, ResolveMediaSourceException.ResolveInvalidCodeException, ResolveJsonException {
        MediaResource resource;
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        MediaResource mediaResource = null;
        if (resolverParams instanceof IInternationalizedParams) {
            IInternationalizedParams iInternationalizedParams = (IInternationalizedParams) resolverParams;
            IPlayerMultiLangStore playerMultiLangStore = getPlayerMultiLangStore();
            iInternationalizedParams.setLanguage(playerMultiLangStore != null ? playerMultiLangStore.getPreferredLang() : null);
        }
        if (flashJson != null) {
            if (function2 != null) {
                mediaResource = (MediaResource) function2.invoke(resolverParams, flashJson);
            } else {
                mediaResource = DefaultFlashMediaResourceResolveInterceptorV2.Companion.resolve(flashJson, resolverParams.getFrom());
            }
        }
        MediaResource resource2 = mediaResource;
        if (resource2 == null) {
            if (function1 != null) {
                resource = (MediaResource) function1.invoke(resolverParams);
            } else {
                resource = resolveMediaResourceByPlayView(resolverParams);
            }
            return resource;
        }
        return resource2;
    }

    /* renamed from: resolveMediaResource-_OmDtSA  reason: not valid java name */
    public static final MediaResource m2161resolveMediaResource_OmDtSA(IResolveParams params, boolean isUseHttps, int i, int format) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (isUseHttps) {
            params.setDomainParams(2);
        }
        params.setFormat(format);
        params.setCodecType-N6j8eWo(i);
        try {
            return MediaResolveProviderV2.Companion.createResolverAndResolve(BiliContext.application(), params, false);
        } catch (Exception e) {
            BLog.w(PlayerItemCachePoolExtKt.PRELOAD_POOL_TAG, "player cache item update resolve failed, error message: " + e.getMessage());
            return null;
        }
    }

    public static final MediaItemParams.Builder preloadMediaItemParams(MediaResource resource, PreloadReportData reportData, IResolveParams resolverParams, long cacheTimeMs) {
        String value;
        VideoBizType reportBizType;
        String fromSpmid;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        MediaItemParams.Builder itemParams = new MediaItemParams.Builder();
        itemParams.setEnableHWCodex(true);
        itemParams.setHdr(resource.isHdr());
        itemParams.setHdrType(resource.getHdrType());
        itemParams.setDolbyVision(resource.isDolbyVision());
        itemParams.setForceStartAccurateSeek(resource.isForceStartAccurateSeek);
        itemParams.setVolumeInfo(resource.getVolumeInfo());
        itemParams.setVariableResolutionRatio(resource.getVariableResolutionRatio());
        itemParams.setStartWhenPrepared(false);
        itemParams.setCacheTime(cacheTimeMs);
        itemParams.setStartPosition(resource.startPosition);
        String str = "";
        itemParams.putReportParam("spmid", (reportData == null || (r5 = reportData.getSpmid()) == null) ? "" : "");
        if (reportData != null && (fromSpmid = reportData.getFromSpmid()) != null) {
            str = fromSpmid;
        }
        itemParams.putReportParam("from_spmid", str);
        if (reportData == null || (reportBizType = reportData.getReportBizType()) == null || (value = reportBizType.getValue()) == null) {
            value = VideoBizType.UNKNOWN.getValue();
        }
        itemParams.putReportParam(MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, value);
        itemParams.putReportParam(MediaItemParams.IJK_REPORT_KEY_FLASH, resource.sourceFrom() == 1 ? "yes" : "no");
        itemParams.setTrackerId(reportData != null ? reportData.getTrackerId() : 0L);
        itemParams.setAvid(reportData != null ? reportData.getAid() : 0L);
        itemParams.setP2pParams(reportData != null ? reportData.getP2pParams() : null);
        if (Intrinsics.areEqual(resolverParams.getFrom(), "live")) {
            itemParams.setEnableLiveSkipFrame(true);
        }
        return itemParams;
    }

    public static final MediaItem<?> createMediaItem(MediaResource resource, PreloadReportData reportData, IResolveParams resolverParams, long cacheTimeMs) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        MediaItemParams itemParams = preloadMediaItemParams(resource, reportData, resolverParams, cacheTimeMs).build();
        MediaItem item = getTransformer().createMediaItem(resource, itemParams, null);
        return item;
    }

    /* renamed from: toIjkPriority-E-Jy1Qw  reason: not valid java name */
    public static final IjkMediaPlayerItem.PlayerItemPriority m2162toIjkPriorityEJy1Qw(int i) {
        if (PreloadPriority.m2149equalsimpl0(i, PreloadPriority.Companion.m2154getDefault3gV422k())) {
            return IjkMediaPlayerItem.PlayerItemPriority.PRIORITY_7;
        }
        for (IjkMediaPlayerItem.PlayerItemPriority priority : EntriesMappings.entries$0) {
            if (priority.PriorityToValue() == i) {
                return priority;
            }
        }
        return IjkMediaPlayerItem.PlayerItemPriority.PRIORITY_7;
    }

    public static final boolean shouldProcessUrl() {
        return FreeDataManager.getInstance().isTf();
    }

    public static final boolean supportDrmFreeData(PlayIndex.DrmType drmType) {
        return false;
    }

    public static final String processUrl(FreeDataManager.ResType resType, String originUrl) {
        Intrinsics.checkNotNullParameter(resType, "resType");
        Application context = BiliContext.application();
        if (context == null) {
            return null;
        }
        TfTransformResp result = FreeDataManager.getInstance().processUrl(context, resType, originUrl);
        Intrinsics.checkNotNullExpressionValue(result, "processUrl(...)");
        if (TfTransformKt.isSuccessful(result)) {
            String url = result.getUrl();
            if (url == null || url.length() == 0) {
                return null;
            }
            return Uri.parse(result.getUrl()).buildUpon().appendQueryParameter("free_traffic", "1").build().toString();
        }
        return null;
    }
}