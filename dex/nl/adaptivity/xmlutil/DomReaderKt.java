package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.dom2.Node;

/* compiled from: DomReader.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"toEventType", "Lnl/adaptivity/xmlutil/EventType;", "Lnl/adaptivity/xmlutil/dom2/Node;", "endOfElement", "", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DomReaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final EventType toEventType(Node $this$toEventType, boolean endOfElement) {
        short nodeType = $this$toEventType.getNodeType();
        if (nodeType == 2) {
            return EventType.ATTRIBUTE;
        }
        if (nodeType == 4) {
            return EventType.CDSECT;
        }
        if (nodeType == 8) {
            return EventType.COMMENT;
        }
        if (nodeType == 10) {
            return EventType.DOCDECL;
        }
        if (nodeType == 5) {
            return EventType.ENTITY_REF;
        }
        if (nodeType == 11 || nodeType == 9) {
            return endOfElement ? EventType.END_DOCUMENT : EventType.START_DOCUMENT;
        } else if (nodeType == 7) {
            return EventType.PROCESSING_INSTRUCTION;
        } else {
            if (nodeType != 3) {
                if (nodeType == 1) {
                    return endOfElement ? EventType.END_ELEMENT : EventType.START_ELEMENT;
                }
                throw new XmlException("Unsupported event type (" + $this$toEventType + ')', null, 2, null);
            }
            String textContent = $this$toEventType.getTextContent();
            Intrinsics.checkNotNull(textContent);
            return XmlUtil.isXmlWhitespace(textContent) ? EventType.IGNORABLE_WHITESPACE : EventType.TEXT;
        }
    }
}