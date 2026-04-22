package facadeverify;

import host.R;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class m0 {
    public static final Object b = new b(null);
    public Map a;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class b {
        public /* synthetic */ b(a aVar) {
        }

        public final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public String toString() {
            return "null";
        }
    }

    public m0() {
        this.a = new HashMap();
    }

    public static String b(String str) {
        String sb;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        int i2 = 0;
        char c = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                case '\\':
                    stringBuffer.append('\\');
                    stringBuffer.append(charAt);
                    break;
                case R.styleable.CameraView_cameraVideoSizeAspectRatio /* 47 */:
                    if (c == '<') {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt);
                    break;
                default:
                    if (charAt >= ' ' && ((charAt < 128 || charAt >= 160) && (charAt < 8192 || charAt >= 8448))) {
                        stringBuffer.append(charAt);
                        break;
                    } else {
                        stringBuffer.append(facadeverify.a.a("\\u").append(facadeverify.a.a("000").append(Integer.toHexString(charAt)).toString().substring(sb.length() - 4)).toString());
                        break;
                    }
            }
            i2++;
            c = charAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    public Object a(String str) {
        Object obj = str == null ? null : this.a.get(str);
        if (obj != null) {
            return obj;
        }
        throw new l0(facadeverify.a.a("JSONObject[").append(b(str)).append("] not found.").toString());
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{");
            for (Object obj : this.a.keySet()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(b(obj.toString()));
                stringBuffer.append(':');
                stringBuffer.append(b(this.a.get(obj)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception e2) {
            return null;
        }
    }

    public m0(n0 n0Var) {
        this.a = new HashMap();
        if (n0Var.c() != '{') {
            throw n0Var.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c = n0Var.c();
            if (c == 0) {
                throw n0Var.a("A JSONObject text must end with '}'");
            }
            if (c == '}') {
                return;
            }
            n0Var.a();
            String obj = n0Var.d().toString();
            char c2 = n0Var.c();
            if (c2 == '=') {
                if (n0Var.b() != '>') {
                    n0Var.a();
                }
            } else if (c2 != ':') {
                throw n0Var.a("Expected a ':' after a key");
            }
            Object d2 = n0Var.d();
            if (obj != null) {
                if (d2 != null) {
                    a(d2);
                    this.a.put(obj, d2);
                } else {
                    this.a.remove(obj);
                }
                char c3 = n0Var.c();
                if (c3 != ',' && c3 != ';') {
                    if (c3 != '}') {
                        throw n0Var.a("Expected a ',' or '}'");
                    }
                    return;
                } else if (n0Var.c() == '}') {
                    return;
                } else {
                    n0Var.a();
                }
            } else {
                throw new l0("Null key.");
            }
        }
    }

    public static void a(Object obj) {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d2 = (Double) obj;
                if (d2.isInfinite() || d2.isNaN()) {
                    throw new l0("JSON does not allow non-finite numbers.");
                }
            } else if (obj instanceof Float) {
                Float f2 = (Float) obj;
                if (f2.isInfinite() || f2.isNaN()) {
                    throw new l0("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    public m0(Map map) {
        this.a = map == null ? new HashMap() : map;
    }

    public static String b(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            a(number);
            String obj2 = number.toString();
            if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
                return obj2;
            }
            while (obj2.endsWith("0")) {
                obj2 = obj2.substring(0, obj2.length() - 1);
            }
            return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
        } else if (!(obj instanceof Boolean) && !(obj instanceof m0) && !(obj instanceof k0)) {
            if (obj instanceof Map) {
                return new m0((Map) obj).toString();
            }
            if (obj instanceof Collection) {
                return new k0((Collection) obj).toString();
            }
            if (obj.getClass().isArray()) {
                k0 k0Var = new k0();
                if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    for (int i2 = 0; i2 < length; i2++) {
                        k0Var.a.add(Array.get(obj, i2));
                    }
                    return k0Var.toString();
                }
                throw new l0("JSONArray initial value should be a string or collection or array.");
            }
            return b(obj.toString());
        } else {
            return obj.toString();
        }
    }
}