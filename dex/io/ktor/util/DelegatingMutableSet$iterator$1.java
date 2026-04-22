package io.ktor.util;

import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: Add missing generic type declarations: [To] */
/* compiled from: DelegatingMutableSet.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"io/ktor/util/DelegatingMutableSet$iterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "remove", "()V", "delegateIterator", "Ljava/util/Iterator;", "getDelegateIterator", "()Ljava/util/Iterator;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DelegatingMutableSet$iterator$1<To> implements Iterator<To>, KMutableIterator {
    private final Iterator<From> delegateIterator;
    final /* synthetic */ DelegatingMutableSet<From, To> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelegatingMutableSet$iterator$1(DelegatingMutableSet<From, To> delegatingMutableSet) {
        Set set;
        this.this$0 = delegatingMutableSet;
        set = ((DelegatingMutableSet) delegatingMutableSet).delegate;
        this.delegateIterator = set.iterator();
    }

    public final Iterator<From> getDelegateIterator() {
        return this.delegateIterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.delegateIterator.hasNext();
    }

    @Override // java.util.Iterator
    public To next() {
        Function1 function1;
        function1 = ((DelegatingMutableSet) this.this$0).convertTo;
        return (To) function1.invoke(this.delegateIterator.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.delegateIterator.remove();
    }
}