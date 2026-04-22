package shark.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.GcRoot;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HeapValue;
import shark.IgnoredReferenceMatcher;
import shark.LibraryLeakReferenceMatcher;
import shark.ReferenceMatcher;
import shark.ReferenceMatcherKt;
import shark.ReferencePattern;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.Reference;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: JavaLocalReferenceReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lshark/internal/JavaLocalReferenceReader;", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader;", "graph", "Lshark/HeapGraph;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "(Lshark/HeapGraph;Ljava/util/List;)V", "getGraph", "()Lshark/HeapGraph;", "threadClassObjectIds", "", "", "threadNameReferenceMatchers", "", "", "matches", "", "instance", "Lshark/HeapObject$HeapInstance;", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "shark"}, k = 1, mv = {1, 4, 1})
public final class JavaLocalReferenceReader implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader {
    private final HeapGraph graph;
    private final Set<Long> threadClassObjectIds;
    private final Map<String, ReferenceMatcher> threadNameReferenceMatchers;

    public JavaLocalReferenceReader(HeapGraph graph, List<? extends ReferenceMatcher> list) {
        Set<Long> emptySet;
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        this.graph = graph;
        HeapGraph heapGraph = this.graph;
        String name = Thread.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "Thread::class.java.name");
        HeapObject.HeapClass threadClass = heapGraph.findClassByName(name);
        this.threadClassObjectIds = (threadClass == null || (emptySet = SetsKt.plus(SetsKt.setOf(Long.valueOf(threadClass.getObjectId())), SequencesKt.toSet(SequencesKt.map(threadClass.getSubclasses(), new Function1<HeapObject.HeapClass, Long>() { // from class: shark.internal.JavaLocalReferenceReader$threadClassObjectIds$1$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Long.valueOf(invoke((HeapObject.HeapClass) obj));
            }

            public final long invoke(HeapObject.HeapClass it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.getObjectId();
            }
        })))) == null) ? SetsKt.emptySet() : emptySet;
        Map threadNames = new LinkedHashMap();
        Iterable $this$forEach$iv = ReferenceMatcherKt.filterFor(list, this.graph);
        for (Object element$iv : $this$forEach$iv) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) element$iv;
            ReferencePattern pattern = referenceMatcher.getPattern();
            if (pattern instanceof ReferencePattern.JavaLocalPattern) {
                threadNames.put(((ReferencePattern.JavaLocalPattern) pattern).getThreadName(), referenceMatcher);
            }
        }
        this.threadNameReferenceMatchers = threadNames;
    }

    public final HeapGraph getGraph() {
        return this.graph;
    }

    @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
    public boolean matches(HeapObject.HeapInstance instance) {
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        return this.threadClassObjectIds.contains(Long.valueOf(instance.getInstanceClassId())) && ThreadObjects.INSTANCE.getByThreadObjectId(this.graph, instance.getObjectId()) != null;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        Sequence<Reference> map;
        HeapValue value;
        String threadName;
        Intrinsics.checkParameterIsNotNull(source, "source");
        HeapField heapField = source.get(Reflection.getOrCreateKotlinClass(Thread.class), ChannelRoutes.CHANNEL_NAME);
        final ReferenceMatcher referenceMatcher = (heapField == null || (value = heapField.getValue()) == null || (threadName = value.readAsJavaString()) == null) ? null : this.threadNameReferenceMatchers.get(threadName);
        if (referenceMatcher instanceof IgnoredReferenceMatcher) {
            return SequencesKt.emptySequence();
        }
        final long threadClassId = source.getInstanceClassId();
        List frames = JavaFrames.INSTANCE.getByThreadObjectId(this.graph, source.getObjectId());
        if (frames != null && (map = SequencesKt.map(CollectionsKt.asSequence(frames), new Function1<GcRoot.JavaFrame, Reference>() { // from class: shark.internal.JavaLocalReferenceReader$read$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Reference invoke(GcRoot.JavaFrame frame) {
                Intrinsics.checkParameterIsNotNull(frame, "frame");
                return new Reference(frame.getId(), true, new Reference.LazyDetails.Resolver() { // from class: shark.internal.JavaLocalReferenceReader$read$$inlined$let$lambda$1.1
                    @Override // shark.internal.Reference.LazyDetails.Resolver
                    public final Reference.LazyDetails resolve() {
                        return new Reference.LazyDetails("", threadClassId, ReferenceLocationType.LOCAL, (LibraryLeakReferenceMatcher) referenceMatcher, true);
                    }
                });
            }
        })) != null) {
            return map;
        }
        return SequencesKt.emptySequence();
    }
}