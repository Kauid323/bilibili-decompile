package facadeverify;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class r extends FutureTask<x> {
    public final /* synthetic */ w a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, Callable callable, w wVar) {
        super(callable);
        this.a = wVar;
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.a.c.a();
        super.done();
    }
}