package leakcanary.internal.activity.db;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ScopedLeaksDb.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class ScopedLeaksDb$open$1$1 extends MutablePropertyReference0 {
    ScopedLeaksDb$open$1$1(ScopedLeaksDb scopedLeaksDb) {
        super(scopedLeaksDb);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "leaksDbHelper";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ScopedLeaksDb.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getLeaksDbHelper()Lleakcanary/internal/activity/db/LeaksDbHelper;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return ScopedLeaksDb.access$getLeaksDbHelper$p((ScopedLeaksDb) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object value) {
        ScopedLeaksDb scopedLeaksDb = (ScopedLeaksDb) this.receiver;
        ScopedLeaksDb.leaksDbHelper = (LeaksDbHelper) value;
    }
}