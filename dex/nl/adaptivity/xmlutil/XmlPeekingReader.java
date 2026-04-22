package nl.adaptivity.xmlutil;

import kotlin.Metadata;

/* compiled from: XmlPeekingReader.kt */
@XmlUtilInternal
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/XmlPeekingReader;", "Lnl/adaptivity/xmlutil/XmlReader;", "hasPeekItems", "", "getHasPeekItems", "()Z", "pushBackCurrent", "", "peekNextEvent", "Lnl/adaptivity/xmlutil/EventType;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlPeekingReader extends XmlReader {
    boolean getHasPeekItems();

    EventType peekNextEvent();

    void pushBackCurrent();
}