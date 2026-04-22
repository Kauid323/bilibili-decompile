package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirement {
    public static final Companion Companion = new Companion(null);
    private final Integer errorCode;
    private final ProtoBuf.VersionRequirement.VersionKind kind;
    private final DeprecationLevel level;
    private final String message;
    private final Version version;

    public VersionRequirement(Version version, ProtoBuf.VersionRequirement.VersionKind kind, DeprecationLevel level, Integer errorCode, String message) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(level, "level");
        this.version = version;
        this.kind = kind;
        this.level = level;
        this.errorCode = errorCode;
        this.message = message;
    }

    public final Version getVersion() {
        return this.version;
    }

    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    public final DeprecationLevel getLevel() {
        return this.level;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    /* compiled from: VersionRequirement.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Version {
        public static final Companion Companion = new Companion(null);
        public static final Version INFINITY = new Version(256, 256, 256);
        private final int major;
        private final int minor;

        /* renamed from: patch  reason: collision with root package name */
        private final int f10patch;

        public final int component1() {
            return this.major;
        }

        public final int component2() {
            return this.minor;
        }

        public final int component3() {
            return this.f10patch;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Version) {
                Version version = (Version) obj;
                return this.major == version.major && this.minor == version.minor && this.f10patch == version.f10patch;
            }
            return false;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.f10patch;
        }

        public Version(int major, int minor, int patch2) {
            this.major = major;
            this.minor = minor;
            this.f10patch = patch2;
        }

        public final String asString() {
            StringBuilder append;
            int i;
            if (this.f10patch == 0) {
                append = new StringBuilder().append(this.major).append(FilenameUtils.EXTENSION_SEPARATOR);
                i = this.minor;
            } else {
                append = new StringBuilder().append(this.major).append(FilenameUtils.EXTENSION_SEPARATOR).append(this.minor).append(FilenameUtils.EXTENSION_SEPARATOR);
                i = this.f10patch;
            }
            return append.append(i).toString();
        }

        public final void encode(Function1<? super Integer, Unit> writeVersion, Function1<? super Integer, Unit> writeVersionFull) {
            Intrinsics.checkNotNullParameter(writeVersion, "writeVersion");
            Intrinsics.checkNotNullParameter(writeVersionFull, "writeVersionFull");
            if (!Intrinsics.areEqual(this, INFINITY)) {
                if (this.major > 7 || this.minor > 15 || this.f10patch > 127) {
                    writeVersionFull.invoke(Integer.valueOf(this.major | (this.minor << 8) | (this.f10patch << 16)));
                } else {
                    writeVersion.invoke(Integer.valueOf(this.major | (this.minor << 3) | (this.f10patch << 7)));
                }
            }
        }

        public String toString() {
            return asString();
        }

        /* compiled from: VersionRequirement.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Version decode(Integer version, Integer versionFull) {
                if (versionFull != null) {
                    return new Version(versionFull.intValue() & 255, (versionFull.intValue() >> 8) & 255, (versionFull.intValue() >> 16) & 255);
                }
                if (version != null) {
                    return new Version(version.intValue() & 7, (version.intValue() >> 3) & 15, (version.intValue() >> 7) & WorkQueueKt.MASK);
                }
                return Version.INFINITY;
            }
        }
    }

    public String toString() {
        return "since " + this.version + ' ' + this.level + (this.errorCode != null ? " error " + this.errorCode.intValue() : "") + (this.message != null ? ": " + this.message : "");
    }

    /* compiled from: VersionRequirement.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {

        /* compiled from: VersionRequirement.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProtoBuf.VersionRequirement.Level.values().length];
                try {
                    iArr[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VersionRequirement create(int id, NameResolver nameResolver, VersionRequirementTable table) {
            DeprecationLevel level;
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(table, "table");
            ProtoBuf.VersionRequirement info = table.get(id);
            if (info == null) {
                return null;
            }
            Version version = Version.Companion.decode(info.hasVersion() ? Integer.valueOf(info.getVersion()) : null, info.hasVersionFull() ? Integer.valueOf(info.getVersionFull()) : null);
            ProtoBuf.VersionRequirement.Level level2 = info.getLevel();
            Intrinsics.checkNotNull(level2);
            switch (WhenMappings.$EnumSwitchMapping$0[level2.ordinal()]) {
                case 1:
                    level = DeprecationLevel.WARNING;
                    break;
                case 2:
                    level = DeprecationLevel.ERROR;
                    break;
                case 3:
                    level = DeprecationLevel.HIDDEN;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            Integer errorCode = info.hasErrorCode() ? Integer.valueOf(info.getErrorCode()) : null;
            String message = info.hasMessage() ? nameResolver.getString(info.getMessage()) : null;
            ProtoBuf.VersionRequirement.VersionKind versionKind = info.getVersionKind();
            Intrinsics.checkNotNullExpressionValue(versionKind, "getVersionKind(...)");
            return new VersionRequirement(version, versionKind, level, errorCode, message);
        }
    }
}