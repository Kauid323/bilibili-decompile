package de.robv.android.xposed;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.os.RuntimeInit;
import com.android.internal.os.ZygoteInit;
import dalvik.system.PathClassLoader;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class XposedBridge {
    static long BOOT_START_TIME = 0;
    private static final int RUNTIME_ART = 2;
    private static final int RUNTIME_DALVIK = 1;
    public static final String TAG = "Xposed";
    @Deprecated
    public static int XPOSED_BRIDGE_VERSION;
    public static final ClassLoader BOOTCLASSLOADER = ClassLoader.getSystemClassLoader();
    static boolean isZygote = true;
    private static int runtime = 0;
    static boolean disableHooks = false;
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private static final Map<Member, CopyOnWriteSortedSet<XC_MethodHook>> sHookedMethodCallbacks = new HashMap();
    static final CopyOnWriteSortedSet<XC_LoadPackage> sLoadedPackageCallbacks = new CopyOnWriteSortedSet<>();
    static final CopyOnWriteSortedSet<XC_InitPackageResources> sInitPackageResourcesCallbacks = new CopyOnWriteSortedSet<>();

    private static native Object cloneToSubclassNative(Object obj, Class<?> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void closeFilesBeforeForkNative();

    static native void dumpObjectNative(Object obj);

    private static native int getRuntime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getStartClassName();

    public static native int getXposedVersion();

    private static native boolean hadInitErrors();

    private static native synchronized void hookMethodNative(Member member, Class<?> cls, int i2, Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean initXResourcesNative();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void invalidateCallersNative(Member[] memberArr);

    private static native Object invokeOriginalMethodNative(Member member, int i2, Class<?>[] clsArr, Class<?> cls, Object obj, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    private static native void removeFinalFlagNative(Class<?> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void reopenFilesAfterForkNative();

    private static native void setObjectClassNative(Object obj, Class<?> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean startsSystemServer();

    private XposedBridge() {
    }

    protected static void main(String[] args) {
        try {
            if (hadInitErrors()) {
                Log.e(TAG, "Not initializing Xposed because of previous errors");
            } else {
                initXResources();
                SELinuxHelper.initOnce();
                SELinuxHelper.initForProcess(null);
                runtime = getRuntime();
                XPOSED_BRIDGE_VERSION = getXposedVersion();
                if (isZygote) {
                    XposedInit.hookResources();
                    XposedInit.initForZygote();
                }
                XposedInit.loadModules();
            }
        } catch (Throwable t) {
            Log.e(TAG, "Errors during Xposed initialization", t);
            disableHooks = true;
        }
        if (isZygote) {
            ZygoteInit.main(args);
        } else {
            RuntimeInit.main(args);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    protected static final class ToolEntryPoint {
        protected ToolEntryPoint() {
        }

        protected static void main(String[] args) {
            XposedBridge.isZygote = false;
            XposedBridge.main(args);
        }
    }

    private static void initXResources() throws IOException {
        Resources res = Resources.getSystem();
        File resDexFile = ensureSuperDexFile("XResources", res.getClass(), Resources.class);
        Class<?> taClass = TypedArray.class;
        try {
            TypedArray ta = res.obtainTypedArray(res.getIdentifier("preloaded_drawables", "array", "android"));
            taClass = ta.getClass();
            ta.recycle();
        } catch (Resources.NotFoundException nfe) {
            log(nfe);
        }
        Runtime.getRuntime().gc();
        File taDexFile = ensureSuperDexFile("XTypedArray", taClass, TypedArray.class);
        ClassLoader myCL = XposedBridge.class.getClassLoader();
        String paths = resDexFile.getAbsolutePath() + File.pathSeparator + taDexFile.getAbsolutePath();
        PathClassLoader dummyCL = new PathClassLoader(paths, myCL.getParent());
        XposedHelpers.setObjectField(myCL, "parent", dummyCL);
    }

    private static File ensureSuperDexFile(String clz, Class<?> realSuperClz, Class<?> topClz) throws IOException {
        removeFinalFlagNative(realSuperClz);
        File dexFile = DexCreator.ensure(clz, realSuperClz, topClz);
        dexFile.setReadable(true, false);
        return dexFile;
    }

    public static synchronized void log(String text) {
        synchronized (XposedBridge.class) {
            if (TextUtils.isEmpty(text)) {
                return;
            }
            Log.i(TAG, text);
        }
    }

    public static synchronized void log(Throwable t) {
        synchronized (XposedBridge.class) {
            Log.e(TAG, Log.getStackTraceString(t));
        }
    }

    public static XC_MethodHook.Unhook hookMethod(Member hookMethod, XC_MethodHook callback) {
        Class<?> exposedBridge = XposedHelpers.findClass("me.weishu.exposed.ExposedBridge", XposedBridge.class.getClassLoader());
        return (XC_MethodHook.Unhook) XposedHelpers.callStaticMethod(exposedBridge, "hookMethod", hookMethod, callback);
    }

    @Deprecated
    public static void unhookMethod(Member hookMethod, XC_MethodHook callback) {
        synchronized (sHookedMethodCallbacks) {
            try {
                try {
                    CopyOnWriteSortedSet<XC_MethodHook> callbacks = sHookedMethodCallbacks.get(hookMethod);
                    if (callbacks == null) {
                        return;
                    }
                    callbacks.remove(callback);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback) {
        Member[] declaredMethods;
        Set<XC_MethodHook.Unhook> unhooks = new HashSet<>();
        for (Member method : hookClass.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                unhooks.add(hookMethod(method, callback));
            }
        }
        return unhooks;
    }

    public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> hookClass, XC_MethodHook callback) {
        Member[] declaredConstructors;
        Set<XC_MethodHook.Unhook> unhooks = new HashSet<>();
        for (Member constructor : hookClass.getDeclaredConstructors()) {
            unhooks.add(hookMethod(constructor, callback));
        }
        return unhooks;
    }

    private static Object handleHookedMethod(Member method, int originalMethodId, Object additionalInfoObj, Object thisObject, Object[] args) throws Throwable {
        int beforeIdx;
        AdditionalHookInfo additionalInfo = (AdditionalHookInfo) additionalInfoObj;
        if (disableHooks) {
            try {
                return invokeOriginalMethodNative(method, originalMethodId, additionalInfo.parameterTypes, additionalInfo.returnType, thisObject, args);
            } catch (InvocationTargetException e2) {
                throw e2.getCause();
            }
        }
        Object[] callbacksSnapshot = additionalInfo.callbacks.getSnapshot();
        int callbacksLength = callbacksSnapshot.length;
        if (callbacksLength == 0) {
            try {
                return invokeOriginalMethodNative(method, originalMethodId, additionalInfo.parameterTypes, additionalInfo.returnType, thisObject, args);
            } catch (InvocationTargetException e3) {
                throw e3.getCause();
            }
        }
        XC_MethodHook.MethodHookParam param = new XC_MethodHook.MethodHookParam();
        param.method = method;
        param.thisObject = thisObject;
        param.args = args;
        int beforeIdx2 = 0;
        while (true) {
            try {
                ((XC_MethodHook) callbacksSnapshot[beforeIdx2]).beforeHookedMethod(param);
                if (param.returnEarly) {
                    beforeIdx = beforeIdx2 + 1;
                    break;
                }
            } catch (Throwable t) {
                log(t);
                param.setResult(null);
                param.returnEarly = false;
            }
            beforeIdx2++;
            if (beforeIdx2 >= callbacksLength) {
                beforeIdx = beforeIdx2;
                break;
            }
        }
        if (!param.returnEarly) {
            try {
                param.setResult(invokeOriginalMethodNative(method, originalMethodId, additionalInfo.parameterTypes, additionalInfo.returnType, param.thisObject, param.args));
            } catch (InvocationTargetException e4) {
                param.setThrowable(e4.getCause());
            }
        }
        int afterIdx = beforeIdx - 1;
        do {
            Object lastResult = param.getResult();
            Throwable lastThrowable = param.getThrowable();
            try {
                ((XC_MethodHook) callbacksSnapshot[afterIdx]).afterHookedMethod(param);
            } catch (Throwable t2) {
                log(t2);
                if (lastThrowable == null) {
                    param.setResult(lastResult);
                } else {
                    param.setThrowable(lastThrowable);
                }
            }
            afterIdx--;
        } while (afterIdx >= 0);
        if (param.hasThrowable()) {
            throw param.getThrowable();
        }
        return param.getResult();
    }

    public static void hookLoadPackage(XC_LoadPackage callback) {
        synchronized (sLoadedPackageCallbacks) {
            sLoadedPackageCallbacks.add(callback);
        }
    }

    public static void hookInitPackageResources(XC_InitPackageResources callback) {
        synchronized (sInitPackageResourcesCallbacks) {
            sInitPackageResourcesCallbacks.add(callback);
        }
    }

    public static Object invokeOriginalMethod(Member method, Object thisObject, Object[] args) throws NullPointerException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (args == null) {
            args = EMPTY_ARRAY;
        }
        Class<?> exposedBridge = XposedHelpers.findClass("me.weishu.exposed.ExposedBridge", XposedBridge.class.getClassLoader());
        return XposedHelpers.callStaticMethod(exposedBridge, "invokeOriginalMethod", method, thisObject, args);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setObjectClass(Object obj, Class<?> clazz) {
        if (clazz.isAssignableFrom(obj.getClass())) {
            throw new IllegalArgumentException("Cannot transfer object from " + obj.getClass() + " to " + clazz);
        }
        setObjectClassNative(obj, clazz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object cloneToSubclass(Object obj, Class<?> targetClazz) {
        if (obj == null) {
            return null;
        }
        if (!obj.getClass().isAssignableFrom(targetClazz)) {
            throw new ClassCastException(targetClazz + " doesn't extend " + obj.getClass());
        }
        return cloneToSubclassNative(obj, targetClazz);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CopyOnWriteSortedSet<E> {
        private volatile transient Object[] elements = XposedBridge.EMPTY_ARRAY;

        public synchronized boolean add(E e2) {
            int index = indexOf(e2);
            if (index >= 0) {
                return false;
            }
            Object[] newElements = new Object[this.elements.length + 1];
            System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
            newElements[this.elements.length] = e2;
            Arrays.sort(newElements);
            this.elements = newElements;
            return true;
        }

        public synchronized boolean remove(E e2) {
            int index = indexOf(e2);
            if (index == -1) {
                return false;
            }
            Object[] newElements = new Object[this.elements.length - 1];
            System.arraycopy(this.elements, 0, newElements, 0, index);
            System.arraycopy(this.elements, index + 1, newElements, index, (this.elements.length - index) - 1);
            this.elements = newElements;
            return true;
        }

        private int indexOf(Object o) {
            for (int i2 = 0; i2 < this.elements.length; i2++) {
                if (o.equals(this.elements[i2])) {
                    return i2;
                }
            }
            return -1;
        }

        public Object[] getSnapshot() {
            return this.elements;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static class AdditionalHookInfo {
        final CopyOnWriteSortedSet<XC_MethodHook> callbacks;
        final Class<?>[] parameterTypes;
        final Class<?> returnType;

        private AdditionalHookInfo(CopyOnWriteSortedSet<XC_MethodHook> callbacks, Class<?>[] parameterTypes, Class<?> returnType) {
            this.callbacks = callbacks;
            this.parameterTypes = parameterTypes;
            this.returnType = returnType;
        }
    }
}