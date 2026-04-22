package j$.time.chrono;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ChronoLocalDate$$ExternalSyntheticLambda0 implements Comparator, Serializable {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        compare = Long.compare(((ChronoLocalDate) obj).toEpochDay(), ((ChronoLocalDate) obj2).toEpochDay());
        return compare;
    }
}