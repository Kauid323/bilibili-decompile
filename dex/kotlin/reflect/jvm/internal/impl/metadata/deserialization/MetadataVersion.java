package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataVersion.kt */
public final class MetadataVersion extends BinaryVersion {
    public static final Companion Companion = new Companion(null);
    public static final MetadataVersion INSTANCE = new MetadataVersion(2, 2, 0);
    public static final MetadataVersion INSTANCE_NEXT = INSTANCE.next();
    public static final MetadataVersion INVALID_VERSION = new MetadataVersion(new int[0]);
    private final boolean isStrictSemantics;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataVersion(int[] versionArray, boolean isStrictSemantics) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        Intrinsics.checkNotNullParameter(versionArray, "versionArray");
        this.isStrictSemantics = isStrictSemantics;
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MetadataVersion(int... numbers) {
        this(numbers, false);
        Intrinsics.checkNotNullParameter(numbers, "numbers");
    }

    public final MetadataVersion lastSupportedVersionWithThisLanguageVersion(boolean isStrictSemantics) {
        MetadataVersion forwardCompatibility = isStrictSemantics ? INSTANCE : INSTANCE_NEXT;
        return forwardCompatibility.newerThan(this) ? forwardCompatibility : this;
    }

    public final boolean isCompatible(MetadataVersion metadataVersionFromLanguageVersion) {
        Intrinsics.checkNotNullParameter(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        MetadataVersion limitVersion = metadataVersionFromLanguageVersion.lastSupportedVersionWithThisLanguageVersion(this.isStrictSemantics);
        return isCompatibleInternal(limitVersion);
    }

    private final boolean isCompatibleInternal(MetadataVersion limitVersion) {
        if ((getMajor() == 1 && getMinor() == 0) || getMajor() == 0) {
            return false;
        }
        return !newerThan(limitVersion);
    }

    public final MetadataVersion next() {
        return (getMajor() == 1 && getMinor() == 9) ? new MetadataVersion(2, 0, 0) : new MetadataVersion(getMajor(), getMinor() + 1, 0);
    }

    private final boolean newerThan(MetadataVersion other) {
        if (getMajor() > other.getMajor()) {
            return true;
        }
        return getMajor() >= other.getMajor() && getMinor() > other.getMinor();
    }

    /* compiled from: MetadataVersion.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}