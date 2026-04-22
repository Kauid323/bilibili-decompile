package io.ktor.util.collections;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import io.ktor.utils.io.InternalAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CopyOnWriteHashMap.kt */
@InternalAPI
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u000bJ8\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u00002!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/util/collections/CopyOnWriteHashMap;", "", "K", "V", "<init>", "()V", "key", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "producer", "computeIfAbsent", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CopyOnWriteHashMap<K, V> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater current$FU = AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, "current");
    private volatile /* synthetic */ Object current = MapsKt.emptyMap();

    public final V put(K k, V v) {
        Map old;
        HashMap copy;
        V v2;
        Intrinsics.checkNotNullParameter(k, "key");
        Intrinsics.checkNotNullParameter(v, "value");
        do {
            old = (Map) this.current;
            if (old.get(k) == v) {
                return v;
            }
            copy = new HashMap(old);
            v2 = (V) copy.put(k, v);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(current$FU, this, old, copy));
        return v2;
    }

    public final V get(K k) {
        Intrinsics.checkNotNullParameter(k, "key");
        return (V) ((Map) this.current).get(k);
    }

    public final void set(K k, V v) {
        Intrinsics.checkNotNullParameter(k, "key");
        Intrinsics.checkNotNullParameter(v, "value");
        put(k, v);
    }

    public final V remove(K k) {
        Map old;
        HashMap copy;
        V v;
        Intrinsics.checkNotNullParameter(k, "key");
        do {
            old = (Map) this.current;
            if (old.get(k) == null) {
                return null;
            }
            copy = new HashMap(old);
            v = (V) copy.remove(k);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(current$FU, this, old, copy));
        return v;
    }

    public final V computeIfAbsent(K k, Function1<? super K, ? extends V> function1) {
        Map old;
        HashMap copy;
        V v;
        Intrinsics.checkNotNullParameter(k, "key");
        Intrinsics.checkNotNullParameter(function1, "producer");
        do {
            old = (Map) this.current;
            V v2 = (V) old.get(k);
            if (v2 != null) {
                return v2;
            }
            copy = new HashMap(old);
            v = (V) function1.invoke(k);
            copy.put(k, v);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(current$FU, this, old, copy));
        return v;
    }
}