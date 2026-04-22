package tv.danmaku.videoplayer.core.media.mediacenter.utils;

import android.util.LruCache;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LruCacheMap.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\u0004\u0018\u00018\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010 \u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0018J\u0014\u0010#\u001a\u00020\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\fR\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/utils/LruCacheMap;", "K", "V", "", "maxSize", "", "<init>", "(I)V", "mKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mActionCallback", "Ltv/danmaku/videoplayer/core/media/mediacenter/utils/LruActionCallback;", "mLruCache", "Landroid/util/LruCache;", "getMLruCache", "()Landroid/util/LruCache;", "mLruCache$delegate", "Lkotlin/Lazy;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "put", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "removeKey", "(Ljava/lang/Object;)V", "removeValue", "isEmpty", "size", "clear", "setLruActionCallback", "callback", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LruCacheMap<K, V> {
    private LruActionCallback<V> mActionCallback;
    private final ArrayList<K> mKeys = new ArrayList<>();
    private final Lazy mLruCache$delegate;

    public LruCacheMap(final int maxSize) {
        this.mLruCache$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.videoplayer.core.media.mediacenter.utils.LruCacheMap$$ExternalSyntheticLambda0
            public final Object invoke() {
                LruCacheMap$mLruCache$2$1 mLruCache_delegate$lambda$0;
                mLruCache_delegate$lambda$0 = LruCacheMap.mLruCache_delegate$lambda$0(maxSize, this);
                return mLruCache_delegate$lambda$0;
            }
        });
    }

    private final LruCache<K, V> getMLruCache() {
        return (LruCache) this.mLruCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [tv.danmaku.videoplayer.core.media.mediacenter.utils.LruCacheMap$mLruCache$2$1] */
    public static final LruCacheMap$mLruCache$2$1 mLruCache_delegate$lambda$0(final int $maxSize, final LruCacheMap this$0) {
        return new LruCache<K, V>($maxSize) { // from class: tv.danmaku.videoplayer.core.media.mediacenter.utils.LruCacheMap$mLruCache$2$1
            /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
                r0 = ((tv.danmaku.videoplayer.core.media.mediacenter.utils.LruCacheMap) r2).mActionCallback;
             */
            @Override // android.util.LruCache
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            protected void entryRemoved(boolean evicted, K k, V v, V v2) {
                LruActionCallback lruActionCallback;
                if (!evicted || lruActionCallback == null) {
                    return;
                }
                lruActionCallback.onValueRemoved(v);
            }
        };
    }

    public final boolean containsKey(K k) {
        return this.mKeys.contains(k);
    }

    public final void put(K k, V v) {
        getMLruCache().put(k, v);
        if (!this.mKeys.contains(k)) {
            this.mKeys.add(k);
        }
    }

    public final V get(K k) {
        return getMLruCache().get(k);
    }

    public final void removeKey(K k) {
        this.mKeys.remove(k);
        getMLruCache().remove(k);
    }

    public final K removeValue(V v) {
        if (v == null) {
            return null;
        }
        Iterable tmpKeys = new ArrayList(this.mKeys);
        Iterable<K> $this$forEach$iv = tmpKeys;
        for (K k : $this$forEach$iv) {
            if (Intrinsics.areEqual(getMLruCache().get(k), v)) {
                getMLruCache().remove(k);
                this.mKeys.remove(k);
                return k;
            }
        }
        return null;
    }

    public final boolean isEmpty() {
        ArrayList<K> arrayList = this.mKeys;
        return (arrayList == null || arrayList.isEmpty()) && getMLruCache().size() <= 0;
    }

    public final int size() {
        if (isEmpty()) {
            return 0;
        }
        return getMLruCache().size();
    }

    public final void clear() {
        this.mKeys.clear();
        getMLruCache().evictAll();
    }

    public final void setLruActionCallback(LruActionCallback<V> lruActionCallback) {
        Intrinsics.checkNotNullParameter(lruActionCallback, "callback");
        this.mActionCallback = lruActionCallback;
    }
}