package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;

public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean isForRecordComponent;
    private ParameterNamesStatus parameterNamesStatus;
    public static final CallableDescriptor.UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new CallableDescriptor.UserDataKey<ValueParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.1
    };
    public static final CallableDescriptor.UserDataKey<Boolean> HAS_ERASED_VALUE_PARAMETERS = new CallableDescriptor.UserDataKey<Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.2
    };

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case additional_type_content_video_VALUE:
            case 18:
            case 21:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case additional_type_content_video_VALUE:
            case 18:
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
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case additional_type_content_opus_VALUE:
                objArr[0] = "visibility";
                break;
            case additional_type_content_video_VALUE:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case additional_type_content_comment_VALUE:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        switch (i) {
            case additional_type_content_video_VALUE:
                objArr[1] = "initialize";
                break;
            case 18:
                objArr[1] = "createSubstitutedCopy";
                break;
            case 21:
                objArr[1] = "enhance";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
                objArr[2] = "initialize";
                break;
            case additional_type_content_video_VALUE:
            case 18:
            case 21:
                break;
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case additional_type_content_video_VALUE:
            case 18:
            case 21:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Pair pair) {
        return enhance(kotlinType, (List<KotlinType>) list, kotlinType2, (Pair<CallableDescriptor.UserDataKey<?>, ?>) pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        ParameterNamesStatus(boolean isStable, boolean isSynthesized) {
            this.isStable = isStable;
            this.isSynthesized = isSynthesized;
        }

        public static ParameterNamesStatus get(boolean stable, boolean synthesized) {
            ParameterNamesStatus parameterNamesStatus = stable ? synthesized ? STABLE_SYNTHESIZED : STABLE_DECLARED : synthesized ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (parameterNamesStatus == null) {
                $$$reportNull$$$0(0);
            }
            return parameterNamesStatus;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected JavaMethodDescriptor(DeclarationDescriptor containingDeclaration, SimpleFunctionDescriptor original, Annotations annotations, Name name, CallableMemberDescriptor.Kind kind, SourceElement source, boolean isForRecordComponent) {
        super(containingDeclaration, original, annotations, name, kind, source);
        if (containingDeclaration == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (kind == null) {
            $$$reportNull$$$0(3);
        }
        if (source == null) {
            $$$reportNull$$$0(4);
        }
        this.parameterNamesStatus = null;
        this.isForRecordComponent = isForRecordComponent;
    }

    public static JavaMethodDescriptor createJavaMethod(DeclarationDescriptor containingDeclaration, Annotations annotations, Name name, SourceElement source, boolean isForRecordComponent) {
        if (containingDeclaration == null) {
            $$$reportNull$$$0(5);
        }
        if (annotations == null) {
            $$$reportNull$$$0(6);
        }
        if (name == null) {
            $$$reportNull$$$0(7);
        }
        if (source == null) {
            $$$reportNull$$$0(8);
        }
        return new JavaMethodDescriptor(containingDeclaration, null, annotations, name, CallableMemberDescriptor.Kind.DECLARATION, source, isForRecordComponent);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl
    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor extensionReceiverParameter, ReceiverParameterDescriptor dispatchReceiverParameter, List<ReceiverParameterDescriptor> contextReceiverParameters, List<? extends TypeParameterDescriptor> typeParameters, List<ValueParameterDescriptor> unsubstitutedValueParameters, KotlinType unsubstitutedReturnType, Modality modality, DescriptorVisibility visibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> userData) {
        if (contextReceiverParameters == null) {
            $$$reportNull$$$0(9);
        }
        if (typeParameters == null) {
            $$$reportNull$$$0(10);
        }
        if (unsubstitutedValueParameters == null) {
            $$$reportNull$$$0(11);
        }
        if (visibility == null) {
            $$$reportNull$$$0(12);
        }
        SimpleFunctionDescriptorImpl descriptor = super.initialize(extensionReceiverParameter, dispatchReceiverParameter, contextReceiverParameters, typeParameters, unsubstitutedValueParameters, unsubstitutedReturnType, modality, visibility, userData);
        setOperator(OperatorChecks.INSTANCE.check(descriptor).isSuccess());
        if (descriptor == null) {
            $$$reportNull$$$0(13);
        }
        return descriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        if (this.parameterNamesStatus == null) {
            throw new AssertionError("Parameter names status was not set: " + this);
        }
        return this.parameterNamesStatus.isStable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        if (this.parameterNamesStatus == null) {
            throw new AssertionError("Parameter names status was not set: " + this);
        }
        return this.parameterNamesStatus.isSynthesized;
    }

    public void setParameterNamesStatus(boolean hasStableParameterNames, boolean hasSynthesizedParameterNames) {
        this.parameterNamesStatus = ParameterNamesStatus.get(hasStableParameterNames, hasSynthesizedParameterNames);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public JavaMethodDescriptor createSubstitutedCopy(DeclarationDescriptor newOwner, FunctionDescriptor original, CallableMemberDescriptor.Kind kind, Name newName, Annotations annotations, SourceElement source) {
        if (newOwner == null) {
            $$$reportNull$$$0(14);
        }
        if (kind == null) {
            $$$reportNull$$$0(15);
        }
        if (annotations == null) {
            $$$reportNull$$$0(16);
        }
        if (source == null) {
            $$$reportNull$$$0(17);
        }
        JavaMethodDescriptor result = new JavaMethodDescriptor(newOwner, (SimpleFunctionDescriptor) original, annotations, newName != null ? newName : getName(), kind, source, this.isForRecordComponent);
        result.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return result;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaMethodDescriptor enhance(KotlinType enhancedReceiverType, List<KotlinType> enhancedValueParameterTypes, KotlinType enhancedReturnType, Pair<CallableDescriptor.UserDataKey<?>, ?> additionalUserData) {
        if (enhancedValueParameterTypes == null) {
            $$$reportNull$$$0(19);
        }
        if (enhancedReturnType == null) {
            $$$reportNull$$$0(20);
        }
        List<ValueParameterDescriptor> enhancedValueParameters = UtilKt.copyValueParameters(enhancedValueParameterTypes, getValueParameters(), this);
        ReceiverParameterDescriptor enhancedReceiver = enhancedReceiverType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(this, enhancedReceiverType, Annotations.Companion.getEMPTY());
        JavaMethodDescriptor enhancedMethod = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(enhancedValueParameters).setReturnType(enhancedReturnType).setExtensionReceiverParameter(enhancedReceiver).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (enhancedMethod == null) {
            throw new AssertionError("null after substitution while enhancing " + this);
        }
        if (additionalUserData != null) {
            enhancedMethod.putInUserDataMap((CallableDescriptor.UserDataKey) additionalUserData.getFirst(), additionalUserData.getSecond());
        }
        if (enhancedMethod == null) {
            $$$reportNull$$$0(21);
        }
        return enhancedMethod;
    }
}