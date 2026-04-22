package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IDocumentFragment;
import org.w3c.dom.DocumentFragment;

/* compiled from: DocumentFragmentImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/DocumentFragmentImpl;", "Lnl/adaptivity/xmlutil/core/impl/dom/NodeImpl;", "Lorg/w3c/dom/DocumentFragment;", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentFragment;", "delegate", "<init>", "(Lorg/w3c/dom/DocumentFragment;)V", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentFragmentImpl extends NodeImpl<DocumentFragment> implements IDocumentFragment {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFragmentImpl(DocumentFragment delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }
}