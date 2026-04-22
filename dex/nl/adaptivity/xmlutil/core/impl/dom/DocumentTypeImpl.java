package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IDocumentType;
import nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;

/* compiled from: DocumentTypeImpl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/DocumentTypeImpl;", "Lnl/adaptivity/xmlutil/core/impl/dom/NodeImpl;", "Lorg/w3c/dom/DocumentType;", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentType;", "delegate", "<init>", "(Lorg/w3c/dom/DocumentType;)V", "getName", "", "getEntities", "Lnl/adaptivity/xmlutil/core/impl/idom/INamedNodeMap;", "getNotations", "getPublicId", "getSystemId", "getInternalSubset", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentTypeImpl extends NodeImpl<DocumentType> implements IDocumentType {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentTypeImpl(DocumentType delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // org.w3c.dom.DocumentType, nl.adaptivity.xmlutil.dom2.DocumentType
    public String getName() {
        String name = getDelegate().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // org.w3c.dom.DocumentType
    public INamedNodeMap getEntities() {
        NamedNodeMap entities = getDelegate().getEntities();
        Intrinsics.checkNotNullExpressionValue(entities, "getEntities(...)");
        return new WrappingNamedNodeMap(entities);
    }

    @Override // org.w3c.dom.DocumentType
    public INamedNodeMap getNotations() {
        NamedNodeMap notations = getDelegate().getNotations();
        Intrinsics.checkNotNullExpressionValue(notations, "getNotations(...)");
        return new WrappingNamedNodeMap(notations);
    }

    @Override // org.w3c.dom.DocumentType, nl.adaptivity.xmlutil.dom2.DocumentType
    public String getPublicId() {
        String publicId = getDelegate().getPublicId();
        Intrinsics.checkNotNullExpressionValue(publicId, "getPublicId(...)");
        return publicId;
    }

    @Override // org.w3c.dom.DocumentType, nl.adaptivity.xmlutil.dom2.DocumentType
    public String getSystemId() {
        String systemId = getDelegate().getSystemId();
        Intrinsics.checkNotNullExpressionValue(systemId, "getSystemId(...)");
        return systemId;
    }

    @Override // org.w3c.dom.DocumentType
    public String getInternalSubset() {
        String internalSubset = getDelegate().getInternalSubset();
        Intrinsics.checkNotNullExpressionValue(internalSubset, "getInternalSubset(...)");
        return internalSubset;
    }
}