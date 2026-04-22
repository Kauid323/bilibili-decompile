package nl.adaptivity.xmlutil;

import kotlin.Metadata;

/* compiled from: XmlSerializer.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class XmlSerialDescriptor$annotationImpl$nl_adaptivity_xmlutil_XmlSerialDescriptorMarker$0 implements XmlSerialDescriptorMarker {
    @Override // java.lang.annotation.Annotation
    public final /* synthetic */ Class annotationType() {
        return XmlSerialDescriptorMarker.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (obj instanceof XmlSerialDescriptorMarker) {
            XmlSerialDescriptorMarker xmlSerialDescriptorMarker = (XmlSerialDescriptorMarker) obj;
            return true;
        }
        return false;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@nl.adaptivity.xmlutil.XmlSerialDescriptorMarker()";
    }
}