package nl.adaptivity.xmlutil.core;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: KtXmlWriter.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\u0010\u0010\u0007\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"nl/adaptivity/xmlutil/core/KtXmlWriterKt$asCodePoints$1$iterator$1", "", "Lkotlin/UInt;", "nextPos", "", "hasNext", "", "next", "next-pVg5ArA", "()I", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KtXmlWriterKt$asCodePoints$1$iterator$1 implements Iterator<UInt>, KMappedMarker {
    final /* synthetic */ CharSequence $this_asCodePoints;
    private int nextPos;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KtXmlWriterKt$asCodePoints$1$iterator$1(CharSequence $receiver) {
        this.$this_asCodePoints = $receiver;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.box-impl(m1620nextpVg5ArA());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextPos < this.$this_asCodePoints.length();
    }

    /* renamed from: next-pVg5ArA  reason: not valid java name */
    public int m1620nextpVg5ArA() {
        if (Character.isHighSurrogate(this.$this_asCodePoints.charAt(this.nextPos))) {
            int i = UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(this.$this_asCodePoints.charAt(this.nextPos)) - 55296) << 10) + 65536) + UInt.constructor-impl(UInt.constructor-impl(this.$this_asCodePoints.charAt(this.nextPos + 1)) - 56320));
            this.nextPos += 2;
            return i;
        }
        int i2 = UInt.constructor-impl(this.$this_asCodePoints.charAt(this.nextPos));
        this.nextPos++;
        return i2;
    }
}