package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapObject;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: HeapField.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lshark/HeapField;", "", "declaringClass", "Lshark/HeapObject$HeapClass;", ChannelRoutes.CHANNEL_NAME, "", "value", "Lshark/HeapValue;", "(Lshark/HeapObject$HeapClass;Ljava/lang/String;Lshark/HeapValue;)V", "getDeclaringClass", "()Lshark/HeapObject$HeapClass;", "getName", "()Ljava/lang/String;", "getValue", "()Lshark/HeapValue;", "valueAsClass", "getValueAsClass", "valueAsInstance", "Lshark/HeapObject$HeapInstance;", "getValueAsInstance", "()Lshark/HeapObject$HeapInstance;", "valueAsObjectArray", "Lshark/HeapObject$HeapObjectArray;", "getValueAsObjectArray", "()Lshark/HeapObject$HeapObjectArray;", "valueAsPrimitiveArray", "Lshark/HeapObject$HeapPrimitiveArray;", "getValueAsPrimitiveArray", "()Lshark/HeapObject$HeapPrimitiveArray;", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class HeapField {
    private final HeapObject.HeapClass declaringClass;
    private final String name;
    private final HeapValue value;

    public HeapField(HeapObject.HeapClass declaringClass, String name, HeapValue value) {
        Intrinsics.checkParameterIsNotNull(declaringClass, "declaringClass");
        Intrinsics.checkParameterIsNotNull(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.declaringClass = declaringClass;
        this.name = name;
        this.value = value;
    }

    public final HeapObject.HeapClass getDeclaringClass() {
        return this.declaringClass;
    }

    public final String getName() {
        return this.name;
    }

    public final HeapValue getValue() {
        return this.value;
    }

    public final HeapObject.HeapClass getValueAsClass() {
        HeapObject asObject = this.value.getAsObject();
        if (asObject != null) {
            return asObject.getAsClass();
        }
        return null;
    }

    public final HeapObject.HeapInstance getValueAsInstance() {
        HeapObject asObject = this.value.getAsObject();
        if (asObject != null) {
            return asObject.getAsInstance();
        }
        return null;
    }

    public final HeapObject.HeapObjectArray getValueAsObjectArray() {
        HeapObject asObject = this.value.getAsObject();
        if (asObject != null) {
            return asObject.getAsObjectArray();
        }
        return null;
    }

    public final HeapObject.HeapPrimitiveArray getValueAsPrimitiveArray() {
        HeapObject asObject = this.value.getAsObject();
        if (asObject != null) {
            return asObject.getAsPrimitiveArray();
        }
        return null;
    }
}