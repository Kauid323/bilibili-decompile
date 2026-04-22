package de.robv.android.xposed;

import android.os.SELinux;
import de.robv.android.xposed.services.BaseService;
import de.robv.android.xposed.services.BinderService;
import de.robv.android.xposed.services.DirectAccessService;
import de.robv.android.xposed.services.ZygoteService;

public final class SELinuxHelper {
    private static boolean sIsSELinuxEnabled = false;
    private static BaseService sServiceAppDataFile = null;

    private SELinuxHelper() {
    }

    public static boolean isSELinuxEnabled() {
        return sIsSELinuxEnabled;
    }

    public static boolean isSELinuxEnforced() {
        return sIsSELinuxEnabled && SELinux.isSELinuxEnforced();
    }

    public static String getContext() {
        if (sIsSELinuxEnabled) {
            return SELinux.getContext();
        }
        return null;
    }

    public static BaseService getAppDataFileService() {
        if (sServiceAppDataFile != null) {
            return sServiceAppDataFile;
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initOnce() {
        try {
            sIsSELinuxEnabled = SELinux.isSELinuxEnabled();
        } catch (NoClassDefFoundError e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initForProcess(String packageName) {
        if (sIsSELinuxEnabled) {
            if (packageName == null) {
                sServiceAppDataFile = new ZygoteService();
                return;
            } else if (packageName.equals("android")) {
                sServiceAppDataFile = BinderService.getService(0);
                return;
            } else {
                sServiceAppDataFile = new DirectAccessService();
                return;
            }
        }
        sServiceAppDataFile = new DirectAccessService();
    }
}