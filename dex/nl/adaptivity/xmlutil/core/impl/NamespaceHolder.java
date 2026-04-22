package nl.adaptivity.xmlutil.core.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.XMLConstants;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.XmlUtilInternal;

/* compiled from: NamespaceHolder.kt */
@XmlUtilInternal
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u001a\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0006H\u0002J\u001a\u0010$\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0006\u0010&\u001a\u00020\u0016J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0002J\u0014\u0010)\u001a\u00020\u00162\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010'\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\"2\b\u0010,\u001a\u0004\u0018\u00010\"J\b\u0010-\u001a\u00020\u0016H\u0002J\u0010\u00102\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\"J\u0010\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020\"J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204H\u0096\u0002J\u0006\u00105\u001a\u00020\tJ\u0010\u00106\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00067"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/NamespaceHolder;", "", "Lnl/adaptivity/xmlutil/Namespace;", "<init>", "()V", "nextAutoPrefixNo", "", "nameSpaces", "", "", "[Ljava/lang/String;", "namespaceCounts", "", "value", "depth", "getDepth", "()I", "namespacesAtCurrentDepth", "", "getNamespacesAtCurrentDepth", "()Ljava/util/List;", "incDepth", "", "namespaceIndicesAt", "Lkotlin/ranges/IntRange;", "decDepth", "totalNamespaceCount", "getTotalNamespaceCount", "arrayUseAtDepth", "prefixArrayPos", "pairPos", "nsArrayPos", "setPrefix", "pos", "", "getPrefix", "setNamespace", "getNamespace", "clear", "addPrefixToContext", "ns", "addPrefixesToContext", "namespaces", "prefix", "namespaceUri", "enlargeNamespaceBuffer", "namespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceUri", "iterator", "", "nextAutoPrefix", "namespaceAtCurrentDepth", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NamespaceHolder implements Iterable<Namespace>, KMappedMarker {
    private int depth;
    private int nextAutoPrefixNo = 1;
    private String[] nameSpaces = new String[10];
    private int[] namespaceCounts = new int[20];
    private final IterableNamespaceContext namespaceContext = new NamespaceHolder$namespaceContext$1(this);

    public final int getDepth() {
        return this.depth;
    }

    public final List<Namespace> getNamespacesAtCurrentDepth() {
        int startIdx = this.depth == 0 ? 0 : arrayUseAtDepth(this.depth - 1) >> 1;
        int endIdx = arrayUseAtDepth(this.depth) >> 1;
        int i = endIdx - startIdx;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int offset = i2;
            int i3 = startIdx + offset;
            arrayList.add(new XmlEvent.NamespaceImpl(getPrefix(i3), getNamespace(i3)));
        }
        return arrayList;
    }

    public final void incDepth() {
        this.depth++;
        if (this.depth >= this.namespaceCounts.length) {
            int[] copyOf = Arrays.copyOf(this.namespaceCounts, this.namespaceCounts.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.namespaceCounts = copyOf;
        }
        this.namespaceCounts[this.depth] = this.depth == 0 ? 0 : this.namespaceCounts[this.depth - 1];
    }

    private final IntRange namespaceIndicesAt(int depth) {
        int startIdx = depth == 0 ? 0 : arrayUseAtDepth(depth - 1) / 2;
        int endIdx = arrayUseAtDepth(depth) / 2;
        return RangesKt.until(startIdx, endIdx);
    }

    public final void decDepth() {
        IntRange namespaceIndicesAt = namespaceIndicesAt(this.depth);
        int i = namespaceIndicesAt.getFirst();
        int last = namespaceIndicesAt.getLast();
        if (i <= last) {
            while (true) {
                this.nameSpaces[prefixArrayPos(i)] = null;
                this.nameSpaces[nsArrayPos(i)] = null;
                if (i == last) {
                    break;
                }
                i++;
            }
        }
        this.namespaceCounts[this.depth] = 0;
        this.depth--;
    }

    public final int getTotalNamespaceCount() {
        return this.namespaceCounts[this.depth];
    }

    private final int arrayUseAtDepth(int depth) {
        return this.namespaceCounts[depth] * 2;
    }

    private final int prefixArrayPos(int pairPos) {
        return pairPos * 2;
    }

    private final int nsArrayPos(int pairPos) {
        return (pairPos * 2) + 1;
    }

    private final void setPrefix(int pos, CharSequence value) {
        this.nameSpaces[prefixArrayPos(pos)] = (value == null || (r2 = value.toString()) == null) ? "" : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPrefix(int pos) {
        String str = this.nameSpaces[prefixArrayPos(pos)];
        Intrinsics.checkNotNull(str);
        return str;
    }

    private final void setNamespace(int pos, CharSequence value) {
        this.nameSpaces[nsArrayPos(pos)] = (value == null || (r2 = value.toString()) == null) ? "" : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getNamespace(int pos) {
        String str = this.nameSpaces[nsArrayPos(pos)];
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final void clear() {
        this.nameSpaces = new String[10];
        this.namespaceCounts = new int[20];
        this.depth = 0;
    }

    public final void addPrefixToContext(Namespace ns) {
        Intrinsics.checkNotNullParameter(ns, "ns");
        addPrefixToContext(ns.getPrefix(), ns.getNamespaceURI());
    }

    public final void addPrefixesToContext(Iterable<? extends Namespace> namespaces) {
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        Iterator iter = namespaces.iterator();
        if (iter.hasNext()) {
            int prevCounts = this.depth >= 1 ? this.namespaceCounts[this.depth - 1] : 0;
            if (prevCounts != 0) {
                while (iter.hasNext()) {
                    addPrefixToContext(iter.next());
                }
                return;
            }
            int nextIdx = this.namespaceCounts[this.depth] * 2;
            if (namespaces instanceof Collection) {
                while ((((Collection) namespaces).size() * 2) + nextIdx >= this.nameSpaces.length) {
                    enlargeNamespaceBuffer();
                }
                while (iter.hasNext()) {
                    Namespace n = iter.next();
                    int nextIdx2 = nextIdx + 1;
                    this.nameSpaces[nextIdx] = n.getPrefix();
                    this.nameSpaces[nextIdx2] = n.getNamespaceURI();
                    nextIdx = nextIdx2 + 1;
                }
            } else {
                while (iter.hasNext()) {
                    Namespace n2 = iter.next();
                    if (nextIdx + 2 >= this.nameSpaces.length) {
                        enlargeNamespaceBuffer();
                    }
                    int nextIdx3 = nextIdx + 1;
                    this.nameSpaces[nextIdx] = n2.getPrefix();
                    this.nameSpaces[nextIdx3] = n2.getNamespaceURI();
                    nextIdx = nextIdx3 + 1;
                }
            }
            this.namespaceCounts[this.depth] = nextIdx / 2;
        }
    }

    public final void addPrefixToContext(CharSequence prefix, CharSequence namespaceUri) {
        int prevCounts = this.depth >= 1 ? this.namespaceCounts[this.depth - 1] : 0;
        int i = this.namespaceCounts[this.depth];
        for (int i2 = prevCounts; i2 < i; i2++) {
            if (Intrinsics.areEqual(getPrefix(i2), prefix) && Intrinsics.areEqual(getNamespace(i2), namespaceUri)) {
                return;
            }
        }
        int nextPair = this.namespaceCounts[this.depth];
        if (nsArrayPos(nextPair) >= this.nameSpaces.length) {
            enlargeNamespaceBuffer();
        }
        setPrefix(nextPair, prefix);
        setNamespace(nextPair, namespaceUri);
        int[] iArr = this.namespaceCounts;
        int i3 = this.depth;
        iArr[i3] = iArr[i3] + 1;
    }

    private final void enlargeNamespaceBuffer() {
        Object[] copyOf = Arrays.copyOf(this.nameSpaces, this.nameSpaces.length * 2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.nameSpaces = (String[]) copyOf;
    }

    public final IterableNamespaceContext getNamespaceContext() {
        return this.namespaceContext;
    }

    public final String getNamespaceUri(CharSequence prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        String prefixStr = prefix.toString();
        int nsIdx = getTotalNamespaceCount();
        do {
            nsIdx--;
            if (nsIdx < 0) {
                switch (prefixStr.hashCode()) {
                    case 0:
                        if (prefixStr.equals("")) {
                            return "";
                        }
                        break;
                    case 118807:
                        if (prefixStr.equals(XMLConstants.XML_NS_PREFIX)) {
                            return XMLConstants.XML_NS_URI;
                        }
                        break;
                    case 114177052:
                        if (prefixStr.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
                            return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
                        }
                        break;
                }
                return null;
            }
        } while (!Intrinsics.areEqual(prefixStr, getPrefix(nsIdx)));
        return getNamespace(nsIdx);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0101 A[LOOP:1: B:34:0x0097->B:56:0x0101, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getPrefix(CharSequence namespaceUri) {
        Object element$iv;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        String namespaceUriStr = namespaceUri.toString();
        boolean z3 = false;
        boolean z4 = true;
        switch (namespaceUriStr.hashCode()) {
            case 0:
                if (namespaceUriStr.equals("")) {
                    Iterable $this$none$iv = RangesKt.until(0, getTotalNamespaceCount());
                    if (($this$none$iv instanceof Collection) && ((Collection) $this$none$iv).isEmpty()) {
                        z3 = true;
                    } else {
                        Iterator<Integer> it = $this$none$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                int element$iv2 = ((IntIterator) it).nextInt();
                                if (getPrefix(element$iv2).length() == 0) {
                                    z2 = true;
                                    continue;
                                } else {
                                    z2 = false;
                                    continue;
                                }
                                if (z2) {
                                }
                            } else {
                                z3 = true;
                            }
                        }
                    }
                    if (z3) {
                        return "";
                    }
                    return null;
                }
                break;
            case 557947472:
                if (namespaceUriStr.equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
                    return XMLConstants.XMLNS_ATTRIBUTE;
                }
                break;
            case 1952986079:
                if (namespaceUriStr.equals(XMLConstants.XML_NS_URI)) {
                    return XMLConstants.XML_NS_PREFIX;
                }
                break;
        }
        Iterable $this$firstOrNull$iv = RangesKt.downTo(getTotalNamespaceCount() - 1, 0);
        Iterator<Integer> it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it2.hasNext()) {
                element$iv = it2.next();
                int i = ((Number) element$iv).intValue();
                if (Intrinsics.areEqual(getNamespace(i), namespaceUriStr)) {
                    Iterable $this$none$iv2 = RangesKt.until(i + 1, getTotalNamespaceCount());
                    if (!($this$none$iv2 instanceof Collection) || !((Collection) $this$none$iv2).isEmpty()) {
                        Iterator<Integer> it3 = $this$none$iv2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                int element$iv3 = ((IntIterator) it3).nextInt();
                                if (Intrinsics.areEqual(getPrefix(i), getPrefix(element$iv3))) {
                                    z4 = false;
                                }
                            } else {
                                z4 = true;
                            }
                        }
                    }
                    if (z4) {
                        z = true;
                        if (z) {
                            z4 = true;
                        }
                    }
                }
                z = false;
                if (z) {
                }
            } else {
                element$iv = null;
            }
        }
        Integer num = (Integer) element$iv;
        if (num != null) {
            int it4 = num.intValue();
            return getPrefix(it4);
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<Namespace> iterator() {
        return new NamespaceHolder$iterator$1(this);
    }

    public final String nextAutoPrefix() {
        String prefix;
        do {
            prefix = new StringBuilder().append('n').append(this.nextAutoPrefixNo).toString();
        } while (getNamespaceUri(prefix) != null);
        return prefix;
    }

    public final String namespaceAtCurrentDepth(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        IntRange namespaceIndicesAt = namespaceIndicesAt(this.depth);
        int first = namespaceIndicesAt.getFirst();
        int i = first;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(first, namespaceIndicesAt.getLast(), 2);
        if (i <= progressionLastElement) {
            while (!Intrinsics.areEqual(this.nameSpaces[prefixArrayPos(i)], prefix)) {
                if (i == progressionLastElement) {
                    return null;
                }
                i += 2;
            }
            return this.nameSpaces[nsArrayPos(i)];
        }
        return null;
    }
}