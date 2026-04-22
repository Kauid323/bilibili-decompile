package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReferenceMatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"filterFor", "", "Lshark/ReferenceMatcher;", "", "graph", "Lshark/HeapGraph;", "shark"}, k = 2, mv = {1, 4, 1})
public final class ReferenceMatcherKt {
    public static final List<ReferenceMatcher> filterFor(Iterable<? extends ReferenceMatcher> iterable, HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$filterFor");
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Collection destination$iv$iv = new ArrayList();
        for (ReferenceMatcher referenceMatcher : iterable) {
            ReferenceMatcher matcher = referenceMatcher;
            if ((matcher instanceof IgnoredReferenceMatcher) || ((matcher instanceof LibraryLeakReferenceMatcher) && ((Boolean) ((LibraryLeakReferenceMatcher) matcher).getPatternApplies().invoke(graph)).booleanValue())) {
                destination$iv$iv.add(referenceMatcher);
            }
        }
        return (List) destination$iv$iv;
    }
}