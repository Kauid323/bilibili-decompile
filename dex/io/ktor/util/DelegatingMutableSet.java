package io.ktor.util;

import com.bilibili.playset.playlist.helper.ReportHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* compiled from: DelegatingMutableSet.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003BG\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\b\u0006\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\b\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u001d\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u001d\u0010\u0019\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u0013J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\u001d\u0010\u001b\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$H\u0096\u0002¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010*R%\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\b\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010+R%\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\b\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010+R\u001a\u0010,\u001a\u00020!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010#¨\u0006/"}, d2 = {"Lio/ktor/util/DelegatingMutableSet;", "From", "To", "", "delegate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "convertTo", "convert", "<init>", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "(Ljava/util/Collection;)Ljava/util/Collection;", "element", "", "add", "(Ljava/lang/Object;)Z", "elements", "addAll", "(Ljava/util/Collection;)Z", "", ReportHelper.EventValue.REPORT_EVENT_VALUE_CLEAR_INVALID_CLEAR, "()V", "remove", "removeAll", "retainAll", "contains", "containsAll", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "hashCode", "()I", "", "other", "equals", "", "toString", "()Ljava/lang/String;", "Ljava/util/Set;", "Lkotlin/jvm/functions/Function1;", "size", "I", "getSize", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class DelegatingMutableSet<From, To> implements Set<To>, KMutableSet {
    private final Function1<To, From> convert;
    private final Function1<From, To> convertTo;
    private final Set<From> delegate;
    private final int size;

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelegatingMutableSet(Set<From> set, Function1<? super From, ? extends To> function1, Function1<? super To, ? extends From> function12) {
        Intrinsics.checkNotNullParameter(set, "delegate");
        Intrinsics.checkNotNullParameter(function1, "convertTo");
        Intrinsics.checkNotNullParameter(function12, "convert");
        this.delegate = set;
        this.convertTo = function1;
        this.convert = function12;
        this.size = this.delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public Collection<From> convert(Collection<? extends To> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection<? extends To> $this$map$iv = collection;
        Collection destination$iv$iv = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Object it = this.convert.invoke(item$iv$iv);
            destination$iv$iv.add(it);
        }
        return (List) destination$iv$iv;
    }

    public Collection<To> convertTo(Collection<? extends From> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection<? extends From> $this$map$iv = collection;
        Collection destination$iv$iv = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Object it = this.convertTo.invoke(item$iv$iv);
            destination$iv$iv.add(it);
        }
        return (List) destination$iv$iv;
    }

    public int getSize() {
        return this.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean add(To to) {
        return this.delegate.add(this.convert.invoke(to));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends To> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.delegate.addAll(convert(collection));
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        return this.delegate.remove(this.convert.invoke(element));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.delegate.removeAll(kotlin.collections.CollectionsKt.toSet(convert(collection)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.delegate.retainAll(kotlin.collections.CollectionsKt.toSet(convert(collection)));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return this.delegate.contains(this.convert.invoke(element));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.delegate.containsAll(convert(collection));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<To> iterator() {
        return new DelegatingMutableSet$iterator$1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Set)) {
            return false;
        }
        Collection elements = convertTo(this.delegate);
        return ((Set) other).containsAll(elements) && elements.containsAll((Collection) other);
    }

    public String toString() {
        return convertTo(this.delegate).toString();
    }
}