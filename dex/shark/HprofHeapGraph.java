package shark;

import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okio.BufferedSource;
import shark.GcRoot;
import shark.HeapObject;
import shark.HprofRecord;
import shark.internal.FieldValuesReader;
import shark.internal.HprofInMemoryIndex;
import shark.internal.IndexedObject;
import shark.internal.LruCache;
import shark.internal.hppc.IntObjectPair;
import shark.internal.hppc.LongObjectPair;
import tv.danmaku.bili.BR;

/* compiled from: HprofHeapGraph.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 |2\u00020\u0001:\u0001|B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00172\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020@2\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0002\bAJ\u001b\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00172\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020,H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020JH\u0016J\u0015\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0000¢\u0006\u0002\bOJ\u001d\u0010P\u001a\u00020F2\u0006\u0010G\u001a\u00020,2\u0006\u0010Q\u001a\u00020;H\u0000¢\u0006\u0002\bRJ\u0012\u0010S\u001a\u0004\u0018\u00010\u000f2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020,H\u0016J\u0010\u0010V\u001a\u0002012\u0006\u0010W\u001a\u00020\nH\u0016J\u0010\u0010X\u001a\u0002012\u0006\u0010U\u001a\u00020,H\u0016J\u0012\u0010Y\u001a\u0004\u0018\u0001012\u0006\u0010U\u001a\u00020,H\u0016J\u0010\u0010Z\u001a\u0002012\u0006\u0010[\u001a\u00020\nH\u0016J\u0006\u0010\\\u001a\u00020FJ\u0010\u0010]\u001a\u00020@2\u0006\u0010U\u001a\u00020,H\u0016J\u001d\u0010^\u001a\u00020_2\u0006\u0010U\u001a\u00020,2\u0006\u0010`\u001a\u00020=H\u0000¢\u0006\u0002\baJ\u001d\u0010b\u001a\u00020N2\u0006\u0010U\u001a\u00020,2\u0006\u0010`\u001a\u00020cH\u0000¢\u0006\u0002\bdJ\u001d\u0010e\u001a\u00020\n2\u0006\u0010U\u001a\u00020,2\u0006\u0010`\u001a\u00020fH\u0000¢\u0006\u0002\bgJ\u001d\u0010h\u001a\u00020i2\u0006\u0010U\u001a\u00020,2\u0006\u0010`\u001a\u00020fH\u0000¢\u0006\u0002\bjJ@\u0010k\u001a\u0002Hl\"\b\b\u0000\u0010l*\u00020-2\u0006\u0010U\u001a\u00020,2\u0006\u0010`\u001a\u00020m2\u0017\u0010n\u001a\u0013\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u0002Hl0o¢\u0006\u0002\bqH\u0002¢\u0006\u0002\u0010rJ\u001d\u0010s\u001a\u00020\n2\u0006\u0010U\u001a\u00020,2\u0006\u0010`\u001a\u00020tH\u0000¢\u0006\u0002\buJ\u001d\u0010v\u001a\u00020w2\u0006\u0010U\u001a\u00020,2\u0006\u0010`\u001a\u00020tH\u0000¢\u0006\u0002\bxJ\u001d\u0010y\u001a\u00020F2\u0006\u0010G\u001a\u00020,2\u0006\u0010Q\u001a\u00020CH\u0000¢\u0006\u0002\bzJ \u0010{\u001a\u0002012\u0006\u0010[\u001a\u00020\n2\u0006\u0010`\u001a\u00020m2\u0006\u0010U\u001a\u00020,H\u0002R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0010\u0010\"\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\fR\u0014\u0010%\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\fR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\fR\u001a\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0011R\u0014\u00103\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\fR\u0014\u00105\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\fR\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002080\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lshark/HprofHeapGraph;", "Lshark/CloseableHeapGraph;", "header", "Lshark/HprofHeader;", "reader", "Lshark/RandomAccessHprofReader;", "index", "Lshark/internal/HprofInMemoryIndex;", "(Lshark/HprofHeader;Lshark/RandomAccessHprofReader;Lshark/internal/HprofInMemoryIndex;)V", "classCount", "", "getClassCount", "()I", "classes", "Lkotlin/sequences/Sequence;", "Lshark/HeapObject$HeapClass;", "getClasses", "()Lkotlin/sequences/Sequence;", "context", "Lshark/GraphContext;", "getContext", "()Lshark/GraphContext;", "gcRoots", "", "Lshark/GcRoot;", "getGcRoots", "()Ljava/util/List;", "identifierByteSize", "getIdentifierByteSize", "instanceCount", "getInstanceCount", "instances", "Lshark/HeapObject$HeapInstance;", "getInstances", "javaLangObjectClass", "objectArrayCount", "getObjectArrayCount", "objectArrayRecordNonElementSize", "getObjectArrayRecordNonElementSize$shark_graph", "objectArrays", "Lshark/HeapObject$HeapObjectArray;", "getObjectArrays", "objectCache", "Lshark/internal/LruCache;", "", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "objectCount", "getObjectCount", "objects", "Lshark/HeapObject;", "getObjects", "primitiveArrayCount", "getPrimitiveArrayCount", "primitiveArrayRecordNonElementSize", "getPrimitiveArrayRecordNonElementSize$shark_graph", "primitiveArrays", "Lshark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrays", "classDumpFields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "indexedClass", "Lshark/internal/IndexedObject$IndexedClass;", "classDumpFields$shark_graph", "classDumpHasReferenceFields", "", "classDumpHasReferenceFields$shark_graph", "classDumpStaticFields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "classDumpStaticFields$shark_graph", "className", "", "classId", "className$shark_graph", "close", "", "createFieldValuesReader", "Lshark/internal/FieldValuesReader;", "record", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "createFieldValuesReader$shark_graph", "fieldName", "fieldRecord", "fieldName$shark_graph", "findClassByName", "findHeapDumpIndex", "objectId", "findObjectByHeapDumpIndex", "heapDumpIndex", "findObjectById", "findObjectByIdOrNull", "findObjectByIndex", "objectIndex", "lruCacheStats", "objectExists", "readClassDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "indexedObject", "readClassDumpRecord$shark_graph", "readInstanceDumpRecord", "Lshark/internal/IndexedObject$IndexedInstance;", "readInstanceDumpRecord$shark_graph", "readObjectArrayByteSize", "Lshark/internal/IndexedObject$IndexedObjectArray;", "readObjectArrayByteSize$shark_graph", "readObjectArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readObjectArrayDumpRecord$shark_graph", "readObjectRecord", "T", "Lshark/internal/IndexedObject;", "readBlock", "Lkotlin/Function1;", "Lshark/HprofRecordReader;", "Lkotlin/ExtensionFunctionType;", "(JLshark/internal/IndexedObject;Lkotlin/jvm/functions/Function1;)Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "readPrimitiveArrayByteSize", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "readPrimitiveArrayByteSize$shark_graph", "readPrimitiveArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readPrimitiveArrayDumpRecord$shark_graph", "staticFieldName", "staticFieldName$shark_graph", "wrapIndexedObject", "Companion", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class HprofHeapGraph implements CloseableHeapGraph {
    public static final Companion Companion = new Companion(null);
    private static int INTERNAL_LRU_CACHE_SIZE = 3000;
    private final GraphContext context;
    private final HprofHeader header;
    private final HprofInMemoryIndex index;
    private final HeapObject.HeapClass javaLangObjectClass;
    private final int objectArrayRecordNonElementSize;
    private final LruCache<Long, HprofRecord.HeapDumpRecord.ObjectRecord> objectCache;
    private final int primitiveArrayRecordNonElementSize;
    private final RandomAccessHprofReader reader;

    public HprofHeapGraph(HprofHeader header, RandomAccessHprofReader reader, HprofInMemoryIndex index) {
        Intrinsics.checkParameterIsNotNull(header, "header");
        Intrinsics.checkParameterIsNotNull(reader, "reader");
        Intrinsics.checkParameterIsNotNull(index, "index");
        this.header = header;
        this.reader = reader;
        this.index = index;
        this.context = new GraphContext();
        this.objectCache = new LruCache<>(INTERNAL_LRU_CACHE_SIZE);
        this.javaLangObjectClass = findClassByName("java.lang.Object");
        this.objectArrayRecordNonElementSize = (getIdentifierByteSize() * 2) + (PrimitiveType.INT.getByteSize() * 2);
        this.primitiveArrayRecordNonElementSize = getIdentifierByteSize() + (PrimitiveType.INT.getByteSize() * 2) + PrimitiveType.BYTE.getByteSize();
    }

    @Override // shark.HeapGraph
    public int getIdentifierByteSize() {
        return this.header.getIdentifierByteSize();
    }

    @Override // shark.HeapGraph
    public GraphContext getContext() {
        return this.context;
    }

    @Override // shark.HeapGraph
    public int getObjectCount() {
        return getClassCount() + getInstanceCount() + getObjectArrayCount() + getPrimitiveArrayCount();
    }

    @Override // shark.HeapGraph
    public int getClassCount() {
        return this.index.getClassCount();
    }

    @Override // shark.HeapGraph
    public int getInstanceCount() {
        return this.index.getInstanceCount();
    }

    @Override // shark.HeapGraph
    public int getObjectArrayCount() {
        return this.index.getObjectArrayCount();
    }

    @Override // shark.HeapGraph
    public int getPrimitiveArrayCount() {
        return this.index.getPrimitiveArrayCount();
    }

    @Override // shark.HeapGraph
    public List<GcRoot> getGcRoots() {
        return this.index.gcRoots();
    }

    @Override // shark.HeapGraph
    public Sequence<HeapObject> getObjects() {
        final Ref.IntRef objectIndex = new Ref.IntRef();
        objectIndex.element = 0;
        return SequencesKt.map(this.index.indexedObjectSequence(), new Function1<LongObjectPair<? extends IndexedObject>, HeapObject>() { // from class: shark.HprofHeapGraph$objects$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final HeapObject invoke(LongObjectPair<? extends IndexedObject> longObjectPair) {
                HeapObject wrapIndexedObject;
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                HprofHeapGraph hprofHeapGraph = HprofHeapGraph.this;
                Ref.IntRef intRef = objectIndex;
                int i = intRef.element;
                intRef.element = i + 1;
                wrapIndexedObject = hprofHeapGraph.wrapIndexedObject(i, longObjectPair.getSecond(), longObjectPair.getFirst());
                return wrapIndexedObject;
            }
        });
    }

    @Override // shark.HeapGraph
    public Sequence<HeapObject.HeapClass> getClasses() {
        final Ref.IntRef objectIndex = new Ref.IntRef();
        objectIndex.element = 0;
        return SequencesKt.map(this.index.indexedClassSequence(), new Function1<LongObjectPair<? extends IndexedObject.IndexedClass>, HeapObject.HeapClass>() { // from class: shark.HprofHeapGraph$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final HeapObject.HeapClass invoke(LongObjectPair<IndexedObject.IndexedClass> longObjectPair) {
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                long objectId = longObjectPair.getFirst();
                IndexedObject.IndexedClass indexedObject = longObjectPair.getSecond();
                HprofHeapGraph hprofHeapGraph = HprofHeapGraph.this;
                Ref.IntRef intRef = objectIndex;
                int i = intRef.element;
                intRef.element = i + 1;
                return new HeapObject.HeapClass(hprofHeapGraph, indexedObject, objectId, i);
            }
        });
    }

    @Override // shark.HeapGraph
    public Sequence<HeapObject.HeapInstance> getInstances() {
        final Ref.IntRef objectIndex = new Ref.IntRef();
        objectIndex.element = getClassCount();
        return SequencesKt.map(this.index.indexedInstanceSequence(), new Function1<LongObjectPair<? extends IndexedObject.IndexedInstance>, HeapObject.HeapInstance>() { // from class: shark.HprofHeapGraph$instances$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final HeapObject.HeapInstance invoke(LongObjectPair<IndexedObject.IndexedInstance> longObjectPair) {
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                long objectId = longObjectPair.getFirst();
                IndexedObject.IndexedInstance indexedObject = longObjectPair.getSecond();
                HprofHeapGraph hprofHeapGraph = HprofHeapGraph.this;
                Ref.IntRef intRef = objectIndex;
                int i = intRef.element;
                intRef.element = i + 1;
                return new HeapObject.HeapInstance(hprofHeapGraph, indexedObject, objectId, i);
            }
        });
    }

    @Override // shark.HeapGraph
    public Sequence<HeapObject.HeapObjectArray> getObjectArrays() {
        final Ref.IntRef objectIndex = new Ref.IntRef();
        objectIndex.element = getClassCount() + getInstanceCount();
        return SequencesKt.map(this.index.indexedObjectArraySequence(), new Function1<LongObjectPair<? extends IndexedObject.IndexedObjectArray>, HeapObject.HeapObjectArray>() { // from class: shark.HprofHeapGraph$objectArrays$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final HeapObject.HeapObjectArray invoke(LongObjectPair<IndexedObject.IndexedObjectArray> longObjectPair) {
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                long objectId = longObjectPair.getFirst();
                IndexedObject.IndexedObjectArray indexedObject = longObjectPair.getSecond();
                HprofHeapGraph hprofHeapGraph = HprofHeapGraph.this;
                Ref.IntRef intRef = objectIndex;
                int i = intRef.element;
                intRef.element = i + 1;
                return new HeapObject.HeapObjectArray(hprofHeapGraph, indexedObject, objectId, i);
            }
        });
    }

    @Override // shark.HeapGraph
    public Sequence<HeapObject.HeapPrimitiveArray> getPrimitiveArrays() {
        final Ref.IntRef objectIndex = new Ref.IntRef();
        objectIndex.element = getClassCount() + getInstanceCount() + getObjectArrayCount();
        return SequencesKt.map(this.index.indexedPrimitiveArraySequence(), new Function1<LongObjectPair<? extends IndexedObject.IndexedPrimitiveArray>, HeapObject.HeapPrimitiveArray>() { // from class: shark.HprofHeapGraph$primitiveArrays$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final HeapObject.HeapPrimitiveArray invoke(LongObjectPair<IndexedObject.IndexedPrimitiveArray> longObjectPair) {
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                long objectId = longObjectPair.getFirst();
                IndexedObject.IndexedPrimitiveArray indexedObject = longObjectPair.getSecond();
                HprofHeapGraph hprofHeapGraph = HprofHeapGraph.this;
                Ref.IntRef intRef = objectIndex;
                int i = intRef.element;
                intRef.element = i + 1;
                return new HeapObject.HeapPrimitiveArray(hprofHeapGraph, indexedObject, objectId, i);
            }
        });
    }

    public final int getObjectArrayRecordNonElementSize$shark_graph() {
        return this.objectArrayRecordNonElementSize;
    }

    public final int getPrimitiveArrayRecordNonElementSize$shark_graph() {
        return this.primitiveArrayRecordNonElementSize;
    }

    public final String lruCacheStats() {
        return this.objectCache.toString();
    }

    @Override // shark.HeapGraph
    public HeapObject findObjectById(long objectId) {
        HeapObject findObjectByIdOrNull = findObjectByIdOrNull(objectId);
        if (findObjectByIdOrNull != null) {
            return findObjectByIdOrNull;
        }
        throw new IllegalArgumentException("Object id " + objectId + " not found in heap dump.");
    }

    @Override // shark.HeapGraph
    public HeapObject findObjectByIndex(int objectIndex) {
        if (!(objectIndex >= 0 && getObjectCount() > objectIndex)) {
            throw new IllegalArgumentException((objectIndex + " should be in range [0, " + getObjectCount() + '[').toString());
        }
        LongObjectPair<IndexedObject> objectAtIndex = this.index.objectAtIndex(objectIndex);
        long objectId = objectAtIndex.component1();
        IndexedObject indexedObject = objectAtIndex.component2();
        return wrapIndexedObject(objectIndex, indexedObject, objectId);
    }

    @Override // shark.HeapGraph
    public HeapObject findObjectByIdOrNull(long objectId) {
        HeapObject.HeapClass heapClass = this.javaLangObjectClass;
        if (heapClass == null || objectId != heapClass.getObjectId()) {
            IntObjectPair<IndexedObject> indexedObjectOrNull = this.index.indexedObjectOrNull(objectId);
            if (indexedObjectOrNull == null) {
                return null;
            }
            int objectIndex = indexedObjectOrNull.component1();
            IndexedObject indexedObject = indexedObjectOrNull.component2();
            return wrapIndexedObject(objectIndex, indexedObject, objectId);
        }
        return this.javaLangObjectClass;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // shark.HeapGraph
    public HeapObject.HeapClass findClassByName(String className) {
        String str;
        int indexOfArrayChar;
        char c;
        Intrinsics.checkParameterIsNotNull(className, "className");
        if (this.header.getVersion() == HprofVersion.ANDROID || (indexOfArrayChar = StringsKt.indexOf$default(className, '[', 0, false, 6, (Object) null)) == -1) {
            str = className;
        } else {
            int dimensions = (className.length() - indexOfArrayChar) / 2;
            String componentClassName = className.substring(0, indexOfArrayChar);
            Intrinsics.checkExpressionValueIsNotNull(componentClassName, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            StringBuilder append = new StringBuilder().append(StringsKt.repeat("[", dimensions));
            switch (componentClassName.hashCode()) {
                case -1325958191:
                    if (componentClassName.equals("double")) {
                        c = 'D';
                        break;
                    }
                    c = 'L' + componentClassName + ';';
                    break;
                case 104431:
                    if (componentClassName.equals("int")) {
                        c = 'I';
                        break;
                    }
                    c = 'L' + componentClassName + ';';
                    break;
                case 3039496:
                    if (componentClassName.equals("byte")) {
                        c = 'B';
                        break;
                    }
                    c = 'L' + componentClassName + ';';
                    break;
                case 3052374:
                    if (componentClassName.equals("char")) {
                        c = 'C';
                        break;
                    }
                    c = 'L' + componentClassName + ';';
                    break;
                case 3327612:
                    if (componentClassName.equals("long")) {
                        c = 'J';
                        break;
                    }
                    c = 'L' + componentClassName + ';';
                    break;
                case 97526364:
                    if (componentClassName.equals("float")) {
                        c = 'F';
                        break;
                    }
                    c = 'L' + componentClassName + ';';
                    break;
                case 109413500:
                    if (componentClassName.equals("short")) {
                        c = 'S';
                        break;
                    }
                    c = 'L' + componentClassName + ';';
                    break;
                default:
                    c = 'L' + componentClassName + ';';
                    break;
            }
            str = append.append(c).toString();
        }
        String heapDumpClassName = str;
        Long classId = this.index.classId(heapDumpClassName);
        if (classId == null) {
            return null;
        }
        HeapObject findObjectById = findObjectById(classId.longValue());
        if (findObjectById != null) {
            return (HeapObject.HeapClass) findObjectById;
        }
        throw new TypeCastException("null cannot be cast to non-null type shark.HeapObject.HeapClass");
    }

    @Override // shark.HeapGraph
    public boolean objectExists(long objectId) {
        return this.index.objectIdIsIndexed(objectId);
    }

    @Override // shark.HeapGraph
    public int findHeapDumpIndex(long objectId) {
        IntObjectPair<IndexedObject> indexedObjectOrNull = this.index.indexedObjectOrNull(objectId);
        if (indexedObjectOrNull == null) {
            throw new IllegalArgumentException("Object id " + objectId + " not found in heap dump.");
        }
        IndexedObject indexedObject = indexedObjectOrNull.component2();
        long position = indexedObject.getPosition();
        int countObjectsBefore = 1;
        Sequence $this$forEach$iv = this.index.indexedObjectSequence();
        for (Object element$iv : $this$forEach$iv) {
            LongObjectPair it = (LongObjectPair) element$iv;
            if (position > ((IndexedObject) it.getSecond()).getPosition()) {
                countObjectsBefore++;
            }
        }
        return countObjectsBefore;
    }

    @Override // shark.HeapGraph
    public HeapObject findObjectByHeapDumpIndex(int heapDumpIndex) {
        boolean z = true;
        if (!((1 > heapDumpIndex || getObjectCount() < heapDumpIndex) ? false : false)) {
            throw new IllegalArgumentException((heapDumpIndex + " should be in range [1, " + getObjectCount() + ']').toString());
        }
        Iterable $this$sortedBy$iv = SequencesKt.toList(this.index.indexedObjectSequence());
        long objectId = ((LongObjectPair) CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator<T>() { // from class: shark.HprofHeapGraph$findObjectByHeapDumpIndex$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                LongObjectPair it = (LongObjectPair) t;
                LongObjectPair it2 = (LongObjectPair) t2;
                return ComparisonsKt.compareValues(Long.valueOf(((IndexedObject) it.getSecond()).getPosition()), Long.valueOf(((IndexedObject) it2.getSecond()).getPosition()));
            }
        }).get(heapDumpIndex)).component1();
        return findObjectById(objectId);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.reader.close();
    }

    public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> classDumpStaticFields$shark_graph(IndexedObject.IndexedClass indexedClass) {
        Intrinsics.checkParameterIsNotNull(indexedClass, "indexedClass");
        return this.index.getClassFieldsReader().classDumpStaticFields(indexedClass);
    }

    public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> classDumpFields$shark_graph(IndexedObject.IndexedClass indexedClass) {
        Intrinsics.checkParameterIsNotNull(indexedClass, "indexedClass");
        return this.index.getClassFieldsReader().classDumpFields(indexedClass);
    }

    public final boolean classDumpHasReferenceFields$shark_graph(IndexedObject.IndexedClass indexedClass) {
        Intrinsics.checkParameterIsNotNull(indexedClass, "indexedClass");
        return this.index.getClassFieldsReader().classDumpHasReferenceFields(indexedClass);
    }

    public final String fieldName$shark_graph(long classId, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord) {
        Intrinsics.checkParameterIsNotNull(fieldRecord, "fieldRecord");
        return this.index.fieldName(classId, fieldRecord.getNameStringId());
    }

    public final String staticFieldName$shark_graph(long classId, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord fieldRecord) {
        Intrinsics.checkParameterIsNotNull(fieldRecord, "fieldRecord");
        return this.index.fieldName(classId, fieldRecord.getNameStringId());
    }

    public final FieldValuesReader createFieldValuesReader$shark_graph(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord record) {
        Intrinsics.checkParameterIsNotNull(record, "record");
        return new FieldValuesReader(record, getIdentifierByteSize());
    }

    public final String className$shark_graph(long classId) {
        String hprofClassName = this.index.className(classId);
        if (this.header.getVersion() != HprofVersion.ANDROID && StringsKt.startsWith$default(hprofClassName, '[', false, 2, (Object) null)) {
            int arrayCharLastIndex = StringsKt.lastIndexOf$default(hprofClassName, '[', 0, false, 6, (Object) null);
            String brackets = StringsKt.repeat("[]", arrayCharLastIndex + 1);
            char typeChar = hprofClassName.charAt(arrayCharLastIndex + 1);
            switch (typeChar) {
                case BR.bitmapTransformation /* 66 */:
                    return "byte" + brackets;
                case BR.blurCoverUrl /* 67 */:
                    return "char" + brackets;
                case BR.bottomDesc /* 68 */:
                    return "double" + brackets;
                case BR.bottomDisplay2 /* 70 */:
                    return "float" + brackets;
                case BR.bottomText /* 73 */:
                    return "int" + brackets;
                case BR.btnBgColor /* 74 */:
                    return "long" + brackets;
                case BR.btnTryAgainText /* 76 */:
                    int classNameStart = arrayCharLastIndex + 2;
                    StringBuilder sb = new StringBuilder();
                    int length = hprofClassName.length() - 1;
                    if (hprofClassName != null) {
                        String substring = hprofClassName.substring(classNameStart, length);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        return sb.append(substring).append(brackets).toString();
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                case BR.calenderVisible /* 83 */:
                    return "short" + brackets;
                case BR.cardStyle /* 90 */:
                    return "boolean" + brackets;
                default:
                    throw new IllegalStateException(("Unexpected type char " + typeChar).toString());
            }
        }
        return hprofClassName;
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord readObjectArrayDumpRecord$shark_graph(long objectId, IndexedObject.IndexedObjectArray indexedObject) {
        Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
        return (HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) readObjectRecord(objectId, indexedObject, new Function1<HprofRecordReader, HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord>() { // from class: shark.HprofHeapGraph$readObjectArrayDumpRecord$1
            public final HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord invoke(HprofRecordReader $this$readObjectRecord) {
                Intrinsics.checkParameterIsNotNull($this$readObjectRecord, "$receiver");
                return $this$readObjectRecord.readObjectArrayDumpRecord();
            }
        });
    }

    public final int readObjectArrayByteSize$shark_graph(long objectId, IndexedObject.IndexedObjectArray indexedObject) {
        Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
        HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord cachedRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) this.objectCache.get(Long.valueOf(objectId));
        if (cachedRecord != null) {
            return cachedRecord.getElementIds().length * getIdentifierByteSize();
        }
        long position = indexedObject.getPosition() + getIdentifierByteSize() + PrimitiveType.INT.getByteSize();
        long size = PrimitiveType.INT.getByteSize();
        int thinRecordSize = ((Number) this.reader.readRecord(position, size, new Function1<HprofRecordReader, Integer>() { // from class: shark.HprofHeapGraph$readObjectArrayByteSize$thinRecordSize$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Integer.valueOf(invoke((HprofRecordReader) obj));
            }

            public final int invoke(HprofRecordReader $this$readRecord) {
                Intrinsics.checkParameterIsNotNull($this$readRecord, "$receiver");
                return $this$readRecord.readInt();
            }
        })).intValue();
        return getIdentifierByteSize() * thinRecordSize;
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readPrimitiveArrayDumpRecord$shark_graph(long objectId, IndexedObject.IndexedPrimitiveArray indexedObject) {
        Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
        return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) readObjectRecord(objectId, indexedObject, new Function1<HprofRecordReader, HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord>() { // from class: shark.HprofHeapGraph$readPrimitiveArrayDumpRecord$1
            public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord invoke(HprofRecordReader $this$readObjectRecord) {
                Intrinsics.checkParameterIsNotNull($this$readObjectRecord, "$receiver");
                return $this$readObjectRecord.readPrimitiveArrayDumpRecord();
            }
        });
    }

    public final int readPrimitiveArrayByteSize$shark_graph(long objectId, IndexedObject.IndexedPrimitiveArray indexedObject) {
        Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
        HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord cachedRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) this.objectCache.get(Long.valueOf(objectId));
        if (cachedRecord != null) {
            if (cachedRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) {
                return ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) cachedRecord).getArray().length * PrimitiveType.BOOLEAN.getByteSize();
            }
            if (cachedRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) {
                return ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) cachedRecord).getArray().length * PrimitiveType.CHAR.getByteSize();
            }
            if (cachedRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) {
                return ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) cachedRecord).getArray().length * PrimitiveType.FLOAT.getByteSize();
            }
            if (cachedRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) {
                return ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) cachedRecord).getArray().length * PrimitiveType.DOUBLE.getByteSize();
            }
            if (cachedRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) {
                return ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) cachedRecord).getArray().length * PrimitiveType.BYTE.getByteSize();
            }
            if (cachedRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) {
                return ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) cachedRecord).getArray().length * PrimitiveType.SHORT.getByteSize();
            }
            if (cachedRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) {
                return ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) cachedRecord).getArray().length * PrimitiveType.INT.getByteSize();
            }
            if (cachedRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) {
                return ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) cachedRecord).getArray().length * PrimitiveType.LONG.getByteSize();
            }
            throw new NoWhenBranchMatchedException();
        }
        long position = indexedObject.getPosition() + getIdentifierByteSize() + PrimitiveType.INT.getByteSize();
        int size = ((Number) this.reader.readRecord(position, PrimitiveType.INT.getByteSize(), new Function1<HprofRecordReader, Integer>() { // from class: shark.HprofHeapGraph$readPrimitiveArrayByteSize$size$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Integer.valueOf(invoke((HprofRecordReader) obj));
            }

            public final int invoke(HprofRecordReader $this$readRecord) {
                Intrinsics.checkParameterIsNotNull($this$readRecord, "$receiver");
                return $this$readRecord.readInt();
            }
        })).intValue();
        return indexedObject.getPrimitiveType().getByteSize() * size;
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord readClassDumpRecord$shark_graph(long objectId, IndexedObject.IndexedClass indexedObject) {
        Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
        return (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) readObjectRecord(objectId, indexedObject, new Function1<HprofRecordReader, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord>() { // from class: shark.HprofHeapGraph$readClassDumpRecord$1
            public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord invoke(HprofRecordReader $this$readObjectRecord) {
                Intrinsics.checkParameterIsNotNull($this$readObjectRecord, "$receiver");
                return $this$readObjectRecord.readClassDumpRecord();
            }
        });
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord readInstanceDumpRecord$shark_graph(long objectId, IndexedObject.IndexedInstance indexedObject) {
        Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
        return (HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) readObjectRecord(objectId, indexedObject, new Function1<HprofRecordReader, HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord>() { // from class: shark.HprofHeapGraph$readInstanceDumpRecord$1
            public final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord invoke(HprofRecordReader $this$readObjectRecord) {
                Intrinsics.checkParameterIsNotNull($this$readObjectRecord, "$receiver");
                return $this$readObjectRecord.readInstanceDumpRecord();
            }
        });
    }

    private final <T extends HprofRecord.HeapDumpRecord.ObjectRecord> T readObjectRecord(long objectId, IndexedObject indexedObject, final Function1<? super HprofRecordReader, ? extends T> function1) {
        T t = (T) this.objectCache.get(Long.valueOf(objectId));
        if (t != null) {
            return t;
        }
        Object readRecord = this.reader.readRecord(indexedObject.getPosition(), indexedObject.getRecordSize(), new Function1<HprofRecordReader, T>() { // from class: shark.HprofHeapGraph$readObjectRecord$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Lshark/HprofRecordReader;)TT; */
            public final HprofRecord.HeapDumpRecord.ObjectRecord invoke(HprofRecordReader $this$readRecord) {
                Intrinsics.checkParameterIsNotNull($this$readRecord, "$receiver");
                return (HprofRecord.HeapDumpRecord.ObjectRecord) function1.invoke($this$readRecord);
            }
        });
        HprofRecord.HeapDumpRecord.ObjectRecord $this$apply = (HprofRecord.HeapDumpRecord.ObjectRecord) readRecord;
        this.objectCache.put(Long.valueOf(objectId), $this$apply);
        return (T) readRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HeapObject wrapIndexedObject(int objectIndex, IndexedObject indexedObject, long objectId) {
        if (indexedObject instanceof IndexedObject.IndexedClass) {
            return new HeapObject.HeapClass(this, (IndexedObject.IndexedClass) indexedObject, objectId, objectIndex);
        }
        if (indexedObject instanceof IndexedObject.IndexedInstance) {
            return new HeapObject.HeapInstance(this, (IndexedObject.IndexedInstance) indexedObject, objectId, objectIndex);
        }
        if (indexedObject instanceof IndexedObject.IndexedObjectArray) {
            return new HeapObject.HeapObjectArray(this, (IndexedObject.IndexedObjectArray) indexedObject, objectId, objectIndex);
        }
        if (indexedObject instanceof IndexedObject.IndexedPrimitiveArray) {
            return new HeapObject.HeapPrimitiveArray(this, (IndexedObject.IndexedPrimitiveArray) indexedObject, objectId, objectIndex);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: HprofHeapGraph.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\nH\u0002J4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\nH\u0007J&\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\nJ&\u0010\u0014\u001a\u00020\u0015*\u00020\u00182\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lshark/HprofHeapGraph$Companion;", "", "()V", "INTERNAL_LRU_CACHE_SIZE", "", "getINTERNAL_LRU_CACHE_SIZE", "()I", "setINTERNAL_LRU_CACHE_SIZE", "(I)V", "deprecatedDefaultIndexedGcRootTypes", "", "Lkotlin/reflect/KClass;", "Lshark/GcRoot;", "indexHprof", "Lshark/HeapGraph;", "hprof", "Lshark/Hprof;", "proguardMapping", "Lshark/ProguardMapping;", "indexedGcRootTypes", "openHeapGraph", "Lshark/CloseableHeapGraph;", "Ljava/io/File;", "Lshark/HprofRecordTag;", "Lshark/DualSourceProvider;", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final int getINTERNAL_LRU_CACHE_SIZE() {
            return HprofHeapGraph.INTERNAL_LRU_CACHE_SIZE;
        }

        public final void setINTERNAL_LRU_CACHE_SIZE(int i) {
            HprofHeapGraph.INTERNAL_LRU_CACHE_SIZE = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CloseableHeapGraph openHeapGraph$default(Companion companion, File file, ProguardMapping proguardMapping, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                proguardMapping = null;
            }
            if ((i & 2) != 0) {
                set = HprofIndex.Companion.defaultIndexedGcRootTags();
            }
            return companion.openHeapGraph(file, proguardMapping, set);
        }

        public final CloseableHeapGraph openHeapGraph(File $this$openHeapGraph, ProguardMapping proguardMapping, Set<? extends HprofRecordTag> set) {
            Intrinsics.checkParameterIsNotNull($this$openHeapGraph, "$this$openHeapGraph");
            Intrinsics.checkParameterIsNotNull(set, "indexedGcRootTypes");
            return openHeapGraph(new FileSourceProvider($this$openHeapGraph), proguardMapping, set);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CloseableHeapGraph openHeapGraph$default(Companion companion, DualSourceProvider dualSourceProvider, ProguardMapping proguardMapping, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                proguardMapping = null;
            }
            if ((i & 2) != 0) {
                set = HprofIndex.Companion.defaultIndexedGcRootTags();
            }
            return companion.openHeapGraph(dualSourceProvider, proguardMapping, set);
        }

        public final CloseableHeapGraph openHeapGraph(DualSourceProvider $this$openHeapGraph, ProguardMapping proguardMapping, Set<? extends HprofRecordTag> set) {
            Intrinsics.checkParameterIsNotNull($this$openHeapGraph, "$this$openHeapGraph");
            Intrinsics.checkParameterIsNotNull(set, "indexedGcRootTypes");
            BufferedSource bufferedSource = (Closeable) $this$openHeapGraph.openStreamingSource();
            try {
                BufferedSource it = bufferedSource;
                HprofHeader header = HprofHeader.Companion.parseHeaderOf(it);
                CloseableKt.closeFinally(bufferedSource, (Throwable) null);
                HprofIndex index = HprofIndex.Companion.indexRecordsOf($this$openHeapGraph, header, proguardMapping, set);
                return index.openHeapGraph();
            } finally {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HeapGraph indexHprof$default(Companion companion, Hprof hprof, ProguardMapping proguardMapping, Set set, int i, Object obj) {
            if ((i & 2) != 0) {
                proguardMapping = null;
            }
            if ((i & 4) != 0) {
                set = companion.deprecatedDefaultIndexedGcRootTypes();
            }
            return companion.indexHprof(hprof, proguardMapping, set);
        }

        @Deprecated(message = "Replaced by HprofIndex.indexRecordsOf().openHeapGraph() or File.openHeapGraph()", replaceWith = @ReplaceWith(expression = "HprofIndex.indexRecordsOf(hprof, proguardMapping, indexedGcRootTypes).openHeapGraph()", imports = {}))
        public final HeapGraph indexHprof(Hprof hprof, ProguardMapping proguardMapping, Set<? extends KClass<? extends GcRoot>> set) {
            HprofRecordTag hprofRecordTag;
            Intrinsics.checkParameterIsNotNull(hprof, "hprof");
            Intrinsics.checkParameterIsNotNull(set, "indexedGcRootTypes");
            Set<? extends KClass<? extends GcRoot>> $this$map$iv = set;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KClass it = (KClass) item$iv$iv;
                if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.Unknown.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_UNKNOWN;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.JniGlobal.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_JNI_GLOBAL;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.JniLocal.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_JNI_LOCAL;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.JavaFrame.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_JAVA_FRAME;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.NativeStack.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_NATIVE_STACK;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.StickyClass.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_STICKY_CLASS;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.ThreadBlock.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_THREAD_BLOCK;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.MonitorUsed.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_MONITOR_USED;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.ThreadObject.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_THREAD_OBJECT;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.InternedString.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_INTERNED_STRING;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.Finalizing.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_FINALIZING;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.Debugger.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_DEBUGGER;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.ReferenceCleanup.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_REFERENCE_CLEANUP;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.VmInternal.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_VM_INTERNAL;
                } else if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.JniMonitor.class))) {
                    hprofRecordTag = HprofRecordTag.ROOT_JNI_MONITOR;
                } else if (!Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(GcRoot.Unreachable.class))) {
                    throw new IllegalStateException(("Unknown root " + it).toString());
                } else {
                    hprofRecordTag = HprofRecordTag.ROOT_UNREACHABLE;
                }
                destination$iv$iv.add(hprofRecordTag);
            }
            Set indexedRootTags = CollectionsKt.toSet((List) destination$iv$iv);
            HprofIndex index = HprofIndex.Companion.indexRecordsOf(new FileSourceProvider(hprof.getFile()), hprof.getHeader(), proguardMapping, indexedRootTags);
            CloseableHeapGraph graph = index.openHeapGraph();
            hprof.attachClosable(graph);
            return graph;
        }

        private final Set<KClass<? extends GcRoot>> deprecatedDefaultIndexedGcRootTypes() {
            return SetsKt.setOf(new KClass[]{Reflection.getOrCreateKotlinClass(GcRoot.JniGlobal.class), Reflection.getOrCreateKotlinClass(GcRoot.JavaFrame.class), Reflection.getOrCreateKotlinClass(GcRoot.JniLocal.class), Reflection.getOrCreateKotlinClass(GcRoot.MonitorUsed.class), Reflection.getOrCreateKotlinClass(GcRoot.NativeStack.class), Reflection.getOrCreateKotlinClass(GcRoot.StickyClass.class), Reflection.getOrCreateKotlinClass(GcRoot.ThreadBlock.class), Reflection.getOrCreateKotlinClass(GcRoot.ThreadObject.class), Reflection.getOrCreateKotlinClass(GcRoot.JniMonitor.class)});
        }
    }
}