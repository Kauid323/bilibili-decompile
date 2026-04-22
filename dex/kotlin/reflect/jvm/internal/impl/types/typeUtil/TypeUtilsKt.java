package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AbstractStubType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;

/* compiled from: TypeUtils.kt */
public final class TypeUtilsKt {
    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        return hasTypeParameterRecursiveBounds$default(typeParameter, null, null, 6, null);
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType $this$builtIns) {
        Intrinsics.checkNotNullParameter($this$builtIns, "<this>");
        KotlinBuiltIns builtIns = $this$builtIns.getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
        return builtIns;
    }

    public static final KotlinType makeNullable(KotlinType $this$makeNullable) {
        Intrinsics.checkNotNullParameter($this$makeNullable, "<this>");
        KotlinType makeNullable = TypeUtils.makeNullable($this$makeNullable);
        Intrinsics.checkNotNullExpressionValue(makeNullable, "makeNullable(...)");
        return makeNullable;
    }

    public static final KotlinType makeNotNullable(KotlinType $this$makeNotNullable) {
        Intrinsics.checkNotNullParameter($this$makeNotNullable, "<this>");
        KotlinType makeNotNullable = TypeUtils.makeNotNullable($this$makeNotNullable);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(...)");
        return makeNotNullable;
    }

    public static final boolean isNothing(KotlinType $this$isNothing) {
        Intrinsics.checkNotNullParameter($this$isNothing, "<this>");
        return KotlinBuiltIns.isNothing($this$isNothing);
    }

    public static final boolean isBoolean(KotlinType $this$isBoolean) {
        Intrinsics.checkNotNullParameter($this$isBoolean, "<this>");
        return KotlinBuiltIns.isBoolean($this$isBoolean);
    }

    public static final boolean isTypeParameter(KotlinType $this$isTypeParameter) {
        Intrinsics.checkNotNullParameter($this$isTypeParameter, "<this>");
        return TypeUtils.isTypeParameter($this$isTypeParameter);
    }

    public static final boolean containsTypeParameter(KotlinType $this$containsTypeParameter) {
        Intrinsics.checkNotNullParameter($this$containsTypeParameter, "<this>");
        return TypeUtils.contains($this$containsTypeParameter, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Boolean containsTypeParameter$lambda$0;
                containsTypeParameter$lambda$0 = TypeUtilsKt.containsTypeParameter$lambda$0((UnwrappedType) obj);
                return containsTypeParameter$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean containsTypeParameter$lambda$0(UnwrappedType t) {
        return Boolean.valueOf(TypeUtils.isTypeParameter(t));
    }

    public static final boolean isSubtypeOf(KotlinType $this$isSubtypeOf, KotlinType superType) {
        Intrinsics.checkNotNullParameter($this$isSubtypeOf, "<this>");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf($this$isSubtypeOf, superType);
    }

    public static final KotlinType replaceAnnotations(KotlinType $this$replaceAnnotations, Annotations newAnnotations) {
        Intrinsics.checkNotNullParameter($this$replaceAnnotations, "<this>");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        return ($this$replaceAnnotations.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? $this$replaceAnnotations : $this$replaceAnnotations.unwrap().replaceAttributes(TypeAttributesKt.replaceAnnotations($this$replaceAnnotations.getAttributes(), newAnnotations));
    }

    public static final TypeProjection createProjection(KotlinType type, Variance projectionKind, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(projectionKind, "projectionKind");
        return new TypeProjectionImpl((typeParameterDescriptor != null ? typeParameterDescriptor.getVariance() : null) == projectionKind ? Variance.INVARIANT : projectionKind, type);
    }

    public static final TypeProjection asTypeProjection(KotlinType $this$asTypeProjection) {
        Intrinsics.checkNotNullParameter($this$asTypeProjection, "<this>");
        return new TypeProjectionImpl($this$asTypeProjection);
    }

    public static final boolean contains(KotlinType $this$contains, Function1<? super UnwrappedType, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return TypeUtils.contains($this$contains, predicate);
    }

    public static final KotlinType replaceArgumentsWithStarProjections(KotlinType $this$replaceArgumentsWithStarProjections) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter($this$replaceArgumentsWithStarProjections, "<this>");
        UnwrappedType unwrapped$iv = $this$replaceArgumentsWithStarProjections.unwrap();
        if (unwrapped$iv instanceof FlexibleType) {
            SimpleType $this$replaceArgumentsByParametersWith$iv$iv = ((FlexibleType) unwrapped$iv).getLowerBound();
            if (!$this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().mo1171getDeclarationDescriptor() != null) {
                Iterable parameters = $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                Iterable $this$map$iv$iv$iv = parameters;
                Collection destination$iv$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10));
                for (Object item$iv$iv$iv$iv : $this$map$iv$iv$iv) {
                    TypeParameterDescriptor p0 = (TypeParameterDescriptor) item$iv$iv$iv$iv;
                    destination$iv$iv$iv$iv.add(new StarProjectionImpl(p0));
                }
                List newArguments$iv$iv = (List) destination$iv$iv$iv$iv;
                $this$replaceArgumentsByParametersWith$iv$iv = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv, newArguments$iv$iv, null, 2, null);
            }
            SimpleType $this$replaceArgumentsByParametersWith$iv$iv2 = ((FlexibleType) unwrapped$iv).getUpperBound();
            if (!$this$replaceArgumentsByParametersWith$iv$iv2.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv2.getConstructor().mo1171getDeclarationDescriptor() != null) {
                Iterable parameters2 = $this$replaceArgumentsByParametersWith$iv$iv2.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters2, "getParameters(...)");
                Iterable $this$map$iv$iv$iv2 = parameters2;
                Collection destination$iv$iv$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv2, 10));
                for (Object item$iv$iv$iv$iv2 : $this$map$iv$iv$iv2) {
                    TypeParameterDescriptor p02 = (TypeParameterDescriptor) item$iv$iv$iv$iv2;
                    destination$iv$iv$iv$iv2.add(new StarProjectionImpl(p02));
                }
                List newArguments$iv$iv2 = (List) destination$iv$iv$iv$iv2;
                $this$replaceArgumentsByParametersWith$iv$iv2 = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv2, newArguments$iv$iv2, null, 2, null);
            }
            simpleType = KotlinTypeFactory.flexibleType($this$replaceArgumentsByParametersWith$iv$iv, $this$replaceArgumentsByParametersWith$iv$iv2);
        } else if (!(unwrapped$iv instanceof SimpleType)) {
            throw new NoWhenBranchMatchedException();
        } else {
            SimpleType $this$replaceArgumentsByParametersWith$iv$iv3 = (SimpleType) unwrapped$iv;
            if (!$this$replaceArgumentsByParametersWith$iv$iv3.getConstructor().getParameters().isEmpty() && $this$replaceArgumentsByParametersWith$iv$iv3.getConstructor().mo1171getDeclarationDescriptor() != null) {
                Iterable parameters3 = $this$replaceArgumentsByParametersWith$iv$iv3.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters3, "getParameters(...)");
                Iterable $this$map$iv$iv$iv3 = parameters3;
                Collection destination$iv$iv$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv3, 10));
                for (Object item$iv$iv$iv$iv3 : $this$map$iv$iv$iv3) {
                    TypeParameterDescriptor p03 = (TypeParameterDescriptor) item$iv$iv$iv$iv3;
                    destination$iv$iv$iv$iv3.add(new StarProjectionImpl(p03));
                }
                List newArguments$iv$iv3 = (List) destination$iv$iv$iv$iv3;
                $this$replaceArgumentsByParametersWith$iv$iv3 = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv3, newArguments$iv$iv3, null, 2, null);
            }
            simpleType = $this$replaceArgumentsByParametersWith$iv$iv3;
        }
        return TypeWithEnhancementKt.inheritEnhancement(simpleType, unwrapped$iv);
    }

    public static final Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds(KotlinType $this$extractTypeParametersFromUpperBounds, Set<? extends TypeParameterDescriptor> set) {
        Intrinsics.checkNotNullParameter($this$extractTypeParametersFromUpperBounds, "<this>");
        Set it = new LinkedHashSet();
        extractTypeParametersFromUpperBounds($this$extractTypeParametersFromUpperBounds, $this$extractTypeParametersFromUpperBounds, it, set);
        return it;
    }

    private static final void extractTypeParametersFromUpperBounds(KotlinType $this$extractTypeParametersFromUpperBounds, KotlinType baseType, Set<TypeParameterDescriptor> set, Set<? extends TypeParameterDescriptor> set2) {
        ClassifierDescriptor declarationDescriptor = $this$extractTypeParametersFromUpperBounds.getConstructor().mo1171getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            if (!Intrinsics.areEqual($this$extractTypeParametersFromUpperBounds.getConstructor(), baseType.getConstructor())) {
                set.add(declarationDescriptor);
                return;
            }
            for (KotlinType upperBound : ((TypeParameterDescriptor) declarationDescriptor).getUpperBounds()) {
                Intrinsics.checkNotNull(upperBound);
                extractTypeParametersFromUpperBounds(upperBound, baseType, set, set2);
            }
            return;
        }
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$extractTypeParametersFromUpperBounds.getConstructor().mo1171getDeclarationDescriptor();
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = mo1171getDeclarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) mo1171getDeclarationDescriptor : null;
        List typeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
        int i = 0;
        for (TypeProjection argument : $this$extractTypeParametersFromUpperBounds.getArguments()) {
            int i2 = i;
            boolean isTypeParameterVisited = true;
            i++;
            TypeParameterDescriptor typeParameter = typeParameters != null ? (TypeParameterDescriptor) CollectionsKt.getOrNull(typeParameters, i2) : null;
            isTypeParameterVisited = (typeParameter == null || set2 == null || !set2.contains(typeParameter)) ? false : false;
            if (!isTypeParameterVisited && !argument.isStarProjection() && !CollectionsKt.contains(set, argument.getType().getConstructor().mo1171getDeclarationDescriptor()) && !Intrinsics.areEqual(argument.getType().getConstructor(), baseType.getConstructor())) {
                KotlinType type = argument.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                extractTypeParametersFromUpperBounds(type, baseType, set, set2);
            }
        }
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(TypeParameterDescriptor typeParameterDescriptor, TypeConstructor typeConstructor, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = null;
        }
        if ((i & 4) != 0) {
            set = null;
        }
        return hasTypeParameterRecursiveBounds(typeParameterDescriptor, typeConstructor, set);
    }

    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor typeParameter, TypeConstructor selfConstructor, Set<? extends TypeParameterDescriptor> set) {
        KotlinType upperBound;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Iterable upperBounds = typeParameter.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        Iterable $this$any$iv = upperBounds;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            KotlinType upperBound2 = (KotlinType) element$iv;
            Intrinsics.checkNotNull(upperBound2);
            if (containsSelfTypeParameter(upperBound2, typeParameter.getDefaultType().getConstructor(), set) && (selfConstructor == null || Intrinsics.areEqual(upperBound2.getConstructor(), selfConstructor))) {
                upperBound = 1;
                continue;
            } else {
                upperBound = null;
                continue;
            }
            if (upperBound != null) {
                return true;
            }
        }
        return false;
    }

    private static final boolean containsSelfTypeParameter(KotlinType $this$containsSelfTypeParameter, TypeConstructor baseConstructor, Set<? extends TypeParameterDescriptor> set) {
        boolean z;
        boolean z2 = true;
        if (Intrinsics.areEqual($this$containsSelfTypeParameter.getConstructor(), baseConstructor)) {
            return true;
        }
        ClassifierDescriptor mo1171getDeclarationDescriptor = $this$containsSelfTypeParameter.getConstructor().mo1171getDeclarationDescriptor();
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = mo1171getDeclarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) mo1171getDeclarationDescriptor : null;
        List typeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
        Iterable $this$any$iv = CollectionsKt.withIndex($this$containsSelfTypeParameter.getArguments());
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            IndexedValue indexedValue = (IndexedValue) element$iv;
            int i = indexedValue.component1();
            TypeProjection argument = (TypeProjection) indexedValue.component2();
            TypeParameterDescriptor typeParameter = typeParameters != null ? (TypeParameterDescriptor) CollectionsKt.getOrNull(typeParameters, i) : null;
            boolean isTypeParameterVisited = (typeParameter == null || set == null || !set.contains(typeParameter)) ? false : z2;
            if (isTypeParameterVisited || argument.isStarProjection()) {
                z = false;
            } else {
                KotlinType type = argument.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                z = containsSelfTypeParameter(type, baseConstructor, set);
            }
            if (z) {
                return true;
            }
            z2 = true;
        }
        return false;
    }

    public static final boolean containsTypeAliasParameters(KotlinType $this$containsTypeAliasParameters) {
        Intrinsics.checkNotNullParameter($this$containsTypeAliasParameters, "<this>");
        return contains($this$containsTypeAliasParameters, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean containsTypeAliasParameters$lambda$0;
                containsTypeAliasParameters$lambda$0 = TypeUtilsKt.containsTypeAliasParameters$lambda$0((UnwrappedType) obj);
                return Boolean.valueOf(containsTypeAliasParameters$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsTypeAliasParameters$lambda$0(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ClassifierDescriptor mo1171getDeclarationDescriptor = it.getConstructor().mo1171getDeclarationDescriptor();
        if (mo1171getDeclarationDescriptor != null) {
            return isTypeAliasParameter(mo1171getDeclarationDescriptor);
        }
        return false;
    }

    public static final boolean isTypeAliasParameter(ClassifierDescriptor $this$isTypeAliasParameter) {
        Intrinsics.checkNotNullParameter($this$isTypeAliasParameter, "<this>");
        return ($this$isTypeAliasParameter instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) $this$isTypeAliasParameter).getContainingDeclaration() instanceof TypeAliasDescriptor);
    }

    public static final boolean requiresTypeAliasExpansion(KotlinType $this$requiresTypeAliasExpansion) {
        Intrinsics.checkNotNullParameter($this$requiresTypeAliasExpansion, "<this>");
        return contains($this$requiresTypeAliasExpansion, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean requiresTypeAliasExpansion$lambda$0;
                requiresTypeAliasExpansion$lambda$0 = TypeUtilsKt.requiresTypeAliasExpansion$lambda$0((UnwrappedType) obj);
                return Boolean.valueOf(requiresTypeAliasExpansion$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requiresTypeAliasExpansion$lambda$0(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ClassifierDescriptor it2 = it.getConstructor().mo1171getDeclarationDescriptor();
        if (it2 != null) {
            return (it2 instanceof TypeAliasDescriptor) || (it2 instanceof TypeParameterDescriptor);
        }
        return false;
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:686)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:544)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        r5 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c A[EDGE_INSN: B:27:0x005c->B:21:0x005c ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.List r0 = r11.getUpperBounds()
            java.lang.String r1 = "getUpperBounds(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L74
            java.util.List r0 = r11.getUpperBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 0
            java.util.Iterator r3 = r0.iterator()
        L24:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L5b
            java.lang.Object r4 = r3.next()
            r6 = r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            r7 = 0
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r8 = r6.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r8 = r8.mo1171getDeclarationDescriptor()
            boolean r9 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r9 == 0) goto L42
            r5 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r5
        L42:
            r8 = 0
            if (r5 != 0) goto L46
            goto L57
        L46:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r9 = r5.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r10 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r9 == r10) goto L57
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r9 = r5.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r10 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r9 == r10) goto L57
            r8 = 1
        L57:
            if (r8 == 0) goto L24
            r5 = r4
            goto L5c
        L5b:
        L5c:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
            if (r5 != 0) goto L73
            java.util.List r0 = r11.getUpperBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            java.lang.String r1 = "first(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
        L73:
            return r5
        L74:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Upper bounds should not be empty: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r0 = r1.toString()
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    public static final boolean shouldBeUpdated(KotlinType $this$shouldBeUpdated) {
        return $this$shouldBeUpdated == null || contains($this$shouldBeUpdated, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean shouldBeUpdated$lambda$0;
                shouldBeUpdated$lambda$0 = TypeUtilsKt.shouldBeUpdated$lambda$0((UnwrappedType) obj);
                return Boolean.valueOf(shouldBeUpdated$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldBeUpdated$lambda$0(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it instanceof StubTypeForBuilderInference) || (it.getConstructor() instanceof TypeVariableTypeConstructorMarker) || KotlinTypeKt.isError(it);
    }

    public static final boolean isStubType(KotlinType $this$isStubType) {
        Intrinsics.checkNotNullParameter($this$isStubType, "<this>");
        if ($this$isStubType instanceof AbstractStubType) {
            return true;
        }
        KotlinType $this$isDefNotNullStubType$iv = (($this$isStubType instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) $this$isStubType).getOriginal() instanceof AbstractStubType)) ? 1 : null;
        return $this$isDefNotNullStubType$iv != null;
    }

    public static final boolean isStubTypeForBuilderInference(KotlinType $this$isStubTypeForBuilderInference) {
        Intrinsics.checkNotNullParameter($this$isStubTypeForBuilderInference, "<this>");
        if ($this$isStubTypeForBuilderInference instanceof StubTypeForBuilderInference) {
            return true;
        }
        KotlinType $this$isDefNotNullStubType$iv = (($this$isStubTypeForBuilderInference instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) $this$isStubTypeForBuilderInference).getOriginal() instanceof StubTypeForBuilderInference)) ? 1 : null;
        return $this$isDefNotNullStubType$iv != null;
    }

    public static final boolean isUnresolvedType(KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (type instanceof ErrorType) && ((ErrorType) type).getKind().isUnresolved();
    }
}