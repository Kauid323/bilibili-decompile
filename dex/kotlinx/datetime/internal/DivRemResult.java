package kotlinx.datetime.internal;

import kotlin.Metadata;

/* compiled from: math.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u0086\u0002J\t\u0010\n\u001a\u00020\u0003H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/internal/DivRemResult;", "", "q", "", "r", "(JJ)V", "getQ", "()J", "getR", "component1", "component2", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DivRemResult {
    private final long q;
    private final long r;

    public DivRemResult(long q, long r) {
        this.q = q;
        this.r = r;
    }

    public final long getQ() {
        return this.q;
    }

    public final long getR() {
        return this.r;
    }

    public final long component1() {
        return this.q;
    }

    public final long component2() {
        return this.r;
    }
}