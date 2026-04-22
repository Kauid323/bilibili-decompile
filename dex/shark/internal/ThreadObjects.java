package shark.internal;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.GcRoot;
import shark.GraphContext;
import shark.HeapGraph;

/* compiled from: ThreadObjects.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0019\u0010\t\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u0006J!\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u000b0\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lshark/internal/ThreadObjects;", "", "()V", "getByThreadObjectId", "Lshark/GcRoot$ThreadObject;", "graph", "Lshark/HeapGraph;", "objectId", "", "getThreadObjects", "", "Lkotlin/internal/NoInfer;", "getThreadObjectsByIdMap", "", "shark"}, k = 1, mv = {1, 4, 1})
public final class ThreadObjects {
    public static final ThreadObjects INSTANCE = new ThreadObjects();

    private ThreadObjects() {
    }

    private final Map<Long, GcRoot.ThreadObject> getThreadObjectsByIdMap(final HeapGraph graph) {
        GraphContext context = graph.getContext();
        String name = ThreadObjects.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "ThreadObjects::class.java.name");
        return (Map) context.getOrPut(name, new Function0<Map<Long, ? extends GcRoot.ThreadObject>>() { // from class: shark.internal.ThreadObjects$getThreadObjectsByIdMap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Map<Long, GcRoot.ThreadObject> invoke() {
                Sequence $this$filterIsInstance$iv = CollectionsKt.asSequence(HeapGraph.this.getGcRoots());
                Sequence $this$associateBy$iv = SequencesKt.filter($this$filterIsInstance$iv, new Function1<Object, Boolean>() { // from class: shark.internal.ThreadObjects$getThreadObjectsByIdMap$1$$special$$inlined$filterIsInstance$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Boolean.valueOf(m156invoke(obj));
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final boolean m156invoke(Object it) {
                        return it instanceof GcRoot.ThreadObject;
                    }
                });
                if ($this$associateBy$iv == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
                }
                Map destination$iv$iv = new LinkedHashMap();
                for (Object element$iv$iv : $this$associateBy$iv) {
                    GcRoot.ThreadObject it = (GcRoot.ThreadObject) element$iv$iv;
                    destination$iv$iv.put(Long.valueOf(it.getId()), element$iv$iv);
                }
                return destination$iv$iv;
            }
        });
    }

    public final Collection<GcRoot.ThreadObject> getThreadObjects(HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        return getThreadObjectsByIdMap(graph).values();
    }

    public final GcRoot.ThreadObject getByThreadObjectId(HeapGraph graph, long objectId) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Map threadObjectsById = getThreadObjectsByIdMap(graph);
        return threadObjectsById.get(Long.valueOf(objectId));
    }
}