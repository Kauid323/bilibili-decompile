package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* compiled from: propertiesConventionUtil.kt */
public final class PropertiesConventionUtilKt {
    public static final Name propertyNameByGetMethodName(Name methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Name propertyNameFromAccessorMethodName$default = propertyNameFromAccessorMethodName$default(methodName, "get", false, null, 12, null);
        return propertyNameFromAccessorMethodName$default == null ? propertyNameFromAccessorMethodName$default(methodName, "is", false, null, 8, null) : propertyNameFromAccessorMethodName$default;
    }

    public static final Name propertyNameBySetMethodName(Name methodName, boolean withIsPrefix) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return propertyNameFromAccessorMethodName$default(methodName, "set", false, withIsPrefix ? "is" : null, 4, null);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return CollectionsKt.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(methodName, false), propertyNameBySetMethodName(methodName, true)});
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name, str, z, str2);
    }

    private static final Name propertyNameFromAccessorMethodName(Name methodName, String prefix, boolean removePrefix, String addPrefix) {
        if (methodName.isSpecial()) {
            return null;
        }
        String identifier = methodName.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        boolean z = false;
        if (StringsKt.startsWith$default(identifier, prefix, false, 2, (Object) null) && identifier.length() != prefix.length()) {
            char charAt = identifier.charAt(prefix.length());
            if ('a' <= charAt && charAt < '{') {
                z = true;
            }
            if (z) {
                return null;
            }
            if (addPrefix != null) {
                if (!removePrefix) {
                    throw new AssertionError("Assertion failed");
                }
                return Name.identifier(addPrefix + StringsKt.removePrefix(identifier, (CharSequence) prefix));
            } else if (removePrefix) {
                String name = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.removePrefix(identifier, (CharSequence) prefix), true);
                if (Name.isValidIdentifier(name)) {
                    return Name.identifier(name);
                }
                return null;
            } else {
                return methodName;
            }
        }
        return null;
    }

    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String nameAsString = name.asString();
        Intrinsics.checkNotNullExpressionValue(nameAsString, "asString(...)");
        if (JvmAbi.isGetterName(nameAsString)) {
            return CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name));
        }
        if (JvmAbi.isSetterName(nameAsString)) {
            return propertyNamesBySetMethodName(name);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
    }
}