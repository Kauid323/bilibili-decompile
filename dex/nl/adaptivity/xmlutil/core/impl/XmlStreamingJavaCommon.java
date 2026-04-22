package nl.adaptivity.xmlutil.core.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import nl.adaptivity.xmlutil.IXmlStreaming;
import nl.adaptivity.xmlutil.XmlDeclMode;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlStreaming_jvmKt;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.core.impl.multiplatform.Writer;
import nl.adaptivity.xmlutil.util.SerializationProvider;

/* compiled from: XmlStreamingJavaCommon.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\n\u001a\u00020\u000b2\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H'J\"\u0010!\u001a\u0004\u0018\u00010\"\"\b\b\u0000\u0010#*\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H'J\"\u0010!\u001a\u0004\u0018\u00010\"\"\b\b\u0000\u0010#*\u00020$2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H#0(H\u0007J(\u0010)\u001a\n\u0012\u0004\u0012\u0002H#\u0018\u00010*\"\b\b\u0000\u0010#*\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H'J(\u0010)\u001a\n\u0012\u0004\u0012\u0002H#\u0018\u00010*\"\b\b\u0000\u0010#*\u00020$2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H#0(H\u0007J*\u0010+\u001a\u00020,\"\n\b\u0000\u0010#\u0018\u0001*\u00020$2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u0002H#H\u0087\b¢\u0006\u0002\u0010/J'\u00100\u001a\u00020,\"\b\b\u0000\u0010#*\u00020$2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u0002H#H\u0007¢\u0006\u0002\u0010/J5\u00100\u001a\u00020,\"\b\b\u0000\u0010#*\u00020$2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H#0(2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u0002H#H\u0007¢\u0006\u0002\u00102J-\u00103\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\u0006\u00104\u001a\u00020\u001e2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H'¢\u0006\u0002\u00105J-\u00103\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\u0006\u00104\u001a\u00020\u001e2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H#0(H\u0007¢\u0006\u0002\u00106J-\u00103\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\u0006\u00104\u001a\u0002072\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H'¢\u0006\u0002\u00108J-\u00103\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\u0006\u00104\u001a\u0002072\f\u00101\u001a\b\u0012\u0004\u0012\u0002H#0(H'¢\u0006\u0002\u00109J-\u00103\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\u0006\u00104\u001a\u00020\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H'¢\u0006\u0002\u0010:J-\u00103\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\u0006\u00104\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u0002H#0(H\u0007¢\u0006\u0002\u0010;J4\u00103\u001a\b\u0012\u0004\u0012\u0002H#0<\"\b\b\u0000\u0010#*\u00020$2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130>2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H'J4\u00103\u001a\b\u0012\u0004\u0012\u0002H#0<\"\b\b\u0000\u0010#*\u00020$2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130>2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H#0(H\u0007J\"\u00103\u001a\u0002H#\"\n\b\u0000\u0010#\u0018\u0001*\u00020$2\u0006\u00104\u001a\u00020\u0013H\u0087\b¢\u0006\u0002\u0010?J-\u00103\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\u0006\u0010@\u001a\u00020 2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H'¢\u0006\u0002\u0010AJ-\u00103\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\u0006\u0010@\u001a\u00020 2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H#0(H\u0007¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020 H'J\u0010\u0010F\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0013H'R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058$X¥\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006G"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/XmlStreamingJavaCommon;", "Lnl/adaptivity/xmlutil/IXmlStreaming;", "<init>", "()V", "serializationLoader", "Ljava/util/ServiceLoader;", "Lnl/adaptivity/xmlutil/util/SerializationProvider;", "getSerializationLoader$annotations", "getSerializationLoader", "()Ljava/util/ServiceLoader;", "newWriter", "Lnl/adaptivity/xmlutil/XmlWriter;", "result", "Ljavax/xml/transform/Result;", "repairNamespaces", "", "outputStream", "Ljava/io/OutputStream;", "encoding", "", "writer", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Writer;", "Ljava/io/Writer;", "omitXmlDecl", "output", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "newReader", "Lnl/adaptivity/xmlutil/XmlReader;", "inputStream", "Ljava/io/InputStream;", "source", "Ljavax/xml/transform/Source;", "deserializerFor", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlDeserializerFun;", "T", "", "type", "Ljava/lang/Class;", "klass", "Lkotlin/reflect/KClass;", "serializerFor", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlSerializerFun;", "serializeAs", "", "target", "value", "(Lnl/adaptivity/xmlutil/XmlWriter;Ljava/lang/Object;)V", "serialize", "kClass", "(Lkotlin/reflect/KClass;Lnl/adaptivity/xmlutil/XmlWriter;Ljava/lang/Object;)V", "deSerialize", "input", "(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/io/InputStream;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Ljava/io/Reader;", "(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/io/Reader;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "", "inputs", "", "(Ljava/lang/String;)Ljava/lang/Object;", "reader", "(Ljavax/xml/transform/Source;Ljava/lang/Class;)Ljava/lang/Object;", "(Ljavax/xml/transform/Source;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toCharArray", "", "content", "toString", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class XmlStreamingJavaCommon implements IXmlStreaming {
    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    protected static /* synthetic */ void getSerializationLoader$annotations() {
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract <T> T deSerialize(InputStream inputStream, Class<T> cls);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract <T> T deSerialize(Reader reader, Class<T> cls);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract <T> T deSerialize(Reader reader, KClass<T> kClass);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract <T> T deSerialize(String str, Class<T> cls);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract <T> T deSerialize(Source source, Class<T> cls);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract <T> List<T> deSerialize(Iterable<String> iterable, Class<T> cls);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract <T> SerializationProvider.XmlDeserializerFun deserializerFor(Class<T> cls);

    protected abstract ServiceLoader<SerializationProvider> getSerializationLoader();

    @Deprecated(message = "Use extension functions on IXmlStreaming")
    public abstract XmlReader newReader(InputStream inputStream, String str);

    @Deprecated(message = "Use the version taking a CharSequence")
    public abstract XmlReader newReader(String str);

    @Deprecated(message = "Use extension functions on IXmlStreaming")
    public abstract XmlReader newReader(Source source);

    public abstract XmlWriter newWriter(Result result, boolean z);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract <T> SerializationProvider.XmlSerializerFun<T> serializerFor(Class<T> cls);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract char[] toCharArray(Source source);

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public abstract String toString(Source source);

    @Deprecated(message = "Use extension functions on IXmlStreaming")
    public final XmlWriter newWriter(Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return newWriter(result, false);
    }

    public static /* synthetic */ XmlWriter newWriter$default(XmlStreamingJavaCommon xmlStreamingJavaCommon, Result result, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return xmlStreamingJavaCommon.newWriter(result, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newWriter");
    }

    @Deprecated(message = "Use extension functions on IXmlStreaming")
    public XmlWriter newWriter(OutputStream outputStream, String encoding) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        return XmlStreamingJavaCommonKt.newWriter((IXmlStreaming) this, outputStream, encoding, false);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use extension functions on IXmlStreaming")
    public final /* synthetic */ XmlWriter newWriter(Writer writer) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        return newWriter(writer, false);
    }

    public final XmlWriter newWriter(java.io.Writer writer) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        return newWriter(writer, false);
    }

    @Deprecated(message = "Use version that takes XmlDeclMode")
    public final XmlWriter newWriter(Writer writer, boolean repairNamespaces, boolean omitXmlDecl) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        return newWriter((Appendable) writer, repairNamespaces, omitXmlDecl);
    }

    @Deprecated(message = "Use version that takes XmlDeclMode")
    public final XmlWriter newWriter(java.io.Writer writer, boolean repairNamespaces, boolean omitXmlDecl) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        return XmlStreaming_jvmKt.newWriter((IXmlStreaming) this, (Appendable) writer, repairNamespaces, XmlDeclMode.Companion.from(omitXmlDecl));
    }

    @Deprecated(message = "Use extension functions on IXmlStreaming")
    public final XmlWriter newWriter(Writer writer, boolean repairNamespaces) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        return XmlStreaming_jvmKt.newWriter$default((IXmlStreaming) this, (Appendable) writer, repairNamespaces, (XmlDeclMode) null, 4, (Object) null);
    }

    public final XmlWriter newWriter(java.io.Writer writer, boolean repairNamespaces) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        return XmlStreaming_jvmKt.newWriter((IXmlStreaming) this, (Appendable) writer, repairNamespaces, XmlDeclMode.None);
    }

    @Deprecated(message = "Use version that takes XmlDeclMode")
    public final XmlWriter newWriter(Appendable output, boolean repairNamespaces, boolean omitXmlDecl) {
        Intrinsics.checkNotNullParameter(output, "output");
        return XmlStreaming_jvmKt.newWriter(this, output, repairNamespaces, XmlDeclMode.Companion.from(omitXmlDecl));
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final <T> SerializationProvider.XmlDeserializerFun deserializerFor(KClass<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Iterator<SerializationProvider> it = getSerializationLoader().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SerializationProvider candidate = it.next();
            SerializationProvider.XmlDeserializerFun deSerializer = candidate.deSerializer(klass);
            if (deSerializer != null) {
                return deSerializer;
            }
        }
        return null;
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final <T> SerializationProvider.XmlSerializerFun<T> serializerFor(KClass<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Iterator<SerializationProvider> it = getSerializationLoader().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SerializationProvider candidate = it.next();
            SerializationProvider.XmlSerializerFun serializer = candidate.serializer(klass);
            if (serializer != null) {
                return serializer;
            }
        }
        return null;
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final /* synthetic */ <T> void serializeAs(XmlWriter target, T value) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.reifiedOperationMarker(4, "T");
        serialize(Reflection.getOrCreateKotlinClass(Object.class), target, value);
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final <T> void serialize(XmlWriter target, T value) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(value, "value");
        KClass kClass = Reflection.getOrCreateKotlinClass(value.getClass());
        serialize(kClass, target, value);
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final <T> void serialize(KClass<T> kClass, XmlWriter target, T value) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationProvider.XmlSerializerFun serializer = serializerFor(kClass);
        if (serializer == null) {
            throw new IllegalArgumentException("No serializer for " + kClass + " found");
        }
        serializer.invoke(target, value);
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final <T> T deSerialize(InputStream input, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        SerializationProvider.XmlDeserializerFun deserializer = deserializerFor(kClass);
        if (deserializer == null) {
            throw new IllegalArgumentException("No deserializer for " + kClass);
        }
        return (T) deserializer.invoke(newReader(input, "UTF-8"), kClass);
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final <T> T deSerialize(String input, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        SerializationProvider.XmlDeserializerFun deserializer = deserializerFor(kClass);
        if (deserializer == null) {
            throw new IllegalArgumentException("No deserializer for " + kClass);
        }
        return (T) deserializer.invoke(newReader(new StringReader(input)), kClass);
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final <T> List<T> deSerialize(Iterable<String> inputs, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        SerializationProvider.XmlDeserializerFun deserializer = deserializerFor(kClass);
        if (deserializer == null) {
            throw new IllegalArgumentException("No deserializer for " + kClass);
        }
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(inputs, 10));
        for (Object item$iv$iv : inputs) {
            String input = (String) item$iv$iv;
            destination$iv$iv.add(deserializer.invoke(newReader(new StringReader(input)), kClass));
        }
        return (List) destination$iv$iv;
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final /* synthetic */ <T> T deSerialize(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) deSerialize(input, Reflection.getOrCreateKotlinClass(Object.class));
    }

    @Deprecated(message = "This functionality uses service loaders and isn't really needed. Will be removed in 1.0")
    public final <T> T deSerialize(Source reader, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        SerializationProvider.XmlDeserializerFun deserializer = deserializerFor(kClass);
        if (deserializer == null) {
            throw new IllegalArgumentException("No deserializer for " + kClass);
        }
        return (T) deserializer.invoke(newReader(reader), kClass);
    }
}