package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: collections.kt */
public final class CollectionsKt {
    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        LinkedHashMap map = new LinkedHashMap();
        int i = 0;
        for (K k : iterable) {
            int index = i;
            i++;
            map.put(k, Integer.valueOf(index));
        }
        return map;
    }

    public static final <T> void addIfNotNull(Collection<T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        if (t != null) {
            collection.add(t);
        }
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return new HashMap<>(capacity(expectedSize));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize) {
        return new HashSet<>(capacity(expectedSize));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int expectedSize) {
        return new LinkedHashSet<>(capacity(expectedSize));
    }

    private static final int capacity(int expectedSize) {
        if (expectedSize < 3) {
            return 3;
        }
        return (expectedSize / 3) + expectedSize + 1;
    }

    public static final <T> List<T> compact(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        switch (arrayList.size()) {
            case 0:
                return kotlin.collections.CollectionsKt.emptyList();
            case 1:
                return kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first((List<? extends Object>) arrayList));
            default:
                arrayList.trimToSize();
                return arrayList;
        }
    }
}