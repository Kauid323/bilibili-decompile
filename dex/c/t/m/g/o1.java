package c.t.m.g;

import java.util.Observable;

/* compiled from: TML */
public class o1 {
    public static volatile o1 b;
    public b a = new b();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class b extends Observable {
        public b() {
        }

        @Override // java.util.Observable
        public void notifyObservers(Object obj) {
            setChanged();
            super.notifyObservers(obj);
        }
    }

    public static o1 a() {
        w3.c("DATABUS_TEST", "getDataBus thread: " + Thread.currentThread().getId());
        if (b == null) {
            synchronized (o1.class) {
                if (b == null) {
                    b = new o1();
                }
            }
        }
        w3.c("DATABUS_TEST", "getDataBus mInstance is null: " + (b == null));
        return b;
    }

    public void b(q1 q1Var) {
        this.a.deleteObserver(q1Var);
    }

    public void a(p1 p1Var) {
        this.a.notifyObservers(p1Var);
    }

    public void a(q1 q1Var) {
        this.a.addObserver(q1Var);
    }
}