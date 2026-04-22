package shark.internal.hppc;

import kotlin.Metadata;

/* compiled from: Tuples.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0080\u0004¢\u0006\u0002\u0010\u0005\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\u00020\u00072\u0006\u0010\u0004\u001a\u0002H\u0002H\u0080\u0004¢\u0006\u0002\u0010\b\u001a\u0015\u0010\u0000\u001a\u00020\t*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0080\u0004¨\u0006\n"}, d2 = {"to", "Lshark/internal/hppc/IntObjectPair;", "B", "", "that", "(ILjava/lang/Object;)Lshark/internal/hppc/IntObjectPair;", "Lshark/internal/hppc/LongObjectPair;", "", "(JLjava/lang/Object;)Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/hppc/LongLongPair;", "shark-graph"}, k = 2, mv = {1, 4, 1})
public final class TuplesKt {
    public static final <B> LongObjectPair<B> to(long $this$to, B b) {
        return new LongObjectPair<>($this$to, b);
    }

    public static final <B> IntObjectPair<B> to(int $this$to, B b) {
        return new IntObjectPair<>($this$to, b);
    }

    public static final LongLongPair to(long $this$to, long that) {
        return new LongLongPair($this$to, that);
    }
}