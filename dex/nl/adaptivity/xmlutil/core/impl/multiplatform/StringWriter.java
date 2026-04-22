package nl.adaptivity.xmlutil.core.impl.multiplatform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/multiplatform/StringWriter;", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;", "<init>", "()V", "delegate", "Ljava/io/StringWriter;", "append", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "startIndex", "", "endIndex", "toString", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class StringWriter extends Writer {
    private final java.io.StringWriter delegate = new java.io.StringWriter();

    @Override // nl.adaptivity.xmlutil.core.impl.multiplatform.Writer, java.lang.Appendable
    public Appendable append(char value) {
        this.delegate.append(value);
        return this;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.multiplatform.Writer, java.lang.Appendable
    public Appendable append(CharSequence value, int startIndex, int endIndex) {
        this.delegate.append(value, startIndex, endIndex);
        return this;
    }

    public String toString() {
        String stringWriter = this.delegate.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter, "toString(...)");
        return stringWriter;
    }
}