package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt;

/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer {
    private final DeserializationContext c;
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    private final String containerPresentableName;
    private final String debugName;
    private final TypeDeserializer parent;
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(DeserializationContext c, TypeDeserializer parent, List<ProtoBuf.TypeParameter> typeParameterProtos, String debugName, String containerPresentableName) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(typeParameterProtos, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(debugName, "debugName");
        Intrinsics.checkNotNullParameter(containerPresentableName, "containerPresentableName");
        this.c = c;
        this.parent = parent;
        this.debugName = debugName;
        this.containerPresentableName = containerPresentableName;
        this.classifierDescriptors = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$0
            private final TypeDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassifierDescriptor computeClassifierDescriptor;
                computeClassifierDescriptor = this.arg$0.computeClassifierDescriptor(((Number) obj).intValue());
                return computeClassifierDescriptor;
            }
        });
        this.typeAliasDescriptors = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$1
            private final TypeDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassifierDescriptor computeTypeAliasDescriptor;
                computeTypeAliasDescriptor = this.arg$0.computeTypeAliasDescriptor(((Number) obj).intValue());
                return computeTypeAliasDescriptor;
            }
        });
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = MapsKt.emptyMap();
        } else {
            LinkedHashMap result = new LinkedHashMap();
            int index = 0;
            proto = null;
            int i = 0;
            for (ProtoBuf.TypeParameter proto : typeParameterProtos) {
                index = i;
                i++;
                result.put(Integer.valueOf(proto.getId()), new DeserializedTypeParameterDescriptor(this.c, proto, index));
            }
            linkedHashMap = result;
        }
        this.typeParameterDescriptors = linkedHashMap;
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public final KotlinType type(ProtoBuf.Type proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasFlexibleTypeCapabilitiesId()) {
            String id = this.c.getNameResolver().getString(proto.getFlexibleTypeCapabilitiesId());
            SimpleType lowerBound = simpleType$default(this, proto, false, 2, null);
            ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(proto, this.c.getTypeTable());
            Intrinsics.checkNotNull(flexibleUpperBound);
            SimpleType upperBound = simpleType$default(this, flexibleUpperBound, false, 2, null);
            return this.c.getComponents().getFlexibleTypeDeserializer().create(proto, id, lowerBound, upperBound);
        }
        return simpleType(proto, true);
    }

    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> list, Annotations annotations, TypeConstructor constructor, DeclarationDescriptor containingDeclaration) {
        List<? extends TypeAttributeTranslator> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            TypeAttributeTranslator translator = (TypeAttributeTranslator) item$iv$iv;
            destination$iv$iv.add(translator.toAttributes(annotations, constructor, containingDeclaration));
        }
        List translated = CollectionsKt.flatten((List) destination$iv$iv);
        return TypeAttributes.Companion.create(translated);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return typeDeserializer.simpleType(type, z);
    }

    public final SimpleType simpleType(final ProtoBuf.Type proto, boolean expandTypeAliases) {
        SimpleType localClassifierType;
        SimpleType expandedType;
        SimpleType computedType;
        Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasClassName()) {
            localClassifierType = computeLocalClassifierReplacementType(proto.getClassName());
        } else {
            localClassifierType = proto.hasTypeAliasName() ? computeLocalClassifierReplacementType(proto.getTypeAliasName()) : null;
        }
        if (localClassifierType != null) {
            return localClassifierType;
        }
        TypeConstructor constructor = typeConstructor(proto);
        if (ErrorUtils.isError(constructor.mo1171getDeclarationDescriptor())) {
            return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, constructor, constructor.toString());
        }
        DeserializedAnnotations annotations = new DeserializedAnnotations(this.c.getStorageManager(), new Function0(this, proto) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$2
            private final TypeDeserializer arg$0;
            private final ProtoBuf.Type arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = proto;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List simpleType$lambda$0;
                simpleType$lambda$0 = TypeDeserializer.simpleType$lambda$0(this.arg$0, this.arg$1);
                return simpleType$lambda$0;
            }
        });
        TypeAttributes attributes = toAttributes(this.c.getComponents().getTypeAttributeTranslators(), annotations, constructor, this.c.getContainingDeclaration());
        Iterable $this$mapIndexed$iv = simpleType$collectAllArguments(proto, this);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProtoBuf.Type.Argument argumentProto = (ProtoBuf.Type.Argument) item$iv$iv;
            SimpleType localClassifierType2 = localClassifierType;
            List<TypeParameterDescriptor> parameters = constructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            destination$iv$iv.add(typeArgument((TypeParameterDescriptor) CollectionsKt.getOrNull(parameters, index$iv$iv), argumentProto));
            index$iv$iv = index$iv$iv2;
            localClassifierType = localClassifierType2;
            $this$mapIndexed$iv = $this$mapIndexed$iv;
        }
        List arguments = CollectionsKt.toList((List) destination$iv$iv);
        ClassifierDescriptor declarationDescriptor = constructor.mo1171getDeclarationDescriptor();
        if (expandTypeAliases && (declarationDescriptor instanceof TypeAliasDescriptor)) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType expandedType2 = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) declarationDescriptor, arguments);
            TypeAttributes expandedAttributes = toAttributes(this.c.getComponents().getTypeAttributeTranslators(), Annotations.Companion.create(CollectionsKt.plus((Iterable) annotations, (Iterable) expandedType2.getAnnotations())), constructor, this.c.getContainingDeclaration());
            expandedType = expandedType2.makeNullableAsSpecified(KotlinTypeKt.isNullable(expandedType2) || proto.getNullable()).replaceAttributes(expandedAttributes);
        } else if (Flags.SUSPEND_TYPE.get(proto.getFlags()).booleanValue()) {
            expandedType = createSuspendFunctionType(attributes, constructor, arguments, proto.getNullable());
        } else {
            expandedType = KotlinTypeFactory.simpleType$default(attributes, constructor, arguments, proto.getNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
            if (Flags.DEFINITELY_NOT_NULL_TYPE.get(proto.getFlags()).booleanValue()) {
                DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, expandedType, true, false, 4, null);
                if (makeDefinitelyNotNull$default == null) {
                    throw new IllegalStateException(("null DefinitelyNotNullType for '" + expandedType + '\'').toString());
                }
                expandedType = makeDefinitelyNotNull$default;
            }
        }
        ProtoBuf.Type it = ProtoTypeTableUtilKt.abbreviatedType(proto, this.c.getTypeTable());
        if (it == null || (computedType = SpecialTypesKt.withAbbreviation(expandedType, simpleType(it, false))) == null) {
            return expandedType;
        }
        return computedType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List simpleType$lambda$0(TypeDeserializer this$0, ProtoBuf.Type $proto) {
        return this$0.c.getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations($proto, this$0.c.getNameResolver());
    }

    private static final List<ProtoBuf.Type.Argument> simpleType$collectAllArguments(ProtoBuf.Type $this$simpleType_u24collectAllArguments, TypeDeserializer this$0) {
        List<ProtoBuf.Type.Argument> argumentList = $this$simpleType_u24collectAllArguments.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(argumentList, "getArgumentList(...)");
        List<ProtoBuf.Type.Argument> list = argumentList;
        ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType($this$simpleType_u24collectAllArguments, this$0.c.getTypeTable());
        List<ProtoBuf.Type.Argument> simpleType$collectAllArguments = outerType != null ? simpleType$collectAllArguments(outerType, this$0) : null;
        if (simpleType$collectAllArguments == null) {
            simpleType$collectAllArguments = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus((Collection) list, (Iterable) simpleType$collectAllArguments);
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(final TypeDeserializer this$0, ProtoBuf.Type $proto, int classIdIndex) {
        ClassId classId = NameResolverUtilKt.getClassId(this$0.c.getNameResolver(), classIdIndex);
        List typeParametersCount = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence($proto, new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$3
            private final TypeDeserializer arg$0;

            {
                this.arg$0 = this$0;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ProtoBuf.Type typeConstructor$notFoundClass$lambda$0;
                typeConstructor$notFoundClass$lambda$0 = TypeDeserializer.typeConstructor$notFoundClass$lambda$0(this.arg$0, (ProtoBuf.Type) obj);
                return typeConstructor$notFoundClass$lambda$0;
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                int typeConstructor$notFoundClass$lambda$1;
                typeConstructor$notFoundClass$lambda$1 = TypeDeserializer.typeConstructor$notFoundClass$lambda$1((ProtoBuf.Type) obj);
                return Integer.valueOf(typeConstructor$notFoundClass$lambda$1);
            }
        }));
        int classNestingLevel = SequencesKt.count(SequencesKt.generateSequence(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object receiver0) {
                return ((ClassId) receiver0).getOuterClassId();
            }
        }));
        while (typeParametersCount.size() < classNestingLevel) {
            typeParametersCount.add(0);
        }
        return this$0.c.getComponents().getNotFoundClasses().getClass(classId, typeParametersCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProtoBuf.Type typeConstructor$notFoundClass$lambda$0(TypeDeserializer this$0, ProtoBuf.Type it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ProtoTypeTableUtilKt.outerType(it, this$0.c.getTypeTable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int typeConstructor$notFoundClass$lambda$1(ProtoBuf.Type it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getArgumentCount();
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type proto) {
        ClassDescriptor classifier;
        Object obj;
        if (proto.hasClassName()) {
            classifier = this.classifierDescriptors.invoke(Integer.valueOf(proto.getClassName()));
            if (classifier == null) {
                classifier = typeConstructor$notFoundClass(this, proto, proto.getClassName());
            }
        } else if (proto.hasTypeParameter()) {
            TypeParameterDescriptor loadTypeParameter = loadTypeParameter(proto.getTypeParameter());
            if (loadTypeParameter == null) {
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, String.valueOf(proto.getTypeParameter()), this.containerPresentableName);
            }
            classifier = loadTypeParameter;
        } else if (proto.hasTypeParameterName()) {
            String name = this.c.getNameResolver().getString(proto.getTypeParameterName());
            Iterator<T> it = getOwnTypeParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                TypeParameterDescriptor it2 = (TypeParameterDescriptor) obj;
                if (Intrinsics.areEqual(it2.getName().asString(), name)) {
                    break;
                }
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) obj;
            if (typeParameterDescriptor == null) {
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, name, this.c.getContainingDeclaration().toString());
            }
            classifier = typeParameterDescriptor;
        } else if (proto.hasTypeAliasName()) {
            classifier = this.typeAliasDescriptors.invoke(Integer.valueOf(proto.getTypeAliasName()));
            if (classifier == null) {
                classifier = typeConstructor$notFoundClass(this, proto, proto.getTypeAliasName());
            }
        } else {
            return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
        }
        TypeConstructor typeConstructor = classifier.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return typeConstructor;
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes attributes, TypeConstructor functionTypeConstructor, List<? extends TypeProjection> list, boolean nullable) {
        SimpleType simpleType = null;
        switch (functionTypeConstructor.getParameters().size() - list.size()) {
            case 0:
                simpleType = createSuspendFunctionTypeForBasicCase(attributes, functionTypeConstructor, list, nullable);
                break;
            case 1:
                int arity = list.size() - 1;
                if (arity >= 0) {
                    TypeConstructor typeConstructor = functionTypeConstructor.getBuiltIns().getSuspendFunction(arity).getTypeConstructor();
                    Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
                    simpleType = KotlinTypeFactory.simpleType$default(attributes, typeConstructor, list, nullable, (KotlinTypeRefiner) null, 16, (Object) null);
                    break;
                }
                break;
        }
        SimpleType result = simpleType;
        return result == null ? ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, list, functionTypeConstructor, new String[0]) : result;
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes attributes, TypeConstructor functionTypeConstructor, List<? extends TypeProjection> list, boolean nullable) {
        SimpleType functionType = KotlinTypeFactory.simpleType$default(attributes, functionTypeConstructor, list, nullable, (KotlinTypeRefiner) null, 16, (Object) null);
        if (FunctionTypesKt.isFunctionType(functionType)) {
            return transformRuntimeFunctionTypeToSuspendFunction(functionType);
        }
        return null;
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType funType) {
        KotlinType continuationArgumentType;
        TypeProjection typeProjection = (TypeProjection) CollectionsKt.lastOrNull((List<? extends Object>) FunctionTypesKt.getValueParameterTypesFromFunctionType(funType));
        if (typeProjection == null || (continuationArgumentType = typeProjection.getType()) == null) {
            return null;
        }
        ClassifierDescriptor mo1171getDeclarationDescriptor = continuationArgumentType.getConstructor().mo1171getDeclarationDescriptor();
        FqName continuationArgumentFqName = mo1171getDeclarationDescriptor != null ? DescriptorUtilsKt.getFqNameSafe(mo1171getDeclarationDescriptor) : null;
        if (continuationArgumentType.getArguments().size() != 1 || (!Intrinsics.areEqual(continuationArgumentFqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) && !Intrinsics.areEqual(continuationArgumentFqName, TypeDeserializerKt.access$getEXPERIMENTAL_CONTINUATION_FQ_NAME$p()))) {
            return (SimpleType) funType;
        }
        KotlinType suspendReturnType = ((TypeProjection) CollectionsKt.single((List<? extends Object>) continuationArgumentType.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(suspendReturnType, "getType(...)");
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        CallableDescriptor callableDescriptor = containingDeclaration instanceof CallableDescriptor ? (CallableDescriptor) containingDeclaration : null;
        if (Intrinsics.areEqual(callableDescriptor != null ? DescriptorUtilsKt.fqNameOrNull(callableDescriptor) : null, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return createSimpleSuspendFunctionType(funType, suspendReturnType);
        }
        return createSimpleSuspendFunctionType(funType, suspendReturnType);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType funType, KotlinType suspendReturnType) {
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(funType);
        Annotations annotations = funType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(funType);
        List<KotlinType> contextReceiverTypesFromFunctionType = FunctionTypesKt.getContextReceiverTypesFromFunctionType(funType);
        Iterable $this$map$iv = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(funType), 1);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            TypeProjection p0 = (TypeProjection) item$iv$iv;
            destination$iv$iv.add(p0.getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, contextReceiverTypesFromFunctionType, (List) destination$iv$iv, null, suspendReturnType, true).makeNullableAsSpecified(funType.isMarkedNullable());
    }

    private final TypeParameterDescriptor loadTypeParameter(int typeParameterId) {
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(Integer.valueOf(typeParameterId));
        if (typeParameterDescriptor == null) {
            TypeDeserializer typeDeserializer = this.parent;
            if (typeDeserializer != null) {
                return typeDeserializer.loadTypeParameter(typeParameterId);
            }
            return null;
        }
        return typeParameterDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeClassifierDescriptor(int fqNameIndex) {
        ClassId id = NameResolverUtilKt.getClassId(this.c.getNameResolver(), fqNameIndex);
        if (id.isLocal()) {
            return this.c.getComponents().deserializeClass(id);
        }
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), id);
    }

    private final SimpleType computeLocalClassifierReplacementType(int className) {
        if (NameResolverUtilKt.getClassId(this.c.getNameResolver(), className).isLocal()) {
            return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeTypeAliasDescriptor(int fqNameIndex) {
        ClassId id = NameResolverUtilKt.getClassId(this.c.getNameResolver(), fqNameIndex);
        if (id.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), id);
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor parameter, ProtoBuf.Type.Argument typeArgumentProto) {
        if (typeArgumentProto.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            if (parameter == null) {
                return new StarProjectionForAbsentTypeParameter(this.c.getComponents().getModuleDescriptor().getBuiltIns());
            }
            return new StarProjectionImpl(parameter);
        }
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        ProtoBuf.Type.Argument.Projection projection = typeArgumentProto.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection, "getProjection(...)");
        Variance projection2 = protoEnumFlags.variance(projection);
        ProtoBuf.Type type = ProtoTypeTableUtilKt.type(typeArgumentProto, this.c.getTypeTable());
        if (type == null) {
            return new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, typeArgumentProto.toString()));
        }
        return new TypeProjectionImpl(projection2, type(type));
    }

    public String toString() {
        return this.debugName + (this.parent == null ? "" : ". Child of " + this.parent.debugName);
    }
}