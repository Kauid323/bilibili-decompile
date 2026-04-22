package nl.adaptivity.xmlutil;

import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlEvent;

/* compiled from: QName.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0086\u0004¢\u0006\u0002\u0010\u0005\u001a\u0013\u0010\u000e\u001a\u00020\u000f*\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0010\"\u001a\u0010\u0006\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u001a\u0010\n\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u001a\u0010\f\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\t*;\u0010\u0011\"\u0011`\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\t0\u00142$0\u0002j\u0011`\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\t0\u0014¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\t0\u0014¨\u0006\u0015"}, d2 = {"isEquivalent", "", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "other", "(Ljavax/xml/namespace/QName;Ljavax/xml/namespace/QName;)Z", "prefix", "", "getPrefix", "(Ljavax/xml/namespace/QName;)Ljava/lang/String;", "localPart", "getLocalPart", "namespaceURI", "getNamespaceURI", "toNamespace", "Lnl/adaptivity/xmlutil/Namespace;", "(Ljavax/xml/namespace/QName;)Lnl/adaptivity/xmlutil/Namespace;", "SerializableQName", "Lkotlinx/serialization/Serializable;", "with", "Lnl/adaptivity/xmlutil/QNameSerializer;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class QNameKt {
    public static final boolean isEquivalent(QName $this$isEquivalent, QName other) {
        Intrinsics.checkNotNullParameter($this$isEquivalent, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual($this$isEquivalent.getLocalPart(), other.getLocalPart()) && Intrinsics.areEqual($this$isEquivalent.getNamespaceURI(), other.getNamespaceURI());
    }

    public static final String getPrefix(QName $this$prefix) {
        Intrinsics.checkNotNullParameter($this$prefix, "<this>");
        return $this$prefix.getPrefix();
    }

    public static final String getLocalPart(QName $this$localPart) {
        Intrinsics.checkNotNullParameter($this$localPart, "<this>");
        return $this$localPart.getLocalPart();
    }

    public static final String getNamespaceURI(QName $this$namespaceURI) {
        Intrinsics.checkNotNullParameter($this$namespaceURI, "<this>");
        return $this$namespaceURI.getNamespaceURI();
    }

    public static final Namespace toNamespace(QName $this$toNamespace) {
        Intrinsics.checkNotNullParameter($this$toNamespace, "<this>");
        return new XmlEvent.NamespaceImpl($this$toNamespace.getPrefix(), $this$toNamespace.getNamespaceURI());
    }
}