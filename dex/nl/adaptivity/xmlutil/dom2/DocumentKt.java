package nl.adaptivity.xmlutil.dom2;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Document.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0017\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\b*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u0014*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016¨\u0006\u001c"}, d2 = {"supportsWhitespaceAtToplevel", "", "Lnl/adaptivity/xmlutil/dom2/Document;", "getSupportsWhitespaceAtToplevel$annotations", "(Lnl/adaptivity/xmlutil/dom2/Document;)V", "getSupportsWhitespaceAtToplevel", "(Lnl/adaptivity/xmlutil/dom2/Document;)Z", "implementation", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "getImplementation", "(Lnl/adaptivity/xmlutil/dom2/Document;)Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "doctype", "Lnl/adaptivity/xmlutil/dom2/DocumentType;", "getDoctype", "(Lnl/adaptivity/xmlutil/dom2/Document;)Lnl/adaptivity/xmlutil/dom2/DocumentType;", "documentElement", "Lnl/adaptivity/xmlutil/dom2/Element;", "getDocumentElement", "(Lnl/adaptivity/xmlutil/dom2/Document;)Lnl/adaptivity/xmlutil/dom2/Element;", "inputEncoding", "", "getInputEncoding", "(Lnl/adaptivity/xmlutil/dom2/Document;)Ljava/lang/String;", "importNode", "Lnl/adaptivity/xmlutil/dom2/Node;", "node", "characterSet", "getCharacterSet", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DocumentKt {
    @Deprecated(message = "Use implementation", replaceWith = @ReplaceWith(expression = "implementation.supportsWhitespaceAtToplevel", imports = {}))
    public static /* synthetic */ void getSupportsWhitespaceAtToplevel$annotations(Document document) {
    }

    public static final boolean getSupportsWhitespaceAtToplevel(Document $this$supportsWhitespaceAtToplevel) {
        Intrinsics.checkNotNullParameter($this$supportsWhitespaceAtToplevel, "<this>");
        return $this$supportsWhitespaceAtToplevel.getImplementation().getSupportsWhitespaceAtToplevel();
    }

    public static final DOMImplementation getImplementation(Document $this$implementation) {
        Intrinsics.checkNotNullParameter($this$implementation, "<this>");
        return $this$implementation.getImplementation();
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

    public static final Node importNode(Document $this$importNode, Node node) {
        Intrinsics.checkNotNullParameter($this$importNode, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        return $this$importNode.importNode(node, false);
    }

    public static final String getCharacterSet(Document $this$characterSet) {
        Intrinsics.checkNotNullParameter($this$characterSet, "<this>");
        return $this$characterSet.getInputEncoding();
    }
}