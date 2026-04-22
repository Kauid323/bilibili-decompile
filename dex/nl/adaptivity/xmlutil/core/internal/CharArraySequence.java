package nl.adaptivity.xmlutil.core.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharArraySequence.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0002J\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lnl/adaptivity/xmlutil/core/internal/CharArraySequence;", "", "data", "", "offset", "", "length", "<init>", "([CII)V", "getLength", "()I", "get", "", "index", "subSequence", "startIndex", "endIndex", "toString", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CharArraySequence implements CharSequence {
    private final char[] data;
    private final int length;
    private final int offset;

    public CharArraySequence(char[] data, int offset, int length) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.offset = offset;
        this.length = length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CharArraySequence(char[] cArr, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cArr, i, (i3 & 4) != 0 ? cArr.length - i : i2);
        i = (i3 & 2) != 0 ? 0 : i;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int index) {
        return get(index);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public int getLength() {
        return this.length;
    }

    public char get(int index) {
        if (index < 0 || index >= this.offset + length()) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        return this.data[this.offset + index];
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        if (startIndex < 0 || startIndex > length()) {
            throw new IndexOutOfBoundsException("startIndex: " + startIndex);
        }
        if (endIndex < startIndex || endIndex > length()) {
            throw new IndexOutOfBoundsException("endIndex: " + endIndex);
        }
        return new CharArraySequence(this.data, this.offset + startIndex, endIndex - startIndex);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String sb = new StringBuilder(this).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}