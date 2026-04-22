package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmTypeProjection;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.KmVersion;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.MutableVersionRequirementTable;

/* compiled from: Writers.kt */
public final class WritersKt {

    /* compiled from: Writers.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[KmVersionRequirementVersionKind.values().length];
            try {
                iArr[KmVersionRequirementVersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.API_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[KmVersionRequirementLevel.values().length];
            try {
                iArr2[KmVersionRequirementLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[KmVersionRequirementLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[KmVersionRequirementLevel.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[KmEffectType.values().length];
            try {
                iArr3[KmEffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr3[KmEffectType.CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr3[KmEffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[KmEffectInvocationKind.values().length];
            try {
                iArr4[KmEffectInvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr4[KmEffectInvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr4[KmEffectInvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private static final ProtoBuf.TypeParameter.Builder writeTypeParameter(WriteContext $this$writeTypeParameter, KmTypeParameter kmTypeParameter) {
        ProtoBuf.TypeParameter.Builder t = ProtoBuf.TypeParameter.newBuilder();
        Iterable $this$forEach$iv = kmTypeParameter.getUpperBounds();
        for (Object element$iv : $this$forEach$iv) {
            KmType ub = (KmType) element$iv;
            t.addUpperBound(writeType($this$writeTypeParameter, ub).build());
        }
        Iterable $this$forEach$iv2 = $this$writeTypeParameter.getExtensions$kotlin_metadata();
        for (Object element$iv2 : $this$forEach$iv2) {
            MetadataExtensions it = (MetadataExtensions) element$iv2;
            Intrinsics.checkNotNull(t);
            it.writeTypeParameterExtensions(kmTypeParameter, t, $this$writeTypeParameter);
        }
        t.setName($this$writeTypeParameter.get(kmTypeParameter.getName()));
        t.setId(kmTypeParameter.getId());
        boolean reified = Attributes.isReified(kmTypeParameter);
        if (reified != ProtoBuf.TypeParameter.getDefaultInstance().getReified()) {
            t.setReified(reified);
        }
        if (kmTypeParameter.getVariance() == KmVariance.IN) {
            t.setVariance(ProtoBuf.TypeParameter.Variance.IN);
        } else if (kmTypeParameter.getVariance() == KmVariance.OUT) {
            t.setVariance(ProtoBuf.TypeParameter.Variance.OUT);
        }
        Intrinsics.checkNotNull(t);
        return t;
    }

    private static final ProtoBuf.Type.Argument.Builder writeTypeProjection(WriteContext $this$writeTypeProjection, KmTypeProjection argument) {
        ProtoBuf.Type.Argument.Builder t = ProtoBuf.Type.Argument.newBuilder();
        if (Intrinsics.areEqual(argument, KmTypeProjection.STAR)) {
            t.setProjection(ProtoBuf.Type.Argument.Projection.STAR);
        } else {
            KmVariance variance = argument.component1();
            KmType argType = argument.component2();
            if (variance == null || argType == null) {
                throw new InconsistentKotlinMetadataException("Variance and type must be set for non-star type projection", null, 2, null);
            }
            if (variance == KmVariance.IN) {
                t.setProjection(ProtoBuf.Type.Argument.Projection.IN);
            } else if (variance == KmVariance.OUT) {
                t.setProjection(ProtoBuf.Type.Argument.Projection.OUT);
            }
            t.setType(writeType($this$writeTypeProjection, argType).build());
        }
        Intrinsics.checkNotNull(t);
        return t;
    }

    private static final ProtoBuf.Type.Builder writeType(WriteContext $this$writeType, KmType kmType) {
        ProtoBuf.Type.Builder t = ProtoBuf.Type.newBuilder();
        KmClassifier cls = kmType.getClassifier();
        if (cls instanceof KmClassifier.Class) {
            t.setClassName($this$writeType.getClassName$kotlin_metadata(((KmClassifier.Class) cls).getName()));
        } else if (cls instanceof KmClassifier.TypeAlias) {
            t.setTypeAliasName($this$writeType.getClassName$kotlin_metadata(((KmClassifier.TypeAlias) cls).getName()));
        } else if (!(cls instanceof KmClassifier.TypeParameter)) {
            throw new NoWhenBranchMatchedException();
        } else {
            t.setTypeParameter(((KmClassifier.TypeParameter) cls).getId());
        }
        Iterable $this$forEach$iv = kmType.getArguments();
        for (Object element$iv : $this$forEach$iv) {
            KmTypeProjection argument = (KmTypeProjection) element$iv;
            t.addArgument(writeTypeProjection($this$writeType, argument));
        }
        KmType it = kmType.getAbbreviatedType();
        if (it != null) {
            t.setAbbreviatedType(writeType($this$writeType, it).build());
        }
        KmType it2 = kmType.getOuterType();
        if (it2 != null) {
            t.setOuterType(writeType($this$writeType, it2).build());
        }
        KmFlexibleTypeUpperBound fub = kmType.getFlexibleTypeUpperBound();
        if (fub != null) {
            ProtoBuf.Type.Builder fubType = writeType($this$writeType, fub.getType());
            String it3 = fub.getTypeFlexibilityId();
            if (it3 != null) {
                t.setFlexibleTypeCapabilitiesId($this$writeType.get(it3));
            }
            t.setFlexibleUpperBound(fubType.build());
        }
        Iterable $this$forEach$iv2 = $this$writeType.getExtensions$kotlin_metadata();
        for (Object element$iv2 : $this$forEach$iv2) {
            Intrinsics.checkNotNull(t);
            ((MetadataExtensions) element$iv2).writeTypeExtensions(kmType, t, $this$writeType);
        }
        if (Attributes.isNullable(kmType)) {
            t.setNullable(true);
        }
        int flagsToWrite = kmType.getFlags$kotlin_metadata() >> 1;
        if (flagsToWrite != ProtoBuf.Type.getDefaultInstance().getFlags()) {
            t.setFlags(flagsToWrite);
        }
        Intrinsics.checkNotNull(t);
        return t;
    }

    public static final ProtoBuf.Property.Builder writeProperty(WriteContext $this$writeProperty, KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter($this$writeProperty, "<this>");
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        ProtoBuf.Property.Builder t = ProtoBuf.Property.newBuilder();
        Iterable $this$forEach$iv = kmProperty.getTypeParameters();
        for (Object element$iv : $this$forEach$iv) {
            KmTypeParameter tp = (KmTypeParameter) element$iv;
            t.addTypeParameter(writeTypeParameter($this$writeProperty, tp).build());
        }
        KmType it = kmProperty.getReceiverParameterType();
        if (it != null) {
            t.setReceiverType(writeType($this$writeProperty, it).build());
        }
        Iterable $this$map$iv = kmProperty.getContextParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(writeValueParameter($this$writeProperty, (KmValueParameter) item$iv$iv).build());
        }
        t.addAllContextParameter((List) destination$iv$iv);
        Iterable $this$map$iv2 = kmProperty.getContextParameters();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            destination$iv$iv2.add(writeType($this$writeProperty, ((KmValueParameter) item$iv$iv2).getType()).build());
        }
        t.addAllContextReceiverType((List) destination$iv$iv2);
        KmValueParameter it2 = kmProperty.getSetterParameter();
        if (it2 != null) {
            t.setSetterValueParameter(writeValueParameter($this$writeProperty, it2).build());
        }
        t.setReturnType(writeType($this$writeProperty, kmProperty.getReturnType()).build());
        Iterable $this$mapNotNull$iv = kmProperty.getVersionRequirements();
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Integer writeVersionRequirement = writeVersionRequirement($this$writeProperty, (KmVersionRequirement) element$iv$iv$iv);
            if (writeVersionRequirement != null) {
                destination$iv$iv3.add(writeVersionRequirement);
            }
        }
        t.addAllVersionRequirement((List) destination$iv$iv3);
        Iterable $this$forEach$iv2 = $this$writeProperty.getExtensions$kotlin_metadata();
        for (Object element$iv2 : $this$forEach$iv2) {
            Intrinsics.checkNotNull(t);
            ((MetadataExtensions) element$iv2).writePropertyExtensions(kmProperty, t, $this$writeProperty);
        }
        t.setName($this$writeProperty.get(kmProperty.getName()));
        int flags = kmProperty.getFlags$kotlin_metadata() | Flags.HAS_ANNOTATIONS.toFlags(Boolean.valueOf(!kmProperty.getAnnotations().isEmpty()));
        if (flags != ProtoBuf.Property.getDefaultInstance().getFlags()) {
            t.setFlags(flags);
        }
        t.setGetterFlags(kmProperty.getGetter().getFlags$kotlin_metadata() | Flags.HAS_ANNOTATIONS.toFlags(Boolean.valueOf(!kmProperty.getGetter().getAnnotations().isEmpty())));
        KmPropertyAccessorAttributes setter = kmProperty.getSetter();
        if (setter != null) {
            t.setSetterFlags(setter.getFlags$kotlin_metadata() | Flags.HAS_ANNOTATIONS.toFlags(Boolean.valueOf(!setter.getAnnotations().isEmpty())));
        }
        Intrinsics.checkNotNull(t);
        return t;
    }

    private static final ProtoBuf.ValueParameter.Builder writeValueParameter(WriteContext $this$writeValueParameter, KmValueParameter kmValueParameter) {
        ProtoBuf.ValueParameter.Builder t = ProtoBuf.ValueParameter.newBuilder();
        t.setType(writeType($this$writeValueParameter, kmValueParameter.getType()).build());
        KmType it = kmValueParameter.getVarargElementType();
        if (it != null) {
            t.setVarargElementType(writeType($this$writeValueParameter, it).build());
        }
        KmAnnotationArgument it2 = kmValueParameter.getAnnotationParameterDefaultValue();
        if (it2 != null) {
            t.setAnnotationParameterDefaultValue(WriteUtilsKt.writeAnnotationArgument(it2, $this$writeValueParameter.getStrings()).build());
        }
        Iterable $this$forEach$iv = $this$writeValueParameter.getExtensions$kotlin_metadata();
        for (Object element$iv : $this$forEach$iv) {
            Intrinsics.checkNotNull(t);
            ((MetadataExtensions) element$iv).writeValueParameterExtensions(kmValueParameter, t, $this$writeValueParameter);
        }
        int flags = kmValueParameter.getFlags$kotlin_metadata() | Flags.HAS_ANNOTATIONS.toFlags(Boolean.valueOf(!kmValueParameter.getAnnotations().isEmpty()));
        if (flags != ProtoBuf.ValueParameter.getDefaultInstance().getFlags()) {
            t.setFlags(flags);
        }
        t.setName($this$writeValueParameter.get(kmValueParameter.getName()));
        Intrinsics.checkNotNull(t);
        return t;
    }

    private static final Integer writeVersionRequirement(WriteContext $this$writeVersionRequirement, KmVersionRequirement kmVersionRequirement) {
        ProtoBuf.VersionRequirement.VersionKind versionKind;
        ProtoBuf.VersionRequirement.Level requirementLevel;
        KmVersionRequirementVersionKind kind = kmVersionRequirement.getKind();
        KmVersionRequirementLevel level = kmVersionRequirement.getLevel();
        Integer errorCode = kmVersionRequirement.getErrorCode();
        String message = kmVersionRequirement.getMessage();
        final ProtoBuf.VersionRequirement.Builder t = ProtoBuf.VersionRequirement.newBuilder();
        switch (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case 1:
                versionKind = ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION;
                break;
            case 2:
                versionKind = ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION;
                break;
            case 3:
                versionKind = ProtoBuf.VersionRequirement.VersionKind.API_VERSION;
                break;
            case 4:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (versionKind != t.getDefaultInstanceForType().getVersionKind()) {
            t.setVersionKind(versionKind);
        }
        switch (WhenMappings.$EnumSwitchMapping$1[level.ordinal()]) {
            case 1:
                requirementLevel = ProtoBuf.VersionRequirement.Level.WARNING;
                break;
            case 2:
                requirementLevel = ProtoBuf.VersionRequirement.Level.ERROR;
                break;
            case 3:
                requirementLevel = ProtoBuf.VersionRequirement.Level.HIDDEN;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (requirementLevel != t.getDefaultInstanceForType().getLevel()) {
            t.setLevel(requirementLevel);
        }
        if (errorCode != null) {
            t.setErrorCode(errorCode.intValue());
        }
        if (message != null) {
            t.setMessage($this$writeVersionRequirement.get(message));
        }
        KmVersion version = kmVersionRequirement.getVersion();
        int major = version.component1();
        int minor = version.component2();
        int patch2 = version.component3();
        new VersionRequirement.Version(major, minor, patch2).encode(new Function1(t) { // from class: kotlin.reflect.jvm.internal.impl.km.internal.WritersKt$$Lambda$0
            private final ProtoBuf.VersionRequirement.Builder arg$0;

            {
                this.arg$0 = t;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit writeVersionRequirement$lambda$1;
                writeVersionRequirement$lambda$1 = WritersKt.writeVersionRequirement$lambda$1(this.arg$0, ((Number) obj).intValue());
                return writeVersionRequirement$lambda$1;
            }
        }, new Function1(t) { // from class: kotlin.reflect.jvm.internal.impl.km.internal.WritersKt$$Lambda$1
            private final ProtoBuf.VersionRequirement.Builder arg$0;

            {
                this.arg$0 = t;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit writeVersionRequirement$lambda$2;
                writeVersionRequirement$lambda$2 = WritersKt.writeVersionRequirement$lambda$2(this.arg$0, ((Number) obj).intValue());
                return writeVersionRequirement$lambda$2;
            }
        });
        MutableVersionRequirementTable versionRequirements$kotlin_metadata = $this$writeVersionRequirement.getVersionRequirements$kotlin_metadata();
        Intrinsics.checkNotNull(t);
        return Integer.valueOf(versionRequirements$kotlin_metadata.get(t));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeVersionRequirement$lambda$1(ProtoBuf.VersionRequirement.Builder $t, int it) {
        Intrinsics.checkNotNull($t);
        $t.setVersion(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeVersionRequirement$lambda$2(ProtoBuf.VersionRequirement.Builder $t, int it) {
        Intrinsics.checkNotNull($t);
        $t.setVersionFull(it);
        return Unit.INSTANCE;
    }
}