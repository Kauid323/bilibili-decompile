package leakcanary.internal;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Serializables.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toByteArray", "", "Ljava/io/Serializable;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class SerializablesKt {
    public static final byte[] toByteArray(Serializable toByteArray) {
        Intrinsics.checkParameterIsNotNull(toByteArray, "$this$toByteArray");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(outputStream).writeObject(toByteArray);
        byte[] byteArray = outputStream.toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byteArray, "outputStream.toByteArray()");
        return byteArray;
    }
}