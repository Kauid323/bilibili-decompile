package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XmlWriter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J+\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lnl/adaptivity/xmlutil/SubstreamFilterWriter;", "Lnl/adaptivity/xmlutil/XmlDelegatingWriter;", "delegate", "Lnl/adaptivity/xmlutil/XmlWriter;", "<init>", "(Lnl/adaptivity/xmlutil/XmlWriter;)V", "processingInstruction", "", "text", "", "target", "data", "endDocument", "docdecl", "startDocument", "version", "encoding", "standalone", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SubstreamFilterWriter extends XmlDelegatingWriter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubstreamFilterWriter(XmlWriter delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingWriter, nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingWriter, nl.adaptivity.xmlutil.XmlWriter
    public void processingInstruction(String target, String data) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingWriter, nl.adaptivity.xmlutil.XmlWriter
    public void endDocument() {
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingWriter, nl.adaptivity.xmlutil.XmlWriter
    public void docdecl(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    @Override // nl.adaptivity.xmlutil.XmlDelegatingWriter, nl.adaptivity.xmlutil.XmlWriter
    public void startDocument(String version, String encoding, Boolean standalone) {
    }
}