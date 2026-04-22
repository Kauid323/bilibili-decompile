package nl.adaptivity.xmlutil.core.impl.idom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.dom2.Node;
import org.w3c.dom.Document;

/* compiled from: IDocument.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0014\u0010\u001b\u001a\u00020\u00012\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH&J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001fH&J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u001a\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020\u0006H&J\u0018\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H&J\u0014\u0010'\u001a\u00020\u00012\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0016J\u001c\u0010'\u001a\u00020\u00012\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010(\u001a\u00020)H&J\u0018\u0010'\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H&J\u001a\u0010'\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020)H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/idom/IDocument;", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/dom/Document;", "Lnl/adaptivity/xmlutil/dom2/Document;", "getInputEncoding", "", "getImplementation", "Lnl/adaptivity/xmlutil/core/impl/idom/IDOMImplementation;", "getDoctype", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentType;", "getDocumentElement", "Lnl/adaptivity/xmlutil/core/impl/idom/IElement;", "createElement", "localName", "createDocumentFragment", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentFragment;", "createTextNode", "Lnl/adaptivity/xmlutil/core/impl/idom/IText;", "data", "createCDATASection", "Lnl/adaptivity/xmlutil/core/impl/idom/ICDATASection;", "createComment", "Lnl/adaptivity/xmlutil/core/impl/idom/IComment;", "createProcessingInstruction", "Lnl/adaptivity/xmlutil/core/impl/idom/IProcessingInstruction;", "target", "adoptNode", "node", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "Lnl/adaptivity/xmlutil/dom2/Node;", "createAttribute", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "createAttributeNS", "namespace", "qualifiedName", "createElementNS", "namespaceURI", "importNode", "deep", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocument extends INode, Document, nl.adaptivity.xmlutil.dom2.Document {
    INode adoptNode(INode iNode);

    INode adoptNode(Node node);

    INode adoptNode(org.w3c.dom.Node node);

    IAttr createAttribute(String str);

    IAttr createAttributeNS(String str, String str2);

    ICDATASection createCDATASection(String str);

    IComment createComment(String str);

    IDocumentFragment createDocumentFragment();

    IElement createElement(String str);

    IElement createElementNS(String str, String str2);

    IProcessingInstruction createProcessingInstruction(String str, String str2);

    IText createTextNode(String str);

    IDocumentType getDoctype();

    IElement getDocumentElement();

    IDOMImplementation getImplementation();

    String getInputEncoding();

    INode importNode(INode iNode, boolean z);

    INode importNode(Node node, boolean z);

    INode importNode(org.w3c.dom.Node node);

    INode importNode(org.w3c.dom.Node node, boolean z);

    /* compiled from: IDocument.kt */
    /* renamed from: nl.adaptivity.xmlutil.core.impl.idom.IDocument$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static INode $default$adoptNode(IDocument _this, INode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return _this.adoptNode((Node) node);
        }

        public static INode $default$importNode(IDocument _this, org.w3c.dom.Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return _this.importNode(node, false);
        }

        public static INode $default$importNode(IDocument _this, INode node, boolean deep) {
            Intrinsics.checkNotNullParameter(node, "node");
            return _this.importNode((Node) node, deep);
        }

        public static /* synthetic */ INode importNode$default(IDocument iDocument, INode iNode, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return iDocument.importNode(iNode, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: importNode");
        }
    }
}