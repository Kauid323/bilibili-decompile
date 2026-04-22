package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class JavaPropertyDescriptor extends PropertyDescriptorImpl implements JavaCallableMemberDescriptor {
    private KotlinType inType;
    private final boolean isStaticFinal;
    private final Pair<CallableDescriptor.UserDataKey<?>, ?> singleUserData;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 21:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 21:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case additional_type_content_opus_VALUE:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case additional_type_content_video_VALUE:
                objArr[0] = "newOwner";
                break;
            case additional_type_content_comment_VALUE:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        switch (i) {
            case 21:
                objArr[1] = "enhance";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
                objArr[2] = "create";
                break;
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 21:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaPropertyDescriptor(DeclarationDescriptor containingDeclaration, Annotations annotations, Modality modality, DescriptorVisibility visibility, boolean isVar, Name name, SourceElement source, PropertyDescriptor original, CallableMemberDescriptor.Kind kind, boolean isStaticFinal, Pair<CallableDescriptor.UserDataKey<?>, ?> singleUserData) {
        super(containingDeclaration, original, annotations, modality, visibility, isVar, name, kind, source, false, false, false, false, false, false);
        if (containingDeclaration == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (modality == null) {
            $$$reportNull$$$0(2);
        }
        if (visibility == null) {
            $$$reportNull$$$0(3);
        }
        if (name == null) {
            $$$reportNull$$$0(4);
        }
        if (source == null) {
            $$$reportNull$$$0(5);
        }
        if (kind == null) {
            $$$reportNull$$$0(6);
        }
        this.inType = null;
        this.isStaticFinal = isStaticFinal;
        this.singleUserData = singleUserData;
    }

    public static JavaPropertyDescriptor create(DeclarationDescriptor containingDeclaration, Annotations annotations, Modality modality, DescriptorVisibility visibility, boolean isVar, Name name, SourceElement source, boolean isStaticFinal) {
        if (containingDeclaration == null) {
            $$$reportNull$$$0(7);
        }
        if (annotations == null) {
            $$$reportNull$$$0(8);
        }
        if (modality == null) {
            $$$reportNull$$$0(9);
        }
        if (visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (name == null) {
            $$$reportNull$$$0(11);
        }
        if (source == null) {
            $$$reportNull$$$0(12);
        }
        return new JavaPropertyDescriptor(containingDeclaration, annotations, modality, visibility, isVar, name, source, null, CallableMemberDescriptor.Kind.DECLARATION, isStaticFinal, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    protected PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor newOwner, Modality newModality, DescriptorVisibility newVisibility, PropertyDescriptor original, CallableMemberDescriptor.Kind kind, Name newName, SourceElement source) {
        if (newOwner == null) {
            $$$reportNull$$$0(13);
        }
        if (newModality == null) {
            $$$reportNull$$$0(14);
        }
        if (newVisibility == null) {
            $$$reportNull$$$0(15);
        }
        if (kind == null) {
            $$$reportNull$$$0(16);
        }
        if (newName == null) {
            $$$reportNull$$$0(17);
        }
        if (source == null) {
            $$$reportNull$$$0(18);
        }
        return new JavaPropertyDescriptor(newOwner, getAnnotations(), newModality, newVisibility, isVar(), newName, source, original, kind, this.isStaticFinal, this.singleUserData);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaCallableMemberDescriptor enhance(KotlinType enhancedReceiverType, List<KotlinType> enhancedValueParameterTypes, KotlinType enhancedReturnType, Pair<CallableDescriptor.UserDataKey<?>, ?> additionalUserData) {
        PropertyGetterDescriptorImpl newGetter;
        PropertySetterDescriptorImpl newSetter;
        if (enhancedValueParameterTypes == null) {
            $$$reportNull$$$0(19);
        }
        if (enhancedReturnType == null) {
            $$$reportNull$$$0(20);
        }
        PropertyDescriptor enhancedOriginal = getOriginal() == this ? null : getOriginal();
        JavaPropertyDescriptor enhanced = new JavaPropertyDescriptor(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), enhancedOriginal, getKind(), this.isStaticFinal, additionalUserData);
        PropertyGetterDescriptorImpl getter = getGetter();
        if (getter == null) {
            newGetter = null;
        } else {
            PropertyGetterDescriptorImpl newGetter2 = new PropertyGetterDescriptorImpl(enhanced, getter.getAnnotations(), getter.getModality(), getter.getVisibility(), getter.isDefault(), getter.isExternal(), getter.isInline(), getKind(), enhancedOriginal == null ? null : enhancedOriginal.getGetter(), getter.getSource());
            newGetter2.setInitialSignatureDescriptor(getter.getInitialSignatureDescriptor());
            newGetter2.initialize(enhancedReturnType);
            newGetter = newGetter2;
        }
        PropertySetterDescriptor setter = getSetter();
        if (setter == null) {
            newSetter = null;
        } else {
            PropertySetterDescriptorImpl newSetter2 = new PropertySetterDescriptorImpl(enhanced, setter.getAnnotations(), setter.getModality(), setter.getVisibility(), setter.isDefault(), setter.isExternal(), setter.isInline(), getKind(), enhancedOriginal == null ? null : enhancedOriginal.getSetter(), setter.getSource());
            newSetter2.setInitialSignatureDescriptor(newSetter2.getInitialSignatureDescriptor());
            newSetter2.initialize(setter.getValueParameters().get(0));
            newSetter = newSetter2;
        }
        enhanced.initialize(newGetter, newSetter, getBackingField(), getDelegateField());
        enhanced.setSetterProjectedOut(isSetterProjectedOut());
        if (this.compileTimeInitializerFactory != null) {
            enhanced.setCompileTimeInitializer(this.compileTimeInitializer, this.compileTimeInitializerFactory);
        }
        enhanced.setOverriddenDescriptors(getOverriddenDescriptors());
        ReceiverParameterDescriptor enhancedReceiver = enhancedReceiverType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(this, enhancedReceiverType, Annotations.Companion.getEMPTY());
        enhanced.setType(enhancedReturnType, getTypeParameters(), getDispatchReceiverParameter(), enhancedReceiver, CollectionsKt.emptyList());
        return enhanced;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        KotlinType type = getType();
        return this.isStaticFinal && ConstUtil.canBeUsedForConstVal(type) && (!TypeEnhancementKt.hasEnhancedNullability(type) || KotlinBuiltIns.isString(type));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    public void setInType(KotlinType inType) {
        if (inType == null) {
            $$$reportNull$$$0(22);
        }
        this.inType = inType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> key) {
        if (this.singleUserData != null && ((CallableDescriptor.UserDataKey) this.singleUserData.getFirst()).equals(key)) {
            return (V) this.singleUserData.getSecond();
        }
        return null;
    }
}