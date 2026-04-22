package shark.internal.hppc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tuples.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lshark/internal/hppc/LongObjectPair;", "B", "", "first", "", "second", "(JLjava/lang/Object;)V", "getFirst", "()J", "getSecond", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(JLjava/lang/Object;)Lshark/internal/hppc/LongObjectPair;", "equals", "", "other", "hashCode", "", "toString", "", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class LongObjectPair<B> {
    private final long first;
    private final B second;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LongObjectPair copy$default(LongObjectPair longObjectPair, long j, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            j = longObjectPair.first;
        }
        if ((i & 2) != 0) {
            obj = longObjectPair.second;
        }
        return longObjectPair.copy(j, obj);
    }

    public final long component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final LongObjectPair<B> copy(long j, B b) {
        return new LongObjectPair<>(j, b);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LongObjectPair) {
                LongObjectPair longObjectPair = (LongObjectPair) obj;
                return this.first == longObjectPair.first && Intrinsics.areEqual(this.second, longObjectPair.second);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.first;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        B b = this.second;
        return i + (b != null ? b.hashCode() : 0);
    }

    public String toString() {
        return "LongObjectPair(first=" + this.first + ", second=" + this.second + ")";
    }

    public LongObjectPair(long first, B b) {
        this.first = first;
        this.second = b;
    }

    public final long getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }
}