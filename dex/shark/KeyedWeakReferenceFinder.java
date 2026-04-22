package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import shark.HeapObject;
import shark.SharkLog;
import shark.internal.KeyedWeakReferenceMirror;

/* compiled from: KeyedWeakReferenceFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lshark/KeyedWeakReferenceFinder;", "Lshark/LeakingObjectFinder;", "()V", "findKeyedWeakReferences", "", "Lshark/internal/KeyedWeakReferenceMirror;", "graph", "Lshark/HeapGraph;", "findKeyedWeakReferences$shark", "findLeakingObjectIds", "", "", "heapDumpUptimeMillis", "(Lshark/HeapGraph;)Ljava/lang/Long;", "shark"}, k = 1, mv = {1, 4, 1})
public final class KeyedWeakReferenceFinder implements LeakingObjectFinder {
    public static final KeyedWeakReferenceFinder INSTANCE = new KeyedWeakReferenceFinder();

    private KeyedWeakReferenceFinder() {
    }

    @Override // shark.LeakingObjectFinder
    public Set<Long> findLeakingObjectIds(HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Iterable $this$filter$iv = findKeyedWeakReferences$shark(graph);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            KeyedWeakReferenceMirror it = (KeyedWeakReferenceMirror) element$iv$iv;
            if (it.getHasReferent() && it.isRetained()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$filter$iv2 = (List) destination$iv$iv;
        Iterable $this$map$iv = $this$filter$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv2.add(Long.valueOf(((KeyedWeakReferenceMirror) item$iv$iv).getReferent().getValue()));
        }
        return CollectionsKt.toSet((List) destination$iv$iv2);
    }

    public final Long heapDumpUptimeMillis(final HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        return (Long) graph.getContext().getOrPut("heapDumpUptimeMillis", new Function0<Long>() { // from class: shark.KeyedWeakReferenceFinder$heapDumpUptimeMillis$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Long m151invoke() {
                HeapField heapField;
                HeapValue value;
                HeapObject.HeapClass keyedWeakReferenceClass = HeapGraph.this.findClassByName("leakcanary.KeyedWeakReference");
                Long heapDumpUptimeMillis = null;
                if (keyedWeakReferenceClass != null && (heapField = keyedWeakReferenceClass.get("heapDumpUptimeMillis")) != null && (value = heapField.getValue()) != null) {
                    heapDumpUptimeMillis = value.getAsLong();
                }
                if (heapDumpUptimeMillis == null) {
                    SharkLog this_$iv = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv = this_$iv.getLogger();
                    if (logger$iv != null) {
                        logger$iv.d("leakcanary.KeyedWeakReference.heapDumpUptimeMillis field not found");
                    }
                }
                return heapDumpUptimeMillis;
            }
        });
    }

    public final List<KeyedWeakReferenceMirror> findKeyedWeakReferences$shark(final HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        return (List) graph.getContext().getOrPut(ObjectInspectors.KEYED_WEAK_REFERENCE.name(), new Function0<List<? extends KeyedWeakReferenceMirror>>() { // from class: shark.KeyedWeakReferenceFinder$findKeyedWeakReferences$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final List<KeyedWeakReferenceMirror> invoke() {
                HeapObject.HeapClass keyedWeakReferenceClass = HeapGraph.this.findClassByName("leakcanary.KeyedWeakReference");
                final long keyedWeakReferenceClassId = keyedWeakReferenceClass != null ? keyedWeakReferenceClass.getObjectId() : 0L;
                HeapObject.HeapClass findClassByName = HeapGraph.this.findClassByName("com.squareup.leakcanary.KeyedWeakReference");
                final long legacyKeyedWeakReferenceClassId = findClassByName != null ? findClassByName.getObjectId() : 0L;
                final Long heapDumpUptimeMillis = KeyedWeakReferenceFinder.INSTANCE.heapDumpUptimeMillis(HeapGraph.this);
                List addedToContext = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(HeapGraph.this.getInstances(), new Function1<HeapObject.HeapInstance, Boolean>() { // from class: shark.KeyedWeakReferenceFinder$findKeyedWeakReferences$1$addedToContext$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Boolean.valueOf(invoke((HeapObject.HeapInstance) obj));
                    }

                    public final boolean invoke(HeapObject.HeapInstance instance) {
                        Intrinsics.checkParameterIsNotNull(instance, "instance");
                        return instance.getInstanceClassId() == keyedWeakReferenceClassId || instance.getInstanceClassId() == legacyKeyedWeakReferenceClassId;
                    }
                }), new Function1<HeapObject.HeapInstance, KeyedWeakReferenceMirror>() { // from class: shark.KeyedWeakReferenceFinder$findKeyedWeakReferences$1$addedToContext$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final KeyedWeakReferenceMirror invoke(HeapObject.HeapInstance it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        return KeyedWeakReferenceMirror.Companion.fromInstance(it, heapDumpUptimeMillis);
                    }
                }));
                HeapGraph.this.getContext().set(ObjectInspectors.KEYED_WEAK_REFERENCE.name(), addedToContext);
                return addedToContext;
            }
        });
    }
}