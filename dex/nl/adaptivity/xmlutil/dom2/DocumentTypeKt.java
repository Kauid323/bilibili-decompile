package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentType.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"name", "", "Lnl/adaptivity/xmlutil/dom2/DocumentType;", "getName", "(Lnl/adaptivity/xmlutil/dom2/DocumentType;)Ljava/lang/String;", "publicId", "getPublicId", "systemId", "getSystemId", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DocumentTypeKt {
    public static final String getName(DocumentType $this$name) {
        Intrinsics.checkNotNullParameter($this$name, "<this>");
        return $this$name.getName();
    }

    public static final String getPublicId(DocumentType $this$publicId) {
        Intrinsics.checkNotNullParameter($this$publicId, "<this>");
        return $this$publicId.getPublicId();
    }

    public static final String getSystemId(DocumentType $this$systemId) {
        Intrinsics.checkNotNullParameter($this$systemId, "<this>");
        return $this$systemId.getSystemId();
    }
}