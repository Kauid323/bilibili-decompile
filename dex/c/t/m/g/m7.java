package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import java.util.Locale;

/* compiled from: TML */
public class m7 {
    public static volatile m7 g;
    public u4 a;
    public TencentLocationManager b;

    /* renamed from: c  reason: collision with root package name */
    public m4 f68c;
    public n7 d;
    public n7 e;
    public final TencentLocationListener f;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements TencentLocationListener {
        public a() {
        }

        public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
            w3.e("SDK", String.format(Locale.ENGLISH, "callback,%d,%s,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f", Integer.valueOf(i), tencentLocation.getProvider(), Double.valueOf(tencentLocation.getLatitude()), Double.valueOf(tencentLocation.getLongitude()), Double.valueOf(tencentLocation.getAltitude()), Float.valueOf(tencentLocation.getAccuracy()), Float.valueOf(tencentLocation.getBearing()), Float.valueOf(tencentLocation.getSpeed())));
            if (m7.this.d != n7.l) {
                m7.this.d.a(tencentLocation);
            } else {
                m7.this.d = new n7(tencentLocation);
            }
            m7.this.d.a(i);
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }
    }

    public m7(m4 m4Var) {
        n7 n7Var = n7.l;
        this.d = n7Var;
        this.e = n7Var;
        this.f = new a();
        this.f68c = m4Var;
        this.a = m4Var.e().a();
        this.b = TencentLocationManager.getInstance(m4Var.a);
    }

    public boolean b() {
        if (this.f68c.k()) {
            return this.a.isSupport();
        }
        return false;
    }

    public final void c() {
        TencentLocationRequest interval = TencentLocationRequest.create().setInterval(1000L);
        interval.setAllowGPS(true);
        w3.e("SDK", "register " + this.b.requestLocationUpdates(interval, this.f));
    }

    public void d() {
        this.b.removeUpdates(this.f);
        this.a.terminateDrEngine();
    }

    public static m7 a(m4 m4Var) {
        if (g == null) {
            synchronized (m7.class) {
                if (g == null) {
                    g = new m7(m4Var);
                }
            }
        }
        return g;
    }

    public int a(int i) {
        if (this.f68c.k()) {
            int startDrEngine = this.a.startDrEngine(i);
            if (this.a.a()) {
                c();
            }
            return startDrEngine;
        }
        return -1;
    }

    public TencentLocation a() {
        double[] position = this.a.getPosition();
        if (position != null && a3.a(position[1], position[2])) {
            Location location = new Location("gps");
            location.setLatitude(position[1]);
            location.setLongitude(position[2]);
            double[] dArr = new double[2];
            g7.a(location, dArr);
            position[1] = dArr[0];
            position[2] = dArr[1];
        }
        k7 k7Var = new k7(position);
        n7 n7Var = this.e;
        if (n7Var == n7.l) {
            this.e = new n7(k7Var);
        } else {
            n7Var.a(k7Var);
        }
        w3.e("DR", String.format(Locale.ENGLISH, "update,%d,%s,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f", Integer.valueOf(this.e.a()), this.e.getProvider(), Double.valueOf(this.e.getLatitude()), Double.valueOf(this.e.getLongitude()), Double.valueOf(this.e.getAltitude()), Float.valueOf(this.e.getAccuracy()), Float.valueOf(this.e.getBearing()), Float.valueOf(this.e.getSpeed())));
        if (this.e.a() == 0) {
            w3.c("TxDR", "callback,DR");
            n7 n7Var2 = new n7(this.d);
            n7Var2.a(k7Var);
            return n7Var2;
        } else if (this.d.a() == 0) {
            w3.c("TxDR", "callback,SDK");
            return new n7(this.d);
        } else {
            w3.c("TxDR", "callback,ERR");
            return n7.l;
        }
    }
}