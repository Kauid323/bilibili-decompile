package nl.adaptivity.xmlutil;

import java.util.Map;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import nl.adaptivity.xmlutil.dom2.Node;

@Metadata(d1 = {"nl/adaptivity/xmlutil/XmlWriterUtil__XmlWriterKt", "nl/adaptivity/xmlutil/XmlWriterUtil__XmlWriterUtilKt"}, k = 4, mv = {2, 1, 0}, xi = 48)
public final class XmlWriterUtil {
    @Deprecated(message = "This function should be internal")
    public static final void addUndeclaredNamespaces(XmlWriter $this$addUndeclaredNamespaces, XmlReader reader, Map<String, String> map) {
        XmlWriterUtil__XmlWriterKt.addUndeclaredNamespaces($this$addUndeclaredNamespaces, reader, map);
    }

    public static final void endTag(XmlWriter $this$endTag, QName predelemname) {
        XmlWriterUtil__XmlWriterKt.endTag($this$endTag, predelemname);
    }

    public static final XmlWriter filterSubstream(XmlWriter $this$filterSubstream) {
        return XmlWriterUtil__XmlWriterKt.filterSubstream($this$filterSubstream);
    }

    public static final void serialize(XmlWriter $this$serialize, XmlReader reader) {
        XmlWriterUtil__XmlWriterKt.serialize($this$serialize, reader);
    }

    public static final void serialize(XmlWriter $this$serialize, Node node) {
        XmlWriterUtil__XmlWriterKt.serialize($this$serialize, node);
    }

    public static final void serialize(XmlWriter $this$serialize, org.w3c.dom.Node node) {
        XmlWriterUtil__XmlWriterUtilKt.serialize($this$serialize, node);
    }

    @Deprecated(message = "Should be moved to the xmlserializable library", replaceWith = @ReplaceWith(expression = "this.serializeAll(iterable)", imports = {"nl.adaptivity.xmlutil.xmlserializable.serializeAll"}))
    public static final <T extends XmlSerializable> void serializeAll(XmlWriter $this$serializeAll, Iterable<? extends T> iterable) {
        XmlWriterUtil__XmlWriterKt.serializeAll($this$serializeAll, iterable);
    }

    @Deprecated(message = "Should be moved to the xmlserializable library", replaceWith = @ReplaceWith(expression = "this.serializeAll(iterable)", imports = {"nl.adaptivity.xmlutil.xmlserializable.serializeAll"}))
    public static final <T extends XmlSerializable> void serializeAll(XmlWriter $this$serializeAll, Sequence<? extends T> sequence) {
        XmlWriterUtil__XmlWriterKt.serializeAll($this$serializeAll, sequence);
    }

