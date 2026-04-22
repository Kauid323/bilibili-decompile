package shark;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import shark.HeapObject;
import shark.HprofRecord;
import shark.ValueHolder;
import shark.internal.FieldValuesReader;
import shark.internal.IndexedObject;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: HeapObject.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b6\u0018\u0000 %2\u00020\u0001:\u0005%&'()B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H&R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0012\u0010!\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001e\u0082\u0001\u0004\u0004\b\f\u0010¨\u0006*"}, d2 = {"Lshark/HeapObject;", "", "()V", "asClass", "Lshark/HeapObject$HeapClass;", "getAsClass", "()Lshark/HeapObject$HeapClass;", "asInstance", "Lshark/HeapObject$HeapInstance;", "getAsInstance", "()Lshark/HeapObject$HeapInstance;", "asObjectArray", "Lshark/HeapObject$HeapObjectArray;", "getAsObjectArray", "()Lshark/HeapObject$HeapObjectArray;", "asPrimitiveArray", "Lshark/HeapObject$HeapPrimitiveArray;", "getAsPrimitiveArray", "()Lshark/HeapObject$HeapPrimitiveArray;", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "objectId", "", "getObjectId", "()J", "objectIndex", "", "getObjectIndex", "()I", "positiveObjectId", "getPositiveObjectId", "recordSize", "getRecordSize", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Companion", "HeapClass", "HeapInstance", "HeapObjectArray", "HeapPrimitiveArray", "shark-graph"}, k = 1, mv = {1, 4, 1})
public abstract class HeapObject {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, PrimitiveType> primitiveTypesByPrimitiveArrayClassName;
    private static final Set<String> primitiveWrapperClassNames;

    public abstract HeapGraph getGraph();

    public abstract long getObjectId();

    public abstract int getObjectIndex();

    public abstract int getRecordSize();

    public abstract HprofRecord.HeapDumpRecord.ObjectRecord readRecord();

    private HeapObject() {
    }

