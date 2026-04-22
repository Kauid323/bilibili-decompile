package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* compiled from: FunctionInvokeDescriptor.kt */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = new Factory(null);

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z);
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor container, FunctionInvokeDescriptor original, CallableMemberDescriptor.Kind callableKind, boolean isSuspend) {
        super(container, original, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, callableKind, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(isSuspend);
        setHasStableParameterNames(false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptor doSubstitute(FunctionDescriptorImpl.CopyConfiguration configuration) {
        ValueParameterDescriptor it;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        FunctionInvokeDescriptor substituted = (FunctionInvokeDescriptor) super.doSubstitute(configuration);
        if (substituted == null) {
            return null;
        }
        Iterable valueParameters = substituted.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        Iterable $this$none$iv = valueParameters;
        boolean z = true;
        if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
            Iterator<T> it2 = $this$none$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv = it2.next();
                ValueParameterDescriptor it3 = (ValueParameterDescriptor) element$iv;
                KotlinType type = it3.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            return substituted;
        }
        Iterable valueParameters2 = substituted.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        Iterable $this$map$iv = valueParameters2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ValueParameterDescriptor it4 = (ValueParameterDescriptor) item$iv$iv;
            KotlinType type2 = it4.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            destination$iv$iv.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type2));
        }
        List parameterNames = (List) destination$iv$iv;
        return substituted.replaceParameterNames(parameterNames);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor newOwner, FunctionDescriptor original, CallableMemberDescriptor.Kind kind, Name newName, Annotations annotations, SourceElement source) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(source, "source");
        return new FunctionInvokeDescriptor(newOwner, (FunctionInvokeDescriptor) original, kind, isSuspend());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration] */
    private final FunctionDescriptor replaceParameterNames(List<Name> list) {
        boolean z;
        boolean z2;
        Name parameterName;
        Iterable $this$all$iv;
        int indexShift = getValueParameters().size() - list.size();
        if (!(indexShift == 0 || indexShift == 1)) {
            throw new AssertionError("Assertion failed");
        }
        if (indexShift == 0) {
            List<ValueParameterDescriptor> valueParameters = getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            Iterable $this$all$iv2 = CollectionsKt.zip(list, valueParameters);
            if (($this$all$iv2 instanceof Collection) && ((Collection) $this$all$iv2).isEmpty()) {
                $this$all$iv = 1;
            } else {
                Iterator it = $this$all$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        Pair pair = (Pair) element$iv;
                        Name name = (Name) pair.component1();
                        ValueParameterDescriptor parameter = (ValueParameterDescriptor) pair.component2();
                        if (!Intrinsics.areEqual(name, parameter.getName())) {
                            $this$all$iv = null;
                            break;
                        }
                    } else {
                        $this$all$iv = 1;
                        break;
                    }
                }
            }
            if ($this$all$iv != null) {
                return this;
            }
        }
        Iterable valueParameters2 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        Iterable $this$map$iv = valueParameters2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ValueParameterDescriptor it2 = (ValueParameterDescriptor) item$iv$iv;
            Name newName = it2.getName();
            Intrinsics.checkNotNullExpressionValue(newName, "getName(...)");
            int parameterIndex = it2.getIndex();
            int nameIndex = parameterIndex - indexShift;
            if (nameIndex >= 0 && (parameterName = list.get(nameIndex)) != null) {
                newName = parameterName;
            }
            destination$iv$iv.add(it2.copy(this, newName, parameterIndex));
        }
        List newValueParameters = (List) destination$iv$iv;
        FunctionDescriptorImpl.CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        List<Name> $this$any$iv = list;
        if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
            Iterator<T> it3 = $this$any$iv.iterator();
            while (true) {
                if (it3.hasNext()) {
                    Object element$iv2 = it3.next();
                    if (((Name) element$iv2) == null) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        ?? original = newCopyBuilder.setHasSynthesizedParameterNames(z).setValueParameters2((List<ValueParameterDescriptor>) newValueParameters).setOriginal((CallableMemberDescriptor) getOriginal());
        Intrinsics.checkNotNullExpressionValue(original, "setOriginal(...)");
        FunctionDescriptor doSubstitute = super.doSubstitute(original);
        Intrinsics.checkNotNull(doSubstitute);
        return doSubstitute;
    }

    /* compiled from: FunctionInvokeDescriptor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor functionClass, boolean isSuspend) {
            Intrinsics.checkNotNullParameter(functionClass, "functionClass");
            List typeParameters = functionClass.getDeclaredTypeParameters();
            FunctionInvokeDescriptor result = new FunctionInvokeDescriptor(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, isSuspend, null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClass.getThisAsReceiverParameter();
            List emptyList = CollectionsKt.emptyList();
            List emptyList2 = CollectionsKt.emptyList();
            List $this$takeWhile$iv = typeParameters;
            ArrayList list$iv = new ArrayList();
            for (Object item$iv : $this$takeWhile$iv) {
                if (!(((TypeParameterDescriptor) item$iv).getVariance() == Variance.IN_VARIANCE)) {
                    break;
                }
                list$iv.add(item$iv);
            }
            ArrayList $this$takeWhile$iv2 = list$iv;
            Iterable $this$map$iv = CollectionsKt.withIndex($this$takeWhile$iv2);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                IndexedValue it = (IndexedValue) item$iv$iv;
                destination$iv$iv.add(FunctionInvokeDescriptor.Factory.createValueParameter(result, it.getIndex(), (TypeParameterDescriptor) it.getValue()));
                $this$map$iv = $this$map$iv;
            }
            result.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, emptyList, emptyList2, (List) ((List) destination$iv$iv), (KotlinType) ((TypeParameterDescriptor) CollectionsKt.last((List<? extends Object>) typeParameters)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            result.setHasSynthesizedParameterNames(true);
            return result;
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor containingDeclaration, int index, TypeParameterDescriptor typeParameter) {
            String typeParameterName;
            String typeParameterName2 = typeParameter.getName().asString();
            Intrinsics.checkNotNullExpressionValue(typeParameterName2, "asString(...)");
            if (Intrinsics.areEqual(typeParameterName2, "T")) {
                typeParameterName = "instance";
            } else if (Intrinsics.areEqual(typeParameterName2, "E")) {
                typeParameterName = "receiver";
            } else {
                typeParameterName = typeParameterName2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(typeParameterName, "toLowerCase(...)");
            }
            Annotations empty = Annotations.Companion.getEMPTY();
            Name identifier = Name.identifier(typeParameterName);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            SimpleType defaultType = typeParameter.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(containingDeclaration, null, index, empty, identifier, defaultType, false, false, false, null, NO_SOURCE);
        }
    }
}