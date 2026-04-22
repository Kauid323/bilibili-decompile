package faceverify;

/* compiled from: outline */
public class a {
    public static int a(String str, Object[] objArr, StringBuilder sb, int i2, int i3) {
        sb.append(String.format(str, objArr));
        return i2 + i3;
    }

    public static StringBuilder a(String str) {
        return new StringBuilder().append(str);
    }
}