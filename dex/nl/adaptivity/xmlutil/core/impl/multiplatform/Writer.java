package nl.adaptivity.xmlutil.core.impl.multiplatform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\n\u001a\u00020\u000bH&J&\u0010\t\u001a\u00060\u0001j\u0002`\u00022\b\u0010\n\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0016\u0010\t\u001a\u00060\u0001j\u0002`\u00022\b\u0010\n\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "<init>", "()V", "write", "", "text", "", "append", "value", "", "", "startIndex", "", "endIndex", "flush", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Writer implements Appendable {
    @Override // java.lang.Appendable
    public abstract Appendable append(char c);

    @Override // java.lang.Appendable
    public abstract Appendable append(CharSequence charSequence, int i, int i2);

    public void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        append(text);
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence value) {
        return append(value, 0, value != null ? value.length() : 0);
    }

    public void flush() {
    }
}