    public static final String smartStartTag(XmlWriter $this$smartStartTag, String nsUri, String localName) {
        return XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, nsUri, localName);
    }

    public static final String smartStartTag(XmlWriter $this$smartStartTag, String nsUri, String localName, String prefix) {
        return XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, nsUri, localName, prefix);
    }

    @Deprecated(message = "Use strings", replaceWith = @ReplaceWith(expression = "smartStartTag(nsUri?.toString(), localName.toString(), prefix?.toString())", imports = {}))
    public static final void smartStartTag(XmlWriter $this$smartStartTag, CharSequence nsUri, CharSequence localName) {
        XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, nsUri, localName);
    }

    @Deprecated(message = "Use strings", replaceWith = @ReplaceWith(expression = "smartStartTag(nsUri?.toString(), localName.toString(), prefix?.toString())", imports = {}))
    public static final void smartStartTag(XmlWriter $this$smartStartTag, CharSequence nsUri, CharSequence localName, CharSequence prefix) {
        XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, nsUri, localName, prefix);
    }

    @Deprecated(message = "Use strings", replaceWith = @ReplaceWith(expression = "smartStartTag(nsUri?.toString(), localName.toString(), prefix?.toString(), body)", imports = {}))
    public static final void smartStartTag(XmlWriter $this$smartStartTag, CharSequence nsUri, CharSequence localName, CharSequence prefix, Function1<? super XmlWriter, Unit> function1) {
        XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, nsUri, localName, prefix, function1);
    }

    public static final void smartStartTag(XmlWriter $this$smartStartTag, String nsUri, String localName, String prefix, Function1<? super XmlWriter, Unit> function1) {
        XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, nsUri, localName, prefix, function1);
    }

    public static final void smartStartTag(XmlWriter $this$smartStartTag, String nsUri, String localName, Function1<? super XmlWriter, Unit> function1) {
        XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, nsUri, localName, function1);
    }

    public static final void smartStartTag(XmlWriter $this$smartStartTag, QName qName) {
        XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, qName);
    }

    public static final void smartStartTag(XmlWriter $this$smartStartTag, QName qName, Function1<? super XmlWriter, Unit> function1) {
        XmlWriterUtil__XmlWriterKt.smartStartTag($this$smartStartTag, qName, function1);
    }

    public static final void startTag(XmlWriter $this$startTag, String nsUri, String localName, String prefix, Function1<? super XmlWriter, Unit> function1) {
        XmlWriterUtil__XmlWriterKt.startTag($this$startTag, nsUri, localName, prefix, function1);
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, double value) {
        XmlWriterUtil__XmlWriterKt.writeAttribute($this$writeAttribute, name, value);
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, long value) {
        XmlWriterUtil__XmlWriterKt.writeAttribute($this$writeAttribute, name, value);
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, Object value) {
        XmlWriterUtil__XmlWriterKt.writeAttribute($this$writeAttribute, name, value);
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, String value) {
        XmlWriterUtil__XmlWriterKt.writeAttribute($this$writeAttribute, name, value);
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, QName value) {
        XmlWriterUtil__XmlWriterKt.writeAttribute($this$writeAttribute, name, value);
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, QName name, String value) {
        XmlWriterUtil__XmlWriterKt.writeAttribute($this$writeAttribute, name, value);
    }

    public static final void writeChild(XmlWriter $this$writeChild, org.w3c.dom.Node node) {
        XmlWriterUtil__XmlWriterUtilKt.writeChild($this$writeChild, node);
    }

    public static final void writeCurrentEvent(XmlWriter $this$writeCurrentEvent, XmlReader reader) {
        XmlWriterUtil__XmlWriterKt.writeCurrentEvent($this$writeCurrentEvent, reader);
    }

    public static final void writeElement(XmlWriter $this$writeElement, Map<String, String> map, XmlReader reader) {
        XmlWriterUtil__XmlWriterKt.writeElement($this$writeElement, map, reader);
    }

    public static final void writeElementContent(XmlWriter $this$writeElementContent, Map<String, String> map, XmlReader reader) {
        XmlWriterUtil__XmlWriterKt.writeElementContent($this$writeElementContent, map, reader);
    }

    public static final <T> void writeListIfNotEmpty(XmlWriter $this$writeListIfNotEmpty, Iterable<? extends T> iterable, String nsUri, String localName, String prefix, Function2<? super XmlWriter, ? super T, Unit> function2) {
        XmlWriterUtil__XmlWriterKt.writeListIfNotEmpty($this$writeListIfNotEmpty, iterable, nsUri, localName, prefix, function2);
    }

    public static final void writeSimpleElement(XmlWriter $this$writeSimpleElement, String nsUri, String localName, String prefix, String value) {
        XmlWriterUtil__XmlWriterKt.writeSimpleElement($this$writeSimpleElement, nsUri, localName, prefix, value);
    }

    public static final void writeSimpleElement(XmlWriter $this$writeSimpleElement, QName qName, String value) {
        XmlWriterUtil__XmlWriterKt.writeSimpleElement($this$writeSimpleElement, qName, value);
    }
}