package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;
    private final DeserializationContext c;

    public MemberDeserializer(DeserializationContext c) {
        Intrinsics.checkNotNullParameter(c, "c");
        this.c = c;
        this.annotationDeserializer = new AnnotationDeserializer(this.c.getComponents().getModuleDescriptor(), this.c.getComponents().getNotFoundClasses());
    }

    public static /* synthetic */ PropertyDescriptor loadProperty$default(MemberDeserializer memberDeserializer, ProtoBuf.Property property, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return memberDeserializer.loadProperty(property, z);
    }

    public final PropertyDescriptor loadProperty(ProtoBuf.Property proto, boolean loadAnnotationsFromMetadata) {
        Annotations annotations;
        final ProtoBuf.Property property;
        Annotations receiverAnnotations;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        PropertyGetterDescriptorImpl getter;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        PropertyGetterDescriptorImpl createDefaultGetter;
        KotlinType receiverType;
        Intrinsics.checkNotNullParameter(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        if (loadAnnotationsFromMetadata) {
            Annotations.Companion companion = Annotations.Companion;
            Iterable annotationList = proto.getAnnotationList();
            Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
            Iterable $this$map$iv = annotationList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv$iv;
                AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
                Intrinsics.checkNotNull(it);
                destination$iv$iv.add(annotationDeserializer.deserializeAnnotation(it, this.c.getNameResolver()));
            }
            annotations = companion.create((List) destination$iv$iv);
        } else {
            annotations = null;
        }
        Annotations annotationsFromMetadata = annotations;
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Annotations annotations2 = annotationsFromMetadata == null ? getAnnotations(proto, flags, AnnotatedCallableKind.PROPERTY) : annotationsFromMetadata;
        Modality modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(flags));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(flags));
        Boolean bool = Flags.IS_VAR.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean booleanValue = bool.booleanValue();
        Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName());
        CallableMemberDescriptor.Kind memberKind = ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(flags));
        Boolean bool2 = Flags.IS_LATEINIT.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        boolean booleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        boolean booleanValue3 = bool3.booleanValue();
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        boolean booleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool5, "get(...)");
        boolean booleanValue5 = bool5.booleanValue();
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool6, "get(...)");
        final DeserializedPropertyDescriptor property2 = new DeserializedPropertyDescriptor(containingDeclaration, null, annotations2, modality, descriptorVisibility, booleanValue, name, memberKind, booleanValue2, booleanValue3, booleanValue4, booleanValue5, bool6.booleanValue(), proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext local = DeserializationContext.childContext$default(this.c, property2, typeParameterList, null, null, null, null, 60, null);
        Boolean bool7 = Flags.HAS_GETTER.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool7, "get(...)");
        boolean hasGetter = bool7.booleanValue();
        if (!hasGetter || !ProtoTypeTableUtilKt.hasReceiver(proto)) {
            property = proto;
            receiverAnnotations = Annotations.Companion.getEMPTY();
        } else {
            property = proto;
            receiverAnnotations = getReceiverParameterAnnotations(property, AnnotatedCallableKind.PROPERTY_GETTER);
        }
        KotlinType type = local.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(property, this.c.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = local.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf.Type p0 = ProtoTypeTableUtilKt.receiverType(property, this.c.getTypeTable());
        if (p0 == null || (receiverType = local.getTypeDeserializer().type(p0)) == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(property2, receiverType, receiverAnnotations);
        }
        MemberDeserializer memberDeserializer = local.getMemberDeserializer();
        List<ProtoBuf.Type> contextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(property, this.c.getTypeTable());
        List<ProtoBuf.ValueParameter> contextParameterList = proto.getContextParameterList();
        Intrinsics.checkNotNullExpressionValue(contextParameterList, "getContextParameterList(...)");
        property2.setType(type, ownTypeParameters, dispatchReceiverParameter, receiverParameterDescriptor, memberDeserializer.contextReceivers(contextReceiverTypes, contextParameterList, property, AnnotatedCallableKind.PROPERTY_GETTER));
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool8, "get(...)");
        int defaultAccessorFlags = Flags.getAccessorFlags(bool8.booleanValue(), Flags.VISIBILITY.get(flags), Flags.MODALITY.get(flags), false, false, false);
        if (!hasGetter) {
            getter = null;
        } else {
            int getterFlags = proto.hasGetterFlags() ? proto.getGetterFlags() : defaultAccessorFlags;
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool9, "get(...)");
            boolean isNotDefault = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool10, "get(...)");
            boolean isExternal = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool11, "get(...)");
            boolean isInline = bool11.booleanValue();
            Annotations annotations3 = getAnnotations(property, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (isNotDefault) {
                createDefaultGetter = new PropertyGetterDescriptorImpl(property2, annotations3, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(getterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(getterFlags)), !isNotDefault, isExternal, isInline, property2.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                createDefaultGetter = DescriptorFactory.createDefaultGetter(property2, annotations3);
                Intrinsics.checkNotNull(createDefaultGetter);
            }
            getter = createDefaultGetter;
            getter.initialize(property2.getReturnType());
        }
        if (!Flags.HAS_SETTER.get(flags).booleanValue()) {
            propertySetterDescriptorImpl = null;
        } else {
            int setterFlags = proto.hasSetterFlags() ? proto.getSetterFlags() : defaultAccessorFlags;
            Boolean bool12 = Flags.IS_NOT_DEFAULT.get(setterFlags);
            Intrinsics.checkNotNullExpressionValue(bool12, "get(...)");
            boolean isNotDefault2 = bool12.booleanValue();
            Boolean bool13 = Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags);
            Intrinsics.checkNotNullExpressionValue(bool13, "get(...)");
            boolean isExternal2 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_INLINE_ACCESSOR.get(setterFlags);
            Intrinsics.checkNotNullExpressionValue(bool14, "get(...)");
            boolean isInline2 = bool14.booleanValue();
            Annotations annotations4 = getAnnotations(property, setterFlags, AnnotatedCallableKind.PROPERTY_SETTER);
            if (isNotDefault2) {
                PropertySetterDescriptorImpl setter = new PropertySetterDescriptorImpl(property2, annotations4, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(setterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(setterFlags)), !isNotDefault2, isExternal2, isInline2, property2.getKind(), null, SourceElement.NO_SOURCE);
                DeserializationContext setterLocal = DeserializationContext.childContext$default(local, setter, CollectionsKt.emptyList(), null, null, null, null, 60, null);
                List valueParameters = setterLocal.getMemberDeserializer().valueParameters(CollectionsKt.listOf(proto.getSetterValueParameter()), property, AnnotatedCallableKind.PROPERTY_SETTER);
                setter.initialize((ValueParameterDescriptor) CollectionsKt.single((List<? extends Object>) valueParameters));
                propertySetterDescriptorImpl = setter;
            } else {
                propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(property2, annotations4, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNull(propertySetterDescriptorImpl);
            }
        }
        PropertySetterDescriptorImpl setter2 = propertySetterDescriptorImpl;
        if (Flags.HAS_CONSTANT.get(flags).booleanValue()) {
            property2.setCompileTimeInitializerFactory(new Function0(this, property, property2) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$0
                private final MemberDeserializer arg$0;
                private final ProtoBuf.Property arg$1;
                private final DeserializedPropertyDescriptor arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = property;
                    this.arg$2 = property2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    NullableLazyValue loadProperty$lambda$2;
                    loadProperty$lambda$2 = MemberDeserializer.loadProperty$lambda$2(this.arg$0, this.arg$1, this.arg$2);
                    return loadProperty$lambda$2;
                }
            });
        }
        DeclarationDescriptor containingDeclaration2 = this.c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration2 instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration2 : null;
        if ((classDescriptor != null ? classDescriptor.getKind() : null) == ClassKind.ANNOTATION_CLASS) {
            property2.setCompileTimeInitializerFactory(new Function0(this, property, property2) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$1
                private final MemberDeserializer arg$0;
                private final ProtoBuf.Property arg$1;
                private final DeserializedPropertyDescriptor arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = property;
                    this.arg$2 = property2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    NullableLazyValue loadProperty$lambda$3;
                    loadProperty$lambda$3 = MemberDeserializer.loadProperty$lambda$3(this.arg$0, this.arg$1, this.arg$2);
                    return loadProperty$lambda$3;
                }
            });
        }
        property2.initialize(getter, setter2, new FieldDescriptorImpl(getPropertyFieldAnnotations(property, false), property2), new FieldDescriptorImpl(getPropertyFieldAnnotations(property, true), property2));
        return property2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NullableLazyValue loadProperty$lambda$2(final MemberDeserializer this$0, final ProtoBuf.Property $proto, final DeserializedPropertyDescriptor $property) {
        return this$0.c.getStorageManager().createNullableLazyValue(new Function0(this$0, $proto, $property) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$7
            private final MemberDeserializer arg$0;
            private final ProtoBuf.Property arg$1;
            private final DeserializedPropertyDescriptor arg$2;

            {
                this.arg$0 = this$0;
                this.arg$1 = $proto;
                this.arg$2 = $property;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ConstantValue loadProperty$lambda$2$0;
                loadProperty$lambda$2$0 = MemberDeserializer.loadProperty$lambda$2$0(this.arg$0, this.arg$1, this.arg$2);
                return loadProperty$lambda$2$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstantValue loadProperty$lambda$2$0(MemberDeserializer this$0, ProtoBuf.Property $proto, DeserializedPropertyDescriptor $property) {
        ProtoContainer container = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        Intrinsics.checkNotNull(container);
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = this$0.c.getComponents().getAnnotationAndConstantLoader();
        KotlinType returnType = $property.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return annotationAndConstantLoader.loadPropertyConstant(container, $proto, returnType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NullableLazyValue loadProperty$lambda$3(final MemberDeserializer this$0, final ProtoBuf.Property $proto, final DeserializedPropertyDescriptor $property) {
        return this$0.c.getStorageManager().createNullableLazyValue(new Function0(this$0, $proto, $property) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$8
            private final MemberDeserializer arg$0;
            private final ProtoBuf.Property arg$1;
            private final DeserializedPropertyDescriptor arg$2;

            {
                this.arg$0 = this$0;
                this.arg$1 = $proto;
                this.arg$2 = $property;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ConstantValue loadProperty$lambda$3$0;
                loadProperty$lambda$3$0 = MemberDeserializer.loadProperty$lambda$3$0(this.arg$0, this.arg$1, this.arg$2);
                return loadProperty$lambda$3$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstantValue loadProperty$lambda$3$0(MemberDeserializer this$0, ProtoBuf.Property $proto, DeserializedPropertyDescriptor $property) {
        ProtoContainer container = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        Intrinsics.checkNotNull(container);
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = this$0.c.getComponents().getAnnotationAndConstantLoader();
        KotlinType returnType = $property.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return annotationAndConstantLoader.loadAnnotationDefaultValue(container, $proto, returnType);
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor $this$initializeWithCoroutinesExperimentalityStatus, ReceiverParameterDescriptor extensionReceiverParameter, ReceiverParameterDescriptor dispatchReceiverParameter, List<? extends ReceiverParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, List<? extends ValueParameterDescriptor> list3, KotlinType unsubstitutedReturnType, Modality modality, DescriptorVisibility visibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        $this$initializeWithCoroutinesExperimentalityStatus.initialize(extensionReceiverParameter, dispatchReceiverParameter, list, list2, list3, unsubstitutedReturnType, modality, visibility, map);
    }

    private final int loadOldFlags(int oldFlags) {
        int lowSixBits = oldFlags & 63;
        int rest = (oldFlags >> 8) << 6;
        return lowSixBits + rest;
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf.Function proto) {
        Annotations empty;
        VersionRequirementTable versionRequirementTable;
        KotlinType receiverType;
        Intrinsics.checkNotNullParameter(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        Annotations annotations = getAnnotations(proto, flags, AnnotatedCallableKind.FUNCTION);
        if (ProtoTypeTableUtilKt.hasReceiver(proto)) {
            empty = getReceiverParameterAnnotations(proto, AnnotatedCallableKind.FUNCTION);
        } else {
            empty = Annotations.Companion.getEMPTY();
        }
        Annotations receiverAnnotations = empty;
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.c.getVersionRequirementTable();
        }
        DeserializedSimpleFunctionDescriptor function = new DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), null, annotations, NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(flags)), proto, this.c.getNameResolver(), this.c.getTypeTable(), versionRequirementTable, this.c.getContainerSource(), null, 1024, null);
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext local = DeserializationContext.childContext$default(this.c, function, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf.Type p0 = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable = (p0 == null || (receiverType = local.getTypeDeserializer().type(p0)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(function, receiverType, receiverAnnotations);
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        MemberDeserializer memberDeserializer = local.getMemberDeserializer();
        List<ProtoBuf.Type> contextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.c.getTypeTable());
        List<ProtoBuf.ValueParameter> contextParameterList = proto.getContextParameterList();
        Intrinsics.checkNotNullExpressionValue(contextParameterList, "getContextParameterList(...)");
        List<ReceiverParameterDescriptor> contextReceivers = memberDeserializer.contextReceivers(contextReceiverTypes, contextParameterList, proto, AnnotatedCallableKind.FUNCTION);
        List<TypeParameterDescriptor> ownTypeParameters = local.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer2 = local.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        initializeWithCoroutinesExperimentalityStatus(function, createExtensionReceiverParameterForCallable, dispatchReceiverParameter, contextReceivers, ownTypeParameters, memberDeserializer2.valueParameters(valueParameterList, proto, AnnotatedCallableKind.FUNCTION), local.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable())), ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(flags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(flags)), MapsKt.emptyMap());
        Boolean bool = Flags.IS_OPERATOR.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        function.setOperator(bool.booleanValue());
        Boolean bool2 = Flags.IS_INFIX.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        function.setInfix(bool2.booleanValue());
        Boolean bool3 = Flags.IS_EXTERNAL_FUNCTION.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        function.setExternal(bool3.booleanValue());
        Boolean bool4 = Flags.IS_INLINE.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        function.setInline(bool4.booleanValue());
        Boolean bool5 = Flags.IS_TAILREC.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool5, "get(...)");
        function.setTailrec(bool5.booleanValue());
        Boolean bool6 = Flags.IS_SUSPEND.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool6, "get(...)");
        function.setSuspend(bool6.booleanValue());
        Boolean bool7 = Flags.IS_EXPECT_FUNCTION.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool7, "get(...)");
        function.setExpect(bool7.booleanValue());
        function.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(flags).booleanValue());
        Pair mapValueForContract = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(proto, function, this.c.getTypeTable(), local.getTypeDeserializer());
        if (mapValueForContract != null) {
            function.putInUserDataMap((CallableDescriptor.UserDataKey) mapValueForContract.getFirst(), mapValueForContract.getSecond());
        }
        return function;
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf.TypeAlias proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Annotations.Companion companion = Annotations.Companion;
        Iterable annotationList = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        Iterable $this$map$iv = annotationList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv$iv;
            AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
            Intrinsics.checkNotNull(it);
            destination$iv$iv.add(annotationDeserializer.deserializeAnnotation(it, this.c.getNameResolver()));
        }
        Annotations annotations = companion.create((List) destination$iv$iv);
        DescriptorVisibility visibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags()));
        DeserializedTypeAliasDescriptor typeAlias = new DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), annotations, NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName()), visibility, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext local = DeserializationContext.childContext$default(this.c, typeAlias, typeParameterList, null, null, null, null, 60, null);
        typeAlias.initialize(local.getTypeDeserializer().getOwnTypeParameters(), local.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(proto, this.c.getTypeTable()), false), local.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(proto, this.c.getTypeTable()), false));
        return typeAlias;
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            return classDescriptor.getThisAsReceiverParameter();
        }
        return null;
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf.Constructor proto, boolean isPrimary) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        DeserializedClassConstructorDescriptor descriptor = new DeserializedClassConstructorDescriptor(classDescriptor, null, getAnnotations(proto, proto.getFlags(), AnnotatedCallableKind.FUNCTION), isPrimary, CallableMemberDescriptor.Kind.DECLARATION, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), null, 1024, null);
        DeserializationContext local = DeserializationContext.childContext$default(this.c, descriptor, CollectionsKt.emptyList(), null, null, null, null, 60, null);
        MemberDeserializer memberDeserializer = local.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        descriptor.initialize(memberDeserializer.valueParameters(valueParameterList, proto, AnnotatedCallableKind.FUNCTION), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags())));
        descriptor.setReturnType(classDescriptor.getDefaultType());
        descriptor.setExpect(classDescriptor.isExpect());
        descriptor.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(proto.getFlags()).booleanValue());
        return descriptor;
    }

    private final Annotations getAnnotations(final MessageLite proto, int flags, final AnnotatedCallableKind kind) {
        if (!Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0(this, proto, kind) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$2
            private final MemberDeserializer arg$0;
            private final MessageLite arg$1;
            private final AnnotatedCallableKind arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = proto;
                this.arg$2 = kind;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List annotations$lambda$0;
                annotations$lambda$0 = MemberDeserializer.getAnnotations$lambda$0(this.arg$0, this.arg$1, this.arg$2);
                return annotations$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAnnotations$lambda$0(MemberDeserializer this$0, MessageLite $proto, AnnotatedCallableKind $kind) {
        ProtoContainer it = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        List list = it != null ? CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(it, $proto, $kind)) : null;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final Annotations getPropertyFieldAnnotations(final ProtoBuf.Property proto, final boolean isDelegate) {
        if (!Flags.HAS_ANNOTATIONS.get(proto.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0(this, isDelegate, proto) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$3
            private final MemberDeserializer arg$0;
            private final boolean arg$1;
            private final ProtoBuf.Property arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = isDelegate;
                this.arg$2 = proto;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List propertyFieldAnnotations$lambda$0;
                propertyFieldAnnotations$lambda$0 = MemberDeserializer.getPropertyFieldAnnotations$lambda$0(this.arg$0, this.arg$1, this.arg$2);
                return propertyFieldAnnotations$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPropertyFieldAnnotations$lambda$0(MemberDeserializer this$0, boolean $isDelegate, ProtoBuf.Property $proto) {
        List list;
        ProtoContainer it = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        if (it == null) {
            list = null;
        } else if ($isDelegate) {
            list = CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(it, $proto));
        } else {
            list = CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(it, $proto));
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final Annotations getReceiverParameterAnnotations(final MessageLite proto, final AnnotatedCallableKind kind) {
        return new DeserializedAnnotations(this.c.getStorageManager(), new Function0(this, proto, kind) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$4
            private final MemberDeserializer arg$0;
            private final MessageLite arg$1;
            private final AnnotatedCallableKind arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = proto;
                this.arg$2 = kind;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List receiverParameterAnnotations$lambda$0;
                receiverParameterAnnotations$lambda$0 = MemberDeserializer.getReceiverParameterAnnotations$lambda$0(this.arg$0, this.arg$1, this.arg$2);
                return receiverParameterAnnotations$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getReceiverParameterAnnotations$lambda$0(MemberDeserializer this$0, MessageLite $proto, AnnotatedCallableKind $kind) {
        ProtoContainer it = this$0.asProtoContainer(this$0.c.getContainingDeclaration());
        List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations = it != null ? this$0.c.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(it, $proto, $kind) : null;
        return loadExtensionReceiverParameterAnnotations == null ? CollectionsKt.emptyList() : loadExtensionReceiverParameterAnnotations;
    }

    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> list, final MessageLite callable, final AnnotatedCallableKind kind) {
        NonEmptyDeserializedAnnotations annotations;
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        DeclarationDescriptor containingDeclaration2 = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
        final ProtoContainer containerOfCallable = asProtoContainer(containingDeclaration2);
        List<ProtoBuf.ValueParameter> $this$mapIndexed$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        Collection destination$iv$iv2 = destination$iv$iv;
        final int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final ProtoBuf.ValueParameter proto = (ProtoBuf.ValueParameter) item$iv$iv;
            int flags = proto.hasFlags() ? proto.getFlags() : 0;
            if (containerOfCallable != null && Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
                annotations = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0(this, containerOfCallable, callable, kind, index$iv$iv, proto) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$5
                    private final MemberDeserializer arg$0;
                    private final ProtoContainer arg$1;
                    private final MessageLite arg$2;
                    private final AnnotatedCallableKind arg$3;
                    private final int arg$4;
                    private final ProtoBuf.ValueParameter arg$5;

                    {
                        this.arg$0 = this;
                        this.arg$1 = containerOfCallable;
                        this.arg$2 = callable;
                        this.arg$3 = kind;
                        this.arg$4 = index$iv$iv;
                        this.arg$5 = proto;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        List valueParameters$lambda$0$0;
                        valueParameters$lambda$0$0 = MemberDeserializer.valueParameters$lambda$0$0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
                        return valueParameters$lambda$0$0;
                    }
                });
            } else {
                annotations = Annotations.Companion.getEMPTY();
            }
            Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName());
            KotlinType type = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(proto, this.c.getTypeTable()));
            Boolean bool = Flags.DECLARES_DEFAULT_VALUE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
            boolean booleanValue = bool.booleanValue();
            Boolean bool2 = Flags.IS_CROSSINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
            boolean booleanValue2 = bool2.booleanValue();
            Boolean bool3 = Flags.IS_NOINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
            boolean booleanValue3 = bool3.booleanValue();
            ProtoBuf.Type it = ProtoTypeTableUtilKt.varargElementType(proto, this.c.getTypeTable());
            KotlinType type2 = it != null ? this.c.getTypeDeserializer().type(it) : null;
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            Collection destination$iv$iv3 = destination$iv$iv2;
            destination$iv$iv3.add(new ValueParameterDescriptorImpl(callableDescriptor, null, index$iv$iv, annotations, name, type, booleanValue, booleanValue2, booleanValue3, type2, NO_SOURCE));
            destination$iv$iv2 = destination$iv$iv3;
            $this$mapIndexed$iv = $this$mapIndexed$iv;
            index$iv$iv = index$iv$iv2;
        }
        return CollectionsKt.toList((List) destination$iv$iv2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List valueParameters$lambda$0$0(MemberDeserializer this$0, ProtoContainer $containerOfCallable, MessageLite $callable, AnnotatedCallableKind $kind, int $i, ProtoBuf.ValueParameter $proto) {
        return CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations($containerOfCallable, $callable, $kind, $i, $proto));
    }

    private final ProtoContainer asProtoContainer(DeclarationDescriptor $this$asProtoContainer) {
        if ($this$asProtoContainer instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) $this$asProtoContainer).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource());
        }
        if ($this$asProtoContainer instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) $this$asProtoContainer).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
        if (r24.hasFlags() == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<ReceiverParameterDescriptor> contextReceivers(List<ProtoBuf.Type> list, List<ProtoBuf.ValueParameter> list2, final MessageLite callable, final AnnotatedCallableKind kind) {
        int index;
        ProtoContainer containerOfCallable;
        Iterable $this$mapIndexedNotNull$iv;
        int $i$f$mapIndexedNotNull;
        ProtoBuf.Type type;
        NonEmptyDeserializedAnnotations empty;
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        DeclarationDescriptor containingDeclaration2 = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
        ProtoContainer containerOfCallable2 = asProtoContainer(containingDeclaration2);
        List<ProtoBuf.Type> $this$mapIndexedNotNull$iv2 = list;
        int $i$f$mapIndexedNotNull2 = 0;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv2) {
            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
            if (index$iv$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final int index$iv$iv = index$iv$iv$iv;
            ProtoBuf.Type type2 = (ProtoBuf.Type) item$iv$iv$iv;
            final ProtoBuf.ValueParameter parameterProto = (ProtoBuf.ValueParameter) CollectionsKt.getOrNull(list2, index$iv$iv);
            boolean z = parameterProto != null;
            int flags = z ? parameterProto.getFlags() : 0;
            if (containerOfCallable2 == null || !Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
                index = index$iv$iv;
                containerOfCallable = containerOfCallable2;
                $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                type = type2;
                empty = Annotations.Companion.getEMPTY();
            } else {
                $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                final ProtoContainer protoContainer = containerOfCallable2;
                index = index$iv$iv;
                containerOfCallable = containerOfCallable2;
                type = type2;
                empty = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0(this, protoContainer, callable, kind, index$iv$iv, parameterProto) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$6
                    private final MemberDeserializer arg$0;
                    private final ProtoContainer arg$1;
                    private final MessageLite arg$2;
                    private final AnnotatedCallableKind arg$3;
                    private final int arg$4;
                    private final ProtoBuf.ValueParameter arg$5;

                    {
                        this.arg$0 = this;
                        this.arg$1 = protoContainer;
                        this.arg$2 = callable;
                        this.arg$3 = kind;
                        this.arg$4 = index$iv$iv;
                        this.arg$5 = parameterProto;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        List contextReceivers$lambda$0$0;
                        contextReceivers$lambda$0$0 = MemberDeserializer.contextReceivers$lambda$0$0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
                        return contextReceivers$lambda$0$0;
                    }
                });
            }
            Annotations annotations = empty;
            ReceiverParameterDescriptor createContextReceiverParameterForCallable = DescriptorFactory.createContextReceiverParameterForCallable(callableDescriptor, this.c.getTypeDeserializer().type(type), null, annotations, index);
            if (createContextReceiverParameterForCallable != null) {
                destination$iv$iv.add(createContextReceiverParameterForCallable);
            }
            index$iv$iv$iv = index$iv$iv$iv2;
            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
            $i$f$mapIndexedNotNull2 = $i$f$mapIndexedNotNull;
            containerOfCallable2 = containerOfCallable;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List contextReceivers$lambda$0$0(MemberDeserializer this$0, ProtoContainer $containerOfCallable, MessageLite $callable, AnnotatedCallableKind $kind, int $index, ProtoBuf.ValueParameter $parameterProto) {
        return CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadContextParameterAnnotations($containerOfCallable, $callable, $kind, $index, $parameterProto));
    }
}