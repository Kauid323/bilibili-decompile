package c.t.m.g;

/* compiled from: TML */
public class c5 {
    public float b;
    public double g;
    public double j;
    public double d = -1.0d;
    public double e = -1.0d;
    public double f = -1.0d;
    public float a = -1.0f;

    /* renamed from: c  reason: collision with root package name */
    public long f16c = -1;
    public double h = 0.0d;
    public double i = 0.0d;

    public double a() {
        return this.d;
    }

    public double b() {
        return this.e;
    }

    public void c() {
        this.f = -1.0d;
        this.a = -1.0f;
        this.f16c = -1L;
        this.h = 0.0d;
        this.i = 0.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0280, code lost:
        if ((r11 - r30.d) <= 0.0d) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0291, code lost:
        if ((r11 - r30.d) < 0.0d) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0293, code lost:
        r30.d += r30.h * (r13 / 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(double d, double d2, double d3, long j) {
        double d4;
        double d5;
        double d6;
        String str;
        double d7;
        long j2;
        double d8;
        String str2;
        long j3;
        double d9 = d3 < 1.0d ? 1.0d : d3;
        a7.b("a", "lat_me:" + d + ",lng_me:" + d2 + ",accuracy:" + d9 + ",time:" + j + ",lat:" + this.d + ",lng:" + this.e);
        if (j - this.f16c >= 20000) {
            a7.b("a", "Time:" + j + ",last_time:" + this.f16c);
            c();
        }
        this.a = (float) (Math.abs(d - this.d) * 1000000.0d);
        this.b = (float) (Math.abs(d2 - this.e) * 1000000.0d);
        a7.b("a", "Q:" + this.a + ",QLng:" + this.b);
        if (this.f < 0.0d) {
            this.f16c = j;
            this.d = d;
            this.e = d2;
            this.f = d9 * d9;
            return;
        }
        long j4 = j - this.f16c;
        if (j4 < 1000) {
            j4 = 1000;
        }
        if (j4 > 0) {
            double d10 = j4;
            this.f += d10;
            this.g += d10;
        }
        double d11 = this.f;
        double d12 = d9 * d9;
        double d13 = d9;
        double d14 = d11 / ((d11 + d12) + (this.a * 5.0f));
        double d15 = this.g;
        double d16 = d15 / ((d15 + d12) + (this.b * 5.0f));
        a7.b("a", "K:" + d14 + ",KLng:" + d16);
        if (d14 < 0.4d || d16 < 0.4d) {
            d4 = d2;
            d5 = d14;
            d6 = d16;
            str = "a";
            if (this.h > 0.0d) {
                d7 = d;
            } else {
                d7 = d;
            }
            if (this.h < 0.0d) {
            }
            if ((this.i > 0.0d && d4 - this.e > 0.0d) || (this.i < 0.0d && d4 - this.e < 0.0d)) {
                this.e += this.i * (j4 / 1000);
            }
            double d17 = j4;
            this.f -= d17;
            this.g -= d17;
        } else {
            double d18 = this.d;
            d6 = d16;
            if ((this.h <= 0.0d || d - d18 <= 0.0d) && (this.h >= 0.0d || d - this.d >= 0.0d)) {
                str2 = "a";
            } else {
                str2 = "a";
                this.d += this.h * (j4 / 1000);
            }
            double d19 = this.d;
            this.d = d19 + ((d - d19) * d14);
            str = str2;
            a7.b(str, "lat:" + this.d + ",tmp:" + d18 + ",timeInc:" + j4);
            double d20 = this.d - d18;
            double d21 = j4 / 1000;
            this.h = d20 / d21;
            double d22 = this.e;
            if (this.i > 0.0d) {
                d4 = d2;
                if (d4 - d22 > 0.0d) {
                    d5 = d14;
                    j3 = j4;
                    this.e += this.i * d21;
                    double d23 = this.e;
                    this.e = d23 + ((d4 - d23) * d6);
                    a7.b(str, "lng:" + this.e + ",tmp:" + d22 + ",timeInc:" + j3);
                    this.i = (this.e - d22) / d21;
                    this.f = (1.0d - d5) * this.f;
                    this.g = (1.0d - d6) * this.g;
                    this.f16c = j;
                    a7.b(str, "last_metres_per_second:" + this.h + ",last_metres_per_second_lng:" + this.i);
                    d7 = d;
                }
            } else {
                d4 = d2;
            }
            d5 = d14;
            if (this.i >= 0.0d || d4 - this.e >= 0.0d) {
                j3 = j4;
                double d232 = this.e;
                this.e = d232 + ((d4 - d232) * d6);
                a7.b(str, "lng:" + this.e + ",tmp:" + d22 + ",timeInc:" + j3);
                this.i = (this.e - d22) / d21;
                this.f = (1.0d - d5) * this.f;
                this.g = (1.0d - d6) * this.g;
                this.f16c = j;
                a7.b(str, "last_metres_per_second:" + this.h + ",last_metres_per_second_lng:" + this.i);
                d7 = d;
            }
            j3 = j4;
            this.e += this.i * d21;
            double d2322 = this.e;
            this.e = d2322 + ((d4 - d2322) * d6);
            a7.b(str, "lng:" + this.e + ",tmp:" + d22 + ",timeInc:" + j3);
            this.i = (this.e - d22) / d21;
            this.f = (1.0d - d5) * this.f;
            this.g = (1.0d - d6) * this.g;
            this.f16c = j;
            a7.b(str, "last_metres_per_second:" + this.h + ",last_metres_per_second_lng:" + this.i);
            d7 = d;
        }
        a7.b(str, "variance:" + this.f + ",vaLng:" + this.g);
        if (d13 != 30.0d || d5 < 0.5d || d6 < 0.5d) {
            j2 = j;
            d8 = d12;
        } else {
            this.d = d7;
            this.e = d4;
            this.h = 0.0d;
            this.i = 0.0d;
            j2 = j;
            this.f16c = j2;
            d8 = d12;
            this.f = d8;
        }
        if (this.j > 100.0d && d13 <= 30.0d) {
            this.d = d7;
            this.e = d4;
            this.h = 0.0d;
            this.i = 0.0d;
            this.f16c = j2;
            this.f = d8;
        }
        this.j = d13;
    }
}