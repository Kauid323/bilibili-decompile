package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: KPropertyImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KPropertyImplKt {
    public static final /* synthetic */ Caller access$computeCallerForAccessor(KPropertyImpl.Accessor $receiver, boolean isGetter) {
        return computeCallerForAccessor($receiver, isGetter);
    }

    public static final Object getBoundReceiver(KPropertyImpl.Accessor<?, ?> accessor) {
        Intrinsics.checkNotNullParameter(accessor, "<this>");
        return accessor.getProperty().getBoundReceiver();
    }

    public static final Caller<?> computeCallerForAccessor(KPropertyImpl.Accessor<?, ?> accessor, boolean isGetter) {
        JvmFunctionSignature.KotlinFunction signature;
        Method method;
        Caller boundInstance;
        JvmProtoBuf.JvmMethodSignature setter;
        Method unboxMethod;
        if (KDeclarationContainerImpl.Companion.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(accessor.getProperty().getSignature())) {
            return ThrowingCaller.INSTANCE;
        }
        JvmPropertySignature jvmSignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(accessor.getProperty().getDescriptor());
        if (jvmSignature instanceof JvmPropertySignature.KotlinProperty) {
            JvmProtoBuf.JvmPropertySignature $this$computeCallerForAccessor_u24lambda_u240 = ((JvmPropertySignature.KotlinProperty) jvmSignature).getSignature();
            if (isGetter) {
                setter = $this$computeCallerForAccessor_u24lambda_u240.hasGetter() ? $this$computeCallerForAccessor_u24lambda_u240.getGetter() : null;
            } else {
                setter = $this$computeCallerForAccessor_u24lambda_u240.hasSetter() ? $this$computeCallerForAccessor_u24lambda_u240.getSetter() : null;
            }
            JvmProtoBuf.JvmMethodSignature accessorSignature = setter;
            Method accessor2 = accessorSignature != null ? accessor.getProperty().getContainer().findMethodBySignature(((JvmPropertySignature.KotlinProperty) jvmSignature).getNameResolver().getString(accessorSignature.getName()), ((JvmPropertySignature.KotlinProperty) jvmSignature).getNameResolver().getString(accessorSignature.getDesc())) : null;
            if (accessor2 == null) {
                if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(accessor.getProperty().getDescriptor()) && Intrinsics.areEqual(accessor.getProperty().getDescriptor().getVisibility(), DescriptorVisibilities.INTERNAL)) {
                    Class<?> inlineClass = ValueClassAwareCallerKt.toInlineClass(accessor.getProperty().getDescriptor().getContainingDeclaration());
                    if (inlineClass == null || (unboxMethod = ValueClassAwareCallerKt.getInlineClassUnboxMethod(inlineClass, accessor.getProperty().getDescriptor())) == null) {
                        throw new KotlinReflectionInternalError("Underlying property of inline class " + accessor.getProperty() + " should have a field");
                    }
                    boundInstance = accessor.isBound() ? new InternalUnderlyingValOfInlineClass.Bound(unboxMethod, getBoundReceiver(accessor)) : new InternalUnderlyingValOfInlineClass.Unbound(unboxMethod);
                } else {
                    Field javaField = accessor.getProperty().getJavaField();
                    if (javaField == null) {
                        throw new KotlinReflectionInternalError("No accessors or field is found for property " + accessor.getProperty());
                    }
                    boundInstance = computeCallerForAccessor$computeFieldCaller(accessor, isGetter, javaField);
                }
            } else if (!Modifier.isStatic(accessor2.getModifiers())) {
                boundInstance = accessor.isBound() ? new CallerImpl.Method.BoundInstance(accessor2, getBoundReceiver(accessor)) : new CallerImpl.Method.Instance(accessor2);
            } else if (computeCallerForAccessor$isJvmStaticProperty(accessor)) {
                boundInstance = accessor.isBound() ? new CallerImpl.Method.BoundJvmStaticInObject(accessor2) : new CallerImpl.Method.JvmStaticInObject(accessor2);
            } else {
                boundInstance = accessor.isBound() ? new CallerImpl.Method.BoundStatic(accessor2, false, getBoundReceiver(accessor)) : new CallerImpl.Method.Static(accessor2);
            }
        } else if (jvmSignature instanceof JvmPropertySignature.JavaField) {
            boundInstance = computeCallerForAccessor$computeFieldCaller(accessor, isGetter, ((JvmPropertySignature.JavaField) jvmSignature).getField());
        } else if (jvmSignature instanceof JvmPropertySignature.JavaMethodProperty) {
            if (isGetter) {
                method = ((JvmPropertySignature.JavaMethodProperty) jvmSignature).getGetterMethod();
            } else {
                method = ((JvmPropertySignature.JavaMethodProperty) jvmSignature).getSetterMethod();
                if (method == null) {
                    throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + ((JvmPropertySignature.JavaMethodProperty) jvmSignature).getGetterMethod());
                }
            }
            boundInstance = accessor.isBound() ? new CallerImpl.Method.BoundInstance(method, getBoundReceiver(accessor)) : new CallerImpl.Method.Instance(method);
        } else if (!(jvmSignature instanceof JvmPropertySignature.MappedKotlinProperty)) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (isGetter) {
                signature = ((JvmPropertySignature.MappedKotlinProperty) jvmSignature).getGetterSignature();
            } else {
                signature = ((JvmPropertySignature.MappedKotlinProperty) jvmSignature).getSetterSignature();
                if (signature == null) {
                    throw new KotlinReflectionInternalError("No setter found for property " + accessor.getProperty());
                }
            }
            Method accessor3 = accessor.getProperty().getContainer().findMethodBySignature(signature.getMethodName(), signature.getMethodDesc());
            if (accessor3 == null) {
                throw new KotlinReflectionInternalError("No accessor found for property " + accessor.getProperty());
            }
            if (Modifier.isStatic(accessor3.getModifiers())) {
                throw new AssertionError("Mapped property cannot have a static accessor: " + accessor.getProperty());
            }
            return accessor.isBound() ? new CallerImpl.Method.BoundInstance(accessor3, getBoundReceiver(accessor)) : new CallerImpl.Method.Instance(accessor3);
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded$default(boundInstance, accessor.getDescriptor(), false, 2, null);
    }

    private static final boolean computeCallerForAccessor$isJvmStaticProperty(KPropertyImpl.Accessor<?, ?> accessor) {
        return accessor.getProperty().getDescriptor().getAnnotations().hasAnnotation(UtilKt.getJVM_STATIC());
    }

    private static final boolean computeCallerForAccessor$isNotNullProperty(KPropertyImpl.Accessor<?, ?> accessor) {
        return !TypeUtils.isNullableType(accessor.getProperty().getDescriptor().getType());
    }

    private static final CallerImpl<Field> computeCallerForAccessor$computeFieldCaller(KPropertyImpl.Accessor<?, ?> accessor, boolean $isGetter, Field field) {
        if (isJvmFieldPropertyInCompanionObject(accessor.getProperty().getDescriptor()) || !Modifier.isStatic(field.getModifiers())) {
            if ($isGetter) {
                return accessor.isBound() ? new CallerImpl.FieldGetter.BoundInstance(field, getBoundReceiver(accessor)) : new CallerImpl.FieldGetter.Instance(field);
            }
            return accessor.isBound() ? new CallerImpl.FieldSetter.BoundInstance(field, computeCallerForAccessor$isNotNullProperty(accessor), getBoundReceiver(accessor)) : new CallerImpl.FieldSetter.Instance(field, computeCallerForAccessor$isNotNullProperty(accessor));
        } else if (!computeCallerForAccessor$isJvmStaticProperty(accessor)) {
            return $isGetter ? new CallerImpl.FieldGetter.Static(field) : new CallerImpl.FieldSetter.Static(field, computeCallerForAccessor$isNotNullProperty(accessor));
        } else if ($isGetter) {
            return accessor.isBound() ? new CallerImpl.FieldGetter.BoundJvmStaticInObject(field) : new CallerImpl.FieldGetter.JvmStaticInObject(field);
        } else {
            return accessor.isBound() ? new CallerImpl.FieldSetter.BoundJvmStaticInObject(field, computeCallerForAccessor$isNotNullProperty(accessor)) : new CallerImpl.FieldSetter.JvmStaticInObject(field, computeCallerForAccessor$isNotNullProperty(accessor));
        }
    }

    private static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor $this$isJvmFieldPropertyInCompanionObject) {
        DeclarationDescriptor container = $this$isJvmFieldPropertyInCompanionObject.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(container, "getContainingDeclaration(...)");
        if (DescriptorUtils.isCompanionObject(container)) {
            DeclarationDescriptor outerClass = container.getContainingDeclaration();
            if (DescriptorUtils.isInterface(outerClass) || DescriptorUtils.isAnnotationClass(outerClass)) {
                return ($this$isJvmFieldPropertyInCompanionObject instanceof DeserializedPropertyDescriptor) && JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor) $this$isJvmFieldPropertyInCompanionObject).getProto());
            }
            return true;
        }
        return false;
    }
}