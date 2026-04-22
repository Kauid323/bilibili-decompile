package leakcanary.internal;

import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;
import shark.SharkLog;

/* compiled from: RemoteHeapAnalyzerWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
final class RemoteHeapAnalyzerWorker$startRemoteWork$1 implements Runnable {
    final /* synthetic */ EventListener.Event.HeapDump $heapDump;
    final /* synthetic */ SettableFuture $result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteHeapAnalyzerWorker$startRemoteWork$1(EventListener.Event.HeapDump heapDump, SettableFuture settableFuture) {
        this.$heapDump = heapDump;
        this.$result = settableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EventListener.Event.HeapAnalysisDone doneEvent = AndroidDebugHeapAnalyzer.INSTANCE.runAnalysisBlocking(this.$heapDump, new Function0<Boolean>() { // from class: leakcanary.internal.RemoteHeapAnalyzerWorker$startRemoteWork$1$doneEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                SettableFuture result = RemoteHeapAnalyzerWorker$startRemoteWork$1.this.$result;
                Intrinsics.checkExpressionValueIsNotNull(result, "result");
                return result.isCancelled();
            }
        }, new Function1<EventListener.Event.HeapAnalysisProgress, Unit>() { // from class: leakcanary.internal.RemoteHeapAnalyzerWorker$startRemoteWork$1$doneEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EventListener.Event.HeapAnalysisProgress heapAnalysisProgress) {
                invoke2(heapAnalysisProgress);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventListener.Event.HeapAnalysisProgress progressEvent) {
                Intrinsics.checkParameterIsNotNull(progressEvent, "progressEvent");
                SettableFuture result = RemoteHeapAnalyzerWorker$startRemoteWork$1.this.$result;
                Intrinsics.checkExpressionValueIsNotNull(result, "result");
                if (!result.isCancelled()) {
                    InternalLeakCanary.INSTANCE.sendEvent(progressEvent);
                }
            }
        });
        SettableFuture result = this.$result;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        if (result.isCancelled()) {
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d("Remote heap analysis for " + this.$heapDump.getFile() + " was canceled");
                return;
            }
            return;
        }
        InternalLeakCanary.INSTANCE.sendEvent(doneEvent);
        this.$result.set(ListenableWorker.Result.success());
    }
}