package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeMappingMode.kt */
public final class TypeMappingMode {
    private final TypeMappingMode genericArgumentMode;
    private final TypeMappingMode genericContravariantArgumentMode;
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean ignoreTypeArgumentsBounds;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;
    public static final Companion Companion = new Companion(null);
    public static final TypeMappingMode GENERIC_ARGUMENT = new TypeMappingMode(false, false, false, false, false, null, false, null, null, false, false, 2047, null);
    public static final TypeMappingMode GENERIC_ARGUMENT_FOR_SUPER_TYPES_AS_IS = new TypeMappingMode(false, false, false, false, false, null, false, null, null, false, true, 1023, null);
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST = new TypeMappingMode(false, false, false, false, false, null, false, null, null, true, false, 1535, null);
    public static final TypeMappingMode RETURN_TYPE_BOXED = new TypeMappingMode(false, true, false, false, false, null, false, null, null, false, false, 2045, null);
    public static final TypeMappingMode DEFAULT = new TypeMappingMode(false, false, false, false, false, GENERIC_ARGUMENT, false, null, null, false, false, 2012, null);
    public static final TypeMappingMode DEFAULT_UAST = new TypeMappingMode(false, false, false, false, false, GENERIC_ARGUMENT_UAST, false, null, null, true, false, 1500, null);
    public static final TypeMappingMode CLASS_DECLARATION = new TypeMappingMode(false, true, false, false, false, GENERIC_ARGUMENT, false, null, null, false, false, 2012, null);
    public static final TypeMappingMode SUPER_TYPE = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT, false, null, null, false, false, 2007, null);
    public static final TypeMappingMode SUPER_TYPE_AS_IS = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT_FOR_SUPER_TYPES_AS_IS, false, null, null, false, true, 983, null);
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT_FOR_SUPER_TYPES_AS_IS, false, null, null, false, true, 919, null);
    public static final TypeMappingMode VALUE_FOR_ANNOTATION = new TypeMappingMode(false, false, true, false, false, GENERIC_ARGUMENT, false, null, null, false, false, 2008, null);
    public static final TypeMappingMode INVOKE_DYNAMIC_BOOTSTRAP_ARGUMENT = new TypeMappingMode(true, true, false, false, false, null, true, null, null, false, false, 1980, null);

    /* compiled from: TypeMappingMode.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Variance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, false, 2047, null);
    }

    public TypeMappingMode(boolean needPrimitiveBoxing, boolean needInlineClassWrapping, boolean isForAnnotationParameter, boolean skipDeclarationSiteWildcards, boolean skipDeclarationSiteWildcardsIfPossible, TypeMappingMode genericArgumentMode, boolean kotlinCollectionsToJavaCollections, TypeMappingMode genericContravariantArgumentMode, TypeMappingMode genericInvariantArgumentMode, boolean mapTypeAliases, boolean ignoreTypeArgumentsBounds) {
        this.needPrimitiveBoxing = needPrimitiveBoxing;
        this.needInlineClassWrapping = needInlineClassWrapping;
        this.isForAnnotationParameter = isForAnnotationParameter;
        this.skipDeclarationSiteWildcards = skipDeclarationSiteWildcards;
        this.skipDeclarationSiteWildcardsIfPossible = skipDeclarationSiteWildcardsIfPossible;
        this.genericArgumentMode = genericArgumentMode;
        this.kotlinCollectionsToJavaCollections = kotlinCollectionsToJavaCollections;
        this.genericContravariantArgumentMode = genericContravariantArgumentMode;
        this.genericInvariantArgumentMode = genericInvariantArgumentMode;
        this.mapTypeAliases = mapTypeAliases;
        this.ignoreTypeArgumentsBounds = ignoreTypeArgumentsBounds;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TypeMappingMode typeMappingMode, boolean z6, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z7, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r6, r7, r8, (i & 64) == 0 ? z6 : true, (i & 128) != 0 ? r8 : typeMappingMode2, (i & 256) != 0 ? r8 : typeMappingMode3, (i & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? false : z7, (i & 1024) == 0 ? z8 : false);
        boolean z9 = (i & 1) != 0 ? true : z;
        boolean z10 = (i & 2) != 0 ? true : z2;
        boolean z11 = (i & 4) != 0 ? false : z3;
        boolean z12 = (i & 8) != 0 ? false : z4;
        boolean z13 = (i & 16) != 0 ? false : z5;
        TypeMappingMode typeMappingMode4 = (i & 32) != 0 ? null : typeMappingMode;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    /* compiled from: TypeMappingMode.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final TypeMappingMode toGenericArgumentMode(Variance effectiveVariance, boolean ofArray) {
        Intrinsics.checkNotNullParameter(effectiveVariance, "effectiveVariance");
        if (!ofArray || !this.isForAnnotationParameter) {
            switch (WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()]) {
                case 1:
                    TypeMappingMode typeMappingMode = this.genericContravariantArgumentMode;
                    if (typeMappingMode != null) {
                        return typeMappingMode;
                    }
                    break;
                case 2:
                    TypeMappingMode typeMappingMode2 = this.genericInvariantArgumentMode;
                    if (typeMappingMode2 != null) {
                        return typeMappingMode2;
                    }
                    break;
                default:
                    TypeMappingMode typeMappingMode3 = this.genericArgumentMode;
                    if (typeMappingMode3 != null) {
                        return typeMappingMode3;
                    }
                    break;
            }
        }
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, this.mapTypeAliases, this.ignoreTypeArgumentsBounds);
    }
}