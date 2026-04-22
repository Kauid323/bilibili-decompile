package kotlinx.io;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffer.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0006H\u0081\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"seek", "T", "Lkotlinx/io/Buffer;", "fromIndex", "", "lambda", "Lkotlin/Function2;", "Lkotlinx/io/Segment;", "(Lkotlinx/io/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BufferKt {
    public static final /* synthetic */ <T> T seek(Buffer $this$seek, long fromIndex, Function2<? super Segment, ? super Long, ? extends T> lambda) {
        Intrinsics.checkNotNullParameter($this$seek, "<this>");
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        if ($this$seek.getHead() == null) {
            return lambda.invoke(null, -1L);
        }
        if ($this$seek.getSize() - fromIndex < fromIndex) {
            Segment s = $this$seek.getTail();
            long offset = $this$seek.getSize();
            while (s != null && offset > fromIndex) {
                offset -= s.getLimit() - s.getPos();
                if (offset <= fromIndex) {
                    break;
                }
                s = s.getPrev();
            }
            return lambda.invoke(s, Long.valueOf(offset));
        }
        Segment s2 = $this$seek.getHead();
        long offset2 = 0;
        while (s2 != null) {
            long nextOffset = (s2.getLimit() - s2.getPos()) + offset2;
            if (nextOffset > fromIndex) {
                break;
            }
            s2 = s2.getNext();
            offset2 = nextOffset;
        }
        return lambda.invoke(s2, Long.valueOf(offset2));
    }
}