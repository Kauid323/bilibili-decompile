package leakcanary.internal;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.RemoteListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.BackgroundThreadHeapAnalyzer;
import leakcanary.EventListener;
import leakcanary.internal.HeapAnalyzerWorker;
import shark.SharkLog;

/* compiled from: RemoteHeapAnalyzerWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0016¨\u0006\f"}, d2 = {"Lleakcanary/internal/RemoteHeapAnalyzerWorker;", "Landroidx/work/multiprocess/RemoteListenableWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "getForegroundInfoAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ForegroundInfo;", "startRemoteWork", "Landroidx/work/ListenableWorker$Result;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class RemoteHeapAnalyzerWorker extends RemoteListenableWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteHeapAnalyzerWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkParameterIsNotNull(appContext, "appContext");
        Intrinsics.checkParameterIsNotNull(workerParams, "workerParams");
    }

    public ListenableFuture<ListenableWorker.Result> startRemoteWork() {
        HeapAnalyzerWorker.Companion companion = HeapAnalyzerWorker.Companion;
        Data inputData = getInputData();
        Intrinsics.checkExpressionValueIsNotNull(inputData, "inputData");
        Serializables serializables = Serializables.INSTANCE;
        byte[] byteArray$iv$iv = inputData.getByteArray("EVENT_BYTES");
        if (byteArray$iv$iv == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(byteArray$iv$iv, "getByteArray(EVENT_BYTES)!!");
        ByteArrayInputStream inputStream$iv$iv = new ByteArrayInputStream(byteArray$iv$iv);
        EventListener.Event.HeapDump heapDump = null;
        try {
            Object readObject = new ObjectInputStream(inputStream$iv$iv).readObject();
            if (!(readObject instanceof EventListener.Event.HeapDump)) {
                readObject = null;
            }
            heapDump = (EventListener.Event.HeapDump) readObject;
        } catch (Throwable ignored$iv$iv) {
            SharkLog this_$iv$iv$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv$iv$iv = this_$iv$iv$iv.getLogger();
            if (logger$iv$iv$iv != null) {
                logger$iv$iv$iv.d(ignored$iv$iv, "Could not deserialize bytes, ignoring");
            }
        }
        if (heapDump == null) {
            Intrinsics.throwNpe();
        }
        EventListener.Event.HeapDump heapDump2 = heapDump;
        ListenableFuture<ListenableWorker.Result> result = SettableFuture.create();
        BackgroundThreadHeapAnalyzer.INSTANCE.getHeapAnalyzerThreadHandler$leakcanary_android_core_release().post(new RemoteHeapAnalyzerWorker$startRemoteWork$1(heapDump2, result));
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        HeapAnalyzerWorker.Companion companion = HeapAnalyzerWorker.Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        return companion.heapAnalysisForegroundInfoAsync(applicationContext);
    }
}