package facadeverify;

public class l0 extends Exception {
    public Throwable a;

    public l0(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    public l0(Throwable th) {
        super(th.getMessage());
        this.a = th;
    }
}