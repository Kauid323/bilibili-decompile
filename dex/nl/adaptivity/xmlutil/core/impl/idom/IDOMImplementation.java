package nl.adaptivity.xmlutil.core.impl.idom;

import kotlin.Metadata;
import nl.adaptivity.xmlutil.dom2.DocumentType;
import org.w3c.dom.DOMImplementation;

/* compiled from: IDOMImplementation.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J,\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0016J&\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/idom/IDOMImplementation;", "Lorg/w3c/dom/DOMImplementation;", "Lnl/adaptivity/xmlutil/dom/DOMImplementation;", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "createDocumentType", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentType;", "qualifiedName", "", "publicId", "systemId", "createDocument", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocument;", "namespace", "documentType", "Lorg/w3c/dom/DocumentType;", "Lnl/adaptivity/xmlutil/dom/DocumentType;", "Lnl/adaptivity/xmlutil/dom2/DocumentType;", "hasFeature", "", "feature", "version", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDOMImplementation extends DOMImplementation, nl.adaptivity.xmlutil.dom2.DOMImplementation {
    IDocument createDocument(String str, String str2, IDocumentType iDocumentType);

    IDocument createDocument(String str, String str2, DocumentType documentType);

    @Override // org.w3c.dom.DOMImplementation
    IDocument createDocument(String str, String str2, org.w3c.dom.DocumentType documentType);

    @Override // org.w3c.dom.DOMImplementation, nl.adaptivity.xmlutil.dom2.DOMImplementation
    IDocumentType createDocumentType(String str, String str2, String str3);

    @Override // org.w3c.dom.DOMImplementation, nl.adaptivity.xmlutil.dom2.DOMImplementation
    boolean hasFeature(String str, String str2);

    /* compiled from: IDOMImplementation.kt */
    /* renamed from: nl.adaptivity.xmlutil.core.impl.idom.IDOMImplementation$-CC */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
    }
}