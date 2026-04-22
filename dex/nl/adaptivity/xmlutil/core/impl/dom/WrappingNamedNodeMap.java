package nl.adaptivity.xmlutil.core.impl.dom;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import nl.adaptivity.xmlutil.core.impl.idom.IAttr;
import nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap;
import nl.adaptivity.xmlutil.dom2.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: WrappingNamedNodeMap.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0018H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/WrappingNamedNodeMap;", "Lnl/adaptivity/xmlutil/core/impl/idom/INamedNodeMap;", "delegate", "Lorg/w3c/dom/NamedNodeMap;", "<init>", "(Lorg/w3c/dom/NamedNodeMap;)V", "getDelegate", "()Lorg/w3c/dom/NamedNodeMap;", "size", "", "getSize", "()I", "item", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "index", "getNamedItem", "qualifiedName", "", "getNamedItemNS", "namespace", "localName", "setNamedItem", "attr", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom2/Attr;", "setNamedItemNS", "removeNamedItem", "removeNamedItemNS", "iterator", "", "IteratorImpl", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WrappingNamedNodeMap implements INamedNodeMap, Collection {
    private final NamedNodeMap delegate;

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Attr attr) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add  reason: avoid collision after fix types in other method */
    public boolean add2(Attr attr) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(java.util.Collection<? extends Attr> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return INamedNodeMap.CC.$default$contains(this, obj);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap
    public /* synthetic */ boolean contains(Attr attr) {
        return INamedNodeMap.CC.$default$contains((INamedNodeMap) this, attr);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap, java.util.Collection
    public /* synthetic */ boolean containsAll(java.util.Collection collection) {
        return INamedNodeMap.CC.$default$containsAll(this, collection);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(Consumer<? super Attr> consumer) {
        Iterable.-CC.$default$forEach(this, consumer);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap
    public /* synthetic */ IAttr get(int i) {
        return INamedNodeMap.CC.$default$get((INamedNodeMap) this, i);
    }

    @Override // nl.adaptivity.xmlutil.dom2.NamedNodeMap
    public /* bridge */ /* synthetic */ Attr get(int i) {
        return INamedNodeMap.CC.m1624$default$get((INamedNodeMap) this, i);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap, org.w3c.dom.NamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap
    public /* synthetic */ int getLength() {
        return INamedNodeMap.CC.$default$getLength(this);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap, java.util.Collection
    public /* synthetic */ boolean isEmpty() {
        return INamedNodeMap.CC.$default$isEmpty(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ Stream<Attr> parallelStream() {
        return Collection.-CC.$default$parallelStream(this);
    }

    @Override // java.util.Collection
    /* renamed from: parallelStream  reason: avoid collision after fix types in other method */
    public /* synthetic */ Stream<Attr> parallelStream2() {
        return Stream.Wrapper.convert(parallelStream());
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super Attr> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.lang.Iterable, java.util.Collection
    public /* synthetic */ Spliterator<Attr> spliterator() {
        return Collection.-CC.$default$spliterator(this);
    }

    @Override // java.lang.Iterable, java.util.Collection
    /* renamed from: spliterator  reason: avoid collision after fix types in other method */
    public /* synthetic */ Spliterator<Attr> spliterator2() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream<Attr> stream() {
        return Collection.-CC.$default$stream(this);
    }

    @Override // java.util.Collection
    /* renamed from: stream  reason: avoid collision after fix types in other method */
    public /* synthetic */ java.util.stream.Stream<Attr> stream2() {
        return Stream.Wrapper.convert(stream());
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.-CC.$default$toArray(this, intFunction);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public WrappingNamedNodeMap(NamedNodeMap delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final NamedNodeMap getDelegate() {
        return this.delegate;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap
    public int getSize() {
        return this.delegate.getLength();
    }

    @Override // org.w3c.dom.NamedNodeMap
    public IAttr item(int index) {
        Node item = this.delegate.item(index);
        if (item != null) {
            return AttrImplKt.wrapAttr(item);
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public IAttr getNamedItem(String qualifiedName) {
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        Node namedItem = this.delegate.getNamedItem(qualifiedName);
        if (namedItem != null) {
            return AttrImplKt.wrapAttr(namedItem);
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public IAttr getNamedItemNS(String namespace, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        Node namedItemNS = this.delegate.getNamedItemNS(namespace, localName);
        if (namedItemNS != null) {
            return AttrImplKt.wrapAttr(namedItemNS);
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public IAttr setNamedItem(Node attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Node namedItem = this.delegate.setNamedItem(NodeImplKt.unWrap(attr));
        if (namedItem != null) {
            return AttrImplKt.wrapAttr(namedItem);
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.dom2.NamedNodeMap
    public IAttr setNamedItem(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Node namedItem = this.delegate.setNamedItem(NodeImplKt.unWrap(attr));
        if (namedItem != null) {
            return AttrImplKt.wrapAttr(namedItem);
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public IAttr setNamedItemNS(Node attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Node namedItemNS = this.delegate.setNamedItemNS(NodeImplKt.unWrap(attr));
        if (namedItemNS != null) {
            return AttrImplKt.wrapAttr(namedItemNS);
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.dom2.NamedNodeMap
    public IAttr setNamedItemNS(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Node namedItemNS = this.delegate.setNamedItemNS(NodeImplKt.unWrap(attr));
        if (namedItemNS != null) {
            return AttrImplKt.wrapAttr(namedItemNS);
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public IAttr removeNamedItem(String qualifiedName) {
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        Node removeNamedItem = this.delegate.removeNamedItem(qualifiedName);
        if (removeNamedItem != null) {
            return AttrImplKt.wrapAttr(removeNamedItem);
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public IAttr removeNamedItemNS(String namespace, String localName) {
        Intrinsics.checkNotNullParameter(localName, "localName");
        Node removeNamedItemNS = this.delegate.removeNamedItemNS(namespace, localName);
        if (removeNamedItemNS != null) {
            return AttrImplKt.wrapAttr(removeNamedItemNS);
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap, java.lang.Iterable, java.util.Collection
    public Iterator<IAttr> iterator() {
        return new IteratorImpl(this.delegate);
    }

    /* compiled from: WrappingNamedNodeMap.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/WrappingNamedNodeMap$IteratorImpl;", "", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "delegate", "Lorg/w3c/dom/NamedNodeMap;", "<init>", "(Lorg/w3c/dom/NamedNodeMap;)V", "next", "", "hasNext", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class IteratorImpl implements Iterator<IAttr>, KMappedMarker {
        private final NamedNodeMap delegate;
        private int next;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public IteratorImpl(NamedNodeMap delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.delegate = delegate;
        }

        @Override // java.util.Iterator
        public IAttr next() {
            NamedNodeMap namedNodeMap = this.delegate;
            int i = this.next;
            this.next = i + 1;
            Node item = namedNodeMap.item(i);
            Intrinsics.checkNotNullExpressionValue(item, "item(...)");
            return AttrImplKt.wrapAttr(item);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next < this.delegate.getLength();
        }
    }
}