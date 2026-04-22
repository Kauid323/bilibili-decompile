package curtains;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DispatchState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcurtains/DispatchState;", "", "()V", "Companion", "Consumed", "NotConsumed", "Lcurtains/DispatchState$Consumed;", "Lcurtains/DispatchState$NotConsumed;", "curtains_release"}, k = 1, mv = {1, 4, 1})
public abstract class DispatchState {
    public static final Companion Companion = new Companion(null);
    private static final NotConsumed NotConsumedInternalOnly = new NotConsumed();

    private DispatchState() {
    }

    public /* synthetic */ DispatchState(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* compiled from: DispatchState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcurtains/DispatchState$Consumed;", "Lcurtains/DispatchState;", "()V", "curtains_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Consumed extends DispatchState {
        public static final Consumed INSTANCE = new Consumed();

        private Consumed() {
            super(null);
        }
    }

    /* compiled from: DispatchState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcurtains/DispatchState$NotConsumed;", "Lcurtains/DispatchState;", "()V", "curtains_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class NotConsumed extends DispatchState {
        public NotConsumed() {
            super(null);
        }
    }

    /* compiled from: DispatchState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcurtains/DispatchState$Companion;", "", "()V", "NotConsumedInternalOnly", "Lcurtains/DispatchState$NotConsumed;", "from", "Lcurtains/DispatchState;", "consumed", "", "from$curtains_release", "curtains_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final DispatchState from$curtains_release(boolean consumed) {
            return consumed ? Consumed.INSTANCE : DispatchState.NotConsumedInternalOnly;
        }
    }
}