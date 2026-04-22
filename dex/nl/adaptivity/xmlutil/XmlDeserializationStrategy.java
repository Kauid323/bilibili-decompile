package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: XmlDeserializationStrategy.kt */
@ExperimentalXmlUtilApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J3\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/XmlDeserializationStrategy;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializeXML", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "input", "Lnl/adaptivity/xmlutil/XmlReader;", "previousValue", "isValueChild", "", "(Lkotlinx/serialization/encoding/Decoder;Lnl/adaptivity/xmlutil/XmlReader;Ljava/lang/Object;Z)Ljava/lang/Object;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlDeserializationStrategy<T> extends DeserializationStrategy<T> {
    T deserializeXML(Decoder decoder, XmlReader xmlReader, T t, boolean z);

    /* compiled from: XmlDeserializationStrategy.kt */
    /* renamed from: nl.adaptivity.xmlutil.XmlDeserializationStrategy$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object deserializeXML$default(XmlDeserializationStrategy xmlDeserializationStrategy, Decoder decoder, XmlReader xmlReader, Object obj, boolean z, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                if ((i & 8) != 0) {
                    z = false;
                }
                return xmlDeserializationStrategy.deserializeXML(decoder, xmlReader, obj, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deserializeXML");
        }
    }
}