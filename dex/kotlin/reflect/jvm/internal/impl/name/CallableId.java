package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: CallableId.kt */
public final class CallableId {
    public static final Companion Companion = new Companion(null);
    private static final Name LOCAL_NAME = SpecialNames.LOCAL;
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL = FqName.Companion.topLevel(LOCAL_NAME);
    private final Name callableName;
    private final ClassId classId;
    private final FqName className;
    private final FqName packageName;
    private final FqName pathToLocal;

    private CallableId(FqName packageName, FqName className, Name callableName, ClassId classId, FqName pathToLocal) {
        this.packageName = packageName;
        this.className = className;
        this.callableName = callableName;
        this.classId = classId;
        this.pathToLocal = pathToLocal;
    }

    /* compiled from: CallableId.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallableId(FqName packageName, Name callableName) {
        this(packageName, null, callableName, null, null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(callableName, "callableName");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CallableId) {
            return Intrinsics.areEqual(this.packageName, ((CallableId) other).packageName) && Intrinsics.areEqual(this.className, ((CallableId) other).className) && Intrinsics.areEqual(this.callableName, ((CallableId) other).callableName);
        }
        return false;
    }

    public int hashCode() {
        int result = (17 * 31) + this.packageName.hashCode();
        int result2 = result * 31;
        FqName fqName = this.className;
        return ((result2 + (fqName != null ? fqName.hashCode() : 0)) * 31) + this.callableName.hashCode();
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
        $this$toString_u24lambda_u240.append(StringsKt.replace$default(this.packageName.asString(), (char) FilenameUtils.EXTENSION_SEPARATOR, '/', false, 4, (Object) null));
        $this$toString_u24lambda_u240.append("/");
        if (this.className != null) {
            $this$toString_u24lambda_u240.append(this.className);
            $this$toString_u24lambda_u240.append(".");
        }
        $this$toString_u24lambda_u240.append(this.callableName);
        return $this$toString_u24lambda_u240.toString();
    }
}