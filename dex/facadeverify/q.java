package facadeverify;

public class q extends Exception {
    public int a;
    public String b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public q(Integer num, String str) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("Http Transport error");
        if (num != null) {
            sb.append("[").append(num).append("]");
        }
        sb.append(" : ");
        if (str != null) {
            sb.append(str);
        }
        this.a = num.intValue();
        this.b = str;
    }
}