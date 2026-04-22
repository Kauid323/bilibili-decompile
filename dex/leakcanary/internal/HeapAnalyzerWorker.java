package leakcanary.internal;

import android.app.Notification;
import android.content.Context;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.squareup.leakcanary.core.R;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;
import shark.SharkLog;

/* compiled from: HeapAnalyzerWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\r"}, d2 = {"Lleakcanary/internal/HeapAnalyzerWorker;", "Landroidx/work/Worker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "getForegroundInfoAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ForegroundInfo;", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HeapAnalyzerWorker extends Worker {
    public static final Companion Companion = new Companion(null);
    private static final String EVENT_BYTES = "EVENT_BYTES";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeapAnalyzerWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkParameterIsNotNull(appContext, "appContext");
        Intrinsics.checkParameterIsNotNull(workerParams, "workerParams");
    }

    public ListenableWorker.Result doWork() {
        AndroidDebugHeapAnalyzer androidDebugHeapAnalyzer = AndroidDebugHeapAnalyzer.INSTANCE;
        Companion companion = Companion;
        Data inputData = getInputData();
        Intrinsics.checkExpressionValueIsNotNull(inputData, "inputData");
        Serializables serializables = Serializables.INSTANCE;
        byte[] byteArray$iv$iv = inputData.getByteArray(EVENT_BYTES);
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
        EventListener.Event.HeapAnalysisDone doneEvent = AndroidDebugHeapAnalyzer.runAnalysisBlocking$default(androidDebugHeapAnalyzer, heapDump, null, new Function1<EventListener.Event.HeapAnalysisProgress, Unit>() { // from class: leakcanary.internal.HeapAnalyzerWorker$doWork$doneEvent$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EventListener.Event.HeapAnalysisProgress heapAnalysisProgress) {
                invoke2(heapAnalysisProgress);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventListener.Event.HeapAnalysisProgress event) {
                Intrinsics.checkParameterIsNotNull(event, "event");
                InternalLeakCanary.INSTANCE.sendEvent(event);
            }
        }, 2, null);
        InternalLeakCanary.INSTANCE.sendEvent(doneEvent);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        Intrinsics.checkExpressionValueIsNotNull(success, "Result.success()");
        return success;
    }

    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        Companion companion = Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        return companion.heapAnalysisForegroundInfoAsync(applicationContext);
    }

    /* compiled from: HeapAnalyzerWorker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lleakcanary/internal/HeapAnalyzerWorker$Companion;", "", "()V", HeapAnalyzerWorker.EVENT_BYTES, "", "asEvent", "T", "Landroidx/work/Data;", "(Landroidx/work/Data;)Ljava/lang/Object;", "asWorkerInputData", "Lleakcanary/EventListener$Event;", "dataBuilder", "Landroidx/work/Data$Builder;", "heapAnalysisForegroundInfoAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ForegroundInfo;", "Landroid/content/Context;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static /* synthetic */ Data asWorkerInputData$default(Companion companion, EventListener.Event event, Data.Builder builder, int i, Object obj) {
            if ((i & 1) != 0) {
                builder = new Data.Builder();
            }
            return companion.asWorkerInputData(event, builder);
        }

        public final Data asWorkerInputData(EventListener.Event asWorkerInputData, Data.Builder dataBuilder) {
            Intrinsics.checkParameterIsNotNull(asWorkerInputData, "$this$asWorkerInputData");
            Intrinsics.checkParameterIsNotNull(dataBuilder, "dataBuilder");
            Data build = dataBuilder.putByteArray(HeapAnalyzerWorker.EVENT_BYTES, SerializablesKt.toByteArray(asWorkerInputData)).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "dataBuilder\n      .putBy…teArray())\n      .build()");
            return build;
        }

        public final /* synthetic */ <T> T asEvent(Data asEvent) {
            T t;
            Intrinsics.checkParameterIsNotNull(asEvent, "$this$asEvent");
            Serializables serializables = Serializables.INSTANCE;
            byte[] byteArray$iv = asEvent.getByteArray(HeapAnalyzerWorker.EVENT_BYTES);
            if (byteArray$iv == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(byteArray$iv, "getByteArray(EVENT_BYTES)!!");
            ByteArrayInputStream inputStream$iv = new ByteArrayInputStream(byteArray$iv);
            try {
                t = (T) new ObjectInputStream(inputStream$iv).readObject();
                Intrinsics.reifiedOperationMarker(2, "T");
                T t2 = t;
            } catch (Throwable ignored$iv) {
                SharkLog this_$iv$iv = SharkLog.INSTANCE;
                SharkLog.Logger logger$iv$iv = this_$iv$iv.getLogger();
                if (logger$iv$iv != null) {
                    logger$iv$iv.d(ignored$iv, "Could not deserialize bytes, ignoring");
                }
                t = null;
            }
            if (t == null) {
                Intrinsics.throwNpe();
            }
            return t;
        }

        public final ListenableFuture<ForegroundInfo> heapAnalysisForegroundInfoAsync(Context heapAnalysisForegroundInfoAsync) {
            Intrinsics.checkParameterIsNotNull(heapAnalysisForegroundInfoAsync, "$this$heapAnalysisForegroundInfoAsync");
            ListenableFuture<ForegroundInfo> infoFuture = SettableFuture.create();
            Notification.Builder builder = new Notification.Builder(heapAnalysisForegroundInfoAsync).setContentTitle(heapAnalysisForegroundInfoAsync.getString(R.string.leak_canary_notification_analysing)).setContentText("LeakCanary is working.").setProgress(100, 0, true);
            Intrinsics.checkExpressionValueIsNotNull(builder, "Notification.Builder(thi…setProgress(100, 0, true)");
            Notification notification = Notifications.INSTANCE.buildNotification(heapAnalysisForegroundInfoAsync, builder, NotificationType.LEAKCANARY_LOW);
            infoFuture.set(new ForegroundInfo(R.id.leak_canary_notification_analyzing_heap, notification));
            Intrinsics.checkExpressionValueIsNotNull(infoFuture, "infoFuture");
            return infoFuture;
        }
    }
}