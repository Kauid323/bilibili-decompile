package kotlinx.serialization.json.internal;

import kotlin.Metadata;

/* compiled from: AbstractJsonLexer.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0016\u001a\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0001H\u0000\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"BEGIN_LIST", "", "BEGIN_OBJ", "COLON", "COMMA", "CTC_MAX", "", "END_LIST", "END_OBJ", "ESC2C_MAX", "INVALID", "NULL", "", "STRING", "STRING_ESC", "TC_BEGIN_LIST", "", "TC_BEGIN_OBJ", "TC_COLON", "TC_COMMA", "TC_END_LIST", "TC_END_OBJ", "TC_EOF", "TC_INVALID", "TC_OTHER", "TC_STRING", "TC_STRING_ESC", "TC_WHITESPACE", "UNICODE_ESC", "allowStructuredMapKeysHint", "asciiCaseMask", "coerceInputValuesHint", "ignoreUnknownKeysHint", "lenientHint", "specialFlowingValuesHint", "charToTokenClass", "c", "escapeToChar", "kotlinx-serialization-json"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AbstractJsonLexerKt {
    public static final char BEGIN_LIST = '[';
    public static final char BEGIN_OBJ = '{';
    public static final char COLON = ':';
    public static final char COMMA = ',';
    private static final int CTC_MAX = 126;
    public static final char END_LIST = ']';
    public static final char END_OBJ = '}';
    private static final int ESC2C_MAX = 117;
    public static final char INVALID = 0;
    public static final String NULL = "null";
    public static final char STRING = '\"';
    public static final char STRING_ESC = '\\';
    public static final byte TC_BEGIN_LIST = 8;
    public static final byte TC_BEGIN_OBJ = 6;
    public static final byte TC_COLON = 5;
    public static final byte TC_COMMA = 4;
    public static final byte TC_END_LIST = 9;
    public static final byte TC_END_OBJ = 7;
    public static final byte TC_EOF = 10;
    public static final byte TC_INVALID = Byte.MAX_VALUE;
    public static final byte TC_OTHER = 0;
    public static final byte TC_STRING = 1;
    public static final byte TC_STRING_ESC = 2;
    public static final byte TC_WHITESPACE = 3;
    public static final char UNICODE_ESC = 'u';
    public static final String allowStructuredMapKeysHint = "Use 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.";
    public static final int asciiCaseMask = 32;
    public static final String coerceInputValuesHint = "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.";
    public static final String ignoreUnknownKeysHint = "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.";
    public static final String lenientHint = "Use 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.";
    public static final String specialFlowingValuesHint = "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'";

    public static final byte charToTokenClass(char c) {
        if (c < CTC_MAX) {
            return CharMappings.CHAR_TO_TOKEN[c];
        }
        return (byte) 0;
    }

    public static final char escapeToChar(int c) {
        if (c < ESC2C_MAX) {
            return CharMappings.ESCAPE_2_CHAR[c];
        }
        return (char) 0;
    }
}