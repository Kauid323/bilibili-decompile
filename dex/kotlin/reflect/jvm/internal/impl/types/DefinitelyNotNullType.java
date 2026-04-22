package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;

/* compiled from: SpecialTypes.kt */
public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeParameter, DefinitelyNotNullTypeMarker {
    public static final Companion Companion = new Companion(null);
    private final SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    public /* synthetic */ DefinitelyNotNullType(SimpleType simpleType, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleType, z);
    }

    private DefinitelyNotNullType(SimpleType original, boolean useCorrectedNullabilityForTypeParameters) {
        this.original = original;
        this.useCorrectedNullabilityForTypeParameters = useCorrectedNullabilityForTypeParameters;
    }

    public final SimpleType getOriginal() {
        return this.original;
    }

    /* compiled from: SpecialTypes.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion companion, UnwrappedType unwrappedType, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return companion.makeDefinitelyNotNull(unwrappedType, z, z2);
        }

        public final DefinitelyNotNullType makeDefinitelyNotNull(UnwrappedType type, boolean useCorrectedNullabilityForTypeParameters, boolean avoidCheckingActualTypeNullability) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof DefinitelyNotNullType) {
                return (DefinitelyNotNullType) type;
            }
            if (!avoidCheckingActualTypeNullability && !makesSenseToBeDefinitelyNotNull(type, useCorrectedNullabilityForTypeParameters)) {
                return null;
            }
            if ((type instanceof FlexibleType) && !Intrinsics.areEqual(((FlexibleType) type).getLowerBound().getConstructor(), ((FlexibleType) type).getUpperBound().getConstructor())) {
                throw new AssertionError("DefinitelyNotNullType for flexible type (" + type + ") can be created only from type variable with the same constructor for bounds");
            }
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(type).makeNullableAsSpecified(false), useCorrectedNullabilityForTypeParameters, null);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType type, boolean useCorrectedNullabilityForFlexibleTypeParameters) {
            boolean z = false;
            if (canHaveUndefinedNullability(type)) {
                if (type instanceof StubTypeForBuilderInference) {
                    return TypeUtils.isNullableType(type);
                }
                ClassifierDescriptor mo1171getDeclarationDescriptor = type.getConstructor().mo1171getDeclarationDescriptor();
                TypeParameterDescriptorImpl typeParameterDescriptorImpl = mo1171getDeclarationDescriptor instanceof TypeParameterDescriptorImpl ? (TypeParameterDescriptorImpl) mo1171getDeclarationDescriptor : null;
                if (typeParameterDescriptorImpl != null && !typeParameterDescriptorImpl.isInitialized()) {
                    z = true;
                }
                if (z) {
                    return true;
                }
                if (useCorrectedNullabilityForFlexibleTypeParameters && (type.getConstructor().mo1171getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
                    return TypeUtils.isNullableType(type);
                }
                return !NullabilityChecker.INSTANCE.isSubtypeOfAny(type);
            }
            return false;
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType $this$canHaveUndefinedNullability) {
            return ($this$canHaveUndefinedNullability.getConstructor() instanceof NewTypeVariableConstructor) || ($this$canHaveUndefinedNullability.getConstructor().mo1171getDeclarationDescriptor() instanceof TypeParameterDescriptor) || ($this$canHaveUndefinedNullability instanceof NewCapturedType) || ($this$canHaveUndefinedNullability instanceof StubTypeForBuilderInference);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected SimpleType getDelegate() {
        return this.original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        return (getDelegate().getConstructor() instanceof NewTypeVariableConstructor) || (getDelegate().getConstructor().mo1171getDeclarationDescriptor() instanceof TypeParameterDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType replacement) {
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(replacement.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new DefinitelyNotNullType(getDelegate().replaceAttributes(newAttributes), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean newNullability) {
        return newNullability ? getDelegate().makeNullableAsSpecified(newNullability) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        return getDelegate() + " & Any";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public DefinitelyNotNullType replaceDelegate(SimpleType delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new DefinitelyNotNullType(delegate, this.useCorrectedNullabilityForTypeParameters);
    }
}