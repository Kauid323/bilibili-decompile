package j$.util;

import java.io.Serializable;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Map$Entry$$ExternalSyntheticLambda1 implements java.util.Comparator, Serializable {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((Comparable) ((Map.Entry) obj).getValue()).compareTo(((Map.Entry) obj2).getValue());
        return compareTo;
    }
}