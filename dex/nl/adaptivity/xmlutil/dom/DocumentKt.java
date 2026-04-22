package nl.adaptivity.xmlutil.dom;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* compiled from: Document.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0006\u001a\u00060\u0007j\u0002`\b*\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0002\u0010\n\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"'\u0010\u000b\u001a\u00060\fj\u0002`\r*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"+\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017\"+\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u001d\"%\u0010\u001e\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0005¨\u0006!"}, d2 = {"characterSet", "", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/dom/Document;", "getCharacterSet", "(Lorg/w3c/dom/Document;)Ljava/lang/String;", "importNode", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "node", "(Lorg/w3c/dom/Document;Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;", "implementation", "Lorg/w3c/dom/DOMImplementation;", "Lnl/adaptivity/xmlutil/dom/DOMImplementation;", "getImplementation$annotations", "(Lorg/w3c/dom/Document;)V", "getImplementation", "(Lorg/w3c/dom/Document;)Lorg/w3c/dom/DOMImplementation;", "doctype", "Lorg/w3c/dom/DocumentType;", "Lnl/adaptivity/xmlutil/dom/DocumentType;", "getDoctype$annotations", "getDoctype", "(Lorg/w3c/dom/Document;)Lorg/w3c/dom/DocumentType;", "documentElement", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "getDocumentElement$annotations", "getDocumentElement", "(Lorg/w3c/dom/Document;)Lorg/w3c/dom/Element;", "inputEncoding", "getInputEncoding$annotations", "getInputEncoding", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DocumentKt {
    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getDoctype()", imports = {}))
    public static /* synthetic */ void getDoctype$annotations(Document document) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getDocumentElement()", imports = {}))
    public static /* synthetic */ void getDocumentElement$annotations(Document document) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getImplementation()", imports = {}))
    public static /* synthetic */ void getImplementation$annotations(Document document) {
    }

    @Deprecated(message = "Use accessor methods for dom2 compatibility", replaceWith = @ReplaceWith(expression = "getInputEncoding()", imports = {}))
    public static /* synthetic */ void getInputEncoding$annotations(Document document) {
    }

    public static final String getCharacterSet(Document $this$characterSet) {
        Intrinsics.checkNotNullParameter($this$characterSet, "<this>");
        return $this$characterSet.getInputEncoding();
    }

    public static final Node importNode(Document $this$importNode, Node node) {
        Intrinsics.checkNotNullParameter($this$importNode, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        return $this$importNode.importNode(node, false);
    }

    public static final DOMImplementation getImplementation(Document $this$implementation) {
        Intrinsics.checkNotNullParameter($this$implementation, "<this>");
        DOMImplementation implementation = $this$implementation.getImplementation();
        Intrinsics.checkNotNullExpressionValue(implementation, "getImplementation(...)");
        return implementation;
    }

    public static final DocumentType getDoctype(Document $this$doctype) {
        Intrinsics.checkNotNullParameter($this$doctype, "<this>");
        return $this$doctype.getDoctype();
    }

    public static final Element getDocumentElement(Document $this$documentElement) {
        Intrinsics.checkNotNullParameter($this$documentElement, "<this>");
        return $this$documentElement.getDocumentElement();
    }

    public static final String getInputEncoding(Document $this$inputEncoding) {
        Intrinsics.checkNotNullParameter($this$inputEncoding, "<this>");
        return $this$inputEncoding.getInputEncoding();
    }
}