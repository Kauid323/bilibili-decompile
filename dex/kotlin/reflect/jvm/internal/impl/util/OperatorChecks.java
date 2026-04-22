package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck;

/* compiled from: modifierChecks.kt */
public final class OperatorChecks extends AbstractModifierChecks {
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    private static final List<Checks> checks = CollectionsKt.listOf((Object[]) new Checks[]{new Checks(OperatorNameConventions.GET, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(1)}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SET, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(2)}, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$0
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            String checks$lambda$0;
            checks$lambda$0 = OperatorChecks.checks$lambda$0((FunctionDescriptor) obj);
            return checks$lambda$0;
        }
    }), new Checks(OperatorNameConventions.GET_VALUE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(2), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SET_VALUE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(3), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.PROVIDE_DELEGATE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.Equals(2), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.INVOKE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.CONTAINS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.ITERATOR, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.NEXT, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.HAS_NEXT, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.RANGE_TO, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.RANGE_UNTIL, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.EQUALS, new Check[]{MemberKindCheck.Member.INSTANCE}, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$1
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            String checks$lambda$1;
            checks$lambda$1 = OperatorChecks.checks$lambda$1((FunctionDescriptor) obj);
            return checks$lambda$1;
        }
    }), new Checks(OperatorNameConventions.COMPARE_TO, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsInt.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(CollectionsKt.listOf((Object[]) new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC}), new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$2
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            String checks$lambda$2;
            checks$lambda$2 = OperatorChecks.checks$lambda$2((FunctionDescriptor) obj);
            return checks$lambda$2;
        }
    }), new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsUnit.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.COMPONENT_REGEX, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null)});

    private OperatorChecks() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
    public List<Checks> getChecks$descriptors() {
        return checks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String checks$lambda$0(FunctionDescriptor Checks) {
        Intrinsics.checkNotNullParameter(Checks, "$this$Checks");
        List<ValueParameterDescriptor> valueParameters = Checks.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        ValueParameterDescriptor it = (ValueParameterDescriptor) CollectionsKt.lastOrNull((List<? extends Object>) valueParameters);
        boolean z = false;
        if (it != null) {
            if (((DescriptorUtilsKt.declaresOrInheritsDefaultValue(it) || it.getVarargElementType() != null) ? null : 1) == 1) {
                z = true;
            }
        }
        boolean lastIsOk = z;
        OperatorChecks operatorChecks = INSTANCE;
        if (lastIsOk) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }

    private static final boolean checks$lambda$1$isAny(DeclarationDescriptor $this$checks_u24lambda_u241_u24isAny) {
        return ($this$checks_u24lambda_u241_u24isAny instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) $this$checks_u24lambda_u241_u24isAny);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String checks$lambda$1(FunctionDescriptor Checks) {
        Iterable $this$any$iv;
        Intrinsics.checkNotNullParameter(Checks, "$this$Checks");
        OperatorChecks operatorChecks = INSTANCE;
        DeclarationDescriptor containingDeclaration = Checks.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        boolean z = true;
        if (!checks$lambda$1$isAny(containingDeclaration)) {
            Iterable overriddenDescriptors = Checks.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            Iterable $this$any$iv2 = overriddenDescriptors;
            if (!((Collection) $this$any$iv2).isEmpty()) {
                Iterator<T> it = $this$any$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        FunctionDescriptor it2 = (FunctionDescriptor) element$iv;
                        DeclarationDescriptor containingDeclaration2 = it2.getContainingDeclaration();
                        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                        if (checks$lambda$1$isAny(containingDeclaration2)) {
                            $this$any$iv = 1;
                            break;
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            if ($this$any$iv == null && !DescriptorUtilKt.isTypedEqualsInValueClass(Checks)) {
                z = false;
            }
        }
        boolean cond$iv = z;
        if (cond$iv) {
            return null;
        }
        StringBuilder $this$checks_u24lambda_u241_u241_u240 = new StringBuilder();
        $this$checks_u24lambda_u241_u241_u240.append("must override ''equals()'' in Any");
        DeclarationDescriptor containingDeclaration3 = Checks.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration3, "getContainingDeclaration(...)");
        if (InlineClassesUtilsKt.isValueClass(containingDeclaration3)) {
            DescriptorRenderer descriptorRenderer = DescriptorRenderer.SHORT_NAMES_IN_TYPES;
            DeclarationDescriptor containingDeclaration4 = Checks.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            SimpleType defaultType = ((ClassDescriptor) containingDeclaration4).getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            String expectedParameterTypeRendered = descriptorRenderer.renderType(TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType));
            $this$checks_u24lambda_u241_u241_u240.append(" or define ''equals(other: " + expectedParameterTypeRendered + "): Boolean''");
        }
        return $this$checks_u24lambda_u241_u241_u240.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String checks$lambda$2(FunctionDescriptor Checks) {
        boolean z;
        Intrinsics.checkNotNullParameter(Checks, "$this$Checks");
        ReceiverParameterDescriptor receiver = Checks.getDispatchReceiverParameter();
        if (receiver == null) {
            receiver = Checks.getExtensionReceiverParameter();
        }
        OperatorChecks operatorChecks = INSTANCE;
        boolean cond$iv = false;
        if (receiver != null) {
            KotlinType returnType = Checks.getReturnType();
            if (returnType != null) {
                KotlinType type = receiver.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                z = TypeUtilsKt.isSubtypeOf(returnType, type);
            } else {
                z = false;
            }
            if (z || INSTANCE.incDecCheckForExpectClass(Checks, receiver)) {
                cond$iv = true;
            }
        }
        if (cond$iv) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }

    private final boolean incDecCheckForExpectClass(FunctionDescriptor $this$incDecCheckForExpectClass, ReceiverParameterDescriptor receiver) {
        ClassId potentialActualAliasId;
        KotlinType returnType;
        ReceiverValue receiverValue = receiver.getValue();
        Intrinsics.checkNotNullExpressionValue(receiverValue, "getValue(...)");
        if (receiverValue instanceof ImplicitClassReceiver) {
            ClassDescriptor classDescriptor = ((ImplicitClassReceiver) receiverValue).getClassDescriptor();
            if (classDescriptor.isExpect() && (potentialActualAliasId = DescriptorUtilsKt.getClassId(classDescriptor)) != null) {
                ClassifierDescriptor findClassifierAcrossModuleDependencies = FindClassInModuleKt.findClassifierAcrossModuleDependencies(DescriptorUtilsKt.getModule(classDescriptor), potentialActualAliasId);
                TypeAliasDescriptor actualReceiverTypeAlias = findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor ? (TypeAliasDescriptor) findClassifierAcrossModuleDependencies : null;
                if (actualReceiverTypeAlias == null || (returnType = $this$incDecCheckForExpectClass.getReturnType()) == null) {
                    return false;
                }
                return TypeUtilsKt.isSubtypeOf(returnType, actualReceiverTypeAlias.getExpandedType());
            }
            return false;
        }
        return false;
    }
}