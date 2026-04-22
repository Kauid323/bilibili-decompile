package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.text.StringsKt;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u0006\u0012\u0002\b\u00030\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "<init>", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "isKnownBuiltInFunction", "", "descriptor", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapJvmClassToKotlinClassId", "klass", "Ljava/lang/Class;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE = new RuntimeTypeMapper();
    private static final ClassId JAVA_LANG_VOID = ClassId.Companion.topLevel(new FqName("java.lang.Void"));

    private RuntimeTypeMapper() {
    }

    public final JvmFunctionSignature mapSignature(FunctionDescriptor possiblySubstitutedFunction) {
        Method method;
        JvmMemberSignature.Method signature;
        JvmMemberSignature.Method realSignature;
        JvmMemberSignature.Method signature2;
        Intrinsics.checkNotNullParameter(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        FunctionDescriptor function = ((FunctionDescriptor) DescriptorUtils.unwrapFakeOverride(possiblySubstitutedFunction)).getOriginal();
        Intrinsics.checkNotNullExpressionValue(function, "getOriginal(...)");
        if (function instanceof DeserializedCallableMemberDescriptor) {
            MessageLite proto = ((DeserializedMemberDescriptor) function).getProto();
            if ((proto instanceof ProtoBuf.Function) && (signature2 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) proto, ((DeserializedMemberDescriptor) function).getNameResolver(), ((DeserializedMemberDescriptor) function).getTypeTable())) != null) {
                return new JvmFunctionSignature.KotlinFunction(signature2);
            }
            if ((proto instanceof ProtoBuf.Constructor) && (signature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) proto, ((DeserializedMemberDescriptor) function).getNameResolver(), ((DeserializedMemberDescriptor) function).getTypeTable())) != null) {
                DeclarationDescriptor containingDeclaration = possiblySubstitutedFunction.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                if (InlineClassesUtilsKt.isInlineClass(containingDeclaration)) {
                    return new JvmFunctionSignature.KotlinFunction(signature);
                }
                DeclarationDescriptor containingDeclaration2 = possiblySubstitutedFunction.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration2)) {
                    boolean z = true;
                    if (((ConstructorDescriptor) possiblySubstitutedFunction).isPrimary()) {
                        if (!Intrinsics.areEqual(signature.getName(), "constructor-impl") || !StringsKt.endsWith$default(signature.getDesc(), ")V", false, 2, (Object) null)) {
                            z = false;
                        }
                        if (!z) {
                            throw new IllegalArgumentException(("Invalid signature: " + signature).toString());
                        }
                    } else if (!Intrinsics.areEqual(signature.getName(), "constructor-impl")) {
                        throw new IllegalArgumentException(("Invalid signature: " + signature).toString());
                    } else {
                        ClassDescriptor constructedClass = ((ConstructorDescriptor) possiblySubstitutedFunction).getConstructedClass();
                        Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
                        String constructedClass2 = ValueClassAwareCallerKt.toJvmDescriptor(constructedClass);
                        if (StringsKt.endsWith$default(signature.getDesc(), ")V", false, 2, (Object) null)) {
                            realSignature = JvmMemberSignature.Method.copy$default(signature, null, StringsKt.removeSuffix(signature.getDesc(), (CharSequence) "V") + constructedClass2, 1, null);
                            return new JvmFunctionSignature.KotlinFunction(realSignature);
                        } else if (!StringsKt.endsWith$default(signature.getDesc(), constructedClass2, false, 2, (Object) null)) {
                            throw new IllegalArgumentException(("Invalid signature: " + signature).toString());
                        }
                    }
                    realSignature = signature;
                    return new JvmFunctionSignature.KotlinFunction(realSignature);
                }
                return new JvmFunctionSignature.KotlinConstructor(signature);
            }
            return mapJvmFunctionSignature(function);
        } else if (function instanceof JavaMethodDescriptor) {
            SourceElement source = ((JavaMethodDescriptor) function).getSource();
            JavaSourceElement javaSourceElement = source instanceof JavaSourceElement ? (JavaSourceElement) source : null;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            ReflectJavaMethod reflectJavaMethod = javaElement instanceof ReflectJavaMethod ? (ReflectJavaMethod) javaElement : null;
            if (reflectJavaMethod == null || (method = reflectJavaMethod.getMember()) == null) {
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + function);
            }
            return new JvmFunctionSignature.JavaMethod(method);
        } else if (function instanceof JavaClassConstructorDescriptor) {
            SourceElement source2 = ((JavaClassConstructorDescriptor) function).getSource();
            JavaSourceElement javaSourceElement2 = source2 instanceof JavaSourceElement ? (JavaSourceElement) source2 : null;
            JavaElement element = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
            if (element instanceof ReflectJavaConstructor) {
                return new JvmFunctionSignature.JavaConstructor(((ReflectJavaConstructor) element).getMember());
            }
            if ((element instanceof ReflectJavaClass) && ((ReflectJavaClass) element).isAnnotationType()) {
                return new JvmFunctionSignature.FakeJavaAnnotationConstructor(((ReflectJavaClass) element).getElement());
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + function + " (" + element + ')');
        } else if (isKnownBuiltInFunction(function)) {
            return mapJvmFunctionSignature(function);
        } else {
            throw new KotlinReflectionInternalError("Unknown origin of " + function + " (" + function.getClass() + ')');
        }
    }

    public final JvmPropertySignature mapPropertySignature(PropertyDescriptor possiblyOverriddenProperty) {
        Intrinsics.checkNotNullParameter(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        PropertyDescriptor property = ((PropertyDescriptor) DescriptorUtils.unwrapFakeOverride(possiblyOverriddenProperty)).getOriginal();
        Intrinsics.checkNotNullExpressionValue(property, "getOriginal(...)");
        JvmFunctionSignature.KotlinFunction kotlinFunction = null;
        if (property instanceof DeserializedPropertyDescriptor) {
            ProtoBuf.Property proto = ((DeserializedPropertyDescriptor) property).getProto();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
            Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature signature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
            if (signature != null) {
                return new JvmPropertySignature.KotlinProperty(property, proto, signature, ((DeserializedPropertyDescriptor) property).getNameResolver(), ((DeserializedPropertyDescriptor) property).getTypeTable());
            }
        } else if (property instanceof JavaPropertyDescriptor) {
            SourceElement source = ((JavaPropertyDescriptor) property).getSource();
            JavaSourceElement javaSourceElement = source instanceof JavaSourceElement ? (JavaSourceElement) source : null;
            JavaElement element = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (element instanceof ReflectJavaField) {
                return new JvmPropertySignature.JavaField(((ReflectJavaField) element).getMember());
            }
            if (element instanceof ReflectJavaMethod) {
                Method member = ((ReflectJavaMethod) element).getMember();
                PropertySetterDescriptor setter = ((JavaPropertyDescriptor) property).getSetter();
                SourceElement source2 = setter != null ? setter.getSource() : null;
                JavaSourceElement javaSourceElement2 = source2 instanceof JavaSourceElement ? (JavaSourceElement) source2 : null;
                JavaElement javaElement = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
                ReflectJavaMethod reflectJavaMethod = javaElement instanceof ReflectJavaMethod ? (ReflectJavaMethod) javaElement : null;
                return new JvmPropertySignature.JavaMethodProperty(member, reflectJavaMethod != null ? reflectJavaMethod.getMember() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + property + " (source = " + element + ')');
        }
        FunctionDescriptor getter = property.getGetter();
        Intrinsics.checkNotNull(getter);
        FunctionDescriptor p0 = getter;
        JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature = mapJvmFunctionSignature(p0);
        FunctionDescriptor setter2 = property.getSetter();
        if (setter2 != null) {
            FunctionDescriptor p02 = setter2;
            kotlinFunction = mapJvmFunctionSignature(p02);
        }
        return new JvmPropertySignature.MappedKotlinProperty(mapJvmFunctionSignature, kotlinFunction);
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor descriptor) {
        if (DescriptorFactory.isEnumValueOfMethod(descriptor) || DescriptorFactory.isEnumValuesMethod(descriptor)) {
            return true;
        }
        return Intrinsics.areEqual(descriptor.getName(), CloneableClassScope.Companion.getCLONE_NAME()) && descriptor.getValueParameters().isEmpty();
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor descriptor) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName(descriptor), MethodSignatureMappingKt.computeJvmDescriptor$default(descriptor, false, false, 1, null)));
    }

    private final String mapName(CallableMemberDescriptor descriptor) {
        String jvmMethodNameIfSpecial = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(descriptor);
        if (jvmMethodNameIfSpecial == null) {
            if (descriptor instanceof PropertyGetterDescriptor) {
                String asString = DescriptorUtilsKt.getPropertyIfAccessor(descriptor).getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                return JvmAbi.getterName(asString);
            } else if (descriptor instanceof PropertySetterDescriptor) {
                String asString2 = DescriptorUtilsKt.getPropertyIfAccessor(descriptor).getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
                return JvmAbi.setterName(asString2);
            } else {
                String asString3 = descriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString3, "asString(...)");
                return asString3;
            }
        }
        return jvmMethodNameIfSpecial;
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> klass) {
        ClassId it;
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
            PrimitiveType it2 = getPrimitiveType(componentType);
            if (it2 != null) {
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, it2.getArrayTypeName());
            }
            return ClassId.Companion.topLevel(StandardNames.FqNames.array.toSafe());
        } else if (Intrinsics.areEqual(klass, Void.TYPE)) {
            return JAVA_LANG_VOID;
        } else {
            PrimitiveType it3 = getPrimitiveType(klass);
            if (it3 != null) {
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, it3.getTypeName());
            }
            ClassId classId = ReflectClassUtilKt.getClassId(klass);
            if (!classId.isLocal() && (it = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(classId.asSingleFqName())) != null) {
                return it;
            }
            return classId;
        }
    }

    private final PrimitiveType getPrimitiveType(Class<?> cls) {
        if (cls.isPrimitive()) {
            return JvmPrimitiveType.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }
}