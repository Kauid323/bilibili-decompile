package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;

public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private boolean hasStableParameterNames;
    private boolean hasSynthesizedParameterNames;
    private FunctionDescriptor initialSignatureDescriptor;
    private boolean isActual;
    private boolean isExpect;
    private boolean isExternal;
    private boolean isHiddenForResolutionEverywhereBesideSupercalls;
    private boolean isHiddenToOvercomeSignatureClash;
    private boolean isInfix;
    private boolean isInline;
    private boolean isOperator;
    private boolean isSuspend;
    private boolean isTailrec;
    private final CallableMemberDescriptor.Kind kind;
    private volatile Function0<Collection<FunctionDescriptor>> lazyOverriddenFunctionsTask;
    private Modality modality;
    private final FunctionDescriptor original;
    private Collection<? extends FunctionDescriptor> overriddenFunctions;
    private List<TypeParameterDescriptor> typeParameters;
    private KotlinType unsubstitutedReturnType;
    private List<ValueParameterDescriptor> unsubstitutedValueParameters;
    protected Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;
    private DescriptorVisibility visibility;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 9:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
            case 17:
            case 22:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i2 = 2;
                break;
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
            case 17:
            case 22:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case additional_type_content_opus_VALUE:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
            case 17:
            case 22:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case additional_type_content_video_VALUE:
                objArr[1] = "getContextReceiverParameters";
                break;
            case additional_type_content_comment_VALUE:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case additional_type_content_opus_VALUE:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                objArr[2] = "newCopyBuilder";
                break;
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 9:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new IllegalStateException(format);
            case 10:
            case 11:
            case additional_type_content_opus_VALUE:
            case 17:
            case 22:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    protected abstract FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionDescriptorImpl(DeclarationDescriptor containingDeclaration, FunctionDescriptor original, Annotations annotations, Name name, CallableMemberDescriptor.Kind kind, SourceElement source) {
        super(containingDeclaration, annotations, name, source);
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
        this.visibility = DescriptorVisibilities.UNKNOWN;
        this.isOperator = false;
        this.isInfix = false;
        this.isExternal = false;
        this.isInline = false;
        this.isTailrec = false;
        this.isExpect = false;
        this.isActual = false;
        this.isHiddenToOvercomeSignatureClash = false;
        this.isHiddenForResolutionEverywhereBesideSupercalls = false;
        this.isSuspend = false;
        this.hasStableParameterNames = true;
        this.hasSynthesizedParameterNames = false;
        this.overriddenFunctions = null;
        this.lazyOverriddenFunctionsTask = null;
        this.initialSignatureDescriptor = null;
        this.userDataMap = null;
        this.original = original == null ? this : original;
        this.kind = kind;
    }

    public FunctionDescriptorImpl initialize(ReceiverParameterDescriptor extensionReceiverParameter, ReceiverParameterDescriptor dispatchReceiverParameter, List<ReceiverParameterDescriptor> contextReceiverParameters, List<? extends TypeParameterDescriptor> typeParameters, List<ValueParameterDescriptor> unsubstitutedValueParameters, KotlinType unsubstitutedReturnType, Modality modality, DescriptorVisibility visibility) {
        if (contextReceiverParameters == null) {
            $$$reportNull$$$0(5);
        }
        if (typeParameters == null) {
            $$$reportNull$$$0(6);
        }
        if (unsubstitutedValueParameters == null) {
            $$$reportNull$$$0(7);
        }
        if (visibility == null) {
            $$$reportNull$$$0(8);
        }
        this.typeParameters = CollectionsKt.toList(typeParameters);
        this.unsubstitutedValueParameters = CollectionsKt.toList(unsubstitutedValueParameters);
        this.unsubstitutedReturnType = unsubstitutedReturnType;
        this.modality = modality;
        this.visibility = visibility;
        this.extensionReceiverParameter = extensionReceiverParameter;
        this.dispatchReceiverParameter = dispatchReceiverParameter;
        this.contextReceiverParameters = contextReceiverParameters;
        for (int i = 0; i < typeParameters.size(); i++) {
            TypeParameterDescriptor typeParameterDescriptor = typeParameters.get(i);
            if (typeParameterDescriptor.getIndex() != i) {
                throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i);
            }
        }
        for (int i2 = 0; i2 < unsubstitutedValueParameters.size(); i2++) {
            ValueParameterDescriptor valueParameterDescriptor = unsubstitutedValueParameters.get(i2);
            if (valueParameterDescriptor.getIndex() != i2 + 0) {
                throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i2);
            }
        }
        return this;
    }

    public void setVisibility(DescriptorVisibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(10);
        }
        this.visibility = visibility;
    }

    public void setOperator(boolean isOperator) {
        this.isOperator = isOperator;
    }

    public void setInfix(boolean isInfix) {
        this.isInfix = isInfix;
    }

    public void setExternal(boolean isExternal) {
        this.isExternal = isExternal;
    }

    public void setInline(boolean isInline) {
        this.isInline = isInline;
    }

    public void setTailrec(boolean isTailrec) {
        this.isTailrec = isTailrec;
    }

    public void setExpect(boolean isExpect) {
        this.isExpect = isExpect;
    }

    public void setActual(boolean isActual) {
        this.isActual = isActual;
    }

    private void setHiddenToOvercomeSignatureClash(boolean hiddenToOvercomeSignatureClash) {
        this.isHiddenToOvercomeSignatureClash = hiddenToOvercomeSignatureClash;
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean hiddenForResolutionEverywhereBesideSupercalls) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = hiddenForResolutionEverywhereBesideSupercalls;
    }

    public void setSuspend(boolean suspend) {
        this.isSuspend = suspend;
    }

    public void setReturnType(KotlinType unsubstitutedReturnType) {
        if (unsubstitutedReturnType == null) {
            $$$reportNull$$$0(11);
        }
        this.unsubstitutedReturnType = unsubstitutedReturnType;
    }

    public void setHasStableParameterNames(boolean hasStableParameterNames) {
        this.hasStableParameterNames = hasStableParameterNames;
    }

    public void setHasSynthesizedParameterNames(boolean hasSynthesizedParameterNames) {
        this.hasSynthesizedParameterNames = hasSynthesizedParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            $$$reportNull$$$0(13);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        performOverriddenLazyCalculationIfNeeded();
        Collection<? extends FunctionDescriptor> emptyList = this.overriddenFunctions != null ? this.overriddenFunctions : Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(14);
        }
        return emptyList;
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        Function0<Collection<FunctionDescriptor>> overriddenTask = this.lazyOverriddenFunctionsTask;
        if (overriddenTask != null) {
            this.overriddenFunctions = overriddenTask.invoke();
            this.lazyOverriddenFunctionsTask = null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.modality;
        if (modality == null) {
            $$$reportNull$$$0(15);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(16);
        }
        return descriptorVisibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        if (this.isOperator) {
            return true;
        }
        for (FunctionDescriptor descriptor : getOriginal().getOverriddenDescriptors()) {
            if (descriptor.isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        if (this.isInfix) {
            return true;
        }
        for (FunctionDescriptor descriptor : getOriginal().getOverriddenDescriptors()) {
            if (descriptor.isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isInline() {
        return this.isInline;
    }

    public boolean isTailrec() {
        return this.isTailrec;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return this.isSuspend;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> key) {
        if (this.userDataMap == null) {
            return null;
        }
        return (V) this.userDataMap.get(key);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == 0) {
            $$$reportNull$$$0(17);
        }
        this.overriddenFunctions = overriddenDescriptors;
        for (FunctionDescriptor function : this.overriddenFunctions) {
            if (function.isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.isHiddenForResolutionEverywhereBesideSupercalls = true;
                return;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> parameters = this.typeParameters;
        if (parameters == null) {
            throw new IllegalStateException("typeParameters == null for " + this);
        }
        if (parameters == null) {
            $$$reportNull$$$0(18);
        }
        return parameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.unsubstitutedValueParameters;
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        return list;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor original = this.original == this ? this : this.original.getOriginal();
        if (original == null) {
            $$$reportNull$$$0(20);
        }
        return original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            $$$reportNull$$$0(21);
        }
        return kind;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration] */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public FunctionDescriptor substitute(TypeSubstitutor originalSubstitutor) {
        if (originalSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        if (originalSubstitutor.isEmpty()) {
            return this;
        }
        return newCopyBuilder(originalSubstitutor).setOriginal((CallableMemberDescriptor) getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public class CopyConfiguration implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        private Annotations additionalAnnotations;
        protected boolean copyOverrides;
        protected ReceiverParameterDescriptor dispatchReceiverParameter;
        protected boolean dropOriginalInContainingParts;
        private boolean isHiddenForResolutionEverywhereBesideSupercalls;
        private boolean isHiddenToOvercomeSignatureClash;
        protected boolean justForTypeSubstitution;
        protected CallableMemberDescriptor.Kind kind;
        protected Name name;
        protected List<ReceiverParameterDescriptor> newContextReceiverParameters;
        protected ReceiverParameterDescriptor newExtensionReceiverParameter;
        private Boolean newHasSynthesizedParameterNames;
        protected Modality newModality;
        protected DeclarationDescriptor newOwner;
        protected KotlinType newReturnType;
        private List<TypeParameterDescriptor> newTypeParameters;
        protected List<ValueParameterDescriptor> newValueParameterDescriptors;
        protected DescriptorVisibility newVisibility;
        protected FunctionDescriptor original;
        protected boolean preserveSourceElement;
        protected boolean signatureChange;
        protected TypeSubstitution substitution;
        final /* synthetic */ FunctionDescriptorImpl this$0;
        private Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 10:
                case additional_type_content_opus_VALUE:
                case additional_type_content_comment_VALUE:
                case 17:
                case 19:
                case 21:
                case 23:
                case LeaksDbHelper.VERSION /* 25 */:
                case 35:
                case 37:
                case 39:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    i2 = 2;
                    break;
                case 10:
                case additional_type_content_opus_VALUE:
                case additional_type_content_comment_VALUE:
                case 17:
                case 19:
                case 21:
                case 23:
                case LeaksDbHelper.VERSION /* 25 */:
                case 35:
                case 37:
                case 39:
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case additional_type_content_comment_VALUE:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case additional_type_content_opus_VALUE:
                    objArr[0] = "visibility";
                    break;
                case 17:
                    objArr[0] = "name";
                    break;
                case 19:
                case 21:
                    objArr[0] = "parameters";
                    break;
                case 23:
                    objArr[0] = "type";
                    break;
                case LeaksDbHelper.VERSION /* 25 */:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case 35:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 37:
                default:
                    objArr[0] = "substitution";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                case additional_type_content_opus_VALUE:
                case additional_type_content_comment_VALUE:
                case 17:
                case 19:
                case 21:
                case 23:
                case LeaksDbHelper.VERSION /* 25 */:
                case 35:
                case 37:
                case 39:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case additional_type_content_video_VALUE:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 18:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case 22:
                    objArr[1] = "setTypeParameters";
                    break;
                case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                    objArr[1] = "setReturnType";
                    break;
                case 26:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case 27:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 28:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 29:
                    objArr[1] = "setOriginal";
                    break;
                case 30:
                    objArr[1] = "setSignatureChange";
                    break;
                case 31:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 33:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 34:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 36:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case additional_type_content_opus_VALUE:
                    objArr[2] = "setVisibility";
                    break;
                case additional_type_content_comment_VALUE:
                    objArr[2] = "setKind";
                    break;
                case 17:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case 21:
                    objArr[2] = "setTypeParameters";
                    break;
                case 23:
                    objArr[2] = "setReturnType";
                    break;
                case LeaksDbHelper.VERSION /* 25 */:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case 35:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 9:
                case 11:
                case additional_type_content_video_VALUE:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    throw new IllegalStateException(format);
                case 10:
                case additional_type_content_opus_VALUE:
                case additional_type_content_comment_VALUE:
                case 17:
                case 19:
                case 21:
                case 23:
                case LeaksDbHelper.VERSION /* 25 */:
                case 35:
                case 37:
                case 39:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder<FunctionDescriptor> setTypeParameters(List list) {
            return setTypeParameters2((List<TypeParameterDescriptor>) list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder<FunctionDescriptor> setValueParameters(List list) {
            return setValueParameters2((List<ValueParameterDescriptor>) list);
        }

        public CopyConfiguration(FunctionDescriptorImpl this$0, TypeSubstitution substitution, DeclarationDescriptor newOwner, Modality newModality, DescriptorVisibility newVisibility, CallableMemberDescriptor.Kind kind, List<ValueParameterDescriptor> newValueParameterDescriptors, List<ReceiverParameterDescriptor> newContextReceiverParameters, ReceiverParameterDescriptor newExtensionReceiverParameter, KotlinType newReturnType, Name name) {
            if (substitution == null) {
                $$$reportNull$$$0(0);
            }
            if (newOwner == null) {
                $$$reportNull$$$0(1);
            }
            if (newModality == null) {
                $$$reportNull$$$0(2);
            }
            if (newVisibility == null) {
                $$$reportNull$$$0(3);
            }
            if (kind == null) {
                $$$reportNull$$$0(4);
            }
            if (newValueParameterDescriptors == null) {
                $$$reportNull$$$0(5);
            }
            if (newContextReceiverParameters == null) {
                $$$reportNull$$$0(6);
            }
            if (newReturnType == null) {
                $$$reportNull$$$0(7);
            }
            this.this$0 = this$0;
            this.original = null;
            this.dispatchReceiverParameter = this.this$0.dispatchReceiverParameter;
            this.copyOverrides = true;
            this.signatureChange = false;
            this.preserveSourceElement = false;
            this.dropOriginalInContainingParts = false;
            this.isHiddenToOvercomeSignatureClash = this.this$0.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = this.this$0.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.justForTypeSubstitution = false;
            this.substitution = substitution;
            this.newOwner = newOwner;
            this.newModality = newModality;
            this.newVisibility = newVisibility;
            this.kind = kind;
            this.newValueParameterDescriptors = newValueParameterDescriptors;
            this.newContextReceiverParameters = newContextReceiverParameters;
            this.newExtensionReceiverParameter = newExtensionReceiverParameter;
            this.newReturnType = newReturnType;
            this.name = name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setOwner(DeclarationDescriptor owner) {
            if (owner == null) {
                $$$reportNull$$$0(8);
            }
            this.newOwner = owner;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setModality(Modality modality) {
            if (modality == null) {
                $$$reportNull$$$0(10);
            }
            this.newModality = modality;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setVisibility(DescriptorVisibility visibility) {
            if (visibility == null) {
                $$$reportNull$$$0(12);
            }
            this.newVisibility = visibility;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setKind(CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                $$$reportNull$$$0(14);
            }
            this.kind = kind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setCopyOverrides(boolean copyOverrides) {
            this.copyOverrides = copyOverrides;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setName(Name name) {
            if (name == null) {
                $$$reportNull$$$0(17);
            }
            this.name = name;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        /* renamed from: setValueParameters  reason: avoid collision after fix types in other method */
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setValueParameters2(List<ValueParameterDescriptor> parameters) {
            if (parameters == null) {
                $$$reportNull$$$0(19);
            }
            this.newValueParameterDescriptors = parameters;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        /* renamed from: setTypeParameters  reason: avoid collision after fix types in other method */
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setTypeParameters2(List<TypeParameterDescriptor> parameters) {
            if (parameters == null) {
                $$$reportNull$$$0(21);
            }
            this.newTypeParameters = parameters;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setReturnType(KotlinType type) {
            if (type == null) {
                $$$reportNull$$$0(23);
            }
            this.newReturnType = type;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setExtensionReceiverParameter(ReceiverParameterDescriptor extensionReceiverParameter) {
            this.newExtensionReceiverParameter = extensionReceiverParameter;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setDispatchReceiverParameter(ReceiverParameterDescriptor dispatchReceiverParameter) {
            this.dispatchReceiverParameter = dispatchReceiverParameter;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setOriginal(CallableMemberDescriptor original) {
            this.original = (FunctionDescriptor) original;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setSignatureChange() {
            this.signatureChange = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setPreserveSourceElement() {
            this.preserveSourceElement = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setAdditionalAnnotations(Annotations additionalAnnotations) {
            if (additionalAnnotations == null) {
                $$$reportNull$$$0(35);
            }
            this.additionalAnnotations = additionalAnnotations;
            return this;
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean value) {
            this.newHasSynthesizedParameterNames = Boolean.valueOf(value);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setSubstitution(TypeSubstitution substitution) {
            if (substitution == null) {
                $$$reportNull$$$0(37);
            }
            this.substitution = substitution;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public <V> FunctionDescriptor.CopyBuilder<FunctionDescriptor> putUserData(CallableDescriptor.UserDataKey<V> userDataKey, V value) {
            if (userDataKey == null) {
                $$$reportNull$$$0(39);
            }
            this.userDataMap.put(userDataKey, value);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        public CopyConfiguration setJustForTypeSubstitution(boolean value) {
            this.justForTypeSubstitution = value;
            return this;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (newCopyBuilder == null) {
            $$$reportNull$$$0(23);
        }
        return newCopyBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CopyConfiguration newCopyBuilder(TypeSubstitutor substitutor) {
        if (substitutor == null) {
            $$$reportNull$$$0(24);
        }
        return new CopyConfiguration(this, substitutor.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getContextReceiverParameters(), getExtensionReceiverParameter(), getReturnType(), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FunctionDescriptor doSubstitute(CopyConfiguration configuration) {
        Annotations resultAnnotations;
        KotlinType substitutedReturnType;
        if (configuration == null) {
            $$$reportNull$$$0(25);
        }
        boolean[] wereChanges = new boolean[1];
        if (configuration.additionalAnnotations != null) {
            resultAnnotations = AnnotationsKt.composeAnnotations(getAnnotations(), configuration.additionalAnnotations);
        } else {
            resultAnnotations = getAnnotations();
        }
        FunctionDescriptorImpl substitutedDescriptor = createSubstitutedCopy(configuration.newOwner, configuration.original, configuration.kind, configuration.name, resultAnnotations, getSourceToUseForCopy(configuration.preserveSourceElement, configuration.original));
        List<TypeParameterDescriptor> unsubstitutedTypeParameters = configuration.newTypeParameters == null ? getTypeParameters() : configuration.newTypeParameters;
        wereChanges[0] = wereChanges[0] | (!unsubstitutedTypeParameters.isEmpty());
        List<TypeParameterDescriptor> substitutedTypeParameters = new ArrayList<>(unsubstitutedTypeParameters.size());
        final TypeSubstitutor substitutor = DescriptorSubstitutor.substituteTypeParameters(unsubstitutedTypeParameters, configuration.substitution, substitutedDescriptor, substitutedTypeParameters, wereChanges);
        FunctionDescriptor functionDescriptor = null;
        if (substitutor == null) {
            return null;
        }
        List<ReceiverParameterDescriptor> substitutedContextReceiverParameters = new ArrayList<>();
        if (!configuration.newContextReceiverParameters.isEmpty()) {
            int index = 0;
            for (ReceiverParameterDescriptor newContextReceiverParameter : configuration.newContextReceiverParameters) {
                KotlinType substitutedContextReceiverType = substitutor.substitute(newContextReceiverParameter.getType(), Variance.IN_VARIANCE);
                if (substitutedContextReceiverType == null) {
                    return functionDescriptor;
                }
                int index2 = index + 1;
                ReceiverParameterDescriptor substitutedContextReceiverParameter = DescriptorFactory.createContextReceiverParameterForCallable(substitutedDescriptor, substitutedContextReceiverType, ((ImplicitContextReceiver) newContextReceiverParameter.getValue()).getCustomLabelName(), newContextReceiverParameter.getAnnotations(), index);
                substitutedContextReceiverParameters.add(substitutedContextReceiverParameter);
                wereChanges[0] = wereChanges[0] | (substitutedContextReceiverType != newContextReceiverParameter.getType());
                index = index2;
                functionDescriptor = null;
            }
        }
        ReceiverParameterDescriptor substitutedReceiverParameter = null;
        if (configuration.newExtensionReceiverParameter != null) {
            KotlinType substitutedExtensionReceiverType = substitutor.substitute(configuration.newExtensionReceiverParameter.getType(), Variance.IN_VARIANCE);
            if (substitutedExtensionReceiverType == null) {
                return null;
            }
            substitutedReceiverParameter = new ReceiverParameterDescriptorImpl(substitutedDescriptor, new ExtensionReceiver(substitutedDescriptor, substitutedExtensionReceiverType, configuration.newExtensionReceiverParameter.getValue()), configuration.newExtensionReceiverParameter.getAnnotations());
            wereChanges[0] = wereChanges[0] | (substitutedExtensionReceiverType != configuration.newExtensionReceiverParameter.getType());
        }
        ReceiverParameterDescriptor substitutedExpectedThis = null;
        if (configuration.dispatchReceiverParameter != null) {
            substitutedExpectedThis = configuration.dispatchReceiverParameter.substitute(substitutor);
            if (substitutedExpectedThis != null) {
                wereChanges[0] = wereChanges[0] | (substitutedExpectedThis != configuration.dispatchReceiverParameter);
            } else {
                return null;
            }
        }
        List<ValueParameterDescriptor> substitutedValueParameters = getSubstitutedValueParameters(substitutedDescriptor, configuration.newValueParameterDescriptors, substitutor, configuration.dropOriginalInContainingParts, configuration.preserveSourceElement, wereChanges);
        if (substitutedValueParameters != null && (substitutedReturnType = substitutor.substitute(configuration.newReturnType, Variance.OUT_VARIANCE)) != null) {
            wereChanges[0] = wereChanges[0] | (substitutedReturnType != configuration.newReturnType);
            if (wereChanges[0] || !configuration.justForTypeSubstitution) {
                substitutedDescriptor.initialize(substitutedReceiverParameter, substitutedExpectedThis, substitutedContextReceiverParameters, substitutedTypeParameters, substitutedValueParameters, substitutedReturnType, configuration.newModality, configuration.newVisibility);
                substitutedDescriptor.setOperator(this.isOperator);
                substitutedDescriptor.setInfix(this.isInfix);
                substitutedDescriptor.setExternal(this.isExternal);
                substitutedDescriptor.setInline(this.isInline);
                substitutedDescriptor.setTailrec(this.isTailrec);
                substitutedDescriptor.setSuspend(this.isSuspend);
                substitutedDescriptor.setExpect(this.isExpect);
                substitutedDescriptor.setActual(this.isActual);
                substitutedDescriptor.setHasStableParameterNames(this.hasStableParameterNames);
                substitutedDescriptor.setHiddenToOvercomeSignatureClash(configuration.isHiddenToOvercomeSignatureClash);
                substitutedDescriptor.setHiddenForResolutionEverywhereBesideSupercalls(configuration.isHiddenForResolutionEverywhereBesideSupercalls);
                substitutedDescriptor.setHasSynthesizedParameterNames(configuration.newHasSynthesizedParameterNames != null ? configuration.newHasSynthesizedParameterNames.booleanValue() : this.hasSynthesizedParameterNames);
                if (!configuration.userDataMap.isEmpty() || this.userDataMap != null) {
                    Map<CallableDescriptor.UserDataKey<?>, Object> newMap = configuration.userDataMap;
                    if (this.userDataMap != null) {
                        for (Map.Entry<CallableDescriptor.UserDataKey<?>, Object> entry : this.userDataMap.entrySet()) {
                            if (!newMap.containsKey(entry.getKey())) {
                                newMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    if (newMap.size() == 1) {
                        substitutedDescriptor.userDataMap = Collections.singletonMap(newMap.keySet().iterator().next(), newMap.values().iterator().next());
                    } else {
                        substitutedDescriptor.userDataMap = newMap;
                    }
                }
                if (configuration.signatureChange || getInitialSignatureDescriptor() != null) {
                    FunctionDescriptor initialSignature = getInitialSignatureDescriptor() != null ? getInitialSignatureDescriptor() : this;
                    FunctionDescriptor initialSignatureSubstituted = initialSignature.substitute(substitutor);
                    substitutedDescriptor.setInitialSignatureDescriptor(initialSignatureSubstituted);
                }
                if (configuration.copyOverrides && !getOriginal().getOverriddenDescriptors().isEmpty()) {
                    if (configuration.substitution.isEmpty()) {
                        Function0<Collection<FunctionDescriptor>> overriddenFunctionsTask = this.lazyOverriddenFunctionsTask;
                        if (overriddenFunctionsTask != null) {
                            substitutedDescriptor.lazyOverriddenFunctionsTask = overriddenFunctionsTask;
                        } else {
                            substitutedDescriptor.setOverriddenDescriptors(getOverriddenDescriptors());
                        }
                    } else {
                        substitutedDescriptor.lazyOverriddenFunctionsTask = new Function0<Collection<FunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.1
                            @Override // kotlin.jvm.functions.Function0
                            public Collection<FunctionDescriptor> invoke() {
                                Collection<FunctionDescriptor> result = new SmartList<>();
                                for (FunctionDescriptor overriddenFunction : FunctionDescriptorImpl.this.getOverriddenDescriptors()) {
                                    result.add(overriddenFunction.substitute(substitutor));
                                }
                                return result;
                            }
                        };
                    }
                }
                return substitutedDescriptor;
            }
            return this;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public FunctionDescriptor copy(DeclarationDescriptor newOwner, Modality modality, DescriptorVisibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        FunctionDescriptor build = newCopyBuilder().setOwner(newOwner).setModality(modality).setVisibility(visibility).setKind(kind).setCopyOverrides(copyOverrides).build();
        if (build == null) {
            $$$reportNull$$$0(26);
        }
        return build;
    }

    private SourceElement getSourceToUseForCopy(boolean preserveSource, FunctionDescriptor original) {
        SourceElement sourceElement;
        if (preserveSource) {
            sourceElement = (original != null ? original : getOriginal()).getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(27);
        }
        return sourceElement;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor, D data) {
        return visitor.visitFunctionDescriptor(this, data);
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor substitutedDescriptor, List<ValueParameterDescriptor> unsubstitutedValueParameters, TypeSubstitutor substitutor) {
        if (unsubstitutedValueParameters == null) {
            $$$reportNull$$$0(28);
        }
        if (substitutor == null) {
            $$$reportNull$$$0(29);
        }
        return getSubstitutedValueParameters(substitutedDescriptor, unsubstitutedValueParameters, substitutor, false, false, null);
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor substitutedDescriptor, List<ValueParameterDescriptor> unsubstitutedValueParameters, TypeSubstitutor substitutor, boolean dropOriginal, boolean preserveSourceElement, boolean[] wereChanges) {
        KotlinType substitute;
        Function0<List<VariableDescriptor>> destructuringVariablesAction;
        if (unsubstitutedValueParameters == null) {
            $$$reportNull$$$0(30);
        }
        if (substitutor == null) {
            $$$reportNull$$$0(31);
        }
        List<ValueParameterDescriptor> result = new ArrayList<>(unsubstitutedValueParameters.size());
        for (ValueParameterDescriptor unsubstitutedValueParameter : unsubstitutedValueParameters) {
            KotlinType substitutedType = substitutor.substitute(unsubstitutedValueParameter.getType(), Variance.IN_VARIANCE);
            KotlinType varargElementType = unsubstitutedValueParameter.getVarargElementType();
            if (varargElementType == null) {
                substitute = null;
            } else {
                substitute = substitutor.substitute(varargElementType, Variance.IN_VARIANCE);
            }
            KotlinType substituteVarargElementType = substitute;
            if (substitutedType == null) {
                return null;
            }
            if ((substitutedType != unsubstitutedValueParameter.getType() || varargElementType != substituteVarargElementType) && wereChanges != null) {
                wereChanges[0] = true;
            }
            if (!(unsubstitutedValueParameter instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration)) {
                destructuringVariablesAction = null;
            } else {
                final List<VariableDescriptor> destructuringVariables = ((ValueParameterDescriptorImpl.WithDestructuringDeclaration) unsubstitutedValueParameter).getDestructuringVariables();
                Function0<List<VariableDescriptor>> destructuringVariablesAction2 = new Function0<List<VariableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.2
                    @Override // kotlin.jvm.functions.Function0
                    public List<VariableDescriptor> invoke() {
                        return destructuringVariables;
                    }
                };
                destructuringVariablesAction = destructuringVariablesAction2;
            }
            result.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(substitutedDescriptor, dropOriginal ? null : unsubstitutedValueParameter, unsubstitutedValueParameter.getIndex(), unsubstitutedValueParameter.getAnnotations(), unsubstitutedValueParameter.getName(), substitutedType, unsubstitutedValueParameter.declaresDefaultValue(), unsubstitutedValueParameter.isCrossinline(), unsubstitutedValueParameter.isNoinline(), substituteVarargElementType, preserveSourceElement ? unsubstitutedValueParameter.getSource() : SourceElement.NO_SOURCE, destructuringVariablesAction));
        }
        return result;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    private void setInitialSignatureDescriptor(FunctionDescriptor initialSignatureDescriptor) {
        this.initialSignatureDescriptor = initialSignatureDescriptor;
    }

    public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> key, Object value) {
        if (this.userDataMap == null) {
            this.userDataMap = new LinkedHashMap();
        }
        this.userDataMap.put(key, value);
    }
}