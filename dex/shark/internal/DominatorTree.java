package shark.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.internal.DominatorTree;
import shark.internal.ObjectDominators;
import shark.internal.hppc.LongLongScatterMap;
import shark.internal.hppc.LongScatterSet;

/* compiled from: DominatorTree.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\fJ@\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e0\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lshark/internal/DominatorTree;", "", "expectedElements", "", "(I)V", "dominated", "Lshark/internal/hppc/LongLongScatterMap;", "buildFullDominatorTree", "", "", "Lshark/internal/ObjectDominators$DominatorNode;", "computeSize", "Lkotlin/Function1;", "computeRetainedSizes", "Lkotlin/Pair;", "retainedObjectIds", "", "updateDominated", "", "objectId", "parentObjectId", "updateDominatedAsRoot", "MutableDominatorNode", "shark"}, k = 1, mv = {1, 4, 1})
public final class DominatorTree {
    private final LongLongScatterMap dominated;

    public DominatorTree() {
        this(0, 1, null);
    }

    public DominatorTree(int expectedElements) {
        this.dominated = new LongLongScatterMap(expectedElements);
    }

    public /* synthetic */ DominatorTree(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 4 : i);
    }

    public final boolean updateDominatedAsRoot(long objectId) {
        return updateDominated(objectId, 0L);
    }

    public final boolean updateDominated(long objectId, long parentObjectId) {
        int dominatedSlot = this.dominated.getSlot(objectId);
        boolean hasDominator = dominatedSlot != -1;
        if (hasDominator) {
            if (parentObjectId != 0) {
                long currentDominator = this.dominated.getSlotValue(dominatedSlot);
                if (currentDominator != 0) {
                    LongScatterSet currentDominators = new LongScatterSet(0, 1, null);
                    long dominator = currentDominator;
                    for (long j = 0; dominator != j; j = 0) {
                        currentDominators.add(dominator);
                        int nextDominatorSlot = this.dominated.getSlot(dominator);
                        if (nextDominatorSlot == -1) {
                            throw new IllegalStateException("Did not find dominator for " + dominator + " when going through the dominator chain for " + currentDominator + ": " + currentDominators);
                        }
                        dominator = this.dominated.getSlotValue(nextDominatorSlot);
                    }
                    long dominator2 = parentObjectId;
                    while (dominator2 != 0 && !currentDominators.contains(dominator2)) {
                        int nextDominatorSlot2 = this.dominated.getSlot(dominator2);
                        if (nextDominatorSlot2 == -1) {
                            throw new IllegalStateException("Did not find dominator for " + dominator2 + " when going through the dominator chain for " + parentObjectId);
                        }
                        dominator2 = this.dominated.getSlotValue(nextDominatorSlot2);
                    }
                    this.dominated.set(objectId, dominator2);
                }
                return hasDominator;
            }
        }
        this.dominated.set(objectId, parentObjectId);
        return hasDominator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DominatorTree.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lshark/internal/DominatorTree$MutableDominatorNode;", "", "()V", "dominated", "", "", "getDominated", "()Ljava/util/List;", "retainedCount", "", "getRetainedCount", "()I", "setRetainedCount", "(I)V", "retainedSize", "getRetainedSize", "setRetainedSize", "shallowSize", "getShallowSize", "setShallowSize", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class MutableDominatorNode {
        private final List<Long> dominated = new ArrayList();
        private int retainedCount;
        private int retainedSize;
        private int shallowSize;

        public final int getShallowSize() {
            return this.shallowSize;
        }

        public final void setShallowSize(int i) {
            this.shallowSize = i;
        }

        public final int getRetainedSize() {
            return this.retainedSize;
        }

        public final void setRetainedSize(int i) {
            this.retainedSize = i;
        }

        public final int getRetainedCount() {
            return this.retainedCount;
        }

        public final void setRetainedCount(int i) {
            this.retainedCount = i;
        }

        public final List<Long> getDominated() {
            return this.dominated;
        }
    }

    public final Map<Long, ObjectDominators.DominatorNode> buildFullDominatorTree(final Function1<? super Long, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "computeSize");
        final Map dominators = new LinkedHashMap();
        this.dominated.forEach(new LongLongScatterMap.ForEachCallback() { // from class: shark.internal.DominatorTree$buildFullDominatorTree$1
            @Override // shark.internal.hppc.LongLongScatterMap.ForEachCallback
            public final void onEntry(long key, long value) {
                Map $this$getOrPut$iv = dominators;
                Long valueOf = Long.valueOf(key);
                if ($this$getOrPut$iv.get(valueOf) == null) {
                    $this$getOrPut$iv.put(valueOf, new DominatorTree.MutableDominatorNode());
                }
                Map $this$getOrPut$iv2 = dominators;
                Long valueOf2 = Long.valueOf(value);
                Object value$iv = $this$getOrPut$iv2.get(valueOf2);
                if (value$iv == null) {
                    DominatorTree.MutableDominatorNode mutableDominatorNode = new DominatorTree.MutableDominatorNode();
                    $this$getOrPut$iv2.put(valueOf2, mutableDominatorNode);
                    value$iv = mutableDominatorNode;
                }
                ((DominatorTree.MutableDominatorNode) value$iv).getDominated().add(Long.valueOf(key));
            }
        });
        long j = 0;
        Set allReachableObjectIds = SetsKt.minus(CollectionsKt.toSet(dominators.keySet()), 0L);
        Map retainedSizes = computeRetainedSizes(allReachableObjectIds, new Function1<Long, Integer>() { // from class: shark.internal.DominatorTree$buildFullDominatorTree$retainedSizes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Integer.valueOf(invoke(((Number) obj).longValue()));
            }

            public final int invoke(long objectId) {
                int shallowSize = ((Number) function1.invoke(Long.valueOf(objectId))).intValue();
                ((DominatorTree.MutableDominatorNode) MapsKt.getValue(dominators, Long.valueOf(objectId))).setShallowSize(shallowSize);
                return shallowSize;
            }
        });
        for (Map.Entry element$iv : dominators.entrySet()) {
            long objectId = ((Number) element$iv.getKey()).longValue();
            MutableDominatorNode node = (MutableDominatorNode) element$iv.getValue();
            if (objectId != j) {
                Pair pair = (Pair) MapsKt.getValue(retainedSizes, Long.valueOf(objectId));
                int retainedSize = ((Number) pair.component1()).intValue();
                int retainedCount = ((Number) pair.component2()).intValue();
                node.setRetainedSize(retainedSize);
                node.setRetainedCount(retainedCount);
            }
            j = 0;
        }
        MutableDominatorNode rootDominator = (MutableDominatorNode) MapsKt.getValue(dominators, 0L);
        Iterable $this$map$iv = rootDominator.getDominated();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            long it = ((Number) item$iv$iv).longValue();
            Object obj = dominators.get(Long.valueOf(it));
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            destination$iv$iv.add(Integer.valueOf(((MutableDominatorNode) obj).getRetainedSize()));
        }
        rootDominator.setRetainedSize(CollectionsKt.sumOfInt((List) destination$iv$iv));
        Iterable $this$map$iv2 = rootDominator.getDominated();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            long it2 = ((Number) item$iv$iv2).longValue();
            Object obj2 = dominators.get(Long.valueOf(it2));
            if (obj2 == null) {
                Intrinsics.throwNpe();
            }
            destination$iv$iv2.add(Integer.valueOf(((MutableDominatorNode) obj2).getRetainedCount()));
        }
        rootDominator.setRetainedCount(CollectionsKt.sumOfInt((List) destination$iv$iv2));
        Iterable<MutableDominatorNode> $this$forEach$iv = dominators.values();
        for (MutableDominatorNode node2 : $this$forEach$iv) {
            List $this$sortBy$iv = node2.getDominated();
            if ($this$sortBy$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv, new Comparator<T>() { // from class: shark.internal.DominatorTree$buildFullDominatorTree$$inlined$forEach$lambda$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        long it3 = ((Number) t).longValue();
                        long it4 = ((Number) t2).longValue();
                        return ComparisonsKt.compareValues(Integer.valueOf(-((DominatorTree.MutableDominatorNode) MapsKt.getValue(dominators, Long.valueOf(it3))).getRetainedSize()), Integer.valueOf(-((DominatorTree.MutableDominatorNode) MapsKt.getValue(dominators, Long.valueOf(it4))).getRetainedSize()));
                    }
                });
            }
        }
        Map $this$mapValues$iv = dominators;
        Map destination$iv$iv3 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            Map.Entry $dstr$_u24__u24$node = (Map.Entry) element$iv$iv$iv;
            MutableDominatorNode node3 = (MutableDominatorNode) $dstr$_u24__u24$node.getValue();
            destination$iv$iv3.put(key, new ObjectDominators.DominatorNode(node3.getShallowSize(), node3.getRetainedSize(), node3.getRetainedCount(), node3.getDominated()));
            rootDominator = rootDominator;
            dominators = dominators;
            allReachableObjectIds = allReachableObjectIds;
            $this$mapValues$iv = $this$mapValues$iv;
        }
        return destination$iv$iv3;
    }

    public final Map<Long, Pair<Integer, Integer>> computeRetainedSizes(Set<Long> set, final Function1<? super Long, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(set, "retainedObjectIds");
        Intrinsics.checkParameterIsNotNull(function1, "computeSize");
        final Map nodeRetainedSizes = new LinkedHashMap();
        Set<Long> $this$forEach$iv = set;
        for (Object element$iv : $this$forEach$iv) {
            long objectId = ((Number) element$iv).longValue();
            nodeRetainedSizes.put(Long.valueOf(objectId), TuplesKt.to(0, 0));
        }
        this.dominated.forEach(new LongLongScatterMap.ForEachCallback() { // from class: shark.internal.DominatorTree$computeRetainedSizes$2
            @Override // shark.internal.hppc.LongLongScatterMap.ForEachCallback
            public void onEntry(long key, long value) {
                LongLongScatterMap longLongScatterMap;
                LongLongScatterMap longLongScatterMap2;
                LongLongScatterMap longLongScatterMap3;
                int instanceSize = -1;
                Pair $dstr$currentRetainedSize$currentRetainedCount = (Pair) nodeRetainedSizes.get(Long.valueOf(key));
                if ($dstr$currentRetainedSize$currentRetainedCount != null) {
                    int currentRetainedSize = ((Number) $dstr$currentRetainedSize$currentRetainedCount.component1()).intValue();
                    int currentRetainedCount = ((Number) $dstr$currentRetainedSize$currentRetainedCount.component2()).intValue();
                    instanceSize = ((Number) function1.invoke(Long.valueOf(key))).intValue();
                    nodeRetainedSizes.put(Long.valueOf(key), TuplesKt.to(Integer.valueOf(currentRetainedSize + instanceSize), Integer.valueOf(currentRetainedCount + 1)));
                }
                if (value != 0) {
                    long dominator = value;
                    List dominatedByNextNode = CollectionsKt.mutableListOf(new Long[]{Long.valueOf(key)});
                    while (dominator != 0) {
                        if (nodeRetainedSizes.containsKey(Long.valueOf(dominator))) {
                            List $this$forEach$iv2 = dominatedByNextNode;
                            for (Object element$iv2 : $this$forEach$iv2) {
                                long objectId2 = ((Number) element$iv2).longValue();
                                longLongScatterMap3 = DominatorTree.this.dominated;
                                longLongScatterMap3.set(objectId2, dominator);
                            }
                            if (instanceSize == -1) {
                                instanceSize = ((Number) function1.invoke(Long.valueOf(key))).intValue();
                            }
                            Pair pair = (Pair) MapsKt.getValue(nodeRetainedSizes, Long.valueOf(dominator));
                            int currentRetainedSize2 = ((Number) pair.component1()).intValue();
                            int currentRetainedCount2 = ((Number) pair.component2()).intValue();
                            nodeRetainedSizes.put(Long.valueOf(dominator), TuplesKt.to(Integer.valueOf(currentRetainedSize2 + instanceSize), Integer.valueOf(currentRetainedCount2 + 1)));
                            dominatedByNextNode.clear();
                        } else {
                            dominatedByNextNode.add(Long.valueOf(dominator));
                        }
                        longLongScatterMap2 = DominatorTree.this.dominated;
                        dominator = longLongScatterMap2.get(dominator);
                    }
                    List $this$forEach$iv3 = dominatedByNextNode;
                    for (Object element$iv3 : $this$forEach$iv3) {
                        long objectId3 = ((Number) element$iv3).longValue();
                        longLongScatterMap = DominatorTree.this.dominated;
                        longLongScatterMap.set(objectId3, 0L);
                    }
                }
            }
        });
        this.dominated.release();
        return nodeRetainedSizes;
    }
}