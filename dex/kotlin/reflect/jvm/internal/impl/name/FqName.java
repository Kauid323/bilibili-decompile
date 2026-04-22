package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FqName.kt */
public final class FqName {
    public static final Companion Companion = new Companion(null);
    public static final FqName ROOT = new FqName("");
    private final FqNameUnsafe fqName;
    private transient FqName parent;

    public FqName(String fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = new FqNameUnsafe(fqName, this);
    }

    public FqName(FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    private FqName(FqNameUnsafe fqName, FqName parent) {
        this.fqName = fqName;
        this.parent = parent;
    }

    public final String asString() {
        return this.fqName.asString();
    }

    public final FqNameUnsafe toUnsafe() {
        return this.fqName;
    }

    public final boolean isRoot() {
        return this.fqName.isRoot();
    }

    public final FqName parent() {
        FqName it = this.parent;
        if (it != null) {
            return it;
        }
        if (isRoot()) {
            throw new IllegalStateException("root".toString());
        }
        FqName it2 = new FqName(this.fqName.parent());
        this.parent = it2;
        return it2;
    }

    public final FqName child(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new FqName(this.fqName.child(name), this);
    }

    public final Name shortName() {
        return this.fqName.shortName();
    }

    public final Name shortNameOrSpecial() {
        return this.fqName.shortNameOrSpecial();
    }

    public final List<Name> pathSegments() {
        return this.fqName.pathSegments();
    }

    public final boolean startsWith(Name segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        return this.fqName.startsWith(segment);
    }

    public String toString() {
        return this.fqName.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FqName) && Intrinsics.areEqual(this.fqName, ((FqName) other).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    /* compiled from: FqName.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FqName topLevel(Name shortName) {
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            return new FqName(FqNameUnsafe.Companion.topLevel(shortName));
        }
    }
}