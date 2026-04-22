package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: JsonToStringWriter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToStringWriter;", "Lkotlinx/serialization/json/internal/JsonWriter;", "()V", "array", "", "size", "", "appendStringSlowPath", "", "firstEscapedChar", "currentSize", "string", "", "ensureAdditionalCapacity", "expected", "ensureTotalCapacity", "oldSize", "additional", "release", "toString", "write", "text", "writeChar", "char", "", "writeLong", "value", "", "writeQuoted", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsonToStringWriter implements JsonWriter {
    private char[] array = CharArrayPool.INSTANCE.take();
    private int size;

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void writeChar(char c) {
        ensureAdditionalCapacity(1);
        char[] cArr = this.array;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c;
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        ensureAdditionalCapacity(length);
        text.getChars(0, text.length(), this.array, this.size);
        this.size += length;
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void writeQuoted(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ensureAdditionalCapacity(text.length() + 2);
        char[] arr = this.array;
        int sz = this.size;
        int sz2 = sz + 1;
        arr[sz] = '\"';
        int length = text.length();
        text.getChars(0, length, arr, sz2);
        int i = sz2 + length;
        for (int i2 = sz2; i2 < i; i2++) {
            char c = arr[i2];
            if (c < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c] != 0) {
                appendStringSlowPath(i2 - sz2, i2, text);
                return;
            }
        }
        int sz3 = sz2 + length;
        arr[sz3] = '\"';
        this.size = sz3 + 1;
    }

    private final void appendStringSlowPath(int firstEscapedChar, int currentSize, String string) {
        int sz = currentSize;
        int length = string.length();
        for (int i = firstEscapedChar; i < length; i++) {
            int sz2 = ensureTotalCapacity(sz, 2);
            int ch = string.charAt(i);
            if (ch < StringOpsKt.getESCAPE_MARKERS().length) {
                byte marker = StringOpsKt.getESCAPE_MARKERS()[ch];
                if (marker == 0) {
                    this.array[sz2] = (char) ch;
                    sz = sz2 + 1;
                } else if (marker == 1) {
                    String escapedString = StringOpsKt.getESCAPE_STRINGS()[ch];
                    Intrinsics.checkNotNull(escapedString);
                    int sz3 = ensureTotalCapacity(sz2, escapedString.length());
                    escapedString.getChars(0, escapedString.length(), this.array, sz3);
                    sz = sz3 + escapedString.length();
                    this.size = sz;
                } else {
                    this.array[sz2] = '\\';
                    this.array[sz2 + 1] = (char) marker;
                    sz = sz2 + 2;
                    this.size = sz;
                }
            } else {
                this.array[sz2] = (char) ch;
                sz = sz2 + 1;
            }
        }
        int sz4 = ensureTotalCapacity(sz, 1);
        this.array[sz4] = '\"';
        this.size = sz4 + 1;
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void release() {
        CharArrayPool.INSTANCE.release(this.array);
    }

    public String toString() {
        return new String(this.array, 0, this.size);
    }

    private final void ensureAdditionalCapacity(int expected) {
        ensureTotalCapacity(this.size, expected);
    }

    private final int ensureTotalCapacity(int oldSize, int additional) {
        int newSize = oldSize + additional;
        if (this.array.length <= newSize) {
            char[] copyOf = Arrays.copyOf(this.array, RangesKt.coerceAtLeast(newSize, oldSize * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.array = copyOf;
        }
        return oldSize;
    }
}