package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* compiled from: descriptorUtil.kt */
public final class DescriptorUtilKt {
    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor $this$resolveClassByFqName, FqName fqName, LookupLocation lookupLocation) {
        ClassifierDescriptor classifierDescriptor;
        MemberScope unsubstitutedInnerClassesScope;
        Intrinsics.checkNotNullParameter($this$resolveClassByFqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(lookupLocation, "lookupLocation");
        if (fqName.isRoot()) {
            return null;
        }
        ClassifierDescriptor contributedClassifier = $this$resolveClassByFqName.getPackage(fqName.parent()).getMemberScope().mo1173getContributedClassifier(fqName.shortName(), lookupLocation);
        ClassDescriptor it = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        if (it != null) {
            return it;
        }
        ClassDescriptor resolveClassByFqName = resolveClassByFqName($this$resolveClassByFqName, fqName.parent(), lookupLocation);
        if (resolveClassByFqName == null || (unsubstitutedInnerClassesScope = resolveClassByFqName.getUnsubstitutedInnerClassesScope()) == null) {
            classifierDescriptor = null;
        } else {
            classifierDescriptor = unsubstitutedInnerClassesScope.mo1173getContributedClassifier(fqName.shortName(), lookupLocation);
        }
        if (classifierDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) classifierDescriptor;
        }
        return null;
    }

    public static final boolean isTopLevelInPackage(DeclarationDescriptor $this$isTopLevelInPackage) {
        Intrinsics.checkNotNullParameter($this$isTopLevelInPackage, "<this>");
        return $this$isTopLevelInPackage.getContainingDeclaration() instanceof PackageFragmentDescriptor;
    }

    public static final ClassifierDescriptor getTopLevelContainingClassifier(DeclarationDescriptor $this$getTopLevelContainingClassifier) {
        Intrinsics.checkNotNullParameter($this$getTopLevelContainingClassifier, "<this>");
        DeclarationDescriptor containingDeclaration = $this$getTopLevelContainingClassifier.getContainingDeclaration();
        if (containingDeclaration == null || ($this$getTopLevelContainingClassifier instanceof PackageFragmentDescriptor)) {
            return null;
        }
        if (!isTopLevelInPackage(containingDeclaration)) {
            return getTopLevelContainingClassifier(containingDeclaration);
        }
        if (!(containingDeclaration instanceof ClassifierDescriptor)) {
            return null;
        }
        return (ClassifierDescriptor) containingDeclaration;
    }

    public static final boolean isTypedEqualsInValueClass(FunctionDescriptor $this$isTypedEqualsInValueClass) {
        SimpleType defaultType;
        KotlinType valueClassStarProjection;
        KotlinType returnType;
        Intrinsics.checkNotNullParameter($this$isTypedEqualsInValueClass, "<this>");
        DeclarationDescriptor containingDeclaration = $this$isTypedEqualsInValueClass.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            ClassDescriptor it = classDescriptor;
            ClassDescriptor classDescriptor2 = InlineClassesUtilsKt.isValueClass(it) ? classDescriptor : null;
            if (classDescriptor2 == null || (defaultType = classDescriptor2.getDefaultType()) == null || (valueClassStarProjection = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) == null || (returnType = $this$isTypedEqualsInValueClass.getReturnType()) == null || !Intrinsics.areEqual($this$isTypedEqualsInValueClass.getName(), OperatorNameConventions.EQUALS)) {
                return false;
            }
            if ((TypeUtilsKt.isBoolean(returnType) || TypeUtilsKt.isNothing(returnType)) && $this$isTypedEqualsInValueClass.getValueParameters().size() == 1) {
                KotlinType type = $this$isTypedEqualsInValueClass.getValueParameters().get(0).getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                return Intrinsics.areEqual(TypeUtilsKt.replaceArgumentsWithStarProjections(type), valueClassStarProjection) && $this$isTypedEqualsInValueClass.getContextReceiverParameters().isEmpty() && $this$isTypedEqualsInValueClass.getExtensionReceiverParameter() == null;
            }
            return false;
        }
        return false;
    }
}