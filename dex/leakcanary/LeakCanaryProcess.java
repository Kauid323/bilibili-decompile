package leakcanary;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Process;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.io.ConstantsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.RemoteLeakCanaryWorkerService;
import shark.SharkLog;

/* compiled from: LeakCanaryProcess.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"Lleakcanary/LeakCanaryProcess;", "", "()V", "isInAnalyzerProcess", "", "Ljava/lang/Boolean;", "context", "Landroid/content/Context;", "isInServiceProcess", "serviceClass", "Ljava/lang/Class;", "Landroid/app/Service;", "leakcanary-android-process_release"}, k = 1, mv = {1, 4, 1})
public final class LeakCanaryProcess {
    public static final LeakCanaryProcess INSTANCE = new LeakCanaryProcess();
    private static volatile Boolean isInAnalyzerProcess;

    private LeakCanaryProcess() {
    }

    public final boolean isInAnalyzerProcess(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Boolean isInAnalyzerProcess2 = isInAnalyzerProcess;
        if (isInAnalyzerProcess2 == null) {
            isInAnalyzerProcess2 = Boolean.valueOf(isInServiceProcess(context, RemoteLeakCanaryWorkerService.class));
            isInAnalyzerProcess = isInAnalyzerProcess2;
        }
        return isInAnalyzerProcess2.booleanValue();
    }

    private final boolean isInServiceProcess(Context context, Class<? extends Service> cls) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(packageManager, context.getPackageName(), 4);
            Intrinsics.checkExpressionValueIsNotNull(packageInfo, "packageManager.getPackag…kageManager.GET_SERVICES)");
            String mainProcess = packageInfo.applicationInfo.processName;
            ComponentName component = new ComponentName(context, cls);
            try {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(component, ConstantsKt.MINIMUM_BLOCK_SIZE);
                Intrinsics.checkExpressionValueIsNotNull(serviceInfo, "packageManager.getServic….GET_DISABLED_COMPONENTS)");
                if (serviceInfo.processName == null) {
                    SharkLog this_$iv = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv = this_$iv.getLogger();
                    if (logger$iv != null) {
                        logger$iv.d("Did not expect service " + cls + " to have a null process name");
                    }
                    return false;
                } else if (Intrinsics.areEqual(serviceInfo.processName, mainProcess)) {
                    SharkLog this_$iv2 = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv2 = this_$iv2.getLogger();
                    if (logger$iv2 != null) {
                        logger$iv2.d("Did not expect service " + cls + " to run in main process " + mainProcess);
                    }
                    return false;
                } else {
                    int myPid = Process.myPid();
                    Object systemService = context.getSystemService("activity");
                    if (systemService == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
                    }
                    ActivityManager activityManager = (ActivityManager) systemService;
                    ActivityManager.RunningAppProcessInfo myProcess = null;
                    try {
                        List runningProcesses = activityManager.getRunningAppProcesses();
                        if (runningProcesses != null) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo process = it.next();
                                if (process.pid == myPid) {
                                    myProcess = process;
                                    break;
                                }
                            }
                        }
                        if (myProcess == null) {
                            SharkLog this_$iv3 = SharkLog.INSTANCE;
                            SharkLog.Logger logger$iv3 = this_$iv3.getLogger();
                            if (logger$iv3 != null) {
                                logger$iv3.d("Could not find running process for " + myPid);
                                return false;
                            }
                            return false;
                        }
                        return Intrinsics.areEqual(myProcess.processName, serviceInfo.processName);
                    } catch (SecurityException exception) {
                        SharkLog this_$iv4 = SharkLog.INSTANCE;
                        SharkLog.Logger logger$iv4 = this_$iv4.getLogger();
                        if (logger$iv4 != null) {
                            logger$iv4.d("Could not get running app processes " + exception);
                            return false;
                        }
                        return false;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        } catch (Exception e2) {
            SharkLog this_$iv5 = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv5 = this_$iv5.getLogger();
            if (logger$iv5 != null) {
                logger$iv5.d(e2, "Could not get package info for " + context.getPackageName());
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r9, false, 2, (java.lang.Object) null) == true) goto L19;
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