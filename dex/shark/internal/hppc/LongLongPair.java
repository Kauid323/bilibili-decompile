package shark.internal.hppc;

import kotlin.Metadata;

/* compiled from: Tuples.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lshark/internal/hppc/LongLongPair;", "", "first", "", "second", "(JJ)V", "getFirst", "()J", "getSecond", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class LongLongPair {
    private final long first;
    private final long second;

    public static /* synthetic */ LongLongPair copy$default(LongLongPair longLongPair, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = longLongPair.first;
        }
        if ((i & 2) != 0) {
            j2 = longLongPair.second;
        }
        return longLongPair.copy(j, j2);
    }

    public final long component1() {
        return this.first;
    }

    public final long component2() {
        return this.second;
    }

    public final LongLongPair copy(long j, long j2) {
        return new LongLongPair(j, j2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LongLongPair) {
                LongLongPair longLongPair = (LongLongPair) obj;
                return this.first == longLongPair.first && this.second == longLongPair.second;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.first;
        long j2 = this.second;
        return (((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2));
    }

    public String toString() {
        return "LongLongPair(first=" + this.first + ", second=" + this.second + ")";
    }

    public LongLongPair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }
}