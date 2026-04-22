package c.t.m.g;

import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.tencentmap.lbssdk.service.RegTxGposListener;
import com.tencent.tencentmap.lbssdk.service.TxGposListener;
import com.tencent.tencentmap.lbssdk.service.TxRtkSvr;
import java.io.File;

/* compiled from: TML */
public class a5 {
    public static int g;
    public v7 a;
    public x7 b;

    /* renamed from: c  reason: collision with root package name */
    public String f6c;
    public b d;
    public boolean e = false;
    public TxGposListener f;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements u7 {
        public a(a5 a5Var) {
        }

        @Override // c.t.m.g.u7
        public void a(String str, String str2) {
            a7.c(str, str2);
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void a(Message message) {
            switch (message.what) {
                case 6001:
                    if (Build.VERSION.SDK_INT >= 24) {
                        GnssStatus gnssStatus = (GnssStatus) message.obj;
                        a5.a(gnssStatus);
                        a5.this.b.a(gnssStatus);
                        return;
                    }
                    return;
                case 6002:
                    if (Build.VERSION.SDK_INT >= 24) {
                        a5.this.b.a((GnssNavigationMessage) message.obj);
                        return;
                    }
                    return;
                case 6003:
                    a5.this.b.b(message.arg1);
                    return;
                case 6004:
                    if (Build.VERSION.SDK_INT >= 24) {
                        a5.this.b.a((GnssMeasurementsEvent) message.obj);
                        return;
                    }
                    return;
                case 6005:
                    a5.this.b.a(message.arg1);
                    return;
                case 6006:
                    a6 a6Var = (a6) message.obj;
                    a5.this.b.a(a6Var.b(), a6Var.a());
                    return;
                case 6007:
                    Location location = (Location) message.obj;
                    a5.this.b.a(location);
                    if (a5.this.a.f && location.getProvider().equals("gps")) {
                        if (a5.this.a.b) {
                            a5.this.a.d = SystemClock.elapsedRealtimeNanos();
                            a5.this.a.e = a5.this.a.d - a5.this.a.f111c;
                            a5.this.b.a(a5.this.a.e);
                        }
                        a5.this.a.f = false;
                        return;
                    }
                    return;
                case 6008:
                    z5 z5Var = (z5) message.obj;
                    if (a5.this.a.b) {
                        a5.this.b.a(z5Var.b(), z5Var.c(), z5Var.a());
                        return;
                    }
                    return;
                case 6009:
                    if (a5.this.b != null) {
                        a5.this.b.a();
                    }
                    a7.b("TXBD", "stop txgpos positioning ok");
                    return;
                case 6010:
                    if (a5.this.b != null) {
                        a5.this.b.j();
                    }
                    TxRtkSvr.jni_set_ntrip_mode(1);
                    if (a5.this.f != null) {
                        RegTxGposListener.registTxGposListener(a5.this.f);
                    }
                    if (a5.this.c() == 1) {
                        a7.c("TXBD", "txgpos positioning run ok");
                        return;
                    } else {
                        a7.b("TXBD", "txgpos positioning run fail");
                        return;
                    }
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                a(message);
            } catch (Throwable th) {
            }
        }
    }

    public a5(Context context) {
        this.a = null;
        this.b = null;
        if (t7.a) {
            try {
                t7.a(context, new File(context.getExternalFilesDir(com.alipay.sdk.m.l.e.m).getAbsolutePath() + "/s_l"));
                t7.a(new a(this));
                this.f6c = context.getExternalFilesDir("dgnss").getAbsolutePath();
            } catch (Throwable th) {
                a7.a("TXBD", "", th);
            }
        }
        this.b = new x7(context);
        this.a = new v7(context, this.b);
    }

    public void a(TxGposListener txGposListener, Looper looper) {
        if (this.e) {
            return;
        }
        this.e = true;
        g = e7.a("LocationSDK", "is_support_beidou", 0);
        b bVar = new b(looper);
        this.d = bVar;
        this.f = txGposListener;
        p3.b(bVar, 6010);
    }

    public void b() {
        if (this.e) {
            this.e = false;
            p3.b(this.d, 6009);
        }
    }

    public final int c() {
        if (t7.a) {
            TxRtkSvr.jni_settrace_path(3, this.f6c + "/txgpos_%Y_%m_%d_%h_%M_%S.trace");
            TxRtkSvr.jni_setlogger_path(this.f6c + "/txgpos_%Y_%m_%d_%h_%M_%S.log");
            TxRtkSvr.jni_setsol_path(this.f6c + "/txgpos_%Y_%m_%d_%h_%M_%S.sol");
        }
        return TxRtkSvr.jni_init_txgpos();
    }

    public void a(int i, int i2, int i3, Object obj) {
        p3.b(this.d, i, i2, i3, obj);
    }

    public static boolean a(Location location) {
        String string;
        if (location == null) {
            a7.b("TXBD", "location is null");
            return false;
        }
        Bundle extras = location.getExtras();
        if (extras == null || (string = extras.getString("gnss_source")) == null || string.isEmpty() || !string.equals("beidou")) {
            return false;
        }
        a7.c("TXBD", "from beidou");
        return true;
    }

    public static boolean a(p6 p6Var) {
        String string;
        if (p6Var == null) {
            a7.b("TXBD", "location is null");
            return false;
        }
        Bundle extra = p6Var.getExtra();
        if (extra == null || (string = extra.getString("gnss_source")) == null || string.isEmpty() || !string.equals("beidou")) {
            return false;
        }
        a7.c("TXBD", "from beidou");
        return true;
    }

    public static int a() {
        return g;
    }

    public static void a(Object obj) {
        if (g == 1) {
            return;
        }
        u5 c2 = y6.c(obj);
        if (c2.a() >= 1) {
            g = 1;
            e7.b("LocationSDK", "is_support_beidou", 1);
        } else if (c2.b() >= 12) {
            g = -1;
            e7.b("LocationSDK", "is_support_beidou", -1);
        }
    }
}