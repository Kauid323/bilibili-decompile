package io.ktor.util.collections;

import com.bilibili.playset.playlist.helper.ReportHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: Add missing generic type declarations: [Key] */
/* compiled from: ConcurrentSet.kt */
@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u001d\u0010\u0011\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u001d\u0010\u0014\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"io/ktor/util/collections/ConcurrentSetKt$ConcurrentSet$1", "", "element", "", "add", "(Ljava/lang/Object;)Z", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "", ReportHelper.EventValue.REPORT_EVENT_VALUE_CLEAR_INVALID_CLEAR, "()V", "", "iterator", "()Ljava/util/Iterator;", "remove", "removeAll", "retainAll", "contains", "containsAll", "isEmpty", "()Z", "Lio/ktor/util/collections/ConcurrentMap;", "delegate", "Lio/ktor/util/collections/ConcurrentMap;", "", "getSize", "()I", "size", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConcurrentSetKt$ConcurrentSet$1<Key> implements Set<Key>, KMutableSet {
    private final ConcurrentMap<Key, Unit> delegate = new ConcurrentMap<>(0, 1, null);

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Key key) {
        Intrinsics.checkNotNullParameter(key, "element");
        if (this.delegate.containsKey(key)) {
            return false;
        }
        this.delegate.put(key, Unit.INSTANCE);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Key> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<? extends Key> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!add(element$iv)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Key> iterator() {
        return this.delegate.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        return (element == null || this.delegate.remove(element) == null) ? false : true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<? extends Object> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!remove(element$iv)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Set removeList = new LinkedHashSet();
        for (Key key : this.delegate.keySet()) {
            if (!collection.contains(key)) {
                removeList.add(key);
            }
        }
        return removeAll(removeList);
    }

    public int getSize() {
        return this.delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        if (element == null) {
            return false;
        }
        return this.delegate.containsKey(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return collection.containsAll(this.delegate.keySet());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }
}