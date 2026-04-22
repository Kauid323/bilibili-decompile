package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;

/* compiled from: TML */
public class z4 {
    public static z4 e;
    public m4 a;
    public TencentLocationListener b;
    public long d = 0;

    /* renamed from: c  reason: collision with root package name */
    public b f127c = new b();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            String str;
            if (message.what != 1) {
                return;
            }
            n7 n7Var = (n7) m7.a(z4.this.a).a();
            if (n7Var == null) {
                a7.b("LocSceneProvider", "drPosition is null");
                return;
            }
            if (n7Var == n7.l) {
                str = "ERROR_NETWORK";
                i = 1;
            } else {
                i = 0;
                str = "OK";
            }
            if ((n7Var.getProvider() != null && !"network".equals(n7Var.getProvider())) || System.currentTimeMillis() - z4.this.d > 5000) {
                z4.this.b.onLocationChanged(n7Var, i, str);
            }
            z4.this.f127c.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public z4(m4 m4Var) {
        this.a = m4Var;
    }

    public static z4 a(m4 m4Var) {
        if (e == null) {
            synchronized (z4.class) {
                if (e == null) {
                    e = new z4(m4Var);
                }
            }
        }
        return e;
    }

    public void b(int i, TencentLocationListener tencentLocationListener) {
        if (i == 12) {
            TencentLocationManager.getInstance(this.a.a).removeUpdates(tencentLocationListener);
        } else if (i == 11) {
            m7.a(this.a).d();
            this.f127c.removeCallbacksAndMessages(null);
            this.d = 0L;
        }
        a7.c("LocSceneProvider", "stopLoc scene = " + i);
    }

    public int a(int i, TencentLocationListener tencentLocationListener) {
        int i2;
        if (i == 10) {
            TencentLocationRequest create = TencentLocationRequest.create();
            create.setLocMode(10).setAllowGPS(true).setGpsFirst(true).setGpsFirstTimeOut(3000).setRequestLevel(3);
            int requestSingleFreshLocation = TencentLocationManager.getInstance(this.a.a).requestSingleFreshLocation(create, tencentLocationListener, Looper.getMainLooper());
            a7.c("LocSceneProvider", "requestLoc SIGN_IN_SCENE res: " + requestSingleFreshLocation);
            return requestSingleFreshLocation;
        } else if (i == 12) {
            TencentLocationRequest create2 = TencentLocationRequest.create();
            create2.setLocMode(10).setAllowGPS(true).setLocMode(12).setInterval(1000L);
            int requestLocationUpdates = TencentLocationManager.getInstance(this.a.a).requestLocationUpdates(create2, tencentLocationListener, Looper.getMainLooper());
            a7.c("LocSceneProvider", "requestLoc TRANSPORT_SCENE res: " + requestLocationUpdates);
            return requestLocationUpdates;
        } else if (i == 11) {
            if (m7.a(this.a).b()) {
                this.b = tencentLocationListener;
                i2 = m7.a(this.a).a(TencentLocationManager.DR_TYPE_WALK);
                if (i2 == 0) {
                    if (this.d == 0) {
                        this.d = System.currentTimeMillis();
                    }
                    this.f127c.sendEmptyMessageDelayed(1, 1000L);
                }
            } else {
                i2 = -1;
            }
            a7.c("LocSceneProvider", "requestLoc SPORT_SCENE res: " + i2);
            return i2;
        } else {
            return 0;
        }
    }
}