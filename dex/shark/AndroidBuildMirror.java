package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapObject;

/* compiled from: AndroidBuildMirror.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lshark/AndroidBuildMirror;", "", "manufacturer", "", "sdkInt", "", "id", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getManufacturer", "getSdkInt", "()I", "Companion", "shark-android"}, k = 1, mv = {1, 4, 1})
public final class AndroidBuildMirror {
    public static final Companion Companion = new Companion(null);
    private final String id;
    private final String manufacturer;
    private final int sdkInt;

    public AndroidBuildMirror(String manufacturer, int sdkInt, String id) {
        Intrinsics.checkParameterIsNotNull(manufacturer, "manufacturer");
        Intrinsics.checkParameterIsNotNull(id, "id");
        this.manufacturer = manufacturer;
        this.sdkInt = sdkInt;
        this.id = id;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final int getSdkInt() {
        return this.sdkInt;
    }

    public final String getId() {
        return this.id;
    }

    /* compiled from: AndroidBuildMirror.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lshark/AndroidBuildMirror$Companion;", "", "()V", "fromHeapGraph", "Lshark/AndroidBuildMirror;", "graph", "Lshark/HeapGraph;", "shark-android"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final AndroidBuildMirror fromHeapGraph(final HeapGraph graph) {
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            GraphContext context = graph.getContext();
            String name = AndroidBuildMirror.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "AndroidBuildMirror::class.java.name");
            return (AndroidBuildMirror) context.getOrPut(name, new Function0<AndroidBuildMirror>() { // from class: shark.AndroidBuildMirror$Companion$fromHeapGraph$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final AndroidBuildMirror invoke() {
                    HeapObject.HeapClass buildClass = HeapGraph.this.findClassByName("android.os.Build");
                    if (buildClass == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapObject.HeapClass versionClass = HeapGraph.this.findClassByName("android.os.Build$VERSION");
                    if (versionClass == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapField heapField = buildClass.get("MANUFACTURER");
                    if (heapField == null) {
                        Intrinsics.throwNpe();
                    }
                    String manufacturer = heapField.getValue().readAsJavaString();
                    if (manufacturer == null) {
                        Intrinsics.throwNpe();
                    }
                    HeapField heapField2 = versionClass.get("SDK_INT");
                    if (heapField2 == null) {
                        Intrinsics.throwNpe();
                    }
                    Integer asInt = heapField2.getValue().getAsInt();
                    if (asInt == null) {
                        Intrinsics.throwNpe();
                    }
                    int sdkInt = asInt.intValue();
                    HeapField heapField3 = buildClass.get("ID");
                    if (heapField3 == null) {
                        Intrinsics.throwNpe();
                    }
                    String id = heapField3.getValue().readAsJavaString();
                    if (id == null) {
                        Intrinsics.throwNpe();
                    }
                    return new AndroidBuildMirror(manufacturer, sdkInt, id);
                }
            });
        }
    }
}