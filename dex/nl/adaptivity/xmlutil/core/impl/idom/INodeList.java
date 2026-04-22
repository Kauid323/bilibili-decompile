package nl.adaptivity.xmlutil.core.impl.idom;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import nl.adaptivity.xmlutil.dom2.Node;
import nl.adaptivity.xmlutil.dom2.NodeListIterator;
import org.w3c.dom.NodeList;

/* compiled from: INodeList.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H&J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0096\u0002J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0002J\u0016\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/idom/INodeList;", "Lorg/w3c/dom/NodeList;", "Lnl/adaptivity/xmlutil/dom/NodeList;", "Lnl/adaptivity/xmlutil/dom2/NodeList;", "", "Lnl/adaptivity/xmlutil/dom2/Node;", "getLength", "", "item", "Lnl/adaptivity/xmlutil/core/impl/idom/INode;", "index", "iterator", "", "contains", "", "element", "containsAll", "elements", "isEmpty", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INodeList extends NodeList, nl.adaptivity.xmlutil.dom2.NodeList, Collection<Node>, KMappedMarker {
    boolean contains(Node node);

    boolean containsAll(Collection<?> collection);

    @Override // org.w3c.dom.NodeList, nl.adaptivity.xmlutil.dom2.NodeList
    @Deprecated(message = "Use size", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    int getLength();

    boolean isEmpty();

    @Override // org.w3c.dom.NodeList, nl.adaptivity.xmlutil.dom2.NodeList
    INode item(int i);

    Iterator<INode> iterator();

    /* compiled from: INodeList.kt */
    /* renamed from: nl.adaptivity.xmlutil.core.impl.idom.INodeList$-CC */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static /* bridge */ boolean $default$contains(INodeList _this, Object element) {
            if (element instanceof Node) {
                return _this.contains((Node) element);
            }
            return false;
        }

        public static Iterator $default$iterator(INodeList _this) {
            return new NodeListIterator(_this);
        }

        public static boolean $default$contains(INodeList _this, Node element) {
            Intrinsics.checkNotNullParameter(element, "element");
            return SequencesKt.contains(CollectionsKt.asSequence(_this), element);
        }

        public static boolean $default$containsAll(INodeList _this, Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Collection $this$all$iv = elements;
            if ($this$all$iv.isEmpty()) {
                return true;
            }
            for (Object element$iv : $this$all$iv) {
                Node it = (Node) element$iv;
                if (!_this.contains((Object) it)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean $default$isEmpty(INodeList _this) {
            return _this.size() == 0;
        }
    }
}