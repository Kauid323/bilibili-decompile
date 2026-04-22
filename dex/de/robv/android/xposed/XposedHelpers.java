package de.robv.android.xposed;

import android.content.res.Resources;
import com.xiaomi.mipush.sdk.Constants;
import dalvik.system.DexFile;
import de.robv.android.xposed.XC_MethodHook;
import external.org.apache.commons.lang3.ClassUtils;
import external.org.apache.commons.lang3.reflect.MemberUtils;
import io.grpc.internal.GrpcUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipFile;

public final class XposedHelpers {
    private static final HashMap<String, Field> fieldCache = new HashMap<>();
    private static final HashMap<String, Method> methodCache = new HashMap<>();
    private static final HashMap<String, Constructor<?>> constructorCache = new HashMap<>();
    private static final WeakHashMap<Object, HashMap<String, Object>> additionalFields = new WeakHashMap<>();
    private static final HashMap<String, ThreadLocal<AtomicInteger>> sMethodDepth = new HashMap<>();

    private XposedHelpers() {
    }

    public static Class<?> findClass(String className, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = XposedBridge.BOOTCLASSLOADER;
        }
        try {
            return ClassUtils.getClass(classLoader, className, false);
        } catch (ClassNotFoundException e2) {
            throw new ClassNotFoundError(e2);
        }
    }

    public static Class<?> findClassIfExists(String className, ClassLoader classLoader) {
        try {
            return findClass(className, classLoader);
        } catch (ClassNotFoundError e2) {
            return null;
        }
    }

    public static Field findField(Class<?> clazz, String fieldName) {
        String fullFieldName = clazz.getName() + '#' + fieldName;
        if (fieldCache.containsKey(fullFieldName)) {
            Field field = fieldCache.get(fullFieldName);
            if (field == null) {
                throw new NoSuchFieldError(fullFieldName);
            }
            return field;
        }
        try {
            Field field2 = findFieldRecursiveImpl(clazz, fieldName);
            field2.setAccessible(true);
            fieldCache.put(fullFieldName, field2);
            return field2;
        } catch (NoSuchFieldException e2) {
            fieldCache.put(fullFieldName, null);
            throw new NoSuchFieldError(fullFieldName);
        }
    }

    public static Field findFieldIfExists(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName);
        } catch (NoSuchFieldError e2) {
            return null;
        }
    }

    private static Field findFieldRecursiveImpl(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e2) {
            while (true) {
                clazz = clazz.getSuperclass();
                if (clazz == null || clazz.equals(Object.class)) {
                    break;
                }
                try {
                    return clazz.getDeclaredField(fieldName);
                } catch (NoSuchFieldException e3) {
                }
            }
            throw e2;
        }
    }

    public static Field findFirstFieldByExactType(Class<?> clazz, Class<?> type) {
        Field[] declaredFields;
        Class<? super Object> superclass;
        Class<?> clz = clazz;
        do {
            for (Field field : clz.getDeclaredFields()) {
                if (field.getType() == type) {
                    field.setAccessible(true);
                    return field;
                }
            }
            superclass = clz.getSuperclass();
            clz = superclass;
        } while (superclass != null);
        throw new NoSuchFieldError("Field of type " + type.getName() + " in class " + clazz.getName());
    }

    public static XC_MethodHook.Unhook findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
        if (parameterTypesAndCallback.length == 0 || !(parameterTypesAndCallback[parameterTypesAndCallback.length - 1] instanceof XC_MethodHook)) {
            throw new IllegalArgumentException("no callback defined");
        }
        XC_MethodHook callback = (XC_MethodHook) parameterTypesAndCallback[parameterTypesAndCallback.length - 1];
        Method m = findMethodExact(clazz, methodName, getParameterClasses(clazz.getClassLoader(), parameterTypesAndCallback));
        return XposedBridge.hookMethod(m, callback);
    }

    public static XC_MethodHook.Unhook findAndHookMethod(String className, ClassLoader classLoader, String methodName, Object... parameterTypesAndCallback) {
        return findAndHookMethod(findClass(className, classLoader), methodName, parameterTypesAndCallback);
    }

    public static Method findMethodExact(Class<?> clazz, String methodName, Object... parameterTypes) {
        return findMethodExact(clazz, methodName, getParameterClasses(clazz.getClassLoader(), parameterTypes));
    }

    public static Method findMethodExactIfExists(Class<?> clazz, String methodName, Object... parameterTypes) {
        try {
            return findMethodExact(clazz, methodName, parameterTypes);
        } catch (ClassNotFoundError | NoSuchMethodError e2) {
            return null;
        }
    }

    public static Method findMethodExact(String className, ClassLoader classLoader, String methodName, Object... parameterTypes) {
        return findMethodExact(findClass(className, classLoader), methodName, getParameterClasses(classLoader, parameterTypes));
    }

    public static Method findMethodExactIfExists(String className, ClassLoader classLoader, String methodName, Object... parameterTypes) {
        try {
            return findMethodExact(className, classLoader, methodName, parameterTypes);
        } catch (ClassNotFoundError | NoSuchMethodError e2) {
            return null;
        }
    }

    public static Method findMethodExact(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        String fullMethodName = clazz.getName() + '#' + methodName + getParametersString(parameterTypes) + "#exact";
        if (methodCache.containsKey(fullMethodName)) {
            Method method = methodCache.get(fullMethodName);
            if (method == null) {
                throw new NoSuchMethodError(fullMethodName);
            }
            return method;
        }
        try {
            Method method2 = clazz.getDeclaredMethod(methodName, parameterTypes);
            method2.setAccessible(true);
            methodCache.put(fullMethodName, method2);
            return method2;
        } catch (NoSuchMethodException e2) {
            methodCache.put(fullMethodName, null);
            throw new NoSuchMethodError(fullMethodName);
        }
    }

    public static Method[] findMethodsByExactParameters(Class<?> clazz, Class<?> returnType, Class<?>... parameterTypes) {
        Method[] declaredMethods;
        List<Method> result = new LinkedList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (returnType == null || returnType == method.getReturnType()) {
                Class<?>[] methodParameterTypes = method.getParameterTypes();
                if (parameterTypes.length == methodParameterTypes.length) {
                    boolean match = true;
                    int i2 = 0;
                    while (true) {
                        if (i2 < parameterTypes.length) {
                            if (parameterTypes[i2] == methodParameterTypes[i2]) {
                                i2++;
                            } else {
                                match = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (match) {
                        method.setAccessible(true);
                        result.add(method);
                    }
                }
            }
        }
        return (Method[]) result.toArray(new Method[result.size()]);
    }

    public static Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        Method[] declaredMethods;
        Class<? super Object> superclass;
        String fullMethodName = clazz.getName() + '#' + methodName + getParametersString(parameterTypes) + "#bestmatch";
        if (methodCache.containsKey(fullMethodName)) {
            Method method = methodCache.get(fullMethodName);
            if (method == null) {
                throw new NoSuchMethodError(fullMethodName);
            }
            return method;
        }
        try {
            Method method2 = findMethodExact(clazz, methodName, parameterTypes);
            methodCache.put(fullMethodName, method2);
            return method2;
        } catch (NoSuchMethodError e2) {
            Method bestMatch = null;
            Class<?> clz = clazz;
            boolean considerPrivateMethods = true;
            do {
                for (Method method3 : clz.getDeclaredMethods()) {
                    if ((considerPrivateMethods || !Modifier.isPrivate(method3.getModifiers())) && method3.getName().equals(methodName) && ClassUtils.isAssignable(parameterTypes, method3.getParameterTypes(), true) && (bestMatch == null || MemberUtils.compareParameterTypes(method3.getParameterTypes(), bestMatch.getParameterTypes(), parameterTypes) < 0)) {
                        bestMatch = method3;
                    }
                }
                considerPrivateMethods = false;
                superclass = clz.getSuperclass();
                clz = superclass;
            } while (superclass != null);
            if (bestMatch != null) {
                bestMatch.setAccessible(true);
                methodCache.put(fullMethodName, bestMatch);
                return bestMatch;
            }
            NoSuchMethodError e3 = new NoSuchMethodError(fullMethodName);
            methodCache.put(fullMethodName, null);
            throw e3;
        }
    }

    public static Method findMethodBestMatch(Class<?> clazz, String methodName, Object... args) {
        return findMethodBestMatch(clazz, methodName, getParameterTypes(args));
    }

    public static Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] args) {
        Class<?>[] argsClasses = null;
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (parameterTypes[i2] == null) {
                if (argsClasses == null) {
                    argsClasses = getParameterTypes(args);
                }
                parameterTypes[i2] = argsClasses[i2];
            }
        }
        return findMethodBestMatch(clazz, methodName, parameterTypes);
    }

    public static Class<?>[] getParameterTypes(Object... args) {
        Class<?>[] clazzes = new Class[args.length];
        for (int i2 = 0; i2 < args.length; i2++) {
            clazzes[i2] = args[i2] != null ? args[i2].getClass() : null;
        }
        return clazzes;
    }

    private static Class<?>[] getParameterClasses(ClassLoader classLoader, Object[] parameterTypesAndCallback) {
        Class<?>[] parameterClasses = null;
        for (int i2 = parameterTypesAndCallback.length - 1; i2 >= 0; i2--) {
            Object type = parameterTypesAndCallback[i2];
            if (type == null) {
                throw new ClassNotFoundError("parameter type must not be null", null);
            }
            if (!(type instanceof XC_MethodHook)) {
                if (parameterClasses == null) {
                    parameterClasses = new Class[i2 + 1];
                }
                if (type instanceof Class) {
                    parameterClasses[i2] = (Class) type;
                } else if (type instanceof String) {
                    parameterClasses[i2] = findClass((String) type, classLoader);
                } else {
                    throw new ClassNotFoundError("parameter type must either be specified as Class or String", null);
                }
            }
        }
        if (parameterClasses == null) {
            Class<?>[] parameterClasses2 = new Class[0];
            return parameterClasses2;
        }
        return parameterClasses;
    }

    public static Class<?>[] getClassesAsArray(Class<?>... clazzes) {
        return clazzes;
    }

    private static String getParametersString(Class<?>... clazzes) {
        StringBuilder sb = new StringBuilder("(");
        boolean first = true;
        for (Class<?> clazz : clazzes) {
            if (first) {
                first = false;
            } else {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            if (clazz != null) {
                sb.append(clazz.getCanonicalName());
            } else {
                sb.append("null");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static Constructor<?> findConstructorExact(Class<?> clazz, Object... parameterTypes) {
        return findConstructorExact(clazz, getParameterClasses(clazz.getClassLoader(), parameterTypes));
    }

    public static Constructor<?> findConstructorExactIfExists(Class<?> clazz, Object... parameterTypes) {
        try {
            return findConstructorExact(clazz, parameterTypes);
        } catch (ClassNotFoundError | NoSuchMethodError e2) {
            return null;
        }
    }

    public static Constructor<?> findConstructorExact(String className, ClassLoader classLoader, Object... parameterTypes) {
        return findConstructorExact(findClass(className, classLoader), getParameterClasses(classLoader, parameterTypes));
    }

    public static Constructor<?> findConstructorExactIfExists(String className, ClassLoader classLoader, Object... parameterTypes) {
        try {
            return findConstructorExact(className, classLoader, parameterTypes);
        } catch (ClassNotFoundError | NoSuchMethodError e2) {
            return null;
        }
    }

    public static Constructor<?> findConstructorExact(Class<?> clazz, Class<?>... parameterTypes) {
        String fullConstructorName = clazz.getName() + getParametersString(parameterTypes) + "#exact";
        if (constructorCache.containsKey(fullConstructorName)) {
            Constructor<?> constructor = constructorCache.get(fullConstructorName);
            if (constructor == null) {
                throw new NoSuchMethodError(fullConstructorName);
            }
            return constructor;
        }
        try {
            Constructor<?> constructor2 = clazz.getDeclaredConstructor(parameterTypes);
            constructor2.setAccessible(true);
            constructorCache.put(fullConstructorName, constructor2);
            return constructor2;
        } catch (NoSuchMethodException e2) {
            constructorCache.put(fullConstructorName, null);
            throw new NoSuchMethodError(fullConstructorName);
        }
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(Class<?> clazz, Object... parameterTypesAndCallback) {
        if (parameterTypesAndCallback.length == 0 || !(parameterTypesAndCallback[parameterTypesAndCallback.length - 1] instanceof XC_MethodHook)) {
            throw new IllegalArgumentException("no callback defined");
        }
        XC_MethodHook callback = (XC_MethodHook) parameterTypesAndCallback[parameterTypesAndCallback.length - 1];
        Constructor<?> m = findConstructorExact(clazz, getParameterClasses(clazz.getClassLoader(), parameterTypesAndCallback));
        return XposedBridge.hookMethod(m, callback);
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(String className, ClassLoader classLoader, Object... parameterTypesAndCallback) {
        return findAndHookConstructor(findClass(className, classLoader), parameterTypesAndCallback);
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> clazz, Class<?>... parameterTypes) {
        String fullConstructorName = clazz.getName() + getParametersString(parameterTypes) + "#bestmatch";
        if (constructorCache.containsKey(fullConstructorName)) {
            Constructor<?> constructor = constructorCache.get(fullConstructorName);
            if (constructor == null) {
                throw new NoSuchMethodError(fullConstructorName);
            }
            return constructor;
        }
        try {
            Constructor<?> constructor2 = findConstructorExact(clazz, parameterTypes);
            constructorCache.put(fullConstructorName, constructor2);
            return constructor2;
        } catch (NoSuchMethodError e2) {
            Constructor<?> bestMatch = null;
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor3 : constructors) {
                if (ClassUtils.isAssignable(parameterTypes, constructor3.getParameterTypes(), true) && (bestMatch == null || MemberUtils.compareParameterTypes(constructor3.getParameterTypes(), bestMatch.getParameterTypes(), parameterTypes) < 0)) {
                    bestMatch = constructor3;
                }
            }
            if (bestMatch != null) {
                bestMatch.setAccessible(true);
                constructorCache.put(fullConstructorName, bestMatch);
                return bestMatch;
            }
            NoSuchMethodError e3 = new NoSuchMethodError(fullConstructorName);
            constructorCache.put(fullConstructorName, null);
            throw e3;
        }
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> clazz, Object... args) {
        return findConstructorBestMatch(clazz, getParameterTypes(args));
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> clazz, Class<?>[] parameterTypes, Object[] args) {
        Class<?>[] argsClasses = null;
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (parameterTypes[i2] == null) {
                if (argsClasses == null) {
                    argsClasses = getParameterTypes(args);
                }
                parameterTypes[i2] = argsClasses[i2];
            }
        }
        return findConstructorBestMatch(clazz, parameterTypes);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClassNotFoundError extends Error {
        private static final long serialVersionUID = -1070936889459514628L;

        public ClassNotFoundError(Throwable cause) {
            super(cause);
        }

        public ClassNotFoundError(String detailMessage, Throwable cause) {
            super(detailMessage, cause);
        }
    }

    public static int getFirstParameterIndexByType(Member method, Class<?> type) {
        Class<?>[] classes = method instanceof Method ? ((Method) method).getParameterTypes() : ((Constructor) method).getParameterTypes();
        for (int i2 = 0; i2 < classes.length; i2++) {
            if (classes[i2] == type) {
                return i2;
            }
        }
        throw new NoSuchFieldError("No parameter of type " + type + " found in " + method);
    }

    public static int getParameterIndexByType(Member method, Class<?> type) {
        Class<?>[] classes = method instanceof Method ? ((Method) method).getParameterTypes() : ((Constructor) method).getParameterTypes();
        int idx = -1;
        for (int i2 = 0; i2 < classes.length; i2++) {
            if (classes[i2] == type) {
                if (idx == -1) {
                    idx = i2;
                } else {
                    throw new NoSuchFieldError("More than one parameter of type " + type + " found in " + method);
                }
            }
        }
        if (idx != -1) {
            return idx;
        }
        throw new NoSuchFieldError("No parameter of type " + type + " found in " + method);
    }

    public static void setObjectField(Object obj, String fieldName, Object value) {
        try {
            findField(obj.getClass(), fieldName).set(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setBooleanField(Object obj, String fieldName, boolean value) {
        try {
            findField(obj.getClass(), fieldName).setBoolean(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setByteField(Object obj, String fieldName, byte value) {
        try {
            findField(obj.getClass(), fieldName).setByte(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setCharField(Object obj, String fieldName, char value) {
        try {
            findField(obj.getClass(), fieldName).setChar(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setDoubleField(Object obj, String fieldName, double value) {
        try {
            findField(obj.getClass(), fieldName).setDouble(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setFloatField(Object obj, String fieldName, float value) {
        try {
            findField(obj.getClass(), fieldName).setFloat(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setIntField(Object obj, String fieldName, int value) {
        try {
            findField(obj.getClass(), fieldName).setInt(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setLongField(Object obj, String fieldName, long value) {
        try {
            findField(obj.getClass(), fieldName).setLong(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setShortField(Object obj, String fieldName, short value) {
        try {
            findField(obj.getClass(), fieldName).setShort(obj, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static Object getObjectField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).get(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static Object getSurroundingThis(Object obj) {
        return getObjectField(obj, "this$0");
    }

    public static boolean getBooleanField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getBoolean(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static byte getByteField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getByte(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static char getCharField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getChar(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static double getDoubleField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getDouble(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static float getFloatField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getFloat(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static int getIntField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getInt(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static long getLongField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getLong(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static short getShortField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getShort(obj);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticObjectField(Class<?> clazz, String fieldName, Object value) {
        try {
            findField(clazz, fieldName).set(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticBooleanField(Class<?> clazz, String fieldName, boolean value) {
        try {
            findField(clazz, fieldName).setBoolean(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticByteField(Class<?> clazz, String fieldName, byte value) {
        try {
            findField(clazz, fieldName).setByte(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticCharField(Class<?> clazz, String fieldName, char value) {
        try {
            findField(clazz, fieldName).setChar(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticDoubleField(Class<?> clazz, String fieldName, double value) {
        try {
            findField(clazz, fieldName).setDouble(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticFloatField(Class<?> clazz, String fieldName, float value) {
        try {
            findField(clazz, fieldName).setFloat(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticIntField(Class<?> clazz, String fieldName, int value) {
        try {
            findField(clazz, fieldName).setInt(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticLongField(Class<?> clazz, String fieldName, long value) {
        try {
            findField(clazz, fieldName).setLong(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static void setStaticShortField(Class<?> clazz, String fieldName, short value) {
        try {
            findField(clazz, fieldName).setShort(null, value);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static Object getStaticObjectField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).get(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static boolean getStaticBooleanField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).getBoolean(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static byte getStaticByteField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).getByte(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static char getStaticCharField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).getChar(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static double getStaticDoubleField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).getDouble(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static float getStaticFloatField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).getFloat(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static int getStaticIntField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).getInt(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static long getStaticLongField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).getLong(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static short getStaticShortField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).getShort(null);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public static Object callMethod(Object obj, String methodName, Object... args) {
        try {
            return findMethodBestMatch(obj.getClass(), methodName, args).invoke(obj, args);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InvocationTargetException e4) {
            throw new InvocationTargetError(e4.getCause());
        }
    }

    public static Object callMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object... args) {
        try {
            return findMethodBestMatch(obj.getClass(), methodName, parameterTypes, args).invoke(obj, args);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InvocationTargetException e4) {
            throw new InvocationTargetError(e4.getCause());
        }
    }

    public static Object callStaticMethod(Class<?> clazz, String methodName, Object... args) {
        try {
            return findMethodBestMatch(clazz, methodName, args).invoke(null, args);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InvocationTargetException e4) {
            throw new InvocationTargetError(e4.getCause());
        }
    }

    public static Object callStaticMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object... args) {
        try {
            return findMethodBestMatch(clazz, methodName, parameterTypes, args).invoke(null, args);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InvocationTargetException e4) {
            throw new InvocationTargetError(e4.getCause());
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class InvocationTargetError extends Error {
        private static final long serialVersionUID = -1070936889459514628L;

        public InvocationTargetError(Throwable cause) {
            super(cause);
        }
    }

    public static Object newInstance(Class<?> clazz, Object... args) {
        try {
            return findConstructorBestMatch(clazz, args).newInstance(args);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InstantiationException e4) {
            throw new InstantiationError(e4.getMessage());
        } catch (InvocationTargetException e5) {
            throw new InvocationTargetError(e5.getCause());
        }
    }

    public static Object newInstance(Class<?> clazz, Class<?>[] parameterTypes, Object... args) {
        try {
            return findConstructorBestMatch(clazz, parameterTypes, args).newInstance(args);
        } catch (IllegalAccessException e2) {
            XposedBridge.log(e2);
            throw new IllegalAccessError(e2.getMessage());
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InstantiationException e4) {
            throw new InstantiationError(e4.getMessage());
        } catch (InvocationTargetException e5) {
            throw new InvocationTargetError(e5.getCause());
        }
    }

    public static Object setAdditionalInstanceField(Object obj, String key, Object value) {
        Object put;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (key == null) {
            throw new NullPointerException("key must not be null");
        }
        synchronized (additionalFields) {
            try {
                try {
                    HashMap<String, Object> objectFields = additionalFields.get(obj);
                    if (objectFields == null) {
                        objectFields = new HashMap<>();
                        additionalFields.put(obj, objectFields);
                    }
                    synchronized (objectFields) {
                        put = objectFields.put(key, value);
                    }
                    return put;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static Object getAdditionalInstanceField(Object obj, String key) {
        Object obj2;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (key == null) {
            throw new NullPointerException("key must not be null");
        }
        synchronized (additionalFields) {
            try {
                try {
                    HashMap<String, Object> objectFields = additionalFields.get(obj);
                    if (objectFields == null) {
                        return null;
                    }
                    synchronized (objectFields) {
                        obj2 = objectFields.get(key);
                    }
                    return obj2;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static Object removeAdditionalInstanceField(Object obj, String key) {
        Object remove;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (key == null) {
            throw new NullPointerException("key must not be null");
        }
        synchronized (additionalFields) {
            try {
                try {
                    HashMap<String, Object> objectFields = additionalFields.get(obj);
                    if (objectFields == null) {
                        return null;
                    }
                    synchronized (objectFields) {
                        remove = objectFields.remove(key);
                    }
                    return remove;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static Object setAdditionalStaticField(Object obj, String key, Object value) {
        return setAdditionalInstanceField(obj.getClass(), key, value);
    }

    public static Object getAdditionalStaticField(Object obj, String key) {
        return getAdditionalInstanceField(obj.getClass(), key);
    }

    public static Object removeAdditionalStaticField(Object obj, String key) {
        return removeAdditionalInstanceField(obj.getClass(), key);
    }

    public static Object setAdditionalStaticField(Class<?> clazz, String key, Object value) {
        return setAdditionalInstanceField(clazz, key, value);
    }

    public static Object getAdditionalStaticField(Class<?> clazz, String key) {
        return getAdditionalInstanceField(clazz, key);
    }

    public static Object removeAdditionalStaticField(Class<?> clazz, String key) {
        return removeAdditionalInstanceField(clazz, key);
    }

    public static byte[] assetAsByteArray(Resources res, String path) throws IOException {
        return inputStreamToByteArray(res.getAssets().open(path));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] inputStreamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        byte[] temp = new byte[1024];
        while (true) {
            int read = is.read(temp);
            if (read > 0) {
                buf.write(temp, 0, read);
            } else {
                is.close();
                return buf.toByteArray();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeSilently(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeSilently(DexFile dexFile) {
        if (dexFile != null) {
            try {
                dexFile.close();
            } catch (IOException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeSilently(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e2) {
            }
        }
    }

    public static String getMD5Sum(String file) throws IOException {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            InputStream is = new FileInputStream(file);
            byte[] buffer = new byte[GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE];
            while (true) {
                int read = is.read(buffer);
                if (read > 0) {
                    digest.update(buffer, 0, read);
                } else {
                    is.close();
                    byte[] md5sum = digest.digest();
                    BigInteger bigInt = new BigInteger(1, md5sum);
                    return bigInt.toString(16);
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            return "";
        }
    }

    public static int incrementMethodDepth(String method) {
        return getMethodDepthCounter(method).get().incrementAndGet();
    }

    public static int decrementMethodDepth(String method) {
        return getMethodDepthCounter(method).get().decrementAndGet();
    }

    public static int getMethodDepth(String method) {
        return getMethodDepthCounter(method).get().get();
    }

    private static ThreadLocal<AtomicInteger> getMethodDepthCounter(String method) {
        ThreadLocal<AtomicInteger> counter;
        synchronized (sMethodDepth) {
            counter = sMethodDepth.get(method);
            if (counter == null) {
                counter = new ThreadLocal<AtomicInteger>() { // from class: de.robv.android.xposed.XposedHelpers.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // java.lang.ThreadLocal
                    public AtomicInteger initialValue() {
                        return new AtomicInteger();
                    }
                };
                sMethodDepth.put(method, counter);
            }
        }
        return counter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean fileContains(File file, String str) throws IOException {
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            do {
                line = in.readLine();
                if (line == null) {
                    closeSilently(in);
                    return false;
                }
            } while (!line.contains(str));
            closeSilently(in);
            return true;
        } catch (Throwable th) {
            closeSilently(in);
            throw th;
        }
    }

    static Method getOverriddenMethod(Method method) {
        int modifiers = method.getModifiers();
        if (Modifier.isStatic(modifiers) || Modifier.isPrivate(modifiers)) {
            return null;
        }
        String name = method.getName();
        Class<?>[] parameters = method.getParameterTypes();
        for (Class<?> clazz = method.getDeclaringClass().getSuperclass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Method superMethod = clazz.getDeclaredMethod(name, parameters);
                int modifiers2 = superMethod.getModifiers();
                if (!Modifier.isPrivate(modifiers2)) {
                    if (!Modifier.isAbstract(modifiers2)) {
                        return superMethod;
                    }
                }
                return null;
            } catch (NoSuchMethodException e2) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<Method> getOverriddenMethods(Class<?> clazz) {
        Method[] declaredMethods;
        Set<Method> methods = new HashSet<>();
        for (Method method : clazz.getDeclaredMethods()) {
            Method overridden = getOverriddenMethod(method);
            if (overridden != null) {
                methods.add(overridden);
            }
        }
        return methods;
    }
}