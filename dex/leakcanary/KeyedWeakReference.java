package leakcanary;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyedWeakReference.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, d2 = {"Lleakcanary/KeyedWeakReference;", "Ljava/lang/ref/WeakReference;", "", "referent", "key", "", "description", "watchUptimeMillis", "", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;JLjava/lang/ref/ReferenceQueue;)V", "getDescription", "()Ljava/lang/String;", "getKey", "retainedUptimeMillis", "getRetainedUptimeMillis", "()J", "setRetainedUptimeMillis", "(J)V", "getWatchUptimeMillis", "clear", "", "Companion", "leakcanary-object-watcher"}, k = 1, mv = {1, 4, 1})
public final class KeyedWeakReference extends WeakReference<Object> {
    public static final Companion Companion = new Companion(null);
    private static volatile long heapDumpUptimeMillis;
    private final String description;
    private final String key;
    private volatile long retainedUptimeMillis;
    private final long watchUptimeMillis;

    public static final long getHeapDumpUptimeMillis() {
        return heapDumpUptimeMillis;
    }

    public static final void setHeapDumpUptimeMillis(long j) {
        heapDumpUptimeMillis = j;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyedWeakReference(Object referent, String key, String description, long watchUptimeMillis, ReferenceQueue<Object> referenceQueue) {
        super(referent, referenceQueue);
        Intrinsics.checkParameterIsNotNull(referent, "referent");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(description, "description");
        Intrinsics.checkParameterIsNotNull(referenceQueue, "referenceQueue");
        this.key = key;
        this.description = description;
        this.watchUptimeMillis = watchUptimeMillis;
        this.retainedUptimeMillis = -1L;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getWatchUptimeMillis() {
        return this.watchUptimeMillis;
    }

    public final long getRetainedUptimeMillis() {
        return this.retainedUptimeMillis;
    }

    public final void setRetainedUptimeMillis(long j) {
        this.retainedUptimeMillis = j;
    }

    @Override // java.lang.ref.Reference
    public void clear() {
        super.clear();
        this.retainedUptimeMillis = -1L;
    }

    /* compiled from: KeyedWeakReference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lleakcanary/KeyedWeakReference$Companion;", "", "()V", "heapDumpUptimeMillis", "", "getHeapDumpUptimeMillis$annotations", "getHeapDumpUptimeMillis", "()J", "setHeapDumpUptimeMillis", "(J)V", "leakcanary-object-watcher"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void getHeapDumpUptimeMillis$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final long getHeapDumpUptimeMillis() {
            return KeyedWeakReference.heapDumpUptimeMillis;
        }

        public final void setHeapDumpUptimeMillis(long j) {
            KeyedWeakReference.heapDumpUptimeMillis = j;
        }
    }
}