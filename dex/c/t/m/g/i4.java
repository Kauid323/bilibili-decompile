package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.util.HashMap;
import java.util.UUID;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class i4 {
    public static volatile boolean a = false;
    public static volatile String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f41c = "";
    public static volatile String d = "";
    public static volatile boolean e = true;
    public static boolean f = true;
    public static int g;
    public static final byte[] h = new byte[0];
    public static HashMap<String, Object> i = new HashMap<>();

    @Deprecated
    public static String a() {
        return "";
    }

    public static synchronized void a(boolean z) {
        synchronized (i4.class) {
            a = z;
        }
    }

    public static synchronized Object b(String str) {
        Object obj;
        synchronized (i4.class) {
            obj = i.get(str);
            if (obj == null && (obj = b3.a().getSystemService(str)) != null) {
                i.put(str, obj);
            }
        }
        return obj;
    }

    public static String c() {
        Context a2 = b3.a();
        CharSequence loadLabel = a2.getApplicationInfo().loadLabel(a2.getPackageManager());
        return loadLabel == null ? "UNKNOWN" : loadLabel.toString();
    }

    public static String d() {
        return b(b3.a());
    }

    public static String e() {
        Context a2 = b3.a();
        try {
            return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(a2.getPackageManager(), a2.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            return "unknown";
        }
    }

    public static String f() {
        String g2 = g();
        try {
            if (TextUtils.isEmpty(d)) {
                d = h4.a(h4.a(), "loc_build_model_encr", "");
                if (TextUtils.isEmpty(d)) {
                    d = z3.a(g2, "MD5");
                    if (d.length() > 8) {
                        d = d.substring(0, 8);
                    }
                    h4.b(h4.a(), "loc_build_model_encr", d);
                }
            }
        } catch (Exception e2) {
        }
        if (e) {
            e = false;
            return g2 + "_" + d;
        }
        return "_" + d;
    }

    public static String g() {
        p();
        if (TextUtils.isEmpty(f41c)) {
            f41c = h4.a(h4.a(), "loc_build_model", "");
            if (TextUtils.isEmpty(f41c)) {
                f41c = Build.MODEL;
                h4.b(h4.a(), "loc_build_model", f41c);
            }
        }
        return f41c;
    }

    @Deprecated
    public static String h() {
        return "";
    }

    @Deprecated
    public static String i() {
        return "";
    }

    @Deprecated
    public static String j() {
        return "";
    }

    public static String k() {
        if (d4.a(b)) {
            synchronized (h) {
                b = (String) h4.a(h4.a(), "loc_id_LocCommId", (Object) "");
                if (d4.a(b)) {
                    long nanoTime = System.nanoTime();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = (currentTimeMillis * 1000000) + (nanoTime % 1000000);
                    b = z3.a("" + j, "MD5");
                    w3.a("SystemUtil", "generate LocCommId : " + nanoTime + "," + currentTimeMillis + "," + j + "," + b);
                    h4.b(h4.a(), "loc_id_LocCommId", (Object) b);
                }
            }
        }
        return b;
    }

    @Deprecated
    public static String l() {
        return "";
    }

    public static String m() {
        return t0.b();
    }

    @Deprecated
    public static String n() {
        return "";
    }

    public static String o() {
        try {
            String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
            return replaceAll.substring(0, 5) + replaceAll.substring(8, 10) + replaceAll.substring(14, 16) + replaceAll.substring(16, 18) + replaceAll.substring(20, 25);
        } catch (Exception e2) {
            return "".length() > 16 ? "".substring(0, 16) : "";
        }
    }

    public static synchronized void p() {
        synchronized (i4.class) {
        }
    }

    public static synchronized boolean q() {
        boolean z;
        synchronized (i4.class) {
            z = a;
        }
        return z;
    }

    public static int a(TelephonyManager telephonyManager) {
        if (f && telephonyManager != null) {
            g = telephonyManager.getSimState();
            f = false;
        }
        return g;
    }

    @Deprecated
    public static String b(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            return "UNKNOWN";
        }
    }

    @Deprecated
    public static String a(Context context) {
        try {
            CharSequence loadLabel = context.getApplicationInfo().loadLabel(context.getPackageManager());
            String replaceAll = loadLabel == null ? "UNKNOWN" : loadLabel.toString().replaceAll("_", "");
            String replaceAll2 = context.getPackageName().replaceAll("_", "");
            PackageInfo __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384);
            return replaceAll + "_" + replaceAll2 + "_" + __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo.versionCode + "_" + __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo.versionName;
        } catch (Throwable th) {
            return "UNKNOWN AppInfo";
        }
    }

    public static String b() {
        return a(b3.a());
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "0123456789ABCDEF" : str;
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
        } catch (Exception e2) {
            agreeGetPackageInfo = true;
        }
        if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("pm_get_package_info") || !agreeGetPackageInfo) {
            try {
                String str = (String) ConfigManager.Companion.config().get("privacy.pkg_info_whitelist", (Object) null);
                if (str != null) {
                }
                inPkgWhiteLst = false;
            } catch (Exception e3) {
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