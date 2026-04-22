package leakcanary.internal;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import shark.SharkLog;

/* compiled from: Serializables.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lleakcanary/internal/Serializables;", "", "()V", "fromByteArray", "T", "byteArray", "", "([B)Ljava/lang/Object;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class Serializables {
    public static final Serializables INSTANCE = new Serializables();

    private Serializables() {
    }

    public final /* synthetic */ <T> T fromByteArray(byte[] byteArray) {
        Intrinsics.checkParameterIsNotNull(byteArray, "byteArray");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
        try {
            T t = (T) new ObjectInputStream(inputStream).readObject();
            Intrinsics.reifiedOperationMarker(2, "T");
            T t2 = t;
            return t;
        } catch (Throwable ignored) {
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d(ignored, "Could not deserialize bytes, ignoring");
            }
            return null;
        }
    }
}