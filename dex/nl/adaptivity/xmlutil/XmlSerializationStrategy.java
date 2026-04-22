package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: XmlSerializationStrategy.kt */
@ExperimentalXmlUtilApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/XmlSerializationStrategy;", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializeXML", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "output", "Lnl/adaptivity/xmlutil/XmlWriter;", "value", "isValueChild", "", "(Lkotlinx/serialization/encoding/Encoder;Lnl/adaptivity/xmlutil/XmlWriter;Ljava/lang/Object;Z)V", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlSerializationStrategy<T> extends SerializationStrategy<T> {
    void serializeXML(Encoder encoder, XmlWriter xmlWriter, T t, boolean z);

    /* compiled from: XmlSerializationStrategy.kt */
    /* renamed from: nl.adaptivity.xmlutil.XmlSerializationStrategy$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void serializeXML$default(XmlSerializationStrategy xmlSerializationStrategy, Encoder encoder, XmlWriter xmlWriter, Object obj, boolean z, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: serializeXML");
            }
            if ((i & 8) != 0) {
                z = false;
            }
            xmlSerializationStrategy.serializeXML(encoder, xmlWriter, obj, z);
        }
    }
}