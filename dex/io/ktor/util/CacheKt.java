package io.ktor.util;

import io.ktor.utils.io.InternalAPI;
import j$.util.DesugarCollections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Cache.kt */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u001aW\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"K", "V", "Lkotlin/Function1;", "supplier", "", "close", "", "maxSize", "", "createLRUCache", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;I)Ljava/util/Map;", "CACHE_INITIAL_CAPACITY", "I", "", "CACHE_LOAD_FACTOR", "F", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CacheKt {
    private static final int CACHE_INITIAL_CAPACITY = 10;
    private static final float CACHE_LOAD_FACTOR = 0.75f;

    @InternalAPI
    public static final <K, V> Map<K, V> createLRUCache(Function1<? super K, ? extends V> function1, Function1<? super V, Unit> function12, int maxSize) {
        Intrinsics.checkNotNullParameter(function1, "supplier");
        Intrinsics.checkNotNullParameter(function12, "close");
        Map<K, V> synchronizedMap = DesugarCollections.synchronizedMap(new LRUCache(function1, function12, maxSize));
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(...)");
        return synchronizedMap;
    }
}