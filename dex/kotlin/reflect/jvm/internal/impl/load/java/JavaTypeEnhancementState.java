package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaTypeEnhancementState.kt */
public final class JavaTypeEnhancementState {
    public static final Companion Companion = new Companion(null);
    private final boolean disabledDefaultAnnotations;
    private final Function1<FqName, ReportLevel> getReportLevelForAnnotation;
    private final Jsr305Settings jsr305;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(Jsr305Settings jsr305, Function1<? super FqName, ? extends ReportLevel> getReportLevelForAnnotation) {
        Intrinsics.checkNotNullParameter(jsr305, "jsr305");
        Intrinsics.checkNotNullParameter(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.jsr305 = jsr305;
        this.getReportLevelForAnnotation = getReportLevelForAnnotation;
        this.disabledDefaultAnnotations = this.jsr305.isDisabled() || this.getReportLevelForAnnotation.invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.IGNORE;
    }

    public final Jsr305Settings getJsr305() {
        return this.jsr305;
    }

    public final Function1<FqName, ReportLevel> getGetReportLevelForAnnotation() {
        return this.getReportLevelForAnnotation;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.disabledDefaultAnnotations;
    }

    /* compiled from: JavaTypeEnhancementState.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JavaTypeEnhancementState getDefault(final KotlinVersion kotlinVersion) {
            Intrinsics.checkNotNullParameter(kotlinVersion, "kotlinVersion");
            return new JavaTypeEnhancementState(JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings(kotlinVersion), new Function1(kotlinVersion) { // from class: kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState$Companion$$Lambda$0
                private final KotlinVersion arg$0;

                {
                    this.arg$0 = kotlinVersion;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    ReportLevel default$lambda$0;
                    default$lambda$0 = JavaTypeEnhancementState.Companion.getDefault$lambda$0(this.arg$0, (FqName) obj);
                    return default$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ReportLevel getDefault$lambda$0(KotlinVersion $kotlinVersion, FqName it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return JavaNullabilityAnnotationSettingsKt.getDefaultReportLevelForAnnotation(it, $kotlinVersion);
        }
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.jsr305 + ", getReportLevelForAnnotation=" + this.getReportLevelForAnnotation + ')';
    }
}