package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import c.t.m.g.k1;
import c.t.m.g.v0;
import com.alipay.sdk.app.PayTask;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.security.MessageDigest;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class b1 {
    public Context a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public k1 f8c;
    public ServiceConnection d = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b1.this.f8c = k1.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b1.this.f8c = null;
        }
    }

    public b1(Context context) {
        this.a = context;
    }

    public String a(v0.b bVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.a.bindService(intent, this.d, 1)) {
                try {
                    SystemClock.sleep(PayTask.j);
                } catch (Exception e) {
                    w3.a("OppoDeviceIDHelper", "getID", e);
                }
                if (this.f8c != null) {
                    String a2 = a("OUID");
                    boolean a3 = a();
                    if (bVar != null) {
                        bVar.a(a2, a3);
                        return a2;
                    }
                    return a2;
                }
            }
            return null;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    public final String a(String str) {
        Signature[] signatureArr;
        String packageName = this.a.getPackageName();
        if (this.b == null) {
            String str2 = null;
            try {
                signatureArr = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(this.a.getPackageManager(), packageName, 64).signatures;
            } catch (Exception e) {
                w3.a("OppoDeviceIDHelper", "getID", e);
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Exception e2) {
                    w3.a("OppoDeviceIDHelper", "getID", e2);
                }
            }
            this.b = str2;
        }
        return ((k1.a.C0001a) this.f8c).a(packageName, this.b, str);
    }

    public final boolean a() {
        long j;
        try {
            PackageInfo __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(this.a.getPackageManager(), "com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                j = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo.getLongVersionCode();
            } else {
                j = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo.versionCode;
            }
            return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo != null && j >= 1;
        } catch (Exception e) {
            w3.a("OppoDeviceIDHelper", "isSupportOppo", e);
            return false;
        }
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