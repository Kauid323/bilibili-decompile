package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: SpecialNames.kt */
public final class SpecialNames {
    public static final Name ANONYMOUS;
    public static final FqName ANONYMOUS_FQ_NAME;
    public static final Name ARRAY;
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT;
    public static final Name DESTRUCT;
    public static final Name ENUM_GET_ENTRIES;
    public static final Name IMPLICIT_SET_PARAMETER;
    public static final Name INIT;
    public static final SpecialNames INSTANCE = new SpecialNames();
    public static final Name ITERATOR;
    public static final Name LOCAL;
    public static final Name NO_NAME_PROVIDED;
    public static final Name RECEIVER;
    public static final Name ROOT_PACKAGE;
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME;
    public static final Name THIS;
    public static final Name UNARY;
    public static final Name UNDERSCORE_FOR_UNUSED_VAR;
    public static final Name WHEN_SUBJECT;

    private SpecialNames() {
    }

    static {
        Name special = Name.special("<no name provided>");
        Intrinsics.checkNotNullExpressionValue(special, "special(...)");
        NO_NAME_PROVIDED = special;
        Name special2 = Name.special("<root package>");
        Intrinsics.checkNotNullExpressionValue(special2, "special(...)");
        ROOT_PACKAGE = special2;
        Name identifier = Name.identifier("Companion");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = identifier;
        Name identifier2 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
        SAFE_IDENTIFIER_FOR_NO_NAME = identifier2;
        Name special3 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(special3, "special(...)");
        ANONYMOUS = special3;
        FqName.Companion companion = FqName.Companion;
        Name special4 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(special4, "special(...)");
        ANONYMOUS_FQ_NAME = companion.topLevel(special4);
        Name special5 = Name.special("<unary>");
        Intrinsics.checkNotNullExpressionValue(special5, "special(...)");
        UNARY = special5;
        Name special6 = Name.special("<this>");
        Intrinsics.checkNotNullExpressionValue(special6, "special(...)");
        THIS = special6;
        Name special7 = Name.special("<init>");
        Intrinsics.checkNotNullExpressionValue(special7, "special(...)");
        INIT = special7;
        Name special8 = Name.special("<when-subject>");
        Intrinsics.checkNotNullExpressionValue(special8, "special(...)");
        WHEN_SUBJECT = special8;
        Name special9 = Name.special("<iterator>");
        Intrinsics.checkNotNullExpressionValue(special9, "special(...)");
        ITERATOR = special9;
        Name special10 = Name.special("<destruct>");
        Intrinsics.checkNotNullExpressionValue(special10, "special(...)");
        DESTRUCT = special10;
        Name special11 = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(special11, "special(...)");
        LOCAL = special11;
        Name special12 = Name.special("<unused var>");
        Intrinsics.checkNotNullExpressionValue(special12, "special(...)");
        UNDERSCORE_FOR_UNUSED_VAR = special12;
        Name special13 = Name.special("<set-?>");
        Intrinsics.checkNotNullExpressionValue(special13, "special(...)");
        IMPLICIT_SET_PARAMETER = special13;
        Name special14 = Name.special("<array>");
        Intrinsics.checkNotNullExpressionValue(special14, "special(...)");
        ARRAY = special14;
        Name special15 = Name.special("<receiver>");
        Intrinsics.checkNotNullExpressionValue(special15, "special(...)");
        RECEIVER = special15;
        Name special16 = Name.special("<get-entries>");
        Intrinsics.checkNotNullExpressionValue(special16, "special(...)");
        ENUM_GET_ENTRIES = special16;
    }

    @JvmStatic
    public static final Name safeIdentifier(Name name) {
        return (name == null || name.isSpecial()) ? SAFE_IDENTIFIER_FOR_NO_NAME : name;
    }

    public final boolean isSafeIdentifier(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return (asString.length() > 0) && !name.isSpecial();
    }
}