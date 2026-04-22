package c.t.m.g;

/* compiled from: TML */
public abstract class o2 {
    public volatile boolean a = false;
    public byte[] b = new byte[0];

    public abstract String a();

    public boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.a;
        }
        return z;
    }

    public void c() {
        synchronized (this.b) {
            if (this.a) {
                if (w3.a()) {
                    w3.a(a(), "shutdown()");
                }
                d();
                this.a = false;
            }
        }
    }

    public abstract void d();
}