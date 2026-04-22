package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.format.UnicodeFormat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Unicode.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/format/UnknownUnicodeDirective;", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "formatLetter", "", "formatLength", "", "(CI)V", "getFormatLength", "()I", "getFormatLetter", "()C", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnknownUnicodeDirective extends UnicodeFormat.Directive {
    private final int formatLength;
    private final char formatLetter;

    public UnknownUnicodeDirective(char formatLetter, int formatLength) {
        super(null);
        this.formatLetter = formatLetter;
        this.formatLength = formatLength;
    }

    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
    public int getFormatLength() {
        return this.formatLength;
    }

    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
    public char getFormatLetter() {
        return this.formatLetter;
    }
}