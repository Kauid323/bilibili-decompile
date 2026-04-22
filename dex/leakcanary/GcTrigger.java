package leakcanary;

import kotlin.Metadata;

/* compiled from: GcTrigger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lleakcanary/GcTrigger;", "", "runGc", "", "Default", "leakcanary-object-watcher"}, k = 1, mv = {1, 4, 1})
public interface GcTrigger {
    void runGc();

    /* compiled from: GcTrigger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lleakcanary/GcTrigger$Default;", "Lleakcanary/GcTrigger;", "()V", "enqueueReferences", "", "runGc", "leakcanary-object-watcher"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Default implements GcTrigger {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override // leakcanary.GcTrigger
        public void runGc() {
            Runtime.getRuntime().gc();
            enqueueReferences();
            System.runFinalization();
        }

        private final void enqueueReferences() {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                throw new AssertionError();
            }
        }
    }
}