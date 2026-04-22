package tv.danmaku.ijk.media.player.render.tools;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.utils.StringsKt;

public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static int getResourceFieldValue(Class<?> clazz, String name) {
        Field field = getField(clazz, name);
        if (field == null) {
            return 0;
        }
        try {
            Object property = field.get(clazz);
            int id = ((Integer) property).intValue();
            return id;
        } catch (Exception e) {
            BLog.e(TAG, e.getMessage());
            return 0;
        }
    }

    public static Field getField(Class<?> clazz, String name) {
        Field[] fields;
        if (clazz == null || name == null || (fields = clazz.getFields()) == null) {
            return null;
        }
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(name)) {
                return field;
            }
        }
        return null;
    }

    public static Class<?> subClass(Class<?> clazz, String className) {
        Class<?>[] classies = clazz.getDeclaredClasses();
        if (className == null || classies == null || classies.length == 0) {
            return null;
        }
        for (Class<?> child : classies) {
            if (child.getSimpleName().equalsIgnoreCase(className)) {
                return child;
            }
        }
        return null;
    }

    public static Class<?> reflectClass(String className) {
        if (className == null) {
            return null;
        }
        try {
            Class<?> clazz = Class.forName(className);
            return clazz;
        } catch (ClassNotFoundException e) {
            BLog.e(TAG, e.getLocalizedMessage());
            return null;
        }
    }

    public static <T> T classInstance(String className) {
        Class<?> clazz = reflectClass(className);
        return (T) classInstance(clazz);
    }

    public static <T> T classInstance(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        try {
            T instance = (T) clazz.newInstance();
            return instance;
        } catch (IllegalAccessException e) {
            BLog.e(TAG, e.getMessage());
            return null;
        } catch (InstantiationException e2) {
            BLog.e(TAG, e2.getMessage());
            return null;
        }
    }

    public static <T> T[] arrayInstance(Class<?> clazz, int size) {
        if (clazz == null || size < 0) {
            return null;
        }
        try {
            T[] arrayIns = (T[]) ((Object[]) Array.newInstance(clazz, size));
            return arrayIns;
        } catch (Exception e) {
            BLog.e(TAG, e.getMessage());
            return null;
        }
    }

    public static StringBuilder trace(Object o) {
        if (o == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(o.getClass().getName()).append(":{\n");
        Field[] fields = o.getClass().getFields();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                sb.append(field.getName()).append(" : ");
                Object value = getFieldValue(field, o);
                if (value == null) {
                    sb.append(StringsKt.NULL_STRING);
                } else {
                    sb.append(value.toString());
                }
                sb.append(", \n");
            }
        }
        sb.append("};");
        return sb;
    }

    public static Object getFieldValue(Field field, Object o) {
        try {
            Object value = field.get(o);
            return value;
        } catch (IllegalAccessException e) {
            BLog.e(TAG, e.getMessage());
            return null;
        } catch (IllegalArgumentException e2) {
            BLog.e(TAG, e2.getMessage());
            return null;
        }
    }

    public static Field reflectField(Class<?> clazz, String name) {
        if (clazz == null || name == null) {
            return null;
        }
        try {
            Field field = clazz.getField(name);
            return field;
        } catch (NoSuchFieldException e) {
            BLog.e(TAG, e.getMessage());
            return null;
        }
    }

    public static void setFieldValue(Field field, Object target, Object value) {
        if (field == null || target == null || value == null) {
            return;
        }
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            BLog.e(TAG, e.getMessage());
        } catch (IllegalArgumentException e2) {
            BLog.e(TAG, e2.getMessage());
        }
    }

    public static Method getMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        if (clazz == null || name == null) {
            return null;
        }
        try {
            Method method = clazz.getMethod(name, parameterTypes);
            return method;
        } catch (NoSuchMethodException e) {
            BLog.e(TAG, e.getMessage());
            return null;
        }
    }

    public static Object reflectMethod(Method method, Object target, Object... args) {
        if (method == null || target == null) {
            return null;
        }
        try {
            return method.invoke(target, args);
        } catch (IllegalAccessException e) {
            BLog.e(TAG, e.getMessage());
            return null;
        } catch (IllegalArgumentException e2) {
            BLog.e(TAG, e2.getMessage());
            return null;
        } catch (InvocationTargetException e3) {
            BLog.e(TAG, e3.getMessage());
            return null;
        }
    }

    public static Class<?> genericCollectionType(Type genericType) {
        List<Class<?>> list = genericCollectionTypes(genericType);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static List<Class<?>> genericCollectionTypes(Type genericType) {
        Type[] args;
        if (genericType == null || !(genericType instanceof ParameterizedType) || (args = ((ParameterizedType) genericType).getActualTypeArguments()) == null || args.length < 1) {
            return null;
        }
        ArrayList<Class<?>> list = new ArrayList<>(args.length);
        for (Type arg : args) {
            list.add((Class) arg);
        }
        return list;
    }

    public static String serialize(Object object) {
        if (object == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            String base64 = Base64.encodeToString(baos.toByteArray(), 0);
            return base64;
        } catch (IOException e) {
            BLog.e(TAG, e.getMessage());
            return null;
        }
    }

    public static <T> T deserialize(String base64) {
        if (base64 == null) {
            return null;
        }
        byte[] base64Bytes = Base64.decode(base64, 0);
        ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            T object = (T) ois.readObject();
            return object;
        } catch (StreamCorruptedException e) {
            BLog.e(TAG, e.getMessage());
            return null;
        } catch (IOException e2) {
            BLog.e(TAG, e2.getMessage());
            return null;
        } catch (ClassNotFoundException e3) {
            BLog.e(TAG, e3.getMessage());
            return null;
        }
    }

    public static void asserts(boolean expression, String failedMessage) {
        if (!expression) {
            throw new AssertionError(failedMessage);
        }
    }

    public static <T> T notNull(T argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " should not be null!");
        }
        return argument;
    }
}