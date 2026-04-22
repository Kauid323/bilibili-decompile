package nl.adaptivity.xmlutil;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import nl.adaptivity.xmlutil.XmlStreamingFactory;
import nl.adaptivity.xmlutil.core.KtXmlReader;
import nl.adaptivity.xmlutil.core.KtXmlReaderJavaKt;
import nl.adaptivity.xmlutil.core.KtXmlWriter;
import nl.adaptivity.xmlutil.core.XmlVersion;
import nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon;
import nl.adaptivity.xmlutil.core.impl.dom.DOMImplementationImpl;
import nl.adaptivity.xmlutil.core.impl.multiplatform.Writer;
import nl.adaptivity.xmlutil.dom2.DOMImplementation;
import nl.adaptivity.xmlutil.dom2.Node;
import nl.adaptivity.xmlutil.util.SerializationProvider;

/* compiled from: XmlStreaming.jvm.kt */
@Deprecated(message = "Don't use directly", replaceWith = @ReplaceWith(expression = "xmlStreaming", imports = {"nl.adaptivity.xmlutil.xmlStreaming", "nl.adaptivity.xmlutil.newWriter", "nl.adaptivity.xmlutil.newGenericWriter"}))
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001SB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0012\u001a\u00020\u001cH\u0016J\u0010\u0010\u0012\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\"H\u0007J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020#2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\"H\u0007J(\u0010\u0012\u001a\u00020\u00132\n\u0010$\u001a\u00060%j\u0002`&2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\"H\u0007J(\u0010'\u001a\u00020(2\n\u0010$\u001a\u00060%j\u0002`&2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\"H\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001eH\u0017J\u0015\u0010.\u001a\u00020/2\u0006\u00101\u001a\u000202H\u0000¢\u0006\u0002\b3J\u0018\u0010.\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\u0010\u0010.\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000206H\u0017J\u0010\u0010.\u001a\u00020/2\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00107\u001a\u00020\u001bH\u0017J\u0010\u00109\u001a\u00020/2\u0006\u00107\u001a\u000208H\u0016J\u000e\u00109\u001a\u00020/2\u0006\u00107\u001a\u00020\u001bJ\u001a\u00109\u001a\u00020/2\u0006\u00101\u001a\u0002022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u00109\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0016J\u0012\u0010:\u001a\u00020;2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000206H\u0017J\u0010\u0010?\u001a\u00020\u001b2\u0006\u00100\u001a\u000206H\u0017J-\u0010@\u001a\u0002HA\"\b\b\u0000\u0010A*\u00020B2\u0006\u00107\u001a\u0002022\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0017¢\u0006\u0002\u0010EJ-\u0010@\u001a\u0002HA\"\b\b\u0000\u0010A*\u00020B2\u0006\u00107\u001a\u0002052\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0017¢\u0006\u0002\u0010FJ-\u0010@\u001a\u0002HA\"\b\b\u0000\u0010A*\u00020B2\u0006\u00107\u001a\u0002052\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HA0HH\u0017¢\u0006\u0002\u0010IJ-\u0010@\u001a\u0002HA\"\b\b\u0000\u0010A*\u00020B2\u0006\u00107\u001a\u00020\u001b2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0017¢\u0006\u0002\u0010JJ4\u0010@\u001a\b\u0012\u0004\u0012\u0002HA0K\"\b\b\u0000\u0010A*\u00020B2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001b0M2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0017J-\u0010@\u001a\u0002HA\"\b\b\u0000\u0010A*\u00020B2\u0006\u00104\u001a\u0002062\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0017¢\u0006\u0002\u0010NJ\"\u0010O\u001a\u0004\u0018\u00010P\"\b\b\u0000\u0010A*\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0017J(\u0010Q\u001a\n\u0012\u0004\u0012\u0002HA\u0018\u00010R\"\b\b\u0000\u0010A*\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0017R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068TX\u0095\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006T"}, d2 = {"Lnl/adaptivity/xmlutil/XmlStreaming;", "Lnl/adaptivity/xmlutil/core/impl/XmlStreamingJavaCommon;", "Lnl/adaptivity/xmlutil/IXmlStreaming;", "<init>", "()V", "serializationLoader", "Ljava/util/ServiceLoader;", "Lnl/adaptivity/xmlutil/util/SerializationProvider;", "getSerializationLoader$annotations", "getSerializationLoader", "()Ljava/util/ServiceLoader;", "serviceLoader", "Lnl/adaptivity/xmlutil/XmlStreamingFactory;", "getServiceLoader", "_factory", "factory", "getFactory", "()Lnl/adaptivity/xmlutil/XmlStreamingFactory;", "newWriter", "Lnl/adaptivity/xmlutil/XmlWriter;", "result", "Ljavax/xml/transform/Result;", "repairNamespaces", "", "outputStream", "Ljava/io/OutputStream;", "encoding", "", "Lnl/adaptivity/xmlutil/DomWriter;", "dest", "Lnl/adaptivity/xmlutil/dom2/Node;", "writer", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;", "xmlDeclMode", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "Ljava/io/Writer;", "output", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "newGenericWriter", "Lnl/adaptivity/xmlutil/core/KtXmlWriter;", "isRepairNamespaces", "genericDomImplementation", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "getGenericDomImplementation", "()Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "newReader", "Lnl/adaptivity/xmlutil/XmlReader;", "source", "inputStream", "Ljava/io/InputStream;", "newReader$core", "reader", "Ljava/io/Reader;", "Ljavax/xml/transform/Source;", "input", "", "newGenericReader", "setFactory", "", "toCharArray", "", "content", "toString", "deSerialize", "T", "", "type", "Ljava/lang/Class;", "(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;", "kClass", "Lkotlin/reflect/KClass;", "(Ljava/io/Reader;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "", "inputs", "", "(Ljavax/xml/transform/Source;Ljava/lang/Class;)Ljava/lang/Object;", "deserializerFor", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlDeserializerFun;", "serializerFor", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlSerializerFun;", "GenericFactory", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XmlStreaming extends XmlStreamingJavaCommon implements IXmlStreaming {
    public static final XmlStreaming INSTANCE = new XmlStreaming();
    private static volatile XmlStreamingFactory _factory;

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    protected static /* synthetic */ void getSerializationLoader$annotations() {
    }

    private XmlStreaming() {
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    protected ServiceLoader<SerializationProvider> getSerializationLoader() {
        ServiceLoader<SerializationProvider> load = ServiceLoader.load(SerializationProvider.class, SerializationProvider.class.getClassLoader());
        Intrinsics.checkNotNullExpressionValue(load, "load(...)");
        return load;
    }

    private final ServiceLoader<XmlStreamingFactory> getServiceLoader() {
        ServiceLoader<XmlStreamingFactory> load = ServiceLoader.load(XmlStreamingFactory.class, XmlStreamingFactory.class.getClassLoader());
        Intrinsics.checkNotNullExpressionValue(load, "load(...)");
        return load;
    }

    private final XmlStreamingFactory getFactory() {
        XmlStreamingFactory xmlStreamingFactory;
        XmlStreamingFactory xmlStreamingFactory2;
        XmlStreamingFactory f = _factory;
        if (f != null) {
            return f;
        }
        XmlStreamingFactory xmlStreamingFactory3 = null;
        try {
            xmlStreamingFactory = (XmlStreamingFactory) CollectionsKt.firstOrNull(getServiceLoader());
        } catch (ServiceConfigurationError e) {
            xmlStreamingFactory = null;
        }
        XmlStreamingFactory f2 = xmlStreamingFactory;
        if (f2 == null) {
            try {
                Object newInstance = Class.forName("nl.adaptivity.xmlutil.StAXStreamingFactory").getConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlStreamingFactory");
                xmlStreamingFactory2 = (XmlStreamingFactory) newInstance;
            } catch (ClassNotFoundException e2) {
                xmlStreamingFactory2 = null;
            }
            f2 = xmlStreamingFactory2;
        }
        if (f2 == null) {
            try {
                Object newInstance2 = Class.forName("nl.adaptivity.xmlutil.AndroidStreamingFactory").getConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type nl.adaptivity.xmlutil.XmlStreamingFactory");
                xmlStreamingFactory3 = (XmlStreamingFactory) newInstance2;
            } catch (ClassNotFoundException e3) {
            }
            f2 = xmlStreamingFactory3;
        }
        if (f2 == null) {
            f2 = new GenericFactory();
        }
        _factory = f2;
        return f2;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    public XmlWriter newWriter(Result result, boolean repairNamespaces) {
        Intrinsics.checkNotNullParameter(result, "result");
        return XmlStreamingFactory.CC.newWriter$default(getFactory(), result, repairNamespaces, (XmlDeclMode) null, 4, (Object) null);
    }

    public final XmlWriter newWriter(OutputStream outputStream, String encoding, boolean repairNamespaces) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        return XmlStreamingFactory.CC.newWriter$default(getFactory(), outputStream, encoding, repairNamespaces, (XmlDeclMode) null, 8, (Object) null);
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    public DomWriter newWriter() {
        return new DomWriter((XmlDeclMode) null, 1, (DefaultConstructorMarker) null);
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    public DomWriter newWriter(Node dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        return new DomWriter(dest, false, (XmlDeclMode) null, 6, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ XmlWriter newWriter$default(XmlStreaming xmlStreaming, Writer writer, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            xmlDeclMode = XmlDeclMode.None;
        }
        return xmlStreaming.newWriter(writer, z, xmlDeclMode);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use extension function on IXmlStreaming")
    public final XmlWriter newWriter(Writer writer, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        return getFactory().newWriter(writer, repairNamespaces, xmlDeclMode);
    }

    public static /* synthetic */ XmlWriter newWriter$default(XmlStreaming xmlStreaming, java.io.Writer writer, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            xmlDeclMode = XmlDeclMode.None;
        }
        return xmlStreaming.newWriter(writer, z, xmlDeclMode);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use extension function on IXmlStreaming")
    public final XmlWriter newWriter(java.io.Writer writer, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        return getFactory().newWriter(writer, repairNamespaces, xmlDeclMode);
    }

    public static /* synthetic */ XmlWriter newWriter$default(XmlStreaming xmlStreaming, Appendable appendable, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            xmlDeclMode = XmlDeclMode.None;
        }
        return xmlStreaming.newWriter(appendable, z, xmlDeclMode);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use extension function on IXmlStreaming")
    public final XmlWriter newWriter(Appendable output, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        return getFactory().newWriter(output, repairNamespaces, xmlDeclMode);
    }

    public static /* synthetic */ KtXmlWriter newGenericWriter$default(XmlStreaming xmlStreaming, Appendable appendable, boolean z, XmlDeclMode xmlDeclMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            xmlDeclMode = XmlDeclMode.None;
        }
        return xmlStreaming.newGenericWriter(appendable, z, xmlDeclMode);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use extension function on IXmlStreaming", replaceWith = @ReplaceWith(expression = "KtXmlWriter(output, isRepairNamespaces, xmlDeclMode)", imports = {"nl.adaptivity.xmlutil.core.KtXmlWriter"}))
    public final KtXmlWriter newGenericWriter(Appendable output, boolean isRepairNamespaces, XmlDeclMode xmlDeclMode) {
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
        return new KtXmlWriter(output, isRepairNamespaces, xmlDeclMode, (XmlVersion) null, 8, (DefaultConstructorMarker) null);
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    public DOMImplementation getGenericDomImplementation() {
        return DOMImplementationImpl.INSTANCE;
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    @ExperimentalXmlUtilApi
    public XmlReader newReader(Node source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new DomReader(source);
    }

    public final XmlReader newReader$core(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return getFactory().newReader(inputStream);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "Use extension functions on IXmlStreaming")
    public XmlReader newReader(InputStream inputStream, String encoding) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        return getFactory().newReader(inputStream, encoding);
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    public XmlReader newReader(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        return getFactory().newReader(reader);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "Note that sources are inefficient and poorly designed, relying on runtime types")
    public XmlReader newReader(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return getFactory().newReader(source);
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    public XmlReader newReader(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return getFactory().newReader(input);
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "Use the version taking a CharSequence", replaceWith = @ReplaceWith(expression = "newReader(input as CharSequence)", imports = {"nl.adaptivity.xmlutil.XmlStreaming.newReader"}))
    public XmlReader newReader(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return newReader((CharSequence) input);
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    public XmlReader newGenericReader(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return newGenericReader(new StringReader(input.toString()));
    }

    public final XmlReader newGenericReader(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return newGenericReader(new StringReader(input));
    }

    public static /* synthetic */ XmlReader newGenericReader$default(XmlStreaming xmlStreaming, InputStream inputStream, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return xmlStreaming.newGenericReader(inputStream, str);
    }

    public final XmlReader newGenericReader(InputStream inputStream, String encoding) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return KtXmlReaderJavaKt.KtXmlReader$default(inputStream, encoding, false, 4, null);
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    public XmlReader newGenericReader(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        return new KtXmlReader(reader, false, 2, null);
    }

    @Override // nl.adaptivity.xmlutil.IXmlStreaming
    public void setFactory(XmlStreamingFactory factory) {
        _factory = factory;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "Note that sources are inefficient and poorly designed, relying on runtime types", replaceWith = @ReplaceWith(expression = "newReader(content).toCharArrayWriter().toCharArray()", imports = {"nl.adaptivity.xmlutil.XmlStreaming.newReader"}))
    public char[] toCharArray(Source content) {
        Intrinsics.checkNotNullParameter(content, "content");
        char[] charArray = XmlReaderUtil.toCharArrayWriter(newReader(content)).toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return charArray;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "Note that sources are inefficient and poorly designed, relying on runtime types", replaceWith = @ReplaceWith(expression = "newReader(source).toCharArrayWriter().toString()", imports = {"nl.adaptivity.xmlutil.XmlStreaming.newReader"}))
    public String toString(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        String charArrayWriter = XmlReaderUtil.toCharArrayWriter(newReader(source)).toString();
        Intrinsics.checkNotNullExpressionValue(charArrayWriter, "toString(...)");
        return charArrayWriter;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0", replaceWith = @ReplaceWith(expression = "deSerialize(input, type.kotlin)", imports = {"nl.adaptivity.xmlutil.XmlStreaming.deSerialize"}))
    public <T> T deSerialize(InputStream input, Class<T> type) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) deSerialize(input, JvmClassMappingKt.getKotlinClass(type));
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0", replaceWith = @ReplaceWith(expression = "deSerialize(input, type.kotlin)", imports = {"nl.adaptivity.xmlutil.XmlStreaming.deSerialize"}))
    public <T> T deSerialize(Reader input, Class<T> type) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) deSerialize(input, JvmClassMappingKt.getKotlinClass(type));
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public <T> T deSerialize(Reader input, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        SerializationProvider.XmlDeserializerFun deserializer = deserializerFor(kClass);
        if (deserializer == null) {
            throw new IllegalArgumentException("No deserializer for " + kClass + " (" + CollectionsKt.joinToString$default(getSerializationLoader(), null, null, null, 0, null, new Function1() { // from class: nl.adaptivity.xmlutil.XmlStreaming$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence deSerialize$lambda$0;
                    deSerialize$lambda$0 = XmlStreaming.deSerialize$lambda$0((SerializationProvider) obj);
                    return deSerialize$lambda$0;
                }
            }, 31, null) + ')');
        }
        return (T) deserializer.invoke(newReader(input), kClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence deSerialize$lambda$0(SerializationProvider it) {
        String name = it.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0", replaceWith = @ReplaceWith(expression = "deSerialize(input, type.kotlin)", imports = {"nl.adaptivity.xmlutil.XmlStreaming.deSerialize"}))
    public <T> T deSerialize(String input, Class<T> type) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) deSerialize(input, JvmClassMappingKt.getKotlinClass(type));
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0", replaceWith = @ReplaceWith(expression = "deSerialize(inputs, type.kotlin)", imports = {"nl.adaptivity.xmlutil.XmlStreaming.deSerialize"}))
    public <T> List<T> deSerialize(Iterable<String> inputs, Class<T> type) {
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        Intrinsics.checkNotNullParameter(type, "type");
        return deSerialize(inputs, JvmClassMappingKt.getKotlinClass(type));
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0", replaceWith = @ReplaceWith(expression = "deSerialize(reader, type.kotlin)", imports = {"nl.adaptivity.xmlutil.XmlStreaming.deSerialize"}))
    public <T> T deSerialize(Source reader, Class<T> type) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) deSerialize(reader, JvmClassMappingKt.getKotlinClass(type));
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0", replaceWith = @ReplaceWith(expression = "deserializerFor(type.kotlin)", imports = {"nl.adaptivity.xmlutil.XmlStreaming.deserializerFor"}))
    public <T> SerializationProvider.XmlDeserializerFun deserializerFor(Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return deserializerFor(JvmClassMappingKt.getKotlinClass(type));
    }

    @Override // nl.adaptivity.xmlutil.core.impl.XmlStreamingJavaCommon
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0", replaceWith = @ReplaceWith(expression = "serializerFor(type.kotlin)", imports = {"nl.adaptivity.xmlutil.XmlStreaming.serializerFor"}))
    public <T> SerializationProvider.XmlSerializerFun<T> serializerFor(Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return serializerFor(JvmClassMappingKt.getKotlinClass(type));
    }

    /* compiled from: XmlStreaming.jvm.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0016"}, d2 = {"Lnl/adaptivity/xmlutil/XmlStreaming$GenericFactory;", "Lnl/adaptivity/xmlutil/XmlStreamingFactory;", "<init>", "()V", "newWriter", "Lnl/adaptivity/xmlutil/XmlWriter;", "writer", "Ljava/io/Writer;", "repairNamespaces", "", "xmlDeclMode", "Lnl/adaptivity/xmlutil/XmlDeclMode;", "outputStream", "Ljava/io/OutputStream;", "encoding", "", "newReader", "Lnl/adaptivity/xmlutil/XmlReader;", "reader", "Ljava/io/Reader;", "inputStream", "Ljava/io/InputStream;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class GenericFactory implements XmlStreamingFactory {
        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlReader newReader(CharSequence charSequence) {
            return XmlStreamingFactory.CC.$default$newReader(this, charSequence);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlReader newReader(String str) {
            return XmlStreamingFactory.CC.$default$newReader((XmlStreamingFactory) this, str);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlReader newReader(Source source) {
            return XmlStreamingFactory.CC.$default$newReader(this, source);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlWriter newWriter(OutputStream outputStream, String str, boolean z, boolean z2) {
            return XmlStreamingFactory.CC.$default$newWriter(this, outputStream, str, z, z2);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlWriter newWriter(java.io.Writer writer, boolean z, boolean z2) {
            return XmlStreamingFactory.CC.$default$newWriter((XmlStreamingFactory) this, writer, z, z2);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlWriter newWriter(Appendable appendable, boolean z, XmlDeclMode xmlDeclMode) {
            return XmlStreamingFactory.CC.$default$newWriter(this, appendable, z, xmlDeclMode);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlWriter newWriter(Appendable appendable, boolean z, boolean z2) {
            return XmlStreamingFactory.CC.$default$newWriter(this, appendable, z, z2);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlWriter newWriter(Result result, boolean z, XmlDeclMode xmlDeclMode) {
            return XmlStreamingFactory.CC.$default$newWriter(this, result, z, xmlDeclMode);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public /* synthetic */ XmlWriter newWriter(Result result, boolean z, boolean z2) {
            return XmlStreamingFactory.CC.$default$newWriter(this, result, z, z2);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public XmlWriter newWriter(java.io.Writer writer, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
            return new KtXmlWriter(writer, repairNamespaces, xmlDeclMode, (XmlVersion) null, 8, (DefaultConstructorMarker) null);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public XmlWriter newWriter(OutputStream outputStream, String encoding, boolean repairNamespaces, XmlDeclMode xmlDeclMode) {
            Intrinsics.checkNotNullParameter(outputStream, "outputStream");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            Intrinsics.checkNotNullParameter(xmlDeclMode, "xmlDeclMode");
            return new KtXmlWriter(new OutputStreamWriter(outputStream, encoding), repairNamespaces, xmlDeclMode, (XmlVersion) null, 8, (DefaultConstructorMarker) null);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public XmlReader newReader(Reader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new KtXmlReader(reader, false, 2, null);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public XmlReader newReader(InputStream inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            return KtXmlReaderJavaKt.KtXmlReader$default(inputStream, null, false, 6, null);
        }

        @Override // nl.adaptivity.xmlutil.XmlStreamingFactory
        public XmlReader newReader(InputStream inputStream, String encoding) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            return KtXmlReaderJavaKt.KtXmlReader$default(inputStream, encoding, false, 4, null);
        }
    }
}