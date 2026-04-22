package shark.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HeapValue;

/* compiled from: AndroidNativeSizeMapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lshark/internal/AndroidNativeSizeMapper;", "", "graph", "Lshark/HeapGraph;", "(Lshark/HeapGraph;)V", "buildNativeSizeMap", "", "", "", "mapNativeSizes", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public final class AndroidNativeSizeMapper {
    public static final Companion Companion = new Companion(null);
    private final HeapGraph graph;

    public AndroidNativeSizeMapper(HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        this.graph = graph;
    }

    public final Map<Long, Integer> mapNativeSizes() {
        return (Map) this.graph.getContext().getOrPut("AndroidNativeSizeMapper", new Function0<Map<Long, ? extends Integer>>() { // from class: shark.internal.AndroidNativeSizeMapper$mapNativeSizes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Map<Long, Integer> invoke() {
                Map<Long, Integer> buildNativeSizeMap;
                buildNativeSizeMap = AndroidNativeSizeMapper.this.buildNativeSizeMap();
                return buildNativeSizeMap;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Long, Integer> buildNativeSizeMap() {
        HeapObject.HeapClass cleanerClass;
        String str;
        HeapValue value;
        Long asLong;
        HeapValue value2;
        HeapValue value3;
        Map nativeSizes = new LinkedHashMap();
        String str2 = "sun.misc.Cleaner";
        HeapObject.HeapClass cleanerClass2 = this.graph.findClassByName("sun.misc.Cleaner");
        if (cleanerClass2 != null) {
            Sequence $this$forEach$iv = cleanerClass2.getDirectInstances();
            for (Object element$iv : $this$forEach$iv) {
                HeapObject.HeapInstance cleaner = (HeapObject.HeapInstance) element$iv;
                HeapField thunkField = cleaner.get(str2, "thunk");
                Long referentId = null;
                Long thunkId = (thunkField == null || (value3 = thunkField.getValue()) == null) ? null : value3.getAsNonNullObjectId();
                HeapField heapField = cleaner.get("java.lang.ref.Reference", "referent");
                if (heapField != null && (value2 = heapField.getValue()) != null) {
                    referentId = value2.getAsNonNullObjectId();
                }
                if (thunkId == null || referentId == null) {
                    cleanerClass = cleanerClass2;
                    str = str2;
                } else {
                    HeapObject thunkRecord = thunkField.getValue().getAsObject();
                    if (!(thunkRecord instanceof HeapObject.HeapInstance) || !((HeapObject.HeapInstance) thunkRecord).instanceOf("libcore.util.NativeAllocationRegistry$CleanerThunk")) {
                        cleanerClass = cleanerClass2;
                        str = str2;
                    } else {
                        cleanerClass = cleanerClass2;
                        HeapField allocationRegistryIdField = ((HeapObject.HeapInstance) thunkRecord).get("libcore.util.NativeAllocationRegistry$CleanerThunk", "this$0");
                        if (allocationRegistryIdField == null || !allocationRegistryIdField.getValue().isNonNullReference()) {
                            str = str2;
                        } else {
                            HeapObject allocationRegistryRecord = allocationRegistryIdField.getValue().getAsObject();
                            if (!(allocationRegistryRecord instanceof HeapObject.HeapInstance)) {
                                str = str2;
                            } else if (((HeapObject.HeapInstance) allocationRegistryRecord).instanceOf("libcore.util.NativeAllocationRegistry")) {
                                Integer num = (Integer) nativeSizes.get(referentId);
                                int i = 0;
                                int nativeSize = num != null ? num.intValue() : 0;
                                str = str2;
                                HeapField heapField2 = ((HeapObject.HeapInstance) allocationRegistryRecord).get("libcore.util.NativeAllocationRegistry", "size");
                                if (heapField2 != null && (value = heapField2.getValue()) != null && (asLong = value.getAsLong()) != null) {
                                    i = (int) asLong.longValue();
                                }
                                nativeSizes.put(referentId, Integer.valueOf(nativeSize + i));
                            } else {
                                str = str2;
                            }
                        }
                    }
                }
                cleanerClass2 = cleanerClass;
                str2 = str;
            }
        }
        return nativeSizes;
    }

    /* compiled from: AndroidNativeSizeMapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lshark/internal/AndroidNativeSizeMapper$Companion;", "", "()V", "mapNativeSizes", "", "", "", "heapGraph", "Lshark/HeapGraph;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Map<Long, Integer> mapNativeSizes(HeapGraph heapGraph) {
            Intrinsics.checkParameterIsNotNull(heapGraph, "heapGraph");
            return new AndroidNativeSizeMapper(heapGraph).mapNativeSizes();
        }
    }
}