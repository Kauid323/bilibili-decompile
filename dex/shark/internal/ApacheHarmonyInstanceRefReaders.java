package shark.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HprofRecord;
import shark.internal.ChainingInstanceReferenceReader;

/* compiled from: ApacheHarmonyInstanceRefReaders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lshark/internal/ApacheHarmonyInstanceRefReaders;", "", "Lshark/internal/ChainingInstanceReferenceReader$VirtualInstanceReferenceReader$OptionalFactory;", "(Ljava/lang/String;I)V", "LINKED_LIST", "ARRAY_LIST", "COPY_ON_WRITE_ARRAY_LIST", "HASH_MAP", "HASH_SET", "shark"}, k = 1, mv = {1, 4, 1})
public enum ApacheHarmonyInstanceRefReaders implements ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory {
    LINKED_LIST { // from class: shark.internal.ApacheHarmonyInstanceRefReaders.LINKED_LIST
        @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
        public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            HeapObject.HeapClass linkedListClass = graph.findClassByName("java.util.LinkedList");
            if (linkedListClass != null) {
                Iterable $this$any$iv = linkedListClass.readRecordFields();
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object element$iv = it.next();
                        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord it2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) element$iv;
                        if (Intrinsics.areEqual(linkedListClass.instanceFieldName(it2), "voidLink")) {
                            z = true;
                            break;
                        }
                    }
                }
                boolean isApacheHarmonyImpl = z;
                if (isApacheHarmonyImpl) {
                    return new InternalSharedLinkedListReferenceReader(linkedListClass.getObjectId(), "voidLink", "java.util.LinkedList$Link", "next", "data");
                }
                return null;
            }
            return null;
        }
    },
    ARRAY_LIST { // from class: shark.internal.ApacheHarmonyInstanceRefReaders.ARRAY_LIST
        @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
        public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            HeapObject.HeapClass arrayListClass = graph.findClassByName("java.util.ArrayList");
            if (arrayListClass != null) {
                Iterable $this$any$iv = arrayListClass.readRecordFields();
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object element$iv = it.next();
                        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord it2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) element$iv;
                        if (Intrinsics.areEqual(arrayListClass.instanceFieldName(it2), "array")) {
                            z = true;
                            break;
                        }
                    }
                }
                boolean isApacheHarmonyImpl = z;
                if (isApacheHarmonyImpl) {
                    return new InternalSharedArrayListReferenceReader("java.util.ArrayList", arrayListClass.getObjectId(), "array", "size");
                }
                return null;
            }
            return null;
        }
    },
    COPY_ON_WRITE_ARRAY_LIST { // from class: shark.internal.ApacheHarmonyInstanceRefReaders.COPY_ON_WRITE_ARRAY_LIST
        @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
        public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            HeapObject.HeapClass arrayListClass = graph.findClassByName("java.util.concurrent.CopyOnWriteArrayList");
            if (arrayListClass != null) {
                Iterable $this$any$iv = arrayListClass.readRecordFields();
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object element$iv = it.next();
                        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord it2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) element$iv;
                        if (Intrinsics.areEqual(arrayListClass.instanceFieldName(it2), "elements")) {
                            z = true;
                            break;
                        }
                    }
                }
                boolean isApacheHarmonyImpl = z;
                if (isApacheHarmonyImpl) {
                    return new InternalSharedArrayListReferenceReader("java.util.concurrent.CopyOnWriteArrayList", arrayListClass.getObjectId(), "elements", null);
                }
                return null;
            }
            return null;
        }
    },
    HASH_MAP { // from class: shark.internal.ApacheHarmonyInstanceRefReaders.HASH_MAP
        @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
        public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            HeapObject.HeapClass hashMapClass = graph.findClassByName("java.util.HashMap");
            if (hashMapClass != null) {
                Iterable $this$any$iv = hashMapClass.readRecordFields();
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object element$iv = it.next();
                        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord it2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) element$iv;
                        if (Intrinsics.areEqual(hashMapClass.instanceFieldName(it2), "loadFactor")) {
                            z = true;
                            break;
                        }
                    }
                }
                boolean isOpenJdkImpl = z;
                if (isOpenJdkImpl) {
                    return null;
                }
                HeapObject.HeapClass linkedHashMapClass = graph.findClassByName("java.util.LinkedHashMap");
                final long hashMapClassId = hashMapClass.getObjectId();
                final long linkedHashMapClassId = linkedHashMapClass != null ? linkedHashMapClass.getObjectId() : 0L;
                return new InternalSharedHashMapReferenceReader("java.util.HashMap", "table", "java.util.HashMap$HashMapEntry", "next", "key", "value", "key()", false, new Function1<HeapObject.HeapInstance, Boolean>() { // from class: shark.internal.ApacheHarmonyInstanceRefReaders$HASH_MAP$create$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Boolean.valueOf(invoke((HeapObject.HeapInstance) obj));
                    }

                    public final boolean invoke(HeapObject.HeapInstance it3) {
                        Intrinsics.checkParameterIsNotNull(it3, "it");
                        long instanceClassId = it3.getInstanceClassId();
                        return instanceClassId == hashMapClassId || instanceClassId == linkedHashMapClassId;
                    }
                }, new Function1<HeapObject.HeapInstance, Long>() { // from class: shark.internal.ApacheHarmonyInstanceRefReaders$HASH_MAP$create$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Long.valueOf(invoke((HeapObject.HeapInstance) obj));
                    }

                    public final long invoke(HeapObject.HeapInstance it3) {
                        Intrinsics.checkParameterIsNotNull(it3, "it");
                        return it3.getInstanceClassId();
                    }
                });
            }
            return null;
        }
    },
    HASH_SET { // from class: shark.internal.ApacheHarmonyInstanceRefReaders.HASH_SET
        @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader.OptionalFactory
        public ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create(HeapGraph graph) {
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            HeapObject.HeapClass hashSetClass = graph.findClassByName("java.util.HashSet");
            if (hashSetClass != null) {
                Iterable $this$any$iv = hashSetClass.readRecordFields();
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object element$iv = it.next();
                        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord it2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) element$iv;
                        if (Intrinsics.areEqual(hashSetClass.instanceFieldName(it2), "backingMap")) {
                            z = true;
                            break;
                        }
                    }
                }
                boolean isApacheHarmonyImpl = z;
                if (isApacheHarmonyImpl) {
                    HeapObject.HeapClass linkedHashSetClass = graph.findClassByName("java.util.LinkedHashSet");
                    final long hashSetClassId = hashSetClass.getObjectId();
                    final long linkedHashSetClassId = linkedHashSetClass != null ? linkedHashSetClass.getObjectId() : 0L;
                    return new ChainingInstanceReferenceReader.VirtualInstanceReferenceReader() { // from class: shark.internal.ApacheHarmonyInstanceRefReaders$HASH_SET$create$1
                        @Override // shark.internal.ChainingInstanceReferenceReader.VirtualInstanceReferenceReader
                        public boolean matches(HeapObject.HeapInstance instance) {
                            Intrinsics.checkParameterIsNotNull(instance, "instance");
                            long instanceClassId = instance.getInstanceClassId();
                            return instanceClassId == hashSetClassId || instanceClassId == linkedHashSetClassId;
                        }

                        @Override // shark.internal.ReferenceReader
                        public Sequence<Reference> read(final HeapObject.HeapInstance instance) {
                            Intrinsics.checkParameterIsNotNull(instance, "instance");
                            HeapField heapField = instance.get("java.util.HashSet", "backingMap");
                            if (heapField == null) {
                                Intrinsics.throwNpe();
                            }
                            HeapObject.HeapInstance map = heapField.getValueAsInstance();
                            if (map == null) {
                                Intrinsics.throwNpe();
                            }
                            return new InternalSharedHashMapReferenceReader("java.util.HashMap", "table", "java.util.HashMap$HashMapEntry", "next", "key", "value", "element()", true, new Function1<HeapObject.HeapInstance, Boolean>() { // from class: shark.internal.ApacheHarmonyInstanceRefReaders$HASH_SET$create$1$read$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return Boolean.valueOf(invoke((HeapObject.HeapInstance) obj));
                                }

                                public final boolean invoke(HeapObject.HeapInstance it3) {
                                    Intrinsics.checkParameterIsNotNull(it3, "it");
                                    return true;
                                }
                            }, new Function1<HeapObject.HeapInstance, Long>() { // from class: shark.internal.ApacheHarmonyInstanceRefReaders$HASH_SET$create$1$read$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return Long.valueOf(invoke((HeapObject.HeapInstance) obj));
                                }

                                public final long invoke(HeapObject.HeapInstance it3) {
                                    Intrinsics.checkParameterIsNotNull(it3, "it");
                                    return HeapObject.HeapInstance.this.getInstanceClassId();
                                }
                            }).read(map);
                        }
                    };
                }
                return null;
            }
            return null;
        }
    };

    /* synthetic */ ApacheHarmonyInstanceRefReaders(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}