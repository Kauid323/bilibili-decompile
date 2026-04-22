package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JvmAnnotationNames.kt */
public final class JvmAnnotationNamesKt {
    private static final Set<FqName> FORCE_FLEXIBILITY_ANNOTATIONS;
    private static final Set<FqName> MUTABLE_ANNOTATIONS;
    private static final Set<FqName> NOT_NULL_ANNOTATIONS;
    private static final Set<FqName> NULLABILITY_ANNOTATIONS;
    private static final Set<FqName> NULLABLE_ANNOTATIONS;
    private static final Set<FqName> READ_ONLY_ANNOTATIONS;
    private static final FqName UNDER_MIGRATION_ANNOTATION_FQ_NAME;
    private static final Map<FqName, FqName> javaToKotlinNameMap;
    private static final FqName JSPECIFY_OLD_NULLABLE_ANNOTATION_FQ_NAME = new FqName("org.jspecify.nullness.Nullable");
    private static final FqName JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME = new FqName("org.jspecify.nullness.NullMarked");
    private static final FqName JSPECIFY_OLD_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME = new FqName("org.jspecify.nullness.NullnessUnspecified");
    private static final FqName JSPECIFY_NON_NULL_ANNOTATION_FQ_NAME = new FqName("org.jspecify.annotations.NonNull");
    private static final FqName JSPECIFY_NULLABLE_ANNOTATION_FQ_NAME = new FqName("org.jspecify.annotations.Nullable");
    private static final FqName JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME = new FqName("org.jspecify.annotations.NullMarked");
    private static final FqName JSPECIFY_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME = new FqName("org.jspecify.annotations.NullnessUnspecified");
    private static final FqName JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME = new FqName("org.jspecify.annotations.NullUnmarked");
    private static final FqName JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifier");
    private static final FqName JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifierNickname");
    private static final FqName JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifierDefault");
    private static final FqName JAVAX_NONNULL_ANNOTATION_FQ_NAME = new FqName("javax.annotation.Nonnull");
    private static final FqName JAVAX_NULLABLE_ANNOTATION_FQ_NAME = new FqName("javax.annotation.Nullable");
    private static final FqName JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME = new FqName("javax.annotation.CheckForNull");
    private static final FqName JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.ParametersAreNonnullByDefault");
    private static final FqName JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.ParametersAreNullableByDefault");
    private static final Set<FqName> BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JAVAX_NONNULL_ANNOTATION_FQ_NAME, JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME});

    static {
        FqName JETBRAINS_NOT_NULL_ANNOTATION = JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(JETBRAINS_NOT_NULL_ANNOTATION, "JETBRAINS_NOT_NULL_ANNOTATION");
        NOT_NULL_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JETBRAINS_NOT_NULL_ANNOTATION, JSPECIFY_NON_NULL_ANNOTATION_FQ_NAME, new FqName("android.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.RecentlyNonNull"), new FqName("android.support.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("io.reactivex.annotations.NonNull"), new FqName("io.reactivex.rxjava3.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("lombok.NonNull"), new FqName("jakarta.annotation.Nonnull")});
        FqName JETBRAINS_NULLABLE_ANNOTATION = JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(JETBRAINS_NULLABLE_ANNOTATION, "JETBRAINS_NULLABLE_ANNOTATION");
        NULLABLE_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JETBRAINS_NULLABLE_ANNOTATION, JSPECIFY_OLD_NULLABLE_ANNOTATION_FQ_NAME, JSPECIFY_NULLABLE_ANNOTATION_FQ_NAME, JAVAX_NULLABLE_ANNOTATION_FQ_NAME, JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME, new FqName("android.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.RecentlyNullable"), new FqName("android.support.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("io.reactivex.annotations.Nullable"), new FqName("io.reactivex.rxjava3.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("jakarta.annotation.Nullable")});
        FORCE_FLEXIBILITY_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JSPECIFY_OLD_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME, JSPECIFY_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME});
        NULLABILITY_ANNOTATIONS = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) new LinkedHashSet(), (Iterable) NOT_NULL_ANNOTATIONS), (Iterable) NULLABLE_ANNOTATIONS), JAVAX_NONNULL_ANNOTATION_FQ_NAME), JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME), JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME), JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME);
        READ_ONLY_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION});
        MUTABLE_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION});
        javaToKotlinNameMap = MapsKt.mapOf(TuplesKt.to(JvmAnnotationNames.TARGET_ANNOTATION, StandardNames.FqNames.target), TuplesKt.to(JvmAnnotationNames.RETENTION_ANNOTATION, StandardNames.FqNames.retention), TuplesKt.to(JvmAnnotationNames.DEPRECATED_ANNOTATION, StandardNames.FqNames.deprecated), TuplesKt.to(JvmAnnotationNames.DOCUMENTED_ANNOTATION, StandardNames.FqNames.mustBeDocumented));
        UNDER_MIGRATION_ANNOTATION_FQ_NAME = new FqName("kotlin.annotations.jvm.UnderMigration");
    }

    public static final FqName getJSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION_FQ_NAME() {
        return JAVAX_NONNULL_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final FqName getJAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS;
    }

    public static final Set<FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    public static final Set<FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    public static final Set<FqName> getFORCE_FLEXIBILITY_ANNOTATIONS() {
        return FORCE_FLEXIBILITY_ANNOTATIONS;
    }

    public static final Set<FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }

    public static final Set<FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    public static final FqName getUNDER_MIGRATION_ANNOTATION_FQ_NAME() {
        return UNDER_MIGRATION_ANNOTATION_FQ_NAME;
    }
}