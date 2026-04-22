package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapObject;

/* compiled from: AndroidExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"hexIdentityHashCode", "", "Lshark/HeapObject$HeapInstance;", "getHexIdentityHashCode", "(Lshark/HeapObject$HeapInstance;)Ljava/lang/String;", "identityHashCode", "", "getIdentityHashCode", "(Lshark/HeapObject$HeapInstance;)Ljava/lang/Integer;", "shark-android"}, k = 2, mv = {1, 4, 1})
public final class AndroidExtensionsKt {
    public static final Integer getIdentityHashCode(HeapObject.HeapInstance $this$identityHashCode) {
        HeapValue value;
        Intrinsics.checkParameterIsNotNull($this$identityHashCode, "$this$identityHashCode");
        HeapField heapField = $this$identityHashCode.get("java.lang.Object", "shadow$_monitor_");
        Integer lockWord = (heapField == null || (value = heapField.getValue()) == null) ? null : value.getAsInt();
        if (lockWord == null || (lockWord.intValue() & (-1073741824)) != Integer.MIN_VALUE) {
            return null;
        }
        return Integer.valueOf(lockWord.intValue() & 268435455);
    }

    public static final String getHexIdentityHashCode(HeapObject.HeapInstance $this$hexIdentityHashCode) {
        Intrinsics.checkParameterIsNotNull($this$hexIdentityHashCode, "$this$hexIdentityHashCode");
        Integer identityHashCode = getIdentityHashCode($this$hexIdentityHashCode);
        if (identityHashCode == null) {
            return null;
        }
        int hashCode = identityHashCode.intValue();
        return Integer.toHexString(hashCode);
    }
}