package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Boolean hasStableParameterNames;
    private Boolean hasSynthesizedParameterNames;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 11:
            case 18:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 11:
            case 18:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case additional_type_content_video_VALUE:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case additional_type_content_opus_VALUE:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case additional_type_content_comment_VALUE:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        switch (i) {
            case 11:
                objArr[1] = "createSubstitutedCopy";
                break;
            case 18:
                objArr[1] = "enhance";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 11:
            case 18:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Pair pair) {
        return enhance(kotlinType, (List<KotlinType>) list, kotlinType2, (Pair<CallableDescriptor.UserDataKey<?>, ?>) pair);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected JavaClassConstructorDescriptor(ClassDescriptor containingDeclaration, JavaClassConstructorDescriptor original, Annotations annotations, boolean isPrimary, CallableMemberDescriptor.Kind kind, SourceElement source) {
        super(containingDeclaration, original, annotations, isPrimary, kind, source);
        if (containingDeclaration == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (kind == null) {
            $$$reportNull$$$0(2);
        }
        if (source == null) {
            $$$reportNull$$$0(3);
        }
        this.hasStableParameterNames = null;
        this.hasSynthesizedParameterNames = null;
    }

    public static JavaClassConstructorDescriptor createJavaConstructor(ClassDescriptor containingDeclaration, Annotations annotations, boolean isPrimary, SourceElement source) {
        if (containingDeclaration == null) {
            $$$reportNull$$$0(4);
        }
        if (annotations == null) {
            $$$reportNull$$$0(5);
        }
        if (source == null) {
            $$$reportNull$$$0(6);
        }
        return new JavaClassConstructorDescriptor(containingDeclaration, null, annotations, isPrimary, CallableMemberDescriptor.Kind.DECLARATION, source);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        if (this.hasStableParameterNames == null) {
            throw new AssertionError("hasStableParameterNames was not set: " + this);
        }
        return this.hasStableParameterNames.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public void setHasStableParameterNames(boolean hasStableParameterNames) {
        this.hasStableParameterNames = Boolean.valueOf(hasStableParameterNames);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        if (this.hasSynthesizedParameterNames == null) {
            throw new AssertionError("hasSynthesizedParameterNames was not set: " + this);
        }
        return this.hasSynthesizedParameterNames.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public void setHasSynthesizedParameterNames(boolean hasSynthesizedParameterNames) {
        this.hasSynthesizedParameterNames = Boolean.valueOf(hasSynthesizedParameterNames);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public JavaClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor newOwner, FunctionDescriptor original, CallableMemberDescriptor.Kind kind, Name newName, Annotations annotations, SourceElement source) {
        if (newOwner == null) {
            $$$reportNull$$$0(7);
        }
        if (kind == null) {
            $$$reportNull$$$0(8);
        }
        if (annotations == null) {
            $$$reportNull$$$0(9);
        }
        if (source == null) {
            $$$reportNull$$$0(10);
        }
        if (kind != CallableMemberDescriptor.Kind.DECLARATION && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + newOwner + "\nkind: " + kind);
        }
        if (newName != null) {
            throw new AssertionError("Attempt to rename constructor: " + this);
        }
        JavaClassConstructorDescriptor result = createDescriptor((ClassDescriptor) newOwner, (JavaClassConstructorDescriptor) original, kind, source, annotations);
        result.setHasStableParameterNames(hasStableParameterNames());
        result.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
        if (result == null) {
            $$$reportNull$$$0(11);
        }
        return result;
    }

    protected JavaClassConstructorDescriptor createDescriptor(ClassDescriptor newOwner, JavaClassConstructorDescriptor original, CallableMemberDescriptor.Kind kind, SourceElement sourceElement, Annotations annotations) {
        if (newOwner == null) {
            $$$reportNull$$$0(12);
        }
        if (kind == null) {
            $$$reportNull$$$0(13);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(14);
        }
        if (annotations == null) {
            $$$reportNull$$$0(15);
        }
        return new JavaClassConstructorDescriptor(newOwner, original, annotations, this.isPrimary, kind, sourceElement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaClassConstructorDescriptor enhance(KotlinType enhancedReceiverType, List<KotlinType> enhancedValueParameterTypes, KotlinType enhancedReturnType, Pair<CallableDescriptor.UserDataKey<?>, ?> additionalUserData) {
        if (enhancedValueParameterTypes == null) {
            $$$reportNull$$$0(16);
        }
        if (enhancedReturnType == null) {
            $$$reportNull$$$0(17);
        }
        JavaClassConstructorDescriptor enhanced = createSubstitutedCopy((DeclarationDescriptor) getContainingDeclaration(), (FunctionDescriptor) null, getKind(), (Name) null, getAnnotations(), getSource());
        ReceiverParameterDescriptor enhancedReceiver = enhancedReceiverType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(enhanced, enhancedReceiverType, Annotations.Companion.getEMPTY());
        enhanced.initialize(enhancedReceiver, getDispatchReceiverParameter(), CollectionsKt.emptyList(), getTypeParameters(), UtilKt.copyValueParameters(enhancedValueParameterTypes, getValueParameters(), enhanced), enhancedReturnType, getModality(), getVisibility());
        if (additionalUserData != null) {
            enhanced.putInUserDataMap((CallableDescriptor.UserDataKey) additionalUserData.getFirst(), additionalUserData.getSecond());
        }
        if (enhanced == null) {
            $$$reportNull$$$0(18);
        }
        return enhanced;
    }
}