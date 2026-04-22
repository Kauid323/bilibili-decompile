package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import java.util.HashMap;

/* compiled from: Interner.kt */
public final class Interner<T> {
    private final int firstIndex;
    private final HashMap<T, Integer> interned;
    private final Interner<T> parent;

    private final Integer find(T t) {
        Integer find;
        if (!(this.parent == null || this.parent.interned.size() + this.parent.firstIndex == this.firstIndex)) {
            throw new AssertionError("Parent changed in parallel with child: indexes will be wrong");
        }
        Interner<T> interner = this.parent;
        return (interner == null || (find = interner.find(t)) == null) ? this.interned.get(t) : find;
    }

    public final int intern(T t) {
        Integer find = find(t);
        if (find != null) {
            return find.intValue();
        }
        int it = this.firstIndex + this.interned.size();
        this.interned.put(t, Integer.valueOf(it));
        return it;
    }
}