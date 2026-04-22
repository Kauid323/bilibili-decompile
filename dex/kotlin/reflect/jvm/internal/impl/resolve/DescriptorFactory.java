package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;

public class DescriptorFactory {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case additional_type_content_opus_VALUE:
            case 23:
            case LeaksDbHelper.VERSION /* 25 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case additional_type_content_opus_VALUE:
            case 23:
            case LeaksDbHelper.VERSION /* 25 */:
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
            case 8:
            case additional_type_content_comment_VALUE:
            case 16:
            case 18:
            case 31:
            case 33:
            case 35:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case additional_type_content_video_VALUE:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case additional_type_content_opus_VALUE:
            case 23:
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case 26:
                objArr[0] = "enumClass";
                break;
            case 27:
            case 28:
            case 29:
                objArr[0] = "descriptor";
                break;
            case 30:
            case 32:
            case 34:
                objArr[0] = "owner";
                break;
        }
        switch (i) {
            case additional_type_content_opus_VALUE:
                objArr[1] = "createSetter";
                break;
            case 23:
                objArr[1] = "createEnumValuesMethod";
                break;
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[1] = "createEnumValueOfMethod";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case additional_type_content_opus_VALUE:
            case 23:
            case LeaksDbHelper.VERSION /* 25 */:
                break;
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "createEnumEntriesProperty";
                break;
            case 27:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 28:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 29:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 30:
            case 31:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 32:
            case 33:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case 34:
            case 35:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case additional_type_content_opus_VALUE:
            case 23:
            case LeaksDbHelper.VERSION /* 25 */:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class DefaultClassConstructorDescriptor extends ClassConstructorDescriptorImpl {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "source";
                    break;
                default:
                    objArr[0] = "containingClass";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DefaultClassConstructorDescriptor(ClassDescriptor containingClass, SourceElement source, boolean freedomForSealedInterfacesSupported) {
            super(containingClass, null, Annotations.Companion.getEMPTY(), true, CallableMemberDescriptor.Kind.DECLARATION, source);
            if (containingClass == null) {
                $$$reportNull$$$0(0);
            }
            if (source == null) {
                $$$reportNull$$$0(1);
            }
            initialize(Collections.emptyList(), DescriptorUtils.getDefaultConstructorVisibility(containingClass, freedomForSealedInterfacesSupported));
        }
    }

    public static PropertySetterDescriptorImpl createDefaultSetter(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations parameterAnnotations) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (parameterAnnotations == null) {
            $$$reportNull$$$0(2);
        }
        return createSetter(propertyDescriptor, annotations, parameterAnnotations, true, false, false, propertyDescriptor.getSource());
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations parameterAnnotations, boolean isDefault, boolean isExternal, boolean isInline, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if (annotations == null) {
            $$$reportNull$$$0(4);
        }
        if (parameterAnnotations == null) {
            $$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        return createSetter(propertyDescriptor, annotations, parameterAnnotations, isDefault, isExternal, isInline, propertyDescriptor.getVisibility(), sourceElement);
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations parameterAnnotations, boolean isDefault, boolean isExternal, boolean isInline, DescriptorVisibility visibility, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (annotations == null) {
            $$$reportNull$$$0(8);
        }
        if (parameterAnnotations == null) {
            $$$reportNull$$$0(9);
        }
        if (visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(11);
        }
        PropertySetterDescriptorImpl setterDescriptor = new PropertySetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.getModality(), visibility, isDefault, isExternal, isInline, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
        ValueParameterDescriptorImpl parameter = PropertySetterDescriptorImpl.createSetterParameter(setterDescriptor, propertyDescriptor.getType(), parameterAnnotations);
        setterDescriptor.initialize(parameter);
        return setterDescriptor;
    }

    public static PropertyGetterDescriptorImpl createDefaultGetter(PropertyDescriptor propertyDescriptor, Annotations annotations) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (annotations == null) {
            $$$reportNull$$$0(14);
        }
        return createGetter(propertyDescriptor, annotations, true, false, false);
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor propertyDescriptor, Annotations annotations, boolean isDefault, boolean isExternal, boolean isInline) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        if (annotations == null) {
            $$$reportNull$$$0(16);
        }
        return createGetter(propertyDescriptor, annotations, isDefault, isExternal, isInline, propertyDescriptor.getSource());
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor propertyDescriptor, Annotations annotations, boolean isDefault, boolean isExternal, boolean isInline, SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            $$$reportNull$$$0(17);
        }
        if (annotations == null) {
            $$$reportNull$$$0(18);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(19);
        }
        return new PropertyGetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.getModality(), propertyDescriptor.getVisibility(), isDefault, isExternal, isInline, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
    }

    public static ClassConstructorDescriptorImpl createPrimaryConstructorForObject(ClassDescriptor containingClass, SourceElement source) {
        if (containingClass == null) {
            $$$reportNull$$$0(20);
        }
        if (source == null) {
            $$$reportNull$$$0(21);
        }
        return new DefaultClassConstructorDescriptor(containingClass, source, false);
    }

    public static SimpleFunctionDescriptor createEnumValuesMethod(ClassDescriptor enumClass) {
        if (enumClass == null) {
            $$$reportNull$$$0(22);
        }
        SimpleFunctionDescriptorImpl values = SimpleFunctionDescriptorImpl.create(enumClass, Annotations.Companion.getEMPTY(), StandardNames.ENUM_VALUES, CallableMemberDescriptor.Kind.SYNTHESIZED, enumClass.getSource());
        SimpleFunctionDescriptorImpl initialize = values.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (KotlinType) DescriptorUtilsKt.getBuiltIns(enumClass).getArrayType(Variance.INVARIANT, enumClass.getDefaultType()), Modality.FINAL, DescriptorVisibilities.PUBLIC);
        if (initialize == null) {
            $$$reportNull$$$0(23);
        }
        return initialize;
    }

    public static SimpleFunctionDescriptor createEnumValueOfMethod(ClassDescriptor enumClass) {
        if (enumClass == null) {
            $$$reportNull$$$0(24);
        }
        SimpleFunctionDescriptorImpl valueOf = SimpleFunctionDescriptorImpl.create(enumClass, Annotations.Companion.getEMPTY(), StandardNames.ENUM_VALUE_OF, CallableMemberDescriptor.Kind.SYNTHESIZED, enumClass.getSource());
        ValueParameterDescriptor parameterDescriptor = new ValueParameterDescriptorImpl(valueOf, null, 0, Annotations.Companion.getEMPTY(), Name.identifier("value"), DescriptorUtilsKt.getBuiltIns(enumClass).getStringType(), false, false, false, null, enumClass.getSource());
        SimpleFunctionDescriptorImpl initialize = valueOf.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), Collections.singletonList(parameterDescriptor), (KotlinType) enumClass.getDefaultType(), Modality.FINAL, DescriptorVisibilities.PUBLIC);
        if (initialize == null) {
            $$$reportNull$$$0(25);
        }
        return initialize;
    }

    public static PropertyDescriptor createEnumEntriesProperty(ClassDescriptor enumClass) {
        if (enumClass == null) {
            $$$reportNull$$$0(26);
        }
        ModuleDescriptor module = DescriptorUtils.getContainingModule(enumClass);
        StdlibClassFinder stdlibClassFinder = StdlibClassFinderKt.getStdlibClassFinder(module);
        ClassDescriptor enumEntriesClass = stdlibClassFinder.findEnumEntriesClass(module);
        if (enumEntriesClass == null) {
            return null;
        }
        PropertyDescriptorImpl entries = PropertyDescriptorImpl.create(enumClass, Annotations.Companion.getEMPTY(), Modality.FINAL, DescriptorVisibilities.PUBLIC, false, StandardNames.ENUM_ENTRIES, CallableMemberDescriptor.Kind.SYNTHESIZED, enumClass.getSource(), false, false, false, false, false, false);
        PropertyGetterDescriptorImpl getter = new PropertyGetterDescriptorImpl(entries, Annotations.Companion.getEMPTY(), Modality.FINAL, DescriptorVisibilities.PUBLIC, false, false, false, CallableMemberDescriptor.Kind.SYNTHESIZED, null, enumClass.getSource());
        entries.initialize(getter, null);
        entries.setType(KotlinTypeFactory.simpleType(TypeAttributes.Companion.getEmpty(), enumEntriesClass.getTypeConstructor(), Collections.singletonList(new TypeProjectionImpl(enumClass.getDefaultType())), false), Collections.emptyList(), null, null, Collections.emptyList());
        getter.initialize(entries.getReturnType());
        return entries;
    }

    public static boolean isEnumValuesMethod(FunctionDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(27);
        }
        return descriptor.getName().equals(StandardNames.ENUM_VALUES) && isEnumSpecialMethod(descriptor);
    }

    public static boolean isEnumValueOfMethod(FunctionDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(28);
        }
        return descriptor.getName().equals(StandardNames.ENUM_VALUE_OF) && isEnumSpecialMethod(descriptor);
    }

    private static boolean isEnumSpecialMethod(FunctionDescriptor descriptor) {
        if (descriptor == null) {
            $$$reportNull$$$0(29);
        }
        return descriptor.getKind() == CallableMemberDescriptor.Kind.SYNTHESIZED && DescriptorUtils.isEnumClass(descriptor.getContainingDeclaration());
    }

    public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(CallableDescriptor owner, KotlinType receiverParameterType, Annotations annotations) {
        if (owner == null) {
            $$$reportNull$$$0(30);
        }
        if (annotations == null) {
            $$$reportNull$$$0(31);
        }
        if (receiverParameterType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(owner, new ExtensionReceiver(owner, receiverParameterType, null), annotations);
    }

    public static ReceiverParameterDescriptor createContextReceiverParameterForCallable(CallableDescriptor owner, KotlinType receiverParameterType, Name customLabelName, Annotations annotations, int index) {
        if (owner == null) {
            $$$reportNull$$$0(32);
        }
        if (annotations == null) {
            $$$reportNull$$$0(33);
        }
        if (receiverParameterType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(owner, new ContextReceiver(owner, receiverParameterType, customLabelName, null), annotations, NameUtils.contextReceiverName(index));
    }

    public static ReceiverParameterDescriptor createContextReceiverParameterForClass(ClassDescriptor owner, KotlinType receiverParameterType, Name customLabelName, Annotations annotations, int index) {
        if (owner == null) {
            $$$reportNull$$$0(34);
        }
        if (annotations == null) {
            $$$reportNull$$$0(35);
        }
        if (receiverParameterType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(owner, new ContextClassReceiver(owner, receiverParameterType, customLabelName, null), annotations, NameUtils.contextReceiverName(index));
    }
}