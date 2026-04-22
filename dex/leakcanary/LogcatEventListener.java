package leakcanary;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;
import leakcanary.internal.activity.screen.LeakTraceWrapper;
import org.webrtc.H265Utils;
import shark.SharkLog;

/* compiled from: LogcatEventListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lleakcanary/LogcatEventListener;", "Lleakcanary/EventListener;", "()V", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LogcatEventListener implements EventListener {
    public static final LogcatEventListener INSTANCE = new LogcatEventListener();

    private LogcatEventListener() {
    }

    @Override // leakcanary.EventListener
    public void onEvent(EventListener.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event instanceof EventListener.Event.HeapDumpFailed) {
            if (((EventListener.Event.HeapDumpFailed) event).getWillRetryLater()) {
                SharkLog this_$iv = SharkLog.INSTANCE;
                Throwable throwable$iv = ((EventListener.Event.HeapDumpFailed) event).getException();
                SharkLog.Logger logger$iv = this_$iv.getLogger();
                if (logger$iv != null) {
                    logger$iv.d(throwable$iv, "Failed to dump heap, will retry in 5000 ms");
                    return;
                }
                return;
            }
            SharkLog this_$iv2 = SharkLog.INSTANCE;
            Throwable throwable$iv2 = ((EventListener.Event.HeapDumpFailed) event).getException();
            SharkLog.Logger logger$iv2 = this_$iv2.getLogger();
            if (logger$iv2 != null) {
                logger$iv2.d(throwable$iv2, "Failed to dump heap, will not automatically retry");
            }
        } else if (event instanceof EventListener.Event.HeapAnalysisProgress) {
            int percent = (int) (((EventListener.Event.HeapAnalysisProgress) event).getProgressPercent() * 100);
            SharkLog this_$iv3 = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv3 = this_$iv3.getLogger();
            if (logger$iv3 != null) {
                logger$iv3.d("Analysis in progress, " + percent + "% done, working on " + ((EventListener.Event.HeapAnalysisProgress) event).getStep().getHumanReadableName());
            }
        } else if (event instanceof EventListener.Event.HeapAnalysisDone) {
            SharkLog this_$iv4 = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv4 = this_$iv4.getLogger();
            if (logger$iv4 != null) {
                logger$iv4.d("\u200b\n" + LeakTraceWrapper.INSTANCE.wrap(((EventListener.Event.HeapAnalysisDone) event).getHeapAnalysis().toString(), H265Utils.kLevel4));
            }
        }
    }
}