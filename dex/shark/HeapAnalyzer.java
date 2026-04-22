package shark;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.HeapObject;
import shark.HprofHeapGraph;
import shark.LeakTrace;
import shark.LeakTraceObject;
import shark.LeakTraceReference;
import shark.OnAnalysisProgressListener;
import shark.SharkLog;
import shark.internal.AndroidNativeSizeMapper;
import shark.internal.AndroidReferenceReaders;
import shark.internal.ApacheHarmonyInstanceRefReaders;
import shark.internal.ChainingInstanceReferenceReader;
import shark.internal.ClassReferenceReader;
import shark.internal.DelegatingObjectReferenceReader;
import shark.internal.DominatorTree;
import shark.internal.FieldInstanceReferenceReader;
import shark.internal.JavaLocalReferenceReader;
import shark.internal.KeyedWeakReferenceMirror;
import shark.internal.ObjectArrayReferenceReader;
import shark.internal.OpenJdkInstanceRefReaders;
import shark.internal.PathFinder;
import shark.internal.Reference;
import shark.internal.ReferencePathNode;
import shark.internal.ReferenceReader;
import shark.internal.ShallowSizeCalculator;
import shark.internal.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: HeapAnalyzer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0005VWXYZB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J_\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¢\u0006\u0002\b\u0019JX\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J>\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2 \u0010 \u001a\u001c\u0012\u0004\u0012\u00020\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#\u0018\u00010!H\u0002J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000eH\u0002J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u000eH\u0002J\u001e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020+01H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0018H\u0002J$\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002030#2\u0006\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u0011H\u0002J\u0010\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\"H\u0002J.\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020+2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0006\u0010>\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0002J,\u0010?\u001a\u00020@*\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010:\u001a\u00020\"H\u0002Jh\u0010B\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u000e0#*\u00020A2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020)0\u000e2\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000e0\u000e2 \u0010 \u001a\u001c\u0012\u0004\u0012\u00020\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#\u0018\u00010!H\u0002J(\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u000e*\u00020A2\u0006\u0010I\u001a\u00020)2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000eH\u0002J@\u0010K\u001a\u001a\u0012\u0004\u0012\u00020\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#0!*\u00020A2\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000e0\u000e2\u0006\u0010L\u001a\u00020MH\u0002J\u001a\u0010N\u001a\u00020O*\u00020A2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\"0QH\u0002J(\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e*\u00020A2\u0006\u0010S\u001a\u00020T2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\"0QH\u0002J&\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000e0\u000e*\u00020A2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020)0\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lshark/HeapAnalyzer;", "", "listener", "Lshark/OnAnalysisProgressListener;", "(Lshark/OnAnalysisProgressListener;)V", "analyze", "Lshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "graph", "Lshark/HeapGraph;", "leakingObjectFinder", "Lshark/LeakingObjectFinder;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lshark/ObjectInspector;", "metadataExtractor", "Lshark/MetadataExtractor;", "referenceReader", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject;", "analyze$shark", "proguardMapping", "Lshark/ProguardMapping;", "buildLeakTraceObjects", "Lshark/LeakTraceObject;", "inspectedObjects", "Lshark/HeapAnalyzer$InspectedObject;", "retainedSizes", "", "", "Lkotlin/Pair;", "", "computeLeakStatuses", "leakReporters", "Lshark/ObjectReporter;", "deduplicateShortestPaths", "Lshark/HeapAnalyzer$ShortestPath;", "inputPathResults", "Lshark/internal/ReferencePathNode;", "findResultsInTrie", "", "parentNode", "Lshark/HeapAnalyzer$TrieNode$ParentNode;", "outputPathResults", "", "recordClassName", "", "heap", "resolveStatus", "Lshark/LeakTraceObject$LeakingStatus;", "reporter", "leakingWins", "since", "analysisStartNanoTime", "updateTrie", "pathNode", FileChooserActivity.PATH, "pathIndex", "analyzeGraph", "Lshark/HeapAnalysisSuccess;", "Lshark/HeapAnalyzer$FindLeakInput;", "buildLeakTraces", "Lshark/ApplicationLeak;", "Lshark/LibraryLeak;", "shortestPaths", "inspectedObjectsByPath", "buildReferencePath", "Lshark/LeakTraceReference;", "shortestPath", "leakTraceObjects", "computeRetainedSizes", "dominatorTree", "Lshark/internal/DominatorTree;", "findLeaks", "Lshark/HeapAnalyzer$LeaksAndUnreachableObjects;", "leakingObjectIds", "", "findUnreachableObjects", "pathFindingResults", "Lshark/internal/PathFinder$PathFindingResults;", "inspectObjects", "FindLeakInput", "InspectedObject", "LeaksAndUnreachableObjects", "ShortestPath", "TrieNode", "shark"}, k = 1, mv = {1, 4, 1})
public final class HeapAnalyzer {
    private final OnAnalysisProgressListener listener;

