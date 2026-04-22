package io.ktor.util;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001aE\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0005*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00050\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0002\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\u0002\u001a\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"", "escapeHTML", "(Ljava/lang/String;)Ljava/lang/String;", "separator", "Lkotlin/Function0;", "Lkotlin/Pair;", "onMissingDelimiter", "chomp", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lkotlin/Pair;", "toLowerCasePreservingASCIIRules", "toUpperCasePreservingASCIIRules", "", "ch", "toLowerCasePreservingASCII", "(C)C", "toUpperCasePreservingASCII", "Lio/ktor/util/CaseInsensitiveString;", "caseInsensitive", "(Ljava/lang/String;)Lio/ktor/util/CaseInsensitiveString;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextKt {
    public static final String escapeHTML(String $this$escapeHTML) {
        Intrinsics.checkNotNullParameter($this$escapeHTML, "<this>");
        if ($this$escapeHTML.length() == 0) {
            return $this$escapeHTML;
        }
        StringBuilder $this$escapeHTML_u24lambda_u240 = new StringBuilder($this$escapeHTML.length());
        int length = $this$escapeHTML.length();
        for (int i = 0; i < length; i++) {
            char element = $this$escapeHTML.charAt(i);
            switch (element) {
                case '\"':
                    $this$escapeHTML_u24lambda_u240.append("&quot;");
                    break;
                case '&':
                    $this$escapeHTML_u24lambda_u240.append("&amp;");
                    break;
                case '\'':
                    $this$escapeHTML_u24lambda_u240.append("&#x27;");
                    break;
                case '<':
                    $this$escapeHTML_u24lambda_u240.append("&lt;");
                    break;
                case '>':
                    $this$escapeHTML_u24lambda_u240.append("&gt;");
                    break;
                default:
                    $this$escapeHTML_u24lambda_u240.append(element);
                    break;
            }
        }
        String sb = $this$escapeHTML_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final Pair<String, String> chomp(String $this$chomp, String separator, Function0<Pair<String, String>> function0) {
        Intrinsics.checkNotNullParameter($this$chomp, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(function0, "onMissingDelimiter");
        int idx = StringsKt.indexOf$default($this$chomp, separator, 0, false, 6, (Object) null);
        if (idx == -1) {
            return (Pair) function0.invoke();
        }
        String substring = $this$chomp.substring(0, idx);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = $this$chomp.substring(separator.length() + idx);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return TuplesKt.to(substring, substring2);
    }

    public static final String toLowerCasePreservingASCIIRules(String $this$toLowerCasePreservingASCIIRules) {
        Intrinsics.checkNotNullParameter($this$toLowerCasePreservingASCIIRules, "<this>");
        String $this$indexOfFirst$iv = $this$toLowerCasePreservingASCIIRules;
        int index$iv = 0;
        int length = $this$indexOfFirst$iv.length();
        while (true) {
            if (index$iv < length) {
                char it = $this$indexOfFirst$iv.charAt(index$iv);
                if (toLowerCasePreservingASCII(it) != it) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int firstIndex = index$iv;
        if (firstIndex == -1) {
            return $this$toLowerCasePreservingASCIIRules;
        }
        StringBuilder $this$toLowerCasePreservingASCIIRules_u24lambda_u242 = new StringBuilder($this$toLowerCasePreservingASCIIRules.length());
        $this$toLowerCasePreservingASCIIRules_u24lambda_u242.append((CharSequence) $this$toLowerCasePreservingASCIIRules, 0, firstIndex);
        int index = firstIndex;
        int lastIndex = StringsKt.getLastIndex($this$toLowerCasePreservingASCIIRules);
        if (index <= lastIndex) {
            while (true) {
                $this$toLowerCasePreservingASCIIRules_u24lambda_u242.append(toLowerCasePreservingASCII($this$toLowerCasePreservingASCIIRules.charAt(index)));
                if (index == lastIndex) {
                    break;
                }
                index++;
            }
        }
        String sb = $this$toLowerCasePreservingASCIIRules_u24lambda_u242.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String toUpperCasePreservingASCIIRules(String $this$toUpperCasePreservingASCIIRules) {
        Intrinsics.checkNotNullParameter($this$toUpperCasePreservingASCIIRules, "<this>");
        String $this$indexOfFirst$iv = $this$toUpperCasePreservingASCIIRules;
        int index$iv = 0;
        int length = $this$indexOfFirst$iv.length();
        while (true) {
            if (index$iv < length) {
                char it = $this$indexOfFirst$iv.charAt(index$iv);
                if (toUpperCasePreservingASCII(it) != it) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int firstIndex = index$iv;
        if (firstIndex == -1) {
            return $this$toUpperCasePreservingASCIIRules;
        }
        StringBuilder $this$toUpperCasePreservingASCIIRules_u24lambda_u244 = new StringBuilder($this$toUpperCasePreservingASCIIRules.length());
        $this$toUpperCasePreservingASCIIRules_u24lambda_u244.append((CharSequence) $this$toUpperCasePreservingASCIIRules, 0, firstIndex);
        int index = firstIndex;
        int lastIndex = StringsKt.getLastIndex($this$toUpperCasePreservingASCIIRules);
        if (index <= lastIndex) {
            while (true) {
                $this$toUpperCasePreservingASCIIRules_u24lambda_u244.append(toUpperCasePreservingASCII($this$toUpperCasePreservingASCIIRules.charAt(index)));
                if (index == lastIndex) {
                    break;
                }
                index++;
            }
        }
        String sb = $this$toUpperCasePreservingASCIIRules_u24lambda_u244.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    private static final char toLowerCasePreservingASCII(char ch) {
        boolean z = true;
        if ('A' <= ch && ch < '[') {
            return (char) (ch + ' ');
        }
        if (ch < 0 || ch >= 128) {
            z = false;
        }
        return z ? ch : Character.toLowerCase(ch);
    }

    private static final char toUpperCasePreservingASCII(char ch) {
        boolean z = true;
        if ('a' <= ch && ch < '{') {
            return (char) (ch - ' ');
        }
        if (ch < 0 || ch >= 128) {
            z = false;
        }
        return z ? ch : Character.toLowerCase(ch);
    }

    public static final CaseInsensitiveString caseInsensitive(String $this$caseInsensitive) {
        Intrinsics.checkNotNullParameter($this$caseInsensitive, "<this>");
        return new CaseInsensitiveString($this$caseInsensitive);
    }
}