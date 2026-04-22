package shark;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: HeapAnalysis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\fHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\fHÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\b\u00103\u001a\u00020\nH\u0016R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001b¨\u00065"}, d2 = {"Lshark/HeapAnalysisSuccess;", "Lshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "createdAtTimeMillis", "", "dumpDurationMillis", "analysisDurationMillis", "metadata", "", "", "applicationLeaks", "", "Lshark/ApplicationLeak;", "libraryLeaks", "Lshark/LibraryLeak;", "unreachableObjects", "Lshark/LeakTraceObject;", "(Ljava/io/File;JJJLjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "allLeaks", "Lkotlin/sequences/Sequence;", "Lshark/Leak;", "getAllLeaks", "()Lkotlin/sequences/Sequence;", "getAnalysisDurationMillis", "()J", "getApplicationLeaks", "()Ljava/util/List;", "getCreatedAtTimeMillis", "getDumpDurationMillis", "getHeapDumpFile", "()Ljava/io/File;", "getLibraryLeaks", "getMetadata", "()Ljava/util/Map;", "getUnreachableObjects", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public final class HeapAnalysisSuccess extends HeapAnalysis {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 130453013437459642L;
    private final long analysisDurationMillis;
    private final List<ApplicationLeak> applicationLeaks;
    private final long createdAtTimeMillis;
    private final long dumpDurationMillis;
    private final File heapDumpFile;
    private final List<LibraryLeak> libraryLeaks;
    private final Map<String, String> metadata;
    private final List<LeakTraceObject> unreachableObjects;

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

    public final Map<String, String> component5() {
        return this.metadata;
    }

    public final List<ApplicationLeak> component6() {
        return this.applicationLeaks;
    }

    public final List<LibraryLeak> component7() {
        return this.libraryLeaks;
    }

    public final List<LeakTraceObject> component8() {
        return this.unreachableObjects;
    }

    public final HeapAnalysisSuccess copy(File file, long j, long j2, long j3, Map<String, String> map, List<ApplicationLeak> list, List<LibraryLeak> list2, List<LeakTraceObject> list3) {
        Intrinsics.checkParameterIsNotNull(file, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(map, "metadata");
        Intrinsics.checkParameterIsNotNull(list, "applicationLeaks");
        Intrinsics.checkParameterIsNotNull(list2, "libraryLeaks");
        Intrinsics.checkParameterIsNotNull(list3, "unreachableObjects");
        return new HeapAnalysisSuccess(file, j, j2, j3, map, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HeapAnalysisSuccess) {
                HeapAnalysisSuccess heapAnalysisSuccess = (HeapAnalysisSuccess) obj;
                return Intrinsics.areEqual(getHeapDumpFile(), heapAnalysisSuccess.getHeapDumpFile()) && getCreatedAtTimeMillis() == heapAnalysisSuccess.getCreatedAtTimeMillis() && getDumpDurationMillis() == heapAnalysisSuccess.getDumpDurationMillis() && getAnalysisDurationMillis() == heapAnalysisSuccess.getAnalysisDurationMillis() && Intrinsics.areEqual(this.metadata, heapAnalysisSuccess.metadata) && Intrinsics.areEqual(this.applicationLeaks, heapAnalysisSuccess.applicationLeaks) && Intrinsics.areEqual(this.libraryLeaks, heapAnalysisSuccess.libraryLeaks) && Intrinsics.areEqual(this.unreachableObjects, heapAnalysisSuccess.unreachableObjects);
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
        Map<String, String> map = this.metadata;
        int hashCode2 = (i + (map != null ? map.hashCode() : 0)) * 31;
        List<ApplicationLeak> list = this.applicationLeaks;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<LibraryLeak> list2 = this.libraryLeaks;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<LeakTraceObject> list3 = this.unreachableObjects;
        return hashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeapAnalysisSuccess(File heapDumpFile, long createdAtTimeMillis, long dumpDurationMillis, long analysisDurationMillis, Map<String, String> map, List<ApplicationLeak> list, List<LibraryLeak> list2, List<LeakTraceObject> list3) {
        super(null);
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(map, "metadata");
        Intrinsics.checkParameterIsNotNull(list, "applicationLeaks");
        Intrinsics.checkParameterIsNotNull(list2, "libraryLeaks");
        Intrinsics.checkParameterIsNotNull(list3, "unreachableObjects");
        this.heapDumpFile = heapDumpFile;
        this.createdAtTimeMillis = createdAtTimeMillis;
        this.dumpDurationMillis = dumpDurationMillis;
        this.analysisDurationMillis = analysisDurationMillis;
        this.metadata = map;
        this.applicationLeaks = list;
        this.libraryLeaks = list2;
        this.unreachableObjects = list3;
    }

    @Override // shark.HeapAnalysis
    public File getHeapDumpFile() {
        return this.heapDumpFile;
    }

    @Override // shark.HeapAnalysis
    public long getCreatedAtTimeMillis() {
        return this.createdAtTimeMillis;
    }

    public /* synthetic */ HeapAnalysisSuccess(File file, long j, long j2, long j3, Map map, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, j, (i & 4) != 0 ? -1L : j2, j3, map, list, list2, list3);
    }

    @Override // shark.HeapAnalysis
    public long getDumpDurationMillis() {
        return this.dumpDurationMillis;
    }

    @Override // shark.HeapAnalysis
    public long getAnalysisDurationMillis() {
        return this.analysisDurationMillis;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final List<ApplicationLeak> getApplicationLeaks() {
        return this.applicationLeaks;
    }

    public final List<LibraryLeak> getLibraryLeaks() {
        return this.libraryLeaks;
    }

    public final List<LeakTraceObject> getUnreachableObjects() {
        return this.unreachableObjects;
    }

    public final Sequence<Leak> getAllLeaks() {
        return SequencesKt.plus(CollectionsKt.asSequence(this.applicationLeaks), CollectionsKt.asSequence(this.libraryLeaks));
    }

    public String toString() {
        String str = "";
        StringBuilder append = new StringBuilder().append("====================================\nHEAP ANALYSIS RESULT\n====================================\n").append(this.applicationLeaks.size()).append(" APPLICATION LEAKS\n\nReferences underlined with \"~~~\" are likely causes.\nLearn more at https://squ.re/leaks.\n").append(!this.applicationLeaks.isEmpty() ? "\n" + CollectionsKt.joinToString$default(this.applicationLeaks, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n" : "").append("====================================\n").append(this.libraryLeaks.size()).append(" LIBRARY LEAKS\n\nA Library Leak is a leak caused by a known bug in 3rd party code that you do not have control over.\nSee https://square.github.io/leakcanary/fundamentals-how-leakcanary-works/#4-categorizing-leaks\n").append(!this.libraryLeaks.isEmpty() ? "\n" + CollectionsKt.joinToString$default(this.libraryLeaks, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n" : "").append("====================================\n").append(this.unreachableObjects.size()).append(" UNREACHABLE OBJECTS\n\nAn unreachable object is still in memory but LeakCanary could not find a strong reference path\nfrom GC roots.\n").append(!this.unreachableObjects.isEmpty() ? "\n" + CollectionsKt.joinToString$default(this.unreachableObjects, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n" : "").append("====================================\nMETADATA\n\nPlease include this in bug reports and Stack Overflow questions.\n");
        if (!this.metadata.isEmpty()) {
            StringBuilder append2 = new StringBuilder().append("\n");
            Map $this$map$iv = this.metadata;
            Collection destination$iv$iv = new ArrayList($this$map$iv.size());
            for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                destination$iv$iv.add(item$iv$iv.getKey() + ": " + item$iv$iv.getValue());
            }
            str = append2.append(CollectionsKt.joinToString$default((List) destination$iv$iv, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString();
        }
        return append.append(str).append("\nAnalysis duration: ").append(getAnalysisDurationMillis()).append(" ms\nHeap dump file path: ").append(getHeapDumpFile().getAbsolutePath()).append("\nHeap dump timestamp: ").append(getCreatedAtTimeMillis()).append("\nHeap dump duration: ").append(getDumpDurationMillis() != -1 ? getDumpDurationMillis() + " ms" : "Unknown").append("\n====================================").toString();
    }

    /* compiled from: HeapAnalysis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lshark/HeapAnalysisSuccess$Companion;", "", "()V", "serialVersionUID", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}