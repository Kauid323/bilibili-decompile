package facadeverify;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;

public class k0 {
    public ArrayList a;

    public k0() {
        this.a = new ArrayList();
    }

    public int a() {
        return this.a.size();
    }

    public String toString() {
        try {
            StringBuilder append = new StringBuilder().append('[');
            int a = a();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < a; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                stringBuffer.append(m0.b(this.a.get(i2)));
            }
            return append.append(stringBuffer.toString()).append(']').toString();
        } catch (Exception e2) {
            return null;
        }
    }

    public Object a(int i2) {
        Object obj = (i2 < 0 || i2 >= a()) ? null : this.a.get(i2);
        if (obj != null) {
            return obj;
        }
        throw new l0("JSONArray[" + i2 + "] not found.");
    }

    public k0(n0 n0Var) {
        char c;
        char c2;
        this.a = new ArrayList();
        char c3 = n0Var.c();
        if (c3 == '[') {
            c = ']';
        } else if (c3 != '(') {
            throw n0Var.a("A JSONArray text must start with '['");
        } else {
            c = ')';
        }
        if (n0Var.c() == ']') {
            return;
        }
        n0Var.a();
        while (true) {
            if (n0Var.c() == ',') {
                n0Var.a();
                this.a.add(null);
            } else {
                n0Var.a();
                this.a.add(n0Var.d());
            }
            c2 = n0Var.c();
            if (c2 == ')') {
                break;
            } else if (c2 == ',' || c2 == ';') {
                if (n0Var.c() == ']') {
                    return;
                }
                n0Var.a();
            } else if (c2 != ']') {
                throw n0Var.a("Expected a ',' or ']'");
            }
        }
        if (c != c2) {
            throw n0Var.a(a.a("Expected a '").append(new Character(c)).append("'").toString());
        }
    }

    public k0(Collection collection) {
        this.a = collection == null ? new ArrayList() : new ArrayList(collection);
    }
}