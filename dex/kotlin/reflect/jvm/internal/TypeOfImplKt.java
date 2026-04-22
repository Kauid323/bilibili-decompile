package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeOfImpl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\t"}, d2 = {"createPlatformKType", "Lkotlin/reflect/KType;", "lowerBound", "upperBound", "createMutableCollectionKType", "type", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "createNothingType", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TypeOfImplKt {
    public static final KType createPlatformKType(KType lowerBound, KType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        KotlinType type = ((KTypeImpl) lowerBound).getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType type2 = ((KTypeImpl) upperBound).getType();
        Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) type, (SimpleType) type2), null, 2, null);
    }

    public static final KType createMutableCollectionKType(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType kotlinType = ((KTypeImpl) type).getType();
        if (!(kotlinType instanceof SimpleType)) {
            throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + type).toString());
        }
        ClassifierDescriptor mo1171getDeclarationDescriptor = kotlinType.getConstructor().mo1171getDeclarationDescriptor();
        ClassDescriptor classifier = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
        if (classifier == null) {
            throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + type);
        }
        TypeConstructor typeConstructor = readOnlyToMutable(classifier).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default((SimpleType) kotlinType, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), null, 2, null);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor $this$readOnlyToMutable) {
        FqName fqName = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe($this$readOnlyToMutable));
        if (fqName == null) {
            throw new IllegalArgumentException("Not a readonly collection: " + $this$readOnlyToMutable);
        }
        ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns($this$readOnlyToMutable).getBuiltInClassByFqName(fqName);
        Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "getBuiltInClassByFqName(...)");
        return builtInClassByFqName;
    }

    public static final KType createNothingType(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType kotlinType = ((KTypeImpl) type).getType();
        if (!(kotlinType instanceof SimpleType)) {
            throw new IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + type).toString());
        }
        TypeConstructor typeConstructor = TypeUtilsKt.getBuiltIns(kotlinType).getNothing().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default((SimpleType) kotlinType, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), null, 2, null);
    }
}