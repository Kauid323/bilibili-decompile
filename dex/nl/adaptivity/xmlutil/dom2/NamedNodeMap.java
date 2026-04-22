package nl.adaptivity.xmlutil.dom2;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: NamedNodeMap.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010(\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH&J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0096\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/NamedNodeMap;", "", "Lnl/adaptivity/xmlutil/dom2/Attr;", "getLength", "", "item", "index", "get", "getNamedItem", "qualifiedName", "", "getNamedItemNS", "namespace", "localName", "setNamedItem", "attr", "setNamedItemNS", "removeNamedItem", "removeNamedItemNS", "iterator", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface NamedNodeMap extends Iterable<Attr>, KMappedMarker {
    Attr get(int i);

    int getLength();

    Attr getNamedItem(String str);

    Attr getNamedItemNS(String str, String str2);

    Attr item(int i);

    @Override // java.lang.Iterable, java.util.Collection
    Iterator<Attr> iterator();

    Attr removeNamedItem(String str);

    Attr removeNamedItemNS(String str, String str2);

    Attr setNamedItem(Attr attr);

    Attr setNamedItemNS(Attr attr);

    /* compiled from: NamedNodeMap.kt */
    /* renamed from: nl.adaptivity.xmlutil.dom2.NamedNodeMap$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static Iterator $default$iterator(NamedNodeMap _this) {
            return new NamedNodeMapIterator(_this);
        }
    }
}