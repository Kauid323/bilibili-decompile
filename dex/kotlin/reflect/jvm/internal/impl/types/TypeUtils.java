package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;
import org.webrtc.H265Utils;

public class TypeUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorType(ErrorTypeKind.DONT_CARE, new String[0]);
    public static final SimpleType CANNOT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType(ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case 57:
            case 58:
            case 59:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case 57:
            case 58:
            case 59:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case 57:
            case 58:
            case 59:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 5:
            case 8:
            case 10:
            case 18:
            case 23:
            case LeaksDbHelper.VERSION /* 25 */:
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 40:
            default:
                objArr[0] = "type";
                break;
            case additional_type_content_opus_VALUE:
                objArr[0] = "typeConstructor";
                break;
            case additional_type_content_video_VALUE:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case additional_type_content_comment_VALUE:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = "parameters";
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                objArr[0] = "result";
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case 41:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
                objArr[0] = "isSpecialType";
                break;
            case 45:
            case 46:
                objArr[0] = "parameterDescriptor";
                break;
            case 47:
            case 51:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 49:
            case 50:
                objArr[0] = "supertypes";
                break;
            case 52:
            case 55:
                objArr[0] = "expectedType";
                break;
            case 54:
                objArr[0] = "literalTypeConstructor";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "makeNullableAsSpecified";
                break;
            case 6:
            case 7:
            case 9:
                objArr[1] = "makeNullableIfNeeded";
                break;
            case 11:
            case 15:
                objArr[1] = "makeUnsubstitutedType";
                break;
            case 17:
                objArr[1] = "getDefaultTypeProjections";
                break;
            case 19:
                objArr[1] = "getImmediateSupertypes";
                break;
            case 26:
                objArr[1] = "getAllSupertypes";
                break;
            case 35:
                objArr[1] = "substituteProjectionsForParameters";
                break;
            case 48:
                objArr[1] = "getDefaultPrimitiveNumberType";
                break;
            case 53:
            case 56:
            case 57:
            case 58:
            case 59:
                objArr[1] = "getPrimitiveNumberType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case 57:
            case 58:
            case 59:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                objArr[2] = "collectAllSupertypes";
                break;
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case 41:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 44:
                objArr[2] = "contains";
                break;
            case 45:
            case 46:
                objArr[2] = "makeStarProjection";
                break;
            case 47:
            case 49:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 50:
                objArr[2] = "findByFqName";
                break;
            case 51:
            case 52:
            case 54:
            case 55:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 60:
                objArr[2] = "isTypeParameter";
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 62:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case H265Utils.kLevel2_1 /* 63 */:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case 57:
            case 58:
            case 59:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class SpecialType extends DelegatingSimpleType {
        private final String name;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 1:
                case 4:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 1:
                case 4:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                case 4:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                    break;
                case 2:
                    objArr[0] = "delegate";
                    break;
                case 3:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "newAttributes";
                    break;
            }
            switch (i) {
                case 1:
                    objArr[1] = "toString";
                    break;
                case 4:
                    objArr[1] = "refine";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                    break;
            }
            switch (i) {
                case 1:
                case 4:
                    break;
                case 2:
                    objArr[2] = "replaceDelegate";
                    break;
                case 3:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "replaceAttributes";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 1:
                case 4:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        public SpecialType(String name) {
            this.name = name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        protected SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType replaceAttributes(TypeAttributes newAttributes) {
            if (newAttributes == null) {
                $$$reportNull$$$0(0);
            }
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType makeNullableAsSpecified(boolean newNullability) {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
        public String toString() {
            String str = this.name;
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        public DelegatingSimpleType replaceDelegate(SimpleType delegate) {
            if (delegate == null) {
                $$$reportNull$$$0(2);
            }
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public SpecialType refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner == null) {
                $$$reportNull$$$0(3);
            }
            return this;
        }
    }

    public static boolean noExpectedType(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(0);
        }
        return type == NO_EXPECTED_TYPE || type == UNIT_EXPECTED_TYPE;
    }

    public static boolean isDontCarePlaceholder(KotlinType type) {
        return type != null && type.getConstructor() == DONT_CARE.getConstructor();
    }

    public static KotlinType makeNullable(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(1);
        }
        return makeNullableAsSpecified(type, true);
    }

    public static KotlinType makeNotNullable(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(2);
        }
        return makeNullableAsSpecified(type, false);
    }

    public static KotlinType makeNullableAsSpecified(KotlinType type, boolean nullable) {
        if (type == null) {
            $$$reportNull$$$0(3);
        }
        UnwrappedType makeNullableAsSpecified = type.unwrap().makeNullableAsSpecified(nullable);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(4);
        }
        return makeNullableAsSpecified;
    }

    public static SimpleType makeNullableIfNeeded(SimpleType type, boolean nullable) {
        if (type == null) {
            $$$reportNull$$$0(5);
        }
        if (nullable) {
            SimpleType makeNullableAsSpecified = type.makeNullableAsSpecified(true);
            if (makeNullableAsSpecified == null) {
                $$$reportNull$$$0(6);
            }
            return makeNullableAsSpecified;
        }
        if (type == null) {
            $$$reportNull$$$0(7);
        }
        return type;
    }

    public static KotlinType makeNullableIfNeeded(KotlinType type, boolean nullable) {
        if (type == null) {
            $$$reportNull$$$0(8);
        }
        if (nullable) {
            return makeNullable(type);
        }
        if (type == null) {
            $$$reportNull$$$0(9);
        }
        return type;
    }

    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope unsubstitutedMemberScope, Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory) {
        if (ErrorUtils.isError(classifierDescriptor)) {
            ErrorType createErrorType = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, classifierDescriptor.toString());
            if (createErrorType == null) {
                $$$reportNull$$$0(11);
            }
            return createErrorType;
        }
        TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
        return makeUnsubstitutedType(typeConstructor, unsubstitutedMemberScope, refinedTypeFactory);
    }

    public static SimpleType makeUnsubstitutedType(TypeConstructor typeConstructor, MemberScope unsubstitutedMemberScope, Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(12);
        }
        if (unsubstitutedMemberScope == null) {
            $$$reportNull$$$0(13);
        }
        if (refinedTypeFactory == null) {
            $$$reportNull$$$0(14);
        }
        List<TypeProjection> arguments = getDefaultTypeProjections(typeConstructor.getParameters());
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), typeConstructor, arguments, false, unsubstitutedMemberScope, refinedTypeFactory);
        if (simpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(15);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }

    public static List<TypeProjection> getDefaultTypeProjections(List<TypeParameterDescriptor> parameters) {
        if (parameters == null) {
            $$$reportNull$$$0(16);
        }
        List<TypeProjection> result = new ArrayList<>(parameters.size());
        for (TypeParameterDescriptor parameterDescriptor : parameters) {
            result.add(new TypeProjectionImpl(parameterDescriptor.getDefaultType()));
        }
        List<TypeProjection> list = CollectionsKt.toList(result);
        if (list == null) {
            $$$reportNull$$$0(17);
        }
        return list;
    }

    public static List<KotlinType> getImmediateSupertypes(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(18);
        }
        TypeSubstitutor substitutor = TypeSubstitutor.create(type);
        Collection<KotlinType> originalSupertypes = type.getConstructor().mo1172getSupertypes();
        List<KotlinType> result = new ArrayList<>(originalSupertypes.size());
        for (KotlinType supertype : originalSupertypes) {
            KotlinType substitutedType = createSubstitutedSupertype(type, supertype, substitutor);
            if (substitutedType != null) {
                result.add(substitutedType);
            }
        }
        return result;
    }

    public static KotlinType createSubstitutedSupertype(KotlinType subType, KotlinType superType, TypeSubstitutor substitutor) {
        if (subType == null) {
            $$$reportNull$$$0(20);
        }
        if (superType == null) {
            $$$reportNull$$$0(21);
        }
        if (substitutor == null) {
            $$$reportNull$$$0(22);
        }
        KotlinType substitutedType = substitutor.substitute(superType, Variance.INVARIANT);
        if (substitutedType != null) {
            return makeNullableIfNeeded(substitutedType, subType.isMarkedNullable());
        }
        return null;
    }

    public static boolean isNullableType(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(27);
        }
        if (type.isMarkedNullable()) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(type) && isNullableType(FlexibleTypesKt.asFlexibleType(type).getUpperBound())) {
            return true;
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(type)) {
            return false;
        }
        if (isTypeParameter(type)) {
            return hasNullableSuperType(type);
        }
        if (type instanceof AbstractStubType) {
            NewTypeVariableConstructor typeVariableConstructor = ((AbstractStubType) type).getOriginalTypeVariable();
            TypeParameterDescriptor typeParameter = typeVariableConstructor.getOriginalTypeParameter();
            return typeParameter == null || hasNullableSuperType(typeParameter.getDefaultType());
        }
        TypeConstructor constructor = type.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            for (KotlinType supertype : constructor.mo1172getSupertypes()) {
                if (isNullableType(supertype)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean acceptsNullable(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(28);
        }
        if (type.isMarkedNullable()) {
            return true;
        }
        return FlexibleTypesKt.isFlexible(type) && acceptsNullable(FlexibleTypesKt.asFlexibleType(type).getUpperBound());
    }

    public static boolean hasNullableSuperType(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(29);
        }
        if (type.getConstructor().mo1171getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        for (KotlinType supertype : getImmediateSupertypes(type)) {
            if (isNullableType(supertype)) {
                return true;
            }
        }
        return false;
    }

    public static ClassDescriptor getClassDescriptor(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(30);
        }
        DeclarationDescriptor declarationDescriptor = type.getConstructor().mo1171getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public static boolean contains(KotlinType type, Function1<UnwrappedType, Boolean> isSpecialType) {
        if (isSpecialType == null) {
            $$$reportNull$$$0(43);
        }
        return contains(type, isSpecialType, null);
    }

    private static boolean contains(KotlinType type, Function1<UnwrappedType, Boolean> isSpecialType, SmartSet<KotlinType> visited) {
        if (isSpecialType == null) {
            $$$reportNull$$$0(44);
        }
        if (type == null) {
            return false;
        }
        UnwrappedType unwrappedType = type.unwrap();
        if (noExpectedType(type)) {
            return isSpecialType.invoke(unwrappedType).booleanValue();
        }
        if (visited != null && visited.contains(type)) {
            return false;
        }
        if (isSpecialType.invoke(unwrappedType).booleanValue()) {
            return true;
        }
        if (visited == null) {
            visited = SmartSet.create();
        }
        visited.add(type);
        FlexibleType flexibleType = unwrappedType instanceof FlexibleType ? (FlexibleType) unwrappedType : null;
        if (flexibleType == null || !(contains(flexibleType.getLowerBound(), isSpecialType, visited) || contains(flexibleType.getUpperBound(), isSpecialType, visited))) {
            if ((unwrappedType instanceof DefinitelyNotNullType) && contains(((DefinitelyNotNullType) unwrappedType).getOriginal(), isSpecialType, visited)) {
                return true;
            }
            TypeConstructor typeConstructor = type.getConstructor();
            if (typeConstructor instanceof IntersectionTypeConstructor) {
                IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) typeConstructor;
                for (KotlinType supertype : intersectionTypeConstructor.mo1172getSupertypes()) {
                    if (contains(supertype, isSpecialType, visited)) {
                        return true;
                    }
                }
                return false;
            }
            for (TypeProjection projection : type.getArguments()) {
                if (!projection.isStarProjection()) {
                    if (contains(projection.getType(), isSpecialType, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor parameterDescriptor) {
        if (parameterDescriptor == null) {
            $$$reportNull$$$0(45);
        }
        return new StarProjectionImpl(parameterDescriptor);
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor parameterDescriptor, ErasureTypeAttributes attr) {
        if (parameterDescriptor == null) {
            $$$reportNull$$$0(46);
        }
        if (attr.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(parameterDescriptor));
        }
        return new StarProjectionImpl(parameterDescriptor);
    }

    public static boolean isTypeParameter(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(60);
        }
        return getTypeParameterDescriptorOrNull(type) != null || (type.getConstructor() instanceof NewTypeVariableConstructor);
    }

    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(KotlinType type) {
        if (type == null) {
            $$$reportNull$$$0(63);
        }
        if (type.getConstructor().mo1171getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) type.getConstructor().mo1171getDeclarationDescriptor();
        }
        return null;
    }
}