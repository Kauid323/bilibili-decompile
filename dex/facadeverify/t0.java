package facadeverify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class t0 {
    public static List<x0> a = new ArrayList();

    static {
        a.add(new z0());
        a.add(new r0());
        a.add(new q0());
        a.add(new v0());
        a.add(new p0());
        a.add(new o0());
        a.add(new u0());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = b(obj);
        if (d.a(b.getClass())) {
            return m0.b(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new k0((List) b).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new m0((Map) b).toString();
        }
        throw new IllegalArgumentException(a.a("Unsupported Class : ").append(b.getClass()).toString());
    }

    public static Object b(Object obj) {
        Object a2;
        if (obj == null) {
            return null;
        }
        for (x0 x0Var : a) {
            if (x0Var.a(obj.getClass()) && (a2 = x0Var.a(obj)) != null) {
                return a2;
            }
        }
        throw new IllegalArgumentException(a.a("Unsupported Class : ").append(obj.getClass()).toString());
    }
}