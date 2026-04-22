package nl.adaptivity.xmlutil;

import javax.xml.namespace.QName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: XmlSerializer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {XMLConstants.XML_NS_PREFIX, "Lnl/adaptivity/xmlutil/XmlSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "xmlDescriptor", "serialQName", "Ljavax/xml/namespace/QName;", "Lnl/adaptivity/xmlutil/QName;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;Ljavax/xml/namespace/QName;)Lnl/adaptivity/xmlutil/XmlSerialDescriptor;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class XmlSerializerKt {
    public static /* synthetic */ XmlSerialDescriptor xml$default(SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, QName qName, int i, Object obj) {
        if ((i & 1) != 0) {
            serialDescriptor2 = serialDescriptor;
        }
        if ((i & 2) != 0) {
            qName = null;
        }
        return xml(serialDescriptor, serialDescriptor2, qName);
    }

    @ExperimentalXmlUtilApi
    public static final XmlSerialDescriptor xml(SerialDescriptor $this$xml, SerialDescriptor xmlDescriptor, QName serialQName) {
        Intrinsics.checkNotNullParameter($this$xml, "<this>");
        Intrinsics.checkNotNullParameter(xmlDescriptor, "xmlDescriptor");
        return new ExtXmlSerialDescriptor($this$xml, xmlDescriptor, serialQName);
    }
}