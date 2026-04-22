package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Nodes.kt */
public final class KmFlexibleTypeUpperBound {
    public static final Companion Companion = new Companion(null);
    private KmType type;
    private String typeFlexibilityId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KmFlexibleTypeUpperBound) {
            KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = (KmFlexibleTypeUpperBound) obj;
            return Intrinsics.areEqual(this.type, kmFlexibleTypeUpperBound.type) && Intrinsics.areEqual(this.typeFlexibilityId, kmFlexibleTypeUpperBound.typeFlexibilityId);
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + (this.typeFlexibilityId == null ? 0 : this.typeFlexibilityId.hashCode());
    }

    public String toString() {
        return "KmFlexibleTypeUpperBound(type=" + this.type + ", typeFlexibilityId=" + this.typeFlexibilityId + ')';
    }

    public KmFlexibleTypeUpperBound(KmType type, String typeFlexibilityId) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.typeFlexibilityId = typeFlexibilityId;
    }

    public final KmType getType() {
        return this.type;
    }

    public final String getTypeFlexibilityId() {
        return this.typeFlexibilityId;
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