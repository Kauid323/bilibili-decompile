package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.XmlWriterUtil;

/* compiled from: ElementSerializer.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0002\u001a\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0015H\u0002\u001a\u0014\u0010\u0016\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\u0018"}, d2 = {"wrap", "Lnl/adaptivity/xmlutil/dom2/WrappedDeserializationStrategy2;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "document", "Lnl/adaptivity/xmlutil/dom2/Document;", "writeElem", "", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "value", "Lnl/adaptivity/xmlutil/dom2/Element;", "writeAttr", "Lnl/adaptivity/xmlutil/dom2/Attr;", "writeCData", "Lnl/adaptivity/xmlutil/dom2/CDATASection;", "writeText", "Lnl/adaptivity/xmlutil/dom2/Text;", "writeComment", "Lnl/adaptivity/xmlutil/dom2/Comment;", "writePI", "Lnl/adaptivity/xmlutil/dom2/ProcessingInstruction;", "writeTo", "Lnl/adaptivity/xmlutil/dom2/Node;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ElementSerializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> WrappedDeserializationStrategy2<T> wrap(DeserializationStrategy<? extends T> deserializationStrategy, Document document) {
        return new WrappedDeserializationStrategy2<>(deserializationStrategy, document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeElem(XmlWriter output, Element value) {
        String nsUri$iv = value.getNamespaceURI();
        String localName$iv = value.getLocalName();
        String prefix$iv = value.getPrefix();
        String usedPrefix$iv = XmlWriterUtil.smartStartTag(output, nsUri$iv, localName$iv, prefix$iv);
        for (Attr n : value.getAttributes()) {
            writeAttr(output, n);
        }
        Element $this$childNodes$iv = value;
        for (Node child : $this$childNodes$iv.getChildNodes()) {
            writeTo(child, output);
        }
        output.endTag(nsUri$iv, localName$iv, usedPrefix$iv);
    }

    private static final void writeAttr(XmlWriter output, Attr value) {
        String namespaceURI = value.getNamespaceURI();
        String localName = value.getLocalName();
        if (localName == null) {
            localName = value.getName();
        }
        output.attribute(namespaceURI, localName, value.getPrefix(), value.getValue());
    }

    private static final void writeCData(XmlWriter output, CDATASection value) {
        CDATASection $this$textContent$iv = value;
        String textContent = $this$textContent$iv.getTextContent();
        Intrinsics.checkNotNull(textContent);
        output.cdsect(textContent);
    }

    private static final void writeText(XmlWriter output, Text value) {
        Text $this$textContent$iv = value;
        String textContent = $this$textContent$iv.getTextContent();
        Intrinsics.checkNotNull(textContent);
        output.text(textContent);
    }

    private static final void writeComment(XmlWriter output, Comment value) {
        Comment $this$textContent$iv = value;
        String textContent = $this$textContent$iv.getTextContent();
        Intrinsics.checkNotNull(textContent);
        output.comment(textContent);
    }

    private static final void writePI(XmlWriter output, ProcessingInstruction value) {
        StringBuilder append = new StringBuilder().append(value.getTarget()).append(' ');
        ProcessingInstruction $this$textContent$iv = value;
        String textContent = $this$textContent$iv.getTextContent();
        if (textContent == null) {
            textContent = "";
        }
        output.processingInstruction(append.append(textContent).toString());
    }

    public static final void writeTo(Node $this$writeTo, XmlWriter output) {
        Intrinsics.checkNotNullParameter($this$writeTo, "<this>");
        Intrinsics.checkNotNullParameter(output, "output");
        short nodeType = $this$writeTo.getNodeType();
        if (nodeType != 1) {
            if (nodeType != 2) {
                if (nodeType != 4) {
                    if (nodeType != 3) {
                        if (nodeType != 8) {
                            if (nodeType != 7) {
                                throw new IllegalArgumentException("Can not serialize node: " + $this$writeTo);
                            }
                            writePI(output, (ProcessingInstruction) $this$writeTo);
                            return;
                        }
                        writeComment(output, (Comment) $this$writeTo);
                        return;
                    }
                    writeText(output, (Text) $this$writeTo);
                    return;
                }
                writeCData(output, (CDATASection) $this$writeTo);
                return;
            }
            writeAttr(output, (Attr) $this$writeTo);
            return;
        }
        writeElem(output, (Element) $this$writeTo);
    }
}