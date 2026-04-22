package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo;

/* compiled from: DeserializedDescriptorResolver.kt */
public final class DeserializedDescriptorResolver {
    public DeserializationComponents components;
    public static final Companion Companion = new Companion(null);
    private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS = SetsKt.setOf(KotlinClassHeader.Kind.CLASS);
    private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = SetsKt.setOf((Object[]) new KotlinClassHeader.Kind[]{KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART});
    private static final MetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION = new MetadataVersion(1, 1, 2);
    private static final MetadataVersion KOTLIN_1_3_M1_METADATA_VERSION = new MetadataVersion(1, 1, 11);
    private static final MetadataVersion KOTLIN_1_3_RC_METADATA_VERSION = new MetadataVersion(1, 1, 13);

    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    public final void setComponents(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    private final MetadataVersion getOwnMetadataVersion() {
        return getComponents().getConfiguration().getMetadataVersion();
    }

    public final void setComponents(DeserializationComponentsForJava components) {
        Intrinsics.checkNotNullParameter(components, "components");
        setComponents(components.getComponents());
    }

    private final boolean getSkipMetadataVersionCheck() {
        return getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    public final ClassDescriptor resolveClass(KotlinJvmBinaryClass kotlinClass) {
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        ClassData classData = readClassData$descriptors_jvm(kotlinClass);
        if (classData == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(kotlinClass.getClassId(), classData);
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass kotlinClass) {
        String[] strings;
        Pair<JvmNameResolver, ProtoBuf.Class> pair;
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        String[] data = readData(kotlinClass, KOTLIN_CLASS);
        if (data == null || (strings = kotlinClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                pair = JvmProtoBufUtil.readClassDataFrom(data, strings);
            } catch (InvalidProtocolBufferException e$iv) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e$iv);
            }
        } catch (Throwable e$iv2) {
            if (getSkipMetadataVersionCheck() || kotlinClass.getClassHeader().getMetadataVersion().isCompatible(getOwnMetadataVersion())) {
                throw e$iv2;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        JvmNameResolver nameResolver = (JvmNameResolver) pair.component1();
        ProtoBuf.Class classProto = (ProtoBuf.Class) pair.component2();
        KotlinJvmBinarySourceElement source = new KotlinJvmBinarySourceElement(kotlinClass, getIncompatibility(kotlinClass), new PreReleaseInfo(isPreReleaseInvisible(kotlinClass), null, 2, null), getAbiStability(kotlinClass));
        return new ClassData(nameResolver, classProto, kotlinClass.getClassHeader().getMetadataVersion(), source);
    }

    public final MemberScope createKotlinPackagePartScope(PackageFragmentDescriptor descriptor, KotlinJvmBinaryClass kotlinClass) {
        String[] strings;
        Pair<JvmNameResolver, ProtoBuf.Package> pair;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        String[] data = readData(kotlinClass, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (data == null || (strings = kotlinClass.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                pair = JvmProtoBufUtil.readPackageDataFrom(data, strings);
            } catch (InvalidProtocolBufferException e$iv) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e$iv);
            }
        } catch (Throwable e$iv2) {
            if (getSkipMetadataVersionCheck() || kotlinClass.getClassHeader().getMetadataVersion().isCompatible(getOwnMetadataVersion())) {
                throw e$iv2;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        JvmNameResolver nameResolver = (JvmNameResolver) pair.component1();
        ProtoBuf.Package packageProto = (ProtoBuf.Package) pair.component2();
        JvmPackagePartSource source = new JvmPackagePartSource(kotlinClass, packageProto, nameResolver, getIncompatibility(kotlinClass), isPreReleaseInvisible(kotlinClass), getAbiStability(kotlinClass));
        return new DeserializedPackageMemberScope(descriptor, packageProto, nameResolver, kotlinClass.getClassHeader().getMetadataVersion(), source, getComponents(), "scope for " + source + " in " + descriptor, new Function0() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver$$Lambda$0
            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Collection createKotlinPackagePartScope$lambda$1;
                createKotlinPackagePartScope$lambda$1 = DeserializedDescriptorResolver.createKotlinPackagePartScope$lambda$1();
                return createKotlinPackagePartScope$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection createKotlinPackagePartScope$lambda$1() {
        return CollectionsKt.emptyList();
    }

    private final IncompatibleVersionErrorData<MetadataVersion> getIncompatibility(KotlinJvmBinaryClass $this$incompatibility) {
        if (getSkipMetadataVersionCheck() || $this$incompatibility.getClassHeader().getMetadataVersion().isCompatible(getOwnMetadataVersion())) {
            return null;
        }
        return new IncompatibleVersionErrorData<>($this$incompatibility.getClassHeader().getMetadataVersion(), MetadataVersion.INSTANCE, getOwnMetadataVersion(), getOwnMetadataVersion().lastSupportedVersionWithThisLanguageVersion($this$incompatibility.getClassHeader().getMetadataVersion().isStrictSemantics()), $this$incompatibility.getLocation());
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass $this$isPreReleaseInvisible) {
        return (getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() && ($this$isPreReleaseInvisible.getClassHeader().isPreRelease() || Intrinsics.areEqual($this$isPreReleaseInvisible.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION))) || isCompiledWith13M1($this$isPreReleaseInvisible);
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass $this$isCompiledWith13M1) {
        return !getComponents().getConfiguration().getSkipPrereleaseCheck() && $this$isCompiledWith13M1.getClassHeader().isPreRelease() && Intrinsics.areEqual($this$isCompiledWith13M1.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION);
    }

    private final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass $this$abiStability) {
        return getComponents().getConfiguration().getAllowUnstableDependencies() ? DeserializedContainerAbiStability.STABLE : $this$abiStability.getClassHeader().isUnstableJvmIrBinary() ? DeserializedContainerAbiStability.UNSTABLE : DeserializedContainerAbiStability.STABLE;
    }

    private final String[] readData(KotlinJvmBinaryClass kotlinClass, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader header = kotlinClass.getClassHeader();
        String[] data = header.getData();
        if (data == null) {
            data = header.getIncompatibleData();
        }
        if (data == null || !set.contains(header.getKind())) {
            return null;
        }
        return data;
    }

    /* compiled from: DeserializedDescriptorResolver.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.KOTLIN_1_3_RC_METADATA_VERSION;
        }
    }
}