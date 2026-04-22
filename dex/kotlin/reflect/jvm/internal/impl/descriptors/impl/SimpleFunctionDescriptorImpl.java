package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;

public class SimpleFunctionDescriptorImpl extends FunctionDescriptorImpl implements SimpleFunctionDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case additional_type_content_video_VALUE:
            case 18:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case 29:
            case 30:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case additional_type_content_video_VALUE:
            case 18:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case 29:
            case 30:
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
            case 27:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 26:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 28:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case 21:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case additional_type_content_opus_VALUE:
            case 17:
            case 22:
                objArr[0] = "visibility";
                break;
            case additional_type_content_video_VALUE:
            case 18:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case 29:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case additional_type_content_comment_VALUE:
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[0] = "newOwner";
                break;
        }
        switch (i) {
            case additional_type_content_video_VALUE:
            case 18:
            case 23:
                objArr[1] = "initialize";
                break;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                objArr[1] = "getOriginal";
                break;
            case 29:
                objArr[1] = "copy";
                break;
            case 30:
                objArr[1] = "newCopyBuilder";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "initialize";
                break;
            case additional_type_content_video_VALUE:
            case 18:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case 29:
            case 30:
                break;
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 27:
            case 28:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case additional_type_content_video_VALUE:
            case 18:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case 29:
            case 30:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List list, List list2, List list3, KotlinType kotlinType, Modality modality, DescriptorVisibility descriptorVisibility) {
        return initialize(receiverParameterDescriptor, receiverParameterDescriptor2, (List<ReceiverParameterDescriptor>) list, (List<? extends TypeParameterDescriptor>) list2, (List<ValueParameterDescriptor>) list3, kotlinType, modality, descriptorVisibility);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleFunctionDescriptorImpl(DeclarationDescriptor containingDeclaration, SimpleFunctionDescriptor original, Annotations annotations, Name name, CallableMemberDescriptor.Kind kind, SourceElement source) {
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
    }

    public static SimpleFunctionDescriptorImpl create(DeclarationDescriptor containingDeclaration, Annotations annotations, Name name, CallableMemberDescriptor.Kind kind, SourceElement source) {
        if (containingDeclaration == null) {
            $$$reportNull$$$0(5);
        }
        if (annotations == null) {
            $$$reportNull$$$0(6);
        }
        if (name == null) {
            $$$reportNull$$$0(7);
        }
        if (kind == null) {
            $$$reportNull$$$0(8);
        }
        if (source == null) {
            $$$reportNull$$$0(9);
        }
        return new SimpleFunctionDescriptorImpl(containingDeclaration, null, annotations, name, kind, source);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor extensionReceiverParameter, ReceiverParameterDescriptor dispatchReceiverParameter, List<ReceiverParameterDescriptor> contextReceiverParameters, List<? extends TypeParameterDescriptor> typeParameters, List<ValueParameterDescriptor> unsubstitutedValueParameters, KotlinType unsubstitutedReturnType, Modality modality, DescriptorVisibility visibility) {
        if (contextReceiverParameters == null) {
            $$$reportNull$$$0(14);
        }
        if (typeParameters == null) {
            $$$reportNull$$$0(15);
        }
        if (unsubstitutedValueParameters == null) {
            $$$reportNull$$$0(16);
        }
        if (visibility == null) {
            $$$reportNull$$$0(17);
        }
        SimpleFunctionDescriptorImpl initialize = initialize(extensionReceiverParameter, dispatchReceiverParameter, contextReceiverParameters, typeParameters, unsubstitutedValueParameters, unsubstitutedReturnType, modality, visibility, null);
        if (initialize == null) {
            $$$reportNull$$$0(18);
        }
        return initialize;
    }

    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor extensionReceiverParameter, ReceiverParameterDescriptor dispatchReceiverParameter, List<ReceiverParameterDescriptor> contextReceiverParameters, List<? extends TypeParameterDescriptor> typeParameters, List<ValueParameterDescriptor> unsubstitutedValueParameters, KotlinType unsubstitutedReturnType, Modality modality, DescriptorVisibility visibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> userData) {
        if (contextReceiverParameters == null) {
            $$$reportNull$$$0(19);
        }
        if (typeParameters == null) {
            $$$reportNull$$$0(20);
        }
        if (unsubstitutedValueParameters == null) {
            $$$reportNull$$$0(21);
        }
        if (visibility == null) {
            $$$reportNull$$$0(22);
        }
        super.initialize(extensionReceiverParameter, dispatchReceiverParameter, contextReceiverParameters, typeParameters, unsubstitutedValueParameters, unsubstitutedReturnType, modality, visibility);
        if (userData != null && !userData.isEmpty()) {
            this.userDataMap = new LinkedHashMap(userData);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public SimpleFunctionDescriptor getOriginal() {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) super.getOriginal();
        if (simpleFunctionDescriptor == null) {
            $$$reportNull$$$0(24);
        }
        return simpleFunctionDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor newOwner, FunctionDescriptor original, CallableMemberDescriptor.Kind kind, Name newName, Annotations annotations, SourceElement source) {
        if (newOwner == null) {
            $$$reportNull$$$0(25);
        }
        if (kind == null) {
            $$$reportNull$$$0(26);
        }
        if (annotations == null) {
            $$$reportNull$$$0(27);
        }
        if (source == null) {
            $$$reportNull$$$0(28);
        }
        return new SimpleFunctionDescriptorImpl(newOwner, (SimpleFunctionDescriptor) original, annotations, newName != null ? newName : getName(), kind, source);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public SimpleFunctionDescriptor copy(DeclarationDescriptor newOwner, Modality modality, DescriptorVisibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) super.copy(newOwner, modality, visibility, kind, copyOverrides);
        if (simpleFunctionDescriptor == null) {
            $$$reportNull$$$0(29);
        }
        return simpleFunctionDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        FunctionDescriptor.CopyBuilder newCopyBuilder = super.newCopyBuilder();
        if (newCopyBuilder == null) {
            $$$reportNull$$$0(30);
        }
        return newCopyBuilder;
    }
}