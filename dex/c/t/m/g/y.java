package c.t.m.g;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: TML */
public class y extends w {
    public z b;

    /* renamed from: c  reason: collision with root package name */
    public double[] f123c = new double[3];
    public ArrayList<w> a = new ArrayList<>();

    public y() {
        z zVar = new z();
        this.b = zVar;
        this.a.add(zVar);
    }

    @Override // c.t.m.g.w
    public void a() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }

    @Override // c.t.m.g.w
    public String b() {
        StringBuilder sb = new StringBuilder(this.a.get(0).b());
        for (int i = 1; i < this.a.size(); i++) {
            sb.append('_').append(this.a.get(i).b());
        }
        return sb.toString();
    }

    @Override // c.t.m.g.w
    public void c() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).c();
        }
    }

    @Override // c.t.m.g.w
    public void d() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).d();
        }
    }

    @Override // c.t.m.g.w
    public double[] a(double[] dArr) {
        Arrays.fill(this.f123c, 0.0d);
        double[] a = this.b.a(dArr);
        w3.a("ArAlgoProxy", "pObserver SVM," + v2.a(a, 4, false));
        double[] dArr2 = this.f123c;
        System.arraycopy(a, 0, dArr2, 0, dArr2.length);
        return this.f123c;
    }

    @Override // c.t.m.g.w
    public double[] a(double[][] dArr) {
        return c0.b(dArr);
    }
}