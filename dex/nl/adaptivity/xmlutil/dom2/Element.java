package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Element.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \"2\u00020\u0001:\u0001\"J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0003H&J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&J\"\u0010\u0011\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\u0003H&J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u0019H&J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u0019H&J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H&J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\n\u001a\u00020\u0003H&J\u001a\u0010!\u001a\u00020 2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/Element;", "Lnl/adaptivity/xmlutil/dom2/Node;", "getNamespaceURI", "", "getPrefix", "getLocalName", "getTagName", "getAttributes", "Lnl/adaptivity/xmlutil/dom2/NamedNodeMap;", "getAttribute", "qualifiedName", "getAttributeNS", "namespace", "localName", "setAttribute", "", "value", "setAttributeNS", "cName", "removeAttribute", "removeAttributeNS", "hasAttribute", "", "hasAttributeNS", "getAttributeNode", "Lnl/adaptivity/xmlutil/dom2/Attr;", "getAttributeNodeNS", "setAttributeNode", "attr", "setAttributeNodeNS", "removeAttributeNode", "getElementsByTagName", "Lnl/adaptivity/xmlutil/dom2/NodeList;", "getElementsByTagNameNS", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = ElementSerializer.class)
public interface Element extends Node {
    public static final Companion Companion = Companion.$$INSTANCE;

    String getAttribute(String str);

    String getAttributeNS(String str, String str2);

    Attr getAttributeNode(String str);

    Attr getAttributeNodeNS(String str, String str2);

    NamedNodeMap getAttributes();

    NodeList getElementsByTagName(String str);

    NodeList getElementsByTagNameNS(String str, String str2);

    String getLocalName();

    String getNamespaceURI();

    String getPrefix();

    String getTagName();

    boolean hasAttribute(String str);

    boolean hasAttributeNS(String str, String str2);

    void removeAttribute(String str);

    void removeAttributeNS(String str, String str2);

    Attr removeAttributeNode(Attr attr);

    void setAttribute(String str, String str2);

    void setAttributeNS(String str, String str2, String str3);

    Attr setAttributeNode(Attr attr);

    Attr setAttributeNodeNS(Attr attr);

    /* compiled from: Element.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/Element$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnl/adaptivity/xmlutil/dom2/Element;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<Element> serializer() {
            return ElementSerializer.INSTANCE;
        }
    }
}