package c.t.m.g;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ashampoo.kim.format.jpeg.iptc.IptcConstants;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TML */
public class h extends m2 {
    public static String j = g3.a + "?type=sdk&key=5e1fe70424035ee83066ac22b24f31dc";
    public volatile Handler e = null;
    public volatile b f = new b();
    public StringBuilder g = new StringBuilder();
    public AtomicInteger h = new AtomicInteger(0);
    public int i = 0;

    @Override // c.t.m.g.p2
    public String a() {
        return "GpsNaviPro";
    }

    @Override // c.t.m.g.p2
    public void c() {
        this.g.setLength(0);
        this.h.set(0);
        this.f.a("", 0);
        this.e = null;
        n3.a("th_loc_task_t_consume");
    }

    @Override // c.t.m.g.m2
    public void a(Message message) throws Exception {
        String sb;
        if (message.what != 1001) {
            return;
        }
        p3.a(d(), (int) IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO);
        p3.a(d(), (int) IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO, 5000L);
        int i = this.h.get();
        synchronized (this.b) {
            sb = this.g.toString();
            this.g.setLength(0);
            this.h.set(0);
        }
        if (sb.length() <= 0 || this.e == null) {
            return;
        }
        this.f.a(sb, i);
        p3.a(this.e, this.f);
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class b implements Runnable, y1 {
        public volatile String a;
        public volatile int b;

        public b() {
            this.b = 0;
        }

        @Override // c.t.m.g.y1
        public void a(String str) {
        }

        public void a(String str, int i) {
            if (d4.a(str)) {
                this.a = "";
            } else {
                this.a = str;
            }
            this.b = i;
        }

        @Override // c.t.m.g.y1
        public void b(String str) {
            w3.d("FC", "NaviGps," + this.b);
            if (w3.a()) {
                w3.a("GpsNaviPro", "upload success:" + str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (d4.a(this.a)) {
                    return;
                }
                w3.c("GpsNaviPro", "upload str:" + this.a);
                byte[] bytes = this.a.getBytes(com.alipay.sdk.m.o.a.z);
                this.a = "";
                a(bytes);
            } catch (Throwable th) {
                if (w3.a()) {
                    w3.a("GpsNaviPro", "upload error.", th);
                }
            }
        }

        public final void a(byte[] bArr) {
            byte[] a = c3.a(bArr);
            byte[] a2 = z2.a(a.length);
            byte[] bArr2 = new byte[a2.length + 1 + a.length];
            bArr2[0] = 1;
            System.arraycopy(a2, 0, bArr2, 1, a2.length);
            System.arraycopy(a, 0, bArr2, a2.length + 1, a.length);
            byte[] a3 = i3.a(bArr2, i3.a("fc_gps_for_navi"));
            if (w3.a()) {
                w3.a("GpsNaviPro", "start upload:strBytes=" + bArr.length + ",encBytes=" + a3.length);
            }
            String unused = h.j = g3.a + "?type=sdk&key=5e1fe70424035ee83066ac22b24f31dc";
            z1.a.a(h.j, a3, this);
        }
    }

    @Override // c.t.m.g.p2
    public int a(Looper looper) {
        p3.a(d(), (int) IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO, 5000L);
        this.e = new Handler(n3.b("th_loc_task_t_consume").getLooper());
        this.g.setLength(0);
        this.h.set(0);
        return 0;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(int i, Location location) {
        synchronized (this.b) {
            if (this.g.length() > 5120) {
                this.g.setLength(0);
                this.h.set(0);
            }
            if (this.g.length() > 0) {
                this.g.append('\n');
            }
            String str = d4.a(l.m.a()) ? "null" : "loc_" + l.m.a();
            String a2 = i4.a();
            if (d4.a(a2) || "0123456789ABCDEF".equals(a2)) {
                a2 = i4.k();
            }
            this.g.append(String.format(Locale.ENGLISH, "%s,%d,%d,%.6f,%.6f,%.3f,%.3f,%.3f,%.3f,%d,%d,%d,%d,%d,%d,%d,%s,%s,%s", a2, 12, Integer.valueOf(i), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), Long.valueOf(location.getTime() / 1000), 2, 0, 2, 2, 1, Integer.valueOf(this.i), "null", str, "null"));
            this.h.getAndAdd(1);
        }
    }
}