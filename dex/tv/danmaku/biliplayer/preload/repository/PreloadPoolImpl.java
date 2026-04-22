package tv.danmaku.biliplayer.preload.repository;

import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.player.preload.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.MediaItem;

/* compiled from: PreloadPoolImpl.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000 92\u00020\u0001:\u000289B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u001fH\u0016J(\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0016H\u0002J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0018\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020.H\u0002J\u000e\u00104\u001a\u0004\u0018\u00010\u0013*\u00020\u0016H\u0002J\u000e\u00104\u001a\u0004\u0018\u00010\u0013*\u00020\u001dH\u0002J\u0012\u00105\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0002J\u000e\u00106\u001a\u0004\u0018\u00010\u001f*\u00020\rH\u0002J\b\u00107\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadPoolImpl;", "Ltv/danmaku/biliplayer/preload/repository/PreloadPool;", "<init>", "()V", "_preloadNetworkFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ltv/danmaku/biliplayer/preload/repository/PreloadStreamNetwork;", "preloadStreamNetworkFlow", "Lkotlinx/coroutines/flow/Flow;", "getPreloadStreamNetworkFlow", "()Lkotlinx/coroutines/flow/Flow;", "preloadList", "Ljava/util/LinkedList;", "Ltv/danmaku/biliplayer/preload/repository/CacheElement;", "sceneInfo", "Ltv/danmaku/biliplayer/preload/repository/PreloadPoolImpl$LimitFiFoList;", "setPreloadActions", "", "sceneIdentity", "", "actions", "", "Ltv/danmaku/biliplayer/preload/repository/PreloadAction;", "addPreloadAction", "action", "release", "releaseAll", "releasePreload", "resolverParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "getPlayerItemCache", "Ltv/danmaku/biliplayer/preload/repository/PreloadOutcome;", "params", "timeOutMs", "", "(Lcom/bilibili/lib/media/resolver2/IResolveParams;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBackPlayerItemCache", "outcome", "reusableWhenIdMatching", "", "oldScene", "newScene", "old", "new", "clearExceededBeforeAdd", "newElementsSize", "", "newSceneIdentity", "resetIdleBufferBeforeAdd", "releaseFromScene", LoginSceneProcessor.SCENE_KEY, "limitSize", "cacheId", "clearSceneAfterRemove", "toPreloadOutcomeIfInvalidRelease", "printPreloads", "LimitFiFoList", "Companion", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadPoolImpl implements PreloadPool {
    private static final int ACTIVITY_SCENE_MAX_SIZE = 5;
    private static final int NEXT_SCENE_MAX_SIZE = 2;
    private static final int OTHER_SCENE_MAX_SIZE = 0;
    private static final int PRELOAD_LIMIT_SCENE = 3;
    private static final int PRELOAD_MAX_SIZE = 7;
    private static final String TAG = "PlayerPreload";
    private final MutableSharedFlow<PreloadStreamNetwork> _preloadNetworkFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    private final LinkedList<CacheElement> preloadList = new LinkedList<>();
    private final LimitFiFoList sceneInfo = new LimitFiFoList();
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Boolean> hitPreloadReuse$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean hitPreloadReuse_delegate$lambda$0;
            hitPreloadReuse_delegate$lambda$0 = PreloadPoolImpl.hitPreloadReuse_delegate$lambda$0();
            return Boolean.valueOf(hitPreloadReuse_delegate$lambda$0);
        }
    });

    @Override // tv.danmaku.biliplayer.preload.repository.PreloadPool
    public Flow<PreloadStreamNetwork> getPreloadStreamNetworkFlow() {
        return this._preloadNetworkFlow;
    }

    @Override // tv.danmaku.biliplayer.preload.repository.PreloadPool
    public void setPreloadActions(String sceneIdentity, List<PreloadAction> list) {
        Intrinsics.checkNotNullParameter(sceneIdentity, "sceneIdentity");
        Intrinsics.checkNotNullParameter(list, "actions");
        if (sceneIdentity.length() == 0) {
            BLog.e(TAG, "sceneIdentity is null, cannot preload");
        } else {
            BuildersKt.launch$default(CacheManagerScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new PreloadPoolImpl$setPreloadActions$1(this, list, sceneIdentity, null), 3, (Object) null);
        }
    }

    @Override // tv.danmaku.biliplayer.preload.repository.PreloadPool
    public void addPreloadAction(String sceneIdentity, PreloadAction action) {
        Intrinsics.checkNotNullParameter(sceneIdentity, "sceneIdentity");
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z = true;
        if (sceneIdentity.length() == 0) {
            BLog.e(TAG, "sceneIdentity is null, cannot preload");
            return;
        }
        String id = cacheId(action);
        String str = id;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            BLog.e(TAG, "resolver params is invalid " + id + ", cannot preload");
            return;
        }
        if (action.getMediaItemCreator() == null && action.getReportData() == null) {
            BLog.e(TAG, "PreloadAction params is error:if no mediaItemCreator, please set reportData");
            if (BuildConfig.DEBUG) {
                throw new Exception("PreloadAction params is error:if no mediaItemCreator, please set reportData");
            }
        }
        BuildersKt.launch$default(CacheManagerScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new PreloadPoolImpl$addPreloadAction$1(this, id, sceneIdentity, action, null), 3, (Object) null);
    }

    @Override // tv.danmaku.biliplayer.preload.repository.PreloadPool
    public void release(String sceneIdentity) {
        Intrinsics.checkNotNullParameter(sceneIdentity, "sceneIdentity");
        if (this.preloadList.isEmpty()) {
            return;
        }
        BuildersKt.launch$default(CacheManagerScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new PreloadPoolImpl$release$1(this, sceneIdentity, null), 3, (Object) null);
    }

    @Override // tv.danmaku.biliplayer.preload.repository.PreloadPool
    public void releaseAll() {
        if (this.preloadList.isEmpty()) {
            return;
        }
        this.sceneInfo.forEachInversion(new Function2() { // from class: tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit releaseAll$lambda$0;
                releaseAll$lambda$0 = PreloadPoolImpl.releaseAll$lambda$0(PreloadPoolImpl.this, (String) obj, ((Integer) obj2).intValue());
                return releaseAll$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit releaseAll$lambda$0(PreloadPoolImpl this$0, String scene, int i) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        this$0.release(scene);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayer.preload.repository.PreloadPool
    public void releasePreload(IResolveParams resolverParams) {
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        String id = cacheId(resolverParams);
        String str = id;
        if (str == null || str.length() == 0) {
            BLog.e(TAG, "resolver params is invalid " + id + ", remove fail");
        } else {
            BuildersKt.launch$default(CacheManagerScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new PreloadPoolImpl$releasePreload$1(this, id, null), 3, (Object) null);
        }
    }

    @Override // tv.danmaku.biliplayer.preload.repository.PreloadPool
    public Object getPlayerItemCache(IResolveParams params, long timeOutMs, Continuation<? super PreloadOutcome> continuation) {
        return BuildersKt.withContext(PlayerCacheCoroutineV2Kt.getCacheManagerDispatcher(), new PreloadPoolImpl$getPlayerItemCache$2(this, params, timeOutMs, null), continuation);
    }

    @Override // tv.danmaku.biliplayer.preload.repository.PreloadPool
    public void putBackPlayerItemCache(PreloadOutcome outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        String id = cacheId(outcome.getResolverParams());
        MediaItem<?> mediaItem = outcome.getMediaItem();
        if (mediaItem != null && mediaItem.valid()) {
            String str = id;
            if (!(str == null || str.length() == 0)) {
                if (!(outcome.getSceneIdentity().length() == 0)) {
                    BuildersKt.launch$default(CacheManagerScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new PreloadPoolImpl$putBackPlayerItemCache$1(this, outcome, id, null), 3, (Object) null);
                    return;
                }
            }
        }
        MediaItem<?> mediaItem2 = outcome.getMediaItem();
        if (mediaItem2 != null) {
            mediaItem2.release(true);
        }
        String sceneIdentity = outcome.getSceneIdentity();
        MediaItem<?> mediaItem3 = outcome.getMediaItem();
        BLog.e(TAG, "put play cache " + id + " back error, item invalid:" + sceneIdentity + " :" + (mediaItem3 != null ? Boolean.valueOf(mediaItem3.valid()) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean reusableWhenIdMatching(String oldScene, String newScene, CacheElement old, PreloadAction preloadAction) {
        return old.getStartPosition() == preloadAction.getStartPosition() && (Intrinsics.areEqual(oldScene, newScene) || Companion.getHitPreloadReuse());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearExceededBeforeAdd(final int newElementsSize, final String newSceneIdentity) {
        Iterable $this$filterNot$iv = this.preloadList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            CacheElement element = (CacheElement) element$iv$iv;
            if (!this.sceneInfo.contains(element.getIdentity())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            CacheElement it = (CacheElement) element$iv;
            this.preloadList.remove(it);
            it.release();
        }
        if (newElementsSize > 0 && this.preloadList.size() + newElementsSize > 7) {
            this.sceneInfo.forEachInversion(new Function2() { // from class: tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit clearExceededBeforeAdd$lambda$2;
                    clearExceededBeforeAdd$lambda$2 = PreloadPoolImpl.clearExceededBeforeAdd$lambda$2(PreloadPoolImpl.this, newSceneIdentity, newElementsSize, (String) obj, ((Integer) obj2).intValue());
                    return clearExceededBeforeAdd$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearExceededBeforeAdd$lambda$2(PreloadPoolImpl this$0, String $newSceneIdentity, int $newElementsSize, String scene, int limitSize) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        this$0.releaseFromScene(scene, limitSize - (Intrinsics.areEqual(scene, $newSceneIdentity) ? $newElementsSize : 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetIdleBufferBeforeAdd(String newSceneIdentity) {
        Iterable $this$forEach$iv = this.preloadList;
        for (Object element$iv : $this$forEach$iv) {
            CacheElement element = (CacheElement) element$iv;
            element.syncSuppress(!Intrinsics.areEqual(element.getIdentity(), newSceneIdentity));
        }
    }

    private final void releaseFromScene(String scene, int limitSize) {
        Iterable $this$filter$iv = this.preloadList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            CacheElement it = (CacheElement) element$iv$iv;
            if (Intrinsics.areEqual(it.getIdentity(), scene)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List sceneList = (List) destination$iv$iv;
        if (sceneList.size() <= limitSize) {
            return;
        }
        List $this$sortedBy$iv = sceneList;
        List sortList = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$releaseFromScene$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                CacheElement it2 = (CacheElement) t;
                CacheElement it3 = (CacheElement) t2;
                return ComparisonsKt.compareValues(PreloadPriority.m2145boximpl(it2.m2139getPriority3gV422k()), PreloadPriority.m2145boximpl(it3.m2139getPriority3gV422k()));
            }
        });
        int size = sortList.size();
        for (int index = limitSize; index < size; index++) {
            CacheElement element = (CacheElement) sortList.get(index);
            this.preloadList.remove(element);
            element.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String cacheId(PreloadAction $this$cacheId) {
        return cacheId($this$cacheId.getResolverParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String cacheId(IResolveParams $this$cacheId) {
        if ($this$cacheId.getId().length() > 0) {
            return $this$cacheId.getFrom() + "_" + $this$cacheId.getId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearSceneAfterRemove(String scene) {
        if (scene == null) {
            return;
        }
        Iterable $this$filter$iv = this.preloadList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            CacheElement element = (CacheElement) element$iv$iv;
            if (Intrinsics.areEqual(element.getIdentity(), scene)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List it = (List) destination$iv$iv;
        if (it.isEmpty()) {
            this.sceneInfo.remove(scene);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreloadOutcome toPreloadOutcomeIfInvalidRelease(CacheElement $this$toPreloadOutcomeIfInvalidRelease) {
        if ($this$toPreloadOutcomeIfInvalidRelease.getMediaResource() != null) {
            IResolveParams resolverParams = $this$toPreloadOutcomeIfInvalidRelease.getResolverParams();
            MediaItem<?> mediaItem = $this$toPreloadOutcomeIfInvalidRelease.getMediaItem();
            MediaResource mediaResource = $this$toPreloadOutcomeIfInvalidRelease.getMediaResource();
            Intrinsics.checkNotNull(mediaResource);
            return new PreloadOutcome(resolverParams, mediaItem, mediaResource, $this$toPreloadOutcomeIfInvalidRelease.getIdentity(), $this$toPreloadOutcomeIfInvalidRelease.getReusable());
        }
        $this$toPreloadOutcomeIfInvalidRelease.release();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printPreloads() {
        Iterable $this$forEach$iv = this.preloadList;
        for (Object element$iv : $this$forEach$iv) {
            CacheElement element = (CacheElement) element$iv;
            String identity = element.getIdentity();
            String id = element.getId();
            BLog.d(TAG, "preload item " + identity + " " + id + " " + PreloadPriority.m2151toStringimpl(element.m2139getPriority3gV422k()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PreloadPoolImpl.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J \u0010\u000b\u001a\u00020\b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadPoolImpl$LimitFiFoList;", "", "<init>", "()V", "list", "Ljava/util/LinkedList;", "", "add", "", "value", "remove", "forEachInversion", "block", "Lkotlin/Function2;", "", "contains", "", "getLimitSize", "index", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LimitFiFoList {
        private final LinkedList<String> list = new LinkedList<>();

        public final void add(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.list.isEmpty()) {
                this.list.add(value);
            } else if (!Intrinsics.areEqual(this.list.get(0), value)) {
                this.list.remove(value);
                this.list.addFirst(value);
            }
            if (this.list.size() > 3) {
                this.list.removeLast();
            }
        }

        public final void remove(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.list.remove(value);
        }

        public final void forEachInversion(Function2<? super String, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            int index = this.list.size();
            while (true) {
                index--;
                if (-1 < index) {
                    String str = this.list.get(index);
                    Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                    function2.invoke(str, Integer.valueOf(getLimitSize(index)));
                } else {
                    return;
                }
            }
        }

        public final boolean contains(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return this.list.contains(value);
        }

        public final int getLimitSize(int index) {
            switch (index) {
                case 0:
                    return 5;
                case 1:
                    return 2;
                case 2:
                default:
                    return 0;
            }
        }
    }

    /* compiled from: PreloadPoolImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadPoolImpl$Companion;", "", "<init>", "()V", "PRELOAD_MAX_SIZE", "", "ACTIVITY_SCENE_MAX_SIZE", "NEXT_SCENE_MAX_SIZE", "OTHER_SCENE_MAX_SIZE", "PRELOAD_LIMIT_SCENE", "hitPreloadReuse", "", "getHitPreloadReuse", "()Z", "hitPreloadReuse$delegate", "Lkotlin/Lazy;", "TAG", "", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getHitPreloadReuse() {
            return ((Boolean) PreloadPoolImpl.hitPreloadReuse$delegate.getValue()).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitPreloadReuse_delegate$lambda$0() {
        boolean it = DeviceDecision.INSTANCE.getBoolean("dd_player_cache_application_lifecycle", false);
        BLog.i("hit preload global=" + it);
        return it;
    }
}