    public HeapAnalyzer(OnAnalysisProgressListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeapAnalyzer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lshark/HeapAnalyzer$FindLeakInput;", "", "graph", "Lshark/HeapGraph;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lshark/ObjectInspector;", "referenceReader", "Lshark/internal/ReferenceReader;", "Lshark/HeapObject;", "(Lshark/HeapGraph;Ljava/util/List;ZLjava/util/List;Lshark/internal/ReferenceReader;)V", "getComputeRetainedHeapSize", "()Z", "getGraph", "()Lshark/HeapGraph;", "getObjectInspectors", "()Ljava/util/List;", "getReferenceMatchers", "getReferenceReader", "()Lshark/internal/ReferenceReader;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FindLeakInput {
        private final boolean computeRetainedHeapSize;
        private final HeapGraph graph;
        private final List<ObjectInspector> objectInspectors;
        private final List<ReferenceMatcher> referenceMatchers;
        private final ReferenceReader<HeapObject> referenceReader;

        /* JADX WARN: Multi-variable type inference failed */
        public FindLeakInput(HeapGraph graph, List<? extends ReferenceMatcher> list, boolean computeRetainedHeapSize, List<? extends ObjectInspector> list2, ReferenceReader<HeapObject> referenceReader) {
            Intrinsics.checkParameterIsNotNull(graph, "graph");
            Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
            Intrinsics.checkParameterIsNotNull(list2, "objectInspectors");
            Intrinsics.checkParameterIsNotNull(referenceReader, "referenceReader");
            this.graph = graph;
            this.referenceMatchers = list;
            this.computeRetainedHeapSize = computeRetainedHeapSize;
            this.objectInspectors = list2;
            this.referenceReader = referenceReader;
        }

        public final HeapGraph getGraph() {
            return this.graph;
        }

        public final List<ReferenceMatcher> getReferenceMatchers() {
            return this.referenceMatchers;
        }

        public final boolean getComputeRetainedHeapSize() {
            return this.computeRetainedHeapSize;
        }

        public final List<ObjectInspector> getObjectInspectors() {
            return this.objectInspectors;
        }

        public final ReferenceReader<HeapObject> getReferenceReader() {
            return this.referenceReader;
        }
    }

    public static /* synthetic */ HeapAnalysis analyze$default(HeapAnalyzer heapAnalyzer, File file, LeakingObjectFinder leakingObjectFinder, List list, boolean z, List list2, MetadataExtractor metadataExtractor, ProguardMapping proguardMapping, int i, Object obj) {
        boolean z2;
        List list3;
        MetadataExtractor metadataExtractor2;
        ProguardMapping proguardMapping2;
        List emptyList = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        if ((i & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        if ((i & 16) == 0) {
            list3 = list2;
        } else {
            list3 = CollectionsKt.emptyList();
        }
        if ((i & 32) == 0) {
            metadataExtractor2 = metadataExtractor;
        } else {
            metadataExtractor2 = MetadataExtractor.Companion.getNO_OP();
        }
        if ((i & 64) == 0) {
            proguardMapping2 = proguardMapping;
        } else {
            proguardMapping2 = null;
        }
        return heapAnalyzer.analyze(file, leakingObjectFinder, emptyList, z2, list3, metadataExtractor2, proguardMapping2);
    }

    @Deprecated(message = "Use the non deprecated analyze method instead")
    public final HeapAnalysis analyze(File heapDumpFile, LeakingObjectFinder leakingObjectFinder, List<? extends ReferenceMatcher> list, boolean computeRetainedHeapSize, List<? extends ObjectInspector> list2, MetadataExtractor metadataExtractor, ProguardMapping proguardMapping) {
        HeapAnalysisSuccess copy;
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(leakingObjectFinder, "leakingObjectFinder");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        Intrinsics.checkParameterIsNotNull(list2, "objectInspectors");
        Intrinsics.checkParameterIsNotNull(metadataExtractor, "metadataExtractor");
        if (!heapDumpFile.exists()) {
            IllegalArgumentException exception = new IllegalArgumentException("File does not exist: " + heapDumpFile);
            return new HeapAnalysisFailure(heapDumpFile, System.currentTimeMillis(), 0L, 0L, new HeapAnalysisException(exception), 4, null);
        }
        this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.PARSING_HEAP_DUMP);
        ConstantMemoryMetricsDualSourceProvider sourceProvider = new ConstantMemoryMetricsDualSourceProvider(new FileSourceProvider(heapDumpFile));
        try {
            CloseableHeapGraph openHeapGraph$default = HprofHeapGraph.Companion.openHeapGraph$default(HprofHeapGraph.Companion, sourceProvider, proguardMapping, (Set) null, 2, (Object) null);
            Throwable th = null;
            CloseableHeapGraph graph = openHeapGraph$default;
            HeapAnalysis result = analyze(heapDumpFile, graph, leakingObjectFinder, list, computeRetainedHeapSize, list2, metadataExtractor);
            if (result instanceof HeapAnalysisSuccess) {
                if (graph == null) {
                    throw new TypeCastException("null cannot be cast to non-null type shark.HprofHeapGraph");
                }
                String lruCacheStats = ((HprofHeapGraph) graph).lruCacheStats();
                String randomAccessStats = "RandomAccess[bytes=" + sourceProvider.getRandomAccessByteReads() + ",reads=" + sourceProvider.getRandomAccessReadCount() + ",travel=" + sourceProvider.getRandomAccessByteTravel() + ",range=" + sourceProvider.getByteTravelRange() + ",size=" + heapDumpFile.length() + "]";
                String stats = lruCacheStats + ' ' + randomAccessStats;
                copy = r18.copy((r24 & 1) != 0 ? r18.getHeapDumpFile() : null, (r24 & 2) != 0 ? r18.getCreatedAtTimeMillis() : 0L, (r24 & 4) != 0 ? r18.getDumpDurationMillis() : 0L, (r24 & 8) != 0 ? r18.getAnalysisDurationMillis() : 0L, (r24 & 16) != 0 ? r18.metadata : MapsKt.plus(((HeapAnalysisSuccess) result).getMetadata(), TuplesKt.to("Stats", stats)), (r24 & 32) != 0 ? r18.applicationLeaks : null, (r24 & 64) != 0 ? r18.libraryLeaks : null, (r24 & BR.cover) != 0 ? ((HeapAnalysisSuccess) result).unreachableObjects : null);
                result = copy;
            }
            CloseableKt.closeFinally(openHeapGraph$default, (Throwable) null);
            return result;
        } catch (Throwable throwable) {
            return new HeapAnalysisFailure(heapDumpFile, System.currentTimeMillis(), 0L, 0L, new HeapAnalysisException(throwable), 4, null);
        }
    }

    public static /* synthetic */ HeapAnalysis analyze$default(HeapAnalyzer heapAnalyzer, File file, HeapGraph heapGraph, LeakingObjectFinder leakingObjectFinder, List list, boolean z, List list2, MetadataExtractor metadataExtractor, int i, Object obj) {
        boolean z2;
        List list3;
        MetadataExtractor metadataExtractor2;
        List emptyList = (i & 8) != 0 ? CollectionsKt.emptyList() : list;
        if ((i & 16) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        if ((i & 32) == 0) {
            list3 = list2;
        } else {
            list3 = CollectionsKt.emptyList();
        }
        if ((i & 64) == 0) {
            metadataExtractor2 = metadataExtractor;
        } else {
            metadataExtractor2 = MetadataExtractor.Companion.getNO_OP();
        }
        return heapAnalyzer.analyze(file, heapGraph, leakingObjectFinder, emptyList, z2, list3, metadataExtractor2);
    }

    public final HeapAnalysis analyze(File heapDumpFile, HeapGraph graph, LeakingObjectFinder leakingObjectFinder, List<? extends ReferenceMatcher> list, boolean computeRetainedHeapSize, List<? extends ObjectInspector> list2, MetadataExtractor metadataExtractor) {
        HeapAnalysisFailure copy;
        HeapAnalysisSuccess copy2;
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(leakingObjectFinder, "leakingObjectFinder");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        Intrinsics.checkParameterIsNotNull(list2, "objectInspectors");
        Intrinsics.checkParameterIsNotNull(metadataExtractor, "metadataExtractor");
        long analysisStartNanoTime = System.nanoTime();
        ClassReferenceReader classReferenceReader = new ClassReferenceReader(graph, list);
        List listOf = CollectionsKt.listOf(new JavaLocalReferenceReader(graph, list));
        OpenJdkInstanceRefReaders[] values = OpenJdkInstanceRefReaders.values();
        Collection destination$iv$iv = new ArrayList();
        int length = values.length;
        int $i$f$mapNotNull = 0;
        while ($i$f$mapNotNull < length) {
            int i = length;
            ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create = values[$i$f$mapNotNull].create(graph);
            if (create != null) {
                destination$iv$iv.add(create);
            }
            $i$f$mapNotNull++;
            length = i;
        }
        List plus = CollectionsKt.plus(listOf, (List) destination$iv$iv);
        ApacheHarmonyInstanceRefReaders[] values2 = ApacheHarmonyInstanceRefReaders.values();
        Collection destination$iv$iv2 = new ArrayList();
        int length2 = values2.length;
        int $i$f$mapNotNull2 = 0;
        while ($i$f$mapNotNull2 < length2) {
            int i2 = length2;
            ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create2 = values2[$i$f$mapNotNull2].create(graph);
            if (create2 != null) {
                destination$iv$iv2.add(create2);
            }
            $i$f$mapNotNull2++;
            length2 = i2;
        }
        List plus2 = CollectionsKt.plus(plus, (List) destination$iv$iv2);
        AndroidReferenceReaders[] values3 = AndroidReferenceReaders.values();
        Collection destination$iv$iv3 = new ArrayList();
        int length3 = values3.length;
        int $i$f$mapNotNull3 = 0;
        while ($i$f$mapNotNull3 < length3) {
            int i3 = length3;
            ChainingInstanceReferenceReader.VirtualInstanceReferenceReader create3 = values3[$i$f$mapNotNull3].create(graph);
            if (create3 != null) {
                destination$iv$iv3.add(create3);
            }
            $i$f$mapNotNull3++;
            length3 = i3;
        }
        DelegatingObjectReferenceReader referenceReader = new DelegatingObjectReferenceReader(classReferenceReader, new ChainingInstanceReferenceReader(CollectionsKt.plus(plus2, (List) destination$iv$iv3), new FieldInstanceReferenceReader(graph, list)), new ObjectArrayReferenceReader());
        HeapAnalysis $this$run = analyze$shark(heapDumpFile, graph, leakingObjectFinder, list, computeRetainedHeapSize, list2, metadataExtractor, referenceReader);
        long updatedDurationMillis = since(analysisStartNanoTime);
        if ($this$run instanceof HeapAnalysisSuccess) {
            copy2 = r16.copy((r24 & 1) != 0 ? r16.getHeapDumpFile() : null, (r24 & 2) != 0 ? r16.getCreatedAtTimeMillis() : 0L, (r24 & 4) != 0 ? r16.getDumpDurationMillis() : 0L, (r24 & 8) != 0 ? r16.getAnalysisDurationMillis() : updatedDurationMillis, (r24 & 16) != 0 ? r16.metadata : null, (r24 & 32) != 0 ? r16.applicationLeaks : null, (r24 & 64) != 0 ? r16.libraryLeaks : null, (r24 & BR.cover) != 0 ? ((HeapAnalysisSuccess) $this$run).unreachableObjects : null);
            return copy2;
        } else if ($this$run instanceof HeapAnalysisFailure) {
            copy = r16.copy((r18 & 1) != 0 ? r16.getHeapDumpFile() : null, (r18 & 2) != 0 ? r16.getCreatedAtTimeMillis() : 0L, (r18 & 4) != 0 ? r16.getDumpDurationMillis() : 0L, (r18 & 8) != 0 ? r16.getAnalysisDurationMillis() : updatedDurationMillis, (r18 & 16) != 0 ? ((HeapAnalysisFailure) $this$run).exception : null);
            return copy;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final HeapAnalysis analyze$shark(File heapDumpFile, HeapGraph graph, LeakingObjectFinder leakingObjectFinder, List<? extends ReferenceMatcher> list, boolean computeRetainedHeapSize, List<? extends ObjectInspector> list2, MetadataExtractor metadataExtractor, ReferenceReader<HeapObject> referenceReader) {
        long analysisStartNanoTime;
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(leakingObjectFinder, "leakingObjectFinder");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        Intrinsics.checkParameterIsNotNull(list2, "objectInspectors");
        Intrinsics.checkParameterIsNotNull(metadataExtractor, "metadataExtractor");
        Intrinsics.checkParameterIsNotNull(referenceReader, "referenceReader");
        long analysisStartNanoTime2 = System.nanoTime();
        try {
            FindLeakInput helpers = new FindLeakInput(graph, list, computeRetainedHeapSize, list2, referenceReader);
            analysisStartNanoTime = analysisStartNanoTime2;
            try {
                return analyzeGraph(helpers, metadataExtractor, leakingObjectFinder, heapDumpFile, analysisStartNanoTime);
            } catch (Throwable th) {
                exception = th;
                return new HeapAnalysisFailure(heapDumpFile, System.currentTimeMillis(), 0L, since(analysisStartNanoTime), new HeapAnalysisException(exception), 4, null);
            }
        } catch (Throwable th2) {
            exception = th2;
            analysisStartNanoTime = analysisStartNanoTime2;
        }
    }

    private final HeapAnalysisSuccess analyzeGraph(FindLeakInput $this$analyzeGraph, MetadataExtractor metadataExtractor, LeakingObjectFinder leakingObjectFinder, File heapDumpFile, long analysisStartNanoTime) {
        Map metadataWithCount;
        this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.EXTRACTING_METADATA);
        Map metadata = metadataExtractor.extractMetadata($this$analyzeGraph.getGraph());
        Iterable $this$count$iv = KeyedWeakReferenceFinder.INSTANCE.findKeyedWeakReferences$shark($this$analyzeGraph.getGraph());
        int i = 0;
        if (!($this$count$iv instanceof Collection) || !((Collection) $this$count$iv).isEmpty()) {
            int count$iv = 0;
            for (Object element$iv : $this$count$iv) {
                KeyedWeakReferenceMirror it = (KeyedWeakReferenceMirror) element$iv;
                if ((it.isRetained() && !it.getHasReferent()) && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            i = count$iv;
        }
        int retainedClearedWeakRefCount = i;
        if (retainedClearedWeakRefCount > 0) {
            metadataWithCount = MapsKt.plus(metadata, TuplesKt.to("Count of retained yet cleared", retainedClearedWeakRefCount + " KeyedWeakReference instances"));
        } else {
            metadataWithCount = metadata;
        }
        this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.FINDING_RETAINED_OBJECTS);
        Set leakingObjectIds = leakingObjectFinder.findLeakingObjectIds($this$analyzeGraph.getGraph());
        LeaksAndUnreachableObjects findLeaks = findLeaks($this$analyzeGraph, leakingObjectIds);
        List applicationLeaks = findLeaks.component1();
        List libraryLeaks = findLeaks.component2();
        List unreachableObjects = findLeaks.component3();
        return new HeapAnalysisSuccess(heapDumpFile, System.currentTimeMillis(), 0L, since(analysisStartNanoTime), metadataWithCount, applicationLeaks, libraryLeaks, unreachableObjects, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeapAnalyzer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lshark/HeapAnalyzer$LeaksAndUnreachableObjects;", "", "applicationLeaks", "", "Lshark/ApplicationLeak;", "libraryLeaks", "Lshark/LibraryLeak;", "unreachableObjects", "Lshark/LeakTraceObject;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getApplicationLeaks", "()Ljava/util/List;", "getLibraryLeaks", "getUnreachableObjects", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class LeaksAndUnreachableObjects {
        private final List<ApplicationLeak> applicationLeaks;
        private final List<LibraryLeak> libraryLeaks;
        private final List<LeakTraceObject> unreachableObjects;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LeaksAndUnreachableObjects copy$default(LeaksAndUnreachableObjects leaksAndUnreachableObjects, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = leaksAndUnreachableObjects.applicationLeaks;
            }
            if ((i & 2) != 0) {
                list2 = leaksAndUnreachableObjects.libraryLeaks;
            }
            if ((i & 4) != 0) {
                list3 = leaksAndUnreachableObjects.unreachableObjects;
            }
            return leaksAndUnreachableObjects.copy(list, list2, list3);
        }

        public final List<ApplicationLeak> component1() {
            return this.applicationLeaks;
        }

        public final List<LibraryLeak> component2() {
            return this.libraryLeaks;
        }

        public final List<LeakTraceObject> component3() {
            return this.unreachableObjects;
        }

        public final LeaksAndUnreachableObjects copy(List<ApplicationLeak> list, List<LibraryLeak> list2, List<LeakTraceObject> list3) {
            Intrinsics.checkParameterIsNotNull(list, "applicationLeaks");
            Intrinsics.checkParameterIsNotNull(list2, "libraryLeaks");
            Intrinsics.checkParameterIsNotNull(list3, "unreachableObjects");
            return new LeaksAndUnreachableObjects(list, list2, list3);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof LeaksAndUnreachableObjects) {
                    LeaksAndUnreachableObjects leaksAndUnreachableObjects = (LeaksAndUnreachableObjects) obj;
                    return Intrinsics.areEqual(this.applicationLeaks, leaksAndUnreachableObjects.applicationLeaks) && Intrinsics.areEqual(this.libraryLeaks, leaksAndUnreachableObjects.libraryLeaks) && Intrinsics.areEqual(this.unreachableObjects, leaksAndUnreachableObjects.unreachableObjects);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            List<ApplicationLeak> list = this.applicationLeaks;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<LibraryLeak> list2 = this.libraryLeaks;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<LeakTraceObject> list3 = this.unreachableObjects;
            return hashCode2 + (list3 != null ? list3.hashCode() : 0);
        }

        public String toString() {
            return "LeaksAndUnreachableObjects(applicationLeaks=" + this.applicationLeaks + ", libraryLeaks=" + this.libraryLeaks + ", unreachableObjects=" + this.unreachableObjects + ")";
        }

        public LeaksAndUnreachableObjects(List<ApplicationLeak> list, List<LibraryLeak> list2, List<LeakTraceObject> list3) {
            Intrinsics.checkParameterIsNotNull(list, "applicationLeaks");
            Intrinsics.checkParameterIsNotNull(list2, "libraryLeaks");
            Intrinsics.checkParameterIsNotNull(list3, "unreachableObjects");
            this.applicationLeaks = list;
            this.libraryLeaks = list2;
            this.unreachableObjects = list3;
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
    }

    private final LeaksAndUnreachableObjects findLeaks(FindLeakInput $this$findLeaks, Set<Long> set) {
        Map retainedSizes;
        PathFinder pathFinder = new PathFinder($this$findLeaks.getGraph(), this.listener, $this$findLeaks.getReferenceReader(), $this$findLeaks.getReferenceMatchers());
        PathFinder.PathFindingResults pathFindingResults = pathFinder.findPathsFromGcRoots(set, $this$findLeaks.getComputeRetainedHeapSize());
        List unreachableObjects = findUnreachableObjects($this$findLeaks, pathFindingResults, set);
        List shortestPaths = deduplicateShortestPaths(pathFindingResults.getPathsToLeakingObjects());
        List inspectedObjectsByPath = inspectObjects($this$findLeaks, shortestPaths);
        if (pathFindingResults.getDominatorTree() != null) {
            retainedSizes = computeRetainedSizes($this$findLeaks, inspectedObjectsByPath, pathFindingResults.getDominatorTree());
        } else {
            retainedSizes = null;
        }
        Pair<List<ApplicationLeak>, List<LibraryLeak>> buildLeakTraces = buildLeakTraces($this$findLeaks, shortestPaths, inspectedObjectsByPath, retainedSizes);
        List applicationLeaks = (List) buildLeakTraces.component1();
        List libraryLeaks = (List) buildLeakTraces.component2();
        return new LeaksAndUnreachableObjects(applicationLeaks, libraryLeaks, unreachableObjects);
    }

    private final List<LeakTraceObject> findUnreachableObjects(FindLeakInput $this$findUnreachableObjects, PathFinder.PathFindingResults pathFindingResults, Set<Long> set) {
        Set unreachableLeakingObjectIds;
        Iterable $this$map$iv = pathFindingResults.getPathsToLeakingObjects();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ReferencePathNode it = (ReferencePathNode) item$iv$iv;
            destination$iv$iv.add(Long.valueOf(it.getObjectId()));
        }
        Set reachableLeakingObjectIds = CollectionsKt.toSet((List) destination$iv$iv);
        Set unreachableLeakingObjectIds2 = SetsKt.minus(set, reachableLeakingObjectIds);
        Set $this$map$iv2 = unreachableLeakingObjectIds2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            long objectId = ((Number) item$iv$iv2).longValue();
            destination$iv$iv2.add(new ObjectReporter($this$findUnreachableObjects.getGraph().findObjectById(objectId)));
        }
        Iterable unreachableObjectReporters = (List) destination$iv$iv2;
        Iterable $this$forEach$iv = $this$findUnreachableObjects.getObjectInspectors();
        for (Object element$iv : $this$forEach$iv) {
            ObjectInspector inspector = (ObjectInspector) element$iv;
            Iterable $this$forEach$iv2 = unreachableObjectReporters;
            for (Object element$iv2 : $this$forEach$iv2) {
                inspector.inspect((ObjectReporter) element$iv2);
            }
        }
        Iterable $this$map$iv3 = unreachableObjectReporters;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            ObjectReporter reporter = (ObjectReporter) item$iv$iv3;
            Pair $dstr$status$reason = resolveStatus(reporter, true);
            LeakTraceObject.LeakingStatus status = (LeakTraceObject.LeakingStatus) $dstr$status$reason.component1();
            Set reachableLeakingObjectIds2 = reachableLeakingObjectIds;
            String reason = (String) $dstr$status$reason.component2();
            switch (status) {
                case LEAKING:
                    unreachableLeakingObjectIds = unreachableLeakingObjectIds2;
                    break;
                case UNKNOWN:
                    unreachableLeakingObjectIds = unreachableLeakingObjectIds2;
                    reason = "This is a leaking object";
                    break;
                case NOT_LEAKING:
                    unreachableLeakingObjectIds = unreachableLeakingObjectIds2;
                    reason = "This is a leaking object. Conflicts with " + reason;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            destination$iv$iv3.add(new InspectedObject(reporter.getHeapObject(), LeakTraceObject.LeakingStatus.LEAKING, reason, reporter.getLabels()));
            unreachableLeakingObjectIds2 = unreachableLeakingObjectIds;
            reachableLeakingObjectIds = reachableLeakingObjectIds2;
        }
        List unreachableInspectedObjects = (List) destination$iv$iv3;
        return buildLeakTraceObjects(unreachableInspectedObjects, null);
    }

    /* compiled from: HeapAnalyzer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lshark/HeapAnalyzer$TrieNode;", "", "()V", "objectId", "", "getObjectId", "()J", "LeafNode", "ParentNode", "Lshark/HeapAnalyzer$TrieNode$ParentNode;", "Lshark/HeapAnalyzer$TrieNode$LeafNode;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class TrieNode {
        public abstract long getObjectId();

        private TrieNode() {
        }

        public /* synthetic */ TrieNode(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* compiled from: HeapAnalyzer.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lshark/HeapAnalyzer$TrieNode$ParentNode;", "Lshark/HeapAnalyzer$TrieNode;", "objectId", "", "(J)V", "children", "", "getChildren", "()Ljava/util/Map;", "getObjectId", "()J", "toString", "", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class ParentNode extends TrieNode {
            private final Map<Long, TrieNode> children;
            private final long objectId;

            public ParentNode(long objectId) {
                super(null);
                this.objectId = objectId;
                this.children = new LinkedHashMap();
            }

            @Override // shark.HeapAnalyzer.TrieNode
            public long getObjectId() {
                return this.objectId;
            }

            public final Map<Long, TrieNode> getChildren() {
                return this.children;
            }

            public String toString() {
                return "ParentNode(objectId=" + getObjectId() + ", children=" + this.children + ')';
            }
        }

        /* compiled from: HeapAnalyzer.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lshark/HeapAnalyzer$TrieNode$LeafNode;", "Lshark/HeapAnalyzer$TrieNode;", "objectId", "", "pathNode", "Lshark/internal/ReferencePathNode;", "(JLshark/internal/ReferencePathNode;)V", "getObjectId", "()J", "getPathNode", "()Lshark/internal/ReferencePathNode;", "shark"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class LeafNode extends TrieNode {
            private final long objectId;
            private final ReferencePathNode pathNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LeafNode(long objectId, ReferencePathNode pathNode) {
                super(null);
                Intrinsics.checkParameterIsNotNull(pathNode, "pathNode");
                this.objectId = objectId;
                this.pathNode = pathNode;
            }

            @Override // shark.HeapAnalyzer.TrieNode
            public long getObjectId() {
                return this.objectId;
            }

            public final ReferencePathNode getPathNode() {
                return this.pathNode;
            }
        }
    }

    private final List<ShortestPath> deduplicateShortestPaths(List<? extends ReferencePathNode> list) {
        int i;
        TrieNode.ParentNode rootTrieNode = new TrieNode.ParentNode(0L);
        List<? extends ReferencePathNode> $this$forEach$iv = list;
        Iterator<T> it = $this$forEach$iv.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            ReferencePathNode pathNode = (ReferencePathNode) element$iv;
            List path = new ArrayList();
            ReferencePathNode leakNode = pathNode;
            while (leakNode instanceof ReferencePathNode.ChildNode) {
                path.add(0, Long.valueOf(leakNode.getObjectId()));
                leakNode = ((ReferencePathNode.ChildNode) leakNode).getParent();
            }
            path.add(0, Long.valueOf(leakNode.getObjectId()));
            updateTrie(pathNode, path, 0, rootTrieNode);
        }
        List outputPathResults = new ArrayList();
        findResultsInTrie(rootTrieNode, outputPathResults);
        if (outputPathResults.size() != list.size()) {
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d("Found " + list.size() + " paths to retained objects, down to " + outputPathResults.size() + " after removing duplicated paths");
            }
        } else {
            SharkLog this_$iv2 = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv2 = this_$iv2.getLogger();
            if (logger$iv2 != null) {
                logger$iv2.d("Found " + outputPathResults.size() + " paths to retained objects");
            }
        }
        List $this$map$iv = outputPathResults;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ReferencePathNode retainedObjectNode = (ReferencePathNode) item$iv$iv;
            List shortestChildPath = new ArrayList();
            ReferencePathNode node = retainedObjectNode;
            while (node instanceof ReferencePathNode.ChildNode) {
                shortestChildPath.add(i, node);
                node = ((ReferencePathNode.ChildNode) node).getParent();
            }
            if (node == null) {
                throw new TypeCastException("null cannot be cast to non-null type shark.internal.ReferencePathNode.RootNode");
            }
            ReferencePathNode.RootNode rootNode = (ReferencePathNode.RootNode) node;
            destination$iv$iv.add(new ShortestPath(rootNode, shortestChildPath));
            i = 0;
        }
        return (List) destination$iv$iv;
    }

    private final void updateTrie(ReferencePathNode pathNode, List<Long> list, int pathIndex, TrieNode.ParentNode parentNode) {
        long objectId = list.get(pathIndex).longValue();
        if (pathIndex == CollectionsKt.getLastIndex(list)) {
            parentNode.getChildren().put(Long.valueOf(objectId), new TrieNode.LeafNode(objectId, pathNode));
            return;
        }
        TrieNode.ParentNode childNode = parentNode.getChildren().get(Long.valueOf(objectId));
        if (childNode == null) {
            TrieNode.ParentNode newChildNode = new TrieNode.ParentNode(objectId);
            parentNode.getChildren().put(Long.valueOf(objectId), newChildNode);
            childNode = newChildNode;
        }
        if (childNode instanceof TrieNode.ParentNode) {
            updateTrie(pathNode, list, pathIndex + 1, (TrieNode.ParentNode) childNode);
        }
    }

    private final void findResultsInTrie(TrieNode.ParentNode parentNode, List<ReferencePathNode> list) {
        Iterable $this$forEach$iv = parentNode.getChildren().values();
        for (Object element$iv : $this$forEach$iv) {
            TrieNode childNode = (TrieNode) element$iv;
            if (childNode instanceof TrieNode.ParentNode) {
                findResultsInTrie((TrieNode.ParentNode) childNode, list);
            } else if (childNode instanceof TrieNode.LeafNode) {
                list.add(((TrieNode.LeafNode) childNode).getPathNode());
            }
        }
    }

    /* compiled from: HeapAnalyzer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005J\u001a\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000b0\u0005J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lshark/HeapAnalyzer$ShortestPath;", "", "root", "Lshark/internal/ReferencePathNode$RootNode;", "childPath", "", "Lshark/internal/ReferencePathNode$ChildNode;", "(Lshark/internal/ReferencePathNode$RootNode;Ljava/util/List;)V", "getChildPath", "()Ljava/util/List;", "childPathWithDetails", "Lkotlin/Pair;", "Lshark/internal/Reference$LazyDetails;", "getChildPathWithDetails", "getRoot", "()Lshark/internal/ReferencePathNode$RootNode;", "asList", "Lshark/internal/ReferencePathNode;", "asNodesWithMatchers", "Lshark/LibraryLeakReferenceMatcher;", "firstLibraryLeakMatcher", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShortestPath {
        private final List<ReferencePathNode.ChildNode> childPath;
        private final List<Pair<ReferencePathNode.ChildNode, Reference.LazyDetails>> childPathWithDetails;
        private final ReferencePathNode.RootNode root;

        public ShortestPath(ReferencePathNode.RootNode root, List<ReferencePathNode.ChildNode> list) {
            Intrinsics.checkParameterIsNotNull(root, "root");
            Intrinsics.checkParameterIsNotNull(list, "childPath");
            this.root = root;
            this.childPath = list;
            Iterable $this$map$iv = this.childPath;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ReferencePathNode.ChildNode it = (ReferencePathNode.ChildNode) item$iv$iv;
                destination$iv$iv.add(TuplesKt.to(it, it.getLazyDetailsResolver().resolve()));
            }
            this.childPathWithDetails = (List) destination$iv$iv;
        }

        public final ReferencePathNode.RootNode getRoot() {
            return this.root;
        }

        public final List<ReferencePathNode.ChildNode> getChildPath() {
            return this.childPath;
        }

        public final List<Pair<ReferencePathNode.ChildNode, Reference.LazyDetails>> getChildPathWithDetails() {
            return this.childPathWithDetails;
        }

        public final List<ReferencePathNode> asList() {
            return CollectionsKt.plus(CollectionsKt.listOf(this.root), this.childPath);
        }

        public final LibraryLeakReferenceMatcher firstLibraryLeakMatcher() {
            Object element$iv;
            boolean z;
            if (this.root instanceof ReferencePathNode.RootNode.LibraryLeakRootNode) {
                return ((ReferencePathNode.RootNode.LibraryLeakRootNode) this.root).getMatcher();
            }
            Iterable $this$map$iv = this.childPathWithDetails;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Pair it = (Pair) item$iv$iv;
                destination$iv$iv.add(((Reference.LazyDetails) it.getSecond()).getMatchedLibraryLeak());
            }
            Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
            Iterator it2 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it2.next();
                LibraryLeakReferenceMatcher it3 = (LibraryLeakReferenceMatcher) element$iv;
                if (it3 != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return (LibraryLeakReferenceMatcher) element$iv;
        }

        public final List<Pair<ReferencePathNode, LibraryLeakReferenceMatcher>> asNodesWithMatchers() {
            LibraryLeakReferenceMatcher rootMatcher;
            if (this.root instanceof ReferencePathNode.RootNode.LibraryLeakRootNode) {
                rootMatcher = ((ReferencePathNode.RootNode.LibraryLeakRootNode) this.root).getMatcher();
            } else {
                rootMatcher = null;
            }
            Iterable $this$map$iv = this.childPathWithDetails;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Pair it = (Pair) item$iv$iv;
                destination$iv$iv.add(TuplesKt.to(it.getFirst(), ((Reference.LazyDetails) it.getSecond()).getMatchedLibraryLeak()));
            }
            List childPathWithMatchers = (List) destination$iv$iv;
            return CollectionsKt.plus(CollectionsKt.listOf(TuplesKt.to(this.root, rootMatcher)), childPathWithMatchers);
        }
    }

    private final Pair<List<ApplicationLeak>, List<LibraryLeak>> buildLeakTraces(FindLeakInput $this$buildLeakTraces, List<ShortestPath> list, List<? extends List<InspectedObject>> list2, Map<Long, Pair<Integer, Integer>> map) {
        Iterator it;
        HeapAnalyzer heapAnalyzer = this;
        heapAnalyzer.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.BUILDING_LEAK_TRACES);
        Map applicationLeaksMap = new LinkedHashMap();
        Map libraryLeaksMap = new LinkedHashMap();
        List<ShortestPath> $this$forEachIndexed$iv = list;
        boolean z = false;
        int index$iv = 0;
        Iterator it2 = $this$forEachIndexed$iv.iterator();
        while (it2.hasNext()) {
            Object item$iv = it2.next();
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ShortestPath shortestPath = (ShortestPath) item$iv;
            List inspectedObjects = list2.get(index$iv);
            List leakTraceObjects = heapAnalyzer.buildLeakTraceObjects(inspectedObjects, map);
            Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            List referencePath = heapAnalyzer.buildReferencePath($this$buildLeakTraces, shortestPath, leakTraceObjects);
            boolean z2 = z;
            LeakTrace leakTrace = new LeakTrace(LeakTrace.GcRootType.Companion.fromGcRoot(shortestPath.getRoot().getGcRoot()), referencePath, (LeakTraceObject) CollectionsKt.last(leakTraceObjects));
            LibraryLeakReferenceMatcher firstLibraryLeakMatcher = shortestPath.firstLibraryLeakMatcher();
            if (firstLibraryLeakMatcher != null) {
                String signature = StringsKt.createSHA1Hash(firstLibraryLeakMatcher.getPattern().toString());
                Object value$iv = libraryLeaksMap.get(signature);
                if (value$iv == null) {
                    it = it2;
                    Pair pair = TuplesKt.to(firstLibraryLeakMatcher, new ArrayList());
                    libraryLeaksMap.put(signature, pair);
                    value$iv = pair;
                } else {
                    it = it2;
                }
                ((List) ((Pair) value$iv).getSecond()).add(leakTrace);
            } else {
                it = it2;
                String signature2 = leakTrace.getSignature();
                Object value$iv2 = applicationLeaksMap.get(signature2);
                if (value$iv2 == null) {
                    ArrayList arrayList = new ArrayList();
                    applicationLeaksMap.put(signature2, arrayList);
                    value$iv2 = arrayList;
                }
                ((Collection) ((List) value$iv2)).add(leakTrace);
            }
            heapAnalyzer = this;
            index$iv = index$iv2;
            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
            z = z2;
            it2 = it;
        }
        Collection destination$iv$iv = new ArrayList(applicationLeaksMap.size());
        for (Map.Entry item$iv$iv : applicationLeaksMap.entrySet()) {
            List leakTraces = (List) item$iv$iv.getValue();
            destination$iv$iv.add(new ApplicationLeak(leakTraces));
        }
        List applicationLeaks = (List) destination$iv$iv;
        Map $this$map$iv = libraryLeaksMap;
        int $i$f$map = 0;
        Collection destination$iv$iv2 = new ArrayList($this$map$iv.size());
        for (Map.Entry item$iv$iv2 : $this$map$iv.entrySet()) {
            Pair pair2 = (Pair) item$iv$iv2.getValue();
            LibraryLeakReferenceMatcher matcher = (LibraryLeakReferenceMatcher) pair2.component1();
            List leakTraces2 = (List) pair2.component2();
            destination$iv$iv2.add(new LibraryLeak(leakTraces2, matcher.getPattern(), matcher.getDescription()));
            applicationLeaksMap = applicationLeaksMap;
            libraryLeaksMap = libraryLeaksMap;
            $this$map$iv = $this$map$iv;
            $i$f$map = $i$f$map;
        }
        List libraryLeaks = (List) destination$iv$iv2;
        return TuplesKt.to(applicationLeaks, libraryLeaks);
    }

    private final List<List<InspectedObject>> inspectObjects(FindLeakInput $this$inspectObjects, List<ShortestPath> list) {
        boolean z;
        this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.INSPECTING_OBJECTS);
        List<ShortestPath> $this$map$iv = list;
        boolean z2 = false;
        int i = 10;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        boolean z3 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            ShortestPath path = (ShortestPath) item$iv$iv;
            List pathList = path.asNodesWithMatchers();
            List $this$mapIndexed$iv = pathList;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, i));
            int index$iv$iv = 0;
            for (Object item$iv$iv2 : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair $dstr$node$_u24__u24 = (Pair) item$iv$iv2;
                ReferencePathNode node = (ReferencePathNode) $dstr$node$_u24__u24.component1();
                Iterable $this$map$iv2 = $this$map$iv;
                Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                boolean z4 = z3;
                ObjectReporter reporter = new ObjectReporter($this$inspectObjects.getGraph().findObjectById(node.getObjectId()));
                if (index$iv$iv + 1 >= pathList.size()) {
                    z = z2;
                } else {
                    LibraryLeakReferenceMatcher nextMatcher = (LibraryLeakReferenceMatcher) pathList.get(index$iv$iv + 1).component2();
                    if (nextMatcher == null) {
                        z = z2;
                    } else {
                        z = z2;
                        reporter.getLabels().add("Library leak match: " + nextMatcher.getPattern());
                    }
                }
                destination$iv$iv2.add(reporter);
                index$iv$iv = index$iv$iv2;
                $this$map$iv = $this$map$iv2;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                z3 = z4;
                z2 = z;
            }
            destination$iv$iv.add((List) destination$iv$iv2);
            $this$map$iv = $this$map$iv;
            i = 10;
        }
        Iterable leakReportersByPath = (List) destination$iv$iv;
        Iterable $this$forEach$iv = $this$inspectObjects.getObjectInspectors();
        for (Object element$iv : $this$forEach$iv) {
            ObjectInspector inspector = (ObjectInspector) element$iv;
            for (Object element$iv2 : leakReportersByPath) {
                Iterable leakReporters = (List) element$iv2;
                for (Object element$iv3 : leakReporters) {
                    inspector.inspect((ObjectReporter) element$iv3);
                    $this$forEach$iv = $this$forEach$iv;
                }
            }
        }
        Iterable $this$map$iv3 = leakReportersByPath;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            List leakReporters2 = (List) item$iv$iv3;
            destination$iv$iv3.add(computeLeakStatuses(leakReporters2));
        }
        return (List) destination$iv$iv3;
    }

    private final Map<Long, Pair<Integer, Integer>> computeRetainedSizes(FindLeakInput $this$computeRetainedSizes, List<? extends List<InspectedObject>> list, DominatorTree dominatorTree) {
        List<? extends List<InspectedObject>> $this$flatMap$iv = list;
        boolean z = false;
        Collection destination$iv$iv = new ArrayList();
        Iterable<Iterable> $this$flatMapTo$iv$iv = $this$flatMap$iv;
        for (Iterable inspectedObjects : $this$flatMapTo$iv$iv) {
            Iterable $this$filter$iv = inspectedObjects;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                InspectedObject it = (InspectedObject) element$iv$iv;
                boolean z2 = z;
                Iterable $this$flatMapTo$iv$iv2 = $this$flatMapTo$iv$iv;
                if (it.getLeakingStatus() == LeakTraceObject.LeakingStatus.UNKNOWN || it.getLeakingStatus() == LeakTraceObject.LeakingStatus.LEAKING) {
                    destination$iv$iv2.add(element$iv$iv);
                }
                $this$flatMap$iv = $this$flatMap$iv2;
                z = z2;
                $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv2;
            }
            Iterable $this$flatMap$iv3 = $this$flatMap$iv;
            boolean z3 = z;
            Iterable $this$flatMapTo$iv$iv3 = $this$flatMapTo$iv$iv;
            Iterable $this$map$iv = (List) destination$iv$iv2;
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv3.add(Long.valueOf(((InspectedObject) item$iv$iv).getHeapObject().getObjectId()));
            }
            Iterable list$iv$iv = (List) destination$iv$iv3;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            $this$flatMap$iv = $this$flatMap$iv3;
            z = z3;
            $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv3;
        }
        Set nodeObjectIds = CollectionsKt.toSet((List) destination$iv$iv);
        this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.COMPUTING_NATIVE_RETAINED_SIZE);
        AndroidNativeSizeMapper nativeSizeMapper = new AndroidNativeSizeMapper($this$computeRetainedSizes.getGraph());
        final Map nativeSizes = nativeSizeMapper.mapNativeSizes();
        this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.COMPUTING_RETAINED_SIZE);
        final ShallowSizeCalculator shallowSizeCalculator = new ShallowSizeCalculator($this$computeRetainedSizes.getGraph());
        return dominatorTree.computeRetainedSizes(nodeObjectIds, new Function1<Long, Integer>() { // from class: shark.HeapAnalyzer$computeRetainedSizes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Integer.valueOf(invoke(((Number) obj).longValue()));
            }

            public final int invoke(long objectId) {
                Integer num = (Integer) nativeSizes.get(Long.valueOf(objectId));
                int nativeSize = num != null ? num.intValue() : 0;
                int shallowSize = shallowSizeCalculator.computeShallowSize(objectId);
                return nativeSize + shallowSize;
            }
        });
    }

    private final List<LeakTraceObject> buildLeakTraceObjects(List<InspectedObject> list, Map<Long, Pair<Integer, Integer>> map) {
        LeakTraceObject.ObjectType objectType;
        Map<Long, Pair<Integer, Integer>> map2 = map;
        List<InspectedObject> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            InspectedObject inspectedObject = (InspectedObject) item$iv$iv;
            HeapObject heapObject = inspectedObject.getHeapObject();
            String className = recordClassName(heapObject);
            if (heapObject instanceof HeapObject.HeapClass) {
                objectType = LeakTraceObject.ObjectType.CLASS;
            } else {
                objectType = ((heapObject instanceof HeapObject.HeapObjectArray) || (heapObject instanceof HeapObject.HeapPrimitiveArray)) ? LeakTraceObject.ObjectType.ARRAY : LeakTraceObject.ObjectType.INSTANCE;
            }
            Integer num = null;
            Pair retainedSizeAndObjectCount = map2 != null ? map2.get(Long.valueOf(inspectedObject.getHeapObject().getObjectId())) : null;
            Set<String> labels = inspectedObject.getLabels();
            LeakTraceObject.LeakingStatus leakingStatus = inspectedObject.getLeakingStatus();
            String leakingStatusReason = inspectedObject.getLeakingStatusReason();
            Integer num2 = retainedSizeAndObjectCount != null ? (Integer) retainedSizeAndObjectCount.getFirst() : null;
            if (retainedSizeAndObjectCount != null) {
                num = (Integer) retainedSizeAndObjectCount.getSecond();
            }
            destination$iv$iv.add(new LeakTraceObject(objectType, className, labels, leakingStatus, leakingStatusReason, num2, num));
            map2 = map;
        }
        return (List) destination$iv$iv;
    }

    private final List<LeakTraceReference> buildReferencePath(FindLeakInput $this$buildReferencePath, ShortestPath shortestPath, List<LeakTraceObject> list) {
        Iterable $this$mapIndexed$iv;
        LeakTraceReference.ReferenceType referenceType;
        Iterable $this$mapIndexed$iv2 = shortestPath.getChildPathWithDetails();
        int $i$f$mapIndexed = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
        Iterable $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv2;
        int $i$f$mapIndexedTo = 0;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair $dstr$childNode$details = (Pair) item$iv$iv;
            ReferencePathNode.ChildNode childNode = (ReferencePathNode.ChildNode) $dstr$childNode$details.component1();
            Reference.LazyDetails details = (Reference.LazyDetails) $dstr$childNode$details.component2();
            LeakTraceObject leakTraceObject = list.get(index$iv$iv);
            switch (details.getLocationType()) {
                case INSTANCE_FIELD:
                    $this$mapIndexed$iv = $this$mapIndexed$iv2;
                    referenceType = LeakTraceReference.ReferenceType.INSTANCE_FIELD;
                    break;
                case STATIC_FIELD:
                    $this$mapIndexed$iv = $this$mapIndexed$iv2;
                    referenceType = LeakTraceReference.ReferenceType.STATIC_FIELD;
                    break;
                case LOCAL:
                    $this$mapIndexed$iv = $this$mapIndexed$iv2;
                    referenceType = LeakTraceReference.ReferenceType.LOCAL;
                    break;
                case ARRAY_ENTRY:
                    $this$mapIndexed$iv = $this$mapIndexed$iv2;
                    referenceType = LeakTraceReference.ReferenceType.ARRAY_ENTRY;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            int $i$f$mapIndexed2 = $i$f$mapIndexed;
            Iterable $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv;
            int $i$f$mapIndexedTo2 = $i$f$mapIndexedTo;
            HeapObject.HeapClass asClass = $this$buildReferencePath.getGraph().findObjectById(details.getLocationClassObjectId()).getAsClass();
            if (asClass == null) {
                Intrinsics.throwNpe();
            }
            destination$iv$iv.add(new LeakTraceReference(leakTraceObject, referenceType, asClass.getName(), details.getName()));
            index$iv$iv = index$iv$iv2;
            $i$f$mapIndexed = $i$f$mapIndexed2;
            $this$mapIndexed$iv2 = $this$mapIndexed$iv;
            $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv2;
            $i$f$mapIndexedTo = $i$f$mapIndexedTo2;
        }
        return (List) destination$iv$iv;
    }

    /* compiled from: HeapAnalyzer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lshark/HeapAnalyzer$InspectedObject;", "", "heapObject", "Lshark/HeapObject;", "leakingStatus", "Lshark/LeakTraceObject$LeakingStatus;", "leakingStatusReason", "", "labels", "", "(Lshark/HeapObject;Lshark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/util/Set;)V", "getHeapObject", "()Lshark/HeapObject;", "getLabels", "()Ljava/util/Set;", "getLeakingStatus", "()Lshark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "()Ljava/lang/String;", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class InspectedObject {
        private final HeapObject heapObject;
        private final Set<String> labels;
        private final LeakTraceObject.LeakingStatus leakingStatus;
        private final String leakingStatusReason;

        public InspectedObject(HeapObject heapObject, LeakTraceObject.LeakingStatus leakingStatus, String leakingStatusReason, Set<String> set) {
            Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
            Intrinsics.checkParameterIsNotNull(leakingStatus, "leakingStatus");
            Intrinsics.checkParameterIsNotNull(leakingStatusReason, "leakingStatusReason");
            Intrinsics.checkParameterIsNotNull(set, "labels");
            this.heapObject = heapObject;
            this.leakingStatus = leakingStatus;
            this.leakingStatusReason = leakingStatusReason;
            this.labels = set;
        }

        public final HeapObject getHeapObject() {
            return this.heapObject;
        }

        public final LeakTraceObject.LeakingStatus getLeakingStatus() {
            return this.leakingStatus;
        }

        public final String getLeakingStatusReason() {
            return this.leakingStatusReason;
        }

        public final Set<String> getLabels() {
            return this.labels;
        }
    }

    private final List<InspectedObject> computeLeakStatuses(List<ObjectReporter> list) {
        int i;
        int i2;
        Pair pair;
        Pair pair2;
        int lastElementIndex = list.size() - 1;
        final Ref.IntRef lastNotLeakingElementIndex = new Ref.IntRef();
        lastNotLeakingElementIndex.element = -1;
        final Ref.IntRef firstLeakingElementIndex = new Ref.IntRef();
        firstLeakingElementIndex.element = lastElementIndex;
        ArrayList leakStatuses = new ArrayList();
        int index = 0;
        for (ObjectReporter reporter : list) {
            Pair statusPair = resolveStatus(reporter, index == lastElementIndex);
            if (index == lastElementIndex) {
                switch ((LeakTraceObject.LeakingStatus) statusPair.getFirst()) {
                    case LEAKING:
                        break;
                    case UNKNOWN:
                        statusPair = TuplesKt.to(LeakTraceObject.LeakingStatus.LEAKING, "This is the leaking object");
                        break;
                    case NOT_LEAKING:
                        statusPair = TuplesKt.to(LeakTraceObject.LeakingStatus.LEAKING, "This is the leaking object. Conflicts with " + ((String) statusPair.getSecond()));
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            leakStatuses.add(statusPair);
            LeakTraceObject.LeakingStatus leakStatus = (LeakTraceObject.LeakingStatus) statusPair.component1();
            if (leakStatus == LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                lastNotLeakingElementIndex.element = index;
                firstLeakingElementIndex.element = lastElementIndex;
            } else if (leakStatus == LeakTraceObject.LeakingStatus.LEAKING && firstLeakingElementIndex.element == lastElementIndex) {
                firstLeakingElementIndex.element = index;
            }
            index++;
        }
        List<ObjectReporter> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ObjectReporter reporter2 = (ObjectReporter) item$iv$iv;
            destination$iv$iv.add(StringsKt.lastSegment(recordClassName(reporter2.getHeapObject()), '.'));
        }
        List simpleClassNames = (List) destination$iv$iv;
        int i3 = lastNotLeakingElementIndex.element;
        for (int i4 = 0; i4 < i3; i4++) {
            Pair pair3 = (Pair) leakStatuses.get(i4);
            LeakTraceObject.LeakingStatus leakStatus2 = (LeakTraceObject.LeakingStatus) pair3.component1();
            String leakStatusReason = (String) pair3.component2();
            Sequence $this$first$iv = SequencesKt.generateSequence(Integer.valueOf(i4 + 1), new Function1<Integer, Integer>() { // from class: shark.HeapAnalyzer$computeLeakStatuses$nextNotLeakingIndex$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Integer invoke(int index2) {
                    if (index2 < lastNotLeakingElementIndex.element) {
                        return Integer.valueOf(index2 + 1);
                    }
                    return null;
                }
            });
            for (Object element$iv : $this$first$iv) {
                int index2 = ((Number) element$iv).intValue();
                if (((LeakTraceObject.LeakingStatus) ((Pair) leakStatuses.get(index2)).getFirst()) == LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                    int nextNotLeakingIndex = ((Number) element$iv).intValue();
                    String nextNotLeakingName = (String) simpleClassNames.get(nextNotLeakingIndex);
                    switch (leakStatus2) {
                        case UNKNOWN:
                            pair2 = TuplesKt.to(LeakTraceObject.LeakingStatus.NOT_LEAKING, nextNotLeakingName + "↓ is not leaking");
                            break;
                        case NOT_LEAKING:
                            pair2 = TuplesKt.to(LeakTraceObject.LeakingStatus.NOT_LEAKING, nextNotLeakingName + "↓ is not leaking and " + leakStatusReason);
                            break;
                        case LEAKING:
                            pair2 = TuplesKt.to(LeakTraceObject.LeakingStatus.NOT_LEAKING, nextNotLeakingName + "↓ is not leaking. Conflicts with " + leakStatusReason);
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    leakStatuses.set(i4, pair2);
                }
            }
            throw new NoSuchElementException("Sequence contains no element matching the predicate.");
        }
        if (firstLeakingElementIndex.element < lastElementIndex - 1 && lastElementIndex - 1 >= (i = firstLeakingElementIndex.element + 1)) {
            while (true) {
                Pair pair4 = (Pair) leakStatuses.get(i2);
                LeakTraceObject.LeakingStatus leakStatus3 = (LeakTraceObject.LeakingStatus) pair4.component1();
                String leakStatusReason2 = (String) pair4.component2();
                Sequence $this$first$iv2 = SequencesKt.generateSequence(Integer.valueOf(i2 - 1), new Function1<Integer, Integer>() { // from class: shark.HeapAnalyzer$computeLeakStatuses$previousLeakingIndex$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }

                    public final Integer invoke(int index3) {
                        if (index3 > firstLeakingElementIndex.element) {
                            return Integer.valueOf(index3 - 1);
                        }
                        return null;
                    }
                });
                for (Object element$iv2 : $this$first$iv2) {
                    int index3 = ((Number) element$iv2).intValue();
                    int lastElementIndex2 = lastElementIndex;
                    if (((LeakTraceObject.LeakingStatus) ((Pair) leakStatuses.get(index3)).getFirst()) == LeakTraceObject.LeakingStatus.LEAKING) {
                        int previousLeakingIndex = ((Number) element$iv2).intValue();
                        String previousLeakingName = (String) simpleClassNames.get(previousLeakingIndex);
                        switch (leakStatus3) {
                            case UNKNOWN:
                                pair = TuplesKt.to(LeakTraceObject.LeakingStatus.LEAKING, previousLeakingName + "↑ is leaking");
                                break;
                            case LEAKING:
                                pair = TuplesKt.to(LeakTraceObject.LeakingStatus.LEAKING, previousLeakingName + "↑ is leaking and " + leakStatusReason2);
                                break;
                            case NOT_LEAKING:
                                throw new IllegalStateException("Should never happen");
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        leakStatuses.set(i2, pair);
                        if (i2 != i) {
                            i2--;
                            lastElementIndex = lastElementIndex2;
                        }
                    } else {
                        lastElementIndex = lastElementIndex2;
                    }
                }
                throw new NoSuchElementException("Sequence contains no element matching the predicate.");
            }
        }
        List<ObjectReporter> $this$mapIndexed$iv = list;
        int $i$f$mapIndexed = 0;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv2 : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ObjectReporter objectReporter = (ObjectReporter) item$iv$iv2;
            Pair pair5 = (Pair) leakStatuses.get(index$iv$iv);
            Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
            LeakTraceObject.LeakingStatus leakingStatus = (LeakTraceObject.LeakingStatus) pair5.component1();
            String leakingStatusReason = (String) pair5.component2();
            destination$iv$iv2.add(new InspectedObject(objectReporter.getHeapObject(), leakingStatus, leakingStatusReason, objectReporter.getLabels()));
            index$iv$iv = index$iv$iv2;
            $i$f$mapIndexed = $i$f$mapIndexed;
            $this$mapIndexed$iv = $this$mapIndexed$iv2;
            lastNotLeakingElementIndex = lastNotLeakingElementIndex;
            firstLeakingElementIndex = firstLeakingElementIndex;
        }
        return (List) destination$iv$iv2;
    }

    private final Pair<LeakTraceObject.LeakingStatus, String> resolveStatus(ObjectReporter reporter, boolean leakingWins) {
        LeakTraceObject.LeakingStatus status = LeakTraceObject.LeakingStatus.UNKNOWN;
        String reason = "";
        if (!reporter.getNotLeakingReasons().isEmpty()) {
            status = LeakTraceObject.LeakingStatus.NOT_LEAKING;
            reason = CollectionsKt.joinToString$default(reporter.getNotLeakingReasons(), " and ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        Set leakingReasons = reporter.getLeakingReasons();
        if (!leakingReasons.isEmpty()) {
            String winReasons = CollectionsKt.joinToString$default(leakingReasons, " and ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (status != LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                status = LeakTraceObject.LeakingStatus.LEAKING;
                reason = winReasons;
            } else if (!leakingWins) {
                reason = reason + ". Conflicts with " + winReasons;
            } else {
                status = LeakTraceObject.LeakingStatus.LEAKING;
                reason = winReasons + ". Conflicts with " + reason;
            }
        }
        return TuplesKt.to(status, reason);
    }

    private final String recordClassName(HeapObject heap) {
        if (heap instanceof HeapObject.HeapClass) {
            return ((HeapObject.HeapClass) heap).getName();
        }
        if (heap instanceof HeapObject.HeapInstance) {
            return ((HeapObject.HeapInstance) heap).getInstanceClassName();
        }
        if (heap instanceof HeapObject.HeapObjectArray) {
            return ((HeapObject.HeapObjectArray) heap).getArrayClassName();
        }
        if (heap instanceof HeapObject.HeapPrimitiveArray) {
            return ((HeapObject.HeapPrimitiveArray) heap).getArrayClassName();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final long since(long analysisStartNanoTime) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - analysisStartNanoTime);
    }
}