package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: TML */
public abstract class m2 extends p2 {

    /* renamed from: c  reason: collision with root package name */
    public volatile HandlerThread f64c = null;
    public volatile a d = null;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                m2.this.a(message);
            } catch (Throwable th) {
                if (w3.a()) {
                    w3.a(m2.this.a(), "handleInnerMessage[" + message.what + "] error.", th);
                }
            }
        }
    }

    public void a(long j) {
        synchronized (this.b) {
            if (this.a) {
                if (w3.a()) {
                    w3.a(a(), "shutdown()");
                }
                c();
                b(j);
                this.a = false;
            }
        }
    }

    public abstract void a(Message message) throws Exception;

    public int b(Looper looper) {
        synchronized (this.b) {
            if (b()) {
                return -1;
            }
            this.a = true;
            if (w3.a()) {
                w3.a(a(), "startup()");
            }
            if (looper == null) {
                this.f64c = new HandlerThread("th_" + a());
                this.f64c.start();
                this.d = new a(this.f64c.getLooper());
            } else {
                this.d = new a(looper);
            }
            k4.a(this.d);
            return a(this.d.getLooper());
        }
    }

    public Handler d() {
        a aVar;
        synchronized (this.b) {
            aVar = this.d;
        }
        return aVar;
    }

    public HandlerThread e() {
        HandlerThread handlerThread;
        synchronized (this.b) {
            handlerThread = this.f64c;
        }
        return handlerThread;
    }

    public void f() {
        a(0L);
    }

    public int g() {
        return b((Looper) null);
    }

    public boolean a(int i, long j) {
        boolean a2;
        synchronized (this.b) {
            a2 = p3.a(this.d, i, j);
        }
        return a2;
    }

    public boolean a(Message message, long j) {
        boolean a2;
        synchronized (this.b) {
            a2 = p3.a(this.d, message, j);
        }
        return a2;
    }

    public final void b(long j) {
        try {
            o3.a(this.f64c, this.d, j, false);
            if (this.f64c != null) {
                k4.b(this.f64c);
            }
            this.f64c = null;
            this.d = null;
        } catch (Throwable th) {
            if (w3.a()) {
                w3.a(a(), "shutdown thread error.", th);
            }
        }
    }
}