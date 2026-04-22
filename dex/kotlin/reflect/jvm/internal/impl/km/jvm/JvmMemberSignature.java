package kotlin.reflect.jvm.internal.impl.km.jvm;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JvmMemberSignature.kt */
public abstract class JvmMemberSignature {
    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getDescriptor();

    public abstract String getName();

    public abstract String toString();

    private JvmMemberSignature() {
    }
}