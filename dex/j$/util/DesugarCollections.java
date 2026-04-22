package j$.util;

import j$.util.Collection;
import j$.util.List;
import j$.util.Map;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class DesugarCollections {
    private static final Field COLLECTION_FIELD;
    private static final Constructor<? extends java.util.Collection> SYNCHRONIZED_COLLECTION_CONSTRUCTOR;
    private static final Constructor<? extends java.util.Set> SYNCHRONIZED_SET_CONSTRUCTOR;
    public static final Class<? extends java.util.Collection> SYNCHRONIZED_COLLECTION = Collections.synchronizedCollection(new ArrayList()).getClass();
    static final Class<? extends java.util.List> SYNCHRONIZED_LIST = Collections.synchronizedList(new LinkedList()).getClass();
    private static final Field MUTEX_FIELD = getField(SYNCHRONIZED_COLLECTION, "mutex");

    private DesugarCollections() {
    }

    static {
        if (MUTEX_FIELD != null) {
            MUTEX_FIELD.setAccessible(true);
        }
        COLLECTION_FIELD = getField(SYNCHRONIZED_COLLECTION, "c");
        if (COLLECTION_FIELD != null) {
            COLLECTION_FIELD.setAccessible(true);
        }
        SYNCHRONIZED_SET_CONSTRUCTOR = getConstructor(Collections.synchronizedSet(new HashSet()).getClass(), java.util.Set.class, Object.class);
        if (SYNCHRONIZED_SET_CONSTRUCTOR != null) {
            SYNCHRONIZED_SET_CONSTRUCTOR.setAccessible(true);
        }
        SYNCHRONIZED_COLLECTION_CONSTRUCTOR = getConstructor(SYNCHRONIZED_COLLECTION, java.util.Collection.class, Object.class);
        if (SYNCHRONIZED_COLLECTION_CONSTRUCTOR != null) {
            SYNCHRONIZED_COLLECTION_CONSTRUCTOR.setAccessible(true);
        }
    }

    private static Field getField(Class<?> clazz, String name) {
        try {
            return clazz.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    private static <E> Constructor<? extends E> getConstructor(Class<? extends E> clazz, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredConstructor(parameterTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean removeIf(java.util.Collection<E> collection, Predicate<? super E> filter) {
        boolean removeIf;
        if (MUTEX_FIELD == null) {
            try {
                return Collection.EL.removeIf((java.util.Collection) COLLECTION_FIELD.get(collection), filter);
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e);
            }
        }
        try {
            synchronized (MUTEX_FIELD.get(collection)) {
                removeIf = Collection.EL.removeIf((java.util.Collection) COLLECTION_FIELD.get(collection), filter);
            }
            return removeIf;
        } catch (IllegalAccessException e2) {
            throw new Error("Runtime illegal access in synchronized collection removeIf.", e2);
        }
    }

    public static <E> void forEach(Iterable<E> iterable, Consumer<? super E> consumer) {
        if (MUTEX_FIELD == null) {
            try {
                Collection.EL.forEach((java.util.Collection) COLLECTION_FIELD.get(iterable), consumer);
                return;
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized collection forEach fall-back.", e);
            }
        }
        try {
            synchronized (MUTEX_FIELD.get(iterable)) {
                Collection.EL.forEach((java.util.Collection) COLLECTION_FIELD.get(iterable), consumer);
            }
        } catch (IllegalAccessException e2) {
            throw new Error("Runtime illegal access in synchronized collection forEach.", e2);
        }
    }

    public static <E> void forEachIterable(Iterable<E> iterable, Consumer<? super E> action) {
        Objects.requireNonNull(action);
        for (E t : iterable) {
            action.accept(t);
        }
    }

    static <E> void replaceAll(java.util.List<E> list, UnaryOperator<E> operator) {
        if (MUTEX_FIELD == null) {
            try {
                List.EL.replaceAll((java.util.List) COLLECTION_FIELD.get(list), operator);
                return;
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized list replaceAll fall-back.", e);
            }
        }
        try {
            synchronized (MUTEX_FIELD.get(list)) {
                List.EL.replaceAll((java.util.List) COLLECTION_FIELD.get(list), operator);
            }
        } catch (IllegalAccessException e2) {
            throw new Error("Runtime illegal access in synchronized list replaceAll.", e2);
        }
    }

    static <E> void sort(java.util.List<E> list, java.util.Comparator<? super E> comparator) {
        if (MUTEX_FIELD == null) {
            try {
                List.EL.sort((java.util.List) COLLECTION_FIELD.get(list), comparator);
                return;
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", e);
            }
        }
        try {
            synchronized (MUTEX_FIELD.get(list)) {
                List.EL.sort((java.util.List) COLLECTION_FIELD.get(list), comparator);
            }
        } catch (IllegalAccessException e2) {
            throw new Error("Runtime illegal access in synchronized list sort.", e2);
        }
    }

    public static <K, V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V> m) {
        return new SynchronizedMap(m);
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    private static class SynchronizedMap<K, V> implements java.util.Map<K, V>, Serializable, Map<K, V> {
        private static final long serialVersionUID = 1978198479659022715L;
        private transient java.util.Set<Map.Entry<K, V>> entrySet;
        private transient java.util.Set<K> keySet;
        private final java.util.Map<K, V> m;
        final Object mutex;
        private transient java.util.Collection<V> values;

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        SynchronizedMap(java.util.Map<K, V> m) {
            this.m = (java.util.Map) Objects.requireNonNull(m);
            this.mutex = this;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        SynchronizedMap(java.util.Map<K, V> m, Object mutex) {
            this.m = m;
            this.mutex = mutex;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = this.m.size();
            }
            return size;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.m.isEmpty();
            }
            return isEmpty;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public boolean containsKey(Object key) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = this.m.containsKey(key);
            }
            return containsKey;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public boolean containsValue(Object value) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = this.m.containsValue(value);
            }
            return containsValue;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public V get(Object key) {
            V v;
            synchronized (this.mutex) {
                v = this.m.get(key);
            }
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public V put(K key, V value) {
            V put;
            synchronized (this.mutex) {
                put = this.m.put(key, value);
            }
            return put;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public V remove(Object key) {
            V remove;
            synchronized (this.mutex) {
                remove = this.m.remove(key);
            }
            return remove;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public void putAll(java.util.Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                this.m.putAll(map);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                this.m.clear();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        private <T> java.util.Set<T> instantiateSet(java.util.Set<T> set, Object mutex) {
            if (DesugarCollections.SYNCHRONIZED_SET_CONSTRUCTOR == null) {
                return Collections.synchronizedSet(set);
            }
            try {
                return (java.util.Set) DesugarCollections.SYNCHRONIZED_SET_CONSTRUCTOR.newInstance(set, mutex);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                throw new Error("Unable to instantiate a synchronized list.", e);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        private <T> java.util.Collection<T> instantiateCollection(java.util.Collection<T> collection, Object mutex) {
            if (DesugarCollections.SYNCHRONIZED_COLLECTION_CONSTRUCTOR == null) {
                return Collections.synchronizedCollection(collection);
            }
            try {
                return (java.util.Collection) DesugarCollections.SYNCHRONIZED_COLLECTION_CONSTRUCTOR.newInstance(collection, mutex);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                throw new Error("Unable to instantiate a synchronized list.", e);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public java.util.Set<K> keySet() {
            java.util.Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = (java.util.Set<K>) instantiateSet((java.util.Set<K>) this.m.keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public java.util.Set<Map.Entry<K, V>> entrySet() {
            java.util.Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = (java.util.Set<Map.Entry<K, V>>) instantiateSet((java.util.Set<Map.Entry<K, V>>) this.m.entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public java.util.Collection<V> values() {
            java.util.Collection<V> collection;
            synchronized (this.mutex) {
                if (this.values == null) {
                    this.values = (java.util.Collection<V>) instantiateCollection((java.util.Collection<V>) this.m.values(), this.mutex);
                }
                collection = this.values;
            }
            return collection;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public boolean equals(Object o) {
            boolean equals;
            if (this == o) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.m.equals(o);
            }
            return equals;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.m.hashCode();
            }
            return hashCode;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.m.toString();
            }
            return obj;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public V getOrDefault(Object k, V defaultValue) {
            V v;
            synchronized (this.mutex) {
                v = (V) Map.EL.getOrDefault(this.m, k, defaultValue);
            }
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            synchronized (this.mutex) {
                Map.EL.forEach(this.m, action);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            synchronized (this.mutex) {
                Map.EL.replaceAll(this.m, function);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public V putIfAbsent(K key, V value) {
            V v;
            synchronized (this.mutex) {
                v = (V) Map.EL.putIfAbsent(this.m, key, value);
            }
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.mutex) {
                remove = Map.EL.remove(this.m, key, value);
            }
            return remove;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public boolean replace(K key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.mutex) {
                replace = Map.EL.replace(this.m, key, oldValue, newValue);
            }
            return replace;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public V replace(K key, V value) {
            V v;
            synchronized (this.mutex) {
                v = (V) Map.EL.replace(this.m, key, value);
            }
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            V v;
            synchronized (this.mutex) {
                v = (V) Map.EL.computeIfAbsent(this.m, key, mappingFunction);
            }
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            V v;
            synchronized (this.mutex) {
                v = (V) Map.EL.computeIfPresent(this.m, key, remappingFunction);
            }
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            V v;
            synchronized (this.mutex) {
                v = (V) Map.EL.compute(this.m, key, remappingFunction);
            }
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        @Override // java.util.Map, j$.util.Map
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V v;
            synchronized (this.mutex) {
                v = (V) Map.EL.merge(this.m, key, value, remappingFunction);
            }
            return v;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedMap != java.util.DesugarCollections$SynchronizedMap<K, V> */
        private void writeObject(ObjectOutputStream s) {
            synchronized (this.mutex) {
                s.defaultWriteObject();
            }
        }
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> m) {
        return new SynchronizedSortedMap(m);
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V>, Map<K, V> {
        private static final long serialVersionUID = -8798146769416483793L;
        private final SortedMap<K, V> sm;

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedSortedMap != java.util.DesugarCollections$SynchronizedSortedMap<K, V> */
        SynchronizedSortedMap(SortedMap<K, V> m) {
            super(m);
            this.sm = m;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedSortedMap != java.util.DesugarCollections$SynchronizedSortedMap<K, V> */
        SynchronizedSortedMap(SortedMap<K, V> m, Object mutex) {
            super(m, mutex);
            this.sm = m;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedSortedMap != java.util.DesugarCollections$SynchronizedSortedMap<K, V> */
        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            java.util.Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = this.sm.comparator();
            }
            return comparator;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedSortedMap != java.util.DesugarCollections$SynchronizedSortedMap<K, V> */
        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.subMap(fromKey, toKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedSortedMap != java.util.DesugarCollections$SynchronizedSortedMap<K, V> */
        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K toKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.headMap(toKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedSortedMap != java.util.DesugarCollections$SynchronizedSortedMap<K, V> */
        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K fromKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.tailMap(fromKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedSortedMap != java.util.DesugarCollections$SynchronizedSortedMap<K, V> */
        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = this.sm.firstKey();
            }
            return firstKey;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.DesugarCollections$SynchronizedSortedMap != java.util.DesugarCollections$SynchronizedSortedMap<K, V> */
        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = this.sm.lastKey();
            }
            return lastKey;
        }
    }
}