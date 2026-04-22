package tv.danmaku.biliplayer.preload.repository;

import android.text.TextUtils;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.media.resolver2.BiliCodec;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;
import tv.danmaku.videoplayer.core.media.ijk.IjkMediaPlayerTrackerHelp;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.OnItemUpdateListener;

/* compiled from: CacheElement.kt */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\b\u0004*\u0001\\\b\u0000\u0018\u0000 ^2\u00020\u0001:\u0001^B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0007\u0010\u0011J\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020UJ\u000e\u0010W\u001a\u00020UH\u0086@¢\u0006\u0002\u0010XJ\u000e\u0010Y\u001a\u00020U2\u0006\u0010C\u001a\u00020\u0010J\b\u0010Z\u001a\u00020UH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R,\u00104\u001a \u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u000105j\u0004\u0018\u0001`6X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00107\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u000108j\u0004\u0018\u0001`9X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010:\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\f\u0018\u000108j\u0004\u0018\u0001`;X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR \u0010I\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0010\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0004\n\u0002\u0010]¨\u0006_"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/CacheElement;", "", "id", "", "identity", "action", "Ltv/danmaku/biliplayer/preload/repository/PreloadAction;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/biliplayer/preload/repository/PreloadAction;)V", "resolverParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "item", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "reusable", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/bilibili/lib/media/resolver2/IResolveParams;Ltv/danmaku/videoplayer/coreV2/MediaItem;Lcom/bilibili/lib/media/resource/MediaResource;Z)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getIdentity", "setIdentity", "getResolverParams", "()Lcom/bilibili/lib/media/resolver2/IResolveParams;", "setResolverParams", "(Lcom/bilibili/lib/media/resolver2/IResolveParams;)V", "flashJson", "startPosition", "", "getStartPosition", "()I", "setStartPosition", "(I)V", "reportData", "Ltv/danmaku/biliplayer/preload/repository/PreloadReportData;", "getReportData", "()Ltv/danmaku/biliplayer/preload/repository/PreloadReportData;", "setReportData", "(Ltv/danmaku/biliplayer/preload/repository/PreloadReportData;)V", "priority", "Ltv/danmaku/biliplayer/preload/repository/PreloadPriority;", "getPriority-3gV422k", "setPriority-E-Jy1Qw", "I", "cacheTimeMs", "", "getReusable", "()Z", "setReusable", "(Z)V", "flashMediaResourceCreator", "Lkotlin/Function2;", "Ltv/danmaku/biliplayer/preload/repository/PreloadFlashResolver;", "paramsMediaResourceCreator", "Lkotlin/Function1;", "Ltv/danmaku/biliplayer/preload/repository/PreloadResolver;", "mediaItemCreator", "Ltv/danmaku/biliplayer/preload/repository/PreloadMediaItemCreator;", "streamNetworkFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ltv/danmaku/biliplayer/preload/repository/PreloadStreamNetwork;", "getStreamNetworkFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "setStreamNetworkFlow", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "suppress", "mediaResource", "getMediaResource", "()Lcom/bilibili/lib/media/resource/MediaResource;", "setMediaResource", "(Lcom/bilibili/lib/media/resource/MediaResource;)V", "mediaItem", "getMediaItem", "()Ltv/danmaku/videoplayer/coreV2/MediaItem;", "setMediaItem", "(Ltv/danmaku/videoplayer/coreV2/MediaItem;)V", "cacheJob", "Lkotlinx/coroutines/Job;", "getCacheJob", "()Lkotlinx/coroutines/Job;", "setCacheJob", "(Lkotlinx/coroutines/Job;)V", "start", "", "release", "syncBufferInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncSuppress", "attachItem", "mOnItemUpdateListener", "tv/danmaku/biliplayer/preload/repository/CacheElement$mOnItemUpdateListener$1", "Ltv/danmaku/biliplayer/preload/repository/CacheElement$mOnItemUpdateListener$1;", "Companion", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CacheElement {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PlayerPreloadElement";
    private Job cacheJob;
    private long cacheTimeMs;
    private String flashJson;
    private Function2<? super IResolveParams, ? super String, MediaResource> flashMediaResourceCreator;
    public String id;
    public String identity;
    private final CacheElement$mOnItemUpdateListener$1 mOnItemUpdateListener;
    private MediaItem<?> mediaItem;
    private Function1<? super MediaResource, ? extends MediaItem<?>> mediaItemCreator;
    private MediaResource mediaResource;
    private Function1<? super IResolveParams, MediaResource> paramsMediaResourceCreator;
    private int priority;
    private PreloadReportData reportData;
    public IResolveParams resolverParams;
    private boolean reusable;
    private int startPosition;
    private MutableSharedFlow<PreloadStreamNetwork> streamNetworkFlow;
    private boolean suppress;

    public final String getId() {
        String str = this.id;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("id");
        return null;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getIdentity() {
        String str = this.identity;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("identity");
        return null;
    }

    public final void setIdentity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identity = str;
    }

    public final IResolveParams getResolverParams() {
        IResolveParams iResolveParams = this.resolverParams;
        if (iResolveParams != null) {
            return iResolveParams;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resolverParams");
        return null;
    }

    public final void setResolverParams(IResolveParams iResolveParams) {
        Intrinsics.checkNotNullParameter(iResolveParams, "<set-?>");
        this.resolverParams = iResolveParams;
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final void setStartPosition(int i) {
        this.startPosition = i;
    }

    public final PreloadReportData getReportData() {
        return this.reportData;
    }

    public final void setReportData(PreloadReportData preloadReportData) {
        this.reportData = preloadReportData;
    }

    /* renamed from: getPriority-3gV422k  reason: not valid java name */
    public final int m2139getPriority3gV422k() {
        return this.priority;
    }

    /* renamed from: setPriority-E-Jy1Qw  reason: not valid java name */
    public final void m2140setPriorityEJy1Qw(int i) {
        this.priority = i;
    }

    public final boolean getReusable() {
        return this.reusable;
    }

    public final void setReusable(boolean z) {
        this.reusable = z;
    }

    public final MutableSharedFlow<PreloadStreamNetwork> getStreamNetworkFlow() {
        return this.streamNetworkFlow;
    }

    public final void setStreamNetworkFlow(MutableSharedFlow<PreloadStreamNetwork> mutableSharedFlow) {
        this.streamNetworkFlow = mutableSharedFlow;
    }

    public final MediaResource getMediaResource() {
        return this.mediaResource;
    }

    public final void setMediaResource(MediaResource mediaResource) {
        this.mediaResource = mediaResource;
    }

    public final MediaItem<?> getMediaItem() {
        return this.mediaItem;
    }

    public final void setMediaItem(MediaItem<?> mediaItem) {
        this.mediaItem = mediaItem;
    }

    public final Job getCacheJob() {
        return this.cacheJob;
    }

    public final void setCacheJob(Job job) {
        this.cacheJob = job;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [tv.danmaku.biliplayer.preload.repository.CacheElement$mOnItemUpdateListener$1] */
    public CacheElement(String id, String identity, PreloadAction action) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(action, "action");
        this.priority = PreloadPriority.Companion.m2154getDefault3gV422k();
        this.cacheTimeMs = 500L;
        this.mOnItemUpdateListener = new OnItemUpdateListener() { // from class: tv.danmaku.biliplayer.preload.repository.CacheElement$mOnItemUpdateListener$1
            @Override // tv.danmaku.videoplayer.coreV2.OnItemUpdateListener
            public Object onItemUpdate(int reason, IjkNetworkUtils.NetWorkType type, int codecType, int format) {
                MutableSharedFlow<PreloadStreamNetwork> streamNetworkFlow;
                BLog.i("PlayerPreloadElement", "onAssetUpdate called, reason: " + reason + ", codecType: " + codecType + ", format: " + format + " type:" + type);
                if (reason == 0) {
                    return null;
                }
                switch (reason) {
                    case 2:
                    case 3:
                        if (type == IjkNetworkUtils.NetWorkType.NONE) {
                            return null;
                        }
                        break;
                }
                boolean useHttps = reason == 4;
                MediaResource currentResource = PreloadResolverKt.m2161resolveMediaResource_OmDtSA(CacheElement.this.getResolverParams(), useHttps, BiliCodec.Companion.invoke-RukcXV4(codecType), format);
                if (reason == 2 && type == IjkNetworkUtils.NetWorkType.WIFI && (streamNetworkFlow = CacheElement.this.getStreamNetworkFlow()) != null) {
                    streamNetworkFlow.tryEmit(new PreloadStreamNetwork(IjkNetworkUtils.NetWorkType.WIFI, CacheElement.this.getIdentity(), CacheElement.this.getResolverParams().getId(), null, 8, null));
                }
                if (currentResource == null) {
                    return null;
                }
                CacheElement.this.setMediaResource(currentResource);
                return currentResource.translateToIjkMediaAsset();
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
                if (tv.danmaku.biliplayer.preload.repository.PreloadResolverKt.supportDrmFreeData(r2 != null ? r2.getDrmType() : null) != false) goto L20;
             */
            @Override // tv.danmaku.videoplayer.coreV2.OnItemUpdateListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public String onMeteredNetworkUrlHook(String url, IjkNetworkUtils.NetWorkType type) {
                Intrinsics.checkNotNullParameter(url, "url");
                if (type == null) {
                    BLog.w("PlayerPreloadElement", "onMeteredNetworkUrlHook network type is null!");
                    return url;
                }
                String processedUrl = url;
                if (PreloadResolverKt.shouldProcessUrl()) {
                    MediaResource mediaResource = CacheElement.this.getMediaResource();
                    boolean z = false;
                    if (mediaResource != null && mediaResource.isDrm()) {
                        z = true;
                    }
                    if (z) {
                        MediaResource mediaResource2 = CacheElement.this.getMediaResource();
                    }
                    processedUrl = PreloadResolverKt.processUrl(FreeDataManager.ResType.RES_VIDEO, url);
                    if (TextUtils.isEmpty(processedUrl)) {
                        processedUrl = url;
                    }
                }
                MutableSharedFlow<PreloadStreamNetwork> streamNetworkFlow = CacheElement.this.getStreamNetworkFlow();
                if (streamNetworkFlow != null) {
                    streamNetworkFlow.tryEmit(new PreloadStreamNetwork(type, CacheElement.this.getIdentity(), CacheElement.this.getResolverParams().getId(), processedUrl));
                }
                BLog.i("PlayerPreloadElement", "onMeteredNetworkUrlHook called, url: " + url + ",processed url:" + processedUrl + ",network:" + type);
                return processedUrl;
            }
        };
        setId(id);
        setIdentity(identity);
        setResolverParams(action.getResolverParams());
        this.flashJson = action.getFlashJson();
        this.startPosition = action.getStartPosition();
        this.reportData = action.getReportData();
        this.priority = action.m2144getPriority3gV422k();
        this.cacheTimeMs = action.getCacheTimeMs();
        this.reusable = action.getReusable();
        this.flashMediaResourceCreator = action.getFlashMediaResourceCreator();
        this.paramsMediaResourceCreator = action.getParamsMediaResourceCreator();
        this.mediaItemCreator = action.getMediaItemCreator();
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [tv.danmaku.biliplayer.preload.repository.CacheElement$mOnItemUpdateListener$1] */
    public CacheElement(String id, String identity, IResolveParams resolverParams, MediaItem<?> mediaItem, MediaResource resource, boolean reusable) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        Intrinsics.checkNotNullParameter(mediaItem, "item");
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.priority = PreloadPriority.Companion.m2154getDefault3gV422k();
        this.cacheTimeMs = 500L;
        this.mOnItemUpdateListener = new OnItemUpdateListener() { // from class: tv.danmaku.biliplayer.preload.repository.CacheElement$mOnItemUpdateListener$1
            @Override // tv.danmaku.videoplayer.coreV2.OnItemUpdateListener
            public Object onItemUpdate(int reason, IjkNetworkUtils.NetWorkType type, int codecType, int format) {
                MutableSharedFlow<PreloadStreamNetwork> streamNetworkFlow;
                BLog.i("PlayerPreloadElement", "onAssetUpdate called, reason: " + reason + ", codecType: " + codecType + ", format: " + format + " type:" + type);
                if (reason == 0) {
                    return null;
                }
                switch (reason) {
                    case 2:
                    case 3:
                        if (type == IjkNetworkUtils.NetWorkType.NONE) {
                            return null;
                        }
                        break;
                }
                boolean useHttps = reason == 4;
                MediaResource currentResource = PreloadResolverKt.m2161resolveMediaResource_OmDtSA(CacheElement.this.getResolverParams(), useHttps, BiliCodec.Companion.invoke-RukcXV4(codecType), format);
                if (reason == 2 && type == IjkNetworkUtils.NetWorkType.WIFI && (streamNetworkFlow = CacheElement.this.getStreamNetworkFlow()) != null) {
                    streamNetworkFlow.tryEmit(new PreloadStreamNetwork(IjkNetworkUtils.NetWorkType.WIFI, CacheElement.this.getIdentity(), CacheElement.this.getResolverParams().getId(), null, 8, null));
                }
                if (currentResource == null) {
                    return null;
                }
                CacheElement.this.setMediaResource(currentResource);
                return currentResource.translateToIjkMediaAsset();
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
                if (tv.danmaku.biliplayer.preload.repository.PreloadResolverKt.supportDrmFreeData(r2 != null ? r2.getDrmType() : null) != false) goto L20;
             */
            @Override // tv.danmaku.videoplayer.coreV2.OnItemUpdateListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public String onMeteredNetworkUrlHook(String url, IjkNetworkUtils.NetWorkType type) {
                Intrinsics.checkNotNullParameter(url, "url");
                if (type == null) {
                    BLog.w("PlayerPreloadElement", "onMeteredNetworkUrlHook network type is null!");
                    return url;
                }
                String processedUrl = url;
                if (PreloadResolverKt.shouldProcessUrl()) {
                    MediaResource mediaResource = CacheElement.this.getMediaResource();
                    boolean z = false;
                    if (mediaResource != null && mediaResource.isDrm()) {
                        z = true;
                    }
                    if (z) {
                        MediaResource mediaResource2 = CacheElement.this.getMediaResource();
                    }
                    processedUrl = PreloadResolverKt.processUrl(FreeDataManager.ResType.RES_VIDEO, url);
                    if (TextUtils.isEmpty(processedUrl)) {
                        processedUrl = url;
                    }
                }
                MutableSharedFlow<PreloadStreamNetwork> streamNetworkFlow = CacheElement.this.getStreamNetworkFlow();
                if (streamNetworkFlow != null) {
                    streamNetworkFlow.tryEmit(new PreloadStreamNetwork(type, CacheElement.this.getIdentity(), CacheElement.this.getResolverParams().getId(), processedUrl));
                }
                BLog.i("PlayerPreloadElement", "onMeteredNetworkUrlHook called, url: " + url + ",processed url:" + processedUrl + ",network:" + type);
                return processedUrl;
            }
        };
        setId(id);
        setIdentity(identity);
        setResolverParams(resolverParams);
        this.mediaItem = mediaItem;
        this.mediaResource = resource;
        this.reusable = reusable;
        attachItem();
    }

    public final void start() {
        if (this.mediaResource != null || this.mediaItem != null || this.cacheJob != null) {
            boolean z = this.mediaResource != null;
            BLog.i(TAG, "cache start error, " + z + " " + (this.mediaItem != null) + " " + (this.cacheJob != null));
            return;
        }
        this.cacheJob = BuildersKt.launch$default(VideoCacheScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new CacheElement$start$1(this, null), 3, (Object) null);
    }

    public final void release() {
        Job job = this.cacheJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (!z && this.mediaItem == null) {
            return;
        }
        BuildersKt.launch$default(VideoCacheScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new CacheElement$release$1(this, null), 3, (Object) null);
    }

    public final Object syncBufferInfo(Continuation<? super Unit> continuation) {
        MediaItem<?> mediaItem;
        IjkMediaPlayerItem.PlayerItemPriority ijkPriority = PreloadResolverKt.m2162toIjkPriorityEJy1Qw(this.priority);
        if (this.mediaItem != null) {
            IjkMediaPlayerItem.PlayerItemPriority m2162toIjkPriorityEJy1Qw = PreloadResolverKt.m2162toIjkPriorityEJy1Qw(this.priority);
            MediaItem<?> mediaItem2 = this.mediaItem;
            if (m2162toIjkPriorityEJy1Qw != (mediaItem2 != null ? mediaItem2.getPriority() : null) && (mediaItem = this.mediaItem) != null) {
                mediaItem.setIdleBufferInfo(ijkPriority);
            }
        }
        return Unit.INSTANCE;
    }

    public final void syncSuppress(boolean suppress) {
        if (this.suppress == suppress) {
            return;
        }
        this.suppress = suppress;
        IjkMediaPlayerItem.PlayerItemPriority itemPriority = PreloadResolverKt.m2162toIjkPriorityEJy1Qw(!suppress ? this.priority : PreloadPriority.Companion.m2154getDefault3gV422k());
        if (this.mediaItem != null) {
            MediaItem<?> mediaItem = this.mediaItem;
            if (itemPriority != (mediaItem != null ? mediaItem.getPriority() : null)) {
                BuildersKt.launch$default(VideoCacheScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new CacheElement$syncSuppress$1(this, itemPriority, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attachItem() {
        MediaItem<?> mediaItem = this.mediaItem;
        if (mediaItem != null) {
            mediaItem.setKeepAliveRemoveFromPlayer(this.reusable);
        }
        MediaItem<?> mediaItem2 = this.mediaItem;
        if (mediaItem2 != null) {
            mediaItem2.setItemUpdateListener(this.mOnItemUpdateListener);
        }
        MediaItem<?> mediaItem3 = this.mediaItem;
        if (mediaItem3 != null) {
            mediaItem3.setItemTrackerListener(IjkMediaPlayerTrackerHelp.getInstance());
        }
    }

    /* compiled from: CacheElement.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/CacheElement$Companion;", "", "<init>", "()V", "TAG", "", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}