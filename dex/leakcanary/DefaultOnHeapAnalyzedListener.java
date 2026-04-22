package leakcanary;

import android.app.Application;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapAnalysis;

/* compiled from: DefaultOnHeapAnalyzedListener.kt */
@Deprecated(message = "Add to LeakCanary.config.eventListeners instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lleakcanary/DefaultOnHeapAnalyzedListener;", "Lleakcanary/OnHeapAnalyzedListener;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "()V", "onHeapAnalyzed", "", "heapAnalysis", "Lshark/HeapAnalysis;", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class DefaultOnHeapAnalyzedListener implements OnHeapAnalyzedListener {
    public static final Companion Companion = new Companion(null);

    private DefaultOnHeapAnalyzedListener() {
    }

    public /* synthetic */ DefaultOnHeapAnalyzedListener(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Add to LeakCanary.config.eventListeners instead")
    public DefaultOnHeapAnalyzedListener(Application application) {
        this();
        Intrinsics.checkParameterIsNotNull(application, "application");
    }

    @Override // leakcanary.OnHeapAnalyzedListener
    public void onHeapAnalyzed(HeapAnalysis heapAnalysis) {
        Intrinsics.checkParameterIsNotNull(heapAnalysis, "heapAnalysis");
    }

    /* compiled from: DefaultOnHeapAnalyzedListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lleakcanary/DefaultOnHeapAnalyzedListener$Companion;", "", "()V", "create", "Lleakcanary/OnHeapAnalyzedListener;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final OnHeapAnalyzedListener create() {
            return new DefaultOnHeapAnalyzedListener((DefaultConstructorMarker) null);
        }
    }
}