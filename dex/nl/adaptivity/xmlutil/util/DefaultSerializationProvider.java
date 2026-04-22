package nl.adaptivity.xmlutil.util;

import java.lang.annotation.Annotation;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlSerializable;
import nl.adaptivity.xmlutil.XmlWriter;
import nl.adaptivity.xmlutil.util.SerializationProvider;

/* compiled from: DefaultSerializationProvider.kt */
@Deprecated(message = "This should be done in the xmlserializable module")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016J\"\u0010\n\u001a\u0004\u0018\u00010\u000b\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¨\u0006\u000e"}, d2 = {"Lnl/adaptivity/xmlutil/util/DefaultSerializationProvider;", "Lnl/adaptivity/xmlutil/util/CoreCompatSerializationProvider;", "<init>", "()V", "serializer", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlSerializerFun;", "T", "", "type", "Lkotlin/reflect/KClass;", "deSerializer", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlDeserializerFun;", "DeserializerFun", "SerializableSerializer", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultSerializationProvider implements CoreCompatSerializationProvider {
    @Override // nl.adaptivity.xmlutil.util.SerializationProvider
    public <T> SerializationProvider.XmlSerializerFun<T> serializer(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (XmlSerializable.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass) type))) {
            SerializableSerializer serializableSerializer = SerializableSerializer.INSTANCE;
            Intrinsics.checkNotNull(serializableSerializer, "null cannot be cast to non-null type nl.adaptivity.xmlutil.util.SerializationProvider.XmlSerializerFun<T of nl.adaptivity.xmlutil.util.DefaultSerializationProvider.serializer>");
            return serializableSerializer;
        }
        return null;
    }

    @Override // nl.adaptivity.xmlutil.util.SerializationProvider
    public <T> SerializationProvider.XmlDeserializerFun deSerializer(KClass<T> type) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(type, "type");
        Object[] annotations = JvmClassMappingKt.getJavaClass((KClass) type).getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "getAnnotations(...)");
        Object[] $this$firstOrNull$iv = annotations;
        int length = $this$firstOrNull$iv.length;
        int i = 0;
        while (true) {
            if (i < length) {
                element$iv = $this$firstOrNull$iv[i];
                Annotation it = (Annotation) element$iv;
                if (Intrinsics.areEqual(it.getClass().getName(), "nl.adaptivity.xmlutil.xmlserializable.XmlDeserializer")) {
                    break;
                }
                i++;
            } else {
                element$iv = null;
                break;
            }
        }
        Annotation a = (Annotation) element$iv;
        return a != null ? DeserializerFun.INSTANCE : null;
    }

    /* compiled from: DefaultSerializationProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nH\u0096\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lnl/adaptivity/xmlutil/util/DefaultSerializationProvider$DeserializerFun;", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlDeserializerFun;", "<init>", "()V", "invoke", "T", "", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "type", "Lkotlin/reflect/KClass;", "(Lnl/adaptivity/xmlutil/XmlReader;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class DeserializerFun implements SerializationProvider.XmlDeserializerFun {
        public static final DeserializerFun INSTANCE = new DeserializerFun();

        private DeserializerFun() {
        }

        @Override // nl.adaptivity.xmlutil.util.SerializationProvider.XmlDeserializerFun
        public <T> T invoke(XmlReader input, KClass<T> type) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(type, "type");
            Object[] annotations = JvmClassMappingKt.getJavaClass((KClass) type).getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "getAnnotations(...)");
            Object[] $this$first$iv = annotations;
            for (Object element$iv : $this$first$iv) {
                Annotation it = (Annotation) element$iv;
                if (Intrinsics.areEqual(it.getClass().getName(), "nl.adaptivity.xmlutil.xmlserializable.XmlDeserializer")) {
                    Annotation a = (Annotation) element$iv;
                    Object invoke = a.getClass().getMethod("value", new Class[0]).invoke(a, new Object[0]);
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.lang.Class<*>");
                    Class factoryClass = (Class) invoke;
                    Object factory = factoryClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                    T t = (T) factoryClass.getMethod("deserialize", XmlReader.class).invoke(factory, input);
                    Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of nl.adaptivity.xmlutil.util.DefaultSerializationProvider.DeserializerFun.invoke");
                    return t;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    /* compiled from: DefaultSerializationProvider.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0096\u0002¨\u0006\n"}, d2 = {"Lnl/adaptivity/xmlutil/util/DefaultSerializationProvider$SerializableSerializer;", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlSerializerFun;", "Lnl/adaptivity/xmlutil/XmlSerializable;", "<init>", "()V", "invoke", "", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "value", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class SerializableSerializer implements SerializationProvider.XmlSerializerFun<XmlSerializable> {
        public static final SerializableSerializer INSTANCE = new SerializableSerializer();

        private SerializableSerializer() {
        }

        @Override // nl.adaptivity.xmlutil.util.SerializationProvider.XmlSerializerFun
        public void invoke(XmlWriter output, XmlSerializable value) {
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(value, "value");
            value.serialize(output);
        }
    }
}