package shark;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.internal.StringsKt;

/* compiled from: LeakTraceReference.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0002#$B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lshark/LeakTraceReference;", "Ljava/io/Serializable;", "originObject", "Lshark/LeakTraceObject;", "referenceType", "Lshark/LeakTraceReference$ReferenceType;", "owningClassName", "", "referenceName", "(Lshark/LeakTraceObject;Lshark/LeakTraceReference$ReferenceType;Ljava/lang/String;Ljava/lang/String;)V", "getOriginObject", "()Lshark/LeakTraceObject;", "getOwningClassName", "()Ljava/lang/String;", "owningClassSimpleName", "getOwningClassSimpleName", "referenceDisplayName", "getReferenceDisplayName", "referenceGenericName", "getReferenceGenericName", "getReferenceName", "getReferenceType", "()Lshark/LeakTraceReference$ReferenceType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "ReferenceType", "shark"}, k = 1, mv = {1, 4, 1})
public final class LeakTraceReference implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 1;
    private final LeakTraceObject originObject;
    private final String owningClassName;
    private final String referenceName;
    private final ReferenceType referenceType;

    /* compiled from: LeakTraceReference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lshark/LeakTraceReference$ReferenceType;", "", "(Ljava/lang/String;I)V", "INSTANCE_FIELD", "STATIC_FIELD", "LOCAL", "ARRAY_ENTRY", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum ReferenceType {
        INSTANCE_FIELD,
        STATIC_FIELD,
        LOCAL,
        ARRAY_ENTRY
    }

    public static /* synthetic */ LeakTraceReference copy$default(LeakTraceReference leakTraceReference, LeakTraceObject leakTraceObject, ReferenceType referenceType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            leakTraceObject = leakTraceReference.originObject;
        }
        if ((i & 2) != 0) {
            referenceType = leakTraceReference.referenceType;
        }
        if ((i & 4) != 0) {
            str = leakTraceReference.owningClassName;
        }
        if ((i & 8) != 0) {
            str2 = leakTraceReference.referenceName;
        }
        return leakTraceReference.copy(leakTraceObject, referenceType, str, str2);
    }

    public final LeakTraceObject component1() {
        return this.originObject;
    }

    public final ReferenceType component2() {
        return this.referenceType;
    }

    public final String component3() {
        return this.owningClassName;
    }

    public final String component4() {
        return this.referenceName;
    }

    public final LeakTraceReference copy(LeakTraceObject leakTraceObject, ReferenceType referenceType, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(leakTraceObject, "originObject");
        Intrinsics.checkParameterIsNotNull(referenceType, "referenceType");
        Intrinsics.checkParameterIsNotNull(str, "owningClassName");
        Intrinsics.checkParameterIsNotNull(str2, "referenceName");
        return new LeakTraceReference(leakTraceObject, referenceType, str, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LeakTraceReference) {
                LeakTraceReference leakTraceReference = (LeakTraceReference) obj;
                return Intrinsics.areEqual(this.originObject, leakTraceReference.originObject) && Intrinsics.areEqual(this.referenceType, leakTraceReference.referenceType) && Intrinsics.areEqual(this.owningClassName, leakTraceReference.owningClassName) && Intrinsics.areEqual(this.referenceName, leakTraceReference.referenceName);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        LeakTraceObject leakTraceObject = this.originObject;
        int hashCode = (leakTraceObject != null ? leakTraceObject.hashCode() : 0) * 31;
        ReferenceType referenceType = this.referenceType;
        int hashCode2 = (hashCode + (referenceType != null ? referenceType.hashCode() : 0)) * 31;
        String str = this.owningClassName;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.referenceName;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LeakTraceReference(originObject=" + this.originObject + ", referenceType=" + this.referenceType + ", owningClassName=" + this.owningClassName + ", referenceName=" + this.referenceName + ")";
    }

    public LeakTraceReference(LeakTraceObject originObject, ReferenceType referenceType, String owningClassName, String referenceName) {
        Intrinsics.checkParameterIsNotNull(originObject, "originObject");
        Intrinsics.checkParameterIsNotNull(referenceType, "referenceType");
        Intrinsics.checkParameterIsNotNull(owningClassName, "owningClassName");
        Intrinsics.checkParameterIsNotNull(referenceName, "referenceName");
        this.originObject = originObject;
        this.referenceType = referenceType;
        this.owningClassName = owningClassName;
        this.referenceName = referenceName;
    }

    public final LeakTraceObject getOriginObject() {
        return this.originObject;
    }

    public final ReferenceType getReferenceType() {
        return this.referenceType;
    }

    public final String getOwningClassName() {
        return this.owningClassName;
    }

    public final String getReferenceName() {
        return this.referenceName;
    }

    public final String getOwningClassSimpleName() {
        return StringsKt.lastSegment(this.owningClassName, '.');
    }

    public final String getReferenceDisplayName() {
        switch (this.referenceType) {
            case ARRAY_ENTRY:
                return '[' + this.referenceName + ']';
            case STATIC_FIELD:
            case INSTANCE_FIELD:
                return this.referenceName;
            case LOCAL:
                return "<Java Local>";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getReferenceGenericName() {
        switch (this.referenceType) {
            case ARRAY_ENTRY:
                return "[x]";
            case STATIC_FIELD:
            case INSTANCE_FIELD:
                return this.referenceName;
            case LOCAL:
                return "<Java Local>";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: LeakTraceReference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/LeakTraceReference$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}