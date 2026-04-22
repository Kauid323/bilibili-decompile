package c.t.m.g;

import java.util.Observable;
import java.util.Observer;

/* compiled from: TML */
public abstract class q1 implements Observer {
    public abstract void a(p1 p1Var);

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof p1) {
            a((p1) obj);
        }
    }
}