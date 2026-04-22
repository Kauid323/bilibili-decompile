package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* compiled from: DescriptorBasedDeprecationInfo.kt */
public abstract class DescriptorBasedDeprecationInfo extends DeprecationInfo {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo
    public boolean getPropagatesToOverrides() {
        return getForcePropagationToOverrides();
    }

    public boolean getForcePropagationToOverrides() {
        return false;
    }
}