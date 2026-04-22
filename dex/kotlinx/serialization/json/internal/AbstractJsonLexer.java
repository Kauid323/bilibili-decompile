package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AbstractJsonLexer.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0014J\b\u0010\u001f\u001a\u00020 H&J\u0006\u0010!\u001a\u00020 J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0004H\u0003J\u0006\u0010#\u001a\u00020 J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010&\u001a\u00020\u000fH&J\u001a\u0010'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020 H&J\b\u0010*\u001a\u00020+H&J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u000fJ \u00100\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0005J3\u00101\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020 2!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u001c03H\u0016J\u0006\u00107\u001a\u00020\u000fJ\u0006\u00108\u001a\u00020\u000fJ\u0018\u00109\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010:\u001a\u00020\u001cH\u0016J\u0006\u0010;\u001a\u00020\u001cJ\u0015\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020+H\u0000¢\u0006\u0002\b?J\"\u0010<\u001a\u00020=2\u0006\u0010@\u001a\u00020\u000f2\b\b\u0002\u0010A\u001a\u00020\u00042\b\b\u0002\u0010B\u001a\u00020\u000fJ\u000e\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u000fJ\u0018\u0010E\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0018\u0010H\u001a\u00020 2\u0006\u0010)\u001a\u00020 2\u0006\u0010G\u001a\u00020-H\u0002J\u0006\u0010I\u001a\u00020 J\u0010\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020-H\u0004J\u0006\u0010L\u001a\u00020+J\u0010\u0010M\u001a\u0004\u0018\u00010\u000f2\u0006\u0010)\u001a\u00020 J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H&J1\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020 2\b\b\u0002\u0010A\u001a\u00020\u00042\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000f0QH\u0080\bø\u0001\u0000¢\u0006\u0002\bRJ\u000e\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020 J\b\u0010U\u001a\u00020\u0004H\u0016J\u0018\u0010V\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u0004H\u0016J\b\u0010X\u001a\u00020\u000fH\u0002J\b\u0010Y\u001a\u00020\u000fH\u0016J\b\u0010Z\u001a\u00020 H&J\u0010\u0010[\u001a\u00020 2\b\b\u0002\u0010\\\u001a\u00020 J\u0010\u0010]\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0004J\b\u0010^\u001a\u00020 H\u0002JC\u0010_\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010`\u001a\u00020 2!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u001c03H\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u0011X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006a"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "()V", "currentPosition", "", "escapedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "peekedString", "", "source", "", "getSource", "()Ljava/lang/CharSequence;", "appendEsc", "startPosition", "appendEscape", "lastPosition", "current", "appendHex", "startPos", "appendRange", "", "fromIndex", "toIndex", "canConsumeValue", "", "consumeBoolean", "start", "consumeBooleanLenient", "consumeBooleanLiteral", "literalSuffix", "consumeKeyString", "consumeLeadingMatchingValue", "keyToMatch", "isLenient", "consumeNextToken", "", "expected", "", "consumeNumericLiteral", "", "consumeString", "consumeStringChunked", "consumeChunk", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "stringChunk", "consumeStringLenient", "consumeStringLenientNotNull", "decodedString", "ensureHaveChars", "expectEof", "fail", "", "expectedToken", "fail$kotlinx_serialization_json", "message", "position", "hint", "failOnUnknownKey", "key", "fromHexChar", "indexOf", "char", "insideString", "isNotEof", "isValidValueStart", "c", "peekNextToken", "peekString", "prefetchOrEof", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_json", "skipElement", "allowLenientStrings", "skipWhitespaces", "substring", "endPos", "takePeeked", "toString", "tryConsumeComma", "tryConsumeNull", "doConsume", "unexpectedToken", "wasUnquotedString", "writeRange", "currentChunkHasEscape", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractJsonLexer {
    protected int currentPosition;
    private String peekedString;
    public final JsonPath path = new JsonPath();
    private StringBuilder escapedString = new StringBuilder();

    public abstract boolean canConsumeValue();

    public abstract String consumeKeyString();

    public abstract String consumeLeadingMatchingValue(String str, boolean z);

    public abstract byte consumeNextToken();

    protected abstract CharSequence getSource();

    public abstract int prefetchOrEof(int i);

    public abstract boolean tryConsumeComma();

    public void ensureHaveChars() {
    }

    public final boolean isNotEof() {
        return peekNextToken() != 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isValidValueStart(char c) {
        return !(((c == '}' || c == ']') || c == ':') || c == ',');
    }

    public final void expectEof() {
        byte nextToken = consumeNextToken();
        if (nextToken != 10) {
            fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final StringBuilder getEscapedString() {
        return this.escapedString;
    }

    protected final void setEscapedString(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<set-?>");
        this.escapedString = sb;
    }

    public final byte consumeNextToken(byte expected) {
        byte token = consumeNextToken();
        if (token != expected) {
            fail$kotlinx_serialization_json(expected);
            throw new KotlinNothingValueException();
        }
        return token;
    }

    public void consumeNextToken(char expected) {
        ensureHaveChars();
        CharSequence source = getSource();
        int cpos = this.currentPosition;
        while (true) {
            int cpos2 = prefetchOrEof(cpos);
            if (cpos2 != -1) {
                int cpos3 = cpos2 + 1;
                char c = source.charAt(cpos2);
                if (c != ' ' && c != '\n' && c != '\r' && c != '\t') {
                    this.currentPosition = cpos3;
                    if (c == expected) {
                        return;
                    }
                    unexpectedToken(expected);
                }
                cpos = cpos3;
            } else {
                this.currentPosition = cpos2;
                unexpectedToken(expected);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void unexpectedToken(char expected) {
        this.currentPosition--;
        if (this.currentPosition >= 0 && expected == '\"' && Intrinsics.areEqual(consumeStringLenient(), AbstractJsonLexerKt.NULL)) {
            fail("Expected string literal but 'null' literal was found", this.currentPosition - 4, AbstractJsonLexerKt.coerceInputValuesHint);
            throw new KotlinNothingValueException();
        } else {
            fail$kotlinx_serialization_json(AbstractJsonLexerKt.charToTokenClass(expected));
            throw new KotlinNothingValueException();
        }
    }

    public final Void fail$kotlinx_serialization_json(byte expectedToken) {
        String expected;
        if (expectedToken == 1) {
            expected = "quotation mark '\"'";
        } else if (expectedToken == 4) {
            expected = "comma ','";
        } else if (expectedToken == 5) {
            expected = "colon ':'";
        } else if (expectedToken == 6) {
            expected = "start of the object '{'";
        } else if (expectedToken == 7) {
            expected = "end of the object '}'";
        } else if (expectedToken == 8) {
            expected = "start of the array '['";
        } else {
            expected = expectedToken == 9 ? "end of the array ']'" : "valid token";
        }
        String s = (this.currentPosition == getSource().length() || this.currentPosition <= 0) ? "EOF" : String.valueOf(getSource().charAt(this.currentPosition - 1));
        fail$default(this, "Expected " + expected + ", but had '" + s + "' instead", this.currentPosition - 1, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final byte peekNextToken() {
        CharSequence source = getSource();
        int cpos = this.currentPosition;
        while (true) {
            int cpos2 = prefetchOrEof(cpos);
            if (cpos2 != -1) {
                char ch = source.charAt(cpos2);
                if (ch == ' ' || ch == '\n' || ch == '\r' || ch == '\t') {
                    cpos = cpos2 + 1;
                } else {
                    this.currentPosition = cpos2;
                    return AbstractJsonLexerKt.charToTokenClass(ch);
                }
            } else {
                this.currentPosition = cpos2;
                return (byte) 10;
            }
        }
    }

    public static /* synthetic */ boolean tryConsumeNull$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return abstractJsonLexer.tryConsumeNull(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
    }

    public final boolean tryConsumeNull(boolean doConsume) {
        int current = prefetchOrEof(skipWhitespaces());
        int len = getSource().length() - current;
        if (len < 4 || current == -1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (AbstractJsonLexerKt.NULL.charAt(i) != getSource().charAt(current + i)) {
                return false;
            }
        }
        if (len > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(current + 4)) == 0) {
            return false;
        }
        if (doConsume) {
            this.currentPosition = current + 4;
            return true;
        }
        return true;
    }

    public int skipWhitespaces() {
        int current;
        char c;
        int current2 = this.currentPosition;
        while (true) {
            current = prefetchOrEof(current2);
            if (current == -1 || !((c = getSource().charAt(current)) == ' ' || c == '\n' || c == '\r' || c == '\t')) {
                break;
            }
            current2 = current + 1;
        }
        this.currentPosition = current;
        return current;
    }

    public final String peekString(boolean isLenient) {
        String string;
        byte token = peekNextToken();
        if (isLenient) {
            if (token != 1 && token != 0) {
                return null;
            }
            string = consumeStringLenient();
        } else if (token != 1) {
            return null;
        } else {
            string = consumeString();
        }
        this.peekedString = string;
        return string;
    }

    public int indexOf(char c, int startPos) {
        return StringsKt.indexOf$default(getSource(), c, startPos, false, 4, (Object) null);
    }

    public String substring(int startPos, int endPos) {
        return getSource().subSequence(startPos, endPos).toString();
    }

    private final boolean insideString(boolean isLenient, char c) {
        return isLenient ? AbstractJsonLexerKt.charToTokenClass(c) == 0 : c != '\"';
    }

    public void consumeStringChunked(boolean isLenient, Function1<? super String, Unit> consumeChunk) {
        Intrinsics.checkNotNullParameter(consumeChunk, "consumeChunk");
        byte nextToken = peekNextToken();
        if (!isLenient || nextToken == 0) {
            if (!isLenient) {
                consumeNextToken('\"');
            }
            int currentPosition = this.currentPosition;
            int lastPosition = currentPosition;
            char charAt = getSource().charAt(currentPosition);
            boolean usedAppend = false;
            while (insideString(isLenient, charAt)) {
                if (!isLenient && charAt == '\\') {
                    usedAppend = true;
                    currentPosition = prefetchOrEof(appendEscape(lastPosition, currentPosition));
                    lastPosition = currentPosition;
                } else {
                    currentPosition++;
                }
                if (currentPosition >= getSource().length()) {
                    writeRange(lastPosition, currentPosition, usedAppend, consumeChunk);
                    usedAppend = false;
                    currentPosition = prefetchOrEof(currentPosition);
                    if (currentPosition == -1) {
                        fail$default(this, "EOF", currentPosition, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    lastPosition = currentPosition;
                }
                charAt = getSource().charAt(currentPosition);
            }
            writeRange(lastPosition, currentPosition, usedAppend, consumeChunk);
            this.currentPosition = currentPosition;
            if (!isLenient) {
                consumeNextToken('\"');
            }
        }
    }

    private final void writeRange(int fromIndex, int toIndex, boolean currentChunkHasEscape, Function1<? super String, Unit> function1) {
        if (currentChunkHasEscape) {
            function1.invoke(decodedString(fromIndex, toIndex));
        } else {
            function1.invoke(substring(fromIndex, toIndex));
        }
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String consumeString(CharSequence source, int startPosition, int current) {
        String string;
        Intrinsics.checkNotNullParameter(source, "source");
        int currentPosition = current;
        int lastPosition = startPosition;
        char charAt = source.charAt(currentPosition);
        boolean usedAppend = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                usedAppend = true;
                currentPosition = prefetchOrEof(appendEscape(lastPosition, currentPosition));
                if (currentPosition == -1) {
                    fail$default(this, "EOF", currentPosition, null, 4, null);
                    throw new KotlinNothingValueException();
                }
                lastPosition = currentPosition;
            } else {
                currentPosition++;
                if (currentPosition >= source.length()) {
                    usedAppend = true;
                    appendRange(lastPosition, currentPosition);
                    currentPosition = prefetchOrEof(currentPosition);
                    if (currentPosition == -1) {
                        fail$default(this, "EOF", currentPosition, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                    lastPosition = currentPosition;
                } else {
                    continue;
                }
            }
            charAt = source.charAt(currentPosition);
        }
        if (!usedAppend) {
            string = substring(lastPosition, currentPosition);
        } else {
            string = decodedString(lastPosition, currentPosition);
        }
        this.currentPosition = currentPosition + 1;
        return string;
    }

    private final int appendEscape(int lastPosition, int current) {
        appendRange(lastPosition, current);
        return appendEsc(current + 1);
    }

    private final String decodedString(int lastPosition, int currentPosition) {
        appendRange(lastPosition, currentPosition);
        String result = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(result, "escapedString.toString()");
        this.escapedString.setLength(0);
        return result;
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public final String consumeStringLenientNotNull() {
        String result = consumeStringLenient();
        if (Intrinsics.areEqual(result, AbstractJsonLexerKt.NULL) && wasUnquotedString()) {
            fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return result;
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    public final String consumeStringLenient() {
        String result;
        if (this.peekedString != null) {
            return takePeeked();
        }
        int current = skipWhitespaces();
        if (current >= getSource().length() || current == -1) {
            fail$default(this, "EOF", current, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte token = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(current));
        if (token == 1) {
            return consumeString();
        }
        if (token != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(current), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean usedAppend = false;
        while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(current)) == 0) {
            current++;
            if (current >= getSource().length()) {
                usedAppend = true;
                appendRange(this.currentPosition, current);
                int eof = prefetchOrEof(current);
                if (eof == -1) {
                    this.currentPosition = current;
                    return decodedString(0, 0);
                }
                current = eof;
            }
        }
        if (!usedAppend) {
            result = substring(this.currentPosition, current);
        } else {
            result = decodedString(this.currentPosition, current);
        }
        this.currentPosition = current;
        return result;
    }

    protected void appendRange(int fromIndex, int toIndex) {
        this.escapedString.append(getSource(), fromIndex, toIndex);
    }

    private final int appendEsc(int startPosition) {
        int currentPosition = prefetchOrEof(startPosition);
        if (currentPosition == -1) {
            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int currentPosition2 = currentPosition + 1;
        char currentChar = getSource().charAt(currentPosition);
        if (currentChar == 'u') {
            return appendHex(getSource(), currentPosition2);
        }
        char c = AbstractJsonLexerKt.escapeToChar(currentChar);
        if (c == 0) {
            fail$default(this, "Invalid escaped char '" + currentChar + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        this.escapedString.append(c);
        return currentPosition2;
    }

    private final int appendHex(CharSequence source, int startPos) {
        if (startPos + 4 < source.length()) {
            this.escapedString.append((char) ((fromHexChar(source, startPos) << 12) + (fromHexChar(source, startPos + 1) << 8) + (fromHexChar(source, startPos + 2) << 4) + fromHexChar(source, startPos + 3)));
            return startPos + 4;
        }
        this.currentPosition = startPos;
        ensureHaveChars();
        if (this.currentPosition + 4 < source.length()) {
            return appendHex(source, this.currentPosition);
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void require$kotlinx_serialization_json$default(AbstractJsonLexer $this, boolean condition, int position, Function0 message, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: require");
        }
        if ((i & 2) != 0) {
            position = $this.currentPosition;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (!condition) {
            fail$default($this, (String) message.invoke(), position, null, 4, null);
            throw new KotlinNothingValueException();
        }
    }

    public final void require$kotlinx_serialization_json(boolean condition, int position, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!condition) {
            fail$default(this, message.invoke(), position, null, 4, null);
            throw new KotlinNothingValueException();
        }
    }

    private final int fromHexChar(CharSequence source, int currentPosition) {
        char character = source.charAt(currentPosition);
        boolean z = true;
        if ('0' <= character && character < ':') {
            return character - '0';
        }
        if ('a' <= character && character < 'g') {
            return (character - 'a') + 10;
        }
        if ('A' > character || character >= 'G') {
            z = false;
        }
        if (z) {
            return (character - 'A') + 10;
        }
        fail$default(this, "Invalid toHexChar char '" + character + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final void skipElement(boolean allowLenientStrings) {
        List tokenStack = new ArrayList();
        byte lastToken = peekNextToken();
        if (lastToken != 8 && lastToken != 6) {
            consumeStringLenient();
            return;
        }
        while (true) {
            byte lastToken2 = peekNextToken();
            boolean z = true;
            if (lastToken2 == 1) {
                if (allowLenientStrings) {
                    consumeStringLenient();
                } else {
                    consumeKeyString();
                }
            } else {
                if (lastToken2 != 8 && lastToken2 != 6) {
                    z = false;
                }
                if (z) {
                    tokenStack.add(Byte.valueOf(lastToken2));
                } else if (lastToken2 == 9) {
                    if (((Number) CollectionsKt.last((List<? extends Object>) tokenStack)).byteValue() != 8) {
                        throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of } at path: " + this.path, getSource());
                    }
                    CollectionsKt.removeLast(tokenStack);
                } else if (lastToken2 == 7) {
                    if (((Number) CollectionsKt.last((List<? extends Object>) tokenStack)).byteValue() != 6) {
                        throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ] at path: " + this.path, getSource());
                    }
                    CollectionsKt.removeLast(tokenStack);
                } else if (lastToken2 == 10) {
                    fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                consumeNextToken();
                if (tokenStack.size() == 0) {
                    return;
                }
            }
        }
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) getSource()) + "', currentPosition=" + this.currentPosition + ')';
    }

    public final void failOnUnknownKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String processed = substring(0, this.currentPosition);
        int lastIndexOf = StringsKt.lastIndexOf$default((CharSequence) processed, key, 0, false, 6, (Object) null);
        fail("Encountered an unknown key '" + key + '\'', lastIndexOf, AbstractJsonLexerKt.ignoreUnknownKeysHint);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i, String str2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = abstractJsonLexer.currentPosition;
            }
            if ((i2 & 4) != 0) {
                str2 = "";
            }
            return abstractJsonLexer.fail(str, i, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final Void fail(String message, int position, String hint) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hint, "hint");
        String hintMessage = hint.length() == 0 ? "" : '\n' + hint;
        throw JsonExceptionsKt.JsonDecodingException(position, message + " at path: " + this.path.getPath() + hintMessage, getSource());
    }

    public final long consumeNumericLiteral() {
        boolean z;
        int current = prefetchOrEof(skipWhitespaces());
        if (current >= getSource().length() || current == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(current) == '\"') {
            current++;
            if (current == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            z = true;
        } else {
            z = false;
        }
        boolean hasQuotation = z;
        int start = current;
        int current2 = current;
        boolean hasChars = true;
        int current3 = 0;
        long accumulator = 0;
        while (hasChars) {
            char ch = getSource().charAt(current2);
            if (ch == '-') {
                if (current2 != start) {
                    fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                current3 = 1;
                current2++;
            } else {
                byte token = AbstractJsonLexerKt.charToTokenClass(ch);
                if (token != 0) {
                    break;
                }
                int current4 = current2 + 1;
                boolean hasChars2 = current4 != getSource().length();
                int digit = ch - '0';
                if (!(digit >= 0 && digit < 10)) {
                    fail$default(this, "Unexpected symbol '" + ch + "' in numeric literal", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                accumulator = (10 * accumulator) - digit;
                if (accumulator > 0) {
                    fail$default(this, "Numeric value overflow", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                current2 = current4;
                hasChars = hasChars2;
            }
        }
        if (start == current2 || (current3 != 0 && start == current2 - 1)) {
            fail$default(this, "Expected numeric literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (hasQuotation) {
            if (!hasChars) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            } else if (getSource().charAt(current2) != '\"') {
                fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            } else {
                current2++;
            }
        }
        this.currentPosition = current2;
        if (current3 != 0) {
            return accumulator;
        }
        if (accumulator != Long.MIN_VALUE) {
            return -accumulator;
        }
        fail$default(this, "Numeric value overflow", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final boolean consumeBoolean() {
        return consumeBoolean(skipWhitespaces());
    }

    public final boolean consumeBooleanLenient() {
        boolean hasQuotation;
        int current = skipWhitespaces();
        if (current == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(current) == '\"') {
            current++;
            hasQuotation = true;
        } else {
            hasQuotation = false;
        }
        boolean result = consumeBoolean(current);
        if (hasQuotation) {
            if (this.currentPosition == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            } else if (getSource().charAt(this.currentPosition) != '\"') {
                fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            } else {
                this.currentPosition++;
            }
        }
        return result;
    }

    private final boolean consumeBoolean(int start) {
        int current = prefetchOrEof(start);
        if (current >= getSource().length() || current == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int current2 = current + 1;
        switch (getSource().charAt(current) | 32) {
            case 102:
                consumeBooleanLiteral("alse", current2);
                return false;
            case 116:
                consumeBooleanLiteral("rue", current2);
                return true;
            default:
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
        }
    }

    private final void consumeBooleanLiteral(String literalSuffix, int current) {
        if (getSource().length() - current < literalSuffix.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = literalSuffix.length();
        for (int i = 0; i < length; i++) {
            char expected = literalSuffix.charAt(i);
            char actual = getSource().charAt(current + i);
            if (expected != (actual | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        int i2 = literalSuffix.length();
        this.currentPosition = i2 + current;
    }
}