package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: capitalizeDecapitalize.kt */
public final class CapitalizeDecapitalizeKt {
    public static final String decapitalizeSmartForCompiler(String $this$decapitalizeSmartForCompiler, boolean asciiOnly) {
        Object element$iv;
        Intrinsics.checkNotNullParameter($this$decapitalizeSmartForCompiler, "<this>");
        if (($this$decapitalizeSmartForCompiler.length() == 0) || !isUpperCaseCharAt($this$decapitalizeSmartForCompiler, 0, asciiOnly)) {
            return $this$decapitalizeSmartForCompiler;
        }
        if ($this$decapitalizeSmartForCompiler.length() == 1 || !isUpperCaseCharAt($this$decapitalizeSmartForCompiler, 1, asciiOnly)) {
            if (asciiOnly) {
                return decapitalizeAsciiOnly($this$decapitalizeSmartForCompiler);
            }
            if ($this$decapitalizeSmartForCompiler.length() > 0) {
                char p0 = $this$decapitalizeSmartForCompiler.charAt(0);
                char lowerCase = Character.toLowerCase(p0);
                String substring = $this$decapitalizeSmartForCompiler.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                return lowerCase + substring;
            }
            return $this$decapitalizeSmartForCompiler;
        }
        Iterable $this$firstOrNull$iv = StringsKt.getIndices($this$decapitalizeSmartForCompiler);
        Iterator<Integer> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            int it2 = ((Number) element$iv).intValue();
            if (!isUpperCaseCharAt($this$decapitalizeSmartForCompiler, it2, asciiOnly)) {
                break;
            }
        }
        Integer num = (Integer) element$iv;
        if (num != null) {
            int secondWordStart = num.intValue() - 1;
            StringBuilder sb = new StringBuilder();
            String substring2 = $this$decapitalizeSmartForCompiler.substring(0, secondWordStart);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            StringBuilder append = sb.append(toLowerCase(substring2, asciiOnly));
            String substring3 = $this$decapitalizeSmartForCompiler.substring(secondWordStart);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            return append.append(substring3).toString();
        }
        return toLowerCase($this$decapitalizeSmartForCompiler, asciiOnly);
    }

    private static final boolean isUpperCaseCharAt(String $this$isUpperCaseCharAt, int index, boolean asciiOnly) {
        char c = $this$isUpperCaseCharAt.charAt(index);
        return asciiOnly ? 'A' <= c && c < '[' : Character.isUpperCase(c);
    }

    private static final String toLowerCase(String string, boolean asciiOnly) {
        if (asciiOnly) {
            return toLowerCaseAsciiOnly(string);
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String capitalizeAsciiOnly(String $this$capitalizeAsciiOnly) {
        Intrinsics.checkNotNullParameter($this$capitalizeAsciiOnly, "<this>");
        boolean z = false;
        if ($this$capitalizeAsciiOnly.length() == 0) {
            return $this$capitalizeAsciiOnly;
        }
        char c = $this$capitalizeAsciiOnly.charAt(0);
        if ('a' <= c && c < '{') {
            z = true;
        }
        if (z) {
            StringBuilder $this$capitalizeAsciiOnly_u24lambda_u240 = new StringBuilder($this$capitalizeAsciiOnly.length());
            $this$capitalizeAsciiOnly_u24lambda_u240.append(Character.toUpperCase(c));
            $this$capitalizeAsciiOnly_u24lambda_u240.append((CharSequence) $this$capitalizeAsciiOnly, 1, $this$capitalizeAsciiOnly.length());
            return $this$capitalizeAsciiOnly_u24lambda_u240.toString();
        }
        return $this$capitalizeAsciiOnly;
    }

    public static final String decapitalizeAsciiOnly(String $this$decapitalizeAsciiOnly) {
        Intrinsics.checkNotNullParameter($this$decapitalizeAsciiOnly, "<this>");
        boolean z = false;
        if ($this$decapitalizeAsciiOnly.length() == 0) {
            return $this$decapitalizeAsciiOnly;
        }
        char c = $this$decapitalizeAsciiOnly.charAt(0);
        if ('A' <= c && c < '[') {
            z = true;
        }
        if (z) {
            char lowerCase = Character.toLowerCase(c);
            String substring = $this$decapitalizeAsciiOnly.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return lowerCase + substring;
        }
        return $this$decapitalizeAsciiOnly;
    }

    public static final String toLowerCaseAsciiOnly(String $this$toLowerCaseAsciiOnly) {
        Intrinsics.checkNotNullParameter($this$toLowerCaseAsciiOnly, "<this>");
        StringBuilder builder = new StringBuilder($this$toLowerCaseAsciiOnly.length());
        int length = $this$toLowerCaseAsciiOnly.length();
        for (int i = 0; i < length; i++) {
            char c = $this$toLowerCaseAsciiOnly.charAt(i);
            builder.append('A' <= c && c < '[' ? Character.toLowerCase(c) : c);
        }
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}