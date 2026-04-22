package shark.internal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import shark.HeapGraph;
import shark.HeapObject;
import shark.LibraryLeakReferenceMatcher;
import shark.OnAnalysisProgressListener;
import shark.ReferenceMatcher;
import shark.internal.GcRootProvider;
import shark.internal.ReferencePathNode;
import shark.internal.hppc.LongScatterSet;

/* compiled from: PathFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0003 !\"B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\f\u0010\u001c\u001a\u00020\u0017*\u00020\u0018H\u0002J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0018H\u0002J\f\u0010\u001d\u001a\u00020\u001a*\u00020\u0018H\u0002J\u0012\u0010\u001e\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lshark/internal/PathFinder;", "", "graph", "Lshark/HeapGraph;", "listener", "Lshark/OnAnalysisProgressListener;", "objectReferenceReader", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "(Lshark/HeapGraph;Lshark/OnAnalysisProgressListener;Lshark/internal/ReferenceReader;Ljava/util/List;)V", "gcRootProvider", "Lshark/internal/GcRootProvider;", "findPathsFromGcRoots", "Lshark/internal/PathFinder$PathFindingResults;", "leakingObjectIds", "", "", "computeRetainedHeapSize", "", "enqueue", "", "Lshark/internal/PathFinder$State;", "node", "Lshark/internal/ReferencePathNode;", "isLowPriority", "enqueueGcRoots", "poll", "toLongScatterSet", "Lshark/internal/hppc/LongScatterSet;", "PathFindingResults", "State", "VisitTracker", "shark"}, k = 1, mv = {1, 4, 1})
public final class PathFinder {
    private final GcRootProvider gcRootProvider;
    private final HeapGraph graph;
    private final OnAnalysisProgressListener listener;
    private final ReferenceReader<HeapObject> objectReferenceReader;

    public PathFinder(HeapGraph graph, OnAnalysisProgressListener listener, ReferenceReader<HeapObject> referenceReader, List<? extends ReferenceMatcher> list) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        Intrinsics.checkParameterIsNotNull(referenceReader, "objectReferenceReader");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        this.graph = graph;
        this.listener = listener;
        this.objectReferenceReader = referenceReader;
        this.gcRootProvider = new GcRootProvider(this.graph, list);
    }

    /* compiled from: PathFinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lshark/internal/PathFinder$PathFindingResults;", "", "pathsToLeakingObjects", "", "Lshark/internal/ReferencePathNode;", "dominatorTree", "Lshark/internal/DominatorTree;", "(Ljava/util/List;Lshark/internal/DominatorTree;)V", "getDominatorTree", "()Lshark/internal/DominatorTree;", "getPathsToLeakingObjects", "()Ljava/util/List;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PathFindingResults {
        private final DominatorTree dominatorTree;
        private final List<ReferencePathNode> pathsToLeakingObjects;

        /* JADX WARN: Multi-variable type inference failed */
        public PathFindingResults(List<? extends ReferencePathNode> list, DominatorTree dominatorTree) {
            Intrinsics.checkParameterIsNotNull(list, "pathsToLeakingObjects");
            this.pathsToLeakingObjects = list;
            this.dominatorTree = dominatorTree;
        }

        public final List<ReferencePathNode> getPathsToLeakingObjects() {
            return this.pathsToLeakingObjects;
        }

        public final DominatorTree getDominatorTree() {
            return this.dominatorTree;
        }
    }

    /* compiled from: PathFinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lshark/internal/PathFinder$VisitTracker;", "", "()V", "visited", "", "objectId", "", "parentObjectId", "Dominated", "Visited", "Lshark/internal/PathFinder$VisitTracker$Dominated;", "Lshark/internal/PathFinder$VisitTracker$Visited;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class VisitTracker {
        public abstract boolean visited(long j, long j2);

        private VisitTracker() {
        }

        public /* synthetic */ VisitTracker(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* compiled from: PathFinder.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lshark/internal/PathFinder$VisitTracker$Dominated;", "Lshark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "dominatorTree", "Lshark/internal/DominatorTree;", "getDominatorTree", "()Lshark/internal/DominatorTree;", "visited", "", "objectId", "", "parentObjectId", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Dominated extends VisitTracker {
            private final DominatorTree dominatorTree;

            public Dominated(int expectedElements) {
                super(null);
                this.dominatorTree = new DominatorTree(expectedElements);
            }

            public final DominatorTree getDominatorTree() {
                return this.dominatorTree;
            }

            @Override // shark.internal.PathFinder.VisitTracker
            public boolean visited(long objectId, long parentObjectId) {
                return this.dominatorTree.updateDominated(objectId, parentObjectId);
            }
        }

        /* compiled from: PathFinder.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lshark/internal/PathFinder$VisitTracker$Visited;", "Lshark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "visitedSet", "Lshark/internal/hppc/LongScatterSet;", "visited", "", "objectId", "", "parentObjectId", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Visited extends VisitTracker {
            private final LongScatterSet visitedSet;

            public Visited(int expectedElements) {
                super(null);
                this.visitedSet = new LongScatterSet(expectedElements);
            }

            @Override // shark.internal.PathFinder.VisitTracker
            public boolean visited(long objectId, long parentObjectId) {
                return !this.visitedSet.add(objectId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PathFinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lshark/internal/PathFinder$State;", "", "leakingObjectIds", "Lshark/internal/hppc/LongScatterSet;", "computeRetainedHeapSize", "", "estimatedVisitedObjects", "", "(Lshark/internal/hppc/LongScatterSet;ZI)V", "getComputeRetainedHeapSize", "()Z", "getLeakingObjectIds", "()Lshark/internal/hppc/LongScatterSet;", "queuesNotEmpty", "getQueuesNotEmpty", "toVisitLastQueue", "Ljava/util/Deque;", "Lshark/internal/ReferencePathNode;", "getToVisitLastQueue", "()Ljava/util/Deque;", "toVisitLastSet", "getToVisitLastSet", "toVisitQueue", "getToVisitQueue", "toVisitSet", "getToVisitSet", "visitTracker", "Lshark/internal/PathFinder$VisitTracker;", "getVisitTracker", "()Lshark/internal/PathFinder$VisitTracker;", "visitingLast", "getVisitingLast", "setVisitingLast", "(Z)V", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class State {
        private final boolean computeRetainedHeapSize;
        private final LongScatterSet leakingObjectIds;
        private final Deque<ReferencePathNode> toVisitLastQueue;
        private final LongScatterSet toVisitLastSet;
        private final Deque<ReferencePathNode> toVisitQueue;
        private final LongScatterSet toVisitSet;
        private final VisitTracker visitTracker;
        private boolean visitingLast;

        public State(LongScatterSet leakingObjectIds, boolean computeRetainedHeapSize, int estimatedVisitedObjects) {
            VisitTracker.Visited visited;
            Intrinsics.checkParameterIsNotNull(leakingObjectIds, "leakingObjectIds");
            this.leakingObjectIds = leakingObjectIds;
            this.computeRetainedHeapSize = computeRetainedHeapSize;
            this.toVisitQueue = new ArrayDeque();
            this.toVisitLastQueue = new ArrayDeque();
            this.toVisitSet = new LongScatterSet(0, 1, null);
            this.toVisitLastSet = new LongScatterSet(0, 1, null);
            if (this.computeRetainedHeapSize) {
                visited = new VisitTracker.Dominated(estimatedVisitedObjects);
            } else {
                visited = new VisitTracker.Visited(estimatedVisitedObjects);
            }
            this.visitTracker = visited;
        }

        public final LongScatterSet getLeakingObjectIds() {
            return this.leakingObjectIds;
        }

        public final boolean getComputeRetainedHeapSize() {
            return this.computeRetainedHeapSize;
        }

        public final Deque<ReferencePathNode> getToVisitQueue() {
            return this.toVisitQueue;
        }

        public final Deque<ReferencePathNode> getToVisitLastQueue() {
            return this.toVisitLastQueue;
        }

        public final LongScatterSet getToVisitSet() {
            return this.toVisitSet;
        }

        public final LongScatterSet getToVisitLastSet() {
            return this.toVisitLastSet;
        }

        public final boolean getQueuesNotEmpty() {
            return (this.toVisitQueue.isEmpty() && this.toVisitLastQueue.isEmpty()) ? false : true;
        }

        public final VisitTracker getVisitTracker() {
            return this.visitTracker;
        }

        public final boolean getVisitingLast() {
            return this.visitingLast;
        }

        public final void setVisitingLast(boolean z) {
            this.visitingLast = z;
        }
    }

    public final PathFindingResults findPathsFromGcRoots(Set<Long> set, boolean computeRetainedHeapSize) {
        Intrinsics.checkParameterIsNotNull(set, "leakingObjectIds");
        this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.FINDING_PATHS_TO_RETAINED_OBJECTS);
        int estimatedVisitedObjects = RangesKt.coerceAtLeast(this.graph.getInstanceCount() / 2, 4);
        State state = new State(toLongScatterSet(set), computeRetainedHeapSize, estimatedVisitedObjects);
        return findPathsFromGcRoots(state);
    }

    private final LongScatterSet toLongScatterSet(Set<Long> set) {
        LongScatterSet longScatterSet = new LongScatterSet(0, 1, null);
        longScatterSet.ensureCapacity(set.size());
        Set<Long> $this$forEach$iv = set;
        for (Object element$iv : $this$forEach$iv) {
            long it = ((Number) element$iv).longValue();
            longScatterSet.add(it);
        }
        return longScatterSet;
    }

    private final PathFindingResults findPathsFromGcRoots(State $this$findPathsFromGcRoots) {
        enqueueGcRoots($this$findPathsFromGcRoots);
        List shortestPathsToLeakingObjects = new ArrayList();
        while ($this$findPathsFromGcRoots.getQueuesNotEmpty()) {
            ReferencePathNode node = poll($this$findPathsFromGcRoots);
            if ($this$findPathsFromGcRoots.getLeakingObjectIds().contains(node.getObjectId())) {
                shortestPathsToLeakingObjects.add(node);
                if (shortestPathsToLeakingObjects.size() == $this$findPathsFromGcRoots.getLeakingObjectIds().size()) {
                    if (!$this$findPathsFromGcRoots.getComputeRetainedHeapSize()) {
                        break;
                    }
                    this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.FINDING_DOMINATORS);
                }
            }
            HeapObject heapObject = this.graph.findObjectById(node.getObjectId());
            Sequence $this$forEach$iv = this.objectReferenceReader.read(heapObject);
            for (Object element$iv : $this$forEach$iv) {
                Reference reference = (Reference) element$iv;
                ReferencePathNode.ChildNode newNode = new ReferencePathNode.ChildNode(reference.getValueObjectId(), node, reference.getLazyDetailsResolver());
                enqueue($this$findPathsFromGcRoots, newNode, reference.isLowPriority());
            }
        }
        return new PathFindingResults(shortestPathsToLeakingObjects, $this$findPathsFromGcRoots.getVisitTracker() instanceof VisitTracker.Dominated ? ((VisitTracker.Dominated) $this$findPathsFromGcRoots.getVisitTracker()).getDominatorTree() : null);
    }

    private final ReferencePathNode poll(State $this$poll) {
        if (!$this$poll.getVisitingLast() && !$this$poll.getToVisitQueue().isEmpty()) {
            ReferencePathNode removedNode = $this$poll.getToVisitQueue().poll();
            $this$poll.getToVisitSet().remove(removedNode.getObjectId());
            Intrinsics.checkExpressionValueIsNotNull(removedNode, "removedNode");
            return removedNode;
        }
        $this$poll.setVisitingLast(true);
        ReferencePathNode removedNode2 = $this$poll.getToVisitLastQueue().poll();
        $this$poll.getToVisitLastSet().remove(removedNode2.getObjectId());
        Intrinsics.checkExpressionValueIsNotNull(removedNode2, "removedNode");
        return removedNode2;
    }

    private final void enqueueGcRoots(State $this$enqueueGcRoots) {
        ReferencePathNode.RootNode normalRootNode;
        Sequence $this$forEach$iv = this.gcRootProvider.provideGcRoots();
        for (Object element$iv : $this$forEach$iv) {
            GcRootProvider.GcRootReference gcRootReference = (GcRootProvider.GcRootReference) element$iv;
            LibraryLeakReferenceMatcher matchedLibraryLeak = gcRootReference.getMatchedLibraryLeak();
            if (matchedLibraryLeak != null) {
                normalRootNode = new ReferencePathNode.RootNode.LibraryLeakRootNode(gcRootReference.getGcRoot(), matchedLibraryLeak);
            } else {
                normalRootNode = new ReferencePathNode.RootNode.NormalRootNode(gcRootReference.getGcRoot());
            }
            enqueue($this$enqueueGcRoots, normalRootNode, gcRootReference.isLowPriority());
        }
    }

    private final void enqueue(State $this$enqueue, ReferencePathNode node, boolean isLowPriority) {
        ReferencePathNode it;
        long j = 0;
        if (node.getObjectId() == 0) {
            return;
        }
        if (!(node instanceof ReferencePathNode.RootNode)) {
            if (node instanceof ReferencePathNode.ChildNode) {
                j = ((ReferencePathNode.ChildNode) node).getParent().getObjectId();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        long parentObjectId = j;
        boolean alreadyEnqueued = $this$enqueue.getVisitTracker().visited(node.getObjectId(), parentObjectId);
        boolean visitLast = $this$enqueue.getVisitingLast() || isLowPriority;
        if (alreadyEnqueued) {
            boolean bumpPriority = (visitLast || $this$enqueue.getToVisitSet().contains(node.getObjectId()) || !$this$enqueue.getToVisitLastSet().contains(node.getObjectId())) ? false : true;
            if (bumpPriority) {
                $this$enqueue.getToVisitQueue().add(node);
                $this$enqueue.getToVisitSet().add(node.getObjectId());
                Iterable $this$first$iv = $this$enqueue.getToVisitLastQueue();
                for (Object element$iv : $this$first$iv) {
                    ReferencePathNode it2 = (ReferencePathNode) element$iv;
                    if (it2.getObjectId() == node.getObjectId()) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        ReferencePathNode nodeToRemove = (ReferencePathNode) element$iv;
                        $this$enqueue.getToVisitLastQueue().remove(nodeToRemove);
                        $this$enqueue.getToVisitLastSet().remove(node.getObjectId());
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        } else if (visitLast) {
            $this$enqueue.getToVisitLastQueue().add(node);
            $this$enqueue.getToVisitLastSet().add(node.getObjectId());
        } else {
            $this$enqueue.getToVisitQueue().add(node);
            $this$enqueue.getToVisitSet().add(node.getObjectId());
        }
    }
}