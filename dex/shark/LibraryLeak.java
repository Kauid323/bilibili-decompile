package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.internal.StringsKt;

/* compiled from: HeapAnalysis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000b¨\u0006 "}, d2 = {"Lshark/LibraryLeak;", "Lshark/Leak;", "leakTraces", "", "Lshark/LeakTrace;", "pattern", "Lshark/ReferencePattern;", "description", "", "(Ljava/util/List;Lshark/ReferencePattern;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getLeakTraces", "()Ljava/util/List;", "getPattern", "()Lshark/ReferencePattern;", "shortDescription", "getShortDescription", "signature", "getSignature", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public final class LibraryLeak extends Leak {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 3943636164568681903L;
    private final String description;
    private final List<LeakTrace> leakTraces;
    private final ReferencePattern pattern;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LibraryLeak copy$default(LibraryLeak libraryLeak, List list, ReferencePattern referencePattern, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = libraryLeak.getLeakTraces();
        }
        if ((i & 2) != 0) {
            referencePattern = libraryLeak.pattern;
        }
        if ((i & 4) != 0) {
            str = libraryLeak.description;
        }
        return libraryLeak.copy(list, referencePattern, str);
    }

    public final List<LeakTrace> component1() {
        return getLeakTraces();
    }

    public final ReferencePattern component2() {
        return this.pattern;
    }

    public final String component3() {
        return this.description;
    }

    public final LibraryLeak copy(List<LeakTrace> list, ReferencePattern referencePattern, String str) {
        Intrinsics.checkParameterIsNotNull(list, "leakTraces");
        Intrinsics.checkParameterIsNotNull(referencePattern, "pattern");
        Intrinsics.checkParameterIsNotNull(str, "description");
        return new LibraryLeak(list, referencePattern, str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LibraryLeak) {
                LibraryLeak libraryLeak = (LibraryLeak) obj;
                return Intrinsics.areEqual(getLeakTraces(), libraryLeak.getLeakTraces()) && Intrinsics.areEqual(this.pattern, libraryLeak.pattern) && Intrinsics.areEqual(this.description, libraryLeak.description);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        List<LeakTrace> leakTraces = getLeakTraces();
        int hashCode = (leakTraces != null ? leakTraces.hashCode() : 0) * 31;
        ReferencePattern referencePattern = this.pattern;
        int hashCode2 = (hashCode + (referencePattern != null ? referencePattern.hashCode() : 0)) * 31;
        String str = this.description;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryLeak(List<LeakTrace> list, ReferencePattern pattern, String description) {
        super(null);
        Intrinsics.checkParameterIsNotNull(list, "leakTraces");
        Intrinsics.checkParameterIsNotNull(pattern, "pattern");
        Intrinsics.checkParameterIsNotNull(description, "description");
        this.leakTraces = list;
        this.pattern = pattern;
        this.description = description;
    }

    @Override // shark.Leak
    public List<LeakTrace> getLeakTraces() {
        return this.leakTraces;
    }

    public final ReferencePattern getPattern() {
        return this.pattern;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // shark.Leak
    public String getSignature() {
        return StringsKt.createSHA1Hash(this.pattern.toString());
    }

    @Override // shark.Leak
    public String getShortDescription() {
        return this.pattern.toString();
    }

    @Override // shark.Leak
    public String toString() {
        return "Leak pattern: " + this.pattern + "\nDescription: " + this.description + '\n' + super.toString() + '\n';
    }

    /* compiled from: HeapAnalysis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/LibraryLeak$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}