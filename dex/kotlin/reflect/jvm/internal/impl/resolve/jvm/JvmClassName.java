package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

public class JvmClassName {
    private FqName fqName;
    private final String internalName;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 3:
            case 5:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 4:
            case 6:
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 3:
            case 5:
            case 8:
            case 9:
            case 10:
                i2 = 2;
                break;
            case 4:
            case 6:
            case 7:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
                objArr[0] = "classId";
                break;
            case 3:
            case 5:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 4:
            case 6:
                objArr[0] = "fqName";
                break;
            case 7:
            default:
                objArr[0] = "internalName";
                break;
        }
        switch (i) {
            case 3:
                objArr[1] = "internalNameByClassId";
                break;
            case 4:
            case 6:
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
                objArr[1] = "byFqNameWithoutInnerClasses";
                break;
            case 8:
                objArr[1] = "getFqNameForClassNameWithoutDollars";
                break;
            case 9:
                objArr[1] = "getPackageFqName";
                break;
            case 10:
                objArr[1] = "getInternalName";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
                objArr[2] = "internalNameByClassId";
                break;
            case 3:
            case 5:
            case 8:
            case 9:
            case 10:
                break;
            case 4:
            case 6:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 7:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 3:
            case 5:
            case 8:
            case 9:
            case 10:
                throw new IllegalStateException(format);
            case 4:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static JvmClassName byInternalName(String internalName) {
        if (internalName == null) {
            $$$reportNull$$$0(0);
        }
        return new JvmClassName(internalName);
    }

    public static JvmClassName byClassId(ClassId classId) {
        if (classId == null) {
            $$$reportNull$$$0(1);
        }
        return new JvmClassName(internalNameByClassId(classId));
    }

    public static String internalNameByClassId(ClassId classId) {
        if (classId == null) {
            $$$reportNull$$$0(2);
        }
        FqName packageFqName = classId.getPackageFqName();
        String relativeClassName = classId.getRelativeClassName().asString().replace(FilenameUtils.EXTENSION_SEPARATOR, Typography.dollar);
        String str = packageFqName.isRoot() ? relativeClassName : packageFqName.asString().replace(FilenameUtils.EXTENSION_SEPARATOR, '/') + "/" + relativeClassName;
        if (str == null) {
            $$$reportNull$$$0(3);
        }
        return str;
    }

    public static JvmClassName byFqNameWithoutInnerClasses(FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(4);
        }
        JvmClassName r = new JvmClassName(fqName.asString().replace(FilenameUtils.EXTENSION_SEPARATOR, '/'));
        r.fqName = fqName;
        return r;
    }

    private JvmClassName(String internalName) {
        if (internalName == null) {
            $$$reportNull$$$0(7);
        }
        this.internalName = internalName;
    }

    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace('/', FilenameUtils.EXTENSION_SEPARATOR));
    }

    public FqName getPackageFqName() {
        int lastSlash = this.internalName.lastIndexOf("/");
        if (lastSlash == -1) {
            FqName fqName = FqName.ROOT;
            if (fqName == null) {
                $$$reportNull$$$0(9);
            }
            return fqName;
        }
        return new FqName(this.internalName.substring(0, lastSlash).replace('/', FilenameUtils.EXTENSION_SEPARATOR));
    }

    public String getInternalName() {
        String str = this.internalName;
        if (str == null) {
            $$$reportNull$$$0(10);
        }
        return str;
    }

    public String toString() {
        return this.internalName;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.internalName.equals(((JvmClassName) o).internalName);
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }
}