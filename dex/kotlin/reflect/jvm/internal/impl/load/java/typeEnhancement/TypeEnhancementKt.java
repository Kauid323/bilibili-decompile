package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;

/* compiled from: typeEnhancement.kt */
public final class TypeEnhancementKt {
    private static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;
    private static final Annotations ENHANCED_NULLABILITY_ANNOTATIONS;

    /* compiled from: typeEnhancement.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NullabilityQualifier.values().length];
            try {
                iArr[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean hasEnhancedNullability(KotlinType $this$hasEnhancedNullability) {
        Intrinsics.checkNotNullParameter($this$hasEnhancedNullability, "<this>");
        return TypeEnhancementUtilsKt.hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, $this$hasEnhancedNullability);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Annotations compositeAnnotationsOrSingle(List<? extends Annotations> list) {
        switch (list.size()) {
            case 0:
                throw new IllegalStateException("At least one Annotations object expected".toString());
            case 1:
                return (Annotations) CollectionsKt.single((List<? extends Object>) list);
            default:
                return new CompositeAnnotations(CollectionsKt.toList(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassifierDescriptor enhanceMutability(ClassifierDescriptor $this$enhanceMutability, JavaTypeQualifiers qualifiers, TypeComponentPosition position) {
        JavaToKotlinClassMapper mapper = JavaToKotlinClassMapper.INSTANCE;
        if (TypeComponentPositionKt.shouldEnhance(position) && ($this$enhanceMutability instanceof ClassDescriptor)) {
            if (qualifiers.getMutability() == MutabilityQualifier.READ_ONLY && position == TypeComponentPosition.FLEXIBLE_LOWER && mapper.isMutable((ClassDescriptor) $this$enhanceMutability)) {
                return mapper.convertMutableToReadOnly((ClassDescriptor) $this$enhanceMutability);
            }
            if (qualifiers.getMutability() == MutabilityQualifier.MUTABLE && position == TypeComponentPosition.FLEXIBLE_UPPER && mapper.isReadOnly((ClassDescriptor) $this$enhanceMutability)) {
                return mapper.convertReadOnlyToMutable((ClassDescriptor) $this$enhanceMutability);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean getEnhancedNullability(JavaTypeQualifiers qualifiers, TypeComponentPosition position) {
        if (TypeComponentPositionKt.shouldEnhance(position)) {
            NullabilityQualifier nullability = qualifiers.getNullability();
            switch (nullability == null ? -1 : WhenMappings.$EnumSwitchMapping$0[nullability.ordinal()]) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    return null;
            }
        }
        return null;
    }

    static {
        FqName ENHANCED_NULLABILITY_ANNOTATION = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(ENHANCED_NULLABILITY_ANNOTATION);
        FqName ENHANCED_MUTABILITY_ANNOTATION = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(ENHANCED_MUTABILITY_ANNOTATION, "ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(ENHANCED_MUTABILITY_ANNOTATION);
    }

    public static final Annotations getENHANCED_NULLABILITY_ANNOTATIONS() {
        return ENHANCED_NULLABILITY_ANNOTATIONS;
    }
}