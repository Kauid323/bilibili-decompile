package shark;

import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HeapAnalysis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0012\u0010\t\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lshark/HeapAnalysis;", "Ljava/io/Serializable;", "()V", "analysisDurationMillis", "", "getAnalysisDurationMillis", "()J", "createdAtTimeMillis", "getCreatedAtTimeMillis", "dumpDurationMillis", "getDumpDurationMillis", "heapDumpFile", "Ljava/io/File;", "getHeapDumpFile", "()Ljava/io/File;", "Companion", "Lshark/HeapAnalysisFailure;", "Lshark/HeapAnalysisSuccess;", "shark"}, k = 1, mv = {1, 4, 1})
public abstract class HeapAnalysis implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final long DUMP_DURATION_UNKNOWN = -1;
    private static final long serialVersionUID = -8657286725869987172L;

    public abstract long getAnalysisDurationMillis();

    public abstract long getCreatedAtTimeMillis();

    public abstract long getDumpDurationMillis();

    public abstract File getHeapDumpFile();

    private HeapAnalysis() {
    }

    public /* synthetic */ HeapAnalysis(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* compiled from: HeapAnalysis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lshark/HeapAnalysis$Companion;", "", "()V", "DUMP_DURATION_UNKNOWN", "", "serialVersionUID", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}