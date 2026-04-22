package j$.util;

import java.io.Serializable;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Map$Entry$$ExternalSyntheticLambda3 implements java.util.Comparator, Serializable {
    public final /* synthetic */ java.util.Comparator f$0;

    public /* synthetic */ Map$Entry$$ExternalSyntheticLambda3(java.util.Comparator comparator) {
        this.f$0 = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        compare = this.f$0.compare(((Map.Entry) obj).getKey(), ((Map.Entry) obj2).getKey());
        return compare;
    }
}