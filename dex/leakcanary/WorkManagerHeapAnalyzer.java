package leakcanary;

import android.app.Application;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;
import leakcanary.internal.HeapAnalyzerWorker;
import leakcanary.internal.InternalLeakCanary;
import shark.SharkLog;

/* compiled from: WorkManagerHeapAnalyzer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0011\u0010\u0010\u001a\u00020\u0011*\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u001b\u0010\u0003\u001a\u00020\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0013"}, d2 = {"Lleakcanary/WorkManagerHeapAnalyzer;", "Lleakcanary/EventListener;", "()V", "validWorkManagerInClasspath", "", "getValidWorkManagerInClasspath$leakcanary_android_core_release", "()Z", "validWorkManagerInClasspath$delegate", "Lkotlin/Lazy;", "workManagerSupportsExpeditedRequests", "getWorkManagerSupportsExpeditedRequests", "workManagerSupportsExpeditedRequests$delegate", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "addExpeditedFlag", "Landroidx/work/OneTimeWorkRequest$Builder;", "addExpeditedFlag$leakcanary_android_core_release", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class WorkManagerHeapAnalyzer implements EventListener {
    public static final WorkManagerHeapAnalyzer INSTANCE = new WorkManagerHeapAnalyzer();
    private static final Lazy validWorkManagerInClasspath$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: leakcanary.WorkManagerHeapAnalyzer$validWorkManagerInClasspath$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            boolean z;
            try {
                Class.forName("androidx.work.WorkManager");
                Class dataBuilderClass = Class.forName("androidx.work.Data$Builder");
                Intrinsics.checkExpressionValueIsNotNull(dataBuilderClass, "dataBuilderClass");
                Method[] declaredMethods = dataBuilderClass.getDeclaredMethods();
                Intrinsics.checkExpressionValueIsNotNull(declaredMethods, "dataBuilderClass.declaredMethods");
                int length = declaredMethods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    Method it = declaredMethods[i];
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    if (Intrinsics.areEqual(it.getName(), "putByteArray")) {
                        z = true;
                        break;
                    }
                    i++;
                }
                boolean $this$apply = z;
                if (!$this$apply) {
                    SharkLog this_$iv = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv = this_$iv.getLogger();
                    if (logger$iv != null) {
                        logger$iv.d("Could not find androidx.work.Data$Builder.putByteArray, WorkManager should be at least 2.1.0.");
                    }
                }
                return z;
            } catch (Throwable th) {
                return false;
            }
        }
    });
    private static final Lazy workManagerSupportsExpeditedRequests$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: leakcanary.WorkManagerHeapAnalyzer$workManagerSupportsExpeditedRequests$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            try {
                Class.forName("androidx.work.OutOfQuotaPolicy");
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
    });

    private final boolean getWorkManagerSupportsExpeditedRequests() {
        return ((Boolean) workManagerSupportsExpeditedRequests$delegate.getValue()).booleanValue();
    }

    public final boolean getValidWorkManagerInClasspath$leakcanary_android_core_release() {
        return ((Boolean) validWorkManagerInClasspath$delegate.getValue()).booleanValue();
    }

    private WorkManagerHeapAnalyzer() {
    }

    public final OneTimeWorkRequest.Builder addExpeditedFlag$leakcanary_android_core_release(OneTimeWorkRequest.Builder addExpeditedFlag) {
        Intrinsics.checkParameterIsNotNull(addExpeditedFlag, "$this$addExpeditedFlag");
        if (INSTANCE.getWorkManagerSupportsExpeditedRequests()) {
            addExpeditedFlag.setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST);
        }
        return addExpeditedFlag;
    }

    @Override // leakcanary.EventListener
    public void onEvent(EventListener.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event instanceof EventListener.Event.HeapDump) {
            OneTimeWorkRequest.Builder $this$apply = new OneTimeWorkRequest.Builder(HeapAnalyzerWorker.class);
            $this$apply.setInputData(HeapAnalyzerWorker.Companion.asWorkerInputData$default(HeapAnalyzerWorker.Companion, event, null, 1, null));
            INSTANCE.addExpeditedFlag$leakcanary_android_core_release($this$apply);
            WorkRequest build = $this$apply.build();
            Intrinsics.checkExpressionValueIsNotNull(build, "OneTimeWorkRequest.Build…tedFlag()\n      }.build()");
            WorkRequest workRequest = (OneTimeWorkRequest) build;
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d("Enqueuing heap analysis for " + ((EventListener.Event.HeapDump) event).getFile() + " on WorkManager remote worker");
            }
            Application application = InternalLeakCanary.INSTANCE.getApplication();
            WorkManager.getInstance(application).enqueue(workRequest);
        }
    }
}