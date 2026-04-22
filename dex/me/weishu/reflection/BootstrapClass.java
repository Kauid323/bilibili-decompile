package me.weishu.reflection;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

public final class BootstrapClass {
    private static final String TAG = "BootstrapClass";
    private static Object sVmRuntime;
    private static Method setHiddenApiExemptions;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method forName = Class.class.getDeclaredMethod("forName", String.class);
                Method getDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class<?> vmRuntimeClass = (Class) forName.invoke(null, "dalvik.system.VMRuntime");
                Method getRuntime = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "getRuntime", null);
                setHiddenApiExemptions = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "setHiddenApiExemptions", new Class[]{String[].class});
                sVmRuntime = getRuntime.invoke(null, new Object[0]);
            } catch (Throwable e) {
                Log.w(TAG, "reflect bootstrap failed:", e);
            }
        }
    }

    public static boolean exempt(String method) {
        return exempt(method);
    }

    public static boolean exempt(String... methods) {
        if (sVmRuntime == null || setHiddenApiExemptions == null) {
            return false;
        }
        try {
            setHiddenApiExemptions.invoke(sVmRuntime, methods);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean exemptAll() {
        return exempt("L");
    }
}