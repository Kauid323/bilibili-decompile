package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import c.t.m.g.a4;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: TML */
public class j extends m2 implements x1, Runnable {
    public volatile w1 h;
    public File i;
    public volatile boolean e = false;
    public String j = "wf4_bf";
    public String k = "wf4";
    public StringBuilder l = new StringBuilder(100);
    public p0 g = new p0(8192, 5);
    public List<String> f = new ArrayList();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements y1 {
        public final /* synthetic */ File a;

        public a(j jVar, File file) {
            this.a = file;
        }

        @Override // c.t.m.g.y1
        public void a(String str) {
        }

        @Override // c.t.m.g.y1
        public void b(String str) {
            this.a.delete();
            if (w3.a()) {
                w3.a("WifiInfoPro", "upload suc & del:" + str);
            }
        }
    }

    public j(File file) {
        this.i = file;
        if (w3.a()) {
            w3.a("WifiInfoPro", "data dir:" + this.i.getAbsolutePath());
        }
    }

    @Override // c.t.m.g.p2
    public String a() {
        return "WifiInfoPro";
    }

    public void a(List<ScanResult> list) {
        if (!b() || d4.a((Collection) list)) {
            return;
        }
        Message obtainMessage = d().obtainMessage(102);
        obtainMessage.obj = list;
        a(obtainMessage, 0L);
    }

    public final void b(List<String> list) throws IOException {
        if (this.e || d4.a((Collection) list) || d4.a(this.h)) {
            return;
        }
        long length = this.h.b().length();
        if (w3.a()) {
            w3.a("WifiInfoPro", "wf file len:" + length);
        }
        if (length <= 51200) {
            StringBuilder sb = new StringBuilder(500);
            sb.append("1|").append(list.size());
            for (String str : list) {
                sb.append('|').append(str);
            }
            this.h.a(sb.toString());
        }
        list.clear();
    }

    @Override // c.t.m.g.p2
    public void c() {
        p3.b(d());
        a(101, 0L);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.e = true;
            if (this.h != null) {
                this.h.a();
                this.h = null;
            }
            File file = new File(this.i, this.k);
            if (w3.a()) {
                w3.a("WifiInfoPro", "upload:" + file.getName() + "," + file.length());
            }
            byte[] a2 = c3.a(m3.a(file));
            String str = l.k ? "https://testdatalbs.sparta.html5.qq.com/tr?wf4" : g3.f34c + "?wf4";
            if (!l.g) {
                str = str.replace("https:", "http:");
            }
            l.n.a(str, a2, new a(this, file));
            if (b()) {
                this.h = new w1(new File(this.i, this.k));
                this.h.a(this);
            }
        } catch (Throwable th) {
            try {
                w3.a("WifiInfoPro", "upload error.", th);
            } finally {
                this.e = false;
            }
        }
    }

    @Override // c.t.m.g.p2
    public int a(Looper looper) {
        a(100, 0L);
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0123  */
    @Override // c.t.m.g.m2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message) throws Exception {
        a4.a b;
        if (this.i == null) {
            return;
        }
        boolean z = false;
        switch (message.what) {
            case 100:
                this.h = new w1(new File(this.i, this.k));
                this.h.a(this);
                byte[] a2 = m3.a(new File(this.i, this.j));
                long longValue = ((Long) h4.a("LocationSDK", "log_fc_wf_bf_create_t_ms", (Object) 0L)).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue < 2592000000L && !d4.a(a2)) {
                    this.g.a(a2);
                    w3.a("WifiInfoPro", "bf init.");
                } else {
                    h4.b("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(currentTimeMillis));
                    w3.a("WifiInfoPro", "bf reset.");
                }
                a(103, 300000L);
                m3.a(new File(this.i, this.j), this.g.a(), false);
                a(104, 300000L);
                return;
            case 101:
                b(this.f);
                m3.a(new File(this.i, this.j), this.g.a(), false);
                if (this.h != null) {
                    this.h.a();
                    this.h = null;
                }
                p3.a(d(), 103);
                if (message.what != 101 && b()) {
                    a(103, 1800000L);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long longValue2 = ((Long) h4.a("LocationSDK", "log_fc_wf_up_t_ms", (Object) 0L)).longValue();
                b = a4.b();
                if (b != a4.a.NETWORK_WIFI || (b == a4.a.NETWORK_MOBILE && (l.h || l.j))) {
                    z = true;
                }
                if (w3.a()) {
                    w3.a("WifiInfoPro", "lastUpT:" + longValue2 + ",deltaT:" + (currentTimeMillis2 - longValue2) + ",network status:" + b + ",isUpload:" + z);
                }
                if (z) {
                    return;
                }
                int i = (longValue2 > 0L ? 1 : (longValue2 == 0L ? 0 : -1));
                if (i != 0 && currentTimeMillis2 - longValue2 >= 86400000) {
                    n3.a("th_loc_task_t_consume", this);
                    h4.b("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(currentTimeMillis2));
                    return;
                } else if (i == 0) {
                    h4.b("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(currentTimeMillis2));
                    return;
                } else {
                    return;
                }
            case 102:
                for (ScanResult scanResult : (List) message.obj) {
                    if (!this.g.b(scanResult.BSSID)) {
                        this.g.a(scanResult.BSSID);
                        this.f.add(a(scanResult));
                    }
                }
                if (w3.a()) {
                    w3.a("WifiInfoPro", "wf list size:" + this.f.size());
                }
                if (this.f.size() >= 30) {
                    b(this.f);
                    return;
                }
                return;
            case 103:
                p3.a(d(), 103);
                if (message.what != 101) {
                    a(103, 1800000L);
                    break;
                }
                long currentTimeMillis22 = System.currentTimeMillis();
                long longValue22 = ((Long) h4.a("LocationSDK", "log_fc_wf_up_t_ms", (Object) 0L)).longValue();
                b = a4.b();
                if (b != a4.a.NETWORK_WIFI) {
                    break;
                }
                z = true;
                if (w3.a()) {
                }
                if (z) {
                }
                break;
            case 104:
                m3.a(new File(this.i, this.j), this.g.a(), false);
                a(104, 300000L);
                return;
            default:
                return;
        }
    }

    public final String a(ScanResult scanResult) {
        this.l.setLength(0);
        try {
            this.l.append(scanResult.BSSID).append(',');
            this.l.append(Base64.encodeToString(scanResult.SSID.getBytes(com.alipay.sdk.m.o.a.z), 2)).append(',');
            this.l.append(scanResult.frequency).append(',');
            this.l.append(Base64.encodeToString(scanResult.capabilities.getBytes(com.alipay.sdk.m.o.a.z), 2));
        } catch (Throwable th) {
            this.l.setLength(0);
        }
        return this.l.toString();
    }

    @Override // c.t.m.g.x1
    public byte[] a(byte[] bArr) {
        byte[] a2 = i3.a(c3.a(bArr), i3.a("fc_wf_up"));
        if (!d4.a(a2)) {
            byte[] encode = Base64.encode(a2, 2);
            if (!d4.a(encode)) {
                try {
                    return (new String(encode) + '$').getBytes(com.alipay.sdk.m.o.a.z);
                } catch (Throwable th) {
                }
            }
        }
        return new byte[0];
    }
}