package leakcanary;

import android.app.Application;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;
import leakcanary.internal.HeapAnalyzerWorker;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.RemoteHeapAnalyzerWorker;
import shark.SharkLog;

/* compiled from: RemoteWorkManagerHeapAnalyzer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lleakcanary/RemoteWorkManagerHeapAnalyzer;", "Lleakcanary/EventListener;", "()V", "REMOTE_SERVICE_CLASS_NAME", "", "remoteLeakCanaryServiceInClasspath", "", "getRemoteLeakCanaryServiceInClasspath$leakcanary_android_core_release", "()Z", "remoteLeakCanaryServiceInClasspath$delegate", "Lkotlin/Lazy;", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class RemoteWorkManagerHeapAnalyzer implements EventListener {
    private static final String REMOTE_SERVICE_CLASS_NAME = "leakcanary.internal.RemoteLeakCanaryWorkerService";
    public static final RemoteWorkManagerHeapAnalyzer INSTANCE = new RemoteWorkManagerHeapAnalyzer();
    private static final Lazy remoteLeakCanaryServiceInClasspath$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: leakcanary.RemoteWorkManagerHeapAnalyzer$remoteLeakCanaryServiceInClasspath$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            try {
                Class.forName("leakcanary.internal.RemoteLeakCanaryWorkerService");
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
    });

    public final boolean getRemoteLeakCanaryServiceInClasspath$leakcanary_android_core_release() {
        return ((Boolean) remoteLeakCanaryServiceInClasspath$delegate.getValue()).booleanValue();
    }

    private RemoteWorkManagerHeapAnalyzer() {
    }

    @Override // leakcanary.EventListener
    public void onEvent(EventListener.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event instanceof EventListener.Event.HeapDump) {
            Application application = InternalLeakCanary.INSTANCE.getApplication();
            OneTimeWorkRequest.Builder $this$apply = new OneTimeWorkRequest.Builder(RemoteHeapAnalyzerWorker.class);
            Data.Builder dataBuilder = new Data.Builder().putString("androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME", application.getPackageName()).putString("androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME", REMOTE_SERVICE_CLASS_NAME);
            Intrinsics.checkExpressionValueIsNotNull(dataBuilder, "Data.Builder()\n         …EMOTE_SERVICE_CLASS_NAME)");
            $this$apply.setInputData(HeapAnalyzerWorker.Companion.asWorkerInputData(event, dataBuilder));
            WorkManagerHeapAnalyzer $this$with = WorkManagerHeapAnalyzer.INSTANCE;
            $this$with.addExpeditedFlag$leakcanary_android_core_release($this$apply);
            WorkRequest build = $this$apply.build();
            Intrinsics.checkExpressionValueIsNotNull(build, "OneTimeWorkRequest.Build…      }\n        }.build()");
            WorkRequest workRequest = (OneTimeWorkRequest) build;
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d("Enqueuing heap analysis for " + ((EventListener.Event.HeapDump) event).getFile() + " on WorkManager remote worker");
            }
            WorkManager workManager = WorkManager.getInstance(application);
            Intrinsics.checkExpressionValueIsNotNull(workManager, "WorkManager.getInstance(application)");
            workManager.enqueue(workRequest);
        }
    }
}