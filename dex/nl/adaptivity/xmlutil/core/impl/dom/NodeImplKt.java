package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IAttr;
import nl.adaptivity.xmlutil.core.impl.idom.IDocument;
import nl.adaptivity.xmlutil.core.impl.idom.IDocumentType;
import nl.adaptivity.xmlutil.core.impl.idom.IElement;
import nl.adaptivity.xmlutil.core.impl.idom.INode;
import nl.adaptivity.xmlutil.core.impl.idom.IText;
import nl.adaptivity.xmlutil.dom2.NodeType;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* compiled from: NodeImpl.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0000\u001a\f\u0010\u0006\u001a\u00020\t*\u00020\nH\u0000\u001a\f\u0010\u0006\u001a\u00020\u000b*\u00020\fH\u0000\u001a\f\u0010\u0006\u001a\u00020\r*\u00020\u000eH\u0000\u001a\f\u0010\u0006\u001a\u00020\u000f*\u00020\u0003H\u0000¨\u0006\u0010"}, d2 = {"unWrap", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "Lorg/w3c/dom/Attr;", "Lnl/adaptivity/xmlutil/dom2/Attr;", "Lnl/adaptivity/xmlutil/dom2/Node;", "wrap", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocument;", "Lorg/w3c/dom/Document;", "Lnl/adaptivity/xmlutil/core/impl/idom/IElement;", "Lorg/w3c/dom/Element;", "Lnl/adaptivity/xmlutil/core/impl/idom/IText;", "Lorg/w3c/dom/Text;", "Lnl/adaptivity/xmlutil/core/impl/idom/IDocumentType;", "Lorg/w3c/dom/DocumentType;", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NodeImplKt {
    public static final Node unWrap(INode $this$unWrap) {
        Intrinsics.checkNotNullParameter($this$unWrap, "<this>");
        return $this$unWrap.getDelegate();
    }

    public static final Node unWrap(Node $this$unWrap) {
        Intrinsics.checkNotNullParameter($this$unWrap, "<this>");
        return $this$unWrap instanceof INode ? ((INode) $this$unWrap).getDelegate() : $this$unWrap;
    }

    public static final Attr unWrap(Attr $this$unWrap) {
        Intrinsics.checkNotNullParameter($this$unWrap, "<this>");
        if ($this$unWrap instanceof IAttr) {
            Node delegate = ((IAttr) $this$unWrap).getDelegate();
            Intrinsics.checkNotNull(delegate, "null cannot be cast to non-null type org.w3c.dom.Attr");
            return (Attr) delegate;
        }
        return $this$unWrap;
    }

    public static final Attr unWrap(nl.adaptivity.xmlutil.dom2.Attr $this$unWrap) {
        Intrinsics.checkNotNullParameter($this$unWrap, "<this>");
        if ($this$unWrap instanceof IAttr) {
            Node delegate = ((IAttr) $this$unWrap).getDelegate();
            Intrinsics.checkNotNull(delegate, "null cannot be cast to non-null type org.w3c.dom.Attr");
            return (Attr) delegate;
        } else if ($this$unWrap instanceof Attr) {
            return (Attr) $this$unWrap;
        } else {
            throw new IllegalArgumentException("Attribute can not be resolved");
        }
    }

    public static final Node unWrap(nl.adaptivity.xmlutil.dom2.Node $this$unWrap) {
        Intrinsics.checkNotNullParameter($this$unWrap, "<this>");
        return $this$unWrap instanceof INode ? ((INode) $this$unWrap).getDelegate() : wrap($this$unWrap);
    }

    public static final INode wrap(Node $this$wrap) {
        Intrinsics.checkNotNullParameter($this$wrap, "<this>");
        if ($this$wrap instanceof INode) {
            return (INode) $this$wrap;
        }
        if ($this$wrap instanceof Attr) {
            return new AttrImpl((Attr) $this$wrap);
        }
        if ($this$wrap instanceof CDATASection) {
            return new CDATASectionImpl((CDATASection) $this$wrap);
        }
        if ($this$wrap instanceof Comment) {
            return new CommentImpl((Comment) $this$wrap);
        }
        if ($this$wrap instanceof Document) {
            return new DocumentImpl((Document) $this$wrap);
        }
        if ($this$wrap instanceof DocumentFragment) {
            return new DocumentFragmentImpl((DocumentFragment) $this$wrap);
        }
        if ($this$wrap instanceof DocumentType) {
            return new DocumentTypeImpl((DocumentType) $this$wrap);
        }
        if ($this$wrap instanceof Element) {
            return new ElementImpl((Element) $this$wrap);
        }
        if ($this$wrap instanceof ProcessingInstruction) {
            return new ProcessingInstructionImpl((ProcessingInstruction) $this$wrap);
        }
        if ($this$wrap instanceof Text) {
            return new TextImpl((Text) $this$wrap);
        }
        throw new IllegalStateException(("Node type " + NodeType.Companion.invoke($this$wrap.getNodeType()) + " not supported").toString());
    }

    public static final INode wrap(nl.adaptivity.xmlutil.dom2.Node $this$wrap) {
        Intrinsics.checkNotNullParameter($this$wrap, "<this>");
        if ($this$wrap instanceof INode) {
            return (INode) $this$wrap;
        }
        throw new IllegalStateException(("Node type " + $this$wrap.getNodetype() + " not supported").toString());
    }

    public static final IDocument wrap(Document $this$wrap) {
        Intrinsics.checkNotNullParameter($this$wrap, "<this>");
        return $this$wrap instanceof IDocument ? (IDocument) $this$wrap : new DocumentImpl($this$wrap);
    }

    public static final IElement wrap(Element $this$wrap) {
        Intrinsics.checkNotNullParameter($this$wrap, "<this>");
        return $this$wrap instanceof IElement ? (IElement) $this$wrap : new ElementImpl($this$wrap);
    }

    public static final IText wrap(Text $this$wrap) {
        Intrinsics.checkNotNullParameter($this$wrap, "<this>");
        return $this$wrap instanceof IText ? (IText) $this$wrap : new TextImpl($this$wrap);
    }

    public static final IDocumentType wrap(DocumentType $this$wrap) {
        Intrinsics.checkNotNullParameter($this$wrap, "<this>");
        return $this$wrap instanceof IDocumentType ? (IDocumentType) $this$wrap : new DocumentTypeImpl($this$wrap);
    }

    public static final IAttr wrap(Attr $this$wrap) {
        Intrinsics.checkNotNullParameter($this$wrap, "<this>");
        return $this$wrap instanceof IAttr ? (IAttr) $this$wrap : new AttrImpl($this$wrap);
    }
}