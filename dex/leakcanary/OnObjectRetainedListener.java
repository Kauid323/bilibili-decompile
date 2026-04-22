package leakcanary;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnObjectRetainedListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lleakcanary/OnObjectRetainedListener;", "", "onObjectRetained", "", "Companion", "leakcanary-object-watcher"}, k = 1, mv = {1, 4, 1})
public interface OnObjectRetainedListener {
    public static final Companion Companion = Companion.$$INSTANCE;

    void onObjectRetained();

    /* compiled from: OnObjectRetainedListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\n¨\u0006\b"}, d2 = {"Lleakcanary/OnObjectRetainedListener$Companion;", "", "()V", "invoke", "Lleakcanary/OnObjectRetainedListener;", "block", "Lkotlin/Function0;", "", "leakcanary-object-watcher"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final OnObjectRetainedListener invoke(final Function0<Unit> block) {
            Intrinsics.checkParameterIsNotNull(block, "block");
            return new OnObjectRetainedListener() { // from class: leakcanary.OnObjectRetainedListener$Companion$invoke$1
                @Override // leakcanary.OnObjectRetainedListener
                public final void onObjectRetained() {
                    Function0.this.invoke();
                }
            };
        }
    }
}