package tv.danmaku.bili.update.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PackageUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0000\u001a \u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0006*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TAG", "", "DEFAULT_APP_NAME", "getAppName", "Landroid/content/Context;", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "packageName", "flag", "", "getPackageArchiveInfo", "apkPath", "flags", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PackageUtilsKt {
    private static final String DEFAULT_APP_NAME = "app_name";
    private static final String TAG = "PackageUtilsKt";

    public static final String getAppName(Context $this$getAppName) {
        Intrinsics.checkNotNullParameter($this$getAppName, "<this>");
        try {
            return $this$getAppName.getPackageManager().getApplicationLabel($this$getAppName.getApplicationInfo()).toString();
        } catch (Throwable e) {
            Log.e(TAG, "getAppName/e:" + e);
            return DEFAULT_APP_NAME;
        }
    }

    public static final PackageInfo getPackageInfo(Context $this$getPackageInfo, String packageName, int flag) {
        Intrinsics.checkNotNullParameter($this$getPackageInfo, "<this>");
        String packageName2 = packageName;
        PackageManager manager = $this$getPackageInfo.getPackageManager();
        if (manager == null) {
            return null;
        }
        if (StringsKt.isBlank(packageName2)) {
            packageName2 = $this$getPackageInfo.getPackageName();
        }
        if (packageName2 == null) {
            return null;
        }
        try {
            return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(manager, packageName2, flag);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static final PackageInfo getPackageArchiveInfo(Context $this$getPackageArchiveInfo, String apkPath, int flags) {
        PackageManager manager;
        Intrinsics.checkNotNullParameter($this$getPackageArchiveInfo, "<this>");
        Intrinsics.checkNotNullParameter(apkPath, "apkPath");
        if (StringsKt.isBlank(apkPath) || !new File(apkPath).isFile() || (manager = $this$getPackageArchiveInfo.getPackageManager()) == null) {
            return null;
        }
        return manager.getPackageArchiveInfo(apkPath, flags);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
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