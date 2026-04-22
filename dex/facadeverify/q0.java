package facadeverify;

import java.lang.reflect.Type;
import java.util.Date;

public class q0 implements w0, x0 {
    @Override // facadeverify.w0
    public Object a(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    @Override // facadeverify.x0
    public Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // facadeverify.w0, facadeverify.x0
    public boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}