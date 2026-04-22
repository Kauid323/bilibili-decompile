package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StringJsonLexer.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J3\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "canConsumeValue", "", "consumeKeyString", "consumeLeadingMatchingValue", "keyToMatch", "isLenient", "consumeNextToken", "", "", "expected", "", "consumeStringChunked", "consumeChunk", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "stringChunk", "prefetchOrEof", "", "position", "skipWhitespaces", "tryConsumeComma", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StringJsonLexer extends AbstractJsonLexer {
    private final String source;

    public StringJsonLexer(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
            return position;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        String source = getSource();
        while (this.currentPosition != -1 && this.currentPosition < source.length()) {
            int i = this.currentPosition;
            this.currentPosition = i + 1;
            char ch = source.charAt(i);
            byte tc = AbstractJsonLexerKt.charToTokenClass(ch);
            if (tc != 3) {
                return tc;
            }
        }
        return (byte) 10;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean tryConsumeComma() {
        int current = skipWhitespaces();
        if (current == getSource().length() || current == -1 || getSource().charAt(current) != ',') {
            return false;
        }
        this.currentPosition++;
        int i = this.currentPosition;
        return true;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        int current = this.currentPosition;
        if (current == -1) {
            return false;
        }
        while (current < getSource().length()) {
            char c = getSource().charAt(current);
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                current++;
            } else {
                this.currentPosition = current;
                return isValidValueStart(c);
            }
        }
        this.currentPosition = current;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        char c;
        int current = this.currentPosition;
        if (current == -1) {
            return current;
        }
        while (current < getSource().length() && ((c = getSource().charAt(current)) == ' ' || c == '\n' || c == '\r' || c == '\t')) {
            current++;
        }
        this.currentPosition = current;
        return current;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char expected) {
        if (this.currentPosition == -1) {
            unexpectedToken(expected);
        }
        String source = getSource();
        while (this.currentPosition < source.length()) {
            int i = this.currentPosition;
            this.currentPosition = i + 1;
            char c = source.charAt(i);
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t') {
                if (c == expected) {
                    return;
                }
                unexpectedToken(expected);
            }
        }
        unexpectedToken(expected);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeKeyString() {
        consumeNextToken('\"');
        int current = this.currentPosition;
        int closingQuote = StringsKt.indexOf$default((CharSequence) getSource(), '\"', current, false, 4, (Object) null);
        if (closingQuote == -1) {
            fail$kotlinx_serialization_json((byte) 1);
            throw new KotlinNothingValueException();
        }
        for (int i = current; i < closingQuote; i++) {
            if (getSource().charAt(i) == '\\') {
                return consumeString(getSource(), this.currentPosition, i);
            }
        }
        int i2 = closingQuote + 1;
        this.currentPosition = i2;
        String substring = getSource().substring(current, closingQuote);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeStringChunked(boolean isLenient, Function1<? super String, Unit> consumeChunk) {
        Intrinsics.checkNotNullParameter(consumeChunk, "consumeChunk");
        Iterable $this$forEach$iv = StringsKt.chunked(isLenient ? consumeStringLenient() : consumeString(), 16384);
        for (Object element$iv : $this$forEach$iv) {
            consumeChunk.invoke(element$iv);
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeLeadingMatchingValue(String keyToMatch, boolean isLenient) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        int positionSnapshot = this.currentPosition;
        try {
            if (consumeNextToken() != 6) {
                return null;
            }
            String firstKey = isLenient ? consumeKeyString() : consumeStringLenientNotNull();
            if (Intrinsics.areEqual(firstKey, keyToMatch)) {
                if (consumeNextToken() != 5) {
                    return null;
                }
                String result = isLenient ? consumeString() : consumeStringLenientNotNull();
                this.currentPosition = positionSnapshot;
                return result;
            }
            return null;
        } finally {
            this.currentPosition = positionSnapshot;
        }
    }
}