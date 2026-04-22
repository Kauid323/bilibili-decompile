package leakcanary.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import leakcanary.internal.HeapDumpControl;

/* compiled from: HeapDumpControl.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class HeapDumpControl$iCanHasHeap$1$1 extends MutablePropertyReference0 {
    HeapDumpControl$iCanHasHeap$1$1(HeapDumpControl heapDumpControl) {
        super(heapDumpControl);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "latest";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(HeapDumpControl.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getLatest()Lleakcanary/internal/HeapDumpControl$ICanHazHeap;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return HeapDumpControl.access$getLatest$p((HeapDumpControl) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object value) {
        HeapDumpControl heapDumpControl = (HeapDumpControl) this.receiver;
        HeapDumpControl.latest = (HeapDumpControl.ICanHazHeap) value;
    }
}