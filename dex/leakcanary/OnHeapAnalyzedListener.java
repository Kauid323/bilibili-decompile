package leakcanary;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapAnalysis;

/* compiled from: OnHeapAnalyzedListener.kt */
@Deprecated(message = "Add to LeakCanary.config.eventListeners instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lleakcanary/OnHeapAnalyzedListener;", "", "onHeapAnalyzed", "", "heapAnalysis", "Lshark/HeapAnalysis;", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public interface OnHeapAnalyzedListener {
    public static final Companion Companion = Companion.$$INSTANCE;

    void onHeapAnalyzed(HeapAnalysis heapAnalysis);

    /* compiled from: OnHeapAnalyzedListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\n¨\u0006\t"}, d2 = {"Lleakcanary/OnHeapAnalyzedListener$Companion;", "", "()V", "invoke", "Lleakcanary/OnHeapAnalyzedListener;", "block", "Lkotlin/Function1;", "Lshark/HeapAnalysis;", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final OnHeapAnalyzedListener invoke(final Function1<? super HeapAnalysis, Unit> block) {
            Intrinsics.checkParameterIsNotNull(block, "block");
            return new OnHeapAnalyzedListener() { // from class: leakcanary.OnHeapAnalyzedListener$Companion$invoke$1
                @Override // leakcanary.OnHeapAnalyzedListener
                public final void onHeapAnalyzed(HeapAnalysis heapAnalysis) {
                    Intrinsics.checkParameterIsNotNull(heapAnalysis, "heapAnalysis");
                    Function1.this.invoke(heapAnalysis);
                }
            };
        }
    }
}