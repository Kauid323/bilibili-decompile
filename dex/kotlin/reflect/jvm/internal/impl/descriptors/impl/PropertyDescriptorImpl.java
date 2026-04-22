package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;

public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    private FieldDescriptor backingField;
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private FieldDescriptor delegateField;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private PropertyGetterDescriptorImpl getter;
    private final boolean isActual;
    private final boolean isConst;
    private final boolean isDelegated;
    private final boolean isExpect;
    private final boolean isExternal;
    private final CallableMemberDescriptor.Kind kind;
    private final boolean lateInit;
    private final Modality modality;
    private final PropertyDescriptor original;
    private Collection<? extends PropertyDescriptor> overriddenProperties;
    private PropertySetterDescriptor setter;
    private boolean setterProjectedOut;
    private List<TypeParameterDescriptor> typeParameters;
    private DescriptorVisibility visibility;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
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
            case 20:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case additional_type_content_opus_VALUE:
            case 35:
                objArr[0] = "kind";
                break;
            case 6:
            case additional_type_content_video_VALUE:
            case 37:
                objArr[0] = "source";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case additional_type_content_comment_VALUE:
                objArr[0] = "inType";
                break;
            case 15:
            case 17:
                objArr[0] = "outType";
                break;
            case 16:
            case 18:
                objArr[0] = "typeParameters";
                break;
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 27:
                objArr[0] = "originalSubstitutor";
                break;
            case 29:
                objArr[0] = "copyConfiguration";
                break;
            case 30:
                objArr[0] = "substitutor";
                break;
            case 31:
                objArr[0] = "accessorDescriptor";
                break;
            case 32:
                objArr[0] = "newOwner";
                break;
            case 33:
                objArr[0] = "newModality";
                break;
            case 34:
                objArr[0] = "newVisibility";
                break;
            case 36:
                objArr[0] = "newName";
                break;
            case 40:
                objArr[0] = "overriddenDescriptors";
                break;
        }
        switch (i) {
            case 21:
                objArr[1] = "getTypeParameters";
                break;
            case 22:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 23:
                objArr[1] = "getReturnType";
                break;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                objArr[1] = "getModality";
                break;
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[1] = "getVisibility";
                break;
            case 26:
                objArr[1] = "getAccessors";
                break;
            case 28:
                objArr[1] = "getSourceToUseForCopy";
                break;
            case 38:
                objArr[1] = "getOriginal";
                break;
            case 39:
                objArr[1] = "getKind";
                break;
            case 41:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 42:
                objArr[1] = "copy";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
                objArr[2] = "create";
                break;
            case additional_type_content_comment_VALUE:
                objArr[2] = "setInType";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "setType";
                break;
            case 20:
                objArr[2] = "setVisibility";
                break;
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
                break;
            case 27:
                objArr[2] = "substitute";
                break;
            case 29:
                objArr[2] = "doSubstitute";
                break;
            case 30:
            case 31:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 40:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 21:
            case 22:
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyDescriptorImpl(DeclarationDescriptor containingDeclaration, PropertyDescriptor original, Annotations annotations, Modality modality, DescriptorVisibility visibility, boolean isVar, Name name, CallableMemberDescriptor.Kind kind, SourceElement source, boolean lateInit, boolean isConst, boolean isExpect, boolean isActual, boolean isExternal, boolean isDelegated) {
        super(containingDeclaration, annotations, name, null, isVar, source);
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
        if (kind == null) {
            $$$reportNull$$$0(5);
        }
        if (source == null) {
            $$$reportNull$$$0(6);
        }
        this.overriddenProperties = null;
        this.contextReceiverParameters = Collections.emptyList();
        this.modality = modality;
        this.visibility = visibility;
        this.original = original == null ? this : original;
        this.kind = kind;
        this.lateInit = lateInit;
        this.isConst = isConst;
        this.isExpect = isExpect;
        this.isActual = isActual;
        this.isExternal = isExternal;
        this.isDelegated = isDelegated;
    }

    public static PropertyDescriptorImpl create(DeclarationDescriptor containingDeclaration, Annotations annotations, Modality modality, DescriptorVisibility visibility, boolean isVar, Name name, CallableMemberDescriptor.Kind kind, SourceElement source, boolean lateInit, boolean isConst, boolean isExpect, boolean isActual, boolean isExternal, boolean isDelegated) {
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
        if (kind == null) {
            $$$reportNull$$$0(12);
        }
        if (source == null) {
            $$$reportNull$$$0(13);
        }
        return new PropertyDescriptorImpl(containingDeclaration, null, annotations, modality, visibility, isVar, name, kind, source, lateInit, isConst, isExpect, isActual, isExternal, isDelegated);
    }

    public void setInType(KotlinType inType) {
        if (inType == null) {
            $$$reportNull$$$0(14);
        }
    }

    public void setType(KotlinType outType, List<? extends TypeParameterDescriptor> typeParameters, ReceiverParameterDescriptor dispatchReceiverParameter, ReceiverParameterDescriptor extensionReceiverParameter, List<ReceiverParameterDescriptor> contextReceiverParameters) {
        if (outType == null) {
            $$$reportNull$$$0(17);
        }
        if (typeParameters == null) {
            $$$reportNull$$$0(18);
        }
        if (contextReceiverParameters == null) {
            $$$reportNull$$$0(19);
        }
        setOutType(outType);
        this.typeParameters = new ArrayList(typeParameters);
        this.extensionReceiverParameter = extensionReceiverParameter;
        this.dispatchReceiverParameter = dispatchReceiverParameter;
        this.contextReceiverParameters = contextReceiverParameters;
    }

    public void initialize(PropertyGetterDescriptorImpl getter, PropertySetterDescriptor setter) {
        initialize(getter, setter, null, null);
    }

    public void initialize(PropertyGetterDescriptorImpl getter, PropertySetterDescriptor setter, FieldDescriptor backingField, FieldDescriptor delegateField) {
        this.getter = getter;
        this.setter = setter;
        this.backingField = backingField;
        this.delegateField = delegateField;
    }

    public void setSetterProjectedOut(boolean setterProjectedOut) {
        this.setterProjectedOut = setterProjectedOut;
    }

    public void setVisibility(DescriptorVisibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(20);
        }
        this.visibility = visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> parameters = this.typeParameters;
        if (parameters == null) {
            throw new IllegalStateException("typeParameters == null for " + this);
        }
        if (parameters == null) {
            $$$reportNull$$$0(21);
        }
        return parameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            $$$reportNull$$$0(22);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type == null) {
            $$$reportNull$$$0(23);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.modality;
        if (modality == null) {
            $$$reportNull$$$0(24);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(25);
        }
        return descriptorVisibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    public boolean isSetterProjectedOut() {
        return this.setterProjectedOut;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.lateInit;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.isConst;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.isDelegated;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public List<PropertyAccessorDescriptor> getAccessors() {
        List<PropertyAccessorDescriptor> result = new ArrayList<>(2);
        if (this.getter != null) {
            result.add(this.getter);
        }
        if (this.setter != null) {
            result.add(this.setter);
        }
        return result;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public PropertyDescriptor substitute(TypeSubstitutor originalSubstitutor) {
        if (originalSubstitutor == null) {
            $$$reportNull$$$0(27);
        }
        if (originalSubstitutor.isEmpty()) {
            return this;
        }
        return newCopyBuilder().setSubstitution(originalSubstitutor.getSubstitution()).setOriginal(getOriginal()).build();
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public class CopyConfiguration {
        private ReceiverParameterDescriptor dispatchReceiverParameter;
        private CallableMemberDescriptor.Kind kind;
        private Modality modality;
        private Name name;
        private DeclarationDescriptor owner;
        private KotlinType returnType;
        private DescriptorVisibility visibility;
        private PropertyDescriptor original = null;
        private boolean preserveSourceElement = false;
        private TypeSubstitution substitution = TypeSubstitution.EMPTY;
        private boolean copyOverrides = true;
        private List<TypeParameterDescriptor> newTypeParameters = null;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case additional_type_content_comment_VALUE:
                case 16:
                case 17:
                case 19:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 4:
                case 6:
                case 8:
                case 10:
                case additional_type_content_opus_VALUE:
                case 15:
                case 18:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case additional_type_content_comment_VALUE:
                case 16:
                case 17:
                case 19:
                    i2 = 2;
                    break;
                case 4:
                case 6:
                case 8:
                case 10:
                case additional_type_content_opus_VALUE:
                case 15:
                case 18:
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case additional_type_content_comment_VALUE:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case additional_type_content_opus_VALUE:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            switch (i) {
                case 1:
                    objArr[1] = "setOwner";
                    break;
                case 2:
                    objArr[1] = "setOriginal";
                    break;
                case 3:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 4:
                case 6:
                case 8:
                case 10:
                case additional_type_content_opus_VALUE:
                case 15:
                case 18:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 5:
                    objArr[1] = "setReturnType";
                    break;
                case 7:
                    objArr[1] = "setModality";
                    break;
                case 9:
                    objArr[1] = "setVisibility";
                    break;
                case 11:
                    objArr[1] = "setKind";
                    break;
                case additional_type_content_video_VALUE:
                    objArr[1] = "setTypeParameters";
                    break;
                case additional_type_content_comment_VALUE:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 16:
                    objArr[1] = "setSubstitution";
                    break;
                case 17:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 19:
                    objArr[1] = "setName";
                    break;
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case additional_type_content_comment_VALUE:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case additional_type_content_opus_VALUE:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case additional_type_content_comment_VALUE:
                case 16:
                case 17:
                case 19:
                    throw new IllegalStateException(format);
                case 4:
                case 6:
                case 8:
                case 10:
                case additional_type_content_opus_VALUE:
                case 15:
                case 18:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        public CopyConfiguration() {
            this.owner = PropertyDescriptorImpl.this.getContainingDeclaration();
            this.modality = PropertyDescriptorImpl.this.getModality();
            this.visibility = PropertyDescriptorImpl.this.getVisibility();
            this.kind = PropertyDescriptorImpl.this.getKind();
            this.dispatchReceiverParameter = PropertyDescriptorImpl.this.dispatchReceiverParameter;
            this.name = PropertyDescriptorImpl.this.getName();
            this.returnType = PropertyDescriptorImpl.this.getType();
        }

        public CopyConfiguration setOwner(DeclarationDescriptor owner) {
            if (owner == null) {
                $$$reportNull$$$0(0);
            }
            this.owner = owner;
            return this;
        }

        public CopyConfiguration setOriginal(CallableMemberDescriptor original) {
            this.original = (PropertyDescriptor) original;
            return this;
        }

        public CopyConfiguration setModality(Modality modality) {
            if (modality == null) {
                $$$reportNull$$$0(6);
            }
            this.modality = modality;
            return this;
        }

        public CopyConfiguration setVisibility(DescriptorVisibility visibility) {
            if (visibility == null) {
                $$$reportNull$$$0(8);
            }
            this.visibility = visibility;
            return this;
        }

        public CopyConfiguration setKind(CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                $$$reportNull$$$0(10);
            }
            this.kind = kind;
            return this;
        }

        public CopyConfiguration setSubstitution(TypeSubstitution substitution) {
            if (substitution == null) {
                $$$reportNull$$$0(15);
            }
            this.substitution = substitution;
            return this;
        }

        public CopyConfiguration setCopyOverrides(boolean copyOverrides) {
            this.copyOverrides = copyOverrides;
            return this;
        }

        public PropertyDescriptor build() {
            return PropertyDescriptorImpl.this.doSubstitute(this);
        }

        PropertyGetterDescriptor getOriginalGetter() {
            if (this.original == null) {
                return null;
            }
            return this.original.getGetter();
        }

        PropertySetterDescriptor getOriginalSetter() {
            if (this.original == null) {
                return null;
            }
            return this.original.getSetter();
        }
    }

    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration();
    }

    private SourceElement getSourceToUseForCopy(boolean preserveSource, PropertyDescriptor original) {
        SourceElement sourceElement;
        if (preserveSource) {
            sourceElement = (original != null ? original : getOriginal()).getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(28);
        }
        return sourceElement;
    }

    protected PropertyDescriptor doSubstitute(CopyConfiguration copyConfiguration) {
        ReceiverParameterDescriptor substitutedDispatchReceiver;
        ReceiverParameterDescriptor substitutedExtensionReceiver;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        PropertyGetterDescriptorImpl newGetter;
        if (copyConfiguration == null) {
            $$$reportNull$$$0(29);
        }
        PropertyDescriptorImpl substitutedDescriptor = createSubstitutedCopy(copyConfiguration.owner, copyConfiguration.modality, copyConfiguration.visibility, copyConfiguration.original, copyConfiguration.kind, copyConfiguration.name, getSourceToUseForCopy(copyConfiguration.preserveSourceElement, copyConfiguration.original));
        List<TypeParameterDescriptor> originalTypeParameters = copyConfiguration.newTypeParameters == null ? getTypeParameters() : copyConfiguration.newTypeParameters;
        List<TypeParameterDescriptor> substitutedTypeParameters = new ArrayList<>(originalTypeParameters.size());
        TypeSubstitutor substitutor = DescriptorSubstitutor.substituteTypeParameters(originalTypeParameters, copyConfiguration.substitution, substitutedDescriptor, substitutedTypeParameters);
        KotlinType originalOutType = copyConfiguration.returnType;
        KotlinType outType = substitutor.substitute(originalOutType, Variance.OUT_VARIANCE);
        if (outType == null) {
            return null;
        }
        KotlinType inType = substitutor.substitute(originalOutType, Variance.IN_VARIANCE);
        if (inType != null) {
            substitutedDescriptor.setInType(inType);
        }
        ReceiverParameterDescriptor dispatchReceiver = copyConfiguration.dispatchReceiverParameter;
        if (dispatchReceiver != null) {
            ReceiverParameterDescriptor substitutedDispatchReceiver2 = dispatchReceiver.substitute(substitutor);
            if (substitutedDispatchReceiver2 == null) {
                return null;
            }
            substitutedDispatchReceiver = substitutedDispatchReceiver2;
        } else {
            substitutedDispatchReceiver = null;
        }
        if (this.extensionReceiverParameter != null) {
            substitutedExtensionReceiver = substituteParameterDescriptor(substitutor, substitutedDescriptor, this.extensionReceiverParameter);
        } else {
            substitutedExtensionReceiver = null;
        }
        List<ReceiverParameterDescriptor> substitutedContextReceivers = new ArrayList<>();
        for (ReceiverParameterDescriptor contextReceiverParameter : this.contextReceiverParameters) {
            ReceiverParameterDescriptor substitutedContextReceiver = substituteContextParameterDescriptor(substitutor, substitutedDescriptor, contextReceiverParameter);
            if (substitutedContextReceiver != null) {
                substitutedContextReceivers.add(substitutedContextReceiver);
            }
        }
        substitutedDescriptor.setType(outType, substitutedTypeParameters, substitutedDispatchReceiver, substitutedExtensionReceiver, substitutedContextReceivers);
        if (this.getter == null) {
            propertyGetterDescriptorImpl = null;
        } else {
            propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(substitutedDescriptor, this.getter.getAnnotations(), copyConfiguration.modality, normalizeVisibility(this.getter.getVisibility(), copyConfiguration.kind), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalGetter(), SourceElement.NO_SOURCE);
        }
        PropertyGetterDescriptorImpl newGetter2 = propertyGetterDescriptorImpl;
        if (newGetter2 != null) {
            KotlinType returnType = this.getter.getReturnType();
            newGetter2.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(substitutor, this.getter));
            newGetter2.initialize(returnType != null ? substitutor.substitute(returnType, Variance.OUT_VARIANCE) : null);
        }
        if (this.setter == null) {
            propertySetterDescriptorImpl = null;
            newGetter = newGetter2;
        } else {
            newGetter = newGetter2;
            propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(substitutedDescriptor, this.setter.getAnnotations(), copyConfiguration.modality, normalizeVisibility(this.setter.getVisibility(), copyConfiguration.kind), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalSetter(), SourceElement.NO_SOURCE);
        }
        PropertySetterDescriptorImpl newSetter = propertySetterDescriptorImpl;
        if (newSetter != null) {
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(newSetter, this.setter.getValueParameters(), substitutor, false, false, null);
            if (substitutedValueParameters == null) {
                substitutedDescriptor.setSetterProjectedOut(true);
                substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(newSetter, DescriptorUtilsKt.getBuiltIns(copyConfiguration.owner).getNothingType(), this.setter.getValueParameters().get(0).getAnnotations()));
            }
            if (substitutedValueParameters.size() != 1) {
                throw new IllegalStateException();
            }
            newSetter.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(substitutor, this.setter));
            newSetter.initialize(substitutedValueParameters.get(0));
        }
        substitutedDescriptor.initialize(newGetter, newSetter, this.backingField == null ? null : new FieldDescriptorImpl(this.backingField.getAnnotations(), substitutedDescriptor), this.delegateField == null ? null : new FieldDescriptorImpl(this.delegateField.getAnnotations(), substitutedDescriptor));
        if (copyConfiguration.copyOverrides) {
            Collection<CallableMemberDescriptor> overridden = SmartSet.create();
            for (PropertyDescriptor propertyDescriptor : getOverriddenDescriptors()) {
                overridden.add(propertyDescriptor.substitute(substitutor));
            }
            substitutedDescriptor.setOverriddenDescriptors(overridden);
        }
        if (isConst() && this.compileTimeInitializerFactory != null) {
            substitutedDescriptor.setCompileTimeInitializer(this.compileTimeInitializer, this.compileTimeInitializerFactory);
        }
        return substitutedDescriptor;
    }

    private static DescriptorVisibility normalizeVisibility(DescriptorVisibility prev, CallableMemberDescriptor.Kind kind) {
        if (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && DescriptorVisibilities.isPrivate(prev.normalize())) {
            return DescriptorVisibilities.INVISIBLE_FAKE;
        }
        return prev;
    }

    private static ReceiverParameterDescriptor substituteParameterDescriptor(TypeSubstitutor substitutor, PropertyDescriptor substitutedPropertyDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor) {
        KotlinType substitutedType = substitutor.substitute(receiverParameterDescriptor.getType(), Variance.IN_VARIANCE);
        if (substitutedType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(substitutedPropertyDescriptor, new ExtensionReceiver(substitutedPropertyDescriptor, substitutedType, receiverParameterDescriptor.getValue()), receiverParameterDescriptor.getAnnotations());
    }

    private static ReceiverParameterDescriptor substituteContextParameterDescriptor(TypeSubstitutor substitutor, PropertyDescriptor substitutedPropertyDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor) {
        KotlinType substitutedType = substitutor.substitute(receiverParameterDescriptor.getType(), Variance.IN_VARIANCE);
        if (substitutedType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(substitutedPropertyDescriptor, new ContextReceiver(substitutedPropertyDescriptor, substitutedType, ((ImplicitContextReceiver) receiverParameterDescriptor.getValue()).getCustomLabelName(), receiverParameterDescriptor.getValue()), receiverParameterDescriptor.getAnnotations());
    }

    private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(TypeSubstitutor substitutor, PropertyAccessorDescriptor accessorDescriptor) {
        if (substitutor == null) {
            $$$reportNull$$$0(30);
        }
        if (accessorDescriptor == null) {
            $$$reportNull$$$0(31);
        }
        if (accessorDescriptor.getInitialSignatureDescriptor() != null) {
            return accessorDescriptor.getInitialSignatureDescriptor().substitute(substitutor);
        }
        return null;
    }

    protected PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor newOwner, Modality newModality, DescriptorVisibility newVisibility, PropertyDescriptor original, CallableMemberDescriptor.Kind kind, Name newName, SourceElement source) {
        if (newOwner == null) {
            $$$reportNull$$$0(32);
        }
        if (newModality == null) {
            $$$reportNull$$$0(33);
        }
        if (newVisibility == null) {
            $$$reportNull$$$0(34);
        }
        if (kind == null) {
            $$$reportNull$$$0(35);
        }
        if (newName == null) {
            $$$reportNull$$$0(36);
        }
        if (source == null) {
            $$$reportNull$$$0(37);
        }
        return new PropertyDescriptorImpl(newOwner, original, getAnnotations(), newModality, newVisibility, isVar(), newName, kind, source, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor, D data) {
        return visitor.visitPropertyDescriptor(this, data);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor original = this.original == this ? this : this.original.getOriginal();
        if (original == null) {
            $$$reportNull$$$0(38);
        }
        return original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            $$$reportNull$$$0(39);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getBackingField() {
        return this.backingField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getDelegateField() {
        return this.delegateField;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == 0) {
            $$$reportNull$$$0(40);
        }
        this.overriddenProperties = overriddenDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> emptyList = this.overriddenProperties != null ? this.overriddenProperties : Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(41);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public PropertyDescriptor copy(DeclarationDescriptor newOwner, Modality modality, DescriptorVisibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        PropertyDescriptor build = newCopyBuilder().setOwner(newOwner).setOriginal(null).setModality(modality).setVisibility(visibility).setKind(kind).setCopyOverrides(copyOverrides).build();
        if (build == null) {
            $$$reportNull$$$0(42);
        }
        return build;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> key) {
        return null;
    }
}