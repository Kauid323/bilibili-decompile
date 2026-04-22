package facadeverify;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class s0 {
    public static List<w0> a = new ArrayList();

    static {
        a.add(new z0());
        a.add(new r0());
        a.add(new q0());
        a.add(new v0());
        a.add(new y0());
        a.add(new p0());
        a.add(new o0());
        a.add(new u0());
    }

    public static final Object a(String str, Type type) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            return a(new k0(new n0(trim)), type);
        }
        if (trim.startsWith("{") && trim.endsWith("}")) {
            return a(new m0(new n0(trim)), type);
        }
        return a((Object) trim, type);
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (w0 w0Var : a) {
            if (w0Var.a(d.a(type)) && (t = (T) w0Var.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }
}