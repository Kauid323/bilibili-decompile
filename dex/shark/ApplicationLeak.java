package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* compiled from: HeapAnalysis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lshark/ApplicationLeak;", "Lshark/Leak;", "leakTraces", "", "Lshark/LeakTrace;", "(Ljava/util/List;)V", "getLeakTraces", "()Ljava/util/List;", "shortDescription", "", "getShortDescription", "()Ljava/lang/String;", "signature", "getSignature", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public final class ApplicationLeak extends Leak {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 524928276700576863L;
    private final List<LeakTrace> leakTraces;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplicationLeak copy$default(ApplicationLeak applicationLeak, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = applicationLeak.getLeakTraces();
        }
        return applicationLeak.copy(list);
    }

    public final List<LeakTrace> component1() {
        return getLeakTraces();
    }

    public final ApplicationLeak copy(List<LeakTrace> list) {
        Intrinsics.checkParameterIsNotNull(list, "leakTraces");
        return new ApplicationLeak(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ApplicationLeak) && Intrinsics.areEqual(getLeakTraces(), ((ApplicationLeak) obj).getLeakTraces());
        }
        return true;
    }

    public int hashCode() {
        List<LeakTrace> leakTraces = getLeakTraces();
        if (leakTraces != null) {
            return leakTraces.hashCode();
        }
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationLeak(List<LeakTrace> list) {
        super(null);
        Intrinsics.checkParameterIsNotNull(list, "leakTraces");
        this.leakTraces = list;
    }

    @Override // shark.Leak
    public List<LeakTrace> getLeakTraces() {
        return this.leakTraces;
    }

    @Override // shark.Leak
    public String getSignature() {
        return ((LeakTrace) CollectionsKt.first(getLeakTraces())).getSignature();
    }

    @Override // shark.Leak
    public String getShortDescription() {
        LeakTrace leakTrace = (LeakTrace) CollectionsKt.first(getLeakTraces());
        LeakTraceReference firstSuspectReferencePath = (LeakTraceReference) SequencesKt.firstOrNull(leakTrace.getSuspectReferenceSubpath());
        if (firstSuspectReferencePath != null) {
            String referenceName = firstSuspectReferencePath.getOriginObject().getClassSimpleName() + FileUtils.HIDDEN_PREFIX + firstSuspectReferencePath.getReferenceGenericName();
            if (referenceName != null) {
                return referenceName;
            }
        }
        return leakTrace.getLeakingObject().getClassName();
    }

    @Override // shark.Leak
    public String toString() {
        return super.toString();
    }

    /* compiled from: HeapAnalysis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/ApplicationLeak$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}