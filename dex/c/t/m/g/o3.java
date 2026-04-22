package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TML */
public class o3 {

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends TimerTask {
        public final /* synthetic */ HandlerThread a;
        public final /* synthetic */ Handler b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f76c;
        public final /* synthetic */ Timer d;

        public a(HandlerThread handlerThread, Handler handler, boolean z, Timer timer) {
            this.a = handlerThread;
            this.b = handler;
            this.f76c = z;
            this.d = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                o3.b(this.a, this.b, this.f76c);
                if (this.d != null) {
                    this.d.cancel();
                }
            } catch (Throwable th) {
                if (w3.a()) {
                    w3.a("HandlerThreadUtil", "timertask error.", th);
                }
            }
        }
    }

    public static void b(HandlerThread handlerThread, Handler handler, boolean z) {
        if (z) {
            try {
                p3.b(handler);
            } catch (Throwable th) {
                if (w3.a()) {
                    w3.a("HandlerThreadUtil", "quit error.", th);
                    return;
                }
                return;
            }
        }
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    public static void a(HandlerThread handlerThread, Handler handler, long j, boolean z) {
        if (handlerThread == null && handler == null) {
            return;
        }
        if (j <= 0) {
            b(handlerThread, handler, z);
            return;
        }
        Timer timer = new Timer("th_loc_tmp");
        timer.schedule(new a(handlerThread, handler, z, timer), j);
    }
}