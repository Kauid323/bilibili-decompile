package nl.adaptivity.xmlutil.util;

import java.io.CharArrayReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.EventType;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlUtil;
import nl.adaptivity.xmlutil.core.KtXmlReader;
import nl.adaptivity.xmlutil.util.impl.FragmentNamespaceContext;

/* compiled from: XMLFragmentStreamReader.jvm.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\"B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0005\u0010\fJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\t\u0010\u001a\u001a\u00020\u001bH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0002R\u0014\u0010\u0004\u001a\u00020\u00038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lnl/adaptivity/xmlutil/util/XMLFragmentStreamReader;", "Lnl/adaptivity/xmlutil/XmlDelegatingReader;", "Lnl/adaptivity/xmlutil/util/XMLFragmentStreamReaderJava;", "Lnl/adaptivity/xmlutil/XmlReader;", "delegate", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader;)V", "reader", "Ljava/io/Reader;", "namespaces", "", "Lnl/adaptivity/xmlutil/Namespace;", "(Ljava/io/Reader;Ljava/lang/Iterable;)V", "getDelegate", "()Lnl/adaptivity/xmlutil/XmlReader;", "localNamespaceContext", "Lnl/adaptivity/xmlutil/util/impl/FragmentNamespaceContext;", "getLocalNamespaceContext", "()Lnl/adaptivity/xmlutil/util/impl/FragmentNamespaceContext;", "setLocalNamespaceContext", "(Lnl/adaptivity/xmlutil/util/impl/FragmentNamespaceContext;)V", "getNamespaceURI", "", "prefix", "getNamespacePrefix", "namespaceUri", "next", "Lnl/adaptivity/xmlutil/EventType;", "namespaceContext", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaceContext", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "extendNamespace", "", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XMLFragmentStreamReader extends nl.adaptivity.xmlutil.XmlDelegatingReader implements XMLFragmentStreamReaderJava, XmlReader {
    public static final Companion Companion = new Companion(null);
    private static final String WRAPPERNAMESPACE = "http://wrapperns";
    private static final String WRAPPERPPREFIX = "SDFKLJDSF";
    private FragmentNamespaceContext localNamespaceContext;

    /* compiled from: XMLFragmentStreamReader.jvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.END_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.START_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.PROCESSING_INSTRUCTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.DOCDECL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EventType.START_ELEMENT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EventType.END_ELEMENT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private XMLFragmentStreamReader(XmlReader delegate) {
        super(delegate);
        this.localNamespaceContext = new FragmentNamespaceContext(null, new String[0], new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nl.adaptivity.xmlutil.XmlDelegatingReader
    public XmlReader getDelegate() {
        return super.getDelegate();
    }

    public final FragmentNamespaceContext getLocalNamespaceContext() {
        return this.localNamespaceContext;
    }

    public final void setLocalNamespaceContext(FragmentNamespaceContext fragmentNamespaceContext) {
        Intrinsics.checkNotNullParameter(fragmentNamespaceContext, "<set-?>");
        this.localNamespaceContext = fragmentNamespaceContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XMLFragmentStreamReader(Reader reader, Iterable<? extends Namespace> namespaces) {
        this(Companion.getDelegate(reader, namespaces));
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(namespaces, "namespaces");
        if (!getDelegate().isStarted() || getDelegate().getEventType() != EventType.START_ELEMENT) {
            return;
        }
        extendNamespace();
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingReader, nl.adaptivity.xmlutil.XmlReader
    public String getNamespaceURI(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if ("SDFKLJDSF".contentEquals(prefix)) {
            return null;
        }
        return super.getNamespaceURI(prefix);
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingReader, nl.adaptivity.xmlutil.XmlReader
    public String getNamespacePrefix(String namespaceUri) {
        Intrinsics.checkNotNullParameter(namespaceUri, "namespaceUri");
        if ("http://wrapperns".contentEquals(namespaceUri)) {
            return null;
        }
        return super.getNamespacePrefix(namespaceUri);
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingReader, java.util.Iterator
    public EventType next() {
        EventType delegateNext = getDelegate().next();
        switch (WhenMappings.$EnumSwitchMapping$0[delegateNext.ordinal()]) {
            case 1:
            default:
                return delegateNext;
            case 2:
            case 3:
            case 4:
                return next();
            case 5:
                if ("http://wrapperns".contentEquals(getDelegate().getNamespaceURI())) {
                    return next();
                }
                extendNamespace();
                return delegateNext;
            case 6:
                if ("http://wrapperns".contentEquals(getDelegate().getNamespaceURI())) {
                    return getDelegate().next();
                }
                FragmentNamespaceContext parent = this.localNamespaceContext.getParent();
                if (parent == null) {
                    parent = this.localNamespaceContext;
                }
                this.localNamespaceContext = parent;
                return delegateNext;
        }
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingReader, nl.adaptivity.xmlutil.XmlReader
    public IterableNamespaceContext getNamespaceContext() {
        return this.localNamespaceContext;
    }

    /* compiled from: XMLFragmentStreamReader.jvm.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lnl/adaptivity/xmlutil/util/XMLFragmentStreamReader$Companion;", "", "<init>", "()V", "WRAPPERPPREFIX", "", "WRAPPERNAMESPACE", "getDelegate", "Lnl/adaptivity/xmlutil/XmlReader;", "reader", "Ljava/io/Reader;", "wrapperNamespaceContext", "", "Lnl/adaptivity/xmlutil/Namespace;", "from", "Lnl/adaptivity/xmlutil/util/XMLFragmentStreamReader;", "namespaceContext", "fragment", "Lnl/adaptivity/xmlutil/util/ICompactFragment;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final XmlReader getDelegate(Reader reader, Iterable<? extends Namespace> iterable) {
            StringBuilder $this$getDelegate_u24lambda_u240 = new StringBuilder();
            $this$getDelegate_u24lambda_u240.append("<SDFKLJDSF:wrapper xmlns:SDFKLJDSF=\"http://wrapperns\"");
            for (Namespace ns : iterable) {
                String prefix = ns.getPrefix();
                String uri = ns.getNamespaceURI();
                if (Intrinsics.areEqual("", prefix)) {
                    $this$getDelegate_u24lambda_u240.append(" xmlns");
                } else {
                    $this$getDelegate_u24lambda_u240.append(" xmlns:").append(prefix);
                }
                $this$getDelegate_u24lambda_u240.append("=\"").append(XmlUtil.xmlEncode(uri)).append('\"');
            }
            $this$getDelegate_u24lambda_u240.append(" >");
            String wrapper = $this$getDelegate_u24lambda_u240.toString();
            CombiningReader actualInput = new CombiningReader(new StringReader(wrapper), reader, new StringReader("</SDFKLJDSF:wrapper>"));
            return new KtXmlReader(actualInput, false, 2, null);
        }

        @JvmStatic
        public final XMLFragmentStreamReader from(Reader reader, Iterable<? extends Namespace> namespaceContext) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(namespaceContext, "namespaceContext");
            return new XMLFragmentStreamReader(reader, namespaceContext);
        }

        @JvmStatic
        public final XMLFragmentStreamReader from(Reader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new XMLFragmentStreamReader(reader, CollectionsKt.emptyList());
        }

        @JvmStatic
        public final XMLFragmentStreamReader from(ICompactFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return new XMLFragmentStreamReader(new CharArrayReader(fragment.getContent()), fragment.getNamespaces());
        }
    }

    @JvmStatic
    public static final XMLFragmentStreamReader from(Reader reader, Iterable<? extends Namespace> iterable) {
        return Companion.from(reader, iterable);
    }

    @JvmStatic
    public static final XMLFragmentStreamReader from(Reader reader) {
        return Companion.from(reader);
    }

    @JvmStatic
    public static final XMLFragmentStreamReader from(ICompactFragment fragment) {
        return Companion.from(fragment);
    }

    private final void extendNamespace() {
        List namespaceDecls = getDelegate().getNamespaceDecls();
        int nscount = namespaceDecls.size();
        String[] prefixes = new String[nscount];
        for (int i = 0; i < nscount; i++) {
            prefixes[i] = namespaceDecls.get(i).getPrefix();
        }
        String[] namespaces = new String[nscount];
        for (int i2 = 0; i2 < nscount; i2++) {
            namespaces[i2] = namespaceDecls.get(i2).getNamespaceURI();
        }
        this.localNamespaceContext = new FragmentNamespaceContext(this.localNamespaceContext, prefixes, namespaces);
    }
}