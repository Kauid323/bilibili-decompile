package nl.adaptivity.xmlutil.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.dom.NodeImplKt;
import nl.adaptivity.xmlutil.dom2.Node;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* compiled from: Document.jvm.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0001j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\b\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0001j\u0002`\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00060\fj\u0002`\r*\u00060\u0001j\u0002`\u0005\u001a\u001a\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010*\u00060\u0001j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u0007\u001a\u001a\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014*\u00060\u0001j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u0007\u001a\u001a\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017*\u00060\u0001j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u0007\u001a\"\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a*\u00060\u0001j\u0002`\u00052\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\n\u0010\u001f\u001a\u00060 j\u0002`!*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\""}, d2 = {"Document", "Lorg/w3c/dom/Document;", "createElement", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Element;", "Lnl/adaptivity/xmlutil/dom/Document;", "localName", "", "createElementNS", "namespaceURI", "qualifiedName", "createDocumentFragment", "Lorg/w3c/dom/DocumentFragment;", "Lnl/adaptivity/xmlutil/dom/DocumentFragment;", "createTextNode", "Lorg/w3c/dom/Text;", "Lnl/adaptivity/xmlutil/dom/Text;", "data", "createCDATASection", "Lorg/w3c/dom/CDATASection;", "Lnl/adaptivity/xmlutil/dom/CDATASection;", "createComment", "Lorg/w3c/dom/Comment;", "Lnl/adaptivity/xmlutil/dom/Comment;", "createProcessingInstruction", "Lorg/w3c/dom/ProcessingInstruction;", "Lnl/adaptivity/xmlutil/dom/ProcessingInstruction;", "target", "adoptNode", "Lnl/adaptivity/xmlutil/dom2/Node;", "Lnl/adaptivity/xmlutil/dom2/Document;", "node", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Document_jvmKt {
    public static /* synthetic */ void Document$annotations() {
    }

    public static final Element createElement(Document $this$createElement, String localName) {
        Intrinsics.checkNotNullParameter($this$createElement, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Element createElement = $this$createElement.createElement(localName);
        Intrinsics.checkNotNullExpressionValue(createElement, "createElement(...)");
        return createElement;
    }

    public static final Element createElementNS(Document $this$createElementNS, String namespaceURI, String qualifiedName) {
        Intrinsics.checkNotNullParameter($this$createElementNS, "<this>");
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        Element createElementNS = $this$createElementNS.createElementNS(namespaceURI, qualifiedName);
        Intrinsics.checkNotNullExpressionValue(createElementNS, "createElementNS(...)");
        return createElementNS;
    }

    public static final DocumentFragment createDocumentFragment(Document $this$createDocumentFragment) {
        Intrinsics.checkNotNullParameter($this$createDocumentFragment, "<this>");
        DocumentFragment createDocumentFragment = $this$createDocumentFragment.createDocumentFragment();
        Intrinsics.checkNotNullExpressionValue(createDocumentFragment, "createDocumentFragment(...)");
        return createDocumentFragment;
    }

    public static final Text createTextNode(Document $this$createTextNode, String data) {
        Intrinsics.checkNotNullParameter($this$createTextNode, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Text createTextNode = $this$createTextNode.createTextNode(data);
        Intrinsics.checkNotNullExpressionValue(createTextNode, "createTextNode(...)");
        return createTextNode;
    }

    public static final CDATASection createCDATASection(Document $this$createCDATASection, String data) {
        Intrinsics.checkNotNullParameter($this$createCDATASection, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        CDATASection createCDATASection = $this$createCDATASection.createCDATASection(data);
        Intrinsics.checkNotNullExpressionValue(createCDATASection, "createCDATASection(...)");
        return createCDATASection;
    }

    public static final Comment createComment(Document $this$createComment, String data) {
        Intrinsics.checkNotNullParameter($this$createComment, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Comment createComment = $this$createComment.createComment(data);
        Intrinsics.checkNotNullExpressionValue(createComment, "createComment(...)");
        return createComment;
    }

    public static final ProcessingInstruction createProcessingInstruction(Document $this$createProcessingInstruction, String target, String data) {
        Intrinsics.checkNotNullParameter($this$createProcessingInstruction, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(data, "data");
        ProcessingInstruction createProcessingInstruction = $this$createProcessingInstruction.createProcessingInstruction(target, data);
        Intrinsics.checkNotNullExpressionValue(createProcessingInstruction, "createProcessingInstruction(...)");
        return createProcessingInstruction;
    }

    public static final Node adoptNode(nl.adaptivity.xmlutil.dom2.Document $this$adoptNode, org.w3c.dom.Node node) {
        Intrinsics.checkNotNullParameter($this$adoptNode, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        return NodeImplKt.wrap(node);
    }
}