package curtains.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.FrameMetrics;
import android.view.Window;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CurrentFrameMetricsListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcurtains/internal/CurrentFrameMetricsListener;", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "frameTimeNanos", "", "callback", "Lkotlin/Function1;", "Landroid/view/FrameMetrics;", "", "(JLkotlin/jvm/functions/Function1;)V", "removed", "", "onFrameMetricsAvailable", "window", "Landroid/view/Window;", "frameMetrics", "dropCountSinceLastInvocation", "", "Companion", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class CurrentFrameMetricsListener implements Window.OnFrameMetricsAvailableListener {
    public static final Companion Companion = new Companion(null);
    private static final Lazy mainThreadHandler$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Handler>() { // from class: curtains.internal.CurrentFrameMetricsListener$Companion$mainThreadHandler$2
        /* renamed from: invoke */
        public final Handler m782invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private final Function1<FrameMetrics, Unit> callback;
    private final long frameTimeNanos;
    private boolean removed;

    /* JADX WARN: Multi-variable type inference failed */
    public CurrentFrameMetricsListener(long frameTimeNanos, Function1<? super FrameMetrics, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.frameTimeNanos = frameTimeNanos;
        this.callback = function1;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(final Window window, FrameMetrics frameMetrics, int dropCountSinceLastInvocation) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        if (!this.removed) {
            this.removed = true;
            Companion.getMainThreadHandler().post(new Runnable() { // from class: curtains.internal.CurrentFrameMetricsListener$onFrameMetricsAvailable$1
                @Override // java.lang.Runnable
                public final void run() {
                    window.removeOnFrameMetricsAvailableListener(CurrentFrameMetricsListener.this);
                }
            });
        }
        long vsyncTimestamp = frameMetrics.getMetric(11);
        if (vsyncTimestamp == this.frameTimeNanos) {
            this.callback.invoke(frameMetrics);
        }
    }

    /* compiled from: CurrentFrameMetricsListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcurtains/internal/CurrentFrameMetricsListener$Companion;", "", "()V", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler", "()Landroid/os/Handler;", "mainThreadHandler$delegate", "Lkotlin/Lazy;", "curtains_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        /* JADX INFO: Access modifiers changed from: private */
        public final Handler getMainThreadHandler() {
            Lazy lazy = CurrentFrameMetricsListener.mainThreadHandler$delegate;
            Companion companion = CurrentFrameMetricsListener.Companion;
            return (Handler) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}