package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
public final class JavaNullabilityAnnotationSettingsKt {
    private static final FqName JSPECIFY_OLD_ANNOTATIONS_PACKAGE = new FqName("org.jspecify.nullness");
    private static final FqName JSPECIFY_ANNOTATIONS_PACKAGE = new FqName("org.jspecify.annotations");
    private static final FqName RXJAVA3_ANNOTATIONS_PACKAGE = new FqName("io.reactivex.rxjava3.annotations");
    private static final FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = new FqName("org.checkerframework.checker.nullness.compatqual");
    private static final String RXJAVA3_ANNOTATIONS_PACKAGE_NAME = RXJAVA3_ANNOTATIONS_PACKAGE.asString();
    private static final FqName[] RXJAVA3_ANNOTATIONS = {new FqName(RXJAVA3_ANNOTATIONS_PACKAGE_NAME + ".Nullable"), new FqName(RXJAVA3_ANNOTATIONS_PACKAGE_NAME + ".NonNull")};
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS = new NullabilityAnnotationStatesImpl(MapsKt.mapOf(TuplesKt.to(new FqName("org.jetbrains.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("android.support.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("android.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("com.android.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("org.eclipse.jdt.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("org.checkerframework.checker.nullness.qual"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE, JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("javax.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("edu.umd.cs.findbugs.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("io.reactivex.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation.RecentlyNullable"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null)), TuplesKt.to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null)), TuplesKt.to(new FqName("lombok"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(JSPECIFY_OLD_ANNOTATIONS_PACKAGE, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(2, 1), ReportLevel.STRICT)), TuplesKt.to(JSPECIFY_ANNOTATIONS_PACKAGE, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(2, 1), ReportLevel.STRICT)), TuplesKt.to(RXJAVA3_ANNOTATIONS_PACKAGE, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(1, 8), ReportLevel.STRICT)), TuplesKt.to(new FqName("jakarta.annotation"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(2, 4), ReportLevel.STRICT))));
    private static final JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS = new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null);

    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    public static final FqName[] getRXJAVA3_ANNOTATIONS() {
        return RXJAVA3_ANNOTATIONS;
    }

    public static final Jsr305Settings getDefaultJsr305Settings(KotlinVersion configuredKotlinVersion) {
        ReportLevel globalReportLevel;
        Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        if (JSR_305_DEFAULT_SETTINGS.getSinceVersion() != null && JSR_305_DEFAULT_SETTINGS.getSinceVersion().compareTo(configuredKotlinVersion) <= 0) {
            globalReportLevel = JSR_305_DEFAULT_SETTINGS.getReportLevelAfter();
        } else {
            globalReportLevel = JSR_305_DEFAULT_SETTINGS.getReportLevelBefore();
        }
        ReportLevel migrationLevel = getDefaultMigrationJsr305ReportLevelForGivenGlobal(globalReportLevel);
        return new Jsr305Settings(globalReportLevel, migrationLevel, null, 4, null);
    }

    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(ReportLevel globalReportLevel) {
        Intrinsics.checkNotNullParameter(globalReportLevel, "globalReportLevel");
        if (globalReportLevel == ReportLevel.WARN) {
            return null;
        }
        return globalReportLevel;
    }

    public static final ReportLevel getDefaultReportLevelForAnnotation(FqName annotationFqName, KotlinVersion configuredKotlinVersion) {
        Intrinsics.checkNotNullParameter(annotationFqName, "annotationFqName");
        Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        return getReportLevelForAnnotation(annotationFqName, NullabilityAnnotationStates.Companion.getEMPTY(), configuredKotlinVersion);
    }

    public static final ReportLevel getReportLevelForAnnotation(FqName annotation, NullabilityAnnotationStates<? extends ReportLevel> configuredReportLevels, KotlinVersion configuredKotlinVersion) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(configuredReportLevels, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        ReportLevel it = configuredReportLevels.get(annotation);
        if (it != null) {
            return it;
        }
        JavaNullabilityAnnotationsStatus defaultStatus = NULLABILITY_ANNOTATION_SETTINGS.get(annotation);
        if (defaultStatus == null) {
            return ReportLevel.IGNORE;
        }
        if (defaultStatus.getSinceVersion() != null && defaultStatus.getSinceVersion().compareTo(configuredKotlinVersion) <= 0) {
            return defaultStatus.getReportLevelAfter();
        }
        return defaultStatus.getReportLevelBefore();
    }
}