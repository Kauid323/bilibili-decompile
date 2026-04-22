package c.t.m.g;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class e0 extends n2 {

    /* renamed from: c  reason: collision with root package name */
    public LocationManager f23c;
    public Handler d;
    public volatile Location f;
    public volatile int g = 2;
    public LocationListener h = new b();
    public Runnable e = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b implements LocationListener {
        public long a = 0;

        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    if ("gps".equals(location.getProvider())) {
                        if (m0.f63c || !location.isFromMockProvider()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (Math.abs(currentTimeMillis - this.a) < 1000) {
                                return;
                            }
                            this.a = currentTimeMillis;
                            e0.this.f = location;
                            float speed = location.hasSpeed() ? location.getSpeed() : -1.0f;
                            if (d0.c() != null) {
                                if (w3.a()) {
                                    w3.c("ArGpsProvider", location.getLatitude() + "," + location.getLongitude() + "," + location.getAltitude() + "," + location.getAccuracy() + "," + location.getBearing() + "," + location.getSpeed() + "," + location.getTime());
                                }
                                d0.c().a(currentTimeMillis, speed);
                            }
                        }
                    }
                } catch (Throwable th) {
                    n0.a("ArGpsProvider", "onLocationChanged error.", th);
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public e0() {
        this.f23c = null;
        this.f23c = (LocationManager) b3.a().getSystemService("location");
    }

    @Override // c.t.m.g.o2
    public String a() {
        return "ArGpsProvider";
    }

    @Override // c.t.m.g.o2
    public void d() {
        try {
            this.f23c.removeUpdates(this.h);
        } catch (Throwable th) {
            n0.a("ArGpsProvider", "remove updates error.", th);
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.d = null;
        n0.a("ArGpsProvider", "status:[shutdown]");
    }

    @Override // c.t.m.g.n2
    public int b(Looper looper) {
        Handler handler = new Handler(looper);
        this.d = handler;
        handler.post(this.e);
        n0.a("ArGpsProvider", "status:[start]");
        return 0;
    }

    public void a(int i) {
        this.g = i;
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                if (e0.this.d == null || e0.this.g == 0) {
                    return;
                }
                if (e0.this.g == 1) {
                    str = "gps";
                } else {
                    int unused = e0.this.g;
                    str = "passive";
                }
                __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_requestLocationUpdates(e0.this.f23c, str, 1000L, 0.0f, e0.this.h, e0.this.d.getLooper());
            } catch (Throwable th) {
                n0.a("ArGpsProvider", "No Permission,can not add location listener", th);
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
}