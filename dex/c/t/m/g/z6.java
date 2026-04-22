package c.t.m.g;

import java.util.Iterator;

/* compiled from: TML */
public class z6 {
    public final String a;

    public z6(String str) {
        this.a = a(str);
    }

    public static z6 b(String str) {
        return new z6(str);
    }

    public final String a(String str) {
        if (str != null) {
            return str;
        }
        throw null;
    }

    public final String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    public final String a(Iterator<?> it) {
        return a(new StringBuilder(), it).toString();
    }

    public final StringBuilder a(StringBuilder sb, Iterator<?> it) {
        Object next;
        if (it.hasNext() && (next = it.next()) != null) {
            sb.append(next.toString());
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(this.a);
                sb.append(next2.toString());
            }
        }
        return sb;
    }
}