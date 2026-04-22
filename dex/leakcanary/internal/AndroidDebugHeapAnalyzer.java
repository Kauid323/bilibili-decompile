package leakcanary.internal;

import android.app.Application;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import leakcanary.EventListener;
import leakcanary.LeakCanary;
import leakcanary.internal.activity.LeakActivity;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.activity.db.LeakTable;
import leakcanary.internal.activity.db.ScopedLeaksDb;
import shark.CloseableHeapGraph;
import shark.ConstantMemoryMetricsDualSourceProvider;
import shark.DualSourceProvider;
import shark.HeapAnalysis;
import shark.HeapAnalysisException;
import shark.HeapAnalysisFailure;
import shark.HeapAnalysisSuccess;
import shark.HeapAnalyzer;
import shark.HeapGraph;
import shark.HprofHeapGraph;
import shark.Leak;
import shark.OnAnalysisProgressListener;
import shark.ProguardMappingReader;
import shark.ThrowingCancelableFileSourceProvider;

/* compiled from: AndroidDebugHeapAnalyzer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0002J6\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lleakcanary/internal/AndroidDebugHeapAnalyzer;", "", "()V", "PROGUARD_MAPPING_FILE_NAME", "", "application", "Landroid/app/Application;", "analyzeHeap", "Lshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "progressListener", "Lshark/OnAnalysisProgressListener;", "isCanceled", "Lkotlin/Function0;", "", "missingFileFailure", "Lshark/HeapAnalysisFailure;", "runAnalysisBlocking", "Lleakcanary/EventListener$Event$HeapAnalysisDone;", "heapDumped", "Lleakcanary/EventListener$Event$HeapDump;", "progressEventListener", "Lkotlin/Function1;", "Lleakcanary/EventListener$Event$HeapAnalysisProgress;", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class AndroidDebugHeapAnalyzer {
    private static final String PROGUARD_MAPPING_FILE_NAME = "leakCanaryObfuscationMapping.txt";
    public static final AndroidDebugHeapAnalyzer INSTANCE = new AndroidDebugHeapAnalyzer();
    private static final Application application = InternalLeakCanary.INSTANCE.getApplication();

    private AndroidDebugHeapAnalyzer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventListener.Event.HeapAnalysisDone runAnalysisBlocking$default(AndroidDebugHeapAnalyzer androidDebugHeapAnalyzer, EventListener.Event.HeapDump heapDump, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: leakcanary.internal.AndroidDebugHeapAnalyzer$runAnalysisBlocking$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    return false;
                }
            };
        }
        return androidDebugHeapAnalyzer.runAnalysisBlocking(heapDump, function0, function1);
    }

    public final EventListener.Event.HeapAnalysisDone<?> runAnalysisBlocking(final EventListener.Event.HeapDump heapDumped, Function0<Boolean> isCanceled, final Function1<? super EventListener.Event.HeapAnalysisProgress, Unit> progressEventListener) {
        HeapAnalysisSuccess heapAnalysisSuccess;
        HeapAnalysisSuccess heapAnalysis;
        HeapAnalysisFailure copy$default;
        final HeapAnalysis fullHeapAnalysis;
        Intrinsics.checkParameterIsNotNull(heapDumped, "heapDumped");
        Intrinsics.checkParameterIsNotNull(isCanceled, "isCanceled");
        Intrinsics.checkParameterIsNotNull(progressEventListener, "progressEventListener");
        OnAnalysisProgressListener progressListener = new OnAnalysisProgressListener() { // from class: leakcanary.internal.AndroidDebugHeapAnalyzer$runAnalysisBlocking$progressListener$1
            public final void onAnalysisProgress(OnAnalysisProgressListener.Step step) {
                Intrinsics.checkParameterIsNotNull(step, "step");
                double percent = (step.ordinal() * 1.0d) / OnAnalysisProgressListener.Step.values().length;
                Function1.this.invoke(new EventListener.Event.HeapAnalysisProgress(heapDumped.getUniqueId(), step, percent));
            }
        };
        File heapDumpFile = heapDumped.getFile();
        long heapDumpDurationMillis = heapDumped.getDurationMillis();
        String heapDumpReason = heapDumped.getReason();
        if (heapDumpFile.exists()) {
            heapAnalysisSuccess = analyzeHeap(heapDumpFile, progressListener, isCanceled);
        } else {
            heapAnalysisSuccess = (HeapAnalysis) missingFileFailure(heapDumpFile);
        }
        HeapAnalysisSuccess heapAnalysisSuccess2 = heapAnalysisSuccess;
        if (heapAnalysisSuccess2 instanceof HeapAnalysisSuccess) {
            fullHeapAnalysis = (HeapAnalysis) HeapAnalysisSuccess.copy$default(heapAnalysisSuccess2, (File) null, 0L, heapDumpDurationMillis, 0L, MapsKt.plus(heapAnalysisSuccess2.getMetadata(), TuplesKt.to("Heap dump reason", heapDumpReason)), (List) null, (List) null, (List) null, 235, (Object) null);
            heapAnalysis = heapAnalysisSuccess2;
        } else if (heapAnalysisSuccess2 instanceof HeapAnalysisFailure) {
            Throwable failureCause = ((HeapAnalysisFailure) heapAnalysisSuccess2).getException().getCause();
            if (failureCause == null) {
                Intrinsics.throwNpe();
            }
            if (!(failureCause instanceof OutOfMemoryError)) {
                heapAnalysis = heapAnalysisSuccess2;
                copy$default = HeapAnalysisFailure.copy$default((HeapAnalysisFailure) heapAnalysisSuccess2, (File) null, 0L, heapDumpDurationMillis, 0L, (HeapAnalysisException) null, 27, (Object) null);
            } else {
                copy$default = HeapAnalysisFailure.copy$default((HeapAnalysisFailure) heapAnalysisSuccess2, (File) null, 0L, heapDumpDurationMillis, 0L, new HeapAnalysisException(new RuntimeException("Not enough memory to analyze heap. You can:\n- Kill the app then restart the analysis from the LeakCanary activity.\n- Increase the memory available to your debug app with largeHeap=true: https://developer.android.com/guide/topics/manifest/application-element#largeHeap\n- Set up LeakCanary to run in a separate process: https://square.github.io/leakcanary/recipes/#running-the-leakcanary-analysis-in-a-separate-process\n- Download the heap dump from the LeakCanary activity then run the analysis from your computer with shark-cli: https://square.github.io/leakcanary/shark/#shark-cli", failureCause)), 11, (Object) null);
                heapAnalysis = heapAnalysisSuccess2;
            }
            fullHeapAnalysis = (HeapAnalysis) copy$default;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        progressListener.onAnalysisProgress(OnAnalysisProgressListener.Step.REPORTING_HEAP_ANALYSIS);
        final HeapAnalysisSuccess heapAnalysisSuccess3 = heapAnalysis;
        EventListener.Event.HeapAnalysisDone analysisDoneEvent = (EventListener.Event.HeapAnalysisDone) ScopedLeaksDb.INSTANCE.writableDatabase(application, new Function1<SQLiteDatabase, EventListener.Event.HeapAnalysisDone<? extends HeapAnalysis>>() { // from class: leakcanary.internal.AndroidDebugHeapAnalyzer$runAnalysisBlocking$analysisDoneEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final EventListener.Event.HeapAnalysisDone<? extends HeapAnalysis> invoke(SQLiteDatabase db) {
                Application application2;
                Application application3;
                Intrinsics.checkParameterIsNotNull(db, "db");
                long id = HeapAnalysisTable.INSTANCE.insert(db, heapAnalysisSuccess3);
                HeapAnalysis heapAnalysis2 = fullHeapAnalysis;
                if (heapAnalysis2 instanceof HeapAnalysisSuccess) {
                    LeakActivity.Companion companion = LeakActivity.Companion;
                    AndroidDebugHeapAnalyzer androidDebugHeapAnalyzer = AndroidDebugHeapAnalyzer.INSTANCE;
                    application3 = AndroidDebugHeapAnalyzer.application;
                    Intent showIntent = companion.createSuccessIntent(application3, id);
                    Set leakSignatures = SequencesKt.toSet(SequencesKt.map(fullHeapAnalysis.getAllLeaks(), new Function1<Leak, String>() { // from class: leakcanary.internal.AndroidDebugHeapAnalyzer$runAnalysisBlocking$analysisDoneEvent$1$leakSignatures$1
                        @Override // kotlin.jvm.functions.Function1
                        public final String invoke(Leak it) {
                            Intrinsics.checkParameterIsNotNull(it, "it");
                            return it.getSignature();
                        }
                    }));
                    Map leakSignatureStatuses = LeakTable.INSTANCE.retrieveLeakReadStatuses(db, leakSignatures);
                    Map destination$iv$iv = new LinkedHashMap();
                    for (Map.Entry element$iv$iv : leakSignatureStatuses.entrySet()) {
                        boolean read = element$iv$iv.getValue().booleanValue();
                        if (!read) {
                            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                        }
                    }
                    Set unreadLeakSignatures = CollectionsKt.toSet(destination$iv$iv.keySet());
                    return new EventListener.Event.HeapAnalysisDone.HeapAnalysisSucceeded(heapDumped.getUniqueId(), fullHeapAnalysis, unreadLeakSignatures, showIntent);
                } else if (heapAnalysis2 instanceof HeapAnalysisFailure) {
                    LeakActivity.Companion companion2 = LeakActivity.Companion;
                    AndroidDebugHeapAnalyzer androidDebugHeapAnalyzer2 = AndroidDebugHeapAnalyzer.INSTANCE;
                    application2 = AndroidDebugHeapAnalyzer.application;
                    Intent showIntent2 = companion2.createFailureIntent(application2, id);
                    return new EventListener.Event.HeapAnalysisDone.HeapAnalysisFailed(heapDumped.getUniqueId(), fullHeapAnalysis, showIntent2);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
        LeakCanary.getConfig().getOnHeapAnalyzedListener().onHeapAnalyzed(fullHeapAnalysis);
        return analysisDoneEvent;
    }

    private final HeapAnalysis analyzeHeap(File heapDumpFile, OnAnalysisProgressListener progressListener, final Function0<Boolean> function0) {
        ProguardMappingReader proguardMappingReader;
        DualSourceProvider constantMemoryMetricsDualSourceProvider;
        HprofHeapGraph hprofHeapGraph;
        LeakCanary.Config config = LeakCanary.getConfig();
        HeapAnalyzer heapAnalyzer = new HeapAnalyzer(progressListener);
        try {
            InputStream open = application.getAssets().open(PROGUARD_MAPPING_FILE_NAME);
            Intrinsics.checkExpressionValueIsNotNull(open, "application.assets.open(…OGUARD_MAPPING_FILE_NAME)");
            proguardMappingReader = new ProguardMappingReader(open);
        } catch (IOException e) {
            proguardMappingReader = null;
        }
        ProguardMappingReader proguardMappingReader2 = proguardMappingReader;
        progressListener.onAnalysisProgress(OnAnalysisProgressListener.Step.PARSING_HEAP_DUMP);
        try {
            HprofHeapGraph hprofHeapGraph2 = (Closeable) HprofHeapGraph.Companion.openHeapGraph$default(HprofHeapGraph.Companion, new ConstantMemoryMetricsDualSourceProvider(new ThrowingCancelableFileSourceProvider(heapDumpFile, new Runnable() { // from class: leakcanary.internal.AndroidDebugHeapAnalyzer$analyzeHeap$sourceProvider$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (((Boolean) Function0.this.invoke()).booleanValue()) {
                        throw new RuntimeException("Analysis canceled");
                    }
                }
            })), proguardMappingReader2 != null ? proguardMappingReader2.readProguardMapping() : null, (Set) null, 2, (Object) null);
            try {
                HprofHeapGraph hprofHeapGraph3 = (CloseableHeapGraph) hprofHeapGraph2;
                hprofHeapGraph = hprofHeapGraph2;
                try {
                    HeapAnalysis result = heapAnalyzer.analyze(heapDumpFile, (HeapGraph) hprofHeapGraph3, config.getLeakingObjectFinder(), config.getReferenceMatchers(), config.getComputeRetainedHeapSize(), config.getObjectInspectors(), config.getMetadataExtractor());
                    if (result instanceof HeapAnalysisSuccess) {
                        if (hprofHeapGraph3 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type shark.HprofHeapGraph");
                        }
                        String lruCacheStats = hprofHeapGraph3.lruCacheStats();
                        String randomAccessStats = "RandomAccess[bytes=" + constantMemoryMetricsDualSourceProvider.getRandomAccessByteReads() + AbstractJsonLexerKt.COMMA + "reads=" + constantMemoryMetricsDualSourceProvider.getRandomAccessReadCount() + AbstractJsonLexerKt.COMMA + "travel=" + constantMemoryMetricsDualSourceProvider.getRandomAccessByteTravel() + AbstractJsonLexerKt.COMMA + "range=" + constantMemoryMetricsDualSourceProvider.getByteTravelRange() + AbstractJsonLexerKt.COMMA + "size=" + heapDumpFile.length() + "]";
                        String stats = lruCacheStats + ' ' + randomAccessStats;
                        result = HeapAnalysisSuccess.copy$default((HeapAnalysisSuccess) result, (File) null, 0L, 0L, 0L, MapsKt.plus(((HeapAnalysisSuccess) result).getMetadata(), TuplesKt.to("Stats", stats)), (List) null, (List) null, (List) null, 239, (Object) null);
                    }
                    CloseableKt.closeFinally(hprofHeapGraph, null);
                    return result;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(hprofHeapGraph, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                hprofHeapGraph = hprofHeapGraph2;
            }
        } catch (Throwable throwable) {
            return new HeapAnalysisFailure(heapDumpFile, System.currentTimeMillis(), 0L, 0L, new HeapAnalysisException(throwable), 4, (DefaultConstructorMarker) null);
        }
    }

    private final HeapAnalysisFailure missingFileFailure(File heapDumpFile) {
        String deletedReason = LeakDirectoryProvider.Companion.hprofDeleteReason(heapDumpFile);
        IllegalStateException exception = new IllegalStateException("Hprof file " + heapDumpFile + " missing, deleted because: " + deletedReason);
        return new HeapAnalysisFailure(heapDumpFile, System.currentTimeMillis(), 0L, 0L, new HeapAnalysisException(exception), 4, (DefaultConstructorMarker) null);
    }
}