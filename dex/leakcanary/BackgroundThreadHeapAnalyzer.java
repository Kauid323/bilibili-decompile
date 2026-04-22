package leakcanary;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;
import leakcanary.internal.AndroidDebugHeapAnalyzer;
import leakcanary.internal.InternalLeakCanary;

/* compiled from: BackgroundThreadHeapAnalyzer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lleakcanary/BackgroundThreadHeapAnalyzer;", "Lleakcanary/EventListener;", "()V", "heapAnalyzerThreadHandler", "Landroid/os/Handler;", "getHeapAnalyzerThreadHandler$leakcanary_android_core_release", "()Landroid/os/Handler;", "heapAnalyzerThreadHandler$delegate", "Lkotlin/Lazy;", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class BackgroundThreadHeapAnalyzer implements EventListener {
    public static final BackgroundThreadHeapAnalyzer INSTANCE = new BackgroundThreadHeapAnalyzer();
    private static final Lazy heapAnalyzerThreadHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: leakcanary.BackgroundThreadHeapAnalyzer$heapAnalyzerThreadHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            HandlerThread handlerThread = new HandlerThread("HeapAnalyzer");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });

    public final Handler getHeapAnalyzerThreadHandler$leakcanary_android_core_release() {
        return (Handler) heapAnalyzerThreadHandler$delegate.getValue();
    }

    private BackgroundThreadHeapAnalyzer() {
    }

    @Override // leakcanary.EventListener
    public void onEvent(final EventListener.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event instanceof EventListener.Event.HeapDump) {
            getHeapAnalyzerThreadHandler$leakcanary_android_core_release().post(new Runnable() { // from class: leakcanary.BackgroundThreadHeapAnalyzer$onEvent$1
                @Override // java.lang.Runnable
                public final void run() {
                    EventListener.Event.HeapAnalysisDone doneEvent = AndroidDebugHeapAnalyzer.runAnalysisBlocking$default(AndroidDebugHeapAnalyzer.INSTANCE, (EventListener.Event.HeapDump) EventListener.Event.this, null, new Function1<EventListener.Event.HeapAnalysisProgress, Unit>() { // from class: leakcanary.BackgroundThreadHeapAnalyzer$onEvent$1$doneEvent$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(EventListener.Event.HeapAnalysisProgress heapAnalysisProgress) {
                            invoke2(heapAnalysisProgress);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(EventListener.Event.HeapAnalysisProgress event2) {
                            Intrinsics.checkParameterIsNotNull(event2, "event");
                            InternalLeakCanary.INSTANCE.sendEvent(event2);
                        }
                    }, 2, null);
                    InternalLeakCanary.INSTANCE.sendEvent(doneEvent);
                }
            });
        }
    }
}