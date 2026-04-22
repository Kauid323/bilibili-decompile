package shark;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeapAnalysis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lshark/HeapAnalysisFailure;", "Lshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "createdAtTimeMillis", "", "dumpDurationMillis", "analysisDurationMillis", "exception", "Lshark/HeapAnalysisException;", "(Ljava/io/File;JJJLshark/HeapAnalysisException;)V", "getAnalysisDurationMillis", "()J", "getCreatedAtTimeMillis", "getDumpDurationMillis", "getException", "()Lshark/HeapAnalysisException;", "getHeapDumpFile", "()Ljava/io/File;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public final class HeapAnalysisFailure extends HeapAnalysis {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 8483254400637792414L;
    private final long analysisDurationMillis;
    private final long createdAtTimeMillis;
    private final long dumpDurationMillis;
    private final HeapAnalysisException exception;
    private final File heapDumpFile;

    public final File component1() {
        return getHeapDumpFile();
    }

    public final long component2() {
        return getCreatedAtTimeMillis();
    }

    public final long component3() {
        return getDumpDurationMillis();
    }

    public final long component4() {
        return getAnalysisDurationMillis();
    }

    public final HeapAnalysisException component5() {
        return this.exception;
    }

    public final HeapAnalysisFailure copy(File file, long j, long j2, long j3, HeapAnalysisException heapAnalysisException) {
        Intrinsics.checkParameterIsNotNull(file, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(heapAnalysisException, "exception");
        return new HeapAnalysisFailure(file, j, j2, j3, heapAnalysisException);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HeapAnalysisFailure) {
                HeapAnalysisFailure heapAnalysisFailure = (HeapAnalysisFailure) obj;
                return Intrinsics.areEqual(getHeapDumpFile(), heapAnalysisFailure.getHeapDumpFile()) && getCreatedAtTimeMillis() == heapAnalysisFailure.getCreatedAtTimeMillis() && getDumpDurationMillis() == heapAnalysisFailure.getDumpDurationMillis() && getAnalysisDurationMillis() == heapAnalysisFailure.getAnalysisDurationMillis() && Intrinsics.areEqual(this.exception, heapAnalysisFailure.exception);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        File heapDumpFile = getHeapDumpFile();
        int hashCode = heapDumpFile != null ? heapDumpFile.hashCode() : 0;
        long createdAtTimeMillis = getCreatedAtTimeMillis();
        long dumpDurationMillis = getDumpDurationMillis();
        long analysisDurationMillis = getAnalysisDurationMillis();
        int i = ((((((hashCode * 31) + ((int) (createdAtTimeMillis ^ (createdAtTimeMillis >>> 32)))) * 31) + ((int) (dumpDurationMillis ^ (dumpDurationMillis >>> 32)))) * 31) + ((int) (analysisDurationMillis ^ (analysisDurationMillis >>> 32)))) * 31;
        HeapAnalysisException heapAnalysisException = this.exception;
        return i + (heapAnalysisException != null ? heapAnalysisException.hashCode() : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeapAnalysisFailure(File heapDumpFile, long createdAtTimeMillis, long dumpDurationMillis, long analysisDurationMillis, HeapAnalysisException exception) {
        super(null);
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        this.heapDumpFile = heapDumpFile;
        this.createdAtTimeMillis = createdAtTimeMillis;
        this.dumpDurationMillis = dumpDurationMillis;
        this.analysisDurationMillis = analysisDurationMillis;
        this.exception = exception;
    }

    @Override // shark.HeapAnalysis
    public File getHeapDumpFile() {
        return this.heapDumpFile;
    }

    @Override // shark.HeapAnalysis
    public long getCreatedAtTimeMillis() {
        return this.createdAtTimeMillis;
    }

    public /* synthetic */ HeapAnalysisFailure(File file, long j, long j2, long j3, HeapAnalysisException heapAnalysisException, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, j, (i & 4) != 0 ? -1L : j2, j3, heapAnalysisException);
    }

    @Override // shark.HeapAnalysis
    public long getDumpDurationMillis() {
        return this.dumpDurationMillis;
    }

    @Override // shark.HeapAnalysis
    public long getAnalysisDurationMillis() {
        return this.analysisDurationMillis;
    }

    public final HeapAnalysisException getException() {
        return this.exception;
    }

    public String toString() {
        int androidSdkInt;
        String androidManufacturer;
        String leakCanaryVersion;
        StringBuilder append = new StringBuilder().append("====================================\nHEAP ANALYSIS FAILED\n\nYou can report this failure at https://github.com/square/leakcanary/issues\nPlease provide the stacktrace, metadata and the heap dump file.\n====================================\nSTACKTRACE\n\n").append(this.exception).append("====================================\nMETADATA\n\nBuild.VERSION.SDK_INT: ");
        androidSdkInt = HeapAnalysisKt.androidSdkInt();
        StringBuilder append2 = append.append(androidSdkInt).append("\nBuild.MANUFACTURER: ");
        androidManufacturer = HeapAnalysisKt.androidManufacturer();
        StringBuilder append3 = append2.append(androidManufacturer).append("\nLeakCanary version: ");
        leakCanaryVersion = HeapAnalysisKt.leakCanaryVersion();
        return append3.append(leakCanaryVersion).append("\nAnalysis duration: ").append(getAnalysisDurationMillis()).append(" ms\nHeap dump file path: ").append(getHeapDumpFile().getAbsolutePath()).append("\nHeap dump timestamp: ").append(getCreatedAtTimeMillis()).append("\n====================================").toString();
    }

    /* compiled from: HeapAnalysis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/HeapAnalysisFailure$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}