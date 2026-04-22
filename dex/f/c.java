package f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public abstract class c<Params, Progress, Result> {
    public final b b;
    public final C0019c c;
    public volatile int a = 1;

    /* renamed from: d  reason: collision with root package name */
    public a f1895d = new a(Looper.getMainLooper());

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                c cVar = dVar.a;
                cVar.a(dVar.b[0]);
                cVar.a = 3;
                message.obj = null;
            } else if (i2 == 2) {
                dVar.a.getClass();
            } else if (i2 != 3) {
            } else {
                dVar.a.getClass();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class b extends f<Params, Result> {
        public b() {
            super(0);
        }

        @Override // java.util.concurrent.Callable
        public final Result call() {
            c.this.getClass();
            Process.setThreadPriority(5);
            c cVar = c.this;
            cVar.getClass();
            return (Result) cVar.a();
        }
    }

    /* renamed from: f.c$c  reason: collision with other inner class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public class C0019c extends c<Params, Progress, Result>.e {
        public C0019c(b bVar) {
            super(bVar);
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return 0;
        }

        @Override // java.util.concurrent.FutureTask
        public final void done() {
            try {
                Result result = get();
                c cVar = c.this;
                cVar.f1895d.obtainMessage(1, new d(cVar, result)).sendToTarget();
            } catch (InterruptedException e2) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            } catch (CancellationException e3) {
                c.this.f1895d.obtainMessage(3, new d(c.this, null)).sendToTarget();
            } catch (ExecutionException e4) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            } catch (Throwable th) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class d<Data> {
        public final c a;
        public final Data[] b;

        public d(c cVar, Data... dataArr) {
            this.a = cVar;
            this.b = dataArr;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public abstract class e extends FutureTask<Result> implements Comparable<Object> {
        public e(b bVar) {
            super(bVar);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class f<Params, Result> implements Callable<Result> {
        public f() {
        }

        public /* synthetic */ f(int i2) {
            this();
        }
    }

    public c() {
        b bVar = new b();
        this.b = bVar;
        this.c = new C0019c(bVar);
    }

    public abstract String a();

    public abstract void a(Result result);
}