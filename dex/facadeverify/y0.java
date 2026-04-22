package facadeverify;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class y0 implements w0 {
    @Override // facadeverify.w0
    public Object a(Object obj, Type type) {
        Type type2;
        if (obj.getClass().equals(k0.class)) {
            k0 k0Var = (k0) obj;
            HashSet hashSet = new HashSet();
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = Object.class;
            }
            for (int i2 = 0; i2 < k0Var.a(); i2++) {
                hashSet.add(s0.a(k0Var.a(i2), type2));
            }
            return hashSet;
        }
        return null;
    }

    @Override // facadeverify.w0, facadeverify.x0
    public boolean a(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}