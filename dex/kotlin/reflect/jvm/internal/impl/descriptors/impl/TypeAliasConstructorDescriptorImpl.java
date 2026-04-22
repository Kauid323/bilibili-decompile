package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeAliasConstructorDescriptor.kt */
public final class TypeAliasConstructorDescriptorImpl extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(TypeAliasConstructorDescriptorImpl.class, "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;", 0))};
    public static final Companion Companion = new Companion(null);
    private final StorageManager storageManager;
    private final TypeAliasDescriptor typeAliasDescriptor;
    private ClassConstructorDescriptor underlyingConstructorDescriptor;
    private final NullableLazyValue withDispatchReceiver$delegate;

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptor, annotations, kind, sourceElement);
    }

    private TypeAliasConstructorDescriptorImpl(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, final ClassConstructorDescriptor underlyingConstructorDescriptor, TypeAliasConstructorDescriptor original, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement source) {
        super(typeAliasDescriptor, original, annotations, SpecialNames.INIT, kind, source);
        this.storageManager = storageManager;
        this.typeAliasDescriptor = typeAliasDescriptor;
        setActual(getTypeAliasDescriptor().isActual());
        this.withDispatchReceiver$delegate = this.storageManager.createNullableLazyValue(new Function0(this, underlyingConstructorDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl$$Lambda$0
            private final TypeAliasConstructorDescriptorImpl arg$0;
            private final ClassConstructorDescriptor arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = underlyingConstructorDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                TypeAliasConstructorDescriptorImpl withDispatchReceiver_delegate$lambda$0;
                withDispatchReceiver_delegate$lambda$0 = TypeAliasConstructorDescriptorImpl.withDispatchReceiver_delegate$lambda$0(this.arg$0, this.arg$1);
                return withDispatchReceiver_delegate$lambda$0;
            }
        });
        this.underlyingConstructorDescriptor = underlyingConstructorDescriptor;
    }

    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeAliasConstructorDescriptorImpl withDispatchReceiver_delegate$lambda$0(TypeAliasConstructorDescriptorImpl this$0, ClassConstructorDescriptor $underlyingConstructorDescriptor) {
        Annotations annotations = $underlyingConstructorDescriptor.getAnnotations();
        CallableMemberDescriptor.Kind kind = $underlyingConstructorDescriptor.getKind();
        Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
        SourceElement source = this$0.getTypeAliasDescriptor().getSource();
        Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
        TypeAliasConstructorDescriptorImpl typeAliasConstructor = new TypeAliasConstructorDescriptorImpl(this$0.storageManager, this$0.getTypeAliasDescriptor(), $underlyingConstructorDescriptor, this$0, annotations, kind, source);
        TypeSubstitutor substitutorForUnderlyingClass = Companion.getTypeSubstitutorForUnderlyingClass(this$0.getTypeAliasDescriptor());
        if (substitutorForUnderlyingClass == null) {
            return null;
        }
        ReceiverParameterDescriptor dispatchReceiverParameter = $underlyingConstructorDescriptor.getDispatchReceiverParameter();
        ReceiverParameterDescriptor substitute = dispatchReceiverParameter != null ? dispatchReceiverParameter.substitute(substitutorForUnderlyingClass) : null;
        Iterable contextReceiverParameters = $underlyingConstructorDescriptor.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
        Iterable $this$map$iv = contextReceiverParameters;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ReceiverParameterDescriptor it = (ReceiverParameterDescriptor) item$iv$iv;
            destination$iv$iv.add(it.substitute(substitutorForUnderlyingClass));
        }
        typeAliasConstructor.initialize(null, substitute, (List) destination$iv$iv, this$0.getTypeAliasDescriptor().getDeclaredTypeParameters(), this$0.getValueParameters(), this$0.getReturnType(), Modality.FINAL, this$0.getTypeAliasDescriptor().getVisibility());
        return typeAliasConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
        return constructedClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType returnType = super.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor original = super.getOriginal();
        Intrinsics.checkNotNull(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public TypeAliasConstructorDescriptor substitute(TypeSubstitutor substitutor) {
        Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        FunctionDescriptor substitute = super.substitute(substitutor);
        Intrinsics.checkNotNull(substitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl substitutedTypeAliasConstructor = (TypeAliasConstructorDescriptorImpl) substitute;
        TypeSubstitutor underlyingConstructorSubstitutor = TypeSubstitutor.create(substitutedTypeAliasConstructor.getReturnType());
        Intrinsics.checkNotNullExpressionValue(underlyingConstructorSubstitutor, "create(...)");
        ClassConstructorDescriptor substitutedUnderlyingConstructor = getUnderlyingConstructorDescriptor().getOriginal().substitute(underlyingConstructorSubstitutor);
        if (substitutedUnderlyingConstructor == null) {
            return null;
        }
        substitutedTypeAliasConstructor.underlyingConstructorDescriptor = substitutedUnderlyingConstructor;
        return substitutedTypeAliasConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public TypeAliasConstructorDescriptor copy(DeclarationDescriptor newOwner, Modality modality, DescriptorVisibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter(modality, "modality");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(kind, "kind");
        FunctionDescriptor build = newCopyBuilder().setOwner(newOwner).setModality(modality).setVisibility(visibility).setKind(kind).setCopyOverrides(copyOverrides).build();
        Intrinsics.checkNotNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) build;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public TypeAliasConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor newOwner, FunctionDescriptor original, CallableMemberDescriptor.Kind kind, Name newName, Annotations annotations, SourceElement source) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(kind == CallableMemberDescriptor.Kind.DECLARATION || kind == CallableMemberDescriptor.Kind.SYNTHESIZED)) {
            throw new AssertionError("Creating a type alias constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + newOwner + "\nkind: " + kind);
        }
        if (!(newName == null)) {
            throw new AssertionError("Renaming type alias constructor: " + this);
        }
        return new TypeAliasConstructorDescriptorImpl(this.storageManager, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, annotations, CallableMemberDescriptor.Kind.DECLARATION, source);
    }

    /* compiled from: TypeAliasConstructorDescriptor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TypeSubstitutor getTypeSubstitutorForUnderlyingClass(TypeAliasDescriptor $this$getTypeSubstitutorForUnderlyingClass) {
            if ($this$getTypeSubstitutorForUnderlyingClass.getClassDescriptor() == null) {
                return null;
            }
            return TypeSubstitutor.create($this$getTypeSubstitutorForUnderlyingClass.getExpandedType());
        }

        public final TypeAliasConstructorDescriptor createIfAvailable(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor constructor) {
            ClassConstructorDescriptor substitutedConstructor;
            List contextReceiverParameters;
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            TypeSubstitutor substitutorForUnderlyingClass = getTypeSubstitutorForUnderlyingClass(typeAliasDescriptor);
            if (substitutorForUnderlyingClass == null || (substitutedConstructor = constructor.substitute(substitutorForUnderlyingClass)) == null) {
                return null;
            }
            Annotations annotations = constructor.getAnnotations();
            CallableMemberDescriptor.Kind kind = constructor.getKind();
            Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
            SourceElement source = typeAliasDescriptor.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
            TypeAliasConstructorDescriptorImpl typeAliasConstructor = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, substitutedConstructor, null, annotations, kind, source, null);
            List valueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(typeAliasConstructor, constructor.getValueParameters(), substitutorForUnderlyingClass);
            if (valueParameters == null) {
                return null;
            }
            SimpleType lowerIfFlexible = FlexibleTypesKt.lowerIfFlexible(substitutedConstructor.getReturnType().unwrap());
            SimpleType defaultType = typeAliasDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            SimpleType returnType = SpecialTypesKt.withAbbreviation(lowerIfFlexible, defaultType);
            ReceiverParameterDescriptor it = constructor.getDispatchReceiverParameter();
            ReceiverParameterDescriptor receiverParameter = it != null ? DescriptorFactory.createExtensionReceiverParameterForCallable(typeAliasConstructor, substitutorForUnderlyingClass.safeSubstitute(it.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY()) : null;
            ClassDescriptor classDescriptor = typeAliasDescriptor.getClassDescriptor();
            if (classDescriptor != null) {
                ClassDescriptor it2 = classDescriptor;
                boolean z = false;
                Iterable contextReceiverParameters2 = constructor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters2, "getContextReceiverParameters(...)");
                Iterable $this$mapIndexed$iv = contextReceiverParameters2;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                int index$iv$iv = 0;
                for (Object item$iv$iv : $this$mapIndexed$iv) {
                    int index$iv$iv2 = index$iv$iv + 1;
                    if (index$iv$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ReceiverParameterDescriptor contextReceiver = (ReceiverParameterDescriptor) item$iv$iv;
                    ClassConstructorDescriptor substitutedConstructor2 = substitutedConstructor;
                    ClassDescriptor it3 = it2;
                    KotlinType safeSubstitute = substitutorForUnderlyingClass.safeSubstitute(contextReceiver.getType(), Variance.INVARIANT);
                    ReceiverValue value = contextReceiver.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
                    Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
                    int index = index$iv$iv;
                    destination$iv$iv.add(DescriptorFactory.createContextReceiverParameterForClass(classDescriptor, safeSubstitute, ((ImplicitContextReceiver) value).getCustomLabelName(), Annotations.Companion.getEMPTY(), index));
                    index$iv$iv = index$iv$iv2;
                    it2 = it3;
                    substitutedConstructor = substitutedConstructor2;
                    z = z;
                    $this$mapIndexed$iv = $this$mapIndexed$iv2;
                }
                contextReceiverParameters = (List) destination$iv$iv;
            } else {
                contextReceiverParameters = CollectionsKt.emptyList();
            }
            typeAliasConstructor.initialize(receiverParameter, null, contextReceiverParameters, typeAliasDescriptor.getDeclaredTypeParameters(), valueParameters, returnType, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructor;
        }
    }
}