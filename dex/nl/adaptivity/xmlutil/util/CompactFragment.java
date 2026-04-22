package nl.adaptivity.xmlutil.util;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.SimpleNamespaceContext;
import nl.adaptivity.xmlutil.XmlDeserializerFactory;
import nl.adaptivity.xmlutil.XmlException;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlReaderUtil;
import nl.adaptivity.xmlutil.XmlUtilInternal;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.XmlWriterUtil;

/* compiled from: CompactFragment.jvm.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002%&B!\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\fB\u001f\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0013\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\"\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lnl/adaptivity/xmlutil/util/CompactFragment;", "Lnl/adaptivity/xmlutil/util/ICompactFragment;", "namespaces", "", "Lnl/adaptivity/xmlutil/Namespace;", "content", "", "<init>", "(Ljava/lang/Iterable;[C)V", "", "(Ljava/lang/String;)V", "orig", "(Lnl/adaptivity/xmlutil/util/ICompactFragment;)V", "(Ljava/lang/Iterable;Ljava/lang/String;)V", "isEmpty", "", "()Z", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaces", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getContent", "()[C", "serialize", "", "out", "Lnl/adaptivity/xmlutil/XmlWriter;", "getXmlReader", "Lnl/adaptivity/xmlutil/XmlReader;", "equals", "other", "", "hashCode", "", "toString", "contentString", "getContentString", "()Ljava/lang/String;", "Factory", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = CompactFragmentSerializer.class)
public final class CompactFragment implements ICompactFragment {
    public static final Companion Companion = new Companion(null);
    private static final XmlDeserializerFactory<CompactFragment> FACTORY = new Factory();
    private final transient char[] content;
    private final IterableNamespaceContext namespaces;

    /* compiled from: CompactFragment.jvm.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lnl/adaptivity/xmlutil/util/CompactFragment$Factory;", "Lnl/adaptivity/xmlutil/XmlDeserializerFactory;", "Lnl/adaptivity/xmlutil/util/CompactFragment;", "<init>", "()V", "deserialize", "reader", "Lnl/adaptivity/xmlutil/XmlReader;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Factory implements XmlDeserializerFactory<CompactFragment> {
        @Override // nl.adaptivity.xmlutil.XmlDeserializerFactory
        public CompactFragment deserialize(XmlReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return CompactFragment.Companion.deserialize(reader);
        }
    }

    @Override // nl.adaptivity.xmlutil.util.ICompactFragment
    public boolean isEmpty() {
        return getContent().length == 0;
    }

    @Override // nl.adaptivity.xmlutil.util.ICompactFragment
    public IterableNamespaceContext getNamespaces() {
        return this.namespaces;
    }

    @Override // nl.adaptivity.xmlutil.util.ICompactFragment
    public char[] getContent() {
        return this.content;
    }

    public CompactFragment(Iterable<? extends Namespace> namespaces, char[] content) {
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        this.namespaces = SimpleNamespaceContext.Companion.from(namespaces);
        this.content = content == null ? new char[0] : content;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CompactFragment(String content) {
        this(CollectionsKt.emptyList(), r1);
        Intrinsics.checkNotNullParameter(content, "content");
        char[] charArray = content.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
    }

    public CompactFragment(ICompactFragment orig) {
        Intrinsics.checkNotNullParameter(orig, "orig");
        this.namespaces = SimpleNamespaceContext.Companion.from(orig.getNamespaces());
        this.content = orig.getContent();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CompactFragment(Iterable<? extends Namespace> namespaces, String content) {
        this(namespaces, r0);
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        Intrinsics.checkNotNullParameter(content, "content");
        char[] charArray = content.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
    }

    @Override // nl.adaptivity.xmlutil.XmlSerializable
    public void serialize(XmlWriter out) throws XmlException {
        Intrinsics.checkNotNullParameter(out, "out");
        XMLFragmentStreamReader reader = XMLFragmentStreamReader.Companion.from(this);
        try {
            XmlWriterUtil.serialize(out, reader);
        } finally {
            reader.close();
        }
    }

    @Override // nl.adaptivity.xmlutil.util.ICompactFragment
    public XmlReader getXmlReader() {
        return XMLFragmentStreamReader.Companion.from(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        ICompactFragment that = (ICompactFragment) other;
        if (!Intrinsics.areEqual(getNamespaces(), that.getNamespaces())) {
            return false;
        }
        return Arrays.equals(getContent(), that.getContent());
    }

    public int hashCode() {
        int result = getNamespaces().hashCode();
        return (result * 31) + Arrays.hashCode(getContent());
    }

    public String toString() {
        return CollectionsKt.joinToString$default(getNamespaces(), null, "{namespaces=[", "], content=" + getContentString() + AbstractJsonLexerKt.END_OBJ, 0, null, new Function1() { // from class: nl.adaptivity.xmlutil.util.CompactFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence string$lambda$0;
                string$lambda$0 = CompactFragment.toString$lambda$0((Namespace) obj);
                return string$lambda$0;
            }
        }, 25, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$0(Namespace it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPrefix() + " -> " + it.getNamespaceURI();
    }

    @Override // nl.adaptivity.xmlutil.util.ICompactFragment
    public String getContentString() {
        return new String(getContent());
    }

    /* compiled from: CompactFragment.jvm.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lnl/adaptivity/xmlutil/util/CompactFragment$Companion;", "", "<init>", "()V", "FACTORY", "Lnl/adaptivity/xmlutil/XmlDeserializerFactory;", "Lnl/adaptivity/xmlutil/util/CompactFragment;", "getFACTORY$annotations", "getFACTORY", "()Lnl/adaptivity/xmlutil/XmlDeserializerFactory;", "deserialize", "reader", "Lnl/adaptivity/xmlutil/XmlReader;", "serializer", "Lkotlinx/serialization/KSerializer;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @XmlUtilInternal
        public static /* synthetic */ void getFACTORY$annotations() {
        }

        private Companion() {
        }

        public final KSerializer<CompactFragment> serializer() {
            return CompactFragmentSerializer.INSTANCE;
        }

        public final XmlDeserializerFactory<CompactFragment> getFACTORY() {
            return CompactFragment.FACTORY;
        }

        public final CompactFragment deserialize(XmlReader reader) throws XmlException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return XmlReaderUtil.siblingsToFragment(reader);
        }
    }

    public static final XmlDeserializerFactory<CompactFragment> getFACTORY() {
        return Companion.getFACTORY();
    }
}