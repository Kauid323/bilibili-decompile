package nl.adaptivity.xmlutil.util;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.reflect.KClass;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlWriter;

/* compiled from: SerializationProvider.kt */
@Deprecated(message = "This doesn't really belong in this library.", replaceWith = @ReplaceWith(expression = "nl.adaptivity.xmlutil.xmlserializable.util.SerializationProvider", imports = {}))
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\t\nJ(\u0010\u0002\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H&J\"\u0010\u0007\u001a\u0004\u0018\u00010\b\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/util/SerializationProvider;", "", "serializer", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlSerializerFun;", "T", "type", "Lkotlin/reflect/KClass;", "deSerializer", "Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlDeserializerFun;", "XmlSerializerFun", "XmlDeserializerFun", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SerializationProvider {

    /* compiled from: SerializationProvider.kt */
    @Deprecated(message = "This doesn't really belong in this library.", replaceWith = @ReplaceWith(expression = "nl.adaptivity.xmlutil.xmlserializable.util.SerializationProvider.XmlDeserializerFun", imports = {}))
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H¦\u0002¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlDeserializerFun;", "", "invoke", "T", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "type", "Lkotlin/reflect/KClass;", "(Lnl/adaptivity/xmlutil/XmlReader;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface XmlDeserializerFun {
        <T> T invoke(XmlReader xmlReader, KClass<T> kClass);
    }

    /* compiled from: SerializationProvider.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/util/SerializationProvider$XmlSerializerFun;", "T", "", "invoke", "", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "value", "(Lnl/adaptivity/xmlutil/XmlWriter;Ljava/lang/Object;)V", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Deprecated(message = "This doesn't really belong in this library.", replaceWith = @ReplaceWith(expression = "nl.adaptivity.xmlutil.xmlserializable.util.SerializationProvider.XmlSerializerFun<T>", imports = {}))
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface XmlSerializerFun<T> {
        void invoke(XmlWriter xmlWriter, T t);
    }

    <T> XmlDeserializerFun deSerializer(KClass<T> kClass);

    <T> XmlSerializerFun<T> serializer(KClass<T> kClass);
}