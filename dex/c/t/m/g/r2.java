package c.t.m.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: TML */
public class r2 {
    public static r2 e = new r2();
    public static final Comparator<double[]> f = new a();
    public final List<double[]> a = new ArrayList(32);
    public final List<double[]> b = new ArrayList(32);

    /* renamed from: c  reason: collision with root package name */
    public int f91c = 0;
    public int d = 4096;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Comparator<double[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(double[] dArr, double[] dArr2) {
            return dArr.length - dArr2.length;
        }
    }

    public static r2 a() {
        return e;
    }

    public final synchronized void b() {
        while (this.f91c > this.d) {
            double[] remove = this.a.remove(0);
            this.b.remove(remove);
            this.f91c -= remove.length;
        }
    }

    public synchronized double[] a(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            double[] dArr = this.b.get(i2);
            if (dArr.length == i) {
                this.f91c -= dArr.length;
                this.b.remove(i2);
                this.a.remove(dArr);
                return dArr;
            }
        }
        return new double[i];
    }

    public synchronized void a(double[] dArr) {
        if (dArr != null) {
            if (dArr.length <= this.d) {
                Arrays.fill(dArr, 0.0d);
                this.a.add(dArr);
                int binarySearch = Collections.binarySearch(this.b, dArr, f);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.b.add(binarySearch, dArr);
                this.f91c += dArr.length;
                b();
            }
        }
    }
}