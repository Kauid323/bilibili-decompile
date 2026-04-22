package android.app;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class AndroidAppHelper {
    private static final Class<?> CLASS_RESOURCES_KEY = XposedHelpers.findClass("android.content.res.ResourcesKey", (ClassLoader) null);
    private static final boolean HAS_IS_THEMEABLE;
    private static final boolean HAS_THEME_CONFIG_PARAMETER;

    private AndroidAppHelper() {
    }

    static {
        boolean z = true;
        HAS_IS_THEMEABLE = XposedHelpers.findFieldIfExists(CLASS_RESOURCES_KEY, "mIsThemeable") != null;
        if (!HAS_IS_THEMEABLE || XposedHelpers.findMethodExactIfExists("android.app.ResourcesManager", (ClassLoader) null, "getThemeConfig", new Object[0]) == null) {
            z = false;
        }
        HAS_THEME_CONFIG_PARAMETER = z;
    }

    private static Map<Object, WeakReference> getResourcesMap(ActivityThread activityThread) {
        if (Build.VERSION.SDK_INT >= 24) {
            Object resourcesManager = XposedHelpers.getObjectField(activityThread, "mResourcesManager");
            return (Map) XposedHelpers.getObjectField(resourcesManager, "mResourceImpls");
        }
        Object resourcesManager2 = XposedHelpers.getObjectField(activityThread, "mResourcesManager");
        return (Map) XposedHelpers.getObjectField(resourcesManager2, "mActiveResources");
    }

    private static Object createResourcesKey(String resDir, float scale) {
        try {
            return HAS_IS_THEMEABLE ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, Float.valueOf(scale), false}) : XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, Float.valueOf(scale)});
        } catch (Throwable t) {
            XposedBridge.log(t);
            return null;
        }
    }

    private static Object createResourcesKey(String resDir, int displayId, Configuration overrideConfiguration, float scale) {
        try {
            return HAS_THEME_CONFIG_PARAMETER ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, Integer.valueOf(displayId), overrideConfiguration, Float.valueOf(scale), false, null}) : HAS_IS_THEMEABLE ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, Integer.valueOf(displayId), overrideConfiguration, Float.valueOf(scale), false}) : XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, Integer.valueOf(displayId), overrideConfiguration, Float.valueOf(scale)});
        } catch (Throwable t) {
            XposedBridge.log(t);
            return null;
        }
    }

    private static Object createResourcesKey(String resDir, int displayId, Configuration overrideConfiguration, float scale, IBinder token) {
        try {
            return HAS_THEME_CONFIG_PARAMETER ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, Integer.valueOf(displayId), overrideConfiguration, Float.valueOf(scale), false, null, token}) : HAS_IS_THEMEABLE ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, Integer.valueOf(displayId), overrideConfiguration, Float.valueOf(scale), false, token}) : XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, Integer.valueOf(displayId), overrideConfiguration, Float.valueOf(scale), token});
        } catch (Throwable t) {
            XposedBridge.log(t);
            return null;
        }
    }

    private static Object createResourcesKey(String resDir, String[] splitResDirs, String[] overlayDirs, String[] libDirs, int displayId, Configuration overrideConfiguration, CompatibilityInfo compatInfo) {
        try {
            return XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[]{resDir, splitResDirs, overlayDirs, libDirs, Integer.valueOf(displayId), overrideConfiguration, compatInfo});
        } catch (Throwable t) {
            XposedBridge.log(t);
            return null;
        }
    }

    public static void addActiveResource(String resDir, float scale, boolean isThemeable, Resources resources) {
        addActiveResource(resDir, resources);
    }

    public static void addActiveResource(String resDir, Resources resources) {
        Object resourcesKey;
        ActivityThread thread = ActivityThread.currentActivityThread();
        if (thread == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            CompatibilityInfo compatInfo = (CompatibilityInfo) XposedHelpers.newInstance(CompatibilityInfo.class, new Object[0]);
            XposedHelpers.setFloatField(compatInfo, "applicationScale", resources.hashCode());
            resourcesKey = createResourcesKey(resDir, null, null, null, 0, null, compatInfo);
        } else if (Build.VERSION.SDK_INT == 23) {
            resourcesKey = createResourcesKey(resDir, 0, null, resources.hashCode());
        } else {
            resourcesKey = createResourcesKey(resDir, 0, null, resources.hashCode(), null);
        }
        if (resourcesKey != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Object resImpl = XposedHelpers.getObjectField(resources, "mResourcesImpl");
                getResourcesMap(thread).put(resourcesKey, new WeakReference(resImpl));
                return;
            }
            getResourcesMap(thread).put(resourcesKey, new WeakReference(resources));
        }
    }

    public static String currentProcessName() {
        String processName = ActivityThread.currentPackageName();
        if (processName == null) {
            return "android";
        }
        return processName;
    }

    public static ApplicationInfo currentApplicationInfo() {
        Object boundApplication;
        ActivityThread am = ActivityThread.currentActivityThread();
        if (am == null || (boundApplication = XposedHelpers.getObjectField(am, "mBoundApplication")) == null) {
            return null;
        }
        return (ApplicationInfo) XposedHelpers.getObjectField(boundApplication, "appInfo");
    }

    public static String currentPackageName() {
        ApplicationInfo ai = currentApplicationInfo();
        return ai != null ? ai.packageName : "android";
    }

    public static Application currentApplication() {
        return ActivityThread.currentApplication();
    }

    @Deprecated
    public static SharedPreferences getSharedPreferencesForPackage(String packageName, String prefFileName, int mode) {
        return new XSharedPreferences(packageName, prefFileName);
    }

    @Deprecated
    public static SharedPreferences getDefaultSharedPreferencesForPackage(String packageName) {
        return new XSharedPreferences(packageName);
    }

    @Deprecated
    public static void reloadSharedPreferencesIfNeeded(SharedPreferences pref) {
        if (pref instanceof XSharedPreferences) {
            ((XSharedPreferences) pref).reload();
        }
    }
}