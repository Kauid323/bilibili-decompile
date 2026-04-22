package facadeverify;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

public class v0 implements w0, x0 {
    @Override // facadeverify.x0
    public Object a(Object obj) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            if (entry.getKey() instanceof String) {
                treeMap.put((String) entry.getKey(), t0.b(entry.getValue()));
            } else {
                throw new IllegalArgumentException("Map key must be String!");
            }
        }
        return treeMap;
    }

    @Override // facadeverify.w0
    public Object a(Object obj, Type type) {
        if (obj.getClass().equals(m0.class)) {
            m0 m0Var = (m0) obj;
            Map<Object, Object> a = a(type);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    for (String str : m0Var.a.keySet()) {
                        if (d.a((Class<?>) type3)) {
                            a.put(str, m0Var.a(str));
                        } else {
                            a.put(str, s0.a(m0Var.a(str), type3));
                        }
                    }
                    return a;
                }
                throw new IllegalArgumentException("Deserialize Map Key must be String.class");
            }
            throw new IllegalArgumentException("Deserialize Map must be Generics!");
        }
        return null;
    }

    public Map<Object, Object> a(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type != SortedMap.class && type != TreeMap.class) {
            if (type != ConcurrentMap.class && type != ConcurrentHashMap.class) {
                if (type != Map.class && type != HashMap.class) {
                    if (type == LinkedHashMap.class) {
                        return new LinkedHashMap();
                    }
                    if (type instanceof ParameterizedType) {
                        return a(((ParameterizedType) type).getRawType());
                    }
                    Class cls = (Class) type;
                    if (!cls.isInterface()) {
                        try {
                            return (Map) cls.newInstance();
                        } catch (Exception e2) {
                            throw new IllegalArgumentException("unsupport type " + type, e2);
                        }
                    }
                    throw new IllegalArgumentException("unsupport type " + type);
                }
                return new HashMap();
            }
            return new ConcurrentHashMap();
        }
        return new TreeMap();
    }

    @Override // facadeverify.w0, facadeverify.x0
    public boolean a(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }
}