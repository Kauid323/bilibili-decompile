package facadeverify;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;

public class u0 implements w0, x0 {
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051 A[SYNTHETIC] */
    @Override // facadeverify.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(Object obj) {
        Object obj2;
        TreeMap treeMap = new TreeMap();
        Class<?> cls = obj.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        while (!cls.equals(Object.class)) {
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field != null && !"this$0".equals(field.getName())) {
                        boolean isAccessible = field.isAccessible();
                        field.setAccessible(true);
                        Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            field.setAccessible(isAccessible);
                            obj2 = t0.b(obj3);
                            if (obj2 == null) {
                                treeMap.put(field.getName(), obj2);
                            }
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                    }
                }
            }
            cls = cls.getSuperclass();
            declaredFields = cls.getDeclaredFields();
        }
        return treeMap;
    }

    @Override // facadeverify.w0, facadeverify.x0
    public boolean a(Class<?> cls) {
        return true;
    }

    @Override // facadeverify.w0
    public Object a(Object obj, Type type) {
        if (obj.getClass().equals(m0.class)) {
            m0 m0Var = (m0) obj;
            Class cls = (Class) type;
            Object newInstance = cls.newInstance();
            while (!cls.equals(Object.class)) {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        String name = field.getName();
                        Type genericType = field.getGenericType();
                        if (m0Var.a.containsKey(name)) {
                            field.setAccessible(true);
                            field.set(newInstance, s0.a(m0Var.a(name), genericType));
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
            return newInstance;
        }
        return null;
    }
}