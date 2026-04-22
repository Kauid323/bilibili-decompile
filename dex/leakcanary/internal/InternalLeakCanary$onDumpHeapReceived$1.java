package leakcanary.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: InternalLeakCanary.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class InternalLeakCanary$onDumpHeapReceived$1 extends MutablePropertyReference0 {
    InternalLeakCanary$onDumpHeapReceived$1(InternalLeakCanary internalLeakCanary) {
        super(internalLeakCanary);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "heapDumpTrigger";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(InternalLeakCanary.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getHeapDumpTrigger()Lleakcanary/internal/HeapDumpTrigger;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return InternalLeakCanary.access$getHeapDumpTrigger$p((InternalLeakCanary) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object value) {
        InternalLeakCanary internalLeakCanary = (InternalLeakCanary) this.receiver;
        InternalLeakCanary.heapDumpTrigger = (HeapDumpTrigger) value;
    }
}