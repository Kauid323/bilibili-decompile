package tv.danmaku.biliplayer.preload.repository;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PreloadPoolImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$putBackPlayerItemCache$1", f = "PreloadPoolImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PreloadPoolImpl$putBackPlayerItemCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ PreloadOutcome $outcome;
    int label;
    final /* synthetic */ PreloadPoolImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadPoolImpl$putBackPlayerItemCache$1(PreloadPoolImpl preloadPoolImpl, PreloadOutcome preloadOutcome, String str, Continuation<? super PreloadPoolImpl$putBackPlayerItemCache$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadPoolImpl;
        this.$outcome = preloadOutcome;
        this.$id = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadPoolImpl$putBackPlayerItemCache$1(this.this$0, this.$outcome, this.$id, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LinkedList linkedList;
        Object obj2;
        String cacheId;
        MutableSharedFlow<PreloadStreamNetwork> mutableSharedFlow;
        PreloadPoolImpl.LimitFiFoList limitFiFoList;
        LinkedList linkedList2;
        String cacheId2;
        String cacheId3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                linkedList = this.this$0.preloadList;
                PreloadPoolImpl preloadPoolImpl = this.this$0;
                PreloadOutcome preloadOutcome = this.$outcome;
                Iterator it = linkedList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        CacheElement it2 = (CacheElement) obj2;
                        String id = it2.getId();
                        cacheId3 = preloadPoolImpl.cacheId(preloadOutcome.getResolverParams());
                        if (Intrinsics.areEqual(id, cacheId3)) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    cacheId = this.this$0.cacheId(this.$outcome.getResolverParams());
                    BLog.i("PlayerPreload", "put play cache " + cacheId + " back");
                    CacheElement newCache = new CacheElement(this.$id, this.$outcome.getSceneIdentity(), this.$outcome.getResolverParams(), this.$outcome.getMediaItem(), this.$outcome.getMediaResource(), this.$outcome.getReusable());
                    mutableSharedFlow = this.this$0._preloadNetworkFlow;
                    newCache.setStreamNetworkFlow(mutableSharedFlow);
                    limitFiFoList = this.this$0.sceneInfo;
                    limitFiFoList.add(this.$outcome.getSceneIdentity());
                    this.this$0.clearExceededBeforeAdd(1, this.$outcome.getSceneIdentity());
                    linkedList2 = this.this$0.preloadList;
                    linkedList2.add(0, newCache);
                    return Unit.INSTANCE;
                }
                this.$outcome.getMediaItem().release(true);
                cacheId2 = this.this$0.cacheId(this.$outcome.getResolverParams());
                BLog.e("PlayerPreload", "put play cache " + cacheId2 + " back error, has same item release it");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}