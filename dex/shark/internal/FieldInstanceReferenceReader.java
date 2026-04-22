package shark.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HprofRecord;
import shark.IgnoredReferenceMatcher;
import shark.LibraryLeakReferenceMatcher;
import shark.PrimitiveType;
import shark.ReferenceMatcher;
import shark.ReferenceMatcherKt;
import shark.ReferencePattern;
import shark.internal.Reference;

/* compiled from: FieldInstanceReferenceReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006*\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u0018\u001a\u00020\u000f*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lshark/internal/FieldInstanceReferenceReader;", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject$HeapInstance;", "graph", "Lshark/HeapGraph;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "(Lshark/HeapGraph;Ljava/util/List;)V", "fieldNameByClassName", "", "", "javaLangObjectId", "", "sizeOfObjectInstances", "", "determineSizeOfObjectInstances", "objectClass", "Lshark/HeapObject$HeapClass;", "read", "Lkotlin/sequences/Sequence;", "Lshark/internal/Reference;", "source", "classHierarchyWithoutJavaLangObject", "getRecordSize", "field", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "shark"}, k = 1, mv = {1, 4, 1})
public final class FieldInstanceReferenceReader implements ReferenceReader<HeapObject.HeapInstance> {
    private final Map<String, Map<String, ReferenceMatcher>> fieldNameByClassName;
    private final long javaLangObjectId;
    private final int sizeOfObjectInstances;

    public FieldInstanceReferenceReader(HeapGraph graph, List<? extends ReferenceMatcher> list) {
        LinkedHashMap newMap;
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        HeapObject.HeapClass objectClass = graph.findClassByName("java.lang.Object");
        this.javaLangObjectId = objectClass != null ? objectClass.getObjectId() : -1L;
        this.sizeOfObjectInstances = determineSizeOfObjectInstances(objectClass, graph);
        Map fieldNameByClassName = new LinkedHashMap();
        Iterable $this$forEach$iv = ReferenceMatcherKt.filterFor(list, graph);
        for (Object element$iv : $this$forEach$iv) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) element$iv;
            ReferencePattern pattern = referenceMatcher.getPattern();
            if (pattern instanceof ReferencePattern.InstanceFieldPattern) {
                Map mapOrNull = (Map) fieldNameByClassName.get(((ReferencePattern.InstanceFieldPattern) pattern).getClassName());
                if (mapOrNull != null) {
                    newMap = mapOrNull;
                } else {
                    newMap = new LinkedHashMap();
                    fieldNameByClassName.put(((ReferencePattern.InstanceFieldPattern) pattern).getClassName(), newMap);
                }
                newMap.put(((ReferencePattern.InstanceFieldPattern) pattern).getFieldName(), referenceMatcher);
            }
        }
        this.fieldNameByClassName = fieldNameByClassName;
    }

    @Override // shark.internal.ReferenceReader
    public Sequence<Reference> read(HeapObject.HeapInstance source) {
        List classHierarchy;
        LinkedHashMap fieldReferenceMatchers;
        HeapObject.HeapInstance $this$with;
        boolean z;
        HeapGraph hprofGraph;
        Lazy fieldReader;
        boolean z2;
        FieldInstanceReferenceReader fieldInstanceReferenceReader = this;
        Intrinsics.checkParameterIsNotNull(source, "source");
        if (source.isPrimitiveWrapper() || Intrinsics.areEqual(source.getInstanceClassName(), "java.lang.String") || source.getInstanceClass().getInstanceByteSize() <= fieldInstanceReferenceReader.sizeOfObjectInstances) {
            return SequencesKt.emptySequence();
        }
        LinkedHashMap fieldReferenceMatchers2 = new LinkedHashMap();
        List classHierarchy2 = fieldInstanceReferenceReader.classHierarchyWithoutJavaLangObject(source.getInstanceClass(), fieldInstanceReferenceReader.javaLangObjectId);
        List $this$forEach$iv = classHierarchy2;
        for (Object element$iv : $this$forEach$iv) {
            HeapObject.HeapClass it = (HeapObject.HeapClass) element$iv;
            Map referenceMatcherByField = fieldInstanceReferenceReader.fieldNameByClassName.get(it.getName());
            if (referenceMatcherByField != null) {
                for (Map.Entry<String, ReferenceMatcher> entry : referenceMatcherByField.entrySet()) {
                    String fieldName = entry.getKey();
                    ReferenceMatcher referenceMatcher = entry.getValue();
                    if (!fieldReferenceMatchers2.containsKey(fieldName)) {
                        fieldReferenceMatchers2.put(fieldName, referenceMatcher);
                    }
                }
            }
        }
        final HeapObject.HeapInstance $this$with2 = source;
        boolean z3 = false;
        final HeapGraph hprofGraph2 = $this$with2.getGraph();
        Lazy fieldReader2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<FieldIdReader>() { // from class: shark.internal.FieldInstanceReferenceReader$read$2$fieldReader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final FieldIdReader invoke() {
                return new FieldIdReader(HeapObject.HeapInstance.this.readRecord(), hprofGraph2.getIdentifierByteSize());
            }
        });
        List result = new ArrayList();
        int skipBytesCount = 0;
        for (HeapObject.HeapClass heapClass : classHierarchy2) {
            for (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord : heapClass.readRecordFields()) {
                if (fieldRecord.getType() != 2) {
                    skipBytesCount += fieldInstanceReferenceReader.getRecordSize(hprofGraph2, fieldRecord);
                    fieldReferenceMatchers = fieldReferenceMatchers2;
                    classHierarchy = classHierarchy2;
                    $this$with = $this$with2;
                    z = z3;
                    hprofGraph = hprofGraph2;
                    fieldReader = fieldReader2;
                } else {
                    ((FieldIdReader) fieldReader2.getValue()).skipBytes(skipBytesCount);
                    skipBytesCount = 0;
                    classHierarchy = classHierarchy2;
                    long valueObjectId = ((FieldIdReader) fieldReader2.getValue()).readId();
                    if (valueObjectId == 0) {
                        fieldReferenceMatchers = fieldReferenceMatchers2;
                        $this$with = $this$with2;
                        z = z3;
                        hprofGraph = hprofGraph2;
                        fieldReader = fieldReader2;
                    } else {
                        final String name = heapClass.instanceFieldName(fieldRecord);
                        final ReferenceMatcher referenceMatcher2 = (ReferenceMatcher) fieldReferenceMatchers2.get(name);
                        fieldReferenceMatchers = fieldReferenceMatchers2;
                        if (referenceMatcher2 instanceof IgnoredReferenceMatcher) {
                            $this$with = $this$with2;
                            z = z3;
                            hprofGraph = hprofGraph2;
                            fieldReader = fieldReader2;
                        } else {
                            HeapObject.HeapInstance $this$with3 = $this$with2;
                            z = z3;
                            final long locationClassObjectId = heapClass.getObjectId();
                            $this$with = $this$with3;
                            if (referenceMatcher2 != null) {
                                hprofGraph = hprofGraph2;
                                z2 = true;
                            } else {
                                hprofGraph = hprofGraph2;
                                z2 = false;
                            }
                            fieldReader = fieldReader2;
                            result.add(TuplesKt.to(name, new Reference(valueObjectId, z2, new Reference.LazyDetails.Resolver() { // from class: shark.internal.FieldInstanceReferenceReader$read$2$1
                                @Override // shark.internal.Reference.LazyDetails.Resolver
                                public final Reference.LazyDetails resolve() {
                                    return new Reference.LazyDetails(name, locationClassObjectId, ReferenceLocationType.INSTANCE_FIELD, (LibraryLeakReferenceMatcher) referenceMatcher2, false);
                                }
                            })));
                        }
                    }
                }
                fieldInstanceReferenceReader = this;
                classHierarchy2 = classHierarchy;
                fieldReferenceMatchers2 = fieldReferenceMatchers;
                z3 = z;
                $this$with2 = $this$with;
                fieldReader2 = fieldReader;
                hprofGraph2 = hprofGraph;
            }
            fieldInstanceReferenceReader = this;
        }
        if (result.size() > 1) {
            CollectionsKt.sortWith(result, new Comparator<T>() { // from class: shark.internal.FieldInstanceReferenceReader$$special$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Pair it2 = (Pair) t;
                    Pair it3 = (Pair) t2;
                    return ComparisonsKt.compareValues((String) it2.getFirst(), (String) it3.getFirst());
                }
            });
        }
        return SequencesKt.map(CollectionsKt.asSequence(result), new Function1<Pair<? extends String, ? extends Reference>, Reference>() { // from class: shark.internal.FieldInstanceReferenceReader$read$2$3
            public final Reference invoke(Pair<String, Reference> pair) {
                Intrinsics.checkParameterIsNotNull(pair, "it");
                return (Reference) pair.getSecond();
            }
        });
    }

    private final List<HeapObject.HeapClass> classHierarchyWithoutJavaLangObject(HeapObject.HeapClass $this$classHierarchyWithoutJavaLangObject, long javaLangObjectId) {
        List result = new ArrayList();
        for (HeapObject.HeapClass parent = $this$classHierarchyWithoutJavaLangObject; parent != null && parent.getObjectId() != javaLangObjectId; parent = parent.getSuperclass()) {
            result.add(parent);
        }
        return result;
    }

    private final int getRecordSize(HeapGraph $this$getRecordSize, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord field) {
        int type = field.getType();
        if (type == 2) {
            return $this$getRecordSize.getIdentifierByteSize();
        }
        if (type == PrimitiveType.BOOLEAN.getHprofType()) {
            return 1;
        }
        if (type == PrimitiveType.CHAR.getHprofType()) {
            return 2;
        }
        if (type == PrimitiveType.FLOAT.getHprofType()) {
            return 4;
        }
        if (type == PrimitiveType.DOUBLE.getHprofType()) {
            return 8;
        }
        if (type == PrimitiveType.BYTE.getHprofType()) {
            return 1;
        }
        if (type == PrimitiveType.SHORT.getHprofType()) {
            return 2;
        }
        if (type == PrimitiveType.INT.getHprofType()) {
            return 4;
        }
        if (type == PrimitiveType.LONG.getHprofType()) {
            return 8;
        }
        throw new IllegalStateException("Unknown type " + field.getType());
    }

    private final int determineSizeOfObjectInstances(HeapObject.HeapClass objectClass, HeapGraph graph) {
        if (objectClass == null) {
            return 0;
        }
        int objectClassFieldSize = objectClass.readFieldsByteSize();
        int sizeOfObjectOnArt = graph.getIdentifierByteSize() + PrimitiveType.INT.getByteSize();
        if (objectClassFieldSize != sizeOfObjectOnArt) {
            return 0;
        }
        return sizeOfObjectOnArt;
    }
}