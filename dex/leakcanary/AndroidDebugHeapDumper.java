package leakcanary;

import android.os.Debug;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidDebugHeapDumper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lleakcanary/AndroidDebugHeapDumper;", "Lleakcanary/HeapDumper;", "()V", "dumpHeap", "", "heapDumpFile", "Ljava/io/File;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class AndroidDebugHeapDumper implements HeapDumper {
    public static final AndroidDebugHeapDumper INSTANCE = new AndroidDebugHeapDumper();

    private AndroidDebugHeapDumper() {
    }

    @Override // leakcanary.HeapDumper
    public void dumpHeap(File heapDumpFile) {
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        Debug.dumpHprofData(heapDumpFile.getAbsolutePath());
    }
}