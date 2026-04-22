package facadeverify;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class p0 implements w0, x0 {
    @Override // facadeverify.x0
    public Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            arrayList.add(t0.b(obj2));
        }
        return arrayList;
    }

    @Override // facadeverify.w0
    public Object a(Object obj, Type type) {
        Collection collection;
        Type type2;
        if (obj.getClass().equals(k0.class)) {
            Class<?> a = d.a(type);
            k0 k0Var = (k0) obj;
            if (a == AbstractCollection.class) {
                collection = new ArrayList();
            } else if (a.isAssignableFrom(HashSet.class)) {
                collection = new HashSet();
            } else if (a.isAssignableFrom(LinkedHashSet.class)) {
                collection = new LinkedHashSet();
            } else if (a.isAssignableFrom(TreeSet.class)) {
                collection = new TreeSet();
            } else if (a.isAssignableFrom(ArrayList.class)) {
                collection = new ArrayList();
            } else if (a.isAssignableFrom(EnumSet.class)) {
                if (type instanceof ParameterizedType) {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                } else {
                    type2 = Object.class;
                }
                collection = EnumSet.noneOf(type2);
            } else {
                try {
                    collection = (Collection) a.newInstance();
                } catch (Exception e2) {
                    throw new IllegalArgumentException(a.a("create instane error, class ").append(a.getName()).toString());
                }
            }
            if (type instanceof ParameterizedType) {
                Type type3 = ((ParameterizedType) type).getActualTypeArguments()[0];
                for (int i2 = 0; i2 < k0Var.a(); i2++) {
                    collection.add(s0.a(k0Var.a(i2), type3));
                }
                return collection;
            }
            throw new IllegalArgumentException("Does not support the implement for generics.");
        }
        return null;
    }

    @Override // facadeverify.w0, facadeverify.x0
    public boolean a(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }
}