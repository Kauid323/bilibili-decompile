package j$.util;

import j$.util.Spliterator;
import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.Consumer;

public abstract class AbstractList<E> extends AbstractCollection<E> implements java.util.List<E> {
    protected transient int modCount = 0;

    @Override // java.util.List
    public abstract E get(int i);

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    protected AbstractList() {
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public int indexOf(Object o) {
        ListIterator<E> it = listIterator();
        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return it.previousIndex();
                }
            }
            return -1;
        }
        while (it.hasNext()) {
            if (o.equals(it.next())) {
                return it.previousIndex();
            }
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public int lastIndexOf(Object o) {
        ListIterator<E> it = listIterator(size());
        if (o == null) {
            while (it.hasPrevious()) {
                if (it.previous() == null) {
                    return it.nextIndex();
                }
            }
            return -1;
        }
        while (it.hasPrevious()) {
            if (o.equals(it.previous())) {
                return it.nextIndex();
            }
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeRange(0, size());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public boolean addAll(int index, java.util.Collection<? extends E> c) {
        rangeCheckForAdd(index);
        boolean modified = false;
        for (E e : c) {
            add(index, e);
            modified = true;
            index++;
        }
        return modified;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public java.util.Iterator<E> iterator() {
        return new Itr();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public ListIterator<E> listIterator(int index) {
        rangeCheckForAdd(index);
        return new ListItr(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class Itr implements java.util.Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet;

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$Itr != java.util.AbstractList<E>$Itr */
        private Itr() {
            this.cursor = 0;
            this.lastRet = -1;
            this.expectedModCount = AbstractList.this.modCount;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$Itr != java.util.AbstractList<E>$Itr */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != AbstractList.this.size();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$Itr != java.util.AbstractList<E>$Itr */
        @Override // java.util.Iterator
        public E next() {
            checkForComodification();
            try {
                int i = this.cursor;
                E next = (E) AbstractList.this.get(i);
                this.lastRet = i;
                this.cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$Itr != java.util.AbstractList<E>$Itr */
        @Override // java.util.Iterator
        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                AbstractList.this.remove(this.lastRet);
                if (this.lastRet < this.cursor) {
                    this.cursor--;
                }
                this.lastRet = -1;
                this.expectedModCount = AbstractList.this.modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$Itr != java.util.AbstractList<E>$Itr */
        final void checkForComodification() {
            if (AbstractList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class ListItr extends AbstractList<E>.Itr implements ListIterator<E> {
        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$ListItr != java.util.AbstractList<E>$ListItr */
        ListItr(int index) {
            super();
            this.cursor = index;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$ListItr != java.util.AbstractList<E>$ListItr */
        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$ListItr != java.util.AbstractList<E>$ListItr */
        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            try {
                int i = this.cursor - 1;
                E previous = (E) AbstractList.this.get(i);
                this.cursor = i;
                this.lastRet = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$ListItr != java.util.AbstractList<E>$ListItr */
        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.cursor;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$ListItr != java.util.AbstractList<E>$ListItr */
        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.cursor - 1;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$ListItr != java.util.AbstractList<E>$ListItr */
        @Override // java.util.ListIterator
        public void set(E e) {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                AbstractList.this.set(this.lastRet, e);
                this.expectedModCount = AbstractList.this.modCount;
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$ListItr != java.util.AbstractList<E>$ListItr */
        @Override // java.util.ListIterator
        public void add(E e) {
            checkForComodification();
            try {
                int i = this.cursor;
                AbstractList.this.add(i, e);
                this.lastRet = -1;
                this.cursor = i + 1;
                this.expectedModCount = AbstractList.this.modCount;
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.List
    public java.util.List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size());
        if (this instanceof RandomAccess) {
            return new RandomAccessSubList(this, fromIndex, toIndex);
        }
        return new SubList(this, fromIndex, toIndex);
    }

    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        }
        if (toIndex > size) {
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.Collection, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof java.util.List) {
            ListIterator<E> e1 = listIterator();
            ListIterator<?> e2 = ((java.util.List) o).listIterator();
            while (e1.hasNext() && e2.hasNext()) {
                E o1 = e1.next();
                Object o2 = e2.next();
                if (o1 == null) {
                    if (o2 != null) {
                        return false;
                    }
                } else if (!o1.equals(o2)) {
                    return false;
                }
            }
            return (e1.hasNext() || e2.hasNext()) ? false : true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int hashCode = 1;
        java.util.Iterator<E> it = iterator();
        while (it.hasNext()) {
            E e = it.next();
            hashCode = (hashCode * 31) + (e == null ? 0 : e.hashCode());
        }
        return hashCode;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    protected void removeRange(int fromIndex, int toIndex) {
        ListIterator<E> it = listIterator(fromIndex);
        int n = toIndex - fromIndex;
        for (int i = 0; i < n; i++) {
            it.next();
            it.remove();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class RandomAccessSpliterator<E> implements Spliterator<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AbstractList<E> alist;
        private int expectedModCount;
        private int fence;
        private int index;
        private final java.util.List<E> list;

        @Override // j$.util.Spliterator
        public /* synthetic */ java.util.Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSpliterator != java.util.AbstractList$RandomAccessSpliterator<E> */
        public RandomAccessSpliterator(java.util.List<E> list) {
            this.list = list;
            this.index = 0;
            this.fence = -1;
            this.alist = list instanceof AbstractList ? (AbstractList) list : null;
            this.expectedModCount = this.alist != null ? this.alist.modCount : 0;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSpliterator != java.util.AbstractList$RandomAccessSpliterator<E> */
        private RandomAccessSpliterator(RandomAccessSpliterator<E> randomAccessSpliterator, int origin, int fence) {
            this.list = randomAccessSpliterator.list;
            this.index = origin;
            this.fence = fence;
            this.alist = randomAccessSpliterator.alist;
            this.expectedModCount = randomAccessSpliterator.expectedModCount;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSpliterator != java.util.AbstractList$RandomAccessSpliterator<E> */
        private int getFence() {
            java.util.List<E> lst = this.list;
            int hi = this.fence;
            if (hi < 0) {
                if (this.alist != null) {
                    this.expectedModCount = this.alist.modCount;
                }
                int hi2 = lst.size();
                this.fence = hi2;
                return hi2;
            }
            return hi;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSpliterator != java.util.AbstractList$RandomAccessSpliterator<E> */
        @Override // j$.util.Spliterator
        public Spliterator<E> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            this.index = mid;
            return new RandomAccessSpliterator(this, lo, mid);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSpliterator != java.util.AbstractList$RandomAccessSpliterator<E> */
        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int hi = getFence();
            int i = this.index;
            if (i < hi) {
                this.index = i + 1;
                action.accept((Object) get(this.list, i));
                checkAbstractListModCount(this.alist, this.expectedModCount);
                return true;
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSpliterator != java.util.AbstractList$RandomAccessSpliterator<E> */
        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            java.util.List<E> lst = this.list;
            int hi = getFence();
            this.index = hi;
            for (int i = this.index; i < hi; i++) {
                action.accept((Object) get(lst, i));
            }
            checkAbstractListModCount(this.alist, this.expectedModCount);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSpliterator != java.util.AbstractList$RandomAccessSpliterator<E> */
        @Override // j$.util.Spliterator
        public long estimateSize() {
            return getFence() - this.index;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSpliterator != java.util.AbstractList$RandomAccessSpliterator<E> */
        @Override // j$.util.Spliterator
        public int characteristics() {
            return 16464;
        }

        private static <E> E get(java.util.List<E> list, int i) {
            try {
                return list.get(i);
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<?> */
        static void checkAbstractListModCount(AbstractList<?> abstractList, int expectedModCount) {
            if (abstractList != null && abstractList.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class SubList<E> extends AbstractList<E> {
        private final int offset;
        private final SubList<E> parent;
        private final AbstractList<E> root;
        protected int size;

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        public SubList(AbstractList<E> abstractList, int fromIndex, int toIndex) {
            this.root = abstractList;
            this.parent = null;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = abstractList.modCount;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        protected SubList(SubList<E> subList, int fromIndex, int toIndex) {
            this.root = subList.root;
            this.parent = subList;
            this.offset = subList.offset + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = this.root.modCount;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList, java.util.List
        public E set(int index, E element) {
            Objects.checkIndex(index, this.size);
            checkForComodification();
            return this.root.set(this.offset + index, element);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList, java.util.List
        public E get(int index) {
            Objects.checkIndex(index, this.size);
            checkForComodification();
            return this.root.get(this.offset + index);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            checkForComodification();
            return this.size;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList, java.util.List
        public void add(int index, E element) {
            rangeCheckForAdd(index);
            checkForComodification();
            this.root.add(this.offset + index, element);
            updateSizeAndModCount(1);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList, java.util.List
        public E remove(int index) {
            Objects.checkIndex(index, this.size);
            checkForComodification();
            E result = this.root.remove(this.offset + index);
            updateSizeAndModCount(-1);
            return result;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList
        protected void removeRange(int fromIndex, int toIndex) {
            checkForComodification();
            this.root.removeRange(this.offset + fromIndex, this.offset + toIndex);
            updateSizeAndModCount(fromIndex - toIndex);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(java.util.Collection<? extends E> c) {
            return addAll(this.size, c);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList, java.util.List
        public boolean addAll(int index, java.util.Collection<? extends E> c) {
            rangeCheckForAdd(index);
            int cSize = c.size();
            if (cSize == 0) {
                return false;
            }
            checkForComodification();
            this.root.addAll(this.offset + index, c);
            updateSizeAndModCount(cSize);
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public java.util.Iterator<E> iterator() {
            return listIterator();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(final int index) {
            checkForComodification();
            rangeCheckForAdd(index);
            return new ListIterator<E>() { // from class: j$.util.AbstractList.SubList.1
                private final ListIterator<E> i;

                {
                    this.i = SubList.this.root.listIterator(SubList.this.offset + index);
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return nextIndex() < SubList.this.size;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public E next() {
                    if (hasNext()) {
                        return this.i.next();
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return previousIndex() >= 0;
                }

                @Override // java.util.ListIterator
                public E previous() {
                    if (hasPrevious()) {
                        return this.i.previous();
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.i.nextIndex() - SubList.this.offset;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.i.previousIndex() - SubList.this.offset;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    this.i.remove();
                    SubList.this.updateSizeAndModCount(-1);
                }

                @Override // java.util.ListIterator
                public void set(E e) {
                    this.i.set(e);
                }

                @Override // java.util.ListIterator
                public void add(E e) {
                    this.i.add(e);
                    SubList.this.updateSizeAndModCount(1);
                }
            };
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        @Override // j$.util.AbstractList, java.util.List
        public java.util.List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, this.size);
            return new SubList((SubList) this, fromIndex, toIndex);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        private String outOfBoundsMsg(int index) {
            return "Index: " + index + ", Size: " + this.size;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        private void checkForComodification() {
            if (this.root.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$SubList != java.util.AbstractList$SubList<E> */
        public void updateSizeAndModCount(int sizeChange) {
            SubList<E> subList = this;
            do {
                subList.size += sizeChange;
                subList.modCount = this.root.modCount;
                subList = subList.parent;
            } while (subList != null);
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    private static class RandomAccessSubList<E> extends SubList<E> implements RandomAccess {
        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList != java.util.AbstractList<E> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSubList != java.util.AbstractList$RandomAccessSubList<E> */
        RandomAccessSubList(AbstractList<E> abstractList, int fromIndex, int toIndex) {
            super(abstractList, fromIndex, toIndex);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSubList != java.util.AbstractList$RandomAccessSubList<E> */
        RandomAccessSubList(RandomAccessSubList<E> randomAccessSubList, int fromIndex, int toIndex) {
            super((SubList) randomAccessSubList, fromIndex, toIndex);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.AbstractList$RandomAccessSubList != java.util.AbstractList$RandomAccessSubList<E> */
        @Override // j$.util.AbstractList.SubList, j$.util.AbstractList, java.util.List
        public java.util.List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, this.size);
            return new RandomAccessSubList((RandomAccessSubList) this, fromIndex, toIndex);
        }
    }
}