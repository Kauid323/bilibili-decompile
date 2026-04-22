package shark;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import shark.FilteringLeakingObjectFinder;

/* compiled from: FilteringLeakingObjectFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lshark/FilteringLeakingObjectFinder;", "Lshark/LeakingObjectFinder;", "filters", "", "Lshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "(Ljava/util/List;)V", "findLeakingObjectIds", "", "", "graph", "Lshark/HeapGraph;", "LeakingObjectFilter", "shark"}, k = 1, mv = {1, 4, 1})
public final class FilteringLeakingObjectFinder implements LeakingObjectFinder {
    private final List<LeakingObjectFilter> filters;

    /* compiled from: FilteringLeakingObjectFinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "", "isLeakingObject", "", "heapObject", "Lshark/HeapObject;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface LeakingObjectFilter {
        boolean isLeakingObject(HeapObject heapObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilteringLeakingObjectFinder(List<? extends LeakingObjectFilter> list) {
        Intrinsics.checkParameterIsNotNull(list, "filters");
        this.filters = list;
    }

    @Override // shark.LeakingObjectFinder
    public Set<Long> findLeakingObjectIds(HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        return SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(graph.getObjects(), new Function1<HeapObject, Boolean>() { // from class: shark.FilteringLeakingObjectFinder$findLeakingObjectIds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke((HeapObject) obj));
            }

            public final boolean invoke(HeapObject heapObject) {
                Iterable iterable;
                Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
                iterable = FilteringLeakingObjectFinder.this.filters;
                Iterable $this$any$iv = iterable;
                if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                    return false;
                }
                for (Object element$iv : $this$any$iv) {
                    FilteringLeakingObjectFinder.LeakingObjectFilter filter = (FilteringLeakingObjectFinder.LeakingObjectFilter) element$iv;
                    if (filter.isLeakingObject(heapObject)) {
                        return true;
                    }
                }
                return false;
            }
        }), new Function1<HeapObject, Long>() { // from class: shark.FilteringLeakingObjectFinder$findLeakingObjectIds$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Long.valueOf(invoke((HeapObject) obj));
            }

            public final long invoke(HeapObject it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.getObjectId();
            }
        }));
    }
}