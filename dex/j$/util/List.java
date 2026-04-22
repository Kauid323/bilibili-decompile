package j$.util;

import j$.util.AbstractList;
import j$.util.ImmutableCollections;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

public interface List<E> extends Collection<E> {

    /* compiled from: D8$$SyntheticClass */
    /* renamed from: j$.util.List$-EL */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void replaceAll(java.util.List list, UnaryOperator unaryOperator) {
            if (list instanceof List) {
                ((List) list).replaceAll(unaryOperator);
            } else {
                CC.$default$replaceAll(list, unaryOperator);
            }
        }

        public static /* synthetic */ void sort(java.util.List list, java.util.Comparator comparator) {
            if (list instanceof List) {
                ((List) list).sort(comparator);
            } else {
                CC.$default$sort(list, comparator);
            }
        }

        public static /* synthetic */ Spliterator spliterator(java.util.List list) {
            return list instanceof List ? ((List) list).spliterator() : CC.$default$spliterator(list);
        }
    }

    void replaceAll(UnaryOperator<E> unaryOperator);

    void sort(java.util.Comparator<? super E> comparator);

    @Override // j$.util.Collection, j$.lang.Iterable
    Spliterator<E> spliterator();

    /* renamed from: j$.util.List$-CC */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        public static void $default$replaceAll(java.util.List _this, UnaryOperator unaryOperator) {
            Objects.requireNonNull(unaryOperator);
            ListIterator<E> li = _this.listIterator();
            while (li.hasNext()) {
                li.set((E) unaryOperator.apply(li.next()));
            }
        }

        public static void $default$sort(java.util.List _this, java.util.Comparator comparator) {
            Object[] a = _this.toArray();
            Arrays.sort(a, comparator);
            ListIterator<E> i = _this.listIterator();
            for (Object e : a) {
                i.next();
                i.set(e);
            }
        }

        public static Spliterator $default$spliterator(java.util.List _this) {
            if (_this instanceof RandomAccess) {
                return new AbstractList.RandomAccessSpliterator(_this);
            }
            return Spliterators.spliterator(_this, 16);
        }

        public static <E> java.util.List<E> of() {
            return ImmutableCollections.emptyList();
        }

        public static <E> java.util.List<E> of(E e1) {
            return new ImmutableCollections.List12(e1);
        }

        public static <E> java.util.List<E> of(E e1, E e2) {
            return new ImmutableCollections.List12(e1, e2);
        }

        public static <E> java.util.List<E> of(E e1, E e2, E e3) {
            return new ImmutableCollections.ListN(e1, e2, e3);
        }

        public static <E> java.util.List<E> of(E e1, E e2, E e3, E e4) {
            return new ImmutableCollections.ListN(e1, e2, e3, e4);
        }

        public static <E> java.util.List<E> of(E e1, E e2, E e3, E e4, E e5) {
            return new ImmutableCollections.ListN(e1, e2, e3, e4, e5);
        }

        public static <E> java.util.List<E> of(E e1, E e2, E e3, E e4, E e5, E e6) {
            return new ImmutableCollections.ListN(e1, e2, e3, e4, e5, e6);
        }

        public static <E> java.util.List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
            return new ImmutableCollections.ListN(e1, e2, e3, e4, e5, e6, e7);
        }

        public static <E> java.util.List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
            return new ImmutableCollections.ListN(e1, e2, e3, e4, e5, e6, e7, e8);
        }

        public static <E> java.util.List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
            return new ImmutableCollections.ListN(e1, e2, e3, e4, e5, e6, e7, e8, e9);
        }

        public static <E> java.util.List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
            return new ImmutableCollections.ListN(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
        }

        public static <E> java.util.List<E> of(E... elements) {
            switch (elements.length) {
                case 0:
                    return ImmutableCollections.emptyList();
                case 1:
                    return new ImmutableCollections.List12(elements[0]);
                case DesugarCalendar.LONG_FORMAT /* 2 */:
                    return new ImmutableCollections.List12(elements[0], elements[1]);
                default:
                    return new ImmutableCollections.ListN(elements);
            }
        }

        public static <E> java.util.List<E> copyOf(java.util.Collection<? extends E> coll) {
            return ImmutableCollections.listCopy(coll);
        }
    }
}