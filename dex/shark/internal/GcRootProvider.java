package shark.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.GcRoot;
import shark.HeapGraph;
import shark.HeapObject;
import shark.IgnoredReferenceMatcher;
import shark.LibraryLeakReferenceMatcher;
import shark.ReferenceMatcher;
import shark.ReferenceMatcherKt;
import shark.ReferencePattern;
import shark.internal.GcRootProvider;

/* compiled from: GcRootProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001a\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lshark/internal/GcRootProvider;", "", "graph", "Lshark/HeapGraph;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "(Lshark/HeapGraph;Ljava/util/List;)V", "jniGlobalReferenceMatchers", "", "", "provideGcRoots", "Lkotlin/sequences/Sequence;", "Lshark/internal/GcRootProvider$GcRootReference;", "sortedGcRoots", "Lkotlin/Pair;", "Lshark/HeapObject;", "Lshark/GcRoot;", "GcRootReference", "shark"}, k = 1, mv = {1, 4, 1})
public final class GcRootProvider {
    private final HeapGraph graph;
    private final Map<String, ReferenceMatcher> jniGlobalReferenceMatchers;

    public GcRootProvider(HeapGraph graph, List<? extends ReferenceMatcher> list) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        this.graph = graph;
        Map jniGlobals = new LinkedHashMap();
        Iterable $this$forEach$iv = ReferenceMatcherKt.filterFor(list, this.graph);
        for (Object element$iv : $this$forEach$iv) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) element$iv;
            ReferencePattern pattern = referenceMatcher.getPattern();
            if (pattern instanceof ReferencePattern.NativeGlobalVariablePattern) {
                jniGlobals.put(((ReferencePattern.NativeGlobalVariablePattern) pattern).getClassName(), referenceMatcher);
            }
        }
        this.jniGlobalReferenceMatchers = jniGlobals;
    }

    /* compiled from: GcRootProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lshark/internal/GcRootProvider$GcRootReference;", "", "gcRoot", "Lshark/GcRoot;", "isLowPriority", "", "matchedLibraryLeak", "Lshark/LibraryLeakReferenceMatcher;", "(Lshark/GcRoot;ZLshark/LibraryLeakReferenceMatcher;)V", "getGcRoot", "()Lshark/GcRoot;", "()Z", "getMatchedLibraryLeak", "()Lshark/LibraryLeakReferenceMatcher;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class GcRootReference {
        private final GcRoot gcRoot;
        private final boolean isLowPriority;
        private final LibraryLeakReferenceMatcher matchedLibraryLeak;

        public GcRootReference(GcRoot gcRoot, boolean isLowPriority, LibraryLeakReferenceMatcher matchedLibraryLeak) {
            Intrinsics.checkParameterIsNotNull(gcRoot, "gcRoot");
            this.gcRoot = gcRoot;
            this.isLowPriority = isLowPriority;
            this.matchedLibraryLeak = matchedLibraryLeak;
        }

        public final GcRoot getGcRoot() {
            return this.gcRoot;
        }

        public final boolean isLowPriority() {
            return this.isLowPriority;
        }

        public final LibraryLeakReferenceMatcher getMatchedLibraryLeak() {
            return this.matchedLibraryLeak;
        }
    }

    public final Sequence<GcRootReference> provideGcRoots() {
        return SequencesKt.mapNotNull(CollectionsKt.asSequence(sortedGcRoots()), new Function1<Pair<? extends HeapObject, ? extends GcRoot>, GcRootReference>() { // from class: shark.internal.GcRootProvider$provideGcRoots$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final GcRootProvider.GcRootReference invoke(Pair<? extends HeapObject, ? extends GcRoot> pair) {
                Map map;
                ReferenceMatcher referenceMatcher;
                Map map2;
                Map map3;
                Map map4;
                Intrinsics.checkParameterIsNotNull(pair, "<name for destructuring parameter 0>");
                HeapObject heapObject = (HeapObject) pair.component1();
                GcRoot gcRoot = (GcRoot) pair.component2();
                if (gcRoot instanceof GcRoot.JavaFrame) {
                    return new GcRootProvider.GcRootReference(gcRoot, true, null);
                }
                if (gcRoot instanceof GcRoot.JniGlobal) {
                    if (heapObject instanceof HeapObject.HeapClass) {
                        map4 = GcRootProvider.this.jniGlobalReferenceMatchers;
                        referenceMatcher = (ReferenceMatcher) map4.get(((HeapObject.HeapClass) heapObject).getName());
                    } else if (heapObject instanceof HeapObject.HeapInstance) {
                        map3 = GcRootProvider.this.jniGlobalReferenceMatchers;
                        referenceMatcher = (ReferenceMatcher) map3.get(((HeapObject.HeapInstance) heapObject).getInstanceClassName());
                    } else if (heapObject instanceof HeapObject.HeapObjectArray) {
                        map2 = GcRootProvider.this.jniGlobalReferenceMatchers;
                        referenceMatcher = (ReferenceMatcher) map2.get(((HeapObject.HeapObjectArray) heapObject).getArrayClassName());
                    } else if (heapObject instanceof HeapObject.HeapPrimitiveArray) {
                        map = GcRootProvider.this.jniGlobalReferenceMatchers;
                        referenceMatcher = (ReferenceMatcher) map.get(((HeapObject.HeapPrimitiveArray) heapObject).getArrayClassName());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (referenceMatcher instanceof IgnoredReferenceMatcher) {
                        return null;
                    }
                    if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                        return new GcRootProvider.GcRootReference(gcRoot, true, (LibraryLeakReferenceMatcher) referenceMatcher);
                    }
                    return new GcRootProvider.GcRootReference(gcRoot, false, null);
                }
                return new GcRootProvider.GcRootReference(gcRoot, false, null);
            }
        });
    }

    private final List<Pair<HeapObject, GcRoot>> sortedGcRoots() {
        final Function1 rootClassName = new Function1<HeapObject, String>() { // from class: shark.internal.GcRootProvider$sortedGcRoots$rootClassName$1
            public final String invoke(HeapObject graphObject) {
                Intrinsics.checkParameterIsNotNull(graphObject, "graphObject");
                if (graphObject instanceof HeapObject.HeapClass) {
                    return ((HeapObject.HeapClass) graphObject).getName();
                }
                if (graphObject instanceof HeapObject.HeapInstance) {
                    return ((HeapObject.HeapInstance) graphObject).getInstanceClassName();
                }
                if (graphObject instanceof HeapObject.HeapObjectArray) {
                    return ((HeapObject.HeapObjectArray) graphObject).getArrayClassName();
                }
                if (graphObject instanceof HeapObject.HeapPrimitiveArray) {
                    return ((HeapObject.HeapPrimitiveArray) graphObject).getArrayClassName();
                }
                throw new NoWhenBranchMatchedException();
            }
        };
        Iterable $this$map$iv = ThreadObjects.INSTANCE.getThreadObjects(this.graph);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(Integer.valueOf(((GcRoot.ThreadObject) item$iv$iv).getThreadSerialNumber()));
        }
        Set threadSerialNumbers = CollectionsKt.toSet((List) destination$iv$iv);
        Iterable $this$filter$iv = this.graph.getGcRoots();
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            GcRoot gcRoot = (GcRoot) element$iv$iv;
            if (this.graph.objectExists(gcRoot.getId()) && !((gcRoot instanceof GcRoot.JavaFrame) && threadSerialNumbers.contains(Integer.valueOf(((GcRoot.JavaFrame) gcRoot).getThreadSerialNumber())))) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$filter$iv2 = (List) destination$iv$iv2;
        Iterable $this$map$iv2 = $this$filter$iv2;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            GcRoot it = (GcRoot) item$iv$iv2;
            destination$iv$iv3.add(TuplesKt.to(this.graph.findObjectById(it.getId()), it));
        }
        return CollectionsKt.sortedWith((List) destination$iv$iv3, new Comparator<Pair<? extends HeapObject, ? extends GcRoot>>() { // from class: shark.internal.GcRootProvider$sortedGcRoots$3
            @Override // java.util.Comparator
            public final int compare(Pair<? extends HeapObject, ? extends GcRoot> pair, Pair<? extends HeapObject, ? extends GcRoot> pair2) {
                HeapObject graphObject1 = (HeapObject) pair.component1();
                GcRoot root1 = (GcRoot) pair.component2();
                HeapObject graphObject2 = (HeapObject) pair2.component1();
                GcRoot root2 = (GcRoot) pair2.component2();
                if ((root1 instanceof GcRoot.ThreadObject) && !(root2 instanceof GcRoot.ThreadObject)) {
                    return -1;
                }
                if (!(root1 instanceof GcRoot.ThreadObject) && (root2 instanceof GcRoot.ThreadObject)) {
                    return 1;
                }
                String name = root2.getClass().getName();
                String name2 = root1.getClass().getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "root1::class.java.name");
                int gcRootTypeComparison = name.compareTo(name2);
                if (gcRootTypeComparison != 0) {
                    return gcRootTypeComparison;
                }
                return ((String) rootClassName.invoke(graphObject1)).compareTo((String) rootClassName.invoke(graphObject2));
            }
        });
    }
}