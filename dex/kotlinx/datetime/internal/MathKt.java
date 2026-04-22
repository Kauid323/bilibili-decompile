package kotlinx.datetime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;

/* compiled from: math.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\b\u001a\u0019\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0082\b\u001a\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\b\u001a(\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u001a \u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0018\u001a\u00020\n*\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0019"}, d2 = {"POWERS_OF_TEN", "", "getPOWERS_OF_TEN", "()[I", "high", "", "x", "indexBit", "value", "bit", "", "low", "multiplyAddAndDivide", "d", "n", "r", "m", "multiplyAndAdd", "multiplyAndDivide", "Lkotlinx/datetime/internal/DivRemResult;", "a", "b", "c", "safeMultiplyOrZero", "clampToInt", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MathKt {
    private static final int[] POWERS_OF_TEN = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    public static final int clampToInt(long $this$clampToInt) {
        if ($this$clampToInt > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return $this$clampToInt < -2147483648L ? IntCompanionObject.MIN_VALUE : (int) $this$clampToInt;
    }

    public static final long safeMultiplyOrZero(long a, long b) {
        if (b == -1) {
            if (a == Long.MIN_VALUE) {
                return 0L;
            }
            return -a;
        } else if (b == 1) {
            return a;
        } else {
            long total = a * b;
            if (total / b != a) {
                return 0L;
            }
            return total;
        }
    }

    public static final DivRemResult multiplyAndDivide(long a, long b, long c) {
        int sign;
        long nextBit;
        if (a == 0 || b == 0) {
            return new DivRemResult(0L, 0L);
        }
        long ab = safeMultiplyOrZero(a, b);
        if (ab != 0) {
            return new DivRemResult(ab / c, ab % c);
        }
        if (b == c) {
            return new DivRemResult(a, 0L);
        }
        if (a == c) {
            return new DivRemResult(b, 0L);
        }
        long ae = a >= 0 ? 0L : -1L;
        long be = b >= 0 ? 0L : -1L;
        long al = a & 4294967295L;
        long ah = (a >> 32) & 4294967295L;
        long bl = b & 4294967295L;
        long bh = (b >> 32) & 4294967295L;
        long w = (ae * bh) + (ah * be);
        long x = (ae * bl) + (ah * bh) + (al * be);
        long y1 = ah * bl;
        long y2 = al * bh;
        long z = al * bl;
        long r4 = z & 4294967295L;
        long r3c = (y1 & 4294967295L) + (y2 & 4294967295L) + ((z >> 32) & 4294967295L);
        long r3 = r3c & 4294967295L;
        long r2c = ((r3c >> 32) & 4294967295L) + (x & 4294967295L) + ((y1 >> 32) & 4294967295L) + ((y2 >> 32) & 4294967295L);
        long r2 = r2c & 4294967295L;
        long r1 = ((r2c >> 32) & 4294967295L) + ((x >> 32) & 4294967295L) + (w & 4294967295L);
        long abl = (r3 << 32) | r4;
        long abh = (r1 << 32) | r2;
        int bit$iv = (((abh >> 63) & 1) > 1L ? 1 : (((abh >> 63) & 1) == 1L ? 0 : -1));
        int sign2 = bit$iv == 0 ? -1 : 1;
        if (sign2 == -1) {
            sign = sign2;
            abl = (~abl) + 1;
            abh = ~abh;
            if (abl == 0) {
                abh++;
            }
        } else {
            sign = sign2;
        }
        long q = 0;
        long r = 0;
        for (int bitNo = 127; -1 < bitNo; bitNo--) {
            if (bitNo < 64) {
                nextBit = (abl >> bitNo) & 1;
            } else {
                int bit$iv2 = bitNo - 64;
                nextBit = (abh >> bit$iv2) & 1;
            }
            r = (r << 1) | nextBit;
            if (r >= c || r < 0) {
                r -= c;
                if (bitNo >= 63) {
                    throw new ArithmeticException("The result of a multiplication followed by division overflows a long");
                }
                q |= 1 << bitNo;
            }
        }
        int sign3 = sign;
        long j = sign3 * q;
        long q2 = sign3;
        return new DivRemResult(j, q2 * r);
    }

    private static final long low(long x) {
        return 4294967295L & x;
    }

    private static final long high(long x) {
        return (x >> 32) & 4294967295L;
    }

    private static final long indexBit(long value, int bit) {
        return (value >> bit) & 1;
    }

    public static final long multiplyAddAndDivide(long d, long n, long r, long m) {
        long md;
        long mr;
        if (d > 0 && r < 0) {
            long md2 = d - 1;
            long mr2 = r + n;
            md = md2;
            mr = mr2;
        } else if (d < 0 && r > 0) {
            long md3 = d + 1;
            long mr3 = r - n;
            md = md3;
            mr = mr3;
        } else {
            md = d;
            mr = r;
        }
        if (md == 0) {
            return mr / m;
        }
        DivRemResult multiplyAndDivide = multiplyAndDivide(md, n, m);
        long rd = multiplyAndDivide.component1();
        long rr = multiplyAndDivide.component2();
        return MathJvmKt.safeAdd(rd, MathJvmKt.safeAdd(mr / m, MathJvmKt.safeAdd(mr % m, rr) / m));
    }

    public static final long multiplyAndAdd(long d, long n, long r) {
        long md = d;
        long mr = r;
        if (d > 0 && r < 0) {
            md--;
            mr += n;
        } else if (d < 0 && r > 0) {
            md++;
            mr -= n;
        }
        return MathJvmKt.safeAdd(MathJvmKt.safeMultiply(md, n), mr);
    }

    public static final int[] getPOWERS_OF_TEN() {
        return POWERS_OF_TEN;
    }
}