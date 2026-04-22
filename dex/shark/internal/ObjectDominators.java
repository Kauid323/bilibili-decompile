package shark.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import shark.GcRoot;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.IgnoredReferenceMatcher;
import shark.OnAnalysisProgressListener;
import shark.internal.PathFinder;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: ObjectDominators.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J`\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J:\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019¨\u0006\u001f"}, d2 = {"Lshark/internal/ObjectDominators;", "", "()V", "buildDominatorTree", "", "", "Lshark/internal/ObjectDominators$DominatorNode;", "graph", "Lshark/HeapGraph;", "ignoredRefs", "", "Lshark/IgnoredReferenceMatcher;", "printTree", "", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tree", "objectId", "minSize", "", "depth", "prefix", "", "isLast", "", "printStringContent", "renderDominatorTree", "minRetainedSize", "threadName", "DominatorNode", "shark"}, k = 1, mv = {1, 4, 1})
public final class ObjectDominators {

    /* compiled from: ObjectDominators.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lshark/internal/ObjectDominators$DominatorNode;", "", "shallowSize", "", "retainedSize", "retainedCount", "dominatedObjectIds", "", "", "(IIILjava/util/List;)V", "getDominatedObjectIds", "()Ljava/util/List;", "getRetainedCount", "()I", "getRetainedSize", "getShallowSize", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DominatorNode {
        private final List<Long> dominatedObjectIds;
        private final int retainedCount;
        private final int retainedSize;
        private final int shallowSize;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DominatorNode copy$default(DominatorNode dominatorNode, int i, int i2, int i3, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = dominatorNode.shallowSize;
            }
            if ((i4 & 2) != 0) {
                i2 = dominatorNode.retainedSize;
            }
            if ((i4 & 4) != 0) {
                i3 = dominatorNode.retainedCount;
            }
            if ((i4 & 8) != 0) {
                list = dominatorNode.dominatedObjectIds;
            }
            return dominatorNode.copy(i, i2, i3, list);
        }

        public final int component1() {
            return this.shallowSize;
        }

        public final int component2() {
            return this.retainedSize;
        }

        public final int component3() {
            return this.retainedCount;
        }

        public final List<Long> component4() {
            return this.dominatedObjectIds;
        }

        public final DominatorNode copy(int i, int i2, int i3, List<Long> list) {
            Intrinsics.checkParameterIsNotNull(list, "dominatedObjectIds");
            return new DominatorNode(i, i2, i3, list);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof DominatorNode) {
                    DominatorNode dominatorNode = (DominatorNode) obj;
                    return this.shallowSize == dominatorNode.shallowSize && this.retainedSize == dominatorNode.retainedSize && this.retainedCount == dominatorNode.retainedCount && Intrinsics.areEqual(this.dominatedObjectIds, dominatorNode.dominatedObjectIds);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = ((((this.shallowSize * 31) + this.retainedSize) * 31) + this.retainedCount) * 31;
            List<Long> list = this.dominatedObjectIds;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "DominatorNode(shallowSize=" + this.shallowSize + ", retainedSize=" + this.retainedSize + ", retainedCount=" + this.retainedCount + ", dominatedObjectIds=" + this.dominatedObjectIds + ")";
        }

        public DominatorNode(int shallowSize, int retainedSize, int retainedCount, List<Long> list) {
            Intrinsics.checkParameterIsNotNull(list, "dominatedObjectIds");
            this.shallowSize = shallowSize;
            this.retainedSize = retainedSize;
            this.retainedCount = retainedCount;
            this.dominatedObjectIds = list;
        }

        public final int getShallowSize() {
            return this.shallowSize;
        }

        public final int getRetainedSize() {
            return this.retainedSize;
        }

        public final int getRetainedCount() {
            return this.retainedCount;
        }

        public final List<Long> getDominatedObjectIds() {
            return this.dominatedObjectIds;
        }
    }

    public static /* synthetic */ String renderDominatorTree$default(ObjectDominators objectDominators, HeapGraph heapGraph, List list, int i, String str, boolean z, int i2, Object obj) {
        boolean z2;
        String str2 = (i2 & 8) != 0 ? null : str;
        if ((i2 & 16) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return objectDominators.renderDominatorTree(heapGraph, list, i, str2, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String renderDominatorTree(HeapGraph graph, List<IgnoredReferenceMatcher> list, int minRetainedSize, String threadName, boolean printStringContent) {
        Collection collection;
        boolean z;
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(list, "ignoredRefs");
        StringBuilder stringBuilder = new StringBuilder();
        Map dominatorTree = buildDominatorTree(graph, list);
        DominatorNode root = (DominatorNode) MapsKt.getValue(dominatorTree, 0L);
        stringBuilder.append("Total retained: " + root.getRetainedSize() + " bytes in " + root.getRetainedCount() + " objects. Root dominators: " + root.getDominatedObjectIds().size() + "\n\n");
        if (threadName != null) {
            Iterable $this$first$iv = graph.getGcRoots();
            for (Object element$iv : $this$first$iv) {
                GcRoot gcRoot = (GcRoot) element$iv;
                if ((gcRoot instanceof GcRoot.ThreadObject) && graph.objectExists(gcRoot.getId())) {
                    HeapObject.HeapInstance asInstance = graph.findObjectById(gcRoot.getId()).getAsInstance();
                    if (asInstance == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapField heapField = asInstance.get("java.lang.Thread", ChannelRoutes.CHANNEL_NAME);
                    if (heapField == null) {
                        Intrinsics.throwNpe();
                    }
                    if (Intrinsics.areEqual(heapField.getValue().readAsJavaString(), threadName)) {
                        z = true;
                        continue;
                        if (z) {
                            collection = SetsKt.setOf(Long.valueOf(((GcRoot) element$iv).getId()));
                        }
                    }
                }
                z = false;
                continue;
                if (z) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        Iterable $this$first$iv2 = root.getDominatedObjectIds();
        Iterable $this$filter$iv = $this$first$iv2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            long it = ((Number) element$iv$iv).longValue();
            if (((DominatorNode) MapsKt.getValue(dominatorTree, Long.valueOf(it))).getRetainedSize() > minRetainedSize) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        collection = (List) destination$iv$iv;
        Collection rootIds = collection;
        Collection<Number> $this$forEach$iv = rootIds;
        for (Number number : $this$forEach$iv) {
            long objectId = number.longValue();
            printTree(stringBuilder, graph, dominatorTree, objectId, minRetainedSize, 0, "", true, printStringContent);
            stringBuilder.append("\n");
        }
        String sb = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "stringBuilder.toString()");
        return sb;
    }

    private final void printTree(StringBuilder stringBuilder, HeapGraph graph, Map<Long, DominatorNode> map, long objectId, int minSize, int depth, String prefix, boolean isLast, boolean printStringContent) {
        String arrayClassName;
        String str;
        String str2;
        String str3;
        String str4;
        Map<Long, DominatorNode> map2 = map;
        DominatorNode node = (DominatorNode) MapsKt.getValue(map2, Long.valueOf(objectId));
        HeapObject heapObject = graph.findObjectById(objectId);
        if (heapObject instanceof HeapObject.HeapClass) {
            arrayClassName = "class " + ((HeapObject.HeapClass) heapObject).getName();
        } else if (heapObject instanceof HeapObject.HeapInstance) {
            arrayClassName = ((HeapObject.HeapInstance) heapObject).getInstanceClassName();
        } else if (heapObject instanceof HeapObject.HeapObjectArray) {
            arrayClassName = ((HeapObject.HeapObjectArray) heapObject).getArrayClassName();
        } else if (!(heapObject instanceof HeapObject.HeapPrimitiveArray)) {
            throw new NoWhenBranchMatchedException();
        } else {
            arrayClassName = ((HeapObject.HeapPrimitiveArray) heapObject).getArrayClassName();
        }
        String className = arrayClassName;
        String str5 = "";
        if (depth == 0) {
            str = "";
        } else {
            str = isLast ? "╰─" : "├─";
        }
        String anchor = str;
        if (node.getRetainedSize() != node.getShallowSize()) {
            str2 = node.getRetainedSize() + " bytes (" + node.getShallowSize() + " self)";
        } else {
            str2 = node.getShallowSize() + " bytes";
        }
        String size = str2;
        if (node.getRetainedCount() <= 1) {
            str3 = "";
        } else {
            str3 = ' ' + node.getRetainedCount() + " objects";
        }
        String count = str3;
        if (!printStringContent || !(heapObject instanceof HeapObject.HeapInstance) || !Intrinsics.areEqual(((HeapObject.HeapInstance) heapObject).getInstanceClassName(), "java.lang.String")) {
            str4 = "";
        } else {
            str4 = " \"" + ((HeapObject.HeapInstance) heapObject).readAsJavaString() + '\"';
        }
        String stringContent = str4;
        stringBuilder.append(prefix + anchor + className + " #" + heapObject.getObjectIndex() + " Retained: " + size + count + stringContent + '\n');
        if (depth != 0) {
            if (isLast) {
                str5 = prefix + "  ";
            } else {
                str5 = prefix + "│ ";
            }
        }
        String newPrefix = str5;
        Iterable $this$filter$iv = node.getDominatedObjectIds();
        Collection destination$iv$iv = new ArrayList();
        Iterator<T> it = $this$filter$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Iterable $this$filter$iv2 = $this$filter$iv;
            Object element$iv$iv = it.next();
            long it2 = ((Number) element$iv$iv).longValue();
            String stringContent2 = stringContent;
            if (((DominatorNode) MapsKt.getValue(map2, Long.valueOf(it2))).getRetainedSize() > minSize) {
                destination$iv$iv.add(element$iv$iv);
            }
            map2 = map;
            $this$filter$iv = $this$filter$iv2;
            stringContent = stringContent2;
        }
        List largeChildren = (List) destination$iv$iv;
        int lastIndex = CollectionsKt.getLastIndex(node.getDominatedObjectIds());
        List $this$forEachIndexed$iv = largeChildren;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int index = index$iv;
            String newPrefix2 = newPrefix;
            printTree(stringBuilder, graph, map, ((Number) item$iv).longValue(), minSize, depth + 1, newPrefix2, index == lastIndex, printStringContent);
            size = size;
            index$iv = index$iv2;
            heapObject = heapObject;
            lastIndex = lastIndex;
            count = count;
            newPrefix = newPrefix2;
            anchor = anchor;
            className = className;
        }
        String newPrefix3 = newPrefix;
        int index$iv3 = largeChildren.size();
        if (index$iv3 < node.getDominatedObjectIds().size()) {
            stringBuilder.append(newPrefix3 + "╰┄\n");
        }
    }

    private final Map<Long, DominatorNode> buildDominatorTree(HeapGraph graph, List<IgnoredReferenceMatcher> list) {
        DelegatingObjectReferenceReader referenceReader = new DelegatingObjectReferenceReader(new ClassReferenceReader(graph, CollectionsKt.emptyList()), new ChainingInstanceReferenceReader(CollectionsKt.listOf(new JavaLocalReferenceReader(graph, CollectionsKt.emptyList())), new FieldInstanceReferenceReader(graph, CollectionsKt.emptyList())), new ObjectArrayReferenceReader());
        PathFinder pathFinder = new PathFinder(graph, OnAnalysisProgressListener.Companion.getNO_OP(), referenceReader, list);
        AndroidNativeSizeMapper nativeSizeMapper = new AndroidNativeSizeMapper(graph);
        final Map nativeSizes = nativeSizeMapper.mapNativeSizes();
        final ShallowSizeCalculator shallowSizeCalculator = new ShallowSizeCalculator(graph);
        PathFinder.PathFindingResults result = pathFinder.findPathsFromGcRoots(SetsKt.emptySet(), true);
        DominatorTree dominatorTree = result.getDominatorTree();
        if (dominatorTree == null) {
            Intrinsics.throwNpe();
        }
        return dominatorTree.buildFullDominatorTree(new Function1<Long, Integer>() { // from class: shark.internal.ObjectDominators$buildDominatorTree$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Integer.valueOf(invoke(((Number) obj).longValue()));
            }

            public final int invoke(long objectId) {
                Integer num = (Integer) nativeSizes.get(Long.valueOf(objectId));
                int nativeSize = num != null ? num.intValue() : 0;
                int shallowSize = shallowSizeCalculator.computeShallowSize(objectId);
                return nativeSize + shallowSize;
            }
        });
    }
}