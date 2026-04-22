package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XmlReaderUtil.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0001¨\u0006\u0004"}, d2 = {"asSubstream", "Lnl/adaptivity/xmlutil/XmlReader;", "toEvent", "Lnl/adaptivity/xmlutil/XmlEvent;", "core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "nl/adaptivity/xmlutil/XmlReaderUtil")
final /* synthetic */ class XmlReaderUtil__XmlReaderUtilKt {
    public static final XmlReader asSubstream(XmlReader $this$asSubstream) {
        Intrinsics.checkNotNullParameter($this$asSubstream, "<this>");
        return new SubstreamFilterReader($this$asSubstream);
    }

    public static final XmlEvent toEvent(XmlReader $this$toEvent) {
        Intrinsics.checkNotNullParameter($this$toEvent, "<this>");
        return $this$toEvent.getEventType().createEvent($this$toEvent);
    }
}