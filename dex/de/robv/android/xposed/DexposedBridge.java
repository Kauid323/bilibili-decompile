package de.robv.android.xposed;

import android.app.AndroidAppHelper;
import android.util.Log;
import com.taobao.android.dexposed.utility.Logger;
import com.taobao.android.dexposed.utility.Runtime;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.method.ArtMethod;
import me.weishu.reflection.Reflection;

public final class DexposedBridge {
    public static final ClassLoader BOOTCLASSLOADER;
    private static final Object[] EMPTY_ARRAY;
    private static final String TAG = "DexposedBridge";
    private static final ArrayList<XC_MethodHook.Unhook> allUnhookCallbacks;
    private static final Map<Member, CopyOnWriteSortedSet<XC_MethodHook>> hookedMethodCallbacks;

    private static native synchronized void hookMethodNative(Member member, Class<?> cls, int i2, Object obj);

    private static native Object invokeOriginalMethodNative(Member member, int i2, Class<?>[] clsArr, Class<?> cls, Object obj, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    private static native Object invokeSuperNative(Object obj, Object[] objArr, Member member, Class<?> cls, Class<?>[] clsArr, Class<?> cls2, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    static {
        try {
            System.loadLibrary("epic");
            Reflection.unseal(AndroidAppHelper.currentApplication());
        } catch (Throwable e2) {
            log(e2);
        }
        EMPTY_ARRAY = new Object[0];
        BOOTCLASSLOADER = ClassLoader.getSystemClassLoader();
        hookedMethodCallbacks = new HashMap();
        allUnhookCallbacks = new ArrayList<>();
    }

    public static synchronized void log(String text) {
        synchronized (DexposedBridge.class) {
            Log.i(TAG, text);
        }
    }

    public static synchronized void log(Throwable t) {
        synchronized (DexposedBridge.class) {
            log(Log.getStackTraceString(t));
        }
    }

    public static XC_MethodHook.Unhook hookMethod(Member hookMethod, XC_MethodHook callback) {
        Class<?>[] parameterTypes;
        Class<?> returnType;
        if (!(hookMethod instanceof Method) && !(hookMethod instanceof Constructor)) {
            throw new IllegalArgumentException("only methods and constructors can be hooked");
        }
        boolean newMethod = false;
        synchronized (hookedMethodCallbacks) {
            try {
                try {
                    CopyOnWriteSortedSet<XC_MethodHook> callbacks = hookedMethodCallbacks.get(hookMethod);
                    if (callbacks == null) {
                        callbacks = new CopyOnWriteSortedSet<>();
                        hookedMethodCallbacks.put(hookMethod, callbacks);
                        newMethod = true;
                    }
                    Logger.w(TAG, "hook: " + hookMethod + ", newMethod ? " + newMethod);
                    callbacks.add(callback);
                    if (newMethod) {
                        if (Runtime.isArt()) {
                            if (hookMethod instanceof Method) {
                                Epic.hookMethod((Method) hookMethod);
                            } else {
                                Epic.hookMethod((Constructor) hookMethod);
                            }
                        } else {
                            Class<?> declaringClass = hookMethod.getDeclaringClass();
                            int slot = XposedHelpers.getIntField(hookMethod, "slot");
                            if (hookMethod instanceof Method) {
                                parameterTypes = ((Method) hookMethod).getParameterTypes();
                                returnType = ((Method) hookMethod).getReturnType();
                            } else {
                                parameterTypes = ((Constructor) hookMethod).getParameterTypes();
                                returnType = null;
                            }
                            AdditionalHookInfo additionalInfo = new AdditionalHookInfo(callbacks, parameterTypes, returnType);
                            hookMethodNative(hookMethod, declaringClass, slot, additionalInfo);
                        }
                    }
                    callback.getClass();
                    return new XC_MethodHook.Unhook(hookMethod);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static void unhookMethod(Member hookMethod, XC_MethodHook callback) {
        synchronized (hookedMethodCallbacks) {
            try {
                try {
                    CopyOnWriteSortedSet<XC_MethodHook> callbacks = hookedMethodCallbacks.get(hookMethod);
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

    public static XC_MethodHook.Unhook findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
        if (parameterTypesAndCallback.length == 0 || !(parameterTypesAndCallback[parameterTypesAndCallback.length - 1] instanceof XC_MethodHook)) {
            throw new IllegalArgumentException("no callback defined");
        }
        XC_MethodHook callback = (XC_MethodHook) parameterTypesAndCallback[parameterTypesAndCallback.length - 1];
        Method m = XposedHelpers.findMethodExact(clazz, methodName, parameterTypesAndCallback);
        XC_MethodHook.Unhook unhook = hookMethod(m, callback);
        synchronized (allUnhookCallbacks) {
            allUnhookCallbacks.add(unhook);
        }
        return unhook;
    }

    public static void unhookAllMethods() {
        synchronized (allUnhookCallbacks) {
            for (int i2 = 0; i2 < allUnhookCallbacks.size(); i2++) {
                allUnhookCallbacks.get(i2).unhook();
            }
            allUnhookCallbacks.clear();
        }
    }

    public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> hookClass, XC_MethodHook callback) {
        Member[] declaredConstructors;
        Set<XC_MethodHook.Unhook> unhooks = new HashSet<>();
        for (Member constructor : hookClass.getDeclaredConstructors()) {
            unhooks.add(hookMethod(constructor, callback));
        }
        return unhooks;
    }

    public static Object handleHookedArtMethod(Object artMethodObject, Object thisObject, Object[] args) {
        int beforeIdx;
        ArtMethod artmethod = (ArtMethod) artMethodObject;
        synchronized (hookedMethodCallbacks) {
            try {
                try {
                    CopyOnWriteSortedSet<XC_MethodHook> callbacks = hookedMethodCallbacks.get(artmethod.getExecutable());
                    Object[] callbacksSnapshot = callbacks.getSnapshot();
                    int callbacksLength = callbacksSnapshot.length;
                    if (callbacksLength == 0) {
                        try {
                            ArtMethod method = Epic.getBackMethod(artmethod);
                            return method.invoke(thisObject, args);
                        } catch (Exception e2) {
                            log(e2.getCause());
                        }
                    }
                    XC_MethodHook.MethodHookParam param = new XC_MethodHook.MethodHookParam();
                    param.method = (Member) artmethod.getExecutable();
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
                            ArtMethod method2 = Epic.getBackMethod(artmethod);
                            Object result = method2.invoke(thisObject, args);
                            param.setResult(result);
                        } catch (Exception e3) {
                            param.setThrowable(e3);
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
                        Throwable throwable = param.getThrowable();
                        if ((throwable instanceof IllegalAccessException) || (throwable instanceof InvocationTargetException) || (throwable instanceof InstantiationException)) {
                            throwable.getCause();
                            throwNoCheck(param.getThrowable().getCause(), null);
                            return null;
                        }
                        Logger.e(TAG, "epic cause exception in call bridge!!", throwable);
                        return null;
                    }
                    Object result2 = param.getResult();
                    return result2;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static <T extends Throwable> void throwNoCheck(Throwable exception, Object dummy) throws Throwable {
        throw exception;
    }

    private static Object handleHookedMethod(Member method, int originalMethodId, Object additionalInfoObj, Object thisObject, Object[] args) throws Throwable {
        int beforeIdx;
        AdditionalHookInfo additionalInfo = (AdditionalHookInfo) additionalInfoObj;
        Object[] callbacksSnapshot = additionalInfo.callbacks.getSnapshot();
        int callbacksLength = callbacksSnapshot.length;
        if (callbacksLength == 0) {
            try {
                return invokeOriginalMethodNative(method, originalMethodId, additionalInfo.parameterTypes, additionalInfo.returnType, thisObject, args);
            } catch (InvocationTargetException e2) {
                throw e2.getCause();
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
            } catch (InvocationTargetException e3) {
                param.setThrowable(e3.getCause());
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

    public static Object invokeSuper(Object obj, Member method, Object... args) throws NoSuchFieldException {
        int slot = 0;
        try {
            if (!Runtime.isArt()) {
                Method m = XposedHelpers.findMethodExact((Class<?>) obj.getClass().getSuperclass(), method.getName(), ((Method) method).getParameterTypes());
                slot = XposedHelpers.getIntField(m, "slot");
            }
            return invokeSuperNative(obj, args, method, method.getDeclaringClass(), ((Method) method).getParameterTypes(), ((Method) method).getReturnType(), slot);
        } catch (IllegalAccessException e2) {
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InvocationTargetException e4) {
            throw new XposedHelpers.InvocationTargetError(e4.getCause());
        }
    }

    public static Object invokeOriginalMethod(Member method, Object thisObject, Object[] args) throws NullPointerException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?>[] parameterTypes;
        Class<?> returnType;
        ArtMethod artMethod;
        if (args == null) {
            args = EMPTY_ARRAY;
        }
        if (method instanceof Method) {
            Class<?>[] parameterTypes2 = ((Method) method).getParameterTypes();
            parameterTypes = parameterTypes2;
            returnType = ((Method) method).getReturnType();
        } else if (method instanceof Constructor) {
            Class<?>[] parameterTypes3 = ((Constructor) method).getParameterTypes();
            parameterTypes = parameterTypes3;
            returnType = null;
        } else {
            throw new IllegalArgumentException("method must be of type Method or Constructor");
        }
        if (Runtime.isArt()) {
            if (method instanceof Method) {
                artMethod = ArtMethod.of((Method) method);
            } else {
                artMethod = ArtMethod.of((Constructor) method);
            }
            try {
                return Epic.getBackMethod(artMethod).invoke(thisObject, args);
            } catch (InstantiationException e2) {
                throwNoCheck(e2, null);
            }
        }
        return invokeOriginalMethodNative(method, 0, parameterTypes, returnType, thisObject, args);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class CopyOnWriteSortedSet<E> {
        private volatile transient Object[] elements = DexposedBridge.EMPTY_ARRAY;

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

        public synchronized void clear() {
            this.elements = DexposedBridge.EMPTY_ARRAY;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class AdditionalHookInfo {
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