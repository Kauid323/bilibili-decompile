package nl.adaptivity.xmlutil.core.impl.idom;

import kotlin.Metadata;
import org.w3c.dom.DocumentType;

/* compiled from: IDocumentType.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentType;", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "Lorg/w3c/dom/DocumentType;", "Lnl/adaptivity/xmlutil/dom/DocumentType;", "Lnl/adaptivity/xmlutil/dom2/DocumentType;", "getEntities", "Lnl/adaptivity/xmlutil/core/impl/idom/INamedNodeMap;", "getNotations", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocumentType extends INode, DocumentType, nl.adaptivity.xmlutil.dom2.DocumentType {
    INamedNodeMap getEntities();

    INamedNodeMap getNotations();
}