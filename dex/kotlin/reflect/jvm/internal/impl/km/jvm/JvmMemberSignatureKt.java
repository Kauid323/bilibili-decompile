package kotlin.reflect.jvm.internal.impl.km.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* compiled from: JvmMemberSignature.kt */
public final class JvmMemberSignatureKt {
    public static final JvmMethodSignature wrapAsPublic(JvmMemberSignature.Method $this$wrapAsPublic) {
        Intrinsics.checkNotNullParameter($this$wrapAsPublic, "<this>");
        return new JvmMethodSignature($this$wrapAsPublic.getName(), $this$wrapAsPublic.getDesc());
    }

    public static final JvmFieldSignature wrapAsPublic(JvmMemberSignature.Field $this$wrapAsPublic) {
        Intrinsics.checkNotNullParameter($this$wrapAsPublic, "<this>");
        return new JvmFieldSignature($this$wrapAsPublic.getName(), $this$wrapAsPublic.getDesc());
    }
}