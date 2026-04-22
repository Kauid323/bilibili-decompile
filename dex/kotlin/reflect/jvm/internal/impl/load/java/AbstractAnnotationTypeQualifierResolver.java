package kotlin.reflect.jvm.internal.impl.load.java;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: AbstractAnnotationTypeQualifierResolver.kt */
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    private static final Companion Companion = new Companion(null);
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames;

    protected abstract Iterable<String> enumArguments(TAnnotation tannotation, boolean z);

    protected abstract FqName getFqName(TAnnotation tannotation);

    protected abstract Object getKey(TAnnotation tannotation);

    protected abstract Iterable<TAnnotation> getMetaAnnotations(TAnnotation tannotation);

    public abstract boolean isK2();

    public AbstractAnnotationTypeQualifierResolver(JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.resolvedNicknames = new ConcurrentHashMap<>();
    }

    private final TAnnotation findAnnotation(TAnnotation tannotation, FqName fqName) {
        for (TAnnotation tannotation2 : getMetaAnnotations(tannotation)) {
            if (Intrinsics.areEqual(getFqName(tannotation2), fqName)) {
                return tannotation2;
            }
        }
        return null;
    }

    private final boolean hasAnnotation(TAnnotation tannotation, FqName fqName) {
        Iterable<TAnnotation> $this$any$iv = getMetaAnnotations(tannotation);
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (TAnnotation tannotation2 : $this$any$iv) {
            if (Intrinsics.areEqual(getFqName(tannotation2), fqName)) {
                return true;
            }
        }
        return false;
    }

    public final TAnnotation resolveTypeQualifierAnnotation(TAnnotation annotation) {
        TAnnotation tannotation;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (this.javaTypeEnhancementState.getJsr305().isDisabled()) {
            return null;
        }
        if (CollectionsKt.contains(JvmAnnotationNamesKt.getBUILT_IN_TYPE_QUALIFIER_ANNOTATIONS(), getFqName(annotation)) || hasAnnotation(annotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME())) {
            return annotation;
        }
        if (hasAnnotation(annotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME())) {
            ConcurrentMap $this$getOrPut$iv = this.resolvedNicknames;
            Object key$iv = getKey(annotation);
            TAnnotation tannotation2 = (TAnnotation) $this$getOrPut$iv.get(key$iv);
            if (tannotation2 != null) {
                return tannotation2;
            }
            Iterator<TAnnotation> it = getMetaAnnotations(annotation).iterator();
            while (true) {
                if (!it.hasNext()) {
                    tannotation = null;
                    break;
                }
                tannotation = resolveTypeQualifierAnnotation(it.next());
                if (tannotation != null) {
                    break;
                }
            }
            if (tannotation == null) {
                return null;
            }
            TAnnotation tannotation3 = tannotation;
            TAnnotation tannotation4 = (TAnnotation) $this$getOrPut$iv.putIfAbsent(key$iv, tannotation3);
            return tannotation4 == null ? tannotation3 : tannotation4;
        }
        return null;
    }

    private final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation tannotation) {
        JavaDefaultQualifiers qualifierForDefaultingAnnotation;
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() || (qualifierForDefaultingAnnotation = JavaDefaultQualifiersKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(tannotation))) == null) {
            return null;
        }
        ReportLevel it = resolveDefaultAnnotationState(tannotation);
        if (!(it != ReportLevel.IGNORE)) {
            it = null;
        }
        if (it == null) {
            return null;
        }
        ReportLevel state = it;
        return JavaDefaultQualifiers.copy$default(qualifierForDefaultingAnnotation, NullabilityQualifierWithMigrationStatus.copy$default(qualifierForDefaultingAnnotation.getNullabilityQualifier(), null, state.isWarning(), 1, null), null, false, false, 14, null);
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation tannotation) {
        FqName annotationFqname = getFqName(tannotation);
        if (annotationFqname != null && JavaDefaultQualifiersKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(annotationFqname)) {
            return this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(annotationFqname);
        }
        return resolveJsr305AnnotationState(tannotation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> set) {
        if (set.contains(AnnotationQualifierApplicabilityType.TYPE_USE)) {
            return SetsKt.plus(SetsKt.minus(ArraysKt.toSet(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), (Iterable) set);
        }
        return set;
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation tannotation) {
        TAnnotation findAnnotation;
        TAnnotation tannotation2;
        boolean z;
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() || (findAnnotation = findAnnotation(tannotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME())) == null) {
            return null;
        }
        Iterable $this$firstOrNull$iv = getMetaAnnotations(tannotation);
        Iterator<TAnnotation> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotation2 = null;
                break;
            }
            tannotation2 = it.next();
            if (resolveTypeQualifierAnnotation(tannotation2) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (tannotation2 == null) {
            return null;
        }
        Object typeQualifier = tannotation2;
        Iterable $this$mapNotNullTo$iv = enumArguments(findAnnotation, true);
        Collection destination$iv = (Set) new LinkedHashSet();
        for (Object element$iv$iv : $this$mapNotNullTo$iv) {
            String it2 = (String) element$iv$iv;
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = JAVA_APPLICABILITY_TYPES.get(it2);
            if (annotationQualifierApplicabilityType != null) {
                destination$iv.add(annotationQualifierApplicabilityType);
            }
        }
        Set applicability = (Set) destination$iv;
        return new Pair<>(typeQualifier, allIfTypeUse(applicability));
    }

    public final boolean isTypeUseAnnotation(TAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        TAnnotation findAnnotation = findAnnotation(annotation, StandardNames.FqNames.target);
        if (findAnnotation == null) {
            return false;
        }
        Iterable $this$any$iv = enumArguments(findAnnotation, false);
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            String it = (String) element$iv;
            if (Intrinsics.areEqual(it, "TYPE")) {
                return true;
            }
        }
        return false;
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation tannotation) {
        Iterable<String> enumArguments;
        String enumValue;
        ReportLevel it = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(tannotation));
        if (it != null) {
            return it;
        }
        TAnnotation findAnnotation = findAnnotation(tannotation, JvmAnnotationNamesKt.getUNDER_MIGRATION_ANNOTATION_FQ_NAME());
        if (findAnnotation == null || (enumArguments = enumArguments(findAnnotation, false)) == null || (enumValue = (String) CollectionsKt.firstOrNull(enumArguments)) == null) {
            return null;
        }
        ReportLevel migrationLevel = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
        if (migrationLevel == null) {
            switch (enumValue.hashCode()) {
                case -2137067054:
                    if (enumValue.equals("IGNORE")) {
                        return ReportLevel.IGNORE;
                    }
                    return null;
                case -1838656823:
                    if (enumValue.equals("STRICT")) {
                        return ReportLevel.STRICT;
                    }
                    return null;
                case 2656902:
                    if (enumValue.equals("WARN")) {
                        return ReportLevel.WARN;
                    }
                    return null;
                default:
                    return null;
            }
        }
        return migrationLevel;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation tannotation, Function1<? super TAnnotation, Boolean> function1) {
        NullabilityQualifierWithMigrationStatus knownNullability;
        NullabilityQualifierWithMigrationStatus it = knownNullability(tannotation, function1.invoke(tannotation).booleanValue());
        if (it != null) {
            return it;
        }
        TAnnotation resolveTypeQualifierAnnotation = resolveTypeQualifierAnnotation(tannotation);
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel jsr305State = resolveJsr305AnnotationState(tannotation);
        if (jsr305State.isIgnore() || (knownNullability = knownNullability(resolveTypeQualifierAnnotation, function1.invoke(resolveTypeQualifierAnnotation).booleanValue())) == null) {
            return null;
        }
        return NullabilityQualifierWithMigrationStatus.copy$default(knownNullability, null, jsr305State.isWarning(), 1, null);
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(Iterable<? extends TAnnotation> annotations, Function1<? super TAnnotation, Boolean> forceWarning) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(forceWarning, "forceWarning");
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2 = null;
        for (TAnnotation tannotation : annotations) {
            NullabilityQualifierWithMigrationStatus found = nullabilityQualifierWithMigrationStatus2;
            NullabilityQualifierWithMigrationStatus extracted = extractNullability((AbstractAnnotationTypeQualifierResolver<TAnnotation>) tannotation, (Function1<? super AbstractAnnotationTypeQualifierResolver<TAnnotation>, Boolean>) forceWarning);
            if (found != null) {
                if (extracted != null && !Intrinsics.areEqual(extracted, found) && (!extracted.isForWarningOnly() || found.isForWarningOnly())) {
                    if (extracted.isForWarningOnly() || !found.isForWarningOnly()) {
                        return null;
                    }
                } else {
                    nullabilityQualifierWithMigrationStatus = found;
                    nullabilityQualifierWithMigrationStatus2 = nullabilityQualifierWithMigrationStatus;
                }
            }
            nullabilityQualifierWithMigrationStatus = extracted;
            nullabilityQualifierWithMigrationStatus2 = nullabilityQualifierWithMigrationStatus;
        }
        return nullabilityQualifierWithMigrationStatus2;
    }

    public final MutabilityQualifier extractMutability(Iterable<? extends TAnnotation> annotations) {
        MutabilityQualifier mutabilityQualifier;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        MutabilityQualifier mutabilityQualifier2 = null;
        for (TAnnotation tannotation : annotations) {
            MutabilityQualifier found = mutabilityQualifier2;
            FqName fqName = getFqName(tannotation);
            if (CollectionsKt.contains(JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), fqName)) {
                mutabilityQualifier = MutabilityQualifier.READ_ONLY;
            } else if (CollectionsKt.contains(JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), fqName)) {
                mutabilityQualifier = MutabilityQualifier.MUTABLE;
            } else {
                continue;
                mutabilityQualifier2 = found;
            }
            MutabilityQualifier it = mutabilityQualifier;
            if (found != null && found != it) {
                return null;
            }
            found = mutabilityQualifier;
            mutabilityQualifier2 = found;
        }
        return mutabilityQualifier2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation tannotation) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifier;
        JavaDefaultQualifiers it = resolveQualifierBuiltInDefaultAnnotation(tannotation);
        if (it != null) {
            return it;
        }
        Pair resolveTypeQualifierDefaultAnnotation = resolveTypeQualifierDefaultAnnotation(tannotation);
        if (resolveTypeQualifierDefaultAnnotation == null) {
            return null;
        }
        Object typeQualifier = resolveTypeQualifierDefaultAnnotation.component1();
        Set applicability = (Set) resolveTypeQualifierDefaultAnnotation.component2();
        ReportLevel jsr305State = resolveJsr305CustomState(tannotation);
        if (jsr305State == null) {
            jsr305State = resolveJsr305AnnotationState(typeQualifier);
        }
        if (jsr305State.isIgnore() || (nullabilityQualifier = extractNullability((AbstractAnnotationTypeQualifierResolver<TAnnotation>) typeQualifier, (Function1<? super AbstractAnnotationTypeQualifierResolver<TAnnotation>, Boolean>) new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean extractDefaultQualifiers$lambda$1;
                extractDefaultQualifiers$lambda$1 = AbstractAnnotationTypeQualifierResolver.extractDefaultQualifiers$lambda$1(obj);
                return Boolean.valueOf(extractDefaultQualifiers$lambda$1);
            }
        })) == null) {
            return null;
        }
        return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifier, null, jsr305State.isWarning(), 1, null), applicability, false, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean extractDefaultQualifiers$lambda$1(Object extractNullability) {
        Intrinsics.checkNotNullParameter(extractNullability, "$this$extractNullability");
        return false;
    }

    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(JavaTypeQualifiersByElementType oldQualifiers, Iterable<? extends TAnnotation> annotations) {
        EnumMap p0;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations()) {
            return oldQualifiers;
        }
        Collection destination$iv$iv = new ArrayList();
        for (TAnnotation tannotation : annotations) {
            JavaDefaultQualifiers extractDefaultQualifiers = extractDefaultQualifiers(tannotation);
            if (extractDefaultQualifiers != null) {
                destination$iv$iv.add(extractDefaultQualifiers);
            }
        }
        List<JavaDefaultQualifiers> extractedQualifiers = (List) destination$iv$iv;
        if (extractedQualifiers.isEmpty()) {
            return oldQualifiers;
        }
        EnumMap newQualifiers = new EnumMap(AnnotationQualifierApplicabilityType.class);
        for (JavaDefaultQualifiers extractedQualifier : extractedQualifiers) {
            for (AnnotationQualifierApplicabilityType applicabilityType : extractedQualifier.getQualifierApplicabilityTypes()) {
                if (newQualifiers.containsKey(applicabilityType) && isK2()) {
                    JavaDefaultQualifiers preexistingQualifier = (JavaDefaultQualifiers) newQualifiers.get(applicabilityType);
                    if (preexistingQualifier != null) {
                        NullabilityQualifierWithMigrationStatus preexistingNullability = preexistingQualifier.getNullabilityQualifier();
                        NullabilityQualifierWithMigrationStatus extractedNullability = extractedQualifier.getNullabilityQualifier();
                        newQualifiers.put((EnumMap) applicabilityType, (AnnotationQualifierApplicabilityType) ((!Intrinsics.areEqual(extractedNullability, preexistingNullability) && (!extractedNullability.isForWarningOnly() || preexistingNullability.isForWarningOnly())) ? (extractedNullability.isForWarningOnly() || !preexistingNullability.isForWarningOnly()) ? null : extractedQualifier : preexistingQualifier));
                    }
                } else {
                    newQualifiers.put((EnumMap) applicabilityType, (AnnotationQualifierApplicabilityType) extractedQualifier);
                }
            }
        }
        EnumMap defaultQualifiersByType = (oldQualifiers == null || (p0 = oldQualifiers.getDefaultQualifiers()) == null) ? new EnumMap(AnnotationQualifierApplicabilityType.class) : new EnumMap(p0);
        boolean wasUpdate = false;
        for (Map.Entry entry : newQualifiers.entrySet()) {
            AnnotationQualifierApplicabilityType applicabilityType2 = (AnnotationQualifierApplicabilityType) entry.getKey();
            JavaDefaultQualifiers newQualifier = (JavaDefaultQualifiers) entry.getValue();
            if (newQualifier != null) {
                defaultQualifiersByType.put((EnumMap) applicabilityType2, (AnnotationQualifierApplicabilityType) newQualifier);
                wasUpdate = true;
            }
        }
        return !wasUpdate ? oldQualifiers : new JavaTypeQualifiersByElementType(defaultQualifiersByType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r3.equals("ALWAYS") != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        if (r3.equals("NEVER") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
        if (r3.equals("MAYBE") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
        r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation tannotation, boolean forceWarning) {
        NullabilityQualifier nullability;
        FqName fqName = getFqName(tannotation);
        if (fqName == null) {
            return null;
        }
        ReportLevel reportLevel = this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(fqName);
        if (reportLevel.isIgnore()) {
            return null;
        }
        boolean z = false;
        if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
            nullability = NullabilityQualifier.NOT_NULL;
        } else if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(fqName)) {
            nullability = NullabilityQualifier.NULLABLE;
        } else if (JvmAnnotationNamesKt.getFORCE_FLEXIBILITY_ANNOTATIONS().contains(fqName)) {
            nullability = NullabilityQualifier.FORCE_FLEXIBILITY;
        } else if (!Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION_FQ_NAME())) {
            return null;
        } else {
            String str = (String) CollectionsKt.firstOrNull(enumArguments(tannotation, false));
            if (str != null) {
                switch (str.hashCode()) {
                    case 73135176:
                        break;
                    case 74175084:
                        break;
                    case 433141802:
                        if (str.equals("UNKNOWN")) {
                            nullability = NullabilityQualifier.FORCE_FLEXIBILITY;
                            break;
                        }
                        return null;
                    case 1933739535:
                        break;
                    default:
                        return null;
                }
            }
            nullability = NullabilityQualifier.NOT_NULL;
        }
        return new NullabilityQualifierWithMigrationStatus(nullability, (reportLevel.isWarning() || forceWarning) ? true : true);
    }

    /* compiled from: AbstractAnnotationTypeQualifierResolver.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        AnnotationQualifierApplicabilityType[] values;
        Map $this$JAVA_APPLICABILITY_TYPES_u24lambda_u240 = new LinkedHashMap();
        for (AnnotationQualifierApplicabilityType type : AnnotationQualifierApplicabilityType.values()) {
            String javaTarget = type.getJavaTarget();
            Object value$iv = $this$JAVA_APPLICABILITY_TYPES_u24lambda_u240.get(javaTarget);
            if (value$iv == null) {
                $this$JAVA_APPLICABILITY_TYPES_u24lambda_u240.put(javaTarget, type);
            }
        }
        JAVA_APPLICABILITY_TYPES = $this$JAVA_APPLICABILITY_TYPES_u24lambda_u240;
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation tannotation) {
        ReportLevel it = resolveJsr305CustomState(tannotation);
        if (it != null) {
            return it;
        }
        return this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }
}