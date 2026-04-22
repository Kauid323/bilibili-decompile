package tv.danmaku.bili.report;

import android.app.Activity;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.ui.intent.IntentHandlerActivity;

/* compiled from: ReferrerUtil.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/report/ReferrerUtil;", "", "<init>", "()V", "referrer", "", "installer", "getInstaller", "()Ljava/lang/String;", "installer$delegate", "Lkotlin/Lazy;", "installTime", "getInstallTime", "installTime$delegate", "getReferrer", "initReferrer", "", "firstActivity", "Landroid/app/Activity;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ReferrerUtil {
    private static String referrer;
    public static final ReferrerUtil INSTANCE = new ReferrerUtil();
    private static final Lazy installer$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.report.ReferrerUtil$$ExternalSyntheticLambda0
        public final Object invoke() {
            String installer_delegate$lambda$0;
            installer_delegate$lambda$0 = ReferrerUtil.installer_delegate$lambda$0();
            return installer_delegate$lambda$0;
        }
    });
    private static final Lazy installTime$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.report.ReferrerUtil$$ExternalSyntheticLambda1
        public final Object invoke() {
            String installTime_delegate$lambda$0;
            installTime_delegate$lambda$0 = ReferrerUtil.installTime_delegate$lambda$0();
            return installTime_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private ReferrerUtil() {
    }

    public final String getInstaller() {
        return (String) installer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String installer_delegate$lambda$0() {
        String __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getInstallerPackageName;
        try {
            PackageManager packageManager = FoundationAlias.getFapp().getPackageManager();
            if (Build.VERSION.SDK_INT > 29) {
                InstallSourceInfo installSource = packageManager.getInstallSourceInfo(FoundationAlias.getFapp().getPackageName());
                Intrinsics.checkNotNullExpressionValue(installSource, "getInstallSourceInfo(...)");
                __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getInstallerPackageName = installSource.getInstallingPackageName();
            } else {
                __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getInstallerPackageName = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getInstallerPackageName(packageManager, FoundationAlias.getFapp().getPackageName());
            }
            if (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getInstallerPackageName == null) {
                return "";
            }
            return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getInstallerPackageName;
        } catch (Exception e) {
            return "";
        }
    }

    public final String getInstallTime() {
        return (String) installTime$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String installTime_delegate$lambda$0() {
        try {
            return String.valueOf(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(FoundationAlias.getFapp().getPackageManager(), FoundationAlias.getFapp().getPackageName(), 0).firstInstallTime);
        } catch (Exception e) {
            return "";
        }
    }

    public final String getReferrer() {
        String str = referrer;
        return str == null ? "" : str;
    }

    public final void initReferrer(Activity firstActivity) {
        String authority;
        Intrinsics.checkNotNullParameter(firstActivity, "firstActivity");
        if (referrer != null) {
            return;
        }
        if (!(firstActivity instanceof IntentHandlerActivity) && !(firstActivity instanceof MainActivityV2)) {
            String msg = "unknown app entrance: " + firstActivity.getClass().getName();
            if (AppBuildConfig.Companion.getDebug()) {
                throw new IllegalStateException(msg.toString());
            }
            BLog.w(msg);
        }
        Uri referrerUrl = firstActivity.getReferrer();
        if (referrerUrl == null) {
            authority = "";
        } else {
            authority = Intrinsics.areEqual(referrerUrl.getScheme(), "android-app") ? referrerUrl.getAuthority() : referrerUrl.toString();
        }
        referrer = authority;
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

    @JvmStatic
    private static String __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getInstallerPackageName(PackageManager pm, String pkg) {
        Intrinsics.checkNotNullParameter(pm, "pm");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Object defaultReturnValue$iv = null;
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("pm_get_installer_package_name")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [pm_get_installer_package_name]", (Throwable) null, 4, (Object) null);
                Object installerPackageName = pm.getInstallerPackageName(pkg);
                defaultReturnValue$iv = installerPackageName instanceof String ? installerPackageName : null;
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("pm_get_installer_package_name")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [pm_get_installer_package_name] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("pm_get_installer_package_name")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [pm_get_installer_package_name] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
            } else {
                Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "pm_get_installer_package_name");
                if (it$iv == null) {
                    Object installerPackageName2 = pm.getInstallerPackageName(pkg);
                    if (!(installerPackageName2 instanceof String)) {
                        installerPackageName2 = null;
                    }
                    Object res$iv = installerPackageName2;
                    if (res$iv != null) {
                        PrivacyHelper.INSTANCE.getPrivacyCache().put("pm_get_installer_package_name", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "pm_get_installer_package_name", defaultCacheTime$iv)));
                    }
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: pm_get_installer_package_name", (Throwable) null, 4, (Object) null);
                    defaultReturnValue$iv = res$iv;
                } else {
                    defaultReturnValue$iv = it$iv;
                }
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: pm_get_installer_package_name, message = " + t$iv.getMessage(), t$iv);
            } else {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: pm_get_installer_package_name, message = " + t$iv.getMessage(), (Throwable) null);
            }
        }
        return (String) defaultReturnValue$iv;
    }
}