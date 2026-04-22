package c.t.m.g;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import c.t.m.g.p6;
import c.t.m.g.x5;
import com.alipay.sdk.app.PayTask;
import com.ashampoo.kim.format.jpeg.iptc.IptcConstants;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import com.tencent.map.geolocation.util.SoUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class m5 {
    public final m4 a;

    /* renamed from: c  reason: collision with root package name */
    public final LocationManager f66c;
    public final HandlerThread e;
    public b f;
    public Looper g;
    public int l;
    public String m;
    public int n;
    public int o;
    public c p;
    public int b = 0;
    public final byte[] h = new byte[0];
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public final a d = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                a7.c("TxNetworkProvider", "system nlp callback,location: " + location);
                a7.c("TxNetworkProvider", "system nlp callback,isGetLastKownLoc: " + m5.this.j);
                if (m5.this.j) {
                    return;
                }
                m5.this.i = true;
                Location a = m5.this.a(location);
                a.setAccuracy(1000.0f);
                m5.this.b(a);
            } catch (Exception e) {
                m5.this.i = false;
                a7.a("TxNetworkProvider", "", e);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            a7.c("TxNetworkProvider", "onProviderDisabled: " + str);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            a7.c("TxNetworkProvider", "onProviderEnabled: " + str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            a7.c("TxNetworkProvider", "onStatusChanged: " + i);
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public interface c {
        void a(p6 p6Var, int i);
    }

    public m5(m4 m4Var) {
        this.a = m4Var;
        this.f66c = m4Var.d();
        HandlerThread handlerThread = new HandlerThread("loc_nlp_thread");
        this.e = handlerThread;
        handlerThread.start();
        this.g = this.e.getLooper();
        this.f = new b(this.g);
    }

    public void c(int i) {
        this.l = i;
    }

    public void b(int i) {
        this.o = i;
    }

    public boolean b() {
        if (this.b == 1) {
            return false;
        }
        synchronized (this.h) {
            a7.c("TxNetworkProvider", "send msg to MSG_ID_START ");
            p3.b(this.f, IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO, 0, 0, null);
            p3.a(this.f, (int) IptcConstants.IMAGE_RESOURCE_BLOCK_PHOTOSHOP2_COLOR_TABLE, (long) PayTask.j);
        }
        return true;
    }

    public void a(c cVar) {
        this.p = cVar;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(String str) {
        this.m = str;
    }

    public void a(int i) {
        this.n = i;
    }

    public boolean a() {
        if (this.b == 0) {
            return false;
        }
        synchronized (this.h) {
            a7.c("TxNetworkProvider", "send msg to MSG_ID_Stop");
            p3.b(this.f, IptcConstants.IMAGE_RESOURCE_BLOCK_XML_DATA, 0, 0, null);
        }
        return true;
    }

    public final void b(Location location) {
        x5 x5Var = new x5(location, System.currentTimeMillis(), 0, 0, 0, x5.a.NONE);
        y5 y5Var = new y5(null, null, x5Var, null, null);
        String a2 = y5Var.a(this.l, this.m, this.a, true, false, false);
        a7.c("TxNetworkProvider", "nlp json = " + a2);
        if (!(a2 == null || !g7.a(a2))) {
            a(a2, y5Var, this.n, x5Var);
            return;
        }
        a7.b("TxNetworkProvider", "handleMessage: bad json ");
        c cVar = this.p;
        if (cVar != null) {
            cVar.a(p6.q, this.o);
        }
    }

    public Location a(Location location) {
        if (location == null) {
            return e5.a;
        }
        if (this.k && v6.a(location.getLatitude(), location.getLongitude())) {
            a7.c("TxNetworkProvider", "notifyListeners: local deflect");
            double[] dArr = new double[2];
            g7.a(location, dArr);
            a(location, dArr[0], dArr[1], 0);
        } else {
            a(location, location.getLatitude(), location.getLongitude(), 0);
        }
        return location;
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

    /* JADX WARN: Removed duplicated region for block: B:40:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, y5 y5Var, int i, x5 x5Var) {
        double d;
        c cVar;
        double d2;
        boolean z;
        byte[] a2;
        String a3;
        double d3 = 0.0d;
        try {
            Location location = new Location(x5Var.a);
            Bundle extras = location.getExtras();
            if (extras == null) {
                d = 0.0d;
                d2 = 0.0d;
            } else {
                d = extras.getDouble("lat");
                try {
                    d2 = extras.getDouble("lng");
                } catch (Throwable th) {
                    th = th;
                    a7.a("TxNetworkProvider", "", th);
                    a7.c("TxNetworkProvider", "net error , just update coordinate");
                    Location location2 = new Location(x5Var.a);
                    a7.c("TxNetworkProvider", "origin loc 1: " + location2);
                    p6 a4 = new p6.b().b("network").a(this.l).a(location2.getExtras()).a(new Location(x5Var.a)).a();
                    location2.setLatitude(d);
                    location2.setLongitude(d3);
                    a4.b(location2);
                    a7.c("TxNetworkProvider", "origin loc 2: " + location2);
                    cVar = this.p;
                    if (cVar == null) {
                    }
                }
            }
            try {
                a7.c("TxNetworkProvider", "ongpschanged location extras:" + d + "," + d2);
                if (d == 0.0d && d2 == 0.0d) {
                    a7.c("TxNetworkProvider", "defl error");
                    c cVar2 = this.p;
                    if (cVar2 != null) {
                        cVar2.a(p6.q, this.o);
                        return;
                    }
                    return;
                }
                a7.c("TxNetworkProvider", str);
                if (e5.d && e5.e) {
                    a7.c("TxNetworkProvider", "current is iot");
                    a2 = h7.a(str.getBytes("GBK"));
                    a3 = a(a2, i);
                    z = true;
                } else {
                    a7.c("TxNetworkProvider", "current is not iot");
                    z = false;
                    a2 = m4.b().f().a(h7.a(str.getBytes("GBK")), m4.b().c(), false);
                    a3 = e5.a(i);
                }
                a7.c("TxNetworkProvider", "url: " + a3);
                long currentTimeMillis = System.currentTimeMillis();
                String string = this.a.a(a3, a2, true, z).getString(com.alipay.sdk.m.q.k.f247c);
                a7.c("TxNetworkProvider", "cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",result:" + string);
                if (string == null) {
                    string = "";
                }
                a7.c("TxNetworkProvider", "response: " + string);
                p6 a5 = new p6.b().a(new p6.b().a(string).a()).b("coarse").a(this.l).a(location.getExtras()).a(new Location(x5Var.a)).a();
                location.setLatitude(d);
                location.setLongitude(d2);
                a5.b(location);
                c cVar3 = this.p;
                if (cVar3 != null) {
                    cVar3.a(a5, this.o);
                }
            } catch (Throwable th2) {
                th = th2;
                d3 = d2;
                a7.a("TxNetworkProvider", "", th);
                a7.c("TxNetworkProvider", "net error , just update coordinate");
                Location location22 = new Location(x5Var.a);
                a7.c("TxNetworkProvider", "origin loc 1: " + location22);
                p6 a42 = new p6.b().b("network").a(this.l).a(location22.getExtras()).a(new Location(x5Var.a)).a();
                location22.setLatitude(d);
                location22.setLongitude(d3);
                a42.b(location22);
                a7.c("TxNetworkProvider", "origin loc 2: " + location22);
                cVar = this.p;
                if (cVar == null) {
                    cVar.a(a42, this.o);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            d = 0.0d;
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

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void a(Message message) {
            Location location = null;
            boolean z = false;
            switch (message.what) {
                case IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO /* 1001 */:
                    a7.c("TxNetworkProvider", "LocationManager MSG_ID_START 1");
                    m5.this.j = false;
                    m5.this.i = false;
                    try {
                        List<String> allProviders = m5.this.f66c.getAllProviders();
                        if (allProviders != null) {
                            for (String str : allProviders) {
                                a7.c("TxNetworkProvider", "LocationManager provider:" + str);
                                if ("network".equals(str)) {
                                    z = true;
                                }
                            }
                        }
                        a7.c("TxNetworkProvider", "LocationManager isSupportNetwork:" + z);
                        if (z) {
                            __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_requestLocationUpdates(m5.this.f66c, "network", 1000L, 0.0f, m5.this.d, m5.this.g);
                            a7.c("TxNetworkProvider", "permission ok");
                        }
                    } catch (Exception e) {
                        a7.a("TxNetworkProvider", "", e);
                    }
                    a7.c("TxNetworkProvider", "LocationManager MSG_ID_START 2");
                    m5.this.b = 1;
                    return;
                case IptcConstants.IMAGE_RESOURCE_BLOCK_XML_DATA /* 1002 */:
                    m5.this.j = false;
                    m5.this.i = false;
                    a7.c("TxNetworkProvider", "LocationManager MSG_ID_STOP 1 ");
                    removeCallbacksAndMessages(null);
                    m5.this.f66c.removeUpdates(m5.this.d);
                    m5.this.b = 0;
                    a7.c("TxNetworkProvider", "LocationManager MSG_ID_STOP 2 ");
                    return;
                case IptcConstants.IMAGE_RESOURCE_BLOCK_PHOTOSHOP2_COLOR_TABLE /* 1003 */:
                    a7.c("TxNetworkProvider", "MSG_ID_DELAY_GET_LASTLOC msg come, and isNLPcallback: " + m5.this.i);
                    if (m5.this.i) {
                        return;
                    }
                    try {
                        location = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getLastKnownLocation(m5.this.f66c, "network");
                        location.setAccuracy(5000.0f);
                        a7.c("TxNetworkProvider", "getLastKownLocation, " + location);
                    } catch (Throwable th) {
                        a7.a("TxNetworkProvider", "", th);
                    }
                    m5.this.b(m5.this.a(location));
                    m5.this.j = true;
                    return;
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
                a7.a("TxNetworkProvider", "", th);
            }
        }

        @JvmStatic
        private static Location __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getLastKnownLocation(LocationManager lm, String provider) {
            Intrinsics.checkNotNullParameter(lm, "lm");
            Intrinsics.checkNotNullParameter(provider, "provider");
            Object defaultReturnValue$iv = null;
            PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
            try {
                if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("lm_get_last_known_location")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [lm_get_last_known_location]", (Throwable) null, 4, (Object) null);
                    Object lastKnownLocation = lm.getLastKnownLocation(provider);
                    defaultReturnValue$iv = lastKnownLocation instanceof Location ? lastKnownLocation : null;
                } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("lm_get_last_known_location")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [lm_get_last_known_location] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
                } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("lm_get_last_known_location")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [lm_get_last_known_location] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
                } else {
                    Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "lm_get_last_known_location");
                    if (it$iv == null) {
                        Object lastKnownLocation2 = lm.getLastKnownLocation(provider);
                        if (!(lastKnownLocation2 instanceof Location)) {
                            lastKnownLocation2 = null;
                        }
                        Object res$iv = lastKnownLocation2;
                        if (res$iv != null) {
                            PrivacyHelper.INSTANCE.getPrivacyCache().put("lm_get_last_known_location", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "lm_get_last_known_location", defaultCacheTime$iv)));
                        }
                        ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: lm_get_last_known_location", (Throwable) null, 4, (Object) null);
                        defaultReturnValue$iv = res$iv;
                    } else {
                        defaultReturnValue$iv = it$iv;
                    }
                }
            } catch (Throwable t$iv) {
                if (PrivacyHelper.access$getDebug$p()) {
                    PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: lm_get_last_known_location, message = " + t$iv.getMessage(), t$iv);
                } else {
                    PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: lm_get_last_known_location, message = " + t$iv.getMessage(), (Throwable) null);
                }
            }
            return (Location) defaultReturnValue$iv;
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
}