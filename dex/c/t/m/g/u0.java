package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import c.t.m.g.v0;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class u0 {
    public Context a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f103c = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                u0.this.b.put(iBinder);
            } catch (Exception e) {
                w3.a("ASUSDeviceIDHelper", "onServiceConnected", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public u0(Context context) {
        this.a = context;
    }

    public void a(v0.b bVar) {
        try {
            __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(this.a.getPackageManager(), "com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e) {
            w3.a("ASUSDeviceIDHelper", "getID", e);
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.a.bindService(intent, this.f103c, 1)) {
            try {
                f1 f1Var = new f1(this.b.take());
                String e2 = f1Var.e();
                boolean f = f1Var.f();
                if (bVar != null) {
                    bVar.a(e2, f);
                }
            } catch (Exception e3) {
                w3.a("ASUSDeviceIDHelper", "getID", e3);
            }
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