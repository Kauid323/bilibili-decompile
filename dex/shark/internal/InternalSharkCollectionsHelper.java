package shark.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapGraph;
import shark.HeapObject;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.Reference;

/* compiled from: InternalSharkCollectionsHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lshark/internal/InternalSharkCollectionsHelper;", "", "()V", "arrayListValues", "Lkotlin/sequences/Sequence;", "", "heapInstance", "Lshark/HeapObject$HeapInstance;", "className", "graphObject", "Lshark/HeapObject;", "shark"}, k = 1, mv = {1, 4, 1})
public final class InternalSharkCollectionsHelper {
    public static final InternalSharkCollectionsHelper INSTANCE = new InternalSharkCollectionsHelper();

    private InternalSharkCollectionsHelper() {
    }

    public final Sequence<String> arrayListValues(HeapObject.HeapInstance heapInstance) {
        Intrinsics.checkParameterIsNotNull(heapInstance, "heapInstance");
        final HeapGraph graph = heapInstance.getGraph();
        ChainingInstanceReferenceReader.VirtualInstanceReferenceReader arrayListReader = OpenJdkInstanceRefReaders.ARRAY_LIST.create(graph);
        if (arrayListReader == null) {
            arrayListReader = ApacheHarmonyInstanceRefReaders.ARRAY_LIST.create(graph);
        }
        if (arrayListReader == null) {
            return SequencesKt.emptySequence();
        }
        if (!arrayListReader.matches(heapInstance)) {
            return SequencesKt.emptySequence();
        }
        return SequencesKt.map(arrayListReader.read(heapInstance), new Function1<Reference, String>() { // from class: shark.internal.InternalSharkCollectionsHelper$arrayListValues$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final String invoke(Reference reference) {
                String className;
                Intrinsics.checkParameterIsNotNull(reference, "reference");
                HeapObject arrayListValue = HeapGraph.this.findObjectById(reference.getValueObjectId());
                Reference.LazyDetails details = reference.getLazyDetailsResolver().resolve();
                StringBuilder append = new StringBuilder().append('[').append(details.getName()).append("] = ");
                className = InternalSharkCollectionsHelper.INSTANCE.className(arrayListValue);
                return append.append(className).toString();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String className(HeapObject graphObject) {
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
}