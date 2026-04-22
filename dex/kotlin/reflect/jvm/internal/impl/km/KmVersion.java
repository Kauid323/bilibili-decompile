package kotlin.reflect.jvm.internal.impl.km;

import org.apache.commons.io.FilenameUtils;

/* compiled from: Nodes.kt */
public final class KmVersion {
    private final int major;
    private final int minor;

    /* renamed from: patch  reason: collision with root package name */
    private final int f8patch;

    public final int component1() {
        return this.major;
    }

    public final int component2() {
        return this.minor;
    }

    public final int component3() {
        return this.f8patch;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KmVersion) {
            KmVersion kmVersion = (KmVersion) obj;
            return this.major == kmVersion.major && this.minor == kmVersion.minor && this.f8patch == kmVersion.f8patch;
        }
        return false;
    }

    public int hashCode() {
        return (((this.major * 31) + this.minor) * 31) + this.f8patch;
    }

    public KmVersion(int major, int minor, int patch2) {
        this.major = major;
        this.minor = minor;
        this.f8patch = patch2;
    }

    public String toString() {
        return new StringBuilder().append(this.major).append(FilenameUtils.EXTENSION_SEPARATOR).append(this.minor).append(FilenameUtils.EXTENSION_SEPARATOR).append(this.f8patch).toString();
    }
}