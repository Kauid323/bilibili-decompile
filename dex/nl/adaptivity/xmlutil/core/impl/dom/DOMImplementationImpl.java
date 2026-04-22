package nl.adaptivity.xmlutil.core.impl.dom;

import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IDOMImplementation;
import nl.adaptivity.xmlutil.core.impl.idom.IDocument;
import nl.adaptivity.xmlutil.core.impl.idom.IDocumentType;
import nl.adaptivity.xmlutil.dom2.DOMImplementation;
import nl.adaptivity.xmlutil.dom2.Document;
import nl.adaptivity.xmlutil.dom2.DocumentType;
import org.w3c.dom.DOMImplementation;

/* compiled from: DOMImplementationImpl.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J&\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/DOMImplementationImpl;", "Lnl/adaptivity/xmlutil/core/impl/idom/IDOMImplementation;", "<init>", "()V", "delegate", "Lorg/w3c/dom/DOMImplementation;", "getDelegate", "()Lorg/w3c/dom/DOMImplementation;", "supportsWhitespaceAtToplevel", "", "getSupportsWhitespaceAtToplevel", "()Z", "createDocumentType", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentType;", "qualifiedName", "", "publicId", "systemId", "createDocument", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocument;", "namespace", "documentType", "hasFeature", "feature", "version", "getFeature", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DOMImplementationImpl implements IDOMImplementation {
    public static final DOMImplementationImpl INSTANCE = new DOMImplementationImpl();
    private static final DOMImplementation delegate;

    @Override // nl.adaptivity.xmlutil.core.impl.idom.IDOMImplementation, nl.adaptivity.xmlutil.dom2.DOMImplementation
    public /* synthetic */ IDocument createDocument(String str, String str2, DocumentType documentType) {
        return IDOMImplementation.CC.$default$createDocument((IDOMImplementation) this, str, str2, documentType);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.IDOMImplementation, org.w3c.dom.DOMImplementation
    public /* synthetic */ IDocument createDocument(String str, String str2, org.w3c.dom.DocumentType documentType) {
        return IDOMImplementation.CC.$default$createDocument((IDOMImplementation) this, str, str2, documentType);
    }

    @Override // nl.adaptivity.xmlutil.dom2.DOMImplementation
    public /* bridge */ /* synthetic */ Document createDocument(String str, String str2, DocumentType documentType) {
        return IDOMImplementation.CC.m1622$default$createDocument((IDOMImplementation) this, str, str2, documentType);
    }

    @Override // org.w3c.dom.DOMImplementation
    public /* bridge */ /* synthetic */ org.w3c.dom.Document createDocument(String str, String str2, org.w3c.dom.DocumentType documentType) {
        return IDOMImplementation.CC.m1623$default$createDocument((IDOMImplementation) this, str, str2, documentType);
    }

    @Override // nl.adaptivity.xmlutil.dom2.DOMImplementation
    public /* synthetic */ boolean hasFeature(DOMImplementation.SupportedFeatures supportedFeatures, DOMImplementation.DOMVersion dOMVersion) {
        return DOMImplementation.CC.$default$hasFeature(this, supportedFeatures, dOMVersion);
    }

    private DOMImplementationImpl() {
    }

    public final org.w3c.dom.DOMImplementation getDelegate() {
        return delegate;
    }

    static {
        DocumentBuilderFactory $this$delegate_u24lambda_u240 = DocumentBuilderFactory.newInstance();
        $this$delegate_u24lambda_u240.setNamespaceAware(true);
        org.w3c.dom.DOMImplementation dOMImplementation = $this$delegate_u24lambda_u240.newDocumentBuilder().getDOMImplementation();
        Intrinsics.checkNotNullExpressionValue(dOMImplementation, "getDOMImplementation(...)");
        delegate = dOMImplementation;
    }

    @Override // nl.adaptivity.xmlutil.dom2.DOMImplementation
    public boolean getSupportsWhitespaceAtToplevel() {
        return true;
    }

    @Override // org.w3c.dom.DOMImplementation
    public IDocumentType createDocumentType(String qualifiedName, String publicId, String systemId) {
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        Intrinsics.checkNotNullParameter(publicId, "publicId");
        Intrinsics.checkNotNullParameter(systemId, "systemId");
        org.w3c.dom.DocumentType createDocumentType = delegate.createDocumentType(qualifiedName, publicId, systemId);
        Intrinsics.checkNotNullExpressionValue(createDocumentType, "createDocumentType(...)");
        return NodeImplKt.wrap(createDocumentType);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.IDOMImplementation
    public IDocument createDocument(String namespace, String qualifiedName, IDocumentType documentType) {
        org.w3c.dom.Document createDocument = delegate.createDocument(namespace, qualifiedName, documentType);
        Intrinsics.checkNotNullExpressionValue(createDocument, "createDocument(...)");
        return NodeImplKt.wrap(createDocument);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.idom.IDOMImplementation, org.w3c.dom.DOMImplementation, nl.adaptivity.xmlutil.dom2.DOMImplementation
    public boolean hasFeature(String feature, String version) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return delegate.hasFeature(feature, version);
    }

    @Override // org.w3c.dom.DOMImplementation
    public Object getFeature(String feature, String version) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Object feature2 = delegate.getFeature(feature, version);
        Intrinsics.checkNotNullExpressionValue(feature2, "getFeature(...)");
        return feature2;
    }
}