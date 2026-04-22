package nl.adaptivity.xmlutil.core;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: KtXmlWriter.kt */
@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"nl/adaptivity/xmlutil/core/KtXmlWriterKt$asCodePoints$1", "", "Lkotlin/UInt;", "iterator", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KtXmlWriterKt$asCodePoints$1 implements Iterable<UInt>, KMappedMarker {
    final /* synthetic */ CharSequence $this_asCodePoints;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KtXmlWriterKt$asCodePoints$1(CharSequence $receiver) {
        this.$this_asCodePoints = $receiver;
    }

    @Override // java.lang.Iterable
    public Iterator<UInt> iterator() {
        return new KtXmlWriterKt$asCodePoints$1$iterator$1(this.$this_asCodePoints);
    }
}