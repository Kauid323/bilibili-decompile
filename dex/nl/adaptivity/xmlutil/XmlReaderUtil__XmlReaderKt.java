package nl.adaptivity.xmlutil;

import java.util.Collection;
import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import nl.adaptivity.xmlutil.XmlEvent;

/* compiled from: XmlReader.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0010*\u00020\u00032\n\u0010\u0014\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0015\u001a\n\u0010\u0016\u001a\u00020\u0012*\u00020\u0003\u001a\n\u0010\u0017\u001a\u00020\u0012*\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u0012*\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u001c*\u00020\u0003\u001a\n\u0010\u001d\u001a\u00020\u0012*\u00020\u0003\u001a\n\u0010\u001e\u001a\u00020\u001c*\u00020\u0003\u001a\n\u0010\u001f\u001a\u00020\u0010*\u00020\u0003\u001a#\u0010\u0013\u001a\u00020\u0010*\u00020\u00032\u0006\u0010 \u001a\u00020!2\n\u0010\u0014\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\"\u001a*\u0010\u0013\u001a\u00020\u0010*\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0012H\u0007\u001a0\u0010\u0013\u001a\u00020\u0010*\u00020\u00032\u0006\u0010 \u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0012\u001a\u0012\u0010&\u001a\u00020\u001c*\u00020\u00032\u0006\u0010'\u001a\u00020(\"\u001d\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0019\u0010\n\u001a\u00060\u000bj\u0002`\f*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, d2 = {"attributes", "", "Lnl/adaptivity/xmlutil/XmlEvent$Attribute;", "Lnl/adaptivity/xmlutil/XmlReader;", "getAttributes", "(Lnl/adaptivity/xmlutil/XmlReader;)[Lnl/adaptivity/xmlutil/XmlEvent$Attribute;", "attributeIndices", "Lkotlin/ranges/IntRange;", "getAttributeIndices", "(Lnl/adaptivity/xmlutil/XmlReader;)Lkotlin/ranges/IntRange;", "qname", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "getQname", "(Lnl/adaptivity/xmlutil/XmlReader;)Ljavax/xml/namespace/QName;", "isPrefixDeclaredInElement", "", "prefix", "", "isElement", "elementname", "(Lnl/adaptivity/xmlutil/XmlReader;Ljavax/xml/namespace/QName;)Z", "allText", "consecutiveTextContent", "Lnl/adaptivity/xmlutil/XmlBufferedReader;", "allConsecutiveTextContent", "Lnl/adaptivity/xmlutil/XmlPeekingReader;", "skipElement", "", "readSimpleElement", "skipPreamble", "isIgnorable", "type", "Lnl/adaptivity/xmlutil/EventType;", "(Lnl/adaptivity/xmlutil/XmlReader;Lnl/adaptivity/xmlutil/EventType;Ljavax/xml/namespace/QName;)Z", "elementNamespace", "elementName", "elementPrefix", "writeCurrent", "writer", "Lnl/adaptivity/xmlutil/XmlWriter;", "core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "nl/adaptivity/xmlutil/XmlReaderUtil")
public final /* synthetic */ class XmlReaderUtil__XmlReaderKt {

    /* compiled from: XmlReader.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.PROCESSING_INSTRUCTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.IGNORABLE_WHITESPACE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.ENTITY_REF.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EventType.TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EventType.CDSECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EventType.START_ELEMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EventType.START_DOCUMENT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EventType.END_DOCUMENT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EventType.DOCDECL.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final XmlEvent.Attribute[] getAttributes(XmlReader $this$attributes) {
        Intrinsics.checkNotNullParameter($this$attributes, "<this>");
        int attributeCount = $this$attributes.getAttributeCount();
        XmlEvent.Attribute[] attributeArr = new XmlEvent.Attribute[attributeCount];
        for (int i = 0; i < attributeCount; i++) {
            attributeArr[i] = new XmlEvent.Attribute($this$attributes.getExtLocationInfo(), $this$attributes.getAttributeNamespace(i), $this$attributes.getAttributeLocalName(i), $this$attributes.getAttributePrefix(i), $this$attributes.getAttributeValue(i));
        }
        return attributeArr;
    }

    public static final IntRange getAttributeIndices(XmlReader $this$attributeIndices) {
        Intrinsics.checkNotNullParameter($this$attributeIndices, "<this>");
        return RangesKt.until(0, $this$attributeIndices.getAttributeCount());
    }

    public static final QName getQname(XmlReader $this$qname) {
        Intrinsics.checkNotNullParameter($this$qname, "<this>");
        return XmlUtil.toQname($this$qname.getText());
    }

    public static final boolean isPrefixDeclaredInElement(XmlReader $this$isPrefixDeclaredInElement, String prefix) {
        Intrinsics.checkNotNullParameter($this$isPrefixDeclaredInElement, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Iterable $this$any$iv = $this$isPrefixDeclaredInElement.getNamespaceDecls();
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            Namespace it = (Namespace) element$iv;
            if (Intrinsics.areEqual(it.getPrefix(), prefix)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isElement(XmlReader $this$isElement, QName elementname) {
        Intrinsics.checkNotNullParameter($this$isElement, "<this>");
        Intrinsics.checkNotNullParameter(elementname, "elementname");
        return XmlReaderUtil.isElement($this$isElement, EventType.START_ELEMENT, elementname.getNamespaceURI(), elementname.getLocalPart(), elementname.getPrefix());
    }

    public static final String allText(XmlReader $this$allText) {
        Intrinsics.checkNotNullParameter($this$allText, "<this>");
        StringBuilder $this$allText_u24lambda_u242 = new StringBuilder();
        if ($this$allText.getEventType().isTextElement()) {
            $this$allText_u24lambda_u242.append($this$allText.getText());
        }
        while (true) {
            EventType $this$allText_u24lambda_u242_u24lambda_u241 = $this$allText.next();
            if ($this$allText_u24lambda_u242_u24lambda_u241 == EventType.END_ELEMENT) {
                return $this$allText_u24lambda_u242.toString();
            }
            switch ($this$allText_u24lambda_u242_u24lambda_u241 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[$this$allText_u24lambda_u242_u24lambda_u241.ordinal()]) {
                case 1:
                case 2:
                    break;
                case 3:
                    if ($this$allText_u24lambda_u242.length() == 0) {
                        break;
                    } else {
                        $this$allText_u24lambda_u242.append($this$allText.getText());
                        break;
                    }
                case 4:
                case 5:
                case 6:
                    $this$allText_u24lambda_u242.append($this$allText.getText());
                    break;
                default:
                    throw new XmlException("Found unexpected child tag with type: " + $this$allText_u24lambda_u242_u24lambda_u241, null, 2, null);
            }
        }
    }

    public static final String consecutiveTextContent(XmlBufferedReader $this$consecutiveTextContent) {
        XmlEvent $this$consecutiveTextContent_u24lambda_u244_u24lambda_u243;
        Intrinsics.checkNotNullParameter($this$consecutiveTextContent, "<this>");
        StringBuilder whiteSpace = new StringBuilder();
        StringBuilder $this$consecutiveTextContent_u24lambda_u244 = new StringBuilder();
        if ($this$consecutiveTextContent.getEventType().isTextElement()) {
            $this$consecutiveTextContent_u24lambda_u244.append($this$consecutiveTextContent.getText());
        } else if ($this$consecutiveTextContent.getEventType() == EventType.IGNORABLE_WHITESPACE) {
            whiteSpace.append($this$consecutiveTextContent.getText());
        }
        while (true) {
            $this$consecutiveTextContent_u24lambda_u244_u24lambda_u243 = $this$consecutiveTextContent.peek();
            if (($this$consecutiveTextContent_u24lambda_u244_u24lambda_u243 != null ? $this$consecutiveTextContent_u24lambda_u244_u24lambda_u243.getEventType() : null) != EventType.END_ELEMENT) {
                EventType eventType = $this$consecutiveTextContent_u24lambda_u244_u24lambda_u243 != null ? $this$consecutiveTextContent_u24lambda_u244_u24lambda_u243.getEventType() : null;
                switch (eventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
                    case 1:
                    case 2:
                        $this$consecutiveTextContent.next();
                        Unit unit = Unit.INSTANCE;
                        break;
                    case 3:
                        $this$consecutiveTextContent.next();
                        whiteSpace.append($this$consecutiveTextContent.getText());
                        break;
                    case 4:
                    case 5:
                    case 6:
                        $this$consecutiveTextContent.next();
                        if ($this$consecutiveTextContent_u24lambda_u244.length() > 0) {
                            $this$consecutiveTextContent_u24lambda_u244.append((CharSequence) whiteSpace);
                            StringsKt.clear(whiteSpace);
                        }
                        $this$consecutiveTextContent_u24lambda_u244.append($this$consecutiveTextContent.getText());
                        break;
                    case 7:
                        if ($this$consecutiveTextContent_u24lambda_u244.length() > 0) {
                            $this$consecutiveTextContent_u24lambda_u244.append((CharSequence) whiteSpace);
                            StringsKt.clear(whiteSpace);
                            break;
                        }
                        break;
                    default:
                        throw new XmlException("Found unexpected child tag: " + $this$consecutiveTextContent_u24lambda_u244_u24lambda_u243, null, 2, null);
                }
            }
        }
        if (($this$consecutiveTextContent_u24lambda_u244_u24lambda_u243 != null ? $this$consecutiveTextContent_u24lambda_u244_u24lambda_u243.getEventType() : null) == EventType.END_ELEMENT) {
            $this$consecutiveTextContent_u24lambda_u244.append((CharSequence) whiteSpace);
        }
        return $this$consecutiveTextContent_u24lambda_u244.toString();
    }

    public static final String allConsecutiveTextContent(XmlPeekingReader $this$allConsecutiveTextContent) {
        Intrinsics.checkNotNullParameter($this$allConsecutiveTextContent, "<this>");
        EventType et = $this$allConsecutiveTextContent.getHasPeekItems() ? null : $this$allConsecutiveTextContent.getEventType();
        if (et == EventType.END_ELEMENT) {
            return "";
        }
        StringBuilder $this$allConsecutiveTextContent_u24lambda_u246 = new StringBuilder();
        if (et != null && (et.isTextElement() || et == EventType.IGNORABLE_WHITESPACE)) {
            $this$allConsecutiveTextContent_u24lambda_u246.append($this$allConsecutiveTextContent.getText());
        }
        while (true) {
            EventType it = $this$allConsecutiveTextContent.peekNextEvent();
            if (it != EventType.END_ELEMENT) {
                switch (it == null ? -1 : WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                    case 1:
                    case 2:
                        $this$allConsecutiveTextContent.next();
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        $this$allConsecutiveTextContent.next();
                        $this$allConsecutiveTextContent_u24lambda_u246.append($this$allConsecutiveTextContent.getText());
                        break;
                    case 7:
                        break;
                    default:
                        throw new XmlException("Found unexpected child tag: " + it, null, 2, null);
                }
            }
        }
        return $this$allConsecutiveTextContent_u24lambda_u246.toString();
    }

    public static final void skipElement(XmlReader $this$skipElement) {
        Intrinsics.checkNotNullParameter($this$skipElement, "<this>");
        $this$skipElement.require(EventType.START_ELEMENT, null, null);
        while ($this$skipElement.hasNext() && $this$skipElement.next() != EventType.END_ELEMENT) {
            if ($this$skipElement.getEventType() == EventType.START_ELEMENT) {
                XmlReaderUtil.skipElement($this$skipElement);
            }
        }
    }

    public static final String readSimpleElement(XmlReader $this$readSimpleElement) {
        Intrinsics.checkNotNullParameter($this$readSimpleElement, "<this>");
        $this$readSimpleElement.require(EventType.START_ELEMENT, null, null);
        StringBuilder $this$readSimpleElement_u24lambda_u247 = new StringBuilder();
        while ($this$readSimpleElement.next() != EventType.END_ELEMENT) {
            switch (WhenMappings.$EnumSwitchMapping$0[$this$readSimpleElement.getEventType().ordinal()]) {
                case 1:
                case 2:
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    $this$readSimpleElement_u24lambda_u247.append($this$readSimpleElement.getText());
                    break;
                default:
                    throw new XmlException("Expected text content or end tag, found: " + $this$readSimpleElement.getEventType(), null, 2, null);
            }
        }
        return $this$readSimpleElement_u24lambda_u247.toString();
    }

    public static final void skipPreamble(XmlReader $this$skipPreamble) {
        Intrinsics.checkNotNullParameter($this$skipPreamble, "<this>");
        while (true) {
            if ((!$this$skipPreamble.isStarted() || XmlReaderUtil.isIgnorable($this$skipPreamble)) && $this$skipPreamble.hasNext()) {
                $this$skipPreamble.next();
            } else {
                return;
            }
        }
    }

    public static final boolean isIgnorable(XmlReader $this$isIgnorable) {
        Intrinsics.checkNotNullParameter($this$isIgnorable, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$isIgnorable.getEventType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 8:
            case 9:
            case 10:
                return true;
            case 4:
            case 6:
            case 7:
            default:
                return false;
            case 5:
                return XmlUtil.isXmlWhitespace($this$isIgnorable.getText());
        }
    }

    public static final boolean isElement(XmlReader $this$isElement, EventType type, QName elementname) {
        Intrinsics.checkNotNullParameter($this$isElement, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(elementname, "elementname");
        return XmlReaderUtil.isElement($this$isElement, type, elementname.getNamespaceURI(), elementname.getLocalPart(), elementname.getPrefix());
    }

    public static /* synthetic */ boolean isElement$default(XmlReader xmlReader, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return XmlReaderUtil.isElement(xmlReader, str, str2, str3);
    }

    public static final boolean isElement(XmlReader $this$isElement, String elementNamespace, String elementName, String elementPrefix) {
        Intrinsics.checkNotNullParameter($this$isElement, "<this>");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        return XmlReaderUtil.isElement($this$isElement, EventType.START_ELEMENT, elementNamespace, elementName, elementPrefix);
    }

    public static final boolean isElement(XmlReader $this$isElement, String elementNamespace, String elementName) {
        boolean isElement$default;
        Intrinsics.checkNotNullParameter($this$isElement, "<this>");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        isElement$default = isElement$default($this$isElement, elementNamespace, elementName, null, 4, null);
        return isElement$default;
    }

    public static /* synthetic */ boolean isElement$default(XmlReader xmlReader, EventType eventType, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        return XmlReaderUtil.isElement(xmlReader, eventType, str, str2, str3);
    }

    public static final boolean isElement(XmlReader $this$isElement, EventType type, String elementNamespace, String elementName, String elementPrefix) {
        Intrinsics.checkNotNullParameter($this$isElement, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        if ($this$isElement.getEventType() != type) {
            return false;
        }
        CharSequence charSequence = null;
        if (elementNamespace != null) {
            String str = elementNamespace;
            if (!(str.length() == 0)) {
                charSequence = str;
            }
            charSequence = (String) charSequence;
        }
        CharSequence expNs = charSequence;
        if (Intrinsics.areEqual($this$isElement.getLocalName(), elementName)) {
            String str2 = elementNamespace;
            if (!(str2 == null || str2.length() == 0)) {
                return Intrinsics.areEqual(expNs, $this$isElement.getNamespaceURI());
            }
            String str3 = elementPrefix;
            if (str3 == null || str3.length() == 0) {
                return $this$isElement.getPrefix().length() == 0;
            }
            return Intrinsics.areEqual(elementPrefix, $this$isElement.getPrefix());
        }
        return false;
    }

    public static final void writeCurrent(XmlReader $this$writeCurrent, XmlWriter writer) {
        Intrinsics.checkNotNullParameter($this$writeCurrent, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        $this$writeCurrent.getEventType().writeEvent(writer, $this$writeCurrent);
    }
}