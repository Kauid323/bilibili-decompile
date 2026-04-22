package tv.danmaku.biliplayer.preload.repository;

import com.bilibili.player.preload.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PreloadPoolImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$setPreloadActions$1", f = "PreloadPoolImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PreloadPoolImpl$setPreloadActions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PreloadAction> $actions;
    final /* synthetic */ String $sceneIdentity;
    int label;
    final /* synthetic */ PreloadPoolImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadPoolImpl$setPreloadActions$1(PreloadPoolImpl preloadPoolImpl, List<PreloadAction> list, String str, Continuation<? super PreloadPoolImpl$setPreloadActions$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadPoolImpl;
        this.$actions = list;
        this.$sceneIdentity = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadPoolImpl$setPreloadActions$1(this.this$0, this.$actions, this.$sceneIdentity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        PreloadPoolImpl.LimitFiFoList limitFiFoList;
        Iterator actionIterator;
        PreloadPoolImpl.LimitFiFoList limitFiFoList2;
        PreloadAction element;
        String cacheId;
        String id;
        LinkedList linkedList;
        MutableSharedFlow<PreloadStreamNetwork> mutableSharedFlow;
        LinkedList linkedList2;
        String id2;
        LinkedList linkedList3;
        boolean reusableWhenIdMatching;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ArrayList reusableElements = new ArrayList();
                ArrayList newElements = new ArrayList();
                limitFiFoList = this.this$0.sceneInfo;
                boolean z = false;
                int maxSize = limitFiFoList.getLimitSize(0);
                if (this.$actions.size() <= 5) {
                    actionIterator = this.$actions.iterator();
                } else {
                    BLog.e("PlayerPreload", LoginSceneProcessor.SCENE_KEY + this.$sceneIdentity + " set too much items will result in bandwidth waste， ignore count: " + (this.$actions.size() - 5));
                    actionIterator = this.$actions.subList(0, maxSize).iterator();
                }
                boolean needSyncReuseItems = false;
                while (actionIterator.hasNext()) {
                    PreloadAction action = actionIterator.next();
                    id2 = this.this$0.cacheId(action);
                    String str = id2;
                    if ((str == null || str.length() == 0) ? true : z) {
                        BLog.e("PlayerPreload", "resolver params is invalid " + id2 + ", cannot preload");
                    } else {
                        if (action.getMediaItemCreator() == null && action.getReportData() == null) {
                            BLog.e("PlayerPreload", "PreloadAction params is error:if no mediaItemCreator, please set reportData");
                            if (BuildConfig.DEBUG) {
                                throw new Exception("PreloadAction params is error:if no mediaItemCreator, please set reportData");
                            }
                        }
                        linkedList3 = this.this$0.preloadList;
                        Iterator iterator = linkedList3.iterator();
                        Intrinsics.checkNotNullExpressionValue(iterator, "iterator(...)");
                        boolean newCacheItem = true;
                        while (true) {
                            if (iterator.hasNext()) {
                                Object next = iterator.next();
                                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                CacheElement element2 = (CacheElement) next;
                                if (Intrinsics.areEqual(element2.getId(), id2)) {
                                    reusableWhenIdMatching = this.this$0.reusableWhenIdMatching(element2.getIdentity(), this.$sceneIdentity, element2, action);
                                    if (reusableWhenIdMatching) {
                                        element2.setIdentity(this.$sceneIdentity);
                                        if (!PreloadPriority.m2149equalsimpl0(element2.m2139getPriority3gV422k(), action.m2144getPriority3gV422k())) {
                                            needSyncReuseItems = true;
                                        }
                                        element2.m2140setPriorityEJy1Qw(action.m2144getPriority3gV422k());
                                        reusableElements.add(element2);
                                        newCacheItem = false;
                                    } else {
                                        BLog.e("PlayerPreload", "same element " + id2 + ", but cannot reuse");
                                        element2.release();
                                    }
                                    iterator.remove();
                                }
                            }
                        }
                        if (newCacheItem) {
                            newElements.add(action);
                        }
                        z = false;
                    }
                }
                limitFiFoList2 = this.this$0.sceneInfo;
                limitFiFoList2.add(this.$sceneIdentity);
                this.this$0.clearExceededBeforeAdd(maxSize, this.$sceneIdentity);
                this.this$0.resetIdleBufferBeforeAdd(this.$sceneIdentity);
                if (!reusableElements.isEmpty()) {
                    linkedList2 = this.this$0.preloadList;
                    linkedList2.addAll(0, reusableElements);
                    if (needSyncReuseItems) {
                        BuildersKt.launch$default(VideoCacheScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(reusableElements, null), 3, (Object) null);
                    }
                }
                ArrayList $this$forEach$iv = newElements;
                PreloadPoolImpl preloadPoolImpl = this.this$0;
                String str2 = this.$sceneIdentity;
                for (Object element$iv : $this$forEach$iv) {
                    PreloadAction action2 = (PreloadAction) element$iv;
                    id = preloadPoolImpl.cacheId(action2);
                    if (id != null) {
                        CacheElement it = new CacheElement(id, str2, action2);
                        linkedList = preloadPoolImpl.preloadList;
                        linkedList.add(0, it);
                        mutableSharedFlow = preloadPoolImpl._preloadNetworkFlow;
                        it.setStreamNetworkFlow(mutableSharedFlow);
                        it.start();
                    }
                }
                if (BuildConfig.DEBUG) {
                    Iterable $this$forEach$iv2 = this.$actions;
                    String str3 = this.$sceneIdentity;
                    PreloadPoolImpl preloadPoolImpl2 = this.this$0;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        cacheId = preloadPoolImpl2.cacheId((PreloadAction) element$iv2);
                        BLog.d("PlayerPreload", "preload set item " + str3 + " " + cacheId + " " + PreloadPriority.m2151toStringimpl(element.m2144getPriority3gV422k()));
                    }
                    this.this$0.printPreloads();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PreloadPoolImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$setPreloadActions$1$1", f = "PreloadPoolImpl.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$setPreloadActions$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<CacheElement> $reusableElements;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArrayList<CacheElement> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$reusableElements = arrayList;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$reusableElements, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0044 -> B:14:0x0047). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Iterator it;
            AnonymousClass1 anonymousClass1;
            Iterator it2;
            AnonymousClass1 anonymousClass12;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$forEach$iv = this.$reusableElements;
                    it = $this$forEach$iv.iterator();
                    anonymousClass1 = this;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    it2 = (Iterator) this.L$0;
                    anonymousClass12 = this;
                    anonymousClass1 = anonymousClass12;
                    it = it2;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (!it.hasNext()) {
                Object element$iv = it.next();
                CacheElement element = (CacheElement) element$iv;
                anonymousClass1.L$0 = it;
                anonymousClass1.label = 1;
                if (element.syncBufferInfo(anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it2 = it;
                anonymousClass12 = anonymousClass1;
                anonymousClass1 = anonymousClass12;
                it = it2;
                if (!it.hasNext()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}