package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: TML */
public class b {
    public static volatile b o;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public g f7c;
    public HandlerThread d;
    public volatile Location e;
    public volatile Location f;
    public volatile List<d> g;
    public volatile d h;
    public volatile List<ScanResult> i;
    public LruCache<String, Pair<Double, Double>> j;
    public byte[] a = new byte[0];
    public long k = 180000;
    public long l = 0;
    public long m = 0;
    public long n = 0;

    public b(Context context) {
        Context applicationContext = context == null ? null : context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext != null) {
            b3.a(context);
            this.j = new LruCache<>(100);
            String str = "";
            try {
                if (!l.f57c && !l.d) {
                    str = m3.a(this.b, com.alipay.sdk.m.l.e.m).getAbsolutePath();
                }
                str = TextUtils.isEmpty(str) ? this.b.getFilesDir().getAbsolutePath() + "/data/" : str;
                if (!TextUtils.isEmpty(str)) {
                    this.f7c = new g(this.b, str);
                    e();
                }
                o = this;
                return;
            } catch (Throwable th) {
                this.f7c = null;
                return;
            }
        }
        throw new IllegalArgumentException("context cannot be null!");
    }

    public static b a() {
        return o;
    }

    public static String b() {
        return "1.7.6_220414";
    }

    public boolean c() {
        g gVar = this.f7c;
        if (gVar == null) {
            return false;
        }
        return gVar.b();
    }

    public final void d() {
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.j.evictAll();
    }

    public final void e() {
        for (Map.Entry<String, String> entry : l.a().entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public void f() {
        synchronized (this.a) {
            if (this.f7c != null && this.f7c.b()) {
                this.f7c.c();
            }
            if (this.d != null) {
                n3.a("th_loc_extra", 300L);
                this.d = null;
            }
            d();
            w3.a("TxCoreDC", "shutdown");
        }
    }

    public final void g() {
        if (!d4.b(this.f7c, this.e) || d4.a((Collection) this.g)) {
            return;
        }
        if (l.h && p.a(this.b) == 3) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.l < this.k) {
            this.n = currentTimeMillis;
            this.f = a(this.f, this.e);
            this.f7c.a(this.e, (List<ScanResult>) null, this.g);
        }
    }

    public void a(Looper looper) {
        synchronized (this.a) {
            w3.a("TxCoreDC", "startup");
            d();
            if (this.f7c != null) {
                if (looper == null) {
                    HandlerThread b = n3.b("th_loc_extra");
                    this.d = b;
                    looper = b.getLooper();
                }
                this.f7c.a(looper);
            }
        }
    }

    public void a(c cVar) {
        synchronized (this.a) {
            l.l = cVar;
            if (w3.a()) {
                w3.a("TxCoreDC", "appInfo:" + cVar.f() + "," + cVar.b() + "_" + cVar.c() + "," + cVar.d() + "," + cVar.e());
            }
        }
    }

    @Deprecated
    public void a(Location location) {
        a(0, location);
    }

    public void a(int i, Location location) {
        synchronized (this.a) {
            if (c()) {
                if (location != null && "gps".equals(location.getProvider())) {
                    if (l.k || !location.isFromMockProvider()) {
                        w3.a("TxCoreDC", "setGpsLocation");
                        if (this.f7c != null) {
                            this.f7c.a(i, location);
                        }
                        if (!b4.a(location.getAltitude(), 0.0d) || !b4.a(location.getSpeed(), 0.0d)) {
                            this.e = a(this.e, location);
                            if (this.f == null || (this.e != null && this.e.distanceTo(this.f) >= 50.0f && System.currentTimeMillis() - this.n >= 5000)) {
                                g();
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(long j, int i, double d, double d2, double d3) {
        synchronized (this.a) {
            if (c()) {
                if (w3.a()) {
                    w3.a("TxCoreDC", "setNetLoc");
                }
                if (this.f7c != null) {
                    this.f7c.a(j, i, d, d2, d3);
                }
            }
        }
    }

    public void a(List<ScanResult> list) {
        long currentTimeMillis;
        boolean a;
        synchronized (this.a) {
            if (c()) {
                try {
                    currentTimeMillis = System.currentTimeMillis();
                    a = p.a(this.i, list);
                    if (w3.a()) {
                        w3.a("TxCoreDC", "setWifiResults, same pre:" + a);
                    }
                } catch (Throwable th) {
                }
                if (!a || currentTimeMillis - this.m <= 30000) {
                    if (this.f7c != null) {
                        this.f7c.a(list);
                    }
                    if (this.f7c != null && this.e != null && !d4.a((Collection) list)) {
                        if (list.size() == 1) {
                            if ("123456789abc".equals(list.get(0).BSSID.toLowerCase())) {
                                return;
                            }
                        } else if (list.size() > 1 && p.a(list)) {
                            return;
                        }
                        if (l.h && currentTimeMillis - this.m < 5000) {
                            return;
                        }
                        if (!a) {
                            this.m = currentTimeMillis;
                            this.i = list;
                        }
                        this.f7c.a(this.e, list, currentTimeMillis - this.l < this.k ? this.g : null);
                    }
                }
            }
        }
    }

    public void a(d dVar, List<d> list) {
        synchronized (this.a) {
            if (c()) {
                ArrayList arrayList = new ArrayList();
                for (d dVar2 : list) {
                    if (k.a(dVar2.f, dVar2.a, dVar2.b, dVar2.f17c, dVar2.e) && a(dVar2.f17c + "_" + dVar2.e, this.e)) {
                        arrayList.add(dVar2);
                    }
                }
                this.g = arrayList;
                this.l = System.currentTimeMillis();
                if (dVar != null && !dVar.equals(this.h)) {
                    this.h = dVar;
                    g();
                }
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this.a) {
            if (this.f7c == null || d4.a(str2)) {
                return;
            }
            if (w3.a()) {
                w3.a("TxCoreDC", "setSetting(" + str + "," + str2 + ")");
            }
            if ("D_CH_ID".equals(str)) {
                m.a(str2);
            } else if ("D_FC_SRC".equals(str)) {
                m.b(str2);
            } else if ("D_POS_COLL".equals(str)) {
                l.e = Boolean.parseBoolean(str2.toLowerCase());
            } else if ("D_WRITE_MAC".equals(str)) {
                l.f = Boolean.parseBoolean(str2.toLowerCase());
            } else if ("D_UP_NET".equals(str)) {
                if ("m".equals(str2.toLowerCase())) {
                    l.h = true;
                } else if ("w".equals(str2.toLowerCase())) {
                    l.h = false;
                    l.j = false;
                } else if ("w_m1".equals(str2.toLowerCase())) {
                    l.h = false;
                    l.j = true;
                } else if ("allways".equals(str2.toLowerCase())) {
                    l.i = true;
                }
            } else if ("D_EXTRA_SET_SN".equals(str)) {
                o.a = d4.a(str2) ? "" : str2;
            } else if ("D_SDK_VER".equals(str)) {
                l.a = d4.a(str2) ? "1.0.0" : str2;
            } else if ("D_SETING_OAID".equals(str)) {
                l.b = d4.a(str2) ? "" : str2;
            } else {
                this.f7c.a(str, str2);
            }
        }
    }

    public void a(int i, long j, Object obj) {
        synchronized (this.a) {
            try {
                this.f7c.a(i, j, obj);
            }
        }
    }

    public final Location a(Location location, Location location2) {
        if (location == null) {
            location = new Location("gps");
        }
        if (location2 != null) {
            location.set(location2);
        }
        return location;
    }

    public final boolean a(String str, Location location) {
        if (d4.a(str) || location == null || location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) {
            return false;
        }
        Pair<Double, Double> pair = this.j.get(str);
        if (pair != null) {
            return v3.a(location.getLatitude(), location.getLongitude(), ((Double) pair.first).doubleValue(), ((Double) pair.second).doubleValue()) < 6000.0d;
        }
        this.j.put(str, Pair.create(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        return true;
    }
}