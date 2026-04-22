package facadeverify;

import java.lang.reflect.Type;

public class r0 implements w0, x0 {
    @Override // facadeverify.w0
    public Object a(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    @Override // facadeverify.x0
    public Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // facadeverify.w0, facadeverify.x0
    public boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}