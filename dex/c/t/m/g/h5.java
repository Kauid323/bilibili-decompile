package c.t.m.g;

import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import c.t.m.g.q0;
import c.t.m.g.x5;
import com.alipay.sdk.app.PayTask;
import com.ashampoo.kim.format.tiff.constant.GpsTag;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.tencentmap.lbssdk.service.TxGposListener;
import j$.util.Objects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public final class h5 implements LocationListener, TxGposListener {
    public static LinkedList<a> L = new LinkedList<>();
    public b C;
    public LocationManager D;
    public volatile Location E;
    public c G;
    public a5 H;
    public final m4 a;

    /* renamed from: c  reason: collision with root package name */
    public volatile GpsStatus f38c;
    public volatile Object d;
    public volatile Location e;
    public volatile Location f;
    public boolean r;
    public volatile boolean t;
    public boolean z;
    public AtomicInteger b = new AtomicInteger(1024);
    public long h = 0;
    public long i = 0;
    public volatile long j = 0;
    public volatile long k = 0;
    public volatile long l = 0;
    public long m = 1000;
    public boolean n = false;
    public boolean o = false;
    public AtomicInteger p = new AtomicInteger(0);
    public AtomicInteger q = new AtomicInteger(0);
    public ArrayList<Float> s = new ArrayList<>();
    public volatile boolean u = true;
    public volatile long w = 0;
    public int x = 0;
    public boolean y = false;
    public long B = -1;
    public long I = 0;
    public final double[] J = new double[2];
    public boolean K = true;
    public Location g = new Location("gps");
    public y4 A = y4.a();
    public h5 v = this;
    public q0 F = new q0();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class a implements Serializable {
        public double a;
        public double b;

        /* renamed from: c  reason: collision with root package name */
        public float f39c;
        public long d;

        public a(Location location) {
            if (location == null) {
                a7.b("BasicGpsInfo", "BasicGpsInfo failed, location is null");
                return;
            }
            this.a = location.getLatitude();
            this.b = location.getLongitude();
            this.f39c = location.getAccuracy();
            this.d = location.getTime();
        }

        public float a() {
            return this.f39c;
        }

        public double b() {
            return this.a;
        }

        public double c() {
            return this.b;
        }

        public long d() {
            return this.d;
        }

        public String toString() {
            return "BasicGpsInfo{latitude=" + this.a + ", longitude=" + this.b + ", accuracy=" + this.f39c + ", timeStamp=" + this.d + '}';
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void a(Message message) {
            removeMessages(message.what);
            switch (message.what) {
                case 1101:
                    Location location = (Location) message.obj;
                    if (location == null) {
                        x3.a("G", "gl null");
                        return;
                    }
                    v4.a(8, h5.this.b(location));
                    boolean e = h5.this.e(location);
                    h5 h5Var = h5.this;
                    boolean a = h5Var.a(h5Var.a.a, location);
                    if (e && (!a || !v4.b(80))) {
                        h5 h5Var2 = h5.this;
                        boolean a2 = h5Var2.a(location, h5Var2.E);
                        h5.this.E = location;
                        if (!a2) {
                            if (h5.this.f(location)) {
                                h5.this.g(location);
                                a7.c("TxGpsProvider", "notifyListeners, location: " + location);
                                h5.this.n();
                                h5.this.b.set(h5.this.b.get() | 2);
                                if (h5.this.B == -1 || h5.this.B == 0) {
                                    h5.this.a(true);
                                    h5.this.B = System.currentTimeMillis();
                                    return;
                                }
                                return;
                            }
                            w6.a("gps,is sys nlp");
                            a7.c("TxGpsProvider", "this location is consider nlp:" + String.format(Locale.ENGLISH, "l,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), "f"));
                            x3.a("G", String.format(Locale.ENGLISH, "l,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), "nf"));
                            return;
                        }
                        a7.c("TxGpsProvider", location.getLatitude() + "," + location.getLongitude() + ",isFilter=" + a2);
                        x3.a("G", String.format(Locale.ENGLISH, "l,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), "f"));
                        return;
                    }
                    x3.a("G", "gl inRegular");
                    a7.b("TxGpsProvider", "isLaLoRegular: " + e);
                    if (v4.b(80)) {
                        a7.b("TxGpsProvider", "isFromMockProvider: true");
                        return;
                    }
                    return;
                case 1102:
                    h5.this.n();
                    x3.a("G", "vf:" + h5.this.p.get() + "," + h5.this.q.get());
                    if (System.currentTimeMillis() - h5.this.I > 10000) {
                        h5.this.I = System.currentTimeMillis();
                        w6.a("gps,vf," + h5.this.p.get() + "," + h5.this.q.get());
                    }
                    h5.this.i();
                    if ((h5.this.f38c != null || h5.this.d != null) && h5.this.s != null && h5.this.s.size() > 0) {
                        try {
                            h5.this.u = h5.this.A.a(h5.this.s, h5.this.p.get());
                        } catch (Throwable th) {
                            a7.a("TxGpsProvider", "judgeIO Error!", th);
                        }
                    }
                    if (h5.this.u) {
                        if (h5.this.B == -1 || h5.this.B == 0) {
                            h5.this.a(true);
                        }
                        h5.this.w = System.currentTimeMillis();
                        h5.this.B = System.currentTimeMillis();
                    } else if (h5.this.B == -1 || (System.currentTimeMillis() - h5.this.B > 40000 && h5.this.B != 0)) {
                        h5.this.a(false);
                        h5.this.B = 0L;
                    }
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (h5.this.r || h5.this.p.get() <= 10 || h5.this.p.get() >= 100 || h5.this.E == null || currentTimeMillis - h5.this.E.getTime() <= 60000) {
                            return;
                        }
                        a7.b("TxGpsProvider", "Visible num:" + h5.this.p.get() + ",usedNum:" + h5.this.q.get() + ",last gps time:" + h5.this.E.getTime());
                        x3.a("G", "restart gps.");
                        h5.this.m();
                        h5.this.k();
                        h5.this.r = true;
                        a7.c("TxGpsProvider", "gps is restart");
                        return;
                    } catch (Throwable th2) {
                        a7.a("TxGpsProvider", "", th2);
                        return;
                    }
                case 1103:
                    a7.c("TxGpsProvider", "onProviderEnabled: gps is enabled");
                    h5.this.b.set(4);
                    h5.this.j();
                    return;
                case 1104:
                    a7.c("TxGpsProvider", "onProviderDisabled: gps is disabled");
                    h5.this.p.set(0);
                    h5.this.q.set(0);
                    h5.this.b.set(0);
                    h5.this.n = false;
                    h5.this.j();
                    return;
                case 1105:
                    a7.c("TxGpsProvider", "MSG_READ_GPS_FILE");
                    h5.this.a();
                    return;
                case 1106:
                    a7.c("TxGpsProvider", "MSG_WRITE_GPS_FILE");
                    h5.this.o();
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            try {
                a(message);
            } catch (Throwable th) {
                a7.a("TxGpsProvider", "handleMessage error.", th);
            }
        }
    }

    public h5(m4 m4Var, boolean z) {
        this.a = m4Var;
        this.D = this.a.d();
        if (z) {
            a7.c("TxGpsProvider", "init TxBeidouProvider");
            this.H = new a5(m4Var.a);
            return;
        }
        a7.c("TxGpsProvider", "didn't init TxBeidouProvider");
    }

    public final int a(float f, double d, double d2) {
        return ((d <= 100000.0d || d / d2 <= 200.0d || d <= ((double) f)) && (d > 100000.0d || d / d2 <= 50.0d || d <= ((double) f))) ? 0 : 1;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        a5 a5Var;
        try {
            if (location == null) {
                a7.c("TxGpsProvider", "location is null.");
                return;
            }
            a7.c("TxGpsProvider", "onLocationChanged: " + ((Object) DateFormat.format("yyyy-MM-dd kk:mm:ss", location.getTime())) + "," + location.getElapsedRealtimeNanos() + "," + location.getLatitude() + "," + location.getLongitude() + "," + location.getBearing() + "," + location.getSpeed() + "," + location.toString());
            Location location2 = new Location(location);
            if (h() && this.H != null && (a5Var = this.H) != null) {
                a5Var.a(6007, 0, 0, location2);
            }
            a(location, "gps");
        } catch (Throwable th) {
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            a(1104);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            a(1103);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        a5 a5Var;
        z5 z5Var = new z5(str, i, bundle);
        if (!h() || (a5Var = this.H) == null || a5Var == null) {
            return;
        }
        a5Var.a(6008, 0, 0, z5Var);
    }

    public void onTxGposLocation(int[] iArr, double[] dArr) {
    }

    public void onTxGposLocationBDS(int[] iArr, double[] dArr) {
        a7.c("TxGpsProvider", "onTxGposLocationBDS: " + iArr[0]);
        if (iArr[0] > 0) {
            Location location = new Location("gps");
            location.setLatitude(dArr[0]);
            location.setLongitude(dArr[1]);
            location.setAltitude(dArr[2]);
            location.setAccuracy((float) dArr[3]);
            location.setBearing((float) dArr[4]);
            location.setSpeed((float) dArr[5]);
            location.setTime((long) dArr[6]);
            a7.c("TxGpsProvider", "onTxGposLocationBDS, GnssSourceFirst is " + this.x + ", beidou result: " + location);
            a(location, "beidou");
            return;
        }
        a7.b("TxGpsProvider", "beidou SOLQ_NONE");
    }

    public void onTxRtcmReceived(int[] iArr) {
    }

    public boolean f() {
        return System.currentTimeMillis() - this.j < 20000;
    }

    public boolean g() {
        try {
            return this.a.d().isProviderEnabled("gps");
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean h() {
        return this.y;
    }

    public final boolean i() {
        int i = this.p.get();
        int i2 = this.q.get();
        if (i > 0) {
            this.o = true;
        }
        if (i2 > 0) {
            this.n = true;
        }
        if (!this.o || i > 2) {
            if (this.n) {
                if (i2 >= 3 || i2 == 0) {
                    return true;
                }
            } else if (i2 == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void j() {
        int i;
        if (this.b.get() == 4) {
            i = 13001;
        } else {
            i = this.b.get() == 0 ? 13002 : -1;
        }
        o1.a().a(new r1(12002, i));
    }

    public final void k() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_requestLocationUpdates(this.D, "gps", this.m, 0.0f, this, Looper.getMainLooper());
                x3.a("G", "request in thread[" + Thread.currentThread().getName() + "]");
                return;
            }
            __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_requestLocationUpdates(this.D, "gps", this.m, 0.0f, this, this.C == null ? Looper.getMainLooper() : this.C.getLooper());
            x3.a("G", "request in thread[" + Thread.currentThread().getName() + "]");
        } catch (Throwable th) {
            u6.a = true;
            x3.a("G", "request failed.");
            a7.a("TxGpsProvider", "startup: can not add location listener", th);
        }
    }

    public final void l() {
        a5 a5Var;
        if (this.t) {
            this.t = false;
            this.b.set(1024);
            this.n = false;
            this.o = false;
            this.p.set(0);
            this.q.set(0);
            this.s.clear();
            this.B = -1L;
            this.z = false;
            this.r = false;
            Arrays.fill(this.J, 0.0d);
            a(1106);
            m();
            this.C = null;
            this.e = null;
            this.f = null;
            this.E = null;
            try {
                this.F.f();
                this.G = null;
            } catch (Exception e) {
            }
            if (h() && (a5Var = this.H) != null) {
                a5Var.b();
            }
            a7.c("TxGpsProvider", "shutdown: state=[shutdown]");
        }
    }

    public final void m() {
        try {
            this.a.d().removeUpdates(this.v);
        } catch (Exception e) {
        }
    }

    public final void n() {
        int i;
        int i2;
        Throwable th;
        this.s.clear();
        int i3 = 0;
        try {
            c.t.m.g.b a2 = c.t.m.g.b.a();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    GnssStatus gnssStatus = (GnssStatus) this.d;
                    if (gnssStatus != null) {
                        i = 0;
                        i2 = 0;
                        while (i3 < gnssStatus.getSatelliteCount()) {
                            try {
                                try {
                                    this.s.add(Float.valueOf(gnssStatus.getCn0DbHz(i3)));
                                    i++;
                                    if (gnssStatus.usedInFix(i3)) {
                                        i2++;
                                    }
                                } catch (Throwable th2) {
                                }
                                i3++;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    a7.a("TxGpsProvider", "update sate error.", th);
                                } finally {
                                    this.p.set(i);
                                    this.q.set(i2);
                                    a7.c("TxGpsProvider", "viewSate: " + i + ", usedSate: " + i2);
                                }
                            }
                        }
                        i3 = i;
                    } else {
                        i2 = 0;
                    }
                    if (a2 != null) {
                        a2.a(2, currentTimeMillis, gnssStatus);
                    }
                } else {
                    GpsStatus gpsStatus = this.f38c;
                    Iterator<GpsSatellite> it = gpsStatus == null ? null : gpsStatus.getSatellites().iterator();
                    i2 = 0;
                    if (it != null) {
                        while (it.hasNext()) {
                            GpsSatellite next = it.next();
                            i3++;
                            this.s.add(Float.valueOf(next.getSnr()));
                            if (next.usedInFix()) {
                                i2++;
                            }
                        }
                    }
                    if (a2 != null) {
                        a2.a(1, currentTimeMillis, gpsStatus);
                    }
                }
                this.p.set(i3);
                this.q.set(i2);
                a7.c("TxGpsProvider", "viewSate: " + i3 + ", usedSate: " + i2);
            } catch (Throwable th4) {
                th = th4;
                i = 0;
                th = th;
                a7.a("TxGpsProvider", "update sate error.", th);
            }
        } catch (Throwable th5) {
            th = th5;
            i = 0;
            i2 = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0086 -> B:62:0x0089). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o() {
        FileOutputStream fileOutputStream;
        Exception e;
        LinkedList<a> linkedList = L;
        if (linkedList != null && !linkedList.isEmpty()) {
            int size = L.size();
            if (size > 10) {
                L.subList(0, size - 10).clear();
            }
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    fileOutputStream = this.a.a.openFileOutput("g_q", 0);
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                        try {
                            objectOutputStream2.writeObject(L);
                            a7.b("TxGpsProvider", "gpsLocQueue write to file, size:" + L.size());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            objectOutputStream2.close();
                        } catch (Exception e3) {
                            e = e3;
                            objectOutputStream = objectOutputStream2;
                            try {
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                L.clear();
                                return;
                            } catch (Throwable th) {
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream = objectOutputStream2;
                            if (fileOutputStream != null) {
                            }
                            if (objectOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            L.clear();
            return;
        }
        a7.b("TxGpsProvider", "write gpsLocQueue is empty");
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class c extends q0.g {
        public c() {
        }

        @Override // c.t.m.g.q0.g
        public void a(long j, String str) {
            a5 a5Var;
            super.a(j, str);
            h5.this.a(j, str);
            a6 a6Var = new a6(str, j);
            if (!h5.this.h() || h5.this.H == null || (a5Var = h5.this.H) == null) {
                return;
            }
            a5Var.a(6006, 0, 0, a6Var);
        }

        @Override // c.t.m.g.q0.g
        public void b() {
            super.b();
            h5.this.a(2, (Object) null);
            a7.c("TxGpsProvider", "onGnssStatusStopped");
        }

        @Override // c.t.m.g.q0.g
        public void c(int i) {
            super.c(i);
            h5.this.a(3, (Object) null);
            a7.c("TxGpsProvider", "onGnssStatusFirstFix");
        }

        @Override // c.t.m.g.q0.g
        public void d(int i) {
            if (Build.VERSION.SDK_INT >= 24) {
                a7.b("TxGpsProvider", "SDK Version >= 24, gpsStatus disabled, use gnssStatus instead");
                return;
            }
            h5.this.a(i, (Object) null);
            a7.c("TxGpsProvider", "onGpsStatusChanged: " + i);
        }

        @Override // c.t.m.g.q0.g
        public void b(Object obj) {
            a5 a5Var;
            super.b(obj);
            if (!h5.this.h() || h5.this.H == null || (a5Var = h5.this.H) == null) {
                return;
            }
            a5Var.a(6002, 0, 0, obj);
        }

        @Override // c.t.m.g.q0.g
        public void c(Object obj) {
            super.c(obj);
            h5.this.a(4, obj);
            a7.c("TxGpsProvider", "onGnssSatelliteStatusChanged");
        }

        @Override // c.t.m.g.q0.g
        public void a() {
            super.a();
            h5.this.a(1, (Object) null);
            a7.c("TxGpsProvider", "onGnssStatusStarted");
        }

        @Override // c.t.m.g.q0.g
        public void b(int i) {
            a5 a5Var;
            super.b(i);
            if (!h5.this.h() || h5.this.H == null || (a5Var = h5.this.H) == null) {
                return;
            }
            a5Var.a(6003, i, 0, null);
        }

        @Override // c.t.m.g.q0.g
        public void a(Object obj) {
            a5 a5Var;
            GnssMeasurementsEvent gnssMeasurementsEvent;
            a7.c("TxGpsProvider", "onGnssMeasurementsReceived");
            h5.this.i = System.currentTimeMillis();
            super.a(obj);
            if (Build.VERSION.SDK_INT >= 24 && ((gnssMeasurementsEvent = (GnssMeasurementsEvent) obj) == null || gnssMeasurementsEvent.getClock() == null || gnssMeasurementsEvent.getMeasurements() == null)) {
                a7.b("TxGpsProvider", "eventArgs is null");
            } else if (!h5.this.h() || h5.this.H == null || (a5Var = h5.this.H) == null) {
            } else {
                a5Var.a(6004, 0, 0, obj);
            }
        }

        @Override // c.t.m.g.q0.g
        public void a(int i) {
            a5 a5Var;
            a7.c("TxGpsProvider", "onGnssMeasurementsStatusChanged: " + i);
            super.a(i);
            if (!h5.this.h() || h5.this.H == null || (a5Var = h5.this.H) == null) {
                return;
            }
            a5Var.a(6005, i, 0, null);
        }
    }

    public final boolean e(Location location) {
        try {
            if (location.getAccuracy() > 10000.0f) {
                return false;
            }
            if ((!a(location.getLatitude()) || !a(location.getLongitude())) && Math.abs(location.getLatitude()) >= 1.0E-8d && Math.abs(location.getLongitude()) >= 1.0E-8d && Math.abs(location.getLatitude() - 1.0d) >= 1.0E-8d && Math.abs(location.getLongitude() - 1.0d) >= 1.0E-8d && location.getLatitude() >= -90.0d && location.getLatitude() <= 90.0d && location.getLongitude() >= -180.0d) {
                if (location.getLongitude() <= 180.0d) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            a7.c("TxGpsProvider", th.toString());
            return true;
        }
    }

    public final boolean f(Location location) {
        return (this.q.get() == 0 && location.getBearing() == 0.0f && location.getSpeed() <= 0.0f) ? false : true;
    }

    public int b() {
        return this.b.get();
    }

    public void c(boolean z) {
        this.z = z;
    }

    public int d() {
        return this.q.get();
    }

    public final void g(Location location) {
        int i;
        if (this.q.get() < 0 || this.q.get() > 3) {
            i = (this.q.get() < 4 || this.q.get() > 6) ? 3 : 2;
        } else {
            i = 1;
        }
        int i2 = Boolean.parseBoolean(TencentLocationManagerOptions.getExtraDataForKey("isBaGun")) ? 3 : i;
        if (this.z && v6.a(location.getLatitude(), location.getLongitude())) {
            for (int i3 = 0; i3 <= 3; i3++) {
                double[] dArr = this.J;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                g7.a(location, dArr);
                a7.c("TxGpsProvider", "deflected, " + i3 + "," + this.J[0] + "," + this.J[1]);
                double[] dArr2 = this.J;
                if (dArr2[0] != 0.0d && dArr2[1] != 0.0d) {
                    break;
                }
            }
            double[] dArr3 = this.J;
            a(location, dArr3[0], dArr3[1], i2);
            a7.c("TxGpsProvider", "deflected, " + this.J[0] + "," + this.J[1]);
            double[] dArr4 = this.J;
            x4.i = new x4(dArr4[0], dArr4[1], location.getAltitude(), location.getAccuracy(), location.getBearing(), location.getSpeed());
            a7.c("TxGpsProvider", "cache gps02 " + x4.i);
        } else {
            a(location, location.getLatitude(), location.getLongitude(), i2);
            x4.h = new x4(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getAccuracy(), location.getBearing(), location.getSpeed());
            a7.c("TxGpsProvider", "cache wgs84 " + x4.h);
        }
        this.j = System.currentTimeMillis();
        o1.a().a(new x5(location, c(), e(), d(), b(), x5.a.GPS));
    }

    public void b(int i) {
        this.x = i;
    }

    public long c() {
        return this.j;
    }

    public boolean d(Location location) {
        if (location.getExtras() != null) {
            int i = location.getExtras().getInt("SourceType", 0);
            if ((i & 128) == 128) {
                w3.d("G", "HuaWei net insert , SourceType:" + i);
                return true;
            }
        }
        return false;
    }

    public void b(boolean z) {
        this.y = z;
    }

    public final boolean c(Location location) {
        boolean z;
        long time;
        if (location == null) {
            a7.b("TxGpsProvider", "location is null");
            return false;
        }
        if (L == null) {
            L = new LinkedList<>();
            a7.b("TxGpsProvider", "mGpsLocQueue is null");
        }
        Iterator<a> it = L.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            float accuracy = location.getAccuracy() + next.a();
            double distanceBetween = TencentLocationUtils.distanceBetween(next.b(), next.c(), location.getLatitude(), location.getLongitude());
            if (location.getTime() - next.d() >= 2000) {
                i += a(accuracy, distanceBetween, ((float) time) / 1000.0f);
            }
        }
        if (i >= 3) {
            a7.c("TxGpsProvider", "invalidSpeedNum:" + i + ", gps speed fake");
            z = true;
        } else {
            a aVar = new a(location);
            if (L.isEmpty()) {
                L.add(aVar);
            } else {
                a last = L.getLast();
                if (System.currentTimeMillis() - last.d() >= 2000 && a(aVar, last)) {
                    L.add(aVar);
                    a7.c("TxGpsProvider", "add gpsInfo into mGpsLocQueue");
                }
            }
            z = false;
        }
        if (L.size() > 10) {
            LinkedList<a> linkedList = L;
            linkedList.subList(0, linkedList.size() - 10).clear();
        }
        return z;
    }

    public void a(long j) {
        if (j < 0) {
            return;
        }
        this.m = j;
    }

    public final boolean b(Location location) {
        if (location != null && this.f != null) {
            float distanceTo = location.distanceTo(this.f);
            if (distanceTo > this.f.getAccuracy() + 1000.0f + location.getAccuracy() && System.currentTimeMillis() - this.k < 5000) {
                a7.c("TxGpsProvider", "isFarFromBeidou, dis: " + distanceTo);
                return true;
            }
        }
        return false;
    }

    public void a(Handler handler, Handler handler2, Handler handler3, boolean z) {
        a5 a5Var;
        if (this.t) {
            return;
        }
        this.t = true;
        this.j = 0L;
        Looper looper = handler == null ? null : handler.getLooper();
        b bVar = this.C;
        if (bVar == null || bVar.getLooper() != looper) {
            if (looper != null) {
                this.C = new b(looper);
            } else {
                this.C = new b(Looper.getMainLooper());
            }
        }
        if (!z) {
            k();
            if (h() && (a5Var = this.H) != null) {
                a5Var.a(this, this.C.getLooper());
                a7.c("TxGpsProvider", "start up BeidouProvider");
            }
            this.r = false;
            try {
                this.G = new c();
                int i = h() ? 30 : 14;
                if (Boolean.parseBoolean(TencentLocationManagerOptions.getExtraDataForKey("isBaGun"))) {
                    i = i & (-3) & (-5);
                    a7.c("TxGpsProvider", "disable gnss status and gnss nmea listener");
                }
                this.F.a(i, this.G, this.C.getLooper());
                this.w = System.currentTimeMillis();
            } catch (Throwable th) {
                w3.b("TxGpsProvider", th.toString());
            }
        } else {
            try {
                __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_requestLocationUpdates(this.D, "passive", 2000L, 1.0f, this);
            } catch (Throwable th2) {
                a7.b("TxGpsProvider", th2.toString());
            }
        }
        if (g()) {
            this.b.set(4);
            j();
        }
        a(1105);
        a7.c("TxGpsProvider", "startup: state=[start]");
    }

    public int e() {
        return this.p.get();
    }

    public final boolean a(double d) {
        return Math.abs(((double) Double.valueOf(d).longValue()) - d) < Double.MIN_VALUE;
    }

    public final double a(String str) {
        double parseDouble = Double.parseDouble(str);
        double floor = (int) Math.floor(parseDouble / 100.0d);
        return floor + ((parseDouble - (100.0d * floor)) / 60.0d);
    }

    public final void a(boolean z) {
        o1.a().a(new r1(12002, z ? 13003 : 13004));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, Location location) {
        boolean z;
        boolean z2;
        Location location2;
        boolean z3;
        float distanceTo;
        if (v4.a() || a5.a(location)) {
            return false;
        }
        boolean c2 = c(location);
        v4.a(2, c2);
        try {
            if (this.a.d().isProviderEnabled("gps")) {
                z = false;
            } else {
                a7.b("TxGpsProvider", "reason: isProviderEnabled false");
                z = true;
            }
            try {
                if (location.isFromMockProvider()) {
                    a7.b("TxGpsProvider", "reason: isFromMockProvider");
                    z = true;
                }
            } catch (Throwable th) {
                th = th;
                a7.b("TxGpsProvider", th.toString());
                if (!a(location)) {
                }
                v4.a(16, z);
                a7.b("TxGpsProvider", "is out door ? " + this.u);
                if (this.u) {
                }
                z2 = false;
                a7.b("TxGpsProvider", "mLastNmeaTime: " + this.h + ", mLastGpsOriginTime: " + this.l + ", diff: " + (this.l - this.h));
                if (!d(location)) {
                    a7.b("TxGpsProvider", "indoor,and no nmea, mock!!");
                    z2 = true;
                }
                if (!d(location)) {
                    a7.b("TxGpsProvider", "no measurement and no nmea, mock!!");
                    z2 = true;
                }
                v4.a(32, z2);
                location2 = this.g;
                if (location2 != null) {
                    distanceTo = location.distanceTo(this.g);
                    if (distanceTo > 100.0f) {
                    }
                }
                z3 = false;
                v4.a(64, z3);
                if (Boolean.parseBoolean(TencentLocationManagerOptions.getExtraDataForKey("isBaGun"))) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (!a(location)) {
            a7.b("TxGpsProvider", "reason: isComplete false");
            z = true;
        }
        v4.a(16, z);
        a7.b("TxGpsProvider", "is out door ? " + this.u);
        if (this.u && this.q.get() < 4 && System.currentTimeMillis() - this.w > 120000) {
            x3.a("G", "Mock:2");
            a7.b("TxGpsProvider", "indoor,but has location,mock!!");
            z2 = true;
        } else {
            z2 = false;
        }
        a7.b("TxGpsProvider", "mLastNmeaTime: " + this.h + ", mLastGpsOriginTime: " + this.l + ", diff: " + (this.l - this.h));
        if (!d(location) && !this.u && this.l - this.h >= 15000) {
            a7.b("TxGpsProvider", "indoor,and no nmea, mock!!");
            z2 = true;
        }
        if (!d(location) && this.l - this.h >= 15000 && this.l - this.i >= 15000) {
            a7.b("TxGpsProvider", "no measurement and no nmea, mock!!");
            z2 = true;
        }
        v4.a(32, z2);
        location2 = this.g;
        if (location2 != null && location2.getTime() != 0 && System.currentTimeMillis() - this.g.getTime() < 30000) {
            distanceTo = location.distanceTo(this.g);
            if (distanceTo > 100.0f) {
                a7.b("TxGpsProvider", "Distance:" + distanceTo);
                x3.a("G", "D:3:" + distanceTo);
                if (!this.u) {
                    z3 = true;
                    v4.a(64, z3);
                    return Boolean.parseBoolean(TencentLocationManagerOptions.getExtraDataForKey("isBaGun")) ? z || c2 : z || z2 || z3 || c2;
                }
            }
        }
        z3 = false;
        v4.a(64, z3);
        if (Boolean.parseBoolean(TencentLocationManagerOptions.getExtraDataForKey("isBaGun"))) {
        }
    }

    public final boolean a(Location location) {
        try {
            return location.getElapsedRealtimeNanos() != 0;
        } catch (Throwable th) {
            a7.a("TxGpsProvider", "isComplete: ", th);
            return true;
        }
    }

    public final void a(long j, String str) {
        String[] split;
        if (str == null || str.length() <= 5) {
            return;
        }
        this.h = System.currentTimeMillis();
        int indexOf = str.indexOf(",");
        String trim = indexOf <= 0 ? null : str.substring(0, indexOf).trim();
        if (trim == null || trim.length() <= 5 || trim.charAt(3) != 'R') {
            return;
        }
        if (("$GPRMC".equals(trim) || "$GNRMC".equals(trim) || "$BDRMC".equals(trim) || "$GLRMC".equals(trim)) && (split = str.split(",")) != null && split.length >= 6 && GpsTag.GPS_TAG_GPS_STATUS_VALUE_MEASUREMENT_IN_PROGRESS.equals(split[2])) {
            try {
                this.g.setLatitude(a(split[3]));
                this.g.setLongitude(a(split[5]));
                this.g.setTime(System.currentTimeMillis());
                a7.b("TxGpsProvider", "GPRMC:Lat:" + a(split[3]) + ",Lng" + a(split[5]));
            } catch (NumberFormatException e) {
                a7.a("TxGpsProvider", "<" + str + ">", e);
            }
        }
    }

    public void a(Location location, String str) {
        o1.a().a(new s1(location));
        if (a7.a) {
            double[] dArr = new double[2];
            g7.a(location, dArr);
            a7.c("TxGpsProvider", "$ " + str + String.format(Locale.getDefault(), ": %f,%f,%f,%f,%f,%f,%d", Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), Long.valueOf(location.getTime())));
        }
        if ("gps".equals(location.getProvider())) {
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putString("gnss_source", str);
            location.setExtras(extras);
            a7.c("TxGpsProvider", "gpsLocation from " + str);
            if (!str.equals("beidou")) {
                this.l = System.currentTimeMillis();
                a7.c("TxGpsProvider", "mLastGpsOriginTime: " + this.l);
            } else {
                this.f = location;
                this.k = System.currentTimeMillis();
                a7.c("TxGpsProvider", "mLastBeiDouTime: " + this.k);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            long currentTimeMillis2 = System.currentTimeMillis() - this.l;
            a7.c("TxGpsProvider", "lastBeidouElapsedTime: " + currentTimeMillis + ", lastGpsOriginElapsedTime: " + currentTimeMillis2);
            if (this.x == 21) {
                if (str.equals("gps")) {
                    if (currentTimeMillis < 1500) {
                        a7.c("TxGpsProvider", "gps call back, beidou is valid, use beidou cache, lastBeidouElapsedTime: " + currentTimeMillis);
                        return;
                    }
                    a7.c("TxGpsProvider", "gps call back, beidou not valid, use gps, lastBeidouElapsedTime: " + currentTimeMillis);
                }
            } else if (str.equals("beidou")) {
                if (currentTimeMillis2 < PayTask.j) {
                    a7.c("TxGpsProvider", "beidou call back, gps is valid, use gps cache, lastGpsOriginElapsedTime: " + currentTimeMillis2);
                    return;
                }
                a7.c("TxGpsProvider", "beidou call back, gps not valid, use beidou, lastGpsOriginElapsedTime: " + currentTimeMillis2);
            }
            if (location.getExtras() != null) {
                int i = location.getExtras().getInt("SourceType", 0);
                if ((i & 128) == 128) {
                    x3.a("G", "SourceType:" + i);
                    return;
                }
            }
            if (this.e == null || location.getTime() - this.e.getTime() > 10000 || this.K) {
                x3.a("G", String.format(Locale.ENGLISH, "l,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Float.valueOf(location.getSpeed()), str));
            }
            this.K = !this.K;
            this.e = location;
            a(1101, location);
        }
    }

    public void a(int i, Object obj) {
        a5 a5Var;
        x3.a("G", "e[" + i + "]");
        boolean z = true;
        switch (i) {
            case 1:
                AtomicInteger atomicInteger = this.b;
                atomicInteger.set(atomicInteger.get() | 1);
                return;
            case 2:
                this.b.set(0);
                return;
            case 3:
                AtomicInteger atomicInteger2 = this.b;
                atomicInteger2.set(atomicInteger2.get() | 2);
                return;
            case 4:
                if (Build.VERSION.SDK_INT < 24) {
                    try {
                        this.f38c = this.a.d().getGpsStatus(this.f38c);
                        StringBuilder append = new StringBuilder().append("mGpsStatus: ");
                        if (this.f38c != null) {
                            z = false;
                        }
                        a7.c("TxGpsProvider", append.append(z).toString());
                    } catch (Throwable th) {
                    }
                } else {
                    this.d = obj;
                    if (h() && (a5Var = this.H) != null && a5Var != null) {
                        a5Var.a(6001, 0, 0, obj);
                    }
                }
                a(1102);
                return;
            default:
                return;
        }
    }

    public final void a(int i) {
        b bVar = this.C;
        if (bVar != null) {
            bVar.obtainMessage(i).sendToTarget();
        }
    }

    public final void a(int i, Location location) {
        try {
            b bVar = this.C;
            if (bVar != null) {
                a7.c("TxGpsProvider", "innerthread isalive:" + bVar.getLooper().getThread().isAlive());
                Message obtainMessage = bVar.obtainMessage(i);
                obtainMessage.obj = location;
                bVar.sendMessage(obtainMessage);
            }
        } catch (Throwable th) {
            x3.a("G", th.toString());
        }
    }

    public final void a(Location location, double d, double d2, int i) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putDouble("lat", d);
        extras.putDouble("lng", d2);
        extras.putInt("rssi", i);
        location.setExtras(extras);
    }

    public final boolean a(a aVar, a aVar2) {
        if (aVar.b() == 0.0d || aVar.c() == 0.0d) {
            return false;
        }
        return Math.abs(aVar.b() - aVar2.b()) >= 1.0E-7d || Math.abs(aVar.c() - aVar2.c()) >= 1.0E-7d;
    }

    public final boolean a(Location location, Location location2) {
        if (location == null) {
            return true;
        }
        if (location2 != null && this.q.get() < 3 && location.getLongitude() == location2.getLongitude() && location.getLatitude() == location2.getLatitude() && location.getAccuracy() == location2.getAccuracy() && location.getSpeed() == 0.0f && location2.getSpeed() == 0.0f && location.getBearing() == 0.0f && location2.getBearing() == 0.0f && location.getAltitude() == 0.0d && location2.getAltitude() == 0.0d) {
            a7.c("TxGpsProvider", "cur loc and last loc coordinate,speed,bearing,altitude is all same and =0,so filter current location");
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df A[Catch: IOException -> 0x00e3, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x00e3, blocks: (B:22:0x00ba, B:42:0x00df), top: B:68:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e4 -> B:67:0x00e7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        FileInputStream fileInputStream;
        Throwable th;
        Exception e;
        FileInputStream fileInputStream2;
        Exception e2;
        ObjectInputStream objectInputStream;
        String str;
        Context context = this.a.a;
        ObjectInputStream objectInputStream2 = 0;
        objectInputStream2 = 0;
        try {
            try {
                try {
                    str = ((File) Objects.requireNonNull(context.getFilesDir())).getAbsolutePath() + File.separator + "g_q";
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            if (!new File(str).exists()) {
                a7.b("TxGpsProvider", "file: " + str + " not exits.");
                return;
            }
            fileInputStream2 = context.openFileInput("g_q");
            try {
                objectInputStream = new ObjectInputStream(fileInputStream2);
                try {
                    LinkedList<a> linkedList = (LinkedList) objectInputStream.readObject();
                    L = linkedList;
                    if (linkedList == null) {
                        L = new LinkedList<>();
                        a7.b("TxGpsProvider", "gpsLocQueue is null, new gpsLocQueue");
                    } else if (linkedList.isEmpty()) {
                        a7.b("TxGpsProvider", "read gpsLocQueue is empty");
                    } else {
                        a7.c("TxGpsProvider", "get gpsLocQueue form file, size:" + L.size() + " " + L.toString());
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    objectInputStream.close();
                } catch (Exception e6) {
                    e2 = e6;
                    e2.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (objectInputStream == null) {
                        objectInputStream.close();
                    }
                }
            } catch (Exception e8) {
                e = e8;
                e2 = e;
                objectInputStream = null;
                e2.printStackTrace();
                if (fileInputStream2 != null) {
                }
                if (objectInputStream == null) {
                }
            } catch (Throwable th3) {
                fileInputStream = fileInputStream2;
                th = th3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                if (objectInputStream2 != 0) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            fileInputStream = "g_q";
            th = th4;
            objectInputStream2 = context;
        }
    }

    @JvmStatic
    private static void __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_requestLocationUpdates(LocationManager lm, String provider, long minTimeMs, float minDistanceM, LocationListener listener) {
        Intrinsics.checkNotNullParameter(lm, "lm");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("lm_request_location_updates_1")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [lm_request_location_updates_1]", (Throwable) null, 4, (Object) null);
                lm.requestLocationUpdates(provider, Long.valueOf(minTimeMs).longValue(), Float.valueOf(minDistanceM).floatValue(), listener);
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("lm_request_location_updates_1")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [lm_request_location_updates_1] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("lm_request_location_updates_1")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [lm_request_location_updates_1] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "lm_request_location_updates_1") == null) {
                lm.requestLocationUpdates(provider, Long.valueOf(minTimeMs).longValue(), Float.valueOf(minDistanceM).floatValue(), listener);
                Object res$iv = Unit.INSTANCE;
                PrivacyHelper.INSTANCE.getPrivacyCache().put("lm_request_location_updates_1", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "lm_request_location_updates_1", defaultCacheTime$iv)));
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: lm_request_location_updates_1", (Throwable) null, 4, (Object) null);
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: lm_request_location_updates_1, message = " + t$iv.getMessage(), t$iv);
                return;
            }
            PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: lm_request_location_updates_1, message = " + t$iv.getMessage(), (Throwable) null);
        }
    }

    @JvmStatic
    private static void __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_requestLocationUpdates(LocationManager lm, String provider, long minTimeMs, float minDistanceM, LocationListener listener, Looper looper) {
        Intrinsics.checkNotNullParameter(lm, "lm");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(looper, "looper");
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("lm_request_location_updates_2")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [lm_request_location_updates_2]", (Throwable) null, 4, (Object) null);
                lm.requestLocationUpdates(provider, Long.valueOf(minTimeMs).longValue(), Float.valueOf(minDistanceM).floatValue(), listener, looper);
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("lm_request_location_updates_2")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [lm_request_location_updates_2] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("lm_request_location_updates_2")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [lm_request_location_updates_2] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "lm_request_location_updates_2") == null) {
                lm.requestLocationUpdates(provider, Long.valueOf(minTimeMs).longValue(), Float.valueOf(minDistanceM).floatValue(), listener, looper);
                Object res$iv = Unit.INSTANCE;
                PrivacyHelper.INSTANCE.getPrivacyCache().put("lm_request_location_updates_2", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "lm_request_location_updates_2", defaultCacheTime$iv)));
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: lm_request_location_updates_2", (Throwable) null, 4, (Object) null);
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: lm_request_location_updates_2, message = " + t$iv.getMessage(), t$iv);
                return;
            }
            PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: lm_request_location_updates_2, message = " + t$iv.getMessage(), (Throwable) null);
        }
    }
}