package shark;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeapAnalysis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lshark/Leak;", "Ljava/io/Serializable;", "()V", "leakTraces", "", "Lshark/LeakTrace;", "getLeakTraces", "()Ljava/util/List;", "shortDescription", "", "getShortDescription", "()Ljava/lang/String;", "signature", "getSignature", "totalRetainedHeapByteSize", "", "getTotalRetainedHeapByteSize", "()Ljava/lang/Integer;", "totalRetainedObjectCount", "getTotalRetainedObjectCount", "toString", "Companion", "Lshark/LibraryLeak;", "Lshark/ApplicationLeak;", "shark"}, k = 1, mv = {1, 4, 1})
public abstract class Leak implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = -2287572510360910916L;

    public abstract List<LeakTrace> getLeakTraces();

    public abstract String getShortDescription();

    public abstract String getSignature();

    private Leak() {
    }

    public /* synthetic */ Leak(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public final Integer getTotalRetainedHeapByteSize() {
        if (((LeakTrace) CollectionsKt.first(getLeakTraces())).getRetainedHeapByteSize() == null) {
            return null;
        }
        Iterable $this$sumBy$iv = getLeakTraces();
        int sum$iv = 0;
        for (Object element$iv : $this$sumBy$iv) {
            LeakTrace it = (LeakTrace) element$iv;
            Integer retainedHeapByteSize = it.getRetainedHeapByteSize();
            if (retainedHeapByteSize == null) {
                Intrinsics.throwNpe();
            }
            sum$iv += retainedHeapByteSize.intValue();
        }
        return Integer.valueOf(sum$iv);
    }

    public final Integer getTotalRetainedObjectCount() {
        if (((LeakTrace) CollectionsKt.first(getLeakTraces())).getRetainedObjectCount() == null) {
            return null;
        }
        Iterable $this$sumBy$iv = getLeakTraces();
        int sum$iv = 0;
        for (Object element$iv : $this$sumBy$iv) {
            LeakTrace it = (LeakTrace) element$iv;
            Integer retainedObjectCount = it.getRetainedObjectCount();
            if (retainedObjectCount == null) {
                Intrinsics.throwNpe();
            }
            sum$iv += retainedObjectCount.intValue();
        }
        return Integer.valueOf(sum$iv);
    }

    public String toString() {
        return (getTotalRetainedHeapByteSize() != null ? getTotalRetainedHeapByteSize() + " bytes retained by leaking objects\n" : "") + (getLeakTraces().size() > 1 ? "Displaying only 1 leak trace out of " + getLeakTraces().size() + " with the same signature\n" : "") + "Signature: " + getSignature() + '\n' + ((LeakTrace) CollectionsKt.first(getLeakTraces()));
    }

    /* compiled from: HeapAnalysis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/Leak$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}