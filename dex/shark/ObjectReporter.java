package shark;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import shark.HeapObject;

/* compiled from: ObjectReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u001d\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\u0002\b\u001dJ5\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001f2\u001d\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006 "}, d2 = {"Lshark/ObjectReporter;", "", "heapObject", "Lshark/HeapObject;", "(Lshark/HeapObject;)V", "getHeapObject", "()Lshark/HeapObject;", "labels", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "getLabels", "()Ljava/util/LinkedHashSet;", "leakingReasons", "", "getLeakingReasons", "()Ljava/util/Set;", "likelyLeakingReasons", "getLikelyLeakingReasons$annotations", "()V", "getLikelyLeakingReasons", "notLeakingReasons", "getNotLeakingReasons", "whenInstanceOf", "", "expectedClassName", "block", "Lkotlin/Function2;", "Lshark/HeapObject$HeapInstance;", "Lkotlin/ExtensionFunctionType;", "expectedClass", "Lkotlin/reflect/KClass;", "shark"}, k = 1, mv = {1, 4, 1})
public final class ObjectReporter {
    private final HeapObject heapObject;
    private final LinkedHashSet<String> labels;
    private final Set<String> leakingReasons;
    private final Set<String> notLeakingReasons;

    @Deprecated(message = "Replace likelyLeakingReasons with leakingReasons", replaceWith = @ReplaceWith(expression = "leakingReasons", imports = {}))
    public static /* synthetic */ void getLikelyLeakingReasons$annotations() {
    }

    public ObjectReporter(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
        this.heapObject = heapObject;
        this.labels = new LinkedHashSet<>();
        this.leakingReasons = new LinkedHashSet();
        this.notLeakingReasons = new LinkedHashSet();
    }

    public final HeapObject getHeapObject() {
        return this.heapObject;
    }

    public final LinkedHashSet<String> getLabels() {
        return this.labels;
    }

    public final Set<String> getLeakingReasons() {
        return this.leakingReasons;
    }

    public final Set<String> getLikelyLeakingReasons() {
        return this.leakingReasons;
    }

    public final Set<String> getNotLeakingReasons() {
        return this.notLeakingReasons;
    }

    public final void whenInstanceOf(KClass<? extends Object> kClass, Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(kClass, "expectedClass");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        String name = JvmClassMappingKt.getJavaClass(kClass).getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "expectedClass.java.name");
        whenInstanceOf(name, function2);
    }

    public final void whenInstanceOf(String expectedClassName, Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(expectedClassName, "expectedClassName");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        HeapObject heapObject = this.heapObject;
        if ((heapObject instanceof HeapObject.HeapInstance) && ((HeapObject.HeapInstance) heapObject).instanceOf(expectedClassName)) {
            function2.invoke(this, heapObject);
        }
    }
}