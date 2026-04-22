package c.t.m.g;

import java.lang.reflect.Method;

/* compiled from: TML */
public class f4 {
    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        return a(obj.getClass(), obj, str, clsArr, objArr);
    }

    public static Object a(Class<?> cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = d4.c(clsArr) ? cls.getDeclaredMethod(str, new Class[0]) : cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(obj, objArr);
                declaredMethod.setAccessible(isAccessible);
                return invoke;
            } else if (!w3.a()) {
                return null;
            } else {
                w3.b("ReflectUtil", "method " + str + "() is null.");
                return null;
            }
        } catch (Throwable th) {
            if (!w3.a()) {
                return null;
            }
            w3.a("ReflectUtil", "invoke " + str + " error.", th);
            return null;
        }
    }
}