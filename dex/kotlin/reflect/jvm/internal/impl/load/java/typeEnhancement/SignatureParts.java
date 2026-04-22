package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: signatureEnhancement.kt */
public final class SignatureParts extends AbstractSignatureParts<AnnotationDescriptor> {
    private final AnnotationQualifierApplicabilityType containerApplicabilityType;
    private final LazyJavaResolverContext containerContext;
    private final boolean isCovariant;
    private final boolean skipRawTypeArguments;
    private final Annotated typeContainer;

    public SignatureParts(Annotated typeContainer, boolean isCovariant, LazyJavaResolverContext containerContext, AnnotationQualifierApplicabilityType containerApplicabilityType, boolean skipRawTypeArguments) {
        Intrinsics.checkNotNullParameter(containerContext, "containerContext");
        Intrinsics.checkNotNullParameter(containerApplicabilityType, "containerApplicabilityType");
        this.typeContainer = typeContainer;
        this.isCovariant = isCovariant;
        this.containerContext = containerContext;
        this.containerApplicabilityType = containerApplicabilityType;
        this.skipRawTypeArguments = skipRawTypeArguments;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SignatureParts(Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, r5);
        boolean z3;
        if ((i & 16) == 0) {
            z3 = z2;
        } else {
            z3 = false;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isCovariant() {
        return this.isCovariant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public AnnotationQualifierApplicabilityType getContainerApplicabilityType() {
        return this.containerApplicabilityType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getSkipRawTypeArguments() {
        return this.skipRawTypeArguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> getAnnotationTypeQualifierResolver() {
        return this.containerContext.getComponents().getAnnotationTypeQualifierResolver();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getEnableImprovementsInStrictMode() {
        return this.containerContext.getComponents().getSettings().getTypeEnhancementImprovementsInStrictMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable<AnnotationDescriptor> getContainerAnnotations() {
        Iterable<AnnotationDescriptor> emptyList;
        Annotated annotated = this.typeContainer;
        if (annotated == null || (emptyList = annotated.getAnnotations()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers() {
        return this.containerContext.getDefaultTypeQualifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getContainerIsVarargParameter() {
        return (this.typeContainer instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) this.typeContainer).getVarargElementType() != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public TypeSystemInferenceExtensionContext getTypeSystem() {
        return SimpleClassicTypeSystemContext.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean forceWarning(AnnotationDescriptor $this$forceWarning, KotlinTypeMarker unenhancedType) {
        Intrinsics.checkNotNullParameter($this$forceWarning, "<this>");
        return (($this$forceWarning instanceof PossiblyExternalAnnotationDescriptor) && ((PossiblyExternalAnnotationDescriptor) $this$forceWarning).isIdeExternalAnnotation()) || (($this$forceWarning instanceof LazyJavaAnnotationDescriptor) && !getEnableImprovementsInStrictMode() && (((LazyJavaAnnotationDescriptor) $this$forceWarning).isFreshlySupportedTypeUseAnnotation() || getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS)) || (unenhancedType != null && KotlinBuiltIns.isPrimitiveArray((KotlinType) unenhancedType) && getAnnotationTypeQualifierResolver().isTypeUseAnnotation($this$forceWarning) && !this.containerContext.getComponents().getSettings().getEnhancePrimitiveArrays());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable<AnnotationDescriptor> getAnnotations(KotlinTypeMarker $this$annotations) {
        Intrinsics.checkNotNullParameter($this$annotations, "<this>");
        return ((KotlinType) $this$annotations).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public KotlinType getEnhancedForWarnings(KotlinTypeMarker $this$enhancedForWarnings) {
        Intrinsics.checkNotNullParameter($this$enhancedForWarnings, "<this>");
        return TypeWithEnhancementKt.getEnhancement((KotlinType) $this$enhancedForWarnings);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker $this$fqNameUnsafe) {
        Intrinsics.checkNotNullParameter($this$fqNameUnsafe, "<this>");
        ClassDescriptor it = TypeUtils.getClassDescriptor((KotlinType) $this$fqNameUnsafe);
        if (it != null) {
            return DescriptorUtils.getFqName(it);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker $this$isNotNullTypeParameterCompat) {
        Intrinsics.checkNotNullParameter($this$isNotNullTypeParameterCompat, "<this>");
        return ((KotlinType) $this$isNotNullTypeParameterCompat).unwrap() instanceof NotNullTypeParameterImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isEqual(KotlinTypeMarker $this$isEqual, KotlinTypeMarker other) {
        Intrinsics.checkNotNullParameter($this$isEqual, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return this.containerContext.getComponents().getKotlinTypeChecker().equalTypes((KotlinType) $this$isEqual, (KotlinType) other);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isArrayOrPrimitiveArray(KotlinTypeMarker $this$isArrayOrPrimitiveArray) {
        Intrinsics.checkNotNullParameter($this$isArrayOrPrimitiveArray, "<this>");
        return KotlinBuiltIns.isArrayOrPrimitiveArray((KotlinType) $this$isArrayOrPrimitiveArray);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isFromJava(TypeParameterMarker $this$isFromJava) {
        Intrinsics.checkNotNullParameter($this$isFromJava, "<this>");
        return $this$isFromJava instanceof LazyJavaTypeParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    protected NullabilityQualifierWithMigrationStatus getDefaultNullability(NullabilityQualifierWithMigrationStatus referencedParameterBoundsNullability, JavaDefaultQualifiers defaultTypeQualifiers) {
        NullabilityQualifierWithMigrationStatus copy$default;
        if (referencedParameterBoundsNullability == null || (copy$default = NullabilityQualifierWithMigrationStatus.copy$default(referencedParameterBoundsNullability, NullabilityQualifier.NOT_NULL, false, 2, null)) == null) {
            if (defaultTypeQualifiers != null) {
                return defaultTypeQualifiers.getNullabilityQualifier();
            }
            return null;
        }
        return copy$default;
    }
}