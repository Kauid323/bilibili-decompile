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
public class e1 {
    public Context a;
    public String b = "com.mdid.msa";

    /* renamed from: c  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f24c = new LinkedBlockingQueue<>(1);
    public ServiceConnection d = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                e1.this.f24c.put(iBinder);
            } catch (Exception e) {
                w3.a("ZTEDeviceIDHelper", "onServiceConnected", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public e1(Context context) {
        this.a = context;
    }

    public final int a() {
        try {
            __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(this.a.getPackageManager(), this.b, 0);
            return 1;
        } catch (Exception e) {
            w3.a("ZTEDeviceIDHelper", "checkService", e);
            return 0;
        }
    }

    public final void a(String str) {
        a();
        Intent intent = new Intent();
        intent.setClassName(this.b, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (this.a.startService(intent) != null) {
            }
        } catch (Exception e) {
            w3.a("ZTEDeviceIDHelper", "startMsaklServer", e);
        }
    }

    public void a(v0.b bVar) {
        try {
            __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(this.a.getPackageManager(), this.b, 0);
        } catch (Exception e) {
            w3.a("ZTEDeviceIDHelper", "getID", e);
        }
        String packageName = this.a.getPackageName();
        a(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        try {
            if (this.a.bindService(intent, this.d, 1)) {
                try {
                    l1 l1Var = new l1(this.f24c.take());
                    String c2 = l1Var.c();
                    boolean a2 = l1Var.a();
                    if (bVar != null) {
                        bVar.a(c2, a2);
                    }
                    this.a.unbindService(this.d);
                } catch (Exception e2) {
                    w3.a("ZTEDeviceIDHelper", "getID", e2);
                }
            }
        } finally {
            this.a.unbindService(this.d);
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