    public /* synthetic */ HeapObject(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public final long getPositiveObjectId() {
        return getObjectId() & ((-1) >>> ((8 - getGraph().getIdentifierByteSize()) * 8));
    }

    public final HeapClass getAsClass() {
        if (this instanceof HeapClass) {
            return (HeapClass) this;
        }
        return null;
    }

    public final HeapInstance getAsInstance() {
        if (this instanceof HeapInstance) {
            return (HeapInstance) this;
        }
        return null;
    }

    public final HeapObjectArray getAsObjectArray() {
        if (this instanceof HeapObjectArray) {
            return (HeapObjectArray) this;
        }
        return null;
    }

    public final HeapPrimitiveArray getAsPrimitiveArray() {
        if (this instanceof HeapPrimitiveArray) {
            return (HeapPrimitiveArray) this;
        }
        return null;
    }

    /* compiled from: HeapObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020$H\u0086\u0002J\u000e\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020\tJ\b\u0010@\u001a\u00020AH\u0016J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020>0CJ\f\u0010D\u001a\b\u0012\u0004\u0012\u00020E0CJ\u0010\u0010F\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020$J\f\u0010G\u001a\b\u0012\u0004\u0012\u00020:0\fJ\u0011\u0010H\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u0000H\u0086\u0004J\u0011\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020\u0000H\u0086\u0004J\b\u0010K\u001a\u00020$H\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000eR\u0011\u0010\u001f\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010 \u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b \u0010\u0019R\u0011\u0010!\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0011\u0010\"\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\f8F¢\u0006\u0006\u001a\u0004\b)\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\f8F¢\u0006\u0006\u001a\u0004\b/\u0010\u000eR\u0014\u00100\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001cR\u0011\u00102\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b3\u0010&R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00000\f8F¢\u0006\u0006\u001a\u0004\b5\u0010\u000eR\u0013\u00106\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006L"}, d2 = {"Lshark/HeapObject$HeapClass;", "Lshark/HeapObject;", "hprofGraph", "Lshark/HprofHeapGraph;", "indexedObject", "Lshark/internal/IndexedObject$IndexedClass;", "objectId", "", "objectIndex", "", "(Lshark/HprofHeapGraph;Lshark/internal/IndexedObject$IndexedClass;JI)V", "classHierarchy", "Lkotlin/sequences/Sequence;", "getClassHierarchy", "()Lkotlin/sequences/Sequence;", "directInstances", "Lshark/HeapObject$HeapInstance;", "getDirectInstances", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "hasReferenceInstanceFields", "", "getHasReferenceInstanceFields", "()Z", "instanceByteSize", "getInstanceByteSize", "()I", "instances", "getInstances", "isArrayClass", "isObjectArrayClass", "isPrimitiveArrayClass", "isPrimitiveWrapperClass", ChannelRoutes.CHANNEL_NAME, "", "getName", "()Ljava/lang/String;", "objectArrayInstances", "Lshark/HeapObject$HeapObjectArray;", "getObjectArrayInstances", "getObjectId", "()J", "getObjectIndex", "primitiveArrayInstances", "Lshark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrayInstances", "recordSize", "getRecordSize", "simpleName", "getSimpleName", "subclasses", "getSubclasses", "superclass", "getSuperclass", "()Lshark/HeapObject$HeapClass;", "get", "Lshark/HeapField;", "fieldName", "instanceFieldName", "fieldRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "readFieldsByteSize", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readRecordFields", "", "readRecordStaticFields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "readStaticField", "readStaticFields", "subclassOf", "superclassOf", "subclass", "toString", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HeapClass extends HeapObject {
        private final HprofHeapGraph hprofGraph;
        private final IndexedObject.IndexedClass indexedObject;
        private final long objectId;
        private final int objectIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeapClass(HprofHeapGraph hprofGraph, IndexedObject.IndexedClass indexedObject, long objectId, int objectIndex) {
            super(null);
            Intrinsics.checkParameterIsNotNull(hprofGraph, "hprofGraph");
            Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
            this.hprofGraph = hprofGraph;
            this.indexedObject = indexedObject;
            this.objectId = objectId;
            this.objectIndex = objectIndex;
        }

        @Override // shark.HeapObject
        public long getObjectId() {
            return this.objectId;
        }

        @Override // shark.HeapObject
        public int getObjectIndex() {
            return this.objectIndex;
        }

        @Override // shark.HeapObject
        public HeapGraph getGraph() {
            return this.hprofGraph;
        }

        public final boolean isPrimitiveWrapperClass() {
            return HeapObject.primitiveWrapperClassNames.contains(getName());
        }

        public final String getName() {
            return this.hprofGraph.className$shark_graph(getObjectId());
        }

        public final String getSimpleName() {
            return HeapObject.Companion.classSimpleName(getName());
        }

        public final int getInstanceByteSize() {
            return this.indexedObject.getInstanceSize();
        }

        @Override // shark.HeapObject
        public int getRecordSize() {
            return (int) this.indexedObject.getRecordSize();
        }

        public final boolean getHasReferenceInstanceFields() {
            return this.hprofGraph.classDumpHasReferenceFields$shark_graph(this.indexedObject);
        }

        public final boolean isArrayClass() {
            return StringsKt.endsWith$default(getName(), "[]", false, 2, (Object) null);
        }

        public final boolean isPrimitiveArrayClass() {
            return HeapObject.Companion.getPrimitiveTypesByPrimitiveArrayClassName$shark_graph().containsKey(getName());
        }

        public final boolean isObjectArrayClass() {
            return isArrayClass() && !isPrimitiveArrayClass();
        }

        public final int readFieldsByteSize() {
            int intValue;
            Iterable $this$sumBy$iv = readRecordFields();
            int sum$iv = 0;
            for (Object element$iv : $this$sumBy$iv) {
                HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord it = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) element$iv;
                if (it.getType() == 2) {
                    intValue = this.hprofGraph.getIdentifierByteSize();
                } else {
                    intValue = ((Number) MapsKt.getValue(PrimitiveType.Companion.getByteSizeByHprofType(), Integer.valueOf(it.getType()))).intValue();
                }
                sum$iv += intValue;
            }
            return sum$iv;
        }

        public final HeapClass getSuperclass() {
            if (this.indexedObject.getSuperclassId() == 0) {
                return null;
            }
            HeapObject findObjectById = this.hprofGraph.findObjectById(this.indexedObject.getSuperclassId());
            if (findObjectById != null) {
                return (HeapClass) findObjectById;
            }
            throw new TypeCastException("null cannot be cast to non-null type shark.HeapObject.HeapClass");
        }

        public final Sequence<HeapClass> getClassHierarchy() {
            return SequencesKt.generateSequence(this, new Function1<HeapClass, HeapClass>() { // from class: shark.HeapObject$HeapClass$classHierarchy$1
                public final HeapObject.HeapClass invoke(HeapObject.HeapClass it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return it.getSuperclass();
                }
            });
        }

        public final Sequence<HeapClass> getSubclasses() {
            return SequencesKt.filter(this.hprofGraph.getClasses(), new Function1<HeapClass, Boolean>() { // from class: shark.HeapObject$HeapClass$subclasses$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject.HeapClass) obj));
                }

                public final boolean invoke(HeapObject.HeapClass it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return it.subclassOf(HeapObject.HeapClass.this);
                }
            });
        }

        public final boolean superclassOf(HeapClass subclass) {
            boolean z;
            Intrinsics.checkParameterIsNotNull(subclass, "subclass");
            Sequence $this$any$iv = subclass.getClassHierarchy();
            Iterator it = $this$any$iv.iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    return false;
                }
                Object element$iv = it.next();
                HeapClass it2 = (HeapClass) element$iv;
                if (it2.getObjectId() == getObjectId()) {
                    z = true;
                    continue;
                }
            } while (!z);
            return true;
        }

        public final boolean subclassOf(HeapClass superclass) {
            Sequence $this$any$iv;
            HeapClass it;
            Intrinsics.checkParameterIsNotNull(superclass, "superclass");
            if (superclass.getObjectId() != getObjectId()) {
                Sequence $this$any$iv2 = getClassHierarchy();
                Iterator it2 = $this$any$iv2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        HeapClass it3 = (HeapClass) element$iv;
                        if (it3.getObjectId() == superclass.getObjectId()) {
                            it = 1;
                            continue;
                        } else {
                            it = null;
                            continue;
                        }
                        if (it != null) {
                            $this$any$iv = 1;
                            break;
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
                return $this$any$iv != null;
            }
            return false;
        }

        public final Sequence<HeapInstance> getInstances() {
            if (!isArrayClass()) {
                return SequencesKt.filter(this.hprofGraph.getInstances(), new Function1<HeapInstance, Boolean>() { // from class: shark.HeapObject$HeapClass$instances$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Boolean.valueOf(invoke((HeapObject.HeapInstance) obj));
                    }

                    public final boolean invoke(HeapObject.HeapInstance it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        return it.instanceOf(HeapObject.HeapClass.this);
                    }
                });
            }
            return SequencesKt.emptySequence();
        }

        public final Sequence<HeapObjectArray> getObjectArrayInstances() {
            if (isObjectArrayClass()) {
                return SequencesKt.filter(this.hprofGraph.getObjectArrays(), new Function1<HeapObjectArray, Boolean>() { // from class: shark.HeapObject$HeapClass$objectArrayInstances$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Boolean.valueOf(invoke((HeapObject.HeapObjectArray) obj));
                    }

                    public final boolean invoke(HeapObject.HeapObjectArray it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        return it.getIndexedObject$shark_graph().getArrayClassId() == HeapObject.HeapClass.this.getObjectId();
                    }
                });
            }
            return SequencesKt.emptySequence();
        }

        public final Sequence<HeapPrimitiveArray> getPrimitiveArrayInstances() {
            final PrimitiveType primitiveType = HeapObject.Companion.getPrimitiveTypesByPrimitiveArrayClassName$shark_graph().get(getName());
            if (primitiveType != null) {
                return SequencesKt.filter(this.hprofGraph.getPrimitiveArrays(), new Function1<HeapPrimitiveArray, Boolean>() { // from class: shark.HeapObject$HeapClass$primitiveArrayInstances$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Boolean.valueOf(invoke((HeapObject.HeapPrimitiveArray) obj));
                    }

                    public final boolean invoke(HeapObject.HeapPrimitiveArray it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        return it.getPrimitiveType() == PrimitiveType.this;
                    }
                });
            }
            return SequencesKt.emptySequence();
        }

        public final Sequence<HeapInstance> getDirectInstances() {
            return SequencesKt.filter(this.hprofGraph.getInstances(), new Function1<HeapInstance, Boolean>() { // from class: shark.HeapObject$HeapClass$directInstances$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapObject.HeapInstance) obj));
                }

                public final boolean invoke(HeapObject.HeapInstance it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return it.getIndexedObject$shark_graph().getClassId() == HeapObject.HeapClass.this.getObjectId();
                }
            });
        }

        @Override // shark.HeapObject
        public HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord readRecord() {
            return this.hprofGraph.readClassDumpRecord$shark_graph(getObjectId(), this.indexedObject);
        }

        public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> readRecordStaticFields() {
            return this.hprofGraph.classDumpStaticFields$shark_graph(this.indexedObject);
        }

        public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> readRecordFields() {
            return this.hprofGraph.classDumpFields$shark_graph(this.indexedObject);
        }

        public final String instanceFieldName(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord) {
            Intrinsics.checkParameterIsNotNull(fieldRecord, "fieldRecord");
            return this.hprofGraph.fieldName$shark_graph(getObjectId(), fieldRecord);
        }

        public final Sequence<HeapField> readStaticFields() {
            return SequencesKt.map(CollectionsKt.asSequence(readRecordStaticFields()), new Function1<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord, HeapField>() { // from class: shark.HeapObject$HeapClass$readStaticFields$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final HeapField invoke(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord fieldRecord) {
                    HprofHeapGraph hprofHeapGraph;
                    HprofHeapGraph hprofHeapGraph2;
                    Intrinsics.checkParameterIsNotNull(fieldRecord, "fieldRecord");
                    HeapObject.HeapClass heapClass = HeapObject.HeapClass.this;
                    hprofHeapGraph = HeapObject.HeapClass.this.hprofGraph;
                    String staticFieldName$shark_graph = hprofHeapGraph.staticFieldName$shark_graph(HeapObject.HeapClass.this.getObjectId(), fieldRecord);
                    hprofHeapGraph2 = HeapObject.HeapClass.this.hprofGraph;
                    return new HeapField(heapClass, staticFieldName$shark_graph, new HeapValue(hprofHeapGraph2, fieldRecord.getValue()));
                }
            });
        }

        public final HeapField readStaticField(String fieldName) {
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            for (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord fieldRecord : readRecordStaticFields()) {
                String recordFieldName = this.hprofGraph.staticFieldName$shark_graph(getObjectId(), fieldRecord);
                if (Intrinsics.areEqual(recordFieldName, fieldName)) {
                    return new HeapField(this, fieldName, new HeapValue(this.hprofGraph, fieldRecord.getValue()));
                }
            }
            return null;
        }

        public final HeapField get(String fieldName) {
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            return readStaticField(fieldName);
        }

        public String toString() {
            return "class " + getName();
        }
    }

    /* compiled from: HeapObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001cH\u0086\u0002J#\u0010(\u001a\u0004\u0018\u00010)2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0-2\u0006\u0010+\u001a\u00020\u001cH\u0086\u0002J\u0011\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u001cH\u0086\u0004J\u0015\u0010/\u001a\u00020\"2\n\u00101\u001a\u0006\u0012\u0002\b\u00030-H\u0086\u0004J\u0011\u0010/\u001a\u00020\"2\u0006\u00101\u001a\u00020\u0015H\u0086\u0004J\b\u00102\u001a\u0004\u0018\u00010\u001cJ\u0018\u00103\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001cJ \u00103\u001a\u0004\u0018\u00010)2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0-2\u0006\u0010+\u001a\u00020\u001cJ\f\u00104\u001a\b\u0012\u0004\u0012\u00020)05J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u001cH\u0016R\u0011\u0010\u000b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b!\u0010#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u0014\u0010&\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\r¨\u00069"}, d2 = {"Lshark/HeapObject$HeapInstance;", "Lshark/HeapObject;", "hprofGraph", "Lshark/HprofHeapGraph;", "indexedObject", "Lshark/internal/IndexedObject$IndexedInstance;", "objectId", "", "objectIndex", "", "(Lshark/HprofHeapGraph;Lshark/internal/IndexedObject$IndexedInstance;JI)V", "byteSize", "getByteSize", "()I", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "getIndexedObject$shark_graph", "()Lshark/internal/IndexedObject$IndexedInstance;", "instanceClass", "Lshark/HeapObject$HeapClass;", "getInstanceClass", "()Lshark/HeapObject$HeapClass;", "instanceClassId", "getInstanceClassId", "()J", "instanceClassName", "", "getInstanceClassName", "()Ljava/lang/String;", "instanceClassSimpleName", "getInstanceClassSimpleName", "isPrimitiveWrapper", "", "()Z", "getObjectId", "getObjectIndex", "recordSize", "getRecordSize", "get", "Lshark/HeapField;", "declaringClassName", "fieldName", "declaringClass", "Lkotlin/reflect/KClass;", "", "instanceOf", "className", "expectedClass", "readAsJavaString", "readField", "readFields", "Lkotlin/sequences/Sequence;", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "toString", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HeapInstance extends HeapObject {
        private final HprofHeapGraph hprofGraph;
        private final IndexedObject.IndexedInstance indexedObject;
        private final long objectId;
        private final int objectIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeapInstance(HprofHeapGraph hprofGraph, IndexedObject.IndexedInstance indexedObject, long objectId, int objectIndex) {
            super(null);
            Intrinsics.checkParameterIsNotNull(hprofGraph, "hprofGraph");
            Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
            this.hprofGraph = hprofGraph;
            this.indexedObject = indexedObject;
            this.objectId = objectId;
            this.objectIndex = objectIndex;
        }

        public final IndexedObject.IndexedInstance getIndexedObject$shark_graph() {
            return this.indexedObject;
        }

        @Override // shark.HeapObject
        public long getObjectId() {
            return this.objectId;
        }

        @Override // shark.HeapObject
        public int getObjectIndex() {
            return this.objectIndex;
        }

        public final boolean isPrimitiveWrapper() {
            return HeapObject.primitiveWrapperClassNames.contains(getInstanceClassName());
        }

        @Override // shark.HeapObject
        public HeapGraph getGraph() {
            return this.hprofGraph;
        }

        public final int getByteSize() {
            return getInstanceClass().getInstanceByteSize();
        }

        public final String getInstanceClassName() {
            return this.hprofGraph.className$shark_graph(this.indexedObject.getClassId());
        }

        public final String getInstanceClassSimpleName() {
            return HeapObject.Companion.classSimpleName(getInstanceClassName());
        }

        public final HeapClass getInstanceClass() {
            HeapObject findObjectById = this.hprofGraph.findObjectById(this.indexedObject.getClassId());
            if (findObjectById != null) {
                return (HeapClass) findObjectById;
            }
            throw new TypeCastException("null cannot be cast to non-null type shark.HeapObject.HeapClass");
        }

        public final long getInstanceClassId() {
            return this.indexedObject.getClassId();
        }

        @Override // shark.HeapObject
        public HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord readRecord() {
            return this.hprofGraph.readInstanceDumpRecord$shark_graph(getObjectId(), this.indexedObject);
        }

        @Override // shark.HeapObject
        public int getRecordSize() {
            return (int) this.indexedObject.getRecordSize();
        }

        public final boolean instanceOf(String className) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Sequence $this$any$iv = getInstanceClass().getClassHierarchy();
            for (Object element$iv : $this$any$iv) {
                HeapClass it = (HeapClass) element$iv;
                if (Intrinsics.areEqual(it.getName(), className)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean instanceOf(KClass<?> kClass) {
            Intrinsics.checkParameterIsNotNull(kClass, "expectedClass");
            String name = JvmClassMappingKt.getJavaClass(kClass).getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "expectedClass.java.name");
            return instanceOf(name);
        }

        public final boolean instanceOf(HeapClass expectedClass) {
            boolean z;
            Intrinsics.checkParameterIsNotNull(expectedClass, "expectedClass");
            Sequence $this$any$iv = getInstanceClass().getClassHierarchy();
            Iterator it = $this$any$iv.iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    return false;
                }
                Object element$iv = it.next();
                HeapClass it2 = (HeapClass) element$iv;
                if (it2.getObjectId() == expectedClass.getObjectId()) {
                    z = true;
                    continue;
                }
            } while (!z);
            return true;
        }

        public final HeapField readField(KClass<? extends Object> kClass, String fieldName) {
            Intrinsics.checkParameterIsNotNull(kClass, "declaringClass");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            String name = JvmClassMappingKt.getJavaClass(kClass).getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "declaringClass.java.name");
            return readField(name, fieldName);
        }

        public final HeapField readField(String declaringClassName, String fieldName) {
            Object element$iv;
            boolean z;
            Intrinsics.checkParameterIsNotNull(declaringClassName, "declaringClassName");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            Sequence $this$firstOrNull$iv = readFields();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    HeapField field = (HeapField) element$iv;
                    if (Intrinsics.areEqual(field.getDeclaringClass().getName(), declaringClassName) && Intrinsics.areEqual(field.getName(), fieldName)) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            return (HeapField) element$iv;
        }

        public final HeapField get(KClass<? extends Object> kClass, String fieldName) {
            Intrinsics.checkParameterIsNotNull(kClass, "declaringClass");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            return readField(kClass, fieldName);
        }

        public final HeapField get(String declaringClassName, String fieldName) {
            Intrinsics.checkParameterIsNotNull(declaringClassName, "declaringClassName");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            return readField(declaringClassName, fieldName);
        }

        public final Sequence<HeapField> readFields() {
            final Lazy fieldReader = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<FieldValuesReader>() { // from class: shark.HeapObject$HeapInstance$readFields$fieldReader$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final FieldValuesReader invoke() {
                    HprofHeapGraph hprofHeapGraph;
                    hprofHeapGraph = HeapObject.HeapInstance.this.hprofGraph;
                    return hprofHeapGraph.createFieldValuesReader$shark_graph(HeapObject.HeapInstance.this.readRecord());
                }
            });
            return SequencesKt.flatten(SequencesKt.map(getInstanceClass().getClassHierarchy(), new Function1<HeapClass, Sequence<? extends HeapField>>() { // from class: shark.HeapObject$HeapInstance$readFields$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Sequence<HeapField> invoke(final HeapObject.HeapClass heapClass) {
                    Intrinsics.checkParameterIsNotNull(heapClass, "heapClass");
                    return SequencesKt.map(CollectionsKt.asSequence(heapClass.readRecordFields()), new Function1<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord, HeapField>() { // from class: shark.HeapObject$HeapInstance$readFields$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final HeapField invoke(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord) {
                            HprofHeapGraph hprofHeapGraph;
                            HprofHeapGraph hprofHeapGraph2;
                            Intrinsics.checkParameterIsNotNull(fieldRecord, "fieldRecord");
                            hprofHeapGraph = HeapObject.HeapInstance.this.hprofGraph;
                            String fieldName = hprofHeapGraph.fieldName$shark_graph(heapClass.getObjectId(), fieldRecord);
                            Lazy lazy = fieldReader;
                            KProperty kProperty = r3;
                            ValueHolder fieldValue = ((FieldValuesReader) lazy.getValue()).readValue(fieldRecord);
                            HeapObject.HeapClass heapClass2 = heapClass;
                            hprofHeapGraph2 = HeapObject.HeapInstance.this.hprofGraph;
                            return new HeapField(heapClass2, fieldName, new HeapValue(hprofHeapGraph2, fieldValue));
                        }
                    });
                }
            }));
        }

        public final String readAsJavaString() {
            char[] chars;
            int toIndex;
            HeapValue value;
            HeapValue value2;
            Integer num = null;
            if (Intrinsics.areEqual(getInstanceClassName(), "java.lang.String")) {
                HeapField heapField = get("java.lang.String", "count");
                Integer count = (heapField == null || (value2 = heapField.getValue()) == null) ? null : value2.getAsInt();
                if (count != null && count.intValue() == 0) {
                    return "";
                }
                HeapField heapField2 = get("java.lang.String", "value");
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                HeapObject asObject = heapField2.getValue().getAsObject();
                if (asObject == null) {
                    Intrinsics.throwNpe();
                }
                HprofRecord.HeapDumpRecord.ObjectRecord valueRecord = asObject.readRecord();
                if (valueRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) {
                    HeapField heapField3 = get("java.lang.String", "offset");
                    if (heapField3 != null && (value = heapField3.getValue()) != null) {
                        num = value.getAsInt();
                    }
                    Integer offset = num;
                    if (count != null && offset != null) {
                        if (offset.intValue() + count.intValue() > ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) valueRecord).getArray().length) {
                            toIndex = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) valueRecord).getArray().length;
                        } else {
                            toIndex = offset.intValue() + count.intValue();
                        }
                        chars = ArraysKt.copyOfRange(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) valueRecord).getArray(), offset.intValue(), toIndex);
                    } else {
                        chars = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) valueRecord).getArray();
                    }
                    return new String(chars);
                } else if (valueRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) {
                    byte[] array = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) valueRecord).getArray();
                    Charset forName = Charset.forName("UTF-8");
                    Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(\"UTF-8\")");
                    return new String(array, forName);
                } else {
                    StringBuilder append = new StringBuilder().append("'value' field ");
                    HeapField heapField4 = get("java.lang.String", "value");
                    if (heapField4 == null) {
                        Intrinsics.throwNpe();
                    }
                    throw new UnsupportedOperationException(append.append(heapField4.getValue()).append(" was expected to be either").append(" a char or byte array in string instance with id ").append(getObjectId()).toString());
                }
            }
            return null;
        }

        public String toString() {
            return "instance @" + getObjectId() + " of " + getInstanceClassName();
        }
    }

    /* compiled from: HeapObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010%\u001a\u00020\tH\u0007J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0014\u0010#\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001a¨\u0006,"}, d2 = {"Lshark/HeapObject$HeapObjectArray;", "Lshark/HeapObject;", "hprofGraph", "Lshark/HprofHeapGraph;", "indexedObject", "Lshark/internal/IndexedObject$IndexedObjectArray;", "objectId", "", "objectIndex", "", "(Lshark/HprofHeapGraph;Lshark/internal/IndexedObject$IndexedObjectArray;JI)V", "arrayClass", "Lshark/HeapObject$HeapClass;", "getArrayClass", "()Lshark/HeapObject$HeapClass;", "arrayClassId", "getArrayClassId", "()J", "arrayClassName", "", "getArrayClassName", "()Ljava/lang/String;", "arrayClassSimpleName", "getArrayClassSimpleName", "byteSize", "getByteSize", "()I", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "getIndexedObject$shark_graph", "()Lshark/internal/IndexedObject$IndexedObjectArray;", "getObjectId", "getObjectIndex", "recordSize", "getRecordSize", "readByteSize", "readElements", "Lkotlin/sequences/Sequence;", "Lshark/HeapValue;", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "toString", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HeapObjectArray extends HeapObject {
        private final HprofHeapGraph hprofGraph;
        private final IndexedObject.IndexedObjectArray indexedObject;
        private final long objectId;
        private final int objectIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeapObjectArray(HprofHeapGraph hprofGraph, IndexedObject.IndexedObjectArray indexedObject, long objectId, int objectIndex) {
            super(null);
            Intrinsics.checkParameterIsNotNull(hprofGraph, "hprofGraph");
            Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
            this.hprofGraph = hprofGraph;
            this.indexedObject = indexedObject;
            this.objectId = objectId;
            this.objectIndex = objectIndex;
        }

        public final IndexedObject.IndexedObjectArray getIndexedObject$shark_graph() {
            return this.indexedObject;
        }

        @Override // shark.HeapObject
        public long getObjectId() {
            return this.objectId;
        }

        @Override // shark.HeapObject
        public int getObjectIndex() {
            return this.objectIndex;
        }

        @Override // shark.HeapObject
        public HeapGraph getGraph() {
            return this.hprofGraph;
        }

        public final String getArrayClassName() {
            return this.hprofGraph.className$shark_graph(this.indexedObject.getArrayClassId());
        }

        public final String getArrayClassSimpleName() {
            return HeapObject.Companion.classSimpleName(getArrayClassName());
        }

        public final HeapClass getArrayClass() {
            HeapObject findObjectById = this.hprofGraph.findObjectById(this.indexedObject.getArrayClassId());
            if (findObjectById != null) {
                return (HeapClass) findObjectById;
            }
            throw new TypeCastException("null cannot be cast to non-null type shark.HeapObject.HeapClass");
        }

        public final long getArrayClassId() {
            return this.indexedObject.getArrayClassId();
        }

        @Deprecated(message = "Use byteSize property instead", replaceWith = @ReplaceWith(expression = "byteSize", imports = {}))
        public final int readByteSize() {
            return getByteSize();
        }

        public final int getByteSize() {
            return getRecordSize() - this.hprofGraph.getObjectArrayRecordNonElementSize$shark_graph();
        }

        @Override // shark.HeapObject
        public HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord readRecord() {
            return this.hprofGraph.readObjectArrayDumpRecord$shark_graph(getObjectId(), this.indexedObject);
        }

        @Override // shark.HeapObject
        public int getRecordSize() {
            return (int) this.indexedObject.getRecordSize();
        }

        public final Sequence<HeapValue> readElements() {
            return SequencesKt.map(ArraysKt.asSequence(readRecord().getElementIds()), new Function1<Long, HeapValue>() { // from class: shark.HeapObject$HeapObjectArray$readElements$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).longValue());
                }

                public final HeapValue invoke(long it) {
                    HprofHeapGraph hprofHeapGraph;
                    hprofHeapGraph = HeapObject.HeapObjectArray.this.hprofGraph;
                    return new HeapValue(hprofHeapGraph, new ValueHolder.ReferenceHolder(it));
                }
            });
        }

        public String toString() {
            return "object array @" + getObjectId() + " of " + getArrayClassName();
        }
    }

    /* compiled from: HeapObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010#\u001a\u00020\tH\u0007J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015¨\u0006'"}, d2 = {"Lshark/HeapObject$HeapPrimitiveArray;", "Lshark/HeapObject;", "hprofGraph", "Lshark/HprofHeapGraph;", "indexedObject", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "objectId", "", "objectIndex", "", "(Lshark/HprofHeapGraph;Lshark/internal/IndexedObject$IndexedPrimitiveArray;JI)V", "arrayClass", "Lshark/HeapObject$HeapClass;", "getArrayClass", "()Lshark/HeapObject$HeapClass;", "arrayClassName", "", "getArrayClassName", "()Ljava/lang/String;", "byteSize", "getByteSize", "()I", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "getObjectId", "()J", "getObjectIndex", "primitiveType", "Lshark/PrimitiveType;", "getPrimitiveType", "()Lshark/PrimitiveType;", "recordSize", "getRecordSize", "readByteSize", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "toString", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HeapPrimitiveArray extends HeapObject {
        private final HprofHeapGraph hprofGraph;
        private final IndexedObject.IndexedPrimitiveArray indexedObject;
        private final long objectId;
        private final int objectIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeapPrimitiveArray(HprofHeapGraph hprofGraph, IndexedObject.IndexedPrimitiveArray indexedObject, long objectId, int objectIndex) {
            super(null);
            Intrinsics.checkParameterIsNotNull(hprofGraph, "hprofGraph");
            Intrinsics.checkParameterIsNotNull(indexedObject, "indexedObject");
            this.hprofGraph = hprofGraph;
            this.indexedObject = indexedObject;
            this.objectId = objectId;
            this.objectIndex = objectIndex;
        }

        @Override // shark.HeapObject
        public long getObjectId() {
            return this.objectId;
        }

        @Override // shark.HeapObject
        public int getObjectIndex() {
            return this.objectIndex;
        }

        @Override // shark.HeapObject
        public HeapGraph getGraph() {
            return this.hprofGraph;
        }

        @Deprecated(message = "Use byteSize property instead", replaceWith = @ReplaceWith(expression = "byteSize", imports = {}))
        public final int readByteSize() {
            return getByteSize();
        }

        public final int getByteSize() {
            return getRecordSize() - this.hprofGraph.getPrimitiveArrayRecordNonElementSize$shark_graph();
        }

        public final PrimitiveType getPrimitiveType() {
            return this.indexedObject.getPrimitiveType();
        }

        public final String getArrayClassName() {
            StringBuilder sb = new StringBuilder();
            String name = getPrimitiveType().name();
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (name != null) {
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return sb.append(lowerCase).append("[]").toString();
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        public final HeapClass getArrayClass() {
            HeapClass findClassByName = getGraph().findClassByName(getArrayClassName());
            if (findClassByName == null) {
                Intrinsics.throwNpe();
            }
            return findClassByName;
        }

        @Override // shark.HeapObject
        public HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readRecord() {
            return this.hprofGraph.readPrimitiveArrayDumpRecord$shark_graph(getObjectId(), this.indexedObject);
        }

        @Override // shark.HeapObject
        public int getRecordSize() {
            return (int) this.indexedObject.getRecordSize();
        }

        public String toString() {
            return "primitive array @" + getObjectId() + " of " + getArrayClassName();
        }
    }

    /* compiled from: HeapObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lshark/HeapObject$Companion;", "", "()V", "primitiveTypesByPrimitiveArrayClassName", "", "", "Lshark/PrimitiveType;", "getPrimitiveTypesByPrimitiveArrayClassName$shark_graph", "()Ljava/util/Map;", "primitiveWrapperClassNames", "", "classSimpleName", "className", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Map<String, PrimitiveType> getPrimitiveTypesByPrimitiveArrayClassName$shark_graph() {
            return HeapObject.primitiveTypesByPrimitiveArrayClassName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String classSimpleName(String className) {
            int separator = StringsKt.lastIndexOf$default(className, '.', 0, false, 6, (Object) null);
            if (separator == -1) {
                return className;
            }
            int i = separator + 1;
            if (className != null) {
                String substring = className.substring(i);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    static {
        PrimitiveType[] values = PrimitiveType.values();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (PrimitiveType primitiveType : values) {
            StringBuilder sb = new StringBuilder();
            String name = primitiveType.name();
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (name == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            destination$iv$iv.put(sb.append(lowerCase).append("[]").toString(), primitiveType);
        }
        primitiveTypesByPrimitiveArrayClassName = destination$iv$iv;
        String name2 = Boolean.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "Boolean::class.javaObjectType.name");
        String name3 = Character.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name3, "Char::class.javaObjectType.name");
        String name4 = Float.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name4, "Float::class.javaObjectType.name");
        String name5 = Double.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name5, "Double::class.javaObjectType.name");
        String name6 = Byte.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name6, "Byte::class.javaObjectType.name");
        String name7 = Short.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name7, "Short::class.javaObjectType.name");
        String name8 = Integer.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name8, "Int::class.javaObjectType.name");
        String name9 = Long.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name9, "Long::class.javaObjectType.name");
        primitiveWrapperClassNames = SetsKt.setOf(new String[]{name2, name3, name4, name5, name6, name7, name8, name9});
    }
}