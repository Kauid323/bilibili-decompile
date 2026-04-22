package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: ValueClassAwareCaller.kt */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a(\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00110\u0017¢\u0006\u0002\b\u0019H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0011*\u00020\u0015H\u0002\u001a6\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\r\"\n\b\u0000\u0010\u001c*\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u0002H\u001c0\r2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0011*\u00020\tH\u0002\u001a\u0018\u0010\u001e\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010 \u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0012\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f*\u00020\u0013H\u0002\u001a\u0014\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f*\u0004\u0018\u00010\"H\u0000\u001a\u0018\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010'2\u0006\u0010\b\u001a\u00020\tH\u0000\"\u001a\u0010#\u001a\u0004\u0018\u00010\u0013*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"toJvmDescriptor", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassifierDescriptor;", "getValueClassUnboxMethods", "", "Ljava/lang/reflect/Method;", "type", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getMfvcUnboxMethods", "checkParametersSize", "", "Lkotlin/reflect/jvm/internal/calls/Caller;", "expectedArgsSize", "", "isDefault", "", "makeKotlinParameterTypes", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "member", "Ljava/lang/reflect/Member;", "isSpecificClass", "Lkotlin/Function1;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Lkotlin/ExtensionFunctionType;", "acceptsBoxedReceiverParameter", "createValueClassAwareCallerIfNeeded", "M", "hasValueClassReceiver", "getInlineClassUnboxMethod", "Ljava/lang/Class;", "getBoxMethod", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "expectedReceiverType", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ValueClassAwareCallerKt {
    public static final String toJvmDescriptor(ClassifierDescriptor $this$toJvmDescriptor) {
        Intrinsics.checkNotNullParameter($this$toJvmDescriptor, "<this>");
        ClassId classId = DescriptorUtilsKt.getClassId($this$toJvmDescriptor);
        Intrinsics.checkNotNull(classId);
        return ClassMapperLite.mapClass(classId.asString());
    }

    public static final List<Method> getValueClassUnboxMethods(SimpleType type, CallableMemberDescriptor descriptor) {
        Method p0;
        List<Method> mfvcUnboxMethods = getMfvcUnboxMethods(type);
        if (mfvcUnboxMethods == null) {
            Class<?> inlineClass = toInlineClass(type);
            if (inlineClass == null || (p0 = getInlineClassUnboxMethod(inlineClass, descriptor)) == null) {
                return null;
            }
            return CollectionsKt.listOf(p0);
        }
        return mfvcUnboxMethods;
    }

    private static final List<String> getMfvcUnboxMethods$getUnboxMethodNameSuffixes(SimpleType type) {
        Iterable $this$flatMap$iv;
        boolean z;
        Iterable $this$flatMapTo$iv$iv;
        Iterable listOf;
        if (InlineClassesUtilsKt.needsMfvcFlattening(type)) {
            ClassifierDescriptor mo1171getDeclarationDescriptor = type.getConstructor().mo1171getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo1171getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            MultiFieldValueClassRepresentation<SimpleType> multiFieldValueClassRepresentation = DescriptorUtilsKt.getMultiFieldValueClassRepresentation((ClassDescriptor) mo1171getDeclarationDescriptor);
            Intrinsics.checkNotNull(multiFieldValueClassRepresentation);
            Iterable $this$flatMap$iv2 = multiFieldValueClassRepresentation.getUnderlyingPropertyNamesToTypes();
            boolean z2 = false;
            Collection destination$iv$iv = new ArrayList();
            Iterable $this$flatMapTo$iv$iv2 = $this$flatMap$iv2;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv2) {
                Pair pair = (Pair) element$iv$iv;
                Name name = (Name) pair.component1();
                SimpleType innerType = (SimpleType) pair.component2();
                Iterable mfvcUnboxMethods$getUnboxMethodNameSuffixes = getMfvcUnboxMethods$getUnboxMethodNameSuffixes(innerType);
                if (mfvcUnboxMethods$getUnboxMethodNameSuffixes != null) {
                    Iterable $this$map$iv = mfvcUnboxMethods$getUnboxMethodNameSuffixes;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Iterable $this$flatMap$iv3 = $this$flatMap$iv2;
                        String it = (String) item$iv$iv;
                        destination$iv$iv2.add(name.getIdentifier() + '-' + it);
                        $this$flatMap$iv2 = $this$flatMap$iv3;
                        z2 = z2;
                        $this$flatMapTo$iv$iv2 = $this$flatMapTo$iv$iv2;
                    }
                    $this$flatMap$iv = $this$flatMap$iv2;
                    z = z2;
                    $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv2;
                    listOf = (List) destination$iv$iv2;
                } else {
                    $this$flatMap$iv = $this$flatMap$iv2;
                    z = z2;
                    $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv2;
                    listOf = CollectionsKt.listOf(name.getIdentifier());
                }
                Iterable list$iv$iv = listOf;
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                $this$flatMap$iv2 = $this$flatMap$iv;
                z2 = z;
                $this$flatMapTo$iv$iv2 = $this$flatMapTo$iv$iv;
            }
            return (List) destination$iv$iv;
        }
        return null;
    }

    public static final List<Method> getMfvcUnboxMethods(SimpleType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Iterable mfvcUnboxMethods$getUnboxMethodNameSuffixes = getMfvcUnboxMethods$getUnboxMethodNameSuffixes(TypeSubstitutionKt.asSimpleType(type));
        if (mfvcUnboxMethods$getUnboxMethodNameSuffixes != null) {
            Iterable $this$map$iv = mfvcUnboxMethods$getUnboxMethodNameSuffixes;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add("unbox-impl-" + it);
            }
            Iterable unboxMethodsNames = (List) destination$iv$iv;
            ClassifierDescriptor mo1171getDeclarationDescriptor = type.getConstructor().mo1171getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo1171getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class javaClass = UtilKt.toJavaClass((ClassDescriptor) mo1171getDeclarationDescriptor);
            Intrinsics.checkNotNull(javaClass);
            Iterable $this$map$iv2 = unboxMethodsNames;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                String it2 = (String) item$iv$iv2;
                destination$iv$iv2.add(javaClass.getDeclaredMethod(it2, new Class[0]));
            }
            return (List) destination$iv$iv2;
        }
        return null;
    }

    public static final void checkParametersSize(Caller<?> caller, int expectedArgsSize, CallableMemberDescriptor descriptor, boolean isDefault) {
        if (CallerKt.getArity(caller) != expectedArgsSize) {
            throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(caller) + " != " + expectedArgsSize + "\nCalling: " + descriptor + "\nParameter types: " + caller.getParameterTypes() + ")\nDefault: " + isDefault);
        }
    }

    public static final List<KotlinType> makeKotlinParameterTypes(CallableMemberDescriptor descriptor, Member member, Function1<? super ClassDescriptor, Boolean> function1) {
        ArrayList kotlinParameterTypes = new ArrayList();
        ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
        KotlinType extensionReceiverType = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
        if (extensionReceiverType != null) {
            kotlinParameterTypes.add(extensionReceiverType);
        } else if (descriptor instanceof ConstructorDescriptor) {
            ClassDescriptor constructedClass = ((ConstructorDescriptor) descriptor).getConstructedClass();
            Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
            if (constructedClass.isInner()) {
                DeclarationDescriptor containingDeclaration = constructedClass.getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                kotlinParameterTypes.add(((ClassDescriptor) containingDeclaration).getDefaultType());
            }
        } else {
            DeclarationDescriptor containingDeclaration2 = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
            if ((containingDeclaration2 instanceof ClassDescriptor) && function1.invoke(containingDeclaration2).booleanValue()) {
                boolean z = false;
                if (member != null && acceptsBoxedReceiverParameter(member)) {
                    z = true;
                }
                if (z) {
                    SimpleType defaultType = ((ClassDescriptor) containingDeclaration2).getDefaultType();
                    Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
                    kotlinParameterTypes.add(TypeUtilsKt.makeNullable(defaultType));
                } else {
                    kotlinParameterTypes.add(((ClassDescriptor) containingDeclaration2).getDefaultType());
                }
            }
        }
        Iterable valueParameters = descriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        Iterable $this$mapTo$iv = valueParameters;
        ArrayList destination$iv = kotlinParameterTypes;
        for (Object item$iv : $this$mapTo$iv) {
            ValueParameterDescriptor p0 = (ValueParameterDescriptor) item$iv;
            destination$iv.add(p0.getType());
        }
        return kotlinParameterTypes;
    }

    private static final boolean acceptsBoxedReceiverParameter(Member $this$acceptsBoxedReceiverParameter) {
        Class clazz = $this$acceptsBoxedReceiverParameter.getDeclaringClass();
        if (clazz == null) {
            return false;
        }
        return !JvmClassMappingKt.getKotlinClass(clazz).isValue();
    }

    public static /* synthetic */ Caller createValueClassAwareCallerIfNeeded$default(Caller caller, CallableMemberDescriptor callableMemberDescriptor, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return createValueClassAwareCallerIfNeeded(caller, callableMemberDescriptor, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> Caller<M> createValueClassAwareCallerIfNeeded(Caller<? extends M> caller, CallableMemberDescriptor descriptor, boolean isDefault) {
        Iterable $this$any$iv;
        Iterable $this$any$iv2;
        Intrinsics.checkNotNullParameter(caller, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        boolean z = true;
        if (!InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfValueClass(descriptor)) {
            Iterable contextReceiverParameters = descriptor.getContextReceiverParameters();
            Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
            Iterable $this$any$iv3 = contextReceiverParameters;
            if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                Iterator<T> it = $this$any$iv3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        ReceiverParameterDescriptor it2 = (ReceiverParameterDescriptor) element$iv;
                        KotlinType type = it2.getType();
                        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                        if (InlineClassesUtilsKt.isValueClassType(type)) {
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
            if ($this$any$iv == null) {
                Iterable valueParameters = descriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                Iterable $this$any$iv4 = valueParameters;
                if (!($this$any$iv4 instanceof Collection) || !((Collection) $this$any$iv4).isEmpty()) {
                    Iterator<T> it3 = $this$any$iv4.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            Object element$iv2 = it3.next();
                            ValueParameterDescriptor it4 = (ValueParameterDescriptor) element$iv2;
                            KotlinType type2 = it4.getType();
                            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                            if (InlineClassesUtilsKt.isValueClassType(type2)) {
                                $this$any$iv2 = 1;
                                break;
                            }
                        } else {
                            $this$any$iv2 = null;
                            break;
                        }
                    }
                } else {
                    $this$any$iv2 = null;
                }
                if ($this$any$iv2 == null) {
                    KotlinType returnType = descriptor.getReturnType();
                    if (!(returnType != null && InlineClassesUtilsKt.isInlineClassType(returnType)) && !hasValueClassReceiver(descriptor)) {
                        z = false;
                    }
                }
            }
        }
        boolean needsValueClassAwareCaller = z;
        return needsValueClassAwareCaller ? new ValueClassAwareCaller(descriptor, caller, isDefault) : caller;
    }

    private static final boolean hasValueClassReceiver(CallableMemberDescriptor $this$hasValueClassReceiver) {
        KotlinType expectedReceiverType = getExpectedReceiverType($this$hasValueClassReceiver);
        return expectedReceiverType != null && InlineClassesUtilsKt.isValueClassType(expectedReceiverType);
    }

    public static final Method getInlineClassUnboxMethod(Class<?> cls, CallableMemberDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            Intrinsics.checkNotNull(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    public static final Method getBoxMethod(Class<?> cls, CallableMemberDescriptor descriptor) {
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", getInlineClassUnboxMethod(cls, descriptor).getReturnType());
            Intrinsics.checkNotNull(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    public static final Class<?> toInlineClass(KotlinType $this$toInlineClass) {
        Class klass = toInlineClass($this$toInlineClass.getConstructor().mo1171getDeclarationDescriptor());
        if (klass == null) {
            return null;
        }
        if (TypeUtils.isNullableType($this$toInlineClass)) {
            KotlinType expandedUnderlyingType = InlineClassesUtilsKt.unsubstitutedUnderlyingType($this$toInlineClass);
            if (expandedUnderlyingType == null || TypeUtils.isNullableType(expandedUnderlyingType) || KotlinBuiltIns.isPrimitiveType(expandedUnderlyingType)) {
                return null;
            }
            return klass;
        }
        return klass;
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor $this$toInlineClass) {
        if (($this$toInlineClass instanceof ClassDescriptor) && InlineClassesUtilsKt.isInlineClass($this$toInlineClass)) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) $this$toInlineClass);
            if (javaClass != null) {
                return javaClass;
            }
            throw new KotlinReflectionInternalError("Class object for the class " + ((ClassDescriptor) $this$toInlineClass).getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor) $this$toInlineClass) + ')');
        }
        return null;
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor $this$expectedReceiverType) {
        ReceiverParameterDescriptor extensionReceiver = $this$expectedReceiverType.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiver = $this$expectedReceiverType.getDispatchReceiverParameter();
        if (extensionReceiver != null) {
            return extensionReceiver.getType();
        }
        if (dispatchReceiver == null) {
            return null;
        }
        if ($this$expectedReceiverType instanceof ConstructorDescriptor) {
            return dispatchReceiver.getType();
        }
        DeclarationDescriptor containingDeclaration = $this$expectedReceiverType.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        return classDescriptor != null ? classDescriptor.getDefaultType() : null;
    }

    public static final Object coerceToExpectedReceiverType(Object $this$coerceToExpectedReceiverType, CallableMemberDescriptor descriptor) {
        Class<?> inlineClass;
        Method unboxMethod;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if ((descriptor instanceof PropertyDescriptor) && InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor) descriptor)) {
            return $this$coerceToExpectedReceiverType;
        }
        KotlinType expectedReceiverType = getExpectedReceiverType(descriptor);
        if (expectedReceiverType == null || (inlineClass = toInlineClass(expectedReceiverType)) == null || (unboxMethod = getInlineClassUnboxMethod(inlineClass, descriptor)) == null) {
            return $this$coerceToExpectedReceiverType;
        }
        return unboxMethod.invoke($this$coerceToExpectedReceiverType, new Object[0]);
    }
}