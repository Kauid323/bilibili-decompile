package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.GcRoot;
import shark.HeapObject;
import shark.internal.AndroidNativeSizeMapper;

/* compiled from: AndroidMetadataExtractor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0011"}, d2 = {"Lshark/AndroidMetadataExtractor;", "Lshark/MetadataExtractor;", "()V", "extractMetadata", "", "", "graph", "Lshark/HeapGraph;", "readHeapTotalBytes", "", "readLeakCanaryVersion", "readProcessName", "readThreadCount", "putBitmaps", "", "", "putDbLabels", "shark-android"}, k = 1, mv = {1, 4, 1})
public final class AndroidMetadataExtractor implements MetadataExtractor {
    public static final AndroidMetadataExtractor INSTANCE = new AndroidMetadataExtractor();

    private AndroidMetadataExtractor() {
    }

    @Override // shark.MetadataExtractor
    public Map<String, String> extractMetadata(HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Map metadata = new LinkedHashMap();
        AndroidBuildMirror build = AndroidBuildMirror.Companion.fromHeapGraph(graph);
        metadata.put("Build.VERSION.SDK_INT", String.valueOf(build.getSdkInt()));
        metadata.put("Build.MANUFACTURER", build.getManufacturer());
        metadata.put("LeakCanary version", readLeakCanaryVersion(graph));
        metadata.put("App process name", readProcessName(graph));
        metadata.put("Class count", String.valueOf(graph.getClassCount()));
        metadata.put("Instance count", String.valueOf(graph.getInstanceCount()));
        metadata.put("Primitive array count", String.valueOf(graph.getPrimitiveArrayCount()));
        metadata.put("Object array count", String.valueOf(graph.getObjectArrayCount()));
        metadata.put("Thread count", String.valueOf(readThreadCount(graph)));
        metadata.put("Heap total bytes", String.valueOf(readHeapTotalBytes(graph)));
        putBitmaps(metadata, graph);
        putDbLabels(metadata, graph);
        return metadata;
    }

    private final int readHeapTotalBytes(HeapGraph graph) {
        int byteSize;
        Sequence $this$sumBy$iv = graph.getObjects();
        int sum$iv = 0;
        for (Object element$iv : $this$sumBy$iv) {
            HeapObject heapObject = (HeapObject) element$iv;
            if (heapObject instanceof HeapObject.HeapInstance) {
                byteSize = ((HeapObject.HeapInstance) heapObject).getByteSize();
            } else if (heapObject instanceof HeapObject.HeapClass) {
                byteSize = heapObject.getRecordSize();
            } else if (heapObject instanceof HeapObject.HeapObjectArray) {
                byteSize = ((HeapObject.HeapObjectArray) heapObject).getByteSize();
            } else if (!(heapObject instanceof HeapObject.HeapPrimitiveArray)) {
                throw new NoWhenBranchMatchedException();
            } else {
                byteSize = ((HeapObject.HeapPrimitiveArray) heapObject).getByteSize();
            }
            sum$iv += byteSize;
        }
        return sum$iv;
    }

    private final void putBitmaps(Map<String, String> map, HeapGraph graph) {
        int maxDisplayPixels;
        HeapValue value;
        Integer asInt;
        HeapValue value2;
        Integer asInt2;
        Sequence<HeapObject.HeapInstance> directInstances;
        Sequence map2;
        Integer num;
        String str = "android.graphics.Bitmap";
        HeapObject.HeapClass bitmapClass = graph.findClassByName("android.graphics.Bitmap");
        if (bitmapClass == null) {
            return;
        }
        HeapObject.HeapClass findClassByName = graph.findClassByName("android.util.DisplayMetrics");
        int maxDisplayPixels2 = (findClassByName == null || (directInstances = findClassByName.getDirectInstances()) == null || (map2 = SequencesKt.map(directInstances, new Function1<HeapObject.HeapInstance, Integer>() { // from class: shark.AndroidMetadataExtractor$putBitmaps$maxDisplayPixels$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Integer.valueOf(invoke((HeapObject.HeapInstance) obj));
            }

            public final int invoke(HeapObject.HeapInstance instance) {
                HeapValue value3;
                Integer asInt3;
                HeapValue value4;
                Integer asInt4;
                Intrinsics.checkParameterIsNotNull(instance, "instance");
                HeapField heapField = instance.get("android.util.DisplayMetrics", "widthPixels");
                int i = 0;
                int width = (heapField == null || (value4 = heapField.getValue()) == null || (asInt4 = value4.getAsInt()) == null) ? 0 : asInt4.intValue();
                HeapField heapField2 = instance.get("android.util.DisplayMetrics", "heightPixels");
                if (heapField2 != null && (value3 = heapField2.getValue()) != null && (asInt3 = value3.getAsInt()) != null) {
                    i = asInt3.intValue();
                }
                int height = i;
                return width * height;
            }
        })) == null || (num = (Integer) SequencesKt.max(map2)) == null) ? 0 : num.intValue();
        int maxDisplayPixelsWithThreshold = (int) (maxDisplayPixels2 * 1.1d);
        Map sizeMap = AndroidNativeSizeMapper.Companion.mapNativeSizes(graph);
        int sizeSum = 0;
        int count = 0;
        int largeBitmapCount = 0;
        int largeBitmapSizeSum = 0;
        Sequence $this$forEach$iv = bitmapClass.getInstances();
        for (Object element$iv : $this$forEach$iv) {
            HeapObject.HeapInstance bitmap = (HeapObject.HeapInstance) element$iv;
            HeapField heapField = bitmap.get(str, "mWidth");
            int width = (heapField == null || (value2 = heapField.getValue()) == null || (asInt2 = value2.getAsInt()) == null) ? 0 : asInt2.intValue();
            HeapObject.HeapClass bitmapClass2 = bitmapClass;
            HeapField heapField2 = bitmap.get(str, "mHeight");
            int height = (heapField2 == null || (value = heapField2.getValue()) == null || (asInt = value.getAsInt()) == null) ? 0 : asInt.intValue();
            String str2 = str;
            Integer num2 = sizeMap.get(Long.valueOf(bitmap.getObjectId()));
            int size = num2 != null ? num2.intValue() : 0;
            count++;
            sizeSum += size;
            if (maxDisplayPixelsWithThreshold > 0) {
                maxDisplayPixels = maxDisplayPixels2;
                if (width * height > maxDisplayPixelsWithThreshold) {
                    largeBitmapCount++;
                    largeBitmapSizeSum += size;
                }
            } else {
                maxDisplayPixels = maxDisplayPixels2;
            }
            bitmapClass = bitmapClass2;
            maxDisplayPixels2 = maxDisplayPixels;
            str = str2;
        }
        map.put("Bitmap count", String.valueOf(count));
        map.put("Bitmap total bytes", String.valueOf(sizeSum));
        map.put("Large bitmap count", String.valueOf(largeBitmapCount));
        map.put("Large bitmap total bytes", String.valueOf(largeBitmapSizeSum));
    }

    private final int readThreadCount(HeapGraph graph) {
        Iterable $this$filterIsInstance$iv = graph.getGcRoots();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof GcRoot.ThreadObject) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$filterIsInstance$iv2 = (List) destination$iv$iv;
        Iterable $this$map$iv = $this$filterIsInstance$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            GcRoot.ThreadObject it = (GcRoot.ThreadObject) item$iv$iv;
            destination$iv$iv2.add(Long.valueOf(it.getId()));
        }
        return CollectionsKt.toSet((List) destination$iv$iv2).size();
    }

    private final String readLeakCanaryVersion(HeapGraph graph) {
        HeapField heapField;
        HeapValue value;
        String readAsJavaString;
        HeapObject.HeapClass versionHolderClass = graph.findClassByName("leakcanary.internal.InternalLeakCanary");
        return (versionHolderClass == null || (heapField = versionHolderClass.get("version")) == null || (value = heapField.getValue()) == null || (readAsJavaString = value.readAsJavaString()) == null) ? "Unknown" : readAsJavaString;
    }

    private final String readProcessName(HeapGraph graph) {
        HeapField heapField;
        HeapObject.HeapInstance valueAsInstance;
        String readAsJavaString;
        HeapField heapField2;
        HeapField heapField3;
        HeapField heapField4;
        HeapObject.HeapClass findClassByName = graph.findClassByName("android.app.ActivityThread");
        HeapObject.HeapInstance appInfo = null;
        HeapObject.HeapInstance activityThread = (findClassByName == null || (heapField4 = findClassByName.get("sCurrentActivityThread")) == null) ? null : heapField4.getValueAsInstance();
        HeapObject.HeapInstance appBindData = (activityThread == null || (heapField3 = activityThread.get("android.app.ActivityThread", "mBoundApplication")) == null) ? null : heapField3.getValueAsInstance();
        if (appBindData != null && (heapField2 = appBindData.get("android.app.ActivityThread$AppBindData", "appInfo")) != null) {
            appInfo = heapField2.getValueAsInstance();
        }
        return (appInfo == null || (heapField = appInfo.get("android.content.pm.ApplicationInfo", "processName")) == null || (valueAsInstance = heapField.getValueAsInstance()) == null || (readAsJavaString = valueAsInstance.readAsJavaString()) == null) ? "Unknown" : readAsJavaString;
    }

    private final void putDbLabels(Map<String, String> map, HeapGraph graph) {
        HeapObject.HeapClass dbClass = graph.findClassByName("android.database.sqlite.SQLiteDatabase");
        if (dbClass != null) {
            Sequence openDbLabels = SequencesKt.mapNotNull(dbClass.getInstances(), new Function1<HeapObject.HeapInstance, Pair<? extends String, ? extends Boolean>>() { // from class: shark.AndroidMetadataExtractor$putDbLabels$openDbLabels$1
                public final Pair<String, Boolean> invoke(HeapObject.HeapInstance instance) {
                    HeapObject.HeapInstance config;
                    HeapField heapField;
                    HeapValue value;
                    String label;
                    HeapField heapField2;
                    HeapValue value2;
                    Intrinsics.checkParameterIsNotNull(instance, "instance");
                    HeapField heapField3 = instance.get("android.database.sqlite.SQLiteDatabase", "mConfigurationLocked");
                    if (heapField3 == null || (config = heapField3.getValueAsInstance()) == null || (heapField = config.get("android.database.sqlite.SQLiteDatabaseConfiguration", "label")) == null || (value = heapField.getValue()) == null || (label = value.readAsJavaString()) == null || (heapField2 = instance.get("android.database.sqlite.SQLiteDatabase", "mConnectionPoolLocked")) == null || (value2 = heapField2.getValue()) == null) {
                        return null;
                    }
                    boolean open = value2.isNonNullReference();
                    return TuplesKt.to(label, Boolean.valueOf(open));
                }
            });
            int index = 0;
            for (Object item$iv : openDbLabels) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair $dstr$label$open = (Pair) item$iv;
                String label = (String) $dstr$label$open.component1();
                boolean open = ((Boolean) $dstr$label$open.component2()).booleanValue();
                map.put("Db " + (index + 1), (open ? "open " : "closed ") + label);
                index = index$iv;
            }
        }
    }
}