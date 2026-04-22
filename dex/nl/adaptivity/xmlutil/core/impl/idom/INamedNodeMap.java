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
import nl.adaptivity.xmlutil.dom2.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: INamedNodeMap.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H&J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0011H&J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0005H&J\u0016\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H&J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0005H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0011H&J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001dH¦\u0002J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0096\u0002J\u0016\u0010!\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010#\u001a\u00020\u001fH\u0016R\u0012\u0010\b\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/idom/INamedNodeMap;", "Lorg/w3c/dom/NamedNodeMap;", "Lnl/adaptivity/xmlutil/dom/NamedNodeMap;", "Lnl/adaptivity/xmlutil/dom2/NamedNodeMap;", "", "Lnl/adaptivity/xmlutil/dom2/Attr;", "getLength", "", "size", "getSize", "()I", "item", "Lnl/adaptivity/xmlutil/core/impl/idom/IAttr;", "index", "get", "getNamedItem", "qualifiedName", "", "getNamedItemNS", "namespace", "localName", "setNamedItem", "attr", "Lorg/w3c/dom/Node;", "Lnl/adaptivity/xmlutil/dom/Node;", "setNamedItemNS", "removeNamedItem", "removeNamedItemNS", "iterator", "", "contains", "", "element", "containsAll", "elements", "isEmpty", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INamedNodeMap extends NamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap, Collection<Attr>, KMappedMarker {
    boolean contains(Attr attr);

    boolean containsAll(Collection<?> collection);

    IAttr get(int i);

    @Override // org.w3c.dom.NamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap
    @Deprecated(message = "Use size instead", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    int getLength();

    @Override // org.w3c.dom.NamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap
    IAttr getNamedItem(String str);

    @Override // org.w3c.dom.NamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap
    IAttr getNamedItemNS(String str, String str2);

    int getSize();

    boolean isEmpty();

    @Override // org.w3c.dom.NamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap
    IAttr item(int i);

    Iterator<IAttr> iterator();

    @Override // org.w3c.dom.NamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap
    IAttr removeNamedItem(String str);

    @Override // org.w3c.dom.NamedNodeMap, nl.adaptivity.xmlutil.dom2.NamedNodeMap
    IAttr removeNamedItemNS(String str, String str2);

    IAttr setNamedItem(Attr attr);

    @Override // org.w3c.dom.NamedNodeMap
    IAttr setNamedItem(Node node);

    IAttr setNamedItemNS(Attr attr);

    @Override // org.w3c.dom.NamedNodeMap
    IAttr setNamedItemNS(Node node);

    /* compiled from: INamedNodeMap.kt */
    /* renamed from: nl.adaptivity.xmlutil.core.impl.idom.INamedNodeMap$-CC */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static /* bridge */ boolean $default$contains(INamedNodeMap _this, Object element) {
            if (element instanceof Attr) {
                return _this.contains((Attr) element);
            }
            return false;
        }

        /* renamed from: $default$get */
        public static /* bridge */ /* synthetic */ Attr m1624$default$get(INamedNodeMap _this, int index) {
            return _this.get(index);
        }

        @Deprecated(message = "Use size instead", replaceWith = @ReplaceWith(expression = "size", imports = {}))
        public static int $default$getLength(INamedNodeMap _this) {
            return _this.size();
        }

        public static IAttr $default$get(INamedNodeMap _this, int index) {
            return _this.item(index);
        }

        public static boolean $default$contains(INamedNodeMap _this, Attr element) {
            Intrinsics.checkNotNullParameter(element, "element");
            return SequencesKt.contains(CollectionsKt.asSequence(_this), element);
        }

        public static boolean $default$containsAll(INamedNodeMap _this, Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Collection $this$all$iv = elements;
            if ($this$all$iv.isEmpty()) {
                return true;
            }
            for (Object element$iv : $this$all$iv) {
                Attr it = (Attr) element$iv;
                if (!_this.contains((Object) it)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean $default$isEmpty(INamedNodeMap _this) {
            return _this.size() == 0;
        }
    }
}