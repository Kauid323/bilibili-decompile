package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import shark.HeapObject;
import shark.HprofRecord;

/* compiled from: AndroidResourceIdNames.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lshark/AndroidResourceIdNames;", "", "resourceIds", "", "names", "", "", "([I[Ljava/lang/String;)V", "[Ljava/lang/String;", "get", "id", "", "Companion", "shark-android"}, k = 1, mv = {1, 4, 1})
public final class AndroidResourceIdNames {
    public static final Companion Companion = new Companion(null);
    public static final int FIRST_APP_RESOURCE_ID = 2130771968;
    public static final int RESOURCE_ID_TYPE_ITERATOR = 65536;
    private static volatile AndroidResourceIdNames holderField;
    private final String[] names;
    private final int[] resourceIds;

    private AndroidResourceIdNames(int[] resourceIds, String[] names) {
        this.resourceIds = resourceIds;
        this.names = names;
    }

    public /* synthetic */ AndroidResourceIdNames(int[] resourceIds, String[] names, DefaultConstructorMarker $constructor_marker) {
        this(resourceIds, names);
    }

    public final String get(int id) {
        int indexOfId = ArraysKt.binarySearch$default(this.resourceIds, id, 0, 0, 6, (Object) null);
        if (indexOfId >= 0) {
            return this.names[indexOfId];
        }
        return null;
    }

    /* compiled from: AndroidResourceIdNames.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J2\u0010\u0014\u001a\u00020\u00122\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002¨\u0006\u0016"}, d2 = {"Lshark/AndroidResourceIdNames$Companion;", "", "()V", "FIRST_APP_RESOURCE_ID", "", "RESOURCE_ID_TYPE_ITERATOR", "holderField", "Lshark/AndroidResourceIdNames;", "getHolderField$annotations", "findIdTypeResourceIdStart", "getResourceTypeName", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "readFromHeap", "graph", "Lshark/HeapGraph;", "resetForTests", "", "resetForTests$shark_android", "saveToMemory", "getResourceEntryName", "shark-android"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        @JvmStatic
        private static /* synthetic */ void getHolderField$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final synchronized void saveToMemory(Function1<? super Integer, String> function1, Function1<? super Integer, String> function12) {
            Intrinsics.checkParameterIsNotNull(function1, "getResourceTypeName");
            Intrinsics.checkParameterIsNotNull(function12, "getResourceEntryName");
            if (AndroidResourceIdNames.holderField != null) {
                return;
            }
            Iterable idToNamePairs = (List) new ArrayList();
            Integer findIdTypeResourceIdStart = findIdTypeResourceIdStart(function1);
            if (findIdTypeResourceIdStart != null) {
                int idTypeResourceIdStart = findIdTypeResourceIdStart.intValue();
                int resourceId = idTypeResourceIdStart;
                while (true) {
                    String entry = (String) function12.invoke(Integer.valueOf(resourceId));
                    if (entry == null) {
                        break;
                    }
                    ((Collection) idToNamePairs).add(TuplesKt.to(Integer.valueOf(resourceId), entry));
                    resourceId++;
                }
            }
            Iterable $this$map$iv = idToNamePairs;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Pair it = (Pair) item$iv$iv;
                destination$iv$iv.add(Integer.valueOf(((Number) it.getFirst()).intValue()));
            }
            int[] resourceIds = CollectionsKt.toIntArray((List) destination$iv$iv);
            Iterable $this$map$iv2 = idToNamePairs;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                Pair it2 = (Pair) item$iv$iv2;
                destination$iv$iv2.add((String) it2.getSecond());
            }
            Collection thisCollection$iv = (List) destination$iv$iv2;
            Object[] array = thisCollection$iv.toArray(new String[0]);
            if (array != null) {
                String[] names = (String[]) array;
                AndroidResourceIdNames.holderField = new AndroidResourceIdNames(resourceIds, names, null);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        private final Integer findIdTypeResourceIdStart(Function1<? super Integer, String> function1) {
            int resourceTypeId = AndroidResourceIdNames.FIRST_APP_RESOURCE_ID;
            while (true) {
                String str = (String) function1.invoke(Integer.valueOf(resourceTypeId));
                if (str == null) {
                    return null;
                }
                switch (str.hashCode()) {
                    case 3355:
                        if (!str.equals("id")) {
                            break;
                        } else {
                            return Integer.valueOf(resourceTypeId);
                        }
                }
                resourceTypeId += AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
            }
        }

        public final AndroidResourceIdNames readFromHeap(final HeapGraph graph) {
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            GraphContext context = graph.getContext();
            String name = AndroidResourceIdNames.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "AndroidResourceIdNames::class.java.name");
            return (AndroidResourceIdNames) context.getOrPut(name, new Function0<AndroidResourceIdNames>() { // from class: shark.AndroidResourceIdNames$Companion$readFromHeap$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final AndroidResourceIdNames invoke() {
                    String className = AndroidResourceIdNames.class.getName();
                    HeapGraph heapGraph = HeapGraph.this;
                    Intrinsics.checkExpressionValueIsNotNull(className, "className");
                    HeapObject.HeapClass holderClass = heapGraph.findClassByName(className);
                    if (holderClass == null) {
                        return null;
                    }
                    HeapField holderField = holderClass.get("holderField");
                    if (holderField == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapInstance instance = holderField.getValueAsInstance();
                    if (instance == null) {
                        return null;
                    }
                    HeapField resourceIdsField = instance.get(className, "resourceIds");
                    if (resourceIdsField == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapPrimitiveArray resourceIdsArray = resourceIdsField.getValueAsPrimitiveArray();
                    if (resourceIdsArray == null) {
                        Intrinsics.throwNpe();
                    }
                    HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readRecord = resourceIdsArray.readRecord();
                    if (readRecord == null) {
                        throw new TypeCastException("null cannot be cast to non-null type shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump");
                    }
                    int[] resourceIds = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) readRecord).getArray();
                    HeapField heapField = instance.get(className, "names");
                    if (heapField == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapObjectArray valueAsObjectArray = heapField.getValueAsObjectArray();
                    if (valueAsObjectArray == null) {
                        Intrinsics.throwNpe();
                    }
                    Collection $this$toTypedArray$iv = SequencesKt.toList(SequencesKt.map(valueAsObjectArray.readElements(), new Function1<HeapValue, String>() { // from class: shark.AndroidResourceIdNames$Companion$readFromHeap$1$1$1$names$1
                        public final String invoke(HeapValue it) {
                            Intrinsics.checkParameterIsNotNull(it, "it");
                            String readAsJavaString = it.readAsJavaString();
                            if (readAsJavaString == null) {
                                Intrinsics.throwNpe();
                            }
                            return readAsJavaString;
                        }
                    }));
                    Object[] array = $this$toTypedArray$iv.toArray(new String[0]);
                    if (array != null) {
                        String[] names = (String[]) array;
                        return new AndroidResourceIdNames(resourceIds, names, null);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            });
        }

        public final void resetForTests$shark_android() {
            AndroidResourceIdNames.holderField = null;
        }
    }
}