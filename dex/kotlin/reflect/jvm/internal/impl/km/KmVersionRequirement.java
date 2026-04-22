package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Nodes.kt */
public final class KmVersionRequirement {
    private Integer errorCode;
    public KmVersionRequirementVersionKind kind;
    public KmVersionRequirementLevel level;
    private String message;
    public KmVersion version;

    public final KmVersionRequirementVersionKind getKind() {
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind = this.kind;
        if (kmVersionRequirementVersionKind != null) {
            return kmVersionRequirementVersionKind;
        }
        Intrinsics.throwUninitializedPropertyAccessException("kind");
        return null;
    }

    public final void setKind(KmVersionRequirementVersionKind kmVersionRequirementVersionKind) {
        Intrinsics.checkNotNullParameter(kmVersionRequirementVersionKind, "<set-?>");
        this.kind = kmVersionRequirementVersionKind;
    }

    public final KmVersionRequirementLevel getLevel() {
        KmVersionRequirementLevel kmVersionRequirementLevel = this.level;
        if (kmVersionRequirementLevel != null) {
            return kmVersionRequirementLevel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("level");
        return null;
    }

    public final void setLevel(KmVersionRequirementLevel kmVersionRequirementLevel) {
        Intrinsics.checkNotNullParameter(kmVersionRequirementLevel, "<set-?>");
        this.level = kmVersionRequirementLevel;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final KmVersion getVersion() {
        KmVersion kmVersion = this.version;
        if (kmVersion != null) {
            return kmVersion;
        }
        Intrinsics.throwUninitializedPropertyAccessException("version");
        return null;
    }

    public final void setVersion(KmVersion kmVersion) {
        Intrinsics.checkNotNullParameter(kmVersion, "<set-?>");
        this.version = kmVersion;
    }

    public String toString() {
        return "KmVersionRequirement(kind=" + getKind() + ", level=" + getLevel() + ", version=" + getVersion() + ", errorCode=" + this.errorCode + ", message=" + this.message + ')';
    }
}