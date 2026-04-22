package nl.adaptivity.xmlutil.util;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlReader;

/* compiled from: XmlDelegatingReader.kt */
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This has moved to the main package", replaceWith = @ReplaceWith(expression = "XmlDelegatingReader", imports = {"nl.adaptivity.xmlutil"}))
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnl/adaptivity/xmlutil/util/XmlDelegatingReader;", "Lnl/adaptivity/xmlutil/XmlDelegatingReader;", "delegate", "Lnl/adaptivity/xmlutil/XmlReader;", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader;)V", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class XmlDelegatingReader extends nl.adaptivity.xmlutil.XmlDelegatingReader {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected XmlDelegatingReader(XmlReader delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }
}