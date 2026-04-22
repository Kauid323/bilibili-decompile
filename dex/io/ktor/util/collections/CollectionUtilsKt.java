package io.ktor.util.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollectionUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u001a/\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a9\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0006\"\b\b\u0001\u0010\b*\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"T", "", "values", "", "sharedListOf", "([Ljava/lang/Object;)Ljava/util/List;", "", "K", "V", "", "initialCapacity", "", "sharedMap", "(I)Ljava/util/Map;", "sharedList", "()Ljava/util/List;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CollectionUtilsKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Will be dropped with new memory model enabled by default", replaceWith = @ReplaceWith(expression = "mutableListOf(values)", imports = {}))
    public static final <T> List<T> sharedListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "values");
        return CollectionsKt.mutableListOf(Arrays.copyOf(tArr, tArr.length));
    }

    public static /* synthetic */ Map sharedMap$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8;
        }
        return sharedMap(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Will be dropped with new memory model enabled by default", replaceWith = @ReplaceWith(expression = "mutableMapOf()", imports = {}))
    public static final <K, V> Map<K, V> sharedMap(int initialCapacity) {
        return new LinkedHashMap(initialCapacity);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Will be dropped with new memory model enabled by default", replaceWith = @ReplaceWith(expression = "mutableListOf<V>()", imports = {}))
    public static final <V> List<V> sharedList() {
        return new ArrayList();
    }
}