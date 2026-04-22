package nl.adaptivity.xmlutil.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

/* compiled from: DOMImplementation.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0003j\u0002`\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"createDocument", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/dom/Document;", "Lorg/w3c/dom/DOMImplementation;", "Lnl/adaptivity/xmlutil/dom/DOMImplementation;", "namespace", "", "qualifiedName", "(Lorg/w3c/dom/DOMImplementation;Ljava/lang/String;Ljava/lang/String;)Lorg/w3c/dom/Document;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DOMImplementationKt {
    public static final Document createDocument(DOMImplementation $this$createDocument, String namespace, String qualifiedName) {
        Intrinsics.checkNotNullParameter($this$createDocument, "<this>");
        Intrinsics.checkNotNullParameter(qualifiedName, "qualifiedName");
        return $this$createDocument.createDocument(namespace, qualifiedName, null);
    }
}