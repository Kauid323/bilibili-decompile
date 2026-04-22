package tv.danmaku.biliplayer.preload.strategy;

import com.bilibili.lib.media.resolver2.IResolveParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayer.preload.repository.PreloadAction;
import tv.danmaku.biliplayer.preload.repository.PreloadElementKt;
import tv.danmaku.biliplayer.preload.repository.PreloadOutcome;
import tv.danmaku.biliplayer.preload.repository.PreloadPool;
import tv.danmaku.biliplayer.preload.repository.PreloadPoolKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbstractStrategy.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayer/preload/strategy/AbstractStrategy;", "", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "cachePool", "Ltv/danmaku/biliplayer/preload/repository/PreloadPool;", "updateCacheList", "", "sceneIdentity", "list", "", "Ltv/danmaku/biliplayer/preload/repository/PreloadAction;", "getCache", "Ltv/danmaku/biliplayer/preload/repository/PreloadOutcome;", "params", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "(Lcom/bilibili/lib/media/resolver2/IResolveParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addPreloadAction", "action", "removePreloadAction", "releaseAll", "identity", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbstractStrategy {
    private final PreloadPool cachePool = PreloadPoolKt.getPlayerCachePool();

    public abstract String getTag();

    public static /* synthetic */ void updateCacheList$default(AbstractStrategy abstractStrategy, String str, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCacheList");
        }
        if ((i & 1) != 0) {
            str = PreloadElementKt.PRELOAD_IDENTITY_UNIDENTIFIED;
        }
        abstractStrategy.updateCacheList(str, list);
    }

    public final void updateCacheList(String sceneIdentity, List<PreloadAction> list) {
        Intrinsics.checkNotNullParameter(sceneIdentity, "sceneIdentity");
        Intrinsics.checkNotNullParameter(list, "list");
        this.cachePool.setPreloadActions(sceneIdentity, list);
        BLog.i(getTag(), "update preload list, list size:" + list.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getCache(IResolveParams params, Continuation<? super PreloadOutcome> continuation) {
        AbstractStrategy$getCache$1 abstractStrategy$getCache$1;
        AbstractStrategy abstractStrategy;
        Object playerItemCache$default;
        IResolveParams resolverParams;
        if (continuation instanceof AbstractStrategy$getCache$1) {
            abstractStrategy$getCache$1 = (AbstractStrategy$getCache$1) continuation;
            if ((abstractStrategy$getCache$1.label & Integer.MIN_VALUE) != 0) {
                abstractStrategy$getCache$1.label -= Integer.MIN_VALUE;
                Object $result = abstractStrategy$getCache$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (abstractStrategy$getCache$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        abstractStrategy = this;
                        PreloadPool preloadPool = abstractStrategy.cachePool;
                        abstractStrategy$getCache$1.label = 1;
                        playerItemCache$default = PreloadPool.CC.getPlayerItemCache$default(preloadPool, params, 0L, abstractStrategy$getCache$1, 2, null);
                        if (playerItemCache$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        abstractStrategy = this;
                        playerItemCache$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                PreloadOutcome item = (PreloadOutcome) playerItemCache$default;
                BLog.i(abstractStrategy.getTag(), "get cache from pool item:" + item + ", id:" + ((item != null || (resolverParams = item.getResolverParams()) == null) ? null : resolverParams.getId()));
                return item;
            }
        }
        abstractStrategy$getCache$1 = new AbstractStrategy$getCache$1(this, continuation);
        Object $result2 = abstractStrategy$getCache$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (abstractStrategy$getCache$1.label) {
        }
        PreloadOutcome item2 = (PreloadOutcome) playerItemCache$default;
        BLog.i(abstractStrategy.getTag(), "get cache from pool item:" + item2 + ", id:" + ((item2 != null || (resolverParams = item2.getResolverParams()) == null) ? null : resolverParams.getId()));
        return item2;
    }

    public static /* synthetic */ void addPreloadAction$default(AbstractStrategy abstractStrategy, String str, PreloadAction preloadAction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPreloadAction");
        }
        if ((i & 1) != 0) {
            str = PreloadElementKt.PRELOAD_IDENTITY_UNIDENTIFIED;
        }
        abstractStrategy.addPreloadAction(str, preloadAction);
    }

    public final void addPreloadAction(String sceneIdentity, PreloadAction action) {
        Intrinsics.checkNotNullParameter(sceneIdentity, "sceneIdentity");
        Intrinsics.checkNotNullParameter(action, "action");
        this.cachePool.addPreloadAction(sceneIdentity, action);
        BLog.i(getTag(), "add preload action to pool:" + action + ", id:" + action.getResolverParams().getId());
    }

    public final void removePreloadAction(PreloadAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.cachePool.releasePreload(action.getResolverParams());
        BLog.i(getTag(), "remove preload action to pool:" + action + ", id:" + action.getResolverParams().getId());
    }

    public final void releaseAll(String identity) {
        Intrinsics.checkNotNullParameter(identity, "identity");
        this.cachePool.release(identity);
        BLog.i(getTag(), "release pool cache, identity: " + identity);
    }
}