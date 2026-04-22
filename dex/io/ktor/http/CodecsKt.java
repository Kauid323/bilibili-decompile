package io.ktor.http;

import external.org.apache.commons.lang3.ClassUtils;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.BufferKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlinx.io.Buffer;
import kotlinx.io.Source;

/* compiled from: Codecs.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\u001a3\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\r\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\n\u001a\u001b\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a!\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\n\u001a=\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u001c\u0010\u001d\u001a3\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u001e\u0010\u001f\u001a7\u0010 \u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b \u0010\u001d\u001a?\u0010#\u001a\u00020\u0000*\u00020!2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b#\u0010$\u001a\u0013\u0010\u0015\u001a\u00020\u0000*\u00020%H\u0002¢\u0006\u0004\b\u0015\u0010&\u001a\u0017\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0013H\u0002¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010+\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0018H\u0002¢\u0006\u0004\b+\u0010,\u001a'\u00101\u001a\u00020/*\u00020-2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020/0.H\u0002¢\u0006\u0004\b1\u00102\"\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020%0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104\"\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104\"\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00104\"\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020%078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109\"\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00104\" \u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u00104\u001a\u0004\b<\u0010=\"\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020%078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00109¨\u0006?"}, d2 = {"", "", "encodeFull", "spaceToPlus", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "encodeURLQueryComponent", "(Ljava/lang/String;ZZLjava/nio/charset/Charset;)Ljava/lang/String;", "encodeURLPathPart", "(Ljava/lang/String;)Ljava/lang/String;", "encodeSlash", "encodeEncoded", "encodeURLPath", "(Ljava/lang/String;ZZ)Ljava/lang/String;", "encodeOAuth", "encodeURLParameter", "(Ljava/lang/String;Z)Ljava/lang/String;", "", "", "allowedSet", "percentEncode", "(Ljava/lang/String;Ljava/util/Set;)Ljava/lang/String;", "encodeURLParameterValue", "", "start", "end", "plusIsSpace", "decodeURLQueryComponent", "(Ljava/lang/String;IIZLjava/nio/charset/Charset;)Ljava/lang/String;", "decodeURLPart", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Ljava/lang/String;", "decodeScan", "", "prefixEnd", "decodeImpl", "(Ljava/lang/CharSequence;IIIZLjava/nio/charset/Charset;)Ljava/lang/String;", "", "(B)Ljava/lang/String;", "c2", "charToHexDigit", "(C)I", "digit", "hexDigitToChar", "(I)C", "Lkotlinx/io/Source;", "Lkotlin/Function1;", "", "block", "forEach", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)V", "URL_ALPHABET", "Ljava/util/Set;", "URL_ALPHABET_CHARS", "HEX_ALPHABET", "", "URL_PROTOCOL_PART", "Ljava/util/List;", "VALID_PATH_PART", "ATTRIBUTE_CHARACTERS", "getATTRIBUTE_CHARACTERS", "()Ljava/util/Set;", "SPECIAL_SYMBOLS", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CodecsKt {
    private static final Set<Character> ATTRIBUTE_CHARACTERS;
    private static final Set<Character> HEX_ALPHABET;
    private static final List<Byte> SPECIAL_SYMBOLS;
    private static final Set<Byte> URL_ALPHABET;
    private static final Set<Character> URL_ALPHABET_CHARS;
    private static final List<Byte> URL_PROTOCOL_PART;
    private static final Set<Character> VALID_PATH_PART;

    static {
        Iterable $this$map$iv = CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', 'Z')), new CharRange('0', '9'));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            char it = ((Character) item$iv$iv).charValue();
            destination$iv$iv.add(Byte.valueOf((byte) it));
        }
        URL_ALPHABET = CollectionsKt.toSet((List) destination$iv$iv);
        URL_ALPHABET_CHARS = CollectionsKt.toSet(CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', 'Z')), new CharRange('0', '9')));
        HEX_ALPHABET = CollectionsKt.toSet(CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'f'), new CharRange('A', 'F')), new CharRange('0', '9')));
        Iterable $this$map$iv2 = SetsKt.setOf(new Character[]{':', '/', '?', '#', '[', ']', '@', '!', Character.valueOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR), '&', '\'', '(', ')', '*', ',', ';', '=', '-', Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), '_', '~', '+'});
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            char it2 = ((Character) item$iv$iv2).charValue();
            destination$iv$iv2.add(Byte.valueOf((byte) it2));
        }
        URL_PROTOCOL_PART = (List) destination$iv$iv2;
        VALID_PATH_PART = SetsKt.setOf(new Character[]{':', '@', '!', Character.valueOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR), '&', '\'', '(', ')', '*', '+', ',', ';', '=', '-', Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), '_', '~'});
        ATTRIBUTE_CHARACTERS = SetsKt.plus(URL_ALPHABET_CHARS, SetsKt.setOf(new Character[]{'!', '#', Character.valueOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR), '&', '+', '-', Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), '^', '_', '`', '|', '~'}));
        Iterable $this$map$iv3 = CollectionsKt.listOf(new Character[]{'-', Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), '_', '~'});
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            char it3 = ((Character) item$iv$iv3).charValue();
            destination$iv$iv3.add(Byte.valueOf((byte) it3));
        }
        SPECIAL_SYMBOLS = (List) destination$iv$iv3;
    }

    public static final Set<Character> getATTRIBUTE_CHARACTERS() {
        return ATTRIBUTE_CHARACTERS;
    }

    public static /* synthetic */ String encodeURLQueryComponent$default(String str, boolean z, boolean z2, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return encodeURLQueryComponent(str, z, z2, charset);
    }

    public static final String encodeURLQueryComponent(String $this$encodeURLQueryComponent, final boolean encodeFull, final boolean spaceToPlus, Charset charset) {
        Intrinsics.checkNotNullParameter($this$encodeURLQueryComponent, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        final StringBuilder $this$encodeURLQueryComponent_u24lambda_u244 = new StringBuilder();
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "newEncoder(...)");
        Source content = EncodingKt.encode$default(newEncoder, $this$encodeURLQueryComponent, 0, 0, 6, (Object) null);
        forEach(content, new Function1() { // from class: io.ktor.http.CodecsKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit encodeURLQueryComponent$lambda$4$lambda$3;
                encodeURLQueryComponent$lambda$4$lambda$3 = CodecsKt.encodeURLQueryComponent$lambda$4$lambda$3(spaceToPlus, $this$encodeURLQueryComponent_u24lambda_u244, encodeFull, ((Byte) obj).byteValue());
                return encodeURLQueryComponent$lambda$4$lambda$3;
            }
        });
        String sb = $this$encodeURLQueryComponent_u24lambda_u244.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final Unit encodeURLQueryComponent$lambda$4$lambda$3(boolean $spaceToPlus, StringBuilder $this_buildString, boolean $encodeFull, byte it) {
        if (it == 32) {
            if ($spaceToPlus) {
                $this_buildString.append('+');
            } else {
                $this_buildString.append("%20");
            }
        } else if (URL_ALPHABET.contains(Byte.valueOf(it)) || (!$encodeFull && URL_PROTOCOL_PART.contains(Byte.valueOf(it)))) {
            $this_buildString.append((char) it);
        } else {
            $this_buildString.append(percentEncode(it));
        }
        return Unit.INSTANCE;
    }

    public static final String encodeURLPathPart(String $this$encodeURLPathPart) {
        Intrinsics.checkNotNullParameter($this$encodeURLPathPart, "<this>");
        return encodeURLPath$default($this$encodeURLPathPart, true, false, 2, null);
    }

    public static /* synthetic */ String encodeURLPath$default(String str, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return encodeURLPath(str, z, z2);
    }

    public static final String encodeURLPath(String $this$encodeURLPath, boolean encodeSlash, boolean encodeEncoded) {
        Intrinsics.checkNotNullParameter($this$encodeURLPath, "<this>");
        final StringBuilder $this$encodeURLPath_u24lambda_u246 = new StringBuilder();
        Charset charset = Charsets.UTF_8;
        int index = 0;
        while (index < $this$encodeURLPath.length()) {
            char current = $this$encodeURLPath.charAt(index);
            if ((!encodeSlash && current == '/') || URL_ALPHABET_CHARS.contains(Character.valueOf(current)) || VALID_PATH_PART.contains(Character.valueOf(current))) {
                $this$encodeURLPath_u24lambda_u246.append(current);
                index++;
            } else if (!encodeEncoded && current == '%' && index + 2 < $this$encodeURLPath.length() && HEX_ALPHABET.contains(Character.valueOf($this$encodeURLPath.charAt(index + 1))) && HEX_ALPHABET.contains(Character.valueOf($this$encodeURLPath.charAt(index + 2)))) {
                $this$encodeURLPath_u24lambda_u246.append(current);
                $this$encodeURLPath_u24lambda_u246.append($this$encodeURLPath.charAt(index + 1));
                $this$encodeURLPath_u24lambda_u246.append($this$encodeURLPath.charAt(index + 2));
                index += 3;
            } else {
                int symbolSize = CharsKt.isSurrogate(current) ? 2 : 1;
                CharsetEncoder newEncoder = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(newEncoder, "newEncoder(...)");
                forEach(EncodingKt.encode(newEncoder, $this$encodeURLPath, index, index + symbolSize), new Function1() { // from class: io.ktor.http.CodecsKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit encodeURLPath$lambda$6$lambda$5;
                        encodeURLPath$lambda$6$lambda$5 = CodecsKt.encodeURLPath$lambda$6$lambda$5($this$encodeURLPath_u24lambda_u246, ((Byte) obj).byteValue());
                        return encodeURLPath$lambda$6$lambda$5;
                    }
                });
                index += symbolSize;
            }
        }
        String sb = $this$encodeURLPath_u24lambda_u246.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final Unit encodeURLPath$lambda$6$lambda$5(StringBuilder $this_buildString, byte it) {
        $this_buildString.append(percentEncode(it));
        return Unit.INSTANCE;
    }

    public static final String encodeOAuth(String $this$encodeOAuth) {
        Intrinsics.checkNotNullParameter($this$encodeOAuth, "<this>");
        return encodeURLParameter$default($this$encodeOAuth, false, 1, null);
    }

    public static /* synthetic */ String encodeURLParameter$default(String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return encodeURLParameter(str, z);
    }

    public static final String encodeURLParameter(String $this$encodeURLParameter, final boolean spaceToPlus) {
        Intrinsics.checkNotNullParameter($this$encodeURLParameter, "<this>");
        final StringBuilder $this$encodeURLParameter_u24lambda_u248 = new StringBuilder();
        CharsetEncoder newEncoder = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "newEncoder(...)");
        Source content = EncodingKt.encode$default(newEncoder, $this$encodeURLParameter, 0, 0, 6, (Object) null);
        forEach(content, new Function1() { // from class: io.ktor.http.CodecsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit encodeURLParameter$lambda$8$lambda$7;
                encodeURLParameter$lambda$8$lambda$7 = CodecsKt.encodeURLParameter$lambda$8$lambda$7($this$encodeURLParameter_u24lambda_u248, spaceToPlus, ((Byte) obj).byteValue());
                return encodeURLParameter$lambda$8$lambda$7;
            }
        });
        String sb = $this$encodeURLParameter_u24lambda_u248.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final Unit encodeURLParameter$lambda$8$lambda$7(StringBuilder $this_buildString, boolean $spaceToPlus, byte it) {
        if (URL_ALPHABET.contains(Byte.valueOf(it)) || SPECIAL_SYMBOLS.contains(Byte.valueOf(it))) {
            $this_buildString.append((char) it);
        } else if ($spaceToPlus && it == 32) {
            $this_buildString.append('+');
        } else {
            $this_buildString.append(percentEncode(it));
        }
        return Unit.INSTANCE;
    }

    public static final String percentEncode(String $this$percentEncode, Set<Character> set) {
        Intrinsics.checkNotNullParameter($this$percentEncode, "<this>");
        Intrinsics.checkNotNullParameter(set, "allowedSet");
        String $this$count$iv = $this$percentEncode;
        int count$iv = 0;
        for (int i2 = 0; i2 < $this$count$iv.length(); i2++) {
            if (!set.contains(Character.valueOf($this$count$iv.charAt(i2)))) {
                count$iv++;
            }
        }
        int encodedCount = count$iv;
        if (encodedCount == 0) {
            return $this$percentEncode;
        }
        byte[] content = StringsKt.toByteArray($this$percentEncode, Charsets.UTF_8);
        int rawCount = $this$percentEncode.length() - encodedCount;
        int resultSize = ((content.length - rawCount) * 3) + rawCount;
        char[] result = new char[resultSize];
        int writeIndex = 0;
        for (byte element$iv : content) {
            char c = (char) element$iv;
            if (set.contains(Character.valueOf(c))) {
                result[writeIndex] = c;
                writeIndex++;
            } else {
                int writeIndex2 = element$iv & 255;
                int writeIndex3 = writeIndex + 1;
                result[writeIndex] = '%';
                int writeIndex4 = writeIndex3 + 1;
                result[writeIndex3] = hexDigitToChar(writeIndex2 >> 4);
                result[writeIndex4] = hexDigitToChar(writeIndex2 & 15);
                writeIndex = writeIndex4 + 1;
            }
        }
        return kotlin.text.StringsKt.concatToString(result);
    }

    public static final String encodeURLParameterValue(String $this$encodeURLParameterValue) {
        Intrinsics.checkNotNullParameter($this$encodeURLParameterValue, "<this>");
        return encodeURLParameter($this$encodeURLParameterValue, true);
    }

    public static /* synthetic */ String decodeURLQueryComponent$default(String str, int i2, int i3, boolean z, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeURLQueryComponent(str, i2, i3, z, charset);
    }

    public static final String decodeURLQueryComponent(String $this$decodeURLQueryComponent, int start, int end, boolean plusIsSpace, Charset charset) {
        Intrinsics.checkNotNullParameter($this$decodeURLQueryComponent, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return decodeScan($this$decodeURLQueryComponent, start, end, plusIsSpace, charset);
    }

    public static /* synthetic */ String decodeURLPart$default(String str, int i2, int i3, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeURLPart(str, i2, i3, charset);
    }

    public static final String decodeURLPart(String $this$decodeURLPart, int start, int end, Charset charset) {
        Intrinsics.checkNotNullParameter($this$decodeURLPart, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return decodeScan($this$decodeURLPart, start, end, false, charset);
    }

    private static final String decodeScan(String $this$decodeScan, int start, int end, boolean plusIsSpace, Charset charset) {
        for (int index = start; index < end; index++) {
            char ch = $this$decodeScan.charAt(index);
            if (ch == '%' || (plusIsSpace && ch == '+')) {
                return decodeImpl($this$decodeScan, start, end, index, plusIsSpace, charset);
            }
        }
        if (start == 0 && end == $this$decodeScan.length()) {
            return $this$decodeScan.toString();
        }
        String substring = $this$decodeScan.substring(start, end);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    private static final String decodeImpl(CharSequence $this$decodeImpl, int start, int end, int prefixEnd, boolean plusIsSpace, Charset charset) {
        int length = end - start;
        int sbSize = length > 255 ? length / 3 : length;
        StringBuilder sb = new StringBuilder(sbSize);
        if (prefixEnd > start) {
            sb.append($this$decodeImpl, start, prefixEnd);
        }
        int index = prefixEnd;
        byte[] bytes = null;
        while (index < end) {
            char c = $this$decodeImpl.charAt(index);
            if (plusIsSpace && c == '+') {
                sb.append(' ');
                int index2 = index + 1;
                Integer.valueOf(index);
                index = index2;
            } else if (c == '%') {
                if (bytes == null) {
                    bytes = new byte[(end - index) / 3];
                }
                int count = 0;
                while (index < end && $this$decodeImpl.charAt(index) == '%') {
                    if (index + 2 < end) {
                        int digit1 = charToHexDigit($this$decodeImpl.charAt(index + 1));
                        int digit2 = charToHexDigit($this$decodeImpl.charAt(index + 2));
                        if (digit1 == -1 || digit2 == -1) {
                            throw new URLDecodeException("Wrong HEX escape: %" + $this$decodeImpl.charAt(index + 1) + $this$decodeImpl.charAt(index + 2) + ", in " + ((Object) $this$decodeImpl) + ", at " + index);
                        }
                        bytes[count] = (byte) ((digit1 * 16) + digit2);
                        index += 3;
                        count++;
                    } else {
                        throw new URLDecodeException("Incomplete trailing HEX escape: " + $this$decodeImpl.subSequence(index, $this$decodeImpl.length()).toString() + ", in " + ((Object) $this$decodeImpl) + " at " + index);
                    }
                }
                sb.append(kotlin.text.StringsKt.decodeToString$default(bytes, 0, count + 0, false, 4, (Object) null));
            } else {
                sb.append(c);
                int index3 = index + 1;
                Integer.valueOf(index);
                index = index3;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private static final String percentEncode(byte $this$percentEncode) {
        int code = $this$percentEncode & 255;
        char[] array = {'%', hexDigitToChar(code >> 4), hexDigitToChar(code & 15)};
        return kotlin.text.StringsKt.concatToString(array);
    }

    private static final int charToHexDigit(char c2) {
        boolean z = true;
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('A' <= c2 && c2 < 'G') {
            return (c2 - 'A') + 10;
        }
        if ('a' > c2 || c2 >= 'g') {
            z = false;
        }
        if (z) {
            return (c2 - 'a') + 10;
        }
        return -1;
    }

    private static final char hexDigitToChar(int digit) {
        boolean z = false;
        if (digit >= 0 && digit < 10) {
            z = true;
        }
        return z ? (char) (digit + 48) : (char) (((char) (digit + 65)) - '\n');
    }

    private static final void forEach(Source $this$forEach, final Function1<? super Byte, Unit> function1) {
        ByteReadPacketKt.takeWhile($this$forEach, new Function1() { // from class: io.ktor.http.CodecsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean forEach$lambda$11;
                forEach$lambda$11 = CodecsKt.forEach$lambda$11(function1, (Buffer) obj);
                return Boolean.valueOf(forEach$lambda$11);
            }
        });
    }

    public static final boolean forEach$lambda$11(Function1 $block, Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        while (BufferKt.canRead(buffer)) {
            $block.invoke(Byte.valueOf(buffer.readByte()));
        }
        return true;
    }
}