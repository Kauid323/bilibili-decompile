package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import shark.HeapObject;

/* compiled from: AndroidServices.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lshark/AndroidServices;", "", "()V", "aliveAndroidServiceObjectIds", "", "", "Lshark/HeapGraph;", "getAliveAndroidServiceObjectIds", "(Lshark/HeapGraph;)Ljava/util/List;", "shark-android"}, k = 1, mv = {1, 4, 1})
public final class AndroidServices {
    public static final AndroidServices INSTANCE = new AndroidServices();

    private AndroidServices() {
    }

    public final List<Long> getAliveAndroidServiceObjectIds(final HeapGraph $this$aliveAndroidServiceObjectIds) {
        Intrinsics.checkParameterIsNotNull($this$aliveAndroidServiceObjectIds, "$this$aliveAndroidServiceObjectIds");
        GraphContext context = $this$aliveAndroidServiceObjectIds.getContext();
        String name = AndroidServices.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "AndroidServices::class.java.name");
        return (List) context.getOrPut(name, new Function0<List<? extends Long>>() { // from class: shark.AndroidServices$aliveAndroidServiceObjectIds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final List<Long> invoke() {
                HeapObject.HeapClass activityThreadClass = HeapGraph.this.findClassByName("android.app.ActivityThread");
                if (activityThreadClass == null) {
                    Intrinsics.throwNpe();
                }
                HeapField readStaticField = activityThreadClass.readStaticField("sCurrentActivityThread");
                if (readStaticField == null) {
                    Intrinsics.throwNpe();
                }
                HeapObject.HeapInstance currentActivityThread = readStaticField.getValueAsInstance();
                if (currentActivityThread == null) {
                    Intrinsics.throwNpe();
                }
                HeapField heapField = currentActivityThread.get("android.app.ActivityThread", "mServices");
                if (heapField == null) {
                    Intrinsics.throwNpe();
                }
                HeapObject.HeapInstance mServices = heapField.getValueAsInstance();
                if (mServices == null) {
                    Intrinsics.throwNpe();
                }
                HeapField heapField2 = mServices.get("android.util.ArrayMap", "mArray");
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                HeapObject.HeapObjectArray servicesArray = heapField2.getValueAsObjectArray();
                if (servicesArray == null) {
                    Intrinsics.throwNpe();
                }
                return SequencesKt.toList(SequencesKt.map(SequencesKt.filterIndexed(servicesArray.readElements(), new Function2<Integer, HeapValue, Boolean>() { // from class: shark.AndroidServices$aliveAndroidServiceObjectIds$1.1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return Boolean.valueOf(invoke(((Number) obj).intValue(), (HeapValue) obj2));
                    }

                    public final boolean invoke(int index, HeapValue heapValue) {
                        Intrinsics.checkParameterIsNotNull(heapValue, "heapValue");
                        return index % 2 == 1 && heapValue.isNonNullReference();
                    }
                }), new Function1<HeapValue, Long>() { // from class: shark.AndroidServices$aliveAndroidServiceObjectIds$1.2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Long.valueOf(invoke((HeapValue) obj));
                    }

                    public final long invoke(HeapValue it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        Long asNonNullObjectId = it.getAsNonNullObjectId();
                        if (asNonNullObjectId == null) {
                            Intrinsics.throwNpe();
                        }
                        return asNonNullObjectId.longValue();
                    }
                }));
            }
        });
    }
}