package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import c.t.m.g.k2;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class m4 {
    public static HandlerThread o;
    public static volatile m4 p;
    public final Context a;
    public final n4 b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f65c;
    public final HashMap<String, o4> d;
    public final PackageManager e;
    public final TelephonyManager f;
    public final WifiManager g;
    public final LocationManager h;
    public final h6 i;
    public CountDownLatch j;
    public String k;
    public s6 l;
    public byte[] n = k3.a(16);
    public l2 m = u1.a().a(k2.a.FORMALLOCREQ);

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements ThreadFactory {
        public a(m4 m4Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "network_request_pool");
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m4.this.p();
            m4.this.j.countDown();
        }
    }

    public m4(Context context) {
        this.a = context;
        this.e = context.getPackageManager();
        this.f = (TelephonyManager) context.getSystemService("phone");
        this.g = (WifiManager) context.getSystemService("wifi");
        this.h = (LocationManager) context.getSystemService("location");
        this.l = new t6(context);
        this.i = new l5(context, h7.a(context.getPackageName()));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f65c = threadPoolExecutor;
        HandlerThread handlerThread = new HandlerThread("GeoLocationService");
        o = handlerThread;
        handlerThread.start();
        HashMap<String, o4> hashMap = new HashMap<>();
        this.d = hashMap;
        hashMap.put("cell", new p4("cell"));
        this.b = new n4();
        try {
            String b2 = b(context);
            a7.b("AppContext", "key = " + b2);
            this.b.d(b2);
        } catch (Exception e) {
            a7.b("AppContext", "transactionTooLarge");
        }
        e7.a(context.getApplicationContext());
        o();
    }

    public static m4 b() {
        return p;
    }

    public byte[] c() {
        w3.a("AppContext", "aes key: " + Arrays.toString(this.n));
        return this.n;
    }

    public LocationManager d() {
        return this.h;
    }

    public s6 e() {
        return this.l;
    }

    public l2 f() {
        return this.m;
    }

    public TelephonyManager g() {
        return this.f;
    }

    public ExecutorService h() {
        return this.f65c;
    }

    public WifiManager i() {
        return this.g;
    }

    public HandlerThread j() {
        HandlerThread handlerThread;
        synchronized (m4.class) {
            if (o == null || o.getLooper() == null || !o.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("GeoLocationService");
                o = handlerThread2;
                handlerThread2.start();
            }
            handlerThread = o;
        }
        return handlerThread;
    }

    public boolean k() {
        return this.h != null;
    }

    public boolean l() {
        return this.f != null;
    }

    public boolean m() {
        return this.g != null;
    }

    public final void n() {
        n4 n4Var = this.b;
        PackageInfo q = q();
        n4Var.b(q.versionCode);
        n4Var.j(q.versionName);
        CharSequence loadLabel = this.a.getApplicationInfo().loadLabel(this.e);
        n4Var.a(loadLabel != null ? loadLabel.toString() : "unknown");
        try {
            TelephonyManager g = g();
            if (g != null) {
                this.k = d7.a(i4.h(), d7.a).toUpperCase(Locale.ENGLISH);
                String a2 = d7.a(i4.j(), d7.b);
                n4Var.a(g.getPhoneType());
                n4Var.b(this.k);
                n4Var.i(a2);
                a7.c("AppContext", "mDeviceId: " + this.k + "; subscriberId: " + a2 + com.alipay.sdk.m.q.h.b);
            }
        } catch (Throwable th) {
            a7.a("AppContext", "", th);
        }
        n4Var.f(d7.a(i4.l().replaceAll(":", "").toUpperCase(Locale.ENGLISH), d7.f22c));
        PackageManager packageManager = this.e;
        boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.location.gps");
        boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.wifi");
        boolean hasSystemFeature3 = packageManager.hasSystemFeature("android.hardware.telephony");
        n4Var.b(hasSystemFeature);
        n4Var.c(hasSystemFeature2);
        n4Var.a(hasSystemFeature3);
        a7.c("AppContext", "doInBg: hasGps=" + hasSystemFeature + ",hasWifi=" + hasSystemFeature2 + ",hasCell=" + hasSystemFeature3);
    }

    public void o() {
        this.j = new CountDownLatch(1);
        new Thread(new b()).start();
    }

    public void p() {
        try {
            a7.c("AppContext", "doInBg: app status init start");
            n();
            a7.c("AppContext", "doInBg: app status init done");
        } catch (Throwable th) {
            a7.a("AppContext", "doInBg: app status init error", th);
        }
    }

    public final PackageInfo q() {
        try {
            return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(this.e, this.a.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            return new PackageInfo();
        }
    }

    public static m4 a(Context context) {
        if (p == null) {
            synchronized (m4.class) {
                if (p == null) {
                    p = new m4(context);
                }
            }
        }
        return p;
    }

    public String b(String str) {
        return this.i.a(str);
    }

    public static String b(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.containsKey("TencentGeoLocationSDK") ? bundle.getString("TencentGeoLocationSDK") : bundle.containsKey("TencentMapSDK") ? bundle.getString("TencentMapSDK") : "";
            }
        } catch (Exception e) {
        }
        return "";
    }

    public n4 a() {
        return this.b;
    }

    public o4 a(String str) {
        return this.d.get(str);
    }

    public Bundle a(String str, byte[] bArr, boolean z, boolean z2) throws IOException {
        byte[] bArr2;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        Bundle a2 = this.i.a(str, bArr);
        a7.a("HalleyTimeCost: " + (System.currentTimeMillis() - currentTimeMillis) + ", reqKey: " + a2.getString("req_key"));
        if (z2) {
            a7.c("AppContext", "currnt reqeust is iot");
            if (z) {
                bArr2 = h7.b(a2.getByteArray("data_bytes"));
            } else {
                bArr2 = a2.getByteArray("data_bytes");
            }
        } else {
            a7.c("AppContext", "currnt reqeust is not iot");
            byte[] byteArray = a2.getByteArray("data_bytes");
            byte[] c2 = b().c();
            byte[] a3 = h3.a(byteArray, c2, c2);
            if (!z) {
                bArr2 = a3;
            } else {
                bArr2 = h7.b(a3);
            }
        }
        if (bArr2 != null) {
            str2 = new String(bArr2, a2.getString("data_charset"));
        } else {
            a7.c("AppContext", "postSync: inflate failed");
            str2 = "{}";
        }
        a2.remove("data_charset");
        a2.remove("data_bytes");
        a2.putString(com.alipay.sdk.m.q.k.f247c, str2);
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (kotlin.text.StringsKt.contains$default(r5, r9, false, 2, (java.lang.Object) null) == true) goto L19;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PackageInfo __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(PackageManager pm, String pkg, int flag) {
        boolean agreeGetPackageInfo;
        Intrinsics.checkNotNullParameter(pm, "pm");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        boolean inPkgWhiteLst = true;
        try {
            agreeGetPackageInfo = ConfigManager.Companion.ab2().getWithDefault("ff.privacy.hook.agree.get_package_info", true);
        } catch (Exception e) {
            agreeGetPackageInfo = true;
        }
        if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("pm_get_package_info") || !agreeGetPackageInfo) {
            try {
                String str = (String) ConfigManager.Companion.config().get("privacy.pkg_info_whitelist", (Object) null);
                if (str != null) {
                }
                inPkgWhiteLst = false;
            } catch (Exception e2) {
            }
            if (!inPkgWhiteLst) {
                if (Intrinsics.areEqual(pkg, FoundationAlias.getFapps().getAppId())) {
                    PackageInfo fake = pm.getPackageArchiveInfo(FoundationAlias.getFapp().getPackageCodePath(), 0);
                    if (fake == null) {
                        PackageInfo it = new PackageInfo();
                        it.versionCode = 2233;
                        return it;
                    }
                    return fake;
                }
                throw new PackageManager.NameNotFoundException(pkg);
            }
        }
        PackageInfo packageInfo = pm.getPackageInfo(pkg, Integer.valueOf(flag).intValue());
        if (packageInfo instanceof PackageInfo) {
            return packageInfo;
        }
        return null;
    }
}