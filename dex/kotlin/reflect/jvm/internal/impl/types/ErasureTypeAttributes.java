package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: ErasureTypeAttributes.kt */
public class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(TypeUsage howThisTypeIsUsed, Set<? extends TypeParameterDescriptor> set, SimpleType defaultType) {
        Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.visitedTypeParameters = set;
        this.defaultType = defaultType;
    }

    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    public ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameter) {
        Set it;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        TypeUsage howThisTypeIsUsed = getHowThisTypeIsUsed();
        Set it2 = getVisitedTypeParameters();
        if (it2 == null || (it = SetsKt.plus(it2, typeParameter)) == null) {
            it = SetsKt.setOf(typeParameter);
        }
        return new ErasureTypeAttributes(howThisTypeIsUsed, it, getDefaultType());
    }

    public boolean equals(Object other) {
        return (other instanceof ErasureTypeAttributes) && Intrinsics.areEqual(((ErasureTypeAttributes) other).getDefaultType(), getDefaultType()) && ((ErasureTypeAttributes) other).getHowThisTypeIsUsed() == getHowThisTypeIsUsed();
    }

    public int hashCode() {
        SimpleType defaultType = getDefaultType();
        int result = defaultType != null ? defaultType.hashCode() : 0;
        return result + (result * 31) + getHowThisTypeIsUsed().hashCode();
    }
}