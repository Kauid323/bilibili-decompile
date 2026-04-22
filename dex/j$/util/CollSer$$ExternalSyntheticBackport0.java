package j$.util;

import java.util.Collections;
import java.util.HashSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollSer$$ExternalSyntheticBackport0 {
    public static /* synthetic */ java.util.Set m(Object[] objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        for (Object obj : objArr) {
            if (!hashSet.add(Objects.requireNonNull(obj))) {
                throw new IllegalArgumentException("duplicate element: " + obj);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}