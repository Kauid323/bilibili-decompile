package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* compiled from: JvmAbi.kt */
public final class JvmAbi {
    public static final JvmAbi INSTANCE = new JvmAbi();
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmField");
    public static final ClassId JVM_FIELD_ANNOTATION_CLASS_ID = ClassId.Companion.topLevel(JVM_FIELD_ANNOTATION_FQ_NAME);
    private static final ClassId REFLECTION_FACTORY_IMPL = ClassId.Companion.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
    private static final ClassId REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = ClassId.Companion.fromString$default(ClassId.Companion, "kotlin/jvm/internal/RepeatableContainer", false, 2, null);

    private JvmAbi() {
    }

    public final ClassId getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION() {
        return REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION;
    }

    @JvmStatic
    public static final boolean isGetterName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.startsWith$default(name, "get", false, 2, (Object) null) || StringsKt.startsWith$default(name, "is", false, 2, (Object) null);
    }

    @JvmStatic
    public static final boolean isSetterName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.startsWith$default(name, "set", false, 2, (Object) null);
    }

    @JvmStatic
    public static final String getterName(String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        return startsWithIsPrefix(propertyName) ? propertyName : "get" + CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName);
    }

    @JvmStatic
    public static final String setterName(String propertyName) {
        String capitalizeAsciiOnly;
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        StringBuilder append = new StringBuilder().append("set");
        if (startsWithIsPrefix(propertyName)) {
            capitalizeAsciiOnly = propertyName.substring(2);
            Intrinsics.checkNotNullExpressionValue(capitalizeAsciiOnly, "substring(...)");
        } else {
            capitalizeAsciiOnly = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(propertyName);
        }
        return append.append(capitalizeAsciiOnly).toString();
    }

    @JvmStatic
    public static final boolean startsWithIsPrefix(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (StringsKt.startsWith$default(name, "is", false, 2, (Object) null) && name.length() != 2) {
            char c = name.charAt(2);
            return Intrinsics.compare(97, (int) c) > 0 || Intrinsics.compare((int) c, 122) > 0;
        }
        return false;
    }
}