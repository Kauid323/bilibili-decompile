package kotlin.reflect.jvm.internal.impl.name;

import BottomSheetItemData$;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: ClassId.kt */
public final class ClassId {
    public static final Companion Companion = new Companion(null);
    private final boolean isLocal;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClassId) {
            ClassId classId = (ClassId) obj;
            return Intrinsics.areEqual(this.packageFqName, classId.packageFqName) && Intrinsics.areEqual(this.relativeClassName, classId.relativeClassName) && this.isLocal == classId.isLocal;
        }
        return false;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLocal);
    }

    public ClassId(FqName packageFqName, FqName relativeClassName, boolean isLocal) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(relativeClassName, "relativeClassName");
        this.packageFqName = packageFqName;
        this.relativeClassName = relativeClassName;
        this.isLocal = isLocal;
        if (this.relativeClassName.isRoot()) {
            throw new AssertionError("Class name must not be root: " + this.packageFqName + (this.isLocal ? " (local)" : ""));
        }
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(FqName packageFqName, Name topLevelName) {
        this(packageFqName, FqName.Companion.topLevel(topLevelName), false);
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(topLevelName, "topLevelName");
    }

    public final Name getShortClassName() {
        return this.relativeClassName.shortName();
    }

    public final ClassId getOuterClassId() {
        FqName parent = this.relativeClassName.parent();
        boolean condition$iv = !parent.isRoot();
        if (condition$iv) {
            return new ClassId(this.packageFqName, parent, this.isLocal);
        }
        return null;
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public final ClassId createNestedClassId(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ClassId(this.packageFqName, this.relativeClassName.child(name), this.isLocal);
    }

    public final FqName asSingleFqName() {
        return this.packageFqName.isRoot() ? this.relativeClassName : new FqName(this.packageFqName.asString() + FilenameUtils.EXTENSION_SEPARATOR + this.relativeClassName.asString());
    }

    private static final String asString$escapeSlashes(FqName $this$asString_u24escapeSlashes) {
        String res = $this$asString_u24escapeSlashes.asString();
        if (StringsKt.contains$default((CharSequence) res, '/', false, 2, (Object) null)) {
            return '`' + res + '`';
        }
        return res;
    }

    public final String asString() {
        if (this.packageFqName.isRoot()) {
            return asString$escapeSlashes(this.relativeClassName);
        }
        StringBuilder $this$asString_u24lambda_u240 = new StringBuilder();
        $this$asString_u24lambda_u240.append(StringsKt.replace$default(this.packageFqName.asString(), (char) FilenameUtils.EXTENSION_SEPARATOR, '/', false, 4, (Object) null));
        $this$asString_u24lambda_u240.append("/");
        $this$asString_u24lambda_u240.append(asString$escapeSlashes(this.relativeClassName));
        return $this$asString_u24lambda_u240.toString();
    }

    public String toString() {
        return this.packageFqName.isRoot() ? '/' + asString() : asString();
    }

    /* compiled from: ClassId.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ClassId topLevel(FqName topLevelFqName) {
            Intrinsics.checkNotNullParameter(topLevelFqName, "topLevelFqName");
            return new ClassId(topLevelFqName.parent(), topLevelFqName.shortName());
        }

        public static /* synthetic */ ClassId fromString$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.fromString(str, z);
        }

        @JvmStatic
        public final ClassId fromString(String string, boolean isLocal) {
            String packageName;
            String className;
            Intrinsics.checkNotNullParameter(string, "string");
            int tickIndex = StringsKt.indexOf$default((CharSequence) string, '`', 0, false, 6, (Object) null);
            int lastSlashIndex = StringsKt.lastIndexOf$default((CharSequence) string, "/", tickIndex == -1 ? string.length() : tickIndex, false, 4, (Object) null);
            if (lastSlashIndex == -1) {
                packageName = "";
                className = StringsKt.replace$default(string, "`", "", false, 4, (Object) null);
            } else {
                String substring = string.substring(0, lastSlashIndex);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                packageName = StringsKt.replace$default(substring, '/', (char) FilenameUtils.EXTENSION_SEPARATOR, false, 4, (Object) null);
                String substring2 = string.substring(lastSlashIndex + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                className = StringsKt.replace$default(substring2, "`", "", false, 4, (Object) null);
            }
            return new ClassId(new FqName(packageName), new FqName(className), isLocal);
        }
    }

    @JvmStatic
    public static final ClassId topLevel(FqName topLevelFqName) {
        return Companion.topLevel(topLevelFqName);
    }
}