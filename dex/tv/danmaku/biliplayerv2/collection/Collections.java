package tv.danmaku.biliplayerv2.collection;

import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import tv.danmaku.biliplayerv2.collection.Collections;

@Deprecated
public class Collections {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IteratorAction<E> {
        void run(E e);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IteratorActionWithIndex<E> {
        void run(int i, E e);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface SafeIteratorCollection<E> {
        void forEach(IteratorAction<E> iteratorAction);

        void forEachWithIndex(IteratorActionWithIndex<E> iteratorActionWithIndex);

        boolean isIterating();
    }

    public static <E> SafeIteratorList<E> safeIteratorList(List<E> list) {
        return new SafeIteratorList<>(list);
    }

    public static <K, V> SafeIteratorMap<K, V> safeIteratorMap(Map<K, V> map) {
        return new SafeIteratorMap<>(map);
    }

    @Deprecated
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SafeIteratorList<E> implements List<E>, SafeIteratorCollection<E> {
        private final List<E> mInner;
        private int mIteratingCount = 0;
        private final List<Runnable> mPendingActions = new ArrayList();

        SafeIteratorList(List<E> inner) {
            this.mInner = inner;
        }

        @Override // tv.danmaku.biliplayerv2.collection.Collections.SafeIteratorCollection
        public boolean isIterating() {
            return this.mIteratingCount > 0;
        }

        @Override // java.util.List, java.util.Collection
        public int size() {
            return this.mInner.size();
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.mInner.isEmpty();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.mInner.contains(obj);
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            throw new RuntimeException("please use forEach");
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return this.mInner.toArray();
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            return (T[]) this.mInner.toArray(array);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(final E error) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorList.this.m2215lambda$add$0$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(error);
                    }
                });
                return true;
            }
            return this.mInner.add(error);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$add$0$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorList  reason: not valid java name */
        public /* synthetic */ void m2215lambda$add$0$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(Object error) {
            this.mInner.add(error);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(final Object obj) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorList.this.m2219lambda$remove$1$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(obj);
                    }
                });
                return true;
            }
            return this.mInner.remove(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$remove$1$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorList  reason: not valid java name */
        public /* synthetic */ void m2219lambda$remove$1$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(Object obj) {
            this.mInner.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return this.mInner.containsAll(collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(final Collection<? extends E> collection) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorList.this.m2217lambda$addAll$2$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(collection);
                    }
                });
                return true;
            }
            return this.mInner.addAll(collection);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$addAll$2$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorList  reason: not valid java name */
        public /* synthetic */ void m2217lambda$addAll$2$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(Collection collection) {
            this.mInner.addAll(collection);
        }

        @Override // java.util.List
        public boolean addAll(final int index, final Collection<? extends E> c) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorList.this.m2218lambda$addAll$3$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(index, c);
                    }
                });
                return true;
            }
            return this.mInner.addAll(c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$addAll$3$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorList  reason: not valid java name */
        public /* synthetic */ void m2218lambda$addAll$3$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(int index, Collection c) {
            this.mInner.addAll(index, c);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(final Collection<?> collection) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorList.this.m2221lambda$removeAll$4$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(collection);
                    }
                });
                return true;
            }
            return this.mInner.removeAll(collection);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$removeAll$4$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorList  reason: not valid java name */
        public /* synthetic */ void m2221lambda$removeAll$4$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(Collection collection) {
            this.mInner.removeAll(collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return this.mInner.retainAll(collection);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            if (isIterating()) {
                List<Runnable> list = this.mPendingActions;
                final List<E> list2 = this.mInner;
                Objects.requireNonNull(list2);
                list.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        list2.clear();
                    }
                });
                return;
            }
            this.mInner.clear();
        }

        @Override // java.util.List
        public E get(int index) {
            return this.mInner.get(index);
        }

        @Override // java.util.List
        public E set(final int index, final E element) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorList.this.m2222lambda$set$5$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(index, element);
                    }
                });
                return element;
            }
            return this.mInner.set(index, element);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$set$5$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorList  reason: not valid java name */
        public /* synthetic */ void m2222lambda$set$5$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(int index, Object element) {
            this.mInner.set(index, element);
        }

        @Override // java.util.List
        public void add(final int index, final E element) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorList.this.m2216lambda$add$6$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(index, element);
                    }
                });
            } else {
                this.mInner.add(index, element);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$add$6$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorList  reason: not valid java name */
        public /* synthetic */ void m2216lambda$add$6$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(int index, Object element) {
            this.mInner.add(index, element);
        }

        @Override // java.util.List
        public E remove(final int index) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorList$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorList.this.m2220lambda$remove$7$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(index);
                    }
                });
                return this.mInner.get(index);
            }
            return this.mInner.remove(index);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$remove$7$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorList  reason: not valid java name */
        public /* synthetic */ void m2220lambda$remove$7$tvdanmakubiliplayerv2collectionCollections$SafeIteratorList(int index) {
            this.mInner.remove(index);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.mInner.indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.mInner.lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            throw new RuntimeException("please use forEach");
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int index) {
            throw new RuntimeException("please use forEach");
        }

        @Override // java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            return this.mInner.subList(fromIndex, toIndex);
        }

        @Override // tv.danmaku.biliplayerv2.collection.Collections.SafeIteratorCollection
        public void forEach(IteratorAction<E> action) {
            this.mIteratingCount++;
            for (E e : this.mInner) {
                action.run(e);
            }
            this.mIteratingCount--;
            if (!isIterating()) {
                while (this.mPendingActions.size() > 0) {
                    this.mPendingActions.remove(0).run();
                }
            }
        }

        @Override // tv.danmaku.biliplayerv2.collection.Collections.SafeIteratorCollection
        public void forEachWithIndex(IteratorActionWithIndex<E> action) {
            this.mIteratingCount++;
            int size = this.mInner.size();
            for (int i = 0; i < size; i++) {
                action.run(i, this.mInner.get(i));
            }
            int i2 = this.mIteratingCount;
            this.mIteratingCount = i2 - 1;
            if (!isIterating()) {
                while (this.mPendingActions.size() > 0) {
                    this.mPendingActions.remove(0).run();
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SafeIteratorMap<K, V> implements Map<K, V>, SafeIteratorCollection<Map.Entry<K, V>> {
        private final Map<K, V> mInner;
        private int mIteratingCount = 0;
        private final List<Runnable> mPendingActions = new ArrayList();

        SafeIteratorMap(Map<K, V> inner) {
            this.mInner = inner;
        }

        @Override // tv.danmaku.biliplayerv2.collection.Collections.SafeIteratorCollection
        public boolean isIterating() {
            return this.mIteratingCount > 0;
        }

        @Override // java.util.Map
        public int size() {
            return this.mInner.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.mInner.isEmpty();
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            return this.mInner.containsKey(key);
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            return this.mInner.containsValue(value);
        }

        @Override // java.util.Map
        public V get(Object key) {
            return this.mInner.get(key);
        }

        @Override // java.util.Map
        public V put(final K key, final V value) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorMap$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorMap.this.m2223lambda$put$0$tvdanmakubiliplayerv2collectionCollections$SafeIteratorMap(key, value);
                    }
                });
                return value;
            }
            return this.mInner.put(key, value);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$put$0$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorMap  reason: not valid java name */
        public /* synthetic */ void m2223lambda$put$0$tvdanmakubiliplayerv2collectionCollections$SafeIteratorMap(Object key, Object value) {
            this.mInner.put(key, value);
        }

        @Override // java.util.Map
        public V remove(final Object key) {
            if (isIterating()) {
                V value = this.mInner.get(key);
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorMap$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorMap.this.m2225lambda$remove$1$tvdanmakubiliplayerv2collectionCollections$SafeIteratorMap(key);
                    }
                });
                return value;
            }
            return this.mInner.remove(key);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$remove$1$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorMap  reason: not valid java name */
        public /* synthetic */ void m2225lambda$remove$1$tvdanmakubiliplayerv2collectionCollections$SafeIteratorMap(Object key) {
            this.mInner.remove(key);
        }

        @Override // java.util.Map
        public void putAll(final Map<? extends K, ? extends V> map) {
            if (isIterating()) {
                this.mPendingActions.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorMap$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Collections.SafeIteratorMap.this.m2224lambda$putAll$2$tvdanmakubiliplayerv2collectionCollections$SafeIteratorMap(map);
                    }
                });
            } else {
                this.mInner.putAll(map);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$putAll$2$tv-danmaku-biliplayerv2-collection-Collections$SafeIteratorMap  reason: not valid java name */
        public /* synthetic */ void m2224lambda$putAll$2$tvdanmakubiliplayerv2collectionCollections$SafeIteratorMap(Map map) {
            this.mInner.putAll(map);
        }

        @Override // java.util.Map
        public void clear() {
            if (isIterating()) {
                List<Runnable> list = this.mPendingActions;
                final Map<K, V> map = this.mInner;
                Objects.requireNonNull(map);
                list.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.collection.Collections$SafeIteratorMap$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        map.clear();
                    }
                });
                return;
            }
            this.mInner.clear();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return this.mInner.keySet();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return this.mInner.values();
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return this.mInner.entrySet();
        }

        @Override // tv.danmaku.biliplayerv2.collection.Collections.SafeIteratorCollection
        public void forEach(IteratorAction<Map.Entry<K, V>> action) {
            this.mIteratingCount++;
            Set<Map.Entry<K, V>> entries = this.mInner.entrySet();
            for (Map.Entry<K, V> entry : entries) {
                action.run(entry);
            }
            this.mIteratingCount--;
            if (!isIterating()) {
                while (this.mPendingActions.size() > 0) {
                    this.mPendingActions.remove(0).run();
                }
            }
        }

        @Override // tv.danmaku.biliplayerv2.collection.Collections.SafeIteratorCollection
        public void forEachWithIndex(IteratorActionWithIndex<Map.Entry<K, V>> action) {
            this.mIteratingCount++;
            Set<Map.Entry<K, V>> entries = this.mInner.entrySet();
            int index = 0;
            for (Map.Entry<K, V> entry : entries) {
                action.run(index, entry);
                index++;
            }
            this.mIteratingCount--;
            if (!isIterating()) {
                while (this.mPendingActions.size() > 0) {
                    this.mPendingActions.remove(0).run();
                }
            }
        }
    }
}