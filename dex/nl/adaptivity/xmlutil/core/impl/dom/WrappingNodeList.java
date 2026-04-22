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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.INode;
import nl.adaptivity.xmlutil.core.impl.idom.INodeList;
import nl.adaptivity.xmlutil.dom2.Node;
import org.w3c.dom.NodeList;

/* compiled from: WrappingNodeList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/WrappingNodeList;", "Lnl/adaptivity/xmlutil/core/impl/idom/INodeList;", "delegate", "Lorg/w3c/dom/NodeList;", "<init>", "(Lorg/w3c/dom/NodeList;)V", "getDelegate", "()Lorg/w3c/dom/NodeList;", "size", "", "getSize", "()I", "item", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "index", "getLength", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WrappingNodeList implements INodeList, Collection {
    private final NodeList delegate;

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add  reason: avoid collision after fix types in other method */
    public boolean add2(Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(java.util.Collection<? extends Node> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return INodeList.CC.$default$contains(this, obj);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INodeList
    public /* synthetic */ boolean contains(Node node) {
        return INodeList.CC.$default$contains((INodeList) this, node);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INodeList, java.util.Collection
    public /* synthetic */ boolean containsAll(java.util.Collection collection) {
        return INodeList.CC.$default$containsAll(this, collection);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(Consumer<? super Node> consumer) {
        Iterable.-CC.$default$forEach(this, consumer);
    }

    @Override // nl.adaptivity.xmlutil.dom2.NodeList
    public /* synthetic */ Node get(int i) {
        Node item;
        item = item(i);
        return item;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INodeList, java.util.Collection
    public /* synthetic */ boolean isEmpty() {
        return INodeList.CC.$default$isEmpty(this);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INodeList, nl.adaptivity.xmlutil.dom2.NodeList, java.lang.Iterable, java.util.Collection
    public /* synthetic */ Iterator iterator() {
        return INodeList.CC.$default$iterator(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ Stream<Node> parallelStream() {
        return Collection.-CC.$default$parallelStream(this);
    }

    @Override // java.util.Collection
    /* renamed from: parallelStream  reason: avoid collision after fix types in other method */
    public /* synthetic */ Stream<Node> parallelStream2() {
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
    public boolean removeIf(Predicate<? super Node> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.lang.Iterable, java.util.Collection
    public /* synthetic */ Spliterator<Node> spliterator() {
        return Collection.-CC.$default$spliterator(this);
    }

    @Override // java.lang.Iterable, java.util.Collection
    /* renamed from: spliterator  reason: avoid collision after fix types in other method */
    public /* synthetic */ Spliterator<Node> spliterator2() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream<Node> stream() {
        return Collection.-CC.$default$stream(this);
    }

    @Override // java.util.Collection
    /* renamed from: stream  reason: avoid collision after fix types in other method */
    public /* synthetic */ java.util.stream.Stream<Node> stream2() {
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

    public WrappingNodeList(NodeList delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final NodeList getDelegate() {
        return this.delegate;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.delegate.getLength();
    }

    @Override // org.w3c.dom.NodeList
    public INode item(int index) {
        org.w3c.dom.Node item = this.delegate.item(index);
        Intrinsics.checkNotNullExpressionValue(item, "item(...)");
        return NodeImplKt.wrap(item);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.INodeList, org.w3c.dom.NodeList, nl.adaptivity.xmlutil.dom2.NodeList
    @Deprecated(message = "Use size", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    public int getLength() {
        return this.delegate.getLength();
    }
}