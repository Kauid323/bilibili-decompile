package facadeverify;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class o0 implements w0, x0 {
    @Override // facadeverify.x0
    public Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Object[]) obj) {
            arrayList.add(t0.b(obj2));
        }
        return arrayList;
    }

    @Override // facadeverify.w0
    public Object a(Object obj, Type type) {
        if (obj.getClass().equals(k0.class)) {
            k0 k0Var = (k0) obj;
            if (!(type instanceof GenericArrayType)) {
                Class<?> componentType = ((Class) type).getComponentType();
                int a = k0Var.a();
                Object newInstance = Array.newInstance(componentType, a);
                for (int i2 = 0; i2 < a; i2++) {
                    Array.set(newInstance, i2, s0.a(k0Var.a(i2), componentType));
                }
                return newInstance;
            }
            throw new IllegalArgumentException("Does not support generic array!");
        }
        return null;
    }

    @Override // facadeverify.w0, facadeverify.x0
    public boolean a(Class<?> cls) {
        return cls.isArray();
    }
}