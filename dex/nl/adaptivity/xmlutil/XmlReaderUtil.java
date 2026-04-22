package nl.adaptivity.xmlutil;

import java.io.CharArrayWriter;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.util.CompactFragment;
import nl.adaptivity.xmlutil.util.ICompactFragment;

@Metadata(d1 = {"nl/adaptivity/xmlutil/XmlReaderUtil__XmlReaderExtKt", "nl/adaptivity/xmlutil/XmlReaderUtil__XmlReaderKt", "nl/adaptivity/xmlutil/XmlReaderUtil__XmlReaderNSKt", "nl/adaptivity/xmlutil/XmlReaderUtil__XmlReaderUtilKt"}, k = 4, mv = {2, 1, 0}, xi = 48)
public final class XmlReaderUtil {
    public static final String allConsecutiveTextContent(XmlPeekingReader $this$allConsecutiveTextContent) {
        return XmlReaderUtil__XmlReaderKt.allConsecutiveTextContent($this$allConsecutiveTextContent);
    }

    public static final String allText(XmlReader $this$allText) {
        return XmlReaderUtil__XmlReaderKt.allText($this$allText);
    }

    public static final XmlReader asSubstream(XmlReader $this$asSubstream) {
        return XmlReaderUtil__XmlReaderUtilKt.asSubstream($this$asSubstream);
    }

    public static final String consecutiveTextContent(XmlBufferedReader $this$consecutiveTextContent) {
        return XmlReaderUtil__XmlReaderKt.consecutiveTextContent($this$consecutiveTextContent);
    }

    public static final ICompactFragment elementContentToFragment(XmlReader $this$elementContentToFragment) {
        return XmlReaderUtil__XmlReaderNSKt.elementContentToFragment($this$elementContentToFragment);
    }

    public static final CompactFragment elementToFragment(XmlReader $this$elementToFragment) {
        return XmlReaderUtil__XmlReaderNSKt.elementToFragment($this$elementToFragment);
    }

    public static final IntRange getAttributeIndices(XmlReader $this$attributeIndices) {
        return XmlReaderUtil__XmlReaderKt.getAttributeIndices($this$attributeIndices);
    }

    public static final XmlEvent.Attribute[] getAttributes(XmlReader $this$attributes) {
        return XmlReaderUtil__XmlReaderKt.getAttributes($this$attributes);
    }

    public static final QName getQname(XmlReader $this$qname) {
        return XmlReaderUtil__XmlReaderKt.getQname($this$qname);
    }

    public static final boolean isElement(XmlReader $this$isElement, String elementNamespace, String elementName) {
        return XmlReaderUtil__XmlReaderKt.isElement($this$isElement, elementNamespace, elementName);
    }

    public static final boolean isElement(XmlReader $this$isElement, String elementNamespace, String elementName, String elementPrefix) {
        return XmlReaderUtil__XmlReaderKt.isElement($this$isElement, elementNamespace, elementName, elementPrefix);
    }

    public static final boolean isElement(XmlReader $this$isElement, QName elementname) {
        return XmlReaderUtil__XmlReaderKt.isElement($this$isElement, elementname);
    }

    public static final boolean isElement(XmlReader $this$isElement, EventType type, String elementNamespace, String elementName, String elementPrefix) {
        return XmlReaderUtil__XmlReaderKt.isElement($this$isElement, type, elementNamespace, elementName, elementPrefix);
    }

    public static final boolean isElement(XmlReader $this$isElement, EventType type, QName elementname) {
        return XmlReaderUtil__XmlReaderKt.isElement($this$isElement, type, elementname);
    }

    public static final boolean isIgnorable(XmlReader $this$isIgnorable) {
        return XmlReaderUtil__XmlReaderKt.isIgnorable($this$isIgnorable);
    }

    public static final boolean isPrefixDeclaredInElement(XmlReader $this$isPrefixDeclaredInElement, String prefix) {
        return XmlReaderUtil__XmlReaderKt.isPrefixDeclaredInElement($this$isPrefixDeclaredInElement, prefix);
    }

    public static final String readSimpleElement(XmlReader $this$readSimpleElement) {
        return XmlReaderUtil__XmlReaderKt.readSimpleElement($this$readSimpleElement);
    }

    @Deprecated(message = "This is inefficient in Javascript")
    public static final char[] siblingsToCharArray(XmlReader $this$siblingsToCharArray) {
        return XmlReaderUtil__XmlReaderNSKt.siblingsToCharArray($this$siblingsToCharArray);
    }

    public static final CompactFragment siblingsToFragment(XmlReader $this$siblingsToFragment) {
        return XmlReaderUtil__XmlReaderNSKt.siblingsToFragment($this$siblingsToFragment);
    }

    public static final void skipElement(XmlReader $this$skipElement) {
        XmlReaderUtil__XmlReaderKt.skipElement($this$skipElement);
    }

    public static final void skipPreamble(XmlReader $this$skipPreamble) {
        XmlReaderUtil__XmlReaderKt.skipPreamble($this$skipPreamble);
    }

    public static final CharArrayWriter toCharArrayWriter(XmlReader $this$toCharArrayWriter) {
        return XmlReaderUtil__XmlReaderExtKt.toCharArrayWriter($this$toCharArrayWriter);
    }

    public static final XmlEvent toEvent(XmlReader $this$toEvent) {
        return XmlReaderUtil__XmlReaderUtilKt.toEvent($this$toEvent);
    }

    public static final void writeCurrent(XmlReader $this$writeCurrent, XmlWriter writer) {
        XmlReaderUtil__XmlReaderKt.writeCurrent($this$writeCurrent, writer);
    }
}