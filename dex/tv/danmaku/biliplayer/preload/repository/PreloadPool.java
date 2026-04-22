package tv.danmaku.biliplayer.preload.repository;

import com.bilibili.lib.media.resolver2.IResolveParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PreloadPool.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001a\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0011H&R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadPool;", "", "setPreloadActions", "", "sceneIdentity", "", "actions", "", "Ltv/danmaku/biliplayer/preload/repository/PreloadAction;", "addPreloadAction", "action", "release", "releaseAll", "releasePreload", "resolverParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "getPlayerItemCache", "Ltv/danmaku/biliplayer/preload/repository/PreloadOutcome;", "params", "timeOutMs", "", "(Lcom/bilibili/lib/media/resolver2/IResolveParams;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBackPlayerItemCache", "outcome", "preloadStreamNetworkFlow", "Lkotlinx/coroutines/flow/Flow;", "Ltv/danmaku/biliplayer/preload/repository/PreloadStreamNetwork;", "getPreloadStreamNetworkFlow", "()Lkotlinx/coroutines/flow/Flow;", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface PreloadPool {
    void addPreloadAction(String str, PreloadAction preloadAction);

    Object getPlayerItemCache(IResolveParams iResolveParams, long j, Continuation<? super PreloadOutcome> continuation);

    Flow<PreloadStreamNetwork> getPreloadStreamNetworkFlow();

    void putBackPlayerItemCache(PreloadOutcome preloadOutcome);

    void release(String str);

    void releaseAll();

    void releasePreload(IResolveParams iResolveParams);

    void setPreloadActions(String str, List<PreloadAction> list);

    /* compiled from: PreloadPool.kt */
    /* renamed from: tv.danmaku.biliplayer.preload.repository.PreloadPool$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void setPreloadActions$default(PreloadPool preloadPool, String str, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPreloadActions");
            }
            if ((i & 1) != 0) {
                str = PreloadElementKt.PRELOAD_IDENTITY_UNIDENTIFIED;
            }
            preloadPool.setPreloadActions(str, list);
        }

        public static /* synthetic */ void addPreloadAction$default(PreloadPool preloadPool, String str, PreloadAction preloadAction, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPreloadAction");
            }
            if ((i & 1) != 0) {
                str = PreloadElementKt.PRELOAD_IDENTITY_UNIDENTIFIED;
            }
            preloadPool.addPreloadAction(str, preloadAction);
        }

        public static /* synthetic */ void release$default(PreloadPool preloadPool, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: release");
            }
            if ((i & 1) != 0) {
                str = PreloadElementKt.PRELOAD_IDENTITY_UNIDENTIFIED;
            }
            preloadPool.release(str);
        }

        public static /* synthetic */ Object getPlayerItemCache$default(PreloadPool preloadPool, IResolveParams iResolveParams, long j, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    j = 300;
                }
                return preloadPool.getPlayerItemCache(iResolveParams, j, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPlayerItemCache");
        }
    }
}