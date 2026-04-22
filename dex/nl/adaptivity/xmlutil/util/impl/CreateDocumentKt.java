package nl.adaptivity.xmlutil.util.impl;

import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlStreaming_jvmKt;
import nl.adaptivity.xmlutil.XmlUtil;
import nl.adaptivity.xmlutil.XmlUtilInternal;
import nl.adaptivity.xmlutil.dom2.Document;

/* compiled from: createDocument.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"createDocument", "Lnl/adaptivity/xmlutil/dom2/Document;", "rootElementName", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "(Ljavax/xml/namespace/QName;)Lnl/adaptivity/xmlutil/dom2/Document;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CreateDocumentKt {
    @XmlUtilInternal
    public static final Document createDocument(QName rootElementName) {
        Intrinsics.checkNotNullParameter(rootElementName, "rootElementName");
        return XmlStreaming_jvmKt.getXmlStreaming().getGenericDomImplementation().createDocument(rootElementName.getNamespaceURI(), XmlUtil.toCName(rootElementName), null);
    }
}