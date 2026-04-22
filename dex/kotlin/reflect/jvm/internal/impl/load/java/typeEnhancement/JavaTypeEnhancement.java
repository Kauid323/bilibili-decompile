package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: typeEnhancement.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType type, int subtreeSize) {
            this.type = type;
            this.subtreeSize = subtreeSize;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: typeEnhancement.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType type, int subtreeSize, boolean forWarnings) {
            this.type = type;
            this.subtreeSize = subtreeSize;
            this.forWarnings = forWarnings;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }
    }

    public final KotlinType enhance(KotlinType $this$enhance, Function1<? super Integer, JavaTypeQualifiers> qualifiers, boolean isSuperTypesEnhancement) {
        Intrinsics.checkNotNullParameter($this$enhance, "<this>");
        Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
        return enhancePossiblyFlexible($this$enhance.unwrap(), qualifiers, 0, isSuperTypesEnhancement).getType();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b8, code lost:
        if (r1 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Result enhancePossiblyFlexible(UnwrappedType $this$enhancePossiblyFlexible, Function1<? super Integer, JavaTypeQualifiers> function1, int index, boolean isSuperTypesEnhancement) {
        UnwrappedType enhancement;
        RawTypeImpl rawTypeImpl = null;
        if (KotlinTypeKt.isError($this$enhancePossiblyFlexible)) {
            return new Result(null, 1);
        }
        if (!($this$enhancePossiblyFlexible instanceof FlexibleType)) {
            if ($this$enhancePossiblyFlexible instanceof SimpleType) {
                SimpleResult result = enhanceInflexible$default(this, (SimpleType) $this$enhancePossiblyFlexible, function1, index, TypeComponentPosition.INFLEXIBLE, false, isSuperTypesEnhancement, 8, null);
                return new Result(result.getForWarnings() ? TypeWithEnhancementKt.wrapEnhancement($this$enhancePossiblyFlexible, result.getType()) : result.getType(), result.getSubtreeSize());
            }
            throw new NoWhenBranchMatchedException();
        }
        boolean isRawType = $this$enhancePossiblyFlexible instanceof RawType;
        SimpleResult lowerResult = enhanceInflexible(((FlexibleType) $this$enhancePossiblyFlexible).getLowerBound(), function1, index, TypeComponentPosition.FLEXIBLE_LOWER, isRawType, isSuperTypesEnhancement);
        SimpleResult upperResult = enhanceInflexible(((FlexibleType) $this$enhancePossiblyFlexible).getUpperBound(), function1, index, TypeComponentPosition.FLEXIBLE_UPPER, isRawType, isSuperTypesEnhancement);
        if (lowerResult.getSubtreeSize() == upperResult.getSubtreeSize()) {
            if (lowerResult.getType() != null || upperResult.getType() != null) {
                if (lowerResult.getForWarnings() || upperResult.getForWarnings()) {
                    SimpleType it = upperResult.getType();
                    if (it != null) {
                        SimpleType type = lowerResult.getType();
                        if (type == null) {
                            type = it;
                        }
                        enhancement = KotlinTypeFactory.flexibleType(type, it);
                    }
                    UnwrappedType type2 = lowerResult.getType();
                    Intrinsics.checkNotNull(type2);
                    enhancement = type2;
                    rawTypeImpl = TypeWithEnhancementKt.wrapEnhancement($this$enhancePossiblyFlexible, enhancement);
                } else if (isRawType) {
                    SimpleType type3 = lowerResult.getType();
                    if (type3 == null) {
                        type3 = ((FlexibleType) $this$enhancePossiblyFlexible).getLowerBound();
                    }
                    SimpleType type4 = upperResult.getType();
                    if (type4 == null) {
                        type4 = ((FlexibleType) $this$enhancePossiblyFlexible).getUpperBound();
                    }
                    rawTypeImpl = new RawTypeImpl(type3, type4);
                } else {
                    SimpleType type5 = lowerResult.getType();
                    if (type5 == null) {
                        type5 = ((FlexibleType) $this$enhancePossiblyFlexible).getLowerBound();
                    }
                    SimpleType type6 = upperResult.getType();
                    if (type6 == null) {
                        type6 = ((FlexibleType) $this$enhancePossiblyFlexible).getUpperBound();
                    }
                    rawTypeImpl = KotlinTypeFactory.flexibleType(type5, type6);
                }
            }
            UnwrappedType enhancement2 = rawTypeImpl;
            return new Result(enhancement2, lowerResult.getSubtreeSize());
        }
        throw new AssertionError("Different tree sizes of bounds: lower = (" + ((FlexibleType) $this$enhancePossiblyFlexible).getLowerBound() + ", " + lowerResult.getSubtreeSize() + "), upper = (" + ((FlexibleType) $this$enhancePossiblyFlexible).getUpperBound() + ", " + upperResult.getSubtreeSize() + ')');
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        boolean z3;
        boolean z4;
        if ((i2 & 8) == 0) {
            z3 = z;
        } else {
            z3 = false;
        }
        if ((i2 & 16) == 0) {
            z4 = z2;
        } else {
            z4 = false;
        }
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i, typeComponentPosition, z3, z4);
    }

    private final SimpleResult enhanceInflexible(SimpleType $this$enhanceInflexible, Function1<? super Integer, JavaTypeQualifiers> function1, int index, TypeComponentPosition position, boolean isBoundOfRawType, boolean isSuperTypesEnhancement) {
        ClassifierDescriptor enhancedClassifier;
        Boolean enhancedNullability;
        TypeConstructor constructor;
        EnhancedTypeAnnotations enhancedTypeAnnotations;
        Annotations newAnnotations;
        boolean z;
        boolean z2;
        Iterable other$iv;
        boolean shouldEnhanceArguments;
        Result result;
        TypeProjection makeStarProjection;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        boolean z3 = isSuperTypesEnhancement;
        boolean shouldEnhance = TypeComponentPositionKt.shouldEnhance(position);
        boolean shouldEnhanceArguments2 = (z3 && isBoundOfRawType) ? false : true;
        if (shouldEnhance || !$this$enhanceInflexible.getArguments().isEmpty()) {
            ClassifierDescriptor originalClass = $this$enhanceInflexible.getConstructor().mo1171getDeclarationDescriptor();
            if (originalClass == null) {
                return new SimpleResult(null, 1, false);
            }
            JavaTypeQualifiers effectiveQualifiers = function12.invoke(Integer.valueOf(index));
            enhancedClassifier = TypeEnhancementKt.enhanceMutability(originalClass, effectiveQualifiers, position);
            enhancedNullability = TypeEnhancementKt.getEnhancedNullability(effectiveQualifiers, position);
            if (enhancedClassifier == null || (constructor = enhancedClassifier.getTypeConstructor()) == null) {
                constructor = $this$enhanceInflexible.getConstructor();
            }
            TypeConstructor typeConstructor = constructor;
            int globalArgIndex = index + 1;
            Iterable $this$zip$iv = $this$enhanceInflexible.getArguments();
            Iterable parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            Iterable other$iv2 = parameters;
            Iterator first$iv = $this$zip$iv.iterator();
            Iterator second$iv = other$iv2.iterator();
            int collectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault($this$zip$iv, 10);
            int $i$f$zip = CollectionsKt.collectionSizeOrDefault(other$iv2, 10);
            ArrayList list$iv = new ArrayList(Math.min(collectionSizeOrDefault, $i$f$zip));
            while (first$iv.hasNext() && second$iv.hasNext()) {
                Object next = first$iv.next();
                TypeParameterDescriptor parameter = (TypeParameterDescriptor) second$iv.next();
                TypeProjection arg = (TypeProjection) next;
                if (shouldEnhanceArguments2) {
                    other$iv = other$iv2;
                    shouldEnhanceArguments = shouldEnhanceArguments2;
                    if (!arg.isStarProjection()) {
                        result = enhancePossiblyFlexible(arg.getType().unwrap(), function12, globalArgIndex, z3);
                    } else if (function12.invoke(Integer.valueOf(globalArgIndex)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                        UnwrappedType it = arg.getType().unwrap();
                        result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(it).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(it).makeNullableAsSpecified(true)), 1);
                    } else {
                        result = new Result(null, 1);
                    }
                } else {
                    other$iv = other$iv2;
                    shouldEnhanceArguments = shouldEnhanceArguments2;
                    result = new Result(null, 0);
                }
                Result enhanced = result;
                globalArgIndex += enhanced.getSubtreeSize();
                if (enhanced.getType() != null) {
                    KotlinType type = enhanced.getType();
                    Variance projectionKind = arg.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                    makeStarProjection = TypeUtilsKt.createProjection(type, projectionKind, parameter);
                } else if (enhancedClassifier == null || arg.isStarProjection()) {
                    makeStarProjection = enhancedClassifier != null ? TypeUtils.makeStarProjection(parameter) : null;
                } else {
                    KotlinType type2 = arg.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                    Variance projectionKind2 = arg.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind2, "getProjectionKind(...)");
                    makeStarProjection = TypeUtilsKt.createProjection(type2, projectionKind2, parameter);
                }
                list$iv.add(makeStarProjection);
                function12 = function1;
                z3 = isSuperTypesEnhancement;
                other$iv2 = other$iv;
                shouldEnhanceArguments2 = shouldEnhanceArguments;
            }
            ArrayList enhancedArguments = list$iv;
            int subtreeSize = globalArgIndex - index;
            if (enhancedClassifier == null && enhancedNullability == null) {
                ArrayList $this$all$iv = enhancedArguments;
                if (!($this$all$iv instanceof Collection) || !$this$all$iv.isEmpty()) {
                    Iterator it2 = $this$all$iv.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = true;
                            break;
                        }
                        Object element$iv = it2.next();
                        TypeProjection it3 = (TypeProjection) element$iv;
                        if (it3 == null) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (!z2) {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = true;
                }
                if (z) {
                    return new SimpleResult(null, subtreeSize, false);
                }
            }
            Annotations[] annotationsArr = new Annotations[3];
            annotationsArr[0] = $this$enhanceInflexible.getAnnotations();
            enhancedTypeAnnotations = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
            if (!(enhancedClassifier != null)) {
                enhancedTypeAnnotations = null;
            }
            annotationsArr[1] = enhancedTypeAnnotations;
            Annotations enhanced_nullability_annotations = TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS();
            Annotations it4 = enhancedNullability != null ? 1 : null;
            annotationsArr[2] = it4 != null ? enhanced_nullability_annotations : null;
            newAnnotations = TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull((Object[]) annotationsArr));
            TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(newAnnotations);
            ArrayList $this$zip$iv2 = enhancedArguments;
            Iterable other$iv3 = $this$enhanceInflexible.getArguments();
            Iterator first$iv2 = $this$zip$iv2.iterator();
            Iterator second$iv2 = other$iv3.iterator();
            ArrayList list$iv2 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault($this$zip$iv2, 10), CollectionsKt.collectionSizeOrDefault(other$iv3, 10)));
            while (first$iv2.hasNext() && second$iv2.hasNext()) {
                Object next2 = first$iv2.next();
                TypeProjection original = (TypeProjection) second$iv2.next();
                TypeProjection enhanced2 = (TypeProjection) next2;
                if (enhanced2 != null) {
                    original = enhanced2;
                }
                list$iv2.add(original);
            }
            SimpleType enhancedType = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor, list$iv2, enhancedNullability != null ? enhancedNullability.booleanValue() : $this$enhanceInflexible.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
            SimpleType enhancement = effectiveQualifiers.getDefinitelyNotNull() ? notNullTypeParameter(enhancedType) : enhancedType;
            boolean nullabilityForWarning = enhancedNullability != null && effectiveQualifiers.isNullabilityQualifierForWarning();
            return new SimpleResult(enhancement, subtreeSize, nullabilityForWarning);
        }
        return new SimpleResult(null, 1, false);
    }

    private final SimpleType notNullTypeParameter(SimpleType enhancedType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(enhancedType, true);
        }
        return new NotNullTypeParameterImpl(enhancedType);
    }
}