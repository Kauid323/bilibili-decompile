package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ContextClassReceiver.kt */
public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitContextReceiver {
    private final ClassDescriptor classDescriptor;
    private final Name customLabelName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextClassReceiver(ClassDescriptor classDescriptor, KotlinType receiverType, Name customLabelName, ReceiverValue original) {
        super(receiverType, original);
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(receiverType, "receiverType");
        this.classDescriptor = classDescriptor;
        this.customLabelName = customLabelName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver
    public Name getCustomLabelName() {
        return this.customLabelName;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}