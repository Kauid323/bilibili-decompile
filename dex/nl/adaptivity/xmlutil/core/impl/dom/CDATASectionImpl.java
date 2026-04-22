package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.ICDATASection;
import org.w3c.dom.CDATASection;

/* compiled from: CDATASectionImpl.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/CDATASectionImpl;", "Lnl/adaptivity/xmlutil/core/impl/dom/TextImpl;", "Lnl/adaptivity/xmlutil/core/impl/idom/ICDATASection;", "delegate", "Lorg/w3c/dom/CDATASection;", "<init>", "(Lorg/w3c/dom/CDATASection;)V", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CDATASectionImpl extends TextImpl implements ICDATASection {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CDATASectionImpl(CDATASection delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }
}