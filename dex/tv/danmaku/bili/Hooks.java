package tv.danmaku.bili;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.view.inputmethod.InputMethodManager;
import com.bilibili.commons.ClassUtils;
import com.bilibili.commons.StringUtils;
import com.bilibili.lib.crashreport.CrashReporter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import tv.danmaku.android.log.BLog;

public final class Hooks {
    private static boolean sIsHooked = false;

    private Hooks() {
    }

    public static void hook(Context context) {
        if (sIsHooked) {
            return;
        }
        sIsHooked = true;
        try {
            hookPackageManager(context);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        try {
            hookInputMethodManger(context);
        } catch (Throwable t2) {
            t2.printStackTrace();
        }
    }

    static synchronized void hookPackageManager(Context context) {
        synchronized (Hooks.class) {
            try {
                Class<?> activityThreadClass = ClassUtils.getClass(context.getClassLoader(), "android.app.ActivityThread", false);
                try {
                    Class<?> iPackageManagerClass = ClassUtils.getClass(context.getClassLoader(), "android.content.pm.IPackageManager", false);
                    try {
                        Field packageManagerField = activityThreadClass.getDeclaredField("sPackageManager");
                        packageManagerField.setAccessible(true);
                        try {
                            Object packageManager = packageManagerField.get(null);
                            if (packageManager == null) {
                                packageManager = activityThreadClass.getMethod("getPackageManager", new Class[0]).invoke(null, new Object[0]);
                            }
                            if (Proxy.isProxyClass(packageManager.getClass())) {
                                return;
                            }
                            Object proxy = Proxy.newProxyInstance(context.getClassLoader(), new Class[]{iPackageManagerClass}, new PackageManagerProxy(packageManager));
                            try {
                                packageManagerField.set(null, proxy);
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                        }
                    } catch (NoSuchFieldException e3) {
                    }
                } catch (ClassNotFoundException e4) {
                }
            } catch (ClassNotFoundException e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class PackageManagerProxy implements InvocationHandler {
        private Object mPackageManager;

        public PackageManagerProxy(Object packageManager) {
            this.mPackageManager = packageManager;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
                Object result = method.invoke(this.mPackageManager, args);
                return ("getPackageInfo".equals(method.getName()) && (result instanceof PackageInfo)) ? afterGetPackageInfoMethodCall((PackageInfo) result, args) : result;
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }

        private Object afterGetPackageInfoMethodCall(PackageInfo result, Object[] args) {
            if (args.length < 3 || args[1] == null) {
                return result;
            }
            long flags = 0;
            if (args[1] instanceof Integer) {
                flags = ((Integer) args[1]).longValue();
            } else if (args[1] instanceof Long) {
                flags = ((Long) args[1]).longValue();
            }
            if ((4096 & flags) == 0) {
                return result;
            }
            String[] requestedPermissions = result.requestedPermissions;
            if (requestedPermissions == null) {
                return result;
            }
            int permLength = requestedPermissions.length;
            int[] requestedPermissionsFlags = result.requestedPermissionsFlags;
            int flagsLength = requestedPermissionsFlags.length;
            if (flagsLength != permLength) {
                return result;
            }
            if (StringUtils.equals(requestedPermissions[permLength - 1], "android.permission.READ_LOGS")) {
                return result;
            }
            String[] permissions = new String[permLength + 1];
            System.arraycopy(requestedPermissions, 0, permissions, 0, permLength);
            permissions[permLength - 1] = "android.permission.READ_LOGS";
            result.requestedPermissions = permissions;
            int[] permissionsFlags = new int[flagsLength + 1];
            System.arraycopy(requestedPermissionsFlags, 0, permissionsFlags, 0, flagsLength);
            permissionsFlags[flagsLength - 1] = 2;
            result.requestedPermissionsFlags = permissionsFlags;
            return result;
        }
    }

    static synchronized void hookInputMethodManger(Context context) {
        synchronized (Hooks.class) {
            InputMethodManager im = (InputMethodManager) context.getSystemService("input_method");
            try {
                Field mServiceField = InputMethodManager.class.getDeclaredField("mService");
                mServiceField.setAccessible(true);
                try {
                    Object iInputMethodManager = mServiceField.get(im);
                    if (Proxy.isProxyClass(iInputMethodManager.getClass())) {
                        return;
                    }
                    Object proxy = Proxy.newProxyInstance(context.getClassLoader(), iInputMethodManager.getClass().getInterfaces(), new InputMethodManagerProxy(iInputMethodManager));
                    try {
                        mServiceField.set(im, proxy);
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                }
            } catch (NoSuchFieldException e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class InputMethodManagerProxy implements InvocationHandler {
        private Object mService;

        public InputMethodManagerProxy(Object service) {
            this.mService = service;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
                return method.invoke(this.mService, args);
            } catch (RuntimeException e) {
                if (caughtInputChannelException(method, e)) {
                    return null;
                }
                throw e;
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if ((cause instanceof RuntimeException) && caughtInputChannelException(method, (RuntimeException) cause)) {
                    return null;
                }
                throw cause;
            }
        }

        private boolean caughtInputChannelException(Method method, RuntimeException e) {
            String methodName = method.getName();
            if (StringUtils.contains(e.getMessage(), "input channel file descriptors")) {
                if ("windowGainedFocus".equals(methodName) || "startInput".equals(methodName) || "startInputOrWindowGainedFocus".equals(methodName)) {
                    BLog.w("InputMethodManager", "Got runtime exception on call " + methodName, e);
                    CrashReporter.INSTANCE.postCaughtException(new InputChannelException("God bless you!"));
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}