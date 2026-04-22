package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;

/* compiled from: Attr.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/Attr;", "Lnl/adaptivity/xmlutil/dom2/Node;", "getNamespaceURI", "", "getPrefix", "getLocalName", "getName", "getValue", "setValue", "", "value", "getOwnerElement", "Lnl/adaptivity/xmlutil/dom2/Element;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Attr extends Node {
    String getLocalName();

    String getName();

    String getNamespaceURI();

    Element getOwnerElement();

    String getPrefix();

    String getValue();

    void setValue(String str);
}