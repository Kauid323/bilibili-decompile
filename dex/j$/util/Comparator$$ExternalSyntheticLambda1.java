package j$.util;

import j$.util.Comparator;
import java.io.Serializable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Comparator$$ExternalSyntheticLambda1 implements java.util.Comparator, Serializable {
    public final /* synthetic */ java.util.Comparator f$0;
    public final /* synthetic */ java.util.Comparator f$1;

    public /* synthetic */ Comparator$$ExternalSyntheticLambda1(java.util.Comparator comparator, java.util.Comparator comparator2) {
        this.f$0 = comparator;
        this.f$1 = comparator2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Comparator.CC.$private$lambda$thenComparing$36697e65$1(this.f$0, this.f$1, obj, obj2);
    }
}