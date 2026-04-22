package j$.util;

import j$.lang.Iterable;
import j$.util.List;
import j$.util.Set;
import j$.util.SortedSet;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.util.LinkedHashSet;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public interface Collection<E> extends Iterable<E> {

    /* compiled from: D8$$SyntheticClass */
    /* renamed from: j$.util.Collection$-EL  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void forEach(java.util.Collection collection, Consumer consumer) {
            if (collection instanceof Collection) {
                ((Collection) collection).forEach(consumer);
            } else {
                CC.$default$forEach(collection, consumer);
            }
        }

        public static /* synthetic */ Stream parallelStream(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).parallelStream() : CC.$default$parallelStream(collection);
        }

        public static /* synthetic */ boolean removeIf(java.util.Collection collection, Predicate predicate) {
            return collection instanceof Collection ? ((Collection) collection).removeIf(predicate) : CC.$default$removeIf(collection, predicate);
        }

        public static /* synthetic */ Spliterator spliterator(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).spliterator() : collection instanceof LinkedHashSet ? DesugarLinkedHashSet.spliterator((LinkedHashSet) collection) : collection instanceof java.util.SortedSet ? SortedSet.CC.$default$spliterator((java.util.SortedSet) collection) : collection instanceof java.util.Set ? Set.CC.$default$spliterator((java.util.Set) collection) : collection instanceof java.util.List ? List.CC.$default$spliterator((java.util.List) collection) : Spliterators.spliterator(collection, 0);
        }

        public static /* synthetic */ Stream stream(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).stream() : CC.$default$stream(collection);
        }

        public static /* synthetic */ Object[] toArray(java.util.Collection collection, IntFunction intFunction) {
            return collection instanceof Collection ? ((Collection) collection).toArray(intFunction) : CC.$default$toArray(collection, intFunction);
        }
    }

    @Override // j$.lang.Iterable
    void forEach(Consumer<? super E> consumer);

    Stream<E> parallelStream();

    boolean removeIf(Predicate<? super E> predicate);

    @Override // j$.lang.Iterable
    Spliterator<E> spliterator();

    Stream<E> stream();

    <T> T[] toArray(IntFunction<T[]> intFunction);

    /* renamed from: j$.util.Collection$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        public static Object[] $default$toArray(java.util.Collection _this, IntFunction intFunction) {
            return _this.toArray((Object[]) intFunction.apply(0));
        }

        public static boolean $default$removeIf(java.util.Collection _this, Predicate predicate) {
            if (DesugarCollections.SYNCHRONIZED_COLLECTION.isInstance(_this)) {
                return DesugarCollections.removeIf(_this, predicate);
            }
            Objects.requireNonNull(predicate);
            boolean removed = false;
            java.util.Iterator<E> each = _this.iterator();
            while (each.hasNext()) {
                if (predicate.test(each.next())) {
                    each.remove();
                    removed = true;
                }
            }
            return removed;
        }

        public static void $default$forEach(java.util.Collection _this, Consumer consumer) {
            Objects.requireNonNull(consumer);
            for (E t : _this) {
                consumer.accept(t);
            }
        }

        public static Stream $default$stream(java.util.Collection _this) {
            return StreamSupport.stream(EL.spliterator(_this), false);
        }

        public static Stream $default$parallelStream(java.util.Collection _this) {
            return StreamSupport.stream(EL.spliterator(_this), true);
        }
    }
}