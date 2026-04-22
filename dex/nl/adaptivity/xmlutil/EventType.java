package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlEvent;

/* compiled from: EventType.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH&R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u001e"}, d2 = {"Lnl/adaptivity/xmlutil/EventType;", "", "<init>", "(Ljava/lang/String;I)V", "START_DOCUMENT", "START_ELEMENT", "END_ELEMENT", "COMMENT", "TEXT", "CDSECT", "DOCDECL", "END_DOCUMENT", "ENTITY_REF", "IGNORABLE_WHITESPACE", "ATTRIBUTE", "PROCESSING_INSTRUCTION", "isIgnorable", "", "()Z", "isTextElement", "writeEvent", "", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "textEvent", "Lnl/adaptivity/xmlutil/XmlEvent$TextEvent;", "reader", "Lnl/adaptivity/xmlutil/XmlReader;", "createEvent", "Lnl/adaptivity/xmlutil/XmlEvent;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum EventType {
    START_DOCUMENT { // from class: nl.adaptivity.xmlutil.EventType.START_DOCUMENT
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isIgnorable() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.StartDocumentEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.StartDocumentEvent(reader.getExtLocationInfo(), reader.getVersion(), reader.getEncoding(), reader.getStandalone());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.startDocument(reader.getVersion(), reader.getEncoding(), reader.getStandalone());
        }
    },
    START_ELEMENT { // from class: nl.adaptivity.xmlutil.EventType.START_ELEMENT
        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.StartElementEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.StartElementEvent(reader.getExtLocationInfo(), reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix(), XmlReaderUtil.getAttributes(reader), reader.getNamespaceContext().freeze(), reader.getNamespaceDecls());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.startTag(reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix());
            for (Namespace attr : reader.getNamespaceDecls()) {
                writer.namespaceAttr(attr.getPrefix(), attr.getNamespaceURI());
            }
            int attributeCount = reader.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                String attrNs = reader.getAttributeNamespace(i);
                if (!Intrinsics.areEqual(attrNs, XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
                    String attrPrefix = reader.getAttributePrefix(i);
                    String prefix = "";
                    if (!Intrinsics.areEqual(attrNs, "") && (Intrinsics.areEqual(attrNs, writer.getNamespaceContext().getNamespaceURI(attrPrefix)) || (prefix = writer.getNamespaceContext().getPrefix(attrNs)) == null)) {
                        prefix = attrPrefix;
                    }
                    writer.attribute(attrNs, reader.getAttributeLocalName(i), prefix, reader.getAttributeValue(i));
                }
            }
        }
    },
    END_ELEMENT { // from class: nl.adaptivity.xmlutil.EventType.END_ELEMENT
        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.EndElementEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.EndElementEvent(reader.getExtLocationInfo(), reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix(), reader.getNamespaceContext());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.endTag(reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix());
        }
    },
    COMMENT { // from class: nl.adaptivity.xmlutil.EventType.COMMENT
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isIgnorable() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isTextElement() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.TextEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.TextEvent(reader.getExtLocationInfo(), this, reader.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlEvent.TextEvent textEvent) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(textEvent, "textEvent");
            writer.comment(textEvent.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.comment(reader.getText());
        }
    },
    TEXT { // from class: nl.adaptivity.xmlutil.EventType.TEXT
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isTextElement() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.TextEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.TextEvent(reader.getExtLocationInfo(), this, reader.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlEvent.TextEvent textEvent) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(textEvent, "textEvent");
            writer.text(textEvent.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.text(reader.getText());
        }
    },
    CDSECT { // from class: nl.adaptivity.xmlutil.EventType.CDSECT
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isTextElement() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.TextEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.TextEvent(reader.getExtLocationInfo(), this, reader.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlEvent.TextEvent textEvent) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(textEvent, "textEvent");
            writer.cdsect(textEvent.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.cdsect(reader.getText());
        }
    },
    DOCDECL { // from class: nl.adaptivity.xmlutil.EventType.DOCDECL
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isIgnorable() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.TextEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.TextEvent(reader.getExtLocationInfo(), this, reader.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlEvent.TextEvent textEvent) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(textEvent, "textEvent");
            writer.docdecl(textEvent.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.docdecl(reader.getText());
        }
    },
    END_DOCUMENT { // from class: nl.adaptivity.xmlutil.EventType.END_DOCUMENT
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isIgnorable() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.EndDocumentEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.EndDocumentEvent(reader.getExtLocationInfo());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.endDocument();
        }
    },
    ENTITY_REF { // from class: nl.adaptivity.xmlutil.EventType.ENTITY_REF
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isTextElement() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.TextEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.EntityRefEvent(reader.getExtLocationInfo(), reader.getLocalName(), reader.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlEvent.TextEvent textEvent) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(textEvent, "textEvent");
            writer.text(textEvent.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.text(reader.getText());
        }
    },
    IGNORABLE_WHITESPACE { // from class: nl.adaptivity.xmlutil.EventType.IGNORABLE_WHITESPACE
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isIgnorable() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isTextElement() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.TextEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.TextEvent(reader.getExtLocationInfo(), this, reader.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlEvent.TextEvent textEvent) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(textEvent, "textEvent");
            writer.ignorableWhitespace(textEvent.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.ignorableWhitespace(reader.getText());
        }
    },
    ATTRIBUTE { // from class: nl.adaptivity.xmlutil.EventType.ATTRIBUTE
        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.Attribute createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.Attribute(reader.getExtLocationInfo(), reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix(), reader.getText());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.attribute(reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix(), reader.getText());
        }
    },
    PROCESSING_INSTRUCTION { // from class: nl.adaptivity.xmlutil.EventType.PROCESSING_INSTRUCTION
        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isIgnorable() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public boolean isTextElement() {
            return true;
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public XmlEvent.TextEvent createEvent(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XmlEvent.ProcessingInstructionEvent(reader.getExtLocationInfo(), reader.getPiTarget(), reader.getPiData());
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlEvent.TextEvent textEvent) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(textEvent, "textEvent");
            if (!(textEvent instanceof XmlEvent.ProcessingInstructionEvent)) {
                writer.processingInstruction(textEvent.getText());
            } else {
                writer.processingInstruction(((XmlEvent.ProcessingInstructionEvent) textEvent).getTarget(), ((XmlEvent.ProcessingInstructionEvent) textEvent).getData());
            }
        }

        @Override // nl.adaptivity.xmlutil.EventType
        public void writeEvent(XmlWriter writer, XmlReader reader) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(reader, "reader");
            writer.processingInstruction(reader.getPiTarget(), reader.getPiData());
        }
    };
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract XmlEvent createEvent(XmlReader xmlReader);

    public abstract void writeEvent(XmlWriter xmlWriter, XmlReader xmlReader);

    public boolean isIgnorable() {
        return false;
    }

    public boolean isTextElement() {
        return false;
    }

    public void writeEvent(XmlWriter writer, XmlEvent.TextEvent textEvent) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(textEvent, "textEvent");
        throw new UnsupportedOperationException("This is not generally supported, only by text types");
    }

    public static EnumEntries<EventType> getEntries() {
        return $ENTRIES;
    }
}