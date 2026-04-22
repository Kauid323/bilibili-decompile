package c.t.m.g;

/* compiled from: TML */
public class r1 extends p1 {
    public int a;
    public int b;

    public r1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // c.t.m.g.p1
    public int a() {
        return 10005;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }
}