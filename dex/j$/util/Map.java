package j$.util;

import j$.time.ZoneId$$ExternalSyntheticBackport1;
import j$.util.ImmutableCollections;
import j$.util.concurrent.ConcurrentMap;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface Map<K, V> {

    /* compiled from: D8$$SyntheticClass */
    /* renamed from: j$.util.Map$-EL */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class EL {
        public static /* synthetic */ Object compute(java.util.Map map, Object obj, BiFunction biFunction) {
            return map instanceof Map ? ((Map) map).compute(obj, biFunction) : map instanceof ConcurrentMap ? ConcurrentMap.CC.$default$compute((java.util.concurrent.ConcurrentMap) map, obj, biFunction) : CC.$default$compute(map, obj, biFunction);
        }

        public static /* synthetic */ Object computeIfAbsent(java.util.Map map, Object obj, Function function) {
            return map instanceof Map ? ((Map) map).computeIfAbsent(obj, function) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.$default$computeIfAbsent((java.util.concurrent.ConcurrentMap) map, obj, function) : CC.$default$computeIfAbsent(map, obj, function);
        }

        public static /* synthetic */ Object computeIfPresent(java.util.Map map, Object obj, BiFunction biFunction) {
            return map instanceof Map ? ((Map) map).computeIfPresent(obj, biFunction) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.$default$computeIfPresent((java.util.concurrent.ConcurrentMap) map, obj, biFunction) : CC.$default$computeIfPresent(map, obj, biFunction);
        }

        public static /* synthetic */ void forEach(java.util.Map map, BiConsumer biConsumer) {
            if (map instanceof Map) {
                ((Map) map).forEach(biConsumer);
            } else if (map instanceof java.util.concurrent.ConcurrentMap) {
                ConcurrentMap.CC.$default$forEach((java.util.concurrent.ConcurrentMap) map, biConsumer);
            } else {
                CC.$default$forEach(map, biConsumer);
            }
        }

        public static /* synthetic */ Object getOrDefault(java.util.Map map, Object obj, Object obj2) {
            return map instanceof Map ? ((Map) map).getOrDefault(obj, obj2) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.$default$getOrDefault((java.util.concurrent.ConcurrentMap) map, obj, obj2) : CC.$default$getOrDefault(map, obj, obj2);
        }

        public static /* synthetic */ Object merge(java.util.Map map, Object obj, Object obj2, BiFunction biFunction) {
            return map instanceof Map ? ((Map) map).merge(obj, obj2, biFunction) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.$default$merge((java.util.concurrent.ConcurrentMap) map, obj, obj2, biFunction) : CC.$default$merge(map, obj, obj2, biFunction);
        }

        public static /* synthetic */ Object putIfAbsent(java.util.Map map, Object obj, Object obj2) {
            return map instanceof Map ? ((Map) map).putIfAbsent(obj, obj2) : CC.$default$putIfAbsent(map, obj, obj2);
        }

        public static /* synthetic */ boolean remove(java.util.Map map, Object obj, Object obj2) {
            return map instanceof Map ? ((Map) map).remove(obj, obj2) : CC.$default$remove(map, obj, obj2);
        }

        public static /* synthetic */ Object replace(java.util.Map map, Object obj, Object obj2) {
            return map instanceof Map ? ((Map) map).replace(obj, obj2) : CC.$default$replace(map, obj, obj2);
        }

        public static /* synthetic */ boolean replace(java.util.Map map, Object obj, Object obj2, Object obj3) {
            return map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : CC.$default$replace(map, obj, obj2, obj3);
        }

        public static /* synthetic */ void replaceAll(java.util.Map map, BiFunction biFunction) {
            if (map instanceof Map) {
                ((Map) map).replaceAll(biFunction);
            } else if (map instanceof java.util.concurrent.ConcurrentMap) {
                ConcurrentMap.CC.$default$replaceAll((java.util.concurrent.ConcurrentMap) map, biFunction);
            } else {
                CC.$default$replaceAll(map, biFunction);
            }
        }
    }

    V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction);

    V computeIfAbsent(K k, Function<? super K, ? extends V> function);

    V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction);

    void forEach(BiConsumer<? super K, ? super V> biConsumer);

    V getOrDefault(Object obj, V v);

    V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction);

    V putIfAbsent(K k, V v);

    boolean remove(Object obj, Object obj2);

    V replace(K k, V v);

    boolean replace(K k, V v, V v2);

    void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction);

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface Entry<K, V> {

        /* renamed from: j$.util.Map$Entry$-CC */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public final /* synthetic */ class CC {
            public static <K extends Comparable<? super K>, V> java.util.Comparator<Map.Entry<K, V>> comparingByKey() {
                return new Map$Entry$$ExternalSyntheticLambda2();
            }

            public static <K, V extends Comparable<? super V>> java.util.Comparator<Map.Entry<K, V>> comparingByValue() {
                return new Map$Entry$$ExternalSyntheticLambda1();
            }

            public static <K, V> java.util.Comparator<Map.Entry<K, V>> comparingByKey(java.util.Comparator<? super K> cmp) {
                Objects.requireNonNull(cmp);
                return new Map$Entry$$ExternalSyntheticLambda3(cmp);
            }

            public static <K, V> java.util.Comparator<Map.Entry<K, V>> comparingByValue(java.util.Comparator<? super V> cmp) {
                Objects.requireNonNull(cmp);
                return new Map$Entry$$ExternalSyntheticLambda0(cmp);
            }
        }
    }

    /* renamed from: j$.util.Map$-CC */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        public static Object $default$getOrDefault(java.util.Map _this, Object key, Object obj) {
            Object obj2 = _this.get(key);
            if (obj2 != null || _this.containsKey(key)) {
                return obj2;
            }
            return obj;
        }

        public static void $default$forEach(java.util.Map _this, BiConsumer biConsumer) {
            Objects.requireNonNull(biConsumer);
            for (Map.Entry<K, V> entry : _this.entrySet()) {
                try {
                    K k = entry.getKey();
                    V v = entry.getValue();
                    biConsumer.accept(k, v);
                } catch (IllegalStateException ise) {
                    throw new ConcurrentModificationException(ise);
                }
            }
        }

        public static void $default$replaceAll(java.util.Map _this, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            for (Map.Entry<K, V> entry : _this.entrySet()) {
                try {
                    K k = entry.getKey();
                    V v = entry.getValue();
                    try {
                        entry.setValue((V) biFunction.apply(k, v));
                    } catch (IllegalStateException ise) {
                        throw new ConcurrentModificationException(ise);
                    }
                } catch (IllegalStateException ise2) {
                    throw new ConcurrentModificationException(ise2);
                }
            }
        }

        public static Object $default$putIfAbsent(java.util.Map _this, Object obj, Object obj2) {
            Object obj3 = _this.get(obj);
            if (obj3 == null) {
                return _this.put(obj, obj2);
            }
            return obj3;
        }

        public static boolean $default$remove(java.util.Map _this, Object key, Object value) {
            Object curValue = _this.get(key);
            if (Objects.equals(curValue, value)) {
                if (curValue == null && !_this.containsKey(key)) {
                    return false;
                }
                _this.remove(key);
                return true;
            }
            return false;
        }

        public static boolean $default$replace(java.util.Map _this, Object obj, Object obj2, Object obj3) {
            Object curValue = _this.get(obj);
            if (Objects.equals(curValue, obj2)) {
                if (curValue == null && !_this.containsKey(obj)) {
                    return false;
                }
                _this.put(obj, obj3);
                return true;
            }
            return false;
        }

        public static Object $default$replace(java.util.Map _this, Object obj, Object obj2) {
            Object obj3 = _this.get(obj);
            return (obj3 != null || _this.containsKey(obj)) ? _this.put(obj, obj2) : obj3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$computeIfAbsent(java.util.Map _this, Object obj, Function function) {
            Object apply;
            Objects.requireNonNull(function);
            Object obj2 = _this.get(obj);
            if (obj2 != null || (apply = function.apply(obj)) == null) {
                return obj2;
            }
            _this.put(obj, apply);
            return apply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$computeIfPresent(java.util.Map _this, Object obj, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            Object obj2 = _this.get(obj);
            if (obj2 != null) {
                Object apply = biFunction.apply(obj, obj2);
                if (apply != null) {
                    _this.put(obj, apply);
                    return apply;
                }
                _this.remove(obj);
                return null;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$compute(java.util.Map _this, Object obj, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            Object obj2 = _this.get(obj);
            Object apply = biFunction.apply(obj, obj2);
            if (apply != null) {
                _this.put(obj, apply);
                return apply;
            } else if (obj2 == null && !_this.containsKey(obj)) {
                return null;
            } else {
                _this.remove(obj);
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$merge(java.util.Map _this, Object obj, Object obj2, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            Objects.requireNonNull(obj2);
            Object obj3 = _this.get(obj);
            Object apply = obj3 == null ? obj2 : biFunction.apply(obj3, obj2);
            if (apply == null) {
                _this.remove(obj);
            } else {
                _this.put(obj, apply);
            }
            return apply;
        }

        public static <K, V> java.util.Map<K, V> of() {
            return ImmutableCollections.emptyMap();
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1) {
            return new ImmutableCollections.Map1(k1, v1);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2, k3, v3);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2, k3, v3, k4, v4);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
        }

        public static <K, V> java.util.Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
            return new ImmutableCollections.MapN(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
        }

        public static <K, V> java.util.Map<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
            if (entries.length == 0) {
                return ImmutableCollections.emptyMap();
            }
            if (entries.length == 1) {
                return new ImmutableCollections.Map1(entries[0].getKey(), entries[0].getValue());
            }
            Object[] kva = new Object[entries.length << 1];
            int a = 0;
            for (Map.Entry<? extends K, ? extends V> entry : entries) {
                int a2 = a + 1;
                kva[a] = entry.getKey();
                a = a2 + 1;
                kva[a2] = entry.getValue();
            }
            return new ImmutableCollections.MapN(kva);
        }

        public static <K, V> Map.Entry<K, V> entry(K k, V v) {
            return new KeyValueHolder(k, v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <K, V> java.util.Map<K, V> copyOf(java.util.Map<? extends K, ? extends V> map) {
            if (map instanceof ImmutableCollections.AbstractImmutableMap) {
                return map;
            }
            return ZoneId$$ExternalSyntheticBackport1.m((Map.Entry[]) map.entrySet().toArray(new Map.Entry[0]));
        }
    }
}