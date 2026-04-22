package nl.adaptivity.xmlutil;

import java.io.Reader;
import kotlin.Metadata;
import nl.adaptivity.xmlutil.dom2.DOMImplementation;
import nl.adaptivity.xmlutil.dom2.Node;

/* compiled from: IXmlStreaming.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0019\u0010\u0006\u001a\u00020\u00072\n\u0010\n\u001a\u00060\u000bj\u0002`\fH&¢\u0006\u0002\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0019\u0010\u0010\u001a\u00020\u00072\n\u0010\n\u001a\u00060\u000bj\u0002`\fH&¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H'J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH'R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/IXmlStreaming;", "", "setFactory", "", "factory", "Lnl/adaptivity/xmlutil/XmlStreamingFactory;", "newReader", "Lnl/adaptivity/xmlutil/XmlReader;", "input", "", "reader", "Ljava/io/Reader;", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Reader;", "(Ljava/io/Reader;)Lnl/adaptivity/xmlutil/XmlReader;", "source", "Lnl/adaptivity/xmlutil/dom2/Node;", "newGenericReader", "newWriter", "Lnl/adaptivity/xmlutil/DomWriter;", "dest", "genericDomImplementation", "Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "getGenericDomImplementation", "()Lnl/adaptivity/xmlutil/dom2/DOMImplementation;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IXmlStreaming {
    DOMImplementation getGenericDomImplementation();

    XmlReader newGenericReader(Reader reader);

    XmlReader newGenericReader(CharSequence charSequence);

    XmlReader newReader(Reader reader);

    XmlReader newReader(CharSequence charSequence);

    @ExperimentalXmlUtilApi
    XmlReader newReader(Node node);

    @ExperimentalXmlUtilApi
    DomWriter newWriter();

    @ExperimentalXmlUtilApi
    DomWriter newWriter(Node node);

    void setFactory(XmlStreamingFactory xmlStreamingFactory);
}