package c.t.m.g;

import android.os.Looper;
import android.os.Message;
import java.util.Map;

/* compiled from: TML */
public class o5 extends m2 {
    public volatile long f = 0;
    public p5 e = new p5();

    @Override // c.t.m.g.p2
    public String a() {
        return "TxThreadMonitorPro";
    }

    @Override // c.t.m.g.m2
    public void a(Message message) throws Exception {
        if (message.what != 101) {
            return;
        }
        if (b()) {
            a(101, 30000L);
        }
        h();
    }

    @Override // c.t.m.g.p2
    public void c() {
        this.e.a();
        k4.a();
    }

    public final void h() {
        boolean z = false;
        String str = "thread state:";
        for (Thread thread : k4.b()) {
            if (thread == null) {
                w3.d("LOG", "thread is null");
            } else {
                str = str + (thread.getName() + "," + thread.getId() + "," + thread.getState()) + com.alipay.sdk.m.q.h.b;
                if (!k4.a(thread)) {
                    z = true;
                }
            }
        }
        w3.d("LOG", str);
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f > 300000) {
                i();
                this.f = currentTimeMillis;
            }
        }
    }

    public final void i() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Thread thread : allStackTraces.keySet()) {
            if (!k4.a(thread)) {
                StringBuilder sb = new StringBuilder();
                sb.append("thread stack:").append(thread.getName()).append(",").append(thread.getState()).append(",").append(thread.getId()).append(com.alipay.sdk.m.q.h.b);
                for (StackTraceElement stackTraceElement : allStackTraces.get(thread)) {
                    sb.append(stackTraceElement.toString().replaceAll("\\$", "#").replaceAll("\\n", com.alipay.sdk.m.q.h.b)).append(com.alipay.sdk.m.q.h.b);
                }
                w3.d("LOG", sb.toString());
            }
        }
        x3.f().a(2000L);
    }

    @Override // c.t.m.g.p2
    public int a(Looper looper) {
        this.e.a(looper);
        a(101, 500L);
        this.f = 0L;
        return 0;
    }
}