package curtains.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Handlers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\u0007\u0010\u0003¨\u0006\t"}, d2 = {"frameMetricsHandler", "Landroid/os/Handler;", "getFrameMetricsHandler", "()Landroid/os/Handler;", "frameMetricsHandler$delegate", "Lkotlin/Lazy;", "mainHandler", "getMainHandler", "mainHandler$delegate", "curtains_release"}, k = 2, mv = {1, 4, 1})
public final class HandlersKt {
    private static final Lazy mainHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: curtains.internal.HandlersKt$mainHandler$2
        /* renamed from: invoke */
        public final Handler m784invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private static final Lazy frameMetricsHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: curtains.internal.HandlersKt$frameMetricsHandler$2
        /* renamed from: invoke */
        public final Handler m783invoke() {
            HandlerThread thread = new HandlerThread("frame_metrics");
            thread.start();
            return new Handler(thread.getLooper());
        }
    });

    public static final Handler getFrameMetricsHandler() {
        return (Handler) frameMetricsHandler$delegate.getValue();
    }

    public static final Handler getMainHandler() {
        return (Handler) mainHandler$delegate.getValue();
    }
}