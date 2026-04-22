package kotlin.reflect.jvm.internal.impl.utils;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SmartList<E> extends AbstractList<E> implements RandomAccess, List {
    private Object myElem;
    private int mySize;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 4:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                i2 = 2;
                break;
            case 4:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        switch (i) {
            case 2:
            case 3:
                objArr[1] = "iterator";
                break;
            case 4:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 5:
            case 6:
            case 7:
                objArr[1] = "toArray";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                throw new IllegalStateException(format);
            case 4:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.-CC.$default$forEach(this, consumer);
    }

    @Override // java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.-CC.$default$parallelStream(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream parallelStream() {
        return Stream.Wrapper.convert(parallelStream());
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.-CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.-CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Spliterator spliterator() {
        return List.-CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.-CC.$default$stream(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(stream());
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.-CC.$default$toArray(this, intFunction);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        if (index < 0 || index >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.mySize);
        }
        if (this.mySize == 1) {
            return (E) this.myElem;
        }
        return (E) ((Object[]) this.myElem)[index];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        if (this.mySize == 0) {
            this.myElem = e;
        } else if (this.mySize == 1) {
            this.myElem = new Object[]{this.myElem, e};
        } else {
            Object[] array = (Object[]) this.myElem;
            int oldCapacity = array.length;
            if (this.mySize >= oldCapacity) {
                int newCapacity = ((oldCapacity * 3) / 2) + 1;
                int minCapacity = this.mySize + 1;
                if (newCapacity < minCapacity) {
                    newCapacity = minCapacity;
                }
                Object[] objArr = new Object[newCapacity];
                array = objArr;
                this.myElem = objArr;
                System.arraycopy(array, 0, array, 0, oldCapacity);
            }
            array[this.mySize] = e;
        }
        this.mySize++;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E e) {
        if (index < 0 || index > this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.mySize);
        }
        if (this.mySize == 0) {
            this.myElem = e;
        } else if (this.mySize == 1 && index == 0) {
            this.myElem = new Object[]{e, this.myElem};
        } else {
            Object[] array = new Object[this.mySize + 1];
            if (this.mySize == 1) {
                array[0] = this.myElem;
            } else {
                Object[] oldArray = (Object[]) this.myElem;
                System.arraycopy(oldArray, 0, array, 0, index);
                System.arraycopy(oldArray, index, array, index + 1, this.mySize - index);
            }
            array[index] = e;
            this.myElem = array;
        }
        this.mySize++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mySize;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        if (index < 0 || index >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.mySize);
        }
        if (this.mySize == 1) {
            E oldValue = (E) this.myElem;
            this.myElem = element;
            return oldValue;
        }
        Object[] array = (Object[]) this.myElem;
        E oldValue2 = (E) array[index];
        array[index] = element;
        return oldValue2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int index) {
        E oldValue;
        if (index < 0 || index >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.mySize);
        }
        if (this.mySize == 1) {
            oldValue = (E) this.myElem;
            this.myElem = null;
        } else {
            Object[] array = (Object[]) this.myElem;
            Object obj = array[index];
            if (this.mySize == 2) {
                this.myElem = array[1 - index];
            } else {
                int numMoved = (this.mySize - index) - 1;
                if (numMoved > 0) {
                    System.arraycopy(array, index + 1, array, index, numMoved);
                }
                array[this.mySize - 1] = null;
            }
            oldValue = (E) obj;
        }
        this.mySize--;
        this.modCount++;
        return oldValue;
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        if (this.mySize == 0) {
            EmptyIterator emptyIterator = EmptyIterator.getInstance();
            if (emptyIterator == null) {
                $$$reportNull$$$0(2);
            }
            return emptyIterator;
        } else if (this.mySize == 1) {
            return new SingletonIterator();
        } else {
            Iterator<E> it = super.iterator();
            if (it == null) {
                $$$reportNull$$$0(3);
            }
            return it;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        protected abstract void checkCoModification();

        protected abstract T getElement();

        private SingletonIteratorBase() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.myVisited;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.myVisited) {
                throw new NoSuchElementException();
            }
            this.myVisited = true;
            checkCoModification();
            return getElement();
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;

        public SingletonIterator() {
            super();
            this.myInitialModCount = SmartList.this.modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        protected E getElement() {
            return (E) SmartList.this.myElem;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        protected void checkCoModification() {
            if (SmartList.this.modCount != this.myInitialModCount) {
                throw new ConcurrentModificationException("ModCount: " + SmartList.this.modCount + "; expected: " + this.myInitialModCount);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            checkCoModification();
            SmartList.this.clear();
        }
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> comparator) {
        if (this.mySize >= 2) {
            Arrays.sort((Object[]) this.myElem, 0, this.mySize, comparator);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] a) {
        if (a == 0) {
            $$$reportNull$$$0(4);
        }
        int aLength = a.length;
        if (this.mySize == 1) {
            if (aLength != 0) {
                a[0] = this.myElem;
            } else {
                T[] r = (T[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), 1));
                r[0] = this.myElem;
                if (r == 0) {
                    $$$reportNull$$$0(5);
                }
                return r;
            }
        } else if (aLength < this.mySize) {
            T[] tArr = (T[]) Arrays.copyOf((Object[]) this.myElem, this.mySize, a.getClass());
            if (tArr == null) {
                $$$reportNull$$$0(6);
            }
            return tArr;
        } else if (this.mySize != 0) {
            System.arraycopy(this.myElem, 0, a, 0, this.mySize);
        }
        if (aLength > this.mySize) {
            a[this.mySize] = 0;
        }
        if (a == 0) {
            $$$reportNull$$$0(7);
        }
        return a;
    }
}