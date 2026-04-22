package c.t.m.g;

/* compiled from: TML */
public abstract class t3 implements Runnable, Comparable<t3> {
    public int a = 2;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f100c;
    public long d;

    public void a(long j) {
        this.b = j;
    }

    public void b(long j) {
        this.f100c = j;
    }

    public abstract void c();

    public void c(long j) {
        this.d = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d = System.currentTimeMillis() - this.f100c;
        c();
    }

    public long a() {
        return this.f100c;
    }

    public long b() {
        return this.d;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(t3 t3Var) {
        int i = this.a;
        int i2 = t3Var.a;
        return (i != i2 ? i <= i2 : this.b >= t3Var.b) ? 1 : -1;
    }
}