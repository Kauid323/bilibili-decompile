package shark.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

/* compiled from: JavaFrames.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ'\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\r0\u00040\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lshark/internal/JavaFrames;", "", "()V", "getByThreadObjectId", "", "Lshark/GcRoot$JavaFrame;", "graph", "Lshark/HeapGraph;", "threadObjectId", "", "getJavaFramesByThreadSerialNumber", "", "", "Lkotlin/internal/NoInfer;", "shark"}, k = 1, mv = {1, 4, 1})
public final class JavaFrames {
    public static final JavaFrames INSTANCE = new JavaFrames();

    private JavaFrames() {
    }

    private final Map<Integer, List<GcRoot.JavaFrame>> getJavaFramesByThreadSerialNumber(final HeapGraph graph) {
        GraphContext context = graph.getContext();
        String name = JavaFrames.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "JavaFrames::class.java.name");
        return (Map) context.getOrPut(name, new Function0<Map<Integer, ? extends List<? extends GcRoot.JavaFrame>>>() { // from class: shark.internal.JavaFrames$getJavaFramesByThreadSerialNumber$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Map<Integer, List<GcRoot.JavaFrame>> invoke() {
                Sequence $this$filterIsInstance$iv = CollectionsKt.asSequence(HeapGraph.this.getGcRoots());
                Sequence $this$groupBy$iv = SequencesKt.filter($this$filterIsInstance$iv, new Function1<Object, Boolean>() { // from class: shark.internal.JavaFrames$getJavaFramesByThreadSerialNumber$1$$special$$inlined$filterIsInstance$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Boolean.valueOf(m154invoke(obj));
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final boolean m154invoke(Object it) {
                        return it instanceof GcRoot.JavaFrame;
                    }
                });
                if ($this$groupBy$iv == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
                }
                Map destination$iv$iv = new LinkedHashMap();
                for (Object element$iv$iv : $this$groupBy$iv) {
                    GcRoot.JavaFrame javaFrame = (GcRoot.JavaFrame) element$iv$iv;
                    Integer valueOf = Integer.valueOf(javaFrame.getThreadSerialNumber());
                    Object value$iv$iv$iv = destination$iv$iv.get(valueOf);
                    if (value$iv$iv$iv == null) {
                        ArrayList arrayList = new ArrayList();
                        destination$iv$iv.put(valueOf, arrayList);
                        value$iv$iv$iv = arrayList;
                    }
                    List list$iv$iv = (List) value$iv$iv$iv;
                    list$iv$iv.add(element$iv$iv);
                }
                return destination$iv$iv;
            }
        });
    }

    public final List<GcRoot.JavaFrame> getByThreadObjectId(HeapGraph graph, long threadObjectId) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        GcRoot.ThreadObject threadObject = ThreadObjects.INSTANCE.getByThreadObjectId(graph, threadObjectId);
        if (threadObject == null) {
            return null;
        }
        Map javaFrameByThreadSerial = getJavaFramesByThreadSerialNumber(graph);
        return javaFrameByThreadSerial.get(Integer.valueOf(threadObject.getThreadSerialNumber()));
    }
}