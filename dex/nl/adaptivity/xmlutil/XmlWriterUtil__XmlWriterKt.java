package nl.adaptivity.xmlutil;

import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.QName;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import nl.adaptivity.xmlutil.core.impl.multiplatform.Multiplatform_jvmKt;
import nl.adaptivity.xmlutil.dom2.Node;

/* compiled from: XmlWriter.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0007\u001a-\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0002\b\t\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001b\u0010\f\u001a\u00020\u0001*\u00020\u00022\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f¢\u0006\u0002\u0010\u0010\u001a:\u0010\f\u001a\u00020\u0001*\u00020\u00022\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a*\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0007\u001a/\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\b\f\u001a*\u0010\f\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0007\u001aG\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000\u001aG\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000\u001aa\u0010\u001a\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b*\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u001d\u0010\u0011\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000\u001a%\u0010\u001f\u001a\u00020\u0001\"\b\b\u0000\u0010\u001b*\u00020 *\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0087\b\u001a%\u0010\u001f\u001a\u00020\u0001\"\b\b\u0000\u0010\u001b*\u00020 *\u00020\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001b0\"H\u0087\b\u001aG\u0010#\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000\u001a%\u0010$\u001a\u00020\u0001*\u00020\u00022\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010&\u001a0\u0010$\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0007\u001a\u001c\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0007\u001a\u001c\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010)\u001a%\u0010'\u001a\u00020\u0001*\u00020\u00022\n\u0010(\u001a\u00060\u000ej\u0002`\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010&\u001a\u001a\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020*\u001a\u001a\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020+\u001a'\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u00072\u000e\u0010%\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\u0002\u0010,\u001a\u001b\u0010-\u001a\u00020\u0001*\u00020\u00022\n\u0010.\u001a\u00060\u000ej\u0002`\u000f¢\u0006\u0002\u0010\u0010\u001a\n\u0010/\u001a\u00020\u0002*\u00020\u0002\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u00100\u001a\u000201\u001a(\u00102\u001a\u00020\u0001*\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u001a(\u00103\u001a\u00020\u0001*\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"addUndeclaredNamespaces", "", "Lnl/adaptivity/xmlutil/XmlWriter;", "reader", "Lnl/adaptivity/xmlutil/XmlReader;", "missingNamespaces", "", "", "undeclaredPrefixes", "undeclaredPrefixes$XmlWriterUtil__XmlWriterKt", "serialize", "writeCurrentEvent", "smartStartTag", "qName", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "(Lnl/adaptivity/xmlutil/XmlWriter;Ljavax/xml/namespace/QName;)V", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lnl/adaptivity/xmlutil/XmlWriter;Ljavax/xml/namespace/QName;Lkotlin/jvm/functions/Function1;)V", "nsUri", "", "localName", "prefix", "smartStartTagCompat", "writeListIfNotEmpty", "T", "iterable", "", "Lkotlin/Function2;", "serializeAll", "Lnl/adaptivity/xmlutil/XmlSerializable;", "sequence", "Lkotlin/sequences/Sequence;", "startTag", "writeSimpleElement", "value", "(Lnl/adaptivity/xmlutil/XmlWriter;Ljavax/xml/namespace/QName;Ljava/lang/String;)V", "writeAttribute", "name", "", "", "", "(Lnl/adaptivity/xmlutil/XmlWriter;Ljava/lang/String;Ljavax/xml/namespace/QName;)V", "endTag", "predelemname", "filterSubstream", "node", "Lnl/adaptivity/xmlutil/dom2/Node;", "writeElement", "writeElementContent", "core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "nl/adaptivity/xmlutil/XmlWriterUtil")
public final /* synthetic */ class XmlWriterUtil__XmlWriterKt {

    /* compiled from: XmlWriter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.START_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.PROCESSING_INSTRUCTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.DOCDECL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EventType.IGNORABLE_WHITESPACE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EventType.START_ELEMENT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EventType.END_ELEMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EventType.COMMENT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EventType.TEXT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EventType.ATTRIBUTE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[EventType.CDSECT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[EventType.ENTITY_REF.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "This function should be internal")
    public static final void addUndeclaredNamespaces(XmlWriter $this$addUndeclaredNamespaces, XmlReader reader, Map<String, String> missingNamespaces) {
        Intrinsics.checkNotNullParameter($this$addUndeclaredNamespaces, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(missingNamespaces, "missingNamespaces");
        undeclaredPrefixes$XmlWriterUtil__XmlWriterKt($this$addUndeclaredNamespaces, reader, missingNamespaces);
    }

    private static final void undeclaredPrefixes$XmlWriterUtil__XmlWriterKt(XmlWriter $this$undeclaredPrefixes, XmlReader reader, Map<String, String> map) {
        Multiplatform_jvmKt.m1630assert(reader.getEventType() == EventType.START_ELEMENT);
        String prefix = reader.getPrefix();
        if (!map.containsKey(prefix)) {
            String uri = reader.getNamespaceURI();
            if ((uri.length() > 0) && !Intrinsics.areEqual($this$undeclaredPrefixes.getNamespaceUri(prefix), uri)) {
                map.put(prefix, uri);
            }
        }
        int attributeCount = reader.getAttributeCount();
        for (int attrIdx = 0; attrIdx < attributeCount; attrIdx++) {
            String prefix2 = reader.getAttributePrefix(attrIdx);
            if (!Intrinsics.areEqual(prefix2, "") && !Intrinsics.areEqual(prefix2, XMLConstants.XMLNS_ATTRIBUTE) && !map.containsKey(prefix2)) {
                String uri2 = reader.getAttributeNamespace(attrIdx);
                if (!Intrinsics.areEqual($this$undeclaredPrefixes.getNamespaceUri(prefix2), uri2) || !XmlReaderUtil.isPrefixDeclaredInElement(reader, prefix2)) {
                    map.put(prefix2, uri2);
                }
            }
        }
        for (Namespace namespace : reader.getNamespaceDecls()) {
            map.remove(namespace.component1());
        }
    }

    public static final void serialize(XmlWriter $this$serialize, XmlReader reader) {
        Intrinsics.checkNotNullParameter($this$serialize, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        while (reader.hasNext()) {
            switch (WhenMappings.$EnumSwitchMapping$0[reader.next().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    if ($this$serialize.getDepth() > 0) {
                        break;
                    } else {
                        XmlWriterUtil.writeCurrentEvent($this$serialize, reader);
                        break;
                    }
                case 5:
                    if (!($this$serialize.getIndentString().length() == 0)) {
                        break;
                    } else {
                        XmlWriterUtil.writeCurrentEvent($this$serialize, reader);
                        break;
                    }
                default:
                    XmlWriterUtil.writeCurrentEvent($this$serialize, reader);
                    break;
            }
        }
    }

    public static final void writeCurrentEvent(XmlWriter $this$writeCurrentEvent, XmlReader reader) {
        Intrinsics.checkNotNullParameter($this$writeCurrentEvent, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        switch (WhenMappings.$EnumSwitchMapping$0[reader.getEventType().ordinal()]) {
            case 1:
                $this$writeCurrentEvent.startDocument(null, reader.getEncoding(), reader.getStandalone());
                return;
            case 2:
                $this$writeCurrentEvent.processingInstruction(reader.getPiTarget(), reader.getPiData());
                return;
            case 3:
                $this$writeCurrentEvent.docdecl(reader.getText());
                return;
            case 4:
                $this$writeCurrentEvent.endDocument();
                return;
            case 5:
                $this$writeCurrentEvent.ignorableWhitespace(reader.getText());
                return;
            case 6:
                $this$writeCurrentEvent.startTag(reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix());
                for (Namespace a : reader.getNamespaceDecls()) {
                    $this$writeCurrentEvent.namespaceAttr(a.getPrefix(), a.getNamespaceURI());
                }
                IntRange attributeIndices = XmlReaderUtil.getAttributeIndices(reader);
                int i = attributeIndices.getFirst();
                int last = attributeIndices.getLast();
                if (i > last) {
                    return;
                }
                while (true) {
                    String attrPrefix = reader.getAttributePrefix(i);
                    String prefix = "";
                    String namespace = Intrinsics.areEqual(attrPrefix, "") ? "" : reader.getAttributeNamespace(i);
                    if (!Intrinsics.areEqual(namespace, "") && (Intrinsics.areEqual(namespace, $this$writeCurrentEvent.getNamespaceContext().getNamespaceURI(attrPrefix)) || (prefix = $this$writeCurrentEvent.getNamespaceContext().getPrefix(namespace)) == null)) {
                        prefix = attrPrefix;
                    }
                    $this$writeCurrentEvent.attribute(namespace, reader.getAttributeLocalName(i), prefix, reader.getAttributeValue(i));
                    if (i == last) {
                        return;
                    }
                    i++;
                }
                break;
            case 7:
                $this$writeCurrentEvent.endTag(reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix());
                return;
            case 8:
                $this$writeCurrentEvent.comment(reader.getText());
                return;
            case 9:
                $this$writeCurrentEvent.text(reader.getText());
                return;
            case 10:
                $this$writeCurrentEvent.attribute(reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix(), reader.getText());
                return;
            case 11:
                $this$writeCurrentEvent.cdsect(reader.getText());
                return;
            case additional_type_content_opus_VALUE:
                $this$writeCurrentEvent.entityRef(reader.getText());
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final void smartStartTag(XmlWriter $this$smartStartTag, QName qName) {
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(qName, "qName");
        XmlWriterUtil.smartStartTag($this$smartStartTag, qName.getNamespaceURI(), qName.getLocalPart(), qName.getPrefix());
    }

    public static final void smartStartTag(XmlWriter $this$smartStartTag, QName qName, Function1<? super XmlWriter, Unit> body) {
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(qName, "qName");
        Intrinsics.checkNotNullParameter(body, "body");
        String nsUri$iv = qName.getNamespaceURI();
        String localName$iv = qName.getLocalPart();
        String prefix$iv = qName.getPrefix();
        String usedPrefix$iv = XmlWriterUtil.smartStartTag($this$smartStartTag, nsUri$iv, localName$iv, prefix$iv);
        body.invoke($this$smartStartTag);
        $this$smartStartTag.endTag(nsUri$iv, localName$iv, usedPrefix$iv);
    }

    public static /* synthetic */ void smartStartTag$default(XmlWriter xmlWriter, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence3 = null;
        }
        XmlWriterUtil.smartStartTag(xmlWriter, charSequence, charSequence2, charSequence3);
    }

    @Deprecated(message = "Use strings", replaceWith = @ReplaceWith(expression = "smartStartTag(nsUri?.toString(), localName.toString(), prefix?.toString())", imports = {}))
    public static final void smartStartTag(XmlWriter $this$smartStartTag, CharSequence nsUri, CharSequence localName, CharSequence prefix) {
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        XmlWriterUtil.smartStartTag($this$smartStartTag, nsUri != null ? nsUri.toString() : null, localName.toString(), prefix != null ? prefix.toString() : null);
    }

    @Deprecated(message = "Use strings", replaceWith = @ReplaceWith(expression = "smartStartTag(nsUri?.toString(), localName.toString(), prefix?.toString())", imports = {}))
    public static final void smartStartTag(XmlWriter $this$smartStartTag, CharSequence nsUri, CharSequence localName) {
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        smartStartTag$default($this$smartStartTag, nsUri, localName, (CharSequence) null, 4, (Object) null);
    }

    /* renamed from: smartStartTag$default */
    public static /* synthetic */ void m1586smartStartTag$default(XmlWriter xmlWriter, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        m1585smartStartTag(xmlWriter, str, str2, str3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Present for return value change only")
    /* renamed from: smartStartTag */
    public static final /* synthetic */ void m1585smartStartTag(XmlWriter $this$smartStartTagCompat, String nsUri, String localName, String prefix) {
        Intrinsics.checkNotNullParameter($this$smartStartTagCompat, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        XmlWriterUtil.smartStartTag($this$smartStartTagCompat, nsUri, localName, prefix);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Present for return value change only")
    /* renamed from: smartStartTag */
    public static final /* synthetic */ void m1584smartStartTag(XmlWriter $this$smartStartTagCompat, String nsUri, String localName) {
        Intrinsics.checkNotNullParameter($this$smartStartTagCompat, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        m1586smartStartTag$default($this$smartStartTagCompat, nsUri, localName, (String) null, 4, (Object) null);
    }

    public static /* synthetic */ String smartStartTag$default(XmlWriter xmlWriter, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return XmlWriterUtil.smartStartTag(xmlWriter, str, str2, str3);
    }

    public static final String smartStartTag(XmlWriter $this$smartStartTag, String nsUri, String localName, String prefix) {
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        if (nsUri == null || Intrinsics.areEqual(nsUri, XMLConstants.XML_NS_URI) || Intrinsics.areEqual(nsUri, XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
            String namespace = $this$smartStartTag.getNamespaceContext().getNamespaceURI(prefix == null ? "" : prefix);
            if (namespace == null) {
                namespace = "";
            }
            $this$smartStartTag.startTag(namespace, localName, prefix);
            return prefix == null ? "" : prefix;
        }
        boolean writeNs = false;
        String prefix2 = $this$smartStartTag.getPrefix(nsUri);
        if (prefix2 == null) {
            String it = (prefix == null || (it = $this$smartStartTag.getNamespaceUri(prefix)) == null) ? "" : "";
            if (!Intrinsics.areEqual(nsUri, it)) {
                writeNs = true;
            }
            prefix2 = prefix != null ? prefix : "";
        }
        String usedPrefix = prefix2;
        $this$smartStartTag.startTag(nsUri, localName, usedPrefix);
        if (writeNs) {
            $this$smartStartTag.namespaceAttr(usedPrefix, nsUri);
        }
        return usedPrefix;
    }

    public static final String smartStartTag(XmlWriter $this$smartStartTag, String nsUri, String localName) {
        String smartStartTag$default;
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        smartStartTag$default = smartStartTag$default($this$smartStartTag, nsUri, localName, (String) null, 4, (Object) null);
        return smartStartTag$default;
    }

    public static /* synthetic */ void smartStartTag$default(XmlWriter $this$smartStartTag_u24default, CharSequence nsUri, CharSequence localName, CharSequence prefix, Function1 body, int i, Object obj) {
        if ((i & 4) != 0) {
            prefix = null;
        }
        Intrinsics.checkNotNullParameter($this$smartStartTag_u24default, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        String nsUri$iv = nsUri != null ? nsUri.toString() : null;
        String localName$iv = localName.toString();
        String prefix$iv = prefix != null ? prefix.toString() : null;
        String usedPrefix$iv = XmlWriterUtil.smartStartTag($this$smartStartTag_u24default, nsUri$iv, localName$iv, prefix$iv);
        body.invoke($this$smartStartTag_u24default);
        $this$smartStartTag_u24default.endTag(nsUri$iv, localName$iv, usedPrefix$iv);
    }

    @Deprecated(message = "Use strings", replaceWith = @ReplaceWith(expression = "smartStartTag(nsUri?.toString(), localName.toString(), prefix?.toString(), body)", imports = {}))
    public static final void smartStartTag(XmlWriter $this$smartStartTag, CharSequence nsUri, CharSequence localName, CharSequence prefix, Function1<? super XmlWriter, Unit> body) {
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        String nsUri$iv = nsUri != null ? nsUri.toString() : null;
        String localName$iv = localName.toString();
        String prefix$iv = prefix != null ? prefix.toString() : null;
        String usedPrefix$iv = XmlWriterUtil.smartStartTag($this$smartStartTag, nsUri$iv, localName$iv, prefix$iv);
        body.invoke($this$smartStartTag);
        $this$smartStartTag.endTag(nsUri$iv, localName$iv, usedPrefix$iv);
    }

    public static /* synthetic */ void smartStartTag$default(XmlWriter $this$smartStartTag_u24default, String nsUri, String localName, String prefix, Function1 body, int i, Object obj) {
        if ((i & 4) != 0) {
            prefix = null;
        }
        Intrinsics.checkNotNullParameter($this$smartStartTag_u24default, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        String usedPrefix = XmlWriterUtil.smartStartTag($this$smartStartTag_u24default, nsUri, localName, prefix);
        body.invoke($this$smartStartTag_u24default);
        $this$smartStartTag_u24default.endTag(nsUri, localName, usedPrefix);
    }

    public static final void smartStartTag(XmlWriter $this$smartStartTag, String nsUri, String localName, String prefix, Function1<? super XmlWriter, Unit> body) {
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        String usedPrefix = XmlWriterUtil.smartStartTag($this$smartStartTag, nsUri, localName, prefix);
        body.invoke($this$smartStartTag);
        $this$smartStartTag.endTag(nsUri, localName, usedPrefix);
    }

    public static /* synthetic */ void writeListIfNotEmpty$default(XmlWriter $this$writeListIfNotEmpty_u24default, Iterable iterable, String nsUri, String localName, String prefix, Function2 body, int i, Object obj) {
        if ((i & 8) != 0) {
            prefix = null;
        }
        Intrinsics.checkNotNullParameter($this$writeListIfNotEmpty_u24default, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "iterable");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            XmlWriterUtil.smartStartTag($this$writeListIfNotEmpty_u24default, nsUri, localName, prefix);
            while (it.hasNext()) {
                body.invoke($this$writeListIfNotEmpty_u24default, it.next());
            }
            $this$writeListIfNotEmpty_u24default.endTag(nsUri, localName, prefix);
        }
    }

    public static final <T> void writeListIfNotEmpty(XmlWriter $this$writeListIfNotEmpty, Iterable<? extends T> iterable, String nsUri, String localName, String prefix, Function2<? super XmlWriter, ? super T, Unit> body) {
        Intrinsics.checkNotNullParameter($this$writeListIfNotEmpty, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "iterable");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            XmlWriterUtil.smartStartTag($this$writeListIfNotEmpty, nsUri, localName, prefix);
            while (it.hasNext()) {
                body.invoke($this$writeListIfNotEmpty, (T) it.next());
            }
            $this$writeListIfNotEmpty.endTag(nsUri, localName, prefix);
        }
    }

    @Deprecated(message = "Should be moved to the xmlserializable library", replaceWith = @ReplaceWith(expression = "this.serializeAll(iterable)", imports = {"nl.adaptivity.xmlutil.xmlserializable.serializeAll"}))
    public static final <T extends XmlSerializable> void serializeAll(XmlWriter $this$serializeAll, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter($this$serializeAll, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "iterable");
        for (XmlSerializable element$iv : iterable) {
            XmlSerializable it = element$iv;
            it.serialize($this$serializeAll);
        }
    }

    @Deprecated(message = "Should be moved to the xmlserializable library", replaceWith = @ReplaceWith(expression = "this.serializeAll(iterable)", imports = {"nl.adaptivity.xmlutil.xmlserializable.serializeAll"}))
    public static final <T extends XmlSerializable> void serializeAll(XmlWriter $this$serializeAll, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter($this$serializeAll, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        for (XmlSerializable element$iv : sequence) {
            XmlSerializable it = element$iv;
            it.serialize($this$serializeAll);
        }
    }

    public static /* synthetic */ void startTag$default(XmlWriter $this$startTag_u24default, String nsUri, String localName, String prefix, Function1 body, int i, Object obj) {
        if ((i & 4) != 0) {
            prefix = null;
        }
        Intrinsics.checkNotNullParameter($this$startTag_u24default, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        $this$startTag_u24default.startTag(nsUri, localName, prefix);
        body.invoke($this$startTag_u24default);
        $this$startTag_u24default.endTag(nsUri, localName, prefix);
    }

    public static final void startTag(XmlWriter $this$startTag, String nsUri, String localName, String prefix, Function1<? super XmlWriter, Unit> body) {
        Intrinsics.checkNotNullParameter($this$startTag, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        $this$startTag.startTag(nsUri, localName, prefix);
        body.invoke($this$startTag);
        $this$startTag.endTag(nsUri, localName, prefix);
    }

    public static final void writeSimpleElement(XmlWriter $this$writeSimpleElement, QName qName, String value) {
        Intrinsics.checkNotNullParameter($this$writeSimpleElement, "<this>");
        Intrinsics.checkNotNullParameter(qName, "qName");
        XmlWriterUtil.writeSimpleElement($this$writeSimpleElement, qName.getNamespaceURI(), qName.getLocalPart(), qName.getPrefix(), value);
    }

    public static final void writeSimpleElement(XmlWriter $this$writeSimpleElement, String nsUri, String localName, String prefix, String value) {
        Intrinsics.checkNotNullParameter($this$writeSimpleElement, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        XmlWriterUtil.smartStartTag($this$writeSimpleElement, nsUri, localName, prefix);
        String str = value;
        if (!(str == null || str.length() == 0)) {
            $this$writeSimpleElement.text(value.toString());
        }
        $this$writeSimpleElement.endTag(nsUri, localName, prefix);
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, String value) {
        Intrinsics.checkNotNullParameter($this$writeAttribute, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (value != null) {
            $this$writeAttribute.attribute(null, name, null, value);
        }
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, Object value) {
        Intrinsics.checkNotNullParameter($this$writeAttribute, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (value != null) {
            $this$writeAttribute.attribute(null, name, null, value.toString());
        }
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, QName name, String value) {
        Intrinsics.checkNotNullParameter($this$writeAttribute, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (value != null) {
            if (name.getNamespaceURI().length() == 0) {
                if (name.getPrefix().length() == 0) {
                    $this$writeAttribute.attribute(null, name.getLocalPart(), null, value);
                    return;
                }
            }
            $this$writeAttribute.attribute(name.getNamespaceURI(), name.getLocalPart(), name.getPrefix(), value);
        }
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, double value) {
        Intrinsics.checkNotNullParameter($this$writeAttribute, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!Double.isNaN(value)) {
            XmlWriterUtil.writeAttribute($this$writeAttribute, name, String.valueOf(value));
        }
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, long value) {
        Intrinsics.checkNotNullParameter($this$writeAttribute, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        XmlWriterUtil.writeAttribute($this$writeAttribute, name, String.valueOf(value));
    }

    public static final void writeAttribute(XmlWriter $this$writeAttribute, String name, QName value) {
        String prefix;
        Intrinsics.checkNotNullParameter($this$writeAttribute, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (value != null) {
            if (!(value.getNamespaceURI().length() > 0)) {
                prefix = value.getPrefix();
                String it = $this$writeAttribute.getNamespaceContext().getNamespaceURI(prefix);
                if (it == null) {
                    throw new IllegalArgumentException("Cannot determine namespace of qname");
                }
            } else if (Intrinsics.areEqual(value.getNamespaceURI(), $this$writeAttribute.getNamespaceContext().getNamespaceURI(value.getPrefix()))) {
                prefix = value.getPrefix();
            } else {
                prefix = $this$writeAttribute.getNamespaceContext().getPrefix(value.getNamespaceURI());
                if (prefix == null) {
                    prefix = value.getPrefix();
                    $this$writeAttribute.namespaceAttr(prefix, value.getNamespaceURI());
                }
            }
            $this$writeAttribute.attribute(null, name, null, prefix + AbstractJsonLexerKt.COLON + value.getLocalPart());
        }
    }

    public static final void endTag(XmlWriter $this$endTag, QName predelemname) {
        Intrinsics.checkNotNullParameter($this$endTag, "<this>");
        Intrinsics.checkNotNullParameter(predelemname, "predelemname");
        $this$endTag.endTag(predelemname.getNamespaceURI(), predelemname.getLocalPart(), predelemname.getPrefix());
    }

    public static final XmlWriter filterSubstream(XmlWriter $this$filterSubstream) {
        Intrinsics.checkNotNullParameter($this$filterSubstream, "<this>");
        return new SubstreamFilterWriter($this$filterSubstream);
    }

    public static final void serialize(XmlWriter $this$serialize, Node node) {
        Intrinsics.checkNotNullParameter($this$serialize, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        XmlWriterUtil.serialize($this$serialize, XmlStreaming_jvmKt.getXmlStreaming().newReader(node));
    }

    public static final void writeElement(XmlWriter $this$writeElement, Map<String, String> map, XmlReader reader) {
        Intrinsics.checkNotNullParameter($this$writeElement, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (reader.getEventType() == EventType.END_ELEMENT) {
            throw new IllegalArgumentException("Cannot really validly write an end element here");
        }
        XmlReaderUtil.writeCurrent(reader, $this$writeElement);
        if (reader.getEventType() == EventType.START_ELEMENT) {
            XmlWriterUtil.writeElementContent($this$writeElement, map, reader);
        }
    }

    public static final void writeElementContent(XmlWriter $this$writeElementContent, Map<String, String> map, XmlReader reader) {
        Intrinsics.checkNotNullParameter($this$writeElementContent, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        XmlReader $this$forEach$iv = reader;
        while ($this$forEach$iv.hasNext()) {
            Object element$iv = $this$forEach$iv.next();
            EventType type = (EventType) element$iv;
            if (reader.getEventType() == EventType.START_ELEMENT && map != null) {
                XmlWriterUtil.addUndeclaredNamespaces($this$writeElementContent, reader, map);
            }
            XmlReaderUtil.writeCurrent(reader, $this$writeElementContent);
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 6:
                    XmlWriterUtil.writeElementContent($this$writeElementContent, map, reader);
                    break;
                case 7:
                    return;
            }
        }
    }

    public static final void smartStartTag(XmlWriter $this$smartStartTag, String nsUri, String localName, Function1<? super XmlWriter, Unit> body) {
        Intrinsics.checkNotNullParameter($this$smartStartTag, "<this>");
        Intrinsics.checkNotNullParameter(localName, "localName");
        Intrinsics.checkNotNullParameter(body, "body");
        String usedPrefix$iv = XmlWriterUtil.smartStartTag($this$smartStartTag, nsUri, localName, (String) null);
        body.invoke($this$smartStartTag);
        $this$smartStartTag.endTag(nsUri, localName, usedPrefix$iv);
    }
}