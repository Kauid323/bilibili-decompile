package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.map.geolocation.util.SoUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: TML */
public class n5 {
    public final LinkedBlockingQueue<b> a = new LinkedBlockingQueue<>(3);
    public final m4 b;

    /* renamed from: c  reason: collision with root package name */
    public long f72c;
    public long d;
    public long e;
    public long f;
    public volatile boolean g;
    public boolean h;
    public volatile Handler i;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n5.this.a.clear();
            n5.this.b();
        }
    }

    public n5(m4 m4Var) {
        this.b = m4Var;
    }

    public void c() {
        if (this.g) {
            this.g = false;
            this.a.clear();
            this.a.offer(b.i);
            this.i = null;
            if (this.f != 0) {
                a7.c("TxRequestSender", String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", Long.valueOf((SystemClock.elapsedRealtime() - this.f) / 1000), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f72c)));
            }
            a();
            a7.c("TxRequestSender", "shut down");
        }
    }

    public void a(String str, y5 y5Var, int i) {
        try {
            a7.b("TxRequestSender", str);
            if (e5.d && e5.e) {
                a7.c("TxRequestSender", "currnt reqeust is iot");
                byte[] a2 = h7.a(str.getBytes("GBK"));
                String a3 = a(a2, i);
                a7.b("TxRequestSender", "postLocationRequest url = " + a3);
                b bVar = new b(1, a2, a3, y5Var, true);
                bVar.g = str;
                a(bVar);
            } else {
                a7.c("TxRequestSender", "currnt reqeust is not iot");
                byte[] a4 = m4.b().f().a(h7.a(str.getBytes("GBK")), m4.b().c(), false);
                String a5 = e5.a(i);
                a7.b("TxRequestSender", "rsa postLocationRequest url = " + a5);
                b bVar2 = new b(1, a4, a5, y5Var, false);
                bVar2.g = str;
                a(bVar2);
            }
        } catch (Throwable th) {
            a7.a("TxRequestSender", "", th);
        }
    }

    public final void b() {
        long j;
        b take;
        LinkedBlockingQueue<b> linkedBlockingQueue = this.a;
        b bVar = null;
        while (this.g) {
            try {
                take = linkedBlockingQueue.take();
                try {
                    try {
                    } catch (IOException e) {
                        e = e;
                        j = 0;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    bVar = take;
                    a7.a("TxRequestSender", "run: thread is interrupted", e);
                } catch (Throwable th) {
                    th = th;
                    bVar = take;
                    a7.a("TxRequestSender", "run: other exception.", th);
                }
            } catch (IOException e3) {
                e = e3;
                j = 0;
            } catch (InterruptedException e4) {
                e = e4;
            } catch (Throwable th2) {
                th = th2;
            }
            if (b.i == take) {
                a7.c("TxRequestSender", "run: state=[shutdown]");
                return;
            }
            j = System.currentTimeMillis();
            try {
                Bundle a2 = this.b.a(take.f73c, take.b, true, take.d);
                String string = a2.getString(com.alipay.sdk.m.q.k.f247c);
                a7.b("TxRequestSender", "rsa result : " + string);
                long currentTimeMillis = System.currentTimeMillis() - j;
                a7.a("cost:" + currentTimeMillis + ",result:" + string);
                if (string == null) {
                    string = "";
                }
                a(take, string);
                Handler handler = this.i;
                take.h = j;
                if (!this.h && this.g && handler != null && handler.getLooper().getThread().isAlive()) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.arg1 = (int) currentTimeMillis;
                    a(string, take, obtainMessage);
                }
                if (take.a == 1 && this.b.a().g() == 0) {
                    this.b.a().a(currentTimeMillis);
                    this.b.a().c(a2.getString("req_key"));
                }
                bVar = take;
            } catch (IOException e5) {
                e = e5;
                bVar = take;
                a7.a("TxRequestSender", "cost:" + (System.currentTimeMillis() - j) + ",run: io error", e);
                b(bVar);
                a7.b("TxRequestSender", "Send timeout");
                Handler handler2 = this.i;
                Looper looper = handler2 == null ? null : handler2.getLooper();
                if (looper != null && looper.getThread().isAlive()) {
                    handler2.sendEmptyMessageDelayed(4998, 0L);
                }
            }
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class b {
        public static final b i = new b();
        public final int a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public final String f73c;
        public final boolean d;
        public final Object e;
        public int f;
        public String g;
        public long h;

        public b() {
            this.f = 1;
            this.a = 0;
            this.b = null;
            this.f73c = null;
            this.e = null;
            this.d = false;
        }

        public static /* synthetic */ int f(b bVar) {
            int i2 = bVar.f;
            bVar.f = i2 - 1;
            return i2;
        }

        public b(int i2, byte[] bArr, String str, Object obj, boolean z) {
            this.f = 1;
            this.a = i2;
            this.b = bArr;
            this.f73c = str;
            this.e = obj;
            this.d = z;
        }
    }

    public final boolean a(b bVar) {
        boolean z;
        String str;
        if (bVar.b == null) {
            z = false;
        } else {
            z = this.a.offer(bVar);
        }
        if (!z) {
            this.a.clear();
            this.a.offer(bVar);
            if (bVar.a == 2) {
                str = "List";
            } else {
                str = bVar.a == 3 ? "Wifis" : "Location";
            }
            a7.b("TxRequestSender", "post" + str + "Request: failed to add request,because the queue has full,so we delete the first");
        }
        return z;
    }

    public void a(Handler handler, boolean z) {
        if (this.g) {
            return;
        }
        this.g = true;
        this.i = handler;
        this.h = z;
        this.b.h().execute(new a());
        this.f = SystemClock.elapsedRealtime();
        a7.c("TxRequestSender", "start up");
    }

    public final void b(b bVar) {
        boolean z;
        b.f(bVar);
        Iterator<b> it = this.a.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().a == bVar.a) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (bVar.f <= 0 || z) {
            return;
        }
        a7.c("TxRequestSender", "retryIfNeed: times=" + bVar.f);
        this.a.offer(bVar);
    }

    public final void a() {
        this.f72c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }

    public final void a(b bVar, String str) throws FileNotFoundException, IOException {
        byte[] a2;
        this.f72c++;
        this.d += bVar.b.length;
        this.e += h7.a(str.getBytes(com.alipay.sdk.m.o.a.z)) != null ? a2.length : 0;
    }

    public final void a(String str, b bVar, Message message) {
        a7.b("TxRequestSender", "handleResponse");
        if (1 == bVar.a) {
            a7.b("TxRequestSender", "handleResponse result: " + str);
            message.obj = Pair.create(str, bVar);
            message.what = 4999;
            message.sendToTarget();
        }
    }

    public final String a(byte[] bArr, int i) {
        boolean d = i6.d();
        try {
            a7.c("hh", "obfuscate fun_o");
            if (!d && bArr != null && SoUtils.fun_o(bArr, 1) >= 0) {
                return e5.a(1, i, 1);
            }
            return e5.a(1, i, 0);
        } catch (UnsatisfiedLinkError e) {
            return null;
        }
    }
}