package c.t.m.g;

import j$.util.Objects;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: TML */
public class s3 {
    public static boolean a(List<?> list, List<?> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Objects.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int a(List<?> list) {
        HashSet hashSet = new HashSet();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        return hashSet.size();
    }
}