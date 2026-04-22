package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Nodes.kt */
public final class KmTypeProjection {
    public static final Companion Companion = new Companion(null);
    public static final KmTypeProjection STAR = new KmTypeProjection(null, null);
    private KmType type;
    private KmVariance variance;

    public final KmVariance component1() {
        return this.variance;
    }

    public final KmType component2() {
        return this.type;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KmTypeProjection) {
            KmTypeProjection kmTypeProjection = (KmTypeProjection) obj;
            return this.variance == kmTypeProjection.variance && Intrinsics.areEqual(this.type, kmTypeProjection.type);
        }
        return false;
    }

    public int hashCode() {
        return ((this.variance == null ? 0 : this.variance.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    public String toString() {
        return "KmTypeProjection(variance=" + this.variance + ", type=" + this.type + ')';
    }

    public KmTypeProjection(KmVariance variance, KmType type) {
        this.variance = variance;
        this.type = type;
    }

    /* compiled from: Nodes.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}