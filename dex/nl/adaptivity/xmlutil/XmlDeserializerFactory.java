package nl.adaptivity.xmlutil;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: XmlDeserializerFactory.kt */
@Deprecated(message = "This should be replaced by kotlinx.serialization or the xmlserializable module", replaceWith = @ReplaceWith(expression = "nl.adaptivity.xmlutil.xmlserializable.XmlDeserializerFactory", imports = {}))
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/XmlDeserializerFactory;", "T", "", "deserialize", "reader", "Lnl/adaptivity/xmlutil/XmlReader;", "(Lnl/adaptivity/xmlutil/XmlReader;)Ljava/lang/Object;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlDeserializerFactory<T> {
    T deserialize(XmlReader xmlReader);
}