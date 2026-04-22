package nl.adaptivity.xmlutil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import nl.adaptivity.xmlutil.IterableNamespaceContext;

/* compiled from: SimpleNamespaceContext.kt */
@XmlUtilInternal
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0017\u0018\u0000 92\u00020\u0001:\u0004789:B\u0019\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u001f\b\u0016\u0012\u0014\u0010\b\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0005\u0010\u000bB)\b\u0016\u0012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0003¢\u0006\u0004\b\u0005\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u0011B\u0017\b\u0016\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0005\u0010\u0014B\u0017\b\u0016\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0004\b\u0005\u0010\u0016B\u0017\b\u0016\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0004\b\u0005\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u001aJ\b\u0010%\u001a\u00020\u0000H\u0016J\u0010\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0007J\u0011\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0086\u0002J\u0014\u0010&\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017J\u0017\u0010(\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017H\u0086\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010+\u001a\u00020\u0004J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040/2\u0006\u0010+\u001a\u00020\u0004H\u0016J\u000e\u0010*\u001a\u00020\u00042\u0006\u00100\u001a\u00020#J\u000e\u0010)\u001a\u00020\u00042\u0006\u00100\u001a\u00020#J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00130/H\u0096\u0002J\u0011\u0010(\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u0001H\u0096\u0002J\u0013\u00103\u001a\u0002042\b\u0010'\u001a\u0004\u0018\u000105H\u0096\u0002J\b\u00106\u001a\u00020#H\u0016R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8G¢\u0006\u0006\u001a\u0004\b\"\u0010$¨\u0006;"}, d2 = {"Lnl/adaptivity/xmlutil/SimpleNamespaceContext;", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "buffer", "", "", "<init>", "([Ljava/lang/String;)V", "()V", "prefixMap", "", "", "(Ljava/util/Map;)V", "prefixes", "namespaces", "([Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)V", "prefix", "namespace", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "Lnl/adaptivity/xmlutil/Namespace;", "(Ljava/util/Collection;)V", "", "(Ljava/util/List;)V", "", "(Ljava/lang/Iterable;)V", "original", "(Lnl/adaptivity/xmlutil/SimpleNamespaceContext;)V", "getBuffer", "()[Ljava/lang/String;", "[Ljava/lang/String;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "size", "", "()I", "freeze", "combine", "other", "plus", "getNamespaceURI", "getPrefix", "namespaceURI", "getPrefixSequence", "Lkotlin/sequences/Sequence;", "getPrefixes", "", "index", "iterator", "secondary", "equals", "", "", "hashCode", "SimpleIterator", "SimpleNamespace", "Companion", "Serializer", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = Serializer.class)
public class SimpleNamespaceContext implements IterableNamespaceContext {
    public static final Companion Companion = new Companion(null);
    private final String[] buffer;

    public SimpleNamespaceContext(String[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
    }

    public final String[] getBuffer() {
        return this.buffer;
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, size());
    }

    public final int size() {
        return this.buffer.length / 2;
    }

    /* compiled from: SimpleNamespaceContext.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002J\t\u0010\t\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lnl/adaptivity/xmlutil/SimpleNamespaceContext$SimpleIterator;", "", "Lnl/adaptivity/xmlutil/Namespace;", "<init>", "(Lnl/adaptivity/xmlutil/SimpleNamespaceContext;)V", "pos", "", "hasNext", "", "next", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private final class SimpleIterator implements Iterator<Namespace>, KMappedMarker {
        private int pos;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public SimpleIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos < SimpleNamespaceContext.this.size();
        }

        @Override // java.util.Iterator
        public Namespace next() {
            SimpleNamespaceContext simpleNamespaceContext = SimpleNamespaceContext.this;
            int i = this.pos;
            this.pos = i + 1;
            return new SimpleNamespace(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SimpleNamespaceContext.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Lnl/adaptivity/xmlutil/SimpleNamespaceContext$SimpleNamespace;", "Lnl/adaptivity/xmlutil/Namespace;", "pos", "", "<init>", "(Lnl/adaptivity/xmlutil/SimpleNamespaceContext;I)V", "prefix", "", "getPrefix", "()Ljava/lang/String;", "namespaceURI", "getNamespaceURI", "hashCode", "equals", "", "other", "", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class SimpleNamespace implements Namespace {
        private final int pos;

        @Override // nl.adaptivity.xmlutil.Namespace
        public /* synthetic */ String component1() {
            return getPrefix();
        }

        @Override // nl.adaptivity.xmlutil.Namespace
        public /* synthetic */ String component2() {
            return getNamespaceURI();
        }

        public SimpleNamespace(int pos) {
            this.pos = pos;
        }

        @Override // nl.adaptivity.xmlutil.Namespace
        public String getPrefix() {
            return SimpleNamespaceContext.this.getPrefix(this.pos);
        }

        @Override // nl.adaptivity.xmlutil.Namespace
        public String getNamespaceURI() {
            return SimpleNamespaceContext.this.getNamespaceURI(this.pos);
        }

        public int hashCode() {
            return (getPrefix().hashCode() * 31) + getNamespaceURI().hashCode();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Namespace) {
                return Intrinsics.areEqual(getPrefix(), ((Namespace) other).getPrefix()) && Intrinsics.areEqual(getNamespaceURI(), ((Namespace) other).getNamespaceURI());
            }
            return false;
        }

        public String toString() {
            return AbstractJsonLexerKt.BEGIN_OBJ + getPrefix() + AbstractJsonLexerKt.COLON + getNamespaceURI() + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public SimpleNamespaceContext() {
        this(new String[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SimpleNamespaceContext(Map<? extends CharSequence, ? extends CharSequence> prefixMap) {
        this(result$iv);
        Intrinsics.checkNotNullParameter(prefixMap, "prefixMap");
        Companion companion = Companion;
        Collection namespaces$iv = prefixMap.entrySet();
        String[] result$iv = new String[namespaces$iv.size() * 2];
        int i$iv = 0;
        for (Map.Entry n$iv : namespaces$iv) {
            int i$iv2 = i$iv + 1;
            Map.Entry $this$_init__u24lambda_u240 = n$iv;
            result$iv[i$iv] = $this$_init__u24lambda_u240.getKey().toString();
            i$iv = i$iv2 + 1;
            Map.Entry $this$_init__u24lambda_u241 = n$iv;
            result$iv[i$iv2] = $this$_init__u24lambda_u241.getValue().toString();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SimpleNamespaceContext(CharSequence[] prefixes, CharSequence[] namespaces) {
        this(r1);
        Intrinsics.checkNotNullParameter(prefixes, "prefixes");
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        int length = prefixes.length * 2;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = (i % 2 == 0 ? prefixes[i / 2] : namespaces[i / 2]).toString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleNamespaceContext(CharSequence prefix, CharSequence namespace) {
        this(new String[]{prefix.toString(), namespace.toString()});
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SimpleNamespaceContext(Collection<? extends Namespace> namespaces) {
        this(result$iv);
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        Companion companion = Companion;
        String[] result$iv = new String[namespaces.size() * 2];
        int i$iv = 0;
        for (Object n$iv : namespaces) {
            int i$iv2 = i$iv + 1;
            Namespace $this$_init__u24lambda_u242 = (Namespace) n$iv;
            result$iv[i$iv] = $this$_init__u24lambda_u242.getPrefix();
            i$iv = i$iv2 + 1;
            Namespace $this$_init__u24lambda_u243 = (Namespace) n$iv;
            result$iv[i$iv2] = $this$_init__u24lambda_u243.getNamespaceURI();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SimpleNamespaceContext(List<? extends Namespace> namespaces) {
        this(r1);
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        int size = namespaces.size() * 2;
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = i % 2 == 0 ? namespaces.get(i / 2).getPrefix() : namespaces.get(i / 2).getNamespaceURI();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SimpleNamespaceContext(Iterable<? extends Namespace> namespaces) {
        this((Collection<? extends Namespace>) (r0 == null ? CollectionsKt.toList(namespaces) : r0));
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        List list = namespaces instanceof Collection ? (Collection) namespaces : null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleNamespaceContext(SimpleNamespaceContext original) {
        this(original.buffer);
        Intrinsics.checkNotNullParameter(original, "original");
    }

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public SimpleNamespaceContext freeze() {
        return this;
    }

    @Deprecated(message = "Use operator", replaceWith = @ReplaceWith(expression = "this + other", imports = {}))
    public final SimpleNamespaceContext combine(SimpleNamespaceContext other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return plus(other);
    }

    public final SimpleNamespaceContext plus(SimpleNamespaceContext other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Map result = new LinkedHashMap();
        IntRange indices = getIndices();
        int first = indices.getFirst();
        int i = indices.getLast();
        if (first <= i) {
            while (true) {
                result.put(getPrefix(i), getNamespaceURI(i));
                if (i == first) {
                    break;
                }
                i--;
            }
        }
        IntRange indices2 = other.getIndices();
        int first2 = indices2.getFirst();
        int i2 = indices2.getLast();
        if (first2 <= i2) {
            while (true) {
                result.put(other.getPrefix(i2), other.getNamespaceURI(i2));
                if (i2 == first2) {
                    break;
                }
                i2--;
            }
        }
        return new SimpleNamespaceContext(result);
    }

    public final SimpleNamespaceContext combine(Iterable<? extends Namespace> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return plus(other);
    }

    public final SimpleNamespaceContext plus(Iterable<? extends Namespace> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (size() == 0) {
            return Companion.from(other);
        }
        if (other instanceof SimpleNamespaceContext) {
            return plus((SimpleNamespaceContext) other);
        }
        if (!other.iterator().hasNext()) {
            return this;
        }
        Map result = new LinkedHashMap();
        IntRange indices = getIndices();
        int first = indices.getFirst();
        int i = indices.getLast();
        if (first <= i) {
            while (true) {
                result.put(getPrefix(i), getNamespaceURI(i));
                if (i == first) {
                    break;
                }
                i--;
            }
        }
        for (Namespace ns : other) {
            result.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return new SimpleNamespaceContext(result);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (Intrinsics.areEqual(prefix, XMLConstants.XML_NS_PREFIX)) {
            return XMLConstants.XML_NS_URI;
        }
        if (Intrinsics.areEqual(prefix, XMLConstants.XMLNS_ATTRIBUTE)) {
            return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
        }
        for (int i = size() - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(getPrefix(i), prefix)) {
                return getNamespaceURI(i);
            }
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        switch (namespaceURI.hashCode()) {
            case 0:
                if (namespaceURI.equals("")) {
                    return "";
                }
                break;
            case 557947472:
                if (namespaceURI.equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
                    return XMLConstants.XMLNS_ATTRIBUTE;
                }
                break;
            case 1952986079:
                if (namespaceURI.equals(XMLConstants.XML_NS_URI)) {
                    return XMLConstants.XML_NS_PREFIX;
                }
                break;
        }
        for (int i = size() - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(getNamespaceURI(i), namespaceURI)) {
                return getPrefix(i);
            }
        }
        return null;
    }

    public final Sequence<String> getPrefixSequence(final String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        switch (namespaceURI.hashCode()) {
            case 0:
                if (namespaceURI.equals("")) {
                    return SequencesKt.sequenceOf((Object[]) new String[]{""});
                }
                break;
            case 557947472:
                if (namespaceURI.equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
                    return SequencesKt.sequenceOf((Object[]) new String[]{XMLConstants.XMLNS_ATTRIBUTE});
                }
                break;
            case 1952986079:
                if (namespaceURI.equals(XMLConstants.XML_NS_URI)) {
                    return SequencesKt.sequenceOf((Object[]) new String[]{XMLConstants.XML_NS_PREFIX});
                }
                break;
        }
        return SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.reversed(getIndices())), new Function1() { // from class: nl.adaptivity.xmlutil.SimpleNamespaceContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean prefixSequence$lambda$4;
                prefixSequence$lambda$4 = SimpleNamespaceContext.getPrefixSequence$lambda$4(SimpleNamespaceContext.this, namespaceURI, ((Integer) obj).intValue());
                return Boolean.valueOf(prefixSequence$lambda$4);
            }
        }), new Function1() { // from class: nl.adaptivity.xmlutil.SimpleNamespaceContext$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String prefix;
                prefix = SimpleNamespaceContext.this.getPrefix(((Integer) obj).intValue());
                return prefix;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getPrefixSequence$lambda$4(SimpleNamespaceContext this$0, String $namespaceURI, int it) {
        return Intrinsics.areEqual(this$0.getNamespaceURI(it), $namespaceURI);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        return getPrefixSequence(namespaceURI).iterator();
    }

    public final String getPrefix(int index) {
        try {
            return this.buffer[index * 2];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    public final String getNamespaceURI(int index) {
        try {
            return this.buffer[(index * 2) + 1];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Namespace> iterator() {
        return new SimpleIterator();
    }

    @Override // nl.adaptivity.xmlutil.IterableNamespaceContext
    public IterableNamespaceContext plus(IterableNamespaceContext secondary) {
        Intrinsics.checkNotNullParameter(secondary, "secondary");
        return ((secondary instanceof SimpleNamespaceContext) && ((SimpleNamespaceContext) secondary).size() == 0) ? this : ((secondary instanceof SimpleNamespaceContext) && size() == 0) ? secondary : IterableNamespaceContext.CC.$default$plus(this, secondary);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SimpleNamespaceContext) && Arrays.equals(this.buffer, ((SimpleNamespaceContext) other).buffer);
    }

    public int hashCode() {
        return Arrays.hashCode(this.buffer);
    }

    /* compiled from: SimpleNamespaceContext.kt */
    @XmlUtilInternal
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J^\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e2\u0019\b\u0004\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\b\u00112\u0019\b\u0004\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\b\u0011H\u0082\b¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015¨\u0006\u0016"}, d2 = {"Lnl/adaptivity/xmlutil/SimpleNamespaceContext$Companion;", "", "<init>", "()V", "from", "Lnl/adaptivity/xmlutil/SimpleNamespaceContext;", "originalNSContext", "", "Lnl/adaptivity/xmlutil/Namespace;", "flatten", "", "", "T", "namespaces", "", "prefix", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "namespace", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)[Ljava/lang/String;", "serializer", "Lkotlinx/serialization/KSerializer;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SimpleNamespaceContext> serializer() {
            return new Serializer();
        }

        public final SimpleNamespaceContext from(Iterable<? extends Namespace> originalNSContext) {
            Intrinsics.checkNotNullParameter(originalNSContext, "originalNSContext");
            return originalNSContext instanceof SimpleNamespaceContext ? (SimpleNamespaceContext) originalNSContext : new SimpleNamespaceContext(originalNSContext);
        }

        private final <T> String[] flatten(Collection<? extends T> collection, Function1<? super T, String> function1, Function1<? super T, String> function12) {
            String[] result = new String[collection.size() * 2];
            int i = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                Object n = (T) it.next();
                int i2 = i + 1;
                result[i] = function1.invoke(n);
                i = i2 + 1;
                result[i2] = function12.invoke(n);
            }
            return result;
        }
    }

    /* compiled from: SimpleNamespaceContext.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lnl/adaptivity/xmlutil/SimpleNamespaceContext$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lnl/adaptivity/xmlutil/SimpleNamespaceContext;", "<init>", "()V", "actualSerializer", "", "Lnl/adaptivity/xmlutil/Namespace;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Serializer implements KSerializer<SimpleNamespaceContext> {
        private final KSerializer<List<Namespace>> actualSerializer = BuiltinSerializersKt.ListSerializer(Namespace.Companion);
        private final SerialDescriptor descriptor = SerialDescriptorsKt.SerialDescriptor("nl.adaptivity.xmlutil.SimpleNamespaceContext", this.actualSerializer.getDescriptor());

        public static /* synthetic */ void getDescriptor$annotations() {
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return this.descriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public SimpleNamespaceContext deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            return new SimpleNamespaceContext((List<? extends Namespace>) this.actualSerializer.deserialize(decoder));
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, SimpleNamespaceContext value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            this.actualSerializer.serialize(encoder, CollectionsKt.toList(value));
        }
    }
}