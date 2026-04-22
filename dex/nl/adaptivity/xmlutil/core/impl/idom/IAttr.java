package nl.adaptivity.xmlutil.core.impl.idom;

import kotlin.Metadata;
import org.w3c.dom.Attr;

/* compiled from: IAttr.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/dom/Attr;", "Lnl/adaptivity/xmlutil/dom2/Attr;", "getOwnerElement", "Lnl/adaptivity/xmlutil/core/impl/idom/IElement;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAttr extends INode, Attr, nl.adaptivity.xmlutil.dom2.Attr {
    IElement getOwnerElement();
}