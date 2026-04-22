package tv.danmaku.biliplayer.preload.repository;

import com.bilibili.lib.media.resolver2.IResolveParams;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreloadPoolImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/biliplayer/preload/repository/PreloadOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$getPlayerItemCache$2", f = "PreloadPoolImpl.kt", i = {0, 0, 1, 1}, l = {251, 255}, m = "invokeSuspend", n = {"id", "cachedItem", "id", "cachedItem"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class PreloadPoolImpl$getPlayerItemCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PreloadOutcome>, Object> {
    final /* synthetic */ IResolveParams $params;
    final /* synthetic */ long $timeOutMs;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PreloadPoolImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadPoolImpl$getPlayerItemCache$2(PreloadPoolImpl preloadPoolImpl, IResolveParams iResolveParams, long j, Continuation<? super PreloadPoolImpl$getPlayerItemCache$2> continuation) {
        super(2, continuation);
        this.this$0 = preloadPoolImpl;
        this.$params = iResolveParams;
        this.$timeOutMs = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadPoolImpl$getPlayerItemCache$2(this.this$0, this.$params, this.$timeOutMs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PreloadOutcome> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.String] */
    public final Object invokeSuspend(Object $result) {
        ?? r1;
        String id;
        Iterable iterable;
        Object element$iv;
        CacheElement cachedItem;
        LinkedList linkedList;
        CacheElement cachedItem2;
        CacheElement cachedItem3;
        PreloadOutcome result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    id = this.this$0.cacheId(this.$params);
                    String str = id;
                    boolean z = false;
                    if (!(str == null || str.length() == 0)) {
                        iterable = this.this$0.preloadList;
                        Iterable $this$firstOrNull$iv = iterable;
                        Iterator it = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                CacheElement it2 = (CacheElement) element$iv;
                                if (Intrinsics.areEqual(it2.getId(), id)) {
                                }
                            } else {
                                element$iv = null;
                            }
                        }
                        cachedItem = (CacheElement) element$iv;
                        if (cachedItem != null) {
                            if (!cachedItem.getReusable()) {
                                this.this$0.clearSceneAfterRemove(cachedItem.getIdentity());
                            }
                            Job cacheJob = cachedItem.getCacheJob();
                            if (cacheJob != null && !cacheJob.isCompleted()) {
                                z = true;
                            }
                            if (!z) {
                                cachedItem.setStreamNetworkFlow(null);
                                linkedList = this.this$0.preloadList;
                                Boxing.boxBoolean(linkedList.remove(cachedItem));
                                break;
                            } else {
                                BLog.i("PlayerPreload", "### no cache:" + id + " wait resolver");
                                if (this.$timeOutMs <= 0) {
                                    this.L$0 = id;
                                    this.L$1 = cachedItem;
                                    this.label = 2;
                                    if (invokeSuspend$waitCache(cachedItem, this.this$0, (Continuation) this) != coroutine_suspended) {
                                        cachedItem2 = cachedItem;
                                        cachedItem = cachedItem2;
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    this.L$0 = id;
                                    this.L$1 = cachedItem;
                                    this.label = 1;
                                    if (TimeoutKt.withTimeout(this.$timeOutMs, new AnonymousClass1(cachedItem, this.this$0, null), (Continuation) this) != coroutine_suspended) {
                                        cachedItem3 = cachedItem;
                                        cachedItem = cachedItem3;
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                        } else {
                            BLog.i("PlayerPreload", "get play cache " + id + ", should add preload action first");
                            return null;
                        }
                    } else {
                        BLog.e("PlayerPreload", "resolver params is invalid " + id + ", remove fail");
                        return null;
                    }
                    break;
                case 1:
                    cachedItem3 = (CacheElement) this.L$1;
                    id = (String) this.L$0;
                    ResultKt.throwOnFailure($result);
                    cachedItem = cachedItem3;
                    break;
                case 2:
                    cachedItem2 = (CacheElement) this.L$1;
                    id = (String) this.L$0;
                    ResultKt.throwOnFailure($result);
                    cachedItem = cachedItem2;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            result = this.this$0.toPreloadOutcomeIfInvalidRelease(cachedItem);
            BLog.i("PlayerPreload", "### " + (result != null ? "use" : "no") + " cache:" + id + " " + cachedItem.getIdentity());
            return result;
        } catch (TimeoutCancellationException e) {
            BLog.i("PlayerPreload", "get play cache " + ((String) r1) + ", timeout");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object invokeSuspend$waitCache(CacheElement cachedItem, PreloadPoolImpl this$0, Continuation<? super Unit> continuation) {
        PreloadPoolImpl$getPlayerItemCache$2$waitCache$1 preloadPoolImpl$getPlayerItemCache$2$waitCache$1;
        CacheElement cachedItem2;
        PreloadPoolImpl this$02;
        LinkedList linkedList;
        if (continuation instanceof PreloadPoolImpl$getPlayerItemCache$2$waitCache$1) {
            preloadPoolImpl$getPlayerItemCache$2$waitCache$1 = (PreloadPoolImpl$getPlayerItemCache$2$waitCache$1) continuation;
            if ((preloadPoolImpl$getPlayerItemCache$2$waitCache$1.label & Integer.MIN_VALUE) != 0) {
                preloadPoolImpl$getPlayerItemCache$2$waitCache$1.label -= Integer.MIN_VALUE;
                Object $result = preloadPoolImpl$getPlayerItemCache$2$waitCache$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (preloadPoolImpl$getPlayerItemCache$2$waitCache$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Job cacheJob = cachedItem.getCacheJob();
                        if (cacheJob != null) {
                            preloadPoolImpl$getPlayerItemCache$2$waitCache$1.L$0 = cachedItem;
                            preloadPoolImpl$getPlayerItemCache$2$waitCache$1.L$1 = this$0;
                            preloadPoolImpl$getPlayerItemCache$2$waitCache$1.label = 1;
                            if (cacheJob.join(preloadPoolImpl$getPlayerItemCache$2$waitCache$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            cachedItem2 = cachedItem;
                            this$02 = this$0;
                            CacheElement cacheElement = cachedItem2;
                            this$0 = this$02;
                            cachedItem = cacheElement;
                            break;
                        }
                        break;
                    case 1:
                        this$02 = (PreloadPoolImpl) preloadPoolImpl$getPlayerItemCache$2$waitCache$1.L$1;
                        cachedItem2 = (CacheElement) preloadPoolImpl$getPlayerItemCache$2$waitCache$1.L$0;
                        ResultKt.throwOnFailure($result);
                        CacheElement cacheElement2 = cachedItem2;
                        this$0 = this$02;
                        cachedItem = cacheElement2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cachedItem.setStreamNetworkFlow(null);
                linkedList = this$0.preloadList;
                linkedList.remove(cachedItem);
                return Unit.INSTANCE;
            }
        }
        preloadPoolImpl$getPlayerItemCache$2$waitCache$1 = new PreloadPoolImpl$getPlayerItemCache$2$waitCache$1(continuation);
        Object $result2 = preloadPoolImpl$getPlayerItemCache$2$waitCache$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (preloadPoolImpl$getPlayerItemCache$2$waitCache$1.label) {
        }
        cachedItem.setStreamNetworkFlow(null);
        linkedList = this$0.preloadList;
        linkedList.remove(cachedItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PreloadPoolImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$getPlayerItemCache$2$1", f = "PreloadPoolImpl.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$getPlayerItemCache$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CacheElement $cachedItem;
        int label;
        final /* synthetic */ PreloadPoolImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CacheElement cacheElement, PreloadPoolImpl preloadPoolImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cachedItem = cacheElement;
            this.this$0 = preloadPoolImpl;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$cachedItem, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PreloadPoolImpl$getPlayerItemCache$2.invokeSuspend$waitCache(this.$cachedItem, this.this$0, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}