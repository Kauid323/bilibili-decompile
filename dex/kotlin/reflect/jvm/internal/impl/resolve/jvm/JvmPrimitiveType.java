package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.apache.commons.io.FilenameUtils;

public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", "S", "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
    
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = new HashMap();
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = new HashMap();
    private static final Set<String> WRAPPER_CLASS_INTERNAL_NAMES = new HashSet();
    private static final Map<String, String> OWNER_TO_BOXING_METHOD_DESCRIPTOR = new HashMap();

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 6:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 6:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "owner";
                break;
            case 2:
                objArr[0] = "methodDescriptor";
                break;
            case 3:
            case 9:
                objArr[0] = "name";
                break;
            case 4:
            case 6:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            case 5:
                objArr[0] = "type";
                break;
            case 7:
            case 10:
                objArr[0] = "desc";
                break;
            case 8:
                objArr[0] = "primitiveType";
                break;
            case 11:
                objArr[0] = "wrapperClassName";
                break;
            default:
                objArr[0] = "internalName";
                break;
        }
        switch (i) {
            case 4:
            case 6:
                objArr[1] = "get";
                break;
            case additional_type_content_opus_VALUE:
                objArr[1] = "getPrimitiveType";
                break;
            case additional_type_content_video_VALUE:
                objArr[1] = "getJavaKeywordName";
                break;
            case additional_type_content_comment_VALUE:
                objArr[1] = "getDesc";
                break;
            case 15:
                objArr[1] = "getWrapperFqName";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
        }
        switch (i) {
            case 1:
            case 2:
                objArr[2] = "isBoxingMethodDescriptor";
                break;
            case 3:
            case 5:
                objArr[2] = "get";
                break;
            case 4:
            case 6:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
                break;
            case 7:
                objArr[2] = "getByDesc";
                break;
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "isWrapperClassInternalName";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 6:
            case additional_type_content_opus_VALUE:
            case additional_type_content_video_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    static {
        JvmPrimitiveType[] values;
        for (JvmPrimitiveType type : values()) {
            TYPE_BY_NAME.put(type.getJavaKeywordName(), type);
            TYPE_BY_PRIMITIVE_TYPE.put(type.getPrimitiveType(), type);
            TYPE_BY_DESC.put(type.getDesc(), type);
            String internalName = type.wrapperFqName.asString().replace(FilenameUtils.EXTENSION_SEPARATOR, '/');
            WRAPPER_CLASS_INTERNAL_NAMES.add(internalName);
            OWNER_TO_BOXING_METHOD_DESCRIPTOR.put(internalName, "(" + type.desc + ")L" + internalName + ";");
        }
    }

    public static JvmPrimitiveType get(String name) {
        if (name == null) {
            $$$reportNull$$$0(3);
        }
        JvmPrimitiveType result = TYPE_BY_NAME.get(name);
        if (result == null) {
            throw new AssertionError("Non-primitive type name passed: " + name);
        }
        if (result == null) {
            $$$reportNull$$$0(4);
        }
        return result;
    }

    public static JvmPrimitiveType get(PrimitiveType type) {
        if (type == null) {
            $$$reportNull$$$0(5);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_PRIMITIVE_TYPE.get(type);
        if (jvmPrimitiveType == null) {
            $$$reportNull$$$0(6);
        }
        return jvmPrimitiveType;
    }

    JvmPrimitiveType(PrimitiveType primitiveType, String name, String desc, String wrapperClassName) {
        if (primitiveType == null) {
            $$$reportNull$$$0(8);
        }
        if (name == null) {
            $$$reportNull$$$0(9);
        }
        if (desc == null) {
            $$$reportNull$$$0(10);
        }
        if (wrapperClassName == null) {
            $$$reportNull$$$0(11);
        }
        this.primitiveType = primitiveType;
        this.name = name;
        this.desc = desc;
        this.wrapperFqName = new FqName(wrapperClassName);
    }

    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType = this.primitiveType;
        if (primitiveType == null) {
            $$$reportNull$$$0(12);
        }
        return primitiveType;
    }

    public String getJavaKeywordName() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(13);
        }
        return str;
    }

    public String getDesc() {
        String str = this.desc;
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        return str;
    }

    public FqName getWrapperFqName() {
        FqName fqName = this.wrapperFqName;
        if (fqName == null) {
            $$$reportNull$$$0(15);
        }
        return fqName;
    }
}