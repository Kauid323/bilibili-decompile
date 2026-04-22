package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import shark.HeapObject;

/* compiled from: HeapGraph.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020,H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0003H&J\u0010\u00102\u001a\u00020#2\u0006\u0010.\u001a\u00020/H&J\u0012\u00103\u001a\u0004\u0018\u00010#2\u0006\u0010.\u001a\u00020/H&J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u0003H&J\u0010\u00106\u001a\u0002072\u0006\u0010.\u001a\u00020/H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u0012\u0010\u001b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0005R\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0012\u0010%\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\n¨\u00068"}, d2 = {"Lshark/HeapGraph;", "", "classCount", "", "getClassCount", "()I", "classes", "Lkotlin/sequences/Sequence;", "Lshark/HeapObject$HeapClass;", "getClasses", "()Lkotlin/sequences/Sequence;", "context", "Lshark/GraphContext;", "getContext", "()Lshark/GraphContext;", "gcRoots", "", "Lshark/GcRoot;", "getGcRoots", "()Ljava/util/List;", "identifierByteSize", "getIdentifierByteSize", "instanceCount", "getInstanceCount", "instances", "Lshark/HeapObject$HeapInstance;", "getInstances", "objectArrayCount", "getObjectArrayCount", "objectArrays", "Lshark/HeapObject$HeapObjectArray;", "getObjectArrays", "objectCount", "getObjectCount", "objects", "Lshark/HeapObject;", "getObjects", "primitiveArrayCount", "getPrimitiveArrayCount", "primitiveArrays", "Lshark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrays", "findClassByName", "className", "", "findHeapDumpIndex", "objectId", "", "findObjectByHeapDumpIndex", "heapDumpIndex", "findObjectById", "findObjectByIdOrNull", "findObjectByIndex", "objectIndex", "objectExists", "", "shark-graph"}, k = 1, mv = {1, 4, 1})
public interface HeapGraph {
    HeapObject.HeapClass findClassByName(String str);

    int findHeapDumpIndex(long j);

    HeapObject findObjectByHeapDumpIndex(int i);

    HeapObject findObjectById(long j) throws IllegalArgumentException;

    HeapObject findObjectByIdOrNull(long j);

    HeapObject findObjectByIndex(int i) throws IllegalArgumentException;

    int getClassCount();

    Sequence<HeapObject.HeapClass> getClasses();

    GraphContext getContext();

    List<GcRoot> getGcRoots();

    int getIdentifierByteSize();

    int getInstanceCount();

    Sequence<HeapObject.HeapInstance> getInstances();

    int getObjectArrayCount();

    Sequence<HeapObject.HeapObjectArray> getObjectArrays();

    int getObjectCount();

    Sequence<HeapObject> getObjects();

    int getPrimitiveArrayCount();

    Sequence<HeapObject.HeapPrimitiveArray> getPrimitiveArrays();

    boolean objectExists(long j);
}