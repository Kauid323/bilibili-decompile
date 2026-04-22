package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonLexer.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\fH\u0002J\u0006\u0010#\u001a\u00020\u000eJ\u0018\u0010$\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "reader", "Lkotlinx/serialization/json/internal/SerialReader;", "buffer", "", "(Lkotlinx/serialization/json/internal/SerialReader;[C)V", "source", "Lkotlinx/serialization/json/internal/ArrayAsSequence;", "getSource", "()Lkotlinx/serialization/json/internal/ArrayAsSequence;", "threshold", "", "appendRange", "", "fromIndex", "toIndex", "canConsumeValue", "", "consumeKeyString", "", "consumeLeadingMatchingValue", "keyToMatch", "isLenient", "consumeNextToken", "", "ensureHaveChars", "indexOf", "char", "", "startPos", "prefetchOrEof", "position", "preload", "unprocessedCount", "release", "substring", "endPos", "tryConsumeComma", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReaderJsonLexer extends AbstractJsonLexer {
    private final char[] buffer;
    private final SerialReader reader;
    private final ArrayAsSequence source;
    private int threshold;

    public /* synthetic */ ReaderJsonLexer(SerialReader serialReader, char[] cArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serialReader, (i & 2) != 0 ? CharArrayPoolBatchSize.INSTANCE.take() : cArr);
    }

    public ReaderJsonLexer(SerialReader reader, char[] buffer) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.reader = reader;
        this.buffer = buffer;
        this.threshold = 128;
        this.source = new ArrayAsSequence(this.buffer);
        preload(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public ArrayAsSequence getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean tryConsumeComma() {
        int current = skipWhitespaces();
        if (current >= getSource().length() || current == -1 || getSource().charAt(current) != ',') {
            return false;
        }
        this.currentPosition++;
        int i = this.currentPosition;
        return true;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        ensureHaveChars();
        int current = this.currentPosition;
        while (true) {
            int current2 = prefetchOrEof(current);
            if (current2 != -1) {
                char c = getSource().charAt(current2);
                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                    current = current2 + 1;
                } else {
                    this.currentPosition = current2;
                    return isValidValueStart(c);
                }
            } else {
                this.currentPosition = current2;
                return false;
            }
        }
    }

    private final void preload(int unprocessedCount) {
        char[] buffer;
        buffer = getSource().buffer;
        if (unprocessedCount != 0) {
            ArraysKt.copyInto(buffer, buffer, 0, this.currentPosition, this.currentPosition + unprocessedCount);
        }
        int filledCount = unprocessedCount;
        int sizeTotal = getSource().length();
        while (true) {
            if (filledCount == sizeTotal) {
                break;
            }
            int actual = this.reader.read(buffer, filledCount, sizeTotal - filledCount);
            if (actual == -1) {
                getSource().trim(filledCount);
                this.threshold = -1;
                break;
            }
            filledCount += actual;
        }
        this.currentPosition = 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
            return position;
        }
        this.currentPosition = position;
        ensureHaveChars();
        if (this.currentPosition == 0) {
            return getSource().length() == 0 ? -1 : 0;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int cpos = this.currentPosition;
        while (true) {
            int cpos2 = prefetchOrEof(cpos);
            if (cpos2 != -1) {
                int cpos3 = cpos2 + 1;
                char ch = source.charAt(cpos2);
                byte tc = AbstractJsonLexerKt.charToTokenClass(ch);
                if (tc == 3) {
                    cpos = cpos3;
                } else {
                    this.currentPosition = cpos3;
                    return tc;
                }
            } else {
                this.currentPosition = cpos2;
                return (byte) 10;
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void ensureHaveChars() {
        int cur = this.currentPosition;
        int oldSize = getSource().length();
        int spaceLeft = oldSize - cur;
        if (spaceLeft > this.threshold) {
            return;
        }
        preload(spaceLeft);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeKeyString() {
        consumeNextToken('\"');
        int current = this.currentPosition;
        int closingQuote = indexOf('\"', current);
        if (closingQuote == -1) {
            int current2 = prefetchOrEof(current);
            if (current2 == -1) {
                fail$kotlinx_serialization_json((byte) 1);
                throw new KotlinNothingValueException();
            }
            return consumeString(getSource(), this.currentPosition, current2);
        }
        for (int i = current; i < closingQuote; i++) {
            if (getSource().charAt(i) == '\\') {
                return consumeString(getSource(), this.currentPosition, i);
            }
        }
        int i2 = closingQuote + 1;
        this.currentPosition = i2;
        return substring(current, closingQuote);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int indexOf(char c, int startPos) {
        ArrayAsSequence src = getSource();
        int length = src.length();
        for (int i = startPos; i < length; i++) {
            if (src.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String substring(int startPos, int endPos) {
        return getSource().substring(startPos, endPos);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    protected void appendRange(int fromIndex, int toIndex) {
        char[] cArr;
        StringBuilder escapedString = getEscapedString();
        cArr = getSource().buffer;
        Intrinsics.checkNotNullExpressionValue(escapedString.append(cArr, fromIndex, toIndex - fromIndex), "this.append(value, start…x, endIndex - startIndex)");
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeLeadingMatchingValue(String keyToMatch, boolean isLenient) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        return null;
    }

    public final void release() {
        CharArrayPoolBatchSize.INSTANCE.release(this.buffer);
    }
}