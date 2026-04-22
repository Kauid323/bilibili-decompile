package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

/* compiled from: XmlSerializer.kt */
@ExperimentalXmlUtilApi
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/XmlSerializer;", "T", "Lkotlinx/serialization/KSerializer;", "Lnl/adaptivity/xmlutil/XmlSerializationStrategy;", "Lnl/adaptivity/xmlutil/XmlDeserializationStrategy;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlSerializer<T> extends KSerializer<T>, XmlSerializationStrategy<T>, XmlDeserializationStrategy<T> {
}