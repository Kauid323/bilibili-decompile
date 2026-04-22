package facadeverify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public class u {
    public String b;
    public byte[] c;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1927g;
    public boolean a = false;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Header> f1925e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f1926f = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f1924d = "application/x-www-form-urlencoded";

    public u(String str) {
        this.b = str;
    }

    public void a() {
    }

    public void a(Header header) {
        this.f1925e.add(header);
    }

    public ArrayList<Header> b() {
        return this.f1925e;
    }

    public String c() {
        return this.b;
    }

    public boolean d() {
        return this.f1927g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && u.class == obj.getClass()) {
            u uVar = (u) obj;
            byte[] bArr = this.c;
            if (bArr == null) {
                if (uVar.c != null) {
                    return false;
                }
            } else if (!bArr.equals(uVar.c)) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (uVar.b != null) {
                    return false;
                }
            } else if (!str.equals(uVar.b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Map<String, String> map = this.f1926f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f1926f.get("id").hashCode() + 31) * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.b, this.f1925e);
    }

    public void a(String str, String str2) {
        if (this.f1926f == null) {
            this.f1926f = new HashMap();
        }
        this.f1926f.put(str, str2);
    }

    public String a(String str) {
        Map<String, String> map = this.f1926f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }
}