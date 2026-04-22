package shark.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HeapValue;

/* compiled from: ShallowSizeCalculator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lshark/internal/ShallowSizeCalculator;", "", "graph", "Lshark/HeapGraph;", "(Lshark/HeapGraph;)V", "computeShallowSize", "", "objectId", "", "shark"}, k = 1, mv = {1, 4, 1})
public final class ShallowSizeCalculator {
    private final HeapGraph graph;

    public ShallowSizeCalculator(HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        this.graph = graph;
    }

    public final int computeShallowSize(long objectId) {
        int i;
        HeapValue value;
        HeapObject heapObject = this.graph.findObjectById(objectId);
        Long firstNonNullElement = null;
        if (heapObject instanceof HeapObject.HeapInstance) {
            if (Intrinsics.areEqual(((HeapObject.HeapInstance) heapObject).getInstanceClassName(), "java.lang.String")) {
                HeapField heapField = ((HeapObject.HeapInstance) heapObject).get("java.lang.String", "value");
                if (heapField != null && (value = heapField.getValue()) != null) {
                    firstNonNullElement = value.getAsNonNullObjectId();
                }
                Long valueObjectId = firstNonNullElement;
                int byteSize = ((HeapObject.HeapInstance) heapObject).getByteSize();
                if (valueObjectId != null) {
                    i = computeShallowSize(valueObjectId.longValue());
                } else {
                    i = 0;
                }
                return byteSize + i;
            }
            return ((HeapObject.HeapInstance) heapObject).getByteSize();
        } else if (heapObject instanceof HeapObject.HeapObjectArray) {
            if (ObjectArrayReferenceReader.Companion.isSkippablePrimitiveWrapperArray$shark((HeapObject.HeapObjectArray) heapObject)) {
                long[] elementIds = ((HeapObject.HeapObjectArray) heapObject).readRecord().getElementIds();
                int shallowSize = elementIds.length * this.graph.getIdentifierByteSize();
                int length = elementIds.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    long element$iv = elementIds[i2];
                    if (element$iv != 0) {
                        firstNonNullElement = Long.valueOf(element$iv);
                        break;
                    }
                    i2++;
                }
                if (firstNonNullElement != null) {
                    int sizeOfOneElement = computeShallowSize(firstNonNullElement.longValue());
                    int count$iv = 0;
                    int length2 = elementIds.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        if (elementIds[i3] != 0) {
                            count$iv++;
                        }
                    }
                    int countOfNonNullElements = count$iv;
                    return shallowSize + (sizeOfOneElement * countOfNonNullElements);
                }
                return shallowSize;
            }
            return ((HeapObject.HeapObjectArray) heapObject).getByteSize();
        } else if (heapObject instanceof HeapObject.HeapPrimitiveArray) {
            return ((HeapObject.HeapPrimitiveArray) heapObject).getByteSize();
        } else {
            if (heapObject instanceof HeapObject.HeapClass) {
                return heapObject.getRecordSize();